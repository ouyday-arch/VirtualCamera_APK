package l3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/* loaded from: classes.dex */
public interface r {

    /* renamed from: a, reason: collision with root package name */
    public static final a f4781a = a.f4783a;

    /* renamed from: b, reason: collision with root package name */
    public static final r f4782b = new a.C0058a();

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f4783a = new a();

        /* renamed from: l3.r$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static final class C0058a implements r {
            @Override // l3.r
            public List<InetAddress> a(String str) {
                List<InetAddress> w4;
                e3.f.e(str, "hostname");
                try {
                    InetAddress[] allByName = InetAddress.getAllByName(str);
                    e3.f.d(allByName, "getAllByName(...)");
                    w4 = v2.j.w(allByName);
                    return w4;
                } catch (NullPointerException e4) {
                    UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of " + str);
                    unknownHostException.initCause(e4);
                    throw unknownHostException;
                }
            }
        }

        private a() {
        }
    }

    List<InetAddress> a(String str);
}
