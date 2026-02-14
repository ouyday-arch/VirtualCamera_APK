package m3;

import java.text.Normalizer;

/* loaded from: classes.dex */
public final class k {
    public static final String a(String str) {
        e3.f.e(str, "string");
        String normalize = Normalizer.normalize(str, Normalizer.Form.NFC);
        e3.f.d(normalize, "normalize(...)");
        return normalize;
    }
}
