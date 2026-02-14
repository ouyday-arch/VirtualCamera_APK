package p;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Base64;
import android.util.Xml;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class a {

    /* renamed from: p.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0065a {
    }

    /* loaded from: classes.dex */
    public static final class b implements InterfaceC0065a {

        /* renamed from: a, reason: collision with root package name */
        private final c[] f5394a;

        public b(c[] cVarArr) {
            this.f5394a = cVarArr;
        }

        public c[] a() {
            return this.f5394a;
        }
    }

    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        private final String f5395a;

        /* renamed from: b, reason: collision with root package name */
        private int f5396b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f5397c;

        /* renamed from: d, reason: collision with root package name */
        private String f5398d;

        /* renamed from: e, reason: collision with root package name */
        private int f5399e;

        /* renamed from: f, reason: collision with root package name */
        private int f5400f;

        public c(String str, int i4, boolean z4, String str2, int i5, int i6) {
            this.f5395a = str;
            this.f5396b = i4;
            this.f5397c = z4;
            this.f5398d = str2;
            this.f5399e = i5;
            this.f5400f = i6;
        }

        public String a() {
            return this.f5395a;
        }

        public int b() {
            return this.f5400f;
        }

        public int c() {
            return this.f5399e;
        }

        public String d() {
            return this.f5398d;
        }

        public int e() {
            return this.f5396b;
        }

        public boolean f() {
            return this.f5397c;
        }
    }

    /* loaded from: classes.dex */
    public static final class d implements InterfaceC0065a {

        /* renamed from: a, reason: collision with root package name */
        private final v.a f5401a;

        /* renamed from: b, reason: collision with root package name */
        private final int f5402b;

        /* renamed from: c, reason: collision with root package name */
        private final int f5403c;

        public d(v.a aVar, int i4, int i5) {
            this.f5401a = aVar;
            this.f5403c = i4;
            this.f5402b = i5;
        }

        public int a() {
            return this.f5403c;
        }

        public v.a b() {
            return this.f5401a;
        }

        public int c() {
            return this.f5402b;
        }
    }

    private static int a(TypedArray typedArray, int i4) {
        return typedArray.getType(i4);
    }

    public static InterfaceC0065a b(XmlPullParser xmlPullParser, Resources resources) {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return d(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static List<List<byte[]>> c(Resources resources, int i4) {
        if (i4 == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i4);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (a(obtainTypedArray, 0) == 1) {
                for (int i5 = 0; i5 < obtainTypedArray.length(); i5++) {
                    int resourceId = obtainTypedArray.getResourceId(i5, 0);
                    if (resourceId != 0) {
                        arrayList.add(h(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(h(resources.getStringArray(i4)));
            }
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }

    private static InterfaceC0065a d(XmlPullParser xmlPullParser, Resources resources) {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return e(xmlPullParser, resources);
        }
        g(xmlPullParser);
        return null;
    }

    private static InterfaceC0065a e(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), m.b.f4909b);
        String string = obtainAttributes.getString(m.b.f4910c);
        String string2 = obtainAttributes.getString(m.b.f4914g);
        String string3 = obtainAttributes.getString(m.b.f4915h);
        int resourceId = obtainAttributes.getResourceId(m.b.f4911d, 0);
        int integer = obtainAttributes.getInteger(m.b.f4912e, 1);
        int integer2 = obtainAttributes.getInteger(m.b.f4913f, 500);
        obtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                g(xmlPullParser);
            }
            return new d(new v.a(string, string2, string3, c(resources, resourceId)), integer, integer2);
        }
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    arrayList.add(f(xmlPullParser, resources));
                } else {
                    g(xmlPullParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new b((c[]) arrayList.toArray(new c[arrayList.size()]));
    }

    private static c f(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), m.b.f4916i);
        int i4 = m.b.f4925r;
        if (!obtainAttributes.hasValue(i4)) {
            i4 = m.b.f4918k;
        }
        int i5 = obtainAttributes.getInt(i4, 400);
        int i6 = m.b.f4923p;
        if (!obtainAttributes.hasValue(i6)) {
            i6 = m.b.f4919l;
        }
        boolean z4 = 1 == obtainAttributes.getInt(i6, 0);
        int i7 = m.b.f4926s;
        if (!obtainAttributes.hasValue(i7)) {
            i7 = m.b.f4920m;
        }
        int i8 = m.b.f4924q;
        if (!obtainAttributes.hasValue(i8)) {
            i8 = m.b.f4921n;
        }
        String string = obtainAttributes.getString(i8);
        int i9 = obtainAttributes.getInt(i7, 0);
        int i10 = m.b.f4922o;
        if (!obtainAttributes.hasValue(i10)) {
            i10 = m.b.f4917j;
        }
        int resourceId = obtainAttributes.getResourceId(i10, 0);
        String string2 = obtainAttributes.getString(i10);
        obtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            g(xmlPullParser);
        }
        return new c(string2, i5, z4, string, i9, resourceId);
    }

    private static void g(XmlPullParser xmlPullParser) {
        int i4 = 1;
        while (i4 > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i4++;
            } else if (next == 3) {
                i4--;
            }
        }
    }

    private static List<byte[]> h(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }
}
