package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class a extends ViewGroup {

    /* renamed from: b, reason: collision with root package name */
    protected final C0007a f906b;

    /* renamed from: c, reason: collision with root package name */
    protected final Context f907c;

    /* renamed from: d, reason: collision with root package name */
    protected ActionMenuView f908d;

    /* renamed from: e, reason: collision with root package name */
    protected c f909e;

    /* renamed from: f, reason: collision with root package name */
    protected int f910f;

    /* renamed from: g, reason: collision with root package name */
    protected y.t f911g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f912h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f913i;

    /* renamed from: androidx.appcompat.widget.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    protected class C0007a implements y.u {

        /* renamed from: a, reason: collision with root package name */
        private boolean f914a = false;

        /* renamed from: b, reason: collision with root package name */
        int f915b;

        protected C0007a() {
        }

        @Override // y.u
        public void a(View view) {
            if (this.f914a) {
                return;
            }
            a aVar = a.this;
            aVar.f911g = null;
            a.super.setVisibility(this.f915b);
        }

        @Override // y.u
        public void b(View view) {
            a.super.setVisibility(0);
            this.f914a = false;
        }

        @Override // y.u
        public void c(View view) {
            this.f914a = true;
        }

        public C0007a d(y.t tVar, int i4) {
            a.this.f911g = tVar;
            this.f915b = i4;
            return this;
        }
    }

    a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f906b = new C0007a();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(a.a.f0a, typedValue, true) || typedValue.resourceId == 0) {
            this.f907c = context;
        } else {
            this.f907c = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int d(int i4, int i5, boolean z4) {
        return z4 ? i4 - i5 : i4 + i5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int c(View view, int i4, int i5, int i6) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i4, RecyclerView.UNDEFINED_DURATION), i5);
        return Math.max(0, (i4 - view.getMeasuredWidth()) - i6);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int e(View view, int i4, int i5, int i6, boolean z4) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i7 = i5 + ((i6 - measuredHeight) / 2);
        if (z4) {
            view.layout(i4 - measuredWidth, i7, i4, measuredHeight + i7);
        } else {
            view.layout(i4, i7, i4 + measuredWidth, measuredHeight + i7);
        }
        return z4 ? -measuredWidth : measuredWidth;
    }

    public y.t f(int i4, long j4) {
        y.t a5;
        y.t tVar = this.f911g;
        if (tVar != null) {
            tVar.b();
        }
        if (i4 == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            a5 = y.p.c(this).a(1.0f);
        } else {
            a5 = y.p.c(this).a(0.0f);
        }
        a5.d(j4);
        a5.f(this.f906b.d(a5, i4));
        return a5;
    }

    public int getAnimatedVisibility() {
        return this.f911g != null ? this.f906b.f915b : getVisibility();
    }

    public int getContentHeight() {
        return this.f910f;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, a.j.f133a, a.a.f2c, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(a.j.f178j, 0));
        obtainStyledAttributes.recycle();
        c cVar = this.f909e;
        if (cVar != null) {
            cVar.E(configuration);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f913i = false;
        }
        if (!this.f913i) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.f913i = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f913i = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f912h = false;
        }
        if (!this.f912h) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f912h = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f912h = false;
        }
        return true;
    }

    public void setContentHeight(int i4) {
        this.f910f = i4;
        requestLayout();
    }

    @Override // android.view.View
    public void setVisibility(int i4) {
        if (i4 != getVisibility()) {
            y.t tVar = this.f911g;
            if (tVar != null) {
                tVar.b();
            }
            super.setVisibility(i4);
        }
    }
}
