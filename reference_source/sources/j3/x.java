package j3;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends w {
    public static String p0(String str, int i4) {
        int c5;
        e3.f.e(str, "<this>");
        if (i4 >= 0) {
            c5 = g3.l.c(i4, str.length());
            String substring = str.substring(0, c5);
            e3.f.d(substring, "substring(...)");
            return substring;
        }
        throw new IllegalArgumentException(("Requested character count " + i4 + " is less than zero.").toString());
    }
}
