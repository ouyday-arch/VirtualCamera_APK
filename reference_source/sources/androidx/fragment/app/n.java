package androidx.fragment.app;

import androidx.lifecycle.d;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class n {

    /* renamed from: b, reason: collision with root package name */
    int f1585b;

    /* renamed from: c, reason: collision with root package name */
    int f1586c;

    /* renamed from: d, reason: collision with root package name */
    int f1587d;

    /* renamed from: e, reason: collision with root package name */
    int f1588e;

    /* renamed from: f, reason: collision with root package name */
    int f1589f;

    /* renamed from: g, reason: collision with root package name */
    int f1590g;

    /* renamed from: h, reason: collision with root package name */
    boolean f1591h;

    /* renamed from: j, reason: collision with root package name */
    String f1593j;

    /* renamed from: k, reason: collision with root package name */
    int f1594k;

    /* renamed from: l, reason: collision with root package name */
    CharSequence f1595l;

    /* renamed from: m, reason: collision with root package name */
    int f1596m;

    /* renamed from: n, reason: collision with root package name */
    CharSequence f1597n;

    /* renamed from: o, reason: collision with root package name */
    ArrayList<String> f1598o;

    /* renamed from: p, reason: collision with root package name */
    ArrayList<String> f1599p;

    /* renamed from: r, reason: collision with root package name */
    ArrayList<Runnable> f1601r;

    /* renamed from: a, reason: collision with root package name */
    ArrayList<a> f1584a = new ArrayList<>();

    /* renamed from: i, reason: collision with root package name */
    boolean f1592i = true;

    /* renamed from: q, reason: collision with root package name */
    boolean f1600q = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        int f1602a;

        /* renamed from: b, reason: collision with root package name */
        Fragment f1603b;

        /* renamed from: c, reason: collision with root package name */
        int f1604c;

        /* renamed from: d, reason: collision with root package name */
        int f1605d;

        /* renamed from: e, reason: collision with root package name */
        int f1606e;

        /* renamed from: f, reason: collision with root package name */
        int f1607f;

        /* renamed from: g, reason: collision with root package name */
        d.b f1608g;

        /* renamed from: h, reason: collision with root package name */
        d.b f1609h;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i4, Fragment fragment) {
            this.f1602a = i4;
            this.f1603b = fragment;
            d.b bVar = d.b.RESUMED;
            this.f1608g = bVar;
            this.f1609h = bVar;
        }
    }

    public n b(Fragment fragment, String str) {
        f(0, fragment, str, 1);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(a aVar) {
        this.f1584a.add(aVar);
        aVar.f1604c = this.f1585b;
        aVar.f1605d = this.f1586c;
        aVar.f1606e = this.f1587d;
        aVar.f1607f = this.f1588e;
    }

    public abstract int d();

    public abstract int e();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(int i4, Fragment fragment, String str, int i5) {
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str2 = fragment.f1432y;
            if (str2 != null && !str.equals(str2)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.f1432y + " now " + str);
            }
            fragment.f1432y = str;
        }
        if (i4 != 0) {
            if (i4 == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
            int i6 = fragment.f1430w;
            if (i6 != 0 && i6 != i4) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.f1430w + " now " + i4);
            }
            fragment.f1430w = i4;
            fragment.f1431x = i4;
        }
        c(new a(i5, fragment));
    }

    public n g(Fragment fragment) {
        c(new a(3, fragment));
        return this;
    }

    public n h(int i4, Fragment fragment, String str) {
        if (i4 == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        f(i4, fragment, str, 2);
        return this;
    }
}
