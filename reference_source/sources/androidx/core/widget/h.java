package androidx.core.widget;

import android.view.View;
import android.widget.PopupWindow;

/* loaded from: classes.dex */
public final class h {
    public static void a(PopupWindow popupWindow, boolean z4) {
        popupWindow.setOverlapAnchor(z4);
    }

    public static void b(PopupWindow popupWindow, int i4) {
        popupWindow.setWindowLayoutType(i4);
    }

    public static void c(PopupWindow popupWindow, View view, int i4, int i5, int i6) {
        popupWindow.showAsDropDown(view, i4, i5, i6);
    }
}
