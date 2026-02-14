package androidx.core.widget;

import android.widget.ListView;

/* loaded from: classes.dex */
public class f extends a {

    /* renamed from: t, reason: collision with root package name */
    private final ListView f1402t;

    public f(ListView listView) {
        super(listView);
        this.f1402t = listView;
    }

    @Override // androidx.core.widget.a
    public boolean a(int i4) {
        return false;
    }

    @Override // androidx.core.widget.a
    public boolean b(int i4) {
        ListView listView = this.f1402t;
        int count = listView.getCount();
        if (count == 0) {
            return false;
        }
        int childCount = listView.getChildCount();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int i5 = firstVisiblePosition + childCount;
        if (i4 > 0) {
            if (i5 >= count && listView.getChildAt(childCount - 1).getBottom() <= listView.getHeight()) {
                return false;
            }
        } else {
            if (i4 >= 0) {
                return false;
            }
            if (firstVisiblePosition <= 0 && listView.getChildAt(0).getTop() >= 0) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.core.widget.a
    public void j(int i4, int i5) {
        g.a(this.f1402t, i5);
    }
}
