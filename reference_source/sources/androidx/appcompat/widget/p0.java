package androidx.appcompat.widget;

import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.i0;

/* loaded from: classes.dex */
public class p0 extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {

    /* renamed from: k, reason: collision with root package name */
    private static final Interpolator f1115k = new DecelerateInterpolator();

    /* renamed from: b, reason: collision with root package name */
    Runnable f1116b;

    /* renamed from: c, reason: collision with root package name */
    private c f1117c;

    /* renamed from: d, reason: collision with root package name */
    i0 f1118d;

    /* renamed from: e, reason: collision with root package name */
    private Spinner f1119e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f1120f;

    /* renamed from: g, reason: collision with root package name */
    int f1121g;

    /* renamed from: h, reason: collision with root package name */
    int f1122h;

    /* renamed from: i, reason: collision with root package name */
    private int f1123i;

    /* renamed from: j, reason: collision with root package name */
    private int f1124j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f1125b;

        a(View view) {
            this.f1125b = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            p0.this.smoothScrollTo(this.f1125b.getLeft() - ((p0.this.getWidth() - this.f1125b.getWidth()) / 2), 0);
            p0.this.f1116b = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BaseAdapter {
        b() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return p0.this.f1118d.getChildCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i4) {
            return ((d) p0.this.f1118d.getChildAt(i4)).b();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i4) {
            return i4;
        }

        @Override // android.widget.Adapter
        public View getView(int i4, View view, ViewGroup viewGroup) {
            if (view == null) {
                return p0.this.c((a.c) getItem(i4), true);
            }
            ((d) view).a((a.c) getItem(i4));
            return view;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((d) view).b().e();
            int childCount = p0.this.f1118d.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = p0.this.f1118d.getChildAt(i4);
                childAt.setSelected(childAt == view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d extends LinearLayout {

        /* renamed from: b, reason: collision with root package name */
        private final int[] f1129b;

        /* renamed from: c, reason: collision with root package name */
        private a.c f1130c;

        /* renamed from: d, reason: collision with root package name */
        private TextView f1131d;

        /* renamed from: e, reason: collision with root package name */
        private ImageView f1132e;

        /* renamed from: f, reason: collision with root package name */
        private View f1133f;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public d(android.content.Context r6, androidx.appcompat.app.a.c r7, boolean r8) {
            /*
                r4 = this;
                androidx.appcompat.widget.p0.this = r5
                int r5 = a.a.f3d
                r0 = 0
                r4.<init>(r6, r0, r5)
                r1 = 1
                int[] r1 = new int[r1]
                r2 = 16842964(0x10100d4, float:2.3694152E-38)
                r3 = 0
                r1[r3] = r2
                r4.f1129b = r1
                r4.f1130c = r7
                androidx.appcompat.widget.w0 r5 = androidx.appcompat.widget.w0.u(r6, r0, r1, r5, r3)
                boolean r6 = r5.r(r3)
                if (r6 == 0) goto L26
                android.graphics.drawable.Drawable r6 = r5.g(r3)
                r4.setBackgroundDrawable(r6)
            L26:
                r5.v()
                if (r8 == 0) goto L31
                r5 = 8388627(0x800013, float:1.175497E-38)
                r4.setGravity(r5)
            L31:
                r4.c()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.p0.d.<init>(androidx.appcompat.widget.p0, android.content.Context, androidx.appcompat.app.a$c, boolean):void");
        }

        public void a(a.c cVar) {
            this.f1130c = cVar;
            c();
        }

        public a.c b() {
            return this.f1130c;
        }

        public void c() {
            a.c cVar = this.f1130c;
            View b5 = cVar.b();
            if (b5 != null) {
                ViewParent parent = b5.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(b5);
                    }
                    addView(b5);
                }
                this.f1133f = b5;
                TextView textView = this.f1131d;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f1132e;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f1132e.setImageDrawable(null);
                    return;
                }
                return;
            }
            View view = this.f1133f;
            if (view != null) {
                removeView(view);
                this.f1133f = null;
            }
            Drawable c5 = cVar.c();
            CharSequence d5 = cVar.d();
            if (c5 != null) {
                if (this.f1132e == null) {
                    o oVar = new o(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    oVar.setLayoutParams(layoutParams);
                    addView(oVar, 0);
                    this.f1132e = oVar;
                }
                this.f1132e.setImageDrawable(c5);
                this.f1132e.setVisibility(0);
            } else {
                ImageView imageView2 = this.f1132e;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.f1132e.setImageDrawable(null);
                }
            }
            boolean z4 = !TextUtils.isEmpty(d5);
            if (z4) {
                if (this.f1131d == null) {
                    z zVar = new z(getContext(), null, a.a.f4e);
                    zVar.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    zVar.setLayoutParams(layoutParams2);
                    addView(zVar);
                    this.f1131d = zVar;
                }
                this.f1131d.setText(d5);
                this.f1131d.setVisibility(0);
            } else {
                TextView textView2 = this.f1131d;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.f1131d.setText((CharSequence) null);
                }
            }
            ImageView imageView3 = this.f1132e;
            if (imageView3 != null) {
                imageView3.setContentDescription(cVar.a());
            }
            y0.a(this, z4 ? null : cVar.a());
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i4, int i5) {
            super.onMeasure(i4, i5);
            if (p0.this.f1121g > 0) {
                int measuredWidth = getMeasuredWidth();
                int i6 = p0.this.f1121g;
                if (measuredWidth > i6) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i6, 1073741824), i5);
                }
            }
        }

        @Override // android.view.View
        public void setSelected(boolean z4) {
            boolean z5 = isSelected() != z4;
            super.setSelected(z4);
            if (z5 && z4) {
                sendAccessibilityEvent(4);
            }
        }
    }

    private Spinner b() {
        w wVar = new w(getContext(), null, a.a.f7h);
        wVar.setLayoutParams(new i0.a(-2, -1));
        wVar.setOnItemSelectedListener(this);
        return wVar;
    }

    private boolean d() {
        Spinner spinner = this.f1119e;
        return spinner != null && spinner.getParent() == this;
    }

    private void e() {
        if (d()) {
            return;
        }
        if (this.f1119e == null) {
            this.f1119e = b();
        }
        removeView(this.f1118d);
        addView(this.f1119e, new ViewGroup.LayoutParams(-2, -1));
        if (this.f1119e.getAdapter() == null) {
            this.f1119e.setAdapter((SpinnerAdapter) new b());
        }
        Runnable runnable = this.f1116b;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.f1116b = null;
        }
        this.f1119e.setSelection(this.f1124j);
    }

    private boolean f() {
        if (!d()) {
            return false;
        }
        removeView(this.f1119e);
        addView(this.f1118d, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.f1119e.getSelectedItemPosition());
        return false;
    }

    public void a(int i4) {
        View childAt = this.f1118d.getChildAt(i4);
        Runnable runnable = this.f1116b;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        a aVar = new a(childAt);
        this.f1116b = aVar;
        post(aVar);
    }

    d c(a.c cVar, boolean z4) {
        d dVar = new d(this, getContext(), cVar, z4);
        if (z4) {
            dVar.setBackgroundDrawable(null);
            dVar.setLayoutParams(new AbsListView.LayoutParams(-1, this.f1123i));
        } else {
            dVar.setFocusable(true);
            if (this.f1117c == null) {
                this.f1117c = new c();
            }
            dVar.setOnClickListener(this.f1117c);
        }
        return dVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f1116b;
        if (runnable != null) {
            post(runnable);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        f.a b5 = f.a.b(getContext());
        setContentHeight(b5.f());
        this.f1122h = b5.e();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f1116b;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i4, long j4) {
        ((d) view).b().e();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i4, int i5) {
        int i6;
        int mode = View.MeasureSpec.getMode(i4);
        boolean z4 = mode == 1073741824;
        setFillViewport(z4);
        int childCount = this.f1118d.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            i6 = -1;
        } else {
            if (childCount > 2) {
                this.f1121g = (int) (View.MeasureSpec.getSize(i4) * 0.4f);
            } else {
                this.f1121g = View.MeasureSpec.getSize(i4) / 2;
            }
            i6 = Math.min(this.f1121g, this.f1122h);
        }
        this.f1121g = i6;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f1123i, 1073741824);
        if (!z4 && this.f1120f) {
            this.f1118d.measure(0, makeMeasureSpec);
            if (this.f1118d.getMeasuredWidth() > View.MeasureSpec.getSize(i4)) {
                e();
                int measuredWidth = getMeasuredWidth();
                super.onMeasure(i4, makeMeasureSpec);
                int measuredWidth2 = getMeasuredWidth();
                if (z4 || measuredWidth == measuredWidth2) {
                }
                setTabSelected(this.f1124j);
                return;
            }
        }
        f();
        int measuredWidth3 = getMeasuredWidth();
        super.onMeasure(i4, makeMeasureSpec);
        int measuredWidth22 = getMeasuredWidth();
        if (z4) {
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setAllowCollapse(boolean z4) {
        this.f1120f = z4;
    }

    public void setContentHeight(int i4) {
        this.f1123i = i4;
        requestLayout();
    }

    public void setTabSelected(int i4) {
        this.f1124j = i4;
        int childCount = this.f1118d.getChildCount();
        int i5 = 0;
        while (i5 < childCount) {
            View childAt = this.f1118d.getChildAt(i5);
            boolean z4 = i5 == i4;
            childAt.setSelected(z4);
            if (z4) {
                a(i4);
            }
            i5++;
        }
        Spinner spinner = this.f1119e;
        if (spinner == null || i4 < 0) {
            return;
        }
        spinner.setSelection(i4);
    }
}
