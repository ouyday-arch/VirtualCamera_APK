package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.view.menu.j;

/* loaded from: classes.dex */
public interface d0 {
    void a(Menu menu, j.a aVar);

    boolean b();

    boolean c();

    void collapseActionView();

    boolean d();

    boolean e();

    void f();

    boolean g();

    CharSequence getTitle();

    void h();

    int i();

    void j(int i4);

    void k(int i4);

    void l(p0 p0Var);

    ViewGroup m();

    void n(boolean z4);

    Context o();

    int p();

    y.t q(int i4, long j4);

    void r();

    boolean s();

    void setIcon(int i4);

    void setIcon(Drawable drawable);

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);

    void t();

    void u(boolean z4);

    void v(int i4);
}
