package q2;

import android.graphics.Rect;
import android.util.Log;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class q {

    /* renamed from: a, reason: collision with root package name */
    private static final String f5617a = "q";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Comparator<p2.q> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ p2.q f5618b;

        a(p2.q qVar) {
            this.f5618b = qVar;
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(p2.q qVar, p2.q qVar2) {
            return Float.compare(q.this.c(qVar2, this.f5618b), q.this.c(qVar, this.f5618b));
        }
    }

    public List<p2.q> a(List<p2.q> list, p2.q qVar) {
        if (qVar == null) {
            return list;
        }
        Collections.sort(list, new a(qVar));
        return list;
    }

    public p2.q b(List<p2.q> list, p2.q qVar) {
        List<p2.q> a5 = a(list, qVar);
        String str = f5617a;
        Log.i(str, "Viewfinder size: " + qVar);
        Log.i(str, "Preview in order of preference: " + a5);
        return a5.get(0);
    }

    protected abstract float c(p2.q qVar, p2.q qVar2);

    public abstract Rect d(p2.q qVar, p2.q qVar2);
}
