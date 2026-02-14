package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ToggleButton;

/* loaded from: classes.dex */
public class b0 extends ToggleButton {

    /* renamed from: b, reason: collision with root package name */
    private final y f938b;

    public b0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.buttonStyleToggle);
    }

    public b0(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        y yVar = new y(this);
        this.f938b = yVar;
        yVar.m(attributeSet, i4);
    }
}
