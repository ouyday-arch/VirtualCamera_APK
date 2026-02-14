package k0;

import org.chromium.support_lib_boundary.ProxyControllerBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;

/* loaded from: classes.dex */
public class g implements f {

    /* renamed from: a, reason: collision with root package name */
    WebViewProviderFactoryBoundaryInterface f4370a;

    public g(WebViewProviderFactoryBoundaryInterface webViewProviderFactoryBoundaryInterface) {
        this.f4370a = webViewProviderFactoryBoundaryInterface;
    }

    @Override // k0.f
    public String[] a() {
        return this.f4370a.getSupportedFeatures();
    }

    @Override // k0.f
    public ProxyControllerBoundaryInterface getProxyController() {
        return (ProxyControllerBoundaryInterface) d4.a.a(ProxyControllerBoundaryInterface.class, this.f4370a.getProxyController());
    }
}
