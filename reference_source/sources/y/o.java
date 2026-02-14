package y;

import android.view.View;
import android.view.ViewTreeObserver;
import java.util.Objects;

/* loaded from: classes.dex */
public final class o implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: b, reason: collision with root package name */
    private final View f6537b;

    /* renamed from: c, reason: collision with root package name */
    private ViewTreeObserver f6538c;

    /* renamed from: d, reason: collision with root package name */
    private final Runnable f6539d;

    private o(View view, Runnable runnable) {
        this.f6537b = view;
        this.f6538c = view.getViewTreeObserver();
        this.f6539d = runnable;
    }

    public static o a(View view, Runnable runnable) {
        Objects.requireNonNull(view, "view == null");
        Objects.requireNonNull(runnable, "runnable == null");
        o oVar = new o(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(oVar);
        view.addOnAttachStateChangeListener(oVar);
        return oVar;
    }

    public void b() {
        (this.f6538c.isAlive() ? this.f6538c : this.f6537b.getViewTreeObserver()).removeOnPreDrawListener(this);
        this.f6537b.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        b();
        this.f6539d.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.f6538c = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        b();
    }
}
