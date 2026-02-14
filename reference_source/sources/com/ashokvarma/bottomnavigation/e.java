package com.ashokvarma.bottomnavigation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/* loaded from: classes.dex */
class e extends d {

    /* renamed from: u, reason: collision with root package name */
    float f2571u;

    public e(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.ashokvarma.bottomnavigation.d
    public void c() {
        this.f2551c = (int) getResources().getDimension(g.f2574b);
        this.f2552d = (int) getResources().getDimension(g.f2575c);
        View inflate = LayoutInflater.from(getContext()).inflate(i.f2606b, (ViewGroup) this, true);
        this.f2564p = inflate.findViewById(h.f2596e);
        this.f2565q = (TextView) inflate.findViewById(h.f2599h);
        this.f2566r = (ImageView) inflate.findViewById(h.f2597f);
        this.f2567s = (FrameLayout) inflate.findViewById(h.f2598g);
        this.f2568t = (BadgeTextView) inflate.findViewById(h.f2595d);
        this.f2571u = getResources().getDimension(g.f2577e) / getResources().getDimension(g.f2576d);
        super.c();
    }

    @Override // com.ashokvarma.bottomnavigation.d
    public void e(boolean z4, int i4) {
        this.f2565q.animate().scaleX(1.0f).scaleY(1.0f).setDuration(i4).start();
        super.e(z4, i4);
    }

    @Override // com.ashokvarma.bottomnavigation.d
    protected void o(FrameLayout.LayoutParams layoutParams) {
        layoutParams.height = getContext().getResources().getDimensionPixelSize(g.f2580h);
        layoutParams.width = getContext().getResources().getDimensionPixelSize(g.f2581i);
    }

    @Override // com.ashokvarma.bottomnavigation.d
    protected void p(FrameLayout.LayoutParams layoutParams) {
        layoutParams.height = getContext().getResources().getDimensionPixelSize(g.f2582j);
        layoutParams.width = getContext().getResources().getDimensionPixelSize(g.f2583k);
    }

    @Override // com.ashokvarma.bottomnavigation.d
    public void r(boolean z4, int i4) {
        this.f2565q.animate().scaleX(this.f2571u).scaleY(this.f2571u).setDuration(i4).start();
        super.r(z4, i4);
    }
}
