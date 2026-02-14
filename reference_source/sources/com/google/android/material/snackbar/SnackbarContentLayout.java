package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import m0.f;
import m0.k;
import y.p;

/* loaded from: classes.dex */
public class SnackbarContentLayout extends LinearLayout {

    /* renamed from: b, reason: collision with root package name */
    private TextView f3183b;

    /* renamed from: c, reason: collision with root package name */
    private Button f3184c;

    /* renamed from: d, reason: collision with root package name */
    private int f3185d;

    /* renamed from: e, reason: collision with root package name */
    private int f3186e;

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.P2);
        this.f3185d = obtainStyledAttributes.getDimensionPixelSize(k.Q2, -1);
        this.f3186e = obtainStyledAttributes.getDimensionPixelSize(k.X2, -1);
        obtainStyledAttributes.recycle();
    }

    private static void a(View view, int i4, int i5) {
        if (p.J(view)) {
            p.m0(view, p.y(view), i4, p.x(view), i5);
        } else {
            view.setPadding(view.getPaddingLeft(), i4, view.getPaddingRight(), i5);
        }
    }

    private boolean b(int i4, int i5, int i6) {
        boolean z4;
        if (i4 != getOrientation()) {
            setOrientation(i4);
            z4 = true;
        } else {
            z4 = false;
        }
        if (this.f3183b.getPaddingTop() == i5 && this.f3183b.getPaddingBottom() == i6) {
            return z4;
        }
        a(this.f3183b, i5, i6);
        return true;
    }

    public Button getActionView() {
        return this.f3184c;
    }

    public TextView getMessageView() {
        return this.f3183b;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f3183b = (TextView) findViewById(f.f5005r);
        this.f3184c = (Button) findViewById(f.f5004q);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0053, code lost:
    
        if (b(1, r0, r0 - r1) != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0060, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005e, code lost:
    
        if (b(0, r0, r0) != false) goto L24;
     */
    @Override // android.widget.LinearLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r8, int r9) {
        /*
            r7 = this;
            super.onMeasure(r8, r9)
            int r0 = r7.f3185d
            if (r0 <= 0) goto L18
            int r0 = r7.getMeasuredWidth()
            int r1 = r7.f3185d
            if (r0 <= r1) goto L18
            r8 = 1073741824(0x40000000, float:2.0)
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r8)
            super.onMeasure(r8, r9)
        L18:
            android.content.res.Resources r0 = r7.getResources()
            int r1 = m0.d.f4970g
            int r0 = r0.getDimensionPixelSize(r1)
            android.content.res.Resources r1 = r7.getResources()
            int r2 = m0.d.f4969f
            int r1 = r1.getDimensionPixelSize(r2)
            android.widget.TextView r2 = r7.f3183b
            android.text.Layout r2 = r2.getLayout()
            int r2 = r2.getLineCount()
            r3 = 0
            r4 = 1
            if (r2 <= r4) goto L3c
            r2 = r4
            goto L3d
        L3c:
            r2 = r3
        L3d:
            if (r2 == 0) goto L56
            int r5 = r7.f3186e
            if (r5 <= 0) goto L56
            android.widget.Button r5 = r7.f3184c
            int r5 = r5.getMeasuredWidth()
            int r6 = r7.f3186e
            if (r5 <= r6) goto L56
            int r1 = r0 - r1
            boolean r0 = r7.b(r4, r0, r1)
            if (r0 == 0) goto L61
            goto L60
        L56:
            if (r2 == 0) goto L59
            goto L5a
        L59:
            r0 = r1
        L5a:
            boolean r0 = r7.b(r3, r0, r0)
            if (r0 == 0) goto L61
        L60:
            r3 = r4
        L61:
            if (r3 == 0) goto L66
            super.onMeasure(r8, r9)
        L66:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.snackbar.SnackbarContentLayout.onMeasure(int, int):void");
    }

    public void setMaxInlineActionWidth(int i4) {
        this.f3186e = i4;
    }
}
