package b4;

import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class w extends v2.b<g> implements RandomAccess {

    /* renamed from: e, reason: collision with root package name */
    public static final a f2388e = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private final g[] f2389c;

    /* renamed from: d, reason: collision with root package name */
    private final int[] f2390d;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e3.d dVar) {
            this();
        }

        private final void a(long j4, d dVar, int i4, List<? extends g> list, int i5, int i6, List<Integer> list2) {
            int i7;
            int i8;
            int i9;
            int i10;
            d dVar2;
            int i11 = i4;
            if (!(i5 < i6)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            for (int i12 = i5; i12 < i6; i12++) {
                if (!(list.get(i12).y() >= i11)) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            }
            g gVar = list.get(i5);
            g gVar2 = list.get(i6 - 1);
            int i13 = -1;
            if (i11 == gVar.y()) {
                int intValue = list2.get(i5).intValue();
                int i14 = i5 + 1;
                g gVar3 = list.get(i14);
                i7 = i14;
                i8 = intValue;
                gVar = gVar3;
            } else {
                i7 = i5;
                i8 = -1;
            }
            if (gVar.e(i11) == gVar2.e(i11)) {
                int min = Math.min(gVar.y(), gVar2.y());
                int i15 = 0;
                for (int i16 = i11; i16 < min && gVar.e(i16) == gVar2.e(i16); i16++) {
                    i15++;
                }
                long c5 = j4 + c(dVar) + 2 + i15 + 1;
                dVar.t(-i15);
                dVar.t(i8);
                int i17 = i11 + i15;
                while (i11 < i17) {
                    dVar.t(gVar.e(i11) & 255);
                    i11++;
                }
                if (i7 + 1 == i6) {
                    if (!(i17 == list.get(i7).y())) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    dVar.t(list2.get(i7).intValue());
                    return;
                } else {
                    d dVar3 = new d();
                    dVar.t(((int) (c(dVar3) + c5)) * (-1));
                    a(c5, dVar3, i17, list, i7, i6, list2);
                    dVar.j0(dVar3);
                    return;
                }
            }
            int i18 = 1;
            for (int i19 = i7 + 1; i19 < i6; i19++) {
                if (list.get(i19 - 1).e(i11) != list.get(i19).e(i11)) {
                    i18++;
                }
            }
            long c6 = j4 + c(dVar) + 2 + (i18 * 2);
            dVar.t(i18);
            dVar.t(i8);
            for (int i20 = i7; i20 < i6; i20++) {
                byte e4 = list.get(i20).e(i11);
                if (i20 == i7 || e4 != list.get(i20 - 1).e(i11)) {
                    dVar.t(e4 & 255);
                }
            }
            d dVar4 = new d();
            while (i7 < i6) {
                byte e5 = list.get(i7).e(i11);
                int i21 = i7 + 1;
                int i22 = i21;
                while (true) {
                    if (i22 >= i6) {
                        i9 = i6;
                        break;
                    } else {
                        if (e5 != list.get(i22).e(i11)) {
                            i9 = i22;
                            break;
                        }
                        i22++;
                    }
                }
                if (i21 == i9 && i11 + 1 == list.get(i7).y()) {
                    dVar.t(list2.get(i7).intValue());
                    i10 = i9;
                    dVar2 = dVar4;
                } else {
                    dVar.t(((int) (c6 + c(dVar4))) * i13);
                    i10 = i9;
                    dVar2 = dVar4;
                    a(c6, dVar4, i11 + 1, list, i7, i9, list2);
                }
                dVar4 = dVar2;
                i7 = i10;
                i13 = -1;
            }
            dVar.j0(dVar4);
        }

        static /* synthetic */ void b(a aVar, long j4, d dVar, int i4, List list, int i5, int i6, List list2, int i7, Object obj) {
            aVar.a((i7 & 1) != 0 ? 0L : j4, dVar, (i7 & 4) != 0 ? 0 : i4, list, (i7 & 16) != 0 ? 0 : i5, (i7 & 32) != 0 ? list.size() : i6, list2);
        }

        private final long c(d dVar) {
            return dVar.c0() / 4;
        }

        /* JADX WARN: Code restructure failed: missing block: B:46:0x00e9, code lost:
        
            continue;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final b4.w d(b4.g... r17) {
            /*
                Method dump skipped, instructions count: 320
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: b4.w.a.d(b4.g[]):b4.w");
        }
    }

    private w(g[] gVarArr, int[] iArr) {
        this.f2389c = gVarArr;
        this.f2390d = iArr;
    }

    public /* synthetic */ w(g[] gVarArr, int[] iArr, e3.d dVar) {
        this(gVarArr, iArr);
    }

    @Override // v2.a
    public int a() {
        return this.f2389c.length;
    }

    public /* bridge */ boolean b(g gVar) {
        return super.contains(gVar);
    }

    @Override // v2.b, java.util.List
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public g get(int i4) {
        return this.f2389c[i4];
    }

    @Override // v2.a, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof g) {
            return b((g) obj);
        }
        return false;
    }

    public final g[] d() {
        return this.f2389c;
    }

    public final int[] e() {
        return this.f2390d;
    }

    public /* bridge */ int f(g gVar) {
        return super.indexOf(gVar);
    }

    public /* bridge */ int g(g gVar) {
        return super.lastIndexOf(gVar);
    }

    @Override // v2.b, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof g) {
            return f((g) obj);
        }
        return -1;
    }

    @Override // v2.b, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof g) {
            return g((g) obj);
        }
        return -1;
    }
}
