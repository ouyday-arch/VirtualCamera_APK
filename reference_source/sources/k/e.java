package k;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Objects;

/* loaded from: classes.dex */
public class e<K, V> {

    /* renamed from: a, reason: collision with root package name */
    private final LinkedHashMap<K, V> f4306a;

    /* renamed from: b, reason: collision with root package name */
    private int f4307b;

    /* renamed from: c, reason: collision with root package name */
    private int f4308c;

    /* renamed from: d, reason: collision with root package name */
    private int f4309d;

    /* renamed from: e, reason: collision with root package name */
    private int f4310e;

    /* renamed from: f, reason: collision with root package name */
    private int f4311f;

    /* renamed from: g, reason: collision with root package name */
    private int f4312g;

    /* renamed from: h, reason: collision with root package name */
    private int f4313h;

    public e(int i4) {
        if (i4 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f4308c = i4;
        this.f4306a = new LinkedHashMap<>(0, 0.75f, true);
    }

    private int e(K k4, V v4) {
        int f4 = f(k4, v4);
        if (f4 >= 0) {
            return f4;
        }
        throw new IllegalStateException("Negative size: " + k4 + "=" + v4);
    }

    protected V a(K k4) {
        return null;
    }

    protected void b(boolean z4, K k4, V v4, V v5) {
    }

    public final V c(K k4) {
        V v4;
        Objects.requireNonNull(k4, "key == null");
        synchronized (this) {
            V v5 = this.f4306a.get(k4);
            if (v5 != null) {
                this.f4312g++;
                return v5;
            }
            this.f4313h++;
            V a5 = a(k4);
            if (a5 == null) {
                return null;
            }
            synchronized (this) {
                this.f4310e++;
                v4 = (V) this.f4306a.put(k4, a5);
                if (v4 != null) {
                    this.f4306a.put(k4, v4);
                } else {
                    this.f4307b += e(k4, a5);
                }
            }
            if (v4 != null) {
                b(false, k4, a5, v4);
                return v4;
            }
            g(this.f4308c);
            return a5;
        }
    }

    public final V d(K k4, V v4) {
        V put;
        if (k4 == null || v4 == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.f4309d++;
            this.f4307b += e(k4, v4);
            put = this.f4306a.put(k4, v4);
            if (put != null) {
                this.f4307b -= e(k4, put);
            }
        }
        if (put != null) {
            b(false, k4, put, v4);
        }
        g(this.f4308c);
        return put;
    }

    protected int f(K k4, V v4) {
        return 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0070, code lost:
    
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void g(int r5) {
        /*
            r4 = this;
        L0:
            monitor-enter(r4)
            int r0 = r4.f4307b     // Catch: java.lang.Throwable -> L71
            if (r0 < 0) goto L52
            java.util.LinkedHashMap<K, V> r0 = r4.f4306a     // Catch: java.lang.Throwable -> L71
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L71
            if (r0 == 0) goto L11
            int r0 = r4.f4307b     // Catch: java.lang.Throwable -> L71
            if (r0 != 0) goto L52
        L11:
            int r0 = r4.f4307b     // Catch: java.lang.Throwable -> L71
            if (r0 <= r5) goto L50
            java.util.LinkedHashMap<K, V> r0 = r4.f4306a     // Catch: java.lang.Throwable -> L71
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L71
            if (r0 == 0) goto L1e
            goto L50
        L1e:
            java.util.LinkedHashMap<K, V> r0 = r4.f4306a     // Catch: java.lang.Throwable -> L71
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L71
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L71
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L71
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L71
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L71
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L71
            java.util.LinkedHashMap<K, V> r2 = r4.f4306a     // Catch: java.lang.Throwable -> L71
            r2.remove(r1)     // Catch: java.lang.Throwable -> L71
            int r2 = r4.f4307b     // Catch: java.lang.Throwable -> L71
            int r3 = r4.e(r1, r0)     // Catch: java.lang.Throwable -> L71
            int r2 = r2 - r3
            r4.f4307b = r2     // Catch: java.lang.Throwable -> L71
            int r2 = r4.f4311f     // Catch: java.lang.Throwable -> L71
            r3 = 1
            int r2 = r2 + r3
            r4.f4311f = r2     // Catch: java.lang.Throwable -> L71
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L71
            r2 = 0
            r4.b(r3, r1, r0, r2)
            goto L0
        L50:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L71
            return
        L52:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L71
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L71
            r0.<init>()     // Catch: java.lang.Throwable -> L71
            java.lang.Class r1 = r4.getClass()     // Catch: java.lang.Throwable -> L71
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L71
            r0.append(r1)     // Catch: java.lang.Throwable -> L71
            java.lang.String r1 = ".sizeOf() is reporting inconsistent results!"
            r0.append(r1)     // Catch: java.lang.Throwable -> L71
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L71
            r5.<init>(r0)     // Catch: java.lang.Throwable -> L71
            throw r5     // Catch: java.lang.Throwable -> L71
        L71:
            r5 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L71
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: k.e.g(int):void");
    }

    public final synchronized String toString() {
        int i4;
        int i5;
        i4 = this.f4312g;
        i5 = this.f4313h + i4;
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.f4308c), Integer.valueOf(this.f4312g), Integer.valueOf(this.f4313h), Integer.valueOf(i5 != 0 ? (i4 * 100) / i5 : 0));
    }
}
