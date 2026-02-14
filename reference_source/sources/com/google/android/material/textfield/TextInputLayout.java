package com.google.android.material.textfield;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.e0;
import androidx.appcompat.widget.z;
import b1.k;
import com.google.android.material.internal.CheckableImageButton;
import java.util.Iterator;
import java.util.LinkedHashSet;
import m0.i;
import m0.j;
import y.p;

/* loaded from: classes.dex */
public class TextInputLayout extends LinearLayout {
    private static final int I0 = j.f5040f;
    private CharSequence A;
    private final int A0;
    private boolean B;
    private int B0;
    private b1.g C;
    private boolean C0;
    private b1.g D;
    final com.google.android.material.internal.a D0;
    private k E;
    private boolean E0;
    private final int F;
    private ValueAnimator F0;
    private int G;
    private boolean G0;
    private final int H;
    private boolean H0;
    private int I;
    private final int J;
    private final int K;
    private int L;
    private int M;
    private final Rect N;
    private final Rect O;
    private final RectF P;
    private Typeface Q;
    private final CheckableImageButton R;
    private ColorStateList S;
    private boolean T;
    private PorterDuff.Mode U;
    private boolean V;
    private Drawable W;

    /* renamed from: a0, reason: collision with root package name */
    private int f3207a0;

    /* renamed from: b, reason: collision with root package name */
    private final FrameLayout f3208b;

    /* renamed from: b0, reason: collision with root package name */
    private View.OnLongClickListener f3209b0;

    /* renamed from: c, reason: collision with root package name */
    private final LinearLayout f3210c;

    /* renamed from: c0, reason: collision with root package name */
    private final LinkedHashSet<f> f3211c0;

    /* renamed from: d, reason: collision with root package name */
    private final LinearLayout f3212d;

    /* renamed from: d0, reason: collision with root package name */
    private int f3213d0;

    /* renamed from: e, reason: collision with root package name */
    private final FrameLayout f3214e;

    /* renamed from: e0, reason: collision with root package name */
    private final SparseArray<com.google.android.material.textfield.e> f3215e0;

    /* renamed from: f, reason: collision with root package name */
    EditText f3216f;

    /* renamed from: f0, reason: collision with root package name */
    private final CheckableImageButton f3217f0;

    /* renamed from: g, reason: collision with root package name */
    private CharSequence f3218g;

    /* renamed from: g0, reason: collision with root package name */
    private final LinkedHashSet<g> f3219g0;

    /* renamed from: h, reason: collision with root package name */
    private final com.google.android.material.textfield.f f3220h;

    /* renamed from: h0, reason: collision with root package name */
    private ColorStateList f3221h0;

    /* renamed from: i, reason: collision with root package name */
    boolean f3222i;

    /* renamed from: i0, reason: collision with root package name */
    private boolean f3223i0;

    /* renamed from: j, reason: collision with root package name */
    private int f3224j;

    /* renamed from: j0, reason: collision with root package name */
    private PorterDuff.Mode f3225j0;

    /* renamed from: k, reason: collision with root package name */
    private boolean f3226k;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f3227k0;

    /* renamed from: l, reason: collision with root package name */
    private TextView f3228l;

    /* renamed from: l0, reason: collision with root package name */
    private Drawable f3229l0;

    /* renamed from: m, reason: collision with root package name */
    private int f3230m;

    /* renamed from: m0, reason: collision with root package name */
    private int f3231m0;

    /* renamed from: n, reason: collision with root package name */
    private int f3232n;

    /* renamed from: n0, reason: collision with root package name */
    private Drawable f3233n0;

    /* renamed from: o, reason: collision with root package name */
    private CharSequence f3234o;

    /* renamed from: o0, reason: collision with root package name */
    private View.OnLongClickListener f3235o0;

    /* renamed from: p, reason: collision with root package name */
    private boolean f3236p;

    /* renamed from: p0, reason: collision with root package name */
    private final CheckableImageButton f3237p0;

    /* renamed from: q, reason: collision with root package name */
    private TextView f3238q;

    /* renamed from: q0, reason: collision with root package name */
    private ColorStateList f3239q0;

    /* renamed from: r, reason: collision with root package name */
    private ColorStateList f3240r;

    /* renamed from: r0, reason: collision with root package name */
    private ColorStateList f3241r0;

    /* renamed from: s, reason: collision with root package name */
    private int f3242s;

    /* renamed from: s0, reason: collision with root package name */
    private ColorStateList f3243s0;

    /* renamed from: t, reason: collision with root package name */
    private ColorStateList f3244t;

    /* renamed from: t0, reason: collision with root package name */
    private int f3245t0;

    /* renamed from: u, reason: collision with root package name */
    private ColorStateList f3246u;

    /* renamed from: u0, reason: collision with root package name */
    private int f3247u0;

    /* renamed from: v, reason: collision with root package name */
    private CharSequence f3248v;

    /* renamed from: v0, reason: collision with root package name */
    private int f3249v0;

    /* renamed from: w, reason: collision with root package name */
    private final TextView f3250w;

    /* renamed from: w0, reason: collision with root package name */
    private ColorStateList f3251w0;

    /* renamed from: x, reason: collision with root package name */
    private CharSequence f3252x;

    /* renamed from: x0, reason: collision with root package name */
    private int f3253x0;

    /* renamed from: y, reason: collision with root package name */
    private final TextView f3254y;

    /* renamed from: y0, reason: collision with root package name */
    private final int f3255y0;

    /* renamed from: z, reason: collision with root package name */
    private boolean f3256z;

