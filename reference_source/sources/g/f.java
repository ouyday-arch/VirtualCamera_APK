package g;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends d implements SubMenu {

    /* renamed from: e, reason: collision with root package name */
    private final s.c f3761e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Context context, s.c cVar) {
        super(context, cVar);
        this.f3761e = cVar;
    }

    @Override // android.view.SubMenu
    public void clearHeader() {
        this.f3761e.clearHeader();
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return c(this.f3761e.getItem());
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i4) {
        this.f3761e.setHeaderIcon(i4);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        this.f3761e.setHeaderIcon(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i4) {
        this.f3761e.setHeaderTitle(i4);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        this.f3761e.setHeaderTitle(charSequence);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        this.f3761e.setHeaderView(view);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i4) {
        this.f3761e.setIcon(i4);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.f3761e.setIcon(drawable);
        return this;
    }
}
