package z;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* loaded from: classes.dex */
public final class a extends ClickableSpan {

    /* renamed from: b, reason: collision with root package name */
    private final int f6609b;

    /* renamed from: c, reason: collision with root package name */
    private final c f6610c;

    /* renamed from: d, reason: collision with root package name */
    private final int f6611d;

    public a(int i4, c cVar, int i5) {
        this.f6609b = i4;
        this.f6610c = cVar;
        this.f6611d = i5;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f6609b);
        this.f6610c.N(this.f6611d, bundle);
    }
}
