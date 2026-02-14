package b1;

/* loaded from: classes.dex */
public class e extends d {

    /* renamed from: a, reason: collision with root package name */
    float f2132a = -1.0f;

    @Override // b1.d
    public void a(m mVar, float f4, float f5, float f6) {
        mVar.o(0.0f, f6 * f5, 180.0f, 180.0f - f4);
        double d5 = f6;
        double d6 = f5;
        mVar.m((float) (Math.sin(Math.toRadians(f4)) * d5 * d6), (float) (Math.sin(Math.toRadians(90.0f - f4)) * d5 * d6));
    }
}
