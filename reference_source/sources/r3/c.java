package r3;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import m3.s;
import u2.l;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static final a f5859a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f5860b;

    /* renamed from: c, reason: collision with root package name */
    private static final DateFormat[] f5861c;

    /* loaded from: classes.dex */
    public static final class a extends ThreadLocal<DateFormat> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setLenient(false);
            simpleDateFormat.setTimeZone(s.f5212d);
            return simpleDateFormat;
        }
    }

    static {
        String[] strArr = {"EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
        f5860b = strArr;
        f5861c = new DateFormat[strArr.length];
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.text.DateFormat[]] */
    /* JADX WARN: Type inference failed for: r7v0 */
    public static final Date a(String str) {
        e3.f.e(str, "<this>");
        if (str.length() == 0) {
            return null;
        }
        ParsePosition parsePosition = new ParsePosition(0);
        Date parse = f5859a.get().parse(str, parsePosition);
        if (parsePosition.getIndex() == str.length()) {
            return parse;
        }
        String[] strArr = f5860b;
        synchronized (strArr) {
            int length = strArr.length;
            for (int i4 = 0; i4 < length; i4++) {
                ?? r6 = f5861c;
                ?? r7 = r6[i4];
                SimpleDateFormat simpleDateFormat = r7;
                if (r7 == 0) {
                    SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(f5860b[i4], Locale.US);
                    simpleDateFormat2.setTimeZone(s.f5212d);
                    r6[i4] = simpleDateFormat2;
                    simpleDateFormat = simpleDateFormat2;
                }
                parsePosition.setIndex(0);
                Date parse2 = simpleDateFormat.parse(str, parsePosition);
                if (parsePosition.getIndex() != 0) {
                    return parse2;
                }
            }
            l lVar = l.f6223a;
            return null;
        }
    }

    public static final String b(Date date) {
        e3.f.e(date, "<this>");
        String format = f5859a.get().format(date);
        e3.f.d(format, "format(...)");
        return format;
    }
}
