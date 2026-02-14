package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class l0 extends j0 implements k0 {
    private static Method L;
    private k0 K;

    /* loaded from: classes.dex */
    public static class a extends f0 {

        /* renamed from: p, reason: collision with root package name */
        final int f1081p;

        /* renamed from: q, reason: collision with root package name */
        final int f1082q;

        /* renamed from: r, reason: collision with root package name */
        private k0 f1083r;

        /* renamed from: s, reason: collision with root package name */
        private MenuItem f1084s;

        public a(Context context, boolean z4) {
            super(context, z4);
            if (1 == context.getResources().getConfiguration().getLayoutDirection()) {
                this.f1081p = 21;
                this.f1082q = 22;
            } else {
                this.f1081p = 22;
                this.f1082q = 21;
            }
        }

        @Override // androidx.appcompat.widget.f0
        public /* bridge */ /* synthetic */ int d(int i4, int i5, int i6, int i7, int i8) {
            return super.d(i4, i5, i6, i7, i8);
        }

        @Override // androidx.appcompat.widget.f0
        public /* bridge */ /* synthetic */ boolean e(MotionEvent motionEvent, int i4) {
            return super.e(motionEvent, i4);
        }

        @Override // androidx.appcompat.widget.f0, android.view.ViewGroup, android.view.View
        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        @Override // androidx.appcompat.widget.f0, android.view.View
        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        @Override // androidx.appcompat.widget.f0, android.view.View
        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        @Override // androidx.appcompat.widget.f0, android.view.View
        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        @Override // androidx.appcompat.widget.f0, android.view.View
        public boolean onHoverEvent(MotionEvent motionEvent) {
            int i4;
            int pointToPosition;
            int i5;
            if (this.f1083r != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    i4 = headerViewListAdapter.getHeadersCount();
                    adapter = headerViewListAdapter.getWrappedAdapter();
                } else {
                    i4 = 0;
                }
                androidx.appcompat.view.menu.d dVar = (androidx.appcompat.view.menu.d) adapter;
                androidx.appcompat.view.menu.g gVar = null;
                if (motionEvent.getAction() != 10 && (pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) != -1 && (i5 = pointToPosition - i4) >= 0 && i5 < dVar.getCount()) {
                    gVar = dVar.getItem(i5);
                }
                MenuItem menuItem = this.f1084s;
                if (menuItem != gVar) {
                    androidx.appcompat.view.menu.e b5 = dVar.b();
                    if (menuItem != null) {
                        this.f1083r.h(b5, menuItem);
                    }
                    this.f1084s = gVar;
                    if (gVar != null) {
                        this.f1083r.a(b5, gVar);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int i4, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i4 == this.f1081p) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            }
            if (listMenuItemView == null || i4 != this.f1082q) {
                return super.onKeyDown(i4, keyEvent);
            }
            setSelection(-1);
            ((androidx.appcompat.view.menu.d) getAdapter()).b().e(false);
            return true;
        }

        @Override // androidx.appcompat.widget.f0, android.widget.AbsListView, android.view.View
        public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        public void setHoverListener(k0 k0Var) {
            this.f1083r = k0Var;
        }

        @Override // androidx.appcompat.widget.f0, android.widget.AbsListView
        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }
    }

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                L = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public l0(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
    }

    public void Q(Object obj) {
        this.H.setEnterTransition((Transition) obj);
    }

    public void R(Object obj) {
        this.H.setExitTransition((Transition) obj);
    }

    public void S(k0 k0Var) {
        this.K = k0Var;
    }

    public void T(boolean z4) {
        if (Build.VERSION.SDK_INT > 28) {
            this.H.setTouchModal(z4);
            return;
        }
        Method method = L;
        if (method != null) {
            try {
                method.invoke(this.H, Boolean.valueOf(z4));
            } catch (Exception unused) {
                Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
            }
        }
    }

    @Override // androidx.appcompat.widget.k0
    public void a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
        k0 k0Var = this.K;
        if (k0Var != null) {
            k0Var.a(eVar, menuItem);
        }
    }

    @Override // androidx.appcompat.widget.k0
    public void h(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
        k0 k0Var = this.K;
        if (k0Var != null) {
            k0Var.h(eVar, menuItem);
        }
    }

    @Override // androidx.appcompat.widget.j0
    f0 r(Context context, boolean z4) {
        a aVar = new a(context, z4);
        aVar.setHoverListener(this);
        return aVar;
    }
}
