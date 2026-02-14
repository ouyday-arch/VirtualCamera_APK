package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;
import m0.i;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends com.google.android.material.textfield.e {

    /* renamed from: d, reason: collision with root package name */
    private final TextWatcher f3265d;

    /* renamed from: e, reason: collision with root package name */
    private final TextInputLayout.f f3266e;

    /* renamed from: f, reason: collision with root package name */
    private AnimatorSet f3267f;

    /* renamed from: g, reason: collision with root package name */
    private ValueAnimator f3268g;

    /* renamed from: com.google.android.material.textfield.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0032a implements TextWatcher {
        C0032a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (a.this.f3302a.getSuffixText() != null) {
                return;
            }
            a.this.h(a.k(editable));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }
    }

    /* loaded from: classes.dex */
    class b implements TextInputLayout.f {

        /* renamed from: com.google.android.material.textfield.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class ViewOnFocusChangeListenerC0033a implements View.OnFocusChangeListener {
            ViewOnFocusChangeListenerC0033a() {
            }

            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z4) {
                a.this.h((TextUtils.isEmpty(((EditText) view).getText()) ^ true) && z4);
            }
        }

        b() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void a(TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            textInputLayout.setEndIconVisible(a.k(editText.getText()));
            textInputLayout.setEndIconCheckable(false);
            editText.setOnFocusChangeListener(new ViewOnFocusChangeListenerC0033a());
            editText.removeTextChangedListener(a.this.f3265d);
            editText.addTextChangedListener(a.this.f3265d);
        }
    }

    /* loaded from: classes.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.f3302a.getEditText().setText((CharSequence) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            a.this.f3302a.setEndIconVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends AnimatorListenerAdapter {
        e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.f3302a.setEndIconVisible(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements ValueAnimator.AnimatorUpdateListener {
        f() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            a.this.f3304c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g implements ValueAnimator.AnimatorUpdateListener {
        g() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            a.this.f3304c.setScaleX(floatValue);
            a.this.f3304c.setScaleY(floatValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.f3265d = new C0032a();
        this.f3266e = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(boolean z4) {
        boolean z5 = this.f3302a.J() == z4;
        if (z4) {
            this.f3268g.cancel();
            this.f3267f.start();
            if (z5) {
                this.f3267f.end();
                return;
            }
            return;
        }
        this.f3267f.cancel();
        this.f3268g.start();
        if (z5) {
            this.f3268g.end();
        }
    }

    private ValueAnimator i(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(n0.a.f5238a);
        ofFloat.setDuration(100L);
        ofFloat.addUpdateListener(new f());
        return ofFloat;
    }

    private ValueAnimator j() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        ofFloat.setInterpolator(n0.a.f5241d);
        ofFloat.setDuration(150L);
        ofFloat.addUpdateListener(new g());
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean k(Editable editable) {
        return editable.length() > 0;
    }

    private void l() {
        ValueAnimator j4 = j();
        ValueAnimator i4 = i(0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f3267f = animatorSet;
        animatorSet.playTogether(j4, i4);
        this.f3267f.addListener(new d());
        ValueAnimator i5 = i(1.0f, 0.0f);
        this.f3268g = i5;
        i5.addListener(new e());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.e
    public void a() {
        this.f3302a.setEndIconDrawable(c.a.b(this.f3303b, m0.e.f4986d));
        TextInputLayout textInputLayout = this.f3302a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(i.f5026d));
        this.f3302a.setEndIconOnClickListener(new c());
        this.f3302a.e(this.f3266e);
        l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.textfield.e
    public void c(boolean z4) {
        if (this.f3302a.getSuffixText() == null) {
            return;
        }
        h(z4);
    }
}
