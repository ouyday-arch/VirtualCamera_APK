package g1;

import java.util.EnumMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    private final String f3961a;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f3962b;

    /* renamed from: c, reason: collision with root package name */
    private final int f3963c;

    /* renamed from: d, reason: collision with root package name */
    private s[] f3964d;

    /* renamed from: e, reason: collision with root package name */
    private final a f3965e;

    /* renamed from: f, reason: collision with root package name */
    private Map<r, Object> f3966f;

    /* renamed from: g, reason: collision with root package name */
    private final long f3967g;

    public q(String str, byte[] bArr, int i4, s[] sVarArr, a aVar, long j4) {
        this.f3961a = str;
        this.f3962b = bArr;
        this.f3963c = i4;
        this.f3964d = sVarArr;
        this.f3965e = aVar;
        this.f3966f = null;
        this.f3967g = j4;
    }

    public q(String str, byte[] bArr, s[] sVarArr, a aVar) {
        this(str, bArr, sVarArr, aVar, System.currentTimeMillis());
    }

    public q(String str, byte[] bArr, s[] sVarArr, a aVar, long j4) {
        this(str, bArr, bArr == null ? 0 : bArr.length * 8, sVarArr, aVar, j4);
    }

    public void a(s[] sVarArr) {
        s[] sVarArr2 = this.f3964d;
        if (sVarArr2 == null) {
            this.f3964d = sVarArr;
            return;
        }
        if (sVarArr == null || sVarArr.length <= 0) {
            return;
        }
        s[] sVarArr3 = new s[sVarArr2.length + sVarArr.length];
        System.arraycopy(sVarArr2, 0, sVarArr3, 0, sVarArr2.length);
        System.arraycopy(sVarArr, 0, sVarArr3, sVarArr2.length, sVarArr.length);
        this.f3964d = sVarArr3;
    }

    public a b() {
        return this.f3965e;
    }

    public byte[] c() {
        return this.f3962b;
    }

    public Map<r, Object> d() {
        return this.f3966f;
    }

    public s[] e() {
        return this.f3964d;
    }

    public String f() {
        return this.f3961a;
    }

    public void g(Map<r, Object> map) {
        if (map != null) {
            Map<r, Object> map2 = this.f3966f;
            if (map2 == null) {
                this.f3966f = map;
            } else {
                map2.putAll(map);
            }
        }
    }

    public void h(r rVar, Object obj) {
        if (this.f3966f == null) {
            this.f3966f = new EnumMap(r.class);
        }
        this.f3966f.put(rVar, obj);
    }

    public String toString() {
        return this.f3961a;
    }
}
