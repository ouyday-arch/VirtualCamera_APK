package androidx.appcompat.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import w.b;

/* loaded from: classes.dex */
public class z extends TextView implements androidx.core.widget.b {

    /* renamed from: b, reason: collision with root package name */
    private final e f1259b;

    /* renamed from: c, reason: collision with root package name */
    private final y f1260c;

    /* renamed from: d, reason: collision with root package name */
    private final x f1261d;

    /* renamed from: e, reason: collision with root package name */
    private Future<w.b> f1262e;

    public z(Context context) {
        this(context, null);
    }

    public z(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    public z(Context context, AttributeSet attributeSet, int i4) {
        super(t0.b(context), attributeSet, i4);
        e eVar = new e(this);
        this.f1259b = eVar;
        eVar.e(attributeSet, i4);
        y yVar = new y(this);
        this.f1260c = yVar;
        yVar.m(attributeSet, i4);
        yVar.b();
        this.f1261d = new x(this);
    }

    private void c() {
        Future<w.b> future = this.f1262e;
        if (future != null) {
            try {
                this.f1262e = null;
                androidx.core.widget.i.m(this, future.get());
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f1259b;
        if (eVar != null) {
            eVar.b();
        }
        y yVar = this.f1260c;
        if (yVar != null) {
            yVar.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (androidx.core.widget.b.f1401a) {
            return super.getAutoSizeMaxTextSize();
        }
        y yVar = this.f1260c;
        if (yVar != null) {
            return yVar.e();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (androidx.core.widget.b.f1401a) {
            return super.getAutoSizeMinTextSize();
        }
        y yVar = this.f1260c;
        if (yVar != null) {
            return yVar.f();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (androidx.core.widget.b.f1401a) {
            return super.getAutoSizeStepGranularity();
        }
        y yVar = this.f1260c;
        if (yVar != null) {
            return yVar.g();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (androidx.core.widget.b.f1401a) {
            return super.getAutoSizeTextAvailableSizes();
        }
        y yVar = this.f1260c;
        return yVar != null ? yVar.h() : new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (androidx.core.widget.b.f1401a) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        y yVar = this.f1260c;
        if (yVar != null) {
            return yVar.i();
        }
        return 0;
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return androidx.core.widget.i.b(this);
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return androidx.core.widget.i.c(this);
    }

    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f1259b;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f1259b;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1260c.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1260c.k();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        c();
        return super.getText();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        x xVar;
        return (Build.VERSION.SDK_INT >= 28 || (xVar = this.f1261d) == null) ? super.getTextClassifier() : xVar.a();
    }

    public b.a getTextMetricsParamsCompat() {
        return androidx.core.widget.i.f(this);
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return l.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        super.onLayout(z4, i4, i5, i6, i7);
        y yVar = this.f1260c;
        if (yVar != null) {
            yVar.n(z4, i4, i5, i6, i7);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i4, int i5) {
        c();
        super.onMeasure(i4, i5);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        super.onTextChanged(charSequence, i4, i5, i6);
        y yVar = this.f1260c;
        if (yVar == null || androidx.core.widget.b.f1401a || !yVar.l()) {
            return;
        }
        this.f1260c.c();
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i4, int i5, int i6, int i7) {
        if (androidx.core.widget.b.f1401a) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i4, i5, i6, i7);
            return;
        }
        y yVar = this.f1260c;
        if (yVar != null) {
            yVar.s(i4, i5, i6, i7);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i4) {
        if (androidx.core.widget.b.f1401a) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i4);
            return;
        }
        y yVar = this.f1260c;
        if (yVar != null) {
            yVar.t(iArr, i4);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i4) {
        if (androidx.core.widget.b.f1401a) {
            super.setAutoSizeTextTypeWithDefaults(i4);
            return;
        }
        y yVar = this.f1260c;
        if (yVar != null) {
            yVar.u(i4);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f1259b;
        if (eVar != null) {
            eVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i4) {
        super.setBackgroundResource(i4);
        e eVar = this.f1259b;
        if (eVar != null) {
            eVar.g(i4);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        y yVar = this.f1260c;
        if (yVar != null) {
            yVar.o();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        y yVar = this.f1260c;
        if (yVar != null) {
            yVar.o();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i4, int i5, int i6, int i7) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i4 != 0 ? c.a.b(context, i4) : null, i5 != 0 ? c.a.b(context, i5) : null, i6 != 0 ? c.a.b(context, i6) : null, i7 != 0 ? c.a.b(context, i7) : null);
        y yVar = this.f1260c;
        if (yVar != null) {
            yVar.o();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        y yVar = this.f1260c;
        if (yVar != null) {
            yVar.o();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i4, int i5, int i6, int i7) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i4 != 0 ? c.a.b(context, i4) : null, i5 != 0 ? c.a.b(context, i5) : null, i6 != 0 ? c.a.b(context, i6) : null, i7 != 0 ? c.a.b(context, i7) : null);
        y yVar = this.f1260c;
        if (yVar != null) {
            yVar.o();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        y yVar = this.f1260c;
        if (yVar != null) {
            yVar.o();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.i.p(this, callback));
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i4) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setFirstBaselineToTopHeight(i4);
        } else {
            androidx.core.widget.i.j(this, i4);
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i4) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setLastBaselineToBottomHeight(i4);
        } else {
            androidx.core.widget.i.k(this, i4);
        }
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i4) {
        androidx.core.widget.i.l(this, i4);
    }

    public void setPrecomputedText(w.b bVar) {
        androidx.core.widget.i.m(this, bVar);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f1259b;
        if (eVar != null) {
            eVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f1259b;
        if (eVar != null) {
            eVar.j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f1260c.v(colorStateList);
        this.f1260c.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f1260c.w(mode);
        this.f1260c.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i4) {
        super.setTextAppearance(context, i4);
        y yVar = this.f1260c;
        if (yVar != null) {
            yVar.p(context, i4);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        x xVar;
        if (Build.VERSION.SDK_INT >= 28 || (xVar = this.f1261d) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            xVar.b(textClassifier);
        }
    }

    public void setTextFuture(Future<w.b> future) {
        this.f1262e = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(b.a aVar) {
        androidx.core.widget.i.o(this, aVar);
    }

    @Override // android.widget.TextView
    public void setTextSize(int i4, float f4) {
        if (androidx.core.widget.b.f1401a) {
            super.setTextSize(i4, f4);
            return;
        }
        y yVar = this.f1260c;
        if (yVar != null) {
            yVar.z(i4, f4);
        }
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface typeface, int i4) {
        Typeface a5 = (typeface == null || i4 <= 0) ? null : q.b.a(getContext(), typeface, i4);
        if (a5 != null) {
            typeface = a5;
        }
        super.setTypeface(typeface, i4);
    }
}
