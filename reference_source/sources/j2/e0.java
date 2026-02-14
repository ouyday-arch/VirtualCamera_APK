package j2;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class e0 {

    /* renamed from: e, reason: collision with root package name */
    private static e f4218e;

    /* renamed from: f, reason: collision with root package name */
    private static Boolean f4219f;

    /* renamed from: a, reason: collision with root package name */
    private List<String> f4220a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private final Context f4221b;

    /* renamed from: c, reason: collision with root package name */
    private e f4222c;

    /* renamed from: d, reason: collision with root package name */
    private Boolean f4223d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a implements e {
        a() {
        }
    }

    private e0(Context context) {
        this.f4221b = context;
    }

    public static e a() {
        if (f4218e == null) {
            f4218e = new a();
        }
        return f4218e;
    }

    private boolean b(Context context) {
        if (this.f4223d == null) {
            if (f4219f == null) {
                f4219f = Boolean.valueOf(a0.o(context));
            }
            this.f4223d = f4219f;
        }
        return this.f4223d.booleanValue();
    }

    public static e0 f(Context context) {
        return new e0(context);
    }

    public static e0 g(Fragment fragment) {
        return f(fragment.i());
    }

    public e0 c(List<String> list) {
        if (list != null && !list.isEmpty()) {
            for (String str : list) {
                if (!a0.f(this.f4220a, str)) {
                    this.f4220a.add(str);
                }
            }
        }
        return this;
    }

    public e0 d(String... strArr) {
        return c(a0.b(strArr));
    }

    public void e(h hVar) {
        if (this.f4221b == null) {
            return;
        }
        if (this.f4222c == null) {
            this.f4222c = a();
        }
        Context context = this.f4221b;
        e eVar = this.f4222c;
        ArrayList arrayList = new ArrayList(this.f4220a);
        boolean b5 = b(context);
        Activity h4 = a0.h(context);
        if (k.a(h4, b5) && k.j(arrayList, b5)) {
            if (b5) {
                j2.a j4 = a0.j(context);
                k.g(context, arrayList);
                k.l(context, arrayList, j4);
                k.b(arrayList);
                k.c(arrayList);
                k.k(h4, arrayList, j4);
                k.i(arrayList, j4);
                k.h(arrayList, j4);
                k.m(context, arrayList);
                k.f(context, arrayList, j4);
            }
            k.n(arrayList);
            if (!j.f(context, arrayList)) {
                eVar.d(h4, arrayList, hVar);
            } else if (hVar != null) {
                eVar.c(h4, arrayList, arrayList, true, hVar);
                eVar.a(h4, arrayList, true, hVar);
            }
        }
    }
}
