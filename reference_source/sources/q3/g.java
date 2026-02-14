package q3;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class g {
    /* JADX WARN: Multi-variable type inference failed */
    public static final List<InetAddress> a(List<? extends InetAddress> list) {
        e3.f.e(list, "addresses");
        if (list.size() < 2) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : list) {
            if (((InetAddress) obj) instanceof Inet6Address) {
                arrayList.add(obj);
            } else {
                arrayList2.add(obj);
            }
        }
        u2.g gVar = new u2.g(arrayList, arrayList2);
        List list2 = (List) gVar.a();
        List list3 = (List) gVar.b();
        return (list2.isEmpty() || list3.isEmpty()) ? list : m3.p.w(list2, list3);
    }
}
