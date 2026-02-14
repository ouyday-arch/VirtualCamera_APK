package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;

/* loaded from: classes.dex */
public class t extends RatingBar {

    /* renamed from: b, reason: collision with root package name */
    private final r f1172b;

    public t(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.a.G);
    }

    public t(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        r rVar = new r(this);
        this.f1172b = rVar;
        rVar.c(attributeSet, i4);
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        Bitmap b5 = this.f1172b.b();
        if (b5 != null) {
            setMeasuredDimension(View.resolveSizeAndState(b5.getWidth() * getNumStars(), i4, 0), getMeasuredHeight());
        }
    }
}
