package androidx.lifecycle;

import androidx.lifecycle.d;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class FullLifecycleObserverAdapter implements e {

    /* renamed from: a, reason: collision with root package name */
    private final b f1675a;

    /* renamed from: b, reason: collision with root package name */
    private final e f1676b;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1677a;

        static {
            int[] iArr = new int[d.a.values().length];
            f1677a = iArr;
            try {
                iArr[d.a.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1677a[d.a.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1677a[d.a.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1677a[d.a.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1677a[d.a.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1677a[d.a.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1677a[d.a.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FullLifecycleObserverAdapter(b bVar, e eVar) {
        this.f1675a = bVar;
        this.f1676b = eVar;
    }

    @Override // androidx.lifecycle.e
    public void d(g gVar, d.a aVar) {
        switch (a.f1677a[aVar.ordinal()]) {
            case 1:
                this.f1675a.c(gVar);
                break;
            case 2:
                this.f1675a.g(gVar);
                break;
            case 3:
                this.f1675a.a(gVar);
                break;
            case 4:
                this.f1675a.e(gVar);
                break;
            case 5:
                this.f1675a.f(gVar);
                break;
            case 6:
                this.f1675a.b(gVar);
                break;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        e eVar = this.f1676b;
        if (eVar != null) {
            eVar.d(gVar, aVar);
        }
    }
}
