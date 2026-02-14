package androidx.appcompat.app;

import a.j;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import f.b;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: androidx.appcompat.app.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0004a extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public int f413a;

        public C0004a(int i4, int i5) {
            super(i4, i5);
            this.f413a = 8388627;
        }

        public C0004a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f413a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.f228t);
            this.f413a = obtainStyledAttributes.getInt(j.f233u, 0);
            obtainStyledAttributes.recycle();
        }

        public C0004a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f413a = 0;
        }

        public C0004a(C0004a c0004a) {
            super((ViewGroup.MarginLayoutParams) c0004a);
            this.f413a = 0;
            this.f413a = c0004a.f413a;
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(boolean z4);
    }

    @Deprecated
    /* loaded from: classes.dex */
    public static abstract class c {
        public abstract CharSequence a();

        public abstract View b();

        public abstract Drawable c();

        public abstract CharSequence d();

        public abstract void e();
    }

    public boolean g() {
        return false;
    }

    public abstract boolean h();

    public abstract void i(boolean z4);

    public abstract int j();

    public abstract Context k();

    public abstract void l();

    public boolean m() {
        return false;
    }

    public abstract void n(Configuration configuration);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o() {
    }

    public abstract boolean p(int i4, KeyEvent keyEvent);

    public boolean q(KeyEvent keyEvent) {
        return false;
    }

    public boolean r() {
        return false;
    }

    public abstract void s(boolean z4);

    public abstract void t(boolean z4);

    public abstract void u(CharSequence charSequence);

    public abstract f.b v(b.a aVar);
}
