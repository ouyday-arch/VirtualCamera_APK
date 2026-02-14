package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.k;
import y.b;

/* loaded from: classes.dex */
public final class g implements s.b {
    private View A;
    private y.b B;
    private MenuItem.OnActionExpandListener C;
    private ContextMenu.ContextMenuInfo E;

    /* renamed from: a, reason: collision with root package name */
    private final int f668a;

    /* renamed from: b, reason: collision with root package name */
    private final int f669b;

    /* renamed from: c, reason: collision with root package name */
    private final int f670c;

    /* renamed from: d, reason: collision with root package name */
    private final int f671d;

    /* renamed from: e, reason: collision with root package name */
    private CharSequence f672e;

    /* renamed from: f, reason: collision with root package name */
    private CharSequence f673f;

    /* renamed from: g, reason: collision with root package name */
    private Intent f674g;

    /* renamed from: h, reason: collision with root package name */
    private char f675h;

    /* renamed from: j, reason: collision with root package name */
    private char f677j;

    /* renamed from: l, reason: collision with root package name */
    private Drawable f679l;

    /* renamed from: n, reason: collision with root package name */
    e f681n;

    /* renamed from: o, reason: collision with root package name */
    private m f682o;

    /* renamed from: p, reason: collision with root package name */
    private Runnable f683p;

    /* renamed from: q, reason: collision with root package name */
    private MenuItem.OnMenuItemClickListener f684q;

    /* renamed from: r, reason: collision with root package name */
    private CharSequence f685r;

    /* renamed from: s, reason: collision with root package name */
    private CharSequence f686s;

    /* renamed from: z, reason: collision with root package name */
    private int f693z;

    /* renamed from: i, reason: collision with root package name */
    private int f676i = 4096;

    /* renamed from: k, reason: collision with root package name */
    private int f678k = 4096;

    /* renamed from: m, reason: collision with root package name */
    private int f680m = 0;

    /* renamed from: t, reason: collision with root package name */
    private ColorStateList f687t = null;

    /* renamed from: u, reason: collision with root package name */
    private PorterDuff.Mode f688u = null;

    /* renamed from: v, reason: collision with root package name */
    private boolean f689v = false;

    /* renamed from: w, reason: collision with root package name */
    private boolean f690w = false;

    /* renamed from: x, reason: collision with root package name */
    private boolean f691x = false;

    /* renamed from: y, reason: collision with root package name */
    private int f692y = 16;
    private boolean D = false;

    /* loaded from: classes.dex */
    class a implements b.InterfaceC0095b {
        a() {
        }

        @Override // y.b.InterfaceC0095b
        public void onActionProviderVisibilityChanged(boolean z4) {
            g gVar = g.this;
            gVar.f681n.J(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar, int i4, int i5, int i6, int i7, CharSequence charSequence, int i8) {
        this.f681n = eVar;
        this.f668a = i5;
        this.f669b = i4;
        this.f670c = i6;
        this.f671d = i7;
        this.f672e = charSequence;
        this.f693z = i8;
    }

    private static void d(StringBuilder sb, int i4, int i5, String str) {
        if ((i4 & i5) == i5) {
            sb.append(str);
        }
    }

    private Drawable e(Drawable drawable) {
        if (drawable != null && this.f691x && (this.f689v || this.f690w)) {
            drawable = r.a.m(drawable).mutate();
            if (this.f689v) {
                r.a.j(drawable, this.f687t);
            }
            if (this.f690w) {
                r.a.k(drawable, this.f688u);
            }
            this.f691x = false;
        }
        return drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean A() {
        return this.f681n.H() && g() != 0;
    }

    public boolean B() {
        return (this.f693z & 4) == 4;
    }

    @Override // s.b
    public y.b a() {
        return this.B;
    }

    @Override // s.b
    public s.b b(y.b bVar) {
        y.b bVar2 = this.B;
        if (bVar2 != null) {
            bVar2.h();
        }
        this.A = null;
        this.B = bVar;
        this.f681n.K(true);
        y.b bVar3 = this.B;
        if (bVar3 != null) {
            bVar3.j(new a());
        }
        return this;
    }

    public void c() {
        this.f681n.I(this);
    }

    @Override // s.b, android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.f693z & 8) == 0) {
            return false;
        }
        if (this.A == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f681n.f(this);
        }
        return false;
    }

