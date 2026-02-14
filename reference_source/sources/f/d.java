package f;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;

/* loaded from: classes.dex */
public class d extends ContextWrapper {

    /* renamed from: a, reason: collision with root package name */
    private int f3637a;

    /* renamed from: b, reason: collision with root package name */
    private Resources.Theme f3638b;

    /* renamed from: c, reason: collision with root package name */
    private LayoutInflater f3639c;

    /* renamed from: d, reason: collision with root package name */
    private Configuration f3640d;

    /* renamed from: e, reason: collision with root package name */
    private Resources f3641e;

    public d() {
        super(null);
    }

    public d(Context context, int i4) {
        super(context);
        this.f3637a = i4;
    }

    public d(Context context, Resources.Theme theme) {
        super(context);
        this.f3638b = theme;
    }

    private Resources a() {
        if (this.f3641e == null) {
            Configuration configuration = this.f3640d;
            this.f3641e = configuration == null ? super.getResources() : createConfigurationContext(configuration).getResources();
        }
        return this.f3641e;
    }

    private void c() {
        boolean z4 = this.f3638b == null;
        if (z4) {
            this.f3638b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f3638b.setTo(theme);
            }
        }
        d(this.f3638b, this.f3637a, z4);
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public int b() {
        return this.f3637a;
    }

    protected void d(Resources.Theme theme, int i4, boolean z4) {
        theme.applyStyle(i4, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return a();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f3639c == null) {
            this.f3639c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f3639c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f3638b;
        if (theme != null) {
            return theme;
        }
        if (this.f3637a == 0) {
            this.f3637a = a.i.f132c;
        }
        c();
        return this.f3638b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i4) {
        if (this.f3637a != i4) {
            this.f3637a = i4;
            c();
        }
    }
}
