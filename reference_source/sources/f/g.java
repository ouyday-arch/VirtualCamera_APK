package f;

import a.j;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.widget.e0;
import androidx.appcompat.widget.w0;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class g extends MenuInflater {

    /* renamed from: e, reason: collision with root package name */
    static final Class<?>[] f3655e;

    /* renamed from: f, reason: collision with root package name */
    static final Class<?>[] f3656f;

    /* renamed from: a, reason: collision with root package name */
    final Object[] f3657a;

    /* renamed from: b, reason: collision with root package name */
    final Object[] f3658b;

    /* renamed from: c, reason: collision with root package name */
    Context f3659c;

    /* renamed from: d, reason: collision with root package name */
    private Object f3660d;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements MenuItem.OnMenuItemClickListener {

        /* renamed from: c, reason: collision with root package name */
        private static final Class<?>[] f3661c = {MenuItem.class};

        /* renamed from: a, reason: collision with root package name */
        private Object f3662a;

        /* renamed from: b, reason: collision with root package name */
        private Method f3663b;

        public a(Object obj, String str) {
            this.f3662a = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f3663b = cls.getMethod(str, f3661c);
            } catch (Exception e4) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e4);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f3663b.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f3663b.invoke(this.f3662a, menuItem)).booleanValue();
                }
                this.f3663b.invoke(this.f3662a, menuItem);
                return true;
            } catch (Exception e4) {
                throw new RuntimeException(e4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        y.b A;
        private CharSequence B;
        private CharSequence C;
        private ColorStateList D = null;
        private PorterDuff.Mode E = null;

        /* renamed from: a, reason: collision with root package name */
        private Menu f3664a;

        /* renamed from: b, reason: collision with root package name */
        private int f3665b;

        /* renamed from: c, reason: collision with root package name */
        private int f3666c;

        /* renamed from: d, reason: collision with root package name */
        private int f3667d;

        /* renamed from: e, reason: collision with root package name */
        private int f3668e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f3669f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f3670g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f3671h;

        /* renamed from: i, reason: collision with root package name */
        private int f3672i;

        /* renamed from: j, reason: collision with root package name */
        private int f3673j;

        /* renamed from: k, reason: collision with root package name */
        private CharSequence f3674k;

        /* renamed from: l, reason: collision with root package name */
        private CharSequence f3675l;

        /* renamed from: m, reason: collision with root package name */
        private int f3676m;

        /* renamed from: n, reason: collision with root package name */
        private char f3677n;

        /* renamed from: o, reason: collision with root package name */
        private int f3678o;

        /* renamed from: p, reason: collision with root package name */
        private char f3679p;

        /* renamed from: q, reason: collision with root package name */
        private int f3680q;

        /* renamed from: r, reason: collision with root package name */
        private int f3681r;

        /* renamed from: s, reason: collision with root package name */
        private boolean f3682s;

        /* renamed from: t, reason: collision with root package name */
        private boolean f3683t;

        /* renamed from: u, reason: collision with root package name */
        private boolean f3684u;

        /* renamed from: v, reason: collision with root package name */
        private int f3685v;

        /* renamed from: w, reason: collision with root package name */
        private int f3686w;

        /* renamed from: x, reason: collision with root package name */
        private String f3687x;

        /* renamed from: y, reason: collision with root package name */
        private String f3688y;

        /* renamed from: z, reason: collision with root package name */
        private String f3689z;

        public b(Menu menu) {
            this.f3664a = menu;
            h();
        }

        private char c(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        private <T> T e(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, g.this.f3659c.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception e4) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e4);
                return null;
            }
        }

        private void i(MenuItem menuItem) {
            boolean z4 = false;
            menuItem.setChecked(this.f3682s).setVisible(this.f3683t).setEnabled(this.f3684u).setCheckable(this.f3681r >= 1).setTitleCondensed(this.f3675l).setIcon(this.f3676m);
            int i4 = this.f3685v;
            if (i4 >= 0) {
                menuItem.setShowAsAction(i4);
            }
            if (this.f3689z != null) {
                if (g.this.f3659c.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new a(g.this.b(), this.f3689z));
            }
            boolean z5 = menuItem instanceof androidx.appcompat.view.menu.g;
            if (z5) {
            }
            if (this.f3681r >= 2) {
                if (z5) {
                    ((androidx.appcompat.view.menu.g) menuItem).t(true);
                } else if (menuItem instanceof g.c) {
                    ((g.c) menuItem).h(true);
                }
            }
            String str = this.f3687x;
            if (str != null) {
                menuItem.setActionView((View) e(str, g.f3655e, g.this.f3657a));
                z4 = true;
            }
            int i5 = this.f3686w;
            if (i5 > 0) {
                if (z4) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                } else {
                    menuItem.setActionView(i5);
                }
            }
            y.b bVar = this.A;
            if (bVar != null) {
                y.g.a(menuItem, bVar);
            }
            y.g.c(menuItem, this.B);
            y.g.g(menuItem, this.C);
            y.g.b(menuItem, this.f3677n, this.f3678o);
            y.g.f(menuItem, this.f3679p, this.f3680q);
            PorterDuff.Mode mode = this.E;
            if (mode != null) {
                y.g.e(menuItem, mode);
            }
            ColorStateList colorStateList = this.D;
            if (colorStateList != null) {
                y.g.d(menuItem, colorStateList);
            }
        }

        public void a() {
            this.f3671h = true;
            i(this.f3664a.add(this.f3665b, this.f3672i, this.f3673j, this.f3674k));
        }

        public SubMenu b() {
            this.f3671h = true;
            SubMenu addSubMenu = this.f3664a.addSubMenu(this.f3665b, this.f3672i, this.f3673j, this.f3674k);
            i(addSubMenu.getItem());
            return addSubMenu;
        }

        public boolean d() {
            return this.f3671h;
        }

        public void f(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = g.this.f3659c.obtainStyledAttributes(attributeSet, j.f220r1);
            this.f3665b = obtainStyledAttributes.getResourceId(j.f230t1, 0);
            this.f3666c = obtainStyledAttributes.getInt(j.f240v1, 0);
            this.f3667d = obtainStyledAttributes.getInt(j.f245w1, 0);
            this.f3668e = obtainStyledAttributes.getInt(j.f250x1, 0);
            this.f3669f = obtainStyledAttributes.getBoolean(j.f235u1, true);
            this.f3670g = obtainStyledAttributes.getBoolean(j.f225s1, true);
            obtainStyledAttributes.recycle();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void g(AttributeSet attributeSet) {
            w0 t4 = w0.t(g.this.f3659c, attributeSet, j.f255y1);
            this.f3672i = t4.n(j.B1, 0);
            this.f3673j = (t4.k(j.E1, this.f3666c) & (-65536)) | (t4.k(j.F1, this.f3667d) & 65535);
            this.f3674k = t4.p(j.G1);
            this.f3675l = t4.p(j.H1);
            this.f3676m = t4.n(j.f260z1, 0);
            this.f3677n = c(t4.o(j.I1));
            this.f3678o = t4.k(j.P1, 4096);
            this.f3679p = c(t4.o(j.J1));
            this.f3680q = t4.k(j.T1, 4096);
            int i4 = j.K1;
            this.f3681r = t4.r(i4) ? t4.a(i4, false) : this.f3668e;
            this.f3682s = t4.a(j.C1, false);
            this.f3683t = t4.a(j.D1, this.f3669f);
            this.f3684u = t4.a(j.A1, this.f3670g);
            this.f3685v = t4.k(j.U1, -1);
            this.f3689z = t4.o(j.L1);
            this.f3686w = t4.n(j.M1, 0);
            this.f3687x = t4.o(j.O1);
            String o4 = t4.o(j.N1);
            this.f3688y = o4;
            boolean z4 = o4 != null;
            if (z4 && this.f3686w == 0 && this.f3687x == null) {
                this.A = (y.b) e(o4, g.f3656f, g.this.f3658b);
            } else {
                if (z4) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.A = null;
            }
            this.B = t4.p(j.Q1);
            this.C = t4.p(j.V1);
            int i5 = j.S1;
            if (t4.r(i5)) {
                this.E = e0.c(t4.k(i5, -1), this.E);
            } else {
                this.E = null;
            }
            int i6 = j.R1;
            if (t4.r(i6)) {
                this.D = t4.c(i6);
            } else {
                this.D = null;
            }
            t4.v();
            this.f3671h = false;
        }

        public void h() {
            this.f3665b = 0;
            this.f3666c = 0;
            this.f3667d = 0;
            this.f3668e = 0;
            this.f3669f = true;
            this.f3670g = true;
        }
    }

    static {
        Class<?>[] clsArr = {Context.class};
        f3655e = clsArr;
        f3656f = clsArr;
    }

    public g(Context context) {
        super(context);
        this.f3659c = context;
        Object[] objArr = {context};
        this.f3657a = objArr;
        this.f3658b = objArr;
    }

    private Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0048, code lost:
    
        if (r15 == 2) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x004b, code lost:
    
        if (r15 == 3) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004f, code lost:
    
        r15 = r13.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0053, code lost:
    
        if (r7 == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0059, code lost:
    
        if (r15.equals(r8) == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005b, code lost:
    
        r8 = null;
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00b9, code lost:
    
        r15 = r13.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0062, code lost:
    
        if (r15.equals("group") == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0064, code lost:
    
        r0.h();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006c, code lost:
    
        if (r15.equals("item") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0072, code lost:
    
        if (r0.d() != false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0074, code lost:
    
        r15 = r0.A;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0076, code lost:
    
        if (r15 == null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007c, code lost:
    
        if (r15.a() == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007e, code lost:
    
        r0.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0082, code lost:
    
        r0.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008a, code lost:
    
        if (r15.equals("menu") == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008c, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x008e, code lost:
    
        if (r7 == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0091, code lost:
    
        r15 = r13.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0099, code lost:
    
        if (r15.equals("group") == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x009b, code lost:
    
        r0.f(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a3, code lost:
    
        if (r15.equals("item") == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a5, code lost:
    
        r0.g(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00ad, code lost:
    
        if (r15.equals("menu") == false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00af, code lost:
    
        c(r13, r14, r0.b());
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00b7, code lost:
    
        r8 = r15;
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00c5, code lost:
    
        throw new java.lang.RuntimeException("Unexpected end of document");
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00c6, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x003b, code lost:
    
        r8 = null;
        r6 = false;
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0040, code lost:
    
        if (r6 != false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0042, code lost:
    
        if (r15 == 1) goto L61;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void c(org.xmlpull.v1.XmlPullParser r13, android.util.AttributeSet r14, android.view.Menu r15) {
        /*
            r12 = this;
            f.g$b r0 = new f.g$b
            r0.<init>(r15)
            int r15 = r13.getEventType()
        L9:
            r1 = 2
            java.lang.String r2 = "menu"
            r3 = 1
            if (r15 != r1) goto L35
            java.lang.String r15 = r13.getName()
            boolean r4 = r15.equals(r2)
            if (r4 == 0) goto L1e
            int r15 = r13.next()
            goto L3b
        L1e:
            java.lang.RuntimeException r13 = new java.lang.RuntimeException
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r0 = "Expecting menu, got "
            r14.append(r0)
            r14.append(r15)
            java.lang.String r14 = r14.toString()
            r13.<init>(r14)
            throw r13
        L35:
            int r15 = r13.next()
            if (r15 != r3) goto L9
        L3b:
            r4 = 0
            r5 = 0
            r8 = r4
            r6 = r5
            r7 = r6
        L40:
            if (r6 != 0) goto Lc6
            if (r15 == r3) goto Lbe
            java.lang.String r9 = "item"
            java.lang.String r10 = "group"
            if (r15 == r1) goto L8e
            r11 = 3
            if (r15 == r11) goto L4f
            goto Lb9
        L4f:
            java.lang.String r15 = r13.getName()
            if (r7 == 0) goto L5e
            boolean r11 = r15.equals(r8)
            if (r11 == 0) goto L5e
            r8 = r4
            r7 = r5
            goto Lb9
        L5e:
            boolean r10 = r15.equals(r10)
            if (r10 == 0) goto L68
            r0.h()
            goto Lb9
        L68:
            boolean r9 = r15.equals(r9)
            if (r9 == 0) goto L86
            boolean r15 = r0.d()
            if (r15 != 0) goto Lb9
            y.b r15 = r0.A
            if (r15 == 0) goto L82
            boolean r15 = r15.a()
            if (r15 == 0) goto L82
            r0.b()
            goto Lb9
        L82:
            r0.a()
            goto Lb9
        L86:
            boolean r15 = r15.equals(r2)
            if (r15 == 0) goto Lb9
            r6 = r3
            goto Lb9
        L8e:
            if (r7 == 0) goto L91
            goto Lb9
        L91:
            java.lang.String r15 = r13.getName()
            boolean r10 = r15.equals(r10)
            if (r10 == 0) goto L9f
            r0.f(r14)
            goto Lb9
        L9f:
            boolean r9 = r15.equals(r9)
            if (r9 == 0) goto La9
            r0.g(r14)
            goto Lb9
        La9:
            boolean r9 = r15.equals(r2)
            if (r9 == 0) goto Lb7
            android.view.SubMenu r15 = r0.b()
            r12.c(r13, r14, r15)
            goto Lb9
        Lb7:
            r8 = r15
            r7 = r3
        Lb9:
            int r15 = r13.next()
            goto L40
        Lbe:
            java.lang.RuntimeException r13 = new java.lang.RuntimeException
            java.lang.String r14 = "Unexpected end of document"
            r13.<init>(r14)
            throw r13
        Lc6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: f.g.c(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.view.Menu):void");
    }

    Object b() {
        if (this.f3660d == null) {
            this.f3660d = a(this.f3659c);
        }
        return this.f3660d;
    }

    @Override // android.view.MenuInflater
    public void inflate(int i4, Menu menu) {
        if (!(menu instanceof s.a)) {
            super.inflate(i4, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                try {
                    xmlResourceParser = this.f3659c.getResources().getLayout(i4);
                    c(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
                } catch (XmlPullParserException e4) {
                    throw new InflateException("Error inflating menu XML", e4);
                }
            } catch (IOException e5) {
                throw new InflateException("Error inflating menu XML", e5);
            }
        } finally {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        }
    }
}
