package cz.opentree.libssh;

import com.ochafik.lang.jnaerator.runtime.NativeSize;
import cz.opentree.libssh.SshLibrary;
import cz.opentree.libssh.ssh_cipher_struct;
import cz.opentree.libssh.ssh_key_struct;
import cz.opentree.libssh.ssh_string_struct;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.ptr.PointerByReference;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class ssh_crypto_struct extends Structure {
    public ssh_kex_struct client_kex;
    public Pointer compress_in_ctx;
    public Pointer compress_out_ctx;
    public byte[] curve25519_client_pubkey;
    public byte[] curve25519_privkey;
    public byte[] curve25519_server_pubkey;
    public Pointer decryptIV;
    public Pointer decryptMAC;
    public Pointer decryptkey;
    public int delayed_compress_in;
    public int delayed_compress_out;
    public SshLibrary.dh_ctx dh_ctx;
    public NativeSize dh_pmax;
    public NativeSize dh_pmin;
    public NativeSize dh_pn;
    public ssh_string_struct.ByReference dh_server_signature;
    public NativeSize digest_len;
    public int digest_type;
    public int do_compress_in;
    public int do_compress_out;
    public ssh_string_struct.ByReference ecdh_client_pubkey;
    public PointerByReference ecdh_privkey;
    public ssh_string_struct.ByReference ecdh_server_pubkey;
    public Pointer encryptIV;
    public Pointer encryptMAC;
    public Pointer encryptkey;
    public byte[] hmacbuf;
    public ssh_cipher_struct.ByReference in_cipher;
    public int in_hmac;
    public byte in_hmac_etm;
    public Pointer[] kex_methods;
    public int kex_type;
    public ssh_cipher_struct.ByReference out_cipher;
    public int out_hmac;
    public byte out_hmac_etm;
    public Pointer secret_hash;
    public ssh_kex_struct server_kex;
    public ssh_key_struct.ByReference server_pubkey;
    public Pointer session_id;
    public SshLibrary.bignum shared_secret;
    public int used;

    /* loaded from: classes.dex */
    public static class ByReference extends ssh_crypto_struct implements Structure.ByReference {
    }

    /* loaded from: classes.dex */
    public static class ByValue extends ssh_crypto_struct implements Structure.ByValue {
    }

    public ssh_crypto_struct() {
        this.curve25519_privkey = new byte[32];
        this.curve25519_client_pubkey = new byte[32];
        this.curve25519_server_pubkey = new byte[32];
        this.hmacbuf = new byte[64];
        this.kex_methods = new Pointer[10];
    }

    public ssh_crypto_struct(Pointer pointer) {
        super(pointer);
        this.curve25519_privkey = new byte[32];
        this.curve25519_client_pubkey = new byte[32];
        this.curve25519_server_pubkey = new byte[32];
        this.hmacbuf = new byte[64];
        this.kex_methods = new Pointer[10];
    }

    @Override // com.sun.jna.Structure
    public List<String> getFieldOrder() {
        return Arrays.asList("shared_secret", "dh_ctx", "dh_pmin", "dh_pn", "dh_pmax", "ecdh_privkey", "ecdh_client_pubkey", "ecdh_server_pubkey", "curve25519_privkey", "curve25519_client_pubkey", "curve25519_server_pubkey", "dh_server_signature", "digest_len", "session_id", "secret_hash", "encryptIV", "decryptIV", "decryptkey", "encryptkey", "encryptMAC", "decryptMAC", "hmacbuf", "in_cipher", "out_cipher", "in_hmac", "out_hmac", "in_hmac_etm", "out_hmac_etm", "server_pubkey", "do_compress_out", "do_compress_in", "delayed_compress_in", "delayed_compress_out", "compress_out_ctx", "compress_in_ctx", "server_kex", "client_kex", "kex_methods", "kex_type", "digest_type", "used");
    }
}
