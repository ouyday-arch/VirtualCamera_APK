package p2;

import android.content.Context;
import android.view.OrientationEventListener;
import android.view.WindowManager;

/* loaded from: classes.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    private int f5462a;

    /* renamed from: b, reason: collision with root package name */
    private WindowManager f5463b;

    /* renamed from: c, reason: collision with root package name */
    private OrientationEventListener f5464c;

    /* renamed from: d, reason: collision with root package name */
    private o f5465d;

    /* loaded from: classes.dex */
    class a extends OrientationEventListener {
        a(Context context, int i4) {
            super(context, i4);
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i4) {
            int rotation;
            WindowManager windowManager = p.this.f5463b;
            o oVar = p.this.f5465d;
            if (p.this.f5463b == null || oVar == null || (rotation = windowManager.getDefaultDisplay().getRotation()) == p.this.f5462a) {
                return;
            }
            p.this.f5462a = rotation;
            oVar.a(rotation);
        }
    }

    public void e(Context context, o oVar) {
        f();
        Context applicationContext = context.getApplicationContext();
        this.f5465d = oVar;
        this.f5463b = (WindowManager) applicationContext.getSystemService("window");
        a aVar = new a(applicationContext, 3);
        this.f5464c = aVar;
        aVar.enable();
        this.f5462a = this.f5463b.getDefaultDisplay().getRotation();
    }

    public void f() {
        OrientationEventListener orientationEventListener = this.f5464c;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
        this.f5464c = null;
        this.f5463b = null;
        this.f5465d = null;
    }
}
