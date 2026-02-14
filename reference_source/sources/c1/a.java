package c1;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import k.g;

/* loaded from: classes.dex */
public class a extends b0.a {
    public static final Parcelable.Creator<a> CREATOR = new C0024a();

    /* renamed from: d, reason: collision with root package name */
    public final g<String, Bundle> f2444d;

    /* renamed from: c1.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0024a implements Parcelable.ClassLoaderCreator<a> {
        C0024a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel, null, 0 == true ? 1 : 0);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return new a(parcel, classLoader, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i4) {
            return new a[i4];
        }
    }

    private a(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        int readInt = parcel.readInt();
        String[] strArr = new String[readInt];
        parcel.readStringArray(strArr);
        Bundle[] bundleArr = new Bundle[readInt];
        parcel.readTypedArray(bundleArr, Bundle.CREATOR);
        this.f2444d = new g<>(readInt);
        for (int i4 = 0; i4 < readInt; i4++) {
            this.f2444d.put(strArr[i4], bundleArr[i4]);
        }
    }

    /* synthetic */ a(Parcel parcel, ClassLoader classLoader, C0024a c0024a) {
        this(parcel, classLoader);
    }

    public a(Parcelable parcelable) {
        super(parcelable);
        this.f2444d = new g<>();
    }

    public String toString() {
        return "ExtendableSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " states=" + this.f2444d + "}";
    }

    @Override // b0.a, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        int size = this.f2444d.size();
        parcel.writeInt(size);
        String[] strArr = new String[size];
        Bundle[] bundleArr = new Bundle[size];
        for (int i5 = 0; i5 < size; i5++) {
            strArr[i5] = this.f2444d.i(i5);
            bundleArr[i5] = this.f2444d.m(i5);
        }
        parcel.writeStringArray(strArr);
        parcel.writeTypedArray(bundleArr, 0);
    }
}
