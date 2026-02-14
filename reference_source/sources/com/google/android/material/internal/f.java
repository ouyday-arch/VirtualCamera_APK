package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<b> f3155a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private b f3156b = null;

    /* renamed from: c, reason: collision with root package name */
    ValueAnimator f3157c = null;

    /* renamed from: d, reason: collision with root package name */
    private final Animator.AnimatorListener f3158d = new a();

    /* loaded from: classes.dex */
    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f fVar = f.this;
            if (fVar.f3157c == animator) {
                fVar.f3157c = null;
            }
        }
    }

    /* loaded from: classes.dex */
    static class b {

        /* renamed from: a, reason: collision with root package name */
        final int[] f3160a;

        /* renamed from: b, reason: collision with root package name */
        final ValueAnimator f3161b;

        b(int[] iArr, ValueAnimator valueAnimator) {
            this.f3160a = iArr;
            this.f3161b = valueAnimator;
        }
    }

    public void a(int[] iArr, ValueAnimator valueAnimator) {
        b bVar = new b(iArr, valueAnimator);
        valueAnimator.addListener(this.f3158d);
        this.f3155a.add(bVar);
    }
}
