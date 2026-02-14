package g1;

/* loaded from: classes.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    private final float f3980a;

    /* renamed from: b, reason: collision with root package name */
    private final float f3981b;

    public s(float f4, float f5) {
        this.f3980a = f4;
        this.f3981b = f5;
    }

    private static float a(s sVar, s sVar2, s sVar3) {
        float f4 = sVar2.f3980a;
        float f5 = sVar2.f3981b;
        return ((sVar3.f3980a - f4) * (sVar.f3981b - f5)) - ((sVar3.f3981b - f5) * (sVar.f3980a - f4));
    }

    public static float b(s sVar, s sVar2) {
        return o1.a.a(sVar.f3980a, sVar.f3981b, sVar2.f3980a, sVar2.f3981b);
    }

    public static void e(s[] sVarArr) {
        s sVar;
        s sVar2;
        s sVar3;
        float b5 = b(sVarArr[0], sVarArr[1]);
        float b6 = b(sVarArr[1], sVarArr[2]);
        float b7 = b(sVarArr[0], sVarArr[2]);
        if (b6 >= b5 && b6 >= b7) {
            sVar = sVarArr[0];
            sVar2 = sVarArr[1];
            sVar3 = sVarArr[2];
        } else if (b7 < b6 || b7 < b5) {
            sVar = sVarArr[2];
            sVar2 = sVarArr[0];
            sVar3 = sVarArr[1];
        } else {
            sVar = sVarArr[1];
            sVar2 = sVarArr[0];
            sVar3 = sVarArr[2];
        }
        if (a(sVar2, sVar, sVar3) < 0.0f) {
            s sVar4 = sVar3;
            sVar3 = sVar2;
            sVar2 = sVar4;
        }
        sVarArr[0] = sVar2;
        sVarArr[1] = sVar;
        sVarArr[2] = sVar3;
    }

    public final float c() {
        return this.f3980a;
    }

    public final float d() {
        return this.f3981b;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof s) {
            s sVar = (s) obj;
            if (this.f3980a == sVar.f3980a && this.f3981b == sVar.f3981b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f3980a) * 31) + Float.floatToIntBits(this.f3981b);
    }

    public final String toString() {
        return "(" + this.f3980a + ',' + this.f3981b + ')';
    }
}
