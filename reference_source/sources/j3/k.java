package j3;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;

/* loaded from: classes.dex */
public final class k {
    /* JADX INFO: Access modifiers changed from: private */
    public static final h d(Matcher matcher, int i4, CharSequence charSequence) {
        if (matcher.find(i4)) {
            return new i(matcher, charSequence);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final g3.f e(MatchResult matchResult) {
        g3.f h4;
        h4 = g3.l.h(matchResult.start(), matchResult.end());
        return h4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final g3.f f(MatchResult matchResult, int i4) {
        g3.f h4;
        h4 = g3.l.h(matchResult.start(i4), matchResult.end(i4));
        return h4;
    }
}
