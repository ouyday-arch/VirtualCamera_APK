package w1;

/* loaded from: classes.dex */
public final class c extends r {

    /* renamed from: a, reason: collision with root package name */
    static final int[][] f6362a = {new int[]{2, 1, 2, 2, 2, 2}, new int[]{2, 2, 2, 1, 2, 2}, new int[]{2, 2, 2, 2, 2, 1}, new int[]{1, 2, 1, 2, 2, 3}, new int[]{1, 2, 1, 3, 2, 2}, new int[]{1, 3, 1, 2, 2, 2}, new int[]{1, 2, 2, 2, 1, 3}, new int[]{1, 2, 2, 3, 1, 2}, new int[]{1, 3, 2, 2, 1, 2}, new int[]{2, 2, 1, 2, 1, 3}, new int[]{2, 2, 1, 3, 1, 2}, new int[]{2, 3, 1, 2, 1, 2}, new int[]{1, 1, 2, 2, 3, 2}, new int[]{1, 2, 2, 1, 3, 2}, new int[]{1, 2, 2, 2, 3, 1}, new int[]{1, 1, 3, 2, 2, 2}, new int[]{1, 2, 3, 1, 2, 2}, new int[]{1, 2, 3, 2, 2, 1}, new int[]{2, 2, 3, 2, 1, 1}, new int[]{2, 2, 1, 1, 3, 2}, new int[]{2, 2, 1, 2, 3, 1}, new int[]{2, 1, 3, 2, 1, 2}, new int[]{2, 2, 3, 1, 1, 2}, new int[]{3, 1, 2, 1, 3, 1}, new int[]{3, 1, 1, 2, 2, 2}, new int[]{3, 2, 1, 1, 2, 2}, new int[]{3, 2, 1, 2, 2, 1}, new int[]{3, 1, 2, 2, 1, 2}, new int[]{3, 2, 2, 1, 1, 2}, new int[]{3, 2, 2, 2, 1, 1}, new int[]{2, 1, 2, 1, 2, 3}, new int[]{2, 1, 2, 3, 2, 1}, new int[]{2, 3, 2, 1, 2, 1}, new int[]{1, 1, 1, 3, 2, 3}, new int[]{1, 3, 1, 1, 2, 3}, new int[]{1, 3, 1, 3, 2, 1}, new int[]{1, 1, 2, 3, 1, 3}, new int[]{1, 3, 2, 1, 1, 3}, new int[]{1, 3, 2, 3, 1, 1}, new int[]{2, 1, 1, 3, 1, 3}, new int[]{2, 3, 1, 1, 1, 3}, new int[]{2, 3, 1, 3, 1, 1}, new int[]{1, 1, 2, 1, 3, 3}, new int[]{1, 1, 2, 3, 3, 1}, new int[]{1, 3, 2, 1, 3, 1}, new int[]{1, 1, 3, 1, 2, 3}, new int[]{1, 1, 3, 3, 2, 1}, new int[]{1, 3, 3, 1, 2, 1}, new int[]{3, 1, 3, 1, 2, 1}, new int[]{2, 1, 1, 3, 3, 1}, new int[]{2, 3, 1, 1, 3, 1}, new int[]{2, 1, 3, 1, 1, 3}, new int[]{2, 1, 3, 3, 1, 1}, new int[]{2, 1, 3, 1, 3, 1}, new int[]{3, 1, 1, 1, 2, 3}, new int[]{3, 1, 1, 3, 2, 1}, new int[]{3, 3, 1, 1, 2, 1}, new int[]{3, 1, 2, 1, 1, 3}, new int[]{3, 1, 2, 3, 1, 1}, new int[]{3, 3, 2, 1, 1, 1}, new int[]{3, 1, 4, 1, 1, 1}, new int[]{2, 2, 1, 4, 1, 1}, new int[]{4, 3, 1, 1, 1, 1}, new int[]{1, 1, 1, 2, 2, 4}, new int[]{1, 1, 1, 4, 2, 2}, new int[]{1, 2, 1, 1, 2, 4}, new int[]{1, 2, 1, 4, 2, 1}, new int[]{1, 4, 1, 1, 2, 2}, new int[]{1, 4, 1, 2, 2, 1}, new int[]{1, 1, 2, 2, 1, 4}, new int[]{1, 1, 2, 4, 1, 2}, new int[]{1, 2, 2, 1, 1, 4}, new int[]{1, 2, 2, 4, 1, 1}, new int[]{1, 4, 2, 1, 1, 2}, new int[]{1, 4, 2, 2, 1, 1}, new int[]{2, 4, 1, 2, 1, 1}, new int[]{2, 2, 1, 1, 1, 4}, new int[]{4, 1, 3, 1, 1, 1}, new int[]{2, 4, 1, 1, 1, 2}, new int[]{1, 3, 4, 1, 1, 1}, new int[]{1, 1, 1, 2, 4, 2}, new int[]{1, 2, 1, 1, 4, 2}, new int[]{1, 2, 1, 2, 4, 1}, new int[]{1, 1, 4, 2, 1, 2}, new int[]{1, 2, 4, 1, 1, 2}, new int[]{1, 2, 4, 2, 1, 1}, new int[]{4, 1, 1, 2, 1, 2}, new int[]{4, 2, 1, 1, 1, 2}, new int[]{4, 2, 1, 2, 1, 1}, new int[]{2, 1, 2, 1, 4, 1}, new int[]{2, 1, 4, 1, 2, 1}, new int[]{4, 1, 2, 1, 2, 1}, new int[]{1, 1, 1, 1, 4, 3}, new int[]{1, 1, 1, 3, 4, 1}, new int[]{1, 3, 1, 1, 4, 1}, new int[]{1, 1, 4, 1, 1, 3}, new int[]{1, 1, 4, 3, 1, 1}, new int[]{4, 1, 1, 1, 1, 3}, new int[]{4, 1, 1, 3, 1, 1}, new int[]{1, 1, 3, 1, 4, 1}, new int[]{1, 1, 4, 1, 3, 1}, new int[]{3, 1, 1, 1, 4, 1}, new int[]{4, 1, 1, 1, 3, 1}, new int[]{2, 1, 1, 4, 1, 2}, new int[]{2, 1, 1, 2, 1, 4}, new int[]{2, 1, 1, 2, 3, 2}, new int[]{2, 3, 3, 1, 1, 1, 2}};

