package y;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<View> f6556a;

    /* renamed from: b, reason: collision with root package name */
    Runnable f6557b = null;

    /* renamed from: c, reason: collision with root package name */
    Runnable f6558c = null;

    /* renamed from: d, reason: collision with root package name */
    int f6559d = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ u f6560a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f6561b;

        a(u uVar, View view) {
            this.f6560a = uVar;
            this.f6561b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f6560a.c(this.f6561b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f6560a.a(this.f6561b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f6560a.b(this.f6561b);
        }
    }

    /* loaded from: classes.dex */
    class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ w f6563a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f6564b;

        b(w wVar, View view) {
            this.f6563a = wVar;
            this.f6564b = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f6563a.a(this.f6564b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(View view) {
        this.f6556a = new WeakReference<>(view);
    }

    private void g(View view, u uVar) {
        if (uVar != null) {
            view.animate().setListener(new a(uVar, view));
        } else {
            view.animate().setListener(null);
        }
    }

    public t a(float f4) {
        View view = this.f6556a.get();
        if (view != null) {
            view.animate().alpha(f4);
        }
        return this;
    }

    public void b() {
        View view = this.f6556a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public long c() {
        View view = this.f6556a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    public t d(long j4) {
        View view = this.f6556a.get();
        if (view != null) {
            view.animate().setDuration(j4);
        }
        return this;
    }

    public t e(Interpolator interpolator) {
        View view = this.f6556a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public t f(u uVar) {
        View view = this.f6556a.get();
        if (view != null) {
            g(view, uVar);
        }
        return this;
    }

    public t h(long j4) {
        View view = this.f6556a.get();
        if (view != null) {
            view.animate().setStartDelay(j4);
        }
        return this;
    }

    public t i(w wVar) {
        View view = this.f6556a.get();
        if (view != null) {
            view.animate().setUpdateListener(wVar != null ? new b(wVar, view) : null);
        }
        return this;
    }

    public void j() {
        View view = this.f6556a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    public t k(float f4) {
        View view = this.f6556a.get();
        if (view != null) {
            view.animate().translationY(f4);
        }
        return this;
    }
}
