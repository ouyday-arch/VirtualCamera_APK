package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;

/* loaded from: classes.dex */
public class d extends AutoCompleteTextView {

    /* renamed from: d, reason: collision with root package name */
    private static final int[] f967d = {R.attr.popupBackground};

    /* renamed from: b, reason: collision with root package name */
    private final e f968b;

    /* renamed from: c, reason: collision with root package name */
    private final y f969c;

    public d(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.a.f15p);
    }

    public d(Context context, AttributeSet attributeSet, int i4) {
        super(t0.b(context), attributeSet, i4);
        w0 u4 = w0.u(getContext(), attributeSet, f967d, i4, 0);
        if (u4.r(0)) {
            setDropDownBackgroundDrawable(u4.g(0));
        }
        u4.v();
        e eVar = new e(this);
        this.f968b = eVar;
        eVar.e(attributeSet, i4);
        y yVar = new y(this);
        this.f969c = yVar;
        yVar.m(attributeSet, i4);
        yVar.b();
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f968b;
        if (eVar != null) {
            eVar.b();
        }
        y yVar = this.f969c;
        if (yVar != null) {
            yVar.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f968b;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f968b;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return l.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f968b;
        if (eVar != null) {
            eVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i4) {
        super.setBackgroundResource(i4);
        e eVar = this.f968b;
        if (eVar != null) {
            eVar.g(i4);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.i.p(this, callback));
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i4) {
        setDropDownBackgroundDrawable(c.a.b(getContext(), i4));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f968b;
        if (eVar != null) {
            eVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f968b;
        if (eVar != null) {
            eVar.j(mode);
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i4) {
        super.setTextAppearance(context, i4);
        y yVar = this.f969c;
        if (yVar != null) {
            yVar.p(context, i4);
        }
    }
}
