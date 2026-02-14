package i3;

import j3.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import v2.n;
import v2.o;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends h {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes.dex */
    public static final class a<T> implements Iterable<T>, f3.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f4148b;

        public a(c cVar) {
            this.f4148b = cVar;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return this.f4148b.iterator();
        }
    }

    public static <T> Iterable<T> a(c<? extends T> cVar) {
        e3.f.e(cVar, "<this>");
        return new a(cVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> c<T> b(c<? extends T> cVar, int i4) {
        e3.f.e(cVar, "<this>");
        if (i4 >= 0) {
            return i4 == 0 ? cVar : cVar instanceof b ? ((b) cVar).a(i4) : new i3.a(cVar, i4);
        }
        throw new IllegalArgumentException(("Requested element count " + i4 + " is less than zero.").toString());
    }

    public static final <T, A extends Appendable> A c(c<? extends T> cVar, A a5, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i4, CharSequence charSequence4, d3.b<? super T, ? extends CharSequence> bVar) {
        e3.f.e(cVar, "<this>");
        e3.f.e(a5, "buffer");
        e3.f.e(charSequence, "separator");
        e3.f.e(charSequence2, "prefix");
        e3.f.e(charSequence3, "postfix");
        e3.f.e(charSequence4, "truncated");
        a5.append(charSequence2);
        int i5 = 0;
        for (T t4 : cVar) {
            i5++;
            if (i5 > 1) {
                a5.append(charSequence);
            }
            if (i4 >= 0 && i5 > i4) {
                break;
            }
            m.a(a5, t4, bVar);
        }
        if (i4 >= 0 && i5 > i4) {
            a5.append(charSequence4);
        }
        a5.append(charSequence3);
        return a5;
    }

    public static final <T> String d(c<? extends T> cVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i4, CharSequence charSequence4, d3.b<? super T, ? extends CharSequence> bVar) {
        e3.f.e(cVar, "<this>");
        e3.f.e(charSequence, "separator");
        e3.f.e(charSequence2, "prefix");
        e3.f.e(charSequence3, "postfix");
        e3.f.e(charSequence4, "truncated");
        String sb = ((StringBuilder) c(cVar, new StringBuilder(), charSequence, charSequence2, charSequence3, i4, charSequence4, bVar)).toString();
        e3.f.d(sb, "toString(...)");
        return sb;
    }

    public static /* synthetic */ String e(c cVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i4, CharSequence charSequence4, d3.b bVar, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i5 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i5 & 4) == 0 ? charSequence3 : "";
        if ((i5 & 8) != 0) {
            i4 = -1;
        }
        int i6 = i4;
        if ((i5 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i5 & 32) != 0) {
            bVar = null;
        }
        return d(cVar, charSequence, charSequence5, charSequence6, i6, charSequence7, bVar);
    }

    public static <T, R> c<R> f(c<? extends T> cVar, d3.b<? super T, ? extends R> bVar) {
        e3.f.e(cVar, "<this>");
        e3.f.e(bVar, "transform");
        return new j(cVar, bVar);
    }

    public static <T> List<T> g(c<? extends T> cVar) {
        List<T> d5;
        List<T> i4;
        e3.f.e(cVar, "<this>");
        Iterator<? extends T> it = cVar.iterator();
        if (!it.hasNext()) {
            i4 = o.i();
            return i4;
        }
        T next = it.next();
        if (!it.hasNext()) {
            d5 = n.d(next);
            return d5;
        }
        ArrayList arrayList = new ArrayList();
        while (true) {
            arrayList.add(next);
            if (!it.hasNext()) {
                return arrayList;
            }
            next = it.next();
        }
    }
}
