package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class k implements Parcelable {
    public static final Parcelable.Creator<k> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    ArrayList<m> f1558b;

    /* renamed from: c, reason: collision with root package name */
    ArrayList<String> f1559c;

    /* renamed from: d, reason: collision with root package name */
    b[] f1560d;

    /* renamed from: e, reason: collision with root package name */
    String f1561e;

    /* renamed from: f, reason: collision with root package name */
    int f1562f;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<k> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public k createFromParcel(Parcel parcel) {
            return new k(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public k[] newArray(int i4) {
            return new k[i4];
        }
    }

    public k() {
        this.f1561e = null;
    }

    public k(Parcel parcel) {
        this.f1561e = null;
        this.f1558b = parcel.createTypedArrayList(m.CREATOR);
        this.f1559c = parcel.createStringArrayList();
        this.f1560d = (b[]) parcel.createTypedArray(b.CREATOR);
        this.f1561e = parcel.readString();
        this.f1562f = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeTypedList(this.f1558b);
        parcel.writeStringList(this.f1559c);
        parcel.writeTypedArray(this.f1560d, i4);
        parcel.writeString(this.f1561e);
        parcel.writeInt(this.f1562f);
    }
}
