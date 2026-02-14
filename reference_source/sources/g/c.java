package g;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.reflect.Method;
import y.b;

/* loaded from: classes.dex */
public class c extends g.b implements MenuItem {

    /* renamed from: d, reason: collision with root package name */
    private final s.b f3749d;

    /* renamed from: e, reason: collision with root package name */
    private Method f3750e;

    /* loaded from: classes.dex */
    private class a extends y.b {

        /* renamed from: d, reason: collision with root package name */
        final ActionProvider f3751d;

        a(Context context, ActionProvider actionProvider) {
            super(context);
            this.f3751d = actionProvider;
        }

        @Override // y.b
        public boolean a() {
            return this.f3751d.hasSubMenu();
        }

        @Override // y.b
        public View c() {
            return this.f3751d.onCreateActionView();
        }

        @Override // y.b
        public boolean e() {
            return this.f3751d.onPerformDefaultAction();
        }

        @Override // y.b
        public void f(SubMenu subMenu) {
            this.f3751d.onPrepareSubMenu(c.this.d(subMenu));
        }
    }

    /* loaded from: classes.dex */
    private class b extends a implements ActionProvider.VisibilityListener {

        /* renamed from: f, reason: collision with root package name */
        private b.InterfaceC0095b f3753f;

        b(Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        @Override // y.b
        public boolean b() {
            return this.f3751d.isVisible();
        }

        @Override // y.b
        public View d(MenuItem menuItem) {
            return this.f3751d.onCreateActionView(menuItem);
        }

        @Override // y.b
        public boolean g() {
            return this.f3751d.overridesItemVisibility();
        }

        @Override // y.b
        public void j(b.InterfaceC0095b interfaceC0095b) {
            this.f3753f = interfaceC0095b;
            this.f3751d.setVisibilityListener(interfaceC0095b != null ? this : null);
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean z4) {
            b.InterfaceC0095b interfaceC0095b = this.f3753f;
            if (interfaceC0095b != null) {
                interfaceC0095b.onActionProviderVisibilityChanged(z4);
            }
        }
    }

    /* renamed from: g.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0040c extends FrameLayout implements f.c {

        /* renamed from: b, reason: collision with root package name */
        final CollapsibleActionView f3755b;

        /* JADX WARN: Multi-variable type inference failed */
        C0040c(View view) {
            super(view.getContext());
            this.f3755b = (CollapsibleActionView) view;
            addView(view);
        }

        View a() {
            return (View) this.f3755b;
        }

        @Override // f.c
        public void c() {
            this.f3755b.onActionViewExpanded();
        }

        @Override // f.c
        public void f() {
            this.f3755b.onActionViewCollapsed();
        }
    }

    /* loaded from: classes.dex */
    private class d implements MenuItem.OnActionExpandListener {

        /* renamed from: a, reason: collision with root package name */
        private final MenuItem.OnActionExpandListener f3756a;

        d(MenuItem.OnActionExpandListener onActionExpandListener) {
            this.f3756a = onActionExpandListener;
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.f3756a.onMenuItemActionCollapse(c.this.c(menuItem));
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.f3756a.onMenuItemActionExpand(c.this.c(menuItem));
        }
    }

    /* loaded from: classes.dex */
    private class e implements MenuItem.OnMenuItemClickListener {

        /* renamed from: a, reason: collision with root package name */
        private final MenuItem.OnMenuItemClickListener f3758a;

        e(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.f3758a = onMenuItemClickListener;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            return this.f3758a.onMenuItemClick(c.this.c(menuItem));
        }
    }

    public c(Context context, s.b bVar) {
        super(context);
        if (bVar == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.f3749d = bVar;
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        return this.f3749d.collapseActionView();
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        return this.f3749d.expandActionView();
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        y.b a5 = this.f3749d.a();
        if (a5 instanceof a) {
            return ((a) a5).f3751d;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        View actionView = this.f3749d.getActionView();
        return actionView instanceof C0040c ? ((C0040c) actionView).a() : actionView;
    }

    @Override // android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f3749d.getAlphabeticModifiers();
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f3749d.getAlphabeticShortcut();
    }

    @Override // android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f3749d.getContentDescription();
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f3749d.getGroupId();
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f3749d.getIcon();
    }

    @Override // android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f3749d.getIconTintList();
    }

    @Override // android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f3749d.getIconTintMode();
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f3749d.getIntent();
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f3749d.getItemId();
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f3749d.getMenuInfo();
    }

    @Override // android.view.MenuItem
    public int getNumericModifiers() {
        return this.f3749d.getNumericModifiers();
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f3749d.getNumericShortcut();
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f3749d.getOrder();
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return d(this.f3749d.getSubMenu());
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f3749d.getTitle();
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return this.f3749d.getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f3749d.getTooltipText();
    }

    public void h(boolean z4) {
        try {
            if (this.f3750e == null) {
                this.f3750e = this.f3749d.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
            }
            this.f3750e.invoke(this.f3749d, Boolean.valueOf(z4));
        } catch (Exception e4) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e4);
        }
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f3749d.hasSubMenu();
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.f3749d.isActionViewExpanded();
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return this.f3749d.isCheckable();
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return this.f3749d.isChecked();
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return this.f3749d.isEnabled();
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return this.f3749d.isVisible();
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        b bVar = new b(this.f3746a, actionProvider);
        s.b bVar2 = this.f3749d;
        if (actionProvider == null) {
            bVar = null;
        }
        bVar2.b(bVar);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int i4) {
        this.f3749d.setActionView(i4);
        View actionView = this.f3749d.getActionView();
        if (actionView instanceof CollapsibleActionView) {
            this.f3749d.setActionView(new C0040c(actionView));
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new C0040c(view);
        }
        this.f3749d.setActionView(view);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c5) {
        this.f3749d.setAlphabeticShortcut(c5);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c5, int i4) {
        this.f3749d.setAlphabeticShortcut(c5, i4);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z4) {
        this.f3749d.setCheckable(z4);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z4) {
        this.f3749d.setChecked(z4);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setContentDescription(CharSequence charSequence) {
        this.f3749d.setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z4) {
        this.f3749d.setEnabled(z4);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i4) {
        this.f3749d.setIcon(i4);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f3749d.setIcon(drawable);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f3749d.setIconTintList(colorStateList);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f3749d.setIconTintMode(mode);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f3749d.setIntent(intent);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c5) {
        this.f3749d.setNumericShortcut(c5);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c5, int i4) {
        this.f3749d.setNumericShortcut(c5, i4);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f3749d.setOnActionExpandListener(onActionExpandListener != null ? new d(onActionExpandListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f3749d.setOnMenuItemClickListener(onMenuItemClickListener != null ? new e(onMenuItemClickListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c5, char c6) {
        this.f3749d.setShortcut(c5, c6);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c5, char c6, int i4, int i5) {
        this.f3749d.setShortcut(c5, c6, i4, i5);
        return this;
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i4) {
        this.f3749d.setShowAsAction(i4);
    }

    @Override // android.view.MenuItem
    public MenuItem setShowAsActionFlags(int i4) {
        this.f3749d.setShowAsActionFlags(i4);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i4) {
        this.f3749d.setTitle(i4);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f3749d.setTitle(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f3749d.setTitleCondensed(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTooltipText(CharSequence charSequence) {
        this.f3749d.setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z4) {
        return this.f3749d.setVisible(z4);
    }
}
