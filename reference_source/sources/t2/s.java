package t2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class s<T> implements Callable<T> {

    /* renamed from: a, reason: collision with root package name */
    protected final InputStream f5994a;

    /* renamed from: b, reason: collision with root package name */
    protected final List<String> f5995b;

    /* loaded from: classes.dex */
    static class a extends s<Void> {
        /* JADX INFO: Access modifiers changed from: package-private */
        public a(InputStream inputStream, List<String> list) {
            super(inputStream, list);
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Void call() {
            b(false);
            return null;
        }
    }

    /* loaded from: classes.dex */
    static class b extends s<Integer> {
        /* JADX INFO: Access modifiers changed from: package-private */
        public b(InputStream inputStream, List<String> list) {
            super(inputStream, list);
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Integer call() {
            int parseInt;
            String b5 = b(true);
            if (b5 == null) {
                parseInt = 1;
            } else {
                try {
                    parseInt = Integer.parseInt(b5);
                } catch (NumberFormatException unused) {
                    return 1;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("(exit code: ");
            sb.append(parseInt);
            sb.append(")");
            return Integer.valueOf(parseInt);
        }
    }

    s(InputStream inputStream, List<String> list) {
        this.f5994a = inputStream;
        this.f5995b = list;
    }

    private boolean a(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        int i4 = length - 36;
        boolean startsWith = str.startsWith(t.f5996c, i4);
        if (startsWith) {
            if (length == 36) {
                return false;
            }
            str = str.substring(0, i4);
        }
        List<String> list = this.f5995b;
        if (list != null) {
            list.add(str);
        }
        return !startsWith;
    }

    protected String b(boolean z4) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f5994a, StandardCharsets.UTF_8));
        do {
        } while (a(bufferedReader.readLine()));
        if (z4) {
            return bufferedReader.readLine();
        }
        return null;
    }
}
