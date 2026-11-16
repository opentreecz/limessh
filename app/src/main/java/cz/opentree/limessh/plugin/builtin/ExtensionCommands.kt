package cz.opentree.limessh.plugin.builtin

/** Original command adapters for capabilities identified in the plugin research. */
object ExtensionCommands {
    const val EXAMPLE = "printf 'limessh extension API ready\\n'; uname -s"
    const val NVIDIA = "nvidia-smi --query-gpu=name,temperature.gpu,utilization.gpu,memory.used,memory.total --format=csv,noheader"
    const val NAS = "uname -s; zpool status; zpool list; zfs list"
    const val VPN_STATUS = "openpyn --status"
    const val VPN_DISCONNECT = "sudo -n openpyn --kill"

    fun vpnConnect(country: String): String {
        require(country.matches(Regex("[a-zA-Z]{2}"))) { "Use a two-letter country code" }
        return "sudo -n openpyn --daemon ${country.lowercase(java.util.Locale.ROOT)}"
    }
}
