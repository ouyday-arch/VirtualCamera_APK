package w1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class d extends s {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum a {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1
    }

    private static int h(CharSequence charSequence, int i4, int i5) {
        a i6;
        a i7;
        char charAt;
        a i8 = i(charSequence, i4);
        a aVar = a.ONE_DIGIT;
        if (i8 == aVar) {
            return i5 == 101 ? 101 : 100;
        }
        a aVar2 = a.UNCODABLE;
        if (i8 == aVar2) {
            return (i4 >= charSequence.length() || ((charAt = charSequence.charAt(i4)) >= ' ' && (i5 != 101 || (charAt >= '`' && (charAt < 241 || charAt > 244))))) ? 100 : 101;
        }
        if (i5 == 101 && i8 == a.FNC_1) {
            return 101;
        }
        if (i5 == 99) {
            return 99;
        }
        if (i5 != 100) {
            if (i8 == a.FNC_1) {
                i8 = i(charSequence, i4 + 1);
            }
            return i8 == a.TWO_DIGITS ? 99 : 100;
        }
        a aVar3 = a.FNC_1;
        if (i8 == aVar3 || (i6 = i(charSequence, i4 + 2)) == aVar2 || i6 == aVar) {
            return 100;
        }
        if (i6 == aVar3) {
            return i(charSequence, i4 + 3) == a.TWO_DIGITS ? 99 : 100;
        }
        int i9 = i4 + 4;
        while (true) {
            i7 = i(charSequence, i9);
            if (i7 != a.TWO_DIGITS) {
                break;
            }
            i9 += 2;
        }
        return i7 == a.ONE_DIGIT ? 100 : 99;
    }

    private static a i(CharSequence charSequence, int i4) {
        int length = charSequence.length();
        if (i4 >= length) {
            return a.UNCODABLE;
        }
        char charAt = charSequence.charAt(i4);
        if (charAt == 241) {
            return a.FNC_1;
        }
        if (charAt < '0' || charAt > '9') {
            return a.UNCODABLE;
        }
        int i5 = i4 + 1;
        if (i5 >= length) {
            return a.ONE_DIGIT;
        }
        char charAt2 = charSequence.charAt(i5);
        return (charAt2 < '0' || charAt2 > '9') ? a.ONE_DIGIT : a.TWO_DIGITS;
    }

    @Override // w1.s
    public boolean[] d(String str) {
        int length = str.length();
        if (length <= 0 || length > 80) {
            throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got ".concat(String.valueOf(length)));
        }
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            char charAt = str.charAt(i5);
            switch (charAt) {
                case 241:
                case 242:
                case 243:
                case 244:
                    break;
                default:
                    if (charAt > 127) {
                        throw new IllegalArgumentException("Bad character in input: ".concat(String.valueOf(charAt)));
                    }
                    break;
            }
        }
        ArrayList<int[]> arrayList = new ArrayList();
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 1;
        while (true) {
            int i10 = 103;
            if (i6 >= length) {
                int[][] iArr = c.f6362a;
                arrayList.add(iArr[i7 % 103]);
                arrayList.add(iArr[106]);
                int i11 = 0;
                for (int[] iArr2 : arrayList) {
                    for (int i12 : iArr2) {
                        i11 += i12;
                    }
                }
                boolean[] zArr = new boolean[i11];
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    i4 += s.b(zArr, i4, (int[]) it.next(), true);
                }
                return zArr;
            }
            int h4 = h(str, i6, i8);
            int i13 = 100;
            if (h4 == i8) {
                switch (str.charAt(i6)) {
                    case 241:
                        i13 = 102;
                        break;
                    case 242:
                        i13 = 97;
                        break;
                    case 243:
                        i13 = 96;
                        break;
                    case 244:
                        if (i8 == 101) {
                            i13 = 101;
                            break;
                        }
                        break;
                    default:
                        if (i8 != 100) {
                            if (i8 != 101) {
                                i13 = Integer.parseInt(str.substring(i6, i6 + 2));
                                i6++;
                                break;
                            } else {
                                i13 = str.charAt(i6) - ' ';
                                if (i13 < 0) {
                                    i13 += 96;
                                    break;
                                }
                            }
                        } else {
                            i13 = str.charAt(i6) - ' ';
                            break;
                        }
                        break;
                }
                i6++;
            } else {
                if (i8 != 0) {
                    i10 = h4;
                } else if (h4 == 100) {
                    i10 = 104;
                } else if (h4 != 101) {
                    i10 = 105;
                }
                i13 = i10;
                i8 = h4;
            }
            arrayList.add(c.f6362a[i13]);
            i7 += i13 * i9;
            if (i6 != 0) {
                i9++;
            }
        }
    }

    @Override // w1.s
    protected Collection<g1.a> f() {
        return Collections.singleton(g1.a.CODE_128);
    }
}
