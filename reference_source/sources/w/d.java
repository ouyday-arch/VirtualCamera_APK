package w;

import java.util.Locale;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final w.c f6336a = new e(null, false);

    /* renamed from: b, reason: collision with root package name */
    public static final w.c f6337b = new e(null, true);

    /* renamed from: c, reason: collision with root package name */
    public static final w.c f6338c;

    /* renamed from: d, reason: collision with root package name */
    public static final w.c f6339d;

    /* renamed from: e, reason: collision with root package name */
    public static final w.c f6340e;

    /* renamed from: f, reason: collision with root package name */
    public static final w.c f6341f;

    /* loaded from: classes.dex */
    private static class a implements c {

        /* renamed from: b, reason: collision with root package name */
        static final a f6342b = new a(true);

        /* renamed from: a, reason: collision with root package name */
        private final boolean f6343a;

        private a(boolean z4) {
            this.f6343a = z4;
        }

        @Override // w.d.c
        public int a(CharSequence charSequence, int i4, int i5) {
            int i6 = i5 + i4;
            boolean z4 = false;
            while (i4 < i6) {
                int a5 = d.a(Character.getDirectionality(charSequence.charAt(i4)));
                if (a5 != 0) {
                    if (a5 != 1) {
                        continue;
                        i4++;
                        z4 = z4;
                    } else if (!this.f6343a) {
                        return 1;
                    }
                } else if (this.f6343a) {
                    return 0;
                }
                z4 = true;
                i4++;
                z4 = z4;
            }
            if (z4) {
                return this.f6343a ? 1 : 0;
            }
            return 2;
        }
    }

    /* loaded from: classes.dex */
    private static class b implements c {

        /* renamed from: a, reason: collision with root package name */
        static final b f6344a = new b();

        private b() {
        }

        @Override // w.d.c
        public int a(CharSequence charSequence, int i4, int i5) {
            int i6 = i5 + i4;
            int i7 = 2;
            while (i4 < i6 && i7 == 2) {
                i7 = d.b(Character.getDirectionality(charSequence.charAt(i4)));
                i4++;
            }
            return i7;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface c {
        int a(CharSequence charSequence, int i4, int i5);
    }

    /* renamed from: w.d$d, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static abstract class AbstractC0088d implements w.c {

        /* renamed from: a, reason: collision with root package name */
        private final c f6345a;

        AbstractC0088d(c cVar) {
            this.f6345a = cVar;
        }

        private boolean c(CharSequence charSequence, int i4, int i5) {
            int a5 = this.f6345a.a(charSequence, i4, i5);
            if (a5 == 0) {
                return true;
            }
            if (a5 != 1) {
                return b();
            }
            return false;
        }

        @Override // w.c
        public boolean a(CharSequence charSequence, int i4, int i5) {
            if (charSequence == null || i4 < 0 || i5 < 0 || charSequence.length() - i5 < i4) {
                throw new IllegalArgumentException();
            }
            return this.f6345a == null ? b() : c(charSequence, i4, i5);
        }

        protected abstract boolean b();
    }

    /* loaded from: classes.dex */
    private static class e extends AbstractC0088d {

        /* renamed from: b, reason: collision with root package name */
        private final boolean f6346b;

        e(c cVar, boolean z4) {
            super(cVar);
            this.f6346b = z4;
        }

        @Override // w.d.AbstractC0088d
        protected boolean b() {
            return this.f6346b;
        }
    }

    /* loaded from: classes.dex */
    private static class f extends AbstractC0088d {

        /* renamed from: b, reason: collision with root package name */
        static final f f6347b = new f();

        f() {
            super(null);
        }

        @Override // w.d.AbstractC0088d
        protected boolean b() {
            return w.e.a(Locale.getDefault()) == 1;
        }
    }

    static {
        b bVar = b.f6344a;
        f6338c = new e(bVar, false);
        f6339d = new e(bVar, true);
        f6340e = new e(a.f6342b, false);
        f6341f = f.f6347b;
    }

    static int a(int i4) {
        if (i4 != 0) {
            return (i4 == 1 || i4 == 2) ? 0 : 2;
        }
        return 1;
    }

    static int b(int i4) {
        if (i4 != 0) {
            if (i4 == 1 || i4 == 2) {
                return 0;
            }
            switch (i4) {
                case 14:
                case 15:
                    break;
                case 16:
                case 17:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }
}
