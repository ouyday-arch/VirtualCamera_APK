package androidx.fragment.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private final h<?> f1495a;

    private f(h<?> hVar) {
        this.f1495a = hVar;
    }

    public static f b(h<?> hVar) {
        return new f((h) x.h.d(hVar, "callbacks == null"));
    }

    public void a(Fragment fragment) {
        h<?> hVar = this.f1495a;
        hVar.f1501f.n(hVar, hVar, fragment);
    }

    public void c() {
        this.f1495a.f1501f.w();
    }

    public void d(Configuration configuration) {
        this.f1495a.f1501f.x(configuration);
    }

    public boolean e(MenuItem menuItem) {
        return this.f1495a.f1501f.y(menuItem);
    }

    public void f() {
        this.f1495a.f1501f.z();
    }

    public boolean g(Menu menu, MenuInflater menuInflater) {
        return this.f1495a.f1501f.A(menu, menuInflater);
    }

    public void h() {
        this.f1495a.f1501f.B();
    }

    public void i() {
        this.f1495a.f1501f.D();
    }

    public void j(boolean z4) {
        this.f1495a.f1501f.E(z4);
    }

    public boolean k(MenuItem menuItem) {
        return this.f1495a.f1501f.T(menuItem);
    }

    public void l(Menu menu) {
        this.f1495a.f1501f.U(menu);
    }

    public void m() {
        this.f1495a.f1501f.W();
    }

    public void n(boolean z4) {
        this.f1495a.f1501f.X(z4);
    }

    public boolean o(Menu menu) {
        return this.f1495a.f1501f.Y(menu);
    }

    public void p() {
        this.f1495a.f1501f.a0();
    }

    public void q() {
        this.f1495a.f1501f.b0();
    }

    public void r() {
        this.f1495a.f1501f.d0();
    }

    public boolean s() {
        return this.f1495a.f1501f.j0();
    }

    public Fragment t(String str) {
        return this.f1495a.f1501f.p0(str);
    }

    public i u() {
        return this.f1495a.f1501f;
    }

    public void v() {
        this.f1495a.f1501f.R0();
    }

    public View w(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f1495a.f1501f.onCreateView(view, str, context, attributeSet);
    }

    public void x(Parcelable parcelable) {
        h<?> hVar = this.f1495a;
        if (!(hVar instanceof androidx.lifecycle.s)) {
            throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
        }
        hVar.f1501f.b1(parcelable);
    }

    public Parcelable y() {
        return this.f1495a.f1501f.d1();
    }
}
