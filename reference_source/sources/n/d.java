package n;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.lifecycle.d;
import androidx.lifecycle.h;
import androidx.lifecycle.o;
import y.d;

/* loaded from: classes.dex */
public class d extends Activity implements androidx.lifecycle.g, d.a {

    /* renamed from: b, reason: collision with root package name */
    private k.g<Class<Object>, Object> f5234b = new k.g<>();

    /* renamed from: c, reason: collision with root package name */
    private h f5235c = new h(this);

    public androidx.lifecycle.d a() {
        return this.f5235c;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !y.d.d(decorView, keyEvent)) {
            return y.d.e(this, decorView, this, keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !y.d.d(decorView, keyEvent)) {
            return super.dispatchKeyShortcutEvent(keyEvent);
        }
        return true;
    }

    @Override // y.d.a
    public boolean f(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    @SuppressLint({"RestrictedApi"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        o.e(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        this.f5235c.k(d.b.CREATED);
        super.onSaveInstanceState(bundle);
    }
}
