package cz.opentree;

import android.content.Context;
import android.content.Intent;
import cz.opentree.juicessh.R;
import cz.opentree.juicessh.connections.transports.TerminalSessionProvider;

/* compiled from: SessionTranscriptGenerator.java */
/* loaded from: classes.dex */
public class bl0 {
    /* renamed from: a */
    public static Intent m2557a(Context context, TerminalSessionProvider terminalSessionProvider) {
        if (terminalSessionProvider == null || terminalSessionProvider.mo3213e() == null) {
            gj0.m4142c("SessionTranscriptGenerator", "Attempted to generate a session transcript for a null session");
            return null;
        }
        String transcriptText = terminalSessionProvider.mo3213e().getTranscriptText();
        if (transcriptText == null) {
            gj0.m4142c("SessionTranscriptGenerator", "Attempted to generate a session transcript but the session content is null");
            return null;
        }
        String mo2814d = terminalSessionProvider.mo2814d();
        if (mo2814d != null) {
            String str = "<b>" + context.getString(R.string.host) + ": </b>" + mo2814d;
        }
        String trim = transcriptText.trim();
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", trim);
        return Intent.createChooser(intent, context.getString(R.string.select_application_to_share_with));
    }
}
