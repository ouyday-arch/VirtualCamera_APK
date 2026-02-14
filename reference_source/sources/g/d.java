package g;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

/* loaded from: classes.dex */
public class d extends b implements Menu {

    /* renamed from: d, reason: collision with root package name */
    private final s.a f3760d;

    public d(Context context, s.a aVar) {
        super(context);
        if (aVar == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.f3760d = aVar;
    }

    @Override // android.view.Menu
    public MenuItem add(int i4) {
        return c(this.f3760d.add(i4));
    }

    @Override // android.view.Menu
    public MenuItem add(int i4, int i5, int i6, int i7) {
        return c(this.f3760d.add(i4, i5, i6, i7));
    }

    @Override // android.view.Menu
    public MenuItem add(int i4, int i5, int i6, CharSequence charSequence) {
        return c(this.f3760d.add(i4, i5, i6, charSequence));
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return c(this.f3760d.add(charSequence));
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i4, int i5, int i6, ComponentName componentName, Intent[] intentArr, Intent intent, int i7, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr != null ? new MenuItem[menuItemArr.length] : null;
        int addIntentOptions = this.f3760d.addIntentOptions(i4, i5, i6, componentName, intentArr, intent, i7, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i8 = 0; i8 < length; i8++) {
                menuItemArr[i8] = c(menuItemArr2[i8]);
            }
        }
        return addIntentOptions;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i4) {
        return d(this.f3760d.addSubMenu(i4));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i4, int i5, int i6, int i7) {
        return d(this.f3760d.addSubMenu(i4, i5, i6, i7));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i4, int i5, int i6, CharSequence charSequence) {
        return d(this.f3760d.addSubMenu(i4, i5, i6, charSequence));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return d(this.f3760d.addSubMenu(charSequence));
    }

    @Override // android.view.Menu
    public void clear() {
        e();
        this.f3760d.clear();
    }

    @Override // android.view.Menu
    public void close() {
        this.f3760d.close();
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i4) {
        return c(this.f3760d.findItem(i4));
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i4) {
        return c(this.f3760d.getItem(i4));
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        return this.f3760d.hasVisibleItems();
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i4, KeyEvent keyEvent) {
        return this.f3760d.isShortcutKey(i4, keyEvent);
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i4, int i5) {
        return this.f3760d.performIdentifierAction(i4, i5);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i4, KeyEvent keyEvent, int i5) {
        return this.f3760d.performShortcut(i4, keyEvent, i5);
    }

    @Override // android.view.Menu
    public void removeGroup(int i4) {
        f(i4);
        this.f3760d.removeGroup(i4);
    }

    @Override // android.view.Menu
    public void removeItem(int i4) {
        g(i4);
        this.f3760d.removeItem(i4);
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i4, boolean z4, boolean z5) {
        this.f3760d.setGroupCheckable(i4, z4, z5);
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i4, boolean z4) {
        this.f3760d.setGroupEnabled(i4, z4);
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i4, boolean z4) {
        this.f3760d.setGroupVisible(i4, z4);
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z4) {
        this.f3760d.setQwertyMode(z4);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f3760d.size();
    }
}
