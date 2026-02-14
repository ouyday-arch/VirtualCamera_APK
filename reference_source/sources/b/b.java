package b;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.d;
import f.b;
import y.d;

/* loaded from: classes.dex */
public class b extends Dialog implements b.a {

    /* renamed from: b, reason: collision with root package name */
    private d f2124b;

    /* renamed from: c, reason: collision with root package name */
    private final d.a f2125c;

    /* loaded from: classes.dex */
    class a implements d.a {
        a() {
        }

        @Override // y.d.a
        public boolean f(KeyEvent keyEvent) {
            return b.this.c(keyEvent);
        }
    }

    public b(Context context, int i4) {
        super(context, b(context, i4));
        this.f2125c = new a();
        androidx.appcompat.app.d a5 = a();
        a5.C(b(context, i4));
        a5.q(null);
    }

    private static int b(Context context, int i4) {
        if (i4 != 0) {
            return i4;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(a.a.f24y, typedValue, true);
        return typedValue.resourceId;
    }

    public androidx.appcompat.app.d a() {
        if (this.f2124b == null) {
            this.f2124b = androidx.appcompat.app.d.f(this, this);
        }
        return this.f2124b;
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a().c(view, layoutParams);
    }

    boolean c(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean d(int i4) {
        return a().y(i4);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return y.d.e(this.f2125c, getWindow().getDecorView(), this, keyEvent);
    }

    @Override // b.a
    public void e(f.b bVar) {
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int i4) {
        return (T) a().g(i4);
    }

    @Override // b.a
    public f.b i(b.a aVar) {
        return null;
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        a().m();
    }

    @Override // b.a
    public void j(f.b bVar) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        a().l();
        super.onCreate(bundle);
        a().q(bundle);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        a().w();
    }

    @Override // android.app.Dialog
    public void setContentView(int i4) {
        a().z(i4);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        a().A(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a().B(view, layoutParams);
    }

    @Override // android.app.Dialog
    public void setTitle(int i4) {
        super.setTitle(i4);
        a().D(getContext().getString(i4));
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        a().D(charSequence);
    }
}
