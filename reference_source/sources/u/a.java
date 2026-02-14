package u;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static long f6206a;

    /* renamed from: b, reason: collision with root package name */
    private static Method f6207b;

    /* renamed from: c, reason: collision with root package name */
    private static Method f6208c;

    /* renamed from: d, reason: collision with root package name */
    private static Method f6209d;

    /* renamed from: e, reason: collision with root package name */
    private static Method f6210e;

    static {
        if (Build.VERSION.SDK_INT < 29) {
            try {
                f6206a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                Class cls = Long.TYPE;
                f6207b = Trace.class.getMethod("isTagEnabled", cls);
                Class cls2 = Integer.TYPE;
                f6208c = Trace.class.getMethod("asyncTraceBegin", cls, String.class, cls2);
                f6209d = Trace.class.getMethod("asyncTraceEnd", cls, String.class, cls2);
                f6210e = Trace.class.getMethod("traceCounter", cls, String.class, cls2);
            } catch (Exception e4) {
                Log.i("TraceCompat", "Unable to initialize via reflection.", e4);
            }
        }
    }

    public static void a(String str) {
        Trace.beginSection(str);
    }

    public static void b() {
        Trace.endSection();
    }
}
