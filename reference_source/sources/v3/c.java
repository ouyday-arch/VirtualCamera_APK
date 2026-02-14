package v3;

import e3.f;

/* loaded from: classes.dex */
public final class c {
    public static final int a(String str, int i4) {
        f.e(str, "<this>");
        char charAt = str.charAt(i4);
        return (charAt << 7) + str.charAt(i4 + 1);
    }
}
