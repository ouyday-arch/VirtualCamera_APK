package j3;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b {
    public static int a(int i4) {
        if (new g3.f(2, 36).f(i4)) {
            return i4;
        }
        throw new IllegalArgumentException("radix " + i4 + " was not in valid range " + new g3.f(2, 36));
    }

    public static final int b(char c5, int i4) {
        return Character.digit((int) c5, i4);
    }

    public static final boolean c(char c5) {
        return Character.isWhitespace(c5) || Character.isSpaceChar(c5);
    }
}
