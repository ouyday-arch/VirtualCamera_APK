package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0028a();

    /* renamed from: b, reason: collision with root package name */
    private final i f2936b;

    /* renamed from: c, reason: collision with root package name */
    private final i f2937c;

    /* renamed from: d, reason: collision with root package name */
    private final i f2938d;

    /* renamed from: e, reason: collision with root package name */
    private final b f2939e;

    /* renamed from: f, reason: collision with root package name */
    private final int f2940f;

    /* renamed from: g, reason: collision with root package name */
    private final int f2941g;

    /* renamed from: com.google.android.material.datepicker.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0028a implements Parcelable.Creator<a> {
        C0028a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return new a((i) parcel.readParcelable(i.class.getClassLoader()), (i) parcel.readParcelable(i.class.getClassLoader()), (i) parcel.readParcelable(i.class.getClassLoader()), (b) parcel.readParcelable(b.class.getClassLoader()), null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i4) {
            return new a[i4];
        }
    }

    /* loaded from: classes.dex */
    public interface b extends Parcelable {
        boolean c(long j4);
    }

    private a(i iVar, i iVar2, i iVar3, b bVar) {
        this.f2936b = iVar;
        this.f2937c = iVar2;
        this.f2938d = iVar3;
        this.f2939e = bVar;
        if (iVar.compareTo(iVar3) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (iVar3.compareTo(iVar2) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        this.f2941g = iVar.m(iVar2) + 1;
        this.f2940f = (iVar2.f2999e - iVar.f2999e) + 1;
    }

    /* synthetic */ a(i iVar, i iVar2, i iVar3, b bVar, C0028a c0028a) {
        this(iVar, iVar2, iVar3, bVar);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f2936b.equals(aVar.f2936b) && this.f2937c.equals(aVar.f2937c) && this.f2938d.equals(aVar.f2938d) && this.f2939e.equals(aVar.f2939e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i f(i iVar) {
        return iVar.compareTo(this.f2936b) < 0 ? this.f2936b : iVar.compareTo(this.f2937c) > 0 ? this.f2937c : iVar;
    }

    public b g() {
        return this.f2939e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i h() {
        return this.f2937c;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2936b, this.f2937c, this.f2938d, this.f2939e});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i() {
        return this.f2941g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i j() {
        return this.f2938d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i k() {
        return this.f2936b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int l() {
        return this.f2940f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeParcelable(this.f2936b, 0);
        parcel.writeParcelable(this.f2937c, 0);
        parcel.writeParcelable(this.f2938d, 0);
        parcel.writeParcelable(this.f2939e, 0);
    }
}
