package b4;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final /* synthetic */ class u {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f2387a = Logger.getLogger("okio.Okio");

    public static final boolean b(AssertionError assertionError) {
        e3.f.e(assertionError, "<this>");
        if (assertionError.getCause() == null) {
            return false;
        }
        String message = assertionError.getMessage();
        return message != null ? j3.v.C(message, "getsockname failed", false, 2, null) : false;
    }

    public static final e0 c(Socket socket) {
        e3.f.e(socket, "<this>");
        f0 f0Var = new f0(socket);
        OutputStream outputStream = socket.getOutputStream();
        e3.f.d(outputStream, "getOutputStream(...)");
        return f0Var.z(new x(outputStream, f0Var));
    }

    public static final g0 d(File file) {
        e3.f.e(file, "<this>");
        return new p(new FileInputStream(file), h0.f2350e);
    }

    public static final g0 e(InputStream inputStream) {
        e3.f.e(inputStream, "<this>");
        return new p(inputStream, new h0());
    }

    public static final g0 f(Socket socket) {
        e3.f.e(socket, "<this>");
        f0 f0Var = new f0(socket);
        InputStream inputStream = socket.getInputStream();
        e3.f.d(inputStream, "getInputStream(...)");
        return f0Var.A(new p(inputStream, f0Var));
    }
}
