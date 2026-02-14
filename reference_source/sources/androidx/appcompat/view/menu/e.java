package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import y.q;

/* loaded from: classes.dex */
public class e implements s.a {
    private static final int[] A = {1, 4, 5, 3, 2, 0};

    /* renamed from: a, reason: collision with root package name */
    private final Context f638a;

    /* renamed from: b, reason: collision with root package name */
    private final Resources f639b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f640c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f641d;

    /* renamed from: e, reason: collision with root package name */
    private a f642e;

    /* renamed from: m, reason: collision with root package name */
    private ContextMenu.ContextMenuInfo f650m;

    /* renamed from: n, reason: collision with root package name */
    CharSequence f651n;

    /* renamed from: o, reason: collision with root package name */
    Drawable f652o;

    /* renamed from: p, reason: collision with root package name */
    View f653p;

    /* renamed from: x, reason: collision with root package name */
    private g f661x;

    /* renamed from: z, reason: collision with root package name */
    private boolean f663z;

    /* renamed from: l, reason: collision with root package name */
    private int f649l = 0;

    /* renamed from: q, reason: collision with root package name */
    private boolean f654q = false;

    /* renamed from: r, reason: collision with root package name */
    private boolean f655r = false;

    /* renamed from: s, reason: collision with root package name */
    private boolean f656s = false;

    /* renamed from: t, reason: collision with root package name */
    private boolean f657t = false;

    /* renamed from: u, reason: collision with root package name */
    private boolean f658u = false;

    /* renamed from: v, reason: collision with root package name */
    private ArrayList<g> f659v = new ArrayList<>();

    /* renamed from: w, reason: collision with root package name */
    private CopyOnWriteArrayList<WeakReference<j>> f660w = new CopyOnWriteArrayList<>();

    /* renamed from: y, reason: collision with root package name */
    private boolean f662y = false;

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<g> f643f = new ArrayList<>();

    /* renamed from: g, reason: collision with root package name */
    private ArrayList<g> f644g = new ArrayList<>();

    /* renamed from: h, reason: collision with root package name */
    private boolean f645h = true;

    /* renamed from: i, reason: collision with root package name */
    private ArrayList<g> f646i = new ArrayList<>();

    /* renamed from: j, reason: collision with root package name */
    private ArrayList<g> f647j = new ArrayList<>();

    /* renamed from: k, reason: collision with root package name */
    private boolean f648k = true;

    /* loaded from: classes.dex */
    public interface a {
        boolean a(e eVar, MenuItem menuItem);

        void b(e eVar);
    }

    /* loaded from: classes.dex */
    public interface b {
        boolean a(g gVar);
    }

    public e(Context context) {
        this.f638a = context;
        this.f639b = context.getResources();
        b0(true);
    }

