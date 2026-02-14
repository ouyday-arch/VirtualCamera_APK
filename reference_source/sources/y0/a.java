package y0;

import android.graphics.Typeface;

/* loaded from: classes.dex */
public final class a extends f {

    /* renamed from: a, reason: collision with root package name */
    private final Typeface f6567a;

    /* renamed from: b, reason: collision with root package name */
    private final InterfaceC0096a f6568b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f6569c;

    /* renamed from: y0.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0096a {
        void a(Typeface typeface);
    }

    public a(InterfaceC0096a interfaceC0096a, Typeface typeface) {
        this.f6567a = typeface;
        this.f6568b = interfaceC0096a;
    }

    private void d(Typeface typeface) {
        if (this.f6569c) {
            return;
        }
        this.f6568b.a(typeface);
    }

    @Override // y0.f
    public void a(int i4) {
        d(this.f6567a);
    }

    @Override // y0.f
    public void b(Typeface typeface, boolean z4) {
        d(typeface);
    }

    public void c() {
        this.f6569c = true;
    }
}
