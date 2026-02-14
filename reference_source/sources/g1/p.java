package g1;

/* loaded from: classes.dex */
public abstract class p extends Exception {

    /* renamed from: b, reason: collision with root package name */
    protected static final boolean f3959b;

    /* renamed from: c, reason: collision with root package name */
    protected static final StackTraceElement[] f3960c;

    static {
        f3959b = System.getProperty("surefire.test.class.path") != null;
        f3960c = new StackTraceElement[0];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(Throwable th) {
        super(th);
    }

    @Override // java.lang.Throwable
    public final synchronized Throwable fillInStackTrace() {
        return null;
    }
}
