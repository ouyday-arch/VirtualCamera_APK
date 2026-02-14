package q;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import java.io.IOException;
import p.a;
import v.b;

/* loaded from: classes.dex */
public class g extends h {
    @Override // q.h
    public Typeface a(Context context, a.b bVar, Resources resources, int i4) {
        a.c[] a5 = bVar.a();
        int length = a5.length;
        FontFamily.Builder builder = null;
        int i5 = 0;
        while (true) {
            int i6 = 1;
            if (i5 >= length) {
                break;
            }
            a.c cVar = a5[i5];
            try {
                Font.Builder weight = new Font.Builder(resources, cVar.b()).setWeight(cVar.e());
                if (!cVar.f()) {
                    i6 = 0;
                }
                Font build = weight.setSlant(i6).setTtcIndex(cVar.c()).setFontVariationSettings(cVar.d()).build();
                if (builder == null) {
                    builder = new FontFamily.Builder(build);
                } else {
                    builder.addFont(build);
                }
            } catch (IOException unused) {
            }
            i5++;
        }
        if (builder == null) {
            return null;
        }
        return new Typeface.CustomFallbackBuilder(builder.build()).setStyle(new FontStyle((i4 & 1) != 0 ? 700 : 400, (i4 & 2) != 0 ? 1 : 0)).build();
    }

    @Override // q.h
    public Typeface b(Context context, CancellationSignal cancellationSignal, b.f[] fVarArr, int i4) {
        ParcelFileDescriptor openFileDescriptor;
        ContentResolver contentResolver = context.getContentResolver();
        int length = fVarArr.length;
        FontFamily.Builder builder = null;
        int i5 = 0;
        while (true) {
            int i6 = 1;
            if (i5 >= length) {
                if (builder == null) {
                    return null;
                }
                return new Typeface.CustomFallbackBuilder(builder.build()).setStyle(new FontStyle((i4 & 1) != 0 ? 700 : 400, (i4 & 2) != 0 ? 1 : 0)).build();
            }
            b.f fVar = fVarArr[i5];
            try {
                openFileDescriptor = contentResolver.openFileDescriptor(fVar.c(), "r", cancellationSignal);
            } catch (IOException unused) {
                continue;
            }
            if (openFileDescriptor != null) {
                try {
                    Font.Builder weight = new Font.Builder(openFileDescriptor).setWeight(fVar.d());
                    if (!fVar.e()) {
                        i6 = 0;
                    }
                    Font build = weight.setSlant(i6).setTtcIndex(fVar.b()).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(build);
                    } else {
                        builder.addFont(build);
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                        break;
                    } catch (Throwable th2) {
                        try {
                            openFileDescriptor.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                        throw th2;
                        break;
                    }
                }
            } else if (openFileDescriptor == null) {
                i5++;
            }
            openFileDescriptor.close();
            i5++;
        }
    }

    @Override // q.h
    public Typeface d(Context context, Resources resources, int i4, String str, int i5) {
        try {
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(new Font.Builder(resources, i4).build()).build()).setStyle(new FontStyle((i5 & 1) != 0 ? 700 : 400, (i5 & 2) != 0 ? 1 : 0)).build();
        } catch (IOException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // q.h
    public b.f f(b.f[] fVarArr, int i4) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }
}
