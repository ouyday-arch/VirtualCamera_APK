package v2;

import java.util.List;

/* loaded from: classes.dex */
public final class m extends w {
    public static /* bridge */ /* synthetic */ Appendable C(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i4, CharSequence charSequence4, d3.b bVar, int i5, Object obj) {
        Appendable B;
        B = w.B(iterable, appendable, (r14 & 2) != 0 ? ", " : charSequence, (r14 & 4) != 0 ? "" : charSequence2, (r14 & 8) == 0 ? charSequence3 : "", (r14 & 16) != 0 ? -1 : i4, (r14 & 32) != 0 ? "..." : charSequence4, (r14 & 64) != 0 ? null : bVar);
        return B;
    }

    public static /* bridge */ /* synthetic */ Object I(Iterable iterable) {
        return w.I(iterable);
    }

    public static /* bridge */ /* synthetic */ List d(Object obj) {
        return n.d(obj);
    }

    public static /* bridge */ /* synthetic */ List i() {
        return o.i();
    }

    public static /* bridge */ /* synthetic */ int k(List list) {
        return o.k(list);
    }

    public static /* bridge */ /* synthetic */ void q() {
        o.q();
    }

    public static /* bridge */ /* synthetic */ int r(Iterable iterable, int i4) {
        return p.r(iterable, i4);
    }
}
