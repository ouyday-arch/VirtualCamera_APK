package r2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;

/* loaded from: classes.dex */
public class i extends HandlerThread implements Handler.Callback {
    public i(String str) {
        super(str);
        start();
    }

    private void a(byte[] bArr) {
        Log.i("HandlerThread", "test");
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 1) {
            return false;
        }
        a((byte[]) message.obj);
        return true;
    }
}
