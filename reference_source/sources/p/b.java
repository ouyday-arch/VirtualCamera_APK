package p;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import x.h;

/* loaded from: classes.dex */
public final class b {

    /* loaded from: classes.dex */
    public static abstract class a {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: p.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0066a implements Runnable {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Typeface f5404b;

            RunnableC0066a(Typeface typeface) {
                this.f5404b = typeface;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.d(this.f5404b);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: p.b$a$b, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0067b implements Runnable {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f5406b;

            RunnableC0067b(int i4) {
                this.f5406b = i4;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.c(this.f5406b);
            }
        }

        public final void a(int i4, Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new RunnableC0067b(i4));
        }

        public final void b(Typeface typeface, Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new RunnableC0066a(typeface));
        }

        public abstract void c(int i4);

        public abstract void d(Typeface typeface);
    }

    public static Drawable a(Resources resources, int i4, Resources.Theme theme) {
        return resources.getDrawable(i4, theme);
    }

    public static Typeface b(Context context, int i4) {
        if (context.isRestricted()) {
            return null;
        }
        return e(context, i4, new TypedValue(), 0, null, null, false);
    }

    public static Typeface c(Context context, int i4, TypedValue typedValue, int i5, a aVar) {
        if (context.isRestricted()) {
            return null;
        }
        return e(context, i4, typedValue, i5, aVar, null, true);
    }

    public static void d(Context context, int i4, a aVar, Handler handler) {
        h.c(aVar);
        if (context.isRestricted()) {
            aVar.a(-4, handler);
        } else {
            e(context, i4, new TypedValue(), 0, aVar, handler, false);
        }
    }

    private static Typeface e(Context context, int i4, TypedValue typedValue, int i5, a aVar, Handler handler, boolean z4) {
        Resources resources = context.getResources();
        resources.getValue(i4, typedValue, true);
        Typeface f4 = f(context, resources, typedValue, i4, i5, aVar, handler, z4);
        if (f4 != null || aVar != null) {
            return f4;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i4) + " could not be retrieved.");
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.graphics.Typeface f(android.content.Context r15, android.content.res.Resources r16, android.util.TypedValue r17, int r18, int r19, p.b.a r20, android.os.Handler r21, boolean r22) {
        /*
            r0 = r16
            r1 = r17
            r4 = r18
            r5 = r19
            r9 = r20
            r10 = r21
            java.lang.String r11 = "ResourcesCompat"
            java.lang.CharSequence r2 = r1.string
            if (r2 == 0) goto L9a
            java.lang.String r12 = r2.toString()
            java.lang.String r1 = "res/"
            boolean r1 = r12.startsWith(r1)
            r13 = 0
            r14 = -3
            if (r1 != 0) goto L26
            if (r9 == 0) goto L25
            r9.a(r14, r10)
        L25:
            return r13
        L26:
            android.graphics.Typeface r1 = q.b.f(r0, r4, r5)
            if (r1 == 0) goto L32
            if (r9 == 0) goto L31
            r9.b(r1, r10)
        L31:
            return r1
        L32:
            java.lang.String r1 = r12.toLowerCase()     // Catch: java.io.IOException -> L76 org.xmlpull.v1.XmlPullParserException -> L7f
            java.lang.String r2 = ".xml"
            boolean r1 = r1.endsWith(r2)     // Catch: java.io.IOException -> L76 org.xmlpull.v1.XmlPullParserException -> L7f
            if (r1 == 0) goto L65
            android.content.res.XmlResourceParser r1 = r0.getXml(r4)     // Catch: java.io.IOException -> L76 org.xmlpull.v1.XmlPullParserException -> L7f
            p.a$a r2 = p.a.b(r1, r0)     // Catch: java.io.IOException -> L76 org.xmlpull.v1.XmlPullParserException -> L7f
            if (r2 != 0) goto L53
            java.lang.String r0 = "Failed to find font-family tag"
            android.util.Log.e(r11, r0)     // Catch: java.io.IOException -> L76 org.xmlpull.v1.XmlPullParserException -> L7f
            if (r9 == 0) goto L52
            r9.a(r14, r10)     // Catch: java.io.IOException -> L76 org.xmlpull.v1.XmlPullParserException -> L7f
        L52:
            return r13
        L53:
            r1 = r15
            r3 = r16
            r4 = r18
            r5 = r19
            r6 = r20
            r7 = r21
            r8 = r22
            android.graphics.Typeface r0 = q.b.c(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch: java.io.IOException -> L76 org.xmlpull.v1.XmlPullParserException -> L7f
            return r0
        L65:
            r1 = r15
            android.graphics.Typeface r0 = q.b.d(r15, r0, r4, r12, r5)     // Catch: java.io.IOException -> L76 org.xmlpull.v1.XmlPullParserException -> L7f
            if (r9 == 0) goto L75
            if (r0 == 0) goto L72
            r9.b(r0, r10)     // Catch: java.io.IOException -> L76 org.xmlpull.v1.XmlPullParserException -> L7f
            goto L75
        L72:
            r9.a(r14, r10)     // Catch: java.io.IOException -> L76 org.xmlpull.v1.XmlPullParserException -> L7f
        L75:
            return r0
        L76:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to read xml resource "
            goto L87
        L7f:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to parse xml resource "
        L87:
            r1.append(r2)
            r1.append(r12)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r11, r1, r0)
            if (r9 == 0) goto L99
            r9.a(r14, r10)
        L99:
            return r13
        L9a:
            android.content.res.Resources$NotFoundException r2 = new android.content.res.Resources$NotFoundException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "Resource \""
            r3.append(r5)
            java.lang.String r0 = r0.getResourceName(r4)
            r3.append(r0)
            java.lang.String r0 = "\" ("
            r3.append(r0)
            java.lang.String r0 = java.lang.Integer.toHexString(r18)
            r3.append(r0)
            java.lang.String r0 = ") is not a Font: "
            r3.append(r0)
            r3.append(r1)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p.b.f(android.content.Context, android.content.res.Resources, android.util.TypedValue, int, int, p.b$a, android.os.Handler, boolean):android.graphics.Typeface");
    }
}
