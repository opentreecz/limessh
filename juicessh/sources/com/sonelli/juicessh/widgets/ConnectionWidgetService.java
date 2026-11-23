package com.sonelli.juicessh.widgets;

import android.content.Intent;
import android.widget.RemoteViewsService;
import com.sonelli.zj0;

/* loaded from: classes.dex */
public class ConnectionWidgetService extends RemoteViewsService {
    @Override // android.widget.RemoteViewsService
    public RemoteViewsService.RemoteViewsFactory onGetViewFactory(Intent intent) {
        return new zj0(getApplicationContext(), intent);
    }
}
