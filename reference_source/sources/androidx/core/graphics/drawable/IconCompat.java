package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Parcelable;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: j, reason: collision with root package name */
    static final PorterDuff.Mode f1335j = PorterDuff.Mode.SRC_IN;

    /* renamed from: b, reason: collision with root package name */
    Object f1337b;

    /* renamed from: a, reason: collision with root package name */
    public int f1336a = -1;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f1338c = null;

    /* renamed from: d, reason: collision with root package name */
    public Parcelable f1339d = null;

    /* renamed from: e, reason: collision with root package name */
    public int f1340e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f1341f = 0;

    /* renamed from: g, reason: collision with root package name */
    public ColorStateList f1342g = null;

    /* renamed from: h, reason: collision with root package name */
    PorterDuff.Mode f1343h = f1335j;

    /* renamed from: i, reason: collision with root package name */
    public String f1344i = null;

    private static int b(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResId();
        }
        try {
            return ((Integer) icon.getClass().getMethod("getResId", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException e4) {
            Log.e("IconCompat", "Unable to get icon resource", e4);
            return 0;
        } catch (NoSuchMethodException e5) {
            Log.e("IconCompat", "Unable to get icon resource", e5);
            return 0;
        } catch (InvocationTargetException e6) {
            Log.e("IconCompat", "Unable to get icon resource", e6);
            return 0;
        }
    }

    private static String d(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResPackage();
        }
        try {
            return (String) icon.getClass().getMethod("getResPackage", new Class[0]).invoke(icon, new Object[0]);
        } catch (IllegalAccessException e4) {
            Log.e("IconCompat", "Unable to get icon package", e4);
            return null;
        } catch (NoSuchMethodException e5) {
            Log.e("IconCompat", "Unable to get icon package", e5);
            return null;
        } catch (InvocationTargetException e6) {
            Log.e("IconCompat", "Unable to get icon package", e6);
            return null;
        }
    }

    private static String g(int i4) {
        return i4 != 1 ? i4 != 2 ? i4 != 3 ? i4 != 4 ? i4 != 5 ? "UNKNOWN" : "BITMAP_MASKABLE" : "URI" : "DATA" : "RESOURCE" : "BITMAP";
    }

    public int a() {
        int i4 = this.f1336a;
        if (i4 == -1) {
            return b((Icon) this.f1337b);
        }
        if (i4 == 2) {
            return this.f1340e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    public String c() {
        int i4 = this.f1336a;
        if (i4 == -1) {
            return d((Icon) this.f1337b);
        }
        if (i4 == 2) {
            return ((String) this.f1337b).split(":", -1)[0];
        }
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public void e() {
        Parcelable parcelable;
        this.f1343h = PorterDuff.Mode.valueOf(this.f1344i);
        int i4 = this.f1336a;
        if (i4 != -1) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 == 3) {
                        this.f1337b = this.f1338c;
                        return;
                    } else if (i4 != 4) {
                        if (i4 != 5) {
                            return;
                        }
                    }
                }
                this.f1337b = new String(this.f1338c, Charset.forName("UTF-16"));
                return;
            }
            parcelable = this.f1339d;
            if (parcelable == null) {
                byte[] bArr = this.f1338c;
                this.f1337b = bArr;
                this.f1336a = 3;
                this.f1340e = 0;
                this.f1341f = bArr.length;
                return;
            }
        } else {
            parcelable = this.f1339d;
            if (parcelable == null) {
                throw new IllegalArgumentException("Invalid icon");
            }
        }
        this.f1337b = parcelable;
    }

    public void f(boolean z4) {
        this.f1344i = this.f1343h.name();
        int i4 = this.f1336a;
        if (i4 != -1) {
            if (i4 != 1) {
                if (i4 == 2) {
                    this.f1338c = ((String) this.f1337b).getBytes(Charset.forName("UTF-16"));
                    return;
                }
                if (i4 == 3) {
                    this.f1338c = (byte[]) this.f1337b;
                    return;
                } else if (i4 == 4) {
                    this.f1338c = this.f1337b.toString().getBytes(Charset.forName("UTF-16"));
                    return;
                } else if (i4 != 5) {
                    return;
                }
            }
            if (z4) {
                Bitmap bitmap = (Bitmap) this.f1337b;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                this.f1338c = byteArrayOutputStream.toByteArray();
                return;
            }
        } else if (z4) {
            throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
        }
        this.f1339d = (Parcelable) this.f1337b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002b, code lost:
    
        if (r1 != 5) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            r4 = this;
            int r0 = r4.f1336a
            r1 = -1
            if (r0 != r1) goto Lc
            java.lang.Object r0 = r4.f1337b
            java.lang.String r0 = java.lang.String.valueOf(r0)
            return r0
        Lc:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Icon(typ="
            r0.<init>(r1)
            int r1 = r4.f1336a
            java.lang.String r1 = g(r1)
            r0.append(r1)
            int r1 = r4.f1336a
            r2 = 1
            if (r1 == r2) goto L77
            r3 = 2
            if (r1 == r3) goto L4f
            r2 = 3
            if (r1 == r2) goto L39
            r2 = 4
            if (r1 == r2) goto L2e
            r2 = 5
            if (r1 == r2) goto L77
            goto L97
        L2e:
            java.lang.String r1 = " uri="
            r0.append(r1)
            java.lang.Object r1 = r4.f1337b
            r0.append(r1)
            goto L97
        L39:
            java.lang.String r1 = " len="
            r0.append(r1)
            int r1 = r4.f1340e
            r0.append(r1)
            int r1 = r4.f1341f
            if (r1 == 0) goto L97
            java.lang.String r1 = " off="
            r0.append(r1)
            int r1 = r4.f1341f
            goto L94
        L4f:
            java.lang.String r1 = " pkg="
            r0.append(r1)
            java.lang.String r1 = r4.c()
            r0.append(r1)
            java.lang.String r1 = " id="
            r0.append(r1)
            java.lang.Object[] r1 = new java.lang.Object[r2]
            r2 = 0
            int r3 = r4.a()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r1[r2] = r3
            java.lang.String r2 = "0x%08x"
            java.lang.String r1 = java.lang.String.format(r2, r1)
            r0.append(r1)
            goto L97
        L77:
            java.lang.String r1 = " size="
            r0.append(r1)
            java.lang.Object r1 = r4.f1337b
            android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1
            int r1 = r1.getWidth()
            r0.append(r1)
            java.lang.String r1 = "x"
            r0.append(r1)
            java.lang.Object r1 = r4.f1337b
            android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1
            int r1 = r1.getHeight()
        L94:
            r0.append(r1)
        L97:
            android.content.res.ColorStateList r1 = r4.f1342g
            if (r1 == 0) goto La5
            java.lang.String r1 = " tint="
            r0.append(r1)
            android.content.res.ColorStateList r1 = r4.f1342g
            r0.append(r1)
        La5:
            android.graphics.PorterDuff$Mode r1 = r4.f1343h
            android.graphics.PorterDuff$Mode r2 = androidx.core.graphics.drawable.IconCompat.f1335j
            if (r1 == r2) goto Lb5
            java.lang.String r1 = " mode="
            r0.append(r1)
            android.graphics.PorterDuff$Mode r1 = r4.f1343h
            r0.append(r1)
        Lb5:
            java.lang.String r1 = ")"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.drawable.IconCompat.toString():java.lang.String");
    }
}
