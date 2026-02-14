package com.ashokvarma.bottomnavigation;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private int f2537a;

    /* renamed from: b, reason: collision with root package name */
    private Drawable f2538b;

    /* renamed from: c, reason: collision with root package name */
    private int f2539c;

    /* renamed from: d, reason: collision with root package name */
    private Drawable f2540d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f2541e = false;

    /* renamed from: f, reason: collision with root package name */
    private int f2542f;

    /* renamed from: g, reason: collision with root package name */
    private String f2543g;

    /* renamed from: h, reason: collision with root package name */
    private int f2544h;

    /* renamed from: i, reason: collision with root package name */
    private String f2545i;

    /* renamed from: j, reason: collision with root package name */
    private int f2546j;

    /* renamed from: k, reason: collision with root package name */
    private int f2547k;

    /* renamed from: l, reason: collision with root package name */
    private String f2548l;

    /* renamed from: m, reason: collision with root package name */
    private int f2549m;

    public c(int i4, String str) {
        this.f2537a = i4;
        this.f2543g = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(Context context) {
        int i4 = this.f2544h;
        if (i4 != 0) {
            return o.a.b(context, i4);
        }
        if (!TextUtils.isEmpty(this.f2545i)) {
            return Color.parseColor(this.f2545i);
        }
        int i5 = this.f2546j;
        if (i5 != 0) {
            return i5;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a b() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable c(Context context) {
        int i4 = this.f2537a;
        return i4 != 0 ? o.a.c(context, i4) : this.f2538b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d(Context context) {
        int i4 = this.f2547k;
        if (i4 != 0) {
            return o.a.b(context, i4);
        }
        if (!TextUtils.isEmpty(this.f2548l)) {
            return Color.parseColor(this.f2548l);
        }
        int i5 = this.f2549m;
        if (i5 != 0) {
            return i5;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable e(Context context) {
        int i4 = this.f2539c;
        return i4 != 0 ? o.a.c(context, i4) : this.f2540d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String f(Context context) {
        int i4 = this.f2542f;
        return i4 != 0 ? context.getString(i4) : this.f2543g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g() {
        return this.f2541e;
    }
}
