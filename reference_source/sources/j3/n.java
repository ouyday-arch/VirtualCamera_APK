package j3;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends m {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a extends e3.g implements d3.b<String, String> {

        /* renamed from: c, reason: collision with root package name */
        public static final a f4278c = new a();

        a() {
            super(1);
        }

        @Override // d3.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final String b(String str) {
            e3.f.e(str, "line");
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b extends e3.g implements d3.b<String, String> {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f4279c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str) {
            super(1);
            this.f4279c = str;
        }

        @Override // d3.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final String b(String str) {
            e3.f.e(str, "line");
            return this.f4279c + str;
        }
    }

    private static final d3.b<String, String> b(String str) {
        return str.length() == 0 ? a.f4278c : new b(str);
    }

    public static final String c(String str, String str2, String str3) {
        int i4;
        String b5;
        e3.f.e(str, "<this>");
        e3.f.e(str2, "newIndent");
        e3.f.e(str3, "marginPrefix");
        if (!(!u.m(str3))) {
            throw new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
        }
        List<String> V = v.V(str);
        int length = str.length() + (str2.length() * V.size());
        d3.b<String, String> b6 = b(str2);
        int k4 = v2.m.k(V);
        ArrayList arrayList = new ArrayList();
        int i5 = 0;
        for (Object obj : V) {
            int i6 = i5 + 1;
            if (i5 < 0) {
                v2.m.q();
            }
            String str4 = (String) obj;
            String str5 = null;
            if ((i5 == 0 || i5 == k4) && u.m(str4)) {
                str4 = null;
            } else {
                int length2 = str4.length();
                int i7 = 0;
                while (true) {
                    if (i7 >= length2) {
                        i4 = -1;
                        break;
                    }
                    if (!j3.b.c(str4.charAt(i7))) {
                        i4 = i7;
                        break;
                    }
                    i7++;
                }
                if (i4 != -1) {
                    int i8 = i4;
                    if (l.w(str4, str3, i4, false, 4, null)) {
                        int length3 = i8 + str3.length();
                        e3.f.c(str4, "null cannot be cast to non-null type java.lang.String");
                        str5 = str4.substring(length3);
                        e3.f.d(str5, "substring(...)");
                    }
                }
                if (str5 != null && (b5 = b6.b(str5)) != null) {
                    str4 = b5;
                }
            }
            if (str4 != null) {
                arrayList.add(str4);
            }
            i5 = i6;
        }
        String sb = ((StringBuilder) v2.m.C(arrayList, new StringBuilder(length), "\n", null, null, 0, null, null, a.j.N0, null)).toString();
        e3.f.d(sb, "toString(...)");
        return sb;
    }

    public static final String d(String str, String str2) {
        e3.f.e(str, "<this>");
        e3.f.e(str2, "marginPrefix");
        return c(str, "", str2);
    }

    public static /* synthetic */ String e(String str, String str2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str2 = "|";
        }
        return d(str, str2);
    }
}
