package x1;

import androidx.recyclerview.widget.RecyclerView;
import g1.m;
import w1.r;

/* loaded from: classes.dex */
public abstract class a extends r {

    /* renamed from: b, reason: collision with root package name */
    private final int[] f6471b;

    /* renamed from: e, reason: collision with root package name */
    private final int[] f6474e;

    /* renamed from: f, reason: collision with root package name */
    private final int[] f6475f;

    /* renamed from: a, reason: collision with root package name */
    private final int[] f6470a = new int[4];

    /* renamed from: c, reason: collision with root package name */
    private final float[] f6472c = new float[4];

    /* renamed from: d, reason: collision with root package name */
    private final float[] f6473d = new float[4];

    /* JADX INFO: Access modifiers changed from: protected */
    public a() {
        int[] iArr = new int[8];
        this.f6471b = iArr;
        this.f6474e = new int[iArr.length / 2];
        this.f6475f = new int[iArr.length / 2];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void i(int[] iArr, float[] fArr) {
        int i4 = 0;
        float f4 = fArr[0];
        for (int i5 = 1; i5 < iArr.length; i5++) {
            if (fArr[i5] < f4) {
                f4 = fArr[i5];
                i4 = i5;
            }
        }
        iArr[i4] = iArr[i4] - 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void p(int[] iArr, float[] fArr) {
        int i4 = 0;
        float f4 = fArr[0];
        for (int i5 = 1; i5 < iArr.length; i5++) {
            if (fArr[i5] > f4) {
                f4 = fArr[i5];
                i4 = i5;
            }
        }
        iArr[i4] = iArr[i4] + 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean q(int[] iArr) {
        float f4 = (iArr[0] + iArr[1]) / ((iArr[2] + r1) + iArr[3]);
        if (f4 >= 0.7916667f && f4 <= 0.89285713f) {
            int i4 = Integer.MAX_VALUE;
            int i5 = RecyclerView.UNDEFINED_DURATION;
            for (int i6 : iArr) {
                if (i6 > i5) {
                    i5 = i6;
                }
                if (i6 < i4) {
                    i4 = i6;
                }
            }
            if (i5 < i4 * 10) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int r(int[] iArr, int[][] iArr2) {
        for (int i4 = 0; i4 < iArr2.length; i4++) {
            if (r.f(iArr, iArr2[i4], 0.45f) < 0.2f) {
                return i4;
            }
        }
        throw m.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int[] j() {
        return this.f6471b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int[] k() {
        return this.f6470a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int[] l() {
        return this.f6475f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float[] m() {
        return this.f6473d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int[] n() {
        return this.f6474e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float[] o() {
        return this.f6472c;
    }
}
