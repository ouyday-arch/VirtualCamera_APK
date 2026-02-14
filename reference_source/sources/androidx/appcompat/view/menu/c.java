package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.k;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class c implements j, AdapterView.OnItemClickListener {

    /* renamed from: b, reason: collision with root package name */
    Context f621b;

    /* renamed from: c, reason: collision with root package name */
    LayoutInflater f622c;

    /* renamed from: d, reason: collision with root package name */
    e f623d;

    /* renamed from: e, reason: collision with root package name */
    ExpandedMenuView f624e;

    /* renamed from: f, reason: collision with root package name */
    int f625f;

    /* renamed from: g, reason: collision with root package name */
    int f626g;

    /* renamed from: h, reason: collision with root package name */
    int f627h;

    /* renamed from: i, reason: collision with root package name */
    private j.a f628i;

    /* renamed from: j, reason: collision with root package name */
    a f629j;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BaseAdapter {

        /* renamed from: b, reason: collision with root package name */
        private int f630b = -1;

        public a() {
            a();
        }

        void a() {
            g v4 = c.this.f623d.v();
            if (v4 != null) {
                ArrayList<g> z4 = c.this.f623d.z();
                int size = z4.size();
                for (int i4 = 0; i4 < size; i4++) {
                    if (z4.get(i4) == v4) {
                        this.f630b = i4;
                        return;
                    }
                }
            }
            this.f630b = -1;
        }

        @Override // android.widget.Adapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public g getItem(int i4) {
            ArrayList<g> z4 = c.this.f623d.z();
            int i5 = i4 + c.this.f625f;
            int i6 = this.f630b;
            if (i6 >= 0 && i5 >= i6) {
                i5++;
            }
            return z4.get(i5);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = c.this.f623d.z().size() - c.this.f625f;
            return this.f630b < 0 ? size : size - 1;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i4) {
            return i4;
        }

        @Override // android.widget.Adapter
        public View getView(int i4, View view, ViewGroup viewGroup) {
            if (view == null) {
                c cVar = c.this;
                view = cVar.f622c.inflate(cVar.f627h, viewGroup, false);
            }
            ((k.a) view).e(getItem(i4), 0);
            return view;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }

    public c(int i4, int i5) {
        this.f627h = i4;
        this.f626g = i5;
    }

    public c(Context context, int i4) {
        this(i4, 0);
        this.f621b = context;
        this.f622c = LayoutInflater.from(context);
    }

    @Override // androidx.appcompat.view.menu.j
    public void a(e eVar, boolean z4) {
        j.a aVar = this.f628i;
        if (aVar != null) {
            aVar.a(eVar, z4);
        }
    }

    public ListAdapter b() {
        if (this.f629j == null) {
            this.f629j = new a();
        }
        return this.f629j;
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean c() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0029  */
    @Override // androidx.appcompat.view.menu.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(android.content.Context r3, androidx.appcompat.view.menu.e r4) {
        /*
            r2 = this;
            int r0 = r2.f626g
            if (r0 == 0) goto L14
            android.view.ContextThemeWrapper r0 = new android.view.ContextThemeWrapper
            int r1 = r2.f626g
            r0.<init>(r3, r1)
            r2.f621b = r0
            android.view.LayoutInflater r3 = android.view.LayoutInflater.from(r0)
        L11:
            r2.f622c = r3
            goto L23
        L14:
            android.content.Context r0 = r2.f621b
            if (r0 == 0) goto L23
            r2.f621b = r3
            android.view.LayoutInflater r0 = r2.f622c
            if (r0 != 0) goto L23
            android.view.LayoutInflater r3 = android.view.LayoutInflater.from(r3)
            goto L11
        L23:
            r2.f623d = r4
            androidx.appcompat.view.menu.c$a r3 = r2.f629j
            if (r3 == 0) goto L2c
            r3.notifyDataSetChanged()
        L2c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.c.d(android.content.Context, androidx.appcompat.view.menu.e):void");
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean e(e eVar, g gVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean f(e eVar, g gVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public void g(j.a aVar) {
        this.f628i = aVar;
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean h(m mVar) {
        if (!mVar.hasVisibleItems()) {
            return false;
        }
        new f(mVar).d(null);
        j.a aVar = this.f628i;
        if (aVar == null) {
            return true;
        }
        aVar.b(mVar);
        return true;
    }

    @Override // androidx.appcompat.view.menu.j
    public void i(boolean z4) {
        a aVar = this.f629j;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public k j(ViewGroup viewGroup) {
        if (this.f624e == null) {
            this.f624e = (ExpandedMenuView) this.f622c.inflate(a.g.f104g, viewGroup, false);
            if (this.f629j == null) {
                this.f629j = new a();
            }
            this.f624e.setAdapter((ListAdapter) this.f629j);
            this.f624e.setOnItemClickListener(this);
        }
        return this.f624e;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i4, long j4) {
        this.f623d.M(this.f629j.getItem(i4), this, 0);
    }
}
