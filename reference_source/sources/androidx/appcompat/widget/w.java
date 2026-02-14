package androidx.appcompat.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.app.b;

/* loaded from: classes.dex */
public class w extends Spinner {

    /* renamed from: j, reason: collision with root package name */
    private static final int[] f1189j = {R.attr.spinnerMode};

    /* renamed from: b, reason: collision with root package name */
    private final androidx.appcompat.widget.e f1190b;

    /* renamed from: c, reason: collision with root package name */
    private final Context f1191c;

    /* renamed from: d, reason: collision with root package name */
    private h0 f1192d;

    /* renamed from: e, reason: collision with root package name */
    private SpinnerAdapter f1193e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f1194f;

    /* renamed from: g, reason: collision with root package name */
    private g f1195g;

    /* renamed from: h, reason: collision with root package name */
    int f1196h;

    /* renamed from: i, reason: collision with root package name */
    final Rect f1197i;

    /* loaded from: classes.dex */
    class a extends h0 {

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ e f1198k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(View view, e eVar) {
            super(view);
            this.f1198k = eVar;
        }

        @Override // androidx.appcompat.widget.h0
        public g.e b() {
            return this.f1198k;
        }

        @Override // androidx.appcompat.widget.h0
        @SuppressLint({"SyntheticAccessor"})
        public boolean c() {
            if (w.this.getInternalPopup().b()) {
                return true;
            }
            w.this.b();
            return true;
        }
    }

