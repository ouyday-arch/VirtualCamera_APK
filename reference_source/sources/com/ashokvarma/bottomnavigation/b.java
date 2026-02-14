package com.ashokvarma.bottomnavigation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewAnimationUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f2521a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f2522b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f2523c;

        a(View view, int i4, View view2) {
            this.f2521a = view;
            this.f2522b = i4;
            this.f2523c = view2;
        }

        private void a() {
            this.f2521a.setBackgroundColor(this.f2522b);
            this.f2523c.setVisibility(8);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(c cVar, d dVar, BottomNavigationBar bottomNavigationBar) {
        Drawable e4;
        Context context = bottomNavigationBar.getContext();
        dVar.n(cVar.f(context));
        dVar.h(cVar.c(context));
        int a5 = cVar.a(context);
        int d5 = cVar.d(context);
        if (a5 == 0) {
            a5 = bottomNavigationBar.getActiveColor();
        }
        dVar.f(a5);
        if (d5 != 0) {
            dVar.i(d5);
        } else {
            dVar.i(bottomNavigationBar.getInActiveColor());
        }
        if (cVar.g() && (e4 = cVar.e(context)) != null) {
            dVar.j(e4);
        }
        dVar.m(bottomNavigationBar.getBackgroundColor());
        cVar.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int[] b(Context context, int i4, int i5, boolean z4) {
        int[] iArr = new int[2];
        int dimension = (int) context.getResources().getDimension(g.f2579g);
        Resources resources = context.getResources();
        int i6 = g.f2578f;
        int dimension2 = (int) resources.getDimension(i6);
        int i7 = i4 / i5;
        if (i7 < dimension && z4) {
            dimension2 = (int) context.getResources().getDimension(i6);
        } else if (i7 <= dimension2) {
            dimension2 = i7;
        }
        iArr[0] = dimension2;
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int[] c(Context context, int i4, int i5, boolean z4) {
        int i6;
        int i7;
        double d5;
        int[] iArr = new int[2];
        int dimension = (int) context.getResources().getDimension(g.f2587o);
        int dimension2 = (int) context.getResources().getDimension(g.f2586n);
        double d6 = dimension;
        double d7 = i5;
        double d8 = 0.5d + d7;
        double d9 = dimension2;
        double d10 = 0.75d + d7;
        double d11 = d9 * d10;
        double d12 = i4;
        if (d12 < d6 * d8) {
            if (z4) {
                i7 = (int) (d6 * 1.5d);
                i6 = dimension;
            } else {
                i6 = (int) (d12 / d8);
                d5 = i6 * 1.5d;
                i7 = (int) d5;
            }
        } else if (d12 > d11) {
            i7 = (int) (d9 * 1.75d);
            i6 = dimension2;
        } else {
            double d13 = d7 + 0.625d;
            double d14 = d6 * d13;
            double d15 = d6 * d10;
            int i8 = (int) (d12 / d8);
            int i9 = (int) (i8 * 1.5d);
            if (d12 > d14) {
                int i10 = (int) (d12 / d13);
                int i11 = (int) (i10 * 1.625d);
                if (d12 > d15) {
                    i6 = (int) (d12 / d10);
                    d5 = i6 * 1.75d;
                    i7 = (int) d5;
                } else {
                    i6 = i10;
                    i7 = i11;
                }
            } else {
                i6 = i8;
                i7 = i9;
            }
        }
        iArr[0] = i6;
        iArr[1] = i7;
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(View view, View view2, View view3, int i4, int i5) {
        int x4 = (int) (view.getX() + (view.getMeasuredWidth() / 2));
        int measuredHeight = view.getMeasuredHeight() / 2;
        int width = view2.getWidth();
        view2.clearAnimation();
        view3.clearAnimation();
        Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view3, x4, measuredHeight, 0.0f, width);
        createCircularReveal.setDuration(i5);
        createCircularReveal.addListener(new a(view2, i4, view3));
        view3.setBackgroundColor(i4);
        view3.setVisibility(0);
        createCircularReveal.start();
    }
}
