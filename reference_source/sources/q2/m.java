package q2;

import android.graphics.Rect;
import java.util.List;

/* loaded from: classes.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private p2.q f5612a;

    /* renamed from: b, reason: collision with root package name */
    private int f5613b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f5614c = false;

    /* renamed from: d, reason: collision with root package name */
    private q f5615d = new n();

    public m(int i4, p2.q qVar) {
        this.f5613b = i4;
        this.f5612a = qVar;
    }

    public p2.q a(List<p2.q> list, boolean z4) {
        return this.f5615d.b(list, b(z4));
    }

    public p2.q b(boolean z4) {
        p2.q qVar = this.f5612a;
        if (qVar == null) {
            return null;
        }
        return z4 ? qVar.b() : qVar;
    }

    public int c() {
        return this.f5613b;
    }

    public Rect d(p2.q qVar) {
        return this.f5615d.d(qVar, this.f5612a);
    }

    public void e(q qVar) {
        this.f5615d = qVar;
    }
}
