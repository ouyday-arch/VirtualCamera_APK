package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.k;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class d extends BaseAdapter {

    /* renamed from: b, reason: collision with root package name */
    e f632b;

    /* renamed from: c, reason: collision with root package name */
    private int f633c = -1;

    /* renamed from: d, reason: collision with root package name */
    private boolean f634d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f635e;

    /* renamed from: f, reason: collision with root package name */
    private final LayoutInflater f636f;

    /* renamed from: g, reason: collision with root package name */
    private final int f637g;

    public d(e eVar, LayoutInflater layoutInflater, boolean z4, int i4) {
        this.f635e = z4;
        this.f636f = layoutInflater;
        this.f632b = eVar;
        this.f637g = i4;
        a();
    }

    void a() {
        g v4 = this.f632b.v();
        if (v4 != null) {
            ArrayList<g> z4 = this.f632b.z();
            int size = z4.size();
            for (int i4 = 0; i4 < size; i4++) {
                if (z4.get(i4) == v4) {
                    this.f633c = i4;
                    return;
                }
            }
        }
        this.f633c = -1;
    }

    public e b() {
        return this.f632b;
    }

    @Override // android.widget.Adapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public g getItem(int i4) {
        ArrayList<g> z4 = this.f635e ? this.f632b.z() : this.f632b.E();
        int i5 = this.f633c;
        if (i5 >= 0 && i4 >= i5) {
            i4++;
        }
        return z4.get(i4);
    }

    public void d(boolean z4) {
        this.f634d = z4;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<g> z4 = this.f635e ? this.f632b.z() : this.f632b.E();
        int i4 = this.f633c;
        int size = z4.size();
        return i4 < 0 ? size : size - 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i4) {
        return i4;
    }

    @Override // android.widget.Adapter
    public View getView(int i4, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f636f.inflate(this.f637g, viewGroup, false);
        }
        int groupId = getItem(i4).getGroupId();
        int i5 = i4 - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f632b.F() && groupId != (i5 >= 0 ? getItem(i5).getGroupId() : groupId));
        k.a aVar = (k.a) view;
        if (this.f634d) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.e(getItem(i4), 0);
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
