package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class h {

    /* renamed from: c, reason: collision with root package name */
    private float f3174c;

    /* renamed from: f, reason: collision with root package name */
    private y0.d f3177f;

    /* renamed from: a, reason: collision with root package name */
    private final TextPaint f3172a = new TextPaint(1);

    /* renamed from: b, reason: collision with root package name */
    private final y0.f f3173b = new a();

    /* renamed from: d, reason: collision with root package name */
    private boolean f3175d = true;

    /* renamed from: e, reason: collision with root package name */
    private WeakReference<b> f3176e = new WeakReference<>(null);

    /* loaded from: classes.dex */
    class a extends y0.f {
        a() {
        }

        @Override // y0.f
        public void a(int i4) {
            h.this.f3175d = true;
            b bVar = (b) h.this.f3176e.get();
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // y0.f
        public void b(Typeface typeface, boolean z4) {
            if (z4) {
                return;
            }
            h.this.f3175d = true;
            b bVar = (b) h.this.f3176e.get();
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a();

        int[] getState();

        boolean onStateChange(int[] iArr);
    }

    public h(b bVar) {
        g(bVar);
    }

    private float c(CharSequence charSequence) {
        if (charSequence == null) {
            return 0.0f;
        }
        return this.f3172a.measureText(charSequence, 0, charSequence.length());
    }

    public y0.d d() {
        return this.f3177f;
    }

    public TextPaint e() {
        return this.f3172a;
    }

    public float f(String str) {
        if (!this.f3175d) {
            return this.f3174c;
        }
        float c5 = c(str);
        this.f3174c = c5;
        this.f3175d = false;
        return c5;
    }

    public void g(b bVar) {
        this.f3176e = new WeakReference<>(bVar);
    }

    public void h(y0.d dVar, Context context) {
        if (this.f3177f != dVar) {
            this.f3177f = dVar;
            if (dVar != null) {
                dVar.j(context, this.f3172a, this.f3173b);
                b bVar = this.f3176e.get();
                if (bVar != null) {
                    this.f3172a.drawableState = bVar.getState();
                }
                dVar.i(context, this.f3172a, this.f3173b);
                this.f3175d = true;
            }
            b bVar2 = this.f3176e.get();
            if (bVar2 != null) {
                bVar2.a();
                bVar2.onStateChange(bVar2.getState());
            }
        }
    }

    public void i(boolean z4) {
        this.f3175d = z4;
    }

    public void j(Context context) {
        this.f3177f.i(context, this.f3172a, this.f3173b);
    }
}
