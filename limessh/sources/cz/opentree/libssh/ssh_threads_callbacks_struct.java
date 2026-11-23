package cz.opentree.libssh;

import androidx.core.app.NotificationCompat;
import cz.opentree.libssh.SshLibrary;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class ssh_threads_callbacks_struct extends Structure {
    public SshLibrary.ssh_thread_callback mutex_destroy;
    public SshLibrary.ssh_thread_callback mutex_init;
    public SshLibrary.ssh_thread_callback mutex_lock;
    public SshLibrary.ssh_thread_callback mutex_unlock;
    public SshLibrary.ssh_thread_id_callback thread_id;
    public Pointer type;

    /* loaded from: classes.dex */
    public static class ByReference extends ssh_threads_callbacks_struct implements Structure.ByReference {
    }

    /* loaded from: classes.dex */
    public static class ByValue extends ssh_threads_callbacks_struct implements Structure.ByValue {
    }

    public ssh_threads_callbacks_struct() {
    }

    public ssh_threads_callbacks_struct(Pointer pointer) {
        super(pointer);
    }

    public ssh_threads_callbacks_struct(Pointer pointer, SshLibrary.ssh_thread_callback ssh_thread_callbackVar, SshLibrary.ssh_thread_callback ssh_thread_callbackVar2, SshLibrary.ssh_thread_callback ssh_thread_callbackVar3, SshLibrary.ssh_thread_callback ssh_thread_callbackVar4, SshLibrary.ssh_thread_id_callback ssh_thread_id_callbackVar) {
        this.type = pointer;
        this.mutex_init = ssh_thread_callbackVar;
        this.mutex_destroy = ssh_thread_callbackVar2;
        this.mutex_lock = ssh_thread_callbackVar3;
        this.mutex_unlock = ssh_thread_callbackVar4;
        this.thread_id = ssh_thread_id_callbackVar;
    }

    @Override // com.sun.jna.Structure
    public List<String> getFieldOrder() {
        return Arrays.asList(NotificationCompat.MessagingStyle.Message.KEY_DATA_MIME_TYPE, "mutex_init", "mutex_destroy", "mutex_lock", "mutex_unlock", "thread_id");
    }
}
