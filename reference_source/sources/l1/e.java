package l1;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.util.Log;
import java.io.IOException;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: d, reason: collision with root package name */
    private static final String f4492d = "e";

    /* renamed from: a, reason: collision with root package name */
    private final Context f4493a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f4494b = true;

    /* renamed from: c, reason: collision with root package name */
    private boolean f4495c = false;

    public e(Activity activity) {
        activity.setVolumeControlStream(3);
        this.f4493a = activity.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(MediaPlayer mediaPlayer) {
        mediaPlayer.stop();
        mediaPlayer.reset();
        mediaPlayer.release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean d(MediaPlayer mediaPlayer, int i4, int i5) {
        Log.w(f4492d, "Failed to beep " + i4 + ", " + i5);
        mediaPlayer.stop();
        mediaPlayer.reset();
        mediaPlayer.release();
        return true;
    }

    public MediaPlayer e() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioAttributes(new AudioAttributes.Builder().setContentType(2).build());
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: l1.c
            @Override // android.media.MediaPlayer.OnCompletionListener
            public final void onCompletion(MediaPlayer mediaPlayer2) {
                e.c(mediaPlayer2);
            }
        });
        mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: l1.d
            @Override // android.media.MediaPlayer.OnErrorListener
            public final boolean onError(MediaPlayer mediaPlayer2, int i4, int i5) {
                boolean d5;
                d5 = e.d(mediaPlayer2, i4, i5);
                return d5;
            }
        });
        try {
            AssetFileDescriptor openRawResourceFd = this.f4493a.getResources().openRawResourceFd(m.f4534a);
            try {
                mediaPlayer.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
                openRawResourceFd.close();
                mediaPlayer.setVolume(0.1f, 0.1f);
                mediaPlayer.prepare();
                mediaPlayer.start();
                return mediaPlayer;
            } catch (Throwable th) {
                openRawResourceFd.close();
                throw th;
            }
        } catch (IOException e4) {
            Log.w(f4492d, e4);
            mediaPlayer.reset();
            mediaPlayer.release();
            return null;
        }
    }

    @SuppressLint({"MissingPermission"})
    public synchronized void f() {
        Vibrator vibrator;
        if (this.f4494b) {
            e();
        }
        if (this.f4495c && (vibrator = (Vibrator) this.f4493a.getSystemService("vibrator")) != null) {
            vibrator.vibrate(200L);
        }
    }

    public void g(boolean z4) {
        this.f4494b = z4;
    }
}
