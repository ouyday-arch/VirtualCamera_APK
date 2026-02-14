package c4;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a */
    private static final char[] f2455a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX WARN: Removed duplicated region for block: B:174:0x0220 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0047 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0083 A[EDGE_INSN: B:267:0x0083->B:268:0x0083 BREAK  A[LOOP:1: B:249:0x0051->B:276:0x008a, LOOP_LABEL: LOOP:0: B:2:0x0008->B:43:0x0008], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00df A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0173 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final int c(byte[] r19, int r20) {
        /*
            Method dump skipped, instructions count: 565
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c4.b.c(byte[], int):int");
    }

    public static final void d(b4.g gVar, b4.d dVar, int i4, int i5) {
        e3.f.e(gVar, "<this>");
        e3.f.e(dVar, "buffer");
        dVar.d(gVar.f(), i4, i5);
    }

    public static final int e(char c5) {
        if ('0' <= c5 && c5 < ':') {
            return c5 - '0';
        }
        char c6 = 'a';
        if (!('a' <= c5 && c5 < 'g')) {
            c6 = 'A';
            if (!('A' <= c5 && c5 < 'G')) {
                throw new IllegalArgumentException("Unexpected hex digit: " + c5);
            }
        }
        return (c5 - c6) + 10;
    }

    public static final char[] f() {
        return f2455a;
    }
}
