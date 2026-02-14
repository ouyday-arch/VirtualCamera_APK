package com.google.android.material.internal;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;

/* loaded from: classes.dex */
final class g {

    /* renamed from: a, reason: collision with root package name */
    private CharSequence f3162a;

    /* renamed from: b, reason: collision with root package name */
    private final TextPaint f3163b;

    /* renamed from: c, reason: collision with root package name */
    private final int f3164c;

    /* renamed from: e, reason: collision with root package name */
    private int f3166e;

    /* renamed from: i, reason: collision with root package name */
    private boolean f3170i;

    /* renamed from: d, reason: collision with root package name */
    private int f3165d = 0;

    /* renamed from: f, reason: collision with root package name */
    private Layout.Alignment f3167f = Layout.Alignment.ALIGN_NORMAL;

    /* renamed from: g, reason: collision with root package name */
    private int f3168g = Integer.MAX_VALUE;

    /* renamed from: h, reason: collision with root package name */
    private boolean f3169h = true;

    /* renamed from: j, reason: collision with root package name */
    private TextUtils.TruncateAt f3171j = null;

    /* loaded from: classes.dex */
    static class a extends Exception {
    }

    private g(CharSequence charSequence, TextPaint textPaint, int i4) {
        this.f3162a = charSequence;
        this.f3163b = textPaint;
        this.f3164c = i4;
        this.f3166e = charSequence.length();
    }

    public static g b(CharSequence charSequence, TextPaint textPaint, int i4) {
        return new g(charSequence, textPaint, i4);
    }

    public StaticLayout a() {
        if (this.f3162a == null) {
            this.f3162a = "";
        }
        int max = Math.max(0, this.f3164c);
        CharSequence charSequence = this.f3162a;
        if (this.f3168g == 1) {
            charSequence = TextUtils.ellipsize(charSequence, this.f3163b, max, this.f3171j);
        }
        int min = Math.min(charSequence.length(), this.f3166e);
        this.f3166e = min;
        if (this.f3170i) {
            this.f3167f = Layout.Alignment.ALIGN_OPPOSITE;
        }
        StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, this.f3165d, min, this.f3163b, max);
        obtain.setAlignment(this.f3167f);
        obtain.setIncludePad(this.f3169h);
        obtain.setTextDirection(this.f3170i ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
        TextUtils.TruncateAt truncateAt = this.f3171j;
        if (truncateAt != null) {
            obtain.setEllipsize(truncateAt);
        }
        obtain.setMaxLines(this.f3168g);
        return obtain.build();
    }

    public g c(Layout.Alignment alignment) {
        this.f3167f = alignment;
        return this;
    }

    public g d(TextUtils.TruncateAt truncateAt) {
        this.f3171j = truncateAt;
        return this;
    }

    public g e(boolean z4) {
        this.f3169h = z4;
        return this;
    }

    public g f(boolean z4) {
        this.f3170i = z4;
        return this;
    }

    public g g(int i4) {
        this.f3168g = i4;
        return this;
    }
}
