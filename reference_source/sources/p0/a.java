package p0;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import androidx.appcompat.widget.g;
import androidx.core.widget.c;
import m0.b;
import m0.j;

/* loaded from: classes.dex */
public class a extends g {

    /* renamed from: g, reason: collision with root package name */
    private static final int f5408g = j.f5046l;

    /* renamed from: h, reason: collision with root package name */
    private static final int[][] f5409h = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};

    /* renamed from: e, reason: collision with root package name */
    private ColorStateList f5410e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f5411f;

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.f4935c);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public a(android.content.Context r8, android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r4 = p0.a.f5408g
            android.content.Context r8 = e1.a.c(r8, r9, r10, r4)
            r7.<init>(r8, r9, r10)
            android.content.Context r8 = r7.getContext()
            int[] r2 = m0.k.f5053a2
            r6 = 0
            int[] r5 = new int[r6]
            r0 = r8
            r1 = r9
            r3 = r10
            android.content.res.TypedArray r9 = com.google.android.material.internal.i.h(r0, r1, r2, r3, r4, r5)
            int r10 = m0.k.f5059b2
            boolean r0 = r9.hasValue(r10)
            if (r0 == 0) goto L28
            android.content.res.ColorStateList r8 = y0.c.a(r8, r9, r10)
            androidx.core.widget.c.c(r7, r8)
        L28:
            int r8 = m0.k.f5065c2
            boolean r8 = r9.getBoolean(r8, r6)
            r7.f5411f = r8
            r9.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p0.a.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f5410e == null) {
            int[][] iArr = f5409h;
            int[] iArr2 = new int[iArr.length];
            int c5 = s0.a.c(this, b.f4938f);
            int c6 = s0.a.c(this, b.f4943k);
            int c7 = s0.a.c(this, b.f4940h);
            iArr2[0] = s0.a.f(c6, c5, 1.0f);
            iArr2[1] = s0.a.f(c6, c7, 0.54f);
            iArr2[2] = s0.a.f(c6, c7, 0.38f);
            iArr2[3] = s0.a.f(c6, c7, 0.38f);
            this.f5410e = new ColorStateList(iArr, iArr2);
        }
        return this.f5410e;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f5411f && c.b(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z4) {
        this.f5411f = z4;
        c.c(this, z4 ? getMaterialThemeColorsTintList() : null);
    }
}