    private static int i(n1.a aVar, int[] iArr, int i4) {
        r.g(aVar, i4, iArr);
        float f4 = 0.25f;
        int i5 = -1;
        int i6 = 0;
        while (true) {
            int[][] iArr2 = f6362a;
            if (i6 >= iArr2.length) {
                break;
            }
            float f5 = r.f(iArr, iArr2[i6], 0.7f);
            if (f5 < f4) {
                i5 = i6;
                f4 = f5;
            }
            i6++;
        }
        if (i5 >= 0) {
            return i5;
        }
        throw g1.m.a();
    }

    private static int[] j(n1.a aVar) {
        int l4 = aVar.l();
        int j4 = aVar.j(0);
        int[] iArr = new int[6];
        boolean z4 = false;
        int i4 = 0;
        int i5 = j4;
        while (j4 < l4) {
            if (aVar.g(j4) != z4) {
                iArr[i4] = iArr[i4] + 1;
            } else {
                if (i4 == 5) {
                    float f4 = 0.25f;
                    int i6 = -1;
                    for (int i7 = 103; i7 <= 105; i7++) {
                        float f5 = r.f(iArr, f6362a[i7], 0.7f);
                        if (f5 < f4) {
                            i6 = i7;
                            f4 = f5;
                        }
                    }
                    if (i6 >= 0 && aVar.n(Math.max(0, i5 - ((j4 - i5) / 2)), i5, false)) {
                        return new int[]{i5, j4, i6};
                    }
                    i5 += iArr[0] + iArr[1];
                    int i8 = i4 - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i8);
                    iArr[i8] = 0;
                    iArr[i4] = 0;
                    i4--;
                } else {
                    i4++;
                }
                iArr[i4] = 1;
                z4 = !z4;
            }
            j4++;
        }
        throw g1.m.a();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00be, code lost:
    
        if (r13.length() == 0) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00c0, code lost:
    
        r13.append("]C1");
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00c5, code lost:
    
        r13.append((char) 29);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00d2, code lost:
    
        if (r9 != false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x010a, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00fb, code lost:
    
        if (r13.length() == 0) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0108, code lost:
    
        if (r9 != false) goto L82;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:25:0x0087. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:52:0x00b3. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:78:0x00f1. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:99:0x0136. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:68:0x010f A[PHI: r17
  0x010f: PHI (r17v10 boolean) = (r17v6 boolean), (r17v18 boolean) binds: [B:78:0x00f1, B:52:0x00b3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x011b A[PHI: r16 r17
  0x011b: PHI (r16v4 boolean) = (r16v1 boolean), (r16v1 boolean), (r16v3 boolean), (r16v1 boolean), (r16v1 boolean), (r16v1 boolean), (r16v1 boolean) binds: [B:78:0x00f1, B:79:0x00f5, B:70:0x0119, B:57:0x00c5, B:56:0x00c0, B:52:0x00b3, B:53:0x00b8] A[DONT_GENERATE, DONT_INLINE]
  0x011b: PHI (r17v9 boolean) = 
  (r17v6 boolean)
  (r17v6 boolean)
  (r17v8 boolean)
  (r17v14 boolean)
  (r17v15 boolean)
  (r17v18 boolean)
  (r17v18 boolean)
 binds: [B:78:0x00f1, B:79:0x00f5, B:70:0x0119, B:57:0x00c5, B:56:0x00c0, B:52:0x00b3, B:53:0x00b8] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // w1.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public g1.q d(int r25, n1.a r26, java.util.Map<g1.e, ?> r27) {
        /*
            Method dump skipped, instructions count: 590
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w1.c.d(int, n1.a, java.util.Map):g1.q");
    }
}
