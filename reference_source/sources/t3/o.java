package t3;

import java.io.IOException;

/* loaded from: classes.dex */
public final class o extends IOException {

    /* renamed from: b, reason: collision with root package name */
    public final b f6205b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(b bVar) {
        super("stream was reset: " + bVar);
        e3.f.e(bVar, "errorCode");
        this.f6205b = bVar;
    }
}
