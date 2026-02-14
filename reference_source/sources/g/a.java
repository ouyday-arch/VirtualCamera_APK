package g;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* loaded from: classes.dex */
public class a implements s.b {

    /* renamed from: a, reason: collision with root package name */
    private final int f3724a;

    /* renamed from: b, reason: collision with root package name */
    private final int f3725b;

    /* renamed from: c, reason: collision with root package name */
    private final int f3726c;

    /* renamed from: d, reason: collision with root package name */
    private final int f3727d;

    /* renamed from: e, reason: collision with root package name */
    private CharSequence f3728e;

    /* renamed from: f, reason: collision with root package name */
    private CharSequence f3729f;

    /* renamed from: g, reason: collision with root package name */
    private Intent f3730g;

    /* renamed from: h, reason: collision with root package name */
    private char f3731h;

    /* renamed from: j, reason: collision with root package name */
    private char f3733j;

    /* renamed from: l, reason: collision with root package name */
    private Drawable f3735l;

    /* renamed from: n, reason: collision with root package name */
    private Context f3737n;

    /* renamed from: o, reason: collision with root package name */
    private MenuItem.OnMenuItemClickListener f3738o;

    /* renamed from: p, reason: collision with root package name */
    private CharSequence f3739p;

    /* renamed from: q, reason: collision with root package name */
    private CharSequence f3740q;

    /* renamed from: i, reason: collision with root package name */
    private int f3732i = 4096;

    /* renamed from: k, reason: collision with root package name */
    private int f3734k = 4096;

    /* renamed from: m, reason: collision with root package name */
    private int f3736m = 0;

    /* renamed from: r, reason: collision with root package name */
    private ColorStateList f3741r = null;

    /* renamed from: s, reason: collision with root package name */
    private PorterDuff.Mode f3742s = null;

    /* renamed from: t, reason: collision with root package name */
    private boolean f3743t = false;

    /* renamed from: u, reason: collision with root package name */
    private boolean f3744u = false;

    /* renamed from: v, reason: collision with root package name */
    private int f3745v = 16;

    public a(Context context, int i4, int i5, int i6, int i7, CharSequence charSequence) {
        this.f3737n = context;
        this.f3724a = i5;
        this.f3725b = i4;
        this.f3726c = i6;
        this.f3727d = i7;
        this.f3728e = charSequence;
    }

    private void c() {
        Drawable drawable = this.f3735l;
        if (drawable != null) {
            if (this.f3743t || this.f3744u) {
                Drawable m4 = r.a.m(drawable);
                this.f3735l = m4;
                Drawable mutate = m4.mutate();
                this.f3735l = mutate;
                if (this.f3743t) {
                    r.a.j(mutate, this.f3741r);
                }
                if (this.f3744u) {
                    r.a.k(this.f3735l, this.f3742s);
                }
            }
        }
    }

    @Override // s.b
    public y.b a() {
        return null;
    }

    @Override // s.b
    public s.b b(y.b bVar) {
        throw new UnsupportedOperationException();
    }

    @Override // s.b, android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    @Override // s.b, android.view.MenuItem
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public s.b setActionView(int i4) {
        throw new UnsupportedOperationException();
    }

    @Override // s.b, android.view.MenuItem
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public s.b setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // s.b, android.view.MenuItem
    public boolean expandActionView() {
        return false;
    }

    @Override // s.b, android.view.MenuItem
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public s.b setShowAsActionFlags(int i4) {
        setShowAsAction(i4);
        return this;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // s.b, android.view.MenuItem
    public View getActionView() {
        return null;
    }

    @Override // s.b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f3734k;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f3733j;
    }

    @Override // s.b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f3739p;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f3725b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f3735l;
    }

    @Override // s.b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f3741r;
    }

    @Override // s.b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f3742s;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f3730g;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f3724a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // s.b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f3732i;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f3731h;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f3727d;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f3728e;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f3729f;
        return charSequence != null ? charSequence : this.f3728e;
    }

    @Override // s.b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f3740q;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return false;
    }

    @Override // s.b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f3745v & 1) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f3745v & 2) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f3745v & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.f3745v & 8) == 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c5) {
        this.f3733j = Character.toLowerCase(c5);
        return this;
    }

    @Override // s.b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c5, int i4) {
        this.f3733j = Character.toLowerCase(c5);
        this.f3734k = KeyEvent.normalizeMetaState(i4);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z4) {
        this.f3745v = (z4 ? 1 : 0) | (this.f3745v & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z4) {
        this.f3745v = (z4 ? 2 : 0) | (this.f3745v & (-3));
        return this;
    }

    @Override // android.view.MenuItem
    public s.b setContentDescription(CharSequence charSequence) {
        this.f3739p = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z4) {
        this.f3745v = (z4 ? 16 : 0) | (this.f3745v & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i4) {
        this.f3736m = i4;
        this.f3735l = o.a.c(this.f3737n, i4);
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f3735l = drawable;
        this.f3736m = 0;
        c();
        return this;
    }

    @Override // s.b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f3741r = colorStateList;
        this.f3743t = true;
        c();
        return this;
    }

    @Override // s.b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f3742s = mode;
        this.f3744u = true;
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f3730g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c5) {
        this.f3731h = c5;
        return this;
    }

    @Override // s.b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c5, int i4) {
        this.f3731h = c5;
        this.f3732i = KeyEvent.normalizeMetaState(i4);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f3738o = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c5, char c6) {
        this.f3731h = c5;
        this.f3733j = Character.toLowerCase(c6);
        return this;
    }

    @Override // s.b, android.view.MenuItem
    public MenuItem setShortcut(char c5, char c6, int i4, int i5) {
        this.f3731h = c5;
        this.f3732i = KeyEvent.normalizeMetaState(i4);
        this.f3733j = Character.toLowerCase(c6);
        this.f3734k = KeyEvent.normalizeMetaState(i5);
        return this;
    }

    @Override // s.b, android.view.MenuItem
    public void setShowAsAction(int i4) {
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i4) {
        this.f3728e = this.f3737n.getResources().getString(i4);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f3728e = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f3729f = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public s.b setTooltipText(CharSequence charSequence) {
        this.f3740q = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z4) {
        this.f3745v = (this.f3745v & 8) | (z4 ? 0 : 8);
        return this;
    }
}
