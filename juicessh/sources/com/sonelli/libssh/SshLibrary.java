package com.sonelli.libssh;

import com.ochafik.lang.jnaerator.runtime.NativeSize;
import com.ochafik.lang.jnaerator.runtime.NativeSizeByReference;
import com.sonelli.libssh.ssh_key_struct;
import com.sonelli.libssh.ssh_knownhosts_entry;
import com.sonelli.libssh.ssh_signature_struct;
import com.sonelli.libssh.ssh_string_struct;
import com.sun.jna.Callback;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/* loaded from: classes.dex */
public interface SshLibrary extends Library {
    public static final int AES_GCM_IVLEN = 12;
    public static final int AES_GCM_TAGLEN = 16;
    public static final String BINARYDIR = "/build/libssh-arm64-v8a";
    public static final String CLIENT_BANNER_SSH2 = "SSH-2.0-libssh_";
    public static final int CURVE25519_PRIVKEY_SIZE = 32;
    public static final int CURVE25519_PUBKEY_SIZE = 32;
    public static final int DEBUG_CALLTRACE = 1;
    public static final int DH_CLIENT_KEYPAIR = 0;
    public static final int DH_SERVER_KEYPAIR = 1;
    public static final int DIGEST_MAX_LEN = 64;
    public static final String DSA_HEADER_BEGIN = "-----BEGIN DSA PRIVATE KEY-----";
    public static final String DSA_HEADER_END = "-----END DSA PRIVATE KEY-----";
    public static final String ECDSA_HEADER_BEGIN = "-----BEGIN EC PRIVATE KEY-----";
    public static final String ECDSA_HEADER_END = "-----END EC PRIVATE KEY-----";
    public static final int ED25519_KEY_LEN = 32;
    public static final int ED25519_SIG_LEN = 64;
    public static final int ERROR_BUFFERLEN = 1024;
    public static final int EVP_DIGEST_LEN = 64;
    public static final String GLOBAL_BIND_CONFIG = "/etc/ssh/libssh_server_config";
    public static final String GLOBAL_CLIENT_CONFIG = "/etc/ssh/ssh_config";
    public static final int HAVE_ARPA_INET_H = 1;
    public static final int HAVE_CFMAKERAW = 1;
    public static final int HAVE_COMPILER__FUNCTION__ = 1;
    public static final int HAVE_COMPILER__FUNC__ = 1;
    public static final int HAVE_CONSTRUCTOR_ATTRIBUTE = 1;
    public static final int HAVE_CURVE25519 = 1;
    public static final int HAVE_DESTRUCTOR_ATTRIBUTE = 1;
    public static final int HAVE_DSA = 1;
    public static final int HAVE_ECC = 1;
    public static final int HAVE_ECDH = 1;
    public static final int HAVE_GCC_THREAD_LOCAL_STORAGE = 1;
    public static final int HAVE_GCC_VOLATILE_MEMORY_PROTECTION = 1;
    public static final int HAVE_GETADDRINFO = 1;
    public static final int HAVE_GLOB_GL_FLAGS_MEMBER = 1;
    public static final int HAVE_GLOB_H = 1;
    public static final int HAVE_ISBLANK = 1;
    public static final int HAVE_LIBCRYPTO = 1;
    public static final int HAVE_OPENSSL_AES_H = 1;
    public static final int HAVE_OPENSSL_CRYPTO_CTR128_ENCRYPT = 1;
    public static final int HAVE_OPENSSL_DES_H = 1;
    public static final int HAVE_OPENSSL_ECC = 1;
    public static final int HAVE_OPENSSL_ECDH_H = 1;
    public static final int HAVE_OPENSSL_ECDSA_H = 1;
    public static final int HAVE_OPENSSL_EC_H = 1;
    public static final int HAVE_OPENSSL_ED25519 = 1;
    public static final int HAVE_OPENSSL_EVP_AES_CBC = 1;
    public static final int HAVE_OPENSSL_EVP_AES_CTR = 1;
    public static final int HAVE_OPENSSL_EVP_AES_GCM = 1;
    public static final int HAVE_OPENSSL_EVP_CIPHER_CTX_NEW = 1;
    public static final int HAVE_OPENSSL_EVP_DIGESTSIGN = 1;
    public static final int HAVE_OPENSSL_EVP_DIGESTVERIFY = 1;
    public static final int HAVE_OPENSSL_FIPS_MODE = 1;
    public static final int HAVE_OPENSSL_X25519 = 1;
    public static final int HAVE_POLL = 1;
    public static final int HAVE_PTHREAD = 1;
    public static final int HAVE_PTHREAD_H = 1;
    public static final int HAVE_PTY_H = 1;
    public static final int HAVE_SELECT = 1;
    public static final int HAVE_SNPRINTF = 1;
    public static final int HAVE_STDINT_H = 1;
    public static final int HAVE_STRNCPY = 1;
    public static final int HAVE_STRNDUP = 1;
    public static final int HAVE_STRTOULL = 1;
    public static final int HAVE_SYS_TIME_H = 1;
    public static final int HAVE_TERMIOS_H = 1;
    public static final int HAVE_UNISTD_H = 1;
    public static final int HAVE_UNUSED_ATTRIBUTE = 1;
    public static final int HAVE_UTMP_H = 1;
    public static final int HAVE_VSNPRINTF = 1;
    public static final int KBDINT_MAX_PROMPT = 256;
    public static final int LIBSFTP_VERSION = 3;
    public static final int LIBSSH_VERSION_INT = 2307;
    public static final int LIBSSH_VERSION_MAJOR = 0;
    public static final int LIBSSH_VERSION_MICRO = 3;
    public static final int LIBSSH_VERSION_MINOR = 9;
    public static final int MAX_BUF_SIZE = 4096;
    public static final int MAX_PACKET_LEN = 262144;
    public static final int MAX_PRIVKEY_SIZE = 4194304;
    public static final int MAX_PUBKEY_SIZE = 1048576;
    public static final int MD5_DIGEST_LEN = 16;
    public static final String OPENSSH_AUTH_MAGIC = "openssh-key-v1";
    public static final String OPENSSH_HEADER_BEGIN = "-----BEGIN OPENSSH PRIVATE KEY-----";
    public static final String OPENSSH_HEADER_END = "-----END OPENSSH PRIVATE KEY-----";
    public static final int OPENSSL_0_9_7b = 9465903;
    public static final String PACKAGE = "libssh";
    public static final String PRIdS = "zd";
    public static final String RSA_HEADER_BEGIN = "-----BEGIN RSA PRIVATE KEY-----";
    public static final String RSA_HEADER_END = "-----END RSA PRIVATE KEY-----";
    public static final int SFTP_CLOSE = 4;
    public static final int SFTP_EXTENDED = 200;
    public static final int SFTP_FSETSTAT = 10;
    public static final int SFTP_FSTAT = 8;
    public static final int SFTP_LSTAT = 7;
    public static final int SFTP_MKDIR = 14;
    public static final int SFTP_OPEN = 3;
    public static final int SFTP_OPENDIR = 11;
    public static final int SFTP_READ = 5;
    public static final int SFTP_READDIR = 12;
    public static final int SFTP_READLINK = 19;
    public static final int SFTP_REALPATH = 16;
    public static final int SFTP_REMOVE = 13;
    public static final int SFTP_RENAME = 18;
    public static final int SFTP_RMDIR = 15;
    public static final int SFTP_SETSTAT = 9;
    public static final int SFTP_STAT = 17;
    public static final int SFTP_SYMLINK = 20;
    public static final int SFTP_WRITE = 6;
    public static final int SHA256_DIGEST_LEN = 32;
    public static final int SHA384_DIGEST_LEN = 48;
    public static final int SHA512_DIGEST_LEN = 64;
    public static final int SHA_DIGEST_LEN = 20;
    public static final String SOURCEDIR = "/build/libssh";
    public static final int SSH2_AGENTC_ADD_IDENTITY = 17;
    public static final int SSH2_AGENTC_ADD_ID_CONSTRAINED = 25;
    public static final int SSH2_AGENTC_REMOVE_ALL_IDENTITIES = 19;
    public static final int SSH2_AGENTC_REMOVE_IDENTITY = 18;
    public static final int SSH2_AGENTC_REQUEST_IDENTITIES = 11;
    public static final int SSH2_AGENTC_SIGN_REQUEST = 13;
    public static final int SSH2_AGENT_FAILURE = 30;
    public static final int SSH2_AGENT_IDENTITIES_ANSWER = 12;
    public static final int SSH2_AGENT_SIGN_RESPONSE = 14;
    public static final int SSH2_DISCONNECT_AUTH_CANCELLED_BY_USER = 13;
    public static final int SSH2_DISCONNECT_BY_APPLICATION = 11;
    public static final int SSH2_DISCONNECT_COMPRESSION_ERROR = 6;
    public static final int SSH2_DISCONNECT_CONNECTION_LOST = 10;
    public static final int SSH2_DISCONNECT_HOST_AUTHENTICATION_FAILED = 4;
    public static final int SSH2_DISCONNECT_HOST_KEY_NOT_VERIFIABLE = 9;
    public static final int SSH2_DISCONNECT_HOST_NOT_ALLOWED_TO_CONNECT = 1;
    public static final int SSH2_DISCONNECT_ILLEGAL_USER_NAME = 15;
    public static final int SSH2_DISCONNECT_KEY_EXCHANGE_FAILED = 3;
    public static final int SSH2_DISCONNECT_MAC_ERROR = 5;
    public static final int SSH2_DISCONNECT_NO_MORE_AUTH_METHODS_AVAILABLE = 14;
    public static final int SSH2_DISCONNECT_PROTOCOL_ERROR = 2;
    public static final int SSH2_DISCONNECT_PROTOCOL_VERSION_NOT_SUPPORTED = 8;
    public static final int SSH2_DISCONNECT_RESERVED = 4;
    public static final int SSH2_DISCONNECT_SERVICE_NOT_AVAILABLE = 7;
    public static final int SSH2_DISCONNECT_TOO_MANY_CONNECTIONS = 12;
    public static final int SSH2_EXTENDED_DATA_STDERR = 1;
    public static final int SSH2_MSG_CHANNEL_CLOSE = 97;
    public static final int SSH2_MSG_CHANNEL_DATA = 94;
    public static final int SSH2_MSG_CHANNEL_EOF = 96;
    public static final int SSH2_MSG_CHANNEL_EXTENDED_DATA = 95;
    public static final int SSH2_MSG_CHANNEL_FAILURE = 100;
    public static final int SSH2_MSG_CHANNEL_OPEN = 90;
    public static final int SSH2_MSG_CHANNEL_OPEN_CONFIRMATION = 91;
    public static final int SSH2_MSG_CHANNEL_OPEN_FAILURE = 92;
    public static final int SSH2_MSG_CHANNEL_REQUEST = 98;
    public static final int SSH2_MSG_CHANNEL_SUCCESS = 99;
    public static final int SSH2_MSG_CHANNEL_WINDOW_ADJUST = 93;
    public static final int SSH2_MSG_DEBUG = 4;
    public static final int SSH2_MSG_DISCONNECT = 1;
    public static final int SSH2_MSG_ECMQV_INIT = 30;
    public static final int SSH2_MSG_ECMQV_REPLY = 31;
    public static final int SSH2_MSG_EXT_INFO = 7;
    public static final int SSH2_MSG_GLOBAL_REQUEST = 80;
    public static final int SSH2_MSG_IGNORE = 2;
    public static final int SSH2_MSG_KEXDH_INIT = 30;
    public static final int SSH2_MSG_KEXDH_REPLY = 31;
    public static final int SSH2_MSG_KEXINIT = 20;
    public static final int SSH2_MSG_KEX_DH_GEX_GROUP = 31;
    public static final int SSH2_MSG_KEX_DH_GEX_INIT = 32;
    public static final int SSH2_MSG_KEX_DH_GEX_REPLY = 33;
    public static final int SSH2_MSG_KEX_DH_GEX_REQUEST = 34;
    public static final int SSH2_MSG_KEX_DH_GEX_REQUEST_OLD = 30;
    public static final int SSH2_MSG_KEX_ECDH_INIT = 30;
    public static final int SSH2_MSG_KEX_ECDH_REPLY = 31;
    public static final int SSH2_MSG_NEWKEYS = 21;
    public static final int SSH2_MSG_REQUEST_FAILURE = 82;
    public static final int SSH2_MSG_REQUEST_SUCCESS = 81;
    public static final int SSH2_MSG_SERVICE_ACCEPT = 6;
    public static final int SSH2_MSG_SERVICE_REQUEST = 5;
    public static final int SSH2_MSG_UNIMPLEMENTED = 3;
    public static final int SSH2_MSG_USERAUTH_BANNER = 53;
    public static final int SSH2_MSG_USERAUTH_FAILURE = 51;
    public static final int SSH2_MSG_USERAUTH_GSSAPI_ERROR = 64;
    public static final int SSH2_MSG_USERAUTH_GSSAPI_ERRTOK = 65;
    public static final int SSH2_MSG_USERAUTH_GSSAPI_EXCHANGE_COMPLETE = 63;
    public static final int SSH2_MSG_USERAUTH_GSSAPI_MIC = 66;
    public static final int SSH2_MSG_USERAUTH_GSSAPI_RESPONSE = 60;
    public static final int SSH2_MSG_USERAUTH_GSSAPI_TOKEN = 61;
    public static final int SSH2_MSG_USERAUTH_INFO_REQUEST = 60;
    public static final int SSH2_MSG_USERAUTH_INFO_RESPONSE = 61;
    public static final int SSH2_MSG_USERAUTH_PASSWD_CHANGEREQ = 60;
    public static final int SSH2_MSG_USERAUTH_PK_OK = 60;
    public static final int SSH2_MSG_USERAUTH_REQUEST = 50;
    public static final int SSH2_MSG_USERAUTH_SUCCESS = 52;
    public static final int SSH2_OPEN_ADMINISTRATIVELY_PROHIBITED = 1;
    public static final int SSH2_OPEN_CONNECT_FAILED = 2;
    public static final int SSH2_OPEN_RESOURCE_SHORTAGE = 4;
    public static final int SSH2_OPEN_UNKNOWN_CHANNEL_TYPE = 3;
    public static final int SSH_ADDRSTRLEN = 46;
    public static final int SSH_AGAIN = -2;
    public static final int SSH_AGENTC_ADD_RSA_IDENTITY = 7;
    public static final int SSH_AGENTC_ADD_RSA_ID_CONSTRAINED = 24;
    public static final int SSH_AGENTC_ADD_SMARTCARD_KEY = 20;
    public static final int SSH_AGENTC_ADD_SMARTCARD_KEY_CONSTRAINED = 26;
    public static final int SSH_AGENTC_LOCK = 22;
    public static final int SSH_AGENTC_REMOVE_ALL_RSA_IDENTITIES = 9;
    public static final int SSH_AGENTC_REMOVE_RSA_IDENTITY = 8;
    public static final int SSH_AGENTC_REMOVE_SMARTCARD_KEY = 21;
    public static final int SSH_AGENTC_REQUEST_RSA_IDENTITIES = 1;
    public static final int SSH_AGENTC_RSA_CHALLENGE = 3;
    public static final int SSH_AGENTC_UNLOCK = 23;
    public static final int SSH_AGENT_CONSTRAIN_CONFIRM = 2;
    public static final int SSH_AGENT_CONSTRAIN_LIFETIME = 1;
    public static final int SSH_AGENT_FAILURE = 5;
    public static final int SSH_AGENT_OLD_SIGNATURE = 1;
    public static final int SSH_AGENT_RSA_IDENTITIES_ANSWER = 2;
    public static final int SSH_AGENT_RSA_RESPONSE = 4;
    public static final int SSH_AGENT_RSA_SHA2_256 = 2;
    public static final int SSH_AGENT_RSA_SHA2_512 = 4;
    public static final int SSH_AGENT_SUCCESS = 6;
    public static final int SSH_AUTH_METHOD_GSSAPI_MIC = 32;
    public static final int SSH_AUTH_METHOD_HOSTBASED = 8;
    public static final int SSH_AUTH_METHOD_INTERACTIVE = 16;
    public static final int SSH_AUTH_METHOD_NONE = 1;
    public static final int SSH_AUTH_METHOD_PASSWORD = 2;
    public static final int SSH_AUTH_METHOD_PUBLICKEY = 4;
    public static final int SSH_AUTH_METHOD_UNKNOWN = 0;
    public static final int SSH_CLOSED = 1;
    public static final int SSH_CLOSED_ERROR = 4;
    public static final int SSH_COMP = 4;
    public static final int SSH_COM_AGENT2_FAILURE = 102;
    public static final int SSH_CRYPT = 2;
    public static final int SSH_EOF = -127;
    public static final int SSH_ERROR = -1;
    public static final int SSH_FILEXFER_ATTR_ACCESSTIME = 8;
    public static final int SSH_FILEXFER_ATTR_ACL = 64;
    public static final int SSH_FILEXFER_ATTR_ACMODTIME = 8;
    public static final int SSH_FILEXFER_ATTR_CREATETIME = 16;
    public static final int SSH_FILEXFER_ATTR_EXTENDED = Integer.MIN_VALUE;
    public static final int SSH_FILEXFER_ATTR_MODIFYTIME = 32;
    public static final int SSH_FILEXFER_ATTR_OWNERGROUP = 128;
    public static final int SSH_FILEXFER_ATTR_PERMISSIONS = 4;
    public static final int SSH_FILEXFER_ATTR_SIZE = 1;
    public static final int SSH_FILEXFER_ATTR_SUBSECOND_TIMES = 256;
    public static final int SSH_FILEXFER_ATTR_UIDGID = 2;
    public static final int SSH_FILEXFER_TYPE_DIRECTORY = 2;
    public static final int SSH_FILEXFER_TYPE_REGULAR = 1;
    public static final int SSH_FILEXFER_TYPE_SPECIAL = 4;
    public static final int SSH_FILEXFER_TYPE_SYMLINK = 3;
    public static final int SSH_FILEXFER_TYPE_UNKNOWN = 5;
    public static final int SSH_FXE_STATVFS_ST_NOSUID = 2;
    public static final int SSH_FXE_STATVFS_ST_RDONLY = 1;
    public static final int SSH_FXF_APPEND = 4;
    public static final int SSH_FXF_CREAT = 8;
    public static final int SSH_FXF_EXCL = 32;
    public static final int SSH_FXF_READ = 1;
    public static final int SSH_FXF_RENAME_ATOMIC = 2;
    public static final int SSH_FXF_RENAME_NATIVE = 4;
    public static final int SSH_FXF_RENAME_OVERWRITE = 1;
    public static final int SSH_FXF_TEXT = 64;
    public static final int SSH_FXF_TRUNC = 16;
    public static final int SSH_FXF_WRITE = 2;
    public static final int SSH_FXP_ATTRS = 105;
    public static final int SSH_FXP_CLOSE = 4;
    public static final int SSH_FXP_DATA = 103;
    public static final int SSH_FXP_EXTENDED = 200;
    public static final int SSH_FXP_EXTENDED_REPLY = 201;
    public static final int SSH_FXP_FSETSTAT = 10;
    public static final int SSH_FXP_FSTAT = 8;
    public static final int SSH_FXP_HANDLE = 102;
    public static final int SSH_FXP_INIT = 1;
    public static final int SSH_FXP_LSTAT = 7;
    public static final int SSH_FXP_MKDIR = 14;
    public static final int SSH_FXP_NAME = 104;
    public static final int SSH_FXP_OPEN = 3;
    public static final int SSH_FXP_OPENDIR = 11;
    public static final int SSH_FXP_READ = 5;
    public static final int SSH_FXP_READDIR = 12;
    public static final int SSH_FXP_READLINK = 19;
    public static final int SSH_FXP_REALPATH = 16;
    public static final int SSH_FXP_REMOVE = 13;
    public static final int SSH_FXP_RENAME = 18;
    public static final int SSH_FXP_RMDIR = 15;
    public static final int SSH_FXP_SETSTAT = 9;
    public static final int SSH_FXP_STAT = 17;
    public static final int SSH_FXP_STATUS = 101;
    public static final int SSH_FXP_SYMLINK = 20;
    public static final int SSH_FXP_VERSION = 2;
    public static final int SSH_FXP_WRITE = 6;
    public static final int SSH_FX_BAD_MESSAGE = 5;
    public static final int SSH_FX_CONNECTION_LOST = 7;
    public static final int SSH_FX_EOF = 1;
    public static final int SSH_FX_FAILURE = 4;
    public static final int SSH_FX_FILE_ALREADY_EXISTS = 11;
    public static final int SSH_FX_INVALID_HANDLE = 9;
    public static final int SSH_FX_NO_CONNECTION = 6;
    public static final int SSH_FX_NO_MEDIA = 13;
    public static final int SSH_FX_NO_SUCH_FILE = 2;
    public static final int SSH_FX_NO_SUCH_PATH = 10;
    public static final int SSH_FX_OK = 0;
    public static final int SSH_FX_OP_UNSUPPORTED = 8;
    public static final int SSH_FX_PERMISSION_DENIED = 3;
    public static final int SSH_FX_WRITE_PROTECT = 12;
    public static final int SSH_KEX_METHODS = 10;
    public static final int SSH_KEY_FLAG_EMPTY = 0;
    public static final int SSH_KEY_FLAG_PRIVATE = 2;
    public static final int SSH_KEY_FLAG_PUBLIC = 1;
    public static final int SSH_LANG = 5;
    public static final int SSH_LOG_DEBUG = 3;
    public static final int SSH_LOG_FUNCTIONS = 4;
    public static final int SSH_LOG_INFO = 2;
    public static final int SSH_LOG_NOLOG = 0;
    public static final int SSH_LOG_NONE = 0;
    public static final int SSH_LOG_PACKET = 3;
    public static final int SSH_LOG_PROTOCOL = 2;
    public static final int SSH_LOG_TRACE = 4;
    public static final int SSH_LOG_WARN = 1;
    public static final int SSH_LOG_WARNING = 1;
    public static final int SSH_MAC = 3;
    public static final int SSH_OK = 0;
    public static final int SSH_PACKET_NOT_USED = 2;
    public static final int SSH_PACKET_USED = 1;
    public static final int SSH_READ_PENDING = 2;
    public static final int SSH_SCP_READ = 1;
    public static final int SSH_SCP_RECURSIVE = 16;
    public static final int SSH_SCP_WRITE = 0;
    public static final int SSH_SOCKET_CONNECTED_ERROR = 2;
    public static final int SSH_SOCKET_CONNECTED_OK = 1;
    public static final int SSH_SOCKET_CONNECTED_TIMEOUT = 3;
    public static final int SSH_SOCKET_EXCEPTION_EOF = 1;
    public static final int SSH_SOCKET_EXCEPTION_ERROR = 2;
    public static final int SSH_SOCKET_FLOW_WRITEWILLBLOCK = 1;
    public static final int SSH_SOCKET_FLOW_WRITEWONTBLOCK = 2;
    public static final int SSH_S_IFBLK = 24576;
    public static final int SSH_S_IFCHR = 8192;
    public static final int SSH_S_IFDIR = 16384;
    public static final int SSH_S_IFIFO = 4096;
    public static final int SSH_S_IFLNK = 120000;
    public static final int SSH_S_IFMT = 61440;
    public static final int SSH_S_IFREG = 100000;
    public static final int SSH_S_IFSOCK = 140000;
    public static final int SSH_WRITE_PENDING = 8;
    public static final String SYSCONFDIR = "etc";
    public static final String VERSION = "0.9.4";
    public static final int WITH_GEX = 1;
    public static final int WITH_PCAP = 1;
    public static final int WITH_SERVER = 1;
    public static final int WITH_SFTP = 1;
    public static final int WITH_ZLIB = 1;
    public static final String JNA_LIBRARY_NAME = "com.sonelli.libssh";
    public static final NativeLibrary JNA_NATIVE_LIB = NativeLibrary.getInstance(JNA_LIBRARY_NAME);
    public static final SshLibrary INSTANCE = (SshLibrary) Native.loadLibrary(JNA_LIBRARY_NAME, SshLibrary.class);

