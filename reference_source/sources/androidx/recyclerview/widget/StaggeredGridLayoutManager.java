package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import z.c;

/* loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.o implements RecyclerView.z.b {
    private BitSet B;
    private boolean G;
    private boolean H;
    private e I;
    private int J;
    private int[] O;

    /* renamed from: t, reason: collision with root package name */
    f[] f1902t;

    /* renamed from: u, reason: collision with root package name */
    j f1903u;

    /* renamed from: v, reason: collision with root package name */
    j f1904v;

    /* renamed from: w, reason: collision with root package name */
    private int f1905w;

    /* renamed from: x, reason: collision with root package name */
    private int f1906x;

    /* renamed from: y, reason: collision with root package name */
    private final androidx.recyclerview.widget.f f1907y;

    /* renamed from: s, reason: collision with root package name */
    private int f1901s = -1;

    /* renamed from: z, reason: collision with root package name */
    boolean f1908z = false;
    boolean A = false;
    int C = -1;
    int D = RecyclerView.UNDEFINED_DURATION;
    d E = new d();
    private int F = 2;
    private final Rect K = new Rect();
    private final b L = new b();
    private boolean M = false;
    private boolean N = true;
    private final Runnable P = new a();

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StaggeredGridLayoutManager.this.S1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        int f1910a;

        /* renamed from: b, reason: collision with root package name */
        int f1911b;

        /* renamed from: c, reason: collision with root package name */
        boolean f1912c;

        /* renamed from: d, reason: collision with root package name */
        boolean f1913d;

        /* renamed from: e, reason: collision with root package name */
        boolean f1914e;

        /* renamed from: f, reason: collision with root package name */
        int[] f1915f;

        b() {
            c();
        }

        void a() {
            this.f1911b = this.f1912c ? StaggeredGridLayoutManager.this.f1903u.i() : StaggeredGridLayoutManager.this.f1903u.m();
        }

        void b(int i4) {
            this.f1911b = this.f1912c ? StaggeredGridLayoutManager.this.f1903u.i() - i4 : StaggeredGridLayoutManager.this.f1903u.m() + i4;
        }

        void c() {
            this.f1910a = -1;
            this.f1911b = RecyclerView.UNDEFINED_DURATION;
            this.f1912c = false;
            this.f1913d = false;
            this.f1914e = false;
            int[] iArr = this.f1915f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        void d(f[] fVarArr) {
            int length = fVarArr.length;
            int[] iArr = this.f1915f;
            if (iArr == null || iArr.length < length) {
                this.f1915f = new int[StaggeredGridLayoutManager.this.f1902t.length];
            }
            for (int i4 = 0; i4 < length; i4++) {
                this.f1915f[i4] = fVarArr[i4].p(RecyclerView.UNDEFINED_DURATION);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c extends RecyclerView.p {

        /* renamed from: e, reason: collision with root package name */
        f f1917e;

        /* renamed from: f, reason: collision with root package name */
        boolean f1918f;

        public c(int i4, int i5) {
            super(i4, i5);
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public final int e() {
            f fVar = this.f1917e;
            if (fVar == null) {
                return -1;
            }
            return fVar.f1939e;
        }

        public boolean f() {
            return this.f1918f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        int[] f1919a;

        /* renamed from: b, reason: collision with root package name */
        List<a> f1920b;

        /* JADX INFO: Access modifiers changed from: package-private */
        @SuppressLint({"BanParcelableUsage"})
        /* loaded from: classes.dex */
        public static class a implements Parcelable {
            public static final Parcelable.Creator<a> CREATOR = new C0014a();

            /* renamed from: b, reason: collision with root package name */
            int f1921b;

            /* renamed from: c, reason: collision with root package name */
            int f1922c;

            /* renamed from: d, reason: collision with root package name */
            int[] f1923d;

            /* renamed from: e, reason: collision with root package name */
            boolean f1924e;

            /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a$a, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            static class C0014a implements Parcelable.Creator<a> {
                C0014a() {
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public a createFromParcel(Parcel parcel) {
                    return new a(parcel);
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public a[] newArray(int i4) {
                    return new a[i4];
                }
            }

            a() {
            }

            a(Parcel parcel) {
                this.f1921b = parcel.readInt();
                this.f1922c = parcel.readInt();
                this.f1924e = parcel.readInt() == 1;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    int[] iArr = new int[readInt];
                    this.f1923d = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            int f(int i4) {
                int[] iArr = this.f1923d;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i4];
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f1921b + ", mGapDir=" + this.f1922c + ", mHasUnwantedGapAfter=" + this.f1924e + ", mGapPerSpan=" + Arrays.toString(this.f1923d) + '}';
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i4) {
                parcel.writeInt(this.f1921b);
                parcel.writeInt(this.f1922c);
                parcel.writeInt(this.f1924e ? 1 : 0);
                int[] iArr = this.f1923d;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(iArr.length);
                    parcel.writeIntArray(this.f1923d);
                }
            }
        }

        d() {
        }

        private int i(int i4) {
            if (this.f1920b == null) {
                return -1;
            }
            a f4 = f(i4);
            if (f4 != null) {
                this.f1920b.remove(f4);
            }
            int size = this.f1920b.size();
            int i5 = 0;
            while (true) {
                if (i5 >= size) {
                    i5 = -1;
                    break;
                }
                if (this.f1920b.get(i5).f1921b >= i4) {
                    break;
                }
                i5++;
            }
            if (i5 == -1) {
                return -1;
            }
            a aVar = this.f1920b.get(i5);
            this.f1920b.remove(i5);
            return aVar.f1921b;
        }

        private void l(int i4, int i5) {
            List<a> list = this.f1920b;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = this.f1920b.get(size);
                int i6 = aVar.f1921b;
                if (i6 >= i4) {
                    aVar.f1921b = i6 + i5;
                }
            }
        }

        private void m(int i4, int i5) {
            List<a> list = this.f1920b;
            if (list == null) {
                return;
            }
            int i6 = i4 + i5;
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = this.f1920b.get(size);
                int i7 = aVar.f1921b;
                if (i7 >= i4) {
                    if (i7 < i6) {
                        this.f1920b.remove(size);
                    } else {
                        aVar.f1921b = i7 - i5;
                    }
                }
            }
        }

        public void a(a aVar) {
            if (this.f1920b == null) {
                this.f1920b = new ArrayList();
            }
            int size = this.f1920b.size();
            for (int i4 = 0; i4 < size; i4++) {
                a aVar2 = this.f1920b.get(i4);
                if (aVar2.f1921b == aVar.f1921b) {
                    this.f1920b.remove(i4);
                }
                if (aVar2.f1921b >= aVar.f1921b) {
                    this.f1920b.add(i4, aVar);
                    return;
                }
            }
            this.f1920b.add(aVar);
        }

        void b() {
            int[] iArr = this.f1919a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f1920b = null;
        }

        void c(int i4) {
            int[] iArr = this.f1919a;
            if (iArr == null) {
                int[] iArr2 = new int[Math.max(i4, 10) + 1];
                this.f1919a = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i4 >= iArr.length) {
                int[] iArr3 = new int[o(i4)];
                this.f1919a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.f1919a;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        int d(int i4) {
            List<a> list = this.f1920b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (this.f1920b.get(size).f1921b >= i4) {
                        this.f1920b.remove(size);
                    }
                }
            }
            return h(i4);
        }

        public a e(int i4, int i5, int i6, boolean z4) {
            List<a> list = this.f1920b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i7 = 0; i7 < size; i7++) {
                a aVar = this.f1920b.get(i7);
                int i8 = aVar.f1921b;
                if (i8 >= i5) {
                    return null;
                }
                if (i8 >= i4 && (i6 == 0 || aVar.f1922c == i6 || (z4 && aVar.f1924e))) {
                    return aVar;
                }
            }
            return null;
        }

        public a f(int i4) {
            List<a> list = this.f1920b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = this.f1920b.get(size);
                if (aVar.f1921b == i4) {
                    return aVar;
                }
            }
            return null;
        }

        int g(int i4) {
            int[] iArr = this.f1919a;
            if (iArr == null || i4 >= iArr.length) {
                return -1;
            }
            return iArr[i4];
        }

        int h(int i4) {
            int[] iArr = this.f1919a;
            if (iArr == null || i4 >= iArr.length) {
                return -1;
            }
            int i5 = i(i4);
            if (i5 == -1) {
                int[] iArr2 = this.f1919a;
                Arrays.fill(iArr2, i4, iArr2.length, -1);
                return this.f1919a.length;
            }
            int i6 = i5 + 1;
            Arrays.fill(this.f1919a, i4, i6, -1);
            return i6;
        }

        void j(int i4, int i5) {
            int[] iArr = this.f1919a;
            if (iArr == null || i4 >= iArr.length) {
                return;
            }
            int i6 = i4 + i5;
            c(i6);
            int[] iArr2 = this.f1919a;
            System.arraycopy(iArr2, i4, iArr2, i6, (iArr2.length - i4) - i5);
            Arrays.fill(this.f1919a, i4, i6, -1);
            l(i4, i5);
        }

        void k(int i4, int i5) {
            int[] iArr = this.f1919a;
            if (iArr == null || i4 >= iArr.length) {
                return;
            }
            int i6 = i4 + i5;
            c(i6);
            int[] iArr2 = this.f1919a;
            System.arraycopy(iArr2, i6, iArr2, i4, (iArr2.length - i4) - i5);
            int[] iArr3 = this.f1919a;
            Arrays.fill(iArr3, iArr3.length - i5, iArr3.length, -1);
            m(i4, i5);
        }

        void n(int i4, f fVar) {
            c(i4);
            this.f1919a[i4] = fVar.f1939e;
        }

        int o(int i4) {
            int length = this.f1919a.length;
            while (length <= i4) {
                length *= 2;
            }
            return length;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: classes.dex */
    public static class e implements Parcelable {
        public static final Parcelable.Creator<e> CREATOR = new a();

        /* renamed from: b, reason: collision with root package name */
        int f1925b;

        /* renamed from: c, reason: collision with root package name */
        int f1926c;

        /* renamed from: d, reason: collision with root package name */
        int f1927d;

        /* renamed from: e, reason: collision with root package name */
        int[] f1928e;

        /* renamed from: f, reason: collision with root package name */
        int f1929f;

        /* renamed from: g, reason: collision with root package name */
        int[] f1930g;

        /* renamed from: h, reason: collision with root package name */
        List<d.a> f1931h;

        /* renamed from: i, reason: collision with root package name */
        boolean f1932i;

        /* renamed from: j, reason: collision with root package name */
        boolean f1933j;

        /* renamed from: k, reason: collision with root package name */
        boolean f1934k;

        /* loaded from: classes.dex */
        static class a implements Parcelable.Creator<e> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public e createFromParcel(Parcel parcel) {
                return new e(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public e[] newArray(int i4) {
                return new e[i4];
            }
        }

        public e() {
        }

        e(Parcel parcel) {
            this.f1925b = parcel.readInt();
            this.f1926c = parcel.readInt();
            int readInt = parcel.readInt();
            this.f1927d = readInt;
            if (readInt > 0) {
                int[] iArr = new int[readInt];
                this.f1928e = iArr;
                parcel.readIntArray(iArr);
            }
            int readInt2 = parcel.readInt();
            this.f1929f = readInt2;
            if (readInt2 > 0) {
                int[] iArr2 = new int[readInt2];
                this.f1930g = iArr2;
                parcel.readIntArray(iArr2);
            }
            this.f1932i = parcel.readInt() == 1;
            this.f1933j = parcel.readInt() == 1;
            this.f1934k = parcel.readInt() == 1;
            this.f1931h = parcel.readArrayList(d.a.class.getClassLoader());
        }

        public e(e eVar) {
            this.f1927d = eVar.f1927d;
            this.f1925b = eVar.f1925b;
            this.f1926c = eVar.f1926c;
            this.f1928e = eVar.f1928e;
            this.f1929f = eVar.f1929f;
            this.f1930g = eVar.f1930g;
            this.f1932i = eVar.f1932i;
            this.f1933j = eVar.f1933j;
            this.f1934k = eVar.f1934k;
            this.f1931h = eVar.f1931h;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        void f() {
            this.f1928e = null;
            this.f1927d = 0;
            this.f1925b = -1;
            this.f1926c = -1;
        }

        void g() {
            this.f1928e = null;
            this.f1927d = 0;
            this.f1929f = 0;
            this.f1930g = null;
            this.f1931h = null;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            parcel.writeInt(this.f1925b);
            parcel.writeInt(this.f1926c);
            parcel.writeInt(this.f1927d);
            if (this.f1927d > 0) {
                parcel.writeIntArray(this.f1928e);
            }
            parcel.writeInt(this.f1929f);
            if (this.f1929f > 0) {
                parcel.writeIntArray(this.f1930g);
            }
            parcel.writeInt(this.f1932i ? 1 : 0);
            parcel.writeInt(this.f1933j ? 1 : 0);
            parcel.writeInt(this.f1934k ? 1 : 0);
            parcel.writeList(this.f1931h);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f {

        /* renamed from: a, reason: collision with root package name */
        ArrayList<View> f1935a = new ArrayList<>();

        /* renamed from: b, reason: collision with root package name */
        int f1936b = RecyclerView.UNDEFINED_DURATION;

        /* renamed from: c, reason: collision with root package name */
        int f1937c = RecyclerView.UNDEFINED_DURATION;

        /* renamed from: d, reason: collision with root package name */
        int f1938d = 0;

        /* renamed from: e, reason: collision with root package name */
        final int f1939e;

        f(int i4) {
            this.f1939e = i4;
        }

        void a(View view) {
            c n4 = n(view);
            n4.f1917e = this;
            this.f1935a.add(view);
            this.f1937c = RecyclerView.UNDEFINED_DURATION;
            if (this.f1935a.size() == 1) {
                this.f1936b = RecyclerView.UNDEFINED_DURATION;
            }
            if (n4.c() || n4.b()) {
                this.f1938d += StaggeredGridLayoutManager.this.f1903u.e(view);
            }
        }

        void b(boolean z4, int i4) {
            int l4 = z4 ? l(RecyclerView.UNDEFINED_DURATION) : p(RecyclerView.UNDEFINED_DURATION);
            e();
            if (l4 == Integer.MIN_VALUE) {
                return;
            }
            if (!z4 || l4 >= StaggeredGridLayoutManager.this.f1903u.i()) {
                if (z4 || l4 <= StaggeredGridLayoutManager.this.f1903u.m()) {
                    if (i4 != Integer.MIN_VALUE) {
                        l4 += i4;
                    }
                    this.f1937c = l4;
                    this.f1936b = l4;
                }
            }
        }

        void c() {
            d.a f4;
            ArrayList<View> arrayList = this.f1935a;
            View view = arrayList.get(arrayList.size() - 1);
            c n4 = n(view);
            this.f1937c = StaggeredGridLayoutManager.this.f1903u.d(view);
            if (n4.f1918f && (f4 = StaggeredGridLayoutManager.this.E.f(n4.a())) != null && f4.f1922c == 1) {
                this.f1937c += f4.f(this.f1939e);
            }
        }

        void d() {
            d.a f4;
            View view = this.f1935a.get(0);
            c n4 = n(view);
            this.f1936b = StaggeredGridLayoutManager.this.f1903u.g(view);
            if (n4.f1918f && (f4 = StaggeredGridLayoutManager.this.E.f(n4.a())) != null && f4.f1922c == -1) {
                this.f1936b -= f4.f(this.f1939e);
            }
        }

        void e() {
            this.f1935a.clear();
            q();
            this.f1938d = 0;
        }

        public int f() {
            int i4;
            int size;
            if (StaggeredGridLayoutManager.this.f1908z) {
                i4 = this.f1935a.size() - 1;
                size = -1;
            } else {
                i4 = 0;
                size = this.f1935a.size();
            }
            return i(i4, size, true);
        }

        public int g() {
            int size;
            int i4;
            if (StaggeredGridLayoutManager.this.f1908z) {
                size = 0;
                i4 = this.f1935a.size();
            } else {
                size = this.f1935a.size() - 1;
                i4 = -1;
            }
            return i(size, i4, true);
        }

        int h(int i4, int i5, boolean z4, boolean z5, boolean z6) {
            int m4 = StaggeredGridLayoutManager.this.f1903u.m();
            int i6 = StaggeredGridLayoutManager.this.f1903u.i();
            int i7 = i5 > i4 ? 1 : -1;
            while (i4 != i5) {
                View view = this.f1935a.get(i4);
                int g4 = StaggeredGridLayoutManager.this.f1903u.g(view);
                int d5 = StaggeredGridLayoutManager.this.f1903u.d(view);
                boolean z7 = false;
                boolean z8 = !z6 ? g4 >= i6 : g4 > i6;
                if (!z6 ? d5 > m4 : d5 >= m4) {
                    z7 = true;
                }
                if (z8 && z7) {
                    if (!z4 || !z5) {
                        if (!z5 && g4 >= m4 && d5 <= i6) {
                        }
                        return StaggeredGridLayoutManager.this.h0(view);
                    }
                    if (g4 >= m4 && d5 <= i6) {
                        return StaggeredGridLayoutManager.this.h0(view);
                    }
                }
                i4 += i7;
            }
            return -1;
        }

        int i(int i4, int i5, boolean z4) {
            return h(i4, i5, false, false, z4);
        }

        public int j() {
            return this.f1938d;
        }

        int k() {
            int i4 = this.f1937c;
            if (i4 != Integer.MIN_VALUE) {
                return i4;
            }
            c();
            return this.f1937c;
        }

        int l(int i4) {
            int i5 = this.f1937c;
            if (i5 != Integer.MIN_VALUE) {
                return i5;
            }
            if (this.f1935a.size() == 0) {
                return i4;
            }
            c();
            return this.f1937c;
        }

        public View m(int i4, int i5) {
            View view = null;
            if (i5 != -1) {
                int size = this.f1935a.size() - 1;
                while (size >= 0) {
                    View view2 = this.f1935a.get(size);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.f1908z && staggeredGridLayoutManager.h0(view2) >= i4) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.f1908z && staggeredGridLayoutManager2.h0(view2) <= i4) || !view2.hasFocusable()) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = this.f1935a.size();
                int i6 = 0;
                while (i6 < size2) {
                    View view3 = this.f1935a.get(i6);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.f1908z && staggeredGridLayoutManager3.h0(view3) <= i4) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.f1908z && staggeredGridLayoutManager4.h0(view3) >= i4) || !view3.hasFocusable()) {
                        break;
                    }
                    i6++;
                    view = view3;
                }
            }
            return view;
        }

        c n(View view) {
            return (c) view.getLayoutParams();
        }

        int o() {
            int i4 = this.f1936b;
            if (i4 != Integer.MIN_VALUE) {
                return i4;
            }
            d();
            return this.f1936b;
        }

        int p(int i4) {
            int i5 = this.f1936b;
            if (i5 != Integer.MIN_VALUE) {
                return i5;
            }
            if (this.f1935a.size() == 0) {
                return i4;
            }
            d();
            return this.f1936b;
        }

        void q() {
            this.f1936b = RecyclerView.UNDEFINED_DURATION;
            this.f1937c = RecyclerView.UNDEFINED_DURATION;
        }

        void r(int i4) {
            int i5 = this.f1936b;
            if (i5 != Integer.MIN_VALUE) {
                this.f1936b = i5 + i4;
            }
            int i6 = this.f1937c;
            if (i6 != Integer.MIN_VALUE) {
                this.f1937c = i6 + i4;
            }
        }

        void s() {
            int size = this.f1935a.size();
            View remove = this.f1935a.remove(size - 1);
            c n4 = n(remove);
            n4.f1917e = null;
            if (n4.c() || n4.b()) {
                this.f1938d -= StaggeredGridLayoutManager.this.f1903u.e(remove);
            }
            if (size == 1) {
                this.f1936b = RecyclerView.UNDEFINED_DURATION;
            }
            this.f1937c = RecyclerView.UNDEFINED_DURATION;
        }

        void t() {
            View remove = this.f1935a.remove(0);
            c n4 = n(remove);
            n4.f1917e = null;
            if (this.f1935a.size() == 0) {
                this.f1937c = RecyclerView.UNDEFINED_DURATION;
            }
            if (n4.c() || n4.b()) {
                this.f1938d -= StaggeredGridLayoutManager.this.f1903u.e(remove);
            }
            this.f1936b = RecyclerView.UNDEFINED_DURATION;
        }

        void u(View view) {
            c n4 = n(view);
            n4.f1917e = this;
            this.f1935a.add(0, view);
            this.f1936b = RecyclerView.UNDEFINED_DURATION;
            if (this.f1935a.size() == 1) {
                this.f1937c = RecyclerView.UNDEFINED_DURATION;
            }
            if (n4.c() || n4.b()) {
                this.f1938d += StaggeredGridLayoutManager.this.f1903u.e(view);
            }
        }

        void v(int i4) {
            this.f1936b = i4;
            this.f1937c = i4;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i4, int i5) {
        RecyclerView.o.d i02 = RecyclerView.o.i0(context, attributeSet, i4, i5);
        H2(i02.f1862a);
        J2(i02.f1863b);
        I2(i02.f1864c);
        this.f1907y = new androidx.recyclerview.widget.f();
        a2();
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0010, code lost:
    
        if (r4.f2059e == (-1)) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void A2(androidx.recyclerview.widget.RecyclerView.v r3, androidx.recyclerview.widget.f r4) {
        /*
            r2 = this;
            boolean r0 = r4.f2055a
            if (r0 == 0) goto L4d
            boolean r0 = r4.f2063i
            if (r0 == 0) goto L9
            goto L4d
        L9:
            int r0 = r4.f2056b
            r1 = -1
            if (r0 != 0) goto L1e
            int r0 = r4.f2059e
            if (r0 != r1) goto L18
        L12:
            int r4 = r4.f2061g
        L14:
            r2.B2(r3, r4)
            goto L4d
        L18:
            int r4 = r4.f2060f
        L1a:
            r2.C2(r3, r4)
            goto L4d
        L1e:
            int r0 = r4.f2059e
            if (r0 != r1) goto L37
            int r0 = r4.f2060f
            int r1 = r2.m2(r0)
            int r0 = r0 - r1
            if (r0 >= 0) goto L2c
            goto L12
        L2c:
            int r1 = r4.f2061g
            int r4 = r4.f2056b
            int r4 = java.lang.Math.min(r0, r4)
            int r4 = r1 - r4
            goto L14
        L37:
            int r0 = r4.f2061g
            int r0 = r2.n2(r0)
            int r1 = r4.f2061g
            int r0 = r0 - r1
            if (r0 >= 0) goto L43
            goto L18
        L43:
            int r1 = r4.f2060f
            int r4 = r4.f2056b
            int r4 = java.lang.Math.min(r0, r4)
            int r4 = r4 + r1
            goto L1a
        L4d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.A2(androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.f):void");
    }

    private void B2(RecyclerView.v vVar, int i4) {
        for (int J = J() - 1; J >= 0; J--) {
            View I = I(J);
            if (this.f1903u.g(I) < i4 || this.f1903u.q(I) < i4) {
                return;
            }
            c cVar = (c) I.getLayoutParams();
            if (cVar.f1918f) {
                for (int i5 = 0; i5 < this.f1901s; i5++) {
                    if (this.f1902t[i5].f1935a.size() == 1) {
                        return;
                    }
                }
                for (int i6 = 0; i6 < this.f1901s; i6++) {
                    this.f1902t[i6].s();
                }
            } else if (cVar.f1917e.f1935a.size() == 1) {
                return;
            } else {
                cVar.f1917e.s();
            }
            m1(I, vVar);
        }
    }

    private void C2(RecyclerView.v vVar, int i4) {
        while (J() > 0) {
            View I = I(0);
            if (this.f1903u.d(I) > i4 || this.f1903u.p(I) > i4) {
                return;
            }
            c cVar = (c) I.getLayoutParams();
            if (cVar.f1918f) {
                for (int i5 = 0; i5 < this.f1901s; i5++) {
                    if (this.f1902t[i5].f1935a.size() == 1) {
                        return;
                    }
                }
                for (int i6 = 0; i6 < this.f1901s; i6++) {
                    this.f1902t[i6].t();
                }
            } else if (cVar.f1917e.f1935a.size() == 1) {
                return;
            } else {
                cVar.f1917e.t();
            }
            m1(I, vVar);
        }
    }

    private void D2() {
        if (this.f1904v.k() == 1073741824) {
            return;
        }
        float f4 = 0.0f;
        int J = J();
        for (int i4 = 0; i4 < J; i4++) {
            View I = I(i4);
            float e4 = this.f1904v.e(I);
            if (e4 >= f4) {
                if (((c) I.getLayoutParams()).f()) {
                    e4 = (e4 * 1.0f) / this.f1901s;
                }
                f4 = Math.max(f4, e4);
            }
        }
        int i5 = this.f1906x;
        int round = Math.round(f4 * this.f1901s);
        if (this.f1904v.k() == Integer.MIN_VALUE) {
            round = Math.min(round, this.f1904v.n());
        }
        P2(round);
        if (this.f1906x == i5) {
            return;
        }
        for (int i6 = 0; i6 < J; i6++) {
            View I2 = I(i6);
            c cVar = (c) I2.getLayoutParams();
            if (!cVar.f1918f) {
                if (t2() && this.f1905w == 1) {
                    int i7 = this.f1901s;
                    int i8 = cVar.f1917e.f1939e;
                    I2.offsetLeftAndRight(((-((i7 - 1) - i8)) * this.f1906x) - ((-((i7 - 1) - i8)) * i5));
                } else {
                    int i9 = cVar.f1917e.f1939e;
                    int i10 = this.f1905w;
                    int i11 = (this.f1906x * i9) - (i9 * i5);
                    if (i10 == 1) {
                        I2.offsetLeftAndRight(i11);
                    } else {
                        I2.offsetTopAndBottom(i11);
                    }
                }
            }
        }
    }

    private void E2() {
        this.A = (this.f1905w == 1 || !t2()) ? this.f1908z : !this.f1908z;
    }

    private void G2(int i4) {
        androidx.recyclerview.widget.f fVar = this.f1907y;
        fVar.f2059e = i4;
        fVar.f2058d = this.A != (i4 == -1) ? -1 : 1;
    }

    private void K2(int i4, int i5) {
        for (int i6 = 0; i6 < this.f1901s; i6++) {
            if (!this.f1902t[i6].f1935a.isEmpty()) {
                Q2(this.f1902t[i6], i4, i5);
            }
        }
    }

    private boolean L2(RecyclerView.a0 a0Var, b bVar) {
        boolean z4 = this.G;
        int b5 = a0Var.b();
        bVar.f1910a = z4 ? g2(b5) : c2(b5);
        bVar.f1911b = RecyclerView.UNDEFINED_DURATION;
        return true;
    }

    private void M1(View view) {
        for (int i4 = this.f1901s - 1; i4 >= 0; i4--) {
            this.f1902t[i4].a(view);
        }
    }

    private void N1(b bVar) {
        boolean z4;
        e eVar = this.I;
        int i4 = eVar.f1927d;
        if (i4 > 0) {
            if (i4 == this.f1901s) {
                for (int i5 = 0; i5 < this.f1901s; i5++) {
                    this.f1902t[i5].e();
                    e eVar2 = this.I;
                    int i6 = eVar2.f1928e[i5];
                    if (i6 != Integer.MIN_VALUE) {
                        i6 += eVar2.f1933j ? this.f1903u.i() : this.f1903u.m();
                    }
                    this.f1902t[i5].v(i6);
                }
            } else {
                eVar.g();
                e eVar3 = this.I;
                eVar3.f1925b = eVar3.f1926c;
            }
        }
        e eVar4 = this.I;
        this.H = eVar4.f1934k;
        I2(eVar4.f1932i);
        E2();
        e eVar5 = this.I;
        int i7 = eVar5.f1925b;
        if (i7 != -1) {
            this.C = i7;
            z4 = eVar5.f1933j;
        } else {
            z4 = this.A;
        }
        bVar.f1912c = z4;
        if (eVar5.f1929f > 1) {
            d dVar = this.E;
            dVar.f1919a = eVar5.f1930g;
            dVar.f1920b = eVar5.f1931h;
        }
    }

    private void O2(int i4, RecyclerView.a0 a0Var) {
        int i5;
        int i6;
        int c5;
        androidx.recyclerview.widget.f fVar = this.f1907y;
        boolean z4 = false;
        fVar.f2056b = 0;
        fVar.f2057c = i4;
        if (!x0() || (c5 = a0Var.c()) == -1) {
            i5 = 0;
            i6 = 0;
        } else {
            if (this.A == (c5 < i4)) {
                i5 = this.f1903u.n();
                i6 = 0;
            } else {
                i6 = this.f1903u.n();
                i5 = 0;
            }
        }
        if (M()) {
            this.f1907y.f2060f = this.f1903u.m() - i6;
            this.f1907y.f2061g = this.f1903u.i() + i5;
        } else {
            this.f1907y.f2061g = this.f1903u.h() + i5;
            this.f1907y.f2060f = -i6;
        }
        androidx.recyclerview.widget.f fVar2 = this.f1907y;
        fVar2.f2062h = false;
        fVar2.f2055a = true;
        if (this.f1903u.k() == 0 && this.f1903u.h() == 0) {
            z4 = true;
        }
        fVar2.f2063i = z4;
    }

    private void Q1(View view, c cVar, androidx.recyclerview.widget.f fVar) {
        if (fVar.f2059e == 1) {
            if (cVar.f1918f) {
                M1(view);
                return;
            } else {
                cVar.f1917e.a(view);
                return;
            }
        }
        if (cVar.f1918f) {
            z2(view);
        } else {
            cVar.f1917e.u(view);
        }
    }

    private void Q2(f fVar, int i4, int i5) {
        int j4 = fVar.j();
        if (i4 == -1) {
            if (fVar.o() + j4 > i5) {
                return;
            }
        } else if (fVar.k() - j4 < i5) {
            return;
        }
        this.B.set(fVar.f1939e, false);
    }

    private int R1(int i4) {
        if (J() == 0) {
            return this.A ? 1 : -1;
        }
        return (i4 < j2()) != this.A ? -1 : 1;
    }

    private int R2(int i4, int i5, int i6) {
        if (i5 == 0 && i6 == 0) {
            return i4;
        }
        int mode = View.MeasureSpec.getMode(i4);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i4) - i5) - i6), mode) : i4;
    }

    private boolean T1(f fVar) {
        if (this.A) {
            if (fVar.k() < this.f1903u.i()) {
                ArrayList<View> arrayList = fVar.f1935a;
                return !fVar.n(arrayList.get(arrayList.size() - 1)).f1918f;
            }
        } else if (fVar.o() > this.f1903u.m()) {
            return !fVar.n(fVar.f1935a.get(0)).f1918f;
        }
        return false;
    }

    private int U1(RecyclerView.a0 a0Var) {
        if (J() == 0) {
            return 0;
        }
        return l.a(a0Var, this.f1903u, e2(!this.N), d2(!this.N), this, this.N);
    }

    private int V1(RecyclerView.a0 a0Var) {
        if (J() == 0) {
            return 0;
        }
        return l.b(a0Var, this.f1903u, e2(!this.N), d2(!this.N), this, this.N, this.A);
    }

    private int W1(RecyclerView.a0 a0Var) {
        if (J() == 0) {
            return 0;
        }
        return l.c(a0Var, this.f1903u, e2(!this.N), d2(!this.N), this, this.N);
    }

    private int X1(int i4) {
        if (i4 == 1) {
            return (this.f1905w != 1 && t2()) ? 1 : -1;
        }
        if (i4 == 2) {
            return (this.f1905w != 1 && t2()) ? -1 : 1;
        }
        if (i4 == 17) {
            if (this.f1905w == 0) {
                return -1;
            }
            return RecyclerView.UNDEFINED_DURATION;
        }
        if (i4 == 33) {
            if (this.f1905w == 1) {
                return -1;
            }
            return RecyclerView.UNDEFINED_DURATION;
        }
        if (i4 == 66) {
            if (this.f1905w == 0) {
                return 1;
            }
            return RecyclerView.UNDEFINED_DURATION;
        }
        if (i4 == 130 && this.f1905w == 1) {
            return 1;
        }
        return RecyclerView.UNDEFINED_DURATION;
    }

    private d.a Y1(int i4) {
        d.a aVar = new d.a();
        aVar.f1923d = new int[this.f1901s];
        for (int i5 = 0; i5 < this.f1901s; i5++) {
            aVar.f1923d[i5] = i4 - this.f1902t[i5].l(i4);
        }
        return aVar;
    }

    private d.a Z1(int i4) {
        d.a aVar = new d.a();
        aVar.f1923d = new int[this.f1901s];
        for (int i5 = 0; i5 < this.f1901s; i5++) {
            aVar.f1923d[i5] = this.f1902t[i5].p(i4) - i4;
        }
        return aVar;
    }

    private void a2() {
        this.f1903u = j.b(this, this.f1905w);
        this.f1904v = j.b(this, 1 - this.f1905w);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r9v7 */
    private int b2(RecyclerView.v vVar, androidx.recyclerview.widget.f fVar, RecyclerView.a0 a0Var) {
        f fVar2;
        int e4;
        int i4;
        int i5;
        int e5;
        RecyclerView.o oVar;
        View view;
        int i6;
        int i7;
        boolean z4;
        ?? r9 = 0;
        this.B.set(0, this.f1901s, true);
        int i8 = this.f1907y.f2063i ? fVar.f2059e == 1 ? Integer.MAX_VALUE : RecyclerView.UNDEFINED_DURATION : fVar.f2059e == 1 ? fVar.f2061g + fVar.f2056b : fVar.f2060f - fVar.f2056b;
        K2(fVar.f2059e, i8);
        int i9 = this.A ? this.f1903u.i() : this.f1903u.m();
        boolean z5 = false;
        while (fVar.a(a0Var) && (this.f1907y.f2063i || !this.B.isEmpty())) {
            View b5 = fVar.b(vVar);
            c cVar = (c) b5.getLayoutParams();
            int a5 = cVar.a();
            int g4 = this.E.g(a5);
            boolean z6 = g4 == -1 ? true : r9;
            if (z6) {
                fVar2 = cVar.f1918f ? this.f1902t[r9] : p2(fVar);
                this.E.n(a5, fVar2);
            } else {
                fVar2 = this.f1902t[g4];
            }
            f fVar3 = fVar2;
            cVar.f1917e = fVar3;
            if (fVar.f2059e == 1) {
                d(b5);
            } else {
                e(b5, r9);
            }
            v2(b5, cVar, r9);
            if (fVar.f2059e == 1) {
                int l22 = cVar.f1918f ? l2(i9) : fVar3.l(i9);
                int e6 = this.f1903u.e(b5) + l22;
                if (z6 && cVar.f1918f) {
                    d.a Y1 = Y1(l22);
                    Y1.f1922c = -1;
                    Y1.f1921b = a5;
                    this.E.a(Y1);
                }
                i4 = e6;
                e4 = l22;
            } else {
                int o22 = cVar.f1918f ? o2(i9) : fVar3.p(i9);
                e4 = o22 - this.f1903u.e(b5);
                if (z6 && cVar.f1918f) {
                    d.a Z1 = Z1(o22);
                    Z1.f1922c = 1;
                    Z1.f1921b = a5;
                    this.E.a(Z1);
                }
                i4 = o22;
            }
            if (cVar.f1918f && fVar.f2058d == -1) {
                if (!z6) {
                    if (!(fVar.f2059e == 1 ? O1() : P1())) {
                        d.a f4 = this.E.f(a5);
                        if (f4 != null) {
                            f4.f1924e = true;
                        }
                    }
                }
                this.M = true;
            }
            Q1(b5, cVar, fVar);
            if (t2() && this.f1905w == 1) {
                int i10 = cVar.f1918f ? this.f1904v.i() : this.f1904v.i() - (((this.f1901s - 1) - fVar3.f1939e) * this.f1906x);
                e5 = i10;
                i5 = i10 - this.f1904v.e(b5);
            } else {
                int m4 = cVar.f1918f ? this.f1904v.m() : (fVar3.f1939e * this.f1906x) + this.f1904v.m();
                i5 = m4;
                e5 = this.f1904v.e(b5) + m4;
            }
            if (this.f1905w == 1) {
                oVar = this;
                view = b5;
                i6 = i5;
                i5 = e4;
                i7 = e5;
            } else {
                oVar = this;
                view = b5;
                i6 = e4;
                i7 = i4;
                i4 = e5;
            }
            oVar.z0(view, i6, i5, i7, i4);
            if (cVar.f1918f) {
                K2(this.f1907y.f2059e, i8);
            } else {
                Q2(fVar3, this.f1907y.f2059e, i8);
            }
            A2(vVar, this.f1907y);
            if (this.f1907y.f2062h && b5.hasFocusable()) {
                if (cVar.f1918f) {
                    this.B.clear();
                } else {
                    z4 = false;
                    this.B.set(fVar3.f1939e, false);
                    r9 = z4;
                    z5 = true;
                }
            }
            z4 = false;
            r9 = z4;
            z5 = true;
        }
        int i11 = r9;
        if (!z5) {
            A2(vVar, this.f1907y);
        }
        int m5 = this.f1907y.f2059e == -1 ? this.f1903u.m() - o2(this.f1903u.m()) : l2(this.f1903u.i()) - this.f1903u.i();
        return m5 > 0 ? Math.min(fVar.f2056b, m5) : i11;
    }

    private int c2(int i4) {
        int J = J();
        for (int i5 = 0; i5 < J; i5++) {
            int h02 = h0(I(i5));
            if (h02 >= 0 && h02 < i4) {
                return h02;
            }
        }
        return 0;
    }

    private int g2(int i4) {
        for (int J = J() - 1; J >= 0; J--) {
            int h02 = h0(I(J));
            if (h02 >= 0 && h02 < i4) {
                return h02;
            }
        }
        return 0;
    }

    private void h2(RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z4) {
        int i4;
        int l22 = l2(RecyclerView.UNDEFINED_DURATION);
        if (l22 != Integer.MIN_VALUE && (i4 = this.f1903u.i() - l22) > 0) {
            int i5 = i4 - (-F2(-i4, vVar, a0Var));
            if (!z4 || i5 <= 0) {
                return;
            }
            this.f1903u.r(i5);
        }
    }

    private void i2(RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z4) {
        int m4;
        int o22 = o2(Integer.MAX_VALUE);
        if (o22 != Integer.MAX_VALUE && (m4 = o22 - this.f1903u.m()) > 0) {
            int F2 = m4 - F2(m4, vVar, a0Var);
            if (!z4 || F2 <= 0) {
                return;
            }
            this.f1903u.r(-F2);
        }
    }

    private int l2(int i4) {
        int l4 = this.f1902t[0].l(i4);
        for (int i5 = 1; i5 < this.f1901s; i5++) {
            int l5 = this.f1902t[i5].l(i4);
            if (l5 > l4) {
                l4 = l5;
            }
        }
        return l4;
    }

    private int m2(int i4) {
        int p4 = this.f1902t[0].p(i4);
        for (int i5 = 1; i5 < this.f1901s; i5++) {
            int p5 = this.f1902t[i5].p(i4);
            if (p5 > p4) {
                p4 = p5;
            }
        }
        return p4;
    }

    private int n2(int i4) {
        int l4 = this.f1902t[0].l(i4);
        for (int i5 = 1; i5 < this.f1901s; i5++) {
            int l5 = this.f1902t[i5].l(i4);
            if (l5 < l4) {
                l4 = l5;
            }
        }
        return l4;
    }

    private int o2(int i4) {
        int p4 = this.f1902t[0].p(i4);
        for (int i5 = 1; i5 < this.f1901s; i5++) {
            int p5 = this.f1902t[i5].p(i4);
            if (p5 < p4) {
                p4 = p5;
            }
        }
        return p4;
    }

    private f p2(androidx.recyclerview.widget.f fVar) {
        int i4;
        int i5;
        int i6 = -1;
        if (x2(fVar.f2059e)) {
            i4 = this.f1901s - 1;
            i5 = -1;
        } else {
            i4 = 0;
            i6 = this.f1901s;
            i5 = 1;
        }
        f fVar2 = null;
        if (fVar.f2059e == 1) {
            int i7 = Integer.MAX_VALUE;
            int m4 = this.f1903u.m();
            while (i4 != i6) {
                f fVar3 = this.f1902t[i4];
                int l4 = fVar3.l(m4);
                if (l4 < i7) {
                    fVar2 = fVar3;
                    i7 = l4;
                }
                i4 += i5;
            }
            return fVar2;
        }
        int i8 = RecyclerView.UNDEFINED_DURATION;
        int i9 = this.f1903u.i();
        while (i4 != i6) {
            f fVar4 = this.f1902t[i4];
            int p4 = fVar4.p(i9);
            if (p4 > i8) {
                fVar2 = fVar4;
                i8 = p4;
            }
            i4 += i5;
        }
        return fVar2;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0043 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void q2(int r7, int r8, int r9) {
        /*
            r6 = this;
            boolean r0 = r6.A
            if (r0 == 0) goto L9
            int r0 = r6.k2()
            goto Ld
        L9:
            int r0 = r6.j2()
        Ld:
            r1 = 8
            if (r9 != r1) goto L1a
            if (r7 >= r8) goto L16
            int r2 = r8 + 1
            goto L1c
        L16:
            int r2 = r7 + 1
            r3 = r8
            goto L1d
        L1a:
            int r2 = r7 + r8
        L1c:
            r3 = r7
        L1d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r4 = r6.E
            r4.h(r3)
            r4 = 1
            if (r9 == r4) goto L3c
            r5 = 2
            if (r9 == r5) goto L36
            if (r9 == r1) goto L2b
            goto L41
        L2b:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r6.E
            r9.k(r7, r4)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r7 = r6.E
            r7.j(r8, r4)
            goto L41
        L36:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r6.E
            r9.k(r7, r8)
            goto L41
        L3c:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r6.E
            r9.j(r7, r8)
        L41:
            if (r2 > r0) goto L44
            return
        L44:
            boolean r7 = r6.A
            if (r7 == 0) goto L4d
            int r7 = r6.j2()
            goto L51
        L4d:
            int r7 = r6.k2()
        L51:
            if (r3 > r7) goto L56
            r6.t1()
        L56:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.q2(int, int, int):void");
    }

    private void u2(View view, int i4, int i5, boolean z4) {
        j(view, this.K);
        c cVar = (c) view.getLayoutParams();
        int i6 = ((ViewGroup.MarginLayoutParams) cVar).leftMargin;
        Rect rect = this.K;
        int R2 = R2(i4, i6 + rect.left, ((ViewGroup.MarginLayoutParams) cVar).rightMargin + rect.right);
        int i7 = ((ViewGroup.MarginLayoutParams) cVar).topMargin;
        Rect rect2 = this.K;
        int R22 = R2(i5, i7 + rect2.top, ((ViewGroup.MarginLayoutParams) cVar).bottomMargin + rect2.bottom);
        if (z4 ? H1(view, R2, R22, cVar) : F1(view, R2, R22, cVar)) {
            view.measure(R2, R22);
        }
    }

    private void v2(View view, c cVar, boolean z4) {
        int K;
        int K2;
        if (cVar.f1918f) {
            if (this.f1905w != 1) {
                u2(view, RecyclerView.o.K(o0(), p0(), e0() + f0(), ((ViewGroup.MarginLayoutParams) cVar).width, true), this.J, z4);
                return;
            }
            K = this.J;
        } else {
            if (this.f1905w != 1) {
                K = RecyclerView.o.K(o0(), p0(), e0() + f0(), ((ViewGroup.MarginLayoutParams) cVar).width, true);
                K2 = RecyclerView.o.K(this.f1906x, X(), 0, ((ViewGroup.MarginLayoutParams) cVar).height, false);
                u2(view, K, K2, z4);
            }
            K = RecyclerView.o.K(this.f1906x, p0(), 0, ((ViewGroup.MarginLayoutParams) cVar).width, false);
        }
        K2 = RecyclerView.o.K(W(), X(), g0() + d0(), ((ViewGroup.MarginLayoutParams) cVar).height, true);
        u2(view, K, K2, z4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:82:0x014b, code lost:
    
        if (S1() != false) goto L90;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void w2(androidx.recyclerview.widget.RecyclerView.v r9, androidx.recyclerview.widget.RecyclerView.a0 r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 367
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.w2(androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$a0, boolean):void");
    }

    private boolean x2(int i4) {
        if (this.f1905w == 0) {
            return (i4 == -1) != this.A;
        }
        return ((i4 == -1) == this.A) == t2();
    }

    private void z2(View view) {
        for (int i4 = this.f1901s - 1; i4 >= 0; i4--) {
            this.f1902t[i4].u(view);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void C0(int i4) {
        super.C0(i4);
        for (int i5 = 0; i5 < this.f1901s; i5++) {
            this.f1902t[i5].r(i4);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void C1(Rect rect, int i4, int i5) {
        int n4;
        int n5;
        int e02 = e0() + f0();
        int g02 = g0() + d0();
        if (this.f1905w == 1) {
            n5 = RecyclerView.o.n(i5, rect.height() + g02, b0());
            n4 = RecyclerView.o.n(i4, (this.f1906x * this.f1901s) + e02, c0());
        } else {
            n4 = RecyclerView.o.n(i4, rect.width() + e02, c0());
            n5 = RecyclerView.o.n(i5, (this.f1906x * this.f1901s) + g02, b0());
        }
        B1(n4, n5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p D() {
        return this.f1905w == 0 ? new c(-2, -1) : new c(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void D0(int i4) {
        super.D0(i4);
        for (int i5 = 0; i5 < this.f1901s; i5++) {
            this.f1902t[i5].r(i4);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p E(Context context, AttributeSet attributeSet) {
        return new c(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p F(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new c((ViewGroup.MarginLayoutParams) layoutParams) : new c(layoutParams);
    }

    int F2(int i4, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (J() == 0 || i4 == 0) {
            return 0;
        }
        y2(i4, a0Var);
        int b22 = b2(vVar, this.f1907y, a0Var);
        if (this.f1907y.f2056b >= b22) {
            i4 = i4 < 0 ? -b22 : b22;
        }
        this.f1903u.r(-i4);
        this.G = this.A;
        androidx.recyclerview.widget.f fVar = this.f1907y;
        fVar.f2056b = 0;
        A2(vVar, fVar);
        return i4;
    }

    public void H2(int i4) {
        if (i4 != 0 && i4 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        g(null);
        if (i4 == this.f1905w) {
            return;
        }
        this.f1905w = i4;
        j jVar = this.f1903u;
        this.f1903u = this.f1904v;
        this.f1904v = jVar;
        t1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void I0(RecyclerView recyclerView, RecyclerView.v vVar) {
        super.I0(recyclerView, vVar);
        o1(this.P);
        for (int i4 = 0; i4 < this.f1901s; i4++) {
            this.f1902t[i4].e();
        }
        recyclerView.requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void I1(RecyclerView recyclerView, RecyclerView.a0 a0Var, int i4) {
        g gVar = new g(recyclerView.getContext());
        gVar.p(i4);
        J1(gVar);
    }

    public void I2(boolean z4) {
        g(null);
        e eVar = this.I;
        if (eVar != null && eVar.f1932i != z4) {
            eVar.f1932i = z4;
        }
        this.f1908z = z4;
        t1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View J0(View view, int i4, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        View B;
        View m4;
        if (J() == 0 || (B = B(view)) == null) {
            return null;
        }
        E2();
        int X1 = X1(i4);
        if (X1 == Integer.MIN_VALUE) {
            return null;
        }
        c cVar = (c) B.getLayoutParams();
        boolean z4 = cVar.f1918f;
        f fVar = cVar.f1917e;
        int k22 = X1 == 1 ? k2() : j2();
        O2(k22, a0Var);
        G2(X1);
        androidx.recyclerview.widget.f fVar2 = this.f1907y;
        fVar2.f2057c = fVar2.f2058d + k22;
        fVar2.f2056b = (int) (this.f1903u.n() * 0.33333334f);
        androidx.recyclerview.widget.f fVar3 = this.f1907y;
        fVar3.f2062h = true;
        fVar3.f2055a = false;
        b2(vVar, fVar3, a0Var);
        this.G = this.A;
        if (!z4 && (m4 = fVar.m(k22, X1)) != null && m4 != B) {
            return m4;
        }
        if (x2(X1)) {
            for (int i5 = this.f1901s - 1; i5 >= 0; i5--) {
                View m5 = this.f1902t[i5].m(k22, X1);
                if (m5 != null && m5 != B) {
                    return m5;
                }
            }
        } else {
            for (int i6 = 0; i6 < this.f1901s; i6++) {
                View m6 = this.f1902t[i6].m(k22, X1);
                if (m6 != null && m6 != B) {
                    return m6;
                }
            }
        }
        boolean z5 = (this.f1908z ^ true) == (X1 == -1);
        if (!z4) {
            View C = C(z5 ? fVar.f() : fVar.g());
            if (C != null && C != B) {
                return C;
            }
        }
        if (x2(X1)) {
            for (int i7 = this.f1901s - 1; i7 >= 0; i7--) {
                if (i7 != fVar.f1939e) {
                    f[] fVarArr = this.f1902t;
                    View C2 = C(z5 ? fVarArr[i7].f() : fVarArr[i7].g());
                    if (C2 != null && C2 != B) {
                        return C2;
                    }
                }
            }
        } else {
            for (int i8 = 0; i8 < this.f1901s; i8++) {
                f[] fVarArr2 = this.f1902t;
                View C3 = C(z5 ? fVarArr2[i8].f() : fVarArr2[i8].g());
                if (C3 != null && C3 != B) {
                    return C3;
                }
            }
        }
        return null;
    }

    public void J2(int i4) {
        g(null);
        if (i4 != this.f1901s) {
            s2();
            this.f1901s = i4;
            this.B = new BitSet(this.f1901s);
            this.f1902t = new f[this.f1901s];
            for (int i5 = 0; i5 < this.f1901s; i5++) {
                this.f1902t[i5] = new f(i5);
            }
            t1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void K0(AccessibilityEvent accessibilityEvent) {
        super.K0(accessibilityEvent);
        if (J() > 0) {
            View e22 = e2(false);
            View d22 = d2(false);
            if (e22 == null || d22 == null) {
                return;
            }
            int h02 = h0(e22);
            int h03 = h0(d22);
            if (h02 < h03) {
                accessibilityEvent.setFromIndex(h02);
                accessibilityEvent.setToIndex(h03);
            } else {
                accessibilityEvent.setFromIndex(h03);
                accessibilityEvent.setToIndex(h02);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean L1() {
        return this.I == null;
    }

    boolean M2(RecyclerView.a0 a0Var, b bVar) {
        int i4;
        int m4;
        int g4;
        if (!a0Var.e() && (i4 = this.C) != -1) {
            if (i4 >= 0 && i4 < a0Var.b()) {
                e eVar = this.I;
                if (eVar == null || eVar.f1925b == -1 || eVar.f1927d < 1) {
                    View C = C(this.C);
                    if (C != null) {
                        bVar.f1910a = this.A ? k2() : j2();
                        if (this.D != Integer.MIN_VALUE) {
                            if (bVar.f1912c) {
                                m4 = this.f1903u.i() - this.D;
                                g4 = this.f1903u.d(C);
                            } else {
                                m4 = this.f1903u.m() + this.D;
                                g4 = this.f1903u.g(C);
                            }
                            bVar.f1911b = m4 - g4;
                            return true;
                        }
                        if (this.f1903u.e(C) > this.f1903u.n()) {
                            bVar.f1911b = bVar.f1912c ? this.f1903u.i() : this.f1903u.m();
                            return true;
                        }
                        int g5 = this.f1903u.g(C) - this.f1903u.m();
                        if (g5 < 0) {
                            bVar.f1911b = -g5;
                            return true;
                        }
                        int i5 = this.f1903u.i() - this.f1903u.d(C);
                        if (i5 < 0) {
                            bVar.f1911b = i5;
                            return true;
                        }
                        bVar.f1911b = RecyclerView.UNDEFINED_DURATION;
                    } else {
                        int i6 = this.C;
                        bVar.f1910a = i6;
                        int i7 = this.D;
                        if (i7 == Integer.MIN_VALUE) {
                            bVar.f1912c = R1(i6) == 1;
                            bVar.a();
                        } else {
                            bVar.b(i7);
                        }
                        bVar.f1913d = true;
                    }
                } else {
                    bVar.f1911b = RecyclerView.UNDEFINED_DURATION;
                    bVar.f1910a = this.C;
                }
                return true;
            }
            this.C = -1;
            this.D = RecyclerView.UNDEFINED_DURATION;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int N(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return this.f1905w == 1 ? this.f1901s : super.N(vVar, a0Var);
    }

    void N2(RecyclerView.a0 a0Var, b bVar) {
        if (M2(a0Var, bVar) || L2(a0Var, bVar)) {
            return;
        }
        bVar.a();
        bVar.f1910a = 0;
    }

    boolean O1() {
        int l4 = this.f1902t[0].l(RecyclerView.UNDEFINED_DURATION);
        for (int i4 = 1; i4 < this.f1901s; i4++) {
            if (this.f1902t[i4].l(RecyclerView.UNDEFINED_DURATION) != l4) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void P0(RecyclerView.v vVar, RecyclerView.a0 a0Var, View view, z.c cVar) {
        int i4;
        int i5;
        int e4;
        int i6;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof c)) {
            super.O0(view, cVar);
            return;
        }
        c cVar2 = (c) layoutParams;
        if (this.f1905w == 0) {
            i4 = cVar2.e();
            i5 = cVar2.f1918f ? this.f1901s : 1;
            e4 = -1;
            i6 = -1;
        } else {
            i4 = -1;
            i5 = -1;
            e4 = cVar2.e();
            i6 = cVar2.f1918f ? this.f1901s : 1;
        }
        cVar.Z(c.C0097c.a(i4, i5, e4, i6, false, false));
    }

    boolean P1() {
        int p4 = this.f1902t[0].p(RecyclerView.UNDEFINED_DURATION);
        for (int i4 = 1; i4 < this.f1901s; i4++) {
            if (this.f1902t[i4].p(RecyclerView.UNDEFINED_DURATION) != p4) {
                return false;
            }
        }
        return true;
    }

    void P2(int i4) {
        this.f1906x = i4 / this.f1901s;
        this.J = View.MeasureSpec.makeMeasureSpec(i4, this.f1904v.k());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void R0(RecyclerView recyclerView, int i4, int i5) {
        q2(i4, i5, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void S0(RecyclerView recyclerView) {
        this.E.b();
        t1();
    }

    boolean S1() {
        int j22;
        int k22;
        if (J() == 0 || this.F == 0 || !r0()) {
            return false;
        }
        if (this.A) {
            j22 = k2();
            k22 = j2();
        } else {
            j22 = j2();
            k22 = k2();
        }
        if (j22 == 0 && r2() != null) {
            this.E.b();
        } else {
            if (!this.M) {
                return false;
            }
            int i4 = this.A ? -1 : 1;
            int i5 = k22 + 1;
            d.a e4 = this.E.e(j22, i5, i4, true);
            if (e4 == null) {
                this.M = false;
                this.E.d(i5);
                return false;
            }
            d.a e5 = this.E.e(j22, e4.f1921b, i4 * (-1), true);
            if (e5 == null) {
                this.E.d(e4.f1921b);
            } else {
                this.E.d(e5.f1921b + 1);
            }
        }
        u1();
        t1();
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void T0(RecyclerView recyclerView, int i4, int i5, int i6) {
        q2(i4, i5, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void U0(RecyclerView recyclerView, int i4, int i5) {
        q2(i4, i5, 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void W0(RecyclerView recyclerView, int i4, int i5, Object obj) {
        q2(i4, i5, 4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void X0(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        w2(vVar, a0Var, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void Y0(RecyclerView.a0 a0Var) {
        super.Y0(a0Var);
        this.C = -1;
        this.D = RecyclerView.UNDEFINED_DURATION;
        this.I = null;
        this.L.c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.z.b
    public PointF a(int i4) {
        int R1 = R1(i4);
        PointF pointF = new PointF();
        if (R1 == 0) {
            return null;
        }
        if (this.f1905w == 0) {
            pointF.x = R1;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = R1;
        }
        return pointF;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void c1(Parcelable parcelable) {
        if (parcelable instanceof e) {
            this.I = (e) parcelable;
            t1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public Parcelable d1() {
        int p4;
        int m4;
        int[] iArr;
        if (this.I != null) {
            return new e(this.I);
        }
        e eVar = new e();
        eVar.f1932i = this.f1908z;
        eVar.f1933j = this.G;
        eVar.f1934k = this.H;
        d dVar = this.E;
        if (dVar == null || (iArr = dVar.f1919a) == null) {
            eVar.f1929f = 0;
        } else {
            eVar.f1930g = iArr;
            eVar.f1929f = iArr.length;
            eVar.f1931h = dVar.f1920b;
        }
        if (J() > 0) {
            eVar.f1925b = this.G ? k2() : j2();
            eVar.f1926c = f2();
            int i4 = this.f1901s;
            eVar.f1927d = i4;
            eVar.f1928e = new int[i4];
            for (int i5 = 0; i5 < this.f1901s; i5++) {
                if (this.G) {
                    p4 = this.f1902t[i5].l(RecyclerView.UNDEFINED_DURATION);
                    if (p4 != Integer.MIN_VALUE) {
                        m4 = this.f1903u.i();
                        p4 -= m4;
                        eVar.f1928e[i5] = p4;
                    } else {
                        eVar.f1928e[i5] = p4;
                    }
                } else {
                    p4 = this.f1902t[i5].p(RecyclerView.UNDEFINED_DURATION);
                    if (p4 != Integer.MIN_VALUE) {
                        m4 = this.f1903u.m();
                        p4 -= m4;
                        eVar.f1928e[i5] = p4;
                    } else {
                        eVar.f1928e[i5] = p4;
                    }
                }
            }
        } else {
            eVar.f1925b = -1;
            eVar.f1926c = -1;
            eVar.f1927d = 0;
        }
        return eVar;
    }

    View d2(boolean z4) {
        int m4 = this.f1903u.m();
        int i4 = this.f1903u.i();
        View view = null;
        for (int J = J() - 1; J >= 0; J--) {
            View I = I(J);
            int g4 = this.f1903u.g(I);
            int d5 = this.f1903u.d(I);
            if (d5 > m4 && g4 < i4) {
                if (d5 <= i4 || !z4) {
                    return I;
                }
                if (view == null) {
                    view = I;
                }
            }
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void e1(int i4) {
        if (i4 == 0) {
            S1();
        }
    }

    View e2(boolean z4) {
        int m4 = this.f1903u.m();
        int i4 = this.f1903u.i();
        int J = J();
        View view = null;
        for (int i5 = 0; i5 < J; i5++) {
            View I = I(i5);
            int g4 = this.f1903u.g(I);
            if (this.f1903u.d(I) > m4 && g4 < i4) {
                if (g4 >= m4 || !z4) {
                    return I;
                }
                if (view == null) {
                    view = I;
                }
            }
        }
        return view;
    }

    int f2() {
        View d22 = this.A ? d2(true) : e2(true);
        if (d22 == null) {
            return -1;
        }
        return h0(d22);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void g(String str) {
        if (this.I == null) {
            super.g(str);
        }
    }

    int j2() {
        if (J() == 0) {
            return 0;
        }
        return h0(I(0));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean k() {
        return this.f1905w == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int k0(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return this.f1905w == 0 ? this.f1901s : super.k0(vVar, a0Var);
    }

    int k2() {
        int J = J();
        if (J == 0) {
            return 0;
        }
        return h0(I(J - 1));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean l() {
        return this.f1905w == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean m(RecyclerView.p pVar) {
        return pVar instanceof c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void o(int i4, int i5, RecyclerView.a0 a0Var, RecyclerView.o.c cVar) {
        int l4;
        int i6;
        if (this.f1905w != 0) {
            i4 = i5;
        }
        if (J() == 0 || i4 == 0) {
            return;
        }
        y2(i4, a0Var);
        int[] iArr = this.O;
        if (iArr == null || iArr.length < this.f1901s) {
            this.O = new int[this.f1901s];
        }
        int i7 = 0;
        for (int i8 = 0; i8 < this.f1901s; i8++) {
            androidx.recyclerview.widget.f fVar = this.f1907y;
            if (fVar.f2058d == -1) {
                l4 = fVar.f2060f;
                i6 = this.f1902t[i8].p(l4);
            } else {
                l4 = this.f1902t[i8].l(fVar.f2061g);
                i6 = this.f1907y.f2061g;
            }
            int i9 = l4 - i6;
            if (i9 >= 0) {
                this.O[i7] = i9;
                i7++;
            }
        }
        Arrays.sort(this.O, 0, i7);
        for (int i10 = 0; i10 < i7 && this.f1907y.a(a0Var); i10++) {
            cVar.a(this.f1907y.f2057c, this.O[i10]);
            androidx.recyclerview.widget.f fVar2 = this.f1907y;
            fVar2.f2057c += fVar2.f2058d;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int q(RecyclerView.a0 a0Var) {
        return U1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int r(RecyclerView.a0 a0Var) {
        return V1(a0Var);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0074, code lost:
    
        if (r10 == r11) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x008a, code lost:
    
        r10 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0088, code lost:
    
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0086, code lost:
    
        if (r10 == r11) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    android.view.View r2() {
        /*
            r12 = this;
            int r0 = r12.J()
            r1 = 1
            int r0 = r0 - r1
            java.util.BitSet r2 = new java.util.BitSet
            int r3 = r12.f1901s
            r2.<init>(r3)
            int r3 = r12.f1901s
            r4 = 0
            r2.set(r4, r3, r1)
            int r3 = r12.f1905w
            r5 = -1
            if (r3 != r1) goto L20
            boolean r3 = r12.t2()
            if (r3 == 0) goto L20
            r3 = r1
            goto L21
        L20:
            r3 = r5
        L21:
            boolean r6 = r12.A
            if (r6 == 0) goto L27
            r6 = r5
            goto L2b
        L27:
            int r0 = r0 + 1
            r6 = r0
            r0 = r4
        L2b:
            if (r0 >= r6) goto L2e
            r5 = r1
        L2e:
            if (r0 == r6) goto Lab
            android.view.View r7 = r12.I(r0)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r8 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.c) r8
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r9 = r8.f1917e
            int r9 = r9.f1939e
            boolean r9 = r2.get(r9)
            if (r9 == 0) goto L54
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r9 = r8.f1917e
            boolean r9 = r12.T1(r9)
            if (r9 == 0) goto L4d
            return r7
        L4d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r9 = r8.f1917e
            int r9 = r9.f1939e
            r2.clear(r9)
        L54:
            boolean r9 = r8.f1918f
            if (r9 == 0) goto L59
            goto La9
        L59:
            int r9 = r0 + r5
            if (r9 == r6) goto La9
            android.view.View r9 = r12.I(r9)
            boolean r10 = r12.A
            if (r10 == 0) goto L77
            androidx.recyclerview.widget.j r10 = r12.f1903u
            int r10 = r10.d(r7)
            androidx.recyclerview.widget.j r11 = r12.f1903u
            int r11 = r11.d(r9)
            if (r10 >= r11) goto L74
            return r7
        L74:
            if (r10 != r11) goto L8a
            goto L88
        L77:
            androidx.recyclerview.widget.j r10 = r12.f1903u
            int r10 = r10.g(r7)
            androidx.recyclerview.widget.j r11 = r12.f1903u
            int r11 = r11.g(r9)
            if (r10 <= r11) goto L86
            return r7
        L86:
            if (r10 != r11) goto L8a
        L88:
            r10 = r1
            goto L8b
        L8a:
            r10 = r4
        L8b:
            if (r10 == 0) goto La9
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.c) r9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r8 = r8.f1917e
            int r8 = r8.f1939e
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r9 = r9.f1917e
            int r9 = r9.f1939e
            int r8 = r8 - r9
            if (r8 >= 0) goto La0
            r8 = r1
            goto La1
        La0:
            r8 = r4
        La1:
            if (r3 >= 0) goto La5
            r9 = r1
            goto La6
        La5:
            r9 = r4
        La6:
            if (r8 == r9) goto La9
            return r7
        La9:
            int r0 = r0 + r5
            goto L2e
        Lab:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.r2():android.view.View");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int s(RecyclerView.a0 a0Var) {
        return W1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean s0() {
        return this.F != 0;
    }

    public void s2() {
        this.E.b();
        t1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int t(RecyclerView.a0 a0Var) {
        return U1(a0Var);
    }

    boolean t2() {
        return Z() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int u(RecyclerView.a0 a0Var) {
        return V1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int v(RecyclerView.a0 a0Var) {
        return W1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int w1(int i4, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return F2(i4, vVar, a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void x1(int i4) {
        e eVar = this.I;
        if (eVar != null && eVar.f1925b != i4) {
            eVar.f();
        }
        this.C = i4;
        this.D = RecyclerView.UNDEFINED_DURATION;
        t1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int y1(int i4, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return F2(i4, vVar, a0Var);
    }

    void y2(int i4, RecyclerView.a0 a0Var) {
        int i5;
        int j22;
        if (i4 > 0) {
            j22 = k2();
            i5 = 1;
        } else {
            i5 = -1;
            j22 = j2();
        }
        this.f1907y.f2055a = true;
        O2(j22, a0Var);
        G2(i5);
        androidx.recyclerview.widget.f fVar = this.f1907y;
        fVar.f2057c = j22 + fVar.f2058d;
        fVar.f2056b = Math.abs(i4);
    }
}
