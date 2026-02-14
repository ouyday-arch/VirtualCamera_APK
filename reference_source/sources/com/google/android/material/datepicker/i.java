package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class i implements Comparable<i>, Parcelable {
    public static final Parcelable.Creator<i> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    private final Calendar f2996b;

    /* renamed from: c, reason: collision with root package name */
    private final String f2997c;

    /* renamed from: d, reason: collision with root package name */
    final int f2998d;

    /* renamed from: e, reason: collision with root package name */
    final int f2999e;

    /* renamed from: f, reason: collision with root package name */
    final int f3000f;

    /* renamed from: g, reason: collision with root package name */
    final int f3001g;

    /* renamed from: h, reason: collision with root package name */
    final long f3002h;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<i> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public i createFromParcel(Parcel parcel) {
            return i.g(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public i[] newArray(int i4) {
            return new i[i4];
        }
    }

    private i(Calendar calendar) {
        calendar.set(5, 1);
        Calendar d5 = o.d(calendar);
        this.f2996b = d5;
        this.f2998d = d5.get(2);
        this.f2999e = d5.get(1);
        this.f3000f = d5.getMaximum(7);
        this.f3001g = d5.getActualMaximum(5);
        this.f2997c = o.l().format(d5.getTime());
        this.f3002h = d5.getTimeInMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i g(int i4, int i5) {
        Calendar i6 = o.i();
        i6.set(1, i4);
        i6.set(2, i5);
        return new i(i6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i n() {
        return new i(o.g());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.f2998d == iVar.f2998d && this.f2999e == iVar.f2999e;
    }

    @Override // java.lang.Comparable
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public int compareTo(i iVar) {
        return this.f2996b.compareTo(iVar.f2996b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h() {
        int firstDayOfWeek = this.f2996b.get(7) - this.f2996b.getFirstDayOfWeek();
        return firstDayOfWeek < 0 ? firstDayOfWeek + this.f3000f : firstDayOfWeek;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f2998d), Integer.valueOf(this.f2999e)});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long i(int i4) {
        Calendar d5 = o.d(this.f2996b);
        d5.set(5, i4);
        return d5.getTimeInMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String j() {
        return this.f2997c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long k() {
        return this.f2996b.getTimeInMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i l(int i4) {
        Calendar d5 = o.d(this.f2996b);
        d5.add(2, i4);
        return new i(d5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m(i iVar) {
        if (this.f2996b instanceof GregorianCalendar) {
            return ((iVar.f2999e - this.f2999e) * 12) + (iVar.f2998d - this.f2998d);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f2999e);
        parcel.writeInt(this.f2998d);
    }
}