    /* loaded from: classes.dex */
    public static class DSA extends PointerType {
        public DSA() {
        }

        public DSA(Pointer pointer) {
            super(pointer);
        }
    }

    /* loaded from: classes.dex */
    public static class EC_KEY extends PointerType {
        public EC_KEY() {
        }

        public EC_KEY(Pointer pointer) {
            super(pointer);
        }
    }

    /* loaded from: classes.dex */
    public static class EVPCTX extends PointerType {
        public EVPCTX() {
        }

        public EVPCTX(Pointer pointer) {
            super(pointer);
        }
    }

    /* loaded from: classes.dex */
    public static class EVP_CIPHER extends PointerType {
        public EVP_CIPHER() {
        }

        public EVP_CIPHER(Pointer pointer) {
            super(pointer);
        }
    }

    /* loaded from: classes.dex */
    public static class EVP_CIPHER_CTX extends PointerType {
        public EVP_CIPHER_CTX() {
        }

        public EVP_CIPHER_CTX(Pointer pointer) {
            super(pointer);
        }
    }

    /* loaded from: classes.dex */
    public static class HMACCTX extends PointerType {
        public HMACCTX() {
        }

        public HMACCTX(Pointer pointer) {
            super(pointer);
        }
    }

    /* loaded from: classes.dex */
    public static class MD5CTX extends PointerType {
        public MD5CTX() {
        }

        public MD5CTX(Pointer pointer) {
            super(pointer);
        }
    }

    /* loaded from: classes.dex */
    public static class RSA extends PointerType {
        public RSA() {
        }

        public RSA(Pointer pointer) {
            super(pointer);
        }
    }

    /* loaded from: classes.dex */
    public static class SHA256CTX extends PointerType {
        public SHA256CTX() {
        }

        public SHA256CTX(Pointer pointer) {
            super(pointer);
        }
    }

    /* loaded from: classes.dex */
    public static class SHA384CTX extends PointerType {
        public SHA384CTX() {
        }

        public SHA384CTX(Pointer pointer) {
            super(pointer);
        }
    }

    /* loaded from: classes.dex */
    public static class SHA512CTX extends PointerType {
        public SHA512CTX() {
        }

        public SHA512CTX(Pointer pointer) {
            super(pointer);
        }
    }

    /* loaded from: classes.dex */
    public static class SHACTX extends PointerType {
        public SHACTX() {
        }

        public SHACTX(Pointer pointer) {
            super(pointer);
        }
    }

    /* loaded from: classes.dex */
    public static class bignum extends PointerType {
        public bignum() {
        }

        public bignum(Pointer pointer) {
            super(pointer);
        }
    }

    /* loaded from: classes.dex */
    public static class chacha20_poly1305_keysched extends PointerType {
        public chacha20_poly1305_keysched() {
        }

        public chacha20_poly1305_keysched(Pointer pointer) {
            super(pointer);
        }
    }

    /* loaded from: classes.dex */
    public static class const_bignum extends PointerType {
        public const_bignum() {
        }

        public const_bignum(Pointer pointer) {
            super(pointer);
        }
    }

    /* loaded from: classes.dex */
    public static class dh_ctx extends PointerType {
        public dh_ctx() {
        }

        public dh_ctx(Pointer pointer) {
            super(pointer);
        }
    }

    /* loaded from: classes.dex */
    public static class fd_set extends PointerType {
        public fd_set() {
        }

        public fd_set(Pointer pointer) {
            super(pointer);
        }
    }

    /* loaded from: classes.dex */
    public static class sftp_ext extends PointerType {
        public sftp_ext() {
        }

        public sftp_ext(Pointer pointer) {
            super(pointer);
        }
    }

    /* loaded from: classes.dex */
    public static class ssh_3des_key_schedule extends PointerType {
        public ssh_3des_key_schedule() {
        }

        public ssh_3des_key_schedule(Pointer pointer) {
            super(pointer);
        }
    }

    /* loaded from: classes.dex */
    public static class ssh_aes_key_schedule extends PointerType {
        public ssh_aes_key_schedule() {
        }

        public ssh_aes_key_schedule(Pointer pointer) {
            super(pointer);
        }
    }

    /* loaded from: classes.dex */
    public interface ssh_auth_callback extends Callback {
        int apply(Pointer pointer, Pointer pointer2, NativeSize nativeSize, int i, int i2, Pointer pointer3);
    }

    /* loaded from: classes.dex */
    public interface ssh_auth_e {
    }

    /* loaded from: classes.dex */
    public interface ssh_auth_gssapi_mic_callback extends Callback {
        int apply(Pointer pointer, Pointer pointer2, Pointer pointer3, Pointer pointer4);
    }

    /* loaded from: classes.dex */
    public interface ssh_auth_none_callback extends Callback {
        int apply(Pointer pointer, Pointer pointer2, Pointer pointer3);
    }

    /* loaded from: classes.dex */
    public interface ssh_auth_password_callback extends Callback {
        int apply(Pointer pointer, Pointer pointer2, Pointer pointer3, Pointer pointer4);
    }

    /* loaded from: classes.dex */
    public interface ssh_auth_pubkey_callback extends Callback {
        int apply(Pointer pointer, Pointer pointer2, ssh_key_struct ssh_key_structVar, byte b, Pointer pointer3);
    }

    /* loaded from: classes.dex */
    public static class ssh_bind extends PointerType {
        public ssh_bind() {
        }

        public ssh_bind(Pointer pointer) {
            super(pointer);
        }
    }

    /* loaded from: classes.dex */
    public interface ssh_bind_incoming_connection_callback extends Callback {
        void apply(Pointer pointer, Pointer pointer2);
    }

    /* loaded from: classes.dex */
    public interface ssh_bind_options_e {
    }

    /* loaded from: classes.dex */
    public static class ssh_buffer extends PointerType {
        public ssh_buffer() {
        }

        public ssh_buffer(Pointer pointer) {
            super(pointer);
        }
    }

    /* loaded from: classes.dex */
    public static class ssh_buffer_struct extends PointerType {
        public ssh_buffer_struct() {
        }

        public ssh_buffer_struct(Pointer pointer) {
            super(pointer);
        }
    }

    /* loaded from: classes.dex */
    public interface ssh_callback_data extends Callback {
        int apply(Pointer pointer, NativeSize nativeSize, Pointer pointer2);
    }

    /* loaded from: classes.dex */
    public interface ssh_callback_int extends Callback {
        void apply(int i, Pointer pointer);
    }

    /* loaded from: classes.dex */
    public interface ssh_callback_int_int extends Callback {
        void apply(int i, int i2, Pointer pointer);
    }

    /* loaded from: classes.dex */
    public static class ssh_channel extends PointerType {
        public ssh_channel() {
        }

        public ssh_channel(Pointer pointer) {
            super(pointer);
        }
    }

    /* loaded from: classes.dex */
    public interface ssh_channel_auth_agent_req_callback extends Callback {
        void apply(Pointer pointer, Pointer pointer2, Pointer pointer3);
    }

    /* loaded from: classes.dex */
    public interface ssh_channel_callback_data extends Callback {
        int apply(Pointer pointer, int i, Pointer pointer2, NativeSize nativeSize, Pointer pointer3);
    }

    /* loaded from: classes.dex */
    public interface ssh_channel_callback_int extends Callback {
        int apply(Pointer pointer, int i, Pointer pointer2);
    }

    /* loaded from: classes.dex */
    public interface ssh_channel_close_callback extends Callback {
        void apply(Pointer pointer, Pointer pointer2, Pointer pointer3);
    }

    /* loaded from: classes.dex */
    public interface ssh_channel_data_callback extends Callback {
        int apply(Pointer pointer, Pointer pointer2, Pointer pointer3, int i, int i2, Pointer pointer4);
    }

    /* loaded from: classes.dex */
    public interface ssh_channel_env_request_callback extends Callback {
        int apply(Pointer pointer, Pointer pointer2, Pointer pointer3, Pointer pointer4, Pointer pointer5);
    }

    /* loaded from: classes.dex */
    public interface ssh_channel_eof_callback extends Callback {
        void apply(Pointer pointer, Pointer pointer2, Pointer pointer3);
    }

    /* loaded from: classes.dex */
    public interface ssh_channel_exec_request_callback extends Callback {
        int apply(Pointer pointer, Pointer pointer2, Pointer pointer3, Pointer pointer4);
    }

    /* loaded from: classes.dex */
    public interface ssh_channel_exit_signal_callback extends Callback {
        void apply(Pointer pointer, Pointer pointer2, Pointer pointer3, int i, Pointer pointer4, Pointer pointer5, Pointer pointer6);
    }

    /* loaded from: classes.dex */
    public interface ssh_channel_exit_status_callback extends Callback {
        void apply(Pointer pointer, Pointer pointer2, int i, Pointer pointer3);
    }

    /* loaded from: classes.dex */
    public interface ssh_channel_open_request_auth_agent_callback extends Callback {
        ssh_channel apply(Pointer pointer, Pointer pointer2);
    }

    /* loaded from: classes.dex */
    public interface ssh_channel_open_request_session_callback extends Callback {
        ssh_channel apply(Pointer pointer, Pointer pointer2);
    }

    /* loaded from: classes.dex */
    public interface ssh_channel_open_request_x11_callback extends Callback {
        ssh_channel apply(Pointer pointer, Pointer pointer2, int i, Pointer pointer3);
    }

    /* loaded from: classes.dex */
    public interface ssh_channel_pty_request_callback extends Callback {
        int apply(Pointer pointer, Pointer pointer2, Pointer pointer3, int i, int i2, int i3, int i4, Pointer pointer4);
    }

    /* loaded from: classes.dex */
    public interface ssh_channel_pty_window_change_callback extends Callback {
        int apply(Pointer pointer, Pointer pointer2, int i, int i2, int i3, int i4, Pointer pointer3);
    }

    /* loaded from: classes.dex */
    public interface ssh_channel_requests_e {
    }

    /* loaded from: classes.dex */
    public interface ssh_channel_shell_request_callback extends Callback {
        int apply(Pointer pointer, Pointer pointer2, Pointer pointer3);
    }

    /* loaded from: classes.dex */
    public interface ssh_channel_signal_callback extends Callback {
        void apply(Pointer pointer, Pointer pointer2, Pointer pointer3, Pointer pointer4);
    }

    /* loaded from: classes.dex */
    public interface ssh_channel_subsystem_request_callback extends Callback {
        int apply(Pointer pointer, Pointer pointer2, Pointer pointer3, Pointer pointer4);
    }

    /* loaded from: classes.dex */
    public interface ssh_channel_type_e {
    }

    /* loaded from: classes.dex */
    public interface ssh_channel_write_wontblock_callback extends Callback {
        int apply(Pointer pointer, Pointer pointer2, NativeSize nativeSize, Pointer pointer3);
    }

    /* loaded from: classes.dex */
    public interface ssh_channel_x11_req_callback extends Callback {
        void apply(Pointer pointer, Pointer pointer2, int i, Pointer pointer3, Pointer pointer4, int i2, Pointer pointer5);
    }

    /* loaded from: classes.dex */
    public interface ssh_cipher_e {
    }

    /* loaded from: classes.dex */
    public static class ssh_common_struct extends PointerType {
        public ssh_common_struct() {
        }

        public ssh_common_struct(Pointer pointer) {
            super(pointer);
        }
    }

    /* loaded from: classes.dex */
    public static class ssh_connector extends PointerType {
        public ssh_connector() {
        }

        public ssh_connector(Pointer pointer) {
            super(pointer);
        }
    }

    /* loaded from: classes.dex */
    public interface ssh_connector_flags_e {
    }

    /* loaded from: classes.dex */
    public interface ssh_crypto_direction_e {
    }

    /* loaded from: classes.dex */
    public interface ssh_des_e {
    }

    /* loaded from: classes.dex */
    public interface ssh_digest_e {
    }

    /* loaded from: classes.dex */
    public interface ssh_error_types_e {
    }

    /* loaded from: classes.dex */
    public static class ssh_event extends PointerType {
        public ssh_event() {
        }

        public ssh_event(Pointer pointer) {
            super(pointer);
        }
    }

    /* loaded from: classes.dex */
    public interface ssh_event_callback extends Callback {
        int apply(int i, int i2, Pointer pointer);
    }

    /* loaded from: classes.dex */
    public interface ssh_global_request_callback extends Callback {
        void apply(Pointer pointer, Pointer pointer2, Pointer pointer3);
    }

