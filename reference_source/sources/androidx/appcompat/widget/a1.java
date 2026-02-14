package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

/* loaded from: classes.dex */
class a1 {

    /* renamed from: a, reason: collision with root package name */
    private final Context f930a;

    /* renamed from: b, reason: collision with root package name */
    private final View f931b;

    /* renamed from: c, reason: collision with root package name */
    private final TextView f932c;

    /* renamed from: d, reason: collision with root package name */
    private final WindowManager.LayoutParams f933d;

    /* renamed from: e, reason: collision with root package name */
    private final Rect f934e;

    /* renamed from: f, reason: collision with root package name */
    private final int[] f935f;

    /* renamed from: g, reason: collision with root package name */
    private final int[] f936g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a1(Context context) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f933d = layoutParams;
        this.f934e = new Rect();
        this.f935f = new int[2];
        this.f936g = new int[2];
        this.f930a = context;
        View inflate = LayoutInflater.from(context).inflate(a.g.f116s, (ViewGroup) null);
        this.f931b = inflate;
        this.f932c = (TextView) inflate.findViewById(a.f.f90s);
        layoutParams.setTitle(getClass().getSimpleName());
        layoutParams.packageName = context.getPackageName();
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = a.i.f130a;
        layoutParams.flags = 24;
    }

    private void a(View view, int i4, int i5, boolean z4, WindowManager.LayoutParams layoutParams) {
        int height;
        int i6;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = this.f930a.getResources().getDimensionPixelOffset(a.d.f43j);
        if (view.getWidth() < dimensionPixelOffset) {
            i4 = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = this.f930a.getResources().getDimensionPixelOffset(a.d.f42i);
            height = i5 + dimensionPixelOffset2;
            i6 = i5 - dimensionPixelOffset2;
        } else {
            height = view.getHeight();
            i6 = 0;
        }
        layoutParams.gravity = 49;
        int dimensionPixelOffset3 = this.f930a.getResources().getDimensionPixelOffset(z4 ? a.d.f45l : a.d.f44k);
        View b5 = b(view);
        if (b5 == null) {
            Log.e("TooltipPopup", "Cannot find app view");
            return;
        }
        b5.getWindowVisibleDisplayFrame(this.f934e);
        Rect rect = this.f934e;
        if (rect.left < 0 && rect.top < 0) {
            Resources resources = this.f930a.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            this.f934e.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        b5.getLocationOnScreen(this.f936g);
        view.getLocationOnScreen(this.f935f);
        int[] iArr = this.f935f;
        int i7 = iArr[0];
        int[] iArr2 = this.f936g;
        iArr[0] = i7 - iArr2[0];
        iArr[1] = iArr[1] - iArr2[1];
        layoutParams.x = (iArr[0] + i4) - (b5.getWidth() / 2);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f931b.measure(makeMeasureSpec, makeMeasureSpec);
        int measuredHeight = this.f931b.getMeasuredHeight();
        int[] iArr3 = this.f935f;
        int i8 = ((iArr3[1] + i6) - dimensionPixelOffset3) - measuredHeight;
        int i9 = iArr3[1] + height + dimensionPixelOffset3;
        if (!z4 ? measuredHeight + i9 <= this.f934e.height() : i8 < 0) {
            layoutParams.y = i8;
        } else {
            layoutParams.y = i9;
        }
    }

    private static View b(View view) {
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if ((layoutParams instanceof WindowManager.LayoutParams) && ((WindowManager.LayoutParams) layoutParams).type == 2) {
            return rootView;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
        }
        return rootView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        if (d()) {
            ((WindowManager) this.f930a.getSystemService("window")).removeView(this.f931b);
        }
    }

    boolean d() {
        return this.f931b.getParent() != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(View view, int i4, int i5, boolean z4, CharSequence charSequence) {
        if (d()) {
            c();
        }
        this.f932c.setText(charSequence);
        a(view, i4, i5, z4, this.f933d);
        ((WindowManager) this.f930a.getSystemService("window")).addView(this.f931b, this.f933d);
    }
}
