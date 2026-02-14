package androidx.appcompat.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.b1;
import f.b;
import n.g;

/* loaded from: classes.dex */
public class c extends androidx.fragment.app.d implements b.a, g.a {

    /* renamed from: s, reason: collision with root package name */
    private d f417s;

    /* renamed from: t, reason: collision with root package name */
    private Resources f418t;

    private boolean E(int i4, KeyEvent keyEvent) {
        Window window;
        return (Build.VERSION.SDK_INT >= 26 || keyEvent.isCtrlPressed() || KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) || keyEvent.getRepeatCount() != 0 || KeyEvent.isModifierKey(keyEvent.getKeyCode()) || (window = getWindow()) == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A(int i4) {
    }

    public void B(n.g gVar) {
    }

    @Deprecated
    public void C() {
    }

    public boolean D() {
        Intent g4 = g();
        if (g4 == null) {
            return false;
        }
        if (!G(g4)) {
            F(g4);
            return true;
        }
        n.g d5 = n.g.d(this);
        z(d5);
        B(d5);
        d5.e();
        try {
            n.a.e(this);
            return true;
        } catch (IllegalStateException unused) {
            finish();
            return true;
        }
    }

    public void F(Intent intent) {
        n.e.e(this, intent);
    }

    public boolean G(Intent intent) {
        return n.e.f(this, intent);
    }

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        x().c(view, layoutParams);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        x().d(context);
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        a y4 = y();
        if (getWindow().hasFeature(0)) {
            if (y4 == null || !y4.g()) {
                super.closeOptionsMenu();
            }
        }
    }

    @Override // n.d, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        a y4 = y();
        if (keyCode == 82 && y4 != null && y4.q(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // b.a
    public void e(f.b bVar) {
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int i4) {
        return (T) x().g(i4);
    }

    @Override // n.g.a
    public Intent g() {
        return n.e.a(this);
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        return x().j();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.f418t == null && b1.b()) {
            this.f418t = new b1(this, super.getResources());
        }
        Resources resources = this.f418t;
        return resources == null ? super.getResources() : resources;
    }

    @Override // b.a
    public f.b i(b.a aVar) {
        return null;
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        x().m();
    }

    @Override // b.a
    public void j(f.b bVar) {
    }

    @Override // androidx.fragment.app.d, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f418t != null) {
            this.f418t.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
        x().p(configuration);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        C();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, n.d, android.app.Activity
    public void onCreate(Bundle bundle) {
        d x4 = x();
        x4.l();
        x4.q(bundle);
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        x().r();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i4, KeyEvent keyEvent) {
        if (E(i4, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i4, keyEvent);
    }

    @Override // androidx.fragment.app.d, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i4, MenuItem menuItem) {
        if (super.onMenuItemSelected(i4, menuItem)) {
            return true;
        }
        a y4 = y();
        if (menuItem.getItemId() != 16908332 || y4 == null || (y4.j() & 4) == 0) {
            return false;
        }
        return D();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i4, Menu menu) {
        return super.onMenuOpened(i4, menu);
    }

    @Override // androidx.fragment.app.d, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i4, Menu menu) {
        super.onPanelClosed(i4, menu);
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        x().s(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        x().t();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, n.d, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        x().u(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, android.app.Activity
    public void onStart() {
        super.onStart();
        x().v();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, android.app.Activity
    public void onStop() {
        super.onStop();
        x().w();
    }

    @Override // android.app.Activity
    protected void onTitleChanged(CharSequence charSequence, int i4) {
        super.onTitleChanged(charSequence, i4);
        x().D(charSequence);
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        a y4 = y();
        if (getWindow().hasFeature(0)) {
            if (y4 == null || !y4.r()) {
                super.openOptionsMenu();
            }
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i4) {
        x().z(i4);
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        x().A(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        x().B(view, layoutParams);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i4) {
        super.setTheme(i4);
        x().C(i4);
    }

    @Override // androidx.fragment.app.d
    public void w() {
        x().m();
    }

    public d x() {
        if (this.f417s == null) {
            this.f417s = d.e(this, this);
        }
        return this.f417s;
    }

    public a y() {
        return x().k();
    }

    public void z(n.g gVar) {
        gVar.b(this);
    }
}
