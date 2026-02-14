package androidx.recyclerview.widget;

import androidx.recyclerview.widget.a;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    final a f2074a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void a(a.b bVar);

        a.b b(int i4, int i5, int i6, Object obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar) {
        this.f2074a = aVar;
    }

    private int a(List<a.b> list) {
        boolean z4 = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).f1949a != 8) {
                z4 = true;
            } else if (z4) {
                return size;
            }
        }
        return -1;
    }

    private void c(List<a.b> list, int i4, a.b bVar, int i5, a.b bVar2) {
        int i6 = bVar.f1952d;
        int i7 = bVar2.f1950b;
        int i8 = i6 < i7 ? -1 : 0;
        int i9 = bVar.f1950b;
        if (i9 < i7) {
            i8++;
        }
        if (i7 <= i9) {
            bVar.f1950b = i9 + bVar2.f1952d;
        }
        int i10 = bVar2.f1950b;
        if (i10 <= i6) {
            bVar.f1952d = i6 + bVar2.f1952d;
        }
        bVar2.f1950b = i10 + i8;
        list.set(i4, bVar2);
        list.set(i5, bVar);
    }

    private void d(List<a.b> list, int i4, int i5) {
        a.b bVar = list.get(i4);
        a.b bVar2 = list.get(i5);
        int i6 = bVar2.f1949a;
        if (i6 == 1) {
            c(list, i4, bVar, i5, bVar2);
        } else if (i6 == 2) {
            e(list, i4, bVar, i5, bVar2);
        } else {
            if (i6 != 4) {
                return;
            }
            f(list, i4, bVar, i5, bVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(List<a.b> list) {
        while (true) {
            int a5 = a(list);
            if (a5 == -1) {
                return;
            } else {
                d(list, a5, a5 + 1);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x009e, code lost:
    
        if (r0 > r14.f1950b) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00ca, code lost:
    
        r12.f1952d = r0 - r14.f1952d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00c8, code lost:
    
        if (r0 >= r14.f1950b) goto L59;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void e(java.util.List<androidx.recyclerview.widget.a.b> r10, int r11, androidx.recyclerview.widget.a.b r12, int r13, androidx.recyclerview.widget.a.b r14) {
        /*
            Method dump skipped, instructions count: 229
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.i.e(java.util.List, int, androidx.recyclerview.widget.a$b, int, androidx.recyclerview.widget.a$b):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void f(java.util.List<androidx.recyclerview.widget.a.b> r9, int r10, androidx.recyclerview.widget.a.b r11, int r12, androidx.recyclerview.widget.a.b r13) {
        /*
            r8 = this;
            int r0 = r11.f1952d
            int r1 = r13.f1950b
            r2 = 4
            r3 = 0
            r4 = 1
            if (r0 >= r1) goto Ld
            int r1 = r1 - r4
            r13.f1950b = r1
            goto L20
        Ld:
            int r5 = r13.f1952d
            int r1 = r1 + r5
            if (r0 >= r1) goto L20
            int r5 = r5 - r4
            r13.f1952d = r5
            androidx.recyclerview.widget.i$a r0 = r8.f2074a
            int r1 = r11.f1950b
            java.lang.Object r5 = r13.f1951c
            androidx.recyclerview.widget.a$b r0 = r0.b(r2, r1, r4, r5)
            goto L21
        L20:
            r0 = r3
        L21:
            int r1 = r11.f1950b
            int r5 = r13.f1950b
            if (r1 > r5) goto L2b
            int r5 = r5 + r4
            r13.f1950b = r5
            goto L41
        L2b:
            int r6 = r13.f1952d
            int r7 = r5 + r6
            if (r1 >= r7) goto L41
            int r5 = r5 + r6
            int r5 = r5 - r1
            androidx.recyclerview.widget.i$a r3 = r8.f2074a
            int r1 = r1 + r4
            java.lang.Object r4 = r13.f1951c
            androidx.recyclerview.widget.a$b r3 = r3.b(r2, r1, r5, r4)
            int r1 = r13.f1952d
            int r1 = r1 - r5
            r13.f1952d = r1
        L41:
            r9.set(r12, r11)
            int r11 = r13.f1952d
            if (r11 <= 0) goto L4c
            r9.set(r10, r13)
            goto L54
        L4c:
            r9.remove(r10)
            androidx.recyclerview.widget.i$a r11 = r8.f2074a
            r11.a(r13)
        L54:
            if (r0 == 0) goto L59
            r9.add(r10, r0)
        L59:
            if (r3 == 0) goto L5e
            r9.add(r10, r3)
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.i.f(java.util.List, int, androidx.recyclerview.widget.a$b, int, androidx.recyclerview.widget.a$b):void");
    }
}
