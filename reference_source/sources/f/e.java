package f;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.widget.ActionBarContextView;
import f.b;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class e extends b implements e.a {

    /* renamed from: d, reason: collision with root package name */
    private Context f3642d;

    /* renamed from: e, reason: collision with root package name */
    private ActionBarContextView f3643e;

    /* renamed from: f, reason: collision with root package name */
    private b.a f3644f;

    /* renamed from: g, reason: collision with root package name */
    private WeakReference<View> f3645g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f3646h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f3647i;

    /* renamed from: j, reason: collision with root package name */
    private androidx.appcompat.view.menu.e f3648j;

    public e(Context context, ActionBarContextView actionBarContextView, b.a aVar, boolean z4) {
        this.f3642d = context;
        this.f3643e = actionBarContextView;
        this.f3644f = aVar;
        androidx.appcompat.view.menu.e S = new androidx.appcompat.view.menu.e(actionBarContextView.getContext()).S(1);
        this.f3648j = S;
        S.R(this);
        this.f3647i = z4;
    }

    @Override // androidx.appcompat.view.menu.e.a
    public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
        return this.f3644f.a(this, menuItem);
    }

    @Override // androidx.appcompat.view.menu.e.a
    public void b(androidx.appcompat.view.menu.e eVar) {
        k();
        this.f3643e.l();
    }

    @Override // f.b
    public void c() {
        if (this.f3646h) {
            return;
        }
        this.f3646h = true;
        this.f3643e.sendAccessibilityEvent(32);
        this.f3644f.c(this);
    }

    @Override // f.b
    public View d() {
        WeakReference<View> weakReference = this.f3645g;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // f.b
    public Menu e() {
        return this.f3648j;
    }

    @Override // f.b
    public MenuInflater f() {
        return new g(this.f3643e.getContext());
    }

    @Override // f.b
    public CharSequence g() {
        return this.f3643e.getSubtitle();
    }

    @Override // f.b
    public CharSequence i() {
        return this.f3643e.getTitle();
    }

    @Override // f.b
    public void k() {
        this.f3644f.d(this, this.f3648j);
    }

    @Override // f.b
    public boolean l() {
        return this.f3643e.j();
    }

    @Override // f.b
    public void m(View view) {
        this.f3643e.setCustomView(view);
        this.f3645g = view != null ? new WeakReference<>(view) : null;
    }

    @Override // f.b
    public void n(int i4) {
        o(this.f3642d.getString(i4));
    }

    @Override // f.b
    public void o(CharSequence charSequence) {
        this.f3643e.setSubtitle(charSequence);
    }

    @Override // f.b
    public void q(int i4) {
        r(this.f3642d.getString(i4));
    }

    @Override // f.b
    public void r(CharSequence charSequence) {
        this.f3643e.setTitle(charSequence);
    }

    @Override // f.b
    public void s(boolean z4) {
        super.s(z4);
        this.f3643e.setTitleOptional(z4);
    }
}
