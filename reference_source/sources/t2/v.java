package t2;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    public static final Handler f6001a = new Handler(Looper.getMainLooper());

    /* renamed from: b, reason: collision with root package name */
    public static final Executor f6002b = new Executor() { // from class: t2.u
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            v.a(runnable);
        }
    };

    public static void a(Runnable runnable) {
        if (s2.c.c()) {
            runnable.run();
        } else {
            f6001a.post(runnable);
        }
    }
}
