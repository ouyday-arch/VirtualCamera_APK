package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class m0 {

    /* renamed from: i, reason: collision with root package name */
    private static m0 f1088i;

    /* renamed from: a, reason: collision with root package name */
    private WeakHashMap<Context, k.h<ColorStateList>> f1090a;

    /* renamed from: b, reason: collision with root package name */
    private k.a<String, b> f1091b;

    /* renamed from: c, reason: collision with root package name */
    private k.h<String> f1092c;

    /* renamed from: d, reason: collision with root package name */
    private final WeakHashMap<Context, k.d<WeakReference<Drawable.ConstantState>>> f1093d = new WeakHashMap<>(0);

    /* renamed from: e, reason: collision with root package name */
    private TypedValue f1094e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f1095f;

    /* renamed from: g, reason: collision with root package name */
    private c f1096g;

    /* renamed from: h, reason: collision with root package name */
    private static final PorterDuff.Mode f1087h = PorterDuff.Mode.SRC_IN;

    /* renamed from: j, reason: collision with root package name */
    private static final a f1089j = new a(6);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends k.e<Integer, PorterDuffColorFilter> {
        public a(int i4) {
            super(i4);
        }

        private static int h(int i4, PorterDuff.Mode mode) {
            return ((i4 + 31) * 31) + mode.hashCode();
        }

        PorterDuffColorFilter i(int i4, PorterDuff.Mode mode) {
            return c(Integer.valueOf(h(i4, mode)));
        }

        PorterDuffColorFilter j(int i4, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return d(Integer.valueOf(h(i4, mode)), porterDuffColorFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface b {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface c {
        Drawable a(m0 m0Var, Context context, int i4);

        boolean b(Context context, int i4, Drawable drawable);

        ColorStateList c(Context context, int i4);

        boolean d(Context context, int i4, Drawable drawable);

        PorterDuff.Mode e(int i4);
    }

    private synchronized boolean a(Context context, long j4, Drawable drawable) {
        boolean z4;
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState != null) {
            k.d<WeakReference<Drawable.ConstantState>> dVar = this.f1093d.get(context);
            if (dVar == null) {
                dVar = new k.d<>();
                this.f1093d.put(context, dVar);
            }
            dVar.j(j4, new WeakReference<>(constantState));
            z4 = true;
        } else {
            z4 = false;
        }
        return z4;
    }

    private void b(Context context, int i4, ColorStateList colorStateList) {
        if (this.f1090a == null) {
            this.f1090a = new WeakHashMap<>();
        }
        k.h<ColorStateList> hVar = this.f1090a.get(context);
        if (hVar == null) {
            hVar = new k.h<>();
            this.f1090a.put(context, hVar);
        }
        hVar.a(i4, colorStateList);
    }

    private void c(Context context) {
        if (this.f1095f) {
            return;
        }
        this.f1095f = true;
        Drawable i4 = i(context, e.a.f3589a);
        if (i4 == null || !p(i4)) {
            this.f1095f = false;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
    }

    private static long d(TypedValue typedValue) {
        return (typedValue.assetCookie << 32) | typedValue.data;
    }

    private Drawable e(Context context, int i4) {
        if (this.f1094e == null) {
            this.f1094e = new TypedValue();
        }
        TypedValue typedValue = this.f1094e;
        context.getResources().getValue(i4, typedValue, true);
        long d5 = d(typedValue);
        Drawable h4 = h(context, d5);
        if (h4 != null) {
            return h4;
        }
        c cVar = this.f1096g;
        Drawable a5 = cVar == null ? null : cVar.a(this, context, i4);
        if (a5 != null) {
            a5.setChangingConfigurations(typedValue.changingConfigurations);
            a(context, d5, a5);
        }
        return a5;
    }

    private static PorterDuffColorFilter f(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return k(colorStateList.getColorForState(iArr, 0), mode);
    }

    public static synchronized m0 g() {
        m0 m0Var;
        synchronized (m0.class) {
            if (f1088i == null) {
                m0 m0Var2 = new m0();
                f1088i = m0Var2;
                o(m0Var2);
            }
            m0Var = f1088i;
        }
        return m0Var;
    }

    private synchronized Drawable h(Context context, long j4) {
        k.d<WeakReference<Drawable.ConstantState>> dVar = this.f1093d.get(context);
        if (dVar == null) {
            return null;
        }
        WeakReference<Drawable.ConstantState> e4 = dVar.e(j4);
        if (e4 != null) {
            Drawable.ConstantState constantState = e4.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            dVar.c(j4);
        }
        return null;
    }

    public static synchronized PorterDuffColorFilter k(int i4, PorterDuff.Mode mode) {
        PorterDuffColorFilter i5;
        synchronized (m0.class) {
            a aVar = f1089j;
            i5 = aVar.i(i4, mode);
            if (i5 == null) {
                i5 = new PorterDuffColorFilter(i4, mode);
                aVar.j(i4, mode, i5);
            }
        }
        return i5;
    }

    private ColorStateList m(Context context, int i4) {
        k.h<ColorStateList> hVar;
        WeakHashMap<Context, k.h<ColorStateList>> weakHashMap = this.f1090a;
        if (weakHashMap == null || (hVar = weakHashMap.get(context)) == null) {
            return null;
        }
        return hVar.e(i4);
    }

    private static void o(m0 m0Var) {
    }

    private static boolean p(Drawable drawable) {
        return (drawable instanceof h0.b) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    private Drawable q(Context context, int i4) {
        int next;
        k.a<String, b> aVar = this.f1091b;
        if (aVar == null || aVar.isEmpty()) {
            return null;
        }
        k.h<String> hVar = this.f1092c;
        if (hVar != null) {
            String e4 = hVar.e(i4);
            if ("appcompat_skip_skip".equals(e4) || (e4 != null && this.f1091b.get(e4) == null)) {
                return null;
            }
        } else {
            this.f1092c = new k.h<>();
        }
        if (this.f1094e == null) {
            this.f1094e = new TypedValue();
        }
        TypedValue typedValue = this.f1094e;
        Resources resources = context.getResources();
        resources.getValue(i4, typedValue, true);
        long d5 = d(typedValue);
        Drawable h4 = h(context, d5);
        if (h4 != null) {
            return h4;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i4);
                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                String name = xml.getName();
                this.f1092c.a(i4, name);
                b bVar = this.f1091b.get(name);
                if (bVar != null) {
                    h4 = bVar.a(context, xml, asAttributeSet, context.getTheme());
                }
                if (h4 != null) {
                    h4.setChangingConfigurations(typedValue.changingConfigurations);
                    a(context, d5, h4);
                }
            } catch (Exception e5) {
                Log.e("ResourceManagerInternal", "Exception while inflating drawable", e5);
            }
        }
        if (h4 == null) {
            this.f1092c.a(i4, "appcompat_skip_skip");
        }
        return h4;
    }

    private Drawable u(Context context, int i4, boolean z4, Drawable drawable) {
        ColorStateList l4 = l(context, i4);
        if (l4 == null) {
            c cVar = this.f1096g;
            if ((cVar == null || !cVar.d(context, i4, drawable)) && !w(context, i4, drawable) && z4) {
                return null;
            }
            return drawable;
        }
        if (e0.a(drawable)) {
            drawable = drawable.mutate();
        }
        Drawable m4 = r.a.m(drawable);
        r.a.j(m4, l4);
        PorterDuff.Mode n4 = n(i4);
        if (n4 == null) {
            return m4;
        }
        r.a.k(m4, n4);
        return m4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void v(Drawable drawable, u0 u0Var, int[] iArr) {
        if (e0.a(drawable) && drawable.mutate() != drawable) {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        boolean z4 = u0Var.f1181d;
        if (z4 || u0Var.f1180c) {
            drawable.setColorFilter(f(z4 ? u0Var.f1178a : null, u0Var.f1180c ? u0Var.f1179b : f1087h, iArr));
        } else {
            drawable.clearColorFilter();
        }
    }

    public synchronized Drawable i(Context context, int i4) {
        return j(context, i4, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Drawable j(Context context, int i4, boolean z4) {
        Drawable q4;
        c(context);
        q4 = q(context, i4);
        if (q4 == null) {
            q4 = e(context, i4);
        }
        if (q4 == null) {
            q4 = o.a.c(context, i4);
        }
        if (q4 != null) {
            q4 = u(context, i4, z4, q4);
        }
        if (q4 != null) {
            e0.b(q4);
        }
        return q4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized ColorStateList l(Context context, int i4) {
        ColorStateList m4;
        m4 = m(context, i4);
        if (m4 == null) {
            c cVar = this.f1096g;
            m4 = cVar == null ? null : cVar.c(context, i4);
            if (m4 != null) {
                b(context, i4, m4);
            }
        }
        return m4;
    }

    PorterDuff.Mode n(int i4) {
        c cVar = this.f1096g;
        if (cVar == null) {
            return null;
        }
        return cVar.e(i4);
    }

    public synchronized void r(Context context) {
        k.d<WeakReference<Drawable.ConstantState>> dVar = this.f1093d.get(context);
        if (dVar != null) {
            dVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Drawable s(Context context, b1 b1Var, int i4) {
        Drawable q4 = q(context, i4);
        if (q4 == null) {
            q4 = b1Var.c(i4);
        }
        if (q4 == null) {
            return null;
        }
        return u(context, i4, false, q4);
    }

    public synchronized void t(c cVar) {
        this.f1096g = cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean w(Context context, int i4, Drawable drawable) {
        c cVar = this.f1096g;
        return cVar != null && cVar.b(context, i4, drawable);
    }
}
