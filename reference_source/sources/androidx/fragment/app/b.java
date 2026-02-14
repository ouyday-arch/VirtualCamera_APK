package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.n;
import androidx.lifecycle.d;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    final int[] f1458b;

    /* renamed from: c, reason: collision with root package name */
    final ArrayList<String> f1459c;

    /* renamed from: d, reason: collision with root package name */
    final int[] f1460d;

    /* renamed from: e, reason: collision with root package name */
    final int[] f1461e;

    /* renamed from: f, reason: collision with root package name */
    final int f1462f;

    /* renamed from: g, reason: collision with root package name */
    final int f1463g;

    /* renamed from: h, reason: collision with root package name */
    final String f1464h;

    /* renamed from: i, reason: collision with root package name */
    final int f1465i;

    /* renamed from: j, reason: collision with root package name */
    final int f1466j;

    /* renamed from: k, reason: collision with root package name */
    final CharSequence f1467k;

    /* renamed from: l, reason: collision with root package name */
    final int f1468l;

    /* renamed from: m, reason: collision with root package name */
    final CharSequence f1469m;

    /* renamed from: n, reason: collision with root package name */
    final ArrayList<String> f1470n;

    /* renamed from: o, reason: collision with root package name */
    final ArrayList<String> f1471o;

    /* renamed from: p, reason: collision with root package name */
    final boolean f1472p;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<b> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public b[] newArray(int i4) {
            return new b[i4];
        }
    }

    public b(Parcel parcel) {
        this.f1458b = parcel.createIntArray();
        this.f1459c = parcel.createStringArrayList();
        this.f1460d = parcel.createIntArray();
        this.f1461e = parcel.createIntArray();
        this.f1462f = parcel.readInt();
        this.f1463g = parcel.readInt();
        this.f1464h = parcel.readString();
        this.f1465i = parcel.readInt();
        this.f1466j = parcel.readInt();
        this.f1467k = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f1468l = parcel.readInt();
        this.f1469m = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f1470n = parcel.createStringArrayList();
        this.f1471o = parcel.createStringArrayList();
        this.f1472p = parcel.readInt() != 0;
    }

    public b(androidx.fragment.app.a aVar) {
        int size = aVar.f1584a.size();
        this.f1458b = new int[size * 5];
        if (!aVar.f1591h) {
            throw new IllegalStateException("Not on back stack");
        }
        this.f1459c = new ArrayList<>(size);
        this.f1460d = new int[size];
        this.f1461e = new int[size];
        int i4 = 0;
        int i5 = 0;
        while (i4 < size) {
            n.a aVar2 = aVar.f1584a.get(i4);
            int i6 = i5 + 1;
            this.f1458b[i5] = aVar2.f1602a;
            ArrayList<String> arrayList = this.f1459c;
            Fragment fragment = aVar2.f1603b;
            arrayList.add(fragment != null ? fragment.f1413f : null);
            int[] iArr = this.f1458b;
            int i7 = i6 + 1;
            iArr[i6] = aVar2.f1604c;
            int i8 = i7 + 1;
            iArr[i7] = aVar2.f1605d;
            int i9 = i8 + 1;
            iArr[i8] = aVar2.f1606e;
            iArr[i9] = aVar2.f1607f;
            this.f1460d[i4] = aVar2.f1608g.ordinal();
            this.f1461e[i4] = aVar2.f1609h.ordinal();
            i4++;
            i5 = i9 + 1;
        }
        this.f1462f = aVar.f1589f;
        this.f1463g = aVar.f1590g;
        this.f1464h = aVar.f1593j;
        this.f1465i = aVar.f1457u;
        this.f1466j = aVar.f1594k;
        this.f1467k = aVar.f1595l;
        this.f1468l = aVar.f1596m;
        this.f1469m = aVar.f1597n;
        this.f1470n = aVar.f1598o;
        this.f1471o = aVar.f1599p;
        this.f1472p = aVar.f1600q;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public androidx.fragment.app.a f(j jVar) {
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(jVar);
        int i4 = 0;
        int i5 = 0;
        while (i4 < this.f1458b.length) {
            n.a aVar2 = new n.a();
            int i6 = i4 + 1;
            aVar2.f1602a = this.f1458b[i4];
            if (j.I) {
                Log.v("FragmentManager", "Instantiate " + aVar + " op #" + i5 + " base fragment #" + this.f1458b[i6]);
            }
            String str = this.f1459c.get(i5);
            aVar2.f1603b = str != null ? jVar.f1508h.get(str) : null;
            aVar2.f1608g = d.b.values()[this.f1460d[i5]];
            aVar2.f1609h = d.b.values()[this.f1461e[i5]];
            int[] iArr = this.f1458b;
            int i7 = i6 + 1;
            int i8 = iArr[i6];
            aVar2.f1604c = i8;
            int i9 = i7 + 1;
            int i10 = iArr[i7];
            aVar2.f1605d = i10;
            int i11 = i9 + 1;
            int i12 = iArr[i9];
            aVar2.f1606e = i12;
            int i13 = iArr[i11];
            aVar2.f1607f = i13;
            aVar.f1585b = i8;
            aVar.f1586c = i10;
            aVar.f1587d = i12;
            aVar.f1588e = i13;
            aVar.c(aVar2);
            i5++;
            i4 = i11 + 1;
        }
        aVar.f1589f = this.f1462f;
        aVar.f1590g = this.f1463g;
        aVar.f1593j = this.f1464h;
        aVar.f1457u = this.f1465i;
        aVar.f1591h = true;
        aVar.f1594k = this.f1466j;
        aVar.f1595l = this.f1467k;
        aVar.f1596m = this.f1468l;
        aVar.f1597n = this.f1469m;
        aVar.f1598o = this.f1470n;
        aVar.f1599p = this.f1471o;
        aVar.f1600q = this.f1472p;
        aVar.i(1);
        return aVar;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeIntArray(this.f1458b);
        parcel.writeStringList(this.f1459c);
        parcel.writeIntArray(this.f1460d);
        parcel.writeIntArray(this.f1461e);
        parcel.writeInt(this.f1462f);
        parcel.writeInt(this.f1463g);
        parcel.writeString(this.f1464h);
        parcel.writeInt(this.f1465i);
        parcel.writeInt(this.f1466j);
        TextUtils.writeToParcel(this.f1467k, parcel, 0);
        parcel.writeInt(this.f1468l);
        TextUtils.writeToParcel(this.f1469m, parcel, 0);
        parcel.writeStringList(this.f1470n);
        parcel.writeStringList(this.f1471o);
        parcel.writeInt(this.f1472p ? 1 : 0);
    }
}
