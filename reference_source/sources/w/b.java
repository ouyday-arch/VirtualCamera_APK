package w;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;

/* loaded from: classes.dex */
public class b implements Spannable {

    /* renamed from: e, reason: collision with root package name */
    private static final Object f6323e = new Object();

    /* renamed from: b, reason: collision with root package name */
    private final Spannable f6324b;

    /* renamed from: c, reason: collision with root package name */
    private final a f6325c;

    /* renamed from: d, reason: collision with root package name */
    private final PrecomputedText f6326d;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final TextPaint f6327a;

        /* renamed from: b, reason: collision with root package name */
        private final TextDirectionHeuristic f6328b;

        /* renamed from: c, reason: collision with root package name */
        private final int f6329c;

        /* renamed from: d, reason: collision with root package name */
        private final int f6330d;

        /* renamed from: e, reason: collision with root package name */
        final PrecomputedText.Params f6331e;

        /* renamed from: w.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0087a {

            /* renamed from: a, reason: collision with root package name */
            private final TextPaint f6332a;

            /* renamed from: c, reason: collision with root package name */
            private int f6334c = 1;

            /* renamed from: d, reason: collision with root package name */
            private int f6335d = 1;

            /* renamed from: b, reason: collision with root package name */
            private TextDirectionHeuristic f6333b = TextDirectionHeuristics.FIRSTSTRONG_LTR;

            public C0087a(TextPaint textPaint) {
                this.f6332a = textPaint;
            }

            public a a() {
                return new a(this.f6332a, this.f6333b, this.f6334c, this.f6335d);
            }

            public C0087a b(int i4) {
                this.f6334c = i4;
                return this;
            }

            public C0087a c(int i4) {
                this.f6335d = i4;
                return this;
            }

            public C0087a d(TextDirectionHeuristic textDirectionHeuristic) {
                this.f6333b = textDirectionHeuristic;
                return this;
            }
        }

        public a(PrecomputedText.Params params) {
            this.f6327a = params.getTextPaint();
            this.f6328b = params.getTextDirection();
            this.f6329c = params.getBreakStrategy();
            this.f6330d = params.getHyphenationFrequency();
            this.f6331e = Build.VERSION.SDK_INT < 29 ? null : params;
        }

        @SuppressLint({"NewApi"})
        a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i4, int i5) {
            this.f6331e = Build.VERSION.SDK_INT >= 29 ? new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(i4).setHyphenationFrequency(i5).setTextDirection(textDirectionHeuristic).build() : null;
            this.f6327a = textPaint;
            this.f6328b = textDirectionHeuristic;
            this.f6329c = i4;
            this.f6330d = i5;
        }

        public boolean a(a aVar) {
            if (this.f6329c == aVar.b() && this.f6330d == aVar.c() && this.f6327a.getTextSize() == aVar.e().getTextSize() && this.f6327a.getTextScaleX() == aVar.e().getTextScaleX() && this.f6327a.getTextSkewX() == aVar.e().getTextSkewX() && this.f6327a.getLetterSpacing() == aVar.e().getLetterSpacing() && TextUtils.equals(this.f6327a.getFontFeatureSettings(), aVar.e().getFontFeatureSettings()) && this.f6327a.getFlags() == aVar.e().getFlags() && this.f6327a.getTextLocales().equals(aVar.e().getTextLocales())) {
                return this.f6327a.getTypeface() == null ? aVar.e().getTypeface() == null : this.f6327a.getTypeface().equals(aVar.e().getTypeface());
            }
            return false;
        }

        public int b() {
            return this.f6329c;
        }

        public int c() {
            return this.f6330d;
        }

        public TextDirectionHeuristic d() {
            return this.f6328b;
        }

        public TextPaint e() {
            return this.f6327a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return a(aVar) && this.f6328b == aVar.d();
        }

        public int hashCode() {
            return x.c.b(Float.valueOf(this.f6327a.getTextSize()), Float.valueOf(this.f6327a.getTextScaleX()), Float.valueOf(this.f6327a.getTextSkewX()), Float.valueOf(this.f6327a.getLetterSpacing()), Integer.valueOf(this.f6327a.getFlags()), this.f6327a.getTextLocales(), this.f6327a.getTypeface(), Boolean.valueOf(this.f6327a.isElegantTextHeight()), this.f6328b, Integer.valueOf(this.f6329c), Integer.valueOf(this.f6330d));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            sb.append("textSize=" + this.f6327a.getTextSize());
            sb.append(", textScaleX=" + this.f6327a.getTextScaleX());
            sb.append(", textSkewX=" + this.f6327a.getTextSkewX());
            int i4 = Build.VERSION.SDK_INT;
            sb.append(", letterSpacing=" + this.f6327a.getLetterSpacing());
            sb.append(", elegantTextHeight=" + this.f6327a.isElegantTextHeight());
            sb.append(", textLocale=" + this.f6327a.getTextLocales());
            sb.append(", typeface=" + this.f6327a.getTypeface());
            if (i4 >= 26) {
                sb.append(", variationSettings=" + this.f6327a.getFontVariationSettings());
            }
            sb.append(", textDir=" + this.f6328b);
            sb.append(", breakStrategy=" + this.f6329c);
            sb.append(", hyphenationFrequency=" + this.f6330d);
            sb.append("}");
            return sb.toString();
        }
    }

    public a a() {
        return this.f6325c;
    }

    public PrecomputedText b() {
        Spannable spannable = this.f6324b;
        if (spannable instanceof PrecomputedText) {
            return (PrecomputedText) spannable;
        }
        return null;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i4) {
        return this.f6324b.charAt(i4);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.f6324b.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.f6324b.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.f6324b.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    @SuppressLint({"NewApi"})
    public <T> T[] getSpans(int i4, int i5, Class<T> cls) {
        return Build.VERSION.SDK_INT >= 29 ? (T[]) this.f6326d.getSpans(i4, i5, cls) : (T[]) this.f6324b.getSpans(i4, i5, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f6324b.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i4, int i5, Class cls) {
        return this.f6324b.nextSpanTransition(i4, i5, cls);
    }

    @Override // android.text.Spannable
    @SuppressLint({"NewApi"})
    public void removeSpan(Object obj) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.f6326d.removeSpan(obj);
        } else {
            this.f6324b.removeSpan(obj);
        }
    }

    @Override // android.text.Spannable
    @SuppressLint({"NewApi"})
    public void setSpan(Object obj, int i4, int i5, int i6) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.f6326d.setSpan(obj, i4, i5, i6);
        } else {
            this.f6324b.setSpan(obj, i4, i5, i6);
        }
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i4, int i5) {
        return this.f6324b.subSequence(i4, i5);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.f6324b.toString();
    }
}
