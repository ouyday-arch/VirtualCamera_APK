package p2;

import android.graphics.Bitmap;
import g1.v;
import java.util.Map;

/* loaded from: classes.dex */
public class b {
    public Bitmap a(n1.b bVar) {
        int l4 = bVar.l();
        int h4 = bVar.h();
        int[] iArr = new int[l4 * h4];
        for (int i4 = 0; i4 < h4; i4++) {
            int i5 = i4 * l4;
            for (int i6 = 0; i6 < l4; i6++) {
                iArr[i5 + i6] = bVar.e(i6, i4) ? -16777216 : -1;
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(l4, h4, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr, 0, l4, 0, 0, l4, h4);
        return createBitmap;
    }

    public n1.b b(String str, g1.a aVar, int i4, int i5, Map<g1.g, ?> map) {
        try {
            return new g1.l().a(str, aVar, i4, i5, map);
        } catch (v e4) {
            throw e4;
        } catch (Exception e5) {
            throw new v(e5);
        }
    }

    public Bitmap c(String str, g1.a aVar, int i4, int i5, Map<g1.g, ?> map) {
        return a(b(str, aVar, i4, i5, map));
    }
}
