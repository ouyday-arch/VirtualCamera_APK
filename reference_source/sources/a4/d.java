package a4;

import b4.i0;
import e3.f;
import j3.u;
import j3.v;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import m3.i;
import v2.o;
import v2.w;

/* loaded from: classes.dex */
public final class d implements HostnameVerifier {

    /* renamed from: a, reason: collision with root package name */
    public static final d f310a = new d();

    private d() {
    }

    private final String b(String str) {
        if (!d(str)) {
            return str;
        }
        Locale locale = Locale.US;
        f.d(locale, "US");
        String lowerCase = str.toLowerCase(locale);
        f.d(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    private final List<String> c(X509Certificate x509Certificate, int i4) {
        List<String> i5;
        Object obj;
        List<String> i6;
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                i6 = o.i();
                return i6;
            }
            ArrayList arrayList = new ArrayList();
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && f.a(list.get(0), Integer.valueOf(i4)) && (obj = list.get(1)) != null) {
                    arrayList.add((String) obj);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            i5 = o.i();
            return i5;
        }
    }

    private final boolean d(String str) {
        return str.length() == ((int) i0.b(str, 0, 0, 3, null));
    }

    private final boolean f(String str, String str2) {
        boolean x4;
        boolean k4;
        boolean x5;
        boolean k5;
        boolean k6;
        boolean k7;
        String str3;
        boolean C;
        boolean x6;
        int M;
        boolean k8;
        int R;
        String str4 = str;
        if (!(str4 == null || str.length() == 0)) {
            x4 = u.x(str4, ".", false, 2, null);
            if (!x4) {
                k4 = u.k(str4, "..", false, 2, null);
                if (!k4) {
                    if (!(str2 == null || str2.length() == 0)) {
                        x5 = u.x(str2, ".", false, 2, null);
                        if (!x5) {
                            k5 = u.k(str2, "..", false, 2, null);
                            if (!k5) {
                                k6 = u.k(str4, ".", false, 2, null);
                                if (!k6) {
                                    str4 = str4 + '.';
                                }
                                String str5 = str4;
                                k7 = u.k(str2, ".", false, 2, null);
                                if (k7) {
                                    str3 = str2;
                                } else {
                                    str3 = str2 + '.';
                                }
                                String b5 = b(str3);
                                C = v.C(b5, "*", false, 2, null);
                                if (!C) {
                                    return f.a(str5, b5);
                                }
                                x6 = u.x(b5, "*.", false, 2, null);
                                if (x6) {
                                    M = v.M(b5, '*', 1, false, 4, null);
                                    if (M != -1 || str5.length() < b5.length() || f.a("*.", b5)) {
                                        return false;
                                    }
                                    String substring = b5.substring(1);
                                    f.d(substring, "substring(...)");
                                    k8 = u.k(str5, substring, false, 2, null);
                                    if (!k8) {
                                        return false;
                                    }
                                    int length = str5.length() - substring.length();
                                    if (length > 0) {
                                        R = v.R(str5, '.', length - 1, false, 4, null);
                                        if (R != -1) {
                                            return false;
                                        }
                                    }
                                    return true;
                                }
                                return false;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return false;
    }

    private final boolean g(String str, X509Certificate x509Certificate) {
        String b5 = b(str);
        List<String> c5 = c(x509Certificate, 2);
        if ((c5 instanceof Collection) && c5.isEmpty()) {
            return false;
        }
        Iterator<T> it = c5.iterator();
        while (it.hasNext()) {
            if (f310a.f(b5, (String) it.next())) {
                return true;
            }
        }
        return false;
    }

    private final boolean h(String str, X509Certificate x509Certificate) {
        String k4 = i.k(str);
        List<String> c5 = c(x509Certificate, 7);
        if ((c5 instanceof Collection) && c5.isEmpty()) {
            return false;
        }
        Iterator<T> it = c5.iterator();
        while (it.hasNext()) {
            if (f.a(k4, i.k((String) it.next()))) {
                return true;
            }
        }
        return false;
    }

    public final List<String> a(X509Certificate x509Certificate) {
        List<String> G;
        f.e(x509Certificate, "certificate");
        G = w.G(c(x509Certificate, 7), c(x509Certificate, 2));
        return G;
    }

    public final boolean e(String str, X509Certificate x509Certificate) {
        f.e(str, "host");
        f.e(x509Certificate, "certificate");
        return i.a(str) ? h(str, x509Certificate) : g(str, x509Certificate);
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        Certificate certificate;
        f.e(str, "host");
        f.e(sSLSession, "session");
        if (d(str)) {
            try {
                certificate = sSLSession.getPeerCertificates()[0];
                f.c(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            } catch (SSLException unused) {
                return false;
            }
        }
        return e(str, (X509Certificate) certificate);
    }
}
