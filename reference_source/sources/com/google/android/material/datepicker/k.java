package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.datepicker.g;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends RecyclerView.g<b> {

    /* renamed from: c, reason: collision with root package name */
    private final com.google.android.material.datepicker.a f3008c;

    /* renamed from: d, reason: collision with root package name */
    private final d<?> f3009d;

    /* renamed from: e, reason: collision with root package name */
    private final g.l f3010e;

    /* renamed from: f, reason: collision with root package name */
    private final int f3011f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements AdapterView.OnItemClickListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ MaterialCalendarGridView f3012b;

        a(MaterialCalendarGridView materialCalendarGridView) {
            this.f3012b = materialCalendarGridView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i4, long j4) {
            if (this.f3012b.getAdapter().j(i4)) {
                k.this.f3010e.a(this.f3012b.getAdapter().getItem(i4).longValue());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends RecyclerView.d0 {

        /* renamed from: t, reason: collision with root package name */
        final TextView f3014t;

        /* renamed from: u, reason: collision with root package name */
        final MaterialCalendarGridView f3015u;

        b(LinearLayout linearLayout, boolean z4) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(m0.f.f4996i);
            this.f3014t = textView;
            y.p.b0(textView, true);
            this.f3015u = (MaterialCalendarGridView) linearLayout.findViewById(m0.f.f4992e);
            if (z4) {
                return;
            }
            textView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Context context, d<?> dVar, com.google.android.material.datepicker.a aVar, g.l lVar) {
        i k4 = aVar.k();
        i h4 = aVar.h();
        i j4 = aVar.j();
        if (k4.compareTo(j4) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        }
        if (j4.compareTo(h4) > 0) {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        this.f3011f = (j.f3003f * g.B1(context)) + (h.s1(context) ? g.B1(context) : 0);
        this.f3008c = aVar;
        this.f3009d = dVar;
        this.f3010e = lVar;
        s(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        return this.f3008c.i();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public long d(int i4) {
        return this.f3008c.k().l(i4).k();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i v(int i4) {
        return this.f3008c.k().l(i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence w(int i4) {
        return v(i4).j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int x(i iVar) {
        return this.f3008c.k().m(iVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void j(b bVar, int i4) {
        i l4 = this.f3008c.k().l(i4);
        bVar.f3014t.setText(l4.j());
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) bVar.f3015u.findViewById(m0.f.f4992e);
        if (materialCalendarGridView.getAdapter() == null || !l4.equals(materialCalendarGridView.getAdapter().f3004b)) {
            j jVar = new j(l4, this.f3009d, this.f3008c);
            materialCalendarGridView.setNumColumns(l4.f3000f);
            materialCalendarGridView.setAdapter((ListAdapter) jVar);
        } else {
            materialCalendarGridView.getAdapter().notifyDataSetChanged();
        }
        materialCalendarGridView.setOnItemClickListener(new a(materialCalendarGridView));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public b l(ViewGroup viewGroup, int i4) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(m0.h.f5020g, viewGroup, false);
        if (!h.s1(viewGroup.getContext())) {
            return new b(linearLayout, false);
        }
        linearLayout.setLayoutParams(new RecyclerView.p(-1, this.f3011f));
        return new b(linearLayout, true);
    }
}
