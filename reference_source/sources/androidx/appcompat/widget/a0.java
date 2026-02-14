package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a0 {

    /* renamed from: k, reason: collision with root package name */
    private static final RectF f917k = new RectF();

    /* renamed from: l, reason: collision with root package name */
    private static ConcurrentHashMap<String, Method> f918l = new ConcurrentHashMap<>();

    /* renamed from: m, reason: collision with root package name */
    private static ConcurrentHashMap<String, Field> f919m = new ConcurrentHashMap<>();

    /* renamed from: a, reason: collision with root package name */
    private int f920a = 0;

    /* renamed from: b, reason: collision with root package name */
    private boolean f921b = false;

    /* renamed from: c, reason: collision with root package name */
    private float f922c = -1.0f;

    /* renamed from: d, reason: collision with root package name */
    private float f923d = -1.0f;

    /* renamed from: e, reason: collision with root package name */
    private float f924e = -1.0f;

    /* renamed from: f, reason: collision with root package name */
    private int[] f925f = new int[0];

    /* renamed from: g, reason: collision with root package name */
    private boolean f926g = false;

    /* renamed from: h, reason: collision with root package name */
    private TextPaint f927h;

    /* renamed from: i, reason: collision with root package name */
    private final TextView f928i;

    /* renamed from: j, reason: collision with root package name */
    private final Context f929j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a0(TextView textView) {
        this.f928i = textView;
        this.f929j = textView.getContext();
    }

    private void A(float f4, float f5, float f6) {
        if (f4 <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f4 + "px) is less or equal to (0px)");
        }
        if (f5 <= f4) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f5 + "px) is less or equal to minimum auto-size text size (" + f4 + "px)");
        }
        if (f6 <= 0.0f) {
            throw new IllegalArgumentException("The auto-size step granularity (" + f6 + "px) is less or equal to (0px)");
        }
        this.f920a = 1;
        this.f923d = f4;
        this.f924e = f5;
        this.f922c = f6;
        this.f926g = false;
    }

    private int[] b(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i4 : iArr) {
            if (i4 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i4)) < 0) {
                arrayList.add(Integer.valueOf(i4));
            }
        }
        if (length == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i5 = 0; i5 < size; i5++) {
            iArr2[i5] = ((Integer) arrayList.get(i5)).intValue();
        }
        return iArr2;
    }

    private void c() {
        this.f920a = 0;
        this.f923d = -1.0f;
        this.f924e = -1.0f;
        this.f922c = -1.0f;
        this.f925f = new int[0];
        this.f921b = false;
    }

    private StaticLayout e(CharSequence charSequence, Layout.Alignment alignment, int i4, int i5) {
        StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), this.f927h, i4);
        StaticLayout.Builder hyphenationFrequency = obtain.setAlignment(alignment).setLineSpacing(this.f928i.getLineSpacingExtra(), this.f928i.getLineSpacingMultiplier()).setIncludePad(this.f928i.getIncludeFontPadding()).setBreakStrategy(this.f928i.getBreakStrategy()).setHyphenationFrequency(this.f928i.getHyphenationFrequency());
        if (i5 == -1) {
            i5 = Integer.MAX_VALUE;
        }
        hyphenationFrequency.setMaxLines(i5);
        try {
            obtain.setTextDirection(Build.VERSION.SDK_INT >= 29 ? this.f928i.getTextDirectionHeuristic() : (TextDirectionHeuristic) n(this.f928i, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        } catch (ClassCastException unused) {
            Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
        }
        return obtain.build();
    }

    private int f(RectF rectF) {
        int i4;
        int length = this.f925f.length;
        if (length == 0) {
            throw new IllegalStateException("No available text sizes to choose from.");
        }
        int i5 = 0;
        int i6 = 1;
        int i7 = length - 1;
        while (true) {
            int i8 = i6;
            int i9 = i5;
            i5 = i8;
            while (i5 <= i7) {
                i4 = (i5 + i7) / 2;
                if (y(this.f925f[i4], rectF)) {
                    break;
                }
                i9 = i4 - 1;
                i7 = i9;
            }
            return this.f925f[i9];
            i6 = i4 + 1;
        }
    }

    private static Method l(String str) {
        try {
            Method method = f918l.get(str);
            if (method == null && (method = TextView.class.getDeclaredMethod(str, new Class[0])) != null) {
                method.setAccessible(true);
                f918l.put(str, method);
            }
            return method;
        } catch (Exception e4) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e4);
            return null;
        }
    }

    private static <T> T n(Object obj, String str, T t4) {
        try {
            return (T) l(str).invoke(obj, new Object[0]);
        } catch (Exception e4) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e4);
            return t4;
        }
    }

    private void t(float f4) {
        if (f4 != this.f928i.getPaint().getTextSize()) {
            this.f928i.getPaint().setTextSize(f4);
            boolean isInLayout = this.f928i.isInLayout();
            if (this.f928i.getLayout() != null) {
                this.f921b = false;
                try {
                    Method l4 = l("nullLayouts");
                    if (l4 != null) {
                        l4.invoke(this.f928i, new Object[0]);
                    }
                } catch (Exception e4) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e4);
                }
                if (isInLayout) {
                    this.f928i.forceLayout();
                } else {
                    this.f928i.requestLayout();
                }
                this.f928i.invalidate();
            }
        }
    }

    private boolean v() {
        if (z() && this.f920a == 1) {
            if (!this.f926g || this.f925f.length == 0) {
                int floor = ((int) Math.floor((this.f924e - this.f923d) / this.f922c)) + 1;
                int[] iArr = new int[floor];
                for (int i4 = 0; i4 < floor; i4++) {
                    iArr[i4] = Math.round(this.f923d + (i4 * this.f922c));
                }
                this.f925f = b(iArr);
            }
            this.f921b = true;
        } else {
            this.f921b = false;
        }
        return this.f921b;
    }

    private void w(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i4 = 0; i4 < length; i4++) {
                iArr[i4] = typedArray.getDimensionPixelSize(i4, -1);
            }
            this.f925f = b(iArr);
            x();
        }
    }

    private boolean x() {
        boolean z4 = this.f925f.length > 0;
        this.f926g = z4;
        if (z4) {
            this.f920a = 1;
            this.f923d = r0[0];
            this.f924e = r0[r1 - 1];
            this.f922c = -1.0f;
        }
        return z4;
    }

    private boolean y(int i4, RectF rectF) {
        CharSequence transformation;
        CharSequence text = this.f928i.getText();
        TransformationMethod transformationMethod = this.f928i.getTransformationMethod();
        if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, this.f928i)) != null) {
            text = transformation;
        }
        int maxLines = this.f928i.getMaxLines();
        m(i4);
        StaticLayout d5 = d(text, (Layout.Alignment) n(this.f928i, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), maxLines);
        return (maxLines == -1 || (d5.getLineCount() <= maxLines && d5.getLineEnd(d5.getLineCount() - 1) == text.length())) && ((float) d5.getHeight()) <= rectF.bottom;
    }

    private boolean z() {
        return !(this.f928i instanceof k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (o()) {
            if (this.f921b) {
                if (this.f928i.getMeasuredHeight() <= 0 || this.f928i.getMeasuredWidth() <= 0) {
                    return;
                }
                int measuredWidth = Build.VERSION.SDK_INT >= 29 ? this.f928i.isHorizontallyScrollable() : ((Boolean) n(this.f928i, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue() ? 1048576 : (this.f928i.getMeasuredWidth() - this.f928i.getTotalPaddingLeft()) - this.f928i.getTotalPaddingRight();
                int height = (this.f928i.getHeight() - this.f928i.getCompoundPaddingBottom()) - this.f928i.getCompoundPaddingTop();
                if (measuredWidth <= 0 || height <= 0) {
                    return;
                }
                RectF rectF = f917k;
                synchronized (rectF) {
                    rectF.setEmpty();
                    rectF.right = measuredWidth;
                    rectF.bottom = height;
                    float f4 = f(rectF);
                    if (f4 != this.f928i.getTextSize()) {
                        u(0, f4);
                    }
                }
            }
            this.f921b = true;
        }
    }

    StaticLayout d(CharSequence charSequence, Layout.Alignment alignment, int i4, int i5) {
        return e(charSequence, alignment, i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return Math.round(this.f924e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h() {
        return Math.round(this.f923d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i() {
        return Math.round(this.f922c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] j() {
        return this.f925f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k() {
        return this.f920a;
    }

    void m(int i4) {
        TextPaint textPaint = this.f927h;
        if (textPaint == null) {
            this.f927h = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.f927h.set(this.f928i.getPaint());
        this.f927h.setTextSize(i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean o() {
        return z() && this.f920a != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(AttributeSet attributeSet, int i4) {
        int resourceId;
        TypedArray obtainStyledAttributes = this.f929j.obtainStyledAttributes(attributeSet, a.j.f174i0, i4, 0);
        int i5 = a.j.f199n0;
        if (obtainStyledAttributes.hasValue(i5)) {
            this.f920a = obtainStyledAttributes.getInt(i5, 0);
        }
        int i6 = a.j.f194m0;
        float dimension = obtainStyledAttributes.hasValue(i6) ? obtainStyledAttributes.getDimension(i6, -1.0f) : -1.0f;
        int i7 = a.j.f184k0;
        float dimension2 = obtainStyledAttributes.hasValue(i7) ? obtainStyledAttributes.getDimension(i7, -1.0f) : -1.0f;
        int i8 = a.j.f179j0;
        float dimension3 = obtainStyledAttributes.hasValue(i8) ? obtainStyledAttributes.getDimension(i8, -1.0f) : -1.0f;
        int i9 = a.j.f189l0;
        if (obtainStyledAttributes.hasValue(i9) && (resourceId = obtainStyledAttributes.getResourceId(i9, 0)) > 0) {
            TypedArray obtainTypedArray = obtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            w(obtainTypedArray);
            obtainTypedArray.recycle();
        }
        obtainStyledAttributes.recycle();
        if (!z()) {
            this.f920a = 0;
            return;
        }
        if (this.f920a == 1) {
            if (!this.f926g) {
                DisplayMetrics displayMetrics = this.f929j.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                A(dimension2, dimension3, dimension);
            }
            v();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(int i4, int i5, int i6, int i7) {
        if (z()) {
            DisplayMetrics displayMetrics = this.f929j.getResources().getDisplayMetrics();
            A(TypedValue.applyDimension(i7, i4, displayMetrics), TypedValue.applyDimension(i7, i5, displayMetrics), TypedValue.applyDimension(i7, i6, displayMetrics));
            if (v()) {
                a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(int[] iArr, int i4) {
        if (z()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i4 == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.f929j.getResources().getDisplayMetrics();
                    for (int i5 = 0; i5 < length; i5++) {
                        iArr2[i5] = Math.round(TypedValue.applyDimension(i4, iArr[i5], displayMetrics));
                    }
                }
                this.f925f = b(iArr2);
                if (!x()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.f926g = false;
            }
            if (v()) {
                a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(int i4) {
        if (z()) {
            if (i4 == 0) {
                c();
                return;
            }
            if (i4 != 1) {
                throw new IllegalArgumentException("Unknown auto-size text type: " + i4);
            }
            DisplayMetrics displayMetrics = this.f929j.getResources().getDisplayMetrics();
            A(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (v()) {
                a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(int i4, float f4) {
        Context context = this.f929j;
        t(TypedValue.applyDimension(i4, f4, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics()));
    }
}
