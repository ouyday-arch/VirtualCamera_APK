package a0;

import a0.b;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;

/* loaded from: classes.dex */
public abstract class a extends BaseAdapter implements Filterable, b.a {

    /* renamed from: b, reason: collision with root package name */
    protected boolean f263b;

    /* renamed from: c, reason: collision with root package name */
    protected boolean f264c;

    /* renamed from: d, reason: collision with root package name */
    protected Cursor f265d;

    /* renamed from: e, reason: collision with root package name */
    protected Context f266e;

    /* renamed from: f, reason: collision with root package name */
    protected int f267f;

    /* renamed from: g, reason: collision with root package name */
    protected C0000a f268g;

    /* renamed from: h, reason: collision with root package name */
    protected DataSetObserver f269h;

    /* renamed from: i, reason: collision with root package name */
    protected a0.b f270i;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a0.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0000a extends ContentObserver {
        C0000a() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z4) {
            a.this.i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends DataSetObserver {
        b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            a aVar = a.this;
            aVar.f263b = true;
            aVar.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            a aVar = a.this;
            aVar.f263b = false;
            aVar.notifyDataSetInvalidated();
        }
    }

    public a(Context context, Cursor cursor, boolean z4) {
        f(context, cursor, z4 ? 1 : 2);
    }

    @Override // a0.b.a
    public abstract CharSequence a(Cursor cursor);

    @Override // a0.b.a
    public void b(Cursor cursor) {
        Cursor j4 = j(cursor);
        if (j4 != null) {
            j4.close();
        }
    }

    @Override // a0.b.a
    public Cursor c() {
        return this.f265d;
    }

    public abstract void e(View view, Context context, Cursor cursor);

    void f(Context context, Cursor cursor, int i4) {
        b bVar;
        if ((i4 & 1) == 1) {
            i4 |= 2;
            this.f264c = true;
        } else {
            this.f264c = false;
        }
        boolean z4 = cursor != null;
        this.f265d = cursor;
        this.f263b = z4;
        this.f266e = context;
        this.f267f = z4 ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i4 & 2) == 2) {
            this.f268g = new C0000a();
            bVar = new b();
        } else {
            bVar = null;
            this.f268g = null;
        }
        this.f269h = bVar;
        if (z4) {
            C0000a c0000a = this.f268g;
            if (c0000a != null) {
                cursor.registerContentObserver(c0000a);
            }
            DataSetObserver dataSetObserver = this.f269h;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public abstract View g(Context context, Cursor cursor, ViewGroup viewGroup);

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor cursor;
        if (!this.f263b || (cursor = this.f265d) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i4, View view, ViewGroup viewGroup) {
        if (!this.f263b) {
            return null;
        }
        this.f265d.moveToPosition(i4);
        if (view == null) {
            view = g(this.f266e, this.f265d, viewGroup);
        }
        e(view, this.f266e, this.f265d);
        return view;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f270i == null) {
            this.f270i = new a0.b(this);
        }
        return this.f270i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i4) {
        Cursor cursor;
        if (!this.f263b || (cursor = this.f265d) == null) {
            return null;
        }
        cursor.moveToPosition(i4);
        return this.f265d;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i4) {
        Cursor cursor;
        if (this.f263b && (cursor = this.f265d) != null && cursor.moveToPosition(i4)) {
            return this.f265d.getLong(this.f267f);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i4, View view, ViewGroup viewGroup) {
        if (!this.f263b) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (this.f265d.moveToPosition(i4)) {
            if (view == null) {
                view = h(this.f266e, this.f265d, viewGroup);
            }
            e(view, this.f266e, this.f265d);
            return view;
        }
        throw new IllegalStateException("couldn't move cursor to position " + i4);
    }

    public abstract View h(Context context, Cursor cursor, ViewGroup viewGroup);

    protected void i() {
        Cursor cursor;
        if (!this.f264c || (cursor = this.f265d) == null || cursor.isClosed()) {
            return;
        }
        this.f263b = this.f265d.requery();
    }

    public Cursor j(Cursor cursor) {
        Cursor cursor2 = this.f265d;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            C0000a c0000a = this.f268g;
            if (c0000a != null) {
                cursor2.unregisterContentObserver(c0000a);
            }
            DataSetObserver dataSetObserver = this.f269h;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f265d = cursor;
        if (cursor != null) {
            C0000a c0000a2 = this.f268g;
            if (c0000a2 != null) {
                cursor.registerContentObserver(c0000a2);
            }
            DataSetObserver dataSetObserver2 = this.f269h;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.f267f = cursor.getColumnIndexOrThrow("_id");
            this.f263b = true;
            notifyDataSetChanged();
        } else {
            this.f267f = -1;
            this.f263b = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }
}
