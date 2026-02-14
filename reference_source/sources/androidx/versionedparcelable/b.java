package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
class b extends a {

    /* renamed from: d, reason: collision with root package name */
    private final SparseIntArray f2114d;

    /* renamed from: e, reason: collision with root package name */
    private final Parcel f2115e;

    /* renamed from: f, reason: collision with root package name */
    private final int f2116f;

    /* renamed from: g, reason: collision with root package name */
    private final int f2117g;

    /* renamed from: h, reason: collision with root package name */
    private final String f2118h;

    /* renamed from: i, reason: collision with root package name */
    private int f2119i;

    /* renamed from: j, reason: collision with root package name */
    private int f2120j;

    /* renamed from: k, reason: collision with root package name */
    private int f2121k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new k.a(), new k.a(), new k.a());
    }

    private b(Parcel parcel, int i4, int i5, String str, k.a<String, Method> aVar, k.a<String, Method> aVar2, k.a<String, Class> aVar3) {
        super(aVar, aVar2, aVar3);
        this.f2114d = new SparseIntArray();
        this.f2119i = -1;
        this.f2121k = -1;
        this.f2115e = parcel;
        this.f2116f = i4;
        this.f2117g = i5;
        this.f2120j = i4;
        this.f2118h = str;
    }

    @Override // androidx.versionedparcelable.a
    public void A(byte[] bArr) {
        if (bArr == null) {
            this.f2115e.writeInt(-1);
        } else {
            this.f2115e.writeInt(bArr.length);
            this.f2115e.writeByteArray(bArr);
        }
    }

    @Override // androidx.versionedparcelable.a
    protected void C(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f2115e, 0);
    }

    @Override // androidx.versionedparcelable.a
    public void E(int i4) {
        this.f2115e.writeInt(i4);
    }

    @Override // androidx.versionedparcelable.a
    public void G(Parcelable parcelable) {
        this.f2115e.writeParcelable(parcelable, 0);
    }

    @Override // androidx.versionedparcelable.a
    public void I(String str) {
        this.f2115e.writeString(str);
    }

    @Override // androidx.versionedparcelable.a
    public void a() {
        int i4 = this.f2119i;
        if (i4 >= 0) {
            int i5 = this.f2114d.get(i4);
            int dataPosition = this.f2115e.dataPosition();
            this.f2115e.setDataPosition(i5);
            this.f2115e.writeInt(dataPosition - i5);
            this.f2115e.setDataPosition(dataPosition);
        }
    }

    @Override // androidx.versionedparcelable.a
    protected a b() {
        Parcel parcel = this.f2115e;
        int dataPosition = parcel.dataPosition();
        int i4 = this.f2120j;
        if (i4 == this.f2116f) {
            i4 = this.f2117g;
        }
        return new b(parcel, dataPosition, i4, this.f2118h + "  ", this.f2111a, this.f2112b, this.f2113c);
    }

    @Override // androidx.versionedparcelable.a
    public boolean g() {
        return this.f2115e.readInt() != 0;
    }

    @Override // androidx.versionedparcelable.a
    public byte[] i() {
        int readInt = this.f2115e.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.f2115e.readByteArray(bArr);
        return bArr;
    }

    @Override // androidx.versionedparcelable.a
    protected CharSequence k() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f2115e);
    }

    @Override // androidx.versionedparcelable.a
    public boolean m(int i4) {
        while (this.f2120j < this.f2117g) {
            int i5 = this.f2121k;
            if (i5 == i4) {
                return true;
            }
            if (String.valueOf(i5).compareTo(String.valueOf(i4)) > 0) {
                return false;
            }
            this.f2115e.setDataPosition(this.f2120j);
            int readInt = this.f2115e.readInt();
            this.f2121k = this.f2115e.readInt();
            this.f2120j += readInt;
        }
        return this.f2121k == i4;
    }

    @Override // androidx.versionedparcelable.a
    public int o() {
        return this.f2115e.readInt();
    }

    @Override // androidx.versionedparcelable.a
    public <T extends Parcelable> T q() {
        return (T) this.f2115e.readParcelable(getClass().getClassLoader());
    }

    @Override // androidx.versionedparcelable.a
    public String s() {
        return this.f2115e.readString();
    }

    @Override // androidx.versionedparcelable.a
    public void w(int i4) {
        a();
        this.f2119i = i4;
        this.f2114d.put(i4, this.f2115e.dataPosition());
        E(0);
        E(i4);
    }

    @Override // androidx.versionedparcelable.a
    public void y(boolean z4) {
        this.f2115e.writeInt(z4 ? 1 : 0);
    }
}
