package k2;

import android.util.Log;
import java.lang.reflect.Modifier;

/* loaded from: classes.dex */
public class l implements l2.b {
    @Override // l2.b
    public boolean a(m mVar) {
        e(mVar.f4425a);
        return false;
    }

    protected boolean b(Class<?> cls) {
        return getClass().equals(cls) || o.class.equals(cls) || cls.isInterface() || Modifier.isAbstract(cls.getModifiers());
    }

    protected boolean c() {
        return o.e();
    }

    protected void d(String str) {
        Log.i("Toaster", str);
    }

    protected void e(CharSequence charSequence) {
        if (c()) {
            for (StackTraceElement stackTraceElement : new Throwable().getStackTrace()) {
                int lineNumber = stackTraceElement.getLineNumber();
                if (lineNumber > 0) {
                    try {
                        if (!b(Class.forName(stackTraceElement.getClassName()))) {
                            d("(" + stackTraceElement.getFileName() + ":" + lineNumber + ") " + charSequence.toString());
                            return;
                        }
                        continue;
                    } catch (ClassNotFoundException e4) {
                        e4.printStackTrace();
                    }
                }
            }
        }
    }
}