    @Override // s.b, android.view.MenuItem
    public boolean expandActionView() {
        if (!j()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f681n.k(this);
        }
        return false;
    }

    public int f() {
        return this.f671d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public char g() {
        return this.f681n.G() ? this.f677j : this.f675h;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // s.b, android.view.MenuItem
    public View getActionView() {
        View view = this.A;
        if (view != null) {
            return view;
        }
        y.b bVar = this.B;
        if (bVar == null) {
            return null;
        }
        View d5 = bVar.d(this);
        this.A = d5;
        return d5;
    }

    @Override // s.b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f678k;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f677j;
    }

    @Override // s.b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f685r;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f669b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        Drawable drawable = this.f679l;
        if (drawable != null) {
            return e(drawable);
        }
        if (this.f680m == 0) {
            return null;
        }
        Drawable b5 = c.a.b(this.f681n.u(), this.f680m);
        this.f680m = 0;
        this.f679l = b5;
        return e(b5);
    }

    @Override // s.b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f687t;
    }

    @Override // s.b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f688u;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f674g;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.f668a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.E;
    }

    @Override // s.b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f676i;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f675h;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f670c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.f682o;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.f672e;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f673f;
        return charSequence != null ? charSequence : this.f672e;
    }

    @Override // s.b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f686s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String h() {
        int i4;
        char g4 = g();
        if (g4 == 0) {
            return "";
        }
        Resources resources = this.f681n.u().getResources();
        StringBuilder sb = new StringBuilder();
        if (ViewConfiguration.get(this.f681n.u()).hasPermanentMenuKey()) {
            sb.append(resources.getString(a.h.f128k));
        }
        int i5 = this.f681n.G() ? this.f678k : this.f676i;
        d(sb, i5, 65536, resources.getString(a.h.f124g));
        d(sb, i5, 4096, resources.getString(a.h.f120c));
        d(sb, i5, 2, resources.getString(a.h.f119b));
        d(sb, i5, 1, resources.getString(a.h.f125h));
        d(sb, i5, 4, resources.getString(a.h.f127j));
        d(sb, i5, 8, resources.getString(a.h.f123f));
        if (g4 == '\b') {
            i4 = a.h.f121d;
        } else if (g4 == '\n') {
            i4 = a.h.f122e;
        } else {
            if (g4 != ' ') {
                sb.append(g4);
                return sb.toString();
            }
            i4 = a.h.f126i;
        }
        sb.append(resources.getString(i4));
        return sb.toString();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f682o != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence i(k.a aVar) {
        return (aVar == null || !aVar.d()) ? getTitle() : getTitleCondensed();
    }

    @Override // s.b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.D;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f692y & 1) == 1;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f692y & 2) == 2;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f692y & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        y.b bVar = this.B;
        return (bVar == null || !bVar.g()) ? (this.f692y & 8) == 0 : (this.f692y & 8) == 0 && this.B.b();
    }

    public boolean j() {
        y.b bVar;
        if ((this.f693z & 8) == 0) {
            return false;
        }
        if (this.A == null && (bVar = this.B) != null) {
            this.A = bVar.d(this);
        }
        return this.A != null;
    }

    public boolean k() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.f684q;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        e eVar = this.f681n;
        if (eVar.h(eVar, this)) {
            return true;
        }
        Runnable runnable = this.f683p;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.f674g != null) {
            try {
                this.f681n.u().startActivity(this.f674g);
                return true;
            } catch (ActivityNotFoundException e4) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e4);
            }
        }
        y.b bVar = this.B;
        return bVar != null && bVar.e();
    }

    public boolean l() {
        return (this.f692y & 32) == 32;
    }

    public boolean m() {
        return (this.f692y & 4) != 0;
    }

    public boolean n() {
        return (this.f693z & 1) == 1;
    }

    public boolean o() {
        return (this.f693z & 2) == 2;
    }

    @Override // s.b, android.view.MenuItem
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public s.b setActionView(int i4) {
        Context u4 = this.f681n.u();
        setActionView(LayoutInflater.from(u4).inflate(i4, (ViewGroup) new LinearLayout(u4), false));
        return this;
    }

    @Override // s.b, android.view.MenuItem
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public s.b setActionView(View view) {
        int i4;
        this.A = view;
        this.B = null;
        if (view != null && view.getId() == -1 && (i4 = this.f668a) > 0) {
            view.setId(i4);
        }
        this.f681n.I(this);
        return this;
    }

    public void r(boolean z4) {
        this.D = z4;
        this.f681n.K(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(boolean z4) {
        int i4 = this.f692y;
        int i5 = (z4 ? 2 : 0) | (i4 & (-3));
        this.f692y = i5;
        if (i4 != i5) {
            this.f681n.K(false);
        }
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c5) {
        if (this.f677j == c5) {
            return this;
        }
        this.f677j = Character.toLowerCase(c5);
        this.f681n.K(false);
        return this;
    }

    @Override // s.b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c5, int i4) {
        if (this.f677j == c5 && this.f678k == i4) {
            return this;
        }
        this.f677j = Character.toLowerCase(c5);
        this.f678k = KeyEvent.normalizeMetaState(i4);
        this.f681n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z4) {
        int i4 = this.f692y;
        int i5 = (z4 ? 1 : 0) | (i4 & (-2));
        this.f692y = i5;
        if (i4 != i5) {
            this.f681n.K(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z4) {
        if ((this.f692y & 4) != 0) {
            this.f681n.T(this);
        } else {
            s(z4);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public s.b setContentDescription(CharSequence charSequence) {
        this.f685r = charSequence;
        this.f681n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z4) {
        this.f692y = z4 ? this.f692y | 16 : this.f692y & (-17);
        this.f681n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i4) {
        this.f679l = null;
        this.f680m = i4;
        this.f691x = true;
        this.f681n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f680m = 0;
        this.f679l = drawable;
        this.f691x = true;
        this.f681n.K(false);
        return this;
    }

    @Override // s.b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f687t = colorStateList;
        this.f689v = true;
        this.f691x = true;
        this.f681n.K(false);
        return this;
    }

    @Override // s.b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f688u = mode;
        this.f690w = true;
        this.f691x = true;
        this.f681n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f674g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c5) {
        if (this.f675h == c5) {
            return this;
        }
        this.f675h = c5;
        this.f681n.K(false);
        return this;
    }

    @Override // s.b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c5, int i4) {
        if (this.f675h == c5 && this.f676i == i4) {
            return this;
        }
        this.f675h = c5;
        this.f676i = KeyEvent.normalizeMetaState(i4);
        this.f681n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.C = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f684q = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c5, char c6) {
        this.f675h = c5;
        this.f677j = Character.toLowerCase(c6);
        this.f681n.K(false);
        return this;
    }

    @Override // s.b, android.view.MenuItem
    public MenuItem setShortcut(char c5, char c6, int i4, int i5) {
        this.f675h = c5;
        this.f676i = KeyEvent.normalizeMetaState(i4);
        this.f677j = Character.toLowerCase(c6);
        this.f678k = KeyEvent.normalizeMetaState(i5);
        this.f681n.K(false);
        return this;
    }

    @Override // s.b, android.view.MenuItem
    public void setShowAsAction(int i4) {
        int i5 = i4 & 3;
        if (i5 != 0 && i5 != 1 && i5 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.f693z = i4;
        this.f681n.I(this);
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i4) {
        return setTitle(this.f681n.u().getString(i4));
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f672e = charSequence;
        this.f681n.K(false);
        m mVar = this.f682o;
        if (mVar != null) {
            mVar.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f673f = charSequence;
        this.f681n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public s.b setTooltipText(CharSequence charSequence) {
        this.f686s = charSequence;
        this.f681n.K(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z4) {
        if (y(z4)) {
            this.f681n.J(this);
        }
        return this;
    }

    public void t(boolean z4) {
        this.f692y = (z4 ? 4 : 0) | (this.f692y & (-5));
    }

    public String toString() {
        CharSequence charSequence = this.f672e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public void u(boolean z4) {
        this.f692y = z4 ? this.f692y | 32 : this.f692y & (-33);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.E = contextMenuInfo;
    }

    @Override // s.b, android.view.MenuItem
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public s.b setShowAsActionFlags(int i4) {
        setShowAsAction(i4);
        return this;
    }

    public void x(m mVar) {
        this.f682o = mVar;
        mVar.setHeaderTitle(getTitle());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean y(boolean z4) {
        int i4 = this.f692y;
        int i5 = (z4 ? 0 : 8) | (i4 & (-9));
        this.f692y = i5;
        return i4 != i5;
    }

    public boolean z() {
        return this.f681n.A();
    }
}
