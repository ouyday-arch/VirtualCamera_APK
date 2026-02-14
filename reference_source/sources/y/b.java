package y;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private final Context f6523a;

    /* renamed from: b, reason: collision with root package name */
    private a f6524b;

    /* renamed from: c, reason: collision with root package name */
    private InterfaceC0095b f6525c;

    /* loaded from: classes.dex */
    public interface a {
    }

    /* renamed from: y.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0095b {
        void onActionProviderVisibilityChanged(boolean z4);
    }

    public b(Context context) {
        this.f6523a = context;
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return true;
    }

    public abstract View c();

    public View d(MenuItem menuItem) {
        return c();
    }

    public boolean e() {
        return false;
    }

    public void f(SubMenu subMenu) {
    }

    public boolean g() {
        return false;
    }

    public void h() {
        this.f6525c = null;
        this.f6524b = null;
    }

    public void i(a aVar) {
        this.f6524b = aVar;
    }

    public void j(InterfaceC0095b interfaceC0095b) {
        if (this.f6525c != null && interfaceC0095b != null) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.f6525c = interfaceC0095b;
    }
}
