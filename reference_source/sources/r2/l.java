package r2;

import android.widget.TextView;

/* loaded from: classes.dex */
public final /* synthetic */ class l implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.nvshen.chmp4.m f5854b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TextView f5855c;

    public /* synthetic */ l(com.nvshen.chmp4.m mVar, TextView textView) {
        this.f5854b = mVar;
        this.f5855c = textView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5854b.w1(this.f5855c);
    }
}
