package w1;

import java.util.Map;

/* loaded from: classes.dex */
public final class u implements g1.u {

    /* renamed from: a, reason: collision with root package name */
    private final j f6397a = new j();

    @Override // g1.u
    public n1.b a(String str, g1.a aVar, int i4, int i5, Map<g1.g, ?> map) {
        if (aVar == g1.a.UPC_A) {
            return this.f6397a.a("0".concat(String.valueOf(str)), g1.a.EAN_13, i4, i5, map);
        }
        throw new IllegalArgumentException("Can only encode UPC-A, but got ".concat(String.valueOf(aVar)));
    }
}
