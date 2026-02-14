package androidx.appcompat.app;

/* loaded from: classes.dex */
class g {

    /* renamed from: d, reason: collision with root package name */
    private static g f496d;

    /* renamed from: a, reason: collision with root package name */
    public long f497a;

    /* renamed from: b, reason: collision with root package name */
    public long f498b;

    /* renamed from: c, reason: collision with root package name */
    public int f499c;

    g() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g b() {
        if (f496d == null) {
            f496d = new g();
        }
        return f496d;
    }

    public void a(long j4, double d5, double d6) {
        double d7 = (0.01720197f * (((float) (j4 - 946728000000L)) / 8.64E7f)) + 6.24006f;
        double sin = (Math.sin(d7) * 0.03341960161924362d) + d7 + (Math.sin(2.0f * r4) * 3.4906598739326E-4d) + (Math.sin(r4 * 3.0f) * 5.236000106378924E-6d) + 1.796593063d + 3.141592653589793d;
        double round = ((float) Math.round((r3 - 9.0E-4f) - r9)) + 9.0E-4f + ((-d6) / 360.0d) + (Math.sin(d7) * 0.0053d) + (Math.sin(2.0d * sin) * (-0.0069d));
        double asin = Math.asin(Math.sin(sin) * Math.sin(0.4092797040939331d));
        double d8 = 0.01745329238474369d * d5;
        double sin2 = (Math.sin(-0.10471975803375244d) - (Math.sin(d8) * Math.sin(asin))) / (Math.cos(d8) * Math.cos(asin));
        if (sin2 >= 1.0d) {
            this.f499c = 1;
        } else {
            if (sin2 > -1.0d) {
                double acos = (float) (Math.acos(sin2) / 6.283185307179586d);
                this.f497a = Math.round((round + acos) * 8.64E7d) + 946728000000L;
                long round2 = Math.round((round - acos) * 8.64E7d) + 946728000000L;
                this.f498b = round2;
                if (round2 >= j4 || this.f497a <= j4) {
                    this.f499c = 1;
                    return;
                } else {
                    this.f499c = 0;
                    return;
                }
            }
            this.f499c = 0;
        }
        this.f497a = -1L;
        this.f498b = -1L;
    }
}
