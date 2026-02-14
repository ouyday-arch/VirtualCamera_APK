package k3;

import java.util.concurrent.TimeUnit;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: c, reason: collision with root package name */
    public static final d f4455c = new d("NANOSECONDS", 0, TimeUnit.NANOSECONDS);

    /* renamed from: d, reason: collision with root package name */
    public static final d f4456d = new d("MICROSECONDS", 1, TimeUnit.MICROSECONDS);

    /* renamed from: e, reason: collision with root package name */
    public static final d f4457e = new d("MILLISECONDS", 2, TimeUnit.MILLISECONDS);

    /* renamed from: f, reason: collision with root package name */
    public static final d f4458f = new d("SECONDS", 3, TimeUnit.SECONDS);

    /* renamed from: g, reason: collision with root package name */
    public static final d f4459g = new d("MINUTES", 4, TimeUnit.MINUTES);

    /* renamed from: h, reason: collision with root package name */
    public static final d f4460h = new d("HOURS", 5, TimeUnit.HOURS);

    /* renamed from: i, reason: collision with root package name */
    public static final d f4461i = new d("DAYS", 6, TimeUnit.DAYS);

    /* renamed from: j, reason: collision with root package name */
    private static final /* synthetic */ d[] f4462j;

    /* renamed from: k, reason: collision with root package name */
    private static final /* synthetic */ y2.a f4463k;

    /* renamed from: b, reason: collision with root package name */
    private final TimeUnit f4464b;

    static {
        d[] a5 = a();
        f4462j = a5;
        f4463k = y2.b.a(a5);
    }

    private d(String str, int i4, TimeUnit timeUnit) {
        this.f4464b = timeUnit;
    }

    private static final /* synthetic */ d[] a() {
        return new d[]{f4455c, f4456d, f4457e, f4458f, f4459g, f4460h, f4461i};
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) f4462j.clone();
    }

    public final TimeUnit b() {
        return this.f4464b;
    }
}
