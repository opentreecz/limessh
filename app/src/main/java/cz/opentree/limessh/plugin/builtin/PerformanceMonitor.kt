package cz.opentree.limessh.plugin.builtin

import cz.opentree.limessh.ssh.SshEngine
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.regex.Pattern

/**
 * Built-in Performance Monitor — ported from the Apache-2.0 licensed
 * JuiceSSH Performance Monitor plugin (github.com/Sonelli/juicessh-performancemonitor).
 *
 * Monitors: CPU usage, free RAM, load average, disk usage, network I/O, temperature.
 * Uses SSH exec channels to run standard Linux commands and parse output.
 */
class PerformanceMonitor(
    private val engine: SshEngine,
    private val intervalMs: Long = 2000L,
) {
    private val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())

    private val _cpuUsage = MutableStateFlow("--")
    val cpuUsage: StateFlow<String> = _cpuUsage.asStateFlow()

    private val _freeRam = MutableStateFlow("--")
    val freeRam: StateFlow<String> = _freeRam.asStateFlow()

    private val _loadAverage = MutableStateFlow("--")
    val loadAverage: StateFlow<String> = _loadAverage.asStateFlow()

    private val _diskUsage = MutableStateFlow("--")
    val diskUsage: StateFlow<String> = _diskUsage.asStateFlow()

    private val _networkUsage = MutableStateFlow("--")
    val networkUsage: StateFlow<String> = _networkUsage.asStateFlow()

    private val _temperature = MutableStateFlow("--")
    val temperature: StateFlow<String> = _temperature.asStateFlow()

    // CPU delta tracking
    private var prevIdle = -1L
    private var prevTotal = -1L

    // Network delta tracking
    private var prevRxBytes = -1L
    private var prevTxBytes = -1L
    private var prevNetTime = -1L

    private val cpuPattern = Pattern.compile("^cpu\\s+(\\d+)\\s+(\\d+)\\s+(\\d+)\\s+(\\d+)\\s+(\\d+)\\s+(\\d+)\\s+(\\d+)\\s+(\\d+)")

    fun start() {
        // CPU usage from /proc/stat
        scope.launch {
            while (isActive) {
                try {
                    val result = engine.exec("cat /proc/stat")
                    parseCpuStat(result.stdout)
                } catch (_: Exception) { _cpuUsage.value = "err" }
                delay(intervalMs)
            }
        }

        // Free RAM from /proc/meminfo
        scope.launch {
            while (isActive) {
                try {
                    val result = engine.exec("cat /proc/meminfo")
                    parseMemInfo(result.stdout)
                } catch (_: Exception) { _freeRam.value = "err" }
                delay(intervalMs)
            }
        }

        // Load average from /proc/loadavg
        scope.launch {
            while (isActive) {
                try {
                    val result = engine.exec("cat /proc/loadavg")
                    val parts = result.stdout.trim().split("\\s+".toRegex())
                    if (parts.size >= 3) {
                        _loadAverage.value = "${parts[0]} ${parts[1]} ${parts[2]}"
                    }
                } catch (_: Exception) { _loadAverage.value = "err" }
                delay(intervalMs)
            }
        }

        // Disk usage from df
        scope.launch {
            while (isActive) {
                try {
                    val result = engine.exec("df -h / | tail -1")
                    val parts = result.stdout.trim().split("\\s+".toRegex())
                    if (parts.size >= 5) {
                        _diskUsage.value = "${parts[4]} (${parts[2]}/${parts[1]})"
                    }
                } catch (_: Exception) { _diskUsage.value = "err" }
                delay(intervalMs * 5) // Disk changes slowly
            }
        }

        // Network I/O from /proc/net/dev
        scope.launch {
            while (isActive) {
                try {
                    val result = engine.exec("cat /proc/net/dev")
                    parseNetDev(result.stdout)
                } catch (_: Exception) { _networkUsage.value = "err" }
                delay(intervalMs)
            }
        }

        // Temperature
        scope.launch {
            while (isActive) {
                try {
                    val result = engine.exec("cat /sys/class/thermal/thermal_zone0/temp 2>/dev/null || echo 0")
                    val milliC = result.stdout.trim().toLongOrNull() ?: 0
                    if (milliC > 0) {
                        val celsius = milliC / 1000.0
                        _temperature.value = String.format("%.1f°C", celsius)
                    }
                } catch (_: Exception) { _temperature.value = "--" }
                delay(intervalMs * 3)
            }
        }
    }

    fun stop() { scope.cancel() }

    private fun parseCpuStat(output: String) {
        for (line in output.lines()) {
            val matcher = cpuPattern.matcher(line)
            if (matcher.find()) {
                val user = matcher.group(1)!!.toLong()
                val nice = matcher.group(2)!!.toLong()
                val sys = matcher.group(3)!!.toLong()
                val idle = matcher.group(4)!!.toLong()
                val iowait = matcher.group(5)!!.toLong()
                val irq = matcher.group(6)!!.toLong()
                val softirq = matcher.group(7)!!.toLong()
                val steal = matcher.group(8)!!.toLong()
                val total = user + nice + sys + idle + iowait + irq + softirq + steal

                if (prevIdle >= 0 && prevTotal >= 0) {
                    val idleDelta = idle - prevIdle
                    val totalDelta = total - prevTotal
                    if (totalDelta > 0) {
                        val free = ((idleDelta * 100.0) / totalDelta + 0.5).toInt()
                        _cpuUsage.value = "${100 - free}%"
                    }
                }
                prevIdle = idle
                prevTotal = total
                return
            }
        }
    }

    private fun parseMemInfo(output: String) {
        var total = 0L; var available = 0L; var free = 0L
        for (line in output.lines()) {
            when {
                line.startsWith("MemTotal:") -> total = extractKb(line)
                line.startsWith("MemAvailable:") -> available = extractKb(line)
                line.startsWith("MemFree:") -> free = extractKb(line)
            }
        }
        val usable = if (available > 0) available else free
        if (total > 0) {
            _freeRam.value = "${formatBytes(usable * 1024)} / ${formatBytes(total * 1024)}"
        }
    }

    private fun parseNetDev(output: String) {
        var totalRx = 0L; var totalTx = 0L
        for (line in output.lines()) {
            if (!line.contains(":") || line.trimStart().startsWith("Inter") || line.trimStart().startsWith("face")) continue
            val parts = line.substringAfter(":").trim().split("\\s+".toRegex())
            if (parts.size >= 9) {
                val iface = line.substringBefore(":").trim()
                if (iface != "lo") { // Skip loopback
                    totalRx += parts[0].toLongOrNull() ?: 0
                    totalTx += parts[8].toLongOrNull() ?: 0
                }
            }
        }
        val now = System.currentTimeMillis()
        if (prevRxBytes >= 0 && prevNetTime > 0) {
            val dt = (now - prevNetTime) / 1000.0
            if (dt > 0) {
                val rxRate = ((totalRx - prevRxBytes) / dt).toLong()
                val txRate = ((totalTx - prevTxBytes) / dt).toLong()
                _networkUsage.value = "↓${formatBytes(rxRate)}/s ↑${formatBytes(txRate)}/s"
            }
        }
        prevRxBytes = totalRx; prevTxBytes = totalTx; prevNetTime = now
    }

    private fun extractKb(line: String): Long =
        line.replace(Regex("[^0-9]"), "").toLongOrNull() ?: 0

    private fun formatBytes(bytes: Long): String = when {
        bytes >= 1_073_741_824 -> String.format("%.1fG", bytes / 1_073_741_824.0)
        bytes >= 1_048_576 -> String.format("%.1fM", bytes / 1_048_576.0)
        bytes >= 1024 -> String.format("%.1fK", bytes / 1024.0)
        else -> "${bytes}B"
    }
}
