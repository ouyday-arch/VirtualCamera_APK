package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.a;

/* loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(a aVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f1329a = (IconCompat) aVar.v(remoteActionCompat.f1329a, 1);
        remoteActionCompat.f1330b = aVar.l(remoteActionCompat.f1330b, 2);
        remoteActionCompat.f1331c = aVar.l(remoteActionCompat.f1331c, 3);
        remoteActionCompat.f1332d = (PendingIntent) aVar.r(remoteActionCompat.f1332d, 4);
        remoteActionCompat.f1333e = aVar.h(remoteActionCompat.f1333e, 5);
        remoteActionCompat.f1334f = aVar.h(remoteActionCompat.f1334f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, a aVar) {
        aVar.x(false, false);
        aVar.M(remoteActionCompat.f1329a, 1);
        aVar.D(remoteActionCompat.f1330b, 2);
        aVar.D(remoteActionCompat.f1331c, 3);
        aVar.H(remoteActionCompat.f1332d, 4);
        aVar.z(remoteActionCompat.f1333e, 5);
        aVar.z(remoteActionCompat.f1334f, 6);
    }
}
