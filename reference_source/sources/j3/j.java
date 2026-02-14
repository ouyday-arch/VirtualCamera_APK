package j3;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class j implements Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final a f4276c = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private final Pattern f4277b;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e3.d dVar) {
            this();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public j(java.lang.String r2) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            e3.f.e(r2, r0)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)
            java.lang.String r0 = "compile(...)"
            e3.f.d(r2, r0)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j3.j.<init>(java.lang.String):void");
    }

    public j(Pattern pattern) {
        e3.f.e(pattern, "nativePattern");
        this.f4277b = pattern;
    }

    public final h a(CharSequence charSequence, int i4) {
        h d5;
        e3.f.e(charSequence, "input");
        Matcher matcher = this.f4277b.matcher(charSequence);
        e3.f.d(matcher, "matcher(...)");
        d5 = k.d(matcher, i4, charSequence);
        return d5;
    }

    public final boolean b(CharSequence charSequence) {
        e3.f.e(charSequence, "input");
        return this.f4277b.matcher(charSequence).matches();
    }

    public final String c(CharSequence charSequence, String str) {
        e3.f.e(charSequence, "input");
        e3.f.e(str, "replacement");
        String replaceAll = this.f4277b.matcher(charSequence).replaceAll(str);
        e3.f.d(replaceAll, "replaceAll(...)");
        return replaceAll;
    }

    public String toString() {
        String pattern = this.f4277b.toString();
        e3.f.d(pattern, "toString(...)");
        return pattern;
    }
}
