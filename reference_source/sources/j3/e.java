package j3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e implements i3.c<g3.f> {

    /* renamed from: a, reason: collision with root package name */
    private final CharSequence f4257a;

    /* renamed from: b, reason: collision with root package name */
    private final int f4258b;

    /* renamed from: c, reason: collision with root package name */
    private final int f4259c;

    /* renamed from: d, reason: collision with root package name */
    private final d3.c<CharSequence, Integer, u2.g<Integer, Integer>> f4260d;

    /* loaded from: classes.dex */
    public static final class a implements Iterator<g3.f>, f3.a {

        /* renamed from: b, reason: collision with root package name */
        private int f4261b = -1;

        /* renamed from: c, reason: collision with root package name */
        private int f4262c;

        /* renamed from: d, reason: collision with root package name */
        private int f4263d;

        /* renamed from: e, reason: collision with root package name */
        private g3.f f4264e;

        /* renamed from: f, reason: collision with root package name */
        private int f4265f;

        a() {
            int d5;
            d5 = g3.l.d(e.this.f4258b, 0, e.this.f4257a.length());
            this.f4262c = d5;
            this.f4263d = d5;
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
        
            if (r0 < r6.f4266g.f4259c) goto L9;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final void a() {
            /*
                r6 = this;
                int r0 = r6.f4263d
                r1 = 0
                if (r0 >= 0) goto Lc
                r6.f4261b = r1
                r0 = 0
                r6.f4264e = r0
                goto L99
            Lc:
                j3.e r0 = j3.e.this
                int r0 = j3.e.d(r0)
                r2 = -1
                r3 = 1
                if (r0 <= 0) goto L23
                int r0 = r6.f4265f
                int r0 = r0 + r3
                r6.f4265f = r0
                j3.e r4 = j3.e.this
                int r4 = j3.e.d(r4)
                if (r0 >= r4) goto L31
            L23:
                int r0 = r6.f4263d
                j3.e r4 = j3.e.this
                java.lang.CharSequence r4 = j3.e.c(r4)
                int r4 = r4.length()
                if (r0 <= r4) goto L47
            L31:
                g3.f r0 = new g3.f
                int r1 = r6.f4262c
                j3.e r4 = j3.e.this
                java.lang.CharSequence r4 = j3.e.c(r4)
                int r4 = j3.v.H(r4)
                r0.<init>(r1, r4)
            L42:
                r6.f4264e = r0
            L44:
                r6.f4263d = r2
                goto L97
            L47:
                j3.e r0 = j3.e.this
                d3.c r0 = j3.e.b(r0)
                j3.e r4 = j3.e.this
                java.lang.CharSequence r4 = j3.e.c(r4)
                int r5 = r6.f4263d
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r0 = r0.a(r4, r5)
                u2.g r0 = (u2.g) r0
                if (r0 != 0) goto L73
                g3.f r0 = new g3.f
                int r1 = r6.f4262c
                j3.e r4 = j3.e.this
                java.lang.CharSequence r4 = j3.e.c(r4)
                int r4 = j3.v.H(r4)
                r0.<init>(r1, r4)
                goto L42
            L73:
                java.lang.Object r2 = r0.a()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.b()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r4 = r6.f4262c
                g3.f r4 = g3.j.h(r4, r2)
                r6.f4264e = r4
                int r2 = r2 + r0
                r6.f4262c = r2
                if (r0 != 0) goto L95
                r1 = r3
            L95:
                int r2 = r2 + r1
                goto L44
            L97:
                r6.f4261b = r3
            L99:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: j3.e.a.a():void");
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public g3.f next() {
            if (this.f4261b == -1) {
                a();
            }
            if (this.f4261b == 0) {
                throw new NoSuchElementException();
            }
            g3.f fVar = this.f4264e;
            e3.f.c(fVar, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.f4264e = null;
            this.f4261b = -1;
            return fVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f4261b == -1) {
                a();
            }
            return this.f4261b == 1;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(CharSequence charSequence, int i4, int i5, d3.c<? super CharSequence, ? super Integer, u2.g<Integer, Integer>> cVar) {
        e3.f.e(charSequence, "input");
        e3.f.e(cVar, "getNextMatch");
        this.f4257a = charSequence;
        this.f4258b = i4;
        this.f4259c = i5;
        this.f4260d = cVar;
    }

    @Override // i3.c
    public Iterator<g3.f> iterator() {
        return new a();
    }
}
