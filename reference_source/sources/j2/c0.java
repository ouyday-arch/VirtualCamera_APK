package j2;

import android.app.Fragment;
import android.content.Intent;

/* loaded from: classes.dex */
final class c0 {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface b {
        void a(Intent intent, int i4);
    }

    /* loaded from: classes.dex */
    private static class c implements b {

        /* renamed from: a, reason: collision with root package name */
        private final Fragment f4217a;

        private c(Fragment fragment) {
            this.f4217a = fragment;
        }

        @Override // j2.c0.b
        public void a(Intent intent, int i4) {
            this.f4217a.startActivityForResult(intent, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Intent a(Intent intent, Intent intent2) {
        if (intent == null && intent2 != null) {
            return intent2;
        }
        if (intent2 == null) {
            return intent;
        }
        b(intent).putExtra("sub_intent_key", intent2);
        return intent;
    }

    static Intent b(Intent intent) {
        Intent c5 = c(intent);
        return c5 != null ? b(c5) : intent;
    }

    static Intent c(Intent intent) {
        return (Intent) (j2.c.f() ? intent.getParcelableExtra("sub_intent_key", Intent.class) : intent.getParcelableExtra("sub_intent_key"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d(Fragment fragment, Intent intent, int i4) {
        return e(new c(fragment), intent, i4);
    }

    static boolean e(b bVar, Intent intent, int i4) {
        try {
            bVar.a(intent, i4);
            return true;
        } catch (Exception e4) {
            e4.printStackTrace();
            Intent c5 = c(intent);
            if (c5 == null) {
                return false;
            }
            return e(bVar, c5, i4);
        }
    }
}
