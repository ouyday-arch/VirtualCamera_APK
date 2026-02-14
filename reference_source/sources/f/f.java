package f;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import f.b;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class f extends ActionMode {

    /* renamed from: a, reason: collision with root package name */
    final Context f3649a;

    /* renamed from: b, reason: collision with root package name */
    final b f3650b;

    /* loaded from: classes.dex */
    public static class a implements b.a {

        /* renamed from: a, reason: collision with root package name */
        final ActionMode.Callback f3651a;

        /* renamed from: b, reason: collision with root package name */
        final Context f3652b;

        /* renamed from: c, reason: collision with root package name */
        final ArrayList<f> f3653c = new ArrayList<>();

        /* renamed from: d, reason: collision with root package name */
        final k.g<Menu, Menu> f3654d = new k.g<>();

        public a(Context context, ActionMode.Callback callback) {
            this.f3652b = context;
            this.f3651a = callback;
        }

        private Menu f(Menu menu) {
            Menu menu2 = this.f3654d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            g.d dVar = new g.d(this.f3652b, (s.a) menu);
            this.f3654d.put(menu, dVar);
            return dVar;
        }

        @Override // f.b.a
        public boolean a(b bVar, MenuItem menuItem) {
            return this.f3651a.onActionItemClicked(e(bVar), new g.c(this.f3652b, (s.b) menuItem));
        }

        @Override // f.b.a
        public boolean b(b bVar, Menu menu) {
            return this.f3651a.onCreateActionMode(e(bVar), f(menu));
        }

        @Override // f.b.a
        public void c(b bVar) {
            this.f3651a.onDestroyActionMode(e(bVar));
        }

        @Override // f.b.a
        public boolean d(b bVar, Menu menu) {
            return this.f3651a.onPrepareActionMode(e(bVar), f(menu));
        }

        public ActionMode e(b bVar) {
            int size = this.f3653c.size();
            for (int i4 = 0; i4 < size; i4++) {
                f fVar = this.f3653c.get(i4);
                if (fVar != null && fVar.f3650b == bVar) {
                    return fVar;
                }
            }
            f fVar2 = new f(this.f3652b, bVar);
            this.f3653c.add(fVar2);
            return fVar2;
        }
    }

    public f(Context context, b bVar) {
        this.f3649a = context;
        this.f3650b = bVar;
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.f3650b.c();
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.f3650b.d();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return new g.d(this.f3649a, (s.a) this.f3650b.e());
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.f3650b.f();
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.f3650b.g();
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.f3650b.h();
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.f3650b.i();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.f3650b.j();
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.f3650b.k();
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.f3650b.l();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.f3650b.m(view);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i4) {
        this.f3650b.n(i4);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.f3650b.o(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.f3650b.p(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(int i4) {
        this.f3650b.q(i4);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.f3650b.r(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z4) {
        this.f3650b.s(z4);
    }
}
