package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.k;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class a implements j {

    /* renamed from: b, reason: collision with root package name */
    protected Context f577b;

    /* renamed from: c, reason: collision with root package name */
    protected Context f578c;

    /* renamed from: d, reason: collision with root package name */
    protected e f579d;

    /* renamed from: e, reason: collision with root package name */
    protected LayoutInflater f580e;

    /* renamed from: f, reason: collision with root package name */
    protected LayoutInflater f581f;

    /* renamed from: g, reason: collision with root package name */
    private j.a f582g;

    /* renamed from: h, reason: collision with root package name */
    private int f583h;

    /* renamed from: i, reason: collision with root package name */
    private int f584i;

    /* renamed from: j, reason: collision with root package name */
    protected k f585j;

    /* renamed from: k, reason: collision with root package name */
    private int f586k;

    public a(Context context, int i4, int i5) {
        this.f577b = context;
        this.f580e = LayoutInflater.from(context);
        this.f583h = i4;
        this.f584i = i5;
    }

    @Override // androidx.appcompat.view.menu.j
    public void a(e eVar, boolean z4) {
        j.a aVar = this.f582g;
        if (aVar != null) {
            aVar.a(eVar, z4);
        }
    }

    protected void b(View view, int i4) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f585j).addView(view, i4);
    }

    @Override // androidx.appcompat.view.menu.j
    public void d(Context context, e eVar) {
        this.f578c = context;
        this.f581f = LayoutInflater.from(context);
        this.f579d = eVar;
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean e(e eVar, g gVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean f(e eVar, g gVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public void g(j.a aVar) {
        this.f582g = aVar;
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean h(m mVar) {
        j.a aVar = this.f582g;
        if (aVar != null) {
            return aVar.b(mVar);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.view.menu.j
    public void i(boolean z4) {
        ViewGroup viewGroup = (ViewGroup) this.f585j;
        if (viewGroup == null) {
            return;
        }
        e eVar = this.f579d;
        int i4 = 0;
        if (eVar != null) {
            eVar.r();
            ArrayList<g> E = this.f579d.E();
            int size = E.size();
            int i5 = 0;
            for (int i6 = 0; i6 < size; i6++) {
                g gVar = E.get(i6);
                if (q(i5, gVar)) {
                    View childAt = viewGroup.getChildAt(i5);
                    g itemData = childAt instanceof k.a ? ((k.a) childAt).getItemData() : null;
                    View n4 = n(gVar, childAt, viewGroup);
                    if (gVar != itemData) {
                        n4.setPressed(false);
                        n4.jumpDrawablesToCurrentState();
                    }
                    if (n4 != childAt) {
                        b(n4, i5);
                    }
                    i5++;
                }
            }
            i4 = i5;
        }
        while (i4 < viewGroup.getChildCount()) {
            if (!l(viewGroup, i4)) {
                i4++;
            }
        }
    }

    public abstract void j(g gVar, k.a aVar);

    public k.a k(ViewGroup viewGroup) {
        return (k.a) this.f580e.inflate(this.f584i, viewGroup, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean l(ViewGroup viewGroup, int i4) {
        viewGroup.removeViewAt(i4);
        return true;
    }

    public j.a m() {
        return this.f582g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View n(g gVar, View view, ViewGroup viewGroup) {
        k.a k4 = view instanceof k.a ? (k.a) view : k(viewGroup);
        j(gVar, k4);
        return (View) k4;
    }

    public k o(ViewGroup viewGroup) {
        if (this.f585j == null) {
            k kVar = (k) this.f580e.inflate(this.f583h, viewGroup, false);
            this.f585j = kVar;
            kVar.b(this.f579d);
            i(true);
        }
        return this.f585j;
    }

    public void p(int i4) {
        this.f586k = i4;
    }

    public abstract boolean q(int i4, g gVar);
}