    /* loaded from: classes.dex */
    public interface ssh_global_requests_e {
    }

    /* loaded from: classes.dex */
    public interface ssh_gssapi_accept_sec_ctx_callback extends Callback {
        int apply(Pointer pointer, ssh_string_struct ssh_string_structVar, PointerByReference pointerByReference, Pointer pointer2);
    }

    /* loaded from: classes.dex */
    public interface ssh_gssapi_select_oid_callback extends Callback {
        ssh_string_struct apply(Pointer pointer, Pointer pointer2, int i, PointerByReference pointerByReference, Pointer pointer3);
    }

    /* loaded from: classes.dex */
    public interface ssh_gssapi_verify_mic_callback extends Callback {
        int apply(Pointer pointer, ssh_string_struct ssh_string_structVar, Pointer pointer2, NativeSize nativeSize, Pointer pointer3);
    }

    /* loaded from: classes.dex */
    public interface ssh_hmac_e {
    }

    /* loaded from: classes.dex */
    public interface ssh_kdf_digest {
    }

    /* loaded from: classes.dex */
    public interface ssh_kex_types_e {
    }

    /* loaded from: classes.dex */
    public interface ssh_key_exchange_e {
    }

    /* loaded from: classes.dex */
    public interface ssh_keycmp_e {
    }

    /* loaded from: classes.dex */
    public interface ssh_keytypes_e {
    }

    /* loaded from: classes.dex */
    public interface ssh_known_hosts_e {
    }

    /* loaded from: classes.dex */
    public interface ssh_log_callback extends Callback {
        void apply(Pointer pointer, int i, Pointer pointer2, Pointer pointer3);
    }

    /* loaded from: classes.dex */
    public interface ssh_logging_callback extends Callback {
        void apply(int i, Pointer pointer, Pointer pointer2, Pointer pointer3);
    }

    /* loaded from: classes.dex */
    public static class ssh_message extends PointerType {
        public ssh_message() {
        }

        public ssh_message(Pointer pointer) {
            super(pointer);
        }
    }

    /* loaded from: classes.dex */
    public interface ssh_message_callback extends Callback {
        int apply(Pointer pointer, Pointer pointer2);
    }

    /* loaded from: classes.dex */
    public interface ssh_options_e {
    }

    /* loaded from: classes.dex */
    public interface ssh_packet_callback extends Callback {
        int apply(Pointer pointer, byte b, Pointer pointer2, Pointer pointer3);
    }

    /* loaded from: classes.dex */
    public static class ssh_pcap_file extends PointerType {
        public ssh_pcap_file() {
        }

        public ssh_pcap_file(Pointer pointer) {
            super(pointer);
        }
    }

    /* loaded from: classes.dex */
    public static class ssh_private_key extends PointerType {
        public ssh_private_key() {
        }

        public ssh_private_key(Pointer pointer) {
            super(pointer);
        }
    }

    /* loaded from: classes.dex */
    public static class ssh_public_key extends PointerType {
        public ssh_public_key() {
        }

        public ssh_public_key(Pointer pointer) {
            super(pointer);
        }
    }

    /* loaded from: classes.dex */
    public interface ssh_publickey_hash_type {
    }

    /* loaded from: classes.dex */
    public interface ssh_publickey_state_e {
    }

    /* loaded from: classes.dex */
    public interface ssh_requests_e {
    }

    /* loaded from: classes.dex */
    public static class ssh_scp extends PointerType {
        public ssh_scp() {
        }

        public ssh_scp(Pointer pointer) {
            super(pointer);
        }
    }

    /* loaded from: classes.dex */
    public interface ssh_scp_request_types {
    }

    /* loaded from: classes.dex */
    public interface ssh_server_known_e {
    }

    /* loaded from: classes.dex */
    public interface ssh_service_request_callback extends Callback {
        int apply(Pointer pointer, Pointer pointer2, Pointer pointer3);
    }

    /* loaded from: classes.dex */
    public static class ssh_session extends PointerType {
        public ssh_session() {
        }

        public ssh_session(Pointer pointer) {
            super(pointer);
        }
    }

    /* loaded from: classes.dex */
    public static class ssh_session_struct extends PointerType {
        public ssh_session_struct() {
        }

        public ssh_session_struct(Pointer pointer) {
            super(pointer);
        }
    }

    /* loaded from: classes.dex */
    public interface ssh_set_message_callback_ssh_bind_message_callback_callback extends Callback {
        int apply(Pointer pointer, Pointer pointer2, Pointer pointer3);
    }

    /* loaded from: classes.dex */
    public static class ssh_socket_struct extends PointerType {
        public ssh_socket_struct() {
        }

        public ssh_socket_struct(Pointer pointer) {
            super(pointer);
        }
    }

    /* loaded from: classes.dex */
    public interface ssh_status_callback extends Callback {
        void apply(Pointer pointer, float f, Pointer pointer2);
    }

    /* loaded from: classes.dex */
    public interface ssh_thread_callback extends Callback {
        int apply(PointerByReference pointerByReference);
    }

    /* loaded from: classes.dex */
    public interface ssh_thread_id_callback extends Callback {
        NativeLong apply();
    }

    /* loaded from: classes.dex */
    public static class timeval extends PointerType {
        public timeval() {
        }

        public timeval(Pointer pointer) {
            super(pointer);
        }
    }

    @Deprecated
    void _ssh_log(int i, Pointer pointer, Pointer pointer2, Object... objArr);

    void _ssh_log(int i, String str, String str2, Object... objArr);

    @Deprecated
    void _ssh_set_error(Pointer pointer, int i, Pointer pointer2, Pointer pointer3, Object... objArr);

    void _ssh_set_error(Pointer pointer, int i, String str, String str2, Object... objArr);

    @Deprecated
    void _ssh_set_error_invalid(Pointer pointer, Pointer pointer2);

    void _ssh_set_error_invalid(Pointer pointer, String str);

    @Deprecated
    void _ssh_set_error_oom(Pointer pointer, Pointer pointer2);

    void _ssh_set_error_oom(Pointer pointer, String str);

    @Deprecated
    ssh_buffer base64_to_bin(Pointer pointer);

    ssh_buffer base64_to_bin(String str);

    @Deprecated
    int bcrypt_pbkdf(Pointer pointer, NativeSize nativeSize, Pointer pointer2, NativeSize nativeSize2, Pointer pointer3, NativeSize nativeSize3, int i);

    int bcrypt_pbkdf(String str, NativeSize nativeSize, byte[] bArr, NativeSize nativeSize2, ByteBuffer byteBuffer, NativeSize nativeSize3, int i);

    @Deprecated
    Pointer bin_to_base64(Pointer pointer, NativeSize nativeSize);

    Pointer bin_to_base64(byte[] bArr, NativeSize nativeSize);

    int buffer_add_attributes(ssh_buffer ssh_bufferVar, sftp_attributes_struct sftp_attributes_structVar);

    @Deprecated
    int buffer_add_attributes(Pointer pointer, sftp_attributes_struct sftp_attributes_structVar);

    void buffer_free(ssh_buffer ssh_bufferVar);

    @Deprecated
    void buffer_free(Pointer pointer);

    Pointer buffer_get(ssh_buffer ssh_bufferVar);

    @Deprecated
    Pointer buffer_get(Pointer pointer);

    int buffer_get_len(ssh_buffer ssh_bufferVar);

    @Deprecated
    int buffer_get_len(Pointer pointer);

    ssh_buffer buffer_new();

    ssh_channel channel_accept_x11(ssh_channel ssh_channelVar, int i);

    @Deprecated
    ssh_channel channel_accept_x11(Pointer pointer, int i);

    int channel_change_pty_size(ssh_channel ssh_channelVar, int i, int i2);

    @Deprecated
    int channel_change_pty_size(Pointer pointer, int i, int i2);

    int channel_close(ssh_channel ssh_channelVar);

    @Deprecated
    int channel_close(Pointer pointer);

    ssh_channel channel_forward_accept(ssh_session ssh_sessionVar, int i);

    @Deprecated
    ssh_channel channel_forward_accept(Pointer pointer, int i);

    int channel_forward_cancel(ssh_session ssh_sessionVar, String str, int i);

    @Deprecated
    int channel_forward_cancel(Pointer pointer, Pointer pointer2, int i);

    int channel_forward_listen(ssh_session ssh_sessionVar, String str, int i, IntBuffer intBuffer);

    @Deprecated
    int channel_forward_listen(Pointer pointer, Pointer pointer2, int i, IntByReference intByReference);

    void channel_free(ssh_channel ssh_channelVar);

    @Deprecated
    void channel_free(Pointer pointer);

    int channel_get_exit_status(ssh_channel ssh_channelVar);

    @Deprecated
    int channel_get_exit_status(Pointer pointer);

    ssh_session channel_get_session(ssh_channel ssh_channelVar);

    @Deprecated
    ssh_session channel_get_session(Pointer pointer);

    int channel_is_closed(ssh_channel ssh_channelVar);

    @Deprecated
    int channel_is_closed(Pointer pointer);

    int channel_is_eof(ssh_channel ssh_channelVar);

    @Deprecated
    int channel_is_eof(Pointer pointer);

    int channel_is_open(ssh_channel ssh_channelVar);

    @Deprecated
    int channel_is_open(Pointer pointer);

    ssh_channel channel_new(ssh_session ssh_sessionVar);

    @Deprecated
    ssh_channel channel_new(Pointer pointer);

    int channel_open_forward(ssh_channel ssh_channelVar, String str, int i, String str2, int i2);

    @Deprecated
    int channel_open_forward(Pointer pointer, Pointer pointer2, int i, Pointer pointer3, int i2);

    int channel_open_session(ssh_channel ssh_channelVar);

    @Deprecated
    int channel_open_session(Pointer pointer);

    int channel_poll(ssh_channel ssh_channelVar, int i);

    @Deprecated
    int channel_poll(Pointer pointer, int i);

    int channel_read(ssh_channel ssh_channelVar, Pointer pointer, int i, int i2);

    @Deprecated
    int channel_read(Pointer pointer, Pointer pointer2, int i, int i2);

    int channel_read_buffer(ssh_channel ssh_channelVar, ssh_buffer ssh_bufferVar, int i, int i2);

    @Deprecated
    int channel_read_buffer(Pointer pointer, Pointer pointer2, int i, int i2);

    int channel_read_nonblocking(ssh_channel ssh_channelVar, Pointer pointer, int i, int i2);

    @Deprecated
    int channel_read_nonblocking(Pointer pointer, Pointer pointer2, int i, int i2);

    int channel_request_env(ssh_channel ssh_channelVar, String str, String str2);

    @Deprecated
    int channel_request_env(Pointer pointer, Pointer pointer2, Pointer pointer3);

    int channel_request_exec(ssh_channel ssh_channelVar, String str);

    @Deprecated
    int channel_request_exec(Pointer pointer, Pointer pointer2);

    int channel_request_pty(ssh_channel ssh_channelVar);

    @Deprecated
    int channel_request_pty(Pointer pointer);

    int channel_request_pty_size(ssh_channel ssh_channelVar, String str, int i, int i2);

    @Deprecated
    int channel_request_pty_size(Pointer pointer, Pointer pointer2, int i, int i2);

    int channel_request_send_signal(ssh_channel ssh_channelVar, String str);

    @Deprecated
    int channel_request_send_signal(Pointer pointer, Pointer pointer2);

    int channel_request_sftp(ssh_channel ssh_channelVar);

    @Deprecated
    int channel_request_sftp(Pointer pointer);

    int channel_request_shell(ssh_channel ssh_channelVar);

    @Deprecated
    int channel_request_shell(Pointer pointer);

    int channel_request_subsystem(ssh_channel ssh_channelVar, String str);

    @Deprecated
    int channel_request_subsystem(Pointer pointer, Pointer pointer2);

    int channel_request_x11(ssh_channel ssh_channelVar, int i, String str, String str2, int i2);

    @Deprecated
    int channel_request_x11(Pointer pointer, int i, Pointer pointer2, Pointer pointer3, int i2);

    @Deprecated
    int channel_select(Pointer pointer, Pointer pointer2, Pointer pointer3, timeval timevalVar);

    int channel_select(PointerByReference pointerByReference, PointerByReference pointerByReference2, PointerByReference pointerByReference3, timeval timevalVar);

    int channel_send_eof(ssh_channel ssh_channelVar);

    @Deprecated
    int channel_send_eof(Pointer pointer);

    void channel_set_blocking(ssh_channel ssh_channelVar, int i);

    @Deprecated
    void channel_set_blocking(Pointer pointer, int i);

    int channel_write(ssh_channel ssh_channelVar, Pointer pointer, int i);

    @Deprecated
    int channel_write(Pointer pointer, Pointer pointer2, int i);

    int channel_write_stderr(ssh_channel ssh_channelVar, Pointer pointer, int i);

    @Deprecated
    int channel_write_stderr(Pointer pointer, Pointer pointer2, int i);

    int compress_buffer(ssh_session ssh_sessionVar, ssh_buffer ssh_bufferVar);

    @Deprecated
    int compress_buffer(Pointer pointer, Pointer pointer2);

    int crypt_set_algorithms_client(ssh_session ssh_sessionVar);

    @Deprecated
    int crypt_set_algorithms_client(Pointer pointer);

    int crypt_set_algorithms_server(ssh_session ssh_sessionVar);

    @Deprecated
    int crypt_set_algorithms_server(Pointer pointer);

    void crypto_free(ssh_crypto_struct ssh_crypto_structVar);

    ssh_crypto_struct crypto_new();

    @Deprecated
    int crypto_scalarmult(Pointer pointer, Pointer pointer2, Pointer pointer3);

    int crypto_scalarmult(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2);

    @Deprecated
    int crypto_scalarmult_base(Pointer pointer, Pointer pointer2);

    int crypto_scalarmult_base(ByteBuffer byteBuffer, byte[] bArr);

    int decompress_buffer(ssh_session ssh_sessionVar, ssh_buffer ssh_bufferVar, NativeSize nativeSize);

    @Deprecated
    int decompress_buffer(Pointer pointer, Pointer pointer2, NativeSize nativeSize);

    int ecdh_build_k(ssh_session ssh_sessionVar);

    @Deprecated
    int ecdh_build_k(Pointer pointer);

    @Deprecated
    void evp(int i, Pointer pointer, int i2, Pointer pointer2, IntByReference intByReference);

    void evp(int i, ByteBuffer byteBuffer, int i2, ByteBuffer byteBuffer2, IntBuffer intBuffer);

    void evp_final(EVPCTX evpctx, ByteBuffer byteBuffer, IntBuffer intBuffer);

    @Deprecated
    void evp_final(Pointer pointer, Pointer pointer2, IntByReference intByReference);

    EVPCTX evp_init(int i);

    void evp_update(EVPCTX evpctx, Pointer pointer, NativeLong nativeLong);

    @Deprecated
    void evp_update(Pointer pointer, Pointer pointer2, NativeLong nativeLong);

    void explicit_bzero(Pointer pointer, NativeSize nativeSize);

    NativeSize hmac_digest_len(int i);

    void hmac_final(HMACCTX hmacctx, ByteBuffer byteBuffer, IntBuffer intBuffer);

    @Deprecated
    void hmac_final(Pointer pointer, Pointer pointer2, IntByReference intByReference);

    HMACCTX hmac_init(Pointer pointer, int i, int i2);

    void hmac_update(HMACCTX hmacctx, Pointer pointer, NativeLong nativeLong);

    @Deprecated
    void hmac_update(Pointer pointer, Pointer pointer2, NativeLong nativeLong);

    @Deprecated
    int match_hostname(Pointer pointer, Pointer pointer2, int i);

    int match_hostname(String str, String str2, int i);

    @Deprecated
    int match_pattern_list(Pointer pointer, Pointer pointer2, int i, int i2);

    int match_pattern_list(String str, String str2, int i, int i2);

    @Deprecated
    void md5_final(Pointer pointer, Pointer pointer2);

    void md5_final(ByteBuffer byteBuffer, MD5CTX md5ctx);

    MD5CTX md5_init();

    void md5_update(MD5CTX md5ctx, Pointer pointer, NativeLong nativeLong);

    @Deprecated
    void md5_update(Pointer pointer, Pointer pointer2, NativeLong nativeLong);

    @Deprecated
    ssh_signature_struct pki_do_sign(ssh_key_struct ssh_key_structVar, Pointer pointer, NativeSize nativeSize, int i);

    ssh_signature_struct pki_do_sign(ssh_key_struct ssh_key_structVar, byte[] bArr, NativeSize nativeSize, int i);

    @Deprecated
    ssh_signature_struct pki_do_sign_hash(ssh_key_struct ssh_key_structVar, Pointer pointer, NativeSize nativeSize, int i);

    ssh_signature_struct pki_do_sign_hash(ssh_key_struct ssh_key_structVar, byte[] bArr, NativeSize nativeSize, int i);

    int pki_ed25519_key_cmp(ssh_key_struct ssh_key_structVar, ssh_key_struct ssh_key_structVar2, int i);

    int pki_ed25519_key_dup(ssh_key_struct ssh_key_structVar, ssh_key_struct ssh_key_structVar2);

    int pki_ed25519_public_key_to_blob(ssh_buffer ssh_bufferVar, ssh_key_struct ssh_key_structVar);

    @Deprecated
    int pki_ed25519_public_key_to_blob(Pointer pointer, ssh_key_struct ssh_key_structVar);

    @Deprecated
    int pki_ed25519_sign(ssh_key_struct ssh_key_structVar, ssh_signature_struct ssh_signature_structVar, Pointer pointer, NativeSize nativeSize);

    int pki_ed25519_sign(ssh_key_struct ssh_key_structVar, ssh_signature_struct ssh_signature_structVar, byte[] bArr, NativeSize nativeSize);

    ssh_string_struct pki_ed25519_signature_to_blob(ssh_signature_struct ssh_signature_structVar);

    @Deprecated
    int pki_ed25519_verify(ssh_key_struct ssh_key_structVar, ssh_signature_struct ssh_signature_structVar, Pointer pointer, NativeSize nativeSize);

    int pki_ed25519_verify(ssh_key_struct ssh_key_structVar, ssh_signature_struct ssh_signature_structVar, byte[] bArr, NativeSize nativeSize);