    private static int B(int i4) {
        int i5 = ((-65536) & i4) >> 16;
        if (i5 >= 0) {
            int[] iArr = A;
            if (i5 < iArr.length) {
                return (i4 & 65535) | (iArr[i5] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    private void N(int i4, boolean z4) {
        if (i4 < 0 || i4 >= this.f643f.size()) {
            return;
        }
        this.f643f.remove(i4);
        if (z4) {
            K(true);
        }
    }

    private void W(int i4, CharSequence charSequence, int i5, Drawable drawable, View view) {
        Resources C = C();
        if (view != null) {
            this.f653p = view;
            this.f651n = null;
            this.f652o = null;
        } else {
            if (i4 > 0) {
                this.f651n = C.getText(i4);
            } else if (charSequence != null) {
                this.f651n = charSequence;
            }
            if (i5 > 0) {
                this.f652o = o.a.c(u(), i5);
            } else if (drawable != null) {
                this.f652o = drawable;
            }
            this.f653p = null;
        }
        K(false);
    }

    private void b0(boolean z4) {
        this.f641d = z4 && this.f639b.getConfiguration().keyboard != 1 && q.e(ViewConfiguration.get(this.f638a), this.f638a);
    }

    private g g(int i4, int i5, int i6, int i7, CharSequence charSequence, int i8) {
        return new g(this, i4, i5, i6, i7, charSequence, i8);
    }

    private void i(boolean z4) {
        if (this.f660w.isEmpty()) {
            return;
        }
        d0();
        Iterator<WeakReference<j>> it = this.f660w.iterator();
        while (it.hasNext()) {
            WeakReference<j> next = it.next();
            j jVar = next.get();
            if (jVar == null) {
                this.f660w.remove(next);
            } else {
                jVar.i(z4);
            }
        }
        c0();
    }

    private boolean j(m mVar, j jVar) {
        if (this.f660w.isEmpty()) {
            return false;
        }
        boolean h4 = jVar != null ? jVar.h(mVar) : false;
        Iterator<WeakReference<j>> it = this.f660w.iterator();
        while (it.hasNext()) {
            WeakReference<j> next = it.next();
            j jVar2 = next.get();
            if (jVar2 == null) {
                this.f660w.remove(next);
            } else if (!h4) {
                h4 = jVar2.h(mVar);
            }
        }
        return h4;
    }

    private static int n(ArrayList<g> arrayList, int i4) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).f() <= i4) {
                return size + 1;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean A() {
        return this.f657t;
    }

    Resources C() {
        return this.f639b;
    }

    public e D() {
        return this;
    }

    public ArrayList<g> E() {
        if (!this.f645h) {
            return this.f644g;
        }
        this.f644g.clear();
        int size = this.f643f.size();
        for (int i4 = 0; i4 < size; i4++) {
            g gVar = this.f643f.get(i4);
            if (gVar.isVisible()) {
                this.f644g.add(gVar);
            }
        }
        this.f645h = false;
        this.f648k = true;
        return this.f644g;
    }

    public boolean F() {
        return this.f662y;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean G() {
        return this.f640c;
    }

    public boolean H() {
        return this.f641d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(g gVar) {
        this.f648k = true;
        K(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J(g gVar) {
        this.f645h = true;
        K(true);
    }

    public void K(boolean z4) {
        if (this.f654q) {
            this.f655r = true;
            if (z4) {
                this.f656s = true;
                return;
            }
            return;
        }
        if (z4) {
            this.f645h = true;
            this.f648k = true;
        }
        i(z4);
    }

    public boolean L(MenuItem menuItem, int i4) {
        return M(menuItem, null, i4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
    
        if (r1 != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
    
        e(true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x006b, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003c, code lost:
    
        if ((r9 & 1) == 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0068, code lost:
    
        if (r1 == false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean M(android.view.MenuItem r7, androidx.appcompat.view.menu.j r8, int r9) {
        /*
            r6 = this;
            androidx.appcompat.view.menu.g r7 = (androidx.appcompat.view.menu.g) r7
            r0 = 0
            if (r7 == 0) goto L6c
            boolean r1 = r7.isEnabled()
            if (r1 != 0) goto Lc
            goto L6c
        Lc:
            boolean r1 = r7.k()
            y.b r2 = r7.a()
            r3 = 1
            if (r2 == 0) goto L1f
            boolean r4 = r2.a()
            if (r4 == 0) goto L1f
            r4 = r3
            goto L20
        L1f:
            r4 = r0
        L20:
            boolean r5 = r7.j()
            if (r5 == 0) goto L31
            boolean r7 = r7.expandActionView()
            r1 = r1 | r7
            if (r1 == 0) goto L6b
        L2d:
            r6.e(r3)
            goto L6b
        L31:
            boolean r5 = r7.hasSubMenu()
            if (r5 != 0) goto L3f
            if (r4 == 0) goto L3a
            goto L3f
        L3a:
            r7 = r9 & 1
            if (r7 != 0) goto L6b
            goto L2d
        L3f:
            r9 = r9 & 4
            if (r9 != 0) goto L46
            r6.e(r0)
        L46:
            boolean r9 = r7.hasSubMenu()
            if (r9 != 0) goto L58
            androidx.appcompat.view.menu.m r9 = new androidx.appcompat.view.menu.m
            android.content.Context r0 = r6.u()
            r9.<init>(r0, r6, r7)
            r7.x(r9)
        L58:
            android.view.SubMenu r7 = r7.getSubMenu()
            androidx.appcompat.view.menu.m r7 = (androidx.appcompat.view.menu.m) r7
            if (r4 == 0) goto L63
            r2.f(r7)
        L63:
            boolean r7 = r6.j(r7, r8)
            r1 = r1 | r7
            if (r1 != 0) goto L6b
            goto L2d
        L6b:
            return r1
        L6c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.e.M(android.view.MenuItem, androidx.appcompat.view.menu.j, int):boolean");
    }

    public void O(j jVar) {
        Iterator<WeakReference<j>> it = this.f660w.iterator();
        while (it.hasNext()) {
            WeakReference<j> next = it.next();
            j jVar2 = next.get();
            if (jVar2 == null || jVar2 == jVar) {
                this.f660w.remove(next);
            }
        }
    }

    public void P(Bundle bundle) {
        MenuItem findItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(t());
        int size = size();
        for (int i4 = 0; i4 < size; i4++) {
            MenuItem item = getItem(i4);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((m) item.getSubMenu()).P(bundle);
            }
        }
        int i5 = bundle.getInt("android:menu:expandedactionview");
        if (i5 <= 0 || (findItem = findItem(i5)) == null) {
            return;
        }
        findItem.expandActionView();
    }

    public void Q(Bundle bundle) {
        int size = size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i4 = 0; i4 < size; i4++) {
            MenuItem item = getItem(i4);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((m) item.getSubMenu()).Q(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(t(), sparseArray);
        }
    }

    public void R(a aVar) {
        this.f642e = aVar;
    }

    public e S(int i4) {
        this.f649l = i4;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void T(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f643f.size();
        d0();
        for (int i4 = 0; i4 < size; i4++) {
            g gVar = this.f643f.get(i4);
            if (gVar.getGroupId() == groupId && gVar.m() && gVar.isCheckable()) {
                gVar.s(gVar == menuItem);
            }
        }
        c0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e U(int i4) {
        W(0, null, i4, null, null);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e V(Drawable drawable) {
        W(0, null, 0, drawable, null);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e X(int i4) {
        W(i4, null, 0, null, null);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e Y(CharSequence charSequence) {
        W(0, charSequence, 0, null, null);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e Z(View view) {
        W(0, null, 0, null, view);
        return this;
    }

    protected MenuItem a(int i4, int i5, int i6, CharSequence charSequence) {
        int B = B(i6);
        g g4 = g(i4, i5, i6, B, charSequence, this.f649l);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.f650m;
        if (contextMenuInfo != null) {
            g4.v(contextMenuInfo);
        }
        ArrayList<g> arrayList = this.f643f;
        arrayList.add(n(arrayList, B), g4);
        K(true);
        return g4;
    }

    public void a0(boolean z4) {
        this.f663z = z4;
    }

    @Override // android.view.Menu
    public MenuItem add(int i4) {
        return a(0, 0, 0, this.f639b.getString(i4));
    }

    @Override // android.view.Menu
    public MenuItem add(int i4, int i5, int i6, int i7) {
        return a(i4, i5, i6, this.f639b.getString(i7));
    }

    @Override // android.view.Menu
    public MenuItem add(int i4, int i5, int i6, CharSequence charSequence) {
        return a(i4, i5, i6, charSequence);
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i4, int i5, int i6, ComponentName componentName, Intent[] intentArr, Intent intent, int i7, MenuItem[] menuItemArr) {
        int i8;
        PackageManager packageManager = this.f638a.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i7 & 1) == 0) {
            removeGroup(i4);
        }
        for (int i9 = 0; i9 < size; i9++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i9);
            int i10 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i10 < 0 ? intent : intentArr[i10]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            MenuItem intent3 = add(i4, i5, i6, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && (i8 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i8] = intent3;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i4) {
        return addSubMenu(0, 0, 0, this.f639b.getString(i4));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i4, int i5, int i6, int i7) {
        return addSubMenu(i4, i5, i6, this.f639b.getString(i7));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i4, int i5, int i6, CharSequence charSequence) {
        g gVar = (g) a(i4, i5, i6, charSequence);
        m mVar = new m(this.f638a, this, gVar);
        gVar.x(mVar);
        return mVar;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public void b(j jVar) {
        c(jVar, this.f638a);
    }

    public void c(j jVar, Context context) {
        this.f660w.add(new WeakReference<>(jVar));
        jVar.d(context, this);
        this.f648k = true;
    }

    public void c0() {
        this.f654q = false;
        if (this.f655r) {
            this.f655r = false;
            K(this.f656s);
        }
    }

    @Override // android.view.Menu
    public void clear() {
        g gVar = this.f661x;
        if (gVar != null) {
            f(gVar);
        }
        this.f643f.clear();
        K(true);
    }

    public void clearHeader() {
        this.f652o = null;
        this.f651n = null;
        this.f653p = null;
        K(false);
    }

    @Override // android.view.Menu
    public void close() {
        e(true);
    }

    public void d() {
        a aVar = this.f642e;
        if (aVar != null) {
            aVar.b(this);
        }
    }

    public void d0() {
        if (this.f654q) {
            return;
        }
        this.f654q = true;
        this.f655r = false;
        this.f656s = false;
    }

    public final void e(boolean z4) {
        if (this.f658u) {
            return;
        }
        this.f658u = true;
        Iterator<WeakReference<j>> it = this.f660w.iterator();
        while (it.hasNext()) {
            WeakReference<j> next = it.next();
            j jVar = next.get();
            if (jVar == null) {
                this.f660w.remove(next);
            } else {
                jVar.a(this, z4);
            }
        }
        this.f658u = false;
    }

    public boolean f(g gVar) {
        boolean z4 = false;
        if (!this.f660w.isEmpty() && this.f661x == gVar) {
            d0();
            Iterator<WeakReference<j>> it = this.f660w.iterator();
            while (it.hasNext()) {
                WeakReference<j> next = it.next();
                j jVar = next.get();
                if (jVar == null) {
                    this.f660w.remove(next);
                } else {
                    z4 = jVar.e(this, gVar);
                    if (z4) {
                        break;
                    }
                }
            }
            c0();
            if (z4) {
                this.f661x = null;
            }
        }
        return z4;
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i4) {
        MenuItem findItem;
        int size = size();
        for (int i5 = 0; i5 < size; i5++) {
            g gVar = this.f643f.get(i5);
            if (gVar.getItemId() == i4) {
                return gVar;
            }
            if (gVar.hasSubMenu() && (findItem = gVar.getSubMenu().findItem(i4)) != null) {
                return findItem;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i4) {
        return this.f643f.get(i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h(e eVar, MenuItem menuItem) {
        a aVar = this.f642e;
        return aVar != null && aVar.a(eVar, menuItem);
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.f663z) {
            return true;
        }
        int size = size();
        for (int i4 = 0; i4 < size; i4++) {
            if (this.f643f.get(i4).isVisible()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i4, KeyEvent keyEvent) {
        return p(i4, keyEvent) != null;
    }

    public boolean k(g gVar) {
        boolean z4 = false;
        if (this.f660w.isEmpty()) {
            return false;
        }
        d0();
        Iterator<WeakReference<j>> it = this.f660w.iterator();
        while (it.hasNext()) {
            WeakReference<j> next = it.next();
            j jVar = next.get();
            if (jVar == null) {
                this.f660w.remove(next);
            } else {
                z4 = jVar.f(this, gVar);
                if (z4) {
                    break;
                }
            }
        }
        c0();
        if (z4) {
            this.f661x = gVar;
        }
        return z4;
    }

    public int l(int i4) {
        return m(i4, 0);
    }

    public int m(int i4, int i5) {
        int size = size();
        if (i5 < 0) {
            i5 = 0;
        }
        while (i5 < size) {
            if (this.f643f.get(i5).getGroupId() == i4) {
                return i5;
            }
            i5++;
        }
        return -1;
    }

    public int o(int i4) {
        int size = size();
        for (int i5 = 0; i5 < size; i5++) {
            if (this.f643f.get(i5).getItemId() == i4) {
                return i5;
            }
        }
        return -1;
    }

    g p(int i4, KeyEvent keyEvent) {
        ArrayList<g> arrayList = this.f659v;
        arrayList.clear();
        q(arrayList, i4, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean G = G();
        for (int i5 = 0; i5 < size; i5++) {
            g gVar = arrayList.get(i5);
            char alphabeticShortcut = G ? gVar.getAlphabeticShortcut() : gVar.getNumericShortcut();
            char[] cArr = keyData.meta;
            if ((alphabeticShortcut == cArr[0] && (metaState & 2) == 0) || ((alphabeticShortcut == cArr[2] && (metaState & 2) != 0) || (G && alphabeticShortcut == '\b' && i4 == 67))) {
                return gVar;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i4, int i5) {
        return L(findItem(i4), i5);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i4, KeyEvent keyEvent, int i5) {
        g p4 = p(i4, keyEvent);
        boolean L = p4 != null ? L(p4, i5) : false;
        if ((i5 & 2) != 0) {
            e(true);
        }
        return L;
    }

    void q(List<g> list, int i4, KeyEvent keyEvent) {
        boolean G = G();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i4 == 67) {
            int size = this.f643f.size();
            for (int i5 = 0; i5 < size; i5++) {
                g gVar = this.f643f.get(i5);
                if (gVar.hasSubMenu()) {
                    ((e) gVar.getSubMenu()).q(list, i4, keyEvent);
                }
                char alphabeticShortcut = G ? gVar.getAlphabeticShortcut() : gVar.getNumericShortcut();
                if (((modifiers & 69647) == ((G ? gVar.getAlphabeticModifiers() : gVar.getNumericModifiers()) & 69647)) && alphabeticShortcut != 0) {
                    char[] cArr = keyData.meta;
                    if ((alphabeticShortcut == cArr[0] || alphabeticShortcut == cArr[2] || (G && alphabeticShortcut == '\b' && i4 == 67)) && gVar.isEnabled()) {
                        list.add(gVar);
                    }
                }
            }
        }
    }

    public void r() {
        ArrayList<g> E = E();
        if (this.f648k) {
            Iterator<WeakReference<j>> it = this.f660w.iterator();
            boolean z4 = false;
            while (it.hasNext()) {
                WeakReference<j> next = it.next();
                j jVar = next.get();
                if (jVar == null) {
                    this.f660w.remove(next);
                } else {
                    z4 |= jVar.c();
                }
            }
            if (z4) {
                this.f646i.clear();
                this.f647j.clear();
                int size = E.size();
                for (int i4 = 0; i4 < size; i4++) {
                    g gVar = E.get(i4);
                    (gVar.l() ? this.f646i : this.f647j).add(gVar);
                }
            } else {
                this.f646i.clear();
                this.f647j.clear();
                this.f647j.addAll(E());
            }
            this.f648k = false;
        }
    }

    @Override // android.view.Menu
    public void removeGroup(int i4) {
        int l4 = l(i4);
        if (l4 >= 0) {
            int size = this.f643f.size() - l4;
            int i5 = 0;
            while (true) {
                int i6 = i5 + 1;
                if (i5 >= size || this.f643f.get(l4).getGroupId() != i4) {
                    break;
                }
                N(l4, false);
                i5 = i6;
            }
            K(true);
        }
    }

    @Override // android.view.Menu
    public void removeItem(int i4) {
        N(o(i4), true);
    }

    public ArrayList<g> s() {
        r();
        return this.f646i;
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i4, boolean z4, boolean z5) {
        int size = this.f643f.size();
        for (int i5 = 0; i5 < size; i5++) {
            g gVar = this.f643f.get(i5);
            if (gVar.getGroupId() == i4) {
                gVar.t(z5);
                gVar.setCheckable(z4);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z4) {
        this.f662y = z4;
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i4, boolean z4) {
        int size = this.f643f.size();
        for (int i5 = 0; i5 < size; i5++) {
            g gVar = this.f643f.get(i5);
            if (gVar.getGroupId() == i4) {
                gVar.setEnabled(z4);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i4, boolean z4) {
        int size = this.f643f.size();
        boolean z5 = false;
        for (int i5 = 0; i5 < size; i5++) {
            g gVar = this.f643f.get(i5);
            if (gVar.getGroupId() == i4 && gVar.y(z4)) {
                z5 = true;
            }
        }
        if (z5) {
            K(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z4) {
        this.f640c = z4;
        K(false);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f643f.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String t() {
        return "android:menu:actionviewstates";
    }

    public Context u() {
        return this.f638a;
    }

    public g v() {
        return this.f661x;
    }

    public Drawable w() {
        return this.f652o;
    }

    public CharSequence x() {
        return this.f651n;
    }

    public View y() {
        return this.f653p;
    }

    public ArrayList<g> z() {
        r();
        return this.f647j;
    }
}
