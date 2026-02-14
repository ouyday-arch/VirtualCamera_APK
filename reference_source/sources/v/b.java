package v;

import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import p.b;
import q.i;
import v.c;
import x.h;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    static final k.e<String, Typeface> f6233a = new k.e<>(16);

    /* renamed from: b, reason: collision with root package name */
    private static final v.c f6234b = new v.c("fonts", 10, 10000);

    /* renamed from: c, reason: collision with root package name */
    static final Object f6235c = new Object();

    /* renamed from: d, reason: collision with root package name */
    static final k.g<String, ArrayList<c.d<g>>> f6236d = new k.g<>();

    /* renamed from: e, reason: collision with root package name */
    private static final Comparator<byte[]> f6237e = new d();

    /* loaded from: classes.dex */
    static class a implements Callable<g> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f6238a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ v.a f6239b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f6240c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f6241d;

        a(Context context, v.a aVar, int i4, String str) {
            this.f6238a = context;
            this.f6239b = aVar;
            this.f6240c = i4;
            this.f6241d = str;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public g call() {
            g f4 = b.f(this.f6238a, this.f6239b, this.f6240c);
            Typeface typeface = f4.f6252a;
            if (typeface != null) {
                b.f6233a.d(this.f6241d, typeface);
            }
            return f4;
        }
    }

    /* renamed from: v.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0082b implements c.d<g> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b.a f6242a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Handler f6243b;

        C0082b(b.a aVar, Handler handler) {
            this.f6242a = aVar;
            this.f6243b = handler;
        }

        @Override // v.c.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(g gVar) {
            int i4;
            b.a aVar;
            if (gVar == null) {
                aVar = this.f6242a;
                i4 = 1;
            } else {
                i4 = gVar.f6253b;
                if (i4 == 0) {
                    this.f6242a.b(gVar.f6252a, this.f6243b);
                    return;
                }
                aVar = this.f6242a;
            }
            aVar.a(i4, this.f6243b);
        }
    }

    /* loaded from: classes.dex */
    static class c implements c.d<g> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f6244a;

        c(String str) {
            this.f6244a = str;
        }

        @Override // v.c.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(g gVar) {
            synchronized (b.f6235c) {
                k.g<String, ArrayList<c.d<g>>> gVar2 = b.f6236d;
                ArrayList<c.d<g>> arrayList = gVar2.get(this.f6244a);
                if (arrayList == null) {
                    return;
                }
                gVar2.remove(this.f6244a);
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    arrayList.get(i4).a(gVar);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    static class d implements Comparator<byte[]> {
        d() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(byte[] bArr, byte[] bArr2) {
            int i4;
            int i5;
            if (bArr.length == bArr2.length) {
                for (int i6 = 0; i6 < bArr.length; i6++) {
                    if (bArr[i6] != bArr2[i6]) {
                        i4 = bArr[i6];
                        i5 = bArr2[i6];
                    }
                }
                return 0;
            }
            i4 = bArr.length;
            i5 = bArr2.length;
            return i4 - i5;
        }
    }

    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        private final int f6245a;

        /* renamed from: b, reason: collision with root package name */
        private final f[] f6246b;

        public e(int i4, f[] fVarArr) {
            this.f6245a = i4;
            this.f6246b = fVarArr;
        }

        public f[] a() {
            return this.f6246b;
        }

        public int b() {
            return this.f6245a;
        }
    }

    /* loaded from: classes.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        private final Uri f6247a;

        /* renamed from: b, reason: collision with root package name */
        private final int f6248b;

        /* renamed from: c, reason: collision with root package name */
        private final int f6249c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f6250d;

        /* renamed from: e, reason: collision with root package name */
        private final int f6251e;

        public f(Uri uri, int i4, int i5, boolean z4, int i6) {
            this.f6247a = (Uri) h.c(uri);
            this.f6248b = i4;
            this.f6249c = i5;
            this.f6250d = z4;
            this.f6251e = i6;
        }

        public int a() {
            return this.f6251e;
        }

        public int b() {
            return this.f6248b;
        }

        public Uri c() {
            return this.f6247a;
        }

        public int d() {
            return this.f6249c;
        }

        public boolean e() {
            return this.f6250d;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class g {

        /* renamed from: a, reason: collision with root package name */
        final Typeface f6252a;

        /* renamed from: b, reason: collision with root package name */
        final int f6253b;

        g(Typeface typeface, int i4) {
            this.f6252a = typeface;
            this.f6253b = i4;
        }
    }

    private static List<byte[]> a(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return arrayList;
    }

    private static boolean b(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i4 = 0; i4 < list.size(); i4++) {
            if (!Arrays.equals(list.get(i4), list2.get(i4))) {
                return false;
            }
        }
        return true;
    }

    public static e c(Context context, CancellationSignal cancellationSignal, v.a aVar) {
        ProviderInfo h4 = h(context.getPackageManager(), aVar, context.getResources());
        return h4 == null ? new e(1, null) : new e(0, e(context, aVar, h4.authority, cancellationSignal));
    }

    private static List<List<byte[]>> d(v.a aVar, Resources resources) {
        return aVar.a() != null ? aVar.a() : p.a.c(resources, aVar.b());
    }

    static f[] e(Context context, v.a aVar, String str, CancellationSignal cancellationSignal) {
        ArrayList arrayList = new ArrayList();
        Uri build = new Uri.Builder().scheme("content").authority(str).build();
        Uri build2 = new Uri.Builder().scheme("content").authority(str).appendPath("file").build();
        Cursor cursor = null;
        try {
            cursor = context.getContentResolver().query(build, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{aVar.f()}, null, cancellationSignal);
            if (cursor != null && cursor.getCount() > 0) {
                int columnIndex = cursor.getColumnIndex("result_code");
                ArrayList arrayList2 = new ArrayList();
                int columnIndex2 = cursor.getColumnIndex("_id");
                int columnIndex3 = cursor.getColumnIndex("file_id");
                int columnIndex4 = cursor.getColumnIndex("font_ttc_index");
                int columnIndex5 = cursor.getColumnIndex("font_weight");
                int columnIndex6 = cursor.getColumnIndex("font_italic");
                while (cursor.moveToNext()) {
                    int i4 = columnIndex != -1 ? cursor.getInt(columnIndex) : 0;
                    arrayList2.add(new f(columnIndex3 == -1 ? ContentUris.withAppendedId(build, cursor.getLong(columnIndex2)) : ContentUris.withAppendedId(build2, cursor.getLong(columnIndex3)), columnIndex4 != -1 ? cursor.getInt(columnIndex4) : 0, columnIndex5 != -1 ? cursor.getInt(columnIndex5) : 400, columnIndex6 != -1 && cursor.getInt(columnIndex6) == 1, i4));
                }
                arrayList = arrayList2;
            }
            return (f[]) arrayList.toArray(new f[0]);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    static g f(Context context, v.a aVar, int i4) {
        try {
            e c5 = c(context, null, aVar);
            if (c5.b() != 0) {
                return new g(null, c5.b() == 1 ? -2 : -3);
            }
            Typeface b5 = q.b.b(context, null, c5.a(), i4);
            return new g(b5, b5 != null ? 0 : -3);
        } catch (PackageManager.NameNotFoundException unused) {
            return new g(null, -1);
        }
    }

    public static Typeface g(Context context, v.a aVar, b.a aVar2, Handler handler, boolean z4, int i4, int i5) {
        String str = aVar.c() + "-" + i5;
        Typeface c5 = f6233a.c(str);
        if (c5 != null) {
            if (aVar2 != null) {
                aVar2.d(c5);
            }
            return c5;
        }
        if (z4 && i4 == -1) {
            g f4 = f(context, aVar, i5);
            if (aVar2 != null) {
                int i6 = f4.f6253b;
                if (i6 == 0) {
                    aVar2.b(f4.f6252a, handler);
                } else {
                    aVar2.a(i6, handler);
                }
            }
            return f4.f6252a;
        }
        a aVar3 = new a(context, aVar, i5, str);
        if (z4) {
            try {
                return ((g) f6234b.e(aVar3, i4)).f6252a;
            } catch (InterruptedException unused) {
                return null;
            }
        }
        C0082b c0082b = aVar2 == null ? null : new C0082b(aVar2, handler);
        synchronized (f6235c) {
            k.g<String, ArrayList<c.d<g>>> gVar = f6236d;
            ArrayList<c.d<g>> arrayList = gVar.get(str);
            if (arrayList != null) {
                if (c0082b != null) {
                    arrayList.add(c0082b);
                }
                return null;
            }
            if (c0082b != null) {
                ArrayList<c.d<g>> arrayList2 = new ArrayList<>();
                arrayList2.add(c0082b);
                gVar.put(str, arrayList2);
            }
            f6234b.d(aVar3, new c(str));
            return null;
        }
    }

    public static ProviderInfo h(PackageManager packageManager, v.a aVar, Resources resources) {
        String d5 = aVar.d();
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(d5, 0);
        if (resolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException("No package found for authority: " + d5);
        }
        if (!resolveContentProvider.packageName.equals(aVar.e())) {
            throw new PackageManager.NameNotFoundException("Found content provider " + d5 + ", but package was not " + aVar.e());
        }
        List<byte[]> a5 = a(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
        Collections.sort(a5, f6237e);
        List<List<byte[]>> d6 = d(aVar, resources);
        for (int i4 = 0; i4 < d6.size(); i4++) {
            ArrayList arrayList = new ArrayList(d6.get(i4));
            Collections.sort(arrayList, f6237e);
            if (b(a5, arrayList)) {
                return resolveContentProvider;
            }
        }
        return null;
    }

    public static Map<Uri, ByteBuffer> i(Context context, f[] fVarArr, CancellationSignal cancellationSignal) {
        HashMap hashMap = new HashMap();
        for (f fVar : fVarArr) {
            if (fVar.a() == 0) {
                Uri c5 = fVar.c();
                if (!hashMap.containsKey(c5)) {
                    hashMap.put(c5, i.f(context, cancellationSignal, c5));
                }
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }
}
