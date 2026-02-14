package r2;

import android.util.Log;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes.dex */
public class j extends Thread {

    /* renamed from: b, reason: collision with root package name */
    private LinkedBlockingQueue<byte[]> f5848b;

    public j(LinkedBlockingQueue<byte[]> linkedBlockingQueue) {
        this.f5848b = linkedBlockingQueue;
        start();
    }

    private void a(byte[] bArr) {
        Log.i("Queue", "test");
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (true) {
            byte[] bArr = null;
            try {
                bArr = this.f5848b.take();
            } catch (InterruptedException e4) {
                e4.printStackTrace();
            }
            if (bArr.length == 1) {
                return;
            } else {
                a(bArr);
            }
        }
    }
}
