package g2;

import g1.s;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f4023a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(boolean z4) {
        this.f4023a = z4;
    }

    public void a(s[] sVarArr) {
        if (!this.f4023a || sVarArr == null || sVarArr.length < 3) {
            return;
        }
        s sVar = sVarArr[0];
        sVarArr[0] = sVarArr[2];
        sVarArr[2] = sVar;
    }
}