    int pki_import_privkey_buffer(int i, ssh_buffer ssh_bufferVar, ssh_key_struct.ByReference[] byReferenceArr);

    @Deprecated
    int pki_import_privkey_buffer(int i, Pointer pointer, PointerByReference pointerByReference);

    int pki_import_privkey_buffer(int i, Pointer pointer, ssh_key_struct.ByReference[] byReferenceArr);

    int pki_key_check_hash_compatible(ssh_key_struct ssh_key_structVar, int i);

    int pki_key_compare(ssh_key_struct ssh_key_structVar, ssh_key_struct ssh_key_structVar2, int i);

    ssh_key_struct pki_key_dup(ssh_key_struct ssh_key_structVar, int i);

    @Deprecated
    int pki_key_ecdsa_nid_from_name(Pointer pointer);

    int pki_key_ecdsa_nid_from_name(String str);

    String pki_key_ecdsa_nid_to_name(int i);

    int pki_key_generate_dss(ssh_key_struct ssh_key_structVar, int i);

    int pki_key_generate_ecdsa(ssh_key_struct ssh_key_structVar, int i);

    int pki_key_generate_ed25519(ssh_key_struct ssh_key_structVar);

    int pki_key_generate_rsa(ssh_key_struct ssh_key_structVar, int i);

    @Deprecated
    ssh_key_struct pki_private_key_from_base64(Pointer pointer, Pointer pointer2, ssh_auth_callback ssh_auth_callbackVar, Pointer pointer3);

    ssh_key_struct pki_private_key_from_base64(String str, String str2, ssh_auth_callback ssh_auth_callbackVar, Pointer pointer);

    @Deprecated
    ssh_string_struct pki_private_key_to_pem(ssh_key_struct ssh_key_structVar, Pointer pointer, ssh_auth_callback ssh_auth_callbackVar, Pointer pointer2);

    ssh_string_struct pki_private_key_to_pem(ssh_key_struct ssh_key_structVar, String str, ssh_auth_callback ssh_auth_callbackVar, Pointer pointer);

    @Deprecated
    int pki_privatekey_type_from_string(Pointer pointer);

    int pki_privatekey_type_from_string(String str);

    int pki_privkey_build_dss(ssh_key_struct ssh_key_structVar, ssh_string_struct ssh_string_structVar, ssh_string_struct ssh_string_structVar2, ssh_string_struct ssh_string_structVar3, ssh_string_struct ssh_string_structVar4, ssh_string_struct ssh_string_structVar5);

    int pki_privkey_build_ecdsa(ssh_key_struct ssh_key_structVar, int i, ssh_string_struct ssh_string_structVar, ssh_string_struct ssh_string_structVar2);

    int pki_privkey_build_ed25519(ssh_key_struct ssh_key_structVar, ssh_string_struct ssh_string_structVar, ssh_string_struct ssh_string_structVar2);

    int pki_privkey_build_rsa(ssh_key_struct ssh_key_structVar, ssh_string_struct ssh_string_structVar, ssh_string_struct ssh_string_structVar2, ssh_string_struct ssh_string_structVar3, ssh_string_struct ssh_string_structVar4, ssh_string_struct ssh_string_structVar5, ssh_string_struct ssh_string_structVar6);

    int pki_pubkey_build_dss(ssh_key_struct ssh_key_structVar, ssh_string_struct ssh_string_structVar, ssh_string_struct ssh_string_structVar2, ssh_string_struct ssh_string_structVar3, ssh_string_struct ssh_string_structVar4);

    int pki_pubkey_build_ecdsa(ssh_key_struct ssh_key_structVar, int i, ssh_string_struct ssh_string_structVar);

    int pki_pubkey_build_rsa(ssh_key_struct ssh_key_structVar, ssh_string_struct ssh_string_structVar, ssh_string_struct ssh_string_structVar2);

    ssh_string_struct pki_publickey_to_blob(ssh_key_struct ssh_key_structVar);

    @Deprecated
    ssh_signature_struct pki_sign_data(ssh_key_struct ssh_key_structVar, int i, Pointer pointer, NativeSize nativeSize);

    ssh_signature_struct pki_sign_data(ssh_key_struct ssh_key_structVar, int i, byte[] bArr, NativeSize nativeSize);

    ssh_signature_struct pki_signature_from_blob(ssh_key_struct ssh_key_structVar, ssh_string_struct ssh_string_structVar, int i, int i2);

    int pki_signature_from_ed25519_blob(ssh_signature_struct ssh_signature_structVar, ssh_string_struct ssh_string_structVar);

    ssh_string_struct pki_signature_to_blob(ssh_signature_struct ssh_signature_structVar);

    @Deprecated
    int pki_verify_data_signature(ssh_signature_struct ssh_signature_structVar, ssh_key_struct ssh_key_structVar, Pointer pointer, NativeSize nativeSize);

    int pki_verify_data_signature(ssh_signature_struct ssh_signature_structVar, ssh_key_struct ssh_key_structVar, byte[] bArr, NativeSize nativeSize);

    void privatekey_free(ssh_private_key ssh_private_keyVar);

    @Deprecated
    void privatekey_free(Pointer pointer);

    ssh_private_key privatekey_from_file(ssh_session ssh_sessionVar, String str, int i, String str2);

    @Deprecated
    ssh_private_key privatekey_from_file(Pointer pointer, Pointer pointer2, int i, Pointer pointer3);

    void publickey_free(ssh_public_key ssh_public_keyVar);

    @Deprecated
    void publickey_free(Pointer pointer);

    ssh_string_struct publickey_from_file(ssh_session ssh_sessionVar, String str, IntBuffer intBuffer);

    @Deprecated
    ssh_string_struct publickey_from_file(Pointer pointer, Pointer pointer2, IntByReference intByReference);

    ssh_public_key publickey_from_privatekey(ssh_private_key ssh_private_keyVar);

    @Deprecated
    ssh_public_key publickey_from_privatekey(Pointer pointer);

    ssh_string_struct publickey_to_string(ssh_public_key ssh_public_keyVar);

    @Deprecated
    ssh_string_struct publickey_to_string(Pointer pointer);

    int server_set_kex(ssh_session ssh_sessionVar);

    @Deprecated
    int server_set_kex(Pointer pointer);

    int sftp_async_read(sftp_file_struct sftp_file_structVar, Pointer pointer, int i, int i2);

    int sftp_async_read_begin(sftp_file_struct sftp_file_structVar, int i);

    void sftp_attributes_free(sftp_attributes_struct sftp_attributes_structVar);

    @Deprecated
    Pointer sftp_canonicalize_path(sftp_session_struct sftp_session_structVar, Pointer pointer);

    Pointer sftp_canonicalize_path(sftp_session_struct sftp_session_structVar, String str);

    @Deprecated
    int sftp_chmod(sftp_session_struct sftp_session_structVar, Pointer pointer, int i);

    int sftp_chmod(sftp_session_struct sftp_session_structVar, String str, int i);

    @Deprecated
    int sftp_chown(sftp_session_struct sftp_session_structVar, Pointer pointer, int i, int i2);

    int sftp_chown(sftp_session_struct sftp_session_structVar, String str, int i, int i2);

    void sftp_client_message_free(sftp_client_message_struct sftp_client_message_structVar);

    String sftp_client_message_get_data(sftp_client_message_struct sftp_client_message_structVar);

    String sftp_client_message_get_filename(sftp_client_message_struct sftp_client_message_structVar);

    int sftp_client_message_get_flags(sftp_client_message_struct sftp_client_message_structVar);

    String sftp_client_message_get_submessage(sftp_client_message_struct sftp_client_message_structVar);

    byte sftp_client_message_get_type(sftp_client_message_struct sftp_client_message_structVar);

    @Deprecated
    void sftp_client_message_set_filename(sftp_client_message_struct sftp_client_message_structVar, Pointer pointer);

    void sftp_client_message_set_filename(sftp_client_message_struct sftp_client_message_structVar, String str);

    int sftp_close(sftp_file_struct sftp_file_structVar);

    int sftp_closedir(sftp_dir_struct sftp_dir_structVar);

    int sftp_dir_eof(sftp_dir_struct sftp_dir_structVar);

    @Deprecated
    int sftp_extension_supported(sftp_session_struct sftp_session_structVar, Pointer pointer, Pointer pointer2);

    int sftp_extension_supported(sftp_session_struct sftp_session_structVar, String str, String str2);

    int sftp_extensions_get_count(sftp_session_struct sftp_session_structVar);

    String sftp_extensions_get_data(sftp_session_struct sftp_session_structVar, int i);

    String sftp_extensions_get_name(sftp_session_struct sftp_session_structVar, int i);

    void sftp_file_set_blocking(sftp_file_struct sftp_file_structVar);

    void sftp_file_set_nonblocking(sftp_file_struct sftp_file_structVar);

    void sftp_free(sftp_session_struct sftp_session_structVar);

    sftp_attributes_struct sftp_fstat(sftp_file_struct sftp_file_structVar);

    sftp_statvfs_struct sftp_fstatvfs(sftp_file_struct sftp_file_structVar);

    int sftp_fsync(sftp_file_struct sftp_file_structVar);

    sftp_client_message_struct sftp_get_client_message(sftp_session_struct sftp_session_structVar);

    int sftp_get_error(sftp_session_struct sftp_session_structVar);

    Pointer sftp_handle(sftp_session_struct sftp_session_structVar, ssh_string_struct ssh_string_structVar);

    ssh_string_struct sftp_handle_alloc(sftp_session_struct sftp_session_structVar, Pointer pointer);

    void sftp_handle_remove(sftp_session_struct sftp_session_structVar, Pointer pointer);

    int sftp_init(sftp_session_struct sftp_session_structVar);

    @Deprecated
    sftp_attributes_struct sftp_lstat(sftp_session_struct sftp_session_structVar, Pointer pointer);

    sftp_attributes_struct sftp_lstat(sftp_session_struct sftp_session_structVar, String str);

    @Deprecated
    int sftp_mkdir(sftp_session_struct sftp_session_structVar, Pointer pointer, int i);

    int sftp_mkdir(sftp_session_struct sftp_session_structVar, String str, int i);

    sftp_session_struct sftp_new(ssh_session ssh_sessionVar);

    @Deprecated
    sftp_session_struct sftp_new(Pointer pointer);

    sftp_session_struct sftp_new_channel(ssh_session ssh_sessionVar, ssh_channel ssh_channelVar);

    @Deprecated
    sftp_session_struct sftp_new_channel(Pointer pointer, Pointer pointer2);

    @Deprecated
    sftp_file_struct sftp_open(sftp_session_struct sftp_session_structVar, Pointer pointer, int i, int i2);

    sftp_file_struct sftp_open(sftp_session_struct sftp_session_structVar, String str, int i, int i2);

    @Deprecated
    sftp_dir_struct sftp_opendir(sftp_session_struct sftp_session_structVar, Pointer pointer);

    sftp_dir_struct sftp_opendir(sftp_session_struct sftp_session_structVar, String str);

    void sftp_packet_free(sftp_packet_struct sftp_packet_structVar);

    sftp_packet_struct sftp_packet_read(sftp_session_struct sftp_session_structVar);

    NativeSize sftp_packet_write(sftp_session_struct sftp_session_structVar, byte b, ssh_buffer ssh_bufferVar);

    @Deprecated
    NativeSize sftp_packet_write(sftp_session_struct sftp_session_structVar, byte b, Pointer pointer);

    sftp_attributes_struct sftp_parse_attr(sftp_session_struct sftp_session_structVar, ssh_buffer ssh_bufferVar, int i);

    @Deprecated
    sftp_attributes_struct sftp_parse_attr(sftp_session_struct sftp_session_structVar, Pointer pointer, int i);

    NativeSize sftp_read(sftp_file_struct sftp_file_structVar, Pointer pointer, NativeSize nativeSize);

    sftp_attributes_struct sftp_readdir(sftp_session_struct sftp_session_structVar, sftp_dir_struct sftp_dir_structVar);

    @Deprecated
    Pointer sftp_readlink(sftp_session_struct sftp_session_structVar, Pointer pointer);

    Pointer sftp_readlink(sftp_session_struct sftp_session_structVar, String str);

    @Deprecated
    int sftp_rename(sftp_session_struct sftp_session_structVar, Pointer pointer, Pointer pointer2);

    int sftp_rename(sftp_session_struct sftp_session_structVar, String str, String str2);

    int sftp_reply_attr(sftp_client_message_struct sftp_client_message_structVar, sftp_attributes_struct sftp_attributes_structVar);

    int sftp_reply_data(sftp_client_message_struct sftp_client_message_structVar, Pointer pointer, int i);

    int sftp_reply_handle(sftp_client_message_struct sftp_client_message_structVar, ssh_string_struct ssh_string_structVar);

    @Deprecated
    int sftp_reply_name(sftp_client_message_struct sftp_client_message_structVar, Pointer pointer, sftp_attributes_struct sftp_attributes_structVar);

    int sftp_reply_name(sftp_client_message_struct sftp_client_message_structVar, String str, sftp_attributes_struct sftp_attributes_structVar);

    int sftp_reply_names(sftp_client_message_struct sftp_client_message_structVar);

    @Deprecated
    int sftp_reply_names_add(sftp_client_message_struct sftp_client_message_structVar, Pointer pointer, Pointer pointer2, sftp_attributes_struct sftp_attributes_structVar);

    int sftp_reply_names_add(sftp_client_message_struct sftp_client_message_structVar, String str, String str2, sftp_attributes_struct sftp_attributes_structVar);

    @Deprecated
    int sftp_reply_status(sftp_client_message_struct sftp_client_message_structVar, int i, Pointer pointer);

    int sftp_reply_status(sftp_client_message_struct sftp_client_message_structVar, int i, String str);

    void sftp_rewind(sftp_file_struct sftp_file_structVar);

    @Deprecated
    int sftp_rmdir(sftp_session_struct sftp_session_structVar, Pointer pointer);

    int sftp_rmdir(sftp_session_struct sftp_session_structVar, String str);

    int sftp_seek(sftp_file_struct sftp_file_structVar, int i);

    int sftp_seek64(sftp_file_struct sftp_file_structVar, long j);

    int sftp_send_client_message(sftp_session_struct sftp_session_structVar, sftp_client_message_struct sftp_client_message_structVar);

    void sftp_server_free(sftp_session_struct sftp_session_structVar);

    int sftp_server_init(sftp_session_struct sftp_session_structVar);

    sftp_session_struct sftp_server_new(ssh_session ssh_sessionVar, ssh_channel ssh_channelVar);

    @Deprecated
    sftp_session_struct sftp_server_new(Pointer pointer, Pointer pointer2);

    int sftp_server_version(sftp_session_struct sftp_session_structVar);

    @Deprecated
    int sftp_setstat(sftp_session_struct sftp_session_structVar, Pointer pointer, sftp_attributes_struct sftp_attributes_structVar);

    int sftp_setstat(sftp_session_struct sftp_session_structVar, String str, sftp_attributes_struct sftp_attributes_structVar);

    @Deprecated
    sftp_attributes_struct sftp_stat(sftp_session_struct sftp_session_structVar, Pointer pointer);

    sftp_attributes_struct sftp_stat(sftp_session_struct sftp_session_structVar, String str);

    @Deprecated
    sftp_statvfs_struct sftp_statvfs(sftp_session_struct sftp_session_structVar, Pointer pointer);

    sftp_statvfs_struct sftp_statvfs(sftp_session_struct sftp_session_structVar, String str);

    void sftp_statvfs_free(sftp_statvfs_struct sftp_statvfs_structVar);

    @Deprecated
    int sftp_symlink(sftp_session_struct sftp_session_structVar, Pointer pointer, Pointer pointer2);

    int sftp_symlink(sftp_session_struct sftp_session_structVar, String str, String str2);

    NativeLong sftp_tell(sftp_file_struct sftp_file_structVar);

    long sftp_tell64(sftp_file_struct sftp_file_structVar);

    @Deprecated
    int sftp_unlink(sftp_session_struct sftp_session_structVar, Pointer pointer);

    int sftp_unlink(sftp_session_struct sftp_session_structVar, String str);

    @Deprecated
    int sftp_utimes(sftp_session_struct sftp_session_structVar, Pointer pointer, timeval timevalVar);

    int sftp_utimes(sftp_session_struct sftp_session_structVar, String str, timeval timevalVar);

    NativeSize sftp_write(sftp_file_struct sftp_file_structVar, Pointer pointer, NativeSize nativeSize);

    @Deprecated
    void sha1(Pointer pointer, int i, Pointer pointer2);

    void sha1(byte[] bArr, int i, ByteBuffer byteBuffer);

    @Deprecated
    void sha1_final(Pointer pointer, Pointer pointer2);

    void sha1_final(ByteBuffer byteBuffer, SHACTX shactx);

    SHACTX sha1_init();

    void sha1_update(SHACTX shactx, Pointer pointer, NativeLong nativeLong);

    @Deprecated
    void sha1_update(Pointer pointer, Pointer pointer2, NativeLong nativeLong);

    @Deprecated
    void sha256(Pointer pointer, int i, Pointer pointer2);

    void sha256(byte[] bArr, int i, ByteBuffer byteBuffer);

    @Deprecated
    void sha256_final(Pointer pointer, Pointer pointer2);

    void sha256_final(ByteBuffer byteBuffer, SHA256CTX sha256ctx);

    SHA256CTX sha256_init();

    void sha256_update(SHA256CTX sha256ctx, Pointer pointer, NativeLong nativeLong);

    @Deprecated
    void sha256_update(Pointer pointer, Pointer pointer2, NativeLong nativeLong);

    @Deprecated
    void sha384(Pointer pointer, int i, Pointer pointer2);

    void sha384(byte[] bArr, int i, ByteBuffer byteBuffer);

    @Deprecated
    void sha384_final(Pointer pointer, Pointer pointer2);

    void sha384_final(ByteBuffer byteBuffer, SHA384CTX sha384ctx);

    SHA384CTX sha384_init();

    void sha384_update(SHA384CTX sha384ctx, Pointer pointer, NativeLong nativeLong);

    @Deprecated
    void sha384_update(Pointer pointer, Pointer pointer2, NativeLong nativeLong);

    @Deprecated
    void sha512(Pointer pointer, int i, Pointer pointer2);

