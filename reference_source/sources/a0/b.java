package a0;

import android.database.Cursor;
import android.widget.Filter;

/* loaded from: classes.dex */
class b extends Filter {

    /* renamed from: a, reason: collision with root package name */
    a f273a;

    /* loaded from: classes.dex */
    interface a {
        CharSequence a(Cursor cursor);

        void b(Cursor cursor);

        Cursor c();

        Cursor d(CharSequence charSequence);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f273a = aVar;
    }

    @Override // android.widget.Filter
    public CharSequence convertResultToString(Object obj) {
        return this.f273a.a((Cursor) obj);
    }

    @Override // android.widget.Filter
    protected Filter.FilterResults performFiltering(CharSequence charSequence) {
        Cursor d5 = this.f273a.d(charSequence);
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (d5 != null) {
            filterResults.count = d5.getCount();
        } else {
            filterResults.count = 0;
            d5 = null;
        }
        filterResults.values = d5;
        return filterResults;
    }

    @Override // android.widget.Filter
    protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        Cursor c5 = this.f273a.c();
        Object obj = filterResults.values;
        if (obj == null || obj == c5) {
            return;
        }
        this.f273a.b((Cursor) obj);
    }
}
