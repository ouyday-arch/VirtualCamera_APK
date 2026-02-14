package t1;

import java.nio.charset.StandardCharsets;

/* loaded from: classes.dex */
final class h {

    /* renamed from: a, reason: collision with root package name */
    private final String f5921a;

    /* renamed from: b, reason: collision with root package name */
    private l f5922b;

    /* renamed from: c, reason: collision with root package name */
    private g1.f f5923c;

    /* renamed from: d, reason: collision with root package name */
    private g1.f f5924d;

    /* renamed from: e, reason: collision with root package name */
    private final StringBuilder f5925e;

    /* renamed from: f, reason: collision with root package name */
    int f5926f;

    /* renamed from: g, reason: collision with root package name */
    private int f5927g;

    /* renamed from: h, reason: collision with root package name */
    private k f5928h;

    /* renamed from: i, reason: collision with root package name */
    private int f5929i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.ISO_8859_1);
        StringBuilder sb = new StringBuilder(bytes.length);
        int length = bytes.length;
        for (int i4 = 0; i4 < length; i4++) {
            char c5 = (char) (bytes[i4] & 255);
            if (c5 == '?' && str.charAt(i4) != '?') {
                throw new IllegalArgumentException("Message contains characters outside ISO-8859-1 encoding.");
            }
            sb.append(c5);
        }
        this.f5921a = sb.toString();
        this.f5922b = l.FORCE_NONE;
        this.f5925e = new StringBuilder(str.length());
        this.f5927g = -1;
    }

    private int h() {
        return this.f5921a.length() - this.f5929i;
    }

    public int a() {
        return this.f5925e.length();
    }

    public StringBuilder b() {
        return this.f5925e;
    }

    public char c() {
        return this.f5921a.charAt(this.f5926f);
    }

    public String d() {
        return this.f5921a;
    }

    public int e() {
        return this.f5927g;
    }

    public int f() {
        return h() - this.f5926f;
    }

    public k g() {
        return this.f5928h;
    }

    public boolean i() {
        return this.f5926f < h();
    }

    public void j() {
        this.f5927g = -1;
    }

    public void k() {
        this.f5928h = null;
    }

    public void l(g1.f fVar, g1.f fVar2) {
        this.f5923c = fVar;
        this.f5924d = fVar2;
    }

    public void m(int i4) {
        this.f5929i = i4;
    }

    public void n(l lVar) {
        this.f5922b = lVar;
    }

    public void o(int i4) {
        this.f5927g = i4;
    }

    public void p() {
        q(a());
    }

    public void q(int i4) {
        k kVar = this.f5928h;
        if (kVar == null || i4 > kVar.a()) {
            this.f5928h = k.l(i4, this.f5922b, this.f5923c, this.f5924d, true);
        }
    }

    public void r(char c5) {
        this.f5925e.append(c5);
    }

    public void s(String str) {
        this.f5925e.append(str);
    }
}