    void sha512(byte[] bArr, int i, ByteBuffer byteBuffer);

    @Deprecated
    void sha512_final(Pointer pointer, Pointer pointer2);

    void sha512_final(ByteBuffer byteBuffer, SHA512CTX sha512ctx);

    SHA512CTX sha512_init();

    void sha512_update(SHA512CTX sha512ctx, Pointer pointer, NativeLong nativeLong);

    @Deprecated
    void sha512_update(Pointer pointer, Pointer pointer2, NativeLong nativeLong);

    int ssh_accept(ssh_session ssh_sessionVar);

    @Deprecated
    int ssh_accept(Pointer pointer);

    int ssh_add_channel_callbacks(ssh_channel ssh_channelVar, ssh_channel_callbacks_struct ssh_channel_callbacks_structVar);

    @Deprecated
    int ssh_add_channel_callbacks(Pointer pointer, ssh_channel_callbacks_struct ssh_channel_callbacks_structVar);

    void ssh_agent_close(ssh_agent_struct ssh_agent_structVar);

    void ssh_agent_free(ssh_agent_struct ssh_agent_structVar);

    ssh_key_struct ssh_agent_get_first_ident(ssh_session_struct ssh_session_structVar, PointerByReference pointerByReference);

    int ssh_agent_get_ident_count(ssh_session_struct ssh_session_structVar);

    ssh_key_struct ssh_agent_get_next_ident(ssh_session_struct ssh_session_structVar, PointerByReference pointerByReference);

    int ssh_agent_is_running(ssh_session_struct ssh_session_structVar);

    ssh_agent_struct ssh_agent_new(ssh_session_struct ssh_session_structVar);

    ssh_string_struct ssh_agent_sign_data(ssh_session ssh_sessionVar, ssh_key_struct ssh_key_structVar, ssh_buffer_struct ssh_buffer_structVar);

    @Deprecated
    ssh_string_struct ssh_agent_sign_data(Pointer pointer, ssh_key_struct ssh_key_structVar, ssh_buffer_struct ssh_buffer_structVar);

    void ssh_agent_state_free(Pointer pointer);

    int ssh_auth_list(ssh_session ssh_sessionVar);

    @Deprecated
    int ssh_auth_list(Pointer pointer);

    int ssh_auth_reply_default(ssh_session ssh_sessionVar, int i);

    @Deprecated
    int ssh_auth_reply_default(Pointer pointer, int i);

    int ssh_auth_reply_success(ssh_session ssh_sessionVar, int i);

    @Deprecated
    int ssh_auth_reply_success(Pointer pointer, int i);

    @Deprecated
    Pointer ssh_basename(Pointer pointer);

    Pointer ssh_basename(String str);

    int ssh_bind_accept(ssh_bind ssh_bindVar, ssh_session ssh_sessionVar);

    @Deprecated
    int ssh_bind_accept(Pointer pointer, Pointer pointer2);

    int ssh_bind_accept_fd(ssh_bind ssh_bindVar, ssh_session ssh_sessionVar, int i);

    @Deprecated
    int ssh_bind_accept_fd(Pointer pointer, Pointer pointer2, int i);

    void ssh_bind_fd_toaccept(ssh_bind ssh_bindVar);

    @Deprecated
    void ssh_bind_fd_toaccept(Pointer pointer);

    void ssh_bind_free(ssh_bind ssh_bindVar);

    @Deprecated
    void ssh_bind_free(Pointer pointer);

    int ssh_bind_get_fd(ssh_bind ssh_bindVar);

    @Deprecated
    int ssh_bind_get_fd(Pointer pointer);

    int ssh_bind_listen(ssh_bind ssh_bindVar);

    @Deprecated
    int ssh_bind_listen(Pointer pointer);

    ssh_bind ssh_bind_new();

    int ssh_bind_options_parse_config(ssh_bind ssh_bindVar, String str);

    @Deprecated
    int ssh_bind_options_parse_config(Pointer pointer, Pointer pointer2);

    int ssh_bind_options_set(ssh_bind ssh_bindVar, int i, Pointer pointer);

    @Deprecated
    int ssh_bind_options_set(Pointer pointer, int i, Pointer pointer2);

    void ssh_bind_set_blocking(ssh_bind ssh_bindVar, int i);

    @Deprecated
    void ssh_bind_set_blocking(Pointer pointer, int i);

    int ssh_bind_set_callbacks(ssh_bind ssh_bindVar, ssh_bind_callbacks_struct ssh_bind_callbacks_structVar, Pointer pointer);

    @Deprecated
    int ssh_bind_set_callbacks(Pointer pointer, ssh_bind_callbacks_struct ssh_bind_callbacks_structVar, Pointer pointer2);

    void ssh_bind_set_fd(ssh_bind ssh_bindVar, int i);

    @Deprecated
    void ssh_bind_set_fd(Pointer pointer, int i);

    int ssh_blocking_flush(ssh_session ssh_sessionVar, int i);

    @Deprecated
    int ssh_blocking_flush(Pointer pointer, int i);

    int ssh_buffer_add_data(ssh_buffer ssh_bufferVar, Pointer pointer, int i);

    @Deprecated
    int ssh_buffer_add_data(Pointer pointer, Pointer pointer2, int i);

    void ssh_buffer_free(ssh_buffer ssh_bufferVar);

    @Deprecated
    void ssh_buffer_free(Pointer pointer);

    Pointer ssh_buffer_get(ssh_buffer ssh_bufferVar);

    @Deprecated
    Pointer ssh_buffer_get(Pointer pointer);

    int ssh_buffer_get_data(ssh_buffer ssh_bufferVar, Pointer pointer, int i);

    @Deprecated
    int ssh_buffer_get_data(Pointer pointer, Pointer pointer2, int i);

    int ssh_buffer_get_len(ssh_buffer ssh_bufferVar);

    @Deprecated
    int ssh_buffer_get_len(Pointer pointer);

    ssh_buffer ssh_buffer_new();

    int ssh_buffer_reinit(ssh_buffer ssh_bufferVar);

    @Deprecated
    int ssh_buffer_reinit(Pointer pointer);

    ssh_channel ssh_channel_accept_forward(ssh_session ssh_sessionVar, int i, IntBuffer intBuffer);

    @Deprecated
    ssh_channel ssh_channel_accept_forward(Pointer pointer, int i, IntByReference intByReference);

    ssh_channel ssh_channel_accept_x11(ssh_channel ssh_channelVar, int i);

    @Deprecated
    ssh_channel ssh_channel_accept_x11(Pointer pointer, int i);

    int ssh_channel_cancel_forward(ssh_session ssh_sessionVar, String str, int i);

    @Deprecated
    int ssh_channel_cancel_forward(Pointer pointer, Pointer pointer2, int i);

    int ssh_channel_change_pty_size(ssh_channel ssh_channelVar, int i, int i2);

    @Deprecated
    int ssh_channel_change_pty_size(Pointer pointer, int i, int i2);

    int ssh_channel_close(ssh_channel ssh_channelVar);

    @Deprecated
    int ssh_channel_close(Pointer pointer);

    void ssh_channel_free(ssh_channel ssh_channelVar);

    @Deprecated
    void ssh_channel_free(Pointer pointer);

    int ssh_channel_get_exit_status(ssh_channel ssh_channelVar);

    @Deprecated
    int ssh_channel_get_exit_status(Pointer pointer);

    ssh_session ssh_channel_get_session(ssh_channel ssh_channelVar);

    @Deprecated
    ssh_session ssh_channel_get_session(Pointer pointer);

    int ssh_channel_is_closed(ssh_channel ssh_channelVar);

    @Deprecated
    int ssh_channel_is_closed(Pointer pointer);

    int ssh_channel_is_eof(ssh_channel ssh_channelVar);

    @Deprecated
    int ssh_channel_is_eof(Pointer pointer);

    int ssh_channel_is_open(ssh_channel ssh_channelVar);

    @Deprecated
    int ssh_channel_is_open(Pointer pointer);

    int ssh_channel_listen_forward(ssh_session ssh_sessionVar, String str, int i, IntBuffer intBuffer);

    @Deprecated
    int ssh_channel_listen_forward(Pointer pointer, Pointer pointer2, int i, IntByReference intByReference);

    ssh_channel ssh_channel_new(ssh_session ssh_sessionVar);

    @Deprecated
    ssh_channel ssh_channel_new(Pointer pointer);

    int ssh_channel_open_auth_agent(ssh_channel ssh_channelVar);

    @Deprecated
    int ssh_channel_open_auth_agent(Pointer pointer);

    int ssh_channel_open_forward(ssh_channel ssh_channelVar, String str, int i, String str2, int i2);

    @Deprecated
    int ssh_channel_open_forward(Pointer pointer, Pointer pointer2, int i, Pointer pointer3, int i2);

    int ssh_channel_open_forward_unix(ssh_channel ssh_channelVar, String str, String str2, int i);

    @Deprecated
    int ssh_channel_open_forward_unix(Pointer pointer, Pointer pointer2, Pointer pointer3, int i);

    int ssh_channel_open_reverse_forward(ssh_channel ssh_channelVar, String str, int i, String str2, int i2);

    @Deprecated
    int ssh_channel_open_reverse_forward(Pointer pointer, Pointer pointer2, int i, Pointer pointer3, int i2);

    int ssh_channel_open_session(ssh_channel ssh_channelVar);

    @Deprecated
    int ssh_channel_open_session(Pointer pointer);

    int ssh_channel_open_x11(ssh_channel ssh_channelVar, String str, int i);

    @Deprecated
    int ssh_channel_open_x11(Pointer pointer, Pointer pointer2, int i);

    int ssh_channel_poll(ssh_channel ssh_channelVar, int i);

    @Deprecated
    int ssh_channel_poll(Pointer pointer, int i);

    int ssh_channel_poll_timeout(ssh_channel ssh_channelVar, int i, int i2);

    @Deprecated
    int ssh_channel_poll_timeout(Pointer pointer, int i, int i2);

    int ssh_channel_read(ssh_channel ssh_channelVar, Pointer pointer, int i, int i2);

    @Deprecated
    int ssh_channel_read(Pointer pointer, Pointer pointer2, int i, int i2);

    int ssh_channel_read_nonblocking(ssh_channel ssh_channelVar, Pointer pointer, int i, int i2);

    @Deprecated
    int ssh_channel_read_nonblocking(Pointer pointer, Pointer pointer2, int i, int i2);

    int ssh_channel_read_timeout(ssh_channel ssh_channelVar, Pointer pointer, int i, int i2, int i3);

    @Deprecated
    int ssh_channel_read_timeout(Pointer pointer, Pointer pointer2, int i, int i2, int i3);

    int ssh_channel_request_auth_agent(ssh_channel ssh_channelVar);

    @Deprecated
    int ssh_channel_request_auth_agent(Pointer pointer);

    int ssh_channel_request_env(ssh_channel ssh_channelVar, String str, String str2);

    @Deprecated
    int ssh_channel_request_env(Pointer pointer, Pointer pointer2, Pointer pointer3);

    int ssh_channel_request_exec(ssh_channel ssh_channelVar, String str);

    @Deprecated
    int ssh_channel_request_exec(Pointer pointer, Pointer pointer2);

    int ssh_channel_request_pty(ssh_channel ssh_channelVar);

    @Deprecated
    int ssh_channel_request_pty(Pointer pointer);

    int ssh_channel_request_pty_size(ssh_channel ssh_channelVar, String str, int i, int i2);

    @Deprecated
    int ssh_channel_request_pty_size(Pointer pointer, Pointer pointer2, int i, int i2);

    int ssh_channel_request_send_break(ssh_channel ssh_channelVar, int i);

    @Deprecated
    int ssh_channel_request_send_break(Pointer pointer, int i);

    int ssh_channel_request_send_exit_signal(ssh_channel ssh_channelVar, String str, int i, String str2, String str3);

    @Deprecated
    int ssh_channel_request_send_exit_signal(Pointer pointer, Pointer pointer2, int i, Pointer pointer3, Pointer pointer4);

    int ssh_channel_request_send_exit_status(ssh_channel ssh_channelVar, int i);

    @Deprecated
    int ssh_channel_request_send_exit_status(Pointer pointer, int i);

    int ssh_channel_request_send_signal(ssh_channel ssh_channelVar, String str);

    @Deprecated
    int ssh_channel_request_send_signal(Pointer pointer, Pointer pointer2);

    int ssh_channel_request_sftp(ssh_channel ssh_channelVar);

    @Deprecated
    int ssh_channel_request_sftp(Pointer pointer);

    int ssh_channel_request_shell(ssh_channel ssh_channelVar);

    @Deprecated
    int ssh_channel_request_shell(Pointer pointer);

    int ssh_channel_request_subsystem(ssh_channel ssh_channelVar, String str);

    @Deprecated
    int ssh_channel_request_subsystem(Pointer pointer, Pointer pointer2);

    int ssh_channel_request_x11(ssh_channel ssh_channelVar, int i, String str, String str2, int i2);

    @Deprecated
    int ssh_channel_request_x11(Pointer pointer, int i, Pointer pointer2, Pointer pointer3, int i2);

    @Deprecated
    int ssh_channel_select(Pointer pointer, Pointer pointer2, Pointer pointer3, timeval timevalVar);

    int ssh_channel_select(PointerByReference pointerByReference, PointerByReference pointerByReference2, PointerByReference pointerByReference3, timeval timevalVar);

    int ssh_channel_send_eof(ssh_channel ssh_channelVar);

    @Deprecated
    int ssh_channel_send_eof(Pointer pointer);

    void ssh_channel_set_blocking(ssh_channel ssh_channelVar, int i);

    @Deprecated
    void ssh_channel_set_blocking(Pointer pointer, int i);

    void ssh_channel_set_counter(ssh_channel ssh_channelVar, ssh_counter_struct ssh_counter_structVar);

    @Deprecated
    void ssh_channel_set_counter(Pointer pointer, ssh_counter_struct ssh_counter_structVar);

    int ssh_channel_window_size(ssh_channel ssh_channelVar);

    @Deprecated
    int ssh_channel_window_size(Pointer pointer);

    int ssh_channel_write(ssh_channel ssh_channelVar, Pointer pointer, int i);

    @Deprecated
    int ssh_channel_write(Pointer pointer, Pointer pointer2, int i);

    int ssh_channel_write_stderr(ssh_channel ssh_channelVar, Pointer pointer, int i);

    @Deprecated
    int ssh_channel_write_stderr(Pointer pointer, Pointer pointer2, int i);

    void ssh_cipher_clear(ssh_cipher_struct ssh_cipher_structVar);

    void ssh_clean_pubkey_hash(PointerByReference pointerByReference);

    int ssh_client_curve25519_init(ssh_session ssh_sessionVar);

    @Deprecated
    int ssh_client_curve25519_init(Pointer pointer);

    int ssh_client_dh_init(ssh_session ssh_sessionVar);

    @Deprecated
    int ssh_client_dh_init(Pointer pointer);

    int ssh_client_ecdh_init(ssh_session ssh_sessionVar);

    @Deprecated
    int ssh_client_ecdh_init(Pointer pointer);

    Pointer ssh_client_select_hostkeys(ssh_session ssh_sessionVar);

    @Deprecated
    Pointer ssh_client_select_hostkeys(Pointer pointer);

    int ssh_connect(ssh_session ssh_sessionVar);

    @Deprecated
    int ssh_connect(Pointer pointer);

    int ssh_connect_host_nonblocking(ssh_session ssh_sessionVar, String str, String str2, int i);

    @Deprecated
    int ssh_connect_host_nonblocking(Pointer pointer, Pointer pointer2, Pointer pointer3, int i);

    void ssh_connector_free(ssh_connector ssh_connectorVar);

    @Deprecated
    void ssh_connector_free(Pointer pointer);

    ssh_connector ssh_connector_new(ssh_session ssh_sessionVar);

    @Deprecated
    ssh_connector ssh_connector_new(Pointer pointer);

    int ssh_connector_remove_event(ssh_connector ssh_connectorVar);

    @Deprecated
    int ssh_connector_remove_event(Pointer pointer);

    int ssh_connector_set_event(ssh_connector ssh_connectorVar, ssh_event ssh_eventVar);

    @Deprecated
    int ssh_connector_set_event(Pointer pointer, Pointer pointer2);

    int ssh_connector_set_in_channel(ssh_connector ssh_connectorVar, ssh_channel ssh_channelVar, int i);

    @Deprecated
    int ssh_connector_set_in_channel(Pointer pointer, Pointer pointer2, int i);

    void ssh_connector_set_in_fd(ssh_connector ssh_connectorVar, int i);

    @Deprecated
    void ssh_connector_set_in_fd(Pointer pointer, int i);

    int ssh_connector_set_out_channel(ssh_connector ssh_connectorVar, ssh_channel ssh_channelVar, int i);

    @Deprecated
    int ssh_connector_set_out_channel(Pointer pointer, Pointer pointer2, int i);

    void ssh_connector_set_out_fd(ssh_connector ssh_connectorVar, int i);

    @Deprecated
    void ssh_connector_set_out_fd(Pointer pointer, int i);

    String ssh_copyright();

    void ssh_crypto_finalize();

    int ssh_crypto_init();

    void ssh_dh_cleanup(ssh_crypto_struct ssh_crypto_structVar);

    @Deprecated
    int ssh_dh_compute_shared_secret(dh_ctx dh_ctxVar, int i, int i2, Pointer pointer);

    int ssh_dh_compute_shared_secret(dh_ctx dh_ctxVar, int i, int i2, PointerByReference pointerByReference);

    void ssh_dh_debug_crypto(ssh_crypto_struct ssh_crypto_structVar);

    void ssh_dh_finalize();

    ssh_key_struct ssh_dh_get_current_server_publickey(ssh_session ssh_sessionVar);

    @Deprecated
    ssh_key_struct ssh_dh_get_current_server_publickey(Pointer pointer);

    int ssh_dh_get_current_server_publickey_blob(ssh_session ssh_sessionVar, ssh_string_struct.ByReference[] byReferenceArr);

    @Deprecated
    int ssh_dh_get_current_server_publickey_blob(Pointer pointer, PointerByReference pointerByReference);

    int ssh_dh_get_current_server_publickey_blob(Pointer pointer, ssh_string_struct.ByReference[] byReferenceArr);

