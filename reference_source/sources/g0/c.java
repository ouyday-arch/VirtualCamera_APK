package g0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

/* loaded from: classes.dex */
public class c extends l {
    private static final String[] N = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    private static final Property<Drawable, PointF> O = new b(PointF.class, "boundsOrigin");
    private static final Property<k, PointF> P = new C0041c(PointF.class, "topLeft");
    private static final Property<k, PointF> Q = new d(PointF.class, "bottomRight");
    private static final Property<View, PointF> R = new e(PointF.class, "bottomRight");
    private static final Property<View, PointF> S = new f(PointF.class, "topLeft");
    private static final Property<View, PointF> T = new g(PointF.class, "position");
    private static g0.j U = new g0.j();
    private int[] K = new int[2];
    private boolean L = false;
    private boolean M = false;

    /* loaded from: classes.dex */
    class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f3765a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ BitmapDrawable f3766b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f3767c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f3768d;

        a(ViewGroup viewGroup, BitmapDrawable bitmapDrawable, View view, float f4) {
            this.f3765a = viewGroup;
            this.f3766b = bitmapDrawable;
            this.f3767c = view;
            this.f3768d = f4;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            y.b(this.f3765a).d(this.f3766b);
            y.g(this.f3767c, this.f3768d);
        }
    }

    /* loaded from: classes.dex */
    static class b extends Property<Drawable, PointF> {

        /* renamed from: a, reason: collision with root package name */
        private Rect f3770a;

        b(Class cls, String str) {
            super(cls, str);
            this.f3770a = new Rect();
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.f3770a);
            Rect rect = this.f3770a;
            return new PointF(rect.left, rect.top);
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.f3770a);
            this.f3770a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.f3770a);
        }
    }

    /* renamed from: g0.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0041c extends Property<k, PointF> {
        C0041c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(k kVar) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(k kVar, PointF pointF) {
            kVar.c(pointF);
        }
    }

    /* loaded from: classes.dex */
    static class d extends Property<k, PointF> {
        d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(k kVar) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(k kVar, PointF pointF) {
            kVar.a(pointF);
        }
    }

    /* loaded from: classes.dex */
    static class e extends Property<View, PointF> {
        e(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            y.f(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    }

    /* loaded from: classes.dex */
    static class f extends Property<View, PointF> {
        f(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            y.f(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    }

    /* loaded from: classes.dex */
    static class g extends Property<View, PointF> {
        g(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            int round = Math.round(pointF.x);
            int round2 = Math.round(pointF.y);
            y.f(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
        }
    }

    /* loaded from: classes.dex */
    class h extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ k f3771a;
        private k mViewBounds;

        h(k kVar) {
            this.f3771a = kVar;
            this.mViewBounds = kVar;
        }
    }

    /* loaded from: classes.dex */
    class i extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        private boolean f3773a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f3774b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Rect f3775c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f3776d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f3777e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f3778f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f3779g;

        i(View view, Rect rect, int i4, int i5, int i6, int i7) {
            this.f3774b = view;
            this.f3775c = rect;
            this.f3776d = i4;
            this.f3777e = i5;
            this.f3778f = i6;
            this.f3779g = i7;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f3773a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f3773a) {
                return;
            }
            y.p.g0(this.f3774b, this.f3775c);
            y.f(this.f3774b, this.f3776d, this.f3777e, this.f3778f, this.f3779g);
        }
    }

    /* loaded from: classes.dex */
    class j extends m {

        /* renamed from: a, reason: collision with root package name */
        boolean f3781a = false;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewGroup f3782b;

        j(ViewGroup viewGroup) {
            this.f3782b = viewGroup;
        }

        @Override // g0.m, g0.l.f
        public void b(l lVar) {
            v.c(this.f3782b, false);
            this.f3781a = true;
        }

        @Override // g0.l.f
        public void c(l lVar) {
            if (!this.f3781a) {
                v.c(this.f3782b, false);
            }
            lVar.Q(this);
        }

        @Override // g0.m, g0.l.f
        public void d(l lVar) {
            v.c(this.f3782b, false);
        }

        @Override // g0.m, g0.l.f
        public void e(l lVar) {
            v.c(this.f3782b, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class k {

        /* renamed from: a, reason: collision with root package name */
        private int f3784a;

        /* renamed from: b, reason: collision with root package name */
        private int f3785b;

        /* renamed from: c, reason: collision with root package name */
        private int f3786c;

        /* renamed from: d, reason: collision with root package name */
        private int f3787d;

        /* renamed from: e, reason: collision with root package name */
        private View f3788e;

        /* renamed from: f, reason: collision with root package name */
        private int f3789f;

        /* renamed from: g, reason: collision with root package name */
        private int f3790g;

        k(View view) {
            this.f3788e = view;
        }

        private void b() {
            y.f(this.f3788e, this.f3784a, this.f3785b, this.f3786c, this.f3787d);
            this.f3789f = 0;
            this.f3790g = 0;
        }

        void a(PointF pointF) {
            this.f3786c = Math.round(pointF.x);
            this.f3787d = Math.round(pointF.y);
            int i4 = this.f3790g + 1;
            this.f3790g = i4;
            if (this.f3789f == i4) {
                b();
            }
        }

        void c(PointF pointF) {
            this.f3784a = Math.round(pointF.x);
            this.f3785b = Math.round(pointF.y);
            int i4 = this.f3789f + 1;
            this.f3789f = i4;
            if (i4 == this.f3790g) {
                b();
            }
        }
    }

    private void d0(r rVar) {
        View view = rVar.f3881b;
        if (!y.p.H(view) && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        rVar.f3880a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        rVar.f3880a.put("android:changeBounds:parent", rVar.f3881b.getParent());
        if (this.M) {
            rVar.f3881b.getLocationInWindow(this.K);
            rVar.f3880a.put("android:changeBounds:windowX", Integer.valueOf(this.K[0]));
            rVar.f3880a.put("android:changeBounds:windowY", Integer.valueOf(this.K[1]));
        }
        if (this.L) {
            rVar.f3880a.put("android:changeBounds:clip", y.p.n(view));
        }
    }

    private boolean e0(View view, View view2) {
        if (!this.M) {
            return true;
        }
        r u4 = u(view, true);
        if (u4 == null) {
            if (view == view2) {
                return true;
            }
        } else if (view2 == u4.f3881b) {
            return true;
        }
        return false;
    }

    @Override // g0.l
    public String[] E() {
        return N;
    }

    @Override // g0.l
    public void g(r rVar) {
        d0(rVar);
    }

    @Override // g0.l
    public void k(r rVar) {
        d0(rVar);
    }

    @Override // g0.l
    public Animator o(ViewGroup viewGroup, r rVar, r rVar2) {
        int i4;
        View view;
        int i5;
        Rect rect;
        ObjectAnimator objectAnimator;
        Animator c5;
        Path a5;
        Property<View, PointF> property;
        if (rVar == null || rVar2 == null) {
            return null;
        }
        Map<String, Object> map = rVar.f3880a;
        Map<String, Object> map2 = rVar2.f3880a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = rVar2.f3881b;
        if (!e0(viewGroup2, viewGroup3)) {
            int intValue = ((Integer) rVar.f3880a.get("android:changeBounds:windowX")).intValue();
            int intValue2 = ((Integer) rVar.f3880a.get("android:changeBounds:windowY")).intValue();
            int intValue3 = ((Integer) rVar2.f3880a.get("android:changeBounds:windowX")).intValue();
            int intValue4 = ((Integer) rVar2.f3880a.get("android:changeBounds:windowY")).intValue();
            if (intValue == intValue3 && intValue2 == intValue4) {
                return null;
            }
            viewGroup.getLocationInWindow(this.K);
            Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
            view2.draw(new Canvas(createBitmap));
            BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
            float c6 = y.c(view2);
            y.g(view2, 0.0f);
            y.b(viewGroup).b(bitmapDrawable);
            g0.g w4 = w();
            int[] iArr = this.K;
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, g0.h.a(O, w4.a(intValue - iArr[0], intValue2 - iArr[1], intValue3 - iArr[0], intValue4 - iArr[1])));
            ofPropertyValuesHolder.addListener(new a(viewGroup, bitmapDrawable, view2, c6));
            return ofPropertyValuesHolder;
        }
        Rect rect2 = (Rect) rVar.f3880a.get("android:changeBounds:bounds");
        Rect rect3 = (Rect) rVar2.f3880a.get("android:changeBounds:bounds");
        int i6 = rect2.left;
        int i7 = rect3.left;
        int i8 = rect2.top;
        int i9 = rect3.top;
        int i10 = rect2.right;
        int i11 = rect3.right;
        int i12 = rect2.bottom;
        int i13 = rect3.bottom;
        int i14 = i10 - i6;
        int i15 = i12 - i8;
        int i16 = i11 - i7;
        int i17 = i13 - i9;
        Rect rect4 = (Rect) rVar.f3880a.get("android:changeBounds:clip");
        Rect rect5 = (Rect) rVar2.f3880a.get("android:changeBounds:clip");
        if ((i14 == 0 || i15 == 0) && (i16 == 0 || i17 == 0)) {
            i4 = 0;
        } else {
            i4 = (i6 == i7 && i8 == i9) ? 0 : 1;
            if (i10 != i11 || i12 != i13) {
                i4++;
            }
        }
        if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
            i4++;
        }
        if (i4 <= 0) {
            return null;
        }
        if (this.L) {
            view = view2;
            y.f(view, i6, i8, Math.max(i14, i16) + i6, Math.max(i15, i17) + i8);
            ObjectAnimator a6 = (i6 == i7 && i8 == i9) ? null : g0.f.a(view, T, w().a(i6, i8, i7, i9));
            if (rect4 == null) {
                i5 = 0;
                rect = new Rect(0, 0, i14, i15);
            } else {
                i5 = 0;
                rect = rect4;
            }
            Rect rect6 = rect5 == null ? new Rect(i5, i5, i16, i17) : rect5;
            if (rect.equals(rect6)) {
                objectAnimator = null;
            } else {
                y.p.g0(view, rect);
                g0.j jVar = U;
                Object[] objArr = new Object[2];
                objArr[i5] = rect;
                objArr[1] = rect6;
                ObjectAnimator ofObject = ObjectAnimator.ofObject(view, "clipBounds", jVar, objArr);
                ofObject.addListener(new i(view, rect5, i7, i9, i11, i13));
                objectAnimator = ofObject;
            }
            c5 = q.c(a6, objectAnimator);
        } else {
            view = view2;
            y.f(view, i6, i8, i10, i12);
            if (i4 == 2) {
                if (i14 == i16 && i15 == i17) {
                    a5 = w().a(i6, i8, i7, i9);
                    property = T;
                } else {
                    k kVar = new k(view);
                    ObjectAnimator a7 = g0.f.a(kVar, P, w().a(i6, i8, i7, i9));
                    ObjectAnimator a8 = g0.f.a(kVar, Q, w().a(i10, i12, i11, i13));
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(a7, a8);
                    animatorSet.addListener(new h(kVar));
                    c5 = animatorSet;
                }
            } else if (i6 == i7 && i8 == i9) {
                a5 = w().a(i10, i12, i11, i13);
                property = R;
            } else {
                a5 = w().a(i6, i8, i7, i9);
                property = S;
            }
            c5 = g0.f.a(view, property, a5);
        }
        if (view.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup4 = (ViewGroup) view.getParent();
            v.c(viewGroup4, true);
            a(new j(viewGroup4));
        }
        return c5;
    }
}
