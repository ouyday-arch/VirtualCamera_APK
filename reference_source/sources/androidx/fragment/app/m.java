package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.lifecycle.d;

/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class m implements Parcelable {
    public static final Parcelable.Creator<m> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    final String f1570b;

    /* renamed from: c, reason: collision with root package name */
    final String f1571c;

    /* renamed from: d, reason: collision with root package name */
    final boolean f1572d;

    /* renamed from: e, reason: collision with root package name */
    final int f1573e;

    /* renamed from: f, reason: collision with root package name */
    final int f1574f;

    /* renamed from: g, reason: collision with root package name */
    final String f1575g;

    /* renamed from: h, reason: collision with root package name */
    final boolean f1576h;

    /* renamed from: i, reason: collision with root package name */
    final boolean f1577i;

    /* renamed from: j, reason: collision with root package name */
    final boolean f1578j;

    /* renamed from: k, reason: collision with root package name */
    final Bundle f1579k;

    /* renamed from: l, reason: collision with root package name */
    final boolean f1580l;

    /* renamed from: m, reason: collision with root package name */
    final int f1581m;

    /* renamed from: n, reason: collision with root package name */
    Bundle f1582n;

    /* renamed from: o, reason: collision with root package name */
    Fragment f1583o;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<m> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public m createFromParcel(Parcel parcel) {
            return new m(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public m[] newArray(int i4) {
            return new m[i4];
        }
    }

    m(Parcel parcel) {
        this.f1570b = parcel.readString();
        this.f1571c = parcel.readString();
        this.f1572d = parcel.readInt() != 0;
        this.f1573e = parcel.readInt();
        this.f1574f = parcel.readInt();
        this.f1575g = parcel.readString();
        this.f1576h = parcel.readInt() != 0;
        this.f1577i = parcel.readInt() != 0;
        this.f1578j = parcel.readInt() != 0;
        this.f1579k = parcel.readBundle();
        this.f1580l = parcel.readInt() != 0;
        this.f1582n = parcel.readBundle();
        this.f1581m = parcel.readInt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Fragment fragment) {
        this.f1570b = fragment.getClass().getName();
        this.f1571c = fragment.f1413f;
        this.f1572d = fragment.f1421n;
        this.f1573e = fragment.f1430w;
        this.f1574f = fragment.f1431x;
        this.f1575g = fragment.f1432y;
        this.f1576h = fragment.B;
        this.f1577i = fragment.f1420m;
        this.f1578j = fragment.A;
        this.f1579k = fragment.f1414g;
        this.f1580l = fragment.f1433z;
        this.f1581m = fragment.S.ordinal();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Fragment f(ClassLoader classLoader, g gVar) {
        Fragment fragment;
        Bundle bundle;
        if (this.f1583o == null) {
            Bundle bundle2 = this.f1579k;
            if (bundle2 != null) {
                bundle2.setClassLoader(classLoader);
            }
            Fragment a5 = gVar.a(classLoader, this.f1570b);
            this.f1583o = a5;
            a5.g1(this.f1579k);
            Bundle bundle3 = this.f1582n;
            if (bundle3 != null) {
                bundle3.setClassLoader(classLoader);
                fragment = this.f1583o;
                bundle = this.f1582n;
            } else {
                fragment = this.f1583o;
                bundle = new Bundle();
            }
            fragment.f1410c = bundle;
            Fragment fragment2 = this.f1583o;
            fragment2.f1413f = this.f1571c;
            fragment2.f1421n = this.f1572d;
            fragment2.f1423p = true;
            fragment2.f1430w = this.f1573e;
            fragment2.f1431x = this.f1574f;
            fragment2.f1432y = this.f1575g;
            fragment2.B = this.f1576h;
            fragment2.f1420m = this.f1577i;
            fragment2.A = this.f1578j;
            fragment2.f1433z = this.f1580l;
            fragment2.S = d.b.values()[this.f1581m];
            if (j.I) {
                Log.v("FragmentManager", "Instantiated fragment " + this.f1583o);
            }
        }
        return this.f1583o;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f1570b);
        sb.append(" (");
        sb.append(this.f1571c);
        sb.append(")}:");
        if (this.f1572d) {
            sb.append(" fromLayout");
        }
        if (this.f1574f != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f1574f));
        }
        String str = this.f1575g;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.f1575g);
        }
        if (this.f1576h) {
            sb.append(" retainInstance");
        }
        if (this.f1577i) {
            sb.append(" removing");
        }
        if (this.f1578j) {
            sb.append(" detached");
        }
        if (this.f1580l) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f1570b);
        parcel.writeString(this.f1571c);
        parcel.writeInt(this.f1572d ? 1 : 0);
        parcel.writeInt(this.f1573e);
        parcel.writeInt(this.f1574f);
        parcel.writeString(this.f1575g);
        parcel.writeInt(this.f1576h ? 1 : 0);
        parcel.writeInt(this.f1577i ? 1 : 0);
        parcel.writeInt(this.f1578j ? 1 : 0);
        parcel.writeBundle(this.f1579k);
        parcel.writeInt(this.f1580l ? 1 : 0);
        parcel.writeBundle(this.f1582n);
        parcel.writeInt(this.f1581m);
    }
}
