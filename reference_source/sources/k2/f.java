package k2;

import android.annotation.SuppressLint;
import android.app.Application;
import android.widget.Toast;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: classes.dex */
public class f extends i {

    /* renamed from: b, reason: collision with root package name */
    private static boolean f4410b;

    public f(Application application) {
        super(application);
    }

    @SuppressLint({"DiscouragedPrivateApi", "PrivateApi"})
    private static void b() {
        if (f4410b) {
            return;
        }
        f4410b = true;
        try {
            Method declaredMethod = Toast.class.getDeclaredMethod("getService", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            if (invoke == null) {
                return;
            }
            if (Proxy.isProxyClass(invoke.getClass()) && (Proxy.getInvocationHandler(invoke) instanceof e)) {
                return;
            }
            Object newProxyInstance = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{Class.forName("android.app.INotificationManager")}, new e(invoke));
            Field declaredField = Toast.class.getDeclaredField("sService");
            declaredField.setAccessible(true);
            declaredField.set(null, newProxyInstance);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // android.widget.Toast, l2.a
    public void show() {
        b();
        super.show();
    }
}
