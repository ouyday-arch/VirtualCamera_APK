package q2;

import android.graphics.Rect;
import android.util.Log;

/* loaded from: classes.dex */
public class l extends q {

    /* renamed from: b, reason: collision with root package name */
    private static final String f5611b = "l";

    @Override // q2.q
    protected float c(p2.q qVar, p2.q qVar2) {
        if (qVar.f5467b <= 0 || qVar.f5468c <= 0) {
            return 0.0f;
        }
        p2.q c5 = qVar.c(qVar2);
        float f4 = (c5.f5467b * 1.0f) / qVar.f5467b;
        if (f4 > 1.0f) {
            f4 = (float) Math.pow(1.0f / f4, 1.1d);
        }
        float f5 = ((c5.f5467b * 1.0f) / qVar2.f5467b) + ((c5.f5468c * 1.0f) / qVar2.f5468c);
        return f4 * ((1.0f / f5) / f5);
    }

    @Override // q2.q
    public Rect d(p2.q qVar, p2.q qVar2) {
        p2.q c5 = qVar.c(qVar2);
        Log.i(f5611b, "Preview: " + qVar + "; Scaled: " + c5 + "; Want: " + qVar2);
        int i4 = (c5.f5467b - qVar2.f5467b) / 2;
        int i5 = (c5.f5468c - qVar2.f5468c) / 2;
        return new Rect(-i4, -i5, c5.f5467b - i4, c5.f5468c - i5);
    }
}
