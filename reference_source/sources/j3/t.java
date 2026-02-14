package j3;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends s {
    public static Integer f(String str) {
        e3.f.e(str, "<this>");
        return g(str, 10);
    }

    public static final Integer g(String str, int i4) {
        boolean z4;
        int i5;
        e3.f.e(str, "<this>");
        b.a(i4);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i6 = 0;
        char charAt = str.charAt(0);
        int i7 = -2147483647;
        int i8 = 1;
        if (e3.f.f(charAt, 48) >= 0) {
            z4 = false;
            i8 = 0;
        } else {
            if (length == 1) {
                return null;
            }
            if (charAt == '-') {
                i7 = RecyclerView.UNDEFINED_DURATION;
                z4 = true;
            } else {
                if (charAt != '+') {
                    return null;
                }
                z4 = false;
            }
        }
        int i9 = -59652323;
        while (i8 < length) {
            int b5 = b.b(str.charAt(i8), i4);
            if (b5 < 0) {
                return null;
            }
            if ((i6 < i9 && (i9 != -59652323 || i6 < (i9 = i7 / i4))) || (i5 = i6 * i4) < i7 + b5) {
                return null;
            }
            i6 = i5 - b5;
            i8++;
        }
        return z4 ? Integer.valueOf(i6) : Integer.valueOf(-i6);
    }
}
