package n1;

import java.util.List;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f5295a;

    /* renamed from: b, reason: collision with root package name */
    private int f5296b;

    /* renamed from: c, reason: collision with root package name */
    private final String f5297c;

    /* renamed from: d, reason: collision with root package name */
    private final List<byte[]> f5298d;

    /* renamed from: e, reason: collision with root package name */
    private final String f5299e;

    /* renamed from: f, reason: collision with root package name */
    private Integer f5300f;

    /* renamed from: g, reason: collision with root package name */
    private Integer f5301g;

    /* renamed from: h, reason: collision with root package name */
    private Object f5302h;

    /* renamed from: i, reason: collision with root package name */
    private final int f5303i;

    /* renamed from: j, reason: collision with root package name */
    private final int f5304j;

    public e(byte[] bArr, String str, List<byte[]> list, String str2) {
        this(bArr, str, list, str2, -1, -1);
    }

    public e(byte[] bArr, String str, List<byte[]> list, String str2, int i4, int i5) {
        this.f5295a = bArr;
        this.f5296b = bArr == null ? 0 : bArr.length * 8;
        this.f5297c = str;
        this.f5298d = list;
        this.f5299e = str2;
        this.f5303i = i5;
        this.f5304j = i4;
    }

    public List<byte[]> a() {
        return this.f5298d;
    }

    public String b() {
        return this.f5299e;
    }

    public int c() {
        return this.f5296b;
    }

    public Object d() {
        return this.f5302h;
    }

    public byte[] e() {
        return this.f5295a;
    }

    public int f() {
        return this.f5303i;
    }

    public int g() {
        return this.f5304j;
    }

    public String h() {
        return this.f5297c;
    }

    public boolean i() {
        return this.f5303i >= 0 && this.f5304j >= 0;
    }

    public void j(Integer num) {
        this.f5301g = num;
    }

    public void k(Integer num) {
        this.f5300f = num;
    }

    public void l(int i4) {
        this.f5296b = i4;
    }

    public void m(Object obj) {
        this.f5302h = obj;
    }
}
