package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import java.util.Calendar;

/* loaded from: classes.dex */
class h {

    /* renamed from: d, reason: collision with root package name */
    private static h f500d;

    /* renamed from: a, reason: collision with root package name */
    private final Context f501a;

    /* renamed from: b, reason: collision with root package name */
    private final LocationManager f502b;

    /* renamed from: c, reason: collision with root package name */
    private final a f503c = new a();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        boolean f504a;

        /* renamed from: b, reason: collision with root package name */
        long f505b;

        /* renamed from: c, reason: collision with root package name */
        long f506c;

        /* renamed from: d, reason: collision with root package name */
        long f507d;

        /* renamed from: e, reason: collision with root package name */
        long f508e;

        /* renamed from: f, reason: collision with root package name */
        long f509f;

        a() {
        }
    }

    h(Context context, LocationManager locationManager) {
        this.f501a = context;
        this.f502b = locationManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static h a(Context context) {
        if (f500d == null) {
            Context applicationContext = context.getApplicationContext();
            f500d = new h(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return f500d;
    }

    @SuppressLint({"MissingPermission"})
    private Location b() {
        Location c5 = o.b.b(this.f501a, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? c("network") : null;
        Location c6 = o.b.b(this.f501a, "android.permission.ACCESS_FINE_LOCATION") == 0 ? c("gps") : null;
        return (c6 == null || c5 == null) ? c6 != null ? c6 : c5 : c6.getTime() > c5.getTime() ? c6 : c5;
    }

    private Location c(String str) {
        try {
            if (this.f502b.isProviderEnabled(str)) {
                return this.f502b.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e4) {
            Log.d("TwilightManager", "Failed to get last known location", e4);
            return null;
        }
    }

    private boolean e() {
        return this.f503c.f509f > System.currentTimeMillis();
    }

    private void f(Location location) {
        long j4;
        a aVar = this.f503c;
        long currentTimeMillis = System.currentTimeMillis();
        g b5 = g.b();
        b5.a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j5 = b5.f497a;
        b5.a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z4 = b5.f499c == 1;
        long j6 = b5.f498b;
        long j7 = b5.f497a;
        b5.a(86400000 + currentTimeMillis, location.getLatitude(), location.getLongitude());
        long j8 = b5.f498b;
        if (j6 == -1 || j7 == -1) {
            j4 = 43200000 + currentTimeMillis;
        } else {
            j4 = (currentTimeMillis > j7 ? 0 + j8 : currentTimeMillis > j6 ? 0 + j7 : 0 + j6) + 60000;
        }
        aVar.f504a = z4;
        aVar.f505b = j5;
        aVar.f506c = j6;
        aVar.f507d = j7;
        aVar.f508e = j8;
        aVar.f509f = j4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        a aVar = this.f503c;
        if (e()) {
            return aVar.f504a;
        }
        Location b5 = b();
        if (b5 != null) {
            f(b5);
            return aVar.f504a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i4 = Calendar.getInstance().get(11);
        return i4 < 6 || i4 >= 22;
    }
}
