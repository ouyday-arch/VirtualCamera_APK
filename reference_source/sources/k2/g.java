package k2;

import android.os.Handler;
import android.os.Message;
import android.view.WindowManager;

/* loaded from: classes.dex */
final class g extends Handler {

    /* renamed from: a, reason: collision with root package name */
    private final Handler f4411a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(Handler handler) {
        this.f4411a = handler;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            this.f4411a.handleMessage(message);
        } catch (WindowManager.BadTokenException | IllegalStateException e4) {
            e4.printStackTrace();
        }
    }
}
