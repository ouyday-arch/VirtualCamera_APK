package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.b;
import androidx.appcompat.view.menu.j;

/* loaded from: classes.dex */
class f implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, j.a {

    /* renamed from: b, reason: collision with root package name */
    private e f664b;

    /* renamed from: c, reason: collision with root package name */
    private androidx.appcompat.app.b f665c;

    /* renamed from: d, reason: collision with root package name */
    c f666d;

    /* renamed from: e, reason: collision with root package name */
    private j.a f667e;

    public f(e eVar) {
        this.f664b = eVar;
    }

    @Override // androidx.appcompat.view.menu.j.a
    public void a(e eVar, boolean z4) {
        if (z4 || eVar == this.f664b) {
            c();
        }
        j.a aVar = this.f667e;
        if (aVar != null) {
            aVar.a(eVar, z4);
        }
    }

    @Override // androidx.appcompat.view.menu.j.a
    public boolean b(e eVar) {
        j.a aVar = this.f667e;
        if (aVar != null) {
            return aVar.b(eVar);
        }
        return false;
    }

    public void c() {
        androidx.appcompat.app.b bVar = this.f665c;
        if (bVar != null) {
            bVar.dismiss();
        }
    }

    public void d(IBinder iBinder) {
        e eVar = this.f664b;
        b.a aVar = new b.a(eVar.u());
        c cVar = new c(aVar.b(), a.g.f107j);
        this.f666d = cVar;
        cVar.g(this);
        this.f664b.b(this.f666d);
        aVar.c(this.f666d.b(), this);
        View y4 = eVar.y();
        if (y4 != null) {
            aVar.e(y4);
        } else {
            aVar.g(eVar.w()).n(eVar.x());
        }
        aVar.j(this);
        androidx.appcompat.app.b a5 = aVar.a();
        this.f665c = a5;
        a5.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f665c.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f665c.show();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i4) {
        this.f664b.L((g) this.f666d.b().getItem(i4), 0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f666d.a(this.f664b, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i4, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i4 == 82 || i4 == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f665c.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f665c.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f664b.e(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f664b.performShortcut(i4, keyEvent, 0);
    }
}
