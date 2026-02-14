package r3;

import j3.t;
import j3.u;
import java.net.ProtocolException;
import l3.z;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: d, reason: collision with root package name */
    public static final a f5880d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final z f5881a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5882b;

    /* renamed from: c, reason: collision with root package name */
    public final String f5883c;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e3.d dVar) {
            this();
        }

        public final k a(String str) {
            boolean x4;
            boolean x5;
            boolean x6;
            z zVar;
            Integer f4;
            String str2;
            e3.f.e(str, "statusLine");
            x4 = u.x(str, "HTTP/1.", false, 2, null);
            int i4 = 9;
            if (!x4) {
                x5 = u.x(str, "ICY ", false, 2, null);
                if (x5) {
                    zVar = z.f4872d;
                    i4 = 4;
                } else {
                    x6 = u.x(str, "SOURCETABLE ", false, 2, null);
                    if (!x6) {
                        throw new ProtocolException("Unexpected status line: " + str);
                    }
                    zVar = z.f4873e;
                    i4 = 12;
                }
            } else {
                if (str.length() < 9 || str.charAt(8) != ' ') {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                int charAt = str.charAt(7) - '0';
                if (charAt == 0) {
                    zVar = z.f4872d;
                } else {
                    if (charAt != 1) {
                        throw new ProtocolException("Unexpected status line: " + str);
                    }
                    zVar = z.f4873e;
                }
            }
            int i5 = i4 + 3;
            if (str.length() < i5) {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            String substring = str.substring(i4, i5);
            e3.f.d(substring, "substring(...)");
            f4 = t.f(substring);
            if (f4 == null) {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            int intValue = f4.intValue();
            if (str.length() <= i5) {
                str2 = "";
            } else {
                if (str.charAt(i5) != ' ') {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                str2 = str.substring(i4 + 4);
                e3.f.d(str2, "substring(...)");
            }
            return new k(zVar, intValue, str2);
        }
    }

    public k(z zVar, int i4, String str) {
        e3.f.e(zVar, "protocol");
        e3.f.e(str, "message");
        this.f5881a = zVar;
        this.f5882b = i4;
        this.f5883c = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f5881a == z.f4872d ? "HTTP/1.0" : "HTTP/1.1");
        sb.append(' ');
        sb.append(this.f5882b);
        sb.append(' ');
        sb.append(this.f5883c);
        String sb2 = sb.toString();
        e3.f.d(sb2, "toString(...)");
        return sb2;
    }
}