    /* renamed from: z0, reason: collision with root package name */
    private final int f3257z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TextInputLayout.this.o0(!r0.H0);
            TextInputLayout textInputLayout = TextInputLayout.this;
            if (textInputLayout.f3222i) {
                textInputLayout.g0(editable.length());
            }
            if (TextInputLayout.this.f3236p) {
                TextInputLayout.this.s0(editable.length());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.f3217f0.performClick();
            TextInputLayout.this.f3217f0.jumpDrawablesToCurrentState();
        }
    }

    /* loaded from: classes.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.f3216f.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TextInputLayout.this.D0.V(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: classes.dex */
    public static class e extends y.a {

        /* renamed from: d, reason: collision with root package name */
        private final TextInputLayout f3262d;

        public e(TextInputLayout textInputLayout) {
            this.f3262d = textInputLayout;
        }

        @Override // y.a
        public void g(View view, z.c cVar) {
            super.g(view, cVar);
            EditText editText = this.f3262d.getEditText();
            CharSequence text = editText != null ? editText.getText() : null;
            CharSequence hint = this.f3262d.getHint();
            CharSequence helperText = this.f3262d.getHelperText();
            CharSequence error = this.f3262d.getError();
            int counterMaxLength = this.f3262d.getCounterMaxLength();
            CharSequence counterOverflowDescription = this.f3262d.getCounterOverflowDescription();
            boolean z4 = !TextUtils.isEmpty(text);
            boolean z5 = !TextUtils.isEmpty(hint);
            boolean z6 = !TextUtils.isEmpty(helperText);
            boolean z7 = !TextUtils.isEmpty(error);
            boolean z8 = z7 || !TextUtils.isEmpty(counterOverflowDescription);
            String charSequence = z5 ? hint.toString() : "";
            StringBuilder sb = new StringBuilder();
            sb.append(charSequence);
            sb.append(((z7 || z6) && !TextUtils.isEmpty(charSequence)) ? ", " : "");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb2);
            if (z7) {
                helperText = error;
            } else if (!z6) {
                helperText = "";
            }
            sb3.append((Object) helperText);
            String sb4 = sb3.toString();
            if (z4) {
                cVar.q0(text);
            } else if (!TextUtils.isEmpty(sb4)) {
                cVar.q0(sb4);
            }
            if (!TextUtils.isEmpty(sb4)) {
                if (Build.VERSION.SDK_INT >= 26) {
                    cVar.g0(sb4);
                } else {
                    if (z4) {
                        sb4 = ((Object) text) + ", " + sb4;
                    }
                    cVar.q0(sb4);
                }
                cVar.o0(!z4);
            }
            if (text == null || text.length() != counterMaxLength) {
                counterMaxLength = -1;
            }
            cVar.h0(counterMaxLength);
            if (z8) {
                if (!z7) {
                    error = counterOverflowDescription;
                }
                cVar.c0(error);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface f {
        void a(TextInputLayout textInputLayout);
    }

    /* loaded from: classes.dex */
    public interface g {
        void a(TextInputLayout textInputLayout, int i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class h extends b0.a {
        public static final Parcelable.Creator<h> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name */
        CharSequence f3263d;

        /* renamed from: e, reason: collision with root package name */
        boolean f3264e;

        /* loaded from: classes.dex */
        static class a implements Parcelable.ClassLoaderCreator<h> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public h createFromParcel(Parcel parcel) {
                return new h(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public h createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new h(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public h[] newArray(int i4) {
                return new h[i4];
            }
        }

        h(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f3263d = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f3264e = parcel.readInt() == 1;
        }

        h(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.f3263d) + "}";
        }

        @Override // b0.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            TextUtils.writeToParcel(this.f3263d, parcel, i4);
            parcel.writeInt(this.f3264e ? 1 : 0);
        }
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, m0.b.f4958z);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v39 */
    /* JADX WARN: Type inference failed for: r2v40, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r2v74 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public TextInputLayout(android.content.Context r28, android.util.AttributeSet r29, int r30) {
        /*
            Method dump skipped, instructions count: 1462
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    private void A() {
        Iterator<f> it = this.f3211c0.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    private void B(int i4) {
        Iterator<g> it = this.f3219g0.iterator();
        while (it.hasNext()) {
            it.next().a(this, i4);
        }
    }

    private void C(Canvas canvas) {
        b1.g gVar = this.D;
        if (gVar != null) {
            Rect bounds = gVar.getBounds();
            bounds.top = bounds.bottom - this.I;
            this.D.draw(canvas);
        }
    }

    private void D(Canvas canvas) {
        if (this.f3256z) {
            this.D0.j(canvas);
        }
    }

    private void E(boolean z4) {
        ValueAnimator valueAnimator = this.F0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.F0.cancel();
        }
        if (z4 && this.E0) {
            h(0.0f);
        } else {
            this.D0.V(0.0f);
        }
        if (z() && ((com.google.android.material.textfield.c) this.C).g0()) {
            x();
        }
        this.C0 = true;
        I();
        u0();
        x0();
    }

    private int F(int i4, boolean z4) {
        int compoundPaddingLeft = i4 + this.f3216f.getCompoundPaddingLeft();
        return (this.f3248v == null || z4) ? compoundPaddingLeft : (compoundPaddingLeft - this.f3250w.getMeasuredWidth()) + this.f3250w.getPaddingLeft();
    }

    private int G(int i4, boolean z4) {
        int compoundPaddingRight = i4 - this.f3216f.getCompoundPaddingRight();
        return (this.f3248v == null || !z4) ? compoundPaddingRight : compoundPaddingRight + this.f3250w.getMeasuredWidth() + this.f3250w.getPaddingRight();
    }

    private boolean H() {
        return this.f3213d0 != 0;
    }

    private void I() {
        TextView textView = this.f3238q;
        if (textView == null || !this.f3236p) {
            return;
        }
        textView.setText((CharSequence) null);
        this.f3238q.setVisibility(4);
    }

    private boolean K() {
        return this.f3237p0.getVisibility() == 0;
    }

    private boolean O() {
        return this.G == 1 && this.f3216f.getMinLines() <= 1;
    }

    private void Q() {
        o();
        U();
        y0();
        if (this.G != 0) {
            n0();
        }
    }

    private void R() {
        if (z()) {
            RectF rectF = this.P;
            this.D0.m(rectF, this.f3216f.getWidth(), this.f3216f.getGravity());
            k(rectF);
            rectF.offset(-getPaddingLeft(), -getPaddingTop());
            ((com.google.android.material.textfield.c) this.C).m0(rectF);
        }
    }

    private static void S(ViewGroup viewGroup, boolean z4) {
        int childCount = viewGroup.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = viewGroup.getChildAt(i4);
            childAt.setEnabled(z4);
            if (childAt instanceof ViewGroup) {
                S((ViewGroup) childAt, z4);
            }
        }
    }

    private void T() {
        TextView textView = this.f3238q;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    private void U() {
        if (b0()) {
            p.d0(this.f3216f, this.C);
        }
    }

    private static void V(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        boolean C = p.C(checkableImageButton);
        boolean z4 = onLongClickListener != null;
        boolean z5 = C || z4;
        checkableImageButton.setFocusable(z5);
        checkableImageButton.setClickable(C);
        checkableImageButton.setPressable(C);
        checkableImageButton.setLongClickable(z4);
        p.j0(checkableImageButton, z5 ? 1 : 2);
    }

    private static void W(CheckableImageButton checkableImageButton, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnClickListener(onClickListener);
        V(checkableImageButton, onLongClickListener);
    }

    private static void X(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        V(checkableImageButton, onLongClickListener);
    }

    private boolean Z() {
        return (this.f3237p0.getVisibility() == 0 || ((H() && J()) || this.f3252x != null)) && this.f3212d.getMeasuredWidth() > 0;
    }

    private boolean a0() {
        return !(getStartIconDrawable() == null && this.f3248v == null) && this.f3210c.getMeasuredWidth() > 0;
    }

    private boolean b0() {
        EditText editText = this.f3216f;
        return (editText == null || this.C == null || editText.getBackground() != null || this.G == 0) ? false : true;
    }

    private void c0() {
        TextView textView = this.f3238q;
        if (textView == null || !this.f3236p) {
            return;
        }
        textView.setText(this.f3234o);
        this.f3238q.setVisibility(0);
        this.f3238q.bringToFront();
    }

    private void d0(boolean z4) {
        if (!z4 || getEndIconDrawable() == null) {
            l();
            return;
        }
        Drawable mutate = r.a.m(getEndIconDrawable()).mutate();
        r.a.i(mutate, this.f3220h.o());
        this.f3217f0.setImageDrawable(mutate);
    }

    private void e0(Rect rect) {
        b1.g gVar = this.D;
        if (gVar != null) {
            int i4 = rect.bottom;
            gVar.setBounds(rect.left, i4 - this.K, rect.right, i4);
        }
    }

    private void f0() {
        if (this.f3228l != null) {
            EditText editText = this.f3216f;
            g0(editText == null ? 0 : editText.getText().length());
        }
    }

    private void g() {
        TextView textView = this.f3238q;
        if (textView != null) {
            this.f3208b.addView(textView);
            this.f3238q.setVisibility(0);
        }
    }

    private com.google.android.material.textfield.e getEndIconDelegate() {
        com.google.android.material.textfield.e eVar = this.f3215e0.get(this.f3213d0);
        return eVar != null ? eVar : this.f3215e0.get(0);
    }

    private CheckableImageButton getEndIconToUpdateDummyDrawable() {
        if (this.f3237p0.getVisibility() == 0) {
            return this.f3237p0;
        }
        if (H() && J()) {
            return this.f3217f0;
        }
        return null;
    }

    private static void h0(Context context, TextView textView, int i4, int i5, boolean z4) {
        textView.setContentDescription(context.getString(z4 ? i.f5024b : i.f5023a, Integer.valueOf(i4), Integer.valueOf(i5)));
    }

    private void i() {
        b1.g gVar = this.C;
        if (gVar == null) {
            return;
        }
        gVar.setShapeAppearanceModel(this.E);
        if (v()) {
            this.C.Z(this.I, this.L);
        }
        int p4 = p();
        this.M = p4;
        this.C.V(ColorStateList.valueOf(p4));
        if (this.f3213d0 == 3) {
            this.f3216f.getBackground().invalidateSelf();
        }
        j();
        invalidate();
    }

    private void i0() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        TextView textView = this.f3228l;
        if (textView != null) {
            Y(textView, this.f3226k ? this.f3230m : this.f3232n);
            if (!this.f3226k && (colorStateList2 = this.f3244t) != null) {
                this.f3228l.setTextColor(colorStateList2);
            }
            if (!this.f3226k || (colorStateList = this.f3246u) == null) {
                return;
            }
            this.f3228l.setTextColor(colorStateList);
        }
    }

    private void j() {
        if (this.D == null) {
            return;
        }
        if (w()) {
            this.D.V(ColorStateList.valueOf(this.L));
        }
        invalidate();
    }

    private boolean j0() {
        boolean z4;
        if (this.f3216f == null) {
            return false;
        }
        boolean z5 = true;
        if (a0()) {
            int measuredWidth = this.f3210c.getMeasuredWidth() - this.f3216f.getPaddingLeft();
            if (this.W == null || this.f3207a0 != measuredWidth) {
                ColorDrawable colorDrawable = new ColorDrawable();
                this.W = colorDrawable;
                this.f3207a0 = measuredWidth;
                colorDrawable.setBounds(0, 0, measuredWidth, 1);
            }
            Drawable[] a5 = androidx.core.widget.i.a(this.f3216f);
            Drawable drawable = a5[0];
            Drawable drawable2 = this.W;
            if (drawable != drawable2) {
                androidx.core.widget.i.i(this.f3216f, drawable2, a5[1], a5[2], a5[3]);
                z4 = true;
            }
            z4 = false;
        } else {
            if (this.W != null) {
                Drawable[] a6 = androidx.core.widget.i.a(this.f3216f);
                androidx.core.widget.i.i(this.f3216f, null, a6[1], a6[2], a6[3]);
                this.W = null;
                z4 = true;
            }
            z4 = false;
        }
        if (Z()) {
            int measuredWidth2 = this.f3254y.getMeasuredWidth() - this.f3216f.getPaddingRight();
            CheckableImageButton endIconToUpdateDummyDrawable = getEndIconToUpdateDummyDrawable();
            if (endIconToUpdateDummyDrawable != null) {
                measuredWidth2 = measuredWidth2 + endIconToUpdateDummyDrawable.getMeasuredWidth() + y.f.b((ViewGroup.MarginLayoutParams) endIconToUpdateDummyDrawable.getLayoutParams());
            }
            Drawable[] a7 = androidx.core.widget.i.a(this.f3216f);
            Drawable drawable3 = this.f3229l0;
            if (drawable3 == null || this.f3231m0 == measuredWidth2) {
                if (drawable3 == null) {
                    ColorDrawable colorDrawable2 = new ColorDrawable();
                    this.f3229l0 = colorDrawable2;
                    this.f3231m0 = measuredWidth2;
                    colorDrawable2.setBounds(0, 0, measuredWidth2, 1);
                }
                Drawable drawable4 = a7[2];
                Drawable drawable5 = this.f3229l0;
                if (drawable4 != drawable5) {
                    this.f3233n0 = a7[2];
                    androidx.core.widget.i.i(this.f3216f, a7[0], a7[1], drawable5, a7[3]);
                } else {
                    z5 = z4;
                }
            } else {
                this.f3231m0 = measuredWidth2;
                drawable3.setBounds(0, 0, measuredWidth2, 1);
                androidx.core.widget.i.i(this.f3216f, a7[0], a7[1], this.f3229l0, a7[3]);
            }
        } else {
            if (this.f3229l0 == null) {
                return z4;
            }
            Drawable[] a8 = androidx.core.widget.i.a(this.f3216f);
            if (a8[2] == this.f3229l0) {
                androidx.core.widget.i.i(this.f3216f, a8[0], a8[1], this.f3233n0, a8[3]);
            } else {
                z5 = z4;
            }
            this.f3229l0 = null;
        }
        return z5;
    }

    private void k(RectF rectF) {
        float f4 = rectF.left;
        int i4 = this.F;
        rectF.left = f4 - i4;
        rectF.top -= i4;
        rectF.right += i4;
        rectF.bottom += i4;
    }

    private void l() {
        m(this.f3217f0, this.f3223i0, this.f3221h0, this.f3227k0, this.f3225j0);
    }

    private boolean l0() {
        int max;
        if (this.f3216f == null || this.f3216f.getMeasuredHeight() >= (max = Math.max(this.f3212d.getMeasuredHeight(), this.f3210c.getMeasuredHeight()))) {
            return false;
        }
        this.f3216f.setMinimumHeight(max);
        return true;
    }

    private void m(CheckableImageButton checkableImageButton, boolean z4, ColorStateList colorStateList, boolean z5, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null && (z4 || z5)) {
            drawable = r.a.m(drawable).mutate();
            if (z4) {
                r.a.j(drawable, colorStateList);
            }
            if (z5) {
                r.a.k(drawable, mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    private void m0(CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() == null || colorStateList == null || !colorStateList.isStateful()) {
            return;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor());
        Drawable mutate = r.a.m(drawable).mutate();
        r.a.j(mutate, ColorStateList.valueOf(colorForState));
        checkableImageButton.setImageDrawable(mutate);
    }

    private void n() {
        m(this.R, this.T, this.S, this.V, this.U);
    }

    private void n0() {
        if (this.G != 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f3208b.getLayoutParams();
            int u4 = u();
            if (u4 != layoutParams.topMargin) {
                layoutParams.topMargin = u4;
                this.f3208b.requestLayout();
            }
        }
    }

    private void o() {
        int i4 = this.G;
        if (i4 == 0) {
            this.C = null;
        } else if (i4 == 1) {
            this.C = new b1.g(this.E);
            this.D = new b1.g();
            return;
        } else {
            if (i4 != 2) {
                throw new IllegalArgumentException(this.G + " is illegal; only @BoxBackgroundMode constants are supported.");
            }
            this.C = (!this.f3256z || (this.C instanceof com.google.android.material.textfield.c)) ? new b1.g(this.E) : new com.google.android.material.textfield.c(this.E);
        }
        this.D = null;
    }

    private int p() {
        return this.G == 1 ? s0.a.e(s0.a.d(this, m0.b.f4943k, 0), this.M) : this.M;
    }

    private void p0(boolean z4, boolean z5) {
        ColorStateList colorStateList;
        com.google.android.material.internal.a aVar;
        TextView textView;
        boolean isEnabled = isEnabled();
        EditText editText = this.f3216f;
        boolean z6 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.f3216f;
        boolean z7 = editText2 != null && editText2.hasFocus();
        boolean k4 = this.f3220h.k();
        ColorStateList colorStateList2 = this.f3241r0;
        if (colorStateList2 != null) {
            this.D0.K(colorStateList2);
            this.D0.R(this.f3241r0);
        }
        if (!isEnabled) {
            ColorStateList colorStateList3 = this.f3241r0;
            int colorForState = colorStateList3 != null ? colorStateList3.getColorForState(new int[]{-16842910}, this.B0) : this.B0;
            this.D0.K(ColorStateList.valueOf(colorForState));
            this.D0.R(ColorStateList.valueOf(colorForState));
        } else if (k4) {
            this.D0.K(this.f3220h.p());
        } else {
            if (this.f3226k && (textView = this.f3228l) != null) {
                aVar = this.D0;
                colorStateList = textView.getTextColors();
            } else if (z7 && (colorStateList = this.f3243s0) != null) {
                aVar = this.D0;
            }
            aVar.K(colorStateList);
        }
        if (z6 || (isEnabled() && (z7 || k4))) {
            if (z5 || this.C0) {
                y(z4);
                return;
            }
            return;
        }
        if (z5 || !this.C0) {
            E(z4);
        }
    }

    private Rect q(Rect rect) {
        int i4;
        int i5;
        if (this.f3216f == null) {
            throw new IllegalStateException();
        }
        Rect rect2 = this.O;
        boolean z4 = p.t(this) == 1;
        rect2.bottom = rect.bottom;
        int i6 = this.G;
        if (i6 == 1) {
            rect2.left = F(rect.left, z4);
            i4 = rect.top + this.H;
        } else {
            if (i6 == 2) {
                rect2.left = rect.left + this.f3216f.getPaddingLeft();
                rect2.top = rect.top - u();
                i5 = rect.right - this.f3216f.getPaddingRight();
                rect2.right = i5;
                return rect2;
            }
            rect2.left = F(rect.left, z4);
            i4 = getPaddingTop();
        }
        rect2.top = i4;
        i5 = G(rect.right, z4);
        rect2.right = i5;
        return rect2;
    }

    private void q0() {
        EditText editText;
        if (this.f3238q == null || (editText = this.f3216f) == null) {
            return;
        }
        this.f3238q.setGravity((editText.getGravity() & (-113)) | 48);
        this.f3238q.setPadding(this.f3216f.getCompoundPaddingLeft(), this.f3216f.getCompoundPaddingTop(), this.f3216f.getCompoundPaddingRight(), this.f3216f.getCompoundPaddingBottom());
    }

    private int r(Rect rect, Rect rect2, float f4) {
        return O() ? (int) (rect2.top + f4) : rect.bottom - this.f3216f.getCompoundPaddingBottom();
    }

    private void r0() {
        EditText editText = this.f3216f;
        s0(editText == null ? 0 : editText.getText().length());
    }

    private int s(Rect rect, float f4) {
        return O() ? (int) (rect.centerY() - (f4 / 2.0f)) : rect.top + this.f3216f.getCompoundPaddingTop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0(int i4) {
        if (i4 != 0 || this.C0) {
            I();
        } else {
            c0();
        }
    }

    private void setEditText(EditText editText) {
        if (this.f3216f != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (this.f3213d0 != 3 && !(editText instanceof TextInputEditText)) {
            Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.f3216f = editText;
        Q();
        setTextInputAccessibilityDelegate(new e(this));
        this.D0.b0(this.f3216f.getTypeface());
        this.D0.T(this.f3216f.getTextSize());
        int gravity = this.f3216f.getGravity();
        this.D0.L((gravity & (-113)) | 48);
        this.D0.S(gravity);
        this.f3216f.addTextChangedListener(new a());
        if (this.f3241r0 == null) {
            this.f3241r0 = this.f3216f.getHintTextColors();
        }
        if (this.f3256z) {
            if (TextUtils.isEmpty(this.A)) {
                CharSequence hint = this.f3216f.getHint();
                this.f3218g = hint;
                setHint(hint);
                this.f3216f.setHint((CharSequence) null);
            }
            this.B = true;
        }
        if (this.f3228l != null) {
            g0(this.f3216f.getText().length());
        }
        k0();
        this.f3220h.e();
        this.f3210c.bringToFront();
        this.f3212d.bringToFront();
        this.f3214e.bringToFront();
        this.f3237p0.bringToFront();
        A();
        t0();
        w0();
        if (!isEnabled()) {
            editText.setEnabled(false);
        }
        p0(false, true);
    }

    private void setErrorIconVisible(boolean z4) {
        this.f3237p0.setVisibility(z4 ? 0 : 8);
        this.f3214e.setVisibility(z4 ? 8 : 0);
        w0();
        if (H()) {
            return;
        }
        j0();
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.A)) {
            return;
        }
        this.A = charSequence;
        this.D0.Z(charSequence);
        if (this.C0) {
            return;
        }
        R();
    }

    private void setPlaceholderTextEnabled(boolean z4) {
        if (this.f3236p == z4) {
            return;
        }
        if (z4) {
            z zVar = new z(getContext());
            this.f3238q = zVar;
            zVar.setId(m0.f.f5009v);
            p.c0(this.f3238q, 1);
            setPlaceholderTextAppearance(this.f3242s);
            setPlaceholderTextColor(this.f3240r);
            g();
        } else {
            T();
            this.f3238q = null;
        }
        this.f3236p = z4;
    }

    private Rect t(Rect rect) {
        if (this.f3216f == null) {
            throw new IllegalStateException();
        }
        Rect rect2 = this.O;
        float u4 = this.D0.u();
        rect2.left = rect.left + this.f3216f.getCompoundPaddingLeft();
        rect2.top = s(rect, u4);
        rect2.right = rect.right - this.f3216f.getCompoundPaddingRight();
        rect2.bottom = r(rect, rect2, u4);
        return rect2;
    }

    private void t0() {
        if (this.f3216f == null) {
            return;
        }
        this.f3250w.setPadding(P() ? 0 : this.f3216f.getPaddingLeft(), this.f3216f.getCompoundPaddingTop(), this.f3250w.getCompoundPaddingRight(), this.f3216f.getCompoundPaddingBottom());
    }

    private int u() {
        float o4;
        if (!this.f3256z) {
            return 0;
        }
        int i4 = this.G;
        if (i4 == 0 || i4 == 1) {
            o4 = this.D0.o();
        } else {
            if (i4 != 2) {
                return 0;
            }
            o4 = this.D0.o() / 2.0f;
        }
        return (int) o4;
    }

    private void u0() {
        this.f3250w.setVisibility((this.f3248v == null || M()) ? 8 : 0);
        j0();
    }

    private boolean v() {
        return this.G == 2 && w();
    }

    private void v0(boolean z4, boolean z5) {
        int defaultColor = this.f3251w0.getDefaultColor();
        int colorForState = this.f3251w0.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, defaultColor);
        int colorForState2 = this.f3251w0.getColorForState(new int[]{R.attr.state_activated, R.attr.state_enabled}, defaultColor);
        if (z4) {
            this.L = colorForState2;
        } else if (z5) {
            this.L = colorForState;
        } else {
            this.L = defaultColor;
        }
    }

    private boolean w() {
        return this.I > -1 && this.L != 0;
    }

    private void w0() {
        if (this.f3216f == null) {
            return;
        }
        TextView textView = this.f3254y;
        textView.setPadding(textView.getPaddingLeft(), this.f3216f.getPaddingTop(), (J() || K()) ? 0 : this.f3216f.getPaddingRight(), this.f3216f.getPaddingBottom());
    }

    private void x() {
        if (z()) {
            ((com.google.android.material.textfield.c) this.C).j0();
        }
    }

    private void x0() {
        int visibility = this.f3254y.getVisibility();
        boolean z4 = (this.f3252x == null || M()) ? false : true;
        this.f3254y.setVisibility(z4 ? 0 : 8);
        if (visibility != this.f3254y.getVisibility()) {
            getEndIconDelegate().c(z4);
        }
        j0();
    }

    private void y(boolean z4) {
        ValueAnimator valueAnimator = this.F0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.F0.cancel();
        }
        if (z4 && this.E0) {
            h(1.0f);
        } else {
            this.D0.V(1.0f);
        }
        this.C0 = false;
        if (z()) {
            R();
        }
        c0();
        u0();
        x0();
    }

    private boolean z() {
        return this.f3256z && !TextUtils.isEmpty(this.A) && (this.C instanceof com.google.android.material.textfield.c);
    }

    public boolean J() {
        return this.f3214e.getVisibility() == 0 && this.f3217f0.getVisibility() == 0;
    }

    public boolean L() {
        return this.f3220h.x();
    }

    final boolean M() {
        return this.C0;
    }

    public boolean N() {
        return this.B;
    }

    public boolean P() {
        return this.R.getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Y(TextView textView, int i4) {
        boolean z4 = true;
        try {
            androidx.core.widget.i.n(textView, i4);
            if (textView.getTextColors().getDefaultColor() != -65281) {
                z4 = false;
            }
        } catch (Exception unused) {
        }
        if (z4) {
            androidx.core.widget.i.n(textView, j.f5035a);
            textView.setTextColor(o.a.b(getContext(), m0.c.f4959a));
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i4, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText)) {
            super.addView(view, i4, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
        this.f3208b.addView(view, layoutParams2);
        this.f3208b.setLayoutParams(layoutParams);
        n0();
        setEditText((EditText) view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i4) {
        EditText editText;
        if (this.f3218g == null || (editText = this.f3216f) == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i4);
            return;
        }
        boolean z4 = this.B;
        this.B = false;
        CharSequence hint = editText.getHint();
        this.f3216f.setHint(this.f3218g);
        try {
            super.dispatchProvideAutofillStructure(viewStructure, i4);
        } finally {
            this.f3216f.setHint(hint);
            this.B = z4;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.H0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.H0 = false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        D(canvas);
        C(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.G0) {
            return;
        }
        this.G0 = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        com.google.android.material.internal.a aVar = this.D0;
        boolean Y = aVar != null ? aVar.Y(drawableState) | false : false;
        if (this.f3216f != null) {
            o0(p.H(this) && isEnabled());
        }
        k0();
        y0();
        if (Y) {
            invalidate();
        }
        this.G0 = false;
    }

    public void e(f fVar) {
        this.f3211c0.add(fVar);
        if (this.f3216f != null) {
            fVar.a(this);
        }
    }

    public void f(g gVar) {
        this.f3219g0.add(gVar);
    }

    void g0(int i4) {
        boolean z4 = this.f3226k;
        int i5 = this.f3224j;
        if (i5 == -1) {
            this.f3228l.setText(String.valueOf(i4));
            this.f3228l.setContentDescription(null);
            this.f3226k = false;
        } else {
            this.f3226k = i4 > i5;
            h0(getContext(), this.f3228l, i4, this.f3224j, this.f3226k);
            if (z4 != this.f3226k) {
                i0();
            }
            this.f3228l.setText(getContext().getString(i.f5025c, Integer.valueOf(i4), Integer.valueOf(this.f3224j)));
        }
        if (this.f3216f == null || z4 == this.f3226k) {
            return;
        }
        o0(false);
        y0();
        k0();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.f3216f;
        return editText != null ? editText.getBaseline() + getPaddingTop() + u() : super.getBaseline();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b1.g getBoxBackground() {
        int i4 = this.G;
        if (i4 == 1 || i4 == 2) {
            return this.C;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.M;
    }

    public int getBoxBackgroundMode() {
        return this.G;
    }

    public float getBoxCornerRadiusBottomEnd() {
        return this.C.s();
    }

    public float getBoxCornerRadiusBottomStart() {
        return this.C.t();
    }

    public float getBoxCornerRadiusTopEnd() {
        return this.C.G();
    }

    public float getBoxCornerRadiusTopStart() {
        return this.C.F();
    }

    public int getBoxStrokeColor() {
        return this.f3249v0;
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.f3251w0;
    }

    public int getCounterMaxLength() {
        return this.f3224j;
    }

    CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (this.f3222i && this.f3226k && (textView = this.f3228l) != null) {
            return textView.getContentDescription();
        }
        return null;
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.f3244t;
    }

    public ColorStateList getCounterTextColor() {
        return this.f3244t;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.f3241r0;
    }

    public EditText getEditText() {
        return this.f3216f;
    }

    public CharSequence getEndIconContentDescription() {
        return this.f3217f0.getContentDescription();
    }

    public Drawable getEndIconDrawable() {
        return this.f3217f0.getDrawable();
    }

    public int getEndIconMode() {
        return this.f3213d0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CheckableImageButton getEndIconView() {
        return this.f3217f0;
    }

    public CharSequence getError() {
        if (this.f3220h.w()) {
            return this.f3220h.n();
        }
        return null;
    }

    public CharSequence getErrorContentDescription() {
        return this.f3220h.m();
    }

    public int getErrorCurrentTextColors() {
        return this.f3220h.o();
    }

    public Drawable getErrorIconDrawable() {
        return this.f3237p0.getDrawable();
    }

    final int getErrorTextCurrentColor() {
        return this.f3220h.o();
    }

    public CharSequence getHelperText() {
        if (this.f3220h.x()) {
            return this.f3220h.q();
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        return this.f3220h.r();
    }

    public CharSequence getHint() {
        if (this.f3256z) {
            return this.A;
        }
        return null;
    }

    final float getHintCollapsedTextHeight() {
        return this.D0.o();
    }

    final int getHintCurrentCollapsedTextColor() {
        return this.D0.r();
    }

    public ColorStateList getHintTextColor() {
        return this.f3243s0;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.f3217f0.getContentDescription();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.f3217f0.getDrawable();
    }

    public CharSequence getPlaceholderText() {
        if (this.f3236p) {
            return this.f3234o;
        }
        return null;
    }

    public int getPlaceholderTextAppearance() {
        return this.f3242s;
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.f3240r;
    }

    public CharSequence getPrefixText() {
        return this.f3248v;
    }

    public ColorStateList getPrefixTextColor() {
        return this.f3250w.getTextColors();
    }

    public TextView getPrefixTextView() {
        return this.f3250w;
    }

    public CharSequence getStartIconContentDescription() {
        return this.R.getContentDescription();
    }

    public Drawable getStartIconDrawable() {
        return this.R.getDrawable();
    }

    public CharSequence getSuffixText() {
        return this.f3252x;
    }

    public ColorStateList getSuffixTextColor() {
        return this.f3254y.getTextColors();
    }

    public TextView getSuffixTextView() {
        return this.f3254y;
    }

    public Typeface getTypeface() {
        return this.Q;
    }

    void h(float f4) {
        if (this.D0.v() == f4) {
            return;
        }
        if (this.F0 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.F0 = valueAnimator;
            valueAnimator.setInterpolator(n0.a.f5239b);
            this.F0.setDuration(167L);
            this.F0.addUpdateListener(new d());
        }
        this.F0.setFloatValues(this.D0.v(), f4);
        this.F0.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k0() {
        Drawable background;
        TextView textView;
        int currentTextColor;
        EditText editText = this.f3216f;
        if (editText == null || this.G != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        if (e0.a(background)) {
            background = background.mutate();
        }
        if (this.f3220h.k()) {
            currentTextColor = this.f3220h.o();
        } else {
            if (!this.f3226k || (textView = this.f3228l) == null) {
                r.a.a(background);
                this.f3216f.refreshDrawableState();
                return;
            }
            currentTextColor = textView.getCurrentTextColor();
        }
        background.setColorFilter(androidx.appcompat.widget.j.e(currentTextColor, PorterDuff.Mode.SRC_IN));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o0(boolean z4) {
        p0(z4, false);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        super.onLayout(z4, i4, i5, i6, i7);
        EditText editText = this.f3216f;
        if (editText != null) {
            Rect rect = this.N;
            com.google.android.material.internal.b.a(this, editText, rect);
            e0(rect);
            if (this.f3256z) {
                this.D0.T(this.f3216f.getTextSize());
                int gravity = this.f3216f.getGravity();
                this.D0.L((gravity & (-113)) | 48);
                this.D0.S(gravity);
                this.D0.H(q(rect));
                this.D0.P(t(rect));
                this.D0.E();
                if (!z() || this.C0) {
                    return;
                }
                R();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        boolean l02 = l0();
        boolean j02 = j0();
        if (l02 || j02) {
            this.f3216f.post(new c());
        }
        q0();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof h)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        h hVar = (h) parcelable;
        super.onRestoreInstanceState(hVar.f());
        setError(hVar.f3263d);
        if (hVar.f3264e) {
            this.f3217f0.post(new b());
        }
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        h hVar = new h(super.onSaveInstanceState());
        if (this.f3220h.k()) {
            hVar.f3263d = getError();
        }
        hVar.f3264e = H() && this.f3217f0.isChecked();
        return hVar;
    }

    public void setBoxBackgroundColor(int i4) {
        if (this.M != i4) {
            this.M = i4;
            this.f3253x0 = i4;
            i();
        }
    }

    public void setBoxBackgroundColorResource(int i4) {
        setBoxBackgroundColor(o.a.b(getContext(), i4));
    }

    public void setBoxBackgroundMode(int i4) {
        if (i4 == this.G) {
            return;
        }
        this.G = i4;
        if (this.f3216f != null) {
            Q();
        }
    }

    public void setBoxStrokeColor(int i4) {
        if (this.f3249v0 != i4) {
            this.f3249v0 = i4;
            y0();
        }
    }

    public void setBoxStrokeColorStateList(ColorStateList colorStateList) {
        int defaultColor;
        if (!colorStateList.isStateful()) {
            if (this.f3249v0 != colorStateList.getDefaultColor()) {
                defaultColor = colorStateList.getDefaultColor();
            }
            y0();
        } else {
            this.f3245t0 = colorStateList.getDefaultColor();
            this.B0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.f3247u0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            defaultColor = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        }
        this.f3249v0 = defaultColor;
        y0();
    }

    public void setBoxStrokeErrorColor(ColorStateList colorStateList) {
        if (this.f3251w0 != colorStateList) {
            this.f3251w0 = colorStateList;
            y0();
        }
    }

    public void setCounterEnabled(boolean z4) {
        if (this.f3222i != z4) {
            if (z4) {
                z zVar = new z(getContext());
                this.f3228l = zVar;
                zVar.setId(m0.f.f5006s);
                Typeface typeface = this.Q;
                if (typeface != null) {
                    this.f3228l.setTypeface(typeface);
                }
                this.f3228l.setMaxLines(1);
                this.f3220h.d(this.f3228l, 2);
                y.f.c((ViewGroup.MarginLayoutParams) this.f3228l.getLayoutParams(), getResources().getDimensionPixelOffset(m0.d.f4982s));
                i0();
                f0();
            } else {
                this.f3220h.y(this.f3228l, 2);
                this.f3228l = null;
            }
            this.f3222i = z4;
        }
    }

    public void setCounterMaxLength(int i4) {
        if (this.f3224j != i4) {
            if (i4 <= 0) {
                i4 = -1;
            }
            this.f3224j = i4;
            if (this.f3222i) {
                f0();
            }
        }
    }

    public void setCounterOverflowTextAppearance(int i4) {
        if (this.f3230m != i4) {
            this.f3230m = i4;
            i0();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.f3246u != colorStateList) {
            this.f3246u = colorStateList;
            i0();
        }
    }

    public void setCounterTextAppearance(int i4) {
        if (this.f3232n != i4) {
            this.f3232n = i4;
            i0();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.f3244t != colorStateList) {
            this.f3244t = colorStateList;
            i0();
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.f3241r0 = colorStateList;
        this.f3243s0 = colorStateList;
        if (this.f3216f != null) {
            o0(false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z4) {
        S(this, z4);
        super.setEnabled(z4);
    }

    public void setEndIconActivated(boolean z4) {
        this.f3217f0.setActivated(z4);
    }

    public void setEndIconCheckable(boolean z4) {
        this.f3217f0.setCheckable(z4);
    }

    public void setEndIconContentDescription(int i4) {
        setEndIconContentDescription(i4 != 0 ? getResources().getText(i4) : null);
    }

    public void setEndIconContentDescription(CharSequence charSequence) {
        if (getEndIconContentDescription() != charSequence) {
            this.f3217f0.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(int i4) {
        setEndIconDrawable(i4 != 0 ? c.a.b(getContext(), i4) : null);
    }

    public void setEndIconDrawable(Drawable drawable) {
        this.f3217f0.setImageDrawable(drawable);
    }

    public void setEndIconMode(int i4) {
        int i5 = this.f3213d0;
        this.f3213d0 = i4;
        setEndIconVisible(i4 != 0);
        if (getEndIconDelegate().b(this.G)) {
            getEndIconDelegate().a();
            l();
            B(i5);
        } else {
            throw new IllegalStateException("The current box background mode " + this.G + " is not supported by the end icon mode " + i4);
        }
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        W(this.f3217f0, onClickListener, this.f3235o0);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f3235o0 = onLongClickListener;
        X(this.f3217f0, onLongClickListener);
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        if (this.f3221h0 != colorStateList) {
            this.f3221h0 = colorStateList;
            this.f3223i0 = true;
            l();
        }
    }

    public void setEndIconTintMode(PorterDuff.Mode mode) {
        if (this.f3225j0 != mode) {
            this.f3225j0 = mode;
            this.f3227k0 = true;
            l();
        }
    }

    public void setEndIconVisible(boolean z4) {
        if (J() != z4) {
            this.f3217f0.setVisibility(z4 ? 0 : 8);
            w0();
            j0();
        }
    }

    public void setError(CharSequence charSequence) {
        if (!this.f3220h.w()) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (TextUtils.isEmpty(charSequence)) {
            this.f3220h.s();
        } else {
            this.f3220h.L(charSequence);
        }
    }

    public void setErrorContentDescription(CharSequence charSequence) {
        this.f3220h.A(charSequence);
    }

    public void setErrorEnabled(boolean z4) {
        this.f3220h.B(z4);
    }

    public void setErrorIconDrawable(int i4) {
        setErrorIconDrawable(i4 != 0 ? c.a.b(getContext(), i4) : null);
    }

    public void setErrorIconDrawable(Drawable drawable) {
        this.f3237p0.setImageDrawable(drawable);
        setErrorIconVisible(drawable != null && this.f3220h.w());
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        this.f3239q0 = colorStateList;
        Drawable drawable = this.f3237p0.getDrawable();
        if (drawable != null) {
            drawable = r.a.m(drawable).mutate();
            r.a.j(drawable, colorStateList);
        }
        if (this.f3237p0.getDrawable() != drawable) {
            this.f3237p0.setImageDrawable(drawable);
        }
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f3237p0.getDrawable();
        if (drawable != null) {
            drawable = r.a.m(drawable).mutate();
            r.a.k(drawable, mode);
        }
        if (this.f3237p0.getDrawable() != drawable) {
            this.f3237p0.setImageDrawable(drawable);
        }
    }

    public void setErrorTextAppearance(int i4) {
        this.f3220h.C(i4);
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        this.f3220h.D(colorStateList);
    }

    public void setHelperText(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            if (L()) {
                setHelperTextEnabled(false);
            }
        } else {
            if (!L()) {
                setHelperTextEnabled(true);
            }
            this.f3220h.M(charSequence);
        }
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        this.f3220h.G(colorStateList);
    }

    public void setHelperTextEnabled(boolean z4) {
        this.f3220h.F(z4);
    }

    public void setHelperTextTextAppearance(int i4) {
        this.f3220h.E(i4);
    }

    public void setHint(CharSequence charSequence) {
        if (this.f3256z) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z4) {
        this.E0 = z4;
    }

    public void setHintEnabled(boolean z4) {
        if (z4 != this.f3256z) {
            this.f3256z = z4;
            if (z4) {
                CharSequence hint = this.f3216f.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.A)) {
                        setHint(hint);
                    }
                    this.f3216f.setHint((CharSequence) null);
                }
                this.B = true;
            } else {
                this.B = false;
                if (!TextUtils.isEmpty(this.A) && TextUtils.isEmpty(this.f3216f.getHint())) {
                    this.f3216f.setHint(this.A);
                }
                setHintInternal(null);
            }
            if (this.f3216f != null) {
                n0();
            }
        }
    }

    public void setHintTextAppearance(int i4) {
        this.D0.I(i4);
        this.f3243s0 = this.D0.n();
        if (this.f3216f != null) {
            o0(false);
            n0();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.f3243s0 != colorStateList) {
            if (this.f3241r0 == null) {
                this.D0.K(colorStateList);
            }
            this.f3243s0 = colorStateList;
            if (this.f3216f != null) {
                o0(false);
            }
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i4) {
        setPasswordVisibilityToggleContentDescription(i4 != 0 ? getResources().getText(i4) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.f3217f0.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i4) {
        setPasswordVisibilityToggleDrawable(i4 != 0 ? c.a.b(getContext(), i4) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.f3217f0.setImageDrawable(drawable);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z4) {
        if (z4 && this.f3213d0 != 1) {
            setEndIconMode(1);
        } else {
            if (z4) {
                return;
            }
            setEndIconMode(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.f3221h0 = colorStateList;
        this.f3223i0 = true;
        l();
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.f3225j0 = mode;
        this.f3227k0 = true;
        l();
    }

    public void setPlaceholderText(CharSequence charSequence) {
        if (this.f3236p && TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.f3236p) {
                setPlaceholderTextEnabled(true);
            }
            this.f3234o = charSequence;
        }
        r0();
    }

    public void setPlaceholderTextAppearance(int i4) {
        this.f3242s = i4;
        TextView textView = this.f3238q;
        if (textView != null) {
            androidx.core.widget.i.n(textView, i4);
        }
    }

    public void setPlaceholderTextColor(ColorStateList colorStateList) {
        if (this.f3240r != colorStateList) {
            this.f3240r = colorStateList;
            TextView textView = this.f3238q;
            if (textView == null || colorStateList == null) {
                return;
            }
            textView.setTextColor(colorStateList);
        }
    }

    public void setPrefixText(CharSequence charSequence) {
        this.f3248v = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.f3250w.setText(charSequence);
        u0();
    }

    public void setPrefixTextAppearance(int i4) {
        androidx.core.widget.i.n(this.f3250w, i4);
    }

    public void setPrefixTextColor(ColorStateList colorStateList) {
        this.f3250w.setTextColor(colorStateList);
    }

    public void setStartIconCheckable(boolean z4) {
        this.R.setCheckable(z4);
    }

    public void setStartIconContentDescription(int i4) {
        setStartIconContentDescription(i4 != 0 ? getResources().getText(i4) : null);
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        if (getStartIconContentDescription() != charSequence) {
            this.R.setContentDescription(charSequence);
        }
    }

    public void setStartIconDrawable(int i4) {
        setStartIconDrawable(i4 != 0 ? c.a.b(getContext(), i4) : null);
    }

    public void setStartIconDrawable(Drawable drawable) {
        this.R.setImageDrawable(drawable);
        if (drawable != null) {
            setStartIconVisible(true);
            n();
        } else {
            setStartIconVisible(false);
            setStartIconOnClickListener(null);
            setStartIconOnLongClickListener(null);
            setStartIconContentDescription((CharSequence) null);
        }
    }

    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        W(this.R, onClickListener, this.f3209b0);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f3209b0 = onLongClickListener;
        X(this.R, onLongClickListener);
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        if (this.S != colorStateList) {
            this.S = colorStateList;
            this.T = true;
            n();
        }
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        if (this.U != mode) {
            this.U = mode;
            this.V = true;
            n();
        }
    }

    public void setStartIconVisible(boolean z4) {
        if (P() != z4) {
            this.R.setVisibility(z4 ? 0 : 8);
            t0();
            j0();
        }
    }

    public void setSuffixText(CharSequence charSequence) {
        this.f3252x = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.f3254y.setText(charSequence);
        x0();
    }

    public void setSuffixTextAppearance(int i4) {
        androidx.core.widget.i.n(this.f3254y, i4);
    }

    public void setSuffixTextColor(ColorStateList colorStateList) {
        this.f3254y.setTextColor(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(e eVar) {
        EditText editText = this.f3216f;
        if (editText != null) {
            p.a0(editText, eVar);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.Q) {
            this.Q = typeface;
            this.D0.b0(typeface);
            this.f3220h.I(typeface);
            TextView textView = this.f3228l;
            if (textView != null) {
                textView.setTypeface(typeface);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void y0() {
        /*
            Method dump skipped, instructions count: 232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.y0():void");
    }
}
