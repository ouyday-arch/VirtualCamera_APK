package p3;

import e3.f;
import e3.n;
import java.util.Arrays;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public final class b {
    public static final String b(long j4) {
        StringBuilder sb;
        long j5;
        long j6;
        long j7;
        if (j4 > -999500000) {
            if (j4 > -999500) {
                if (j4 <= 0) {
                    sb = new StringBuilder();
                    j7 = j4 - 500;
                } else if (j4 < 999500) {
                    sb = new StringBuilder();
                    j7 = j4 + 500;
                } else if (j4 < 999500000) {
                    sb = new StringBuilder();
                    j6 = j4 + 500000;
                } else {
                    sb = new StringBuilder();
                    j5 = j4 + 500000000;
                }
                sb.append(j7 / 1000);
                sb.append(" µs");
                String sb2 = sb.toString();
                n nVar = n.f3633a;
                String format = String.format("%6s", Arrays.copyOf(new Object[]{sb2}, 1));
                f.d(format, "format(...)");
                return format;
            }
            sb = new StringBuilder();
            j6 = j4 - 500000;
            sb.append(j6 / 1000000);
            sb.append(" ms");
            String sb22 = sb.toString();
            n nVar2 = n.f3633a;
            String format2 = String.format("%6s", Arrays.copyOf(new Object[]{sb22}, 1));
            f.d(format2, "format(...)");
            return format2;
        }
        sb = new StringBuilder();
        j5 = j4 - 500000000;
        sb.append(j5 / 1000000000);
        sb.append(" s ");
        String sb222 = sb.toString();
        n nVar22 = n.f3633a;
        String format22 = String.format("%6s", Arrays.copyOf(new Object[]{sb222}, 1));
        f.d(format22, "format(...)");
        return format22;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Logger logger, a aVar, c cVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(cVar.h());
        sb.append(' ');
        n nVar = n.f3633a;
        String format = String.format("%-22s", Arrays.copyOf(new Object[]{str}, 1));
        f.d(format, "format(...)");
        sb.append(format);
        sb.append(": ");
        sb.append(aVar.b());
        logger.fine(sb.toString());
    }
}
