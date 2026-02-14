package m3;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a */
    public static final b f5187a = new b();

    private b() {
    }

    public final String a(String str, int i4, int i5, String str2, boolean z4, boolean z5, boolean z6, boolean z7) {
        String a5;
        e3.f.e(str, "<this>");
        e3.f.e(str2, "encodeSet");
        a5 = d.f5188a.a(str, (r23 & 1) != 0 ? 0 : i4, (r23 & 2) != 0 ? str.length() : i5, str2, (r23 & 8) != 0 ? false : z4, (r23 & 16) != 0 ? false : z5, (r23 & 32) != 0 ? false : z6, (r23 & 64) != 0 ? false : z7, (r23 & 128) != 0 ? null : null);
        return a5;
    }

    public final void c(b4.d dVar, String str, int i4, int i5, boolean z4) {
        int i6;
        e3.f.e(dVar, "<this>");
        e3.f.e(str, "encoded");
        while (i4 < i5) {
            int codePointAt = str.codePointAt(i4);
            if (codePointAt != 37 || (i6 = i4 + 2) >= i5) {
                if (codePointAt == 43 && z4) {
                    dVar.B(32);
                    i4++;
                }
                dVar.r(codePointAt);
                i4 += Character.charCount(codePointAt);
            } else {
                int A = p.A(str.charAt(i4 + 1));
                int A2 = p.A(str.charAt(i6));
                if (A != -1 && A2 != -1) {
                    dVar.B((A << 4) + A2);
                    i4 = Character.charCount(codePointAt) + i6;
                }
                dVar.r(codePointAt);
                i4 += Character.charCount(codePointAt);
            }
        }
    }
}
