package v1;

import java.text.DecimalFormat;
import n1.e;

/* loaded from: classes.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f6277a = {"\nABCDEFGHIJKLMNOPQRSTUVWXYZ\ufffa\u001c\u001d\u001e\ufffb ￼\"#$%&'()*+,-./0123456789:\ufff1\ufff2\ufff3\ufff4\ufff8", "`abcdefghijklmnopqrstuvwxyz\ufffa\u001c\u001d\u001e\ufffb{￼}~\u007f;<=>?[\\]^_ ,./:@!|￼\ufff5\ufff6￼\ufff0\ufff2\ufff3\ufff4\ufff7", "ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖ×ØÙÚ\ufffa\u001c\u001d\u001eÛÜÝÞßª¬±²³µ¹º¼½¾\u0080\u0081\u0082\u0083\u0084\u0085\u0086\u0087\u0088\u0089\ufff7 \ufff9\ufff3\ufff4\ufff8", "àáâãäåæçèéêëìíîïðñòóôõö÷øùú\ufffa\u001c\u001d\u001e\ufffbûüýþÿ¡¨«¯°´·¸»¿\u008a\u008b\u008c\u008d\u008e\u008f\u0090\u0091\u0092\u0093\u0094\ufff7 \ufff2\ufff9\ufff4\ufff8", "\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\ufffa￼￼\u001b\ufffb\u001c\u001d\u001e\u001f\u009f ¢£¤¥¦§©\u00ad®¶\u0095\u0096\u0097\u0098\u0099\u009a\u009b\u009c\u009d\u009e\ufff7 \ufff2\ufff3\ufff9\ufff8", "\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./0123456789:;<=>?"};

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e a(byte[] bArr, int i4) {
        StringBuilder sb;
        int i5;
        StringBuilder sb2 = new StringBuilder(144);
        if (i4 == 2 || i4 == 3) {
            int i6 = 0;
            String format = i4 == 2 ? new DecimalFormat("0000000000".substring(0, g(bArr))).format(f(bArr)) : h(bArr);
            DecimalFormat decimalFormat = new DecimalFormat("000");
            String format2 = decimalFormat.format(c(bArr));
            String format3 = decimalFormat.format(i(bArr));
            sb2.append(e(bArr, 10, 84));
            if (sb2.toString().startsWith("[)>\u001e01\u001d")) {
                i6 = 9;
                sb = new StringBuilder();
            } else {
                sb = new StringBuilder();
            }
            sb.append(format);
            sb.append((char) 29);
            sb.append(format2);
            sb.append((char) 29);
            sb.append(format3);
            sb.append((char) 29);
            sb2.insert(i6, sb.toString());
        } else {
            if (i4 != 4) {
                i5 = i4 == 5 ? 77 : 93;
            }
            sb2.append(e(bArr, 1, i5));
        }
        return new e(bArr, sb2.toString(), null, String.valueOf(i4));
    }

    private static int b(int i4, byte[] bArr) {
        int i5 = i4 - 1;
        return ((1 << (5 - (i5 % 6))) & bArr[i5 / 6]) == 0 ? 0 : 1;
    }

    private static int c(byte[] bArr) {
        return d(bArr, new byte[]{53, 54, 43, 44, 45, 46, 47, 48, 37, 38});
    }

    private static int d(byte[] bArr, byte[] bArr2) {
        if (bArr2.length == 0) {
            throw new IllegalArgumentException();
        }
        int i4 = 0;
        for (int i5 = 0; i5 < bArr2.length; i5++) {
            i4 += b(bArr2[i5], bArr) << ((bArr2.length - i5) - 1);
        }
        return i4;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x001a. Please report as an issue. */
    private static String e(byte[] bArr, int i4, int i5) {
        StringBuilder sb = new StringBuilder();
        int i6 = i4;
        int i7 = 0;
        int i8 = 0;
        int i9 = -1;
        while (i6 < i4 + i5) {
            char charAt = f6277a[i7].charAt(bArr[i6]);
            switch (charAt) {
                case 65520:
                case 65521:
                case 65522:
                case 65523:
                case 65524:
                    i8 = i7;
                    i7 = charAt - 65520;
                    i9 = 1;
                    break;
                case 65525:
                    i9 = 2;
                    i8 = i7;
                    i7 = 0;
                    break;
                case 65526:
                    i9 = 3;
                    i8 = i7;
                    i7 = 0;
                    break;
                case 65527:
                    i7 = 0;
                    i9 = -1;
                    break;
                case 65528:
                    i9 = -1;
                    i7 = 1;
                    break;
                case 65529:
                    i9 = -1;
                    break;
                case 65530:
                default:
                    sb.append(charAt);
                    break;
                case 65531:
                    int i10 = i6 + 1;
                    int i11 = bArr[i10] << 24;
                    int i12 = i10 + 1;
                    int i13 = i11 + (bArr[i12] << 18);
                    int i14 = i12 + 1;
                    int i15 = i13 + (bArr[i14] << 12);
                    int i16 = i14 + 1;
                    int i17 = i15 + (bArr[i16] << 6);
                    i6 = i16 + 1;
                    sb.append(new DecimalFormat("000000000").format(i17 + bArr[i6]));
                    break;
            }
            int i18 = i9 - 1;
            if (i9 == 0) {
                i7 = i8;
            }
            i6++;
            i9 = i18;
        }
        while (sb.length() > 0 && sb.charAt(sb.length() - 1) == 65532) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    private static int f(byte[] bArr) {
        return d(bArr, new byte[]{33, 34, 35, 36, 25, 26, 27, 28, 29, 30, 19, 20, 21, 22, 23, 24, 13, 14, 15, 16, 17, 18, 7, 8, 9, 10, 11, 12, 1, 2});
    }

    private static int g(byte[] bArr) {
        return d(bArr, new byte[]{39, 40, 41, 42, 31, 32});
    }

    private static String h(byte[] bArr) {
        String[] strArr = f6277a;
        return String.valueOf(new char[]{strArr[0].charAt(d(bArr, new byte[]{39, 40, 41, 42, 31, 32})), strArr[0].charAt(d(bArr, new byte[]{33, 34, 35, 36, 25, 26})), strArr[0].charAt(d(bArr, new byte[]{27, 28, 29, 30, 19, 20})), strArr[0].charAt(d(bArr, new byte[]{21, 22, 23, 24, 13, 14})), strArr[0].charAt(d(bArr, new byte[]{15, 16, 17, 18, 7, 8})), strArr[0].charAt(d(bArr, new byte[]{9, 10, 11, 12, 1, 2}))});
    }

    private static int i(byte[] bArr) {
        return d(bArr, new byte[]{55, 56, 57, 58, 59, 60, 49, 50, 51, 52});
    }
}
