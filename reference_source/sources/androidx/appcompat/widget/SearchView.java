package androidx.appcompat.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class SearchView extends i0 implements f.c {

    /* renamed from: r0, reason: collision with root package name */
    static final k f814r0 = new k();
    private Rect A;
    private Rect B;
    private int[] C;
    private int[] D;
    private final ImageView E;
    private final Drawable F;
    private final int G;
    private final int H;
    private final Intent I;
    private final Intent J;
    private final CharSequence K;
    private m L;
    private l M;
    View.OnFocusChangeListener N;
    private n O;
    private View.OnClickListener P;
    private boolean Q;
    private boolean R;
    a0.a S;
    private boolean T;
    private CharSequence U;
    private boolean V;
    private boolean W;

    /* renamed from: a0, reason: collision with root package name */
    private int f815a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f816b0;

    /* renamed from: c0, reason: collision with root package name */
    private CharSequence f817c0;

    /* renamed from: d0, reason: collision with root package name */
    private CharSequence f818d0;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f819e0;

    /* renamed from: f0, reason: collision with root package name */
    private int f820f0;

    /* renamed from: g0, reason: collision with root package name */
    SearchableInfo f821g0;

    /* renamed from: h0, reason: collision with root package name */
    private Bundle f822h0;

    /* renamed from: i0, reason: collision with root package name */
    private final Runnable f823i0;

    /* renamed from: j0, reason: collision with root package name */
    private Runnable f824j0;

    /* renamed from: k0, reason: collision with root package name */
    private final WeakHashMap<String, Drawable.ConstantState> f825k0;

    /* renamed from: l0, reason: collision with root package name */
    private final View.OnClickListener f826l0;

    /* renamed from: m0, reason: collision with root package name */
    View.OnKeyListener f827m0;

    /* renamed from: n0, reason: collision with root package name */
    private final TextView.OnEditorActionListener f828n0;

    /* renamed from: o0, reason: collision with root package name */
    private final AdapterView.OnItemClickListener f829o0;

    /* renamed from: p0, reason: collision with root package name */
    private final AdapterView.OnItemSelectedListener f830p0;

    /* renamed from: q, reason: collision with root package name */
    final SearchAutoComplete f831q;

    /* renamed from: q0, reason: collision with root package name */
    private TextWatcher f832q0;

    /* renamed from: r, reason: collision with root package name */
    private final View f833r;

    /* renamed from: s, reason: collision with root package name */
    private final View f834s;

    /* renamed from: t, reason: collision with root package name */
    private final View f835t;

    /* renamed from: u, reason: collision with root package name */
    final ImageView f836u;

    /* renamed from: v, reason: collision with root package name */
    final ImageView f837v;

    /* renamed from: w, reason: collision with root package name */
    final ImageView f838w;

    /* renamed from: x, reason: collision with root package name */
    final ImageView f839x;

    /* renamed from: y, reason: collision with root package name */
    private final View f840y;

    /* renamed from: z, reason: collision with root package name */
    private p f841z;

    /* loaded from: classes.dex */
    public static class SearchAutoComplete extends androidx.appcompat.widget.d {

        /* renamed from: e, reason: collision with root package name */
        private int f842e;

        /* renamed from: f, reason: collision with root package name */
        private SearchView f843f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f844g;

        /* renamed from: h, reason: collision with root package name */
        final Runnable f845h;

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SearchAutoComplete.this.b();
            }
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, a.a.f15p);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i4) {
            super(context, attributeSet, i4);
            this.f845h = new a();
            this.f842e = getThreshold();
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i4 = configuration.screenWidthDp;
            int i5 = configuration.screenHeightDp;
            if (i4 >= 960 && i5 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i4 < 600) {
                return (i4 < 640 || i5 < 480) ? 160 : 192;
            }
            return 192;
        }

        boolean a() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        void b() {
            if (this.f844g) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.f844g = false;
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            return this.f842e <= 0 || super.enoughToFilter();
        }

        @Override // androidx.appcompat.widget.d, android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f844g) {
                removeCallbacks(this.f845h);
                post(this.f845h);
            }
            return onCreateInputConnection;
        }

        @Override // android.view.View
        protected void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        protected void onFocusChanged(boolean z4, int i4, Rect rect) {
            super.onFocusChanged(z4, i4, rect);
            this.f843f.Z();
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int i4, KeyEvent keyEvent) {
            if (i4 == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                }
                if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f843f.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i4, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onWindowFocusChanged(boolean z4) {
            super.onWindowFocusChanged(z4);
            if (z4 && this.f843f.hasFocus() && getVisibility() == 0) {
                this.f844g = true;
                if (SearchView.M(getContext())) {
                    SearchView.f814r0.c(this, true);
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        protected void replaceText(CharSequence charSequence) {
        }

        void setImeVisibility(boolean z4) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z4) {
                this.f844g = false;
                removeCallbacks(this.f845h);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else {
                if (!inputMethodManager.isActive(this)) {
                    this.f844g = true;
                    return;
                }
                this.f844g = false;
                removeCallbacks(this.f845h);
                inputMethodManager.showSoftInput(this, 0);
            }
        }

        void setSearchView(SearchView searchView) {
            this.f843f = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i4) {
            super.setThreshold(i4);
            this.f842e = i4;
        }
    }

    /* loaded from: classes.dex */
    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
            SearchView.this.Y(charSequence);
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SearchView.this.f0();
        }
    }

    /* loaded from: classes.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a0.a aVar = SearchView.this.S;
            if (aVar instanceof q0) {
                aVar.b(null);
            }
        }
    }

    /* loaded from: classes.dex */
    class d implements View.OnFocusChangeListener {
        d() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z4) {
            SearchView searchView = SearchView.this;
            View.OnFocusChangeListener onFocusChangeListener = searchView.N;
            if (onFocusChangeListener != null) {
                onFocusChangeListener.onFocusChange(searchView, z4);
            }
        }
    }

    /* loaded from: classes.dex */
    class e implements View.OnLayoutChangeListener {
        e() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
            SearchView.this.B();
        }
    }

    /* loaded from: classes.dex */
    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SearchView searchView = SearchView.this;
            if (view == searchView.f836u) {
                searchView.V();
                return;
            }
            if (view == searchView.f838w) {
                searchView.R();
                return;
            }
            if (view == searchView.f837v) {
                searchView.W();
            } else if (view == searchView.f839x) {
                searchView.a0();
            } else if (view == searchView.f831q) {
                searchView.H();
            }
        }
    }

    /* loaded from: classes.dex */
    class g implements View.OnKeyListener {
        g() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i4, KeyEvent keyEvent) {
            SearchView searchView = SearchView.this;
            if (searchView.f821g0 == null) {
                return false;
            }
            if (searchView.f831q.isPopupShowing() && SearchView.this.f831q.getListSelection() != -1) {
                return SearchView.this.X(view, i4, keyEvent);
            }
            if (SearchView.this.f831q.a() || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i4 != 66) {
                return false;
            }
            view.cancelLongPress();
            SearchView searchView2 = SearchView.this;
            searchView2.P(0, null, searchView2.f831q.getText().toString());
            return true;
        }
    }

    /* loaded from: classes.dex */
    class h implements TextView.OnEditorActionListener {
        h() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i4, KeyEvent keyEvent) {
            SearchView.this.W();
            return true;
        }
    }

    /* loaded from: classes.dex */
    class i implements AdapterView.OnItemClickListener {
        i() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i4, long j4) {
            SearchView.this.S(i4, 0, null);
        }
    }

    /* loaded from: classes.dex */
    class j implements AdapterView.OnItemSelectedListener {
        j() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i4, long j4) {
            SearchView.this.T(i4);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class k {

        /* renamed from: a, reason: collision with root package name */
        private Method f857a;

        /* renamed from: b, reason: collision with root package name */
        private Method f858b;

        /* renamed from: c, reason: collision with root package name */
        private Method f859c;

        k() {
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.f857a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.f858b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                Method method = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                this.f859c = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        void a(AutoCompleteTextView autoCompleteTextView) {
            Method method = this.f858b;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        void b(AutoCompleteTextView autoCompleteTextView) {
            Method method = this.f857a;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        void c(AutoCompleteTextView autoCompleteTextView, boolean z4) {
            Method method = this.f859c;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, Boolean.valueOf(z4));
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface l {
        boolean a();
    }

    /* loaded from: classes.dex */
    public interface m {
        boolean a(String str);

        boolean b(String str);
    }

    /* loaded from: classes.dex */
    public interface n {
        boolean a(int i4);

        boolean b(int i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class o extends b0.a {
        public static final Parcelable.Creator<o> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name */
        boolean f860d;

        /* loaded from: classes.dex */
        static class a implements Parcelable.ClassLoaderCreator<o> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public o createFromParcel(Parcel parcel) {
                return new o(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public o createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new o(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public o[] newArray(int i4) {
                return new o[i4];
            }
        }

        public o(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f860d = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        o(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f860d + "}";
        }

        @Override // b0.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeValue(Boolean.valueOf(this.f860d));
        }
    }

    /* loaded from: classes.dex */
    private static class p extends TouchDelegate {

        /* renamed from: a, reason: collision with root package name */
        private final View f861a;

        /* renamed from: b, reason: collision with root package name */
        private final Rect f862b;

        /* renamed from: c, reason: collision with root package name */
        private final Rect f863c;

        /* renamed from: d, reason: collision with root package name */
        private final Rect f864d;

        /* renamed from: e, reason: collision with root package name */
        private final int f865e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f866f;

        public p(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.f865e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.f862b = new Rect();
            this.f864d = new Rect();
            this.f863c = new Rect();
            a(rect, rect2);
            this.f861a = view;
        }

        public void a(Rect rect, Rect rect2) {
            this.f862b.set(rect);
            this.f864d.set(rect);
            Rect rect3 = this.f864d;
            int i4 = this.f865e;
            rect3.inset(-i4, -i4);
            this.f863c.set(rect2);
        }

        @Override // android.view.TouchDelegate
        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z4;
            float f4;
            int i4;
            boolean z5;
            int x4 = (int) motionEvent.getX();
            int y4 = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            boolean z6 = true;
            if (action != 0) {
                if (action == 1 || action == 2) {
                    z5 = this.f866f;
                    if (z5 && !this.f864d.contains(x4, y4)) {
                        z6 = z5;
                        z4 = false;
                    }
                } else {
                    if (action == 3) {
                        z5 = this.f866f;
                        this.f866f = false;
                    }
                    z4 = true;
                    z6 = false;
                }
                z6 = z5;
                z4 = true;
            } else {
                if (this.f862b.contains(x4, y4)) {
                    this.f866f = true;
                    z4 = true;
                }
                z4 = true;
                z6 = false;
            }
            if (!z6) {
                return false;
            }
            if (!z4 || this.f863c.contains(x4, y4)) {
                Rect rect = this.f863c;
                f4 = x4 - rect.left;
                i4 = y4 - rect.top;
            } else {
                f4 = this.f861a.getWidth() / 2;
                i4 = this.f861a.getHeight() / 2;
            }
            motionEvent.setLocation(f4, i4);
            return this.f861a.dispatchTouchEvent(motionEvent);
        }
    }

    public SearchView(Context context) {
        this(context, null);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.a.H);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.A = new Rect();
        this.B = new Rect();
        this.C = new int[2];
        this.D = new int[2];
        this.f823i0 = new b();
        this.f824j0 = new c();
        this.f825k0 = new WeakHashMap<>();
        f fVar = new f();
        this.f826l0 = fVar;
        this.f827m0 = new g();
        h hVar = new h();
        this.f828n0 = hVar;
        i iVar = new i();
        this.f829o0 = iVar;
        j jVar = new j();
        this.f830p0 = jVar;
        this.f832q0 = new a();
        w0 u4 = w0.u(context, attributeSet, a.j.f176i2, i4, 0);
        LayoutInflater.from(context).inflate(u4.n(a.j.f226s2, a.g.f115r), (ViewGroup) this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(a.f.D);
        this.f831q = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.f833r = findViewById(a.f.f97z);
        View findViewById = findViewById(a.f.C);
        this.f834s = findViewById;
        View findViewById2 = findViewById(a.f.J);
        this.f835t = findViewById2;
        ImageView imageView = (ImageView) findViewById(a.f.f95x);
        this.f836u = imageView;
        ImageView imageView2 = (ImageView) findViewById(a.f.A);
        this.f837v = imageView2;
        ImageView imageView3 = (ImageView) findViewById(a.f.f96y);
        this.f838w = imageView3;
        ImageView imageView4 = (ImageView) findViewById(a.f.E);
        this.f839x = imageView4;
        ImageView imageView5 = (ImageView) findViewById(a.f.B);
        this.E = imageView5;
        y.p.d0(findViewById, u4.g(a.j.f231t2));
        y.p.d0(findViewById2, u4.g(a.j.f251x2));
        int i5 = a.j.f246w2;
        imageView.setImageDrawable(u4.g(i5));
        imageView2.setImageDrawable(u4.g(a.j.f216q2));
        imageView3.setImageDrawable(u4.g(a.j.f201n2));
        imageView4.setImageDrawable(u4.g(a.j.f261z2));
        imageView5.setImageDrawable(u4.g(i5));
        this.F = u4.g(a.j.f241v2);
        y0.a(imageView, getResources().getString(a.h.f129l));
        this.G = u4.n(a.j.f256y2, a.g.f114q);
        this.H = u4.n(a.j.f206o2, 0);
        imageView.setOnClickListener(fVar);
        imageView3.setOnClickListener(fVar);
        imageView2.setOnClickListener(fVar);
        imageView4.setOnClickListener(fVar);
        searchAutoComplete.setOnClickListener(fVar);
        searchAutoComplete.addTextChangedListener(this.f832q0);
        searchAutoComplete.setOnEditorActionListener(hVar);
        searchAutoComplete.setOnItemClickListener(iVar);
        searchAutoComplete.setOnItemSelectedListener(jVar);
        searchAutoComplete.setOnKeyListener(this.f827m0);
        searchAutoComplete.setOnFocusChangeListener(new d());
        setIconifiedByDefault(u4.a(a.j.f221r2, true));
        int f4 = u4.f(a.j.f186k2, -1);
        if (f4 != -1) {
            setMaxWidth(f4);
        }
        this.K = u4.p(a.j.f211p2);
        this.U = u4.p(a.j.f236u2);
        int k4 = u4.k(a.j.f196m2, -1);
        if (k4 != -1) {
            setImeOptions(k4);
        }
        int k5 = u4.k(a.j.f191l2, -1);
        if (k5 != -1) {
            setInputType(k5);
        }
        setFocusable(u4.a(a.j.f181j2, true));
        u4.v();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.I = intent;
        intent.addFlags(268435456);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.J = intent2;
        intent2.addFlags(268435456);
        View findViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.f840y = findViewById3;
        if (findViewById3 != null) {
            findViewById3.addOnLayoutChangeListener(new e());
        }
        k0(this.Q);
        g0();
    }

    private Intent C(String str, Uri uri, String str2, String str3, int i4, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f818d0);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.f822h0;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        if (i4 != 0) {
            intent.putExtra("action_key", i4);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.f821g0.getSearchActivity());
        return intent;
    }

    private Intent D(Cursor cursor, int i4, String str) {
        int i5;
        String o4;
        try {
            String o5 = q0.o(cursor, "suggest_intent_action");
            if (o5 == null) {
                o5 = this.f821g0.getSuggestIntentAction();
            }
            if (o5 == null) {
                o5 = "android.intent.action.SEARCH";
            }
            String str2 = o5;
            String o6 = q0.o(cursor, "suggest_intent_data");
            if (o6 == null) {
                o6 = this.f821g0.getSuggestIntentData();
            }
            if (o6 != null && (o4 = q0.o(cursor, "suggest_intent_data_id")) != null) {
                o6 = o6 + "/" + Uri.encode(o4);
            }
            return C(str2, o6 == null ? null : Uri.parse(o6), q0.o(cursor, "suggest_intent_extra_data"), q0.o(cursor, "suggest_intent_query"), i4, str);
        } catch (RuntimeException e4) {
            try {
                i5 = cursor.getPosition();
            } catch (RuntimeException unused) {
                i5 = -1;
            }
            Log.w("SearchView", "Search suggestions cursor at row " + i5 + " returned exception.", e4);
            return null;
        }
    }

    private Intent E(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1073741824);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f822h0;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        int voiceMaxResults = searchableInfo.getVoiceMaxResults() != 0 ? searchableInfo.getVoiceMaxResults() : 1;
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", voiceMaxResults);
        intent3.putExtra("calling_package", searchActivity != null ? searchActivity.flattenToShortString() : null);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    private Intent F(Intent intent, SearchableInfo searchableInfo) {
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        intent2.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
        return intent2;
    }

    private void G() {
        this.f831q.dismissDropDown();
    }

    private void I(View view, Rect rect) {
        view.getLocationInWindow(this.C);
        getLocationInWindow(this.D);
        int[] iArr = this.C;
        int i4 = iArr[1];
        int[] iArr2 = this.D;
        int i5 = i4 - iArr2[1];
        int i6 = iArr[0] - iArr2[0];
        rect.set(i6, i5, view.getWidth() + i6, view.getHeight() + i5);
    }

    private CharSequence J(CharSequence charSequence) {
        if (!this.Q || this.F == null) {
            return charSequence;
        }
        int textSize = (int) (this.f831q.getTextSize() * 1.25d);
        this.F.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.F), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    private boolean K() {
        SearchableInfo searchableInfo = this.f821g0;
        if (searchableInfo == null || !searchableInfo.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = null;
        if (this.f821g0.getVoiceSearchLaunchWebSearch()) {
            intent = this.I;
        } else if (this.f821g0.getVoiceSearchLaunchRecognizer()) {
            intent = this.J;
        }
        return (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) ? false : true;
    }

    static boolean M(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    private boolean N() {
        return (this.T || this.f816b0) && !L();
    }

    private void O(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            getContext().startActivity(intent);
        } catch (RuntimeException e4) {
            Log.e("SearchView", "Failed launch activity: " + intent, e4);
        }
    }

    private boolean Q(int i4, int i5, String str) {
        Cursor c5 = this.S.c();
        if (c5 == null || !c5.moveToPosition(i4)) {
            return false;
        }
        O(D(c5, i5, str));
        return true;
    }

    private void b0() {
        post(this.f823i0);
    }

    private void c0(int i4) {
        CharSequence a5;
        Editable text = this.f831q.getText();
        Cursor c5 = this.S.c();
        if (c5 == null) {
            return;
        }
        if (!c5.moveToPosition(i4) || (a5 = this.S.a(c5)) == null) {
            setQuery(text);
        } else {
            setQuery(a5);
        }
    }

    private void e0() {
        boolean z4 = true;
        boolean z5 = !TextUtils.isEmpty(this.f831q.getText());
        if (!z5 && (!this.Q || this.f819e0)) {
            z4 = false;
        }
        this.f838w.setVisibility(z4 ? 0 : 8);
        Drawable drawable = this.f838w.getDrawable();
        if (drawable != null) {
            drawable.setState(z5 ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    private void g0() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f831q;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(J(queryHint));
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(a.d.f40g);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(a.d.f41h);
    }

    private void h0() {
        this.f831q.setThreshold(this.f821g0.getSuggestThreshold());
        this.f831q.setImeOptions(this.f821g0.getImeOptions());
        int inputType = this.f821g0.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.f821g0.getSuggestAuthority() != null) {
                inputType = inputType | 65536 | 524288;
            }
        }
        this.f831q.setInputType(inputType);
        a0.a aVar = this.S;
        if (aVar != null) {
            aVar.b(null);
        }
        if (this.f821g0.getSuggestAuthority() != null) {
            q0 q0Var = new q0(getContext(), this, this.f821g0, this.f825k0);
            this.S = q0Var;
            this.f831q.setAdapter(q0Var);
            ((q0) this.S).x(this.V ? 2 : 1);
        }
    }

    private void i0() {
        this.f835t.setVisibility((N() && (this.f837v.getVisibility() == 0 || this.f839x.getVisibility() == 0)) ? 0 : 8);
    }

    private void j0(boolean z4) {
        this.f837v.setVisibility((this.T && N() && hasFocus() && (z4 || !this.f816b0)) ? 0 : 8);
    }

    private void k0(boolean z4) {
        this.R = z4;
        int i4 = z4 ? 0 : 8;
        boolean z5 = !TextUtils.isEmpty(this.f831q.getText());
        this.f836u.setVisibility(i4);
        j0(z5);
        this.f833r.setVisibility(z4 ? 8 : 0);
        this.E.setVisibility((this.E.getDrawable() == null || this.Q) ? 8 : 0);
        e0();
        l0(!z5);
        i0();
    }

    private void l0(boolean z4) {
        int i4 = 8;
        if (this.f816b0 && !L() && z4) {
            this.f837v.setVisibility(8);
            i4 = 0;
        }
        this.f839x.setVisibility(i4);
    }

    private void setQuery(CharSequence charSequence) {
        this.f831q.setText(charSequence);
        this.f831q.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    void B() {
        if (this.f840y.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.f834s.getPaddingLeft();
            Rect rect = new Rect();
            boolean b5 = c1.b(this);
            int dimensionPixelSize = this.Q ? resources.getDimensionPixelSize(a.d.f38e) + resources.getDimensionPixelSize(a.d.f39f) : 0;
            this.f831q.getDropDownBackground().getPadding(rect);
            int i4 = rect.left;
            this.f831q.setDropDownHorizontalOffset(b5 ? -i4 : paddingLeft - (i4 + dimensionPixelSize));
            this.f831q.setDropDownWidth((((this.f840y.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
        }
    }

    void H() {
        if (Build.VERSION.SDK_INT >= 29) {
            this.f831q.refreshAutoCompleteResults();
            return;
        }
        k kVar = f814r0;
        kVar.b(this.f831q);
        kVar.a(this.f831q);
    }

    public boolean L() {
        return this.R;
    }

    void P(int i4, String str, String str2) {
        getContext().startActivity(C("android.intent.action.SEARCH", null, null, str2, i4, str));
    }

    void R() {
        if (!TextUtils.isEmpty(this.f831q.getText())) {
            this.f831q.setText("");
            this.f831q.requestFocus();
            this.f831q.setImeVisibility(true);
        } else if (this.Q) {
            l lVar = this.M;
            if (lVar == null || !lVar.a()) {
                clearFocus();
                k0(true);
            }
        }
    }

    boolean S(int i4, int i5, String str) {
        n nVar = this.O;
        if (nVar != null && nVar.b(i4)) {
            return false;
        }
        Q(i4, 0, null);
        this.f831q.setImeVisibility(false);
        G();
        return true;
    }

    boolean T(int i4) {
        n nVar = this.O;
        if (nVar != null && nVar.a(i4)) {
            return false;
        }
        c0(i4);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void U(CharSequence charSequence) {
        setQuery(charSequence);
    }

    void V() {
        k0(false);
        this.f831q.requestFocus();
        this.f831q.setImeVisibility(true);
        View.OnClickListener onClickListener = this.P;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    void W() {
        Editable text = this.f831q.getText();
        if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        m mVar = this.L;
        if (mVar == null || !mVar.b(text.toString())) {
            if (this.f821g0 != null) {
                P(0, null, text.toString());
            }
            this.f831q.setImeVisibility(false);
            G();
        }
    }

    boolean X(View view, int i4, KeyEvent keyEvent) {
        if (this.f821g0 != null && this.S != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (i4 == 66 || i4 == 84 || i4 == 61) {
                return S(this.f831q.getListSelection(), 0, null);
            }
            if (i4 == 21 || i4 == 22) {
                this.f831q.setSelection(i4 == 21 ? 0 : this.f831q.length());
                this.f831q.setListSelection(0);
                this.f831q.clearListSelection();
                f814r0.c(this.f831q, true);
                return true;
            }
            if (i4 == 19) {
                this.f831q.getListSelection();
                return false;
            }
        }
        return false;
    }

    void Y(CharSequence charSequence) {
        Editable text = this.f831q.getText();
        this.f818d0 = text;
        boolean z4 = !TextUtils.isEmpty(text);
        j0(z4);
        l0(!z4);
        e0();
        i0();
        if (this.L != null && !TextUtils.equals(charSequence, this.f817c0)) {
            this.L.a(charSequence.toString());
        }
        this.f817c0 = charSequence.toString();
    }

    void Z() {
        k0(L());
        b0();
        if (this.f831q.hasFocus()) {
            H();
        }
    }

    void a0() {
        Intent E;
        SearchableInfo searchableInfo = this.f821g0;
        if (searchableInfo == null) {
            return;
        }
        try {
            if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                E = F(this.I, searchableInfo);
            } else if (!searchableInfo.getVoiceSearchLaunchRecognizer()) {
                return;
            } else {
                E = E(this.J, searchableInfo);
            }
            getContext().startActivity(E);
        } catch (ActivityNotFoundException unused) {
            Log.w("SearchView", "Could not find voice search activity");
        }
    }

    @Override // f.c
    public void c() {
        if (this.f819e0) {
            return;
        }
        this.f819e0 = true;
        int imeOptions = this.f831q.getImeOptions();
        this.f820f0 = imeOptions;
        this.f831q.setImeOptions(imeOptions | 33554432);
        this.f831q.setText("");
        setIconified(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        this.W = true;
        super.clearFocus();
        this.f831q.clearFocus();
        this.f831q.setImeVisibility(false);
        this.W = false;
    }

    public void d0(CharSequence charSequence, boolean z4) {
        this.f831q.setText(charSequence);
        if (charSequence != null) {
            SearchAutoComplete searchAutoComplete = this.f831q;
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.f818d0 = charSequence;
        }
        if (!z4 || TextUtils.isEmpty(charSequence)) {
            return;
        }
        W();
    }

    @Override // f.c
    public void f() {
        d0("", false);
        clearFocus();
        k0(true);
        this.f831q.setImeOptions(this.f820f0);
        this.f819e0 = false;
    }

    void f0() {
        int[] iArr = this.f831q.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.f834s.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.f835t.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    public int getImeOptions() {
        return this.f831q.getImeOptions();
    }

    public int getInputType() {
        return this.f831q.getInputType();
    }

    public int getMaxWidth() {
        return this.f815a0;
    }

    public CharSequence getQuery() {
        return this.f831q.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.U;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.f821g0;
        return (searchableInfo == null || searchableInfo.getHintId() == 0) ? this.K : getContext().getText(this.f821g0.getHintId());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSuggestionCommitIconResId() {
        return this.H;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSuggestionRowLayout() {
        return this.G;
    }

    public a0.a getSuggestionsAdapter() {
        return this.S;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.f823i0);
        post(this.f824j0);
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.i0, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        super.onLayout(z4, i4, i5, i6, i7);
        if (z4) {
            I(this.f831q, this.A);
            Rect rect = this.B;
            Rect rect2 = this.A;
            rect.set(rect2.left, 0, rect2.right, i7 - i5);
            p pVar = this.f841z;
            if (pVar != null) {
                pVar.a(this.B, this.A);
                return;
            }
            p pVar2 = new p(this.B, this.A, this.f831q);
            this.f841z = pVar2;
            setTouchDelegate(pVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001f, code lost:
    
        if (r0 <= 0) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004b  */
    @Override // androidx.appcompat.widget.i0, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r4, int r5) {
        /*
            r3 = this;
            boolean r0 = r3.L()
            if (r0 == 0) goto La
            super.onMeasure(r4, r5)
            return
        La:
            int r0 = android.view.View.MeasureSpec.getMode(r4)
            int r4 = android.view.View.MeasureSpec.getSize(r4)
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = 1073741824(0x40000000, float:2.0)
            if (r0 == r1) goto L2c
            if (r0 == 0) goto L22
            if (r0 == r2) goto L1d
            goto L39
        L1d:
            int r0 = r3.f815a0
            if (r0 <= 0) goto L39
            goto L30
        L22:
            int r4 = r3.f815a0
            if (r4 <= 0) goto L27
            goto L39
        L27:
            int r4 = r3.getPreferredWidth()
            goto L39
        L2c:
            int r0 = r3.f815a0
            if (r0 <= 0) goto L31
        L30:
            goto L35
        L31:
            int r0 = r3.getPreferredWidth()
        L35:
            int r4 = java.lang.Math.min(r0, r4)
        L39:
            int r0 = android.view.View.MeasureSpec.getMode(r5)
            int r5 = android.view.View.MeasureSpec.getSize(r5)
            if (r0 == r1) goto L4b
            if (r0 == 0) goto L46
            goto L53
        L46:
            int r5 = r3.getPreferredHeight()
            goto L53
        L4b:
            int r0 = r3.getPreferredHeight()
            int r5 = java.lang.Math.min(r0, r5)
        L53:
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r2)
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r2)
            super.onMeasure(r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.onMeasure(int, int):void");
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof o)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        o oVar = (o) parcelable;
        super.onRestoreInstanceState(oVar.f());
        k0(oVar.f860d);
        requestLayout();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        o oVar = new o(super.onSaveInstanceState());
        oVar.f860d = L();
        return oVar;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z4) {
        super.onWindowFocusChanged(z4);
        b0();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i4, Rect rect) {
        if (this.W || !isFocusable()) {
            return false;
        }
        if (L()) {
            return super.requestFocus(i4, rect);
        }
        boolean requestFocus = this.f831q.requestFocus(i4, rect);
        if (requestFocus) {
            k0(false);
        }
        return requestFocus;
    }

    public void setAppSearchData(Bundle bundle) {
        this.f822h0 = bundle;
    }

    public void setIconified(boolean z4) {
        if (z4) {
            R();
        } else {
            V();
        }
    }

    public void setIconifiedByDefault(boolean z4) {
        if (this.Q == z4) {
            return;
        }
        this.Q = z4;
        k0(z4);
        g0();
    }

    public void setImeOptions(int i4) {
        this.f831q.setImeOptions(i4);
    }

    public void setInputType(int i4) {
        this.f831q.setInputType(i4);
    }

    public void setMaxWidth(int i4) {
        this.f815a0 = i4;
        requestLayout();
    }

    public void setOnCloseListener(l lVar) {
        this.M = lVar;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.N = onFocusChangeListener;
    }

    public void setOnQueryTextListener(m mVar) {
        this.L = mVar;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.P = onClickListener;
    }

    public void setOnSuggestionListener(n nVar) {
        this.O = nVar;
    }

    public void setQueryHint(CharSequence charSequence) {
        this.U = charSequence;
        g0();
    }

    public void setQueryRefinementEnabled(boolean z4) {
        this.V = z4;
        a0.a aVar = this.S;
        if (aVar instanceof q0) {
            ((q0) aVar).x(z4 ? 2 : 1);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.f821g0 = searchableInfo;
        if (searchableInfo != null) {
            h0();
            g0();
        }
        boolean K = K();
        this.f816b0 = K;
        if (K) {
            this.f831q.setPrivateImeOptions("nm");
        }
        k0(L());
    }

    public void setSubmitButtonEnabled(boolean z4) {
        this.T = z4;
        k0(L());
    }

    public void setSuggestionsAdapter(a0.a aVar) {
        this.S = aVar;
        this.f831q.setAdapter(aVar);
    }
}
