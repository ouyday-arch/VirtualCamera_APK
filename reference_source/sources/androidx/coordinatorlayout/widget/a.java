package androidx.coordinatorlayout.widget;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import k.g;
import x.e;
import x.f;

/* loaded from: classes.dex */
public final class a<T> {

    /* renamed from: a, reason: collision with root package name */
    private final e<ArrayList<T>> f1323a = new f(10);

    /* renamed from: b, reason: collision with root package name */
    private final g<T, ArrayList<T>> f1324b = new g<>();

    /* renamed from: c, reason: collision with root package name */
    private final ArrayList<T> f1325c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    private final HashSet<T> f1326d = new HashSet<>();

    private void e(T t4, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (arrayList.contains(t4)) {
            return;
        }
        if (hashSet.contains(t4)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet.add(t4);
        ArrayList<T> arrayList2 = this.f1324b.get(t4);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i4 = 0; i4 < size; i4++) {
                e(arrayList2.get(i4), arrayList, hashSet);
            }
        }
        hashSet.remove(t4);
        arrayList.add(t4);
    }

    private ArrayList<T> f() {
        ArrayList<T> b5 = this.f1323a.b();
        return b5 == null ? new ArrayList<>() : b5;
    }

    private void k(ArrayList<T> arrayList) {
        arrayList.clear();
        this.f1323a.a(arrayList);
    }

    public void a(T t4, T t5) {
        if (!this.f1324b.containsKey(t4) || !this.f1324b.containsKey(t5)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList<T> arrayList = this.f1324b.get(t4);
        if (arrayList == null) {
            arrayList = f();
            this.f1324b.put(t4, arrayList);
        }
        arrayList.add(t5);
    }

    public void b(T t4) {
        if (this.f1324b.containsKey(t4)) {
            return;
        }
        this.f1324b.put(t4, null);
    }

    public void c() {
        int size = this.f1324b.size();
        for (int i4 = 0; i4 < size; i4++) {
            ArrayList<T> m4 = this.f1324b.m(i4);
            if (m4 != null) {
                k(m4);
            }
        }
        this.f1324b.clear();
    }

    public boolean d(T t4) {
        return this.f1324b.containsKey(t4);
    }

    public List g(T t4) {
        return this.f1324b.get(t4);
    }

    public List<T> h(T t4) {
        int size = this.f1324b.size();
        ArrayList arrayList = null;
        for (int i4 = 0; i4 < size; i4++) {
            ArrayList<T> m4 = this.f1324b.m(i4);
            if (m4 != null && m4.contains(t4)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.f1324b.i(i4));
            }
        }
        return arrayList;
    }

    public ArrayList<T> i() {
        this.f1325c.clear();
        this.f1326d.clear();
        int size = this.f1324b.size();
        for (int i4 = 0; i4 < size; i4++) {
            e(this.f1324b.i(i4), this.f1325c, this.f1326d);
        }
        return this.f1325c;
    }

    public boolean j(T t4) {
        int size = this.f1324b.size();
        for (int i4 = 0; i4 < size; i4++) {
            ArrayList<T> m4 = this.f1324b.m(i4);
            if (m4 != null && m4.contains(t4)) {
                return true;
            }
        }
        return false;
    }
}
