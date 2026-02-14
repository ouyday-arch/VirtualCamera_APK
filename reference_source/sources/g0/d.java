package g0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class d extends f0 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends m {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f3792a;

        a(View view) {
            this.f3792a = view;
        }

        @Override // g0.l.f
        public void c(l lVar) {
            y.g(this.f3792a, 1.0f);
            y.a(this.f3792a);
            lVar.Q(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final View f3794a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f3795b = false;

        b(View view) {
            this.f3794a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            y.g(this.f3794a, 1.0f);
            if (this.f3795b) {
                this.f3794a.setLayerType(0, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (y.p.D(this.f3794a) && this.f3794a.getLayerType() == 0) {
                this.f3795b = true;
                this.f3794a.setLayerType(2, null);
            }
        }
    }

    public d(int i4) {
        j0(i4);
    }

    private Animator k0(View view, float f4, float f5) {
        if (f4 == f5) {
            return null;
        }
        y.g(view, f4);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, y.f3891b, f5);
        ofFloat.addListener(new b(view));
        a(new a(view));
        return ofFloat;
    }

    private static float l0(r rVar, float f4) {
        Float f5;
        return (rVar == null || (f5 = (Float) rVar.f3880a.get("android:fade:transitionAlpha")) == null) ? f4 : f5.floatValue();
    }

    @Override // g0.f0
    public Animator f0(ViewGroup viewGroup, View view, r rVar, r rVar2) {
        float l02 = l0(rVar, 0.0f);
        return k0(view, l02 != 1.0f ? l02 : 0.0f, 1.0f);
    }

    @Override // g0.f0
    public Animator h0(ViewGroup viewGroup, View view, r rVar, r rVar2) {
        y.e(view);
        return k0(view, l0(rVar, 1.0f), 0.0f);
    }

    @Override // g0.f0, g0.l
    public void k(r rVar) {
        super.k(rVar);
        rVar.f3880a.put("android:fade:transitionAlpha", Float.valueOf(y.c(rVar.f3881b)));
    }
}
