package t2;

import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import s2.b;
import t2.s;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements b.g {

    /* renamed from: c, reason: collision with root package name */
    static final String f5996c;

    /* renamed from: d, reason: collision with root package name */
    static final byte[] f5997d;

    /* renamed from: a, reason: collision with root package name */
    private final List<q> f5998a;

    /* renamed from: b, reason: collision with root package name */
    private final m f5999b;

    static {
        String uuid = UUID.randomUUID().toString();
        f5996c = uuid;
        f5997d = String.format("__RET=$?;echo %1$s;echo %1$s >&2;echo $__RET;unset __RET\n", uuid).getBytes(StandardCharsets.UTF_8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(List<q> list, m mVar) {
        this.f5998a = list;
        this.f5999b = mVar;
    }

    @Override // s2.b.g
    public void a(OutputStream outputStream, InputStream inputStream, InputStream inputStream2) {
        Future submit = s2.b.f5886b.submit(new s.b(inputStream, this.f5999b.f5980a));
        Future submit2 = s2.b.f5886b.submit(new s.a(inputStream2, this.f5999b.f5981b));
        Iterator<q> it = this.f5998a.iterator();
        while (it.hasNext()) {
            it.next().g(outputStream);
        }
        outputStream.write(f5997d);
        outputStream.flush();
        try {
            this.f5999b.f5982c = ((Integer) submit.get()).intValue();
            submit2.get();
        } catch (InterruptedException | ExecutionException e4) {
            throw ((InterruptedIOException) new InterruptedIOException().initCause(e4));
        }
    }
}
