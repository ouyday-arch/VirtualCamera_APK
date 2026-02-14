package b4;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f0 extends c {

    /* renamed from: o, reason: collision with root package name */
    private final Socket f2336o;

    public f0(Socket socket) {
        e3.f.e(socket, "socket");
        this.f2336o = socket;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b4.c
    protected void B() {
        Logger logger;
        Level level;
        StringBuilder sb;
        Logger logger2;
        Exception exc;
        Logger logger3;
        try {
            this.f2336o.close();
        } catch (AssertionError e4) {
            if (!t.c(e4)) {
                throw e4;
            }
            logger3 = u.f2387a;
            level = Level.WARNING;
            sb = new StringBuilder();
            exc = e4;
            logger2 = logger3;
            sb.append("Failed to close timed out socket ");
            sb.append(this.f2336o);
            logger2.log(level, sb.toString(), (Throwable) exc);
        } catch (Exception e5) {
            logger = u.f2387a;
            level = Level.WARNING;
            sb = new StringBuilder();
            exc = e5;
            logger2 = logger;
            sb.append("Failed to close timed out socket ");
            sb.append(this.f2336o);
            logger2.log(level, sb.toString(), (Throwable) exc);
        }
    }

    @Override // b4.c
    protected IOException x(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }
}
