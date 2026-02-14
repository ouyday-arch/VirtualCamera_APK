package com.google.android.material.theme;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import androidx.appcompat.app.AppCompatViewInflater;
import androidx.appcompat.widget.d;
import androidx.appcompat.widget.f;
import androidx.appcompat.widget.g;
import androidx.appcompat.widget.s;
import androidx.appcompat.widget.z;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;
import d1.a;

/* loaded from: classes.dex */
public class MaterialComponentsViewInflater extends AppCompatViewInflater {

    /* renamed from: f, reason: collision with root package name */
    private static int f3339f = -1;

    @Override // androidx.appcompat.app.AppCompatViewInflater
    protected d b(Context context, AttributeSet attributeSet) {
        return new a(context, attributeSet);
    }

    @Override // androidx.appcompat.app.AppCompatViewInflater
    protected f c(Context context, AttributeSet attributeSet) {
        return v(context, attributeSet) ? new f(context, attributeSet) : new MaterialButton(context, attributeSet);
    }

    @Override // androidx.appcompat.app.AppCompatViewInflater
    protected g d(Context context, AttributeSet attributeSet) {
        return new p0.a(context, attributeSet);
    }

    @Override // androidx.appcompat.app.AppCompatViewInflater
    protected s j(Context context, AttributeSet attributeSet) {
        return new x0.a(context, attributeSet);
    }

    @Override // androidx.appcompat.app.AppCompatViewInflater
    protected z n(Context context, AttributeSet attributeSet) {
        return new MaterialTextView(context, attributeSet);
    }

    protected boolean v(Context context, AttributeSet attributeSet) {
        if (Build.VERSION.SDK_INT != 25) {
            return false;
        }
        if (f3339f == -1) {
            f3339f = context.getResources().getIdentifier("floatingToolbarItemBackgroundDrawable", "^attr-private", "android");
        }
        int i4 = f3339f;
        if (i4 != 0 && i4 != -1) {
            for (int i5 = 0; i5 < attributeSet.getAttributeCount(); i5++) {
                if (attributeSet.getAttributeNameResource(i5) == 16842964) {
                    if (f3339f == attributeSet.getAttributeListValue(i5, null, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
