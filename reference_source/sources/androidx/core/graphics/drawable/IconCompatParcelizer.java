package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import androidx.versionedparcelable.a;

/* loaded from: classes.dex */
public class IconCompatParcelizer {
    public static IconCompat read(a aVar) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f1336a = aVar.p(iconCompat.f1336a, 1);
        iconCompat.f1338c = aVar.j(iconCompat.f1338c, 2);
        iconCompat.f1339d = aVar.r(iconCompat.f1339d, 3);
        iconCompat.f1340e = aVar.p(iconCompat.f1340e, 4);
        iconCompat.f1341f = aVar.p(iconCompat.f1341f, 5);
        iconCompat.f1342g = (ColorStateList) aVar.r(iconCompat.f1342g, 6);
        iconCompat.f1344i = aVar.t(iconCompat.f1344i, 7);
        iconCompat.e();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, a aVar) {
        aVar.x(true, true);
        iconCompat.f(aVar.f());
        int i4 = iconCompat.f1336a;
        if (-1 != i4) {
            aVar.F(i4, 1);
        }
        byte[] bArr = iconCompat.f1338c;
        if (bArr != null) {
            aVar.B(bArr, 2);
        }
        Parcelable parcelable = iconCompat.f1339d;
        if (parcelable != null) {
            aVar.H(parcelable, 3);
        }
        int i5 = iconCompat.f1340e;
        if (i5 != 0) {
            aVar.F(i5, 4);
        }
        int i6 = iconCompat.f1341f;
        if (i6 != 0) {
            aVar.F(i6, 5);
        }
        ColorStateList colorStateList = iconCompat.f1342g;
        if (colorStateList != null) {
            aVar.H(colorStateList, 6);
        }
        String str = iconCompat.f1344i;
        if (str != null) {
            aVar.J(str, 7);
        }
    }
}
