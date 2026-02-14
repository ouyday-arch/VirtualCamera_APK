package f;

import a.j;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private Context f3634a;

    private a(Context context) {
        this.f3634a = context;
    }

    public static a b(Context context) {
        return new a(context);
    }

    public boolean a() {
        return this.f3634a.getApplicationInfo().targetSdkVersion < 14;
    }

    public int c() {
        return this.f3634a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public int d() {
        Configuration configuration = this.f3634a.getResources().getConfiguration();
        int i4 = configuration.screenWidthDp;
        int i5 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i4 > 600) {
            return 5;
        }
        if (i4 > 960 && i5 > 720) {
            return 5;
        }
        if (i4 > 720 && i5 > 960) {
            return 5;
        }
        if (i4 >= 500) {
            return 4;
        }
        if (i4 > 640 && i5 > 480) {
            return 4;
        }
        if (i4 <= 480 || i5 <= 640) {
            return i4 >= 360 ? 3 : 2;
        }
        return 4;
    }

    public int e() {
        return this.f3634a.getResources().getDimensionPixelSize(a.d.f35b);
    }

    public int f() {
        TypedArray obtainStyledAttributes = this.f3634a.obtainStyledAttributes(null, j.f133a, a.a.f2c, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(j.f178j, 0);
        Resources resources = this.f3634a.getResources();
        if (!g()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(a.d.f34a));
        }
        obtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public boolean g() {
        return this.f3634a.getResources().getBoolean(a.b.f26a);
    }

    public boolean h() {
        return true;
    }
}
