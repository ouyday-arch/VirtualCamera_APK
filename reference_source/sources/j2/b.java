package j2;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import j2.a;

/* loaded from: classes.dex */
final class b {
    private static a.C0051a a(XmlResourceParser xmlResourceParser) {
        a.C0051a c0051a = new a.C0051a();
        c0051a.f4195a = xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name");
        c0051a.f4196b = xmlResourceParser.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "supportsPictureInPicture", false);
        return c0051a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a b(Context context, int i4) {
        a aVar = new a();
        XmlResourceParser openXmlResourceParser = context.getAssets().openXmlResourceParser(i4, "AndroidManifest.xml");
        do {
            if (openXmlResourceParser.getEventType() == 2) {
                String name = openXmlResourceParser.getName();
                if (TextUtils.equals("manifest", name)) {
                    aVar.f4189a = openXmlResourceParser.getAttributeValue(null, "package");
                }
                if (TextUtils.equals("uses-sdk", name)) {
                    aVar.f4190b = f(openXmlResourceParser);
                }
                if (TextUtils.equals("uses-permission", name) || TextUtils.equals("uses-permission-sdk-23", name) || TextUtils.equals("uses-permission-sdk-m", name)) {
                    aVar.f4191c.add(d(openXmlResourceParser));
                }
                if (TextUtils.equals("application", name)) {
                    aVar.f4192d = c(openXmlResourceParser);
                }
                if (TextUtils.equals("activity", name) || TextUtils.equals("activity-alias", name)) {
                    aVar.f4193e.add(a(openXmlResourceParser));
                }
                if (TextUtils.equals("service", name)) {
                    aVar.f4194f.add(e(openXmlResourceParser));
                }
            }
        } while (openXmlResourceParser.next() != 1);
        openXmlResourceParser.close();
        return aVar;
    }

    private static a.b c(XmlResourceParser xmlResourceParser) {
        a.b bVar = new a.b();
        bVar.f4197a = xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name");
        bVar.f4198b = xmlResourceParser.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "requestLegacyExternalStorage", false);
        return bVar;
    }

    private static a.c d(XmlResourceParser xmlResourceParser) {
        a.c cVar = new a.c();
        cVar.f4199a = xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name");
        cVar.f4200b = xmlResourceParser.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxSdkVersion", Integer.MAX_VALUE);
        cVar.f4201c = xmlResourceParser.getAttributeIntValue("http://schemas.android.com/apk/res/android", "usesPermissionFlags", 0);
        return cVar;
    }

    private static a.d e(XmlResourceParser xmlResourceParser) {
        a.d dVar = new a.d();
        dVar.f4202a = xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "name");
        dVar.f4203b = xmlResourceParser.getAttributeValue("http://schemas.android.com/apk/res/android", "permission");
        return dVar;
    }

    private static a.e f(XmlResourceParser xmlResourceParser) {
        a.e eVar = new a.e();
        eVar.f4204a = xmlResourceParser.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minSdkVersion", 0);
        return eVar;
    }
}
