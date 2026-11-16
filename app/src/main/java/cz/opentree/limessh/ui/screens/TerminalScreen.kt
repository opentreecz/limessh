package cz.opentree.limessh.ui.screens

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.focusable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.input.key.*
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.input.ImeAction
import cz.opentree.limessh.LimeApp
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.first
import cz.opentree.limessh.ssh.*
import cz.opentree.limessh.ui.theme.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.resumeWithException

/** Host-key prompt state passed up to the composable for UI rendering. */
private sealed class HostKeyPromptState {
    data class Unknown(val host: String, val fingerprint: String) : HostKeyPromptState()
    data class Changed(val host: String, val fingerprint: String) : HostKeyPromptState()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TerminalScreen(
    connectionId: String,
    onBack: () -> Unit,
    onOpenSftp: ((String) -> Unit)? = null,
    onOpenExtensions: ((String) -> Unit)? = null,
    onEditConnection: (() -> Unit)? = null,
) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val focusRequester = remember { FocusRequester() }
    val textMeasurer = rememberTextMeasurer()
    val density = LocalDensity.current
    val preferences by (context.applicationContext as LimeApp).settings.preferences.collectAsState()
    val theme = remember(preferences.terminalThemeId) { TerminalThemes.byId(preferences.terminalThemeId) }

    // Terminal state
    var session by remember { mutableStateOf<SshSession?>(null) }
    var emulator by remember { mutableStateOf<TerminalEmulator?>(null) }
    var snapshot by remember { mutableStateOf<ScreenSnapshot?>(null) }
    var connectionError by remember { mutableStateOf<String?>(null) }
    var isConnecting by remember { mutableStateOf(true) }
    var connectionTitle by remember { mutableStateOf("Connecting...") }
    var loginSummary by remember { mutableStateOf("") }
    var attempt by remember { mutableIntStateOf(0) }

    // Host-key prompt state
    var hostKeyPrompt by remember { mutableStateOf<HostKeyPromptState?>(null) }
    var hostKeyCallback by remember { mutableStateOf<((Boolean) -> Unit)?>(null) }
    var challenge by remember { mutableStateOf<String?>(null) }
    var challengeEcho by remember { mutableStateOf(false) }
    var challengeCallback by remember { mutableStateOf<((String?) -> Unit)?>(null) }
    var input by remember { mutableStateOf("") }

    // Scrollback viewport offset: 0 = live (bottom), negative = scrolled into history.
    var scrollOffset by remember { mutableIntStateOf(0) }
    // Extra-key modifier toggles: arms for the next soft-key button press.
    var ctrlArmed by remember { mutableStateOf(false) }
    var altArmed by remember { mutableStateOf(false) }
    // Transcript / copy-paste state.
    var showTranscriptDialog by remember { mutableStateOf(false) }
    val clipboardManager = LocalClipboardManager.current

    // Terminal dimensions (computed from canvas size)
    var canvasWidthPx by remember { mutableStateOf(0) }
    var canvasHeightPx by remember { mutableStateOf(0) }

    val cellSize = remember(textMeasurer, preferences.fontSize) {
        val result = textMeasurer.measure(
            text = AnnotatedString("M"),
            style = TextStyle(fontFamily = FontFamily.Monospace, fontSize = preferences.fontSize.sp),
        )
        Size(result.size.width.toFloat(), result.size.height.toFloat())
    }

    val termCols = remember(canvasWidthPx, cellSize) {
        if (cellSize.width > 0 && canvasWidthPx > 0)
            (canvasWidthPx / cellSize.width).toInt().coerceAtLeast(20)
        else 80
    }
    val termRows = remember(canvasHeightPx, cellSize) {
        if (cellSize.height > 0 && canvasHeightPx > 0)
            (canvasHeightPx / cellSize.height).toInt().coerceAtLeast(5)
        else 24
    }

    val sessionManager = remember { (context.applicationContext as LimeApp).sessionManager }

