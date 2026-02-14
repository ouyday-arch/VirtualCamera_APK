package l1;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;

/* loaded from: classes.dex */
public final class b implements SensorEventListener {

    /* renamed from: a, reason: collision with root package name */
    private q2.h f4485a;

    /* renamed from: b, reason: collision with root package name */
    private q2.i f4486b;

    /* renamed from: c, reason: collision with root package name */
    private Sensor f4487c;

    /* renamed from: d, reason: collision with root package name */
    private Context f4488d;

    /* renamed from: e, reason: collision with root package name */
    private Handler f4489e = new Handler();

    public b(Context context, q2.h hVar, q2.i iVar) {
        this.f4488d = context;
        this.f4485a = hVar;
        this.f4486b = iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(boolean z4) {
        this.f4485a.t(z4);
    }

    private void c(final boolean z4) {
        this.f4489e.post(new Runnable() { // from class: l1.a
            @Override // java.lang.Runnable
            public final void run() {
                b.this.b(z4);
            }
        });
    }

    public void d() {
        if (this.f4486b.d()) {
            SensorManager sensorManager = (SensorManager) this.f4488d.getSystemService("sensor");
            Sensor defaultSensor = sensorManager.getDefaultSensor(5);
            this.f4487c = defaultSensor;
            if (defaultSensor != null) {
                sensorManager.registerListener(this, defaultSensor, 3);
            }
        }
    }

    public void e() {
        if (this.f4487c != null) {
            ((SensorManager) this.f4488d.getSystemService("sensor")).unregisterListener(this);
            this.f4487c = null;
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i4) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        float f4 = sensorEvent.values[0];
        if (this.f4485a != null) {
            if (f4 <= 45.0f) {
                c(true);
            } else if (f4 >= 450.0f) {
                c(false);
            }
        }
    }
}
