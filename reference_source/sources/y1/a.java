package y1;

import java.util.List;

/* loaded from: classes.dex */
final class a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static n1.a a(List<b> list) {
        int size = (list.size() << 1) - 1;
        if (list.get(list.size() - 1).c() == null) {
            size--;
        }
        n1.a aVar = new n1.a(size * 12);
        int i4 = 0;
        int b5 = list.get(0).c().b();
        for (int i5 = 11; i5 >= 0; i5--) {
            if (((1 << i5) & b5) != 0) {
                aVar.q(i4);
            }
            i4++;
        }
        for (int i6 = 1; i6 < list.size(); i6++) {
            b bVar = list.get(i6);
            int b6 = bVar.b().b();
            for (int i7 = 11; i7 >= 0; i7--) {
                if (((1 << i7) & b6) != 0) {
                    aVar.q(i4);
                }
                i4++;
            }
            if (bVar.c() != null) {
                int b7 = bVar.c().b();
                for (int i8 = 11; i8 >= 0; i8--) {
                    if (((1 << i8) & b7) != 0) {
                        aVar.q(i4);
                    }
                    i4++;
                }
            }
        }
        return aVar;
    }
}
