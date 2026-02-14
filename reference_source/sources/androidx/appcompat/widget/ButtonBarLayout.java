package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class ButtonBarLayout extends LinearLayout {

    /* renamed from: b, reason: collision with root package name */
    private boolean f801b;

    /* renamed from: c, reason: collision with root package name */
    private int f802c;

    /* renamed from: d, reason: collision with root package name */
    private int f803d;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f802c = -1;
        this.f803d = 0;
        int[] iArr = a.j.O0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, iArr, attributeSet, obtainStyledAttributes, 0, 0);
        }
        this.f801b = obtainStyledAttributes.getBoolean(a.j.P0, true);
        obtainStyledAttributes.recycle();
    }

    private int a(int i4) {
        int childCount = getChildCount();
        while (i4 < childCount) {
            if (getChildAt(i4).getVisibility() == 0) {
                return i4;
            }
            i4++;
        }
        return -1;
    }

    private boolean b() {
        return getOrientation() == 1;
    }

    private void setStacked(boolean z4) {
        setOrientation(z4 ? 1 : 0);
        setGravity(z4 ? 5 : 80);
        View findViewById = findViewById(a.f.G);
        if (findViewById != null) {
            findViewById.setVisibility(z4 ? 8 : 4);
        }
        for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
            bringChildToFront(getChildAt(childCount));
        }
    }

    @Override // android.view.View
    public int getMinimumHeight() {
        return Math.max(this.f803d, super.getMinimumHeight());
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i4, int i5) {
        int i6;
        boolean z4;
        int size = View.MeasureSpec.getSize(i4);
        int i7 = 0;
        if (this.f801b) {
            if (size > this.f802c && b()) {
                setStacked(false);
            }
            this.f802c = size;
        }
        if (b() || View.MeasureSpec.getMode(i4) != 1073741824) {
            i6 = i4;
            z4 = false;
        } else {
            i6 = View.MeasureSpec.makeMeasureSpec(size, RecyclerView.UNDEFINED_DURATION);
            z4 = true;
        }
        super.onMeasure(i6, i5);
        if (this.f801b && !b()) {
            if ((getMeasuredWidthAndState() & (-16777216)) == 16777216) {
                setStacked(true);
                z4 = true;
            }
        }
        if (z4) {
            super.onMeasure(i4, i5);
        }
        int a5 = a(0);
        if (a5 >= 0) {
            View childAt = getChildAt(a5);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            int paddingTop = getPaddingTop() + childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin + 0;
            if (b()) {
                int a6 = a(a5 + 1);
                if (a6 >= 0) {
                    paddingTop += getChildAt(a6).getPaddingTop() + ((int) (getResources().getDisplayMetrics().density * 16.0f));
                }
                i7 = paddingTop;
            } else {
                i7 = paddingTop + getPaddingBottom();
            }
        }
        if (y.p.u(this) != i7) {
            setMinimumHeight(i7);
        }
    }

    public void setAllowStacking(boolean z4) {
        if (this.f801b != z4) {
            this.f801b = z4;
            if (!z4 && getOrientation() == 1) {
                setStacked(false);
            }
            requestLayout();
        }
    }
}
