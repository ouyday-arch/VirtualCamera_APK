package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.datepicker.g;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends RecyclerView.g<b> {

    /* renamed from: c, reason: collision with root package name */
    private final g<?> f3017c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f3018b;

        a(int i4) {
            this.f3018b = i4;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            p.this.f3017c.E1(p.this.f3017c.x1().f(i.g(this.f3018b, p.this.f3017c.z1().f2998d)));
            p.this.f3017c.F1(g.k.DAY);
        }
    }

    /* loaded from: classes.dex */
    public static class b extends RecyclerView.d0 {

        /* renamed from: t, reason: collision with root package name */
        final TextView f3020t;

        b(TextView textView) {
            super(textView);
            this.f3020t = textView;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(g<?> gVar) {
        this.f3017c = gVar;
    }

    private View.OnClickListener v(int i4) {
        return new a(i4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int c() {
        return this.f3017c.x1().l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int w(int i4) {
        return i4 - this.f3017c.x1().k().f2999e;
    }

    int x(int i4) {
        return this.f3017c.x1().k().f2999e + i4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void j(b bVar, int i4) {
        int x4 = x(i4);
        String string = bVar.f3020t.getContext().getString(m0.i.f5031i);
        bVar.f3020t.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(x4)));
        bVar.f3020t.setContentDescription(String.format(string, Integer.valueOf(x4)));
        c y12 = this.f3017c.y1();
        Calendar g4 = o.g();
        com.google.android.material.datepicker.b bVar2 = g4.get(1) == x4 ? y12.f2953f : y12.f2951d;
        Iterator<Long> it = this.f3017c.A1().e().iterator();
        while (it.hasNext()) {
            g4.setTimeInMillis(it.next().longValue());
            if (g4.get(1) == x4) {
                bVar2 = y12.f2952e;
            }
        }
        bVar2.d(bVar.f3020t);
        bVar.f3020t.setOnClickListener(v(x4));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public b l(ViewGroup viewGroup, int i4) {
        return new b((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(m0.h.f5022i, viewGroup, false));
    }
}
