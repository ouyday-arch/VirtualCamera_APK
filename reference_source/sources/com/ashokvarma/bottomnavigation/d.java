package com.ashokvarma.bottomnavigation;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/* loaded from: classes.dex */
abstract class d extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    protected boolean f2550b;

    /* renamed from: c, reason: collision with root package name */
    protected int f2551c;

    /* renamed from: d, reason: collision with root package name */
    protected int f2552d;

    /* renamed from: e, reason: collision with root package name */
    protected int f2553e;

    /* renamed from: f, reason: collision with root package name */
    protected int f2554f;

    /* renamed from: g, reason: collision with root package name */
    protected int f2555g;

    /* renamed from: h, reason: collision with root package name */
    protected int f2556h;

    /* renamed from: i, reason: collision with root package name */
    protected int f2557i;

    /* renamed from: j, reason: collision with root package name */
    protected int f2558j;

    /* renamed from: k, reason: collision with root package name */
    protected Drawable f2559k;

    /* renamed from: l, reason: collision with root package name */
    protected Drawable f2560l;

    /* renamed from: m, reason: collision with root package name */
    protected boolean f2561m;

    /* renamed from: n, reason: collision with root package name */
    protected String f2562n;

    /* renamed from: o, reason: collision with root package name */
    boolean f2563o;

    /* renamed from: p, reason: collision with root package name */
    View f2564p;

    /* renamed from: q, reason: collision with root package name */
    TextView f2565q;

    /* renamed from: r, reason: collision with root package name */
    ImageView f2566r;

    /* renamed from: s, reason: collision with root package name */
    FrameLayout f2567s;

    /* renamed from: t, reason: collision with root package name */
    BadgeTextView f2568t;

    /* loaded from: classes.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            View view = d.this.f2564p;
            view.setPadding(view.getPaddingLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), d.this.f2564p.getPaddingRight(), d.this.f2564p.getPaddingBottom());
        }
    }

    /* loaded from: classes.dex */
    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            View view = d.this.f2564p;
            view.setPadding(view.getPaddingLeft(), ((Integer) valueAnimator.getAnimatedValue()).intValue(), d.this.f2564p.getPaddingRight(), d.this.f2564p.getPaddingBottom());
        }
    }

    public d(Context context) {
        this(context, null);
    }

    public d(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public d(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f2561m = false;
        this.f2563o = false;
        c();
    }

    public int a() {
        return this.f2554f;
    }

    public int b() {
        return this.f2553e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        setLayoutParams(new ViewGroup.LayoutParams(-2, -1));
    }

    public void d(boolean z4) {
        Drawable drawable;
        ColorStateList colorStateList;
        this.f2566r.setSelected(false);
        if (this.f2561m) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{R.attr.state_selected}, this.f2559k);
            stateListDrawable.addState(new int[]{-16842913}, this.f2560l);
            stateListDrawable.addState(new int[0], this.f2560l);
            this.f2566r.setImageDrawable(stateListDrawable);
        } else {
            if (z4) {
                drawable = this.f2559k;
                int[][] iArr = {new int[]{R.attr.state_selected}, new int[]{-16842913}, new int[0]};
                int i4 = this.f2555g;
                colorStateList = new ColorStateList(iArr, new int[]{this.f2554f, i4, i4});
            } else {
                drawable = this.f2559k;
                int[][] iArr2 = {new int[]{R.attr.state_selected}, new int[]{-16842913}, new int[0]};
                int i5 = this.f2555g;
                colorStateList = new ColorStateList(iArr2, new int[]{this.f2556h, i5, i5});
            }
            r.a.j(drawable, colorStateList);
            this.f2566r.setImageDrawable(this.f2559k);
        }
        if (this.f2550b) {
            this.f2565q.setVisibility(8);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f2567s.getLayoutParams();
            layoutParams.gravity = 17;
            o(layoutParams);
            this.f2567s.setLayoutParams(layoutParams);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f2566r.getLayoutParams();
            p(layoutParams2);
            this.f2566r.setLayoutParams(layoutParams2);
        }
    }

    public void e(boolean z4, int i4) {
        TextView textView;
        int i5;
        this.f2563o = true;
        ValueAnimator ofInt = ValueAnimator.ofInt(this.f2564p.getPaddingTop(), this.f2551c);
        ofInt.addUpdateListener(new a());
        ofInt.setDuration(i4);
        ofInt.start();
        this.f2566r.setSelected(true);
        if (z4) {
            textView = this.f2565q;
            i5 = this.f2554f;
        } else {
            textView = this.f2565q;
            i5 = this.f2556h;
        }
        textView.setTextColor(i5);
    }

    public void f(int i4) {
        this.f2554f = i4;
    }

    public void g(int i4) {
        this.f2557i = i4;
    }

    public void h(Drawable drawable) {
        this.f2559k = r.a.m(drawable);
    }

    public void i(int i4) {
        this.f2555g = i4;
        this.f2565q.setTextColor(i4);
    }

    public void j(Drawable drawable) {
        this.f2560l = r.a.m(drawable);
        this.f2561m = true;
    }

    public void k(int i4) {
        this.f2558j = i4;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = this.f2558j;
        setLayoutParams(layoutParams);
    }

    public void l(boolean z4) {
        this.f2550b = z4;
    }

    public void m(int i4) {
        this.f2556h = i4;
    }

    public void n(String str) {
        this.f2562n = str;
        this.f2565q.setText(str);
    }

    protected abstract void o(FrameLayout.LayoutParams layoutParams);

    protected abstract void p(FrameLayout.LayoutParams layoutParams);

    public void q(int i4) {
        this.f2553e = i4;
    }

    public void r(boolean z4, int i4) {
        this.f2563o = false;
        ValueAnimator ofInt = ValueAnimator.ofInt(this.f2564p.getPaddingTop(), this.f2552d);
        ofInt.addUpdateListener(new b());
        ofInt.setDuration(i4);
        ofInt.start();
        this.f2565q.setTextColor(this.f2555g);
        this.f2566r.setSelected(false);
    }
}
