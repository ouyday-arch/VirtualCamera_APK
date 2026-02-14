package com.google.android.material.textfield;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import b1.k;
import com.google.android.material.textfield.TextInputLayout;
import y.p;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.google.android.material.textfield.e {

    /* renamed from: o, reason: collision with root package name */
    private static final boolean f3278o = true;

    /* renamed from: d, reason: collision with root package name */
    private final TextWatcher f3279d;

    /* renamed from: e, reason: collision with root package name */
    private final TextInputLayout.e f3280e;

    /* renamed from: f, reason: collision with root package name */
    private final TextInputLayout.f f3281f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f3282g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f3283h;

    /* renamed from: i, reason: collision with root package name */
    private long f3284i;

    /* renamed from: j, reason: collision with root package name */
    private StateListDrawable f3285j;

    /* renamed from: k, reason: collision with root package name */
    private b1.g f3286k;

    /* renamed from: l, reason: collision with root package name */
    private AccessibilityManager f3287l;

    /* renamed from: m, reason: collision with root package name */
    private ValueAnimator f3288m;

    /* renamed from: n, reason: collision with root package name */
    private ValueAnimator f3289n;

    /* loaded from: classes.dex */
    class a implements TextWatcher {

        /* renamed from: com.google.android.material.textfield.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0034a implements Runnable {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ AutoCompleteTextView f3291b;

            RunnableC0034a(AutoCompleteTextView autoCompleteTextView) {
                this.f3291b = autoCompleteTextView;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean isPopupShowing = this.f3291b.isPopupShowing();
                d.this.A(isPopupShowing);
                d.this.f3282g = isPopupShowing;
            }
        }

        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            d dVar = d.this;
            AutoCompleteTextView v4 = dVar.v(dVar.f3302a.getEditText());
            v4.post(new RunnableC0034a(v4));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }
    }

    /* loaded from: classes.dex */
    class b extends TextInputLayout.e {
        b(TextInputLayout textInputLayout) {
            super(textInputLayout);
        }

        @Override // com.google.android.material.textfield.TextInputLayout.e, y.a
        public void g(View view, z.c cVar) {
            super.g(view, cVar);
            cVar.W(Spinner.class.getName());
            if (cVar.J()) {
                cVar.g0(null);
            }
        }

        @Override // y.a
        public void h(View view, AccessibilityEvent accessibilityEvent) {
            super.h(view, accessibilityEvent);
            d dVar = d.this;
            AutoCompleteTextView v4 = dVar.v(dVar.f3302a.getEditText());
            if (accessibilityEvent.getEventType() == 1 && d.this.f3287l.isTouchExplorationEnabled()) {
                d.this.D(v4);
            }
        }
    }

    /* loaded from: classes.dex */
    class c implements TextInputLayout.f {
        c() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void a(TextInputLayout textInputLayout) {
            AutoCompleteTextView v4 = d.this.v(textInputLayout.getEditText());
            d.this.B(v4);
            d.this.s(v4);
            d.this.C(v4);
            v4.setThreshold(0);
            v4.removeTextChangedListener(d.this.f3279d);
            v4.addTextChangedListener(d.this.f3279d);
            textInputLayout.setErrorIconDrawable((Drawable) null);
            textInputLayout.setTextInputAccessibilityDelegate(d.this.f3280e);
            textInputLayout.setEndIconVisible(true);
        }
    }

    /* renamed from: com.google.android.material.textfield.d$d, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class ViewOnClickListenerC0035d implements View.OnClickListener {
        ViewOnClickListenerC0035d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.D((AutoCompleteTextView) d.this.f3302a.getEditText());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements View.OnTouchListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AutoCompleteTextView f3296b;

        e(AutoCompleteTextView autoCompleteTextView) {
            this.f3296b = autoCompleteTextView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                if (d.this.z()) {
                    d.this.f3282g = false;
                }
                d.this.D(this.f3296b);
                view.performClick();
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements View.OnFocusChangeListener {
        f() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z4) {
            d.this.f3302a.setEndIconActivated(z4);
            if (z4) {
                return;
            }
            d.this.A(false);
            d.this.f3282g = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g implements AutoCompleteTextView.OnDismissListener {
        g() {
        }

        @Override // android.widget.AutoCompleteTextView.OnDismissListener
        public void onDismiss() {
            d.this.f3282g = true;
            d.this.f3284i = System.currentTimeMillis();
            d.this.A(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h extends AnimatorListenerAdapter {
        h() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d dVar = d.this;
            dVar.f3304c.setChecked(dVar.f3283h);
            d.this.f3289n.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i implements ValueAnimator.AnimatorUpdateListener {
        i() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            d.this.f3304c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.f3279d = new a();
        this.f3280e = new b(this.f3302a);
        this.f3281f = new c();
        this.f3282g = false;
        this.f3283h = false;
        this.f3284i = Long.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(boolean z4) {
        if (this.f3283h != z4) {
            this.f3283h = z4;
            this.f3289n.cancel();
            this.f3288m.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(AutoCompleteTextView autoCompleteTextView) {
        Drawable drawable;
        if (f3278o) {
            int boxBackgroundMode = this.f3302a.getBoxBackgroundMode();
            if (boxBackgroundMode == 2) {
                drawable = this.f3286k;
            } else if (boxBackgroundMode != 1) {
                return;
            } else {
                drawable = this.f3285j;
            }
            autoCompleteTextView.setDropDownBackgroundDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ClickableViewAccessibility"})
    public void C(AutoCompleteTextView autoCompleteTextView) {
        autoCompleteTextView.setOnTouchListener(new e(autoCompleteTextView));
        autoCompleteTextView.setOnFocusChangeListener(new f());
        if (f3278o) {
            autoCompleteTextView.setOnDismissListener(new g());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(AutoCompleteTextView autoCompleteTextView) {
        if (autoCompleteTextView == null) {
            return;
        }
        if (z()) {
            this.f3282g = false;
        }
        if (this.f3282g) {
            this.f3282g = false;
            return;
        }
        if (f3278o) {
            A(!this.f3283h);
        } else {
            this.f3283h = !this.f3283h;
            this.f3304c.toggle();
        }
        if (!this.f3283h) {
            autoCompleteTextView.dismissDropDown();
        } else {
            autoCompleteTextView.requestFocus();
            autoCompleteTextView.showDropDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(AutoCompleteTextView autoCompleteTextView) {
        if (autoCompleteTextView.getKeyListener() != null) {
            return;
        }
        int boxBackgroundMode = this.f3302a.getBoxBackgroundMode();
        b1.g boxBackground = this.f3302a.getBoxBackground();
        int c5 = s0.a.c(autoCompleteTextView, m0.b.f4939g);
        int[][] iArr = {new int[]{R.attr.state_pressed}, new int[0]};
        if (boxBackgroundMode == 2) {
            u(autoCompleteTextView, c5, iArr, boxBackground);
        } else if (boxBackgroundMode == 1) {
            t(autoCompleteTextView, c5, iArr, boxBackground);
        }
    }

    private void t(AutoCompleteTextView autoCompleteTextView, int i4, int[][] iArr, b1.g gVar) {
        int boxBackgroundColor = this.f3302a.getBoxBackgroundColor();
        int[] iArr2 = {s0.a.f(i4, boxBackgroundColor, 0.1f), boxBackgroundColor};
        if (f3278o) {
            p.d0(autoCompleteTextView, new RippleDrawable(new ColorStateList(iArr, iArr2), gVar, gVar));
            return;
        }
        b1.g gVar2 = new b1.g(gVar.C());
        gVar2.V(new ColorStateList(iArr, iArr2));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gVar, gVar2});
        int y4 = p.y(autoCompleteTextView);
        int paddingTop = autoCompleteTextView.getPaddingTop();
        int x4 = p.x(autoCompleteTextView);
        int paddingBottom = autoCompleteTextView.getPaddingBottom();
        p.d0(autoCompleteTextView, layerDrawable);
        p.m0(autoCompleteTextView, y4, paddingTop, x4, paddingBottom);
    }

    private void u(AutoCompleteTextView autoCompleteTextView, int i4, int[][] iArr, b1.g gVar) {
        LayerDrawable layerDrawable;
        int c5 = s0.a.c(autoCompleteTextView, m0.b.f4943k);
        b1.g gVar2 = new b1.g(gVar.C());
        int f4 = s0.a.f(i4, c5, 0.1f);
        gVar2.V(new ColorStateList(iArr, new int[]{f4, 0}));
        if (f3278o) {
            gVar2.setTint(c5);
            ColorStateList colorStateList = new ColorStateList(iArr, new int[]{f4, c5});
            b1.g gVar3 = new b1.g(gVar.C());
            gVar3.setTint(-1);
            layerDrawable = new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, gVar2, gVar3), gVar});
        } else {
            layerDrawable = new LayerDrawable(new Drawable[]{gVar2, gVar});
        }
        p.d0(autoCompleteTextView, layerDrawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AutoCompleteTextView v(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    private ValueAnimator w(int i4, float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(n0.a.f5238a);
        ofFloat.setDuration(i4);
        ofFloat.addUpdateListener(new i());
        return ofFloat;
    }

    private b1.g x(float f4, float f5, float f6, int i4) {
        k m4 = k.a().z(f4).D(f4).r(f5).v(f5).m();
        b1.g m5 = b1.g.m(this.f3303b, f6);
        m5.setShapeAppearanceModel(m4);
        m5.X(0, i4, 0, i4);
        return m5;
    }

    private void y() {
        this.f3289n = w(67, 0.0f, 1.0f);
        ValueAnimator w4 = w(50, 1.0f, 0.0f);
        this.f3288m = w4;
        w4.addListener(new h());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean z() {
        long currentTimeMillis = System.currentTimeMillis() - this.f3284i;
        return currentTimeMillis < 0 || currentTimeMillis > 300;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.e
    public void a() {
        float dimensionPixelOffset = this.f3303b.getResources().getDimensionPixelOffset(m0.d.f4977n);
        float dimensionPixelOffset2 = this.f3303b.getResources().getDimensionPixelOffset(m0.d.f4975l);
        int dimensionPixelOffset3 = this.f3303b.getResources().getDimensionPixelOffset(m0.d.f4976m);
        b1.g x4 = x(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        b1.g x5 = x(0.0f, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        this.f3286k = x4;
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.f3285j = stateListDrawable;
        stateListDrawable.addState(new int[]{R.attr.state_above_anchor}, x4);
        this.f3285j.addState(new int[0], x5);
        this.f3302a.setEndIconDrawable(c.a.b(this.f3303b, f3278o ? m0.e.f4984b : m0.e.f4985c));
        TextInputLayout textInputLayout = this.f3302a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(m0.i.f5028f));
        this.f3302a.setEndIconOnClickListener(new ViewOnClickListenerC0035d());
        this.f3302a.e(this.f3281f);
        y();
        p.j0(this.f3304c, 2);
        this.f3287l = (AccessibilityManager) this.f3303b.getSystemService("accessibility");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.e
    public boolean b(int i4) {
        return i4 != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.e
    public boolean d() {
        return true;
    }
}
