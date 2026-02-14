package q2;

import android.graphics.Rect;

/* loaded from: classes.dex */
public class o extends q {
    private static float e(float f4) {
        return f4 < 1.0f ? 1.0f / f4 : f4;
    }

    @Override // q2.q
    protected float c(p2.q qVar, p2.q qVar2) {
        int i4 = qVar.f5467b;
        if (i4 <= 0 || qVar.f5468c <= 0) {
            return 0.0f;
        }
        float e4 = (1.0f / e((i4 * 1.0f) / qVar2.f5467b)) / e((qVar.f5468c * 1.0f) / qVar2.f5468c);
        float e5 = e(((qVar.f5467b * 1.0f) / qVar.f5468c) / ((qVar2.f5467b * 1.0f) / qVar2.f5468c));
        return e4 * (((1.0f / e5) / e5) / e5);
    }

    @Override // q2.q
    public Rect d(p2.q qVar, p2.q qVar2) {
        return new Rect(0, 0, qVar2.f5467b, qVar2.f5468c);
    }
}
