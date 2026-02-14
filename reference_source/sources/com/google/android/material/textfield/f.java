package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.z;
import androidx.core.widget.i;
import java.util.ArrayList;
import java.util.List;
import y.p;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private final Context f3305a;

    /* renamed from: b, reason: collision with root package name */
    private final TextInputLayout f3306b;

    /* renamed from: c, reason: collision with root package name */
    private LinearLayout f3307c;

    /* renamed from: d, reason: collision with root package name */
    private int f3308d;

    /* renamed from: e, reason: collision with root package name */
    private FrameLayout f3309e;

    /* renamed from: f, reason: collision with root package name */
    private int f3310f;

    /* renamed from: g, reason: collision with root package name */
    private Animator f3311g;

    /* renamed from: h, reason: collision with root package name */
    private final float f3312h;

    /* renamed from: i, reason: collision with root package name */
    private int f3313i;

    /* renamed from: j, reason: collision with root package name */
    private int f3314j;

    /* renamed from: k, reason: collision with root package name */
    private CharSequence f3315k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f3316l;

    /* renamed from: m, reason: collision with root package name */
    private TextView f3317m;

    /* renamed from: n, reason: collision with root package name */
    private CharSequence f3318n;

    /* renamed from: o, reason: collision with root package name */
    private int f3319o;

    /* renamed from: p, reason: collision with root package name */
    private ColorStateList f3320p;

    /* renamed from: q, reason: collision with root package name */
    private CharSequence f3321q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f3322r;

    /* renamed from: s, reason: collision with root package name */
    private TextView f3323s;

    /* renamed from: t, reason: collision with root package name */
    private int f3324t;

    /* renamed from: u, reason: collision with root package name */
    private ColorStateList f3325u;

    /* renamed from: v, reason: collision with root package name */
    private Typeface f3326v;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f3327a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ TextView f3328b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f3329c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TextView f3330d;

        a(int i4, TextView textView, int i5, TextView textView2) {
            this.f3327a = i4;
            this.f3328b = textView;
            this.f3329c = i5;
            this.f3330d = textView2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f.this.f3313i = this.f3327a;
            f.this.f3311g = null;
            TextView textView = this.f3328b;
            if (textView != null) {
                textView.setVisibility(4);
                if (this.f3329c == 1 && f.this.f3317m != null) {
                    f.this.f3317m.setText((CharSequence) null);
                }
            }
            TextView textView2 = this.f3330d;
            if (textView2 != null) {
                textView2.setTranslationY(0.0f);
                this.f3330d.setAlpha(1.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            TextView textView = this.f3330d;
            if (textView != null) {
                textView.setVisibility(0);
            }
        }
    }

    public f(TextInputLayout textInputLayout) {
        this.f3305a = textInputLayout.getContext();
        this.f3306b = textInputLayout;
        this.f3312h = r0.getResources().getDimensionPixelSize(m0.d.f4971h);
    }

    private void H(TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    private void J(ViewGroup viewGroup, int i4) {
        if (i4 == 0) {
            viewGroup.setVisibility(8);
        }
    }

    private boolean K(TextView textView, CharSequence charSequence) {
        return p.H(this.f3306b) && this.f3306b.isEnabled() && !(this.f3314j == this.f3313i && textView != null && TextUtils.equals(textView.getText(), charSequence));
    }

    private void N(int i4, int i5, boolean z4) {
        if (i4 == i5) {
            return;
        }
        if (z4) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f3311g = animatorSet;
            ArrayList arrayList = new ArrayList();
            h(arrayList, this.f3322r, this.f3323s, 2, i4, i5);
            h(arrayList, this.f3316l, this.f3317m, 1, i4, i5);
            n0.b.a(animatorSet, arrayList);
            animatorSet.addListener(new a(i5, l(i4), i4, l(i5)));
            animatorSet.start();
        } else {
            z(i4, i5);
        }
        this.f3306b.k0();
        this.f3306b.o0(z4);
        this.f3306b.y0();
    }

    private boolean f() {
        return (this.f3307c == null || this.f3306b.getEditText() == null) ? false : true;
    }

    private void h(List<Animator> list, boolean z4, TextView textView, int i4, int i5, int i6) {
        if (textView == null || !z4) {
            return;
        }
        if (i4 == i6 || i4 == i5) {
            list.add(i(textView, i6 == i4));
            if (i6 == i4) {
                list.add(j(textView));
            }
        }
    }

    private ObjectAnimator i(TextView textView, boolean z4) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.ALPHA, z4 ? 1.0f : 0.0f);
        ofFloat.setDuration(167L);
        ofFloat.setInterpolator(n0.a.f5238a);
        return ofFloat;
    }

    private ObjectAnimator j(TextView textView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.TRANSLATION_Y, -this.f3312h, 0.0f);
        ofFloat.setDuration(217L);
        ofFloat.setInterpolator(n0.a.f5241d);
        return ofFloat;
    }

    private TextView l(int i4) {
        if (i4 == 1) {
            return this.f3317m;
        }
        if (i4 != 2) {
            return null;
        }
        return this.f3323s;
    }

    private boolean u(int i4) {
        return (i4 != 1 || this.f3317m == null || TextUtils.isEmpty(this.f3315k)) ? false : true;
    }

    private void z(int i4, int i5) {
        TextView l4;
        TextView l5;
        if (i4 == i5) {
            return;
        }
        if (i5 != 0 && (l5 = l(i5)) != null) {
            l5.setVisibility(0);
            l5.setAlpha(1.0f);
        }
        if (i4 != 0 && (l4 = l(i4)) != null) {
            l4.setVisibility(4);
            if (i4 == 1) {
                l4.setText((CharSequence) null);
            }
        }
        this.f3313i = i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A(CharSequence charSequence) {
        this.f3318n = charSequence;
        TextView textView = this.f3317m;
        if (textView != null) {
            textView.setContentDescription(charSequence);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(boolean z4) {
        if (this.f3316l == z4) {
            return;
        }
        g();
        if (z4) {
            z zVar = new z(this.f3305a);
            this.f3317m = zVar;
            zVar.setId(m0.f.f5007t);
            this.f3317m.setTextAlignment(5);
            Typeface typeface = this.f3326v;
            if (typeface != null) {
                this.f3317m.setTypeface(typeface);
            }
            C(this.f3319o);
            D(this.f3320p);
            A(this.f3318n);
            this.f3317m.setVisibility(4);
            p.c0(this.f3317m, 1);
            d(this.f3317m, 0);
        } else {
            s();
            y(this.f3317m, 0);
            this.f3317m = null;
            this.f3306b.k0();
            this.f3306b.y0();
        }
        this.f3316l = z4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C(int i4) {
        this.f3319o = i4;
        TextView textView = this.f3317m;
        if (textView != null) {
            this.f3306b.Y(textView, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D(ColorStateList colorStateList) {
        this.f3320p = colorStateList;
        TextView textView = this.f3317m;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E(int i4) {
        this.f3324t = i4;
        TextView textView = this.f3323s;
        if (textView != null) {
            i.n(textView, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F(boolean z4) {
        if (this.f3322r == z4) {
            return;
        }
        g();
        if (z4) {
            z zVar = new z(this.f3305a);
            this.f3323s = zVar;
            zVar.setId(m0.f.f5008u);
            this.f3323s.setTextAlignment(5);
            Typeface typeface = this.f3326v;
            if (typeface != null) {
                this.f3323s.setTypeface(typeface);
            }
            this.f3323s.setVisibility(4);
            p.c0(this.f3323s, 1);
            E(this.f3324t);
            G(this.f3325u);
            d(this.f3323s, 1);
        } else {
            t();
            y(this.f3323s, 1);
            this.f3323s = null;
            this.f3306b.k0();
            this.f3306b.y0();
        }
        this.f3322r = z4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(ColorStateList colorStateList) {
        this.f3325u = colorStateList;
        TextView textView = this.f3323s;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(Typeface typeface) {
        if (typeface != this.f3326v) {
            this.f3326v = typeface;
            H(this.f3317m, typeface);
            H(this.f3323s, typeface);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L(CharSequence charSequence) {
        g();
        this.f3315k = charSequence;
        this.f3317m.setText(charSequence);
        int i4 = this.f3313i;
        if (i4 != 1) {
            this.f3314j = 1;
        }
        N(i4, this.f3314j, K(this.f3317m, charSequence));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M(CharSequence charSequence) {
        g();
        this.f3321q = charSequence;
        this.f3323s.setText(charSequence);
        int i4 = this.f3313i;
        if (i4 != 2) {
            this.f3314j = 2;
        }
        N(i4, this.f3314j, K(this.f3323s, charSequence));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(TextView textView, int i4) {
        if (this.f3307c == null && this.f3309e == null) {
            LinearLayout linearLayout = new LinearLayout(this.f3305a);
            this.f3307c = linearLayout;
            linearLayout.setOrientation(0);
            this.f3306b.addView(this.f3307c, -1, -2);
            this.f3309e = new FrameLayout(this.f3305a);
            this.f3307c.addView(this.f3309e, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (this.f3306b.getEditText() != null) {
                e();
            }
        }
        if (v(i4)) {
            this.f3309e.setVisibility(0);
            this.f3309e.addView(textView);
            this.f3310f++;
        } else {
            this.f3307c.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f3307c.setVisibility(0);
        this.f3308d++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        if (f()) {
            p.m0(this.f3307c, p.y(this.f3306b.getEditText()), 0, p.x(this.f3306b.getEditText()), 0);
        }
    }

    void g() {
        Animator animator = this.f3311g;
        if (animator != null) {
            animator.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean k() {
        return u(this.f3314j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence m() {
        return this.f3318n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence n() {
        return this.f3315k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int o() {
        TextView textView = this.f3317m;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList p() {
        TextView textView = this.f3317m;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence q() {
        return this.f3321q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int r() {
        TextView textView = this.f3323s;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s() {
        this.f3315k = null;
        g();
        if (this.f3313i == 1) {
            this.f3314j = (!this.f3322r || TextUtils.isEmpty(this.f3321q)) ? 0 : 2;
        }
        N(this.f3313i, this.f3314j, K(this.f3317m, null));
    }

    void t() {
        g();
        int i4 = this.f3313i;
        if (i4 == 2) {
            this.f3314j = 0;
        }
        N(i4, this.f3314j, K(this.f3323s, null));
    }

    boolean v(int i4) {
        return i4 == 0 || i4 == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean w() {
        return this.f3316l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean x() {
        return this.f3322r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(TextView textView, int i4) {
        FrameLayout frameLayout;
        if (this.f3307c == null) {
            return;
        }
        if (!v(i4) || (frameLayout = this.f3309e) == null) {
            this.f3307c.removeView(textView);
        } else {
            int i5 = this.f3310f - 1;
            this.f3310f = i5;
            J(frameLayout, i5);
            this.f3309e.removeView(textView);
        }
        int i6 = this.f3308d - 1;
        this.f3308d = i6;
        J(this.f3307c, i6);
    }
}
