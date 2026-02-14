package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;
import android.widget.ImageButton;
import androidx.appcompat.widget.m;
import y.p;

/* loaded from: classes.dex */
public class CheckableImageButton extends m implements Checkable {

    /* renamed from: g, reason: collision with root package name */
    private static final int[] f3104g = {R.attr.state_checked};

    /* renamed from: d, reason: collision with root package name */
    private boolean f3105d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f3106e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f3107f;

    /* loaded from: classes.dex */
    class a extends y.a {
        a() {
        }

        @Override // y.a
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            super.f(view, accessibilityEvent);
            accessibilityEvent.setChecked(CheckableImageButton.this.isChecked());
        }

        @Override // y.a
        public void g(View view, z.c cVar) {
            super.g(view, cVar);
            cVar.U(CheckableImageButton.this.a());
            cVar.V(CheckableImageButton.this.isChecked());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b extends b0.a {
        public static final Parcelable.Creator<b> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name */
        boolean f3109d;

        /* loaded from: classes.dex */
        static class a implements Parcelable.ClassLoaderCreator<b> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public b createFromParcel(Parcel parcel) {
                return new b(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public b createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new b(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public b[] newArray(int i4) {
                return new b[i4];
            }
        }

        public b(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            g(parcel);
        }

        public b(Parcelable parcelable) {
            super(parcelable);
        }

        private void g(Parcel parcel) {
            this.f3109d = parcel.readInt() == 1;
        }

        @Override // b0.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeInt(this.f3109d ? 1 : 0);
        }
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.a.B);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f3106e = true;
        this.f3107f = true;
        p.a0(this, new a());
    }

    public boolean a() {
        return this.f3106e;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f3105d;
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int i4) {
        if (!this.f3105d) {
            return super.onCreateDrawableState(i4);
        }
        int[] iArr = f3104g;
        return ImageButton.mergeDrawableStates(super.onCreateDrawableState(i4 + iArr.length), iArr);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof b)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        b bVar = (b) parcelable;
        super.onRestoreInstanceState(bVar.f());
        setChecked(bVar.f3109d);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        b bVar = new b(super.onSaveInstanceState());
        bVar.f3109d = this.f3105d;
        return bVar;
    }

    public void setCheckable(boolean z4) {
        if (this.f3106e != z4) {
            this.f3106e = z4;
            sendAccessibilityEvent(0);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z4) {
        if (!this.f3106e || this.f3105d == z4) {
            return;
        }
        this.f3105d = z4;
        refreshDrawableState();
        sendAccessibilityEvent(2048);
    }

    public void setPressable(boolean z4) {
        this.f3107f = z4;
    }

    @Override // android.view.View
    public void setPressed(boolean z4) {
        if (this.f3107f) {
            super.setPressed(z4);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f3105d);
    }
}
