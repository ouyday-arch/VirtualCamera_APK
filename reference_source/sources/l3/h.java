package l3;

import java.nio.charset.Charset;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    private final String f4664a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, String> f4665b;

    public h(String str, Map<String, String> map) {
        String str2;
        e3.f.e(str, "scheme");
        e3.f.e(map, "authParams");
        this.f4664a = str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key != null) {
                Locale locale = Locale.US;
                e3.f.d(locale, "US");
                str2 = key.toLowerCase(locale);
                e3.f.d(str2, "toLowerCase(...)");
            } else {
                str2 = null;
            }
            linkedHashMap.put(str2, value);
        }
        Map<String, String> unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        e3.f.d(unmodifiableMap, "unmodifiableMap(...)");
        this.f4665b = unmodifiableMap;
    }

    public final Map<String, String> a() {
        return this.f4665b;
    }

    public final Charset b() {
        String str = this.f4665b.get("charset");
        if (str != null) {
            try {
                Charset forName = Charset.forName(str);
                e3.f.d(forName, "forName(...)");
                return forName;
            } catch (Exception unused) {
            }
        }
        return j3.d.f4254g;
    }

    public final String c() {
        return this.f4665b.get("realm");
    }

    public final String d() {
        return this.f4664a;
    }

    public boolean equals(Object obj) {
        return m3.g.a(this, obj);
    }

    public int hashCode() {
        return m3.g.b(this);
    }

    public String toString() {
        return m3.g.c(this);
    }
}
