package g;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    final Context f3746a;

    /* renamed from: b, reason: collision with root package name */
    private Map<s.b, MenuItem> f3747b;

    /* renamed from: c, reason: collision with root package name */
    private Map<s.c, SubMenu> f3748c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context) {
        this.f3746a = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final MenuItem c(MenuItem menuItem) {
        if (!(menuItem instanceof s.b)) {
            return menuItem;
        }
        s.b bVar = (s.b) menuItem;
        if (this.f3747b == null) {
            this.f3747b = new k.a();
        }
        MenuItem menuItem2 = this.f3747b.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        c cVar = new c(this.f3746a, bVar);
        this.f3747b.put(bVar, cVar);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final SubMenu d(SubMenu subMenu) {
        if (!(subMenu instanceof s.c)) {
            return subMenu;
        }
        s.c cVar = (s.c) subMenu;
        if (this.f3748c == null) {
            this.f3748c = new k.a();
        }
        SubMenu subMenu2 = this.f3748c.get(cVar);
        if (subMenu2 != null) {
            return subMenu2;
        }
        f fVar = new f(this.f3746a, cVar);
        this.f3748c.put(cVar, fVar);
        return fVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e() {
        Map<s.b, MenuItem> map = this.f3747b;
        if (map != null) {
            map.clear();
        }
        Map<s.c, SubMenu> map2 = this.f3748c;
        if (map2 != null) {
            map2.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void f(int i4) {
        Map<s.b, MenuItem> map = this.f3747b;
        if (map == null) {
            return;
        }
        Iterator<s.b> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (i4 == it.next().getGroupId()) {
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void g(int i4) {
        Map<s.b, MenuItem> map = this.f3747b;
        if (map == null) {
            return;
        }
        Iterator<s.b> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (i4 == it.next().getItemId()) {
                it.remove();
                return;
            }
        }
    }
}
