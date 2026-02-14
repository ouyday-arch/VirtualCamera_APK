package w;

import android.text.SpannableStringBuilder;
import java.util.Locale;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    static final c f6306d;

    /* renamed from: e, reason: collision with root package name */
    private static final String f6307e;

    /* renamed from: f, reason: collision with root package name */
    private static final String f6308f;

    /* renamed from: g, reason: collision with root package name */
    static final a f6309g;

    /* renamed from: h, reason: collision with root package name */
    static final a f6310h;

    /* renamed from: a, reason: collision with root package name */
    private final boolean f6311a;

    /* renamed from: b, reason: collision with root package name */
    private final int f6312b;

    /* renamed from: c, reason: collision with root package name */
    private final c f6313c;

    /* renamed from: w.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0086a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f6314a;

        /* renamed from: b, reason: collision with root package name */
        private int f6315b;

        /* renamed from: c, reason: collision with root package name */
        private c f6316c;

        public C0086a() {
            c(a.e(Locale.getDefault()));
        }

        private static a b(boolean z4) {
            return z4 ? a.f6310h : a.f6309g;
        }

        private void c(boolean z4) {
            this.f6314a = z4;
            this.f6316c = a.f6306d;
            this.f6315b = 2;
        }

        public a a() {
            return (this.f6315b == 2 && this.f6316c == a.f6306d) ? b(this.f6314a) : new a(this.f6314a, this.f6315b, this.f6316c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: f, reason: collision with root package name */
        private static final byte[] f6317f = new byte[1792];

        /* renamed from: a, reason: collision with root package name */
        private final CharSequence f6318a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f6319b;

        /* renamed from: c, reason: collision with root package name */
        private final int f6320c;

        /* renamed from: d, reason: collision with root package name */
        private int f6321d;

        /* renamed from: e, reason: collision with root package name */
        private char f6322e;

        static {
            for (int i4 = 0; i4 < 1792; i4++) {
                f6317f[i4] = Character.getDirectionality(i4);
            }
        }

        b(CharSequence charSequence, boolean z4) {
            this.f6318a = charSequence;
            this.f6319b = z4;
            this.f6320c = charSequence.length();
        }

        private static byte c(char c5) {
            return c5 < 1792 ? f6317f[c5] : Character.getDirectionality(c5);
        }

        private byte f() {
            char charAt;
            int i4 = this.f6321d;
            do {
                int i5 = this.f6321d;
                if (i5 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f6318a;
                int i6 = i5 - 1;
                this.f6321d = i6;
                charAt = charSequence.charAt(i6);
                this.f6322e = charAt;
                if (charAt == '&') {
                    return (byte) 12;
                }
            } while (charAt != ';');
            this.f6321d = i4;
            this.f6322e = ';';
            return (byte) 13;
        }

        private byte g() {
            char charAt;
            do {
                int i4 = this.f6321d;
                if (i4 >= this.f6320c) {
                    return (byte) 12;
                }
                CharSequence charSequence = this.f6318a;
                this.f6321d = i4 + 1;
                charAt = charSequence.charAt(i4);
                this.f6322e = charAt;
            } while (charAt != ';');
            return (byte) 12;
        }

        private byte h() {
            char charAt;
            int i4 = this.f6321d;
            while (true) {
                int i5 = this.f6321d;
                if (i5 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f6318a;
                int i6 = i5 - 1;
                this.f6321d = i6;
                char charAt2 = charSequence.charAt(i6);
                this.f6322e = charAt2;
                if (charAt2 == '<') {
                    return (byte) 12;
                }
                if (charAt2 == '>') {
                    break;
                }
                if (charAt2 == '\"' || charAt2 == '\'') {
                    do {
                        int i7 = this.f6321d;
                        if (i7 > 0) {
                            CharSequence charSequence2 = this.f6318a;
                            int i8 = i7 - 1;
                            this.f6321d = i8;
                            charAt = charSequence2.charAt(i8);
                            this.f6322e = charAt;
                        }
                    } while (charAt != charAt2);
                }
            }
            this.f6321d = i4;
            this.f6322e = '>';
            return (byte) 13;
        }

        private byte i() {
            char charAt;
            int i4 = this.f6321d;
            while (true) {
                int i5 = this.f6321d;
                if (i5 >= this.f6320c) {
                    this.f6321d = i4;
                    this.f6322e = '<';
                    return (byte) 13;
                }
                CharSequence charSequence = this.f6318a;
                this.f6321d = i5 + 1;
                char charAt2 = charSequence.charAt(i5);
                this.f6322e = charAt2;
                if (charAt2 == '>') {
                    return (byte) 12;
                }
                if (charAt2 == '\"' || charAt2 == '\'') {
                    do {
                        int i6 = this.f6321d;
                        if (i6 < this.f6320c) {
                            CharSequence charSequence2 = this.f6318a;
                            this.f6321d = i6 + 1;
                            charAt = charSequence2.charAt(i6);
                            this.f6322e = charAt;
                        }
                    } while (charAt != charAt2);
                }
            }
        }

        byte a() {
            char charAt = this.f6318a.charAt(this.f6321d - 1);
            this.f6322e = charAt;
            if (Character.isLowSurrogate(charAt)) {
                int codePointBefore = Character.codePointBefore(this.f6318a, this.f6321d);
                this.f6321d -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.f6321d--;
            byte c5 = c(this.f6322e);
            if (!this.f6319b) {
                return c5;
            }
            char c6 = this.f6322e;
            return c6 == '>' ? h() : c6 == ';' ? f() : c5;
        }

        byte b() {
            char charAt = this.f6318a.charAt(this.f6321d);
            this.f6322e = charAt;
            if (Character.isHighSurrogate(charAt)) {
                int codePointAt = Character.codePointAt(this.f6318a, this.f6321d);
                this.f6321d += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.f6321d++;
            byte c5 = c(this.f6322e);
            if (!this.f6319b) {
                return c5;
            }
            char c6 = this.f6322e;
            return c6 == '<' ? i() : c6 == '&' ? g() : c5;
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:46:0x0045. Please report as an issue. */
        int d() {
            this.f6321d = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (this.f6321d < this.f6320c && i4 == 0) {
                byte b5 = b();
                if (b5 != 0) {
                    if (b5 == 1 || b5 == 2) {
                        if (i6 == 0) {
                            return 1;
                        }
                    } else if (b5 != 9) {
                        switch (b5) {
                            case 14:
                            case 15:
                                i6++;
                                i5 = -1;
                                continue;
                            case 16:
                            case 17:
                                i6++;
                                i5 = 1;
                                continue;
                            case 18:
                                i6--;
                                i5 = 0;
                                continue;
                        }
                    }
                } else if (i6 == 0) {
                    return -1;
                }
                i4 = i6;
            }
            if (i4 == 0) {
                return 0;
            }
            if (i5 != 0) {
                return i5;
            }
            while (this.f6321d > 0) {
                switch (a()) {
                    case 14:
                    case 15:
                        if (i4 == i6) {
                            return -1;
                        }
                        i6--;
                    case 16:
                    case 17:
                        if (i4 == i6) {
                            return 1;
                        }
                        i6--;
                    case 18:
                        i6++;
                }
            }
            return 0;
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:33:0x001c. Please report as an issue. */
        int e() {
            this.f6321d = this.f6320c;
            int i4 = 0;
            while (true) {
                int i5 = i4;
                while (this.f6321d > 0) {
                    byte a5 = a();
                    if (a5 != 0) {
                        if (a5 == 1 || a5 == 2) {
                            if (i4 == 0) {
                                return 1;
                            }
                            if (i5 == 0) {
                                break;
                            }
                        } else if (a5 != 9) {
                            switch (a5) {
                                case 14:
                                case 15:
                                    if (i5 == i4) {
                                        return -1;
                                    }
                                    i4--;
                                    break;
                                case 16:
                                case 17:
                                    if (i5 == i4) {
                                        return 1;
                                    }
                                    i4--;
                                    break;
                                case 18:
                                    i4++;
                                    break;
                                default:
                                    if (i5 != 0) {
                                        break;
                                    } else {
                                        break;
                                    }
                            }
                        } else {
                            continue;
                        }
                    } else {
                        if (i4 == 0) {
                            return -1;
                        }
                        if (i5 == 0) {
                            break;
                        }
                    }
                }
                return 0;
            }
        }
    }

    static {
        c cVar = d.f6338c;
        f6306d = cVar;
        f6307e = Character.toString((char) 8206);
        f6308f = Character.toString((char) 8207);
        f6309g = new a(false, 2, cVar);
        f6310h = new a(true, 2, cVar);
    }

    a(boolean z4, int i4, c cVar) {
        this.f6311a = z4;
        this.f6312b = i4;
        this.f6313c = cVar;
    }

    private static int a(CharSequence charSequence) {
        return new b(charSequence, false).d();
    }

    private static int b(CharSequence charSequence) {
        return new b(charSequence, false).e();
    }

    public static a c() {
        return new C0086a().a();
    }

    static boolean e(Locale locale) {
        return e.a(locale) == 1;
    }

    private String f(CharSequence charSequence, c cVar) {
        boolean a5 = cVar.a(charSequence, 0, charSequence.length());
        return (this.f6311a || !(a5 || b(charSequence) == 1)) ? this.f6311a ? (!a5 || b(charSequence) == -1) ? f6308f : "" : "" : f6307e;
    }

    private String g(CharSequence charSequence, c cVar) {
        boolean a5 = cVar.a(charSequence, 0, charSequence.length());
        return (this.f6311a || !(a5 || a(charSequence) == 1)) ? this.f6311a ? (!a5 || a(charSequence) == -1) ? f6308f : "" : "" : f6307e;
    }

    public boolean d() {
        return (this.f6312b & 2) != 0;
    }

    public CharSequence h(CharSequence charSequence) {
        return i(charSequence, this.f6313c, true);
    }

    public CharSequence i(CharSequence charSequence, c cVar, boolean z4) {
        if (charSequence == null) {
            return null;
        }
        boolean a5 = cVar.a(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (d() && z4) {
            spannableStringBuilder.append((CharSequence) g(charSequence, a5 ? d.f6337b : d.f6336a));
        }
        if (a5 != this.f6311a) {
            spannableStringBuilder.append(a5 ? (char) 8235 : (char) 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z4) {
            spannableStringBuilder.append((CharSequence) f(charSequence, a5 ? d.f6337b : d.f6336a));
        }
        return spannableStringBuilder;
    }
}
