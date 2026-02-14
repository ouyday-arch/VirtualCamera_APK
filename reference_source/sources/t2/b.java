package t2;

import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/* loaded from: classes.dex */
class b implements q {

    /* renamed from: b, reason: collision with root package name */
    private final String[] f5951b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String[] strArr) {
        this.f5951b = strArr;
    }

    @Override // t2.q
    public void g(OutputStream outputStream) {
        for (String str : this.f5951b) {
            outputStream.write(str.getBytes(StandardCharsets.UTF_8));
            outputStream.write(10);
        }
    }
}
