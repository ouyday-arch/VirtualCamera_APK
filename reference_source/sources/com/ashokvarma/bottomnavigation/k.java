package com.ashokvarma.bottomnavigation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/* loaded from: classes.dex */
class k extends d {

    /* loaded from: classes.dex */
    private class a extends Animation {

        /* renamed from: b, reason: collision with root package name */
        private int f2660b;

        /* renamed from: c, reason: collision with root package name */
        private int f2661c;

        /* renamed from: d, reason: collision with root package name */
        private View f2662d;

        a(View view, int i4) {
            this.f2662d = view;
            this.f2660b = i4;
            this.f2661c = view.getWidth();
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f4, Transformation transformation) {
            this.f2662d.getLayoutParams().width = this.f2661c + ((int) ((this.f2660b - r0) * f4));
            this.f2662d.requestLayout();
        }

        @Override // android.view.animation.Animation
        public boolean willChangeBounds() {
            return true;
        }
    }

    public k(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.ashokvarma.bottomnavigation.d
    public void c() {
        this.f2551c = (int) getResources().getDimension(g.f2584l);
        this.f2552d = (int) getResources().getDimension(g.f2585m);
        View inflate = LayoutInflater.from(getContext()).inflate(i.f2607c, (ViewGroup) this, true);
        this.f2564p = inflate.findViewById(h.f2601j);
        this.f2565q = (TextView) inflate.findViewById(h.f2604m);
        this.f2566r = (ImageView) inflate.findViewById(h.f2602k);
        this.f2567s = (FrameLayout) inflate.findViewById(h.f2603l);
        this.f2568t = (BadgeTextView) inflate.findViewById(h.f2600i);
        super.c();
    }

    @Override // com.ashokvarma.bottomnavigation.d
    public void e(boolean z4, int i4) {
        super.e(z4, i4);
        a aVar = new a(this, this.f2557i);
        long j4 = i4;
        aVar.setDuration(j4);
        startAnimation(aVar);
        this.f2565q.animate().scaleY(1.0f).scaleX(1.0f).setDuration(j4).start();
    }

    @Override // com.ashokvarma.bottomnavigation.d
    protected void o(FrameLayout.LayoutParams layoutParams) {
        layoutParams.height = getContext().getResources().getDimensionPixelSize(g.f2588p);
        layoutParams.width = getContext().getResources().getDimensionPixelSize(g.f2589q);
    }

    @Override // com.ashokvarma.bottomnavigation.d
    protected void p(FrameLayout.LayoutParams layoutParams) {
        layoutParams.height = getContext().getResources().getDimensionPixelSize(g.f2590r);
        layoutParams.width = getContext().getResources().getDimensionPixelSize(g.f2591s);
    }

    @Override // com.ashokvarma.bottomnavigation.d
    public void r(boolean z4, int i4) {
        super.r(z4, i4);
        a aVar = new a(this, this.f2558j);
        aVar.setDuration(i4);
        startAnimation(aVar);
        this.f2565q.animate().scaleY(0.0f).scaleX(0.0f).setDuration(0L).start();
    }
}