    // Scrollable state for vertical drag gesture (scrollback navigation).
    val scrollableState = rememberScrollableState { delta ->
        val ch = cellSize.height
        val sbSize = snapshot?.scrollbackSize ?: 0
        if (ch > 0 && sbSize > 0) {
            val rowDelta = (delta / ch).toInt()
            val newOffset = (scrollOffset + rowDelta).coerceIn(-sbSize, 0)
            if (newOffset != scrollOffset) scrollOffset = newOffset
        }
        delta
    }

    // Return to live view whenever the emulator emits a new snapshot and we are at live.
    // (Intentionally does NOT auto-scroll back: user must drag down or tap to return.)

    // Observe session disconnection: when the SSH channel drops, show "Connection lost" so the
    // user can tap Retry without having to navigate back and re-open the connection.
    val currentSession = session
    LaunchedEffect(currentSession) {
        currentSession?.disconnected?.collect { dropped ->
            if (dropped && connectionError == null && !isConnecting) {
                connectionError = "Connection lost (server closed or keepalive timeout)."
                isConnecting = false
            }
        }
    }

    // Connect on first composition
    LaunchedEffect(connectionId, attempt) {
        isConnecting = true
        connectionError = null
        val db = cz.opentree.limessh.data.local.AppDatabase.getInstance(context)
        val repo = cz.opentree.limessh.data.repository.ConnectionRepository(db)
        val credStore = cz.opentree.limessh.data.local.crypto.CredentialStore(context)

        val connection = repo.getConnection(connectionId)
        if (connection == null) {
            connectionError = "Connection not found"
            isConnecting = false
            return@LaunchedEffect
        }

        connectionTitle = connection.nickname.ifBlank { connection.address }
        val identity = connection.identityId?.let { repo.getIdentity(it) }
        loginSummary = if (identity != null) "${identity.username}@${connection.address}:${connection.port}\nIdentity: ${identity.nickname} · ${identity.authMethod.name}"
            else "${connection.address}:${connection.port}\nNo login identity assigned"
        val password = identity?.let { credStore.getPassword(it.id.toString()) }

        runCatching {
            val sshSession = sessionManager.findSession(connectionId) ?: sessionManager.connect(
                connection = connection,
                identity = identity,
                password = password,
                portForwards = repo.observePortForwardsForConnection(connection.id).first(),
                snippets = repo.observeSnippets().first().filter { it.connectionId == connection.id && it.runOnConnect },
                challengePrompt = { prompt, echo ->
                    withContext(Dispatchers.Main) {
                        kotlinx.coroutines.suspendCancellableCoroutine { cont ->
                            challenge = prompt
                            challengeEcho = echo
                            challengeCallback = { answer ->
                                challenge = null
                                challengeCallback = null
                                if (cont.isActive) {
                                    if (answer != null) cont.resume(answer) {}
                                    else cont.resumeWithException(IllegalStateException("Authentication cancelled"))
                                }
                            }
                        }
                    }
                },
                hostKeyPrompt = { event ->
                    // Bridge to Compose UI via callback
                    withContext(Dispatchers.Main) {
                        kotlinx.coroutines.suspendCancellableCoroutine<Boolean> { cont ->
                            hostKeyCallback = { accepted ->
                                hostKeyCallback = null
                                hostKeyPrompt = null
                                if (cont.isActive) cont.resume(accepted) {}
                            }
                            hostKeyPrompt = when (event) {
                                is HostKeyEvent.Unknown ->
                                    HostKeyPromptState.Unknown(event.hostname, event.keyFingerprint)
                                is HostKeyEvent.Changed ->
                                    HostKeyPromptState.Changed(event.hostname, event.keyFingerprint)
                            }
                        }
                    }
                },
            )
            session = sshSession

            val em = sshSession.emulator
            emulator = em
            snapshot = em.screenState.value
            em.resize(termCols, termRows)
            sessionManager.resizeSession(sshSession.id, termCols, termRows)

            coroutineScope.launch {
                em.screenState.collect { snap ->
                    snapshot = snap
                }
            }
        }.onFailure { e ->
            if (e is CancellationException) throw e
            connectionError = e.message ?: "Connection failed"
        }
        challenge = null
        challengeCallback = null
        hostKeyPrompt = null
        hostKeyCallback = null
        isConnecting = false
    }

