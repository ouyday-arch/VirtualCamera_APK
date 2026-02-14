package x3;

import android.util.Log;
import j3.v;
import j3.x;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import java.util.logging.Logger;
import l3.y;
import v2.g0;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f6498a = new c();

    /* renamed from: b, reason: collision with root package name */
    private static final CopyOnWriteArraySet<Logger> f6499b = new CopyOnWriteArraySet<>();

    /* renamed from: c, reason: collision with root package name */
    private static final Map<String, String> f6500c;

    static {
        Map<String, String> f4;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Package r22 = y.class.getPackage();
        String name = r22 != null ? r22.getName() : null;
        if (name != null) {
            linkedHashMap.put(name, "OkHttp");
        }
        String name2 = y.class.getName();
        e3.f.d(name2, "getName(...)");
        linkedHashMap.put(name2, "okhttp.OkHttpClient");
        String name3 = t3.f.class.getName();
        e3.f.d(name3, "getName(...)");
        linkedHashMap.put(name3, "okhttp.Http2");
        String name4 = p3.d.class.getName();
        e3.f.d(name4, "getName(...)");
        linkedHashMap.put(name4, "okhttp.TaskRunner");
        linkedHashMap.put("okhttp3.mockwebserver.MockWebServer", "okhttp.MockWebServer");
        f4 = g0.f(linkedHashMap);
        f6500c = f4;
    }

    private c() {
    }

    private final void c(String str, String str2) {
        Logger logger = Logger.getLogger(str);
        if (f6499b.add(logger)) {
            logger.setUseParentHandlers(false);
            logger.setLevel(Log.isLoggable(str2, 3) ? Level.FINE : Log.isLoggable(str2, 4) ? Level.INFO : Level.WARNING);
            logger.addHandler(d.f6501a);
        }
    }

    private final String d(String str) {
        String p02;
        String str2 = f6500c.get(str);
        if (str2 != null) {
            return str2;
        }
        p02 = x.p0(str, 23);
        return p02;
    }

    public final void a(String str, int i4, String str2, Throwable th) {
        int M;
        int min;
        e3.f.e(str, "loggerName");
        e3.f.e(str2, "message");
        String d5 = d(str);
        if (Log.isLoggable(d5, i4)) {
            if (th != null) {
                str2 = str2 + '\n' + Log.getStackTraceString(th);
            }
            int i5 = 0;
            int length = str2.length();
            while (i5 < length) {
                M = v.M(str2, '\n', i5, false, 4, null);
                if (M == -1) {
                    M = length;
                }
                while (true) {
                    min = Math.min(M, i5 + 4000);
                    String substring = str2.substring(i5, min);
                    e3.f.d(substring, "substring(...)");
                    Log.println(i4, d5, substring);
                    if (min >= M) {
                        break;
                    } else {
                        i5 = min;
                    }
                }
                i5 = min + 1;
            }
        }
    }

    public final void b() {
        for (Map.Entry<String, String> entry : f6500c.entrySet()) {
            c(entry.getKey(), entry.getValue());
        }
    }
}
