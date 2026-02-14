package v3;

import b4.e;
import e3.f;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final String f6299a;

    /* renamed from: b, reason: collision with root package name */
    private final String f6300b;

    /* renamed from: c, reason: collision with root package name */
    private final String f6301c;

    public a(String str, String str2, String str3) {
        f.e(str, "sections");
        f.e(str2, "ranges");
        f.e(str3, "mappings");
        this.f6299a = str;
        this.f6300b = str2;
        this.f6301c = str3;
    }

    private final int a(int i4, int i5, int i6) {
        int i7;
        int i8 = i4 & 127;
        int i9 = i6 - 1;
        while (true) {
            if (i5 > i9) {
                i7 = (-i5) - 1;
                break;
            }
            i7 = (i5 + i9) / 2;
            int f4 = f.f(i8, this.f6300b.charAt(i7 * 4));
            if (f4 >= 0) {
                if (f4 <= 0) {
                    break;
                }
                i5 = i7 + 1;
            } else {
                i9 = i7 - 1;
            }
        }
        return i7 >= 0 ? i7 * 4 : ((-i7) - 2) * 4;
    }

    private final int b(int i4) {
        int i5;
        int i6 = (i4 & 2097024) >> 7;
        int length = (this.f6299a.length() / 4) - 1;
        int i7 = 0;
        while (true) {
            if (i7 > length) {
                i5 = (-i7) - 1;
                break;
            }
            i5 = (i7 + length) / 2;
            int f4 = f.f(i6, c.a(this.f6299a, i5 * 4));
            if (f4 >= 0) {
                if (f4 <= 0) {
                    break;
                }
                i7 = i5 + 1;
            } else {
                length = i5 - 1;
            }
        }
        return i5 >= 0 ? i5 * 4 : ((-i5) - 2) * 4;
    }

    public final boolean c(int i4, e eVar) {
        int charAt;
        String str;
        int i5;
        int charAt2;
        String str2;
        int i6;
        int charAt3;
        f.e(eVar, "sink");
        int b5 = b(i4);
        int a5 = a(i4, c.a(this.f6299a, b5 + 2), b5 + 4 < this.f6299a.length() ? c.a(this.f6299a, b5 + 6) : this.f6300b.length() / 4);
        char charAt4 = this.f6300b.charAt(a5 + 1);
        if (charAt4 >= 0 && charAt4 < '@') {
            int a6 = c.a(this.f6300b, a5 + 2);
            eVar.h(this.f6301c, a6, charAt4 + a6);
        } else {
            if ('@' <= charAt4 && charAt4 < 'P') {
                i4 -= this.f6300b.charAt(a5 + 3) | (((charAt4 & 15) << 14) | (this.f6300b.charAt(a5 + 2) << 7));
            } else {
                if ('P' <= charAt4 && charAt4 < '`') {
                    i4 += this.f6300b.charAt(a5 + 3) | ((charAt4 & 15) << 14) | (this.f6300b.charAt(a5 + 2) << 7);
                } else if (charAt4 != 'w') {
                    if (charAt4 != 'x') {
                        if (charAt4 == 'y') {
                            eVar.r(i4);
                            return false;
                        }
                        if (charAt4 == 'z') {
                            str2 = this.f6300b;
                            i6 = a5 + 2;
                        } else {
                            if (charAt4 == '{') {
                                str = this.f6300b;
                                i5 = a5 + 2;
                            } else {
                                if (charAt4 == '|') {
                                    charAt2 = this.f6300b.charAt(a5 + 2);
                                } else if (charAt4 == '}') {
                                    charAt2 = this.f6300b.charAt(a5 + 2) | 128;
                                } else {
                                    if (charAt4 == '~') {
                                        charAt = this.f6300b.charAt(a5 + 2);
                                    } else {
                                        if (charAt4 != 127) {
                                            throw new IllegalStateException(("unexpected rangesIndex for " + i4).toString());
                                        }
                                        charAt = this.f6300b.charAt(a5 + 2) | 128;
                                    }
                                    eVar.B(charAt);
                                    str = this.f6300b;
                                    i5 = a5 + 3;
                                }
                                eVar.B(charAt2);
                                str2 = this.f6300b;
                                i6 = a5 + 3;
                            }
                            charAt3 = str.charAt(i5) | 128;
                            eVar.B(charAt3);
                        }
                        charAt3 = str2.charAt(i6);
                        eVar.B(charAt3);
                    }
                }
            }
            eVar.r(i4);
        }
        return true;
    }
}
