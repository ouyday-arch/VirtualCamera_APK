package r2;

import android.os.AsyncTask;
import android.util.Log;

/* loaded from: classes.dex */
public class h extends AsyncTask<byte[], Void, String> {
    private void b(byte[] bArr) {
        Log.i("AsyncTask", "test");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String doInBackground(byte[]... bArr) {
        b(bArr[0]);
        return "test";
    }
}
