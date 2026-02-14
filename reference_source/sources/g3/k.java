package g3;

/* loaded from: classes.dex */
class k {
    public static final void a(boolean z4, Number number) {
        e3.f.e(number, "step");
        if (z4) {
            return;
        }
        throw new IllegalArgumentException("Step must be positive, was: " + number + '.');
    }
}
