package r1;

import g1.h;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
final class c {

    /* renamed from: b, reason: collision with root package name */
    private static final char[] f5761b;

    /* renamed from: d, reason: collision with root package name */
    private static final char[] f5763d;

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f5760a = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /* renamed from: c, reason: collision with root package name */
    private static final char[] f5762c = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    /* renamed from: e, reason: collision with root package name */
    private static final char[] f5764e = {'`', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '{', '|', '}', '~', 127};

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f5765a;

        static {
            int[] iArr = new int[b.values().length];
            f5765a = iArr;
            try {
                iArr[b.C40_ENCODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5765a[b.TEXT_ENCODE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5765a[b.ANSIX12_ENCODE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5765a[b.EDIFACT_ENCODE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f5765a[b.BASE256_ENCODE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum b {
        PAD_ENCODE,
        ASCII_ENCODE,
        C40_ENCODE,
        TEXT_ENCODE,
        ANSIX12_ENCODE,
        EDIFACT_ENCODE,
        BASE256_ENCODE
    }

    static {
        char[] cArr = {'!', '\"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', '<', '=', '>', '?', '@', '[', '\\', ']', '^', '_'};
        f5761b = cArr;
        f5763d = cArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n1.e a(byte[] bArr) {
        n1.c cVar = new n1.c(bArr);
        StringBuilder sb = new StringBuilder(100);
        StringBuilder sb2 = new StringBuilder(0);
        ArrayList arrayList = new ArrayList(1);
        b bVar = b.ASCII_ENCODE;
        do {
            b bVar2 = b.ASCII_ENCODE;
            if (bVar == bVar2) {
                bVar = c(cVar, sb, sb2);
            } else {
                int i4 = a.f5765a[bVar.ordinal()];
                if (i4 == 1) {
                    e(cVar, sb);
                } else if (i4 == 2) {
                    g(cVar, sb);
                } else if (i4 == 3) {
                    b(cVar, sb);
                } else if (i4 == 4) {
                    f(cVar, sb);
                } else {
                    if (i4 != 5) {
                        throw h.a();
                    }
                    d(cVar, sb, arrayList);
                }
                bVar = bVar2;
            }
            if (bVar == b.PAD_ENCODE) {
                break;
            }
        } while (cVar.a() > 0);
        if (sb2.length() > 0) {
            sb.append((CharSequence) sb2);
        }
        String sb3 = sb.toString();
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        return new n1.e(bArr, sb3, arrayList, null);
    }

    private static void b(n1.c cVar, StringBuilder sb) {
        int d5;
        char c5;
        int i4;
        int[] iArr = new int[3];
        while (cVar.a() != 8 && (d5 = cVar.d(8)) != 254) {
            h(d5, cVar.d(8), iArr);
            for (int i5 = 0; i5 < 3; i5++) {
                int i6 = iArr[i5];
                if (i6 == 0) {
                    c5 = '\r';
                } else if (i6 == 1) {
                    c5 = '*';
                } else if (i6 == 2) {
                    c5 = '>';
                } else if (i6 != 3) {
                    if (i6 < 14) {
                        i4 = i6 + 44;
                    } else {
                        if (i6 >= 40) {
                            throw h.a();
                        }
                        i4 = i6 + 51;
                    }
                    c5 = (char) i4;
                } else {
                    c5 = ' ';
                }
                sb.append(c5);
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:22:0x0037. Please report as an issue. */
    private static b c(n1.c cVar, StringBuilder sb, StringBuilder sb2) {
        String str;
        boolean z4 = false;
        do {
            int d5 = cVar.d(8);
            if (d5 == 0) {
                throw h.a();
            }
            if (d5 > 128) {
                if (d5 != 129) {
                    if (d5 > 229) {
                        switch (d5) {
                            case 230:
                                return b.C40_ENCODE;
                            case 231:
                                return b.BASE256_ENCODE;
                            case 232:
                                sb.append((char) 29);
                                break;
                            case 233:
                            case 234:
                            case 241:
                                break;
                            case 235:
                                z4 = true;
                                break;
                            case 236:
                                str = "[)>\u001e05\u001d";
                                sb.append(str);
                                sb2.insert(0, "\u001e\u0004");
                                break;
                            case 237:
                                str = "[)>\u001e06\u001d";
                                sb.append(str);
                                sb2.insert(0, "\u001e\u0004");
                                break;
                            case 238:
                                return b.ANSIX12_ENCODE;
                            case 239:
                                return b.TEXT_ENCODE;
                            case 240:
                                return b.EDIFACT_ENCODE;
                            default:
                                if (d5 != 254 || cVar.a() != 0) {
                                    throw h.a();
                                }
                                break;
                        }
                    } else {
                        int i4 = d5 - 130;
                        if (i4 < 10) {
                            sb.append('0');
                        }
                        sb.append(i4);
                    }
                } else {
                    return b.PAD_ENCODE;
                }
            } else {
                if (z4) {
                    d5 += 128;
                }
                sb.append((char) (d5 - 1));
                return b.ASCII_ENCODE;
            }
        } while (cVar.a() > 0);
        return b.ASCII_ENCODE;
    }

    private static void d(n1.c cVar, StringBuilder sb, Collection<byte[]> collection) {
        int c5 = cVar.c() + 1;
        int i4 = c5 + 1;
        int i5 = i(cVar.d(8), c5);
        if (i5 == 0) {
            i5 = cVar.a() / 8;
        } else if (i5 >= 250) {
            i5 = ((i5 - 249) * 250) + i(cVar.d(8), i4);
            i4++;
        }
        if (i5 < 0) {
            throw h.a();
        }
        byte[] bArr = new byte[i5];
        int i6 = 0;
        while (i6 < i5) {
            if (cVar.a() < 8) {
                throw h.a();
            }
            bArr[i6] = (byte) i(cVar.d(8), i4);
            i6++;
            i4++;
        }
        collection.add(bArr);
        try {
            sb.append(new String(bArr, "ISO8859_1"));
        } catch (UnsupportedEncodingException e4) {
            throw new IllegalStateException("Platform does not support required encoding: ".concat(String.valueOf(e4)));
        }
    }

    private static void e(n1.c cVar, StringBuilder sb) {
        int d5;
        int i4;
        char c5;
        char c6;
        int[] iArr = new int[3];
        boolean z4 = false;
        int i5 = 0;
        while (cVar.a() != 8 && (d5 = cVar.d(8)) != 254) {
            h(d5, cVar.d(8), iArr);
            for (int i6 = 0; i6 < 3; i6++) {
                int i7 = iArr[i6];
                if (i5 != 0) {
                    if (i5 == 1) {
                        if (z4) {
                            i4 = i7 + 128;
                            c6 = (char) i4;
                            sb.append(c6);
                            z4 = false;
                        }
                        c5 = (char) i7;
                        sb.append(c5);
                    } else if (i5 == 2) {
                        char[] cArr = f5761b;
                        if (i7 < cArr.length) {
                            c5 = cArr[i7];
                            if (z4) {
                                c6 = (char) (c5 + 128);
                                sb.append(c6);
                                z4 = false;
                            }
                        } else if (i7 == 27) {
                            c5 = 29;
                        } else {
                            if (i7 != 30) {
                                throw h.a();
                            }
                            z4 = true;
                        }
                        sb.append(c5);
                    } else {
                        if (i5 != 3) {
                            throw h.a();
                        }
                        if (z4) {
                            i4 = i7 + 224;
                            c6 = (char) i4;
                            sb.append(c6);
                            z4 = false;
                        } else {
                            i7 += 96;
                            c5 = (char) i7;
                            sb.append(c5);
                        }
                    }
                    i5 = 0;
                } else if (i7 < 3) {
                    i5 = i7 + 1;
                } else {
                    char[] cArr2 = f5760a;
                    if (i7 >= cArr2.length) {
                        throw h.a();
                    }
                    char c7 = cArr2[i7];
                    if (z4) {
                        sb.append((char) (c7 + 128));
                        z4 = false;
                    } else {
                        sb.append(c7);
                    }
                }
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    private static void f(n1.c cVar, StringBuilder sb) {
        while (cVar.a() > 16) {
            for (int i4 = 0; i4 < 4; i4++) {
                int d5 = cVar.d(6);
                if (d5 == 31) {
                    int b5 = 8 - cVar.b();
                    if (b5 != 8) {
                        cVar.d(b5);
                        return;
                    }
                    return;
                }
                if ((d5 & 32) == 0) {
                    d5 |= 64;
                }
                sb.append((char) d5);
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0035, code lost:
    
        if (r3 != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0037, code lost:
    
        r3 = (char) (r4 + 128);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x004c, code lost:
    
        if (r3 != false) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void g(n1.c r9, java.lang.StringBuilder r10) {
        /*
            r0 = 3
            int[] r1 = new int[r0]
            r2 = 0
            r3 = r2
            r4 = r3
        L6:
            int r5 = r9.a()
            r6 = 8
            if (r5 != r6) goto Lf
            return
        Lf:
            int r5 = r9.d(r6)
            r7 = 254(0xfe, float:3.56E-43)
            if (r5 != r7) goto L18
            return
        L18:
            int r6 = r9.d(r6)
            h(r5, r6, r1)
            r5 = r2
        L20:
            if (r5 >= r0) goto L93
            r6 = r1[r5]
            if (r4 == 0) goto L71
            r7 = 1
            if (r4 == r7) goto L61
            r8 = 2
            if (r4 == r8) goto L45
            if (r4 != r0) goto L40
            char[] r4 = r1.c.f5764e
            int r7 = r4.length
            if (r6 >= r7) goto L3b
            char r4 = r4[r6]
            if (r3 == 0) goto L6c
        L37:
            int r4 = r4 + 128
            char r3 = (char) r4
            goto L66
        L3b:
            g1.h r9 = g1.h.a()
            throw r9
        L40:
            g1.h r9 = g1.h.a()
            throw r9
        L45:
            char[] r4 = r1.c.f5763d
            int r8 = r4.length
            if (r6 >= r8) goto L4f
            char r4 = r4[r6]
            if (r3 == 0) goto L6c
            goto L37
        L4f:
            r4 = 27
            if (r6 == r4) goto L5e
            r3 = 30
            if (r6 != r3) goto L59
            r3 = r7
            goto L6f
        L59:
            g1.h r9 = g1.h.a()
            throw r9
        L5e:
            r4 = 29
            goto L6c
        L61:
            if (r3 == 0) goto L6b
            int r6 = r6 + 128
            char r3 = (char) r6
        L66:
            r10.append(r3)
            r3 = r2
            goto L6f
        L6b:
            char r4 = (char) r6
        L6c:
            r10.append(r4)
        L6f:
            r4 = r2
            goto L8b
        L71:
            if (r6 >= r0) goto L77
            int r6 = r6 + 1
            r4 = r6
            goto L8b
        L77:
            char[] r7 = r1.c.f5762c
            int r8 = r7.length
            if (r6 >= r8) goto L8e
            char r6 = r7[r6]
            if (r3 == 0) goto L88
            int r6 = r6 + 128
            char r3 = (char) r6
            r10.append(r3)
            r3 = r2
            goto L8b
        L88:
            r10.append(r6)
        L8b:
            int r5 = r5 + 1
            goto L20
        L8e:
            g1.h r9 = g1.h.a()
            throw r9
        L93:
            int r5 = r9.a()
            if (r5 > 0) goto L6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: r1.c.g(n1.c, java.lang.StringBuilder):void");
    }

    private static void h(int i4, int i5, int[] iArr) {
        int i6 = ((i4 << 8) + i5) - 1;
        int i7 = i6 / 1600;
        iArr[0] = i7;
        int i8 = i6 - (i7 * 1600);
        int i9 = i8 / 40;
        iArr[1] = i9;
        iArr[2] = i8 - (i9 * 40);
    }

    private static int i(int i4, int i5) {
        int i6 = i4 - (((i5 * 149) % 255) + 1);
        return i6 >= 0 ? i6 : i6 + 256;
    }
}