    ssh_key_struct ssh_dh_get_next_server_publickey(ssh_session ssh_sessionVar);

    @Deprecated
    ssh_key_struct ssh_dh_get_next_server_publickey(Pointer pointer);

    int ssh_dh_get_next_server_publickey_blob(ssh_session ssh_sessionVar, ssh_string_struct.ByReference[] byReferenceArr);

    @Deprecated
    int ssh_dh_get_next_server_publickey_blob(Pointer pointer, PointerByReference pointerByReference);

    int ssh_dh_get_next_server_publickey_blob(Pointer pointer, ssh_string_struct.ByReference[] byReferenceArr);

    @Deprecated
    int ssh_dh_get_parameters(dh_ctx dh_ctxVar, Pointer pointer, Pointer pointer2);

    int ssh_dh_get_parameters(dh_ctx dh_ctxVar, PointerByReference pointerByReference, PointerByReference pointerByReference2);

    int ssh_dh_import_next_pubkey_blob(ssh_session ssh_sessionVar, ssh_string_struct ssh_string_structVar);

    @Deprecated
    int ssh_dh_import_next_pubkey_blob(Pointer pointer, ssh_string_struct ssh_string_structVar);

    int ssh_dh_init();

    int ssh_dh_init_common(ssh_crypto_struct ssh_crypto_structVar);

    byte ssh_dh_is_known_group(bignum bignumVar, bignum bignumVar2);

    @Deprecated
    byte ssh_dh_is_known_group(Pointer pointer, Pointer pointer2);

    int ssh_dh_keypair_gen_keys(dh_ctx dh_ctxVar, int i);

    @Deprecated
    int ssh_dh_keypair_get_keys(dh_ctx dh_ctxVar, int i, Pointer pointer, Pointer pointer2);

    int ssh_dh_keypair_get_keys(dh_ctx dh_ctxVar, int i, PointerByReference pointerByReference, PointerByReference pointerByReference2);

    int ssh_dh_keypair_set_keys(dh_ctx dh_ctxVar, int i, bignum bignumVar, bignum bignumVar2);

    @Deprecated
    int ssh_dh_keypair_set_keys(dh_ctx dh_ctxVar, int i, Pointer pointer, Pointer pointer2);

    int ssh_dh_set_parameters(dh_ctx dh_ctxVar, bignum bignumVar, bignum bignumVar2);

    @Deprecated
    int ssh_dh_set_parameters(dh_ctx dh_ctxVar, Pointer pointer, Pointer pointer2);

    @Deprecated
    Pointer ssh_dirname(Pointer pointer);

    Pointer ssh_dirname(String str);

    void ssh_disconnect(ssh_session ssh_sessionVar);

    @Deprecated
    void ssh_disconnect(Pointer pointer);

    Pointer ssh_dump_knownhost(ssh_session ssh_sessionVar);

    @Deprecated
    Pointer ssh_dump_knownhost(Pointer pointer);

    int ssh_event_add_connector(ssh_event ssh_eventVar, ssh_connector ssh_connectorVar);

    @Deprecated
    int ssh_event_add_connector(Pointer pointer, Pointer pointer2);

    int ssh_event_add_fd(ssh_event ssh_eventVar, int i, short s, ssh_event_callback ssh_event_callbackVar, Pointer pointer);

    @Deprecated
    int ssh_event_add_fd(Pointer pointer, int i, short s, ssh_event_callback ssh_event_callbackVar, Pointer pointer2);

    int ssh_event_add_session(ssh_event ssh_eventVar, ssh_session ssh_sessionVar);

    @Deprecated
    int ssh_event_add_session(Pointer pointer, Pointer pointer2);

    int ssh_event_dopoll(ssh_event ssh_eventVar, int i);

    @Deprecated
    int ssh_event_dopoll(Pointer pointer, int i);

    void ssh_event_free(ssh_event ssh_eventVar);

    @Deprecated
    void ssh_event_free(Pointer pointer);

    ssh_event ssh_event_new();

    int ssh_event_remove_connector(ssh_event ssh_eventVar, ssh_connector ssh_connectorVar);

    @Deprecated
    int ssh_event_remove_connector(Pointer pointer, Pointer pointer2);

    int ssh_event_remove_fd(ssh_event ssh_eventVar, int i);

    @Deprecated
    int ssh_event_remove_fd(Pointer pointer, int i);

    int ssh_event_remove_session(ssh_event ssh_eventVar, ssh_session ssh_sessionVar);

    @Deprecated
    int ssh_event_remove_session(Pointer pointer, Pointer pointer2);

    int ssh_execute_message_callbacks(ssh_session ssh_sessionVar);

    @Deprecated
    int ssh_execute_message_callbacks(Pointer pointer);

    @Deprecated
    int ssh_fallback_group(int i, Pointer pointer, Pointer pointer2);

    int ssh_fallback_group(int i, PointerByReference pointerByReference, PointerByReference pointerByReference2);

    int ssh_finalize();

    @Deprecated
    Pointer ssh_find_matching(Pointer pointer, Pointer pointer2);

    Pointer ssh_find_matching(String str, String str2);

    ssh_channel ssh_forward_accept(ssh_session ssh_sessionVar, int i);

    @Deprecated
    ssh_channel ssh_forward_accept(Pointer pointer, int i);

    int ssh_forward_cancel(ssh_session ssh_sessionVar, String str, int i);

    @Deprecated
    int ssh_forward_cancel(Pointer pointer, Pointer pointer2, int i);

    int ssh_forward_listen(ssh_session ssh_sessionVar, String str, int i, IntBuffer intBuffer);

    @Deprecated
    int ssh_forward_listen(Pointer pointer, Pointer pointer2, int i, IntByReference intByReference);

    void ssh_free(ssh_session ssh_sessionVar);

    @Deprecated
    void ssh_free(Pointer pointer);

    int ssh_generate_session_keys(ssh_session ssh_sessionVar);

    @Deprecated
    int ssh_generate_session_keys(Pointer pointer);

    ssh_cipher_struct ssh_get_chacha20poly1305_cipher();

    String ssh_get_cipher_in(ssh_session ssh_sessionVar);

    @Deprecated
    String ssh_get_cipher_in(Pointer pointer);

    String ssh_get_cipher_out(ssh_session ssh_sessionVar);

    @Deprecated
    String ssh_get_cipher_out(Pointer pointer);

    ssh_cipher_struct ssh_get_ciphertab();

    String ssh_get_clientbanner(ssh_session ssh_sessionVar);

    @Deprecated
    String ssh_get_clientbanner(Pointer pointer);

    String ssh_get_disconnect_message(ssh_session ssh_sessionVar);

    @Deprecated
    String ssh_get_disconnect_message(Pointer pointer);

    String ssh_get_error(Pointer pointer);

    int ssh_get_error_code(Pointer pointer);

    int ssh_get_fd(ssh_session ssh_sessionVar);

    @Deprecated
    int ssh_get_fd(Pointer pointer);

    @Deprecated
    Pointer ssh_get_fingerprint_hash(int i, Pointer pointer, NativeSize nativeSize);

    Pointer ssh_get_fingerprint_hash(int i, ByteBuffer byteBuffer, NativeSize nativeSize);

    @Deprecated
    Pointer ssh_get_hexa(Pointer pointer, NativeSize nativeSize);

    Pointer ssh_get_hexa(byte[] bArr, NativeSize nativeSize);

    String ssh_get_hmac_in(ssh_session ssh_sessionVar);

    @Deprecated
    String ssh_get_hmac_in(Pointer pointer);

    String ssh_get_hmac_out(ssh_session ssh_sessionVar);

    @Deprecated
    String ssh_get_hmac_out(Pointer pointer);

    ssh_hmac_struct ssh_get_hmactab();

    Pointer ssh_get_issue_banner(ssh_session ssh_sessionVar);

    @Deprecated
    Pointer ssh_get_issue_banner(Pointer pointer);

    int ssh_get_kex1(ssh_session ssh_sessionVar);

    @Deprecated
    int ssh_get_kex1(Pointer pointer);

    String ssh_get_kex_algo(ssh_session ssh_sessionVar);

    @Deprecated
    String ssh_get_kex_algo(Pointer pointer);

    int ssh_get_key_params(ssh_session ssh_sessionVar, ssh_key_struct.ByReference[] byReferenceArr, IntBuffer intBuffer);

    @Deprecated
    int ssh_get_key_params(Pointer pointer, PointerByReference pointerByReference, IntByReference intByReference);

    int ssh_get_key_params(Pointer pointer, ssh_key_struct.ByReference[] byReferenceArr, IntByReference intByReference);

    ssh_logging_callback ssh_get_log_callback();

    int ssh_get_log_level();

    Pointer ssh_get_log_userdata();

    int ssh_get_openssh_version(ssh_session ssh_sessionVar);

    @Deprecated
    int ssh_get_openssh_version(Pointer pointer);

    int ssh_get_poll_flags(ssh_session ssh_sessionVar);

    @Deprecated
    int ssh_get_poll_flags(Pointer pointer);

    ssh_string_struct ssh_get_pubkey(ssh_session ssh_sessionVar);

    @Deprecated
    ssh_string_struct ssh_get_pubkey(Pointer pointer);

    int ssh_get_pubkey_hash(ssh_session ssh_sessionVar, PointerByReference pointerByReference);

    @Deprecated
    int ssh_get_pubkey_hash(Pointer pointer, PointerByReference pointerByReference);

    int ssh_get_publickey(ssh_session ssh_sessionVar, ssh_key_struct.ByReference[] byReferenceArr);

    @Deprecated
    int ssh_get_publickey(Pointer pointer, PointerByReference pointerByReference);

    int ssh_get_publickey(Pointer pointer, ssh_key_struct.ByReference[] byReferenceArr);

    int ssh_get_publickey_hash(ssh_key_struct ssh_key_structVar, int i, PointerByReference pointerByReference, NativeSizeByReference nativeSizeByReference);

    int ssh_get_random(Pointer pointer, int i, int i2);

    int ssh_get_server_publickey(ssh_session ssh_sessionVar, ssh_key_struct.ByReference[] byReferenceArr);

    @Deprecated
    int ssh_get_server_publickey(Pointer pointer, PointerByReference pointerByReference);

    int ssh_get_server_publickey(Pointer pointer, ssh_key_struct.ByReference[] byReferenceArr);

    String ssh_get_serverbanner(ssh_session ssh_sessionVar);

    @Deprecated
    String ssh_get_serverbanner(Pointer pointer);

    int ssh_get_status(ssh_session ssh_sessionVar);

    @Deprecated
    int ssh_get_status(Pointer pointer);

    int ssh_get_version(ssh_session ssh_sessionVar);

    @Deprecated
    int ssh_get_version(Pointer pointer);

    @Deprecated
    int ssh_getpass(Pointer pointer, Pointer pointer2, NativeSize nativeSize, int i, int i2);

    int ssh_getpass(String str, ByteBuffer byteBuffer, NativeSize nativeSize, int i, int i2);

    Pointer ssh_gssapi_get_creds(ssh_session ssh_sessionVar);

    @Deprecated
    Pointer ssh_gssapi_get_creds(Pointer pointer);

    void ssh_gssapi_set_creds(ssh_session ssh_sessionVar, Pointer pointer);

    @Deprecated
    void ssh_gssapi_set_creds(Pointer pointer, Pointer pointer2);

    int ssh_handle_key_exchange(ssh_session ssh_sessionVar);

    @Deprecated
    int ssh_handle_key_exchange(Pointer pointer);

    int ssh_hashbufin_add_cookie(ssh_session ssh_sessionVar, ByteBuffer byteBuffer);

    @Deprecated
    int ssh_hashbufin_add_cookie(Pointer pointer, Pointer pointer2);

    int ssh_hashbufout_add_cookie(ssh_session ssh_sessionVar);

    @Deprecated
    int ssh_hashbufout_add_cookie(Pointer pointer);

    String ssh_hmac_type_to_string(int i, byte b);

    int ssh_init();

    int ssh_is_blocking(ssh_session ssh_sessionVar);

    @Deprecated
    int ssh_is_blocking(Pointer pointer);

    int ssh_is_connected(ssh_session ssh_sessionVar);

    @Deprecated
    int ssh_is_connected(Pointer pointer);

    int ssh_is_server_known(ssh_session ssh_sessionVar);

    @Deprecated
    int ssh_is_server_known(Pointer pointer);

    @Deprecated
    int ssh_kdf(ssh_crypto_struct ssh_crypto_structVar, Pointer pointer, NativeSize nativeSize, int i, Pointer pointer2, NativeSize nativeSize2);

    int ssh_kdf(ssh_crypto_struct ssh_crypto_structVar, ByteBuffer byteBuffer, NativeSize nativeSize, int i, ByteBuffer byteBuffer2, NativeSize nativeSize2);

    @Deprecated
    Pointer ssh_keep_fips_algos(int i, Pointer pointer);

    Pointer ssh_keep_fips_algos(int i, String str);

    @Deprecated
    Pointer ssh_keep_known_algos(int i, Pointer pointer);

    Pointer ssh_keep_known_algos(int i, String str);

    String ssh_kex_get_default_methods(int i);

    String ssh_kex_get_description(int i);

    String ssh_kex_get_fips_methods(int i);

    String ssh_kex_get_supported_method(int i);

    int ssh_kex_select_methods(ssh_session ssh_sessionVar);

    @Deprecated
    int ssh_kex_select_methods(Pointer pointer);

    int ssh_key_algorithm_allowed(ssh_session ssh_sessionVar, String str);

    @Deprecated
    int ssh_key_algorithm_allowed(Pointer pointer, Pointer pointer2);

    void ssh_key_clean(ssh_key_struct ssh_key_structVar);

    int ssh_key_cmp(ssh_key_struct ssh_key_structVar, ssh_key_struct ssh_key_structVar2, int i);

    ssh_key_struct ssh_key_dup(ssh_key_struct ssh_key_structVar);

    void ssh_key_free(ssh_key_struct ssh_key_structVar);

    String ssh_key_get_signature_algorithm(ssh_session ssh_sessionVar, int i);

    @Deprecated
    String ssh_key_get_signature_algorithm(Pointer pointer, int i);

    @Deprecated
    int ssh_key_hash_from_name(Pointer pointer);

    int ssh_key_hash_from_name(String str);

    int ssh_key_is_private(ssh_key_struct ssh_key_structVar);

    int ssh_key_is_public(ssh_key_struct ssh_key_structVar);

    ssh_key_struct ssh_key_new();

    String ssh_key_signature_to_char(int i, int i2);

    int ssh_key_type(ssh_key_struct ssh_key_structVar);

    @Deprecated
    int ssh_key_type_from_name(Pointer pointer);

    int ssh_key_type_from_name(String str);

    @Deprecated
    int ssh_key_type_from_signature_name(Pointer pointer);

    int ssh_key_type_from_signature_name(String str);

    int ssh_key_type_plain(int i);

    String ssh_key_type_to_char(int i);

    int ssh_key_type_to_hash(ssh_session ssh_sessionVar, int i);

    @Deprecated
    int ssh_key_type_to_hash(Pointer pointer, int i);

    @Deprecated
    int ssh_known_hosts_parse_line(Pointer pointer, Pointer pointer2, PointerByReference pointerByReference);

    int ssh_known_hosts_parse_line(Pointer pointer, Pointer pointer2, ssh_knownhosts_entry.ByReference[] byReferenceArr);

    int ssh_known_hosts_parse_line(String str, String str2, ssh_knownhosts_entry.ByReference[] byReferenceArr);

    void ssh_knownhosts_entry_free(ssh_knownhosts_entry ssh_knownhosts_entryVar);

    void ssh_list_kex(ssh_kex_struct ssh_kex_structVar);

    void ssh_log(ssh_session ssh_sessionVar, int i, String str, Object... objArr);

    @Deprecated
    void ssh_log(Pointer pointer, int i, Pointer pointer2, Object... objArr);

    @Deprecated
    void ssh_log_common(ssh_common_struct ssh_common_structVar, int i, Pointer pointer, Pointer pointer2, Object... objArr);

    void ssh_log_common(ssh_common_struct ssh_common_structVar, int i, String str, String str2, Object... objArr);

    @Deprecated
    void ssh_log_function(int i, Pointer pointer, Pointer pointer2);

    void ssh_log_function(int i, String str, String str2);

    int ssh_make_sessionid(ssh_session ssh_sessionVar);

    @Deprecated
    int ssh_make_sessionid(Pointer pointer);

    int ssh_message_auth_interactive_request(ssh_message ssh_messageVar, String str, String str2, int i, String[] strArr, ByteBuffer byteBuffer);

    @Deprecated
    int ssh_message_auth_interactive_request(Pointer pointer, Pointer pointer2, Pointer pointer3, int i, PointerByReference pointerByReference, Pointer pointer4);

    int ssh_message_auth_kbdint_is_response(ssh_message ssh_messageVar);

    @Deprecated
    int ssh_message_auth_kbdint_is_response(Pointer pointer);

    String ssh_message_auth_password(ssh_message ssh_messageVar);

    @Deprecated
    String ssh_message_auth_password(Pointer pointer);

    ssh_key_struct ssh_message_auth_pubkey(ssh_message ssh_messageVar);

    @Deprecated
    ssh_key_struct ssh_message_auth_pubkey(Pointer pointer);

    ssh_public_key ssh_message_auth_publickey(ssh_message ssh_messageVar);

    @Deprecated
    ssh_public_key ssh_message_auth_publickey(Pointer pointer);

    int ssh_message_auth_publickey_state(ssh_message ssh_messageVar);

    @Deprecated
    int ssh_message_auth_publickey_state(Pointer pointer);

    int ssh_message_auth_reply_pk_ok(ssh_message ssh_messageVar, ssh_string_struct ssh_string_structVar, ssh_string_struct ssh_string_structVar2);

    @Deprecated
    int ssh_message_auth_reply_pk_ok(Pointer pointer, ssh_string_struct ssh_string_structVar, ssh_string_struct ssh_string_structVar2);

    int ssh_message_auth_reply_pk_ok_simple(ssh_message ssh_messageVar);

    @Deprecated
    int ssh_message_auth_reply_pk_ok_simple(Pointer pointer);

    int ssh_message_auth_reply_success(ssh_message ssh_messageVar, int i);

