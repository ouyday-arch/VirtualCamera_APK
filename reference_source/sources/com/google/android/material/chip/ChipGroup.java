package com.google.android.material.chip;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import java.util.ArrayList;
import java.util.List;
import m0.j;
import z.c;

/* loaded from: classes.dex */
public class ChipGroup extends com.google.android.material.internal.c {

    /* renamed from: o, reason: collision with root package name */
    private static final int f2894o = j.f5044j;

    /* renamed from: f, reason: collision with root package name */
    private int f2895f;

    /* renamed from: g, reason: collision with root package name */
    private int f2896g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f2897h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f2898i;

    /* renamed from: j, reason: collision with root package name */
    private d f2899j;

    /* renamed from: k, reason: collision with root package name */
    private final b f2900k;

    /* renamed from: l, reason: collision with root package name */
    private e f2901l;

    /* renamed from: m, reason: collision with root package name */
    private int f2902m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f2903n;

    /* loaded from: classes.dex */
    private class b implements CompoundButton.OnCheckedChangeListener {
        private b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
            if (ChipGroup.this.f2903n) {
                return;
            }
            if (ChipGroup.this.getCheckedChipIds().isEmpty() && ChipGroup.this.f2898i) {
                ChipGroup.this.q(compoundButton.getId(), true);
                ChipGroup.this.p(compoundButton.getId(), false);
                return;
            }
            int id = compoundButton.getId();
            if (!z4) {
                if (ChipGroup.this.f2902m == id) {
                    ChipGroup.this.setCheckedId(-1);
                }
            } else {
                if (ChipGroup.this.f2902m != -1 && ChipGroup.this.f2902m != id && ChipGroup.this.f2897h) {
                    ChipGroup chipGroup = ChipGroup.this;
                    chipGroup.q(chipGroup.f2902m, false);
                }
                ChipGroup.this.setCheckedId(id);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c extends ViewGroup.MarginLayoutParams {
        public c(int i4, int i5) {
            super(i4, i5);
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(ChipGroup chipGroup, int i4);
    }

    /* loaded from: classes.dex */
    private class e implements ViewGroup.OnHierarchyChangeListener {

        /* renamed from: b, reason: collision with root package name */
        private ViewGroup.OnHierarchyChangeListener f2905b;

        private e() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            if (view == ChipGroup.this && (view2 instanceof Chip)) {
                if (view2.getId() == -1) {
                    view2.setId(View.generateViewId());
                }
                ((Chip) view2).setOnCheckedChangeListenerInternal(ChipGroup.this.f2900k);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f2905b;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            if (view == ChipGroup.this && (view2 instanceof Chip)) {
                ((Chip) view2).setOnCheckedChangeListenerInternal(null);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f2905b;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    public ChipGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, m0.b.f4936d);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ChipGroup(android.content.Context r8, android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r4 = com.google.android.material.chip.ChipGroup.f2894o
            android.content.Context r8 = e1.a.c(r8, r9, r10, r4)
            r7.<init>(r8, r9, r10)
            com.google.android.material.chip.ChipGroup$b r8 = new com.google.android.material.chip.ChipGroup$b
            r0 = 0
            r8.<init>()
            r7.f2900k = r8
            com.google.android.material.chip.ChipGroup$e r8 = new com.google.android.material.chip.ChipGroup$e
            r8.<init>()
            r7.f2901l = r8
            r8 = -1
            r7.f2902m = r8
            r6 = 0
            r7.f2903n = r6
            android.content.Context r0 = r7.getContext()
            int[] r2 = m0.k.f5175y0
            int[] r5 = new int[r6]
            r1 = r9
            r3 = r10
            android.content.res.TypedArray r9 = com.google.android.material.internal.i.h(r0, r1, r2, r3, r4, r5)
            int r10 = m0.k.A0
            int r10 = r9.getDimensionPixelOffset(r10, r6)
            int r0 = m0.k.B0
            int r0 = r9.getDimensionPixelOffset(r0, r10)
            r7.setChipSpacingHorizontal(r0)
            int r0 = m0.k.C0
            int r10 = r9.getDimensionPixelOffset(r0, r10)
            r7.setChipSpacingVertical(r10)
            int r10 = m0.k.E0
            boolean r10 = r9.getBoolean(r10, r6)
            r7.setSingleLine(r10)
            int r10 = m0.k.F0
            boolean r10 = r9.getBoolean(r10, r6)
            r7.setSingleSelection(r10)
            int r10 = m0.k.D0
            boolean r10 = r9.getBoolean(r10, r6)
            r7.setSelectionRequired(r10)
            int r10 = m0.k.f5180z0
            int r10 = r9.getResourceId(r10, r8)
            if (r10 == r8) goto L69
            r7.f2902m = r10
        L69:
            r9.recycle()
            com.google.android.material.chip.ChipGroup$e r8 = r7.f2901l
            super.setOnHierarchyChangeListener(r8)
            r8 = 1
            y.p.j0(r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.ChipGroup.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    private int getChipCount() {
        int i4 = 0;
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            if (getChildAt(i5) instanceof Chip) {
                i4++;
            }
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i4, boolean z4) {
        this.f2902m = i4;
        d dVar = this.f2899j;
        if (dVar != null && this.f2897h && z4) {
            dVar.a(this, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(int i4, boolean z4) {
        View findViewById = findViewById(i4);
        if (findViewById instanceof Chip) {
            this.f2903n = true;
            ((Chip) findViewById).setChecked(z4);
            this.f2903n = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckedId(int i4) {
        p(i4, true);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i4, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof Chip) {
            Chip chip = (Chip) view;
            if (chip.isChecked()) {
                int i5 = this.f2902m;
                if (i5 != -1 && this.f2897h) {
                    q(i5, false);
                }
                setCheckedId(chip.getId());
            }
        }
        super.addView(view, i4, layoutParams);
    }

    @Override // com.google.android.material.internal.c
    public boolean c() {
        return super.c();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof c);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new c(-2, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new c(layoutParams);
    }

    public int getCheckedChipId() {
        if (this.f2897h) {
            return this.f2902m;
        }
        return -1;
    }

    public List<Integer> getCheckedChipIds() {
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            View childAt = getChildAt(i4);
            if ((childAt instanceof Chip) && ((Chip) childAt).isChecked()) {
                arrayList.add(Integer.valueOf(childAt.getId()));
                if (this.f2897h) {
                    return arrayList;
                }
            }
        }
        return arrayList;
    }

    public int getChipSpacingHorizontal() {
        return this.f2895f;
    }

    public int getChipSpacingVertical() {
        return this.f2896g;
    }

    public void m() {
        this.f2903n = true;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            View childAt = getChildAt(i4);
            if (childAt instanceof Chip) {
                ((Chip) childAt).setChecked(false);
            }
        }
        this.f2903n = false;
        setCheckedId(-1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int n(View view) {
        if (!(view instanceof Chip)) {
            return -1;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            if (getChildAt(i5) instanceof Chip) {
                if (((Chip) getChildAt(i5)) == view) {
                    return i4;
                }
                i4++;
            }
        }
        return -1;
    }

    public boolean o() {
        return this.f2897h;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int i4 = this.f2902m;
        if (i4 != -1) {
            q(i4, true);
            setCheckedId(this.f2902m);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        z.c.t0(accessibilityNodeInfo).Y(c.b.a(getRowCount(), c() ? getChipCount() : -1, false, o() ? 1 : 2));
    }

    public void setChipSpacing(int i4) {
        setChipSpacingHorizontal(i4);
        setChipSpacingVertical(i4);
    }

    public void setChipSpacingHorizontal(int i4) {
        if (this.f2895f != i4) {
            this.f2895f = i4;
            setItemSpacing(i4);
            requestLayout();
        }
    }

    public void setChipSpacingHorizontalResource(int i4) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(i4));
    }

    public void setChipSpacingResource(int i4) {
        setChipSpacing(getResources().getDimensionPixelOffset(i4));
    }

    public void setChipSpacingVertical(int i4) {
        if (this.f2896g != i4) {
            this.f2896g = i4;
            setLineSpacing(i4);
            requestLayout();
        }
    }

    public void setChipSpacingVerticalResource(int i4) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(i4));
    }

    @Deprecated
    public void setDividerDrawableHorizontal(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setDividerDrawableVertical(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setFlexWrap(int i4) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    public void setOnCheckedChangeListener(d dVar) {
        this.f2899j = dVar;
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f2901l.f2905b = onHierarchyChangeListener;
    }

    public void setSelectionRequired(boolean z4) {
        this.f2898i = z4;
    }

    @Deprecated
    public void setShowDividerHorizontal(int i4) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerVertical(int i4) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    public void setSingleLine(int i4) {
        setSingleLine(getResources().getBoolean(i4));
    }

    @Override // com.google.android.material.internal.c
    public void setSingleLine(boolean z4) {
        super.setSingleLine(z4);
    }

    public void setSingleSelection(int i4) {
        setSingleSelection(getResources().getBoolean(i4));
    }

    public void setSingleSelection(boolean z4) {
        if (this.f2897h != z4) {
            this.f2897h = z4;
            m();
        }
    }
}
