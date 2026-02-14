package m3;

import j3.v;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a */
    public static final d f5188a = new d();

    private d() {
    }

    public static /* synthetic */ String b(d dVar, String str, int i4, int i5, String str2, boolean z4, boolean z5, boolean z6, boolean z7, Charset charset, int i6, Object obj) {
        return dVar.a(str, (i6 & 1) != 0 ? 0 : i4, (i6 & 2) != 0 ? str.length() : i5, str2, (i6 & 8) != 0 ? false : z4, (i6 & 16) != 0 ? false : z5, (i6 & 32) != 0 ? false : z6, (i6 & 64) != 0 ? false : z7, (i6 & 128) != 0 ? null : charset);
    }

    public final String a(String str, int i4, int i5, String str2, boolean z4, boolean z5, boolean z6, boolean z7, Charset charset) {
        boolean B;
        e3.f.e(str, "<this>");
        e3.f.e(str2, "encodeSet");
        int i6 = i4;
        while (i6 < i5) {
            int codePointAt = str.codePointAt(i6);
            if (codePointAt >= 32 && codePointAt != 127 && (codePointAt < 128 || z7)) {
                B = v.B(str2, (char) codePointAt, false, 2, null);
                if (!B && ((codePointAt != 37 || (z4 && (!z5 || a.f5185a.D(str, i6, i5)))) && (codePointAt != 43 || !z6))) {
                    i6 += Character.charCount(codePointAt);
                }
            }
            b4.d dVar = new b4.d();
            dVar.h(str, i4, i6);
            c(dVar, str, i6, i5, str2, z4, z5, z6, z7, charset);
            return dVar.Z();
        }
        String substring = str.substring(i4, i5);
        e3.f.d(substring, "substring(...)");
        return substring;
    }

    public final void c(b4.d dVar, String str, int i4, int i5, String str2, boolean z4, boolean z5, boolean z6, boolean z7, Charset charset) {
        boolean B;
        e3.f.e(dVar, "<this>");
        e3.f.e(str, "input");
        e3.f.e(str2, "encodeSet");
        int i6 = i4;
        b4.d dVar2 = null;
        while (i6 < i5) {
            int codePointAt = str.codePointAt(i6);
            if (!z4 || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                String str3 = "+";
                if (codePointAt != 32 || str2 != " !\"#$&'()+,/:;<=>?@[\\]^`{|}~") {
                    if (codePointAt != 43 || !z6) {
                        if (codePointAt >= 32 && codePointAt != 127 && (codePointAt < 128 || z7)) {
                            B = v.B(str2, (char) codePointAt, false, 2, null);
                            if (!B && (codePointAt != 37 || (z4 && (!z5 || a.f5185a.D(str, i6, i5))))) {
                                dVar.r(codePointAt);
                            }
                        }
                        if (dVar2 == null) {
                            dVar2 = new b4.d();
                        }
                        if (charset == null || e3.f.a(charset, j3.d.f4249b)) {
                            dVar2.r(codePointAt);
                        } else {
                            dVar2.p0(str, i6, Character.charCount(codePointAt) + i6, charset);
                        }
                        while (!dVar2.z()) {
                            int H = dVar2.H() & 255;
                            dVar.B(37);
                            a aVar = a.f5185a;
                            dVar.B(aVar.A()[(H >> 4) & 15]);
                            dVar.B(aVar.A()[H & 15]);
                        }
                    } else if (!z4) {
                        str3 = "%2B";
                    }
                }
                dVar.x(str3);
            }
            i6 += Character.charCount(codePointAt);
        }
    }
}
