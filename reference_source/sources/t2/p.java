package t2;

import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import s2.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends s2.b {

    /* renamed from: d, reason: collision with root package name */
    private int f5987d;

    /* renamed from: e, reason: collision with root package name */
    final ExecutorService f5988e;

    /* renamed from: f, reason: collision with root package name */
    final boolean f5989f;

    /* renamed from: g, reason: collision with root package name */
    private final Process f5990g;

    /* renamed from: h, reason: collision with root package name */
    private final b f5991h;

    /* renamed from: i, reason: collision with root package name */
    private final a f5992i;

    /* renamed from: j, reason: collision with root package name */
    private final a f5993j;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends FilterInputStream {
        a(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        void i() {
            ((FilterInputStream) this).in.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends FilterOutputStream {
        b(OutputStream outputStream) {
            super(outputStream instanceof BufferedOutputStream ? outputStream : new BufferedOutputStream(outputStream));
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            ((FilterOutputStream) this).out.flush();
        }

        void i() {
            super.close();
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i4, int i5) {
            ((FilterOutputStream) this).out.write(bArr, i4, i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(t2.a aVar, Process process) {
        this.f5987d = -1;
        this.f5989f = aVar.g(8);
        this.f5990g = process;
        this.f5991h = new b(process.getOutputStream());
        this.f5992i = new a(process.getInputStream());
        this.f5993j = new a(process.getErrorStream());
        n nVar = new n();
        this.f5988e = nVar;
        try {
            try {
                try {
                    this.f5987d = ((Integer) nVar.submit(new Callable() { // from class: t2.o
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            Integer R;
                            R = p.this.R();
                            return R;
                        }
                    }).get(aVar.f5948a, TimeUnit.SECONDS)).intValue();
                } catch (TimeoutException e4) {
                    throw new IOException("Shell check timeout", e4);
                }
            } catch (InterruptedException e5) {
                throw new IOException("Shell check interrupted", e5);
            } catch (ExecutionException e6) {
                Throwable cause = e6.getCause();
                if (!(cause instanceof IOException)) {
                    throw new IOException("Unknown ExecutionException", cause);
                }
                throw ((IOException) cause);
            }
        } catch (IOException e7) {
            this.f5988e.shutdownNow();
            Q();
            throw e7;
        }
    }

    private void Q() {
        this.f5987d = -1;
        try {
            this.f5991h.i();
        } catch (IOException unused) {
        }
        try {
            this.f5993j.i();
        } catch (IOException unused2) {
        }
        try {
            this.f5992i.i();
        } catch (IOException unused3) {
        }
        this.f5990g.destroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Integer R() {
        try {
            this.f5990g.exitValue();
            throw new IOException("Created process has terminated");
        } catch (IllegalThreadStateException unused) {
            s2.c.a(this.f5992i);
            s2.c.a(this.f5993j);
            int i4 = 0;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f5992i));
            try {
                this.f5991h.write("echo SHELL_TEST\n".getBytes(StandardCharsets.UTF_8));
                this.f5991h.flush();
                String readLine = bufferedReader.readLine();
                if (TextUtils.isEmpty(readLine) || !readLine.contains("SHELL_TEST")) {
                    throw new IOException("Created process is not a shell");
                }
                this.f5991h.write("id\n".getBytes(StandardCharsets.UTF_8));
                this.f5991h.flush();
                String readLine2 = bufferedReader.readLine();
                if (!TextUtils.isEmpty(readLine2) && readLine2.contains("uid=0")) {
                    w.h(true);
                    String b5 = s2.c.b(System.getProperty("user.dir"));
                    this.f5991h.write(("cd " + b5 + "\n").getBytes(StandardCharsets.UTF_8));
                    this.f5991h.flush();
                    i4 = 1;
                }
                if (i4 == 1) {
                    this.f5991h.write("readlink /proc/self/ns/mnt\n".getBytes(StandardCharsets.UTF_8));
                    this.f5991h.flush();
                    String readLine3 = bufferedReader.readLine();
                    this.f5991h.write("readlink /proc/1/ns/mnt\n".getBytes(StandardCharsets.UTF_8));
                    this.f5991h.flush();
                    String readLine4 = bufferedReader.readLine();
                    if (!TextUtils.isEmpty(readLine3) && !TextUtils.isEmpty(readLine4) && TextUtils.equals(readLine3, readLine4)) {
                        i4 = 2;
                    }
                }
                bufferedReader.close();
                return Integer.valueOf(i4);
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }

    @Override // s2.b
    public int L() {
        return this.f5987d;
    }

    public synchronized void P(b.g gVar) {
        if (this.f5987d < 0) {
            throw new r();
        }
        s2.c.a(this.f5992i);
        s2.c.a(this.f5993j);
        try {
            this.f5991h.write(10);
            this.f5991h.flush();
            gVar.a(this.f5991h, this.f5992i, this.f5993j);
        } catch (IOException unused) {
            Q();
            throw new r();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f5987d < 0) {
            return;
        }
        this.f5988e.shutdownNow();
        Q();
    }
}
