package com.google.android.material.appbar;

import android.view.View;
import y.p;

/* loaded from: classes.dex */
class d {

    /* renamed from: a, reason: collision with root package name */
    private final View f2724a;

    /* renamed from: b, reason: collision with root package name */
    private int f2725b;

    /* renamed from: c, reason: collision with root package name */
    private int f2726c;

    /* renamed from: d, reason: collision with root package name */
    private int f2727d;

    /* renamed from: e, reason: collision with root package name */
    private int f2728e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f2729f = true;

    /* renamed from: g, reason: collision with root package name */
    private boolean f2730g = true;

    public d(View view) {
        this.f2724a = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        View view = this.f2724a;
        p.N(view, this.f2727d - (view.getTop() - this.f2725b));
        View view2 = this.f2724a;
        p.M(view2, this.f2728e - (view2.getLeft() - this.f2726c));
    }

    public int b() {
        return this.f2727d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.f2725b = this.f2724a.getTop();
        this.f2726c = this.f2724a.getLeft();
    }

    public boolean d(int i4) {
        if (!this.f2730g || this.f2728e == i4) {
            return false;
        }
        this.f2728e = i4;
        a();
        return true;
    }

    public boolean e(int i4) {
        if (!this.f2729f || this.f2727d == i4) {
            return false;
        }
        this.f2727d = i4;
        a();
        return true;
    }
}
