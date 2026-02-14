package b4;

import java.io.RandomAccessFile;

/* loaded from: classes.dex */
public class r extends j {
    @Override // b4.j
    public h a(y yVar) {
        e3.f.e(yVar, "file");
        return new q(false, new RandomAccessFile(yVar.m(), "r"));
    }

    @Override // b4.j
    public g0 b(y yVar) {
        e3.f.e(yVar, "file");
        return t.e(yVar.m());
    }

    public String toString() {
        return "JvmSystemFileSystem";
    }
}
