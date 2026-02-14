package org.chromium.support_lib_boundary;

/* loaded from: classes.dex */
public interface ServiceWorkerWebSettingsBoundaryInterface {
    boolean getAllowContentAccess();

    boolean getAllowFileAccess();

    boolean getBlockNetworkLoads();

    int getCacheMode();

    void setAllowContentAccess(boolean z4);

    void setAllowFileAccess(boolean z4);

    void setBlockNetworkLoads(boolean z4);

    void setCacheMode(int i4);
}