    @Deprecated
    int ssh_message_auth_reply_success(Pointer pointer, int i);

    int ssh_message_auth_set_methods(ssh_message ssh_messageVar, int i);

    @Deprecated
    int ssh_message_auth_set_methods(Pointer pointer, int i);

    String ssh_message_auth_user(ssh_message ssh_messageVar);

    @Deprecated
    String ssh_message_auth_user(Pointer pointer);

    ssh_channel ssh_message_channel_request_channel(ssh_message ssh_messageVar);

    @Deprecated
    ssh_channel ssh_message_channel_request_channel(Pointer pointer);

    String ssh_message_channel_request_command(ssh_message ssh_messageVar);

    @Deprecated
    String ssh_message_channel_request_command(Pointer pointer);

    String ssh_message_channel_request_env_name(ssh_message ssh_messageVar);

    @Deprecated
    String ssh_message_channel_request_env_name(Pointer pointer);

    String ssh_message_channel_request_env_value(ssh_message ssh_messageVar);

    @Deprecated
    String ssh_message_channel_request_env_value(Pointer pointer);

    String ssh_message_channel_request_open_destination(ssh_message ssh_messageVar);

    @Deprecated
    String ssh_message_channel_request_open_destination(Pointer pointer);

    int ssh_message_channel_request_open_destination_port(ssh_message ssh_messageVar);

    @Deprecated
    int ssh_message_channel_request_open_destination_port(Pointer pointer);

    String ssh_message_channel_request_open_originator(ssh_message ssh_messageVar);

    @Deprecated
    String ssh_message_channel_request_open_originator(Pointer pointer);

    int ssh_message_channel_request_open_originator_port(ssh_message ssh_messageVar);

    @Deprecated
    int ssh_message_channel_request_open_originator_port(Pointer pointer);

    ssh_channel ssh_message_channel_request_open_reply_accept(ssh_message ssh_messageVar);

    @Deprecated
    ssh_channel ssh_message_channel_request_open_reply_accept(Pointer pointer);

    int ssh_message_channel_request_open_reply_accept_channel(ssh_message ssh_messageVar, ssh_channel ssh_channelVar);

    @Deprecated
    int ssh_message_channel_request_open_reply_accept_channel(Pointer pointer, Pointer pointer2);

    int ssh_message_channel_request_pty_height(ssh_message ssh_messageVar);

    @Deprecated
    int ssh_message_channel_request_pty_height(Pointer pointer);

    int ssh_message_channel_request_pty_pxheight(ssh_message ssh_messageVar);

    @Deprecated
    int ssh_message_channel_request_pty_pxheight(Pointer pointer);

    int ssh_message_channel_request_pty_pxwidth(ssh_message ssh_messageVar);

    @Deprecated
    int ssh_message_channel_request_pty_pxwidth(Pointer pointer);

    String ssh_message_channel_request_pty_term(ssh_message ssh_messageVar);

    @Deprecated
    String ssh_message_channel_request_pty_term(Pointer pointer);

    int ssh_message_channel_request_pty_width(ssh_message ssh_messageVar);

    @Deprecated
    int ssh_message_channel_request_pty_width(Pointer pointer);

    int ssh_message_channel_request_reply_success(ssh_message ssh_messageVar);

    @Deprecated
    int ssh_message_channel_request_reply_success(Pointer pointer);

    String ssh_message_channel_request_subsystem(ssh_message ssh_messageVar);

    @Deprecated
    String ssh_message_channel_request_subsystem(Pointer pointer);

    String ssh_message_channel_request_x11_auth_cookie(ssh_message ssh_messageVar);

    @Deprecated
    String ssh_message_channel_request_x11_auth_cookie(Pointer pointer);

    String ssh_message_channel_request_x11_auth_protocol(ssh_message ssh_messageVar);

    @Deprecated
    String ssh_message_channel_request_x11_auth_protocol(Pointer pointer);

    int ssh_message_channel_request_x11_screen_number(ssh_message ssh_messageVar);

    @Deprecated
    int ssh_message_channel_request_x11_screen_number(Pointer pointer);

    int ssh_message_channel_request_x11_single_connection(ssh_message ssh_messageVar);

    @Deprecated
    int ssh_message_channel_request_x11_single_connection(Pointer pointer);

    void ssh_message_free(ssh_message ssh_messageVar);

    @Deprecated
    void ssh_message_free(Pointer pointer);

    ssh_message ssh_message_get(ssh_session ssh_sessionVar);

    @Deprecated
    ssh_message ssh_message_get(Pointer pointer);

    String ssh_message_global_request_address(ssh_message ssh_messageVar);

    @Deprecated
    String ssh_message_global_request_address(Pointer pointer);

    int ssh_message_global_request_port(ssh_message ssh_messageVar);

    @Deprecated
    int ssh_message_global_request_port(Pointer pointer);

    int ssh_message_global_request_reply_success(ssh_message ssh_messageVar, short s);

    @Deprecated
    int ssh_message_global_request_reply_success(Pointer pointer, short s);

    int ssh_message_reply_default(ssh_message ssh_messageVar);

    @Deprecated
    int ssh_message_reply_default(Pointer pointer);

    ssh_message ssh_message_retrieve(ssh_session ssh_sessionVar, int i);

    @Deprecated
    ssh_message ssh_message_retrieve(Pointer pointer, int i);

    int ssh_message_service_reply_success(ssh_message ssh_messageVar);

    @Deprecated
    int ssh_message_service_reply_success(Pointer pointer);

    String ssh_message_service_service(ssh_message ssh_messageVar);

    @Deprecated
    String ssh_message_service_service(Pointer pointer);

    int ssh_message_subtype(ssh_message ssh_messageVar);

    @Deprecated
    int ssh_message_subtype(Pointer pointer);

    int ssh_message_type(ssh_message ssh_messageVar);

    @Deprecated
    int ssh_message_type(Pointer pointer);

    @Deprecated
    int ssh_mkdir(Pointer pointer, int i);

    int ssh_mkdir(String str, int i);

    ssh_session ssh_new();

    int ssh_options_copy(ssh_session ssh_sessionVar, PointerByReference pointerByReference);

    @Deprecated
    int ssh_options_copy(Pointer pointer, Pointer pointer2);

    int ssh_options_copy(Pointer pointer, PointerByReference pointerByReference);

    int ssh_options_get(ssh_session ssh_sessionVar, int i, PointerByReference pointerByReference);

    @Deprecated
    int ssh_options_get(Pointer pointer, int i, PointerByReference pointerByReference);

    int ssh_options_get_port(ssh_session ssh_sessionVar, IntBuffer intBuffer);

    @Deprecated
    int ssh_options_get_port(Pointer pointer, IntByReference intByReference);

    int ssh_options_getopt(ssh_session ssh_sessionVar, IntBuffer intBuffer, PointerByReference pointerByReference);

    @Deprecated
    int ssh_options_getopt(Pointer pointer, IntByReference intByReference, PointerByReference pointerByReference);

    int ssh_options_parse_config(ssh_session ssh_sessionVar, String str);

    @Deprecated
    int ssh_options_parse_config(Pointer pointer, Pointer pointer2);

    int ssh_options_set(ssh_session ssh_sessionVar, int i, Pointer pointer);

    @Deprecated
    int ssh_options_set(Pointer pointer, int i, Pointer pointer2);

    int ssh_packet_kexinit(ssh_session ssh_sessionVar, byte b, ssh_buffer ssh_bufferVar, Pointer pointer);

    @Deprecated
    int ssh_packet_kexinit(Pointer pointer, byte b, Pointer pointer2, Pointer pointer3);

    int ssh_packet_server_ecdh_init(ssh_session ssh_sessionVar, byte b, ssh_buffer ssh_bufferVar, Pointer pointer);

    @Deprecated
    int ssh_packet_server_ecdh_init(Pointer pointer, byte b, Pointer pointer2, Pointer pointer3);

    int ssh_pcap_file_close(ssh_pcap_file ssh_pcap_fileVar);

    @Deprecated
    int ssh_pcap_file_close(Pointer pointer);

    void ssh_pcap_file_free(ssh_pcap_file ssh_pcap_fileVar);

    @Deprecated
    void ssh_pcap_file_free(Pointer pointer);

    ssh_pcap_file ssh_pcap_file_new();

    int ssh_pcap_file_open(ssh_pcap_file ssh_pcap_fileVar, String str);

    @Deprecated
    int ssh_pcap_file_open(Pointer pointer, Pointer pointer2);

    ssh_private_key ssh_pki_convert_key_to_privatekey(ssh_key_struct ssh_key_structVar);

    ssh_public_key ssh_pki_convert_key_to_publickey(ssh_key_struct ssh_key_structVar);

    int ssh_pki_copy_cert_to_privkey(ssh_key_struct ssh_key_structVar, ssh_key_struct ssh_key_structVar2);

    ssh_string_struct ssh_pki_do_sign(ssh_session ssh_sessionVar, ssh_buffer ssh_bufferVar, ssh_key_struct ssh_key_structVar, int i);

    @Deprecated
    ssh_string_struct ssh_pki_do_sign(Pointer pointer, Pointer pointer2, ssh_key_struct ssh_key_structVar, int i);

    ssh_string_struct ssh_pki_do_sign_agent(ssh_session ssh_sessionVar, ssh_buffer_struct ssh_buffer_structVar, ssh_key_struct ssh_key_structVar);

    @Deprecated
    ssh_string_struct ssh_pki_do_sign_agent(Pointer pointer, ssh_buffer_struct ssh_buffer_structVar, ssh_key_struct ssh_key_structVar);

    @Deprecated
    int ssh_pki_export_privkey_base64(ssh_key_struct ssh_key_structVar, Pointer pointer, ssh_auth_callback ssh_auth_callbackVar, Pointer pointer2, PointerByReference pointerByReference);

    int ssh_pki_export_privkey_base64(ssh_key_struct ssh_key_structVar, String str, ssh_auth_callback ssh_auth_callbackVar, Pointer pointer, PointerByReference pointerByReference);

    @Deprecated
    int ssh_pki_export_privkey_file(ssh_key_struct ssh_key_structVar, Pointer pointer, ssh_auth_callback ssh_auth_callbackVar, Pointer pointer2, Pointer pointer3);

    int ssh_pki_export_privkey_file(ssh_key_struct ssh_key_structVar, String str, ssh_auth_callback ssh_auth_callbackVar, Pointer pointer, String str2);

    @Deprecated
    int ssh_pki_export_privkey_to_pubkey(ssh_key_struct ssh_key_structVar, PointerByReference pointerByReference);

    int ssh_pki_export_privkey_to_pubkey(ssh_key_struct ssh_key_structVar, ssh_key_struct.ByReference[] byReferenceArr);

    int ssh_pki_export_pubkey_base64(ssh_key_struct ssh_key_structVar, PointerByReference pointerByReference);

    @Deprecated
    int ssh_pki_export_pubkey_blob(ssh_key_struct ssh_key_structVar, PointerByReference pointerByReference);

    int ssh_pki_export_pubkey_blob(ssh_key_struct ssh_key_structVar, ssh_string_struct.ByReference[] byReferenceArr);

    @Deprecated
    int ssh_pki_export_pubkey_file(ssh_key_struct ssh_key_structVar, Pointer pointer);

    int ssh_pki_export_pubkey_file(ssh_key_struct ssh_key_structVar, String str);

    @Deprecated
    int ssh_pki_export_signature_blob(ssh_signature_struct ssh_signature_structVar, PointerByReference pointerByReference);

    int ssh_pki_export_signature_blob(ssh_signature_struct ssh_signature_structVar, ssh_string_struct.ByReference[] byReferenceArr);

    @Deprecated
    int ssh_pki_generate(int i, int i2, PointerByReference pointerByReference);

    int ssh_pki_generate(int i, int i2, ssh_key_struct.ByReference[] byReferenceArr);

    @Deprecated
    int ssh_pki_import_cert_base64(Pointer pointer, int i, PointerByReference pointerByReference);

    int ssh_pki_import_cert_base64(Pointer pointer, int i, ssh_key_struct.ByReference[] byReferenceArr);

    int ssh_pki_import_cert_base64(String str, int i, ssh_key_struct.ByReference[] byReferenceArr);

    @Deprecated
    int ssh_pki_import_cert_blob(ssh_string_struct ssh_string_structVar, PointerByReference pointerByReference);

    int ssh_pki_import_cert_blob(ssh_string_struct ssh_string_structVar, ssh_key_struct.ByReference[] byReferenceArr);

    @Deprecated
    int ssh_pki_import_cert_file(Pointer pointer, PointerByReference pointerByReference);

    int ssh_pki_import_cert_file(Pointer pointer, ssh_key_struct.ByReference[] byReferenceArr);

    int ssh_pki_import_cert_file(String str, ssh_key_struct.ByReference[] byReferenceArr);

    @Deprecated
    int ssh_pki_import_privkey_base64(Pointer pointer, Pointer pointer2, ssh_auth_callback ssh_auth_callbackVar, Pointer pointer3, PointerByReference pointerByReference);

    int ssh_pki_import_privkey_base64(Pointer pointer, Pointer pointer2, ssh_auth_callback ssh_auth_callbackVar, Pointer pointer3, ssh_key_struct.ByReference[] byReferenceArr);

    int ssh_pki_import_privkey_base64(String str, String str2, ssh_auth_callback ssh_auth_callbackVar, Pointer pointer, ssh_key_struct.ByReference[] byReferenceArr);

    @Deprecated
    int ssh_pki_import_privkey_file(Pointer pointer, Pointer pointer2, ssh_auth_callback ssh_auth_callbackVar, Pointer pointer3, PointerByReference pointerByReference);

    int ssh_pki_import_privkey_file(Pointer pointer, Pointer pointer2, ssh_auth_callback ssh_auth_callbackVar, Pointer pointer3, ssh_key_struct.ByReference[] byReferenceArr);

    int ssh_pki_import_privkey_file(String str, String str2, ssh_auth_callback ssh_auth_callbackVar, Pointer pointer, ssh_key_struct.ByReference[] byReferenceArr);

    @Deprecated
    int ssh_pki_import_pubkey_base64(Pointer pointer, int i, PointerByReference pointerByReference);

    int ssh_pki_import_pubkey_base64(Pointer pointer, int i, ssh_key_struct.ByReference[] byReferenceArr);

    int ssh_pki_import_pubkey_base64(String str, int i, ssh_key_struct.ByReference[] byReferenceArr);

    @Deprecated
    int ssh_pki_import_pubkey_blob(ssh_string_struct ssh_string_structVar, PointerByReference pointerByReference);

    int ssh_pki_import_pubkey_blob(ssh_string_struct ssh_string_structVar, ssh_key_struct.ByReference[] byReferenceArr);

    @Deprecated
    int ssh_pki_import_pubkey_file(Pointer pointer, PointerByReference pointerByReference);

    int ssh_pki_import_pubkey_file(Pointer pointer, ssh_key_struct.ByReference[] byReferenceArr);

    int ssh_pki_import_pubkey_file(String str, ssh_key_struct.ByReference[] byReferenceArr);

    @Deprecated
    int ssh_pki_import_signature_blob(ssh_string_struct ssh_string_structVar, ssh_key_struct ssh_key_structVar, PointerByReference pointerByReference);

    int ssh_pki_import_signature_blob(ssh_string_struct ssh_string_structVar, ssh_key_struct ssh_key_structVar, ssh_signature_struct.ByReference[] byReferenceArr);

    String ssh_pki_key_ecdsa_name(ssh_key_struct ssh_key_structVar);

    @Deprecated
    ssh_string_struct ssh_pki_openssh_privkey_export(ssh_key_struct ssh_key_structVar, Pointer pointer, ssh_auth_callback ssh_auth_callbackVar, Pointer pointer2);

    ssh_string_struct ssh_pki_openssh_privkey_export(ssh_key_struct ssh_key_structVar, String str, ssh_auth_callback ssh_auth_callbackVar, Pointer pointer);

    @Deprecated
    ssh_key_struct ssh_pki_openssh_privkey_import(Pointer pointer, Pointer pointer2, ssh_auth_callback ssh_auth_callbackVar, Pointer pointer3);

    ssh_key_struct ssh_pki_openssh_privkey_import(String str, String str2, ssh_auth_callback ssh_auth_callbackVar, Pointer pointer);

    @Deprecated
    ssh_key_struct ssh_pki_openssh_pubkey_import(Pointer pointer);

    ssh_key_struct ssh_pki_openssh_pubkey_import(String str);

    int ssh_pki_signature_verify(ssh_session ssh_sessionVar, ssh_signature_struct ssh_signature_structVar, ssh_key_struct ssh_key_structVar, byte[] bArr, NativeSize nativeSize);

    @Deprecated
    int ssh_pki_signature_verify(Pointer pointer, ssh_signature_struct ssh_signature_structVar, ssh_key_struct ssh_key_structVar, Pointer pointer2, NativeSize nativeSize);

    @Deprecated
    void ssh_print_hash(int i, Pointer pointer, NativeSize nativeSize);

    void ssh_print_hash(int i, ByteBuffer byteBuffer, NativeSize nativeSize);

    @Deprecated
    void ssh_print_hexa(Pointer pointer, Pointer pointer2, NativeSize nativeSize);

    void ssh_print_hexa(String str, byte[] bArr, NativeSize nativeSize);

    int ssh_privatekey_type(ssh_private_key ssh_private_keyVar);

    @Deprecated
    int ssh_privatekey_type(Pointer pointer);

    int ssh_publickey_to_file(ssh_session ssh_sessionVar, String str, ssh_string_struct ssh_string_structVar, int i);

    @Deprecated
    int ssh_publickey_to_file(Pointer pointer, Pointer pointer2, ssh_string_struct ssh_string_structVar, int i);

    int ssh_remove_channel_callbacks(ssh_channel ssh_channelVar, ssh_channel_callbacks_struct ssh_channel_callbacks_structVar);

    @Deprecated
    int ssh_remove_channel_callbacks(Pointer pointer, ssh_channel_callbacks_struct ssh_channel_callbacks_structVar);

    void ssh_reseed();

    void ssh_reset_error(Pointer pointer);

    int ssh_scp_accept_request(ssh_scp ssh_scpVar);

    @Deprecated
    int ssh_scp_accept_request(Pointer pointer);

