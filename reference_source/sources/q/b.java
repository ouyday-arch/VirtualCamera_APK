package q;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import p.a;
import p.b;
import v.b;

@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final h f5504a;

    /* renamed from: b, reason: collision with root package name */
    private static final k.e<String, Typeface> f5505b;

    static {
        int i4 = Build.VERSION.SDK_INT;
        f5504a = i4 >= 29 ? new g() : i4 >= 28 ? new f() : i4 >= 26 ? new e() : d.i() ? new d() : new c();
        f5505b = new k.e<>(16);
    }

    public static Typeface a(Context context, Typeface typeface, int i4) {
        if (context != null) {
            return Typeface.create(typeface, i4);
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    public static Typeface b(Context context, CancellationSignal cancellationSignal, b.f[] fVarArr, int i4) {
        return f5504a.b(context, cancellationSignal, fVarArr, i4);
    }

    public static Typeface c(Context context, a.InterfaceC0065a interfaceC0065a, Resources resources, int i4, int i5, b.a aVar, Handler handler, boolean z4) {
        Typeface a5;
        if (interfaceC0065a instanceof a.d) {
            a.d dVar = (a.d) interfaceC0065a;
            boolean z5 = false;
            if (!z4 ? aVar == null : dVar.a() == 0) {
                z5 = true;
            }
            a5 = v.b.g(context, dVar.b(), aVar, handler, z5, z4 ? dVar.c() : -1, i5);
        } else {
            a5 = f5504a.a(context, (a.b) interfaceC0065a, resources, i5);
            if (aVar != null) {
                if (a5 != null) {
                    aVar.b(a5, handler);
                } else {
                    aVar.a(-3, handler);
                }
            }
        }
        if (a5 != null) {
            f5505b.d(e(resources, i4, i5), a5);
        }
        return a5;
    }

    public static Typeface d(Context context, Resources resources, int i4, String str, int i5) {
        Typeface d5 = f5504a.d(context, resources, i4, str, i5);
        if (d5 != null) {
            f5505b.d(e(resources, i4, i5), d5);
        }
        return d5;
    }

    private static String e(Resources resources, int i4, int i5) {
        return resources.getResourcePackageName(i4) + "-" + i4 + "-" + i5;
    }

    public static Typeface f(Resources resources, int i4, int i5) {
        return f5505b.c(e(resources, i4, i5));
    }
}
