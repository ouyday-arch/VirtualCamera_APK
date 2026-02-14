package g0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import g0.l;

/* loaded from: classes.dex */
public abstract class f0 extends l {
    private static final String[] L = {"android:visibility:visibility", "android:visibility:parent"};
    private int K = 3;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends m {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f3812a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f3813b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f3814c;

        a(ViewGroup viewGroup, View view, View view2) {
            this.f3812a = viewGroup;
            this.f3813b = view;
            this.f3814c = view2;
        }

        @Override // g0.l.f
        public void c(l lVar) {
            this.f3814c.setTag(i.f3829a, null);
            v.a(this.f3812a).c(this.f3813b);
            lVar.Q(this);
        }

        @Override // g0.m, g0.l.f
        public void d(l lVar) {
            v.a(this.f3812a).c(this.f3813b);
        }

        @Override // g0.m, g0.l.f
        public void e(l lVar) {
            if (this.f3813b.getParent() == null) {
                v.a(this.f3812a).a(this.f3813b);
            } else {
                f0.this.f();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends AnimatorListenerAdapter implements l.f {

        /* renamed from: a, reason: collision with root package name */
        private final View f3816a;

        /* renamed from: b, reason: collision with root package name */
        private final int f3817b;

        /* renamed from: c, reason: collision with root package name */
        private final ViewGroup f3818c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f3819d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f3820e;

        /* renamed from: f, reason: collision with root package name */
        boolean f3821f = false;

        b(View view, int i4, boolean z4) {
            this.f3816a = view;
            this.f3817b = i4;
            this.f3818c = (ViewGroup) view.getParent();
            this.f3819d = z4;
            g(true);
        }

        private void f() {
            if (!this.f3821f) {
                y.h(this.f3816a, this.f3817b);
                ViewGroup viewGroup = this.f3818c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            g(false);
        }

        private void g(boolean z4) {
            ViewGroup viewGroup;
            if (!this.f3819d || this.f3820e == z4 || (viewGroup = this.f3818c) == null) {
                return;
            }
            this.f3820e = z4;
            v.c(viewGroup, z4);
        }

        @Override // g0.l.f
        public void a(l lVar) {
        }

        @Override // g0.l.f
        public void b(l lVar) {
        }

        @Override // g0.l.f
        public void c(l lVar) {
            f();
            lVar.Q(this);
        }

        @Override // g0.l.f
        public void d(l lVar) {
            g(false);
        }

        @Override // g0.l.f
        public void e(l lVar) {
            g(true);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f3821f = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            if (this.f3821f) {
                return;
            }
            y.h(this.f3816a, this.f3817b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            if (this.f3821f) {
                return;
            }
            y.h(this.f3816a, 0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        boolean f3822a;

        /* renamed from: b, reason: collision with root package name */
        boolean f3823b;

        /* renamed from: c, reason: collision with root package name */
        int f3824c;

        /* renamed from: d, reason: collision with root package name */
        int f3825d;

        /* renamed from: e, reason: collision with root package name */
        ViewGroup f3826e;

        /* renamed from: f, reason: collision with root package name */
        ViewGroup f3827f;

        c() {
        }
    }

    private void d0(r rVar) {
        rVar.f3880a.put("android:visibility:visibility", Integer.valueOf(rVar.f3881b.getVisibility()));
        rVar.f3880a.put("android:visibility:parent", rVar.f3881b.getParent());
        int[] iArr = new int[2];
        rVar.f3881b.getLocationOnScreen(iArr);
        rVar.f3880a.put("android:visibility:screenLocation", iArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0075, code lost:
    
        if (r9 == 0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x007f, code lost:
    
        if (r0.f3826e == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0091, code lost:
    
        if (r0.f3824c == 0) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private g0.f0.c e0(g0.r r8, g0.r r9) {
        /*
            r7 = this;
            g0.f0$c r0 = new g0.f0$c
            r0.<init>()
            r1 = 0
            r0.f3822a = r1
            r0.f3823b = r1
            java.lang.String r2 = "android:visibility:parent"
            r3 = 0
            r4 = -1
            java.lang.String r5 = "android:visibility:visibility"
            if (r8 == 0) goto L33
            java.util.Map<java.lang.String, java.lang.Object> r6 = r8.f3880a
            boolean r6 = r6.containsKey(r5)
            if (r6 == 0) goto L33
            java.util.Map<java.lang.String, java.lang.Object> r6 = r8.f3880a
            java.lang.Object r6 = r6.get(r5)
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            r0.f3824c = r6
            java.util.Map<java.lang.String, java.lang.Object> r6 = r8.f3880a
            java.lang.Object r6 = r6.get(r2)
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            r0.f3826e = r6
            goto L37
        L33:
            r0.f3824c = r4
            r0.f3826e = r3
        L37:
            if (r9 == 0) goto L5a
            java.util.Map<java.lang.String, java.lang.Object> r6 = r9.f3880a
            boolean r6 = r6.containsKey(r5)
            if (r6 == 0) goto L5a
            java.util.Map<java.lang.String, java.lang.Object> r3 = r9.f3880a
            java.lang.Object r3 = r3.get(r5)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            r0.f3825d = r3
            java.util.Map<java.lang.String, java.lang.Object> r3 = r9.f3880a
            java.lang.Object r2 = r3.get(r2)
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            r0.f3827f = r2
            goto L5e
        L5a:
            r0.f3825d = r4
            r0.f3827f = r3
        L5e:
            r2 = 1
            if (r8 == 0) goto L82
            if (r9 == 0) goto L82
            int r8 = r0.f3824c
            int r9 = r0.f3825d
            if (r8 != r9) goto L70
            android.view.ViewGroup r3 = r0.f3826e
            android.view.ViewGroup r4 = r0.f3827f
            if (r3 != r4) goto L70
            return r0
        L70:
            if (r8 == r9) goto L78
            if (r8 != 0) goto L75
            goto L93
        L75:
            if (r9 != 0) goto L96
            goto L88
        L78:
            android.view.ViewGroup r8 = r0.f3827f
            if (r8 != 0) goto L7d
            goto L93
        L7d:
            android.view.ViewGroup r8 = r0.f3826e
            if (r8 != 0) goto L96
            goto L88
        L82:
            if (r8 != 0) goto L8d
            int r8 = r0.f3825d
            if (r8 != 0) goto L8d
        L88:
            r0.f3823b = r2
        L8a:
            r0.f3822a = r2
            goto L96
        L8d:
            if (r9 != 0) goto L96
            int r8 = r0.f3824c
            if (r8 != 0) goto L96
        L93:
            r0.f3823b = r1
            goto L8a
        L96:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: g0.f0.e0(g0.r, g0.r):g0.f0$c");
    }

    @Override // g0.l
    public String[] E() {
        return L;
    }

    @Override // g0.l
    public boolean G(r rVar, r rVar2) {
        if (rVar == null && rVar2 == null) {
            return false;
        }
        if (rVar != null && rVar2 != null && rVar2.f3880a.containsKey("android:visibility:visibility") != rVar.f3880a.containsKey("android:visibility:visibility")) {
            return false;
        }
        c e02 = e0(rVar, rVar2);
        if (e02.f3822a) {
            return e02.f3824c == 0 || e02.f3825d == 0;
        }
        return false;
    }

    public abstract Animator f0(ViewGroup viewGroup, View view, r rVar, r rVar2);

    @Override // g0.l
    public void g(r rVar) {
        d0(rVar);
    }

    public Animator g0(ViewGroup viewGroup, r rVar, int i4, r rVar2, int i5) {
        if ((this.K & 1) != 1 || rVar2 == null) {
            return null;
        }
        if (rVar == null) {
            View view = (View) rVar2.f3881b.getParent();
            if (e0(u(view, false), F(view, false)).f3822a) {
                return null;
            }
        }
        return f0(viewGroup, rVar2.f3881b, rVar, rVar2);
    }

    public abstract Animator h0(ViewGroup viewGroup, View view, r rVar, r rVar2);

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0089, code lost:
    
        if (r17.f3856x != false) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.animation.Animator i0(android.view.ViewGroup r18, g0.r r19, int r20, g0.r r21, int r22) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g0.f0.i0(android.view.ViewGroup, g0.r, int, g0.r, int):android.animation.Animator");
    }

    public void j0(int i4) {
        if ((i4 & (-4)) != 0) {
            throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
        this.K = i4;
    }

    @Override // g0.l
    public void k(r rVar) {
        d0(rVar);
    }

    @Override // g0.l
    public Animator o(ViewGroup viewGroup, r rVar, r rVar2) {
        c e02 = e0(rVar, rVar2);
        if (!e02.f3822a) {
            return null;
        }
        if (e02.f3826e == null && e02.f3827f == null) {
            return null;
        }
        return e02.f3823b ? g0(viewGroup, rVar, e02.f3824c, rVar2, e02.f3825d) : i0(viewGroup, rVar, e02.f3824c, rVar2, e02.f3825d);
    }
}
