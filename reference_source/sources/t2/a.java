package t2;

import android.text.TextUtils;
import java.io.IOException;
import s2.b;

/* loaded from: classes.dex */
public final class a extends b.a {

    /* renamed from: a, reason: collision with root package name */
    long f5948a = 20;

    /* renamed from: b, reason: collision with root package name */
    private int f5949b = 0;

    /* renamed from: c, reason: collision with root package name */
    private b.c[] f5950c;

    @Override // s2.b.a
    public b.a b(int i4) {
        this.f5949b = i4;
        return this;
    }

    @Override // s2.b.a
    public b.a c(long j4) {
        this.f5948a = j4;
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0024, code lost:
    
        if (r2.M() == false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public t2.p d() {
        /*
            r6 = this;
            java.lang.String r0 = t2.w.f()
            r1 = 1
            boolean r2 = r6.g(r1)
            r3 = 0
            r4 = 0
            if (r2 != 0) goto L26
            r2 = 2
            boolean r5 = r6.g(r2)
            if (r5 == 0) goto L26
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: s2.a -> L26
            r2[r3] = r0     // Catch: s2.a -> L26
            java.lang.String r5 = "--mount-master"
            r2[r1] = r5     // Catch: s2.a -> L26
            t2.p r2 = r6.f(r2)     // Catch: s2.a -> L26
            boolean r5 = r2.M()     // Catch: s2.a -> L27
            if (r5 != 0) goto L27
        L26:
            r2 = r4
        L27:
            if (r2 != 0) goto L40
            boolean r5 = r6.g(r1)
            if (r5 != 0) goto L40
            java.lang.String[] r5 = new java.lang.String[r1]     // Catch: s2.a -> L40
            r5[r3] = r0     // Catch: s2.a -> L40
            t2.p r2 = r6.f(r5)     // Catch: s2.a -> L40
            boolean r0 = r2.M()     // Catch: s2.a -> L40
            if (r0 != 0) goto L3e
            goto L3f
        L3e:
            r4 = r2
        L3f:
            r2 = r4
        L40:
            if (r2 != 0) goto L55
            boolean r0 = r6.g(r1)
            if (r0 != 0) goto L4b
            t2.w.h(r3)
        L4b:
            java.lang.String r0 = "sh"
            java.lang.String[] r0 = new java.lang.String[]{r0}
            t2.p r2 = r6.f(r0)
        L55:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: t2.a.d():t2.p");
    }

    public p e(Process process) {
        try {
            p pVar = new p(this, process);
            g.k(pVar);
            if (this.f5950c != null) {
                w.d();
                for (b.c cVar : this.f5950c) {
                }
            }
            return pVar;
        } catch (IOException e4) {
            throw new s2.a("Unable to create a shell!", e4);
        }
    }

    public p f(String... strArr) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("exec ");
            sb.append(TextUtils.join(" ", strArr));
            return e(Runtime.getRuntime().exec(strArr));
        } catch (IOException e4) {
            throw new s2.a("Unable to create a shell!", e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g(int i4) {
        return (this.f5949b & i4) == i4;
    }
}