    // Resize terminal when dimensions change
    LaunchedEffect(termCols, termRows) {
        val em = emulator ?: return@LaunchedEffect
        val s = session ?: return@LaunchedEffect
        em.resize(termCols, termRows)
        sessionManager.resizeSession(s.id, termCols, termRows)
    }
    LaunchedEffect(emulator, preferences.scrollback) { emulator?.maxScrollback = preferences.scrollback }

    Scaffold(
        bottomBar = {
            if (session != null) Column(Modifier.imePadding()) {
                // Helper: apply Ctrl modifier and send bytes to the session.
                fun sendKey(bytes: ByteArray) {
                    val toSend = if (ctrlArmed && bytes.size == 1) {
                        byteArrayOf((bytes[0].toInt() and 0x1F).toByte())
                    } else bytes
                    ctrlArmed = false
                    altArmed = false
                    coroutineScope.launch {
                        runCatching { sessionManager.writeToSession(session!!.id, toSend) }
                            .onFailure { connectionError = it.message }
                    }
                }
                // Extra-key row: Ctrl and Alt are one-shot toggle modifiers.
                Row(Modifier.horizontalScroll(rememberScrollState())) {
                    // Ctrl toggle
                    TextButton(
                        onClick = { ctrlArmed = !ctrlArmed; altArmed = false },
                        colors = ButtonDefaults.textButtonColors(
                            contentColor = if (ctrlArmed) MaterialTheme.colorScheme.primary
                            else MaterialTheme.colorScheme.onSurface,
                        ),
                    ) { Text("Ctrl") }
                    // Alt/Esc toggle (sends ESC prefix immediately)
                    TextButton(
                        onClick = {
                            altArmed = !altArmed
                            ctrlArmed = false
                            if (altArmed) {
                                coroutineScope.launch {
                                    runCatching { sessionManager.writeToSession(session!!.id, byteArrayOf(0x1B)) }
                                        .onFailure { connectionError = it.message }
                                }
                            }
                        },
                        colors = ButtonDefaults.textButtonColors(
                            contentColor = if (altArmed) MaterialTheme.colorScheme.primary
                            else MaterialTheme.colorScheme.onSurface,
                        ),
                    ) { Text("Alt") }
                    // Static special keys
                    listOf(
                        "Esc"   to byteArrayOf(0x1B),
                        "Tab"   to byteArrayOf(0x09),
                        "Ctrl-C" to byteArrayOf(0x03),
                        "Ctrl-Z" to byteArrayOf(0x1A),
                        "Ctrl-D" to byteArrayOf(0x04),
                        "Ctrl-A" to byteArrayOf(0x01),
                        "Ctrl-E" to byteArrayOf(0x05),
                        "Ctrl-W" to byteArrayOf(0x17),
                        "Ctrl-L" to byteArrayOf(0x0C),
                        "|"     to byteArrayOf(0x7C),
                        "~"     to byteArrayOf(0x7E),
                        "↑"     to byteArrayOf(0x1B, 0x5B, 0x41),
                        "↓"     to byteArrayOf(0x1B, 0x5B, 0x42),
                        "←"     to byteArrayOf(0x1B, 0x5B, 0x44),
                        "→"     to byteArrayOf(0x1B, 0x5B, 0x43),
                        "PgUp"  to byteArrayOf(0x1B, 0x5B, 0x35, 0x7E),
                        "PgDn"  to byteArrayOf(0x1B, 0x5B, 0x36, 0x7E),
                        "Home"  to byteArrayOf(0x1B, 0x5B, 0x48),
                        "End"   to byteArrayOf(0x1B, 0x5B, 0x46),
                        "F1"    to byteArrayOf(0x1B, 0x4F, 0x50),
                        "F2"    to byteArrayOf(0x1B, 0x4F, 0x51),
                        "F3"    to byteArrayOf(0x1B, 0x4F, 0x52),
                        "F4"    to byteArrayOf(0x1B, 0x4F, 0x53),
                        "Enter" to byteArrayOf(0x0D),
                    ).forEach { (label, sequence) ->
                        TextButton(onClick = { sendKey(sequence) }) { Text(label) }
                    }
                }
                Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    fun send() {
                        val text = input
                        input = ""
                        coroutineScope.launch {
                            runCatching { sessionManager.writeToSession(session!!.id, (text + "\r").toByteArray()) }
                                .onFailure { connectionError = it.message }
                        }
                    }
                    OutlinedTextField(value = input, onValueChange = { input = it },
                        modifier = Modifier.weight(1f), singleLine = true, label = { Text("Terminal input") },
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Send),
                        keyboardActions = KeyboardActions(onSend = { send() }))
                    TextButton(onClick = { send() }) { Text("Send") }
                    // Paste from clipboard
                    TextButton(onClick = {
                        val text = clipboardManager.getText()?.text
                        if (!text.isNullOrEmpty()) {
                            coroutineScope.launch {
                                runCatching { sessionManager.writeToSession(session!!.id, text.toByteArray(Charsets.UTF_8)) }
                                    .onFailure { connectionError = it.message }
                            }
                        }
                    }) { Text("Paste") }
                    // Show transcript dialog
                    TextButton(onClick = { showTranscriptDialog = true }) { Text("…") }
                }
            }
        },
        topBar = {
            TopAppBar(
                title = { Text(connectionTitle, maxLines = 1) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    if (session != null && onOpenExtensions != null) {
                        IconButton(onClick = { onOpenExtensions(session!!.id.toString()) }) {
                            Icon(Icons.Default.Extension, contentDescription = "Extensions")
                        }
                    }
                    if (session != null && onOpenSftp != null) {
                        IconButton(onClick = { onOpenSftp(session!!.id.toString()) }) {
                            Icon(Icons.Default.Folder, contentDescription = "SFTP browser")
                        }
                    }
                    if (session != null) {
                        IconButton(onClick = {
                            session?.let { sessionManager.requestDisconnect(it.id) }
                            onBack()
                        }) {
                            Icon(Icons.Default.Close, contentDescription = "Disconnect")
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = theme.background,
                    titleContentColor = theme.foreground,
                    navigationIconContentColor = theme.foreground,
                    actionIconContentColor = theme.foreground,
                ),
            )
        },
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(theme.background),
        ) {
            when {
                isConnecting -> {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center),
                        color = theme.foreground,
                    )
                }
                connectionError != null -> {
                    Column(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Icon(
                            Icons.Default.Warning,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.error,
                            modifier = Modifier.size(48.dp),
                        )
                        Spacer(Modifier.height(16.dp))
                        Text(
                            text = "Connection failed",
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.error,
                        )
                        Spacer(Modifier.height(8.dp))
                        Text(
                            text = connectionError!!,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onBackground,
                        )
                        Text(loginSummary, modifier = Modifier.padding(top = 12.dp))
                        Spacer(Modifier.height(24.dp))
                        Button(onClick = onBack) { Text("Back") }
                        TextButton(onClick = { attempt++ }) { Text("Retry") }
                        if (onEditConnection != null) TextButton(onClick = onEditConnection) { Text("Edit connection / login identity") }
                    }
                }
                else -> {
                    Canvas(
                        modifier = Modifier
                            .fillMaxSize()
                            .focusRequester(focusRequester)
                            .focusable()
                            .onSizeChanged { size ->
                                canvasWidthPx = size.width
                                canvasHeightPx = size.height
                            }
                            .scrollable(scrollableState, Orientation.Vertical)
                            .onKeyEvent { event ->
                                if (event.type == KeyEventType.KeyDown) {
                                    val bytes = keyEventToBytes(event)
                                    if (bytes != null) {
                                        session?.let { s ->
                                            coroutineScope.launch(Dispatchers.IO) {
                                                sessionManager.writeToSession(s.id, bytes)
                                            }
                                        }
                                        true
                                    } else false
                                } else false
                            }
                            .pointerInput(Unit) {
                                detectTapGestures(
                                    onTap = {
                                        focusRequester.requestFocus()
                                        // Tap returns to live view when scrolled into history.
                                        if (scrollOffset != 0) scrollOffset = 0
                                    },
                                    onLongPress = {
                                        // Long-press opens the transcript copy/share dialog.
                                        showTranscriptDialog = true
                                    },
                                )
                            },
                    ) {
                        val snap = snapshot ?: return@Canvas
                        val cw = cellSize.width
                        val ch = cellSize.height
                        val em = emulator

                        // Helper: resolve the cells for a display row.
                        // When scrollOffset == 0, renders live screen rows as before.
                        // When scrollOffset < 0, blends scrollback rows at the top.
                        fun rowCells(displayRow: Int): Array<TermCell>? {
                            val relRow = scrollOffset + displayRow
                            return when {
                                relRow < 0  -> em?.getRow(relRow)  // scrollback
                                else        -> snap.screen.getOrNull(relRow)
                            }
                        }

                        val numRows = snap.screen.size

                        // Pass 1: backgrounds and cursor block.
                        for (row in 0 until numRows) {
                            val cells = rowCells(row) ?: continue
                            for (col in cells.indices) {
                                val cell = cells[col]
                                val x = col * cw
                                val y = row * ch

                                val effectiveBg = if (cell.attr.inverse)
                                    resolveTerminalColor(theme, cell.attr.fg, cell.attr.bold, isBackground = false)
                                else
                                    resolveTerminalColor(theme, cell.attr.bg, cell.attr.bold, isBackground = true)

                                if (effectiveBg != theme.background) {
                                    drawRect(effectiveBg, Offset(x, y), Size(cw, ch))
                                }

                                // Only draw cursor when at live view.
                                if (scrollOffset == 0 &&
                                    row == snap.cursorRow && col == snap.cursorCol && snap.cursorVisible) {
                                    drawRect(theme.cursor.copy(alpha = 0.7f), Offset(x, y), Size(cw, ch))
                                }
                            }
                        }

                        // Pass 2: text.
                        for (row in 0 until numRows) {
                            val cells = rowCells(row) ?: continue
                            val isLiveCursorRow = scrollOffset == 0 && row == snap.cursorRow && snap.cursorVisible
                            val line = buildAnnotatedString {
                                for (col in cells.indices) {
                                    val cell = cells[col]
                                    val isCursor = isLiveCursorRow && col == snap.cursorCol
                                    val fgColor = if (isCursor) theme.background
                                    else if (cell.attr.hidden) theme.background
                                    else {
                                        val fg = if (cell.attr.inverse)
                                            resolveTerminalColor(theme, cell.attr.bg, cell.attr.bold, isBackground = true)
                                        else
                                            resolveTerminalColor(theme, cell.attr.fg, cell.attr.bold, isBackground = false)
                                        if (cell.attr.dim) fg.copy(alpha = 0.5f) else fg
                                    }
                                    withStyle(SpanStyle(
                                        color = fgColor,
                                        fontFamily = FontFamily.Monospace,
                                        fontSize = preferences.fontSize.sp,
                                        fontWeight = if (cell.attr.bold)
                                            androidx.compose.ui.text.font.FontWeight.Bold else null,
                                        fontStyle = if (cell.attr.italic)
                                            androidx.compose.ui.text.font.FontStyle.Italic else null,
                                        textDecoration = buildTextDecoration(cell.attr),
                                    )) { append(cell.char) }
                                }
                            }
                            drawText(textMeasurer = textMeasurer, text = line, topLeft = Offset(0f, row * ch))
                        }

                        // Scrollback position indicator.
                        if (scrollOffset < 0 && snap.scrollbackSize > 0) {
                            val indicatorText = "▲ ${-scrollOffset} / ${snap.scrollbackSize}  (tap to return)"
                            val style = TextStyle(
                                fontFamily = FontFamily.Monospace,
                                fontSize = (preferences.fontSize * 0.8f).sp,
                                color = theme.foreground.copy(alpha = 0.75f),
                                background = theme.background.copy(alpha = 0.6f),
                            )
                            val measured = textMeasurer.measure(indicatorText, style)
                            val ix = size.width - measured.size.width - cw
                            drawText(textMeasurer = textMeasurer, text = indicatorText,
                                style = style, topLeft = Offset(ix.coerceAtLeast(0f), ch * 0.2f))
                        }
                    }
                }
            }
        }

        LaunchedEffect(isConnecting, connectionError) {
            if (!isConnecting && connectionError == null) focusRequester.requestFocus()
        }
    }

    // Host-key dialog
    hostKeyPrompt?.let { prompt ->
        val (title, message) = when (prompt) {
            is HostKeyPromptState.Unknown -> Pair(
                "Unknown host",
                "Host: ${prompt.host}\nFingerprint: ${prompt.fingerprint}\n\nTrust this host?",
            )
            is HostKeyPromptState.Changed -> Pair(
                "Host key changed!",
                "WARNING: The host key for ${prompt.host} has changed.\nNew fingerprint: ${prompt.fingerprint}\n\nThis may indicate an attack. Continue?",
            )
        }
        AlertDialog(
            onDismissRequest = { hostKeyCallback?.invoke(false) },
            title = {
                Text(
                    title,
                    color = if (prompt is HostKeyPromptState.Changed)
                        MaterialTheme.colorScheme.error
                    else
                        MaterialTheme.colorScheme.onSurface,
                )
            },
            text = { Text(message) },
            confirmButton = {
                TextButton(onClick = { hostKeyCallback?.invoke(true) }) {
                    Text(if (prompt is HostKeyPromptState.Changed) "Accept anyway" else "Trust")
                }
            },
            dismissButton = {
                TextButton(onClick = { hostKeyCallback?.invoke(false) }) {
                    Text("Reject")
                }
            },
        )
    }
    challenge?.let { prompt ->
        var answer by remember(prompt) { mutableStateOf("") }
        AlertDialog(onDismissRequest = { challengeCallback?.invoke(null) },
            title = { Text("SSH authentication") },
            text = { OutlinedTextField(answer, { answer = it }, label = { Text(prompt) },
                visualTransformation = if (challengeEcho) androidx.compose.ui.text.input.VisualTransformation.None
                else androidx.compose.ui.text.input.PasswordVisualTransformation()) },
            confirmButton = { TextButton(onClick = { challengeCallback?.invoke(answer) }) { Text("Continue") } },
            dismissButton = { TextButton(onClick = { challengeCallback?.invoke(null) }) { Text("Cancel") } })
    }

    // Transcript dialog (long-press or "…" button): copy all / copy selection / share.
    if (showTranscriptDialog) {
        val transcript = remember(showTranscriptDialog) { emulator?.getTranscriptText() ?: "" }
        AlertDialog(
            onDismissRequest = { showTranscriptDialog = false },
            title = { Text("Session transcript") },
            text = {
                androidx.compose.foundation.text.selection.SelectionContainer {
                    Text(
                        text = transcript,
                        fontFamily = FontFamily.Monospace,
                        fontSize = 12.sp,
                        modifier = Modifier
                            .heightIn(max = 320.dp)
                            .verticalScroll(rememberScrollState()),
                    )
                }
            },
            confirmButton = {
                TextButton(onClick = {
                    clipboardManager.setText(AnnotatedString(transcript))
                    showTranscriptDialog = false
                }) { Text("Copy all") }
            },
            dismissButton = {
                Row {
                    TextButton(onClick = {
                        context.startActivity(Intent.createChooser(
                            Intent(Intent.ACTION_SEND).apply {
                                type = "text/plain"
                                putExtra(Intent.EXTRA_TEXT, transcript)
                            }, null
                        ))
                        showTranscriptDialog = false
                    }) { Text("Share") }
                    TextButton(onClick = { showTranscriptDialog = false }) { Text("Close") }
                }
            },
        )
    }
}

