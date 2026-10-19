package cz.opentree.limessh.plugin

import android.net.Uri

/**
 * LimeSSH Plugin SDK v2 Contract.
 *
 * Replaces the original JuiceSSH `com.sonelli.juicessh.api.v1` with a new
 * namespace. Provides content provider URIs for connections, snippets,
 * port forwards, groups, group memberships, and plugin audit logs.
 *
 * Ported from the Apache-2.0 licensed JuiceSSH plugin library, adapted to
 * the LimeSSH namespace and extended with additional capabilities.
 */
object PluginContract {

    const val AUTHORITY = "cz.opentree.limessh.api.v2"

    // Permissions declared in AndroidManifest.xml
    const val PERMISSION_OPEN_SESSIONS = "cz.opentree.limessh.permission.OPEN_SESSIONS"
    const val PERMISSION_READ_CONNECTIONS = "cz.opentree.limessh.permission.READ_CONNECTIONS"
    const val PERMISSION_WRITE_CONNECTIONS = "cz.opentree.limessh.permission.WRITE_CONNECTIONS"
    const val PERMISSION_READ_SNIPPETS = "cz.opentree.limessh.permission.READ_SNIPPETS"
    const val PERMISSION_WRITE_SNIPPETS = "cz.opentree.limessh.permission.WRITE_SNIPPETS"
    const val PERMISSION_READ_PORT_FORWARDS = "cz.opentree.limessh.permission.READ_PORT_FORWARDS"
    const val PERMISSION_WRITE_PORT_FORWARDS = "cz.opentree.limessh.permission.WRITE_PORT_FORWARDS"
    const val PERMISSION_READ_GROUPS = "cz.opentree.limessh.permission.READ_GROUPS"
    const val PERMISSION_WRITE_GROUPS = "cz.opentree.limessh.permission.WRITE_GROUPS"
    const val PERMISSION_READ_PLUGIN_LOG = "cz.opentree.limessh.permission.READ_PLUGIN_LOG"

    object Connections {
        val CONTENT_URI: Uri = Uri.parse("content://$AUTHORITY/connections")
        const val TYPE_SSH = 0
        const val TYPE_MOSH = 1
        const val TYPE_LOCAL = 2
        const val TYPE_TELNET = 3
        const val COLUMN_ID = "id"
        const val COLUMN_MODIFIED = "modified"
        const val COLUMN_NAME = "name"
        const val COLUMN_ADDRESS = "address"
        const val COLUMN_PORT = "port"
        const val COLUMN_NICKNAME = "nickname"
        const val COLUMN_TYPE = "type"
        const val SORT_ORDER_DEFAULT = "nickname COLLATE NOCASE ASC"
    }

    object Snippets {
        val CONTENT_URI: Uri = Uri.parse("content://$AUTHORITY/snippets")
        const val COLUMN_ID = "id"
        const val COLUMN_MODIFIED = "modified"
        const val COLUMN_NAME = "name"
        const val COLUMN_CONTENT = "content"
        const val SORT_ORDER_DEFAULT = "name COLLATE NOCASE ASC"
    }

    object PortForwards {
        val CONTENT_URI: Uri = Uri.parse("content://$AUTHORITY/portforwards")
        const val MODE_LOCAL = 0
        const val MODE_REMOTE = 1
        const val MODE_SOCKS = 2
        const val COLUMN_ID = "id"
        const val COLUMN_MODIFIED = "modified"
        const val COLUMN_NAME = "name"
        const val COLUMN_MODE = "mode"
        const val COLUMN_CONNECTION_ID = "connection_id"
        const val COLUMN_HOST = "host"
        const val COLUMN_LOCAL_PORT = "localPort"
        const val COLUMN_REMOTE_PORT = "remotePort"
        const val COLUMN_OPEN_IN_BROWSER = "openInBrowser"
    }

    object ConnectionGroups {
        val CONTENT_URI: Uri = Uri.parse("content://$AUTHORITY/connectiongroups")
        const val COLUMN_ID = "id"
        const val COLUMN_MODIFIED = "modified"
        const val COLUMN_NAME = "name"
    }

    object GroupMemberships {
        val CONTENT_URI: Uri = Uri.parse("content://$AUTHORITY/connectiongroupmemberships")
        const val COLUMN_ID = "id"
        const val COLUMN_GROUP_ID = "group_id"
        const val COLUMN_CONNECTION_ID = "connection_id"
    }

    object PluginLog {
        val CONTENT_URI: Uri = Uri.parse("content://$AUTHORITY/pluginlog")
        const val COLUMN_ID = "id"
        const val COLUMN_MODIFIED = "modified"
        const val COLUMN_PACKAGE_NAME = "packageName"
        const val COLUMN_MESSAGE = "message"
    }
}
