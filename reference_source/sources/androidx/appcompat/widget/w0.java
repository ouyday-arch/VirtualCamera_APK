package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import p.b;

/* loaded from: classes.dex */
public class w0 {

    /* renamed from: a, reason: collision with root package name */
    private final Context f1213a;

    /* renamed from: b, reason: collision with root package name */
    private final TypedArray f1214b;

    /* renamed from: c, reason: collision with root package name */
    private TypedValue f1215c;

    private w0(Context context, TypedArray typedArray) {
        this.f1213a = context;
        this.f1214b = typedArray;
    }

    public static w0 s(Context context, int i4, int[] iArr) {
        return new w0(context, context.obtainStyledAttributes(i4, iArr));
    }

    public static w0 t(Context context, AttributeSet attributeSet, int[] iArr) {
        return new w0(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static w0 u(Context context, AttributeSet attributeSet, int[] iArr, int i4, int i5) {
        return new w0(context, context.obtainStyledAttributes(attributeSet, iArr, i4, i5));
    }

    public boolean a(int i4, boolean z4) {
        return this.f1214b.getBoolean(i4, z4);
    }

    public int b(int i4, int i5) {
        return this.f1214b.getColor(i4, i5);
    }

    public ColorStateList c(int i4) {
        int resourceId;
        ColorStateList a5;
        return (!this.f1214b.hasValue(i4) || (resourceId = this.f1214b.getResourceId(i4, 0)) == 0 || (a5 = c.a.a(this.f1213a, resourceId)) == null) ? this.f1214b.getColorStateList(i4) : a5;
    }

    public float d(int i4, float f4) {
        return this.f1214b.getDimension(i4, f4);
    }

    public int e(int i4, int i5) {
        return this.f1214b.getDimensionPixelOffset(i4, i5);
    }

    public int f(int i4, int i5) {
        return this.f1214b.getDimensionPixelSize(i4, i5);
    }

    public Drawable g(int i4) {
        int resourceId;
        return (!this.f1214b.hasValue(i4) || (resourceId = this.f1214b.getResourceId(i4, 0)) == 0) ? this.f1214b.getDrawable(i4) : c.a.b(this.f1213a, resourceId);
    }

    public Drawable h(int i4) {
        int resourceId;
        if (!this.f1214b.hasValue(i4) || (resourceId = this.f1214b.getResourceId(i4, 0)) == 0) {
            return null;
        }
        return j.b().d(this.f1213a, resourceId, true);
    }

    public float i(int i4, float f4) {
        return this.f1214b.getFloat(i4, f4);
    }

    public Typeface j(int i4, int i5, b.a aVar) {
        int resourceId = this.f1214b.getResourceId(i4, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f1215c == null) {
            this.f1215c = new TypedValue();
        }
        return p.b.c(this.f1213a, resourceId, this.f1215c, i5, aVar);
    }

    public int k(int i4, int i5) {
        return this.f1214b.getInt(i4, i5);
    }

    public int l(int i4, int i5) {
        return this.f1214b.getInteger(i4, i5);
    }

    public int m(int i4, int i5) {
        return this.f1214b.getLayoutDimension(i4, i5);
    }

    public int n(int i4, int i5) {
        return this.f1214b.getResourceId(i4, i5);
    }

    public String o(int i4) {
        return this.f1214b.getString(i4);
    }

    public CharSequence p(int i4) {
        return this.f1214b.getText(i4);
    }

    public CharSequence[] q(int i4) {
        return this.f1214b.getTextArray(i4);
    }

    public boolean r(int i4) {
        return this.f1214b.hasValue(i4);
    }

    public void v() {
        this.f1214b.recycle();
    }
}
