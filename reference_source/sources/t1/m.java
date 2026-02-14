package t1;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m extends c {
    @Override // t1.c
    int c(char c5, StringBuilder sb) {
        int i4;
        int i5;
        char c6;
        if (c5 == ' ') {
            c6 = 3;
        } else {
            if (c5 >= '0' && c5 <= '9') {
                i5 = (c5 - '0') + 4;
            } else {
                if (c5 < 'a' || c5 > 'z') {
                    if (c5 < ' ') {
                        sb.append((char) 0);
                    } else {
                        if (c5 <= '/') {
                            sb.append((char) 1);
                            i4 = c5 - '!';
                        } else if (c5 <= '@') {
                            sb.append((char) 1);
                            i4 = (c5 - ':') + 15;
                        } else if (c5 >= '[' && c5 <= '_') {
                            sb.append((char) 1);
                            i4 = (c5 - '[') + 22;
                        } else if (c5 == '`') {
                            sb.append((char) 2);
                            i4 = c5 - '`';
                        } else if (c5 <= 'Z') {
                            sb.append((char) 2);
                            i4 = (c5 - 'A') + 1;
                        } else {
                            if (c5 > 127) {
                                sb.append("\u0001\u001e");
                                return c((char) (c5 - 128), sb) + 2;
                            }
                            sb.append((char) 2);
                            i4 = (c5 - '{') + 27;
                        }
                        c5 = (char) i4;
                    }
                    sb.append(c5);
                    return 2;
                }
                i5 = (c5 - 'a') + 14;
            }
            c6 = (char) i5;
        }
        sb.append(c6);
        return 1;
    }

    @Override // t1.c
    public int e() {
        return 2;
    }
}
