package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;
import m0.f;
import n0.h;
import n0.i;
import n0.j;
import q0.d;
import y.p;

/* loaded from: classes.dex */
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {

    /* renamed from: c, reason: collision with root package name */
    private final Rect f3347c;

    /* renamed from: d, reason: collision with root package name */
    private final RectF f3348d;

    /* renamed from: e, reason: collision with root package name */
    private final RectF f3349e;

    /* renamed from: f, reason: collision with root package name */
    private final int[] f3350f;

    /* renamed from: g, reason: collision with root package name */
    private float f3351g;

    /* renamed from: h, reason: collision with root package name */
    private float f3352h;

    /* loaded from: classes.dex */
    class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f3353a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f3354b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f3355c;

        a(boolean z4, View view, View view2) {
            this.f3353a = z4;
            this.f3354b = view;
            this.f3355c = view2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f3353a) {
                return;
            }
            this.f3354b.setVisibility(4);
            this.f3355c.setAlpha(1.0f);
            this.f3355c.setVisibility(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.f3353a) {
                this.f3354b.setVisibility(0);
                this.f3355c.setAlpha(0.0f);
                this.f3355c.setVisibility(4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f3357a;

        b(View view) {
            this.f3357a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f3357a.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ q0.d f3359a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Drawable f3360b;

        c(q0.d dVar, Drawable drawable) {
            this.f3359a = dVar;
            this.f3360b = drawable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f3359a.setCircularRevealOverlayDrawable(null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f3359a.setCircularRevealOverlayDrawable(this.f3360b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ q0.d f3362a;

        d(q0.d dVar) {
            this.f3362a = dVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d.e revealInfo = this.f3362a.getRevealInfo();
            revealInfo.f5532c = Float.MAX_VALUE;
            this.f3362a.setRevealInfo(revealInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public h f3364a;

        /* renamed from: b, reason: collision with root package name */
        public j f3365b;
    }

    public FabTransformationBehavior() {
        this.f3347c = new Rect();
        this.f3348d = new RectF();
        this.f3349e = new RectF();
        this.f3350f = new int[2];
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3347c = new Rect();
        this.f3348d = new RectF();
        this.f3349e = new RectF();
        this.f3350f = new int[2];
    }

    private ViewGroup K(View view) {
        View findViewById = view.findViewById(f.f5001n);
        return findViewById != null ? f0(findViewById) : ((view instanceof f1.b) || (view instanceof f1.a)) ? f0(((ViewGroup) view).getChildAt(0)) : f0(view);
    }

    private void L(View view, e eVar, i iVar, i iVar2, float f4, float f5, float f6, float f7, RectF rectF) {
        float S = S(eVar, iVar, f4, f6);
        float S2 = S(eVar, iVar2, f5, f7);
        Rect rect = this.f3347c;
        view.getWindowVisibleDisplayFrame(rect);
        RectF rectF2 = this.f3348d;
        rectF2.set(rect);
        RectF rectF3 = this.f3349e;
        T(view, rectF3);
        rectF3.offset(S, S2);
        rectF3.intersect(rectF2);
        rectF.set(rectF3);
    }

    private void M(View view, RectF rectF) {
        T(view, rectF);
        rectF.offset(this.f3351g, this.f3352h);
    }

    private Pair<i, i> N(float f4, float f5, boolean z4, e eVar) {
        i e4;
        h hVar;
        String str;
        if (f4 == 0.0f || f5 == 0.0f) {
            e4 = eVar.f3364a.e("translationXLinear");
            hVar = eVar.f3364a;
            str = "translationYLinear";
        } else if ((!z4 || f5 >= 0.0f) && (z4 || f5 <= 0.0f)) {
            e4 = eVar.f3364a.e("translationXCurveDownwards");
            hVar = eVar.f3364a;
            str = "translationYCurveDownwards";
        } else {
            e4 = eVar.f3364a.e("translationXCurveUpwards");
            hVar = eVar.f3364a;
            str = "translationYCurveUpwards";
        }
        return new Pair<>(e4, hVar.e(str));
    }

    private float O(View view, View view2, j jVar) {
        RectF rectF = this.f3348d;
        RectF rectF2 = this.f3349e;
        M(view, rectF);
        T(view2, rectF2);
        rectF2.offset(-Q(view, view2, jVar), 0.0f);
        return rectF.centerX() - rectF2.left;
    }

    private float P(View view, View view2, j jVar) {
        RectF rectF = this.f3348d;
        RectF rectF2 = this.f3349e;
        M(view, rectF);
        T(view2, rectF2);
        rectF2.offset(0.0f, -R(view, view2, jVar));
        return rectF.centerY() - rectF2.top;
    }

    private float Q(View view, View view2, j jVar) {
        float centerX;
        float centerX2;
        float f4;
        RectF rectF = this.f3348d;
        RectF rectF2 = this.f3349e;
        M(view, rectF);
        T(view2, rectF2);
        int i4 = jVar.f5258a & 7;
        if (i4 == 1) {
            centerX = rectF2.centerX();
            centerX2 = rectF.centerX();
        } else if (i4 == 3) {
            centerX = rectF2.left;
            centerX2 = rectF.left;
        } else {
            if (i4 != 5) {
                f4 = 0.0f;
                return f4 + jVar.f5259b;
            }
            centerX = rectF2.right;
            centerX2 = rectF.right;
        }
        f4 = centerX - centerX2;
        return f4 + jVar.f5259b;
    }

    private float R(View view, View view2, j jVar) {
        float centerY;
        float centerY2;
        float f4;
        RectF rectF = this.f3348d;
        RectF rectF2 = this.f3349e;
        M(view, rectF);
        T(view2, rectF2);
        int i4 = jVar.f5258a & 112;
        if (i4 == 16) {
            centerY = rectF2.centerY();
            centerY2 = rectF.centerY();
        } else if (i4 == 48) {
            centerY = rectF2.top;
            centerY2 = rectF.top;
        } else {
            if (i4 != 80) {
                f4 = 0.0f;
                return f4 + jVar.f5260c;
            }
            centerY = rectF2.bottom;
            centerY2 = rectF.bottom;
        }
        f4 = centerY - centerY2;
        return f4 + jVar.f5260c;
    }

    private float S(e eVar, i iVar, float f4, float f5) {
        long c5 = iVar.c();
        long d5 = iVar.d();
        i e4 = eVar.f3364a.e("expansion");
        return n0.a.a(f4, f5, iVar.e().getInterpolation(((float) (((e4.c() + e4.d()) + 17) - c5)) / ((float) d5)));
    }

    private void T(View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        view.getLocationInWindow(this.f3350f);
        rectF.offsetTo(r0[0], r0[1]);
        rectF.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
    }

    private void U(View view, View view2, boolean z4, boolean z5, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ViewGroup K;
        ObjectAnimator ofFloat;
        if (view2 instanceof ViewGroup) {
            if (((view2 instanceof q0.d) && q0.c.f5525a == 0) || (K = K(view2)) == null) {
                return;
            }
            if (z4) {
                if (!z5) {
                    n0.d.f5244a.set(K, Float.valueOf(0.0f));
                }
                ofFloat = ObjectAnimator.ofFloat(K, n0.d.f5244a, 1.0f);
            } else {
                ofFloat = ObjectAnimator.ofFloat(K, n0.d.f5244a, 0.0f);
            }
            eVar.f3364a.e("contentFade").a(ofFloat);
            list.add(ofFloat);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void V(View view, View view2, boolean z4, boolean z5, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofInt;
        if (view2 instanceof q0.d) {
            q0.d dVar = (q0.d) view2;
            int d02 = d0(view);
            int i4 = 16777215 & d02;
            if (z4) {
                if (!z5) {
                    dVar.setCircularRevealScrimColor(d02);
                }
                ofInt = ObjectAnimator.ofInt(dVar, d.C0070d.f5529a, i4);
            } else {
                ofInt = ObjectAnimator.ofInt(dVar, d.C0070d.f5529a, d02);
            }
            ofInt.setEvaluator(n0.c.b());
            eVar.f3364a.e("color").a(ofInt);
            list.add(ofInt);
        }
    }

    private void W(View view, View view2, boolean z4, e eVar, List<Animator> list) {
        float Q = Q(view, view2, eVar.f3365b);
        float R = R(view, view2, eVar.f3365b);
        Pair<i, i> N = N(Q, R, z4, eVar);
        i iVar = (i) N.first;
        i iVar2 = (i) N.second;
        Property property = View.TRANSLATION_X;
        float[] fArr = new float[1];
        if (!z4) {
            Q = this.f3351g;
        }
        fArr[0] = Q;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, fArr);
        Property property2 = View.TRANSLATION_Y;
        float[] fArr2 = new float[1];
        if (!z4) {
            R = this.f3352h;
        }
        fArr2[0] = R;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, (Property<View, Float>) property2, fArr2);
        iVar.a(ofFloat);
        iVar2.a(ofFloat2);
        list.add(ofFloat);
        list.add(ofFloat2);
    }

    @TargetApi(21)
    private void X(View view, View view2, boolean z4, boolean z5, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofFloat;
        float p4 = p.p(view2) - p.p(view);
        if (z4) {
            if (!z5) {
                view2.setTranslationZ(-p4);
            }
            ofFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, 0.0f);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, -p4);
        }
        eVar.f3364a.e("elevation").a(ofFloat);
        list.add(ofFloat);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void Y(View view, View view2, boolean z4, boolean z5, e eVar, float f4, float f5, List<Animator> list, List<Animator.AnimatorListener> list2) {
        Animator animator;
        if (view2 instanceof q0.d) {
            q0.d dVar = (q0.d) view2;
            float O = O(view, view2, eVar.f3365b);
            float P = P(view, view2, eVar.f3365b);
            ((FloatingActionButton) view).i(this.f3347c);
            float width = this.f3347c.width() / 2.0f;
            i e4 = eVar.f3364a.e("expansion");
            if (z4) {
                if (!z5) {
                    dVar.setRevealInfo(new d.e(O, P, width));
                }
                if (z5) {
                    width = dVar.getRevealInfo().f5532c;
                }
                animator = q0.a.a(dVar, O, P, w0.a.b(O, P, 0.0f, 0.0f, f4, f5));
                animator.addListener(new d(dVar));
                b0(view2, e4.c(), (int) O, (int) P, width, list);
            } else {
                float f6 = dVar.getRevealInfo().f5532c;
                Animator a5 = q0.a.a(dVar, O, P, width);
                int i4 = (int) O;
                int i5 = (int) P;
                b0(view2, e4.c(), i4, i5, f6, list);
                a0(view2, e4.c(), e4.d(), eVar.f3364a.f(), i4, i5, width, list);
                animator = a5;
            }
            e4.a(animator);
            list.add(animator);
            list2.add(q0.a.b(dVar));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void Z(View view, View view2, boolean z4, boolean z5, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofInt;
        if ((view2 instanceof q0.d) && (view instanceof ImageView)) {
            q0.d dVar = (q0.d) view2;
            Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable == null) {
                return;
            }
            drawable.mutate();
            if (z4) {
                if (!z5) {
                    drawable.setAlpha(255);
                }
                ofInt = ObjectAnimator.ofInt(drawable, n0.e.f5245b, 0);
            } else {
                ofInt = ObjectAnimator.ofInt(drawable, n0.e.f5245b, 255);
            }
            ofInt.addUpdateListener(new b(view2));
            eVar.f3364a.e("iconFade").a(ofInt);
            list.add(ofInt);
            list2.add(new c(dVar, drawable));
        }
    }

    private void a0(View view, long j4, long j5, long j6, int i4, int i5, float f4, List<Animator> list) {
        long j7 = j4 + j5;
        if (j7 < j6) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i4, i5, f4, f4);
            createCircularReveal.setStartDelay(j7);
            createCircularReveal.setDuration(j6 - j7);
            list.add(createCircularReveal);
        }
    }

    private void b0(View view, long j4, int i4, int i5, float f4, List<Animator> list) {
        if (j4 > 0) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i4, i5, f4, f4);
            createCircularReveal.setStartDelay(0L);
            createCircularReveal.setDuration(j4);
            list.add(createCircularReveal);
        }
    }

    private void c0(View view, View view2, boolean z4, boolean z5, e eVar, List<Animator> list, List<Animator.AnimatorListener> list2, RectF rectF) {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        float Q = Q(view, view2, eVar.f3365b);
        float R = R(view, view2, eVar.f3365b);
        Pair<i, i> N = N(Q, R, z4, eVar);
        i iVar = (i) N.first;
        i iVar2 = (i) N.second;
        if (z4) {
            if (!z5) {
                view2.setTranslationX(-Q);
                view2.setTranslationY(-R);
            }
            ofFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, 0.0f);
            ofFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, 0.0f);
            L(view2, eVar, iVar, iVar2, -Q, -R, 0.0f, 0.0f, rectF);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, -Q);
            ofFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, -R);
        }
        iVar.a(ofFloat);
        iVar2.a(ofFloat2);
        list.add(ofFloat);
        list.add(ofFloat2);
    }

    private int d0(View view) {
        ColorStateList l4 = p.l(view);
        if (l4 != null) {
            return l4.getColorForState(view.getDrawableState(), l4.getDefaultColor());
        }
        return 0;
    }

    private ViewGroup f0(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    protected AnimatorSet J(View view, View view2, boolean z4, boolean z5) {
        e e02 = e0(view2.getContext(), z4);
        if (z4) {
            this.f3351g = view.getTranslationX();
            this.f3352h = view.getTranslationY();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        X(view, view2, z4, z5, e02, arrayList, arrayList2);
        RectF rectF = this.f3348d;
        c0(view, view2, z4, z5, e02, arrayList, arrayList2, rectF);
        float width = rectF.width();
        float height = rectF.height();
        W(view, view2, z4, e02, arrayList);
        Z(view, view2, z4, z5, e02, arrayList, arrayList2);
        Y(view, view2, z4, z5, e02, width, height, arrayList, arrayList2);
        V(view, view2, z4, z5, e02, arrayList, arrayList2);
        U(view, view2, z4, z5, e02, arrayList, arrayList2);
        AnimatorSet animatorSet = new AnimatorSet();
        n0.b.a(animatorSet, arrayList);
        animatorSet.addListener(new a(z4, view2, view));
        int size = arrayList2.size();
        for (int i4 = 0; i4 < size; i4++) {
            animatorSet.addListener(arrayList2.get(i4));
        }
        return animatorSet;
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean e(CoordinatorLayout coordinatorLayout, View view, View view2) {
        if (view.getVisibility() == 8) {
            throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        }
        if (!(view2 instanceof FloatingActionButton)) {
            return false;
        }
        int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
        return expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId();
    }

    protected abstract e e0(Context context, boolean z4);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void g(CoordinatorLayout.f fVar) {
        if (fVar.f1310h == 0) {
            fVar.f1310h = 80;
        }
    }
}
