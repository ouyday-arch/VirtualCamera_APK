package o2;

import android.animation.ValueAnimator;

/* loaded from: classes.dex */
public class g extends d {

    /* renamed from: k, reason: collision with root package name */
    private float f5374k;

    /* renamed from: l, reason: collision with root package name */
    private float f5375l;

    /* renamed from: m, reason: collision with root package name */
    private final int f5376m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f5377n;

    public g(int i4) {
        this.f5376m = i4;
        if (i4 != 0 && i4 != 1) {
            throw new IllegalArgumentException("You cannot pass in directions other than horizontal or vertical");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(float f4, ValueAnimator valueAnimator) {
        p(((Float) valueAnimator.getAnimatedValue()).floatValue(), f4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(float f4, ValueAnimator valueAnimator) {
        p(f4, ((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x000f, code lost:
    
        if (r0 != 3) goto L56;
     */
    @Override // android.view.View.OnTouchListener
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouch(android.view.View r8, android.view.MotionEvent r9) {
        /*
            Method dump skipped, instructions count: 215
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o2.g.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public long t(float f4, float f5) {
        long abs = Math.abs(f5 - f4) / 2.0f;
        if (abs > 800) {
            return 800L;
        }
        return abs;
    }

    protected void w(float f4, float f5, float f6) {
        x(f4, f5, f6, t(f4, f5));
    }

    protected void x(float f4, float f5, final float f6, long j4) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f4, f5);
        ofFloat.setDuration(j4);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: o2.e
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                g.this.u(f6, valueAnimator);
            }
        });
        ofFloat.start();
    }

    protected void y(float f4, float f5, float f6) {
        z(f4, f5, f6, t(f5, f6));
    }

    protected void z(final float f4, float f5, float f6, long j4) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f5, f6);
        ofFloat.setDuration(j4);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: o2.f
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                g.this.v(f4, valueAnimator);
            }
        });
        ofFloat.start();
    }
}
