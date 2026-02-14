package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f0 extends ListView {

    /* renamed from: b, reason: collision with root package name */
    private final Rect f982b;

    /* renamed from: c, reason: collision with root package name */
    private int f983c;

    /* renamed from: d, reason: collision with root package name */
    private int f984d;

    /* renamed from: e, reason: collision with root package name */
    private int f985e;

    /* renamed from: f, reason: collision with root package name */
    private int f986f;

    /* renamed from: g, reason: collision with root package name */
    private int f987g;

    /* renamed from: h, reason: collision with root package name */
    private Field f988h;

    /* renamed from: i, reason: collision with root package name */
    private a f989i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f990j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f991k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f992l;

    /* renamed from: m, reason: collision with root package name */
    private y.t f993m;

    /* renamed from: n, reason: collision with root package name */
    private androidx.core.widget.f f994n;

    /* renamed from: o, reason: collision with root package name */
    b f995o;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends d.a {

        /* renamed from: c, reason: collision with root package name */
        private boolean f996c;

        a(Drawable drawable) {
            super(drawable);
            this.f996c = true;
        }

        void c(boolean z4) {
            this.f996c = z4;
        }

        @Override // d.a, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.f996c) {
                super.draw(canvas);
            }
        }

        @Override // d.a, android.graphics.drawable.Drawable
        public void setHotspot(float f4, float f5) {
            if (this.f996c) {
                super.setHotspot(f4, f5);
            }
        }

        @Override // d.a, android.graphics.drawable.Drawable
        public void setHotspotBounds(int i4, int i5, int i6, int i7) {
            if (this.f996c) {
                super.setHotspotBounds(i4, i5, i6, i7);
            }
        }

        @Override // d.a, android.graphics.drawable.Drawable
        public boolean setState(int[] iArr) {
            if (this.f996c) {
                return super.setState(iArr);
            }
            return false;
        }

        @Override // d.a, android.graphics.drawable.Drawable
        public boolean setVisible(boolean z4, boolean z5) {
            if (this.f996c) {
                return super.setVisible(z4, z5);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        b() {
        }

        public void a() {
            f0 f0Var = f0.this;
            f0Var.f995o = null;
            f0Var.removeCallbacks(this);
        }

        public void b() {
            f0.this.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            f0 f0Var = f0.this;
            f0Var.f995o = null;
            f0Var.drawableStateChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f0(Context context, boolean z4) {
        super(context, null, a.a.f25z);
        this.f982b = new Rect();
        this.f983c = 0;
        this.f984d = 0;
        this.f985e = 0;
        this.f986f = 0;
        this.f991k = z4;
        setCacheColorHint(0);
        try {
            Field declaredField = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.f988h = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e4) {
            e4.printStackTrace();
        }
    }

    private void a() {
        this.f992l = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.f987g - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        y.t tVar = this.f993m;
        if (tVar != null) {
            tVar.b();
            this.f993m = null;
        }
    }

    private void b(View view, int i4) {
        performItemClick(view, i4, getItemIdAtPosition(i4));
    }

    private void c(Canvas canvas) {
        Drawable selector;
        if (this.f982b.isEmpty() || (selector = getSelector()) == null) {
            return;
        }
        selector.setBounds(this.f982b);
        selector.draw(canvas);
    }

    private void f(int i4, View view) {
        Rect rect = this.f982b;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f983c;
        rect.top -= this.f984d;
        rect.right += this.f985e;
        rect.bottom += this.f986f;
        try {
            boolean z4 = this.f988h.getBoolean(this);
            if (view.isEnabled() != z4) {
                this.f988h.set(this, Boolean.valueOf(!z4));
                if (i4 != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e4) {
            e4.printStackTrace();
        }
    }

    private void g(int i4, View view) {
        Drawable selector = getSelector();
        boolean z4 = (selector == null || i4 == -1) ? false : true;
        if (z4) {
            selector.setVisible(false, false);
        }
        f(i4, view);
        if (z4) {
            Rect rect = this.f982b;
            float exactCenterX = rect.exactCenterX();
            float exactCenterY = rect.exactCenterY();
            selector.setVisible(getVisibility() == 0, false);
            r.a.f(selector, exactCenterX, exactCenterY);
        }
    }

    private void h(int i4, View view, float f4, float f5) {
        g(i4, view);
        Drawable selector = getSelector();
        if (selector == null || i4 == -1) {
            return;
        }
        r.a.f(selector, f4, f5);
    }

    private void i(View view, int i4, float f4, float f5) {
        View childAt;
        this.f992l = true;
        drawableHotspotChanged(f4, f5);
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        int i5 = this.f987g;
        if (i5 != -1 && (childAt = getChildAt(i5 - getFirstVisiblePosition())) != null && childAt != view && childAt.isPressed()) {
            childAt.setPressed(false);
        }
        this.f987g = i4;
        view.drawableHotspotChanged(f4 - view.getLeft(), f5 - view.getTop());
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        h(i4, view, f4, f5);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    private boolean j() {
        return this.f992l;
    }

    private void k() {
        Drawable selector = getSelector();
        if (selector != null && j() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    private void setSelectorEnabled(boolean z4) {
        a aVar = this.f989i;
        if (aVar != null) {
            aVar.c(z4);
        }
    }

    public int d(int i4, int i5, int i6, int i7, int i8) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        getListPaddingLeft();
        getListPaddingRight();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        int i9 = listPaddingTop + listPaddingBottom;
        if (adapter == null) {
            return i9;
        }
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        View view = null;
        while (i10 < count) {
            int itemViewType = adapter.getItemViewType(i10);
            if (itemViewType != i11) {
                view = null;
                i11 = itemViewType;
            }
            view = adapter.getView(i10, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i13 = layoutParams.height;
            view.measure(i4, i13 > 0 ? View.MeasureSpec.makeMeasureSpec(i13, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            if (i10 > 0) {
                i9 += dividerHeight;
            }
            i9 += view.getMeasuredHeight();
            if (i9 >= i7) {
                return (i8 < 0 || i10 <= i8 || i12 <= 0 || i9 == i7) ? i7 : i12;
            }
            if (i8 >= 0 && i10 >= i8) {
                i12 = i9;
            }
            i10++;
        }
        return i9;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        c(canvas);
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.f995o != null) {
            return;
        }
        super.drawableStateChanged();
        setSelectorEnabled(true);
        k();
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
    
        if (r0 != 3) goto L8;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0048 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean e(android.view.MotionEvent r8, int r9) {
        /*
            r7 = this;
            int r0 = r8.getActionMasked()
            r1 = 0
            r2 = 1
            if (r0 == r2) goto L16
            r3 = 2
            if (r0 == r3) goto L14
            r9 = 3
            if (r0 == r9) goto L11
        Le:
            r9 = r1
            r3 = r2
            goto L46
        L11:
            r9 = r1
            r3 = r9
            goto L46
        L14:
            r3 = r2
            goto L17
        L16:
            r3 = r1
        L17:
            int r9 = r8.findPointerIndex(r9)
            if (r9 >= 0) goto L1e
            goto L11
        L1e:
            float r4 = r8.getX(r9)
            int r4 = (int) r4
            float r9 = r8.getY(r9)
            int r9 = (int) r9
            int r5 = r7.pointToPosition(r4, r9)
            r6 = -1
            if (r5 != r6) goto L31
            r9 = r2
            goto L46
        L31:
            int r3 = r7.getFirstVisiblePosition()
            int r3 = r5 - r3
            android.view.View r3 = r7.getChildAt(r3)
            float r4 = (float) r4
            float r9 = (float) r9
            r7.i(r3, r5, r4, r9)
            if (r0 != r2) goto Le
            r7.b(r3, r5)
            goto Le
        L46:
            if (r3 == 0) goto L4a
            if (r9 == 0) goto L4d
        L4a:
            r7.a()
        L4d:
            if (r3 == 0) goto L65
            androidx.core.widget.f r9 = r7.f994n
            if (r9 != 0) goto L5a
            androidx.core.widget.f r9 = new androidx.core.widget.f
            r9.<init>(r7)
            r7.f994n = r9
        L5a:
            androidx.core.widget.f r9 = r7.f994n
            r9.m(r2)
            androidx.core.widget.f r9 = r7.f994n
            r9.onTouch(r7, r8)
            goto L6c
        L65:
            androidx.core.widget.f r8 = r7.f994n
            if (r8 == 0) goto L6c
            r8.m(r1)
        L6c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.f0.e(android.view.MotionEvent, int):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        return this.f991k || super.hasFocus();
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        return this.f991k || super.hasWindowFocus();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.f991k || super.isFocused();
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        return (this.f991k && this.f990j) || super.isInTouchMode();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.f995o = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (Build.VERSION.SDK_INT < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f995o == null) {
            b bVar = new b();
            this.f995o = bVar;
            bVar.b();
        }
        boolean onHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (pointToPosition != -1 && pointToPosition != getSelectedItemPosition()) {
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    setSelectionFromTop(pointToPosition, childAt.getTop() - getTop());
                }
                k();
            }
        } else {
            setSelection(-1);
        }
        return onHoverEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f987g = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        b bVar = this.f995o;
        if (bVar != null) {
            bVar.a();
        }
        return super.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setListSelectionHidden(boolean z4) {
        this.f990j = z4;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        a aVar = drawable != null ? new a(drawable) : null;
        this.f989i = aVar;
        super.setSelector(aVar);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f983c = rect.left;
        this.f984d = rect.top;
        this.f985e = rect.right;
        this.f986f = rect.bottom;
    }
}
