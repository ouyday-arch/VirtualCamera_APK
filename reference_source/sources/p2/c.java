package p2;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    protected g1.q f5432a;

    /* renamed from: b, reason: collision with root package name */
    protected r f5433b;

    /* renamed from: c, reason: collision with root package name */
    private final int f5434c = 2;

    public c(g1.q qVar, r rVar) {
        this.f5432a = qVar;
        this.f5433b = rVar;
    }

    public static List<g1.s> e(List<g1.s> list, r rVar) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<g1.s> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(rVar.f(it.next()));
        }
        return arrayList;
    }

    public g1.a a() {
        return this.f5432a.b();
    }

    public Bitmap b() {
        return this.f5433b.b(null, 2);
    }

    public byte[] c() {
        return this.f5432a.c();
    }

    public Map<g1.r, Object> d() {
        return this.f5432a.d();
    }

    public String toString() {
        return this.f5432a.f();
    }
}
