package x3;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

/* loaded from: classes.dex */
public final class d extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public static final d f6501a = new d();

    private d() {
    }

    @Override // java.util.logging.Handler
    public void close() {
    }

    @Override // java.util.logging.Handler
    public void flush() {
    }

    @Override // java.util.logging.Handler
    public void publish(LogRecord logRecord) {
        int b5;
        e3.f.e(logRecord, "record");
        c cVar = c.f6498a;
        String loggerName = logRecord.getLoggerName();
        e3.f.d(loggerName, "getLoggerName(...)");
        b5 = e.b(logRecord);
        String message = logRecord.getMessage();
        e3.f.d(message, "getMessage(...)");
        cVar.a(loggerName, b5, message, logRecord.getThrown());
    }
}
