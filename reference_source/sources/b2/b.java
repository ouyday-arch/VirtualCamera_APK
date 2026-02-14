package b2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    private final Map<Integer, Integer> f2256a = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] a() {
        ArrayList arrayList = new ArrayList();
        int i4 = -1;
        for (Map.Entry<Integer, Integer> entry : this.f2256a.entrySet()) {
            if (entry.getValue().intValue() > i4) {
                i4 = entry.getValue().intValue();
                arrayList.clear();
            } else if (entry.getValue().intValue() == i4) {
            }
            arrayList.add(entry.getKey());
        }
        return a2.a.b(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i4) {
        Integer num = this.f2256a.get(Integer.valueOf(i4));
        if (num == null) {
            num = 0;
        }
        this.f2256a.put(Integer.valueOf(i4), Integer.valueOf(num.intValue() + 1));
    }
}
