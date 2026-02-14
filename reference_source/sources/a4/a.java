package a4;

import e3.f;
import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

/* loaded from: classes.dex */
public final class a extends c {

    /* renamed from: c, reason: collision with root package name */
    public static final C0002a f306c = new C0002a(null);

    /* renamed from: b, reason: collision with root package name */
    private final e f307b;

    /* renamed from: a4.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0002a {
        private C0002a() {
        }

        public /* synthetic */ C0002a(e3.d dVar) {
            this();
        }
    }

    public a(e eVar) {
        f.e(eVar, "trustRootIndex");
        this.f307b = eVar;
    }

    private final boolean b(X509Certificate x509Certificate, X509Certificate x509Certificate2, int i4) {
        if (!f.a(x509Certificate.getIssuerDN(), x509Certificate2.getSubjectDN()) || x509Certificate2.getBasicConstraints() < i4) {
            return false;
        }
        try {
            x509Certificate.verify(x509Certificate2.getPublicKey());
            return true;
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }

    @Override // a4.c
    public List<Certificate> a(List<? extends Certificate> list, String str) {
        f.e(list, "chain");
        f.e(str, "hostname");
        ArrayDeque arrayDeque = new ArrayDeque(list);
        ArrayList arrayList = new ArrayList();
        Object removeFirst = arrayDeque.removeFirst();
        f.d(removeFirst, "removeFirst(...)");
        arrayList.add(removeFirst);
        boolean z4 = false;
        for (int i4 = 0; i4 < 9; i4++) {
            Object obj = arrayList.get(arrayList.size() - 1);
            f.c(obj, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            X509Certificate x509Certificate = (X509Certificate) obj;
            X509Certificate a5 = this.f307b.a(x509Certificate);
            if (a5 == null) {
                Iterator it = arrayDeque.iterator();
                f.d(it, "iterator(...)");
                while (it.hasNext()) {
                    Object next = it.next();
                    f.c(next, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                    X509Certificate x509Certificate2 = (X509Certificate) next;
                    if (b(x509Certificate, x509Certificate2, arrayList.size() - 1)) {
                        it.remove();
                        arrayList.add(x509Certificate2);
                    }
                }
                if (z4) {
                    return arrayList;
                }
                throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + x509Certificate);
            }
            if (arrayList.size() > 1 || !f.a(x509Certificate, a5)) {
                arrayList.add(a5);
            }
            if (b(a5, a5, arrayList.size() - 2)) {
                return arrayList;
            }
            z4 = true;
        }
        throw new SSLPeerUnverifiedException("Certificate chain too long: " + arrayList);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof a) && f.a(((a) obj).f307b, this.f307b);
    }

    public int hashCode() {
        return this.f307b.hashCode();
    }
}
