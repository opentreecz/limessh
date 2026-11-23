package cz.opentree.libssh;

import com.ochafik.lang.jnaerator.runtime.NativeSize;
import cz.opentree.libssh.SshLibrary;
import com.sun.jna.Callback;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.ptr.PointerByReference;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class ssh_cipher_struct extends Structure {
    public aead_decrypt_callback aead_decrypt;
    public aead_decrypt_length_callback aead_decrypt_length;
    public aead_encrypt_callback aead_encrypt;
    public SshLibrary.ssh_aes_key_schedule aes_key;
    public long blocks;
    public int blocksize;
    public SshLibrary.chacha20_poly1305_keysched chacha20_schedule;
    public PointerByReference cipher;
    public int ciphertype;
    public cleanup_callback cleanup;
    public PointerByReference ctx;
    public decrypt_callback decrypt;
    public SshLibrary.ssh_3des_key_schedule des3_key;
    public encrypt_callback encrypt;
    public NativeSize keylen;
    public int keysize;
    public int lenfield_blocksize;
    public long max_blocks;
    public Pointer name;
    public int packets;
    public set_decrypt_key_callback set_decrypt_key;
    public set_encrypt_key_callback set_encrypt_key;
    public NativeSize tag_size;

    /* loaded from: classes.dex */
    public static class ByReference extends ssh_cipher_struct implements Structure.ByReference {
    }

    /* loaded from: classes.dex */
    public static class ByValue extends ssh_cipher_struct implements Structure.ByValue {
    }

    /* loaded from: classes.dex */
    public interface aead_decrypt_callback extends Callback {
        int apply(ssh_cipher_struct ssh_cipher_structVar, Pointer pointer, Pointer pointer2, NativeSize nativeSize, long j);
    }

    /* loaded from: classes.dex */
    public interface aead_decrypt_length_callback extends Callback {
        int apply(ssh_cipher_struct ssh_cipher_structVar, Pointer pointer, Pointer pointer2, NativeSize nativeSize, long j);
    }

    /* loaded from: classes.dex */
    public interface aead_encrypt_callback extends Callback {
        void apply(ssh_cipher_struct ssh_cipher_structVar, Pointer pointer, Pointer pointer2, NativeSize nativeSize, Pointer pointer3, long j);
    }

    /* loaded from: classes.dex */
    public interface cleanup_callback extends Callback {
        void apply(ssh_cipher_struct ssh_cipher_structVar);
    }

    /* loaded from: classes.dex */
    public interface decrypt_callback extends Callback {
        void apply(ssh_cipher_struct ssh_cipher_structVar, Pointer pointer, Pointer pointer2, NativeSize nativeSize);
    }

    /* loaded from: classes.dex */
    public interface encrypt_callback extends Callback {
        void apply(ssh_cipher_struct ssh_cipher_structVar, Pointer pointer, Pointer pointer2, NativeSize nativeSize);
    }

    /* loaded from: classes.dex */
    public interface set_decrypt_key_callback extends Callback {
        int apply(ssh_cipher_struct ssh_cipher_structVar, Pointer pointer, Pointer pointer2);
    }

    /* loaded from: classes.dex */
    public interface set_encrypt_key_callback extends Callback {
        int apply(ssh_cipher_struct ssh_cipher_structVar, Pointer pointer, Pointer pointer2);
    }

    public ssh_cipher_struct() {
    }

    public ssh_cipher_struct(Pointer pointer) {
        super(pointer);
    }

    @Override // com.sun.jna.Structure
    public List<String> getFieldOrder() {
        return Arrays.asList("name", "blocksize", "ciphertype", "lenfield_blocksize", "keylen", "des3_key", "aes_key", "cipher", "ctx", "chacha20_schedule", "keysize", "tag_size", "packets", "blocks", "max_blocks", "set_encrypt_key", "set_decrypt_key", "encrypt", "decrypt", "aead_encrypt", "aead_decrypt_length", "aead_decrypt", "cleanup");
    }
}
