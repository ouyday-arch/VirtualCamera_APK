package x0;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import androidx.appcompat.widget.s;
import androidx.core.widget.c;
import m0.b;
import m0.j;

/* loaded from: classes.dex */
public class a extends s {

    /* renamed from: g, reason: collision with root package name */
    private static final int f6466g = j.f5047m;

    /* renamed from: h, reason: collision with root package name */
    private static final int[][] f6467h = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};

    /* renamed from: e, reason: collision with root package name */
    private ColorStateList f6468e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f6469f;

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.f4951s);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public a(android.content.Context r7, android.util.AttributeSet r8, int r9) {
        /*
            r6 = this;
            int r4 = x0.a.f6466g
            android.content.Context r7 = e1.a.c(r7, r8, r9, r4)
            r6.<init>(r7, r8, r9)
            android.content.Context r0 = r6.getContext()
            int[] r2 = m0.k.f5071d2
            r7 = 0
            int[] r5 = new int[r7]
            r1 = r8
            r3 = r9
            android.content.res.TypedArray r8 = com.google.android.material.internal.i.h(r0, r1, r2, r3, r4, r5)
            int r9 = m0.k.f5077e2
            boolean r7 = r8.getBoolean(r9, r7)
            r6.f6469f = r7
            r8.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: x0.a.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f6468e == null) {
            int c5 = s0.a.c(this, b.f4938f);
            int c6 = s0.a.c(this, b.f4940h);
            int c7 = s0.a.c(this, b.f4943k);
            int[][] iArr = f6467h;
            int[] iArr2 = new int[iArr.length];
            iArr2[0] = s0.a.f(c7, c5, 1.0f);
            iArr2[1] = s0.a.f(c7, c6, 0.54f);
            iArr2[2] = s0.a.f(c7, c6, 0.38f);
            iArr2[3] = s0.a.f(c7, c6, 0.38f);
            this.f6468e = new ColorStateList(iArr, iArr2);
        }
        return this.f6468e;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f6469f && c.b(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z4) {
        this.f6469f = z4;
        c.c(this, z4 ? getMaterialThemeColorsTintList() : null);
    }
}
