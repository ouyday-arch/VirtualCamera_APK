package androidx.core.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import y.j;
import y.l;
import y.m;
import y.p;
import z.c;

/* loaded from: classes.dex */
public class NestedScrollView extends FrameLayout implements l, y.i {
    private static final a B = new a();
    private static final int[] C = {R.attr.fillViewport};
    private b A;

    /* renamed from: b, reason: collision with root package name */
    private long f1345b;

    /* renamed from: c, reason: collision with root package name */
    private final Rect f1346c;

    /* renamed from: d, reason: collision with root package name */
    private OverScroller f1347d;

    /* renamed from: e, reason: collision with root package name */
    private EdgeEffect f1348e;

    /* renamed from: f, reason: collision with root package name */
    private EdgeEffect f1349f;

    /* renamed from: g, reason: collision with root package name */
    private int f1350g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f1351h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f1352i;

    /* renamed from: j, reason: collision with root package name */
    private View f1353j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f1354k;

    /* renamed from: l, reason: collision with root package name */
    private VelocityTracker f1355l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f1356m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f1357n;

    /* renamed from: o, reason: collision with root package name */
    private int f1358o;

    /* renamed from: p, reason: collision with root package name */
    private int f1359p;

    /* renamed from: q, reason: collision with root package name */
    private int f1360q;

    /* renamed from: r, reason: collision with root package name */
    private int f1361r;

    /* renamed from: s, reason: collision with root package name */
    private final int[] f1362s;

    /* renamed from: t, reason: collision with root package name */
    private final int[] f1363t;

    /* renamed from: u, reason: collision with root package name */
    private int f1364u;

    /* renamed from: v, reason: collision with root package name */
    private int f1365v;

    /* renamed from: w, reason: collision with root package name */
    private c f1366w;

    /* renamed from: x, reason: collision with root package name */
    private final m f1367x;

    /* renamed from: y, reason: collision with root package name */
    private final j f1368y;

    /* renamed from: z, reason: collision with root package name */
    private float f1369z;

    /* loaded from: classes.dex */
    static class a extends y.a {
        a() {
        }

        @Override // y.a
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            super.f(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            z.e.a(accessibilityEvent, nestedScrollView.getScrollX());
            z.e.b(accessibilityEvent, nestedScrollView.getScrollRange());
        }

        @Override // y.a
        public void g(View view, z.c cVar) {
            int scrollRange;
            super.g(view, cVar);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            cVar.W(ScrollView.class.getName());
            if (!nestedScrollView.isEnabled() || (scrollRange = nestedScrollView.getScrollRange()) <= 0) {
                return;
            }
            cVar.n0(true);
            if (nestedScrollView.getScrollY() > 0) {
                cVar.b(c.a.f6629r);
                cVar.b(c.a.C);
            }
            if (nestedScrollView.getScrollY() < scrollRange) {
                cVar.b(c.a.f6628q);
                cVar.b(c.a.E);
            }
        }