    /* loaded from: classes.dex */
    class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!w.this.getInternalPopup().b()) {
                w.this.b();
            }
            ViewTreeObserver viewTreeObserver = w.this.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
        }
    }

    /* loaded from: classes.dex */
    class c implements g, DialogInterface.OnClickListener {

        /* renamed from: b, reason: collision with root package name */
        androidx.appcompat.app.b f1201b;

        /* renamed from: c, reason: collision with root package name */
        private ListAdapter f1202c;

        /* renamed from: d, reason: collision with root package name */
        private CharSequence f1203d;

        c() {
        }

        @Override // androidx.appcompat.widget.w.g
        public boolean b() {
            androidx.appcompat.app.b bVar = this.f1201b;
            if (bVar != null) {
                return bVar.isShowing();
            }
            return false;
        }

        @Override // androidx.appcompat.widget.w.g
        public void c(Drawable drawable) {
            Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.w.g
        public void d(int i4) {
            Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.w.g
        public void dismiss() {
            androidx.appcompat.app.b bVar = this.f1201b;
            if (bVar != null) {
                bVar.dismiss();
                this.f1201b = null;
            }
        }

        @Override // androidx.appcompat.widget.w.g
        public int e() {
            return 0;
        }

        @Override // androidx.appcompat.widget.w.g
        public void f(int i4, int i5) {
            if (this.f1202c == null) {
                return;
            }
            b.a aVar = new b.a(w.this.getPopupContext());
            CharSequence charSequence = this.f1203d;
            if (charSequence != null) {
                aVar.n(charSequence);
            }
            androidx.appcompat.app.b a5 = aVar.l(this.f1202c, w.this.getSelectedItemPosition(), this).a();
            this.f1201b = a5;
            ListView g4 = a5.g();
            g4.setTextDirection(i4);
            g4.setTextAlignment(i5);
            this.f1201b.show();
        }

        @Override // androidx.appcompat.widget.w.g
        public int g() {
            return 0;
        }

        @Override // androidx.appcompat.widget.w.g
        public Drawable i() {
            return null;
        }

        @Override // androidx.appcompat.widget.w.g
        public CharSequence j() {
            return this.f1203d;
        }

        @Override // androidx.appcompat.widget.w.g
        public void l(CharSequence charSequence) {
            this.f1203d = charSequence;
        }

        @Override // androidx.appcompat.widget.w.g
        public void m(int i4) {
            Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.w.g
        public void n(ListAdapter listAdapter) {
            this.f1202c = listAdapter;
        }

        @Override // androidx.appcompat.widget.w.g
        public void o(int i4) {
            Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i4) {
            w.this.setSelection(i4);
            if (w.this.getOnItemClickListener() != null) {
                w.this.performItemClick(null, i4, this.f1202c.getItemId(i4));
            }
            dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d implements ListAdapter, SpinnerAdapter {

        /* renamed from: b, reason: collision with root package name */
        private SpinnerAdapter f1205b;

        /* renamed from: c, reason: collision with root package name */
        private ListAdapter f1206c;

        public d(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.f1205b = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f1206c = (ListAdapter) spinnerAdapter;
            }
            if (theme != null) {
                if (spinnerAdapter instanceof ThemedSpinnerAdapter) {
                    ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                    if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                        themedSpinnerAdapter.setDropDownViewTheme(theme);
                        return;
                    }
                    return;
                }
                if (spinnerAdapter instanceof s0) {
                    s0 s0Var = (s0) spinnerAdapter;
                    if (s0Var.getDropDownViewTheme() == null) {
                        s0Var.setDropDownViewTheme(theme);
                    }
                }
            }
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f1206c;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.f1205b;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        @Override // android.widget.SpinnerAdapter
        public View getDropDownView(int i4, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f1205b;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i4, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public Object getItem(int i4) {
            SpinnerAdapter spinnerAdapter = this.f1205b;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i4);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i4) {
            SpinnerAdapter spinnerAdapter = this.f1205b;
            if (spinnerAdapter == null) {
                return -1L;
            }
            return spinnerAdapter.getItemId(i4);
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int i4) {
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i4, View view, ViewGroup viewGroup) {
            return getDropDownView(i4, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.f1205b;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            return getCount() == 0;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i4) {
            ListAdapter listAdapter = this.f1206c;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i4);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f1205b;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f1205b;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    /* loaded from: classes.dex */
    class e extends j0 implements g {
        private CharSequence K;
        ListAdapter L;
        private final Rect M;
        private int N;

        /* loaded from: classes.dex */
        class a implements AdapterView.OnItemClickListener {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ w f1207b;

            a(w wVar) {
                this.f1207b = wVar;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i4, long j4) {
                w.this.setSelection(i4);
                if (w.this.getOnItemClickListener() != null) {
                    e eVar = e.this;
                    w.this.performItemClick(view, i4, eVar.L.getItemId(i4));
                }
                e.this.dismiss();
            }
        }

        /* loaded from: classes.dex */
        class b implements ViewTreeObserver.OnGlobalLayoutListener {
            b() {
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                e eVar = e.this;
                if (!eVar.T(w.this)) {
                    e.this.dismiss();
                } else {
                    e.this.R();
                    e.super.show();
                }
            }
        }

        /* loaded from: classes.dex */
        class c implements PopupWindow.OnDismissListener {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f1210b;

            c(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
                this.f1210b = onGlobalLayoutListener;
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                ViewTreeObserver viewTreeObserver = w.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this.f1210b);
                }
            }
        }

        public e(Context context, AttributeSet attributeSet, int i4) {
            super(context, attributeSet, i4);
            this.M = new Rect();
            C(w.this);
            I(true);
            N(0);
            K(new a(w.this));
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x008d  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x009a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        void R() {
            /*
                r8 = this;
                android.graphics.drawable.Drawable r0 = r8.i()
                r1 = 0
                if (r0 == 0) goto L26
                androidx.appcompat.widget.w r1 = androidx.appcompat.widget.w.this
                android.graphics.Rect r1 = r1.f1197i
                r0.getPadding(r1)
                androidx.appcompat.widget.w r0 = androidx.appcompat.widget.w.this
                boolean r0 = androidx.appcompat.widget.c1.b(r0)
                if (r0 == 0) goto L1d
                androidx.appcompat.widget.w r0 = androidx.appcompat.widget.w.this
                android.graphics.Rect r0 = r0.f1197i
                int r0 = r0.right
                goto L24
            L1d:
                androidx.appcompat.widget.w r0 = androidx.appcompat.widget.w.this
                android.graphics.Rect r0 = r0.f1197i
                int r0 = r0.left
                int r0 = -r0
            L24:
                r1 = r0
                goto L2e
            L26:
                androidx.appcompat.widget.w r0 = androidx.appcompat.widget.w.this
                android.graphics.Rect r0 = r0.f1197i
                r0.right = r1
                r0.left = r1
            L2e:
                androidx.appcompat.widget.w r0 = androidx.appcompat.widget.w.this
                int r0 = r0.getPaddingLeft()
                androidx.appcompat.widget.w r2 = androidx.appcompat.widget.w.this
                int r2 = r2.getPaddingRight()
                androidx.appcompat.widget.w r3 = androidx.appcompat.widget.w.this
                int r3 = r3.getWidth()
                androidx.appcompat.widget.w r4 = androidx.appcompat.widget.w.this
                int r5 = r4.f1196h
                r6 = -2
                if (r5 != r6) goto L78
                android.widget.ListAdapter r5 = r8.L
                android.widget.SpinnerAdapter r5 = (android.widget.SpinnerAdapter) r5
                android.graphics.drawable.Drawable r6 = r8.i()
                int r4 = r4.a(r5, r6)
                androidx.appcompat.widget.w r5 = androidx.appcompat.widget.w.this
                android.content.Context r5 = r5.getContext()
                android.content.res.Resources r5 = r5.getResources()
                android.util.DisplayMetrics r5 = r5.getDisplayMetrics()
                int r5 = r5.widthPixels
                androidx.appcompat.widget.w r6 = androidx.appcompat.widget.w.this
                android.graphics.Rect r6 = r6.f1197i
                int r7 = r6.left
                int r5 = r5 - r7
                int r6 = r6.right
                int r5 = r5 - r6
                if (r4 <= r5) goto L70
                r4 = r5
            L70:
                int r5 = r3 - r0
                int r5 = r5 - r2
                int r4 = java.lang.Math.max(r4, r5)
                goto L7e
            L78:
                r4 = -1
                if (r5 != r4) goto L82
                int r4 = r3 - r0
                int r4 = r4 - r2
            L7e:
                r8.E(r4)
                goto L85
            L82:
                r8.E(r5)
            L85:
                androidx.appcompat.widget.w r4 = androidx.appcompat.widget.w.this
                boolean r4 = androidx.appcompat.widget.c1.b(r4)
                if (r4 == 0) goto L9a
                int r3 = r3 - r2
                int r0 = r8.y()
                int r3 = r3 - r0
                int r0 = r8.S()
                int r3 = r3 - r0
                int r1 = r1 + r3
                goto La0
            L9a:
                int r2 = r8.S()
                int r0 = r0 + r2
                int r1 = r1 + r0
            La0:
                r8.d(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.w.e.R():void");
        }

        public int S() {
            return this.N;
        }

        boolean T(View view) {
            return y.p.G(view) && view.getGlobalVisibleRect(this.M);
        }

        @Override // androidx.appcompat.widget.w.g
        public void f(int i4, int i5) {
            ViewTreeObserver viewTreeObserver;
            boolean b5 = b();
            R();
            H(2);
            super.show();
            ListView k4 = k();
            k4.setChoiceMode(1);
            k4.setTextDirection(i4);
            k4.setTextAlignment(i5);
            O(w.this.getSelectedItemPosition());
            if (b5 || (viewTreeObserver = w.this.getViewTreeObserver()) == null) {
                return;
            }
            b bVar = new b();
            viewTreeObserver.addOnGlobalLayoutListener(bVar);
            J(new c(bVar));
        }

        @Override // androidx.appcompat.widget.w.g
        public CharSequence j() {
            return this.K;
        }

        @Override // androidx.appcompat.widget.w.g
        public void l(CharSequence charSequence) {
            this.K = charSequence;
        }

        @Override // androidx.appcompat.widget.j0, androidx.appcompat.widget.w.g
        public void n(ListAdapter listAdapter) {
            super.n(listAdapter);
            this.L = listAdapter;
        }

        @Override // androidx.appcompat.widget.w.g
        public void o(int i4) {
            this.N = i4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class f extends View.BaseSavedState {
        public static final Parcelable.Creator<f> CREATOR = new a();

        /* renamed from: b, reason: collision with root package name */
        boolean f1212b;

        /* loaded from: classes.dex */
        static class a implements Parcelable.Creator<f> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public f createFromParcel(Parcel parcel) {
                return new f(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public f[] newArray(int i4) {
                return new f[i4];
            }
        }

        f(Parcel parcel) {
            super(parcel);
            this.f1212b = parcel.readByte() != 0;
        }

        f(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeByte(this.f1212b ? (byte) 1 : (byte) 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface g {
        boolean b();

        void c(Drawable drawable);

        void d(int i4);

        void dismiss();

        int e();

        void f(int i4, int i5);

        int g();

        Drawable i();

        CharSequence j();

        void l(CharSequence charSequence);

        void m(int i4);

        void n(ListAdapter listAdapter);

        void o(int i4);
    }

    public w(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.a.J);
    }

    public w(Context context, AttributeSet attributeSet, int i4) {
        this(context, attributeSet, i4, -1);
    }

    public w(Context context, AttributeSet attributeSet, int i4, int i5) {
        this(context, attributeSet, i4, i5, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0057, code lost:
    
        if (r11 == null) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0036 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public w(android.content.Context r7, android.util.AttributeSet r8, int r9, int r10, android.content.res.Resources.Theme r11) {
        /*
            r6 = this;
            r6.<init>(r7, r8, r9)
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r6.f1197i = r0
            int[] r0 = a.j.A2
            r1 = 0
            androidx.appcompat.widget.w0 r0 = androidx.appcompat.widget.w0.u(r7, r8, r0, r9, r1)
            androidx.appcompat.widget.e r2 = new androidx.appcompat.widget.e
            r2.<init>(r6)
            r6.f1190b = r2
            if (r11 == 0) goto L22
            f.d r2 = new f.d
            r2.<init>(r7, r11)
        L1f:
            r6.f1191c = r2
            goto L32
        L22:
            int r11 = a.j.F2
            int r11 = r0.n(r11, r1)
            if (r11 == 0) goto L30
            f.d r2 = new f.d
            r2.<init>(r7, r11)
            goto L1f
        L30:
            r6.f1191c = r7
        L32:
            r11 = -1
            r2 = 0
            if (r10 != r11) goto L62
            int[] r11 = androidx.appcompat.widget.w.f1189j     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4e
            android.content.res.TypedArray r11 = r7.obtainStyledAttributes(r8, r11, r9, r1)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4e
            boolean r3 = r11.hasValue(r1)     // Catch: java.lang.Exception -> L4a java.lang.Throwable -> L5a
            if (r3 == 0) goto L46
            int r10 = r11.getInt(r1, r1)     // Catch: java.lang.Exception -> L4a java.lang.Throwable -> L5a
        L46:
            r11.recycle()
            goto L62
        L4a:
            r3 = move-exception
            goto L50
        L4c:
            r7 = move-exception
            goto L5c
        L4e:
            r3 = move-exception
            r11 = r2
        L50:
            java.lang.String r4 = "AppCompatSpinner"
            java.lang.String r5 = "Could not read android:spinnerMode"
            android.util.Log.i(r4, r5, r3)     // Catch: java.lang.Throwable -> L5a
            if (r11 == 0) goto L62
            goto L46
        L5a:
            r7 = move-exception
            r2 = r11
        L5c:
            if (r2 == 0) goto L61
            r2.recycle()
        L61:
            throw r7
        L62:
            r11 = 1
            if (r10 == 0) goto L9f
            if (r10 == r11) goto L68
            goto Laf
        L68:
            androidx.appcompat.widget.w$e r10 = new androidx.appcompat.widget.w$e
            android.content.Context r3 = r6.f1191c
            r10.<init>(r3, r8, r9)
            android.content.Context r3 = r6.f1191c
            int[] r4 = a.j.A2
            androidx.appcompat.widget.w0 r1 = androidx.appcompat.widget.w0.u(r3, r8, r4, r9, r1)
            int r3 = a.j.E2
            r4 = -2
            int r3 = r1.m(r3, r4)
            r6.f1196h = r3
            int r3 = a.j.C2
            android.graphics.drawable.Drawable r3 = r1.g(r3)
            r10.c(r3)
            int r3 = a.j.D2
            java.lang.String r3 = r0.o(r3)
            r10.l(r3)
            r1.v()
            r6.f1195g = r10
            androidx.appcompat.widget.w$a r1 = new androidx.appcompat.widget.w$a
            r1.<init>(r6, r10)
            r6.f1192d = r1
            goto Laf
        L9f:
            androidx.appcompat.widget.w$c r10 = new androidx.appcompat.widget.w$c
            r10.<init>()
            r6.f1195g = r10
            int r1 = a.j.D2
            java.lang.String r1 = r0.o(r1)
            r10.l(r1)
        Laf:
            int r10 = a.j.B2
            java.lang.CharSequence[] r10 = r0.q(r10)
            if (r10 == 0) goto Lc7
            android.widget.ArrayAdapter r1 = new android.widget.ArrayAdapter
            r3 = 17367048(0x1090008, float:2.5162948E-38)
            r1.<init>(r7, r3, r10)
            int r7 = a.g.f117t
            r1.setDropDownViewResource(r7)
            r6.setAdapter(r1)
        Lc7:
            r0.v()
            r6.f1194f = r11
            android.widget.SpinnerAdapter r7 = r6.f1193e
            if (r7 == 0) goto Ld5
            r6.setAdapter(r7)
            r6.f1193e = r2
        Ld5:
            androidx.appcompat.widget.e r7 = r6.f1190b
            r7.e(r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.w.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }

    int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i4 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i5 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i4) {
                view = null;
                i4 = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i5 = Math.max(i5, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return i5;
        }
        drawable.getPadding(this.f1197i);
        Rect rect = this.f1197i;
        return i5 + rect.left + rect.right;
    }

    void b() {
        this.f1195g.f(getTextDirection(), getTextAlignment());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        androidx.appcompat.widget.e eVar = this.f1190b;
        if (eVar != null) {
            eVar.b();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        g gVar = this.f1195g;
        return gVar != null ? gVar.e() : super.getDropDownHorizontalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        g gVar = this.f1195g;
        return gVar != null ? gVar.g() : super.getDropDownVerticalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        return this.f1195g != null ? this.f1196h : super.getDropDownWidth();
    }

    final g getInternalPopup() {
        return this.f1195g;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        g gVar = this.f1195g;
        return gVar != null ? gVar.i() : super.getPopupBackground();
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.f1191c;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        g gVar = this.f1195g;
        return gVar != null ? gVar.j() : super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        androidx.appcompat.widget.e eVar = this.f1190b;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        androidx.appcompat.widget.e eVar = this.f1190b;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        g gVar = this.f1195g;
        if (gVar == null || !gVar.b()) {
            return;
        }
        this.f1195g.dismiss();
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    protected void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        if (this.f1195g == null || View.MeasureSpec.getMode(i4) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i4)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        f fVar = (f) parcelable;
        super.onRestoreInstanceState(fVar.getSuperState());
        if (!fVar.f1212b || (viewTreeObserver = getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new b());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public Parcelable onSaveInstanceState() {
        f fVar = new f(super.onSaveInstanceState());
        g gVar = this.f1195g;
        fVar.f1212b = gVar != null && gVar.b();
        return fVar;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        h0 h0Var = this.f1192d;
        if (h0Var == null || !h0Var.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        g gVar = this.f1195g;
        if (gVar == null) {
            return super.performClick();
        }
        if (gVar.b()) {
            return true;
        }
        b();
        return true;
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f1194f) {
            this.f1193e = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.f1195g != null) {
            Context context = this.f1191c;
            if (context == null) {
                context = getContext();
            }
            this.f1195g.n(new d(spinnerAdapter, context.getTheme()));
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        androidx.appcompat.widget.e eVar = this.f1190b;
        if (eVar != null) {
            eVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i4) {
        super.setBackgroundResource(i4);
        androidx.appcompat.widget.e eVar = this.f1190b;
        if (eVar != null) {
            eVar.g(i4);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i4) {
        g gVar = this.f1195g;
        if (gVar == null) {
            super.setDropDownHorizontalOffset(i4);
        } else {
            gVar.o(i4);
            this.f1195g.d(i4);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i4) {
        g gVar = this.f1195g;
        if (gVar != null) {
            gVar.m(i4);
        } else {
            super.setDropDownVerticalOffset(i4);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i4) {
        if (this.f1195g != null) {
            this.f1196h = i4;
        } else {
            super.setDropDownWidth(i4);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        g gVar = this.f1195g;
        if (gVar != null) {
            gVar.c(drawable);
        } else {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i4) {
        setPopupBackgroundDrawable(c.a.b(getPopupContext(), i4));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        g gVar = this.f1195g;
        if (gVar != null) {
            gVar.l(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        androidx.appcompat.widget.e eVar = this.f1190b;
        if (eVar != null) {
            eVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        androidx.appcompat.widget.e eVar = this.f1190b;
        if (eVar != null) {
            eVar.j(mode);
        }
    }
}
