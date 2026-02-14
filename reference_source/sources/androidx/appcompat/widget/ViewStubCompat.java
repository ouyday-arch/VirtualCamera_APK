package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class ViewStubCompat extends View {

    /* renamed from: b, reason: collision with root package name */
    private int f901b;

    /* renamed from: c, reason: collision with root package name */
    private int f902c;

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<View> f903d;

    /* renamed from: e, reason: collision with root package name */
    private LayoutInflater f904e;

    /* renamed from: f, reason: collision with root package name */
    private a f905f;

    /* loaded from: classes.dex */
    public interface a {
        void a(ViewStubCompat viewStubCompat, View view);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f901b = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.E3, i4, 0);
        this.f902c = obtainStyledAttributes.getResourceId(a.j.H3, -1);
        this.f901b = obtainStyledAttributes.getResourceId(a.j.G3, 0);
        setId(obtainStyledAttributes.getResourceId(a.j.F3, -1));
        obtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }

    public View a() {
        ViewParent parent = getParent();
        if (!(parent instanceof ViewGroup)) {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        }
        if (this.f901b == 0) {
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        LayoutInflater layoutInflater = this.f904e;
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(getContext());
        }
        View inflate = layoutInflater.inflate(this.f901b, viewGroup, false);
        int i4 = this.f902c;
        if (i4 != -1) {
            inflate.setId(i4);
        }
        int indexOfChild = viewGroup.indexOfChild(this);
        viewGroup.removeViewInLayout(this);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(inflate, indexOfChild, layoutParams);
        } else {
            viewGroup.addView(inflate, indexOfChild);
        }
        this.f903d = new WeakReference<>(inflate);
        a aVar = this.f905f;
        if (aVar != null) {
            aVar.a(this, inflate);
        }
        return inflate;
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
    }

    public int getInflatedId() {
        return this.f902c;
    }

    public LayoutInflater getLayoutInflater() {
        return this.f904e;
    }

    public int getLayoutResource() {
        return this.f901b;
    }

    @Override // android.view.View
    protected void onMeasure(int i4, int i5) {
        setMeasuredDimension(0, 0);
    }

    public void setInflatedId(int i4) {
        this.f902c = i4;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.f904e = layoutInflater;
    }

    public void setLayoutResource(int i4) {
        this.f901b = i4;
    }

    public void setOnInflateListener(a aVar) {
        this.f905f = aVar;
    }

    @Override // android.view.View
    public void setVisibility(int i4) {
        WeakReference<View> weakReference = this.f903d;
        if (weakReference != null) {
            View view = weakReference.get();
            if (view == null) {
                throw new IllegalStateException("setVisibility called on un-referenced view");
            }
            view.setVisibility(i4);
            return;
        }
        super.setVisibility(i4);
        if (i4 == 0 || i4 == 4) {
            a();
        }
    }
}