        @Override // y.a
        public boolean j(View view, int i4, Bundle bundle) {
            if (super.j(view, i4, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            if (i4 != 4096) {
                if (i4 == 8192 || i4 == 16908344) {
                    int max = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (max == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.N(0, max, true);
                    return true;
                }
                if (i4 != 16908346) {
                    return false;
                }
            }
            int min = Math.min(nestedScrollView.getScrollY() + ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
            if (min == nestedScrollView.getScrollY()) {
                return false;
            }
            nestedScrollView.N(0, min, true);
            return true;
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(NestedScrollView nestedScrollView, int i4, int i5, int i6, int i7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c extends View.BaseSavedState {
        public static final Parcelable.Creator<c> CREATOR = new a();

        /* renamed from: b, reason: collision with root package name */
        public int f1370b;

        /* loaded from: classes.dex */
        static class a implements Parcelable.Creator<c> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public c createFromParcel(Parcel parcel) {
                return new c(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public c[] newArray(int i4) {
                return new c[i4];
            }
        }

        c(Parcel parcel) {
            super(parcel);
            this.f1370b = parcel.readInt();
        }

        c(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.f1370b + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeInt(this.f1370b);
        }
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f1346c = new Rect();
        this.f1351h = true;
        this.f1352i = false;
        this.f1353j = null;
        this.f1354k = false;
        this.f1357n = true;
        this.f1361r = -1;
        this.f1362s = new int[2];
        this.f1363t = new int[2];
        x();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C, i4, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.f1367x = new m(this);
        this.f1368y = new j(this);
        setNestedScrollingEnabled(true);
        p.a0(this, B);
    }

    private static boolean A(View view, View view2) {
        if (view == view2) {
            return true;
        }
        Object parent = view.getParent();
        return (parent instanceof ViewGroup) && A((View) parent, view2);
    }

    private boolean B(View view, int i4, int i5) {
        view.getDrawingRect(this.f1346c);
        offsetDescendantRectToMyCoords(view, this.f1346c);
        return this.f1346c.bottom + i4 >= getScrollY() && this.f1346c.top - i4 <= getScrollY() + i5;
    }

    private void C(int i4, int i5, int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i4);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.f1368y.e(0, scrollY2, 0, i4 - scrollY2, null, i5, iArr);
    }

    private void D(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f1361r) {
            int i4 = actionIndex == 0 ? 1 : 0;
            this.f1350g = (int) motionEvent.getY(i4);
            this.f1361r = motionEvent.getPointerId(i4);
            VelocityTracker velocityTracker = this.f1355l;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void G() {
        VelocityTracker velocityTracker = this.f1355l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f1355l = null;
        }
    }

    private void H(boolean z4) {
        if (z4) {
            O(2, 1);
        } else {
            P(1);
        }
        this.f1365v = getScrollY();
        p.S(this);
    }

    private boolean I(int i4, int i5, int i6) {
        int height = getHeight();
        int scrollY = getScrollY();
        int i7 = height + scrollY;
        boolean z4 = false;
        boolean z5 = i4 == 33;
        View r4 = r(z5, i5, i6);
        if (r4 == null) {
            r4 = this;
        }
        if (i5 < scrollY || i6 > i7) {
            k(z5 ? i5 - scrollY : i6 - i7);
            z4 = true;
        }
        if (r4 != findFocus()) {
            r4.requestFocus(i4);
        }
        return z4;
    }

    private void J(View view) {
        view.getDrawingRect(this.f1346c);
        offsetDescendantRectToMyCoords(view, this.f1346c);
        int e4 = e(this.f1346c);
        if (e4 != 0) {
            scrollBy(0, e4);
        }
    }

    private boolean K(Rect rect, boolean z4) {
        int e4 = e(rect);
        boolean z5 = e4 != 0;
        if (z5) {
            if (z4) {
                scrollBy(0, e4);
            } else {
                L(0, e4);
            }
        }
        return z5;
    }

    private void M(int i4, int i5, boolean z4) {
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.f1345b > 250) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int height = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            this.f1347d.startScroll(getScrollX(), scrollY, 0, Math.max(0, Math.min(i5 + scrollY, Math.max(0, height - height2))) - scrollY);
            H(z4);
        } else {
            if (!this.f1347d.isFinished()) {
                a();
            }
            scrollBy(i4, i5);
        }
        this.f1345b = AnimationUtils.currentAnimationTimeMillis();
    }

    private void a() {
        this.f1347d.abortAnimation();
        P(1);
    }

    private boolean c() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    private static int d(int i4, int i5, int i6) {
        if (i5 >= i6 || i4 < 0) {
            return 0;
        }
        return i5 + i4 > i6 ? i6 - i5 : i4;
    }

    private float getVerticalScrollFactorCompat() {
        if (this.f1369z == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (!context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            this.f1369z = typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.f1369z;
    }

    private void k(int i4) {
        if (i4 != 0) {
            if (this.f1357n) {
                L(0, i4);
            } else {
                scrollBy(0, i4);
            }
        }
    }

    private void l() {
        this.f1354k = false;
        G();
        P(0);
        EdgeEffect edgeEffect = this.f1348e;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            this.f1349f.onRelease();
        }
    }

    private void p() {
        if (getOverScrollMode() == 2) {
            this.f1348e = null;
            this.f1349f = null;
        } else if (this.f1348e == null) {
            Context context = getContext();
            this.f1348e = new EdgeEffect(context);
            this.f1349f = new EdgeEffect(context);
        }
    }

    private View r(boolean z4, int i4, int i5) {
        ArrayList focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z5 = false;
        for (int i6 = 0; i6 < size; i6++) {
            View view2 = (View) focusables.get(i6);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i4 < bottom && top < i5) {
                boolean z6 = i4 < top && bottom < i5;
                if (view == null) {
                    view = view2;
                    z5 = z6;
                } else {
                    boolean z7 = (z4 && top < view.getTop()) || (!z4 && bottom > view.getBottom());
                    if (z5) {
                        if (z6) {
                            if (!z7) {
                            }
                            view = view2;
                        }
                    } else if (z6) {
                        view = view2;
                        z5 = true;
                    } else {
                        if (!z7) {
                        }
                        view = view2;
                    }
                }
            }
        }
        return view;
    }

    private boolean v(int i4, int i5) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        return i5 >= childAt.getTop() - scrollY && i5 < childAt.getBottom() - scrollY && i4 >= childAt.getLeft() && i4 < childAt.getRight();
    }

    private void w() {
        VelocityTracker velocityTracker = this.f1355l;
        if (velocityTracker == null) {
            this.f1355l = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void x() {
        this.f1347d = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f1358o = viewConfiguration.getScaledTouchSlop();
        this.f1359p = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f1360q = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private void y() {
        if (this.f1355l == null) {
            this.f1355l = VelocityTracker.obtain();
        }
    }

    private boolean z(View view) {
        return !B(view, 0, getHeight());
    }

    boolean E(int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, boolean z4) {
        boolean z5;
        boolean z6;
        int overScrollMode = getOverScrollMode();
        boolean z7 = computeHorizontalScrollRange() > computeHorizontalScrollExtent();
        boolean z8 = computeVerticalScrollRange() > computeVerticalScrollExtent();
        boolean z9 = overScrollMode == 0 || (overScrollMode == 1 && z7);
        boolean z10 = overScrollMode == 0 || (overScrollMode == 1 && z8);
        int i12 = i6 + i4;
        int i13 = !z9 ? 0 : i10;
        int i14 = i7 + i5;
        int i15 = !z10 ? 0 : i11;
        int i16 = -i13;
        int i17 = i13 + i8;
        int i18 = -i15;
        int i19 = i15 + i9;
        if (i12 > i17) {
            i12 = i17;
            z5 = true;
        } else if (i12 < i16) {
            z5 = true;
            i12 = i16;
        } else {
            z5 = false;
        }
        if (i14 > i19) {
            i14 = i19;
            z6 = true;
        } else if (i14 < i18) {
            z6 = true;
            i14 = i18;
        } else {
            z6 = false;
        }
        if (z6 && !u(1)) {
            this.f1347d.springBack(i12, i14, 0, 0, 0, getScrollRange());
        }
        onOverScrolled(i12, i14, z5, z6);
        return z5 || z6;
    }

    public boolean F(int i4) {
        boolean z4 = i4 == 130;
        int height = getHeight();
        if (z4) {
            this.f1346c.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
                Rect rect = this.f1346c;
                if (rect.top + height > bottom) {
                    rect.top = bottom - height;
                }
            }
        } else {
            this.f1346c.top = getScrollY() - height;
            Rect rect2 = this.f1346c;
            if (rect2.top < 0) {
                rect2.top = 0;
            }
        }
        Rect rect3 = this.f1346c;
        int i5 = rect3.top;
        int i6 = height + i5;
        rect3.bottom = i6;
        return I(i4, i5, i6);
    }

    public final void L(int i4, int i5) {
        M(i4, i5, false);
    }

    void N(int i4, int i5, boolean z4) {
        M(i4 - getScrollX(), i5 - getScrollY(), z4);
    }

    public boolean O(int i4, int i5) {
        return this.f1368y.q(i4, i5);
    }

    public void P(int i4) {
        this.f1368y.s(i4);
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i4) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i4);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i4, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i4, layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, layoutParams);
    }

    public boolean b(int i4) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i4);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !B(findNextFocus, maxScrollAmount, getHeight())) {
            if (i4 == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i4 == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getScrollY() + getHeight()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i4 != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            k(maxScrollAmount);
        } else {
            findNextFocus.getDrawingRect(this.f1346c);
            offsetDescendantRectToMyCoords(findNextFocus, this.f1346c);
            k(e(this.f1346c));
            findNextFocus.requestFocus(i4);
        }
        if (findFocus == null || !findFocus.isFocused() || !z(findFocus)) {
            return true;
        }
        int descendantFocusability = getDescendantFocusability();
        setDescendantFocusability(131072);
        requestFocus();
        setDescendantFocusability(descendantFocusability);
        return true;
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    @Override // android.view.View
    public void computeScroll() {
        EdgeEffect edgeEffect;
        if (this.f1347d.isFinished()) {
            return;
        }
        this.f1347d.computeScrollOffset();
        int currY = this.f1347d.getCurrY();
        int i4 = currY - this.f1365v;
        this.f1365v = currY;
        int[] iArr = this.f1363t;
        boolean z4 = false;
        iArr[1] = 0;
        f(0, i4, iArr, null, 1);
        int i5 = i4 - this.f1363t[1];
        int scrollRange = getScrollRange();
        if (i5 != 0) {
            int scrollY = getScrollY();
            E(0, i5, getScrollX(), scrollY, 0, scrollRange, 0, 0, false);
            int scrollY2 = getScrollY() - scrollY;
            int i6 = i5 - scrollY2;
            int[] iArr2 = this.f1363t;
            iArr2[1] = 0;
            g(0, scrollY2, 0, i6, this.f1362s, 1, iArr2);
            i5 = i6 - this.f1363t[1];
        }
        if (i5 != 0) {
            int overScrollMode = getOverScrollMode();
            if (overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0)) {
                z4 = true;
            }
            if (z4) {
                p();
                if (i5 < 0) {
                    if (this.f1348e.isFinished()) {
                        edgeEffect = this.f1348e;
                        edgeEffect.onAbsorb((int) this.f1347d.getCurrVelocity());
                    }
                } else if (this.f1349f.isFinished()) {
                    edgeEffect = this.f1349f;
                    edgeEffect.onAbsorb((int) this.f1347d.getCurrVelocity());
                }
            }
            a();
        }
        if (this.f1347d.isFinished()) {
            P(1);
        } else {
            p.S(this);
        }
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int max = Math.max(0, bottom - height);
        return scrollY < 0 ? bottom - scrollY : scrollY > max ? bottom + (scrollY - max) : bottom;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || q(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f4, float f5, boolean z4) {
        return this.f1368y.a(f4, f5, z4);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f4, float f5) {
        return this.f1368y.b(f4, f5);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i4, int i5, int[] iArr, int[] iArr2) {
        return f(i4, i5, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i4, int i5, int i6, int i7, int[] iArr) {
        return this.f1368y.f(i4, i5, i6, i7, iArr);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int i4;
        super.draw(canvas);
        if (this.f1348e != null) {
            int scrollY = getScrollY();
            int i5 = 0;
            if (!this.f1348e.isFinished()) {
                int save = canvas.save();
                int width = getWidth();
                int height = getHeight();
                int min = Math.min(0, scrollY);
                if (getClipToPadding()) {
                    width -= getPaddingLeft() + getPaddingRight();
                    i4 = getPaddingLeft() + 0;
                } else {
                    i4 = 0;
                }
                if (getClipToPadding()) {
                    height -= getPaddingTop() + getPaddingBottom();
                    min += getPaddingTop();
                }
                canvas.translate(i4, min);
                this.f1348e.setSize(width, height);
                if (this.f1348e.draw(canvas)) {
                    p.S(this);
                }
                canvas.restoreToCount(save);
            }
            if (this.f1349f.isFinished()) {
                return;
            }
            int save2 = canvas.save();
            int width2 = getWidth();
            int height2 = getHeight();
            int max = Math.max(getScrollRange(), scrollY) + height2;
            if (getClipToPadding()) {
                width2 -= getPaddingLeft() + getPaddingRight();
                i5 = 0 + getPaddingLeft();
            }
            if (getClipToPadding()) {
                height2 -= getPaddingTop() + getPaddingBottom();
                max -= getPaddingBottom();
            }
            canvas.translate(i5 - width2, max);
            canvas.rotate(180.0f, width2, 0.0f);
            this.f1349f.setSize(width2, height2);
            if (this.f1349f.draw(canvas)) {
                p.S(this);
            }
            canvas.restoreToCount(save2);
        }
    }

    protected int e(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i5 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i4 - verticalFadingEdgeLength : i4;
        int i6 = rect.bottom;
        if (i6 > i5 && rect.top > scrollY) {
            return Math.min((rect.height() > height ? rect.top - scrollY : rect.bottom - i5) + 0, (childAt.getBottom() + layoutParams.bottomMargin) - i4);
        }
        if (rect.top >= scrollY || i6 >= i5) {
            return 0;
        }
        return Math.max(rect.height() > height ? 0 - (i5 - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
    }

    public boolean f(int i4, int i5, int[] iArr, int[] iArr2, int i6) {
        return this.f1368y.d(i4, i5, iArr, iArr2, i6);
    }

    public void g(int i4, int i5, int i6, int i7, int[] iArr, int i8, int[] iArr2) {
        this.f1368y.e(i4, i5, i6, i7, iArr, i8, iArr2);
    }

    @Override // android.view.View
    protected float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + layoutParams.bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (getHeight() * 0.5f);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f1367x.a();
    }

    int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    @Override // android.view.View
    protected float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    @Override // y.k
    public void h(View view, View view2, int i4, int i5) {
        this.f1367x.c(view, view2, i4, i5);
        O(2, i5);
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return u(0);
    }

    @Override // y.k
    public void i(View view, int i4) {
        this.f1367x.d(view, i4);
        P(i4);
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.f1368y.m();
    }

    @Override // y.k
    public void j(View view, int i4, int i5, int[] iArr, int i6) {
        f(i4, i5, iArr, null, i6);
    }

    @Override // y.l
    public void m(View view, int i4, int i5, int i6, int i7, int i8, int[] iArr) {
        C(i7, i8, iArr);
    }

    @Override // android.view.ViewGroup
    protected void measureChild(View view, int i4, int i5) {
        view.measure(FrameLayout.getChildMeasureSpec(i4, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    protected void measureChildWithMargins(View view, int i4, int i5, int i6, int i7) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(FrameLayout.getChildMeasureSpec(i4, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i5, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    @Override // y.k
    public void n(View view, int i4, int i5, int i6, int i7, int i8) {
        C(i7, i8, null);
    }

    @Override // y.k
    public boolean o(View view, View view2, int i4, int i5) {
        return (i4 & 2) != 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f1352i = false;
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0 && motionEvent.getAction() == 8 && !this.f1354k) {
            float axisValue = motionEvent.getAxisValue(9);
            if (axisValue != 0.0f) {
                int verticalScrollFactorCompat = (int) (axisValue * getVerticalScrollFactorCompat());
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                int i4 = scrollY - verticalScrollFactorCompat;
                if (i4 < 0) {
                    scrollRange = 0;
                } else if (i4 <= scrollRange) {
                    scrollRange = i4;
                }
                if (scrollRange != scrollY) {
                    super.scrollTo(getScrollX(), scrollRange);
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 2 && this.f1354k) {
            return true;
        }
        int i4 = action & 255;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 == 2) {
                    int i5 = this.f1361r;
                    if (i5 != -1) {
                        int findPointerIndex = motionEvent.findPointerIndex(i5);
                        if (findPointerIndex == -1) {
                            Log.e("NestedScrollView", "Invalid pointerId=" + i5 + " in onInterceptTouchEvent");
                        } else {
                            int y4 = (int) motionEvent.getY(findPointerIndex);
                            if (Math.abs(y4 - this.f1350g) > this.f1358o && (2 & getNestedScrollAxes()) == 0) {
                                this.f1354k = true;
                                this.f1350g = y4;
                                y();
                                this.f1355l.addMovement(motionEvent);
                                this.f1364u = 0;
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                    }
                } else if (i4 != 3) {
                    if (i4 == 6) {
                        D(motionEvent);
                    }
                }
            }
            this.f1354k = false;
            this.f1361r = -1;
            G();
            if (this.f1347d.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                p.S(this);
            }
            P(0);
        } else {
            int y5 = (int) motionEvent.getY();
            if (v((int) motionEvent.getX(), y5)) {
                this.f1350g = y5;
                this.f1361r = motionEvent.getPointerId(0);
                w();
                this.f1355l.addMovement(motionEvent);
                this.f1347d.computeScrollOffset();
                this.f1354k = !this.f1347d.isFinished();
                O(2, 0);
            } else {
                this.f1354k = false;
                G();
            }
        }
        return this.f1354k;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        super.onLayout(z4, i4, i5, i6, i7);
        int i8 = 0;
        this.f1351h = false;
        View view = this.f1353j;
        if (view != null && A(view, this)) {
            J(this.f1353j);
        }
        this.f1353j = null;
        if (!this.f1352i) {
            if (this.f1366w != null) {
                scrollTo(getScrollX(), this.f1366w.f1370b);
                this.f1366w = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                i8 = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            }
            int paddingTop = ((i7 - i5) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int d5 = d(scrollY, paddingTop, i8);
            if (d5 != scrollY) {
                scrollTo(getScrollX(), d5);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f1352i = true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        if (this.f1356m && View.MeasureSpec.getMode(i5) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(FrameLayout.getChildMeasureSpec(i4, getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f4, float f5, boolean z4) {
        if (z4) {
            return false;
        }
        dispatchNestedFling(0.0f, f5, true);
        s((int) f5);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f4, float f5) {
        return dispatchNestedPreFling(f4, f5);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i4, int i5, int[] iArr) {
        j(view, i4, i5, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i4, int i5, int i6, int i7) {
        C(i7, 0, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i4) {
        h(view, view2, i4, 0);
    }

    @Override // android.view.View
    protected void onOverScrolled(int i4, int i5, boolean z4, boolean z5) {
        super.scrollTo(i4, i5);
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i4, Rect rect) {
        if (i4 == 2) {
            i4 = 130;
        } else if (i4 == 1) {
            i4 = 33;
        }
        FocusFinder focusFinder = FocusFinder.getInstance();
        View findNextFocus = rect == null ? focusFinder.findNextFocus(this, null, i4) : focusFinder.findNextFocusFromRect(this, rect, i4);
        if (findNextFocus == null || z(findNextFocus)) {
            return false;
        }
        return findNextFocus.requestFocus(i4, rect);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof c)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        c cVar = (c) parcelable;
        super.onRestoreInstanceState(cVar.getSuperState());
        this.f1366w = cVar;
        requestLayout();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        c cVar = new c(super.onSaveInstanceState());
        cVar.f1370b = getScrollY();
        return cVar;
    }

    @Override // android.view.View
    protected void onScrollChanged(int i4, int i5, int i6, int i7) {
        super.onScrollChanged(i4, i5, i6, i7);
        b bVar = this.A;
        if (bVar != null) {
            bVar.a(this, i4, i5, i6, i7);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        View findFocus = findFocus();
        if (findFocus == null || this == findFocus || !B(findFocus, 0, i7)) {
            return;
        }
        findFocus.getDrawingRect(this.f1346c);
        offsetDescendantRectToMyCoords(findFocus, this.f1346c);
        k(e(this.f1346c));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i4) {
        return o(view, view2, i4, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        i(view, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0076, code lost:
    
        if (r23.f1347d.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0078, code lost:
    
        y.p.S(r23);
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0210, code lost:
    
        if (r23.f1347d.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) != false) goto L25;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r24) {
        /*
            Method dump skipped, instructions count: 597
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean q(KeyEvent keyEvent) {
        this.f1346c.setEmpty();
        if (!c()) {
            if (!isFocused() || keyEvent.getKeyCode() == 4) {
                return false;
            }
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, 130);
            return (findNextFocus == null || findNextFocus == this || !findNextFocus.requestFocus(130)) ? false : true;
        }
        if (keyEvent.getAction() != 0) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 19) {
            return !keyEvent.isAltPressed() ? b(33) : t(33);
        }
        if (keyCode == 20) {
            return !keyEvent.isAltPressed() ? b(130) : t(130);
        }
        if (keyCode != 62) {
            return false;
        }
        F(keyEvent.isShiftPressed() ? 33 : 130);
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (this.f1351h) {
            this.f1353j = view2;
        } else {
            J(view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z4) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return K(rect, z4);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z4) {
        if (z4) {
            G();
        }
        super.requestDisallowInterceptTouchEvent(z4);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.f1351h = true;
        super.requestLayout();
    }

    public void s(int i4) {
        if (getChildCount() > 0) {
            this.f1347d.fling(getScrollX(), getScrollY(), 0, i4, 0, 0, RecyclerView.UNDEFINED_DURATION, Integer.MAX_VALUE, 0, 0);
            H(true);
        }
    }

    @Override // android.view.View
    public void scrollTo(int i4, int i5) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int width2 = childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int height2 = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int d5 = d(i4, width, width2);
            int d6 = d(i5, height, height2);
            if (d5 == getScrollX() && d6 == getScrollY()) {
                return;
            }
            super.scrollTo(d5, d6);
        }
    }

    public void setFillViewport(boolean z4) {
        if (z4 != this.f1356m) {
            this.f1356m = z4;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z4) {
        this.f1368y.n(z4);
    }

    public void setOnScrollChangeListener(b bVar) {
        this.A = bVar;
    }

    public void setSmoothScrollingEnabled(boolean z4) {
        this.f1357n = z4;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i4) {
        return O(i4, 0);
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        P(0);
    }

    public boolean t(int i4) {
        int childCount;
        boolean z4 = i4 == 130;
        int height = getHeight();
        Rect rect = this.f1346c;
        rect.top = 0;
        rect.bottom = height;
        if (z4 && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            this.f1346c.bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
            Rect rect2 = this.f1346c;
            rect2.top = rect2.bottom - height;
        }
        Rect rect3 = this.f1346c;
        return I(i4, rect3.top, rect3.bottom);
    }

    public boolean u(int i4) {
        return this.f1368y.l(i4);
    }
}