    int ssh_scp_close(ssh_scp ssh_scpVar);

    @Deprecated
    int ssh_scp_close(Pointer pointer);

    int ssh_scp_deny_request(ssh_scp ssh_scpVar, String str);

    @Deprecated
    int ssh_scp_deny_request(Pointer pointer, Pointer pointer2);

    void ssh_scp_free(ssh_scp ssh_scpVar);

    @Deprecated
    void ssh_scp_free(Pointer pointer);

    int ssh_scp_init(ssh_scp ssh_scpVar);

    @Deprecated
    int ssh_scp_init(Pointer pointer);

    int ssh_scp_leave_directory(ssh_scp ssh_scpVar);

    @Deprecated
    int ssh_scp_leave_directory(Pointer pointer);

    ssh_scp ssh_scp_new(ssh_session ssh_sessionVar, int i, String str);

    @Deprecated
    ssh_scp ssh_scp_new(Pointer pointer, int i, Pointer pointer2);

    int ssh_scp_pull_request(ssh_scp ssh_scpVar);

    @Deprecated
    int ssh_scp_pull_request(Pointer pointer);

    int ssh_scp_push_directory(ssh_scp ssh_scpVar, String str, int i);

    @Deprecated
    int ssh_scp_push_directory(Pointer pointer, Pointer pointer2, int i);

    int ssh_scp_push_file(ssh_scp ssh_scpVar, String str, NativeSize nativeSize, int i);

    @Deprecated
    int ssh_scp_push_file(Pointer pointer, Pointer pointer2, NativeSize nativeSize, int i);

    int ssh_scp_push_file64(ssh_scp ssh_scpVar, String str, long j, int i);

    @Deprecated
    int ssh_scp_push_file64(Pointer pointer, Pointer pointer2, long j, int i);

    int ssh_scp_read(ssh_scp ssh_scpVar, Pointer pointer, NativeSize nativeSize);

    @Deprecated
    int ssh_scp_read(Pointer pointer, Pointer pointer2, NativeSize nativeSize);

    String ssh_scp_request_get_filename(ssh_scp ssh_scpVar);

    @Deprecated
    String ssh_scp_request_get_filename(Pointer pointer);

    int ssh_scp_request_get_permissions(ssh_scp ssh_scpVar);

    @Deprecated
    int ssh_scp_request_get_permissions(Pointer pointer);

    NativeSize ssh_scp_request_get_size(ssh_scp ssh_scpVar);

    @Deprecated
    NativeSize ssh_scp_request_get_size(Pointer pointer);

    long ssh_scp_request_get_size64(ssh_scp ssh_scpVar);

    @Deprecated
    long ssh_scp_request_get_size64(Pointer pointer);

    String ssh_scp_request_get_warning(ssh_scp ssh_scpVar);

    @Deprecated
    String ssh_scp_request_get_warning(Pointer pointer);

    int ssh_scp_write(ssh_scp ssh_scpVar, Pointer pointer, NativeSize nativeSize);

    @Deprecated
    int ssh_scp_write(Pointer pointer, Pointer pointer2, NativeSize nativeSize);

    @Deprecated
    int ssh_select(Pointer pointer, Pointer pointer2, int i, fd_set fd_setVar, timeval timevalVar);

    int ssh_select(PointerByReference pointerByReference, PointerByReference pointerByReference2, int i, fd_set fd_setVar, timeval timevalVar);

    int ssh_send_banner(ssh_session ssh_sessionVar, int i);

    @Deprecated
    int ssh_send_banner(Pointer pointer, int i);

    int ssh_send_debug(ssh_session ssh_sessionVar, String str, int i);

    @Deprecated
    int ssh_send_debug(Pointer pointer, Pointer pointer2, int i);

    int ssh_send_ignore(ssh_session ssh_sessionVar, String str);

    @Deprecated
    int ssh_send_ignore(Pointer pointer, Pointer pointer2);

    int ssh_send_keepalive(ssh_session ssh_sessionVar);

    @Deprecated
    int ssh_send_keepalive(Pointer pointer);

    int ssh_send_kex(ssh_session ssh_sessionVar, int i);

    @Deprecated
    int ssh_send_kex(Pointer pointer, int i);

    int ssh_send_rekex(ssh_session ssh_sessionVar);

    @Deprecated
    int ssh_send_rekex(Pointer pointer);

    void ssh_server_curve25519_init(ssh_session ssh_sessionVar);

    @Deprecated
    void ssh_server_curve25519_init(Pointer pointer);

    void ssh_server_dh_init(ssh_session ssh_sessionVar);

    @Deprecated
    void ssh_server_dh_init(Pointer pointer);

    int ssh_server_dh_process_init(ssh_session ssh_sessionVar, ssh_buffer ssh_bufferVar);

    @Deprecated
    int ssh_server_dh_process_init(Pointer pointer, Pointer pointer2);

    void ssh_server_ecdh_init(ssh_session ssh_sessionVar);

    @Deprecated
    void ssh_server_ecdh_init(Pointer pointer);

    int ssh_server_init_kex(ssh_session ssh_sessionVar);

    @Deprecated
    int ssh_server_init_kex(Pointer pointer);

    int ssh_service_request(ssh_session ssh_sessionVar, String str);

    @Deprecated
    int ssh_service_request(Pointer pointer, Pointer pointer2);

    int ssh_session_export_known_hosts_entry(ssh_session ssh_sessionVar, PointerByReference pointerByReference);

    @Deprecated
    int ssh_session_export_known_hosts_entry(Pointer pointer, PointerByReference pointerByReference);

    int ssh_session_get_known_hosts_entry(ssh_session ssh_sessionVar, ssh_knownhosts_entry.ByReference[] byReferenceArr);

    @Deprecated
    int ssh_session_get_known_hosts_entry(Pointer pointer, PointerByReference pointerByReference);

    int ssh_session_get_known_hosts_entry(Pointer pointer, ssh_knownhosts_entry.ByReference[] byReferenceArr);

    int ssh_session_has_known_hosts_entry(ssh_session ssh_sessionVar);

    @Deprecated
    int ssh_session_has_known_hosts_entry(Pointer pointer);

    int ssh_session_is_known_server(ssh_session ssh_sessionVar);

    @Deprecated
    int ssh_session_is_known_server(Pointer pointer);

    int ssh_session_update_known_hosts(ssh_session ssh_sessionVar);

    @Deprecated
    int ssh_session_update_known_hosts(Pointer pointer);

    int ssh_set_agent_channel(ssh_session ssh_sessionVar, ssh_channel ssh_channelVar);

    @Deprecated
    int ssh_set_agent_channel(Pointer pointer, Pointer pointer2);

    int ssh_set_agent_socket(ssh_session ssh_sessionVar, int i);

    @Deprecated
    int ssh_set_agent_socket(Pointer pointer, int i);

    void ssh_set_auth_methods(ssh_session ssh_sessionVar, int i);

    @Deprecated
    void ssh_set_auth_methods(Pointer pointer, int i);

    void ssh_set_blocking(ssh_session ssh_sessionVar, int i);

    @Deprecated
    void ssh_set_blocking(Pointer pointer, int i);

    int ssh_set_callbacks(ssh_session ssh_sessionVar, ssh_callbacks_struct ssh_callbacks_structVar);

    @Deprecated
    int ssh_set_callbacks(Pointer pointer, ssh_callbacks_struct ssh_callbacks_structVar);

    int ssh_set_channel_callbacks(ssh_channel ssh_channelVar, ssh_channel_callbacks_struct ssh_channel_callbacks_structVar);

    @Deprecated
    int ssh_set_channel_callbacks(Pointer pointer, ssh_channel_callbacks_struct ssh_channel_callbacks_structVar);

    int ssh_set_client_kex(ssh_session ssh_sessionVar);

    @Deprecated
    int ssh_set_client_kex(Pointer pointer);

    void ssh_set_counters(ssh_session ssh_sessionVar, ssh_counter_struct ssh_counter_structVar, ssh_counter_struct ssh_counter_structVar2);

    @Deprecated
    void ssh_set_counters(Pointer pointer, ssh_counter_struct ssh_counter_structVar, ssh_counter_struct ssh_counter_structVar2);

    void ssh_set_fd_except(ssh_session ssh_sessionVar);

    @Deprecated
    void ssh_set_fd_except(Pointer pointer);

    void ssh_set_fd_toread(ssh_session ssh_sessionVar);

    @Deprecated
    void ssh_set_fd_toread(Pointer pointer);

    void ssh_set_fd_towrite(ssh_session ssh_sessionVar);

    @Deprecated
    void ssh_set_fd_towrite(Pointer pointer);

    int ssh_set_log_callback(ssh_logging_callback ssh_logging_callbackVar);

    int ssh_set_log_level(int i);

    int ssh_set_log_userdata(Pointer pointer);

    void ssh_set_message_callback(ssh_session ssh_sessionVar, ssh_set_message_callback_ssh_bind_message_callback_callback ssh_set_message_callback_ssh_bind_message_callback_callbackVar, Pointer pointer);

    @Deprecated
    void ssh_set_message_callback(Pointer pointer, ssh_set_message_callback_ssh_bind_message_callback_callback ssh_set_message_callback_ssh_bind_message_callback_callbackVar, Pointer pointer2);

    int ssh_set_pcap_file(ssh_session ssh_sessionVar, ssh_pcap_file ssh_pcap_fileVar);

    @Deprecated
    int ssh_set_pcap_file(Pointer pointer, Pointer pointer2);

    int ssh_set_server_callbacks(ssh_session ssh_sessionVar, ssh_server_callbacks_struct ssh_server_callbacks_structVar);

    @Deprecated
    int ssh_set_server_callbacks(Pointer pointer, ssh_server_callbacks_struct ssh_server_callbacks_structVar);

    void ssh_signature_free(ssh_signature_struct ssh_signature_structVar);

    ssh_signature_struct ssh_signature_new();

    void ssh_silent_disconnect(ssh_session ssh_sessionVar);

    @Deprecated
    void ssh_silent_disconnect(Pointer pointer);

    @Deprecated
    PointerByReference ssh_space_tokenize(Pointer pointer);

    PointerByReference ssh_space_tokenize(String str);

    ssh_string_struct ssh_srv_pki_do_sign_sessionid(ssh_session ssh_sessionVar, ssh_key_struct ssh_key_structVar, int i);

    @Deprecated
    ssh_string_struct ssh_srv_pki_do_sign_sessionid(Pointer pointer, ssh_key_struct ssh_key_structVar, int i);

    void ssh_string_burn(ssh_string_struct ssh_string_structVar);

    ssh_string_struct ssh_string_copy(ssh_string_struct ssh_string_structVar);

    Pointer ssh_string_data(ssh_string_struct ssh_string_structVar);

    int ssh_string_fill(ssh_string_struct ssh_string_structVar, Pointer pointer, NativeSize nativeSize);

    void ssh_string_free(ssh_string_struct ssh_string_structVar);

    @Deprecated
    void ssh_string_free_char(Pointer pointer);

    void ssh_string_free_char(ByteBuffer byteBuffer);

    @Deprecated
    ssh_string_struct ssh_string_from_char(Pointer pointer);

    ssh_string_struct ssh_string_from_char(String str);

    String ssh_string_get_char(ssh_string_struct ssh_string_structVar);

    NativeSize ssh_string_len(ssh_string_struct ssh_string_structVar);

    ssh_string_struct ssh_string_new(NativeSize nativeSize);

    Pointer ssh_string_to_char(ssh_string_struct ssh_string_structVar);

    ssh_threads_callbacks_struct ssh_threads_get_default();

    ssh_threads_callbacks_struct ssh_threads_get_noop();

    ssh_threads_callbacks_struct ssh_threads_get_pthread();

    int ssh_threads_set_callbacks(ssh_threads_callbacks_struct ssh_threads_callbacks_structVar);

    int ssh_try_publickey_from_file(ssh_session ssh_sessionVar, String str, ssh_string_struct.ByReference[] byReferenceArr, IntBuffer intBuffer);

    @Deprecated
    int ssh_try_publickey_from_file(Pointer pointer, Pointer pointer2, PointerByReference pointerByReference, IntByReference intByReference);

    int ssh_try_publickey_from_file(Pointer pointer, Pointer pointer2, ssh_string_struct.ByReference[] byReferenceArr, IntByReference intByReference);

    int ssh_userauth_agent(ssh_session ssh_sessionVar, String str);

    @Deprecated
    int ssh_userauth_agent(Pointer pointer, Pointer pointer2);

    int ssh_userauth_agent_pubkey(ssh_session ssh_sessionVar, String str, ssh_public_key ssh_public_keyVar);

    @Deprecated
    int ssh_userauth_agent_pubkey(Pointer pointer, Pointer pointer2, Pointer pointer3);

    int ssh_userauth_autopubkey(ssh_session ssh_sessionVar, String str);

    @Deprecated
    int ssh_userauth_autopubkey(Pointer pointer, Pointer pointer2);

    int ssh_userauth_gssapi(ssh_session ssh_sessionVar);

    @Deprecated
    int ssh_userauth_gssapi(Pointer pointer);

    int ssh_userauth_kbdint(ssh_session ssh_sessionVar, String str, String str2);

    @Deprecated
    int ssh_userauth_kbdint(Pointer pointer, Pointer pointer2, Pointer pointer3);

    String ssh_userauth_kbdint_getanswer(ssh_session ssh_sessionVar, int i);

    @Deprecated
    String ssh_userauth_kbdint_getanswer(Pointer pointer, int i);

    String ssh_userauth_kbdint_getinstruction(ssh_session ssh_sessionVar);

    @Deprecated
    String ssh_userauth_kbdint_getinstruction(Pointer pointer);

    String ssh_userauth_kbdint_getname(ssh_session ssh_sessionVar);

    @Deprecated
    String ssh_userauth_kbdint_getname(Pointer pointer);

    int ssh_userauth_kbdint_getnanswers(ssh_session ssh_sessionVar);

    @Deprecated
    int ssh_userauth_kbdint_getnanswers(Pointer pointer);

    int ssh_userauth_kbdint_getnprompts(ssh_session ssh_sessionVar);

    @Deprecated
    int ssh_userauth_kbdint_getnprompts(Pointer pointer);

    String ssh_userauth_kbdint_getprompt(ssh_session ssh_sessionVar, int i, ByteBuffer byteBuffer);

    @Deprecated
    String ssh_userauth_kbdint_getprompt(Pointer pointer, int i, Pointer pointer2);

    int ssh_userauth_kbdint_setanswer(ssh_session ssh_sessionVar, int i, String str);

    @Deprecated
    int ssh_userauth_kbdint_setanswer(Pointer pointer, int i, Pointer pointer2);

    int ssh_userauth_list(ssh_session ssh_sessionVar, String str);

    @Deprecated
    int ssh_userauth_list(Pointer pointer, Pointer pointer2);

    int ssh_userauth_none(ssh_session ssh_sessionVar, String str);

    @Deprecated
    int ssh_userauth_none(Pointer pointer, Pointer pointer2);

    int ssh_userauth_offer_pubkey(ssh_session ssh_sessionVar, String str, int i, ssh_string_struct ssh_string_structVar);

    @Deprecated
    int ssh_userauth_offer_pubkey(Pointer pointer, Pointer pointer2, int i, ssh_string_struct ssh_string_structVar);

    int ssh_userauth_password(ssh_session ssh_sessionVar, String str, String str2);

    @Deprecated
    int ssh_userauth_password(Pointer pointer, Pointer pointer2, Pointer pointer3);

    int ssh_userauth_privatekey_file(ssh_session ssh_sessionVar, String str, String str2, String str3);

    @Deprecated
    int ssh_userauth_privatekey_file(Pointer pointer, Pointer pointer2, Pointer pointer3, Pointer pointer4);

    int ssh_userauth_pubkey(ssh_session ssh_sessionVar, String str, ssh_string_struct ssh_string_structVar, ssh_private_key ssh_private_keyVar);

    @Deprecated
    int ssh_userauth_pubkey(Pointer pointer, Pointer pointer2, ssh_string_struct ssh_string_structVar, Pointer pointer3);

    int ssh_userauth_publickey(ssh_session ssh_sessionVar, String str, ssh_key_struct ssh_key_structVar);

    @Deprecated
    int ssh_userauth_publickey(Pointer pointer, Pointer pointer2, ssh_key_struct ssh_key_structVar);

    int ssh_userauth_publickey_auto(ssh_session ssh_sessionVar, String str, String str2);

    @Deprecated
    int ssh_userauth_publickey_auto(Pointer pointer, Pointer pointer2, Pointer pointer3);

    int ssh_userauth_try_publickey(ssh_session ssh_sessionVar, String str, ssh_key_struct ssh_key_structVar);

    @Deprecated
    int ssh_userauth_try_publickey(Pointer pointer, Pointer pointer2, ssh_key_struct ssh_key_structVar);

    @Deprecated
    int ssh_verify_existing_algo(int i, Pointer pointer);

    int ssh_verify_existing_algo(int i, String str);

    String ssh_version(int i);

    int ssh_write_knownhost(ssh_session ssh_sessionVar);

    @Deprecated
    int ssh_write_knownhost(Pointer pointer);

    @Deprecated
    int sshkdf_derive_key(ssh_crypto_struct ssh_crypto_structVar, Pointer pointer, NativeSize nativeSize, int i, Pointer pointer2, NativeSize nativeSize2);

    int sshkdf_derive_key(ssh_crypto_struct ssh_crypto_structVar, ByteBuffer byteBuffer, NativeSize nativeSize, int i, ByteBuffer byteBuffer2, NativeSize nativeSize2);

    void string_burn(ssh_string_struct ssh_string_structVar);

    ssh_string_struct string_copy(ssh_string_struct ssh_string_structVar);

    Pointer string_data(ssh_string_struct ssh_string_structVar);

    int string_fill(ssh_string_struct ssh_string_structVar, Pointer pointer, NativeSize nativeSize);

    void string_free(ssh_string_struct ssh_string_structVar);

    @Deprecated
    ssh_string_struct string_from_char(Pointer pointer);

    ssh_string_struct string_from_char(String str);

    NativeSize string_len(ssh_string_struct ssh_string_structVar);

    ssh_string_struct string_new(NativeSize nativeSize);

    Pointer string_to_char(ssh_string_struct ssh_string_structVar);
}