private fun buildTextDecoration(attr: CellAttr): androidx.compose.ui.text.style.TextDecoration? {
    val decorations = mutableListOf<androidx.compose.ui.text.style.TextDecoration>()
    if (attr.underline) decorations.add(androidx.compose.ui.text.style.TextDecoration.Underline)
    if (attr.strikethrough) decorations.add(androidx.compose.ui.text.style.TextDecoration.LineThrough)
    return if (decorations.isEmpty()) null
    else decorations.fold(
        androidx.compose.ui.text.style.TextDecoration.None,
    ) { acc, td -> androidx.compose.ui.text.style.TextDecoration.combine(listOf(acc, td)) }
}

private fun keyEventToBytes(event: KeyEvent): ByteArray? {
    return when {
        event.key == Key.Enter -> byteArrayOf(0x0D)
        event.key == Key.Tab -> byteArrayOf(0x09)
        event.key == Key.Backspace -> byteArrayOf(0x7F)
        event.key == Key.Escape -> byteArrayOf(0x1B)
        event.key == Key.DirectionUp -> byteArrayOf(0x1B, 0x5B, 0x41)
        event.key == Key.DirectionDown -> byteArrayOf(0x1B, 0x5B, 0x42)
        event.key == Key.DirectionRight -> byteArrayOf(0x1B, 0x5B, 0x43)
        event.key == Key.DirectionLeft -> byteArrayOf(0x1B, 0x5B, 0x44)
        event.key == Key.Home -> byteArrayOf(0x1B, 0x5B, 0x48)
        event.key == Key.MoveEnd -> byteArrayOf(0x1B, 0x5B, 0x46)
        event.key == Key.PageUp -> byteArrayOf(0x1B, 0x5B, 0x35, 0x7E)
        event.key == Key.PageDown -> byteArrayOf(0x1B, 0x5B, 0x36, 0x7E)
        event.key == Key.Delete -> byteArrayOf(0x1B, 0x5B, 0x33, 0x7E)
        event.key == Key.Insert -> byteArrayOf(0x1B, 0x5B, 0x32, 0x7E)
        event.key == Key.F1 -> byteArrayOf(0x1B, 0x4F, 0x50)
        event.key == Key.F2 -> byteArrayOf(0x1B, 0x4F, 0x51)
        event.key == Key.F3 -> byteArrayOf(0x1B, 0x4F, 0x52)
        event.key == Key.F4 -> byteArrayOf(0x1B, 0x4F, 0x53)
        event.key == Key.F5 -> byteArrayOf(0x1B, 0x5B, 0x31, 0x35, 0x7E)
        event.key == Key.F6 -> byteArrayOf(0x1B, 0x5B, 0x31, 0x37, 0x7E)
        event.key == Key.F7 -> byteArrayOf(0x1B, 0x5B, 0x31, 0x38, 0x7E)
        event.key == Key.F8 -> byteArrayOf(0x1B, 0x5B, 0x31, 0x39, 0x7E)
        event.key == Key.F9 -> byteArrayOf(0x1B, 0x5B, 0x32, 0x30, 0x7E)
        event.key == Key.F10 -> byteArrayOf(0x1B, 0x5B, 0x32, 0x31, 0x7E)
        event.key == Key.F11 -> byteArrayOf(0x1B, 0x5B, 0x32, 0x33, 0x7E)
        event.key == Key.F12 -> byteArrayOf(0x1B, 0x5B, 0x32, 0x34, 0x7E)
        event.isCtrlPressed -> {
            val c = event.utf16CodePoint
            if (c in 0x40..0x5F || c in 0x61..0x7A) {
                val ctrl = (c and 0x1F)
                byteArrayOf(ctrl.toByte())
            } else null
        }
        event.utf16CodePoint > 0 -> {
            String(Character.toChars(event.utf16CodePoint)).toByteArray(Charsets.UTF_8)
        }
        else -> null
    }
}
