package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;

/* loaded from: classes.dex */
class i {

    /* renamed from: a, reason: collision with root package name */
    private final CompoundButton f1014a;

    /* renamed from: b, reason: collision with root package name */
    private ColorStateList f1015b = null;

    /* renamed from: c, reason: collision with root package name */
    private PorterDuff.Mode f1016c = null;

    /* renamed from: d, reason: collision with root package name */
    private boolean f1017d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f1018e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f1019f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(CompoundButton compoundButton) {
        this.f1014a = compoundButton;
    }

    void a() {
        Drawable a5 = androidx.core.widget.c.a(this.f1014a);
        if (a5 != null) {
            if (this.f1017d || this.f1018e) {
                Drawable mutate = r.a.m(a5).mutate();
                if (this.f1017d) {
                    r.a.j(mutate, this.f1015b);
                }
                if (this.f1018e) {
                    r.a.k(mutate, this.f1016c);
                }
                if (mutate.isStateful()) {
                    mutate.setState(this.f1014a.getDrawableState());
                }
                this.f1014a.setButtonDrawable(mutate);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(int i4) {
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList c() {
        return this.f1015b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode d() {
        return this.f1016c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002d A[Catch: all -> 0x0074, TRY_ENTER, TryCatch #1 {all -> 0x0074, blocks: (B:3:0x000d, B:5:0x0015, B:8:0x001b, B:11:0x002d, B:13:0x0035, B:15:0x003b, B:16:0x0048, B:18:0x0050, B:19:0x0059, B:21:0x0061), top: B:2:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0050 A[Catch: all -> 0x0074, TryCatch #1 {all -> 0x0074, blocks: (B:3:0x000d, B:5:0x0015, B:8:0x001b, B:11:0x002d, B:13:0x0035, B:15:0x003b, B:16:0x0048, B:18:0x0050, B:19:0x0059, B:21:0x0061), top: B:2:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0061 A[Catch: all -> 0x0074, TRY_LEAVE, TryCatch #1 {all -> 0x0074, blocks: (B:3:0x000d, B:5:0x0015, B:8:0x001b, B:11:0x002d, B:13:0x0035, B:15:0x003b, B:16:0x0048, B:18:0x0050, B:19:0x0059, B:21:0x0061), top: B:2:0x000d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void e(android.util.AttributeSet r4, int r5) {
        /*
            r3 = this;
            android.widget.CompoundButton r0 = r3.f1014a
            android.content.Context r0 = r0.getContext()
            int[] r1 = a.j.R0
            r2 = 0
            android.content.res.TypedArray r4 = r0.obtainStyledAttributes(r4, r1, r5, r2)
            int r5 = a.j.T0     // Catch: java.lang.Throwable -> L74
            boolean r0 = r4.hasValue(r5)     // Catch: java.lang.Throwable -> L74
            if (r0 == 0) goto L2a
            int r5 = r4.getResourceId(r5, r2)     // Catch: java.lang.Throwable -> L74
            if (r5 == 0) goto L2a
            android.widget.CompoundButton r0 = r3.f1014a     // Catch: android.content.res.Resources.NotFoundException -> L2a java.lang.Throwable -> L74
            android.content.Context r1 = r0.getContext()     // Catch: android.content.res.Resources.NotFoundException -> L2a java.lang.Throwable -> L74
            android.graphics.drawable.Drawable r5 = c.a.b(r1, r5)     // Catch: android.content.res.Resources.NotFoundException -> L2a java.lang.Throwable -> L74
            r0.setButtonDrawable(r5)     // Catch: android.content.res.Resources.NotFoundException -> L2a java.lang.Throwable -> L74
            r5 = 1
            goto L2b
        L2a:
            r5 = r2
        L2b:
            if (r5 != 0) goto L48
            int r5 = a.j.S0     // Catch: java.lang.Throwable -> L74
            boolean r0 = r4.hasValue(r5)     // Catch: java.lang.Throwable -> L74
            if (r0 == 0) goto L48
            int r5 = r4.getResourceId(r5, r2)     // Catch: java.lang.Throwable -> L74
            if (r5 == 0) goto L48
            android.widget.CompoundButton r0 = r3.f1014a     // Catch: java.lang.Throwable -> L74
            android.content.Context r1 = r0.getContext()     // Catch: java.lang.Throwable -> L74
            android.graphics.drawable.Drawable r5 = c.a.b(r1, r5)     // Catch: java.lang.Throwable -> L74
            r0.setButtonDrawable(r5)     // Catch: java.lang.Throwable -> L74
        L48:
            int r5 = a.j.U0     // Catch: java.lang.Throwable -> L74
            boolean r0 = r4.hasValue(r5)     // Catch: java.lang.Throwable -> L74
            if (r0 == 0) goto L59
            android.widget.CompoundButton r0 = r3.f1014a     // Catch: java.lang.Throwable -> L74
            android.content.res.ColorStateList r5 = r4.getColorStateList(r5)     // Catch: java.lang.Throwable -> L74
            androidx.core.widget.c.c(r0, r5)     // Catch: java.lang.Throwable -> L74
        L59:
            int r5 = a.j.V0     // Catch: java.lang.Throwable -> L74
            boolean r0 = r4.hasValue(r5)     // Catch: java.lang.Throwable -> L74
            if (r0 == 0) goto L70
            android.widget.CompoundButton r0 = r3.f1014a     // Catch: java.lang.Throwable -> L74
            r1 = -1
            int r5 = r4.getInt(r5, r1)     // Catch: java.lang.Throwable -> L74
            r1 = 0
            android.graphics.PorterDuff$Mode r5 = androidx.appcompat.widget.e0.c(r5, r1)     // Catch: java.lang.Throwable -> L74
            androidx.core.widget.c.d(r0, r5)     // Catch: java.lang.Throwable -> L74
        L70:
            r4.recycle()
            return
        L74:
            r5 = move-exception
            r4.recycle()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.i.e(android.util.AttributeSet, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        if (this.f1019f) {
            this.f1019f = false;
        } else {
            this.f1019f = true;
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(ColorStateList colorStateList) {
        this.f1015b = colorStateList;
        this.f1017d = true;
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(PorterDuff.Mode mode) {
        this.f1016c = mode;
        this.f1018e = true;
        a();
    }
}
