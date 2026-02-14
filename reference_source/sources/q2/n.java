package q2;

import android.graphics.Rect;
import android.util.Log;

/* loaded from: classes.dex */
public class n extends q {

    /* renamed from: b, reason: collision with root package name */
    private static final String f5616b = "n";

    @Override // q2.q
    protected float c(p2.q qVar, p2.q qVar2) {
        if (qVar.f5467b <= 0 || qVar.f5468c <= 0) {
            return 0.0f;
        }
        p2.q d5 = qVar.d(qVar2);
        float f4 = (d5.f5467b * 1.0f) / qVar.f5467b;
        if (f4 > 1.0f) {
            f4 = (float) Math.pow(1.0f / f4, 1.1d);
        }
        float f5 = ((qVar2.f5467b * 1.0f) / d5.f5467b) * ((qVar2.f5468c * 1.0f) / d5.f5468c);
        return f4 * (((1.0f / f5) / f5) / f5);
    }

    @Override // q2.q
    public Rect d(p2.q qVar, p2.q qVar2) {
        p2.q d5 = qVar.d(qVar2);
        Log.i(f5616b, "Preview: " + qVar + "; Scaled: " + d5 + "; Want: " + qVar2);
        int i4 = (d5.f5467b - qVar2.f5467b) / 2;
        int i5 = (d5.f5468c - qVar2.f5468c) / 2;
        return new Rect(-i4, -i5, d5.f5467b - i4, d5.f5468c - i5);
    }
}
