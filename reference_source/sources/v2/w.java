package v2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: classes.dex */
public class w extends v {

    /* loaded from: classes.dex */
    public static final class a<T> implements i3.c<T> {

        /* renamed from: a */
        final /* synthetic */ Iterable f6295a;

        public a(Iterable iterable) {
            this.f6295a = iterable;
        }

        @Override // i3.c
        public Iterator<T> iterator() {
            return this.f6295a.iterator();
        }
    }

    public static <T> T A(List<? extends T> list) {
        e3.f.e(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    public static final <T, A extends Appendable> A B(Iterable<? extends T> iterable, A a5, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i4, CharSequence charSequence4, d3.b<? super T, ? extends CharSequence> bVar) {
        e3.f.e(iterable, "<this>");
        e3.f.e(a5, "buffer");
        e3.f.e(charSequence, "separator");
        e3.f.e(charSequence2, "prefix");
        e3.f.e(charSequence3, "postfix");
        e3.f.e(charSequence4, "truncated");
        a5.append(charSequence2);
        int i5 = 0;
        for (T t4 : iterable) {
            i5++;
            if (i5 > 1) {
                a5.append(charSequence);
            }
            if (i4 >= 0 && i5 > i4) {
                break;
            }
            j3.m.a(a5, t4, bVar);
        }
        if (i4 >= 0 && i5 > i4) {
            a5.append(charSequence4);
        }
        a5.append(charSequence3);
        return a5;
    }

    public static final <T> String D(Iterable<? extends T> iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i4, CharSequence charSequence4, d3.b<? super T, ? extends CharSequence> bVar) {
        e3.f.e(iterable, "<this>");
        e3.f.e(charSequence, "separator");
        e3.f.e(charSequence2, "prefix");
        e3.f.e(charSequence3, "postfix");
        e3.f.e(charSequence4, "truncated");
        String sb = ((StringBuilder) B(iterable, new StringBuilder(), charSequence, charSequence2, charSequence3, i4, charSequence4, bVar)).toString();
        e3.f.d(sb, "toString(...)");
        return sb;
    }

    public static /* synthetic */ String E(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i4, CharSequence charSequence4, d3.b bVar, int i5, Object obj) {
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
        return D(iterable, charSequence, charSequence5, charSequence6, i6, charSequence7, bVar);
    }

    public static <T> T F(List<? extends T> list) {
        int k4;
        e3.f.e(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        k4 = o.k(list);
        return list.get(k4);
    }

    public static <T> List<T> G(Collection<? extends T> collection, Iterable<? extends T> iterable) {
        e3.f.e(collection, "<this>");
        e3.f.e(iterable, "elements");
        if (!(iterable instanceof Collection)) {
            ArrayList arrayList = new ArrayList(collection);
            t.u(arrayList, iterable);
            return arrayList;
        }
        Collection collection2 = (Collection) iterable;
        ArrayList arrayList2 = new ArrayList(collection.size() + collection2.size());
        arrayList2.addAll(collection);
        arrayList2.addAll(collection2);
        return arrayList2;
    }

    public static <T> List<T> H(Collection<? extends T> collection, T t4) {
        e3.f.e(collection, "<this>");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(t4);
        return arrayList;
    }

    public static <T> T I(Iterable<? extends T> iterable) {
        e3.f.e(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) J((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        T next = it.next();
        if (it.hasNext()) {
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        return next;
    }

    public static final <T> T J(List<? extends T> list) {
        e3.f.e(list, "<this>");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        }
        if (size == 1) {
            return list.get(0);
        }
        throw new IllegalArgumentException("List has more than one element.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> List<T> K(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        List<T> c5;
        List<T> N;
        e3.f.e(iterable, "<this>");
        e3.f.e(comparator, "comparator");
        if (!(iterable instanceof Collection)) {
            List<T> O = O(iterable);
            s.t(O, comparator);
            return O;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            N = N(iterable);
            return N;
        }
        Object[] array = collection.toArray(new Object[0]);
        i.m(array, comparator);
        c5 = i.c(array);
        return c5;
    }

    public static final <T> List<T> L(Iterable<? extends T> iterable, int i4) {
        List<T> d5;
        List<T> N;
        List<T> i5;
        e3.f.e(iterable, "<this>");
        int i6 = 0;
        if (!(i4 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i4 + " is less than zero.").toString());
        }
        if (i4 == 0) {
            i5 = o.i();
            return i5;
        }
        if (iterable instanceof Collection) {
            if (i4 >= ((Collection) iterable).size()) {
                N = N(iterable);
                return N;
            }
            if (i4 == 1) {
                d5 = n.d(z(iterable));
                return d5;
            }
        }
        ArrayList arrayList = new ArrayList(i4);
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
            i6++;
            if (i6 == i4) {
                break;
            }
        }
        return o.o(arrayList);
    }

    public static final <T, C extends Collection<? super T>> C M(Iterable<? extends T> iterable, C c5) {
        e3.f.e(iterable, "<this>");
        e3.f.e(c5, "destination");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            c5.add(it.next());
        }
        return c5;
    }

    public static <T> List<T> N(Iterable<? extends T> iterable) {
        List<T> i4;
        List<T> d5;
        List<T> P;
        e3.f.e(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return o.o(O(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            i4 = o.i();
            return i4;
        }
        if (size != 1) {
            P = P(collection);
            return P;
        }
        d5 = n.d(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
        return d5;
    }

    public static final <T> List<T> O(Iterable<? extends T> iterable) {
        List<T> P;
        e3.f.e(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return (List) M(iterable, new ArrayList());
        }
        P = P((Collection) iterable);
        return P;
    }

    public static <T> List<T> P(Collection<? extends T> collection) {
        e3.f.e(collection, "<this>");
        return new ArrayList(collection);
    }

    public static <T> Set<T> Q(Iterable<? extends T> iterable) {
        e3.f.e(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return k0.c((Set) M(iterable, new LinkedHashSet()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return k0.b();
        }
        if (size != 1) {
            return (Set) M(iterable, new LinkedHashSet(f0.a(collection.size())));
        }
        return j0.a(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    public static <T> i3.c<T> x(Iterable<? extends T> iterable) {
        e3.f.e(iterable, "<this>");
        return new a(iterable);
    }

    public static <T> List<T> y(List<? extends T> list, int i4) {
        int b5;
        e3.f.e(list, "<this>");
        if (i4 >= 0) {
            b5 = g3.l.b(list.size() - i4, 0);
            return L(list, b5);
        }
        throw new IllegalArgumentException(("Requested element count " + i4 + " is less than zero.").toString());
    }

    public static final <T> T z(Iterable<? extends T> iterable) {
        Object A;
        e3.f.e(iterable, "<this>");
        if (iterable instanceof List) {
            A = A((List) iterable);
            return (T) A;
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }
}
