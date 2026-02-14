package q0;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;

/* loaded from: classes.dex */
public interface d {

    /* loaded from: classes.dex */
    public static class b implements TypeEvaluator<e> {

        /* renamed from: b, reason: collision with root package name */
        public static final TypeEvaluator<e> f5526b = new b();

        /* renamed from: a, reason: collision with root package name */
        private final e f5527a = new e();

        @Override // android.animation.TypeEvaluator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e evaluate(float f4, e eVar, e eVar2) {
            this.f5527a.a(w0.a.c(eVar.f5530a, eVar2.f5530a, f4), w0.a.c(eVar.f5531b, eVar2.f5531b, f4), w0.a.c(eVar.f5532c, eVar2.f5532c, f4));
            return this.f5527a;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends Property<d, e> {

        /* renamed from: a, reason: collision with root package name */
        public static final Property<d, e> f5528a = new c("circularReveal");

        private c(String str) {
            super(e.class, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e get(d dVar) {
            return dVar.getRevealInfo();
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(d dVar, e eVar) {
            dVar.setRevealInfo(eVar);
        }
    }

    /* renamed from: q0.d$d, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0070d extends Property<d, Integer> {

        /* renamed from: a, reason: collision with root package name */
        public static final Property<d, Integer> f5529a = new C0070d("circularRevealScrimColor");

        private C0070d(String str) {
            super(Integer.class, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer get(d dVar) {
            return Integer.valueOf(dVar.getCircularRevealScrimColor());
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(d dVar, Integer num) {
            dVar.setCircularRevealScrimColor(num.intValue());
        }
    }

    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public float f5530a;

        /* renamed from: b, reason: collision with root package name */
        public float f5531b;

        /* renamed from: c, reason: collision with root package name */
        public float f5532c;

        private e() {
        }

        public e(float f4, float f5, float f6) {
            this.f5530a = f4;
            this.f5531b = f5;
            this.f5532c = f6;
        }

        public void a(float f4, float f5, float f6) {
            this.f5530a = f4;
            this.f5531b = f5;
            this.f5532c = f6;
        }
    }

    void a();

    void b();

    int getCircularRevealScrimColor();

    e getRevealInfo();

    void setCircularRevealOverlayDrawable(Drawable drawable);

    void setCircularRevealScrimColor(int i4);

    void setRevealInfo(e eVar);
}
