package k2;

import android.annotation.TargetApi;
import android.app.Application;
import android.os.Handler;
import android.widget.Toast;
import java.lang.reflect.Field;

@TargetApi(19)
/* loaded from: classes.dex */
public class h extends f {

    /* renamed from: c, reason: collision with root package name */
    private boolean f4412c;

    public h(Application application) {
        super(application);
    }

    private void c() {
        if (this.f4412c) {
            return;
        }
        this.f4412c = true;
        try {
            Field declaredField = Toast.class.getDeclaredField("mTN");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this);
            Field declaredField2 = declaredField.getType().getDeclaredField("mHandler");
            declaredField2.setAccessible(true);
            Handler handler = (Handler) declaredField2.get(obj);
            if (handler instanceof g) {
                return;
            }
            declaredField2.set(obj, new g(handler));
        } catch (IllegalAccessException | NoSuchFieldException e4) {
            e4.printStackTrace();
        }
    }

    @Override // k2.f, android.widget.Toast, l2.a
    public void show() {
        c();
        super.show();
    }
}
