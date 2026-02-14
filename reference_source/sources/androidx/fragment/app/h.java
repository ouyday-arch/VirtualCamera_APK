package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public abstract class h<E> extends e {

    /* renamed from: b, reason: collision with root package name */
    private final Activity f1497b;

    /* renamed from: c, reason: collision with root package name */
    private final Context f1498c;

    /* renamed from: d, reason: collision with root package name */
    private final Handler f1499d;

    /* renamed from: e, reason: collision with root package name */
    private final int f1500e;

    /* renamed from: f, reason: collision with root package name */
    final j f1501f;

    h(Activity activity, Context context, Handler handler, int i4) {
        this.f1501f = new j();
        this.f1497b = activity;
        this.f1498c = (Context) x.h.d(context, "context == null");
        this.f1499d = (Handler) x.h.d(handler, "handler == null");
        this.f1500e = i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(d dVar) {
        this(dVar, dVar, new Handler(), 0);
    }

    @Override // androidx.fragment.app.e
    public View e(int i4) {
        return null;
    }

    @Override // androidx.fragment.app.e
    public boolean f() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Activity g() {
        return this.f1497b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Context i() {
        return this.f1498c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Handler j() {
        return this.f1499d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(Fragment fragment) {
    }

    public void l(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public abstract E m();

    public LayoutInflater n() {
        return LayoutInflater.from(this.f1498c);
    }

    public int o() {
        return this.f1500e;
    }

    public boolean p() {
        return true;
    }

    public void q(Fragment fragment, String[] strArr, int i4) {
    }

    public boolean r(Fragment fragment) {
        return true;
    }

    public boolean s(String str) {
        return false;
    }

    public void t() {
    }
}
