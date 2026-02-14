package c0;

import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* loaded from: classes.dex */
class b {

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(T t4, Rect rect);
    }

    /* renamed from: c0.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0022b<T, V> {
        int a(T t4);

        V b(T t4, int i4);
    }

    /* loaded from: classes.dex */
    private static class c<T> implements Comparator<T> {

        /* renamed from: b, reason: collision with root package name */
        private final Rect f2416b = new Rect();

        /* renamed from: c, reason: collision with root package name */
        private final Rect f2417c = new Rect();

        /* renamed from: d, reason: collision with root package name */
        private final boolean f2418d;

        /* renamed from: e, reason: collision with root package name */
        private final a<T> f2419e;

        c(boolean z4, a<T> aVar) {
            this.f2418d = z4;
            this.f2419e = aVar;
        }

        @Override // java.util.Comparator
        public int compare(T t4, T t5) {
            Rect rect = this.f2416b;
            Rect rect2 = this.f2417c;
            this.f2419e.a(t4, rect);
            this.f2419e.a(t5, rect2);
            int i4 = rect.top;
            int i5 = rect2.top;
            if (i4 < i5) {
                return -1;
            }
            if (i4 > i5) {
                return 1;
            }
            int i6 = rect.left;
            int i7 = rect2.left;
            if (i6 < i7) {
                return this.f2418d ? 1 : -1;
            }
            if (i6 > i7) {
                return this.f2418d ? -1 : 1;
            }
            int i8 = rect.bottom;
            int i9 = rect2.bottom;
            if (i8 < i9) {
                return -1;
            }
            if (i8 > i9) {
                return 1;
            }
            int i10 = rect.right;
            int i11 = rect2.right;
            if (i10 < i11) {
                return this.f2418d ? 1 : -1;
            }
            if (i10 > i11) {
                return this.f2418d ? -1 : 1;
            }
            return 0;
        }
    }

    private static boolean a(int i4, Rect rect, Rect rect2, Rect rect3) {
        boolean b5 = b(i4, rect, rect2);
        if (b(i4, rect, rect3) || !b5) {
            return false;
        }
        return !j(i4, rect, rect3) || i4 == 17 || i4 == 66 || k(i4, rect, rect2) < m(i4, rect, rect3);
    }

    private static boolean b(int i4, Rect rect, Rect rect2) {
        if (i4 != 17) {
            if (i4 != 33) {
                if (i4 != 66) {
                    if (i4 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return rect2.right >= rect.left && rect2.left <= rect.right;
        }
        return rect2.bottom >= rect.top && rect2.top <= rect.bottom;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static <L, T> T c(L r7, c0.b.InterfaceC0022b<L, T> r8, c0.b.a<T> r9, T r10, android.graphics.Rect r11, int r12) {
        /*
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>(r11)
            r1 = 17
            r2 = 0
            if (r12 == r1) goto L38
            r1 = 33
            if (r12 == r1) goto L2e
            r1 = 66
            if (r12 == r1) goto L26
            r1 = 130(0x82, float:1.82E-43)
            if (r12 != r1) goto L1e
            int r1 = r11.height()
            int r1 = r1 + 1
            int r1 = -r1
            goto L34
        L1e:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r8 = "direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}."
            r7.<init>(r8)
            throw r7
        L26:
            int r1 = r11.width()
            int r1 = r1 + 1
            int r1 = -r1
            goto L3e
        L2e:
            int r1 = r11.height()
            int r1 = r1 + 1
        L34:
            r0.offset(r2, r1)
            goto L41
        L38:
            int r1 = r11.width()
            int r1 = r1 + 1
        L3e:
            r0.offset(r1, r2)
        L41:
            r1 = 0
            int r3 = r8.a(r7)
            android.graphics.Rect r4 = new android.graphics.Rect
            r4.<init>()
        L4b:
            if (r2 >= r3) goto L64
            java.lang.Object r5 = r8.b(r7, r2)
            if (r5 != r10) goto L54
            goto L61
        L54:
            r9.a(r5, r4)
            boolean r6 = h(r12, r11, r4, r0)
            if (r6 == 0) goto L61
            r0.set(r4)
            r1 = r5
        L61:
            int r2 = r2 + 1
            goto L4b
        L64:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: c0.b.c(java.lang.Object, c0.b$b, c0.b$a, java.lang.Object, android.graphics.Rect, int):java.lang.Object");
    }

    public static <L, T> T d(L l4, InterfaceC0022b<L, T> interfaceC0022b, a<T> aVar, T t4, int i4, boolean z4, boolean z5) {
        int a5 = interfaceC0022b.a(l4);
        ArrayList arrayList = new ArrayList(a5);
        for (int i5 = 0; i5 < a5; i5++) {
            arrayList.add(interfaceC0022b.b(l4, i5));
        }
        Collections.sort(arrayList, new c(z4, aVar));
        if (i4 == 1) {
            return (T) f(t4, arrayList, z5);
        }
        if (i4 == 2) {
            return (T) e(t4, arrayList, z5);
        }
        throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
    }

    private static <T> T e(T t4, ArrayList<T> arrayList, boolean z4) {
        int size = arrayList.size();
        int lastIndexOf = (t4 == null ? -1 : arrayList.lastIndexOf(t4)) + 1;
        if (lastIndexOf < size) {
            return arrayList.get(lastIndexOf);
        }
        if (!z4 || size <= 0) {
            return null;
        }
        return arrayList.get(0);
    }

    private static <T> T f(T t4, ArrayList<T> arrayList, boolean z4) {
        int size = arrayList.size();
        int indexOf = (t4 == null ? size : arrayList.indexOf(t4)) - 1;
        if (indexOf >= 0) {
            return arrayList.get(indexOf);
        }
        if (!z4 || size <= 0) {
            return null;
        }
        return arrayList.get(size - 1);
    }

    private static int g(int i4, int i5) {
        return (i4 * 13 * i4) + (i5 * i5);
    }

    private static boolean h(int i4, Rect rect, Rect rect2, Rect rect3) {
        if (!i(rect, rect2, i4)) {
            return false;
        }
        if (i(rect, rect3, i4) && !a(i4, rect, rect2, rect3)) {
            return !a(i4, rect, rect3, rect2) && g(k(i4, rect, rect2), o(i4, rect, rect2)) < g(k(i4, rect, rect3), o(i4, rect, rect3));
        }
        return true;
    }

    private static boolean i(Rect rect, Rect rect2, int i4) {
        if (i4 == 17) {
            int i5 = rect.right;
            int i6 = rect2.right;
            return (i5 > i6 || rect.left >= i6) && rect.left > rect2.left;
        }
        if (i4 == 33) {
            int i7 = rect.bottom;
            int i8 = rect2.bottom;
            return (i7 > i8 || rect.top >= i8) && rect.top > rect2.top;
        }
        if (i4 == 66) {
            int i9 = rect.left;
            int i10 = rect2.left;
            return (i9 < i10 || rect.right <= i10) && rect.right < rect2.right;
        }
        if (i4 != 130) {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        int i11 = rect.top;
        int i12 = rect2.top;
        return (i11 < i12 || rect.bottom <= i12) && rect.bottom < rect2.bottom;
    }

    private static boolean j(int i4, Rect rect, Rect rect2) {
        if (i4 == 17) {
            return rect.left >= rect2.right;
        }
        if (i4 == 33) {
            return rect.top >= rect2.bottom;
        }
        if (i4 == 66) {
            return rect.right <= rect2.left;
        }
        if (i4 == 130) {
            return rect.bottom <= rect2.top;
        }
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    }

    private static int k(int i4, Rect rect, Rect rect2) {
        return Math.max(0, l(i4, rect, rect2));
    }

    private static int l(int i4, Rect rect, Rect rect2) {
        int i5;
        int i6;
        if (i4 == 17) {
            i5 = rect.left;
            i6 = rect2.right;
        } else if (i4 == 33) {
            i5 = rect.top;
            i6 = rect2.bottom;
        } else if (i4 == 66) {
            i5 = rect2.left;
            i6 = rect.right;
        } else {
            if (i4 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            i5 = rect2.top;
            i6 = rect.bottom;
        }
        return i5 - i6;
    }

    private static int m(int i4, Rect rect, Rect rect2) {
        return Math.max(1, n(i4, rect, rect2));
    }

    private static int n(int i4, Rect rect, Rect rect2) {
        int i5;
        int i6;
        if (i4 == 17) {
            i5 = rect.left;
            i6 = rect2.left;
        } else if (i4 == 33) {
            i5 = rect.top;
            i6 = rect2.top;
        } else if (i4 == 66) {
            i5 = rect2.right;
            i6 = rect.right;
        } else {
            if (i4 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            i5 = rect2.bottom;
            i6 = rect.bottom;
        }
        return i5 - i6;
    }

    private static int o(int i4, Rect rect, Rect rect2) {
        int height;
        int i5;
        int height2;
        if (i4 != 17) {
            if (i4 != 33) {
                if (i4 != 66) {
                    if (i4 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            height = rect.left + (rect.width() / 2);
            i5 = rect2.left;
            height2 = rect2.width();
            return Math.abs(height - (i5 + (height2 / 2)));
        }
        height = rect.top + (rect.height() / 2);
        i5 = rect2.top;
        height2 = rect2.height();
        return Math.abs(height - (i5 + (height2 / 2)));
    }
}
