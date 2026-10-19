# JuiceSSH Plugin SDK Contract Analysis

Date: 2026-10-18
Source: https://github.com/Sonelli/juicessh-pluginlibrary (commit HEAD, version 1.0.13)
License: Apache-2.0

## SDK Structure

The plugin library exposes three AIDL service interfaces, a content-provider contract, and client wrappers:

### AIDL Services

1. **IConnectionPluginService** – basic session lifecycle
   - `ping(IPingListener)` / `connect(String id)` / `disconnect(sessionId, sessionKey)`
   - `addSessionFinishedListener(sessionId, sessionKey, ISessionFinishedListener)`

2. **IPluginService** – extends connection service with exec/write/attach
   - All of IConnectionPluginService methods (legacy)
   - `attach(sessionId, sessionKey)` – bring session to foreground
   - `executeCommandOnSession(sessionId, sessionKey, command, ISessionExecuteListener)` – exec channel
   - `writeToSession(sessionId, sessionKey, command)` – write to PTY

3. **ISftpPluginService** – SFTP operations (signature-level permission required)
   - `cd`, `chgrp`, `chmod`, `chown`, `get`, `lcd`, `lpwd`, `ls`, `lstat`, `pwd`
   - `readlink`, `realpath`, `rename`, `rm`, `rmdir`, `stat`
   - Note: `put()` is commented out in source

### Hardcoded Bindings (Compatibility Barriers)

| Binding | Value | Impact on renamed successor |
|---------|-------|-----------------------------|
| Content authority | `com.sonelli.juicessh.api.v1` | Plugins query this exact authority |
| Plugin service intent | `com.sonelli.juicessh.pluginservice` | Resolved by PackageManager |
| Connection service intent | `com.sonelli.juicessh.connectionpluginservice` | Same resolution |
| Package check | `com.sonelli.juicessh` (version >= 89) | Hard version gate in `checkVersion()` |
| Permissions | `com.sonelli.juicessh.api.v1.permission.*` (7 permissions) | Declared by host, used by plugins |
| SFTP permission | Signature-level | Only matching signing certificate |

### Content Provider Contract (PluginContract.java)

Exposes read/write access to:
- **Connections** – id, modified, name, address, port, nickname, type (SSH=0, Mosh=1, Local=2, Telnet=3)
- **Snippets** – id, modified, name, content
- **PortForwards** – id, modified, name, mode (Local=0, Remote=1, SOCKS=2), connectionId, host, localPort, remotePort, openInBrowser
- **ConnectionGroups** – id, modified, name
- **ConnectionGroupMemberships** – id, modified, groupId, connectionId
- **PluginLog** – id, modified, packageName, message (read-only)

**NOT exposed**: Identities, private keys, known hosts, EC2 data, team data, encrypted backups.

### Client Wrapper Flow (PluginClient / ConnectionPluginClient)

1. Plugin calls `client.start(context, listener)` → binds two services
2. Plugin calls `client.connect(activity, connectionUUID, listener, requestCode)` → starts background session via Intent with `ssh://UUID`
3. `onActivityResult` returns `session_id` (int) and `session_key` (String) for authentication
4. Plugin uses `writeToSession()`, `executeCommandOnSession()`, `attach()` for interaction
5. `addSessionFinishedListener()` for disconnect notification

### Performance Monitor Plugin Pattern

The monitor (Apache-2.0) demonstrates:
- CursorLoader for reading connections via content provider
- Runtime permission requests for READ_CONNECTIONS and OPEN_SESSIONS
- Controller pattern: each metric runs `executeCommandOnSession()` with Linux commands
- Controllers: CPU, RAM, Load, Disk, Network, Temperature – each parsing command output
- Session lifecycle tied to Activity lifecycle

### Successor Plugin SDK Design Implications

1. **New authority namespace required** – e.g., `dev.successor.ssh.api.v2`
2. **New permission namespace** – e.g., `dev.successor.ssh.permission.*`
3. **Service discovery** – new intent actions, no `com.sonelli` references
4. **Legacy adapter optional** – could register as secondary authority but signing prevents it
5. **Port the Apache-2.0 plugins directly** – PerformanceMonitor, PortKnocker, AuditLog
6. **SFTP put() was incomplete** – new SDK should implement full SFTP from the start
7. **Identity access absent** – design explicit scoped identity exposure with consent

### Verification Checklist

- [x] SDK version confirmed 1.0.13 in build.gradle
- [x] License Apache-2.0 confirmed in LICENSE file
- [x] All AIDL interfaces read and documented
- [x] Hardcoded package/authority references cataloged
- [x] Performance Monitor pattern analyzed as port reference
- [ ] Runtime compatibility with renamed host NOT tested (requires device)
- [ ] SFTP signature permission NOT testable without matching signing key
- [ ] Exact parcel field ordering for IPC NOT verified against running APK
