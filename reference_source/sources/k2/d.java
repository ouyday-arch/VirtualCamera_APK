package k2;

import android.R;
import android.view.View;
import android.widget.TextView;

/* loaded from: classes.dex */
public abstract class d implements l2.a {

    /* renamed from: a, reason: collision with root package name */
    private View f4398a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f4399b;

    /* renamed from: c, reason: collision with root package name */
    private int f4400c;

    /* renamed from: d, reason: collision with root package name */
    private int f4401d;

    /* renamed from: e, reason: collision with root package name */
    private int f4402e;

    /* renamed from: f, reason: collision with root package name */
    private int f4403f;

    /* renamed from: g, reason: collision with root package name */
    private float f4404g;

    /* renamed from: h, reason: collision with root package name */
    private float f4405h;

    /* renamed from: i, reason: collision with root package name */
    private int f4406i = R.style.Animation.Toast;

    /* renamed from: j, reason: collision with root package name */
    private int f4407j = 2000;

    /* renamed from: k, reason: collision with root package name */
    private int f4408k = 3500;

    public int b() {
        return this.f4406i;
    }

    public int c() {
        return this.f4401d;
    }

    public int d() {
        return this.f4400c;
    }

    public float e() {
        return this.f4404g;
    }

    public int f() {
        return this.f4408k;
    }

    public int g() {
        return this.f4407j;
    }

    public float h() {
        return this.f4405h;
    }

    public View i() {
        return this.f4398a;
    }

    public int j() {
        return this.f4402e;
    }

    public int k() {
        return this.f4403f;
    }

    @Override // l2.a
    public void setDuration(int i4) {
        this.f4401d = i4;
    }

    @Override // l2.a
    public void setGravity(int i4, int i5, int i6) {
        this.f4400c = i4;
        this.f4402e = i5;
        this.f4403f = i6;
    }

    @Override // l2.a
    public void setMargin(float f4, float f5) {
        this.f4404g = f4;
        this.f4405h = f5;
    }

    @Override // l2.a
    public void setText(CharSequence charSequence) {
        TextView textView = this.f4399b;
        if (textView == null) {
            return;
        }
        textView.setText(charSequence);
    }

    @Override // l2.a
    public void setView(View view) {
        this.f4398a = view;
        this.f4399b = view == null ? null : a(view);
    }
}
