package k0;

import org.chromium.support_lib_boundary.ProxyControllerBoundaryInterface;

/* loaded from: classes.dex */
public class b implements f {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f4341a = new String[0];

    @Override // k0.f
    public String[] a() {
        return f4341a;
    }

    @Override // k0.f
    public ProxyControllerBoundaryInterface getProxyController() {
        throw new UnsupportedOperationException("This should never happen, if this method was called it means we're trying to reach into WebView APK code on an incompatible device. This most likely means the current method is being called too early, or is being called on start-up rather than lazily");
    }
}
