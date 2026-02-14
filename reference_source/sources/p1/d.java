package p1;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final a f5430a;

    /* renamed from: b, reason: collision with root package name */
    private final List<b> f5431b;

    public d(a aVar) {
        this.f5430a = aVar;
        ArrayList arrayList = new ArrayList();
        this.f5431b = arrayList;
        arrayList.add(new b(aVar, new int[]{1}));
    }

    private b a(int i4) {
        if (i4 >= this.f5431b.size()) {
            List<b> list = this.f5431b;
            b bVar = list.get(list.size() - 1);
            for (int size = this.f5431b.size(); size <= i4; size++) {
                a aVar = this.f5430a;
                bVar = bVar.i(new b(aVar, new int[]{1, aVar.c((size - 1) + aVar.d())}));
                this.f5431b.add(bVar);
            }
        }
        return this.f5431b.get(i4);
    }

    public void b(int[] iArr, int i4) {
        if (i4 == 0) {
            throw new IllegalArgumentException("No error correction bytes");
        }
        int length = iArr.length - i4;
        if (length <= 0) {
            throw new IllegalArgumentException("No data bytes provided");
        }
        b a5 = a(i4);
        int[] iArr2 = new int[length];
        System.arraycopy(iArr, 0, iArr2, 0, length);
        int[] e4 = new b(this.f5430a, iArr2).j(i4, 1).b(a5)[1].e();
        int length2 = i4 - e4.length;
        for (int i5 = 0; i5 < length2; i5++) {
            iArr[length + i5] = 0;
        }
        System.arraycopy(e4, 0, iArr, length + length2, e4.length);
    }
}
