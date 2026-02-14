package k2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
final class e implements InvocationHandler {

    /* renamed from: a, reason: collision with root package name */
    private final Object f4409a;

    public e(Object obj) {
        this.f4409a = obj;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        String name = method.getName();
        name.hashCode();
        char c5 = 65535;
        switch (name.hashCode()) {
            case -1581943859:
                if (name.equals("cancelToast")) {
                    c5 = 0;
                    break;
                }
                break;
            case 1230397970:
                if (name.equals("enqueueToastEx")) {
                    c5 = 1;
                    break;
                }
                break;
            case 1967758591:
                if (name.equals("enqueueToast")) {
                    c5 = 2;
                    break;
                }
                break;
        }
        switch (c5) {
            case 0:
            case 1:
            case 2:
                objArr[0] = "android";
                break;
        }
        return method.invoke(this.f4409a, objArr);
    }
}
