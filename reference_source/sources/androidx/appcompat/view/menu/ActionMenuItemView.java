package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.h0;
import androidx.appcompat.widget.y0;
import androidx.appcompat.widget.z;

/* loaded from: classes.dex */
public class ActionMenuItemView extends z implements k.a, View.OnClickListener, ActionMenuView.a {

    /* renamed from: f, reason: collision with root package name */
    g f544f;

    /* renamed from: g, reason: collision with root package name */
    private CharSequence f545g;

    /* renamed from: h, reason: collision with root package name */
    private Drawable f546h;

    /* renamed from: i, reason: collision with root package name */
    e.b f547i;

    /* renamed from: j, reason: collision with root package name */
    private h0 f548j;

    /* renamed from: k, reason: collision with root package name */
    b f549k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f550l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f551m;

    /* renamed from: n, reason: collision with root package name */
    private int f552n;

    /* renamed from: o, reason: collision with root package name */
    private int f553o;

    /* renamed from: p, reason: collision with root package name */
    private int f554p;

    /* loaded from: classes.dex */
    private class a extends h0 {
        public a() {
            super(ActionMenuItemView.this);
        }

        @Override // androidx.appcompat.widget.h0
        public g.e b() {
            b bVar = ActionMenuItemView.this.f549k;
            if (bVar != null) {
                return bVar.a();
            }
            return null;
        }

        @Override // androidx.appcompat.widget.h0
        protected boolean c() {
            g.e b5;
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            e.b bVar = actionMenuItemView.f547i;
            return bVar != null && bVar.a(actionMenuItemView.f544f) && (b5 = b()) != null && b5.b();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class b {
        public abstract g.e a();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        Resources resources = context.getResources();
        this.f550l = g();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.f238v, i4, 0);
        this.f552n = obtainStyledAttributes.getDimensionPixelSize(a.j.f243w, 0);
        obtainStyledAttributes.recycle();
        this.f554p = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f553o = -1;
        setSaveEnabled(false);
    }

    private boolean g() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i4 = configuration.screenWidthDp;
        return i4 >= 480 || (i4 >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    private void h() {
        boolean z4 = true;
        boolean z5 = !TextUtils.isEmpty(this.f545g);
        if (this.f546h != null && (!this.f544f.B() || (!this.f550l && !this.f551m))) {
            z4 = false;
        }
        boolean z6 = z5 & z4;
        setText(z6 ? this.f545g : null);
        CharSequence contentDescription = this.f544f.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            contentDescription = z6 ? null : this.f544f.getTitle();
        }
        setContentDescription(contentDescription);
        CharSequence tooltipText = this.f544f.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            y0.a(this, z6 ? null : this.f544f.getTitle());
        } else {
            y0.a(this, tooltipText);
        }
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean a() {
        return f();
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean b() {
        return f() && this.f544f.getIcon() == null;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public boolean d() {
        return true;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public void e(g gVar, int i4) {
        this.f544f = gVar;
        setIcon(gVar.getIcon());
        setTitle(gVar.i(this));
        setId(gVar.getItemId());
        setVisibility(gVar.isVisible() ? 0 : 8);
        setEnabled(gVar.isEnabled());
        if (gVar.hasSubMenu() && this.f548j == null) {
            this.f548j = new a();
        }
    }

    public boolean f() {
        return !TextUtils.isEmpty(getText());
    }

    @Override // androidx.appcompat.view.menu.k.a
    public g getItemData() {
        return this.f544f;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        e.b bVar = this.f547i;
        if (bVar != null) {
            bVar.a(this.f544f);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f550l = g();
        h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.z, android.widget.TextView, android.view.View
    public void onMeasure(int i4, int i5) {
        int i6;
        boolean f4 = f();
        if (f4 && (i6 = this.f553o) >= 0) {
            super.setPadding(i6, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i4, i5);
        int mode = View.MeasureSpec.getMode(i4);
        int size = View.MeasureSpec.getSize(i4);
        int measuredWidth = getMeasuredWidth();
        int min = mode == Integer.MIN_VALUE ? Math.min(size, this.f552n) : this.f552n;
        if (mode != 1073741824 && this.f552n > 0 && measuredWidth < min) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(min, 1073741824), i5);
        }
        if (f4 || this.f546h == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.f546h.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        h0 h0Var;
        if (this.f544f.hasSubMenu() && (h0Var = this.f548j) != null && h0Var.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCheckable(boolean z4) {
    }

    public void setChecked(boolean z4) {
    }

    public void setExpandedFormat(boolean z4) {
        if (this.f551m != z4) {
            this.f551m = z4;
            g gVar = this.f544f;
            if (gVar != null) {
                gVar.c();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f546h = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i4 = this.f554p;
            if (intrinsicWidth > i4) {
                intrinsicHeight = (int) (intrinsicHeight * (i4 / intrinsicWidth));
                intrinsicWidth = i4;
            }
            if (intrinsicHeight > i4) {
                intrinsicWidth = (int) (intrinsicWidth * (i4 / intrinsicHeight));
            } else {
                i4 = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i4);
        }
        setCompoundDrawables(drawable, null, null, null);
        h();
    }

    public void setItemInvoker(e.b bVar) {
        this.f547i = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i4, int i5, int i6, int i7) {
        this.f553o = i4;
        super.setPadding(i4, i5, i6, i7);
    }

    public void setPopupCallback(b bVar) {
        this.f549k = bVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.f545g = charSequence;
        h();
    }
}
