package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.j;
import y.p;

/* loaded from: classes.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private final Context f696a;

    /* renamed from: b, reason: collision with root package name */
    private final e f697b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f698c;

    /* renamed from: d, reason: collision with root package name */
    private final int f699d;

    /* renamed from: e, reason: collision with root package name */
    private final int f700e;

    /* renamed from: f, reason: collision with root package name */
    private View f701f;

    /* renamed from: g, reason: collision with root package name */
    private int f702g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f703h;

    /* renamed from: i, reason: collision with root package name */
    private j.a f704i;

    /* renamed from: j, reason: collision with root package name */
    private h f705j;

    /* renamed from: k, reason: collision with root package name */
    private PopupWindow.OnDismissListener f706k;

    /* renamed from: l, reason: collision with root package name */
    private final PopupWindow.OnDismissListener f707l;

    /* loaded from: classes.dex */
    class a implements PopupWindow.OnDismissListener {
        a() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            i.this.e();
        }
    }

    public i(Context context, e eVar, View view, boolean z4, int i4) {
        this(context, eVar, view, z4, i4, 0);
    }

    public i(Context context, e eVar, View view, boolean z4, int i4, int i5) {
        this.f702g = 8388611;
        this.f707l = new a();
        this.f696a = context;
        this.f697b = eVar;
        this.f701f = view;
        this.f698c = z4;
        this.f699d = i4;
        this.f700e = i5;
    }

    private h a() {
        Display defaultDisplay = ((WindowManager) this.f696a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        h bVar = Math.min(point.x, point.y) >= this.f696a.getResources().getDimensionPixelSize(a.d.f36c) ? new b(this.f696a, this.f701f, this.f699d, this.f700e, this.f698c) : new l(this.f696a, this.f697b, this.f701f, this.f699d, this.f700e, this.f698c);
        bVar.j(this.f697b);
        bVar.t(this.f707l);
        bVar.o(this.f701f);
        bVar.g(this.f704i);
        bVar.q(this.f703h);
        bVar.r(this.f702g);
        return bVar;
    }

    private void l(int i4, int i5, boolean z4, boolean z5) {
        h c5 = c();
        c5.u(z5);
        if (z4) {
            if ((y.c.b(this.f702g, p.t(this.f701f)) & 7) == 5) {
                i4 -= this.f701f.getWidth();
            }
            c5.s(i4);
            c5.v(i5);
            int i6 = (int) ((this.f696a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            c5.p(new Rect(i4 - i6, i5 - i6, i4 + i6, i5 + i6));
        }
        c5.show();
    }

    public void b() {
        if (d()) {
            this.f705j.dismiss();
        }
    }

    public h c() {
        if (this.f705j == null) {
            this.f705j = a();
        }
        return this.f705j;
    }

    public boolean d() {
        h hVar = this.f705j;
        return hVar != null && hVar.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        this.f705j = null;
        PopupWindow.OnDismissListener onDismissListener = this.f706k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void f(View view) {
        this.f701f = view;
    }

    public void g(boolean z4) {
        this.f703h = z4;
        h hVar = this.f705j;
        if (hVar != null) {
            hVar.q(z4);
        }
    }

    public void h(int i4) {
        this.f702g = i4;
    }

    public void i(PopupWindow.OnDismissListener onDismissListener) {
        this.f706k = onDismissListener;
    }

    public void j(j.a aVar) {
        this.f704i = aVar;
        h hVar = this.f705j;
        if (hVar != null) {
            hVar.g(aVar);
        }
    }

    public void k() {
        if (!m()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public boolean m() {
        if (d()) {
            return true;
        }
        if (this.f701f == null) {
            return false;
        }
        l(0, 0, false, false);
        return true;
    }

    public boolean n(int i4, int i5) {
        if (d()) {
            return true;
        }
        if (this.f701f == null) {
            return false;
        }
        l(i4, i5, true, true);
        return true;
    }
}
