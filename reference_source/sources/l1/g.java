package l1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import java.util.EnumMap;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private static final String f4505a = "g";

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f4506b = Pattern.compile(",");

    public static Map<g1.e, Object> a(Intent intent) {
        Object obj;
        Bundle extras = intent.getExtras();
        if (extras == null || extras.isEmpty()) {
            return null;
        }
        EnumMap enumMap = new EnumMap(g1.e.class);
        for (g1.e eVar : g1.e.values()) {
            if (eVar != g1.e.CHARACTER_SET && eVar != g1.e.NEED_RESULT_POINT_CALLBACK && eVar != g1.e.POSSIBLE_FORMATS) {
                String name = eVar.name();
                if (extras.containsKey(name)) {
                    if (eVar.a().equals(Void.class)) {
                        obj = Boolean.TRUE;
                    } else {
                        obj = extras.get(name);
                        if (!eVar.a().isInstance(obj)) {
                            Log.w(f4505a, "Ignoring hint " + eVar + " because it is not assignable from " + obj);
                        }
                    }
                    enumMap.put((EnumMap) eVar, (g1.e) obj);
                }
            }
        }
        Log.i(f4505a, "Hints from the Intent: " + enumMap);
        return enumMap;
    }
}
