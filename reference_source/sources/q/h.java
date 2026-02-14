package q;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;
import p.a;
import v.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<Long, a.b> f5522a = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements b<b.f> {
        a() {
        }

        @Override // q.h.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int a(b.f fVar) {
            return fVar.d();
        }

        @Override // q.h.b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean b(b.f fVar) {
            return fVar.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface b<T> {
        int a(T t4);

        boolean b(T t4);
    }

    private static <T> T e(T[] tArr, int i4, b<T> bVar) {
        int i5 = (i4 & 1) == 0 ? 400 : 700;
        boolean z4 = (i4 & 2) != 0;
        T t4 = null;
        int i6 = Integer.MAX_VALUE;
        for (T t5 : tArr) {
            int abs = (Math.abs(bVar.a(t5) - i5) * 2) + (bVar.b(t5) == z4 ? 0 : 1);
            if (t4 == null || i6 > abs) {
                t4 = t5;
                i6 = abs;
            }
        }
        return t4;
    }

    public Typeface a(Context context, a.b bVar, Resources resources, int i4) {
        throw null;
    }

    public Typeface b(Context context, CancellationSignal cancellationSignal, b.f[] fVarArr, int i4) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Typeface c(Context context, InputStream inputStream) {
        File e4 = i.e(context);
        if (e4 == null) {
            return null;
        }
        try {
            if (i.d(e4, inputStream)) {
                return Typeface.createFromFile(e4.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            e4.delete();
        }
    }

    public Typeface d(Context context, Resources resources, int i4, String str, int i5) {
        File e4 = i.e(context);
        if (e4 == null) {
            return null;
        }
        try {
            if (i.c(e4, resources, i4)) {
                return Typeface.createFromFile(e4.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            e4.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b.f f(b.f[] fVarArr, int i4) {
        return (b.f) e(fVarArr, i4, new a());
    }
}
