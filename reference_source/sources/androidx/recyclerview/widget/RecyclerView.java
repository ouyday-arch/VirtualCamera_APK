package androidx.recyclerview.widget;

import android.R;
import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.recyclerview.widget.a;
import androidx.recyclerview.widget.b;
import androidx.recyclerview.widget.e;
import androidx.recyclerview.widget.k;
import androidx.recyclerview.widget.o;
import androidx.recyclerview.widget.p;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import z.c;

/* loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements y.i {
    static final boolean DEBUG = false;
    static final int DEFAULT_ORIENTATION = 1;
    static final boolean DISPATCH_TEMP_DETACH = false;
    static final long FOREVER_NS = Long.MAX_VALUE;
    public static final int HORIZONTAL = 0;
    private static final int INVALID_POINTER = -1;
    public static final int INVALID_TYPE = -1;
    private static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE;
    static final int MAX_SCROLL_DURATION = 2000;
    public static final long NO_ID = -1;
    public static final int NO_POSITION = -1;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    static final String TAG = "RecyclerView";
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    static final String TRACE_BIND_VIEW_TAG = "RV OnBindView";
    static final String TRACE_CREATE_VIEW_TAG = "RV CreateView";
    private static final String TRACE_HANDLE_ADAPTER_UPDATES_TAG = "RV PartialInvalidate";
    static final String TRACE_NESTED_PREFETCH_TAG = "RV Nested Prefetch";
    private static final String TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG = "RV FullInvalidate";
    private static final String TRACE_ON_LAYOUT_TAG = "RV OnLayout";
    static final String TRACE_PREFETCH_TAG = "RV Prefetch";
    static final String TRACE_SCROLL_TAG = "RV Scroll";
    public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
    static final boolean VERBOSE_TRACING = false;
    public static final int VERTICAL = 1;
    static final Interpolator sQuinticInterpolator;
    androidx.recyclerview.widget.k mAccessibilityDelegate;
    private final AccessibilityManager mAccessibilityManager;
    g mAdapter;
    androidx.recyclerview.widget.a mAdapterHelper;
    boolean mAdapterUpdateDuringMeasure;
    private EdgeEffect mBottomGlow;
    private j mChildDrawingOrderCallback;
    androidx.recyclerview.widget.b mChildHelper;
    boolean mClipToPadding;
    boolean mDataSetHasChangedAfterLayout;
    boolean mDispatchItemsChangedEvent;
    private int mDispatchScrollCounter;
    private int mEatenAccessibilityChangeFlags;
    private k mEdgeEffectFactory;
    boolean mEnableFastScroller;
    boolean mFirstLayoutComplete;
    androidx.recyclerview.widget.e mGapWorker;
    boolean mHasFixedSize;
    private boolean mIgnoreMotionEventTillDown;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private int mInterceptRequestLayoutDepth;
    private s mInterceptingOnItemTouchListener;
    boolean mIsAttached;
    l mItemAnimator;
    private l.b mItemAnimatorListener;
    private Runnable mItemAnimatorRunner;
    final ArrayList<n> mItemDecorations;
    boolean mItemsAddedOrRemoved;
    boolean mItemsChanged;
    private int mLastTouchX;
    private int mLastTouchY;
    o mLayout;
    private int mLayoutOrScrollCounter;
    boolean mLayoutSuppressed;
    boolean mLayoutWasDefered;
    private EdgeEffect mLeftGlow;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private final int[] mMinMaxLayoutPositions;
    private final int[] mNestedOffsets;
    private final x mObserver;
    private List<q> mOnChildAttachStateListeners;
    private r mOnFlingListener;
    private final ArrayList<s> mOnItemTouchListeners;
    final List<d0> mPendingAccessibilityImportanceChange;
    private y mPendingSavedState;
    boolean mPostedAnimatorRunner;
    e.b mPrefetchRegistry;
    private boolean mPreserveFocusAfterLayout;
    final v mRecycler;
    w mRecyclerListener;
    final int[] mReusableIntPair;
    private EdgeEffect mRightGlow;
    private float mScaledHorizontalScrollFactor;
    private float mScaledVerticalScrollFactor;
    private t mScrollListener;
    private List<t> mScrollListeners;
    private final int[] mScrollOffset;
    private int mScrollPointerId;
    private int mScrollState;
    private y.j mScrollingChildHelper;
    final a0 mState;
    final Rect mTempRect;
    private final Rect mTempRect2;
    final RectF mTempRectF;
    private EdgeEffect mTopGlow;
    private int mTouchSlop;
    final Runnable mUpdateChildViewsRunnable;
    private VelocityTracker mVelocityTracker;
    final c0 mViewFlinger;
    private final p.b mViewInfoProcessCallback;
    final androidx.recyclerview.widget.p mViewInfoStore;
    private static final int[] NESTED_SCROLLING_ATTRS = {R.attr.nestedScrollingEnabled};
    static final boolean FORCE_INVALIDATE_DISPLAY_LIST = false;
    static final boolean ALLOW_SIZE_IN_UNSPECIFIED_SPEC = true;
    static final boolean POST_UPDATES_ON_ANIMATION = true;
    static final boolean ALLOW_THREAD_GAP_WORK = true;
    private static final boolean FORCE_ABS_FOCUS_SEARCH_DIRECTION = false;
    private static final boolean IGNORE_DETACHED_FOCUSED_CHILD = false;

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = RecyclerView.this;
            if (!recyclerView.mFirstLayoutComplete || recyclerView.isLayoutRequested()) {
                return;
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            if (!recyclerView2.mIsAttached) {
                recyclerView2.requestLayout();
            } else if (recyclerView2.mLayoutSuppressed) {
                recyclerView2.mLayoutWasDefered = true;
            } else {
                recyclerView2.consumePendingUpdateOperations();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a0 {

        /* renamed from: b, reason: collision with root package name */
        private SparseArray<Object> f1783b;

        /* renamed from: m, reason: collision with root package name */
        int f1794m;

        /* renamed from: n, reason: collision with root package name */
        long f1795n;

        /* renamed from: o, reason: collision with root package name */
        int f1796o;

        /* renamed from: p, reason: collision with root package name */
        int f1797p;

        /* renamed from: q, reason: collision with root package name */
        int f1798q;

        /* renamed from: a, reason: collision with root package name */
        int f1782a = -1;

        /* renamed from: c, reason: collision with root package name */
        int f1784c = 0;

        /* renamed from: d, reason: collision with root package name */
        int f1785d = 0;

        /* renamed from: e, reason: collision with root package name */
        int f1786e = 1;

        /* renamed from: f, reason: collision with root package name */
        int f1787f = 0;

        /* renamed from: g, reason: collision with root package name */
        boolean f1788g = false;

        /* renamed from: h, reason: collision with root package name */
        boolean f1789h = false;

        /* renamed from: i, reason: collision with root package name */
        boolean f1790i = false;

        /* renamed from: j, reason: collision with root package name */
        boolean f1791j = false;

        /* renamed from: k, reason: collision with root package name */
        boolean f1792k = false;

        /* renamed from: l, reason: collision with root package name */
        boolean f1793l = false;

        void a(int i4) {
            if ((this.f1786e & i4) != 0) {
                return;
            }
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i4) + " but it is " + Integer.toBinaryString(this.f1786e));
        }

        public int b() {
            return this.f1789h ? this.f1784c - this.f1785d : this.f1787f;
        }

        public int c() {
            return this.f1782a;
        }

        public boolean d() {
            return this.f1782a != -1;
        }

        public boolean e() {
            return this.f1789h;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void f(g gVar) {
            this.f1786e = 1;
            this.f1787f = gVar.c();
            this.f1789h = false;
            this.f1790i = false;
            this.f1791j = false;
        }

        public boolean g() {
            return this.f1793l;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f1782a + ", mData=" + this.f1783b + ", mItemCount=" + this.f1787f + ", mIsMeasuring=" + this.f1791j + ", mPreviousLayoutItemCount=" + this.f1784c + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f1785d + ", mStructureChanged=" + this.f1788g + ", mInPreLayout=" + this.f1789h + ", mRunSimpleAnimations=" + this.f1792k + ", mRunPredictiveAnimations=" + this.f1793l + '}';
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l lVar = RecyclerView.this.mItemAnimator;
            if (lVar != null) {
                lVar.u();
            }
            RecyclerView.this.mPostedAnimatorRunner = false;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class b0 {
    }

    /* loaded from: classes.dex */
    static class c implements Interpolator {
        c() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f4) {
            float f5 = f4 - 1.0f;
            return (f5 * f5 * f5 * f5 * f5) + 1.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c0 implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        private int f1800b;

        /* renamed from: c, reason: collision with root package name */
        private int f1801c;

        /* renamed from: d, reason: collision with root package name */
        OverScroller f1802d;

        /* renamed from: e, reason: collision with root package name */
        Interpolator f1803e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f1804f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f1805g;

        c0() {
            Interpolator interpolator = RecyclerView.sQuinticInterpolator;
            this.f1803e = interpolator;
            this.f1804f = false;
            this.f1805g = false;
            this.f1802d = new OverScroller(RecyclerView.this.getContext(), interpolator);
        }

        private int a(int i4, int i5, int i6, int i7) {
            int i8;
            int abs = Math.abs(i4);
            int abs2 = Math.abs(i5);
            boolean z4 = abs > abs2;
            int sqrt = (int) Math.sqrt((i6 * i6) + (i7 * i7));
            int sqrt2 = (int) Math.sqrt((i4 * i4) + (i5 * i5));
            RecyclerView recyclerView = RecyclerView.this;
            int width = z4 ? recyclerView.getWidth() : recyclerView.getHeight();
            int i9 = width / 2;
            float f4 = width;
            float f5 = i9;
            float b5 = f5 + (b(Math.min(1.0f, (sqrt2 * 1.0f) / f4)) * f5);
            if (sqrt > 0) {
                i8 = Math.round(Math.abs(b5 / sqrt) * 1000.0f) * 4;
            } else {
                if (!z4) {
                    abs = abs2;
                }
                i8 = (int) (((abs / f4) + 1.0f) * 300.0f);
            }
            return Math.min(i8, RecyclerView.MAX_SCROLL_DURATION);
        }

        private float b(float f4) {
            return (float) Math.sin((f4 - 0.5f) * 0.47123894f);
        }

        private void d() {
            RecyclerView.this.removeCallbacks(this);
            y.p.T(RecyclerView.this, this);
        }

        public void c(int i4, int i5) {
            RecyclerView.this.setScrollState(2);
            this.f1801c = 0;
            this.f1800b = 0;
            Interpolator interpolator = this.f1803e;
            Interpolator interpolator2 = RecyclerView.sQuinticInterpolator;
            if (interpolator != interpolator2) {
                this.f1803e = interpolator2;
                this.f1802d = new OverScroller(RecyclerView.this.getContext(), interpolator2);
            }
            this.f1802d.fling(0, 0, i4, i5, RecyclerView.UNDEFINED_DURATION, Integer.MAX_VALUE, RecyclerView.UNDEFINED_DURATION, Integer.MAX_VALUE);
            e();
        }

        void e() {
            if (this.f1804f) {
                this.f1805g = true;
            } else {
                d();
            }
        }

        public void f(int i4, int i5, int i6, Interpolator interpolator) {
            if (i6 == Integer.MIN_VALUE) {
                i6 = a(i4, i5, 0, 0);
            }
            int i7 = i6;
            if (interpolator == null) {
                interpolator = RecyclerView.sQuinticInterpolator;
            }
            if (this.f1803e != interpolator) {
                this.f1803e = interpolator;
                this.f1802d = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.f1801c = 0;
            this.f1800b = 0;
            RecyclerView.this.setScrollState(2);
            this.f1802d.startScroll(0, 0, i4, i5, i7);
            e();
        }

        public void g() {
            RecyclerView.this.removeCallbacks(this);
            this.f1802d.abortAnimation();
        }

        @Override // java.lang.Runnable
        public void run() {
            int i4;
            int i5;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mLayout == null) {
                g();
                return;
            }
            this.f1805g = false;
            this.f1804f = true;
            recyclerView.consumePendingUpdateOperations();
            OverScroller overScroller = this.f1802d;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i6 = currX - this.f1800b;
                int i7 = currY - this.f1801c;
                this.f1800b = currX;
                this.f1801c = currY;
                RecyclerView recyclerView2 = RecyclerView.this;
                int[] iArr = recyclerView2.mReusableIntPair;
                iArr[0] = 0;
                iArr[1] = 0;
                if (recyclerView2.dispatchNestedPreScroll(i6, i7, iArr, null, 1)) {
                    int[] iArr2 = RecyclerView.this.mReusableIntPair;
                    i6 -= iArr2[0];
                    i7 -= iArr2[1];
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.considerReleasingGlowsOnScroll(i6, i7);
                }
                RecyclerView recyclerView3 = RecyclerView.this;
                if (recyclerView3.mAdapter != null) {
                    int[] iArr3 = recyclerView3.mReusableIntPair;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    recyclerView3.scrollStep(i6, i7, iArr3);
                    RecyclerView recyclerView4 = RecyclerView.this;
                    int[] iArr4 = recyclerView4.mReusableIntPair;
                    i5 = iArr4[0];
                    i4 = iArr4[1];
                    i6 -= i5;
                    i7 -= i4;
                    z zVar = recyclerView4.mLayout.f1848g;
                    if (zVar != null && !zVar.g() && zVar.h()) {
                        int b5 = RecyclerView.this.mState.b();
                        if (b5 == 0) {
                            zVar.r();
                        } else {
                            if (zVar.f() >= b5) {
                                zVar.p(b5 - 1);
                            }
                            zVar.j(i5, i4);
                        }
                    }
                } else {
                    i4 = 0;
                    i5 = 0;
                }
                if (!RecyclerView.this.mItemDecorations.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                RecyclerView recyclerView5 = RecyclerView.this;
                int[] iArr5 = recyclerView5.mReusableIntPair;
                iArr5[0] = 0;
                iArr5[1] = 0;
                recyclerView5.dispatchNestedScroll(i5, i4, i6, i7, null, 1, iArr5);
                RecyclerView recyclerView6 = RecyclerView.this;
                int[] iArr6 = recyclerView6.mReusableIntPair;
                int i8 = i6 - iArr6[0];
                int i9 = i7 - iArr6[1];
                if (i5 != 0 || i4 != 0) {
                    recyclerView6.dispatchOnScrolled(i5, i4);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z4 = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i8 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i9 != 0));
                z zVar2 = RecyclerView.this.mLayout.f1848g;
                if ((zVar2 != null && zVar2.g()) || !z4) {
                    e();
                    RecyclerView recyclerView7 = RecyclerView.this;
                    androidx.recyclerview.widget.e eVar = recyclerView7.mGapWorker;
                    if (eVar != null) {
                        eVar.f(recyclerView7, i5, i4);
                    }
                } else {
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        int i10 = i8 < 0 ? -currVelocity : i8 > 0 ? currVelocity : 0;
                        if (i9 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i9 <= 0) {
                            currVelocity = 0;
                        }
                        RecyclerView.this.absorbGlows(i10, currVelocity);
                    }
                    if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                        RecyclerView.this.mPrefetchRegistry.b();
                    }
                }
            }
            z zVar3 = RecyclerView.this.mLayout.f1848g;
            if (zVar3 != null && zVar3.g()) {
                zVar3.j(0, 0);
            }
            this.f1804f = false;
            if (this.f1805g) {
                d();
            } else {
                RecyclerView.this.setScrollState(0);
                RecyclerView.this.stopNestedScroll(1);
            }
        }
    }

    /* loaded from: classes.dex */
    class d implements p.b {
        d() {
        }

        @Override // androidx.recyclerview.widget.p.b
        public void a(d0 d0Var) {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.mLayout.m1(d0Var.f1809a, recyclerView.mRecycler);
        }

        @Override // androidx.recyclerview.widget.p.b
        public void b(d0 d0Var, l.c cVar, l.c cVar2) {
            RecyclerView.this.animateAppearance(d0Var, cVar, cVar2);
        }

        @Override // androidx.recyclerview.widget.p.b
        public void c(d0 d0Var, l.c cVar, l.c cVar2) {
            RecyclerView.this.mRecycler.J(d0Var);
            RecyclerView.this.animateDisappearance(d0Var, cVar, cVar2);
        }

        @Override // androidx.recyclerview.widget.p.b
        public void d(d0 d0Var, l.c cVar, l.c cVar2) {
            d0Var.G(false);
            RecyclerView recyclerView = RecyclerView.this;
            boolean z4 = recyclerView.mDataSetHasChangedAfterLayout;
            l lVar = recyclerView.mItemAnimator;
            if (z4) {
                if (!lVar.b(d0Var, d0Var, cVar, cVar2)) {
                    return;
                }
            } else if (!lVar.d(d0Var, cVar, cVar2)) {
                return;
            }
            RecyclerView.this.postAnimationRunner();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class d0 {

        /* renamed from: s, reason: collision with root package name */
        private static final List<Object> f1808s = Collections.emptyList();

        /* renamed from: a, reason: collision with root package name */
        public final View f1809a;

        /* renamed from: b, reason: collision with root package name */
        WeakReference<RecyclerView> f1810b;

        /* renamed from: j, reason: collision with root package name */
        int f1818j;

        /* renamed from: r, reason: collision with root package name */
        RecyclerView f1826r;

        /* renamed from: c, reason: collision with root package name */
        int f1811c = -1;

        /* renamed from: d, reason: collision with root package name */
        int f1812d = -1;

        /* renamed from: e, reason: collision with root package name */
        long f1813e = -1;

        /* renamed from: f, reason: collision with root package name */
        int f1814f = -1;

        /* renamed from: g, reason: collision with root package name */
        int f1815g = -1;

        /* renamed from: h, reason: collision with root package name */
        d0 f1816h = null;

        /* renamed from: i, reason: collision with root package name */
        d0 f1817i = null;

        /* renamed from: k, reason: collision with root package name */
        List<Object> f1819k = null;

        /* renamed from: l, reason: collision with root package name */
        List<Object> f1820l = null;

        /* renamed from: m, reason: collision with root package name */
        private int f1821m = 0;

        /* renamed from: n, reason: collision with root package name */
        v f1822n = null;

        /* renamed from: o, reason: collision with root package name */
        boolean f1823o = false;

        /* renamed from: p, reason: collision with root package name */
        private int f1824p = 0;

        /* renamed from: q, reason: collision with root package name */
        int f1825q = -1;

        public d0(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.f1809a = view;
        }

        private void g() {
            if (this.f1819k == null) {
                ArrayList arrayList = new ArrayList();
                this.f1819k = arrayList;
                this.f1820l = Collections.unmodifiableList(arrayList);
            }
        }

        void A(int i4, boolean z4) {
            if (this.f1812d == -1) {
                this.f1812d = this.f1811c;
            }
            if (this.f1815g == -1) {
                this.f1815g = this.f1811c;
            }
            if (z4) {
                this.f1815g += i4;
            }
            this.f1811c += i4;
            if (this.f1809a.getLayoutParams() != null) {
                ((p) this.f1809a.getLayoutParams()).f1868c = true;
            }
        }

        void B(RecyclerView recyclerView) {
            int i4 = this.f1825q;
            if (i4 == -1) {
                i4 = y.p.r(this.f1809a);
            }
            this.f1824p = i4;
            recyclerView.setChildImportantForAccessibilityInternal(this, 4);
        }

        void C(RecyclerView recyclerView) {
            recyclerView.setChildImportantForAccessibilityInternal(this, this.f1824p);
            this.f1824p = 0;
        }

        void D() {
            this.f1818j = 0;
            this.f1811c = -1;
            this.f1812d = -1;
            this.f1813e = -1L;
            this.f1815g = -1;
            this.f1821m = 0;
            this.f1816h = null;
            this.f1817i = null;
            d();
            this.f1824p = 0;
            this.f1825q = -1;
            RecyclerView.clearNestedRecyclerViewIfNotNested(this);
        }

        void E() {
            if (this.f1812d == -1) {
                this.f1812d = this.f1811c;
            }
        }

        void F(int i4, int i5) {
            this.f1818j = (i4 & i5) | (this.f1818j & (~i5));
        }

        public final void G(boolean z4) {
            int i4;
            int i5 = this.f1821m;
            int i6 = z4 ? i5 - 1 : i5 + 1;
            this.f1821m = i6;
            if (i6 < 0) {
                this.f1821m = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                return;
            }
            if (!z4 && i6 == 1) {
                i4 = this.f1818j | 16;
            } else if (!z4 || i6 != 0) {
                return;
            } else {
                i4 = this.f1818j & (-17);
            }
            this.f1818j = i4;
        }

        void H(v vVar, boolean z4) {
            this.f1822n = vVar;
            this.f1823o = z4;
        }

        boolean I() {
            return (this.f1818j & 16) != 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean J() {
            return (this.f1818j & 128) != 0;
        }

        void K() {
            this.f1822n.J(this);
        }

        boolean L() {
            return (this.f1818j & 32) != 0;
        }

        void a(Object obj) {
            if (obj == null) {
                b(1024);
            } else if ((1024 & this.f1818j) == 0) {
                g();
                this.f1819k.add(obj);
            }
        }

        void b(int i4) {
            this.f1818j = i4 | this.f1818j;
        }

        void c() {
            this.f1812d = -1;
            this.f1815g = -1;
        }

        void d() {
            List<Object> list = this.f1819k;
            if (list != null) {
                list.clear();
            }
            this.f1818j &= -1025;
        }

        void e() {
            this.f1818j &= -33;
        }

        void f() {
            this.f1818j &= -257;
        }

        boolean h() {
            return (this.f1818j & 16) == 0 && y.p.E(this.f1809a);
        }

        void i(int i4, int i5, boolean z4) {
            b(8);
            A(i5, z4);
            this.f1811c = i4;
        }

        public final int j() {
            RecyclerView recyclerView = this.f1826r;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.getAdapterPositionFor(this);
        }

        public final long k() {
            return this.f1813e;
        }

        public final int l() {
            return this.f1814f;
        }

        public final int m() {
            int i4 = this.f1815g;
            return i4 == -1 ? this.f1811c : i4;
        }

        public final int n() {
            return this.f1812d;
        }

        List<Object> o() {
            if ((this.f1818j & 1024) != 0) {
                return f1808s;
            }
            List<Object> list = this.f1819k;
            return (list == null || list.size() == 0) ? f1808s : this.f1820l;
        }

        boolean p(int i4) {
            return (i4 & this.f1818j) != 0;
        }

        boolean q() {
            return (this.f1818j & 512) != 0 || t();
        }

        boolean r() {
            return (this.f1809a.getParent() == null || this.f1809a.getParent() == this.f1826r) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean s() {
            return (this.f1818j & 1) != 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean t() {
            return (this.f1818j & 4) != 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder((getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName()) + "{" + Integer.toHexString(hashCode()) + " position=" + this.f1811c + " id=" + this.f1813e + ", oldPos=" + this.f1812d + ", pLpos:" + this.f1815g);
            if (w()) {
                sb.append(" scrap ");
                sb.append(this.f1823o ? "[changeScrap]" : "[attachedScrap]");
            }
            if (t()) {
                sb.append(" invalid");
            }
            if (!s()) {
                sb.append(" unbound");
            }
            if (z()) {
                sb.append(" update");
            }
            if (v()) {
                sb.append(" removed");
            }
            if (J()) {
                sb.append(" ignored");
            }
            if (x()) {
                sb.append(" tmpDetached");
            }
            if (!u()) {
                sb.append(" not recyclable(" + this.f1821m + ")");
            }
            if (q()) {
                sb.append(" undefined adapter position");
            }
            if (this.f1809a.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        public final boolean u() {
            return (this.f1818j & 16) == 0 && !y.p.E(this.f1809a);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean v() {
            return (this.f1818j & 8) != 0;
        }

        boolean w() {
            return this.f1822n != null;
        }

        boolean x() {
            return (this.f1818j & 256) != 0;
        }

        boolean y() {
            return (this.f1818j & 2) != 0;
        }

        boolean z() {
            return (this.f1818j & 2) != 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements b.InterfaceC0016b {
        e() {
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0016b
        public View a(int i4) {
            return RecyclerView.this.getChildAt(i4);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0016b
        public void b(View view) {
            d0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                childViewHolderInt.B(RecyclerView.this);
            }
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0016b
        public void c(int i4) {
            View childAt = RecyclerView.this.getChildAt(i4);
            if (childAt != null) {
                RecyclerView.this.dispatchChildDetached(childAt);
                childAt.clearAnimation();
            }
            RecyclerView.this.removeViewAt(i4);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0016b
        public void d() {
            int k4 = k();
            for (int i4 = 0; i4 < k4; i4++) {
                View a5 = a(i4);
                RecyclerView.this.dispatchChildDetached(a5);
                a5.clearAnimation();
            }
            RecyclerView.this.removeAllViews();
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0016b
        public d0 e(View view) {
            return RecyclerView.getChildViewHolderInt(view);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0016b
        public void f(int i4) {
            d0 childViewHolderInt;
            View a5 = a(i4);
            if (a5 != null && (childViewHolderInt = RecyclerView.getChildViewHolderInt(a5)) != null) {
                if (childViewHolderInt.x() && !childViewHolderInt.J()) {
                    throw new IllegalArgumentException("called detach on an already detached child " + childViewHolderInt + RecyclerView.this.exceptionLabel());
                }
                childViewHolderInt.b(256);
            }
            RecyclerView.this.detachViewFromParent(i4);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0016b
        public void g(View view) {
            d0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                childViewHolderInt.C(RecyclerView.this);
            }
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0016b
        public void h(View view, int i4, ViewGroup.LayoutParams layoutParams) {
            d0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                if (!childViewHolderInt.x() && !childViewHolderInt.J()) {
                    throw new IllegalArgumentException("Called attach on a child which is not detached: " + childViewHolderInt + RecyclerView.this.exceptionLabel());
                }
                childViewHolderInt.f();
            }
            RecyclerView.this.attachViewToParent(view, i4, layoutParams);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0016b
        public void i(View view, int i4) {
            RecyclerView.this.addView(view, i4);
            RecyclerView.this.dispatchChildAttached(view);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0016b
        public int j(View view) {
            return RecyclerView.this.indexOfChild(view);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0016b
        public int k() {
            return RecyclerView.this.getChildCount();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements a.InterfaceC0015a {
        f() {
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0015a
        public void a(int i4, int i5) {
            RecyclerView.this.offsetPositionRecordsForMove(i4, i5);
            RecyclerView.this.mItemsAddedOrRemoved = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0015a
        public void b(a.b bVar) {
            i(bVar);
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0015a
        public d0 c(int i4) {
            d0 findViewHolderForPosition = RecyclerView.this.findViewHolderForPosition(i4, true);
            if (findViewHolderForPosition == null || RecyclerView.this.mChildHelper.n(findViewHolderForPosition.f1809a)) {
                return null;
            }
            return findViewHolderForPosition;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0015a
        public void d(int i4, int i5) {
            RecyclerView.this.offsetPositionRecordsForRemove(i4, i5, true);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.mItemsAddedOrRemoved = true;
            recyclerView.mState.f1785d += i5;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0015a
        public void e(int i4, int i5) {
            RecyclerView.this.offsetPositionRecordsForRemove(i4, i5, false);
            RecyclerView.this.mItemsAddedOrRemoved = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0015a
        public void f(a.b bVar) {
            i(bVar);
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0015a
        public void g(int i4, int i5) {
            RecyclerView.this.offsetPositionRecordsForInsert(i4, i5);
            RecyclerView.this.mItemsAddedOrRemoved = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0015a
        public void h(int i4, int i5, Object obj) {
            RecyclerView.this.viewRangeUpdate(i4, i5, obj);
            RecyclerView.this.mItemsChanged = true;
        }

        void i(a.b bVar) {
            int i4 = bVar.f1949a;
            if (i4 == 1) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.mLayout.R0(recyclerView, bVar.f1950b, bVar.f1952d);
                return;
            }
            if (i4 == 2) {
                RecyclerView recyclerView2 = RecyclerView.this;
                recyclerView2.mLayout.U0(recyclerView2, bVar.f1950b, bVar.f1952d);
            } else if (i4 == 4) {
                RecyclerView recyclerView3 = RecyclerView.this;
                recyclerView3.mLayout.W0(recyclerView3, bVar.f1950b, bVar.f1952d, bVar.f1951c);
            } else {
                if (i4 != 8) {
                    return;
                }
                RecyclerView recyclerView4 = RecyclerView.this;
                recyclerView4.mLayout.T0(recyclerView4, bVar.f1950b, bVar.f1952d, 1);
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class g<VH extends d0> {

        /* renamed from: a, reason: collision with root package name */
        private final h f1829a = new h();

        /* renamed from: b, reason: collision with root package name */
        private boolean f1830b = false;

        public final void a(VH vh, int i4) {
            vh.f1811c = i4;
            if (g()) {
                vh.f1813e = d(i4);
            }
            vh.F(1, 519);
            u.a.a(RecyclerView.TRACE_BIND_VIEW_TAG);
            k(vh, i4, vh.o());
            vh.d();
            ViewGroup.LayoutParams layoutParams = vh.f1809a.getLayoutParams();
            if (layoutParams instanceof p) {
                ((p) layoutParams).f1868c = true;
            }
            u.a.b();
        }

        public final VH b(ViewGroup viewGroup, int i4) {
            try {
                u.a.a(RecyclerView.TRACE_CREATE_VIEW_TAG);
                VH l4 = l(viewGroup, i4);
                if (l4.f1809a.getParent() != null) {
                    throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
                }
                l4.f1814f = i4;
                return l4;
            } finally {
                u.a.b();
            }
        }

        public abstract int c();

        public long d(int i4) {
            return -1L;
        }

        public int e(int i4) {
            return 0;
        }

        public final boolean f() {
            return this.f1829a.a();
        }

        public final boolean g() {
            return this.f1830b;
        }

        public final void h() {
            this.f1829a.b();
        }

        public void i(RecyclerView recyclerView) {
        }

        public abstract void j(VH vh, int i4);

        public void k(VH vh, int i4, List<Object> list) {
            j(vh, i4);
        }

        public abstract VH l(ViewGroup viewGroup, int i4);

        public void m(RecyclerView recyclerView) {
        }

        public boolean n(VH vh) {
            return false;
        }

        public void o(VH vh) {
        }

        public void p(VH vh) {
        }

        public void q(VH vh) {
        }

        public void r(i iVar) {
            this.f1829a.registerObserver(iVar);
        }

        public void s(boolean z4) {
            if (f()) {
                throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            }
            this.f1830b = z4;
        }

        public void t(i iVar) {
            this.f1829a.unregisterObserver(iVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class h extends Observable<i> {
        h() {
        }

        public boolean a() {
            return !((Observable) this).mObservers.isEmpty();
        }

        public void b() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((i) ((Observable) this).mObservers.get(size)).a();
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class i {
        public void a() {
        }
    }

    /* loaded from: classes.dex */
    public interface j {
        int a(int i4, int i5);
    }

    /* loaded from: classes.dex */
    public static class k {
        protected EdgeEffect a(RecyclerView recyclerView, int i4) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    /* loaded from: classes.dex */
    public static abstract class l {

        /* renamed from: a, reason: collision with root package name */
        private b f1831a = null;

        /* renamed from: b, reason: collision with root package name */
        private ArrayList<a> f1832b = new ArrayList<>();

        /* renamed from: c, reason: collision with root package name */
        private long f1833c = 120;

        /* renamed from: d, reason: collision with root package name */
        private long f1834d = 120;

        /* renamed from: e, reason: collision with root package name */
        private long f1835e = 250;

        /* renamed from: f, reason: collision with root package name */
        private long f1836f = 250;

        /* loaded from: classes.dex */
        public interface a {
            void a();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public interface b {
            void a(d0 d0Var);
        }

        /* loaded from: classes.dex */
        public static class c {

            /* renamed from: a, reason: collision with root package name */
            public int f1837a;

            /* renamed from: b, reason: collision with root package name */
            public int f1838b;

            /* renamed from: c, reason: collision with root package name */
            public int f1839c;

            /* renamed from: d, reason: collision with root package name */
            public int f1840d;

            public c a(d0 d0Var) {
                return b(d0Var, 0);
            }

            public c b(d0 d0Var, int i4) {
                View view = d0Var.f1809a;
                this.f1837a = view.getLeft();
                this.f1838b = view.getTop();
                this.f1839c = view.getRight();
                this.f1840d = view.getBottom();
                return this;
            }
        }

        static int e(d0 d0Var) {
            int i4 = d0Var.f1818j & 14;
            if (d0Var.t()) {
                return 4;
            }
            if ((i4 & 4) != 0) {
                return i4;
            }
            int n4 = d0Var.n();
            int j4 = d0Var.j();
            return (n4 == -1 || j4 == -1 || n4 == j4) ? i4 : i4 | 2048;
        }

        public abstract boolean a(d0 d0Var, c cVar, c cVar2);

        public abstract boolean b(d0 d0Var, d0 d0Var2, c cVar, c cVar2);

        public abstract boolean c(d0 d0Var, c cVar, c cVar2);

        public abstract boolean d(d0 d0Var, c cVar, c cVar2);

        public abstract boolean f(d0 d0Var);

        public boolean g(d0 d0Var, List<Object> list) {
            return f(d0Var);
        }

        public final void h(d0 d0Var) {
            r(d0Var);
            b bVar = this.f1831a;
            if (bVar != null) {
                bVar.a(d0Var);
            }
        }

        public final void i() {
            int size = this.f1832b.size();
            for (int i4 = 0; i4 < size; i4++) {
                this.f1832b.get(i4).a();
            }
            this.f1832b.clear();
        }

        public abstract void j(d0 d0Var);

        public abstract void k();

        public long l() {
            return this.f1833c;
        }

        public long m() {
            return this.f1836f;
        }

        public long n() {
            return this.f1835e;
        }

        public long o() {
            return this.f1834d;
        }

        public abstract boolean p();

        public c q() {
            return new c();
        }

        public void r(d0 d0Var) {
        }

        public c s(a0 a0Var, d0 d0Var) {
            return q().a(d0Var);
        }

        public c t(a0 a0Var, d0 d0Var, int i4, List<Object> list) {
            return q().a(d0Var);
        }

        public abstract void u();

        void v(b bVar) {
            this.f1831a = bVar;
        }
    }

    /* loaded from: classes.dex */
    private class m implements l.b {
        m() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.l.b
        public void a(d0 d0Var) {
            d0Var.G(true);
            if (d0Var.f1816h != null && d0Var.f1817i == null) {
                d0Var.f1816h = null;
            }
            d0Var.f1817i = null;
            if (d0Var.I() || RecyclerView.this.removeAnimatingView(d0Var.f1809a) || !d0Var.x()) {
                return;
            }
            RecyclerView.this.removeDetachedView(d0Var.f1809a, false);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class n {
        @Deprecated
        public void d(Rect rect, int i4, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void e(Rect rect, View view, RecyclerView recyclerView, a0 a0Var) {
            d(rect, ((p) view.getLayoutParams()).a(), recyclerView);
        }

        @Deprecated
        public void f(Canvas canvas, RecyclerView recyclerView) {
        }

        public void g(Canvas canvas, RecyclerView recyclerView, a0 a0Var) {
            f(canvas, recyclerView);
        }

        @Deprecated
        public void h(Canvas canvas, RecyclerView recyclerView) {
        }

        public void i(Canvas canvas, RecyclerView recyclerView, a0 a0Var) {
            h(canvas, recyclerView);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class o {

        /* renamed from: a, reason: collision with root package name */
        androidx.recyclerview.widget.b f1842a;

        /* renamed from: b, reason: collision with root package name */
        RecyclerView f1843b;

        /* renamed from: c, reason: collision with root package name */
        private final o.b f1844c;

        /* renamed from: d, reason: collision with root package name */
        private final o.b f1845d;

        /* renamed from: e, reason: collision with root package name */
        androidx.recyclerview.widget.o f1846e;

        /* renamed from: f, reason: collision with root package name */
        androidx.recyclerview.widget.o f1847f;

        /* renamed from: g, reason: collision with root package name */
        z f1848g;

        /* renamed from: h, reason: collision with root package name */
        boolean f1849h;

        /* renamed from: i, reason: collision with root package name */
        boolean f1850i;

        /* renamed from: j, reason: collision with root package name */
        boolean f1851j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f1852k;

        /* renamed from: l, reason: collision with root package name */
        private boolean f1853l;

        /* renamed from: m, reason: collision with root package name */
        int f1854m;

        /* renamed from: n, reason: collision with root package name */
        boolean f1855n;

        /* renamed from: o, reason: collision with root package name */
        private int f1856o;

        /* renamed from: p, reason: collision with root package name */
        private int f1857p;

        /* renamed from: q, reason: collision with root package name */
        private int f1858q;

        /* renamed from: r, reason: collision with root package name */
        private int f1859r;

        /* loaded from: classes.dex */
        class a implements o.b {
            a() {
            }

            @Override // androidx.recyclerview.widget.o.b
            public View a(int i4) {
                return o.this.I(i4);
            }

            @Override // androidx.recyclerview.widget.o.b
            public int b() {
                return o.this.o0() - o.this.f0();
            }

            @Override // androidx.recyclerview.widget.o.b
            public int c() {
                return o.this.e0();
            }

            @Override // androidx.recyclerview.widget.o.b
            public int d(View view) {
                return o.this.T(view) + ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).rightMargin;
            }

            @Override // androidx.recyclerview.widget.o.b
            public int e(View view) {
                return o.this.Q(view) - ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).leftMargin;
            }
        }

        /* loaded from: classes.dex */
        class b implements o.b {
            b() {
            }

            @Override // androidx.recyclerview.widget.o.b
            public View a(int i4) {
                return o.this.I(i4);
            }

            @Override // androidx.recyclerview.widget.o.b
            public int b() {
                return o.this.W() - o.this.d0();
            }

            @Override // androidx.recyclerview.widget.o.b
            public int c() {
                return o.this.g0();
            }

            @Override // androidx.recyclerview.widget.o.b
            public int d(View view) {
                return o.this.O(view) + ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).bottomMargin;
            }

            @Override // androidx.recyclerview.widget.o.b
            public int e(View view) {
                return o.this.U(view) - ((ViewGroup.MarginLayoutParams) ((p) view.getLayoutParams())).topMargin;
            }
        }

        /* loaded from: classes.dex */
        public interface c {
            void a(int i4, int i5);
        }

        /* loaded from: classes.dex */
        public static class d {

            /* renamed from: a, reason: collision with root package name */
            public int f1862a;

            /* renamed from: b, reason: collision with root package name */
            public int f1863b;

            /* renamed from: c, reason: collision with root package name */
            public boolean f1864c;

            /* renamed from: d, reason: collision with root package name */
            public boolean f1865d;
        }

        public o() {
            a aVar = new a();
            this.f1844c = aVar;
            b bVar = new b();
            this.f1845d = bVar;
            this.f1846e = new androidx.recyclerview.widget.o(aVar);
            this.f1847f = new androidx.recyclerview.widget.o(bVar);
            this.f1849h = false;
            this.f1850i = false;
            this.f1851j = false;
            this.f1852k = true;
            this.f1853l = true;
        }

        /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
        
            if (r5 == 1073741824) goto L14;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static int K(int r4, int r5, int r6, int r7, boolean r8) {
            /*
                int r4 = r4 - r6
                r6 = 0
                int r4 = java.lang.Math.max(r6, r4)
                r0 = -2
                r1 = -1
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = 1073741824(0x40000000, float:2.0)
                if (r8 == 0) goto L1a
                if (r7 < 0) goto L11
                goto L1c
            L11:
                if (r7 != r1) goto L2f
                if (r5 == r2) goto L20
                if (r5 == 0) goto L2f
                if (r5 == r3) goto L20
                goto L2f
            L1a:
                if (r7 < 0) goto L1e
            L1c:
                r5 = r3
                goto L31
            L1e:
                if (r7 != r1) goto L22
            L20:
                r7 = r4
                goto L31
            L22:
                if (r7 != r0) goto L2f
                if (r5 == r2) goto L2c
                if (r5 != r3) goto L29
                goto L2c
            L29:
                r7 = r4
                r5 = r6
                goto L31
            L2c:
                r7 = r4
                r5 = r2
                goto L31
            L2f:
                r5 = r6
                r7 = r5
            L31:
                int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r5)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.o.K(int, int, int, int, boolean):int");
        }

        private int[] L(View view, Rect rect) {
            int[] iArr = new int[2];
            int e02 = e0();
            int g02 = g0();
            int o02 = o0() - f0();
            int W = W() - d0();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width = rect.width() + left;
            int height = rect.height() + top;
            int i4 = left - e02;
            int min = Math.min(0, i4);
            int i5 = top - g02;
            int min2 = Math.min(0, i5);
            int i6 = width - o02;
            int max = Math.max(0, i6);
            int max2 = Math.max(0, height - W);
            if (Z() != 1) {
                if (min == 0) {
                    min = Math.min(i4, max);
                }
                max = min;
            } else if (max == 0) {
                max = Math.max(min, i6);
            }
            if (min2 == 0) {
                min2 = Math.min(i5, max2);
            }
            iArr[0] = max;
            iArr[1] = min2;
            return iArr;
        }

        private void f(View view, int i4, boolean z4) {
            d0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (z4 || childViewHolderInt.v()) {
                this.f1843b.mViewInfoStore.b(childViewHolderInt);
            } else {
                this.f1843b.mViewInfoStore.p(childViewHolderInt);
            }
            p pVar = (p) view.getLayoutParams();
            if (childViewHolderInt.L() || childViewHolderInt.w()) {
                if (childViewHolderInt.w()) {
                    childViewHolderInt.K();
                } else {
                    childViewHolderInt.e();
                }
                this.f1842a.c(view, i4, view.getLayoutParams(), false);
            } else if (view.getParent() == this.f1843b) {
                int m4 = this.f1842a.m(view);
                if (i4 == -1) {
                    i4 = this.f1842a.g();
                }
                if (m4 == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.f1843b.indexOfChild(view) + this.f1843b.exceptionLabel());
                }
                if (m4 != i4) {
                    this.f1843b.mLayout.B0(m4, i4);
                }
            } else {
                this.f1842a.a(view, i4, false);
                pVar.f1868c = true;
                z zVar = this.f1848g;
                if (zVar != null && zVar.h()) {
                    this.f1848g.k(view);
                }
            }
            if (pVar.f1869d) {
                childViewHolderInt.f1809a.invalidate();
                pVar.f1869d = false;
            }
        }

        public static d i0(Context context, AttributeSet attributeSet, int i4, int i5) {
            d dVar = new d();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f0.c.f3709f, i4, i5);
            dVar.f1862a = obtainStyledAttributes.getInt(f0.c.f3710g, 1);
            dVar.f1863b = obtainStyledAttributes.getInt(f0.c.f3720q, 1);
            dVar.f1864c = obtainStyledAttributes.getBoolean(f0.c.f3719p, false);
            dVar.f1865d = obtainStyledAttributes.getBoolean(f0.c.f3721r, false);
            obtainStyledAttributes.recycle();
            return dVar;
        }

        public static int n(int i4, int i5, int i6) {
            int mode = View.MeasureSpec.getMode(i4);
            int size = View.MeasureSpec.getSize(i4);
            return mode != Integer.MIN_VALUE ? mode != 1073741824 ? Math.max(i5, i6) : size : Math.min(size, Math.max(i5, i6));
        }

        private boolean t0(RecyclerView recyclerView, int i4, int i5) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int e02 = e0();
            int g02 = g0();
            int o02 = o0() - f0();
            int W = W() - d0();
            Rect rect = this.f1843b.mTempRect;
            P(focusedChild, rect);
            return rect.left - i4 < o02 && rect.right - i4 > e02 && rect.top - i5 < W && rect.bottom - i5 > g02;
        }

        private void v1(v vVar, int i4, View view) {
            d0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.J()) {
                return;
            }
            if (childViewHolderInt.t() && !childViewHolderInt.v() && !this.f1843b.mAdapter.g()) {
                q1(i4);
                vVar.C(childViewHolderInt);
            } else {
                x(i4);
                vVar.D(view);
                this.f1843b.mViewInfoStore.k(childViewHolderInt);
            }
        }

        private static boolean w0(int i4, int i5, int i6) {
            int mode = View.MeasureSpec.getMode(i5);
            int size = View.MeasureSpec.getSize(i5);
            if (i6 > 0 && i4 != i6) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i4;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i4;
            }
            return true;
        }

        private void y(int i4, View view) {
            this.f1842a.d(i4);
        }

        void A(RecyclerView recyclerView, v vVar) {
            this.f1850i = false;
            I0(recyclerView, vVar);
        }

        public void A0(View view, int i4, int i5) {
            p pVar = (p) view.getLayoutParams();
            Rect itemDecorInsetsForChild = this.f1843b.getItemDecorInsetsForChild(view);
            int i6 = i4 + itemDecorInsetsForChild.left + itemDecorInsetsForChild.right;
            int i7 = i5 + itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom;
            int K = K(o0(), p0(), e0() + f0() + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin + i6, ((ViewGroup.MarginLayoutParams) pVar).width, k());
            int K2 = K(W(), X(), g0() + d0() + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin + i7, ((ViewGroup.MarginLayoutParams) pVar).height, l());
            if (F1(view, K, K2, pVar)) {
                view.measure(K, K2);
            }
        }

        void A1(int i4, int i5) {
            this.f1858q = View.MeasureSpec.getSize(i4);
            int mode = View.MeasureSpec.getMode(i4);
            this.f1856o = mode;
            if (mode == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                this.f1858q = 0;
            }
            this.f1859r = View.MeasureSpec.getSize(i5);
            int mode2 = View.MeasureSpec.getMode(i5);
            this.f1857p = mode2;
            if (mode2 != 0 || RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                return;
            }
            this.f1859r = 0;
        }

        public View B(View view) {
            View findContainingItemView;
            RecyclerView recyclerView = this.f1843b;
            if (recyclerView == null || (findContainingItemView = recyclerView.findContainingItemView(view)) == null || this.f1842a.n(findContainingItemView)) {
                return null;
            }
            return findContainingItemView;
        }

        public void B0(int i4, int i5) {
            View I = I(i4);
            if (I != null) {
                x(i4);
                h(I, i5);
            } else {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i4 + this.f1843b.toString());
            }
        }

        public void B1(int i4, int i5) {
            this.f1843b.setMeasuredDimension(i4, i5);
        }

        public View C(int i4) {
            int J = J();
            for (int i5 = 0; i5 < J; i5++) {
                View I = I(i5);
                d0 childViewHolderInt = RecyclerView.getChildViewHolderInt(I);
                if (childViewHolderInt != null && childViewHolderInt.m() == i4 && !childViewHolderInt.J() && (this.f1843b.mState.e() || !childViewHolderInt.v())) {
                    return I;
                }
            }
            return null;
        }

        public void C0(int i4) {
            RecyclerView recyclerView = this.f1843b;
            if (recyclerView != null) {
                recyclerView.offsetChildrenHorizontal(i4);
            }
        }

        public void C1(Rect rect, int i4, int i5) {
            B1(n(i4, rect.width() + e0() + f0(), c0()), n(i5, rect.height() + g0() + d0(), b0()));
        }

        public abstract p D();

        public void D0(int i4) {
            RecyclerView recyclerView = this.f1843b;
            if (recyclerView != null) {
                recyclerView.offsetChildrenVertical(i4);
            }
        }

        void D1(int i4, int i5) {
            int J = J();
            if (J == 0) {
                this.f1843b.defaultOnMeasure(i4, i5);
                return;
            }
            int i6 = RecyclerView.UNDEFINED_DURATION;
            int i7 = Integer.MAX_VALUE;
            int i8 = Integer.MAX_VALUE;
            int i9 = Integer.MIN_VALUE;
            for (int i10 = 0; i10 < J; i10++) {
                View I = I(i10);
                Rect rect = this.f1843b.mTempRect;
                P(I, rect);
                int i11 = rect.left;
                if (i11 < i7) {
                    i7 = i11;
                }
                int i12 = rect.right;
                if (i12 > i6) {
                    i6 = i12;
                }
                int i13 = rect.top;
                if (i13 < i8) {
                    i8 = i13;
                }
                int i14 = rect.bottom;
                if (i14 > i9) {
                    i9 = i14;
                }
            }
            this.f1843b.mTempRect.set(i7, i8, i6, i9);
            C1(this.f1843b.mTempRect, i4, i5);
        }

        public p E(Context context, AttributeSet attributeSet) {
            return new p(context, attributeSet);
        }

        public void E0(g gVar, g gVar2) {
        }

        void E1(RecyclerView recyclerView) {
            int height;
            if (recyclerView == null) {
                this.f1843b = null;
                this.f1842a = null;
                height = 0;
                this.f1858q = 0;
            } else {
                this.f1843b = recyclerView;
                this.f1842a = recyclerView.mChildHelper;
                this.f1858q = recyclerView.getWidth();
                height = recyclerView.getHeight();
            }
            this.f1859r = height;
            this.f1856o = 1073741824;
            this.f1857p = 1073741824;
        }

        public p F(ViewGroup.LayoutParams layoutParams) {
            return layoutParams instanceof p ? new p((p) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new p((ViewGroup.MarginLayoutParams) layoutParams) : new p(layoutParams);
        }

        public boolean F0(RecyclerView recyclerView, ArrayList<View> arrayList, int i4, int i5) {
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean F1(View view, int i4, int i5, p pVar) {
            return (!view.isLayoutRequested() && this.f1852k && w0(view.getWidth(), i4, ((ViewGroup.MarginLayoutParams) pVar).width) && w0(view.getHeight(), i5, ((ViewGroup.MarginLayoutParams) pVar).height)) ? false : true;
        }

        public int G() {
            return -1;
        }

        public void G0(RecyclerView recyclerView) {
        }

        boolean G1() {
            return false;
        }

        public int H(View view) {
            return ((p) view.getLayoutParams()).f1867b.bottom;
        }

        @Deprecated
        public void H0(RecyclerView recyclerView) {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean H1(View view, int i4, int i5, p pVar) {
            return (this.f1852k && w0(view.getMeasuredWidth(), i4, ((ViewGroup.MarginLayoutParams) pVar).width) && w0(view.getMeasuredHeight(), i5, ((ViewGroup.MarginLayoutParams) pVar).height)) ? false : true;
        }

        public View I(int i4) {
            androidx.recyclerview.widget.b bVar = this.f1842a;
            if (bVar != null) {
                return bVar.f(i4);
            }
            return null;
        }

        public void I0(RecyclerView recyclerView, v vVar) {
            H0(recyclerView);
        }

        public void I1(RecyclerView recyclerView, a0 a0Var, int i4) {
            Log.e(RecyclerView.TAG, "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public int J() {
            androidx.recyclerview.widget.b bVar = this.f1842a;
            if (bVar != null) {
                return bVar.g();
            }
            return 0;
        }

        public View J0(View view, int i4, v vVar, a0 a0Var) {
            return null;
        }

        public void J1(z zVar) {
            z zVar2 = this.f1848g;
            if (zVar2 != null && zVar != zVar2 && zVar2.h()) {
                this.f1848g.r();
            }
            this.f1848g = zVar;
            zVar.q(this.f1843b, this);
        }

        public void K0(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f1843b;
            L0(recyclerView.mRecycler, recyclerView.mState, accessibilityEvent);
        }

        void K1() {
            z zVar = this.f1848g;
            if (zVar != null) {
                zVar.r();
            }
        }

        public void L0(v vVar, a0 a0Var, AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f1843b;
            if (recyclerView == null || accessibilityEvent == null) {
                return;
            }
            boolean z4 = true;
            if (!recyclerView.canScrollVertically(1) && !this.f1843b.canScrollVertically(-1) && !this.f1843b.canScrollHorizontally(-1) && !this.f1843b.canScrollHorizontally(1)) {
                z4 = false;
            }
            accessibilityEvent.setScrollable(z4);
            g gVar = this.f1843b.mAdapter;
            if (gVar != null) {
                accessibilityEvent.setItemCount(gVar.c());
            }
        }

        public boolean L1() {
            return false;
        }

        public boolean M() {
            RecyclerView recyclerView = this.f1843b;
            return recyclerView != null && recyclerView.mClipToPadding;
        }

        public void M0(v vVar, a0 a0Var, z.c cVar) {
            if (this.f1843b.canScrollVertically(-1) || this.f1843b.canScrollHorizontally(-1)) {
                cVar.a(8192);
                cVar.n0(true);
            }
            if (this.f1843b.canScrollVertically(1) || this.f1843b.canScrollHorizontally(1)) {
                cVar.a(4096);
                cVar.n0(true);
            }
            cVar.Y(c.b.a(k0(vVar, a0Var), N(vVar, a0Var), v0(vVar, a0Var), l0(vVar, a0Var)));
        }

        public int N(v vVar, a0 a0Var) {
            RecyclerView recyclerView = this.f1843b;
            if (recyclerView == null || recyclerView.mAdapter == null || !k()) {
                return 1;
            }
            return this.f1843b.mAdapter.c();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void N0(z.c cVar) {
            RecyclerView recyclerView = this.f1843b;
            M0(recyclerView.mRecycler, recyclerView.mState, cVar);
        }

        public int O(View view) {
            return view.getBottom() + H(view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void O0(View view, z.c cVar) {
            d0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt == null || childViewHolderInt.v() || this.f1842a.n(childViewHolderInt.f1809a)) {
                return;
            }
            RecyclerView recyclerView = this.f1843b;
            P0(recyclerView.mRecycler, recyclerView.mState, view, cVar);
        }

        public void P(View view, Rect rect) {
            RecyclerView.getDecoratedBoundsWithMarginsInt(view, rect);
        }

        public void P0(v vVar, a0 a0Var, View view, z.c cVar) {
            cVar.Z(c.C0097c.a(l() ? h0(view) : 0, 1, k() ? h0(view) : 0, 1, false, false));
        }

        public int Q(View view) {
            return view.getLeft() - a0(view);
        }

        public View Q0(View view, int i4) {
            return null;
        }

        public int R(View view) {
            Rect rect = ((p) view.getLayoutParams()).f1867b;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public void R0(RecyclerView recyclerView, int i4, int i5) {
        }

        public int S(View view) {
            Rect rect = ((p) view.getLayoutParams()).f1867b;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public void S0(RecyclerView recyclerView) {
        }

        public int T(View view) {
            return view.getRight() + j0(view);
        }

        public void T0(RecyclerView recyclerView, int i4, int i5, int i6) {
        }

        public int U(View view) {
            return view.getTop() - m0(view);
        }

        public void U0(RecyclerView recyclerView, int i4, int i5) {
        }

        public View V() {
            View focusedChild;
            RecyclerView recyclerView = this.f1843b;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.f1842a.n(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public void V0(RecyclerView recyclerView, int i4, int i5) {
        }

        public int W() {
            return this.f1859r;
        }

        public void W0(RecyclerView recyclerView, int i4, int i5, Object obj) {
            V0(recyclerView, i4, i5);
        }

        public int X() {
            return this.f1857p;
        }

        public void X0(v vVar, a0 a0Var) {
            Log.e(RecyclerView.TAG, "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public int Y() {
            RecyclerView recyclerView = this.f1843b;
            g adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.c();
            }
            return 0;
        }

        public void Y0(a0 a0Var) {
        }

        public int Z() {
            return y.p.t(this.f1843b);
        }

        public void Z0(v vVar, a0 a0Var, int i4, int i5) {
            this.f1843b.defaultOnMeasure(i4, i5);
        }

        public int a0(View view) {
            return ((p) view.getLayoutParams()).f1867b.left;
        }

        @Deprecated
        public boolean a1(RecyclerView recyclerView, View view, View view2) {
            return x0() || recyclerView.isComputingLayout();
        }

        public void b(View view) {
            c(view, -1);
        }

        public int b0() {
            return y.p.u(this.f1843b);
        }

        public boolean b1(RecyclerView recyclerView, a0 a0Var, View view, View view2) {
            return a1(recyclerView, view, view2);
        }

        public void c(View view, int i4) {
            f(view, i4, true);
        }

        public int c0() {
            return y.p.v(this.f1843b);
        }

        public void c1(Parcelable parcelable) {
        }

        public void d(View view) {
            e(view, -1);
        }

        public int d0() {
            RecyclerView recyclerView = this.f1843b;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public Parcelable d1() {
            return null;
        }

        public void e(View view, int i4) {
            f(view, i4, false);
        }

        public int e0() {
            RecyclerView recyclerView = this.f1843b;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public void e1(int i4) {
        }

        public int f0() {
            RecyclerView recyclerView = this.f1843b;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        void f1(z zVar) {
            if (this.f1848g == zVar) {
                this.f1848g = null;
            }
        }

        public void g(String str) {
            RecyclerView recyclerView = this.f1843b;
            if (recyclerView != null) {
                recyclerView.assertNotInLayoutOrScroll(str);
            }
        }

        public int g0() {
            RecyclerView recyclerView = this.f1843b;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean g1(int i4, Bundle bundle) {
            RecyclerView recyclerView = this.f1843b;
            return h1(recyclerView.mRecycler, recyclerView.mState, i4, bundle);
        }

        public void h(View view, int i4) {
            i(view, i4, (p) view.getLayoutParams());
        }

        public int h0(View view) {
            return ((p) view.getLayoutParams()).a();
        }

        public boolean h1(v vVar, a0 a0Var, int i4, Bundle bundle) {
            int W;
            int o02;
            int i5;
            int i6;
            RecyclerView recyclerView = this.f1843b;
            if (recyclerView == null) {
                return false;
            }
            if (i4 == 4096) {
                W = recyclerView.canScrollVertically(1) ? (W() - g0()) - d0() : 0;
                if (this.f1843b.canScrollHorizontally(1)) {
                    o02 = (o0() - e0()) - f0();
                    i5 = W;
                    i6 = o02;
                }
                i5 = W;
                i6 = 0;
            } else if (i4 != 8192) {
                i6 = 0;
                i5 = 0;
            } else {
                W = recyclerView.canScrollVertically(-1) ? -((W() - g0()) - d0()) : 0;
                if (this.f1843b.canScrollHorizontally(-1)) {
                    o02 = -((o0() - e0()) - f0());
                    i5 = W;
                    i6 = o02;
                }
                i5 = W;
                i6 = 0;
            }
            if (i5 == 0 && i6 == 0) {
                return false;
            }
            this.f1843b.smoothScrollBy(i6, i5, null, RecyclerView.UNDEFINED_DURATION, true);
            return true;
        }

        public void i(View view, int i4, p pVar) {
            d0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.v()) {
                this.f1843b.mViewInfoStore.b(childViewHolderInt);
            } else {
                this.f1843b.mViewInfoStore.p(childViewHolderInt);
            }
            this.f1842a.c(view, i4, pVar, childViewHolderInt.v());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean i1(View view, int i4, Bundle bundle) {
            RecyclerView recyclerView = this.f1843b;
            return j1(recyclerView.mRecycler, recyclerView.mState, view, i4, bundle);
        }

        public void j(View view, Rect rect) {
            RecyclerView recyclerView = this.f1843b;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.getItemDecorInsetsForChild(view));
            }
        }

        public int j0(View view) {
            return ((p) view.getLayoutParams()).f1867b.right;
        }

        public boolean j1(v vVar, a0 a0Var, View view, int i4, Bundle bundle) {
            return false;
        }

        public boolean k() {
            return false;
        }

        public int k0(v vVar, a0 a0Var) {
            RecyclerView recyclerView = this.f1843b;
            if (recyclerView == null || recyclerView.mAdapter == null || !l()) {
                return 1;
            }
            return this.f1843b.mAdapter.c();
        }

        public void k1(v vVar) {
            for (int J = J() - 1; J >= 0; J--) {
                if (!RecyclerView.getChildViewHolderInt(I(J)).J()) {
                    n1(J, vVar);
                }
            }
        }

        public boolean l() {
            return false;
        }

        public int l0(v vVar, a0 a0Var) {
            return 0;
        }

        void l1(v vVar) {
            int j4 = vVar.j();
            for (int i4 = j4 - 1; i4 >= 0; i4--) {
                View n4 = vVar.n(i4);
                d0 childViewHolderInt = RecyclerView.getChildViewHolderInt(n4);
                if (!childViewHolderInt.J()) {
                    childViewHolderInt.G(false);
                    if (childViewHolderInt.x()) {
                        this.f1843b.removeDetachedView(n4, false);
                    }
                    l lVar = this.f1843b.mItemAnimator;
                    if (lVar != null) {
                        lVar.j(childViewHolderInt);
                    }
                    childViewHolderInt.G(true);
                    vVar.y(n4);
                }
            }
            vVar.e();
            if (j4 > 0) {
                this.f1843b.invalidate();
            }
        }

        public boolean m(p pVar) {
            return pVar != null;
        }

        public int m0(View view) {
            return ((p) view.getLayoutParams()).f1867b.top;
        }

        public void m1(View view, v vVar) {
            p1(view);
            vVar.B(view);
        }

        public void n0(View view, boolean z4, Rect rect) {
            Matrix matrix;
            if (z4) {
                Rect rect2 = ((p) view.getLayoutParams()).f1867b;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.f1843b != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.f1843b.mTempRectF;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public void n1(int i4, v vVar) {
            View I = I(i4);
            q1(i4);
            vVar.B(I);
        }

        public void o(int i4, int i5, a0 a0Var, c cVar) {
        }

        public int o0() {
            return this.f1858q;
        }

        public boolean o1(Runnable runnable) {
            RecyclerView recyclerView = this.f1843b;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public void p(int i4, c cVar) {
        }

        public int p0() {
            return this.f1856o;
        }

        public void p1(View view) {
            this.f1842a.p(view);
        }

        public int q(a0 a0Var) {
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean q0() {
            int J = J();
            for (int i4 = 0; i4 < J; i4++) {
                ViewGroup.LayoutParams layoutParams = I(i4).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public void q1(int i4) {
            if (I(i4) != null) {
                this.f1842a.q(i4);
            }
        }

        public int r(a0 a0Var) {
            return 0;
        }

        public boolean r0() {
            return this.f1850i;
        }

        public boolean r1(RecyclerView recyclerView, View view, Rect rect, boolean z4) {
            return s1(recyclerView, view, rect, z4, false);
        }

        public int s(a0 a0Var) {
            return 0;
        }

        public boolean s0() {
            return this.f1851j;
        }

        public boolean s1(RecyclerView recyclerView, View view, Rect rect, boolean z4, boolean z5) {
            int[] L = L(view, rect);
            int i4 = L[0];
            int i5 = L[1];
            if ((z5 && !t0(recyclerView, i4, i5)) || (i4 == 0 && i5 == 0)) {
                return false;
            }
            if (z4) {
                recyclerView.scrollBy(i4, i5);
            } else {
                recyclerView.smoothScrollBy(i4, i5);
            }
            return true;
        }

        public int t(a0 a0Var) {
            return 0;
        }

        public void t1() {
            RecyclerView recyclerView = this.f1843b;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public int u(a0 a0Var) {
            return 0;
        }

        public final boolean u0() {
            return this.f1853l;
        }

        public void u1() {
            this.f1849h = true;
        }

        public int v(a0 a0Var) {
            return 0;
        }

        public boolean v0(v vVar, a0 a0Var) {
            return false;
        }

        public void w(v vVar) {
            for (int J = J() - 1; J >= 0; J--) {
                v1(vVar, J, I(J));
            }
        }

        public int w1(int i4, v vVar, a0 a0Var) {
            return 0;
        }

        public void x(int i4) {
            y(i4, I(i4));
        }

        public boolean x0() {
            z zVar = this.f1848g;
            return zVar != null && zVar.h();
        }

        public void x1(int i4) {
        }

        public boolean y0(View view, boolean z4, boolean z5) {
            boolean z6 = this.f1846e.b(view, 24579) && this.f1847f.b(view, 24579);
            return z4 ? z6 : !z6;
        }

        public int y1(int i4, v vVar, a0 a0Var) {
            return 0;
        }

        void z(RecyclerView recyclerView) {
            this.f1850i = true;
            G0(recyclerView);
        }

        public void z0(View view, int i4, int i5, int i6, int i7) {
            p pVar = (p) view.getLayoutParams();
            Rect rect = pVar.f1867b;
            view.layout(i4 + rect.left + ((ViewGroup.MarginLayoutParams) pVar).leftMargin, i5 + rect.top + ((ViewGroup.MarginLayoutParams) pVar).topMargin, (i6 - rect.right) - ((ViewGroup.MarginLayoutParams) pVar).rightMargin, (i7 - rect.bottom) - ((ViewGroup.MarginLayoutParams) pVar).bottomMargin);
        }

        void z1(RecyclerView recyclerView) {
            A1(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }
    }

    /* loaded from: classes.dex */
    public static class p extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        d0 f1866a;

        /* renamed from: b, reason: collision with root package name */
        final Rect f1867b;

        /* renamed from: c, reason: collision with root package name */
        boolean f1868c;

        /* renamed from: d, reason: collision with root package name */
        boolean f1869d;

        public p(int i4, int i5) {
            super(i4, i5);
            this.f1867b = new Rect();
            this.f1868c = true;
            this.f1869d = false;
        }

        public p(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1867b = new Rect();
            this.f1868c = true;
            this.f1869d = false;
        }

        public p(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1867b = new Rect();
            this.f1868c = true;
            this.f1869d = false;
        }

        public p(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f1867b = new Rect();
            this.f1868c = true;
            this.f1869d = false;
        }

        public p(p pVar) {
            super((ViewGroup.LayoutParams) pVar);
            this.f1867b = new Rect();
            this.f1868c = true;
            this.f1869d = false;
        }

        public int a() {
            return this.f1866a.m();
        }

        public boolean b() {
            return this.f1866a.y();
        }

        public boolean c() {
            return this.f1866a.v();
        }

        public boolean d() {
            return this.f1866a.t();
        }
    }

    /* loaded from: classes.dex */
    public interface q {
        void a(View view);

        void b(View view);
    }

    /* loaded from: classes.dex */
    public static abstract class r {
        public abstract boolean a(int i4, int i5);
    }

    /* loaded from: classes.dex */
    public interface s {
        boolean a(RecyclerView recyclerView, MotionEvent motionEvent);

        void b(RecyclerView recyclerView, MotionEvent motionEvent);

        void c(boolean z4);
    }

    /* loaded from: classes.dex */
    public static abstract class t {
        public void a(RecyclerView recyclerView, int i4) {
        }

        public void b(RecyclerView recyclerView, int i4, int i5) {
        }
    }

    /* loaded from: classes.dex */
    public static class u {

        /* renamed from: a, reason: collision with root package name */
        SparseArray<a> f1870a = new SparseArray<>();

        /* renamed from: b, reason: collision with root package name */
        private int f1871b = 0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static class a {

            /* renamed from: a, reason: collision with root package name */
            final ArrayList<d0> f1872a = new ArrayList<>();

            /* renamed from: b, reason: collision with root package name */
            int f1873b = 5;

            /* renamed from: c, reason: collision with root package name */
            long f1874c = 0;

            /* renamed from: d, reason: collision with root package name */
            long f1875d = 0;

            a() {
            }
        }

        private a g(int i4) {
            a aVar = this.f1870a.get(i4);
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a();
            this.f1870a.put(i4, aVar2);
            return aVar2;
        }

        void a() {
            this.f1871b++;
        }

        public void b() {
            for (int i4 = 0; i4 < this.f1870a.size(); i4++) {
                this.f1870a.valueAt(i4).f1872a.clear();
            }
        }

        void c() {
            this.f1871b--;
        }

        void d(int i4, long j4) {
            a g4 = g(i4);
            g4.f1875d = j(g4.f1875d, j4);
        }

        void e(int i4, long j4) {
            a g4 = g(i4);
            g4.f1874c = j(g4.f1874c, j4);
        }

        public d0 f(int i4) {
            a aVar = this.f1870a.get(i4);
            if (aVar == null || aVar.f1872a.isEmpty()) {
                return null;
            }
            ArrayList<d0> arrayList = aVar.f1872a;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (!arrayList.get(size).r()) {
                    return arrayList.remove(size);
                }
            }
            return null;
        }

        void h(g gVar, g gVar2, boolean z4) {
            if (gVar != null) {
                c();
            }
            if (!z4 && this.f1871b == 0) {
                b();
            }
            if (gVar2 != null) {
                a();
            }
        }

        public void i(d0 d0Var) {
            int l4 = d0Var.l();
            ArrayList<d0> arrayList = g(l4).f1872a;
            if (this.f1870a.get(l4).f1873b <= arrayList.size()) {
                return;
            }
            d0Var.D();
            arrayList.add(d0Var);
        }

        long j(long j4, long j5) {
            return j4 == 0 ? j5 : ((j4 / 4) * 3) + (j5 / 4);
        }

        boolean k(int i4, long j4, long j5) {
            long j6 = g(i4).f1875d;
            return j6 == 0 || j4 + j6 < j5;
        }

        boolean l(int i4, long j4, long j5) {
            long j6 = g(i4).f1874c;
            return j6 == 0 || j4 + j6 < j5;
        }
    }

    /* loaded from: classes.dex */
    public final class v {

        /* renamed from: a, reason: collision with root package name */
        final ArrayList<d0> f1876a;

        /* renamed from: b, reason: collision with root package name */
        ArrayList<d0> f1877b;

        /* renamed from: c, reason: collision with root package name */
        final ArrayList<d0> f1878c;

        /* renamed from: d, reason: collision with root package name */
        private final List<d0> f1879d;

        /* renamed from: e, reason: collision with root package name */
        private int f1880e;

        /* renamed from: f, reason: collision with root package name */
        int f1881f;

        /* renamed from: g, reason: collision with root package name */
        u f1882g;

        public v() {
            ArrayList<d0> arrayList = new ArrayList<>();
            this.f1876a = arrayList;
            this.f1877b = null;
            this.f1878c = new ArrayList<>();
            this.f1879d = Collections.unmodifiableList(arrayList);
            this.f1880e = 2;
            this.f1881f = 2;
        }

        private boolean H(d0 d0Var, int i4, int i5, long j4) {
            d0Var.f1826r = RecyclerView.this;
            int l4 = d0Var.l();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j4 != RecyclerView.FOREVER_NS && !this.f1882g.k(l4, nanoTime, j4)) {
                return false;
            }
            RecyclerView.this.mAdapter.a(d0Var, i4);
            this.f1882g.d(d0Var.l(), RecyclerView.this.getNanoTime() - nanoTime);
            b(d0Var);
            if (!RecyclerView.this.mState.e()) {
                return true;
            }
            d0Var.f1815g = i5;
            return true;
        }

        private void b(d0 d0Var) {
            if (RecyclerView.this.isAccessibilityEnabled()) {
                View view = d0Var.f1809a;
                if (y.p.r(view) == 0) {
                    y.p.j0(view, 1);
                }
                androidx.recyclerview.widget.k kVar = RecyclerView.this.mAccessibilityDelegate;
                if (kVar == null) {
                    return;
                }
                y.a n4 = kVar.n();
                if (n4 instanceof k.a) {
                    ((k.a) n4).o(view);
                }
                y.p.a0(view, n4);
            }
        }

        private void q(ViewGroup viewGroup, boolean z4) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    q((ViewGroup) childAt, true);
                }
            }
            if (z4) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                } else {
                    int visibility = viewGroup.getVisibility();
                    viewGroup.setVisibility(4);
                    viewGroup.setVisibility(visibility);
                }
            }
        }

        private void r(d0 d0Var) {
            View view = d0Var.f1809a;
            if (view instanceof ViewGroup) {
                q((ViewGroup) view, false);
            }
        }

        void A(int i4) {
            a(this.f1878c.get(i4), true);
            this.f1878c.remove(i4);
        }

        public void B(View view) {
            d0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.x()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (childViewHolderInt.w()) {
                childViewHolderInt.K();
            } else if (childViewHolderInt.L()) {
                childViewHolderInt.e();
            }
            C(childViewHolderInt);
            if (RecyclerView.this.mItemAnimator == null || childViewHolderInt.u()) {
                return;
            }
            RecyclerView.this.mItemAnimator.j(childViewHolderInt);
        }

        void C(d0 d0Var) {
            boolean z4;
            boolean z5 = true;
            if (d0Var.w() || d0Var.f1809a.getParent() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Scrapped or attached views may not be recycled. isScrap:");
                sb.append(d0Var.w());
                sb.append(" isAttached:");
                sb.append(d0Var.f1809a.getParent() != null);
                sb.append(RecyclerView.this.exceptionLabel());
                throw new IllegalArgumentException(sb.toString());
            }
            if (d0Var.x()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + d0Var + RecyclerView.this.exceptionLabel());
            }
            if (d0Var.J()) {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.exceptionLabel());
            }
            boolean h4 = d0Var.h();
            g gVar = RecyclerView.this.mAdapter;
            if ((gVar != null && h4 && gVar.n(d0Var)) || d0Var.u()) {
                if (this.f1881f <= 0 || d0Var.p(526)) {
                    z4 = false;
                } else {
                    int size = this.f1878c.size();
                    if (size >= this.f1881f && size > 0) {
                        A(0);
                        size--;
                    }
                    if (RecyclerView.ALLOW_THREAD_GAP_WORK && size > 0 && !RecyclerView.this.mPrefetchRegistry.d(d0Var.f1811c)) {
                        int i4 = size - 1;
                        while (i4 >= 0) {
                            if (!RecyclerView.this.mPrefetchRegistry.d(this.f1878c.get(i4).f1811c)) {
                                break;
                            } else {
                                i4--;
                            }
                        }
                        size = i4 + 1;
                    }
                    this.f1878c.add(size, d0Var);
                    z4 = true;
                }
                if (z4) {
                    z5 = false;
                } else {
                    a(d0Var, true);
                }
                r1 = z4;
            } else {
                z5 = false;
            }
            RecyclerView.this.mViewInfoStore.q(d0Var);
            if (r1 || z5 || !h4) {
                return;
            }
            d0Var.f1826r = null;
        }

        void D(View view) {
            ArrayList<d0> arrayList;
            d0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (!childViewHolderInt.p(12) && childViewHolderInt.y() && !RecyclerView.this.canReuseUpdatedViewHolder(childViewHolderInt)) {
                if (this.f1877b == null) {
                    this.f1877b = new ArrayList<>();
                }
                childViewHolderInt.H(this, true);
                arrayList = this.f1877b;
            } else {
                if (childViewHolderInt.t() && !childViewHolderInt.v() && !RecyclerView.this.mAdapter.g()) {
                    throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.exceptionLabel());
                }
                childViewHolderInt.H(this, false);
                arrayList = this.f1876a;
            }
            arrayList.add(childViewHolderInt);
        }

        void E(u uVar) {
            u uVar2 = this.f1882g;
            if (uVar2 != null) {
                uVar2.c();
            }
            this.f1882g = uVar;
            if (uVar == null || RecyclerView.this.getAdapter() == null) {
                return;
            }
            this.f1882g.a();
        }

        void F(b0 b0Var) {
        }

        public void G(int i4) {
            this.f1880e = i4;
            K();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x0130  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x014d  */
        /* JADX WARN: Removed duplicated region for block: B:66:0x0170  */
        /* JADX WARN: Removed duplicated region for block: B:72:0x01a9  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x01cc A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:80:0x01b7  */
        /* JADX WARN: Removed duplicated region for block: B:86:0x017f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public androidx.recyclerview.widget.RecyclerView.d0 I(int r17, boolean r18, long r19) {
            /*
                Method dump skipped, instructions count: 523
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.v.I(int, boolean, long):androidx.recyclerview.widget.RecyclerView$d0");
        }

        void J(d0 d0Var) {
            (d0Var.f1823o ? this.f1877b : this.f1876a).remove(d0Var);
            d0Var.f1822n = null;
            d0Var.f1823o = false;
            d0Var.e();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void K() {
            o oVar = RecyclerView.this.mLayout;
            this.f1881f = this.f1880e + (oVar != null ? oVar.f1854m : 0);
            for (int size = this.f1878c.size() - 1; size >= 0 && this.f1878c.size() > this.f1881f; size--) {
                A(size);
            }
        }

        boolean L(d0 d0Var) {
            if (d0Var.v()) {
                return RecyclerView.this.mState.e();
            }
            int i4 = d0Var.f1811c;
            if (i4 >= 0 && i4 < RecyclerView.this.mAdapter.c()) {
                if (RecyclerView.this.mState.e() || RecyclerView.this.mAdapter.e(d0Var.f1811c) == d0Var.l()) {
                    return !RecyclerView.this.mAdapter.g() || d0Var.k() == RecyclerView.this.mAdapter.d(d0Var.f1811c);
                }
                return false;
            }
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + d0Var + RecyclerView.this.exceptionLabel());
        }

        void M(int i4, int i5) {
            int i6;
            int i7 = i5 + i4;
            for (int size = this.f1878c.size() - 1; size >= 0; size--) {
                d0 d0Var = this.f1878c.get(size);
                if (d0Var != null && (i6 = d0Var.f1811c) >= i4 && i6 < i7) {
                    d0Var.b(2);
                    A(size);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(d0 d0Var, boolean z4) {
            RecyclerView.clearNestedRecyclerViewIfNotNested(d0Var);
            View view = d0Var.f1809a;
            androidx.recyclerview.widget.k kVar = RecyclerView.this.mAccessibilityDelegate;
            if (kVar != null) {
                y.a n4 = kVar.n();
                y.p.a0(view, n4 instanceof k.a ? ((k.a) n4).n(view) : null);
            }
            if (z4) {
                g(d0Var);
            }
            d0Var.f1826r = null;
            i().i(d0Var);
        }

        public void c() {
            this.f1876a.clear();
            z();
        }

        void d() {
            int size = this.f1878c.size();
            for (int i4 = 0; i4 < size; i4++) {
                this.f1878c.get(i4).c();
            }
            int size2 = this.f1876a.size();
            for (int i5 = 0; i5 < size2; i5++) {
                this.f1876a.get(i5).c();
            }
            ArrayList<d0> arrayList = this.f1877b;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i6 = 0; i6 < size3; i6++) {
                    this.f1877b.get(i6).c();
                }
            }
        }

        void e() {
            this.f1876a.clear();
            ArrayList<d0> arrayList = this.f1877b;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        public int f(int i4) {
            if (i4 >= 0 && i4 < RecyclerView.this.mState.b()) {
                return !RecyclerView.this.mState.e() ? i4 : RecyclerView.this.mAdapterHelper.m(i4);
            }
            throw new IndexOutOfBoundsException("invalid position " + i4 + ". State item count is " + RecyclerView.this.mState.b() + RecyclerView.this.exceptionLabel());
        }

        void g(d0 d0Var) {
            w wVar = RecyclerView.this.mRecyclerListener;
            if (wVar != null) {
                wVar.a(d0Var);
            }
            g gVar = RecyclerView.this.mAdapter;
            if (gVar != null) {
                gVar.q(d0Var);
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mState != null) {
                recyclerView.mViewInfoStore.q(d0Var);
            }
        }

        d0 h(int i4) {
            int size;
            int m4;
            ArrayList<d0> arrayList = this.f1877b;
            if (arrayList != null && (size = arrayList.size()) != 0) {
                for (int i5 = 0; i5 < size; i5++) {
                    d0 d0Var = this.f1877b.get(i5);
                    if (!d0Var.L() && d0Var.m() == i4) {
                        d0Var.b(32);
                        return d0Var;
                    }
                }
                if (RecyclerView.this.mAdapter.g() && (m4 = RecyclerView.this.mAdapterHelper.m(i4)) > 0 && m4 < RecyclerView.this.mAdapter.c()) {
                    long d5 = RecyclerView.this.mAdapter.d(m4);
                    for (int i6 = 0; i6 < size; i6++) {
                        d0 d0Var2 = this.f1877b.get(i6);
                        if (!d0Var2.L() && d0Var2.k() == d5) {
                            d0Var2.b(32);
                            return d0Var2;
                        }
                    }
                }
            }
            return null;
        }

        u i() {
            if (this.f1882g == null) {
                this.f1882g = new u();
            }
            return this.f1882g;
        }

        int j() {
            return this.f1876a.size();
        }

        public List<d0> k() {
            return this.f1879d;
        }

        d0 l(long j4, int i4, boolean z4) {
            for (int size = this.f1876a.size() - 1; size >= 0; size--) {
                d0 d0Var = this.f1876a.get(size);
                if (d0Var.k() == j4 && !d0Var.L()) {
                    if (i4 == d0Var.l()) {
                        d0Var.b(32);
                        if (d0Var.v() && !RecyclerView.this.mState.e()) {
                            d0Var.F(2, 14);
                        }
                        return d0Var;
                    }
                    if (!z4) {
                        this.f1876a.remove(size);
                        RecyclerView.this.removeDetachedView(d0Var.f1809a, false);
                        y(d0Var.f1809a);
                    }
                }
            }
            int size2 = this.f1878c.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                d0 d0Var2 = this.f1878c.get(size2);
                if (d0Var2.k() == j4 && !d0Var2.r()) {
                    if (i4 == d0Var2.l()) {
                        if (!z4) {
                            this.f1878c.remove(size2);
                        }
                        return d0Var2;
                    }
                    if (!z4) {
                        A(size2);
                        return null;
                    }
                }
            }
        }

        d0 m(int i4, boolean z4) {
            View e4;
            int size = this.f1876a.size();
            for (int i5 = 0; i5 < size; i5++) {
                d0 d0Var = this.f1876a.get(i5);
                if (!d0Var.L() && d0Var.m() == i4 && !d0Var.t() && (RecyclerView.this.mState.f1789h || !d0Var.v())) {
                    d0Var.b(32);
                    return d0Var;
                }
            }
            if (z4 || (e4 = RecyclerView.this.mChildHelper.e(i4)) == null) {
                int size2 = this.f1878c.size();
                for (int i6 = 0; i6 < size2; i6++) {
                    d0 d0Var2 = this.f1878c.get(i6);
                    if (!d0Var2.t() && d0Var2.m() == i4 && !d0Var2.r()) {
                        if (!z4) {
                            this.f1878c.remove(i6);
                        }
                        return d0Var2;
                    }
                }
                return null;
            }
            d0 childViewHolderInt = RecyclerView.getChildViewHolderInt(e4);
            RecyclerView.this.mChildHelper.s(e4);
            int m4 = RecyclerView.this.mChildHelper.m(e4);
            if (m4 != -1) {
                RecyclerView.this.mChildHelper.d(m4);
                D(e4);
                childViewHolderInt.b(8224);
                return childViewHolderInt;
            }
            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + childViewHolderInt + RecyclerView.this.exceptionLabel());
        }

        View n(int i4) {
            return this.f1876a.get(i4).f1809a;
        }

        public View o(int i4) {
            return p(i4, false);
        }

        View p(int i4, boolean z4) {
            return I(i4, z4, RecyclerView.FOREVER_NS).f1809a;
        }

        void s() {
            int size = this.f1878c.size();
            for (int i4 = 0; i4 < size; i4++) {
                p pVar = (p) this.f1878c.get(i4).f1809a.getLayoutParams();
                if (pVar != null) {
                    pVar.f1868c = true;
                }
            }
        }

        void t() {
            int size = this.f1878c.size();
            for (int i4 = 0; i4 < size; i4++) {
                d0 d0Var = this.f1878c.get(i4);
                if (d0Var != null) {
                    d0Var.b(6);
                    d0Var.a(null);
                }
            }
            g gVar = RecyclerView.this.mAdapter;
            if (gVar == null || !gVar.g()) {
                z();
            }
        }

        void u(int i4, int i5) {
            int size = this.f1878c.size();
            for (int i6 = 0; i6 < size; i6++) {
                d0 d0Var = this.f1878c.get(i6);
                if (d0Var != null && d0Var.f1811c >= i4) {
                    d0Var.A(i5, true);
                }
            }
        }

        void v(int i4, int i5) {
            int i6;
            int i7;
            int i8;
            int i9;
            if (i4 < i5) {
                i6 = -1;
                i8 = i4;
                i7 = i5;
            } else {
                i6 = 1;
                i7 = i4;
                i8 = i5;
            }
            int size = this.f1878c.size();
            for (int i10 = 0; i10 < size; i10++) {
                d0 d0Var = this.f1878c.get(i10);
                if (d0Var != null && (i9 = d0Var.f1811c) >= i8 && i9 <= i7) {
                    if (i9 == i4) {
                        d0Var.A(i5 - i4, false);
                    } else {
                        d0Var.A(i6, false);
                    }
                }
            }
        }

        void w(int i4, int i5, boolean z4) {
            int i6 = i4 + i5;
            for (int size = this.f1878c.size() - 1; size >= 0; size--) {
                d0 d0Var = this.f1878c.get(size);
                if (d0Var != null) {
                    int i7 = d0Var.f1811c;
                    if (i7 >= i6) {
                        d0Var.A(-i5, z4);
                    } else if (i7 >= i4) {
                        d0Var.b(8);
                        A(size);
                    }
                }
            }
        }

        void x(g gVar, g gVar2, boolean z4) {
            c();
            i().h(gVar, gVar2, z4);
        }

        void y(View view) {
            d0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.f1822n = null;
            childViewHolderInt.f1823o = false;
            childViewHolderInt.e();
            C(childViewHolderInt);
        }

        void z() {
            for (int size = this.f1878c.size() - 1; size >= 0; size--) {
                A(size);
            }
            this.f1878c.clear();
            if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                RecyclerView.this.mPrefetchRegistry.b();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface w {
        void a(d0 d0Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class x extends i {
        x() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void a() {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.mState.f1788g = true;
            recyclerView.processDataSetCompletelyChanged(true);
            if (RecyclerView.this.mAdapterHelper.p()) {
                return;
            }
            RecyclerView.this.requestLayout();
        }
    }

    /* loaded from: classes.dex */
    public static class y extends b0.a {
        public static final Parcelable.Creator<y> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name */
        Parcelable f1885d;

        /* loaded from: classes.dex */
        static class a implements Parcelable.ClassLoaderCreator<y> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public y createFromParcel(Parcel parcel) {
                return new y(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public y createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new y(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public y[] newArray(int i4) {
                return new y[i4];
            }
        }

        y(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f1885d = parcel.readParcelable(classLoader == null ? o.class.getClassLoader() : classLoader);
        }

        y(Parcelable parcelable) {
            super(parcelable);
        }

        void g(y yVar) {
            this.f1885d = yVar.f1885d;
        }

        @Override // b0.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeParcelable(this.f1885d, 0);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class z {

        /* renamed from: b, reason: collision with root package name */
        private RecyclerView f1887b;

        /* renamed from: c, reason: collision with root package name */
        private o f1888c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f1889d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f1890e;

        /* renamed from: f, reason: collision with root package name */
        private View f1891f;

        /* renamed from: h, reason: collision with root package name */
        private boolean f1893h;

        /* renamed from: a, reason: collision with root package name */
        private int f1886a = -1;

        /* renamed from: g, reason: collision with root package name */
        private final a f1892g = new a(0, 0);

        /* loaded from: classes.dex */
        public static class a {

            /* renamed from: a, reason: collision with root package name */
            private int f1894a;

            /* renamed from: b, reason: collision with root package name */
            private int f1895b;

            /* renamed from: c, reason: collision with root package name */
            private int f1896c;

            /* renamed from: d, reason: collision with root package name */
            private int f1897d;

            /* renamed from: e, reason: collision with root package name */
            private Interpolator f1898e;

            /* renamed from: f, reason: collision with root package name */
            private boolean f1899f;

            /* renamed from: g, reason: collision with root package name */
            private int f1900g;

            public a(int i4, int i5) {
                this(i4, i5, RecyclerView.UNDEFINED_DURATION, null);
            }

            public a(int i4, int i5, int i6, Interpolator interpolator) {
                this.f1897d = -1;
                this.f1899f = false;
                this.f1900g = 0;
                this.f1894a = i4;
                this.f1895b = i5;
                this.f1896c = i6;
                this.f1898e = interpolator;
            }

            private void e() {
                if (this.f1898e != null && this.f1896c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                if (this.f1896c < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            boolean a() {
                return this.f1897d >= 0;
            }

            public void b(int i4) {
                this.f1897d = i4;
            }

            void c(RecyclerView recyclerView) {
                int i4 = this.f1897d;
                if (i4 >= 0) {
                    this.f1897d = -1;
                    recyclerView.jumpToPositionForSmoothScroller(i4);
                    this.f1899f = false;
                } else {
                    if (!this.f1899f) {
                        this.f1900g = 0;
                        return;
                    }
                    e();
                    recyclerView.mViewFlinger.f(this.f1894a, this.f1895b, this.f1896c, this.f1898e);
                    int i5 = this.f1900g + 1;
                    this.f1900g = i5;
                    if (i5 > 10) {
                        Log.e(RecyclerView.TAG, "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f1899f = false;
                }
            }

            public void d(int i4, int i5, int i6, Interpolator interpolator) {
                this.f1894a = i4;
                this.f1895b = i5;
                this.f1896c = i6;
                this.f1898e = interpolator;
                this.f1899f = true;
            }
        }

        /* loaded from: classes.dex */
        public interface b {
            PointF a(int i4);
        }

        public PointF a(int i4) {
            Object e4 = e();
            if (e4 instanceof b) {
                return ((b) e4).a(i4);
            }
            Log.w(RecyclerView.TAG, "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + b.class.getCanonicalName());
            return null;
        }

        public View b(int i4) {
            return this.f1887b.mLayout.C(i4);
        }

        public int c() {
            return this.f1887b.mLayout.J();
        }

        public int d(View view) {
            return this.f1887b.getChildLayoutPosition(view);
        }

        public o e() {
            return this.f1888c;
        }

        public int f() {
            return this.f1886a;
        }

        public boolean g() {
            return this.f1889d;
        }

        public boolean h() {
            return this.f1890e;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void i(PointF pointF) {
            float f4 = pointF.x;
            float f5 = pointF.y;
            float sqrt = (float) Math.sqrt((f4 * f4) + (f5 * f5));
            pointF.x /= sqrt;
            pointF.y /= sqrt;
        }

        void j(int i4, int i5) {
            PointF a5;
            RecyclerView recyclerView = this.f1887b;
            if (this.f1886a == -1 || recyclerView == null) {
                r();
            }
            if (this.f1889d && this.f1891f == null && this.f1888c != null && (a5 = a(this.f1886a)) != null) {
                float f4 = a5.x;
                if (f4 != 0.0f || a5.y != 0.0f) {
                    recyclerView.scrollStep((int) Math.signum(f4), (int) Math.signum(a5.y), null);
                }
            }
            this.f1889d = false;
            View view = this.f1891f;
            if (view != null) {
                if (d(view) == this.f1886a) {
                    o(this.f1891f, recyclerView.mState, this.f1892g);
                    this.f1892g.c(recyclerView);
                    r();
                } else {
                    Log.e(RecyclerView.TAG, "Passed over target position while smooth scrolling.");
                    this.f1891f = null;
                }
            }
            if (this.f1890e) {
                l(i4, i5, recyclerView.mState, this.f1892g);
                boolean a6 = this.f1892g.a();
                this.f1892g.c(recyclerView);
                if (a6 && this.f1890e) {
                    this.f1889d = true;
                    recyclerView.mViewFlinger.e();
                }
            }
        }

        protected void k(View view) {
            if (d(view) == f()) {
                this.f1891f = view;
            }
        }

        protected abstract void l(int i4, int i5, a0 a0Var, a aVar);

        protected abstract void m();

        protected abstract void n();

        protected abstract void o(View view, a0 a0Var, a aVar);

        public void p(int i4) {
            this.f1886a = i4;
        }

        void q(RecyclerView recyclerView, o oVar) {
            recyclerView.mViewFlinger.g();
            if (this.f1893h) {
                Log.w(RecyclerView.TAG, "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
            }
            this.f1887b = recyclerView;
            this.f1888c = oVar;
            int i4 = this.f1886a;
            if (i4 == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            recyclerView.mState.f1782a = i4;
            this.f1890e = true;
            this.f1889d = true;
            this.f1891f = b(f());
            m();
            this.f1887b.mViewFlinger.e();
            this.f1893h = true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void r() {
            if (this.f1890e) {
                this.f1890e = false;
                n();
                this.f1887b.mState.f1782a = -1;
                this.f1891f = null;
                this.f1886a = -1;
                this.f1889d = false;
                this.f1888c.f1(this);
                this.f1888c = null;
                this.f1887b = null;
            }
        }
    }

    static {
        Class<?> cls = Integer.TYPE;
        LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = new Class[]{Context.class, AttributeSet.class, cls, cls};
        sQuinticInterpolator = new c();
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, f0.a.f3700a);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.mObserver = new x();
        this.mRecycler = new v();
        this.mViewInfoStore = new androidx.recyclerview.widget.p();
        this.mUpdateChildViewsRunnable = new a();
        this.mTempRect = new Rect();
        this.mTempRect2 = new Rect();
        this.mTempRectF = new RectF();
        this.mItemDecorations = new ArrayList<>();
        this.mOnItemTouchListeners = new ArrayList<>();
        this.mInterceptRequestLayoutDepth = 0;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        this.mLayoutOrScrollCounter = 0;
        this.mDispatchScrollCounter = 0;
        this.mEdgeEffectFactory = new k();
        this.mItemAnimator = new androidx.recyclerview.widget.c();
        this.mScrollState = 0;
        this.mScrollPointerId = -1;
        this.mScaledHorizontalScrollFactor = Float.MIN_VALUE;
        this.mScaledVerticalScrollFactor = Float.MIN_VALUE;
        this.mPreserveFocusAfterLayout = true;
        this.mViewFlinger = new c0();
        this.mPrefetchRegistry = ALLOW_THREAD_GAP_WORK ? new e.b() : null;
        this.mState = new a0();
        this.mItemsAddedOrRemoved = false;
        this.mItemsChanged = false;
        this.mItemAnimatorListener = new m();
        this.mPostedAnimatorRunner = false;
        this.mMinMaxLayoutPositions = new int[2];
        this.mScrollOffset = new int[2];
        this.mNestedOffsets = new int[2];
        this.mReusableIntPair = new int[2];
        this.mPendingAccessibilityImportanceChange = new ArrayList();
        this.mItemAnimatorRunner = new b();
        this.mViewInfoProcessCallback = new d();
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mScaledHorizontalScrollFactor = y.q.b(viewConfiguration, context);
        this.mScaledVerticalScrollFactor = y.q.d(viewConfiguration, context);
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.mItemAnimator.v(this.mItemAnimatorListener);
        initAdapterManager();
        initChildrenHelper();
        initAutofill();
        if (y.p.r(this) == 0) {
            y.p.j0(this, 1);
        }
        this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new androidx.recyclerview.widget.k(this));
        int[] iArr = f0.c.f3709f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i4, 0);
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 29) {
            saveAttributeDataForStyleable(context, iArr, attributeSet, obtainStyledAttributes, i4, 0);
        }
        String string = obtainStyledAttributes.getString(f0.c.f3718o);
        if (obtainStyledAttributes.getInt(f0.c.f3712i, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.mClipToPadding = obtainStyledAttributes.getBoolean(f0.c.f3711h, true);
        boolean z4 = obtainStyledAttributes.getBoolean(f0.c.f3713j, false);
        this.mEnableFastScroller = z4;
        if (z4) {
            initFastScroller((StateListDrawable) obtainStyledAttributes.getDrawable(f0.c.f3716m), obtainStyledAttributes.getDrawable(f0.c.f3717n), (StateListDrawable) obtainStyledAttributes.getDrawable(f0.c.f3714k), obtainStyledAttributes.getDrawable(f0.c.f3715l));
        }
        obtainStyledAttributes.recycle();
        createLayoutManager(context, string, attributeSet, i4, 0);
        int[] iArr2 = NESTED_SCROLLING_ATTRS;
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr2, i4, 0);
        if (i5 >= 29) {
            saveAttributeDataForStyleable(context, iArr2, attributeSet, obtainStyledAttributes2, i4, 0);
        }
        boolean z5 = obtainStyledAttributes2.getBoolean(0, true);
        obtainStyledAttributes2.recycle();
        setNestedScrollingEnabled(z5);
    }

    private void addAnimatingView(d0 d0Var) {
        View view = d0Var.f1809a;
        boolean z4 = view.getParent() == this;
        this.mRecycler.J(getChildViewHolder(view));
        if (d0Var.x()) {
            this.mChildHelper.c(view, -1, view.getLayoutParams(), true);
            return;
        }
        androidx.recyclerview.widget.b bVar = this.mChildHelper;
        if (z4) {
            bVar.k(view);
        } else {
            bVar.b(view, true);
        }
    }

    private void animateChange(d0 d0Var, d0 d0Var2, l.c cVar, l.c cVar2, boolean z4, boolean z5) {
        d0Var.G(false);
        if (z4) {
            addAnimatingView(d0Var);
        }
        if (d0Var != d0Var2) {
            if (z5) {
                addAnimatingView(d0Var2);
            }
            d0Var.f1816h = d0Var2;
            addAnimatingView(d0Var);
            this.mRecycler.J(d0Var);
            d0Var2.G(false);
            d0Var2.f1817i = d0Var;
        }
        if (this.mItemAnimator.b(d0Var, d0Var2, cVar, cVar2)) {
            postAnimationRunner();
        }
    }

    private void cancelScroll() {
        resetScroll();
        setScrollState(0);
    }

    static void clearNestedRecyclerViewIfNotNested(d0 d0Var) {
        WeakReference<RecyclerView> weakReference = d0Var.f1810b;
        if (weakReference != null) {
            Object obj = weakReference.get();
            while (true) {
                for (View view = (View) obj; view != null; view = null) {
                    if (view == d0Var.f1809a) {
                        return;
                    }
                    obj = view.getParent();
                    if (obj instanceof View) {
                        break;
                    }
                }
                d0Var.f1810b = null;
                return;
            }
        }
    }

    private void createLayoutManager(Context context, String str, AttributeSet attributeSet, int i4, int i5) {
        Constructor constructor;
        if (str != null) {
            String trim = str.trim();
            if (trim.isEmpty()) {
                return;
            }
            String fullClassName = getFullClassName(context, trim);
            try {
                Class<? extends U> asSubclass = Class.forName(fullClassName, false, isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).asSubclass(o.class);
                Object[] objArr = null;
                try {
                    constructor = asSubclass.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);
                    objArr = new Object[]{context, attributeSet, Integer.valueOf(i4), Integer.valueOf(i5)};
                } catch (NoSuchMethodException e4) {
                    try {
                        constructor = asSubclass.getConstructor(new Class[0]);
                    } catch (NoSuchMethodException e5) {
                        e5.initCause(e4);
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + fullClassName, e5);
                    }
                }
                constructor.setAccessible(true);
                setLayoutManager((o) constructor.newInstance(objArr));
            } catch (ClassCastException e6) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + fullClassName, e6);
            } catch (ClassNotFoundException e7) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + fullClassName, e7);
            } catch (IllegalAccessException e8) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + fullClassName, e8);
            } catch (InstantiationException e9) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e9);
            } catch (InvocationTargetException e10) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e10);
            }
        }
    }

    private boolean didChildRangeChange(int i4, int i5) {
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        int[] iArr = this.mMinMaxLayoutPositions;
        return (iArr[0] == i4 && iArr[1] == i5) ? false : true;
    }

    private void dispatchContentChangedIfNecessary() {
        int i4 = this.mEatenAccessibilityChangeFlags;
        this.mEatenAccessibilityChangeFlags = 0;
        if (i4 == 0 || !isAccessibilityEnabled()) {
            return;
        }
        AccessibilityEvent obtain = AccessibilityEvent.obtain();
        obtain.setEventType(2048);
        z.b.b(obtain, i4);
        sendAccessibilityEventUnchecked(obtain);
    }

    private void dispatchLayoutStep1() {
        this.mState.a(1);
        fillRemainingScrollValues(this.mState);
        this.mState.f1791j = false;
        startInterceptRequestLayout();
        this.mViewInfoStore.f();
        onEnterLayoutOrScroll();
        processAdapterUpdatesAndSetAnimationFlags();
        saveFocusInfo();
        a0 a0Var = this.mState;
        a0Var.f1790i = a0Var.f1792k && this.mItemsChanged;
        this.mItemsChanged = false;
        this.mItemsAddedOrRemoved = false;
        a0Var.f1789h = a0Var.f1793l;
        a0Var.f1787f = this.mAdapter.c();
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        if (this.mState.f1792k) {
            int g4 = this.mChildHelper.g();
            for (int i4 = 0; i4 < g4; i4++) {
                d0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.f(i4));
                if (!childViewHolderInt.J() && (!childViewHolderInt.t() || this.mAdapter.g())) {
                    this.mViewInfoStore.e(childViewHolderInt, this.mItemAnimator.t(this.mState, childViewHolderInt, l.e(childViewHolderInt), childViewHolderInt.o()));
                    if (this.mState.f1790i && childViewHolderInt.y() && !childViewHolderInt.v() && !childViewHolderInt.J() && !childViewHolderInt.t()) {
                        this.mViewInfoStore.c(getChangedHolderKey(childViewHolderInt), childViewHolderInt);
                    }
                }
            }
        }
        if (this.mState.f1793l) {
            saveOldPositions();
            a0 a0Var2 = this.mState;
            boolean z4 = a0Var2.f1788g;
            a0Var2.f1788g = false;
            this.mLayout.X0(this.mRecycler, a0Var2);
            this.mState.f1788g = z4;
            for (int i5 = 0; i5 < this.mChildHelper.g(); i5++) {
                d0 childViewHolderInt2 = getChildViewHolderInt(this.mChildHelper.f(i5));
                if (!childViewHolderInt2.J() && !this.mViewInfoStore.i(childViewHolderInt2)) {
                    int e4 = l.e(childViewHolderInt2);
                    boolean p4 = childViewHolderInt2.p(8192);
                    if (!p4) {
                        e4 |= 4096;
                    }
                    l.c t4 = this.mItemAnimator.t(this.mState, childViewHolderInt2, e4, childViewHolderInt2.o());
                    if (p4) {
                        recordAnimationInfoIfBouncedHiddenView(childViewHolderInt2, t4);
                    } else {
                        this.mViewInfoStore.a(childViewHolderInt2, t4);
                    }
                }
            }
        }
        clearOldPositions();
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mState.f1786e = 2;
    }

    private void dispatchLayoutStep2() {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.a(6);
        this.mAdapterHelper.j();
        this.mState.f1787f = this.mAdapter.c();
        a0 a0Var = this.mState;
        a0Var.f1785d = 0;
        a0Var.f1789h = false;
        this.mLayout.X0(this.mRecycler, a0Var);
        a0 a0Var2 = this.mState;
        a0Var2.f1788g = false;
        this.mPendingSavedState = null;
        a0Var2.f1792k = a0Var2.f1792k && this.mItemAnimator != null;
        a0Var2.f1786e = 4;
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
    }

    private void dispatchLayoutStep3() {
        this.mState.a(4);
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        a0 a0Var = this.mState;
        a0Var.f1786e = 1;
        if (a0Var.f1792k) {
            for (int g4 = this.mChildHelper.g() - 1; g4 >= 0; g4--) {
                d0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.f(g4));
                if (!childViewHolderInt.J()) {
                    long changedHolderKey = getChangedHolderKey(childViewHolderInt);
                    l.c s4 = this.mItemAnimator.s(this.mState, childViewHolderInt);
                    d0 g5 = this.mViewInfoStore.g(changedHolderKey);
                    if (g5 != null && !g5.J()) {
                        boolean h4 = this.mViewInfoStore.h(g5);
                        boolean h5 = this.mViewInfoStore.h(childViewHolderInt);
                        if (!h4 || g5 != childViewHolderInt) {
                            l.c n4 = this.mViewInfoStore.n(g5);
                            this.mViewInfoStore.d(childViewHolderInt, s4);
                            l.c m4 = this.mViewInfoStore.m(childViewHolderInt);
                            if (n4 == null) {
                                handleMissingPreInfoForChangeError(changedHolderKey, childViewHolderInt, g5);
                            } else {
                                animateChange(g5, childViewHolderInt, n4, m4, h4, h5);
                            }
                        }
                    }
                    this.mViewInfoStore.d(childViewHolderInt, s4);
                }
            }
            this.mViewInfoStore.o(this.mViewInfoProcessCallback);
        }
        this.mLayout.l1(this.mRecycler);
        a0 a0Var2 = this.mState;
        a0Var2.f1784c = a0Var2.f1787f;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        a0Var2.f1792k = false;
        a0Var2.f1793l = false;
        this.mLayout.f1849h = false;
        ArrayList<d0> arrayList = this.mRecycler.f1877b;
        if (arrayList != null) {
            arrayList.clear();
        }
        o oVar = this.mLayout;
        if (oVar.f1855n) {
            oVar.f1854m = 0;
            oVar.f1855n = false;
            this.mRecycler.K();
        }
        this.mLayout.Y0(this.mState);
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mViewInfoStore.f();
        int[] iArr = this.mMinMaxLayoutPositions;
        if (didChildRangeChange(iArr[0], iArr[1])) {
            dispatchOnScrolled(0, 0);
        }
        recoverFocusFromState();
        resetFocusInfo();
    }

    private boolean dispatchToOnItemTouchListeners(MotionEvent motionEvent) {
        s sVar = this.mInterceptingOnItemTouchListener;
        if (sVar == null) {
            if (motionEvent.getAction() == 0) {
                return false;
            }
            return findInterceptingOnItemTouchListener(motionEvent);
        }
        sVar.b(this, motionEvent);
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.mInterceptingOnItemTouchListener = null;
        }
        return true;
    }

    private boolean findInterceptingOnItemTouchListener(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.mOnItemTouchListeners.size();
        for (int i4 = 0; i4 < size; i4++) {
            s sVar = this.mOnItemTouchListeners.get(i4);
            if (sVar.a(this, motionEvent) && action != 3) {
                this.mInterceptingOnItemTouchListener = sVar;
                return true;
            }
        }
        return false;
    }

    private void findMinMaxChildLayoutPositions(int[] iArr) {
        int g4 = this.mChildHelper.g();
        if (g4 == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i4 = Integer.MAX_VALUE;
        int i5 = UNDEFINED_DURATION;
        for (int i6 = 0; i6 < g4; i6++) {
            d0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.f(i6));
            if (!childViewHolderInt.J()) {
                int m4 = childViewHolderInt.m();
                if (m4 < i4) {
                    i4 = m4;
                }
                if (m4 > i5) {
                    i5 = m4;
                }
            }
        }
        iArr[0] = i4;
        iArr[1] = i5;
    }

    static RecyclerView findNestedRecyclerView(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            RecyclerView findNestedRecyclerView = findNestedRecyclerView(viewGroup.getChildAt(i4));
            if (findNestedRecyclerView != null) {
                return findNestedRecyclerView;
            }
        }
        return null;
    }

    private View findNextViewToFocus() {
        d0 findViewHolderForAdapterPosition;
        a0 a0Var = this.mState;
        int i4 = a0Var.f1794m;
        if (i4 == -1) {
            i4 = 0;
        }
        int b5 = a0Var.b();
        for (int i5 = i4; i5 < b5; i5++) {
            d0 findViewHolderForAdapterPosition2 = findViewHolderForAdapterPosition(i5);
            if (findViewHolderForAdapterPosition2 == null) {
                break;
            }
            if (findViewHolderForAdapterPosition2.f1809a.hasFocusable()) {
                return findViewHolderForAdapterPosition2.f1809a;
            }
        }
        int min = Math.min(b5, i4);
        do {
            min--;
            if (min < 0 || (findViewHolderForAdapterPosition = findViewHolderForAdapterPosition(min)) == null) {
                return null;
            }
        } while (!findViewHolderForAdapterPosition.f1809a.hasFocusable());
        return findViewHolderForAdapterPosition.f1809a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d0 getChildViewHolderInt(View view) {
        if (view == null) {
            return null;
        }
        return ((p) view.getLayoutParams()).f1866a;
    }

    static void getDecoratedBoundsWithMarginsInt(View view, Rect rect) {
        p pVar = (p) view.getLayoutParams();
        Rect rect2 = pVar.f1867b;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) pVar).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) pVar).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) pVar).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin);
    }

    private int getDeepestFocusedViewWithId(View view) {
        int id;
        loop0: while (true) {
            id = view.getId();
            while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
                view = ((ViewGroup) view).getFocusedChild();
                if (view.getId() != -1) {
                    break;
                }
            }
        }
        return id;
    }

    private String getFullClassName(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        }
        if (str.contains(".")) {
            return str;
        }
        return RecyclerView.class.getPackage().getName() + '.' + str;
    }

    private y.j getScrollingChildHelper() {
        if (this.mScrollingChildHelper == null) {
            this.mScrollingChildHelper = new y.j(this);
        }
        return this.mScrollingChildHelper;
    }

    private void handleMissingPreInfoForChangeError(long j4, d0 d0Var, d0 d0Var2) {
        int g4 = this.mChildHelper.g();
        for (int i4 = 0; i4 < g4; i4++) {
            d0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.f(i4));
            if (childViewHolderInt != d0Var && getChangedHolderKey(childViewHolderInt) == j4) {
                g gVar = this.mAdapter;
                if (gVar == null || !gVar.g()) {
                    throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + childViewHolderInt + " \n View Holder 2:" + d0Var + exceptionLabel());
                }
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + childViewHolderInt + " \n View Holder 2:" + d0Var + exceptionLabel());
            }
        }
        Log.e(TAG, "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + d0Var2 + " cannot be found but it is necessary for " + d0Var + exceptionLabel());
    }

    private boolean hasUpdatedView() {
        int g4 = this.mChildHelper.g();
        for (int i4 = 0; i4 < g4; i4++) {
            d0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.f(i4));
            if (childViewHolderInt != null && !childViewHolderInt.J() && childViewHolderInt.y()) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"InlinedApi"})
    private void initAutofill() {
        if (y.p.s(this) == 0) {
            y.p.k0(this, 8);
        }
    }

    private void initChildrenHelper() {
        this.mChildHelper = new androidx.recyclerview.widget.b(new e());
    }

    private boolean isPreferredNextFocus(View view, View view2, int i4) {
        int i5;
        if (view2 == null || view2 == this || findContainingItemView(view2) == null) {
            return false;
        }
        if (view == null || findContainingItemView(view) == null) {
            return true;
        }
        this.mTempRect.set(0, 0, view.getWidth(), view.getHeight());
        this.mTempRect2.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        offsetDescendantRectToMyCoords(view2, this.mTempRect2);
        char c5 = 65535;
        int i6 = this.mLayout.Z() == 1 ? -1 : 1;
        Rect rect = this.mTempRect;
        int i7 = rect.left;
        Rect rect2 = this.mTempRect2;
        int i8 = rect2.left;
        if ((i7 < i8 || rect.right <= i8) && rect.right < rect2.right) {
            i5 = 1;
        } else {
            int i9 = rect.right;
            int i10 = rect2.right;
            i5 = ((i9 > i10 || i7 >= i10) && i7 > i8) ? -1 : 0;
        }
        int i11 = rect.top;
        int i12 = rect2.top;
        if ((i11 < i12 || rect.bottom <= i12) && rect.bottom < rect2.bottom) {
            c5 = 1;
        } else {
            int i13 = rect.bottom;
            int i14 = rect2.bottom;
            if ((i13 <= i14 && i11 < i14) || i11 <= i12) {
                c5 = 0;
            }
        }
        if (i4 == 1) {
            return c5 < 0 || (c5 == 0 && i5 * i6 <= 0);
        }
        if (i4 == 2) {
            return c5 > 0 || (c5 == 0 && i5 * i6 >= 0);
        }
        if (i4 == 17) {
            return i5 < 0;
        }
        if (i4 == 33) {
            return c5 < 0;
        }
        if (i4 == 66) {
            return i5 > 0;
        }
        if (i4 == 130) {
            return c5 > 0;
        }
        throw new IllegalArgumentException("Invalid direction: " + i4 + exceptionLabel());
    }

    private void onPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mScrollPointerId) {
            int i4 = actionIndex == 0 ? 1 : 0;
            this.mScrollPointerId = motionEvent.getPointerId(i4);
            int x4 = (int) (motionEvent.getX(i4) + 0.5f);
            this.mLastTouchX = x4;
            this.mInitialTouchX = x4;
            int y4 = (int) (motionEvent.getY(i4) + 0.5f);
            this.mLastTouchY = y4;
            this.mInitialTouchY = y4;
        }
    }

    private boolean predictiveItemAnimationsEnabled() {
        return this.mItemAnimator != null && this.mLayout.L1();
    }

    private void processAdapterUpdatesAndSetAnimationFlags() {
        boolean z4;
        if (this.mDataSetHasChangedAfterLayout) {
            this.mAdapterHelper.u();
            if (this.mDispatchItemsChangedEvent) {
                this.mLayout.S0(this);
            }
        }
        if (predictiveItemAnimationsEnabled()) {
            this.mAdapterHelper.s();
        } else {
            this.mAdapterHelper.j();
        }
        boolean z5 = false;
        boolean z6 = this.mItemsAddedOrRemoved || this.mItemsChanged;
        this.mState.f1792k = this.mFirstLayoutComplete && this.mItemAnimator != null && ((z4 = this.mDataSetHasChangedAfterLayout) || z6 || this.mLayout.f1849h) && (!z4 || this.mAdapter.g());
        a0 a0Var = this.mState;
        if (a0Var.f1792k && z6 && !this.mDataSetHasChangedAfterLayout && predictiveItemAnimationsEnabled()) {
            z5 = true;
        }
        a0Var.f1793l = z5;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void pullGlows(float r7, float r8, float r9, float r10) {
        /*
            r6 = this;
            r0 = 0
            int r1 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            r2 = 1065353216(0x3f800000, float:1.0)
            r3 = 1
            if (r1 >= 0) goto L21
            r6.ensureLeftGlow()
            android.widget.EdgeEffect r1 = r6.mLeftGlow
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r2 - r9
        L1c:
            androidx.core.widget.d.a(r1, r4, r9)
            r9 = r3
            goto L39
        L21:
            int r1 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r1 <= 0) goto L38
            r6.ensureRightGlow()
            android.widget.EdgeEffect r1 = r6.mRightGlow
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            goto L1c
        L38:
            r9 = 0
        L39:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 >= 0) goto L53
            r6.ensureTopGlow()
            android.widget.EdgeEffect r9 = r6.mTopGlow
            float r1 = -r10
            int r2 = r6.getHeight()
            float r2 = (float) r2
            float r1 = r1 / r2
            int r2 = r6.getWidth()
            float r2 = (float) r2
            float r7 = r7 / r2
            androidx.core.widget.d.a(r9, r1, r7)
            goto L6f
        L53:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 <= 0) goto L6e
            r6.ensureBottomGlow()
            android.widget.EdgeEffect r9 = r6.mBottomGlow
            int r1 = r6.getHeight()
            float r1 = (float) r1
            float r1 = r10 / r1
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            float r2 = r2 - r7
            androidx.core.widget.d.a(r9, r1, r2)
            goto L6f
        L6e:
            r3 = r9
        L6f:
            if (r3 != 0) goto L79
            int r7 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r7 != 0) goto L79
            int r7 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r7 == 0) goto L7c
        L79:
            y.p.S(r6)
        L7c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.pullGlows(float, float, float, float):void");
    }

    private void recoverFocusFromState() {
        View findViewById;
        if (!this.mPreserveFocusAfterLayout || this.mAdapter == null || !hasFocus() || getDescendantFocusability() == 393216) {
            return;
        }
        if (getDescendantFocusability() == 131072 && isFocused()) {
            return;
        }
        if (!isFocused()) {
            View focusedChild = getFocusedChild();
            if (!IGNORE_DETACHED_FOCUSED_CHILD || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                if (!this.mChildHelper.n(focusedChild)) {
                    return;
                }
            } else if (this.mChildHelper.g() == 0) {
                requestFocus();
                return;
            }
        }
        View view = null;
        d0 findViewHolderForItemId = (this.mState.f1795n == -1 || !this.mAdapter.g()) ? null : findViewHolderForItemId(this.mState.f1795n);
        if (findViewHolderForItemId != null && !this.mChildHelper.n(findViewHolderForItemId.f1809a) && findViewHolderForItemId.f1809a.hasFocusable()) {
            view = findViewHolderForItemId.f1809a;
        } else if (this.mChildHelper.g() > 0) {
            view = findNextViewToFocus();
        }
        if (view != null) {
            int i4 = this.mState.f1796o;
            if (i4 != -1 && (findViewById = view.findViewById(i4)) != null && findViewById.isFocusable()) {
                view = findViewById;
            }
            view.requestFocus();
        }
    }

    private void releaseGlows() {
        boolean z4;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z4 = this.mLeftGlow.isFinished();
        } else {
            z4 = false;
        }
        EdgeEffect edgeEffect2 = this.mTopGlow;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z4 |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mRightGlow;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z4 |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z4 |= this.mBottomGlow.isFinished();
        }
        if (z4) {
            y.p.S(this);
        }
    }

    private void requestChildOnScreen(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.mTempRect.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof p) {
            p pVar = (p) layoutParams;
            if (!pVar.f1868c) {
                Rect rect = pVar.f1867b;
                Rect rect2 = this.mTempRect;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.mTempRect);
            offsetRectIntoDescendantCoords(view, this.mTempRect);
        }
        this.mLayout.s1(this, view, this.mTempRect, !this.mFirstLayoutComplete, view2 == null);
    }

    private void resetFocusInfo() {
        a0 a0Var = this.mState;
        a0Var.f1795n = -1L;
        a0Var.f1794m = -1;
        a0Var.f1796o = -1;
    }

    private void resetScroll() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        stopNestedScroll(0);
        releaseGlows();
    }

    private void saveFocusInfo() {
        View focusedChild = (this.mPreserveFocusAfterLayout && hasFocus() && this.mAdapter != null) ? getFocusedChild() : null;
        d0 findContainingViewHolder = focusedChild != null ? findContainingViewHolder(focusedChild) : null;
        if (findContainingViewHolder == null) {
            resetFocusInfo();
            return;
        }
        this.mState.f1795n = this.mAdapter.g() ? findContainingViewHolder.k() : -1L;
        this.mState.f1794m = this.mDataSetHasChangedAfterLayout ? -1 : findContainingViewHolder.v() ? findContainingViewHolder.f1812d : findContainingViewHolder.j();
        this.mState.f1796o = getDeepestFocusedViewWithId(findContainingViewHolder.f1809a);
    }

    private void setAdapterInternal(g gVar, boolean z4, boolean z5) {
        g gVar2 = this.mAdapter;
        if (gVar2 != null) {
            gVar2.t(this.mObserver);
            this.mAdapter.m(this);
        }
        if (!z4 || z5) {
            removeAndRecycleViews();
        }
        this.mAdapterHelper.u();
        g gVar3 = this.mAdapter;
        this.mAdapter = gVar;
        if (gVar != null) {
            gVar.r(this.mObserver);
            gVar.i(this);
        }
        o oVar = this.mLayout;
        if (oVar != null) {
            oVar.E0(gVar3, this.mAdapter);
        }
        this.mRecycler.x(gVar3, this.mAdapter, z4);
        this.mState.f1788g = true;
    }

    private void stopScrollersInternal() {
        this.mViewFlinger.g();
        o oVar = this.mLayout;
        if (oVar != null) {
            oVar.K1();
        }
    }

    void absorbGlows(int i4, int i5) {
        if (i4 < 0) {
            ensureLeftGlow();
            if (this.mLeftGlow.isFinished()) {
                this.mLeftGlow.onAbsorb(-i4);
            }
        } else if (i4 > 0) {
            ensureRightGlow();
            if (this.mRightGlow.isFinished()) {
                this.mRightGlow.onAbsorb(i4);
            }
        }
        if (i5 < 0) {
            ensureTopGlow();
            if (this.mTopGlow.isFinished()) {
                this.mTopGlow.onAbsorb(-i5);
            }
        } else if (i5 > 0) {
            ensureBottomGlow();
            if (this.mBottomGlow.isFinished()) {
                this.mBottomGlow.onAbsorb(i5);
            }
        }
        if (i4 == 0 && i5 == 0) {
            return;
        }
        y.p.S(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i4, int i5) {
        o oVar = this.mLayout;
        if (oVar == null || !oVar.F0(this, arrayList, i4, i5)) {
            super.addFocusables(arrayList, i4, i5);
        }
    }

    public void addItemDecoration(n nVar) {
        addItemDecoration(nVar, -1);
    }

    public void addItemDecoration(n nVar, int i4) {
        o oVar = this.mLayout;
        if (oVar != null) {
            oVar.g("Cannot add item decoration during a scroll  or layout");
        }
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i4 < 0) {
            this.mItemDecorations.add(nVar);
        } else {
            this.mItemDecorations.add(i4, nVar);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void addOnChildAttachStateChangeListener(q qVar) {
        if (this.mOnChildAttachStateListeners == null) {
            this.mOnChildAttachStateListeners = new ArrayList();
        }
        this.mOnChildAttachStateListeners.add(qVar);
    }

    public void addOnItemTouchListener(s sVar) {
        this.mOnItemTouchListeners.add(sVar);
    }

    public void addOnScrollListener(t tVar) {
        if (this.mScrollListeners == null) {
            this.mScrollListeners = new ArrayList();
        }
        this.mScrollListeners.add(tVar);
    }

    void animateAppearance(d0 d0Var, l.c cVar, l.c cVar2) {
        d0Var.G(false);
        if (this.mItemAnimator.a(d0Var, cVar, cVar2)) {
            postAnimationRunner();
        }
    }

    void animateDisappearance(d0 d0Var, l.c cVar, l.c cVar2) {
        addAnimatingView(d0Var);
        d0Var.G(false);
        if (this.mItemAnimator.c(d0Var, cVar, cVar2)) {
            postAnimationRunner();
        }
    }

    void assertInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            return;
        }
        if (str == null) {
            throw new IllegalStateException("Cannot call this method unless RecyclerView is computing a layout or scrolling" + exceptionLabel());
        }
        throw new IllegalStateException(str + exceptionLabel());
    }

    void assertNotInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            if (str != null) {
                throw new IllegalStateException(str);
            }
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + exceptionLabel());
        }
        if (this.mDispatchScrollCounter > 0) {
            Log.w(TAG, "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + exceptionLabel()));
        }
    }

    boolean canReuseUpdatedViewHolder(d0 d0Var) {
        l lVar = this.mItemAnimator;
        return lVar == null || lVar.g(d0Var, d0Var.o());
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof p) && this.mLayout.m((p) layoutParams);
    }

    void clearOldPositions() {
        int j4 = this.mChildHelper.j();
        for (int i4 = 0; i4 < j4; i4++) {
            d0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i4));
            if (!childViewHolderInt.J()) {
                childViewHolderInt.c();
            }
        }
        this.mRecycler.d();
    }

    public void clearOnChildAttachStateChangeListeners() {
        List<q> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            list.clear();
        }
    }

    public void clearOnScrollListeners() {
        List<t> list = this.mScrollListeners;
        if (list != null) {
            list.clear();
        }
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        o oVar = this.mLayout;
        if (oVar != null && oVar.k()) {
            return this.mLayout.q(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        o oVar = this.mLayout;
        if (oVar != null && oVar.k()) {
            return this.mLayout.r(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        o oVar = this.mLayout;
        if (oVar != null && oVar.k()) {
            return this.mLayout.s(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        o oVar = this.mLayout;
        if (oVar != null && oVar.l()) {
            return this.mLayout.t(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        o oVar = this.mLayout;
        if (oVar != null && oVar.l()) {
            return this.mLayout.u(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        o oVar = this.mLayout;
        if (oVar != null && oVar.l()) {
            return this.mLayout.v(this.mState);
        }
        return 0;
    }

    void considerReleasingGlowsOnScroll(int i4, int i5) {
        boolean z4;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || edgeEffect.isFinished() || i4 <= 0) {
            z4 = false;
        } else {
            this.mLeftGlow.onRelease();
            z4 = this.mLeftGlow.isFinished();
        }
        EdgeEffect edgeEffect2 = this.mRightGlow;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i4 < 0) {
            this.mRightGlow.onRelease();
            z4 |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i5 > 0) {
            this.mTopGlow.onRelease();
            z4 |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i5 < 0) {
            this.mBottomGlow.onRelease();
            z4 |= this.mBottomGlow.isFinished();
        }
        if (z4) {
            y.p.S(this);
        }
    }

    void consumePendingUpdateOperations() {
        if (!this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout) {
            u.a.a(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
            dispatchLayout();
            u.a.b();
            return;
        }
        if (this.mAdapterHelper.p()) {
            if (this.mAdapterHelper.o(4) && !this.mAdapterHelper.o(11)) {
                u.a.a(TRACE_HANDLE_ADAPTER_UPDATES_TAG);
                startInterceptRequestLayout();
                onEnterLayoutOrScroll();
                this.mAdapterHelper.s();
                if (!this.mLayoutWasDefered) {
                    if (hasUpdatedView()) {
                        dispatchLayout();
                    } else {
                        this.mAdapterHelper.i();
                    }
                }
                stopInterceptRequestLayout(true);
                onExitLayoutOrScroll();
            } else {
                if (!this.mAdapterHelper.p()) {
                    return;
                }
                u.a.a(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
                dispatchLayout();
            }
            u.a.b();
        }
    }

    void defaultOnMeasure(int i4, int i5) {
        setMeasuredDimension(o.n(i4, getPaddingLeft() + getPaddingRight(), y.p.v(this)), o.n(i5, getPaddingTop() + getPaddingBottom(), y.p.u(this)));
    }

    void dispatchChildAttached(View view) {
        d0 childViewHolderInt = getChildViewHolderInt(view);
        onChildAttachedToWindow(view);
        g gVar = this.mAdapter;
        if (gVar != null && childViewHolderInt != null) {
            gVar.o(childViewHolderInt);
        }
        List<q> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).a(view);
            }
        }
    }

    void dispatchChildDetached(View view) {
        d0 childViewHolderInt = getChildViewHolderInt(view);
        onChildDetachedFromWindow(view);
        g gVar = this.mAdapter;
        if (gVar != null && childViewHolderInt != null) {
            gVar.p(childViewHolderInt);
        }
        List<q> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).b(view);
            }
        }
    }

    void dispatchLayout() {
        String str;
        if (this.mAdapter == null) {
            str = "No adapter attached; skipping layout";
        } else {
            if (this.mLayout != null) {
                a0 a0Var = this.mState;
                a0Var.f1791j = false;
                if (a0Var.f1786e == 1) {
                    dispatchLayoutStep1();
                } else if (!this.mAdapterHelper.q() && this.mLayout.o0() == getWidth() && this.mLayout.W() == getHeight()) {
                    this.mLayout.z1(this);
                    dispatchLayoutStep3();
                    return;
                }
                this.mLayout.z1(this);
                dispatchLayoutStep2();
                dispatchLayoutStep3();
                return;
            }
            str = "No layout manager attached; skipping layout";
        }
        Log.e(TAG, str);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f4, float f5, boolean z4) {
        return getScrollingChildHelper().a(f4, f5, z4);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f4, float f5) {
        return getScrollingChildHelper().b(f4, f5);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i4, int i5, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i4, i5, iArr, iArr2);
    }

    public boolean dispatchNestedPreScroll(int i4, int i5, int[] iArr, int[] iArr2, int i6) {
        return getScrollingChildHelper().d(i4, i5, iArr, iArr2, i6);
    }

    public final void dispatchNestedScroll(int i4, int i5, int i6, int i7, int[] iArr, int i8, int[] iArr2) {
        getScrollingChildHelper().e(i4, i5, i6, i7, iArr, i8, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i4, int i5, int i6, int i7, int[] iArr) {
        return getScrollingChildHelper().f(i4, i5, i6, i7, iArr);
    }

    public boolean dispatchNestedScroll(int i4, int i5, int i6, int i7, int[] iArr, int i8) {
        return getScrollingChildHelper().g(i4, i5, i6, i7, iArr, i8);
    }

    void dispatchOnScrollStateChanged(int i4) {
        o oVar = this.mLayout;
        if (oVar != null) {
            oVar.e1(i4);
        }
        onScrollStateChanged(i4);
        t tVar = this.mScrollListener;
        if (tVar != null) {
            tVar.a(this, i4);
        }
        List<t> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).a(this, i4);
            }
        }
    }

    void dispatchOnScrolled(int i4, int i5) {
        this.mDispatchScrollCounter++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i4, scrollY - i5);
        onScrolled(i4, i5);
        t tVar = this.mScrollListener;
        if (tVar != null) {
            tVar.b(this, i4, i5);
        }
        List<t> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).b(this, i4, i5);
            }
        }
        this.mDispatchScrollCounter--;
    }

    void dispatchPendingImportantForAccessibilityChanges() {
        int i4;
        for (int size = this.mPendingAccessibilityImportanceChange.size() - 1; size >= 0; size--) {
            d0 d0Var = this.mPendingAccessibilityImportanceChange.get(size);
            if (d0Var.f1809a.getParent() == this && !d0Var.J() && (i4 = d0Var.f1825q) != -1) {
                y.p.j0(d0Var.f1809a, i4);
                d0Var.f1825q = -1;
            }
        }
        this.mPendingAccessibilityImportanceChange.clear();
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z4;
        float f4;
        int i4;
        super.draw(canvas);
        int size = this.mItemDecorations.size();
        boolean z5 = false;
        for (int i5 = 0; i5 < size; i5++) {
            this.mItemDecorations.get(i5).i(canvas, this, this.mState);
        }
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z4 = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.mClipToPadding ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.mLeftGlow;
            z4 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.mClipToPadding) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.mTopGlow;
            z4 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.mRightGlow;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.mClipToPadding ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(-paddingTop, -width);
            EdgeEffect edgeEffect6 = this.mRightGlow;
            z4 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.mBottomGlow;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.mClipToPadding) {
                f4 = (-getWidth()) + getPaddingRight();
                i4 = (-getHeight()) + getPaddingBottom();
            } else {
                f4 = -getWidth();
                i4 = -getHeight();
            }
            canvas.translate(f4, i4);
            EdgeEffect edgeEffect8 = this.mBottomGlow;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z5 = true;
            }
            z4 |= z5;
            canvas.restoreToCount(save4);
        }
        if ((z4 || this.mItemAnimator == null || this.mItemDecorations.size() <= 0 || !this.mItemAnimator.p()) ? z4 : true) {
            y.p.S(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j4) {
        return super.drawChild(canvas, view, j4);
    }

    void ensureBottomGlow() {
        int measuredWidth;
        int measuredHeight;
        if (this.mBottomGlow != null) {
            return;
        }
        EdgeEffect a5 = this.mEdgeEffectFactory.a(this, 3);
        this.mBottomGlow = a5;
        if (this.mClipToPadding) {
            measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        } else {
            measuredWidth = getMeasuredWidth();
            measuredHeight = getMeasuredHeight();
        }
        a5.setSize(measuredWidth, measuredHeight);
    }

    void ensureLeftGlow() {
        int measuredHeight;
        int measuredWidth;
        if (this.mLeftGlow != null) {
            return;
        }
        EdgeEffect a5 = this.mEdgeEffectFactory.a(this, 0);
        this.mLeftGlow = a5;
        if (this.mClipToPadding) {
            measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        } else {
            measuredHeight = getMeasuredHeight();
            measuredWidth = getMeasuredWidth();
        }
        a5.setSize(measuredHeight, measuredWidth);
    }

    void ensureRightGlow() {
        int measuredHeight;
        int measuredWidth;
        if (this.mRightGlow != null) {
            return;
        }
        EdgeEffect a5 = this.mEdgeEffectFactory.a(this, 2);
        this.mRightGlow = a5;
        if (this.mClipToPadding) {
            measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        } else {
            measuredHeight = getMeasuredHeight();
            measuredWidth = getMeasuredWidth();
        }
        a5.setSize(measuredHeight, measuredWidth);
    }

    void ensureTopGlow() {
        int measuredWidth;
        int measuredHeight;
        if (this.mTopGlow != null) {
            return;
        }
        EdgeEffect a5 = this.mEdgeEffectFactory.a(this, 1);
        this.mTopGlow = a5;
        if (this.mClipToPadding) {
            measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        } else {
            measuredWidth = getMeasuredWidth();
            measuredHeight = getMeasuredHeight();
        }
        a5.setSize(measuredWidth, measuredHeight);
    }

    String exceptionLabel() {
        return " " + super.toString() + ", adapter:" + this.mAdapter + ", layout:" + this.mLayout + ", context:" + getContext();
    }

    final void fillRemainingScrollValues(a0 a0Var) {
        if (getScrollState() != 2) {
            a0Var.f1797p = 0;
            a0Var.f1798q = 0;
        } else {
            OverScroller overScroller = this.mViewFlinger.f1802d;
            a0Var.f1797p = overScroller.getFinalX() - overScroller.getCurrX();
            a0Var.f1798q = overScroller.getFinalY() - overScroller.getCurrY();
        }
    }

    public View findChildViewUnder(float f4, float f5) {
        for (int g4 = this.mChildHelper.g() - 1; g4 >= 0; g4--) {
            View f6 = this.mChildHelper.f(g4);
            float translationX = f6.getTranslationX();
            float translationY = f6.getTranslationY();
            if (f4 >= f6.getLeft() + translationX && f4 <= f6.getRight() + translationX && f5 >= f6.getTop() + translationY && f5 <= f6.getBottom() + translationY) {
                return f6;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:?, code lost:
    
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View findContainingItemView(android.view.View r3) {
        /*
            r2 = this;
        L0:
            android.view.ViewParent r0 = r3.getParent()
            if (r0 == 0) goto L10
            if (r0 == r2) goto L10
            boolean r1 = r0 instanceof android.view.View
            if (r1 == 0) goto L10
            r3 = r0
            android.view.View r3 = (android.view.View) r3
            goto L0
        L10:
            if (r0 != r2) goto L13
            goto L14
        L13:
            r3 = 0
        L14:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.findContainingItemView(android.view.View):android.view.View");
    }

    public d0 findContainingViewHolder(View view) {
        View findContainingItemView = findContainingItemView(view);
        if (findContainingItemView == null) {
            return null;
        }
        return getChildViewHolder(findContainingItemView);
    }

    public d0 findViewHolderForAdapterPosition(int i4) {
        d0 d0Var = null;
        if (this.mDataSetHasChangedAfterLayout) {
            return null;
        }
        int j4 = this.mChildHelper.j();
        for (int i5 = 0; i5 < j4; i5++) {
            d0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i5));
            if (childViewHolderInt != null && !childViewHolderInt.v() && getAdapterPositionFor(childViewHolderInt) == i4) {
                if (!this.mChildHelper.n(childViewHolderInt.f1809a)) {
                    return childViewHolderInt;
                }
                d0Var = childViewHolderInt;
            }
        }
        return d0Var;
    }

    public d0 findViewHolderForItemId(long j4) {
        g gVar = this.mAdapter;
        d0 d0Var = null;
        if (gVar != null && gVar.g()) {
            int j5 = this.mChildHelper.j();
            for (int i4 = 0; i4 < j5; i4++) {
                d0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i4));
                if (childViewHolderInt != null && !childViewHolderInt.v() && childViewHolderInt.k() == j4) {
                    if (!this.mChildHelper.n(childViewHolderInt.f1809a)) {
                        return childViewHolderInt;
                    }
                    d0Var = childViewHolderInt;
                }
            }
        }
        return d0Var;
    }

    public d0 findViewHolderForLayoutPosition(int i4) {
        return findViewHolderForPosition(i4, false);
    }

    @Deprecated
    public d0 findViewHolderForPosition(int i4) {
        return findViewHolderForPosition(i4, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0036 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    androidx.recyclerview.widget.RecyclerView.d0 findViewHolderForPosition(int r6, boolean r7) {
        /*
            r5 = this;
            androidx.recyclerview.widget.b r0 = r5.mChildHelper
            int r0 = r0.j()
            r1 = 0
            r2 = 0
        L8:
            if (r2 >= r0) goto L3a
            androidx.recyclerview.widget.b r3 = r5.mChildHelper
            android.view.View r3 = r3.i(r2)
            androidx.recyclerview.widget.RecyclerView$d0 r3 = getChildViewHolderInt(r3)
            if (r3 == 0) goto L37
            boolean r4 = r3.v()
            if (r4 != 0) goto L37
            if (r7 == 0) goto L23
            int r4 = r3.f1811c
            if (r4 == r6) goto L2a
            goto L37
        L23:
            int r4 = r3.m()
            if (r4 == r6) goto L2a
            goto L37
        L2a:
            androidx.recyclerview.widget.b r1 = r5.mChildHelper
            android.view.View r4 = r3.f1809a
            boolean r1 = r1.n(r4)
            if (r1 == 0) goto L36
            r1 = r3
            goto L37
        L36:
            return r3
        L37:
            int r2 = r2 + 1
            goto L8
        L3a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.findViewHolderForPosition(int, boolean):androidx.recyclerview.widget.RecyclerView$d0");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v6 */
    public boolean fling(int i4, int i5) {
        o oVar = this.mLayout;
        if (oVar == null) {
            Log.e(TAG, "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        }
        if (this.mLayoutSuppressed) {
            return false;
        }
        int k4 = oVar.k();
        boolean l4 = this.mLayout.l();
        if (k4 == 0 || Math.abs(i4) < this.mMinFlingVelocity) {
            i4 = 0;
        }
        if (!l4 || Math.abs(i5) < this.mMinFlingVelocity) {
            i5 = 0;
        }
        if (i4 == 0 && i5 == 0) {
            return false;
        }
        float f4 = i4;
        float f5 = i5;
        if (!dispatchNestedPreFling(f4, f5)) {
            boolean z4 = k4 != 0 || l4;
            dispatchNestedFling(f4, f5, z4);
            r rVar = this.mOnFlingListener;
            if (rVar != null && rVar.a(i4, i5)) {
                return true;
            }
            if (z4) {
                if (l4) {
                    k4 = (k4 == true ? 1 : 0) | 2;
                }
                startNestedScroll(k4, 1);
                int i6 = this.mMaxFlingVelocity;
                int max = Math.max(-i6, Math.min(i4, i6));
                int i7 = this.mMaxFlingVelocity;
                this.mViewFlinger.c(max, Math.max(-i7, Math.min(i5, i7)));
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i4) {
        View view2;
        boolean z4;
        View Q0 = this.mLayout.Q0(view, i4);
        if (Q0 != null) {
            return Q0;
        }
        boolean z5 = (this.mAdapter == null || this.mLayout == null || isComputingLayout() || this.mLayoutSuppressed) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z5 && (i4 == 2 || i4 == 1)) {
            if (this.mLayout.l()) {
                int i5 = i4 == 2 ? 130 : 33;
                z4 = focusFinder.findNextFocus(this, view, i5) == null;
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i4 = i5;
                }
            } else {
                z4 = false;
            }
            if (!z4 && this.mLayout.k()) {
                int i6 = (this.mLayout.Z() == 1) ^ (i4 == 2) ? 66 : 17;
                boolean z6 = focusFinder.findNextFocus(this, view, i6) == null;
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i4 = i6;
                }
                z4 = z6;
            }
            if (z4) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                this.mLayout.J0(view, i4, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            }
            view2 = focusFinder.findNextFocus(this, view, i4);
        } else {
            View findNextFocus = focusFinder.findNextFocus(this, view, i4);
            if (findNextFocus == null && z5) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                view2 = this.mLayout.J0(view, i4, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            } else {
                view2 = findNextFocus;
            }
        }
        if (view2 == null || view2.hasFocusable()) {
            return isPreferredNextFocus(view, view2, i4) ? view2 : super.focusSearch(view, i4);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i4);
        }
        requestChildOnScreen(view2, null);
        return view;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        o oVar = this.mLayout;
        if (oVar != null) {
            return oVar.D();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        o oVar = this.mLayout;
        if (oVar != null) {
            return oVar.E(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        o oVar = this.mLayout;
        if (oVar != null) {
            return oVar.F(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public g getAdapter() {
        return this.mAdapter;
    }

    int getAdapterPositionFor(d0 d0Var) {
        if (d0Var.p(524) || !d0Var.s()) {
            return -1;
        }
        return this.mAdapterHelper.e(d0Var.f1811c);
    }

    @Override // android.view.View
    public int getBaseline() {
        o oVar = this.mLayout;
        return oVar != null ? oVar.G() : super.getBaseline();
    }

    long getChangedHolderKey(d0 d0Var) {
        return this.mAdapter.g() ? d0Var.k() : d0Var.f1811c;
    }

    public int getChildAdapterPosition(View view) {
        d0 childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.j();
        }
        return -1;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i4, int i5) {
        j jVar = this.mChildDrawingOrderCallback;
        return jVar == null ? super.getChildDrawingOrder(i4, i5) : jVar.a(i4, i5);
    }

    public long getChildItemId(View view) {
        d0 childViewHolderInt;
        g gVar = this.mAdapter;
        if (gVar == null || !gVar.g() || (childViewHolderInt = getChildViewHolderInt(view)) == null) {
            return -1L;
        }
        return childViewHolderInt.k();
    }

    public int getChildLayoutPosition(View view) {
        d0 childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.m();
        }
        return -1;
    }

    @Deprecated
    public int getChildPosition(View view) {
        return getChildAdapterPosition(view);
    }

    public d0 getChildViewHolder(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return getChildViewHolderInt(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.mClipToPadding;
    }

    public androidx.recyclerview.widget.k getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    public void getDecoratedBoundsWithMargins(View view, Rect rect) {
        getDecoratedBoundsWithMarginsInt(view, rect);
    }

    public k getEdgeEffectFactory() {
        return this.mEdgeEffectFactory;
    }

    public l getItemAnimator() {
        return this.mItemAnimator;
    }

    Rect getItemDecorInsetsForChild(View view) {
        p pVar = (p) view.getLayoutParams();
        if (!pVar.f1868c) {
            return pVar.f1867b;
        }
        if (this.mState.e() && (pVar.b() || pVar.d())) {
            return pVar.f1867b;
        }
        Rect rect = pVar.f1867b;
        rect.set(0, 0, 0, 0);
        int size = this.mItemDecorations.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.mTempRect.set(0, 0, 0, 0);
            this.mItemDecorations.get(i4).e(this.mTempRect, view, this, this.mState);
            int i5 = rect.left;
            Rect rect2 = this.mTempRect;
            rect.left = i5 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        pVar.f1868c = false;
        return rect;
    }

    public n getItemDecorationAt(int i4) {
        int itemDecorationCount = getItemDecorationCount();
        if (i4 >= 0 && i4 < itemDecorationCount) {
            return this.mItemDecorations.get(i4);
        }
        throw new IndexOutOfBoundsException(i4 + " is an invalid index for size " + itemDecorationCount);
    }

    public int getItemDecorationCount() {
        return this.mItemDecorations.size();
    }

    public o getLayoutManager() {
        return this.mLayout;
    }

    public int getMaxFlingVelocity() {
        return this.mMaxFlingVelocity;
    }

    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getNanoTime() {
        if (ALLOW_THREAD_GAP_WORK) {
            return System.nanoTime();
        }
        return 0L;
    }

    public r getOnFlingListener() {
        return this.mOnFlingListener;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.mPreserveFocusAfterLayout;
    }

    public u getRecycledViewPool() {
        return this.mRecycler.i();
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    public boolean hasFixedSize() {
        return this.mHasFixedSize;
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().k();
    }

    public boolean hasNestedScrollingParent(int i4) {
        return getScrollingChildHelper().l(i4);
    }

    public boolean hasPendingAdapterUpdates() {
        return !this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout || this.mAdapterHelper.p();
    }

    void initAdapterManager() {
        this.mAdapterHelper = new androidx.recyclerview.widget.a(new f());
    }

    void initFastScroller(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable != null && drawable != null && stateListDrawable2 != null && drawable2 != null) {
            Resources resources = getContext().getResources();
            new androidx.recyclerview.widget.d(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(f0.b.f3701a), resources.getDimensionPixelSize(f0.b.f3703c), resources.getDimensionPixelOffset(f0.b.f3702b));
        } else {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + exceptionLabel());
        }
    }

    void invalidateGlows() {
        this.mBottomGlow = null;
        this.mTopGlow = null;
        this.mRightGlow = null;
        this.mLeftGlow = null;
    }

    public void invalidateItemDecorations() {
        if (this.mItemDecorations.size() == 0) {
            return;
        }
        o oVar = this.mLayout;
        if (oVar != null) {
            oVar.g("Cannot invalidate item decorations during a scroll or layout");
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    boolean isAccessibilityEnabled() {
        AccessibilityManager accessibilityManager = this.mAccessibilityManager;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    public boolean isAnimating() {
        l lVar = this.mItemAnimator;
        return lVar != null && lVar.p();
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.mIsAttached;
    }

    public boolean isComputingLayout() {
        return this.mLayoutOrScrollCounter > 0;
    }

    @Deprecated
    public boolean isLayoutFrozen() {
        return isLayoutSuppressed();
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.mLayoutSuppressed;
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().m();
    }

    void jumpToPositionForSmoothScroller(int i4) {
        if (this.mLayout == null) {
            return;
        }
        setScrollState(2);
        this.mLayout.x1(i4);
        awakenScrollBars();
    }

    void markItemDecorInsetsDirty() {
        int j4 = this.mChildHelper.j();
        for (int i4 = 0; i4 < j4; i4++) {
            ((p) this.mChildHelper.i(i4).getLayoutParams()).f1868c = true;
        }
        this.mRecycler.s();
    }

    void markKnownViewsInvalid() {
        int j4 = this.mChildHelper.j();
        for (int i4 = 0; i4 < j4; i4++) {
            d0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i4));
            if (childViewHolderInt != null && !childViewHolderInt.J()) {
                childViewHolderInt.b(6);
            }
        }
        markItemDecorInsetsDirty();
        this.mRecycler.t();
    }

    public void offsetChildrenHorizontal(int i4) {
        int g4 = this.mChildHelper.g();
        for (int i5 = 0; i5 < g4; i5++) {
            this.mChildHelper.f(i5).offsetLeftAndRight(i4);
        }
    }

    public void offsetChildrenVertical(int i4) {
        int g4 = this.mChildHelper.g();
        for (int i5 = 0; i5 < g4; i5++) {
            this.mChildHelper.f(i5).offsetTopAndBottom(i4);
        }
    }

    void offsetPositionRecordsForInsert(int i4, int i5) {
        int j4 = this.mChildHelper.j();
        for (int i6 = 0; i6 < j4; i6++) {
            d0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i6));
            if (childViewHolderInt != null && !childViewHolderInt.J() && childViewHolderInt.f1811c >= i4) {
                childViewHolderInt.A(i5, false);
                this.mState.f1788g = true;
            }
        }
        this.mRecycler.u(i4, i5);
        requestLayout();
    }

    void offsetPositionRecordsForMove(int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int j4 = this.mChildHelper.j();
        if (i4 < i5) {
            i8 = -1;
            i7 = i4;
            i6 = i5;
        } else {
            i6 = i4;
            i7 = i5;
            i8 = 1;
        }
        for (int i10 = 0; i10 < j4; i10++) {
            d0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i10));
            if (childViewHolderInt != null && (i9 = childViewHolderInt.f1811c) >= i7 && i9 <= i6) {
                if (i9 == i4) {
                    childViewHolderInt.A(i5 - i4, false);
                } else {
                    childViewHolderInt.A(i8, false);
                }
                this.mState.f1788g = true;
            }
        }
        this.mRecycler.v(i4, i5);
        requestLayout();
    }

    void offsetPositionRecordsForRemove(int i4, int i5, boolean z4) {
        int i6 = i4 + i5;
        int j4 = this.mChildHelper.j();
        for (int i7 = 0; i7 < j4; i7++) {
            d0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i7));
            if (childViewHolderInt != null && !childViewHolderInt.J()) {
                int i8 = childViewHolderInt.f1811c;
                if (i8 >= i6) {
                    childViewHolderInt.A(-i5, z4);
                } else if (i8 >= i4) {
                    childViewHolderInt.i(i4 - 1, -i5, z4);
                }
                this.mState.f1788g = true;
            }
        }
        this.mRecycler.w(i4, i5, z4);
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mLayoutOrScrollCounter = 0;
        this.mIsAttached = true;
        this.mFirstLayoutComplete = this.mFirstLayoutComplete && !isLayoutRequested();
        o oVar = this.mLayout;
        if (oVar != null) {
            oVar.z(this);
        }
        this.mPostedAnimatorRunner = false;
        if (ALLOW_THREAD_GAP_WORK) {
            ThreadLocal<androidx.recyclerview.widget.e> threadLocal = androidx.recyclerview.widget.e.f2040f;
            androidx.recyclerview.widget.e eVar = threadLocal.get();
            this.mGapWorker = eVar;
            if (eVar == null) {
                this.mGapWorker = new androidx.recyclerview.widget.e();
                Display o4 = y.p.o(this);
                float f4 = 60.0f;
                if (!isInEditMode() && o4 != null) {
                    float refreshRate = o4.getRefreshRate();
                    if (refreshRate >= 30.0f) {
                        f4 = refreshRate;
                    }
                }
                androidx.recyclerview.widget.e eVar2 = this.mGapWorker;
                eVar2.f2044d = 1.0E9f / f4;
                threadLocal.set(eVar2);
            }
            this.mGapWorker.a(this);
        }
    }

    public void onChildAttachedToWindow(View view) {
    }

    public void onChildDetachedFromWindow(View view) {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        androidx.recyclerview.widget.e eVar;
        super.onDetachedFromWindow();
        l lVar = this.mItemAnimator;
        if (lVar != null) {
            lVar.k();
        }
        stopScroll();
        this.mIsAttached = false;
        o oVar = this.mLayout;
        if (oVar != null) {
            oVar.A(this, this.mRecycler);
        }
        this.mPendingAccessibilityImportanceChange.clear();
        removeCallbacks(this.mItemAnimatorRunner);
        this.mViewInfoStore.j();
        if (!ALLOW_THREAD_GAP_WORK || (eVar = this.mGapWorker) == null) {
            return;
        }
        eVar.j(this);
        this.mGapWorker = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.mItemDecorations.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.mItemDecorations.get(i4).g(canvas, this, this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onEnterLayoutOrScroll() {
        this.mLayoutOrScrollCounter++;
    }

    void onExitLayoutOrScroll() {
        onExitLayoutOrScroll(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onExitLayoutOrScroll(boolean z4) {
        int i4 = this.mLayoutOrScrollCounter - 1;
        this.mLayoutOrScrollCounter = i4;
        if (i4 < 1) {
            this.mLayoutOrScrollCounter = 0;
            if (z4) {
                dispatchContentChangedIfNecessary();
                dispatchPendingImportantForAccessibilityChanges();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0068  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onGenericMotionEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            androidx.recyclerview.widget.RecyclerView$o r0 = r5.mLayout
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            boolean r0 = r5.mLayoutSuppressed
            if (r0 == 0) goto Lb
            return r1
        Lb:
            int r0 = r6.getAction()
            r2 = 8
            if (r0 != r2) goto L77
            int r0 = r6.getSource()
            r0 = r0 & 2
            r2 = 0
            if (r0 == 0) goto L3e
            androidx.recyclerview.widget.RecyclerView$o r0 = r5.mLayout
            boolean r0 = r0.l()
            if (r0 == 0) goto L2c
            r0 = 9
            float r0 = r6.getAxisValue(r0)
            float r0 = -r0
            goto L2d
        L2c:
            r0 = r2
        L2d:
            androidx.recyclerview.widget.RecyclerView$o r3 = r5.mLayout
            boolean r3 = r3.k()
            if (r3 == 0) goto L3c
            r3 = 10
            float r3 = r6.getAxisValue(r3)
            goto L64
        L3c:
            r3 = r2
            goto L64
        L3e:
            int r0 = r6.getSource()
            r3 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r3
            if (r0 == 0) goto L62
            r0 = 26
            float r0 = r6.getAxisValue(r0)
            androidx.recyclerview.widget.RecyclerView$o r3 = r5.mLayout
            boolean r3 = r3.l()
            if (r3 == 0) goto L57
            float r0 = -r0
            goto L3c
        L57:
            androidx.recyclerview.widget.RecyclerView$o r3 = r5.mLayout
            boolean r3 = r3.k()
            if (r3 == 0) goto L62
            r3 = r0
            r0 = r2
            goto L64
        L62:
            r0 = r2
            r3 = r0
        L64:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L6c
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 == 0) goto L77
        L6c:
            float r2 = r5.mScaledHorizontalScrollFactor
            float r3 = r3 * r2
            int r2 = (int) r3
            float r3 = r5.mScaledVerticalScrollFactor
            float r0 = r0 * r3
            int r0 = (int) r0
            r5.scrollByInternal(r2, r0, r6)
        L77:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z4;
        if (this.mLayoutSuppressed) {
            return false;
        }
        this.mInterceptingOnItemTouchListener = null;
        if (findInterceptingOnItemTouchListener(motionEvent)) {
            cancelScroll();
            return true;
        }
        o oVar = this.mLayout;
        if (oVar == null) {
            return false;
        }
        boolean k4 = oVar.k();
        boolean l4 = this.mLayout.l();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.mIgnoreMotionEventTillDown) {
                this.mIgnoreMotionEventTillDown = false;
            }
            this.mScrollPointerId = motionEvent.getPointerId(0);
            int x4 = (int) (motionEvent.getX() + 0.5f);
            this.mLastTouchX = x4;
            this.mInitialTouchX = x4;
            int y4 = (int) (motionEvent.getY() + 0.5f);
            this.mLastTouchY = y4;
            this.mInitialTouchY = y4;
            if (this.mScrollState == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                stopNestedScroll(1);
            }
            int[] iArr = this.mNestedOffsets;
            iArr[1] = 0;
            iArr[0] = 0;
            int i4 = k4;
            if (l4) {
                i4 = (k4 ? 1 : 0) | 2;
            }
            startNestedScroll(i4, 0);
        } else if (actionMasked == 1) {
            this.mVelocityTracker.clear();
            stopNestedScroll(0);
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
            if (findPointerIndex < 0) {
                Log.e(TAG, "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x5 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y5 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            if (this.mScrollState != 1) {
                int i5 = x5 - this.mInitialTouchX;
                int i6 = y5 - this.mInitialTouchY;
                if (k4 == 0 || Math.abs(i5) <= this.mTouchSlop) {
                    z4 = false;
                } else {
                    this.mLastTouchX = x5;
                    z4 = true;
                }
                if (l4 && Math.abs(i6) > this.mTouchSlop) {
                    this.mLastTouchY = y5;
                    z4 = true;
                }
                if (z4) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            cancelScroll();
        } else if (actionMasked == 5) {
            this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
            int x6 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.mLastTouchX = x6;
            this.mInitialTouchX = x6;
            int y6 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.mLastTouchY = y6;
            this.mInitialTouchY = y6;
        } else if (actionMasked == 6) {
            onPointerUp(motionEvent);
        }
        return this.mScrollState == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        u.a.a(TRACE_ON_LAYOUT_TAG);
        dispatchLayout();
        u.a.b();
        this.mFirstLayoutComplete = true;
    }

    @Override // android.view.View
    protected void onMeasure(int i4, int i5) {
        o oVar = this.mLayout;
        if (oVar == null) {
            defaultOnMeasure(i4, i5);
            return;
        }
        boolean z4 = false;
        if (oVar.s0()) {
            int mode = View.MeasureSpec.getMode(i4);
            int mode2 = View.MeasureSpec.getMode(i5);
            this.mLayout.Z0(this.mRecycler, this.mState, i4, i5);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z4 = true;
            }
            if (z4 || this.mAdapter == null) {
                return;
            }
            if (this.mState.f1786e == 1) {
                dispatchLayoutStep1();
            }
            this.mLayout.A1(i4, i5);
            this.mState.f1791j = true;
            dispatchLayoutStep2();
            this.mLayout.D1(i4, i5);
            if (this.mLayout.G1()) {
                this.mLayout.A1(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                this.mState.f1791j = true;
                dispatchLayoutStep2();
                this.mLayout.D1(i4, i5);
                return;
            }
            return;
        }
        if (this.mHasFixedSize) {
            this.mLayout.Z0(this.mRecycler, this.mState, i4, i5);
            return;
        }
        if (this.mAdapterUpdateDuringMeasure) {
            startInterceptRequestLayout();
            onEnterLayoutOrScroll();
            processAdapterUpdatesAndSetAnimationFlags();
            onExitLayoutOrScroll();
            a0 a0Var = this.mState;
            if (a0Var.f1793l) {
                a0Var.f1789h = true;
            } else {
                this.mAdapterHelper.j();
                this.mState.f1789h = false;
            }
            this.mAdapterUpdateDuringMeasure = false;
            stopInterceptRequestLayout(false);
        } else if (this.mState.f1793l) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        g gVar = this.mAdapter;
        if (gVar != null) {
            this.mState.f1787f = gVar.c();
        } else {
            this.mState.f1787f = 0;
        }
        startInterceptRequestLayout();
        this.mLayout.Z0(this.mRecycler, this.mState, i4, i5);
        stopInterceptRequestLayout(false);
        this.mState.f1789h = false;
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i4, Rect rect) {
        if (isComputingLayout()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i4, rect);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof y)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        y yVar = (y) parcelable;
        this.mPendingSavedState = yVar;
        super.onRestoreInstanceState(yVar.f());
        o oVar = this.mLayout;
        if (oVar == null || (parcelable2 = this.mPendingSavedState.f1885d) == null) {
            return;
        }
        oVar.c1(parcelable2);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        y yVar = new y(super.onSaveInstanceState());
        y yVar2 = this.mPendingSavedState;
        if (yVar2 != null) {
            yVar.g(yVar2);
        } else {
            o oVar = this.mLayout;
            yVar.f1885d = oVar != null ? oVar.d1() : null;
        }
        return yVar;
    }

    public void onScrollStateChanged(int i4) {
    }

    public void onScrolled(int i4, int i5) {
    }

    @Override // android.view.View
    protected void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        if (i4 == i6 && i5 == i7) {
            return;
        }
        invalidateGlows();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00f4  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            Method dump skipped, instructions count: 476
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    void postAnimationRunner() {
        if (this.mPostedAnimatorRunner || !this.mIsAttached) {
            return;
        }
        y.p.T(this, this.mItemAnimatorRunner);
        this.mPostedAnimatorRunner = true;
    }

    void processDataSetCompletelyChanged(boolean z4) {
        this.mDispatchItemsChangedEvent = z4 | this.mDispatchItemsChangedEvent;
        this.mDataSetHasChangedAfterLayout = true;
        markKnownViewsInvalid();
    }

    void recordAnimationInfoIfBouncedHiddenView(d0 d0Var, l.c cVar) {
        d0Var.F(0, 8192);
        if (this.mState.f1790i && d0Var.y() && !d0Var.v() && !d0Var.J()) {
            this.mViewInfoStore.c(getChangedHolderKey(d0Var), d0Var);
        }
        this.mViewInfoStore.e(d0Var, cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeAndRecycleViews() {
        l lVar = this.mItemAnimator;
        if (lVar != null) {
            lVar.k();
        }
        o oVar = this.mLayout;
        if (oVar != null) {
            oVar.k1(this.mRecycler);
            this.mLayout.l1(this.mRecycler);
        }
        this.mRecycler.c();
    }

    boolean removeAnimatingView(View view) {
        startInterceptRequestLayout();
        boolean r4 = this.mChildHelper.r(view);
        if (r4) {
            d0 childViewHolderInt = getChildViewHolderInt(view);
            this.mRecycler.J(childViewHolderInt);
            this.mRecycler.C(childViewHolderInt);
        }
        stopInterceptRequestLayout(!r4);
        return r4;
    }

    @Override // android.view.ViewGroup
    protected void removeDetachedView(View view, boolean z4) {
        d0 childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            if (childViewHolderInt.x()) {
                childViewHolderInt.f();
            } else if (!childViewHolderInt.J()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + childViewHolderInt + exceptionLabel());
            }
        }
        view.clearAnimation();
        dispatchChildDetached(view);
        super.removeDetachedView(view, z4);
    }

    public void removeItemDecoration(n nVar) {
        o oVar = this.mLayout;
        if (oVar != null) {
            oVar.g("Cannot remove item decoration during a scroll  or layout");
        }
        this.mItemDecorations.remove(nVar);
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void removeItemDecorationAt(int i4) {
        int itemDecorationCount = getItemDecorationCount();
        if (i4 >= 0 && i4 < itemDecorationCount) {
            removeItemDecoration(getItemDecorationAt(i4));
            return;
        }
        throw new IndexOutOfBoundsException(i4 + " is an invalid index for size " + itemDecorationCount);
    }

    public void removeOnChildAttachStateChangeListener(q qVar) {
        List<q> list = this.mOnChildAttachStateListeners;
        if (list == null) {
            return;
        }
        list.remove(qVar);
    }

    public void removeOnItemTouchListener(s sVar) {
        this.mOnItemTouchListeners.remove(sVar);
        if (this.mInterceptingOnItemTouchListener == sVar) {
            this.mInterceptingOnItemTouchListener = null;
        }
    }

    public void removeOnScrollListener(t tVar) {
        List<t> list = this.mScrollListeners;
        if (list != null) {
            list.remove(tVar);
        }
    }

    void repositionShadowingViews() {
        d0 d0Var;
        int g4 = this.mChildHelper.g();
        for (int i4 = 0; i4 < g4; i4++) {
            View f4 = this.mChildHelper.f(i4);
            d0 childViewHolder = getChildViewHolder(f4);
            if (childViewHolder != null && (d0Var = childViewHolder.f1817i) != null) {
                View view = d0Var.f1809a;
                int left = f4.getLeft();
                int top = f4.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.mLayout.b1(this, this.mState, view, view2) && view2 != null) {
            requestChildOnScreen(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z4) {
        return this.mLayout.r1(this, view, rect, z4);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z4) {
        int size = this.mOnItemTouchListeners.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.mOnItemTouchListeners.get(i4).c(z4);
        }
        super.requestDisallowInterceptTouchEvent(z4);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mInterceptRequestLayoutDepth != 0 || this.mLayoutSuppressed) {
            this.mLayoutWasDefered = true;
        } else {
            super.requestLayout();
        }
    }

    void saveOldPositions() {
        int j4 = this.mChildHelper.j();
        for (int i4 = 0; i4 < j4; i4++) {
            d0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i4));
            if (!childViewHolderInt.J()) {
                childViewHolderInt.E();
            }
        }
    }

    @Override // android.view.View
    public void scrollBy(int i4, int i5) {
        o oVar = this.mLayout;
        if (oVar == null) {
            Log.e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.mLayoutSuppressed) {
            return;
        }
        boolean k4 = oVar.k();
        boolean l4 = this.mLayout.l();
        if (k4 || l4) {
            if (!k4) {
                i4 = 0;
            }
            if (!l4) {
                i5 = 0;
            }
            scrollByInternal(i4, i5, null);
        }
    }

    boolean scrollByInternal(int i4, int i5, MotionEvent motionEvent) {
        int i6;
        int i7;
        int i8;
        int i9;
        consumePendingUpdateOperations();
        if (this.mAdapter != null) {
            int[] iArr = this.mReusableIntPair;
            iArr[0] = 0;
            iArr[1] = 0;
            scrollStep(i4, i5, iArr);
            int[] iArr2 = this.mReusableIntPair;
            int i10 = iArr2[0];
            int i11 = iArr2[1];
            i6 = i11;
            i7 = i10;
            i8 = i4 - i10;
            i9 = i5 - i11;
        } else {
            i6 = 0;
            i7 = 0;
            i8 = 0;
            i9 = 0;
        }
        if (!this.mItemDecorations.isEmpty()) {
            invalidate();
        }
        int[] iArr3 = this.mReusableIntPair;
        iArr3[0] = 0;
        iArr3[1] = 0;
        dispatchNestedScroll(i7, i6, i8, i9, this.mScrollOffset, 0, iArr3);
        int[] iArr4 = this.mReusableIntPair;
        int i12 = i8 - iArr4[0];
        int i13 = i9 - iArr4[1];
        boolean z4 = (iArr4[0] == 0 && iArr4[1] == 0) ? false : true;
        int i14 = this.mLastTouchX;
        int[] iArr5 = this.mScrollOffset;
        this.mLastTouchX = i14 - iArr5[0];
        this.mLastTouchY -= iArr5[1];
        int[] iArr6 = this.mNestedOffsets;
        iArr6[0] = iArr6[0] + iArr5[0];
        iArr6[1] = iArr6[1] + iArr5[1];
        if (getOverScrollMode() != 2) {
            if (motionEvent != null && !y.h.a(motionEvent, 8194)) {
                pullGlows(motionEvent.getX(), i12, motionEvent.getY(), i13);
            }
            considerReleasingGlowsOnScroll(i4, i5);
        }
        if (i7 != 0 || i6 != 0) {
            dispatchOnScrolled(i7, i6);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (!z4 && i7 == 0 && i6 == 0) ? false : true;
    }

    void scrollStep(int i4, int i5, int[] iArr) {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        u.a.a(TRACE_SCROLL_TAG);
        fillRemainingScrollValues(this.mState);
        int w12 = i4 != 0 ? this.mLayout.w1(i4, this.mRecycler, this.mState) : 0;
        int y12 = i5 != 0 ? this.mLayout.y1(i5, this.mRecycler, this.mState) : 0;
        u.a.b();
        repositionShadowingViews();
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        if (iArr != null) {
            iArr[0] = w12;
            iArr[1] = y12;
        }
    }

    @Override // android.view.View
    public void scrollTo(int i4, int i5) {
        Log.w(TAG, "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void scrollToPosition(int i4) {
        if (this.mLayoutSuppressed) {
            return;
        }
        stopScroll();
        o oVar = this.mLayout;
        if (oVar == null) {
            Log.e(TAG, "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            oVar.x1(i4);
            awakenScrollBars();
        }
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (shouldDeferAccessibilityEvent(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public void setAccessibilityDelegateCompat(androidx.recyclerview.widget.k kVar) {
        this.mAccessibilityDelegate = kVar;
        y.p.a0(this, kVar);
    }

    public void setAdapter(g gVar) {
        setLayoutFrozen(false);
        setAdapterInternal(gVar, false, true);
        processDataSetCompletelyChanged(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(j jVar) {
        if (jVar == this.mChildDrawingOrderCallback) {
            return;
        }
        this.mChildDrawingOrderCallback = jVar;
        setChildrenDrawingOrderEnabled(jVar != null);
    }

    boolean setChildImportantForAccessibilityInternal(d0 d0Var, int i4) {
        if (!isComputingLayout()) {
            y.p.j0(d0Var.f1809a, i4);
            return true;
        }
        d0Var.f1825q = i4;
        this.mPendingAccessibilityImportanceChange.add(d0Var);
        return false;
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z4) {
        if (z4 != this.mClipToPadding) {
            invalidateGlows();
        }
        this.mClipToPadding = z4;
        super.setClipToPadding(z4);
        if (this.mFirstLayoutComplete) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(k kVar) {
        x.h.c(kVar);
        this.mEdgeEffectFactory = kVar;
        invalidateGlows();
    }

    public void setHasFixedSize(boolean z4) {
        this.mHasFixedSize = z4;
    }

    public void setItemAnimator(l lVar) {
        l lVar2 = this.mItemAnimator;
        if (lVar2 != null) {
            lVar2.k();
            this.mItemAnimator.v(null);
        }
        this.mItemAnimator = lVar;
        if (lVar != null) {
            lVar.v(this.mItemAnimatorListener);
        }
    }

    public void setItemViewCacheSize(int i4) {
        this.mRecycler.G(i4);
    }

    @Deprecated
    public void setLayoutFrozen(boolean z4) {
        suppressLayout(z4);
    }

    public void setLayoutManager(o oVar) {
        if (oVar == this.mLayout) {
            return;
        }
        stopScroll();
        if (this.mLayout != null) {
            l lVar = this.mItemAnimator;
            if (lVar != null) {
                lVar.k();
            }
            this.mLayout.k1(this.mRecycler);
            this.mLayout.l1(this.mRecycler);
            this.mRecycler.c();
            if (this.mIsAttached) {
                this.mLayout.A(this, this.mRecycler);
            }
            this.mLayout.E1(null);
            this.mLayout = null;
        } else {
            this.mRecycler.c();
        }
        this.mChildHelper.o();
        this.mLayout = oVar;
        if (oVar != null) {
            if (oVar.f1843b != null) {
                throw new IllegalArgumentException("LayoutManager " + oVar + " is already attached to a RecyclerView:" + oVar.f1843b.exceptionLabel());
            }
            oVar.E1(this);
            if (this.mIsAttached) {
                this.mLayout.z(this);
            }
        }
        this.mRecycler.K();
        requestLayout();
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition != null) {
            throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
        }
        super.setLayoutTransition(null);
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z4) {
        getScrollingChildHelper().n(z4);
    }

    public void setOnFlingListener(r rVar) {
        this.mOnFlingListener = rVar;
    }

    @Deprecated
    public void setOnScrollListener(t tVar) {
        this.mScrollListener = tVar;
    }

    public void setPreserveFocusAfterLayout(boolean z4) {
        this.mPreserveFocusAfterLayout = z4;
    }

    public void setRecycledViewPool(u uVar) {
        this.mRecycler.E(uVar);
    }

    public void setRecyclerListener(w wVar) {
        this.mRecyclerListener = wVar;
    }

    void setScrollState(int i4) {
        if (i4 == this.mScrollState) {
            return;
        }
        this.mScrollState = i4;
        if (i4 != 2) {
            stopScrollersInternal();
        }
        dispatchOnScrollStateChanged(i4);
    }

    public void setScrollingTouchSlop(int i4) {
        int scaledTouchSlop;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i4 != 0) {
            if (i4 == 1) {
                scaledTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
                this.mTouchSlop = scaledTouchSlop;
            } else {
                Log.w(TAG, "setScrollingTouchSlop(): bad argument constant " + i4 + "; using default value");
            }
        }
        scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mTouchSlop = scaledTouchSlop;
    }

    public void setViewCacheExtension(b0 b0Var) {
        this.mRecycler.F(b0Var);
    }

    boolean shouldDeferAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (!isComputingLayout()) {
            return false;
        }
        int a5 = accessibilityEvent != null ? z.b.a(accessibilityEvent) : 0;
        this.mEatenAccessibilityChangeFlags |= a5 != 0 ? a5 : 0;
        return true;
    }

    public void smoothScrollBy(int i4, int i5) {
        smoothScrollBy(i4, i5, null);
    }

    public void smoothScrollBy(int i4, int i5, Interpolator interpolator) {
        smoothScrollBy(i4, i5, interpolator, UNDEFINED_DURATION);
    }

    public void smoothScrollBy(int i4, int i5, Interpolator interpolator, int i6) {
        smoothScrollBy(i4, i5, interpolator, i6, false);
    }

    void smoothScrollBy(int i4, int i5, Interpolator interpolator, int i6, boolean z4) {
        o oVar = this.mLayout;
        if (oVar == null) {
            Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.mLayoutSuppressed) {
            return;
        }
        if (!oVar.k()) {
            i4 = 0;
        }
        if (!this.mLayout.l()) {
            i5 = 0;
        }
        if (i4 == 0 && i5 == 0) {
            return;
        }
        if (!(i6 == Integer.MIN_VALUE || i6 > 0)) {
            scrollBy(i4, i5);
            return;
        }
        if (z4) {
            int i7 = i4 != 0 ? 1 : 0;
            if (i5 != 0) {
                i7 |= 2;
            }
            startNestedScroll(i7, 1);
        }
        this.mViewFlinger.f(i4, i5, i6, interpolator);
    }

    public void smoothScrollToPosition(int i4) {
        if (this.mLayoutSuppressed) {
            return;
        }
        o oVar = this.mLayout;
        if (oVar == null) {
            Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            oVar.I1(this, this.mState, i4);
        }
    }

    void startInterceptRequestLayout() {
        int i4 = this.mInterceptRequestLayoutDepth + 1;
        this.mInterceptRequestLayoutDepth = i4;
        if (i4 != 1 || this.mLayoutSuppressed) {
            return;
        }
        this.mLayoutWasDefered = false;
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i4) {
        return getScrollingChildHelper().p(i4);
    }

    public boolean startNestedScroll(int i4, int i5) {
        return getScrollingChildHelper().q(i4, i5);
    }

    void stopInterceptRequestLayout(boolean z4) {
        if (this.mInterceptRequestLayoutDepth < 1) {
            this.mInterceptRequestLayoutDepth = 1;
        }
        if (!z4 && !this.mLayoutSuppressed) {
            this.mLayoutWasDefered = false;
        }
        if (this.mInterceptRequestLayoutDepth == 1) {
            if (z4 && this.mLayoutWasDefered && !this.mLayoutSuppressed && this.mLayout != null && this.mAdapter != null) {
                dispatchLayout();
            }
            if (!this.mLayoutSuppressed) {
                this.mLayoutWasDefered = false;
            }
        }
        this.mInterceptRequestLayoutDepth--;
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        getScrollingChildHelper().r();
    }

    public void stopNestedScroll(int i4) {
        getScrollingChildHelper().s(i4);
    }

    public void stopScroll() {
        setScrollState(0);
        stopScrollersInternal();
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z4) {
        if (z4 != this.mLayoutSuppressed) {
            assertNotInLayoutOrScroll("Do not suppressLayout in layout or scroll");
            if (z4) {
                long uptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                this.mLayoutSuppressed = true;
                this.mIgnoreMotionEventTillDown = true;
                stopScroll();
                return;
            }
            this.mLayoutSuppressed = false;
            if (this.mLayoutWasDefered && this.mLayout != null && this.mAdapter != null) {
                requestLayout();
            }
            this.mLayoutWasDefered = false;
        }
    }

    public void swapAdapter(g gVar, boolean z4) {
        setLayoutFrozen(false);
        setAdapterInternal(gVar, true, z4);
        processDataSetCompletelyChanged(true);
        requestLayout();
    }

    void viewRangeUpdate(int i4, int i5, Object obj) {
        int i6;
        int j4 = this.mChildHelper.j();
        int i7 = i4 + i5;
        for (int i8 = 0; i8 < j4; i8++) {
            View i9 = this.mChildHelper.i(i8);
            d0 childViewHolderInt = getChildViewHolderInt(i9);
            if (childViewHolderInt != null && !childViewHolderInt.J() && (i6 = childViewHolderInt.f1811c) >= i4 && i6 < i7) {
                childViewHolderInt.b(2);
                childViewHolderInt.a(obj);
                ((p) i9.getLayoutParams()).f1868c = true;
            }
        }
        this.mRecycler.M(i4, i5);
    }
}
