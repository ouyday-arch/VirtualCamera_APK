package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class t0 extends ContextWrapper {

    /* renamed from: c, reason: collision with root package name */
    private static final Object f1173c = new Object();

    /* renamed from: d, reason: collision with root package name */
    private static ArrayList<WeakReference<t0>> f1174d;

    /* renamed from: a, reason: collision with root package name */
    private final Resources f1175a;

    /* renamed from: b, reason: collision with root package name */
    private final Resources.Theme f1176b;

    private t0(Context context) {
        super(context);
        if (!b1.b()) {
            this.f1175a = new v0(this, context.getResources());
            this.f1176b = null;
            return;
        }
        b1 b1Var = new b1(this, context.getResources());
        this.f1175a = b1Var;
        Resources.Theme newTheme = b1Var.newTheme();
        this.f1176b = newTheme;
        newTheme.setTo(context.getTheme());
    }

    private static boolean a(Context context) {
        return ((context instanceof t0) || (context.getResources() instanceof v0) || (context.getResources() instanceof b1) || !b1.b()) ? false : true;
    }

    public static Context b(Context context) {
        if (!a(context)) {
            return context;
        }
        synchronized (f1173c) {
            ArrayList<WeakReference<t0>> arrayList = f1174d;
            if (arrayList == null) {
                f1174d = new ArrayList<>();
            } else {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    WeakReference<t0> weakReference = f1174d.get(size);
                    if (weakReference == null || weakReference.get() == null) {
                        f1174d.remove(size);
                    }
                }
                for (int size2 = f1174d.size() - 1; size2 >= 0; size2--) {
                    WeakReference<t0> weakReference2 = f1174d.get(size2);
                    t0 t0Var = weakReference2 != null ? weakReference2.get() : null;
                    if (t0Var != null && t0Var.getBaseContext() == context) {
                        return t0Var;
                    }
                }
            }
            t0 t0Var2 = new t0(context);
            f1174d.add(new WeakReference<>(t0Var2));
            return t0Var2;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.f1175a.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.f1175a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f1176b;
        return theme == null ? super.getTheme() : theme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i4) {
        Resources.Theme theme = this.f1176b;
        if (theme == null) {
            super.setTheme(i4);
        } else {
            theme.applyStyle(i4, true);
        }
    }
}
