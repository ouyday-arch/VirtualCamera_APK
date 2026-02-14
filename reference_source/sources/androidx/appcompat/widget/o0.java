package androidx.appcompat.widget;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
class o0 {

    /* renamed from: a, reason: collision with root package name */
    private int f1104a = 0;

    /* renamed from: b, reason: collision with root package name */
    private int f1105b = 0;

    /* renamed from: c, reason: collision with root package name */
    private int f1106c = RecyclerView.UNDEFINED_DURATION;

    /* renamed from: d, reason: collision with root package name */
    private int f1107d = RecyclerView.UNDEFINED_DURATION;

    /* renamed from: e, reason: collision with root package name */
    private int f1108e = 0;

    /* renamed from: f, reason: collision with root package name */
    private int f1109f = 0;

    /* renamed from: g, reason: collision with root package name */
    private boolean f1110g = false;

    /* renamed from: h, reason: collision with root package name */
    private boolean f1111h = false;

    public int a() {
        return this.f1110g ? this.f1104a : this.f1105b;
    }

    public int b() {
        return this.f1104a;
    }

    public int c() {
        return this.f1105b;
    }

    public int d() {
        return this.f1110g ? this.f1105b : this.f1104a;
    }

    public void e(int i4, int i5) {
        this.f1111h = false;
        if (i4 != Integer.MIN_VALUE) {
            this.f1108e = i4;
            this.f1104a = i4;
        }
        if (i5 != Integer.MIN_VALUE) {
            this.f1109f = i5;
            this.f1105b = i5;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001a, code lost:
    
        if (r2 != Integer.MIN_VALUE) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0028, code lost:
    
        if (r2 != Integer.MIN_VALUE) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void f(boolean r2) {
        /*
            r1 = this;
            boolean r0 = r1.f1110g
            if (r2 != r0) goto L5
            return
        L5:
            r1.f1110g = r2
            boolean r0 = r1.f1111h
            if (r0 == 0) goto L2b
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r2 == 0) goto L1d
            int r2 = r1.f1107d
            if (r2 == r0) goto L14
            goto L16
        L14:
            int r2 = r1.f1108e
        L16:
            r1.f1104a = r2
            int r2 = r1.f1106c
            if (r2 == r0) goto L2f
            goto L31
        L1d:
            int r2 = r1.f1106c
            if (r2 == r0) goto L22
            goto L24
        L22:
            int r2 = r1.f1108e
        L24:
            r1.f1104a = r2
            int r2 = r1.f1107d
            if (r2 == r0) goto L2f
            goto L31
        L2b:
            int r2 = r1.f1108e
            r1.f1104a = r2
        L2f:
            int r2 = r1.f1109f
        L31:
            r1.f1105b = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.o0.f(boolean):void");
    }

    public void g(int i4, int i5) {
        this.f1106c = i4;
        this.f1107d = i5;
        this.f1111h = true;
        if (this.f1110g) {
            if (i5 != Integer.MIN_VALUE) {
                this.f1104a = i5;
            }
            if (i4 != Integer.MIN_VALUE) {
                this.f1105b = i4;
                return;
            }
            return;
        }
        if (i4 != Integer.MIN_VALUE) {
            this.f1104a = i4;
        }
        if (i5 != Integer.MIN_VALUE) {
            this.f1105b = i5;
        }
    }
}
