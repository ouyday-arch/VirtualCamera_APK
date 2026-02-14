package b1;

/* loaded from: classes.dex */
public class j extends d {

    /* renamed from: a, reason: collision with root package name */
    float f2183a = -1.0f;

    @Override // b1.d
    public void a(m mVar, float f4, float f5, float f6) {
        mVar.o(0.0f, f6 * f5, 180.0f, 180.0f - f4);
        float f7 = f6 * 2.0f * f5;
        mVar.a(0.0f, 0.0f, f7, f7, 180.0f, f4);
    }
}
