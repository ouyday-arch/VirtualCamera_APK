package androidx.appcompat.app;

import a.j;
import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.widget.i0;
import androidx.core.widget.NestedScrollView;
import java.lang.ref.WeakReference;
import y.p;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class AlertController {
    NestedScrollView A;
    private Drawable C;
    private ImageView D;
    private TextView E;
    private TextView F;
    private View G;
    ListAdapter H;
    private int J;
    private int K;
    int L;
    int M;
    int N;
    int O;
    private boolean P;
    Handler R;

    /* renamed from: a, reason: collision with root package name */
    private final Context f336a;

    /* renamed from: b, reason: collision with root package name */
    final b.b f337b;

    /* renamed from: c, reason: collision with root package name */
    private final Window f338c;

    /* renamed from: d, reason: collision with root package name */
    private final int f339d;

    /* renamed from: e, reason: collision with root package name */
    private CharSequence f340e;

    /* renamed from: f, reason: collision with root package name */
    private CharSequence f341f;

    /* renamed from: g, reason: collision with root package name */
    ListView f342g;

    /* renamed from: h, reason: collision with root package name */
    private View f343h;

    /* renamed from: i, reason: collision with root package name */
    private int f344i;

    /* renamed from: j, reason: collision with root package name */
    private int f345j;

    /* renamed from: k, reason: collision with root package name */
    private int f346k;

    /* renamed from: l, reason: collision with root package name */
    private int f347l;

    /* renamed from: m, reason: collision with root package name */
    private int f348m;

    /* renamed from: o, reason: collision with root package name */
    Button f350o;

    /* renamed from: p, reason: collision with root package name */
    private CharSequence f351p;

    /* renamed from: q, reason: collision with root package name */
    Message f352q;

    /* renamed from: r, reason: collision with root package name */
    private Drawable f353r;

    /* renamed from: s, reason: collision with root package name */
    Button f354s;

    /* renamed from: t, reason: collision with root package name */
    private CharSequence f355t;

    /* renamed from: u, reason: collision with root package name */
    Message f356u;

    /* renamed from: v, reason: collision with root package name */
    private Drawable f357v;

    /* renamed from: w, reason: collision with root package name */
    Button f358w;

    /* renamed from: x, reason: collision with root package name */
    private CharSequence f359x;

    /* renamed from: y, reason: collision with root package name */
    Message f360y;

    /* renamed from: z, reason: collision with root package name */
    private Drawable f361z;

    /* renamed from: n, reason: collision with root package name */
    private boolean f349n = false;
    private int B = 0;
    int I = -1;
    private int Q = 0;
    private final View.OnClickListener S = new a();

    /* loaded from: classes.dex */
    public static class RecycleListView extends ListView {

        /* renamed from: b, reason: collision with root package name */
        private final int f362b;

        /* renamed from: c, reason: collision with root package name */
        private final int f363c;

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.f161f2);
            this.f363c = obtainStyledAttributes.getDimensionPixelOffset(j.f166g2, -1);
            this.f362b = obtainStyledAttributes.getDimensionPixelOffset(j.f171h2, -1);
        }

        public void a(boolean z4, boolean z5) {
            if (z5 && z4) {
                return;
            }
            setPadding(getPaddingLeft(), z4 ? getPaddingTop() : this.f362b, getPaddingRight(), z5 ? getPaddingBottom() : this.f363c);
        }
    }

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Message message;
            Message message2;
            AlertController alertController = AlertController.this;
            Message obtain = ((view != alertController.f350o || (message2 = alertController.f352q) == null) && (view != alertController.f354s || (message2 = alertController.f356u) == null)) ? (view != alertController.f358w || (message = alertController.f360y) == null) ? null : Message.obtain(message) : Message.obtain(message2);
            if (obtain != null) {
                obtain.sendToTarget();
            }
            AlertController alertController2 = AlertController.this;
            alertController2.R.obtainMessage(1, alertController2.f337b).sendToTarget();
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public int A;
        public int B;
        public int C;
        public int D;
        public boolean[] F;
        public boolean G;
        public boolean H;
        public DialogInterface.OnMultiChoiceClickListener J;
        public Cursor K;
        public String L;
        public String M;
        public AdapterView.OnItemSelectedListener N;
        public e O;

        /* renamed from: a, reason: collision with root package name */
        public final Context f365a;

        /* renamed from: b, reason: collision with root package name */
        public final LayoutInflater f366b;

        /* renamed from: d, reason: collision with root package name */
        public Drawable f368d;

        /* renamed from: f, reason: collision with root package name */
        public CharSequence f370f;

        /* renamed from: g, reason: collision with root package name */
        public View f371g;

        /* renamed from: h, reason: collision with root package name */
        public CharSequence f372h;

        /* renamed from: i, reason: collision with root package name */
        public CharSequence f373i;

        /* renamed from: j, reason: collision with root package name */
        public Drawable f374j;

        /* renamed from: k, reason: collision with root package name */
        public DialogInterface.OnClickListener f375k;

        /* renamed from: l, reason: collision with root package name */
        public CharSequence f376l;

        /* renamed from: m, reason: collision with root package name */
        public Drawable f377m;

        /* renamed from: n, reason: collision with root package name */
        public DialogInterface.OnClickListener f378n;

        /* renamed from: o, reason: collision with root package name */
        public CharSequence f379o;

        /* renamed from: p, reason: collision with root package name */
        public Drawable f380p;

        /* renamed from: q, reason: collision with root package name */
        public DialogInterface.OnClickListener f381q;

        /* renamed from: s, reason: collision with root package name */
        public DialogInterface.OnCancelListener f383s;

        /* renamed from: t, reason: collision with root package name */
        public DialogInterface.OnDismissListener f384t;

        /* renamed from: u, reason: collision with root package name */
        public DialogInterface.OnKeyListener f385u;

        /* renamed from: v, reason: collision with root package name */
        public CharSequence[] f386v;

        /* renamed from: w, reason: collision with root package name */
        public ListAdapter f387w;

        /* renamed from: x, reason: collision with root package name */
        public DialogInterface.OnClickListener f388x;

        /* renamed from: y, reason: collision with root package name */
        public int f389y;

        /* renamed from: z, reason: collision with root package name */
        public View f390z;

        /* renamed from: c, reason: collision with root package name */
        public int f367c = 0;

        /* renamed from: e, reason: collision with root package name */
        public int f369e = 0;
        public boolean E = false;
        public int I = -1;
        public boolean P = true;

        /* renamed from: r, reason: collision with root package name */
        public boolean f382r = true;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a extends ArrayAdapter<CharSequence> {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ RecycleListView f391b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Context context, int i4, int i5, CharSequence[] charSequenceArr, RecycleListView recycleListView) {
                super(context, i4, i5, charSequenceArr);
                this.f391b = recycleListView;
            }

            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            public View getView(int i4, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i4, view, viewGroup);
                boolean[] zArr = b.this.F;
                if (zArr != null && zArr[i4]) {
                    this.f391b.setItemChecked(i4, true);
                }
                return view2;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: androidx.appcompat.app.AlertController$b$b, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0003b extends CursorAdapter {

            /* renamed from: b, reason: collision with root package name */
            private final int f393b;

            /* renamed from: c, reason: collision with root package name */
            private final int f394c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ RecycleListView f395d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ AlertController f396e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0003b(Context context, Cursor cursor, boolean z4, RecycleListView recycleListView, AlertController alertController) {
                super(context, cursor, z4);
                this.f395d = recycleListView;
                this.f396e = alertController;
                Cursor cursor2 = getCursor();
                this.f393b = cursor2.getColumnIndexOrThrow(b.this.L);
                this.f394c = cursor2.getColumnIndexOrThrow(b.this.M);
            }

            @Override // android.widget.CursorAdapter
            public void bindView(View view, Context context, Cursor cursor) {
                ((CheckedTextView) view.findViewById(R.id.text1)).setText(cursor.getString(this.f393b));
                this.f395d.setItemChecked(cursor.getPosition(), cursor.getInt(this.f394c) == 1);
            }

            @Override // android.widget.CursorAdapter
            public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                return b.this.f366b.inflate(this.f396e.M, viewGroup, false);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class c implements AdapterView.OnItemClickListener {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ AlertController f398b;

            c(AlertController alertController) {
                this.f398b = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i4, long j4) {
                b.this.f388x.onClick(this.f398b.f337b, i4);
                if (b.this.H) {
                    return;
                }
                this.f398b.f337b.dismiss();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class d implements AdapterView.OnItemClickListener {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ RecycleListView f400b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ AlertController f401c;

            d(RecycleListView recycleListView, AlertController alertController) {
                this.f400b = recycleListView;
                this.f401c = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i4, long j4) {
                boolean[] zArr = b.this.F;
                if (zArr != null) {
                    zArr[i4] = this.f400b.isItemChecked(i4);
                }
                b.this.J.onClick(this.f401c.f337b, i4, this.f400b.isItemChecked(i4));
            }
        }

        /* loaded from: classes.dex */
        public interface e {
            void a(ListView listView);
        }

        public b(Context context) {
            this.f365a = context;
            this.f366b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0093  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x009a  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x009e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private void b(androidx.appcompat.app.AlertController r11) {
            /*
                r10 = this;
                android.view.LayoutInflater r0 = r10.f366b
                int r1 = r11.L
                r2 = 0
                android.view.View r0 = r0.inflate(r1, r2)
                androidx.appcompat.app.AlertController$RecycleListView r0 = (androidx.appcompat.app.AlertController.RecycleListView) r0
                boolean r1 = r10.G
                r8 = 1
                if (r1 == 0) goto L35
                android.database.Cursor r1 = r10.K
                if (r1 != 0) goto L26
                androidx.appcompat.app.AlertController$b$a r9 = new androidx.appcompat.app.AlertController$b$a
                android.content.Context r3 = r10.f365a
                int r4 = r11.M
                r5 = 16908308(0x1020014, float:2.3877285E-38)
                java.lang.CharSequence[] r6 = r10.f386v
                r1 = r9
                r2 = r10
                r7 = r0
                r1.<init>(r3, r4, r5, r6, r7)
                goto L6b
            L26:
                androidx.appcompat.app.AlertController$b$b r9 = new androidx.appcompat.app.AlertController$b$b
                android.content.Context r3 = r10.f365a
                android.database.Cursor r4 = r10.K
                r5 = 0
                r1 = r9
                r2 = r10
                r6 = r0
                r7 = r11
                r1.<init>(r3, r4, r5, r6, r7)
                goto L6b
            L35:
                boolean r1 = r10.H
                if (r1 == 0) goto L3c
                int r1 = r11.N
                goto L3e
            L3c:
                int r1 = r11.O
            L3e:
                r4 = r1
                android.database.Cursor r1 = r10.K
                r2 = 16908308(0x1020014, float:2.3877285E-38)
                if (r1 == 0) goto L5d
                android.widget.SimpleCursorAdapter r9 = new android.widget.SimpleCursorAdapter
                android.content.Context r3 = r10.f365a
                android.database.Cursor r5 = r10.K
                java.lang.String[] r6 = new java.lang.String[r8]
                java.lang.String r1 = r10.L
                r7 = 0
                r6[r7] = r1
                int[] r1 = new int[r8]
                r1[r7] = r2
                r2 = r9
                r7 = r1
                r2.<init>(r3, r4, r5, r6, r7)
                goto L6b
            L5d:
                android.widget.ListAdapter r9 = r10.f387w
                if (r9 == 0) goto L62
                goto L6b
            L62:
                androidx.appcompat.app.AlertController$d r9 = new androidx.appcompat.app.AlertController$d
                android.content.Context r1 = r10.f365a
                java.lang.CharSequence[] r3 = r10.f386v
                r9.<init>(r1, r4, r2, r3)
            L6b:
                androidx.appcompat.app.AlertController$b$e r1 = r10.O
                if (r1 == 0) goto L72
                r1.a(r0)
            L72:
                r11.H = r9
                int r1 = r10.I
                r11.I = r1
                android.content.DialogInterface$OnClickListener r1 = r10.f388x
                if (r1 == 0) goto L85
                androidx.appcompat.app.AlertController$b$c r1 = new androidx.appcompat.app.AlertController$b$c
                r1.<init>(r11)
            L81:
                r0.setOnItemClickListener(r1)
                goto L8f
            L85:
                android.content.DialogInterface$OnMultiChoiceClickListener r1 = r10.J
                if (r1 == 0) goto L8f
                androidx.appcompat.app.AlertController$b$d r1 = new androidx.appcompat.app.AlertController$b$d
                r1.<init>(r0, r11)
                goto L81
            L8f:
                android.widget.AdapterView$OnItemSelectedListener r1 = r10.N
                if (r1 == 0) goto L96
                r0.setOnItemSelectedListener(r1)
            L96:
                boolean r1 = r10.H
                if (r1 == 0) goto L9e
                r0.setChoiceMode(r8)
                goto La6
            L9e:
                boolean r1 = r10.G
                if (r1 == 0) goto La6
                r1 = 2
                r0.setChoiceMode(r1)
            La6:
                r11.f342g = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AlertController.b.b(androidx.appcompat.app.AlertController):void");
        }

        public void a(AlertController alertController) {
            View view = this.f371g;
            if (view != null) {
                alertController.l(view);
            } else {
                CharSequence charSequence = this.f370f;
                if (charSequence != null) {
                    alertController.q(charSequence);
                }
                Drawable drawable = this.f368d;
                if (drawable != null) {
                    alertController.n(drawable);
                }
                int i4 = this.f367c;
                if (i4 != 0) {
                    alertController.m(i4);
                }
                int i5 = this.f369e;
                if (i5 != 0) {
                    alertController.m(alertController.d(i5));
                }
            }
            CharSequence charSequence2 = this.f372h;
            if (charSequence2 != null) {
                alertController.o(charSequence2);
            }
            CharSequence charSequence3 = this.f373i;
            if (charSequence3 != null || this.f374j != null) {
                alertController.k(-1, charSequence3, this.f375k, null, this.f374j);
            }
            CharSequence charSequence4 = this.f376l;
            if (charSequence4 != null || this.f377m != null) {
                alertController.k(-2, charSequence4, this.f378n, null, this.f377m);
            }
            CharSequence charSequence5 = this.f379o;
            if (charSequence5 != null || this.f380p != null) {
                alertController.k(-3, charSequence5, this.f381q, null, this.f380p);
            }
            if (this.f386v != null || this.K != null || this.f387w != null) {
                b(alertController);
            }
            View view2 = this.f390z;
            if (view2 != null) {
                if (this.E) {
                    alertController.t(view2, this.A, this.B, this.C, this.D);
                    return;
                } else {
                    alertController.s(view2);
                    return;
                }
            }
            int i6 = this.f389y;
            if (i6 != 0) {
                alertController.r(i6);
            }
        }
    }

    /* loaded from: classes.dex */
    private static final class c extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<DialogInterface> f403a;

        public c(DialogInterface dialogInterface) {
            this.f403a = new WeakReference<>(dialogInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i4 = message.what;
            if (i4 == -3 || i4 == -2 || i4 == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick(this.f403a.get(), message.what);
            } else {
                if (i4 != 1) {
                    return;
                }
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d extends ArrayAdapter<CharSequence> {
        public d(Context context, int i4, int i5, CharSequence[] charSequenceArr) {
            super(context, i4, i5, charSequenceArr);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i4) {
            return i4;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }
    }

    public AlertController(Context context, b.b bVar, Window window) {
        this.f336a = context;
        this.f337b = bVar;
        this.f338c = window;
        this.R = new c(bVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, j.F, a.a.f13n, 0);
        this.J = obtainStyledAttributes.getResourceId(j.G, 0);
        this.K = obtainStyledAttributes.getResourceId(j.I, 0);
        this.L = obtainStyledAttributes.getResourceId(j.K, 0);
        this.M = obtainStyledAttributes.getResourceId(j.L, 0);
        this.N = obtainStyledAttributes.getResourceId(j.N, 0);
        this.O = obtainStyledAttributes.getResourceId(j.J, 0);
        this.P = obtainStyledAttributes.getBoolean(j.M, true);
        this.f339d = obtainStyledAttributes.getDimensionPixelSize(j.H, 0);
        obtainStyledAttributes.recycle();
        bVar.d(1);
    }

    static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    private void b(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    private ViewGroup i(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    private int j() {
        int i4 = this.K;
        return (i4 != 0 && this.Q == 1) ? i4 : this.J;
    }

    private void p(ViewGroup viewGroup, View view, int i4, int i5) {
        View findViewById = this.f338c.findViewById(a.f.f93v);
        View findViewById2 = this.f338c.findViewById(a.f.f92u);
        p.n0(view, i4, i5);
        if (findViewById != null) {
            viewGroup.removeView(findViewById);
        }
        if (findViewById2 != null) {
            viewGroup.removeView(findViewById2);
        }
    }

    private void u(ViewGroup viewGroup) {
        int i4;
        Button button;
        Button button2 = (Button) viewGroup.findViewById(R.id.button1);
        this.f350o = button2;
        button2.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.f351p) && this.f353r == null) {
            this.f350o.setVisibility(8);
            i4 = 0;
        } else {
            this.f350o.setText(this.f351p);
            Drawable drawable = this.f353r;
            if (drawable != null) {
                int i5 = this.f339d;
                drawable.setBounds(0, 0, i5, i5);
                this.f350o.setCompoundDrawables(this.f353r, null, null, null);
            }
            this.f350o.setVisibility(0);
            i4 = 1;
        }
        Button button3 = (Button) viewGroup.findViewById(R.id.button2);
        this.f354s = button3;
        button3.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.f355t) && this.f357v == null) {
            this.f354s.setVisibility(8);
        } else {
            this.f354s.setText(this.f355t);
            Drawable drawable2 = this.f357v;
            if (drawable2 != null) {
                int i6 = this.f339d;
                drawable2.setBounds(0, 0, i6, i6);
                this.f354s.setCompoundDrawables(this.f357v, null, null, null);
            }
            this.f354s.setVisibility(0);
            i4 |= 2;
        }
        Button button4 = (Button) viewGroup.findViewById(R.id.button3);
        this.f358w = button4;
        button4.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.f359x) && this.f361z == null) {
            this.f358w.setVisibility(8);
        } else {
            this.f358w.setText(this.f359x);
            Drawable drawable3 = this.f353r;
            if (drawable3 != null) {
                int i7 = this.f339d;
                drawable3.setBounds(0, 0, i7, i7);
                this.f350o.setCompoundDrawables(this.f353r, null, null, null);
            }
            this.f358w.setVisibility(0);
            i4 |= 4;
        }
        if (z(this.f336a)) {
            if (i4 == 1) {
                button = this.f350o;
            } else if (i4 == 2) {
                button = this.f354s;
            } else if (i4 == 4) {
                button = this.f358w;
            }
            b(button);
        }
        if (i4 != 0) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void v(ViewGroup viewGroup) {
        NestedScrollView nestedScrollView = (NestedScrollView) this.f338c.findViewById(a.f.f94w);
        this.A = nestedScrollView;
        nestedScrollView.setFocusable(false);
        this.A.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroup.findViewById(R.id.message);
        this.F = textView;
        if (textView == null) {
            return;
        }
        CharSequence charSequence = this.f341f;
        if (charSequence != null) {
            textView.setText(charSequence);
            return;
        }
        textView.setVisibility(8);
        this.A.removeView(this.F);
        if (this.f342g == null) {
            viewGroup.setVisibility(8);
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) this.A.getParent();
        int indexOfChild = viewGroup2.indexOfChild(this.A);
        viewGroup2.removeViewAt(indexOfChild);
        viewGroup2.addView(this.f342g, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
    }

    private void w(ViewGroup viewGroup) {
        View view = this.f343h;
        if (view == null) {
            view = this.f344i != 0 ? LayoutInflater.from(this.f336a).inflate(this.f344i, viewGroup, false) : null;
        }
        boolean z4 = view != null;
        if (!z4 || !a(view)) {
            this.f338c.setFlags(131072, 131072);
        }
        if (!z4) {
            viewGroup.setVisibility(8);
            return;
        }
        FrameLayout frameLayout = (FrameLayout) this.f338c.findViewById(a.f.f85n);
        frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
        if (this.f349n) {
            frameLayout.setPadding(this.f345j, this.f346k, this.f347l, this.f348m);
        }
        if (this.f342g != null) {
            ((i0.a) viewGroup.getLayoutParams()).f1035a = 0.0f;
        }
    }

    private void x(ViewGroup viewGroup) {
        if (this.G != null) {
            viewGroup.addView(this.G, 0, new ViewGroup.LayoutParams(-1, -2));
            this.f338c.findViewById(a.f.O).setVisibility(8);
            return;
        }
        this.D = (ImageView) this.f338c.findViewById(R.id.icon);
        if (!(!TextUtils.isEmpty(this.f340e)) || !this.P) {
            this.f338c.findViewById(a.f.O).setVisibility(8);
            this.D.setVisibility(8);
            viewGroup.setVisibility(8);
            return;
        }
        TextView textView = (TextView) this.f338c.findViewById(a.f.f81j);
        this.E = textView;
        textView.setText(this.f340e);
        int i4 = this.B;
        if (i4 != 0) {
            this.D.setImageResource(i4);
            return;
        }
        Drawable drawable = this.C;
        if (drawable != null) {
            this.D.setImageDrawable(drawable);
        } else {
            this.E.setPadding(this.D.getPaddingLeft(), this.D.getPaddingTop(), this.D.getPaddingRight(), this.D.getPaddingBottom());
            this.D.setVisibility(8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void y() {
        View findViewById;
        ListAdapter listAdapter;
        View findViewById2;
        View findViewById3 = this.f338c.findViewById(a.f.f91t);
        int i4 = a.f.P;
        View findViewById4 = findViewById3.findViewById(i4);
        int i5 = a.f.f84m;
        View findViewById5 = findViewById3.findViewById(i5);
        int i6 = a.f.f82k;
        View findViewById6 = findViewById3.findViewById(i6);
        ViewGroup viewGroup = (ViewGroup) findViewById3.findViewById(a.f.f86o);
        w(viewGroup);
        View findViewById7 = viewGroup.findViewById(i4);
        View findViewById8 = viewGroup.findViewById(i5);
        View findViewById9 = viewGroup.findViewById(i6);
        ViewGroup i7 = i(findViewById7, findViewById4);
        ViewGroup i8 = i(findViewById8, findViewById5);
        ViewGroup i9 = i(findViewById9, findViewById6);
        v(i8);
        u(i9);
        x(i7);
        boolean z4 = viewGroup.getVisibility() != 8;
        boolean z5 = (i7 == null || i7.getVisibility() == 8) ? 0 : 1;
        boolean z6 = (i9 == null || i9.getVisibility() == 8) ? false : true;
        if (!z6 && i8 != null && (findViewById2 = i8.findViewById(a.f.K)) != null) {
            findViewById2.setVisibility(0);
        }
        if (z5 != 0) {
            NestedScrollView nestedScrollView = this.A;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            View findViewById10 = (this.f341f == null && this.f342g == null) ? null : i7.findViewById(a.f.N);
            if (findViewById10 != null) {
                findViewById10.setVisibility(0);
            }
        } else if (i8 != null && (findViewById = i8.findViewById(a.f.L)) != null) {
            findViewById.setVisibility(0);
        }
        ListView listView = this.f342g;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).a(z5, z6);
        }
        if (!z4) {
            View view = this.f342g;
            if (view == null) {
                view = this.A;
            }
            if (view != null) {
                p(i8, view, z5 | (z6 ? 2 : 0), 3);
            }
        }
        ListView listView2 = this.f342g;
        if (listView2 == null || (listAdapter = this.H) == null) {
            return;
        }
        listView2.setAdapter(listAdapter);
        int i10 = this.I;
        if (i10 > -1) {
            listView2.setItemChecked(i10, true);
            listView2.setSelection(i10);
        }
    }

    private static boolean z(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(a.a.f12m, typedValue, true);
        return typedValue.data != 0;
    }

    public Button c(int i4) {
        if (i4 == -3) {
            return this.f358w;
        }
        if (i4 == -2) {
            return this.f354s;
        }
        if (i4 != -1) {
            return null;
        }
        return this.f350o;
    }

    public int d(int i4) {
        TypedValue typedValue = new TypedValue();
        this.f336a.getTheme().resolveAttribute(i4, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView e() {
        return this.f342g;
    }

    public void f() {
        this.f337b.setContentView(j());
        y();
    }

    public boolean g(int i4, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.q(keyEvent);
    }

    public boolean h(int i4, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.q(keyEvent);
    }

    public void k(int i4, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.R.obtainMessage(i4, onClickListener);
        }
        if (i4 == -3) {
            this.f359x = charSequence;
            this.f360y = message;
            this.f361z = drawable;
        } else if (i4 == -2) {
            this.f355t = charSequence;
            this.f356u = message;
            this.f357v = drawable;
        } else {
            if (i4 != -1) {
                throw new IllegalArgumentException("Button does not exist");
            }
            this.f351p = charSequence;
            this.f352q = message;
            this.f353r = drawable;
        }
    }

    public void l(View view) {
        this.G = view;
    }

    public void m(int i4) {
        this.C = null;
        this.B = i4;
        ImageView imageView = this.D;
        if (imageView != null) {
            if (i4 == 0) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.D.setImageResource(this.B);
            }
        }
    }

    public void n(Drawable drawable) {
        this.C = drawable;
        this.B = 0;
        ImageView imageView = this.D;
        if (imageView != null) {
            if (drawable == null) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.D.setImageDrawable(drawable);
            }
        }
    }

    public void o(CharSequence charSequence) {
        this.f341f = charSequence;
        TextView textView = this.F;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void q(CharSequence charSequence) {
        this.f340e = charSequence;
        TextView textView = this.E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void r(int i4) {
        this.f343h = null;
        this.f344i = i4;
        this.f349n = false;
    }

    public void s(View view) {
        this.f343h = view;
        this.f344i = 0;
        this.f349n = false;
    }

    public void t(View view, int i4, int i5, int i6, int i7) {
        this.f343h = view;
        this.f344i = 0;
        this.f349n = true;
        this.f345j = i4;
        this.f346k = i5;
        this.f347l = i6;
        this.f348m = i7;
    }
}
