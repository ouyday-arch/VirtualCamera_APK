package v;

import android.util.Base64;
import java.util.List;
import x.h;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final String f6227a;

    /* renamed from: b, reason: collision with root package name */
    private final String f6228b;

    /* renamed from: c, reason: collision with root package name */
    private final String f6229c;

    /* renamed from: d, reason: collision with root package name */
    private final List<List<byte[]>> f6230d;

    /* renamed from: e, reason: collision with root package name */
    private final int f6231e;

    /* renamed from: f, reason: collision with root package name */
    private final String f6232f;

    public a(String str, String str2, String str3, List<List<byte[]>> list) {
        String str4 = (String) h.c(str);
        this.f6227a = str4;
        String str5 = (String) h.c(str2);
        this.f6228b = str5;
        String str6 = (String) h.c(str3);
        this.f6229c = str6;
        this.f6230d = (List) h.c(list);
        this.f6231e = 0;
        this.f6232f = str4 + "-" + str5 + "-" + str6;
    }

    public List<List<byte[]>> a() {
        return this.f6230d;
    }

    public int b() {
        return this.f6231e;
    }

    public String c() {
        return this.f6232f;
    }

    public String d() {
        return this.f6227a;
    }

    public String e() {
        return this.f6228b;
    }

    public String f() {
        return this.f6229c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f6227a + ", mProviderPackage: " + this.f6228b + ", mQuery: " + this.f6229c + ", mCertificates:");
        for (int i4 = 0; i4 < this.f6230d.size(); i4++) {
            sb.append(" [");
            List<byte[]> list = this.f6230d.get(i4);
            for (int i5 = 0; i5 < list.size(); i5++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString(list.get(i5), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.f6231e);
        return sb.toString();
    }
}
