package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.w0;
import y.p;

/* loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements k.a, AbsListView.SelectionBoundsAdjuster {

    /* renamed from: b, reason: collision with root package name */
    private g f559b;

    /* renamed from: c, reason: collision with root package name */
    private ImageView f560c;

    /* renamed from: d, reason: collision with root package name */
    private RadioButton f561d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f562e;

    /* renamed from: f, reason: collision with root package name */
    private CheckBox f563f;

    /* renamed from: g, reason: collision with root package name */
    private TextView f564g;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f565h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f566i;

    /* renamed from: j, reason: collision with root package name */
    private LinearLayout f567j;

    /* renamed from: k, reason: collision with root package name */
    private Drawable f568k;

    /* renamed from: l, reason: collision with root package name */
    private int f569l;

    /* renamed from: m, reason: collision with root package name */
    private Context f570m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f571n;

    /* renamed from: o, reason: collision with root package name */
    private Drawable f572o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f573p;

    /* renamed from: q, reason: collision with root package name */
    private int f574q;

    /* renamed from: r, reason: collision with root package name */
    private LayoutInflater f575r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f576s;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.a.C);
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet);
        w0 u4 = w0.u(getContext(), attributeSet, a.j.W1, i4, 0);
        this.f568k = u4.g(a.j.Y1);
        this.f569l = u4.n(a.j.X1, -1);
        this.f571n = u4.a(a.j.Z1, false);
        this.f570m = context;
        this.f572o = u4.g(a.j.f136a2);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{R.attr.divider}, a.a.f25z, 0);
        this.f573p = obtainStyledAttributes.hasValue(0);
        u4.v();
        obtainStyledAttributes.recycle();
    }

    private void a(View view) {
        b(view, -1);
    }

    private void b(View view, int i4) {
        LinearLayout linearLayout = this.f567j;
        if (linearLayout != null) {
            linearLayout.addView(view, i4);
        } else {
            addView(view, i4);
        }
    }

    private void c() {
        CheckBox checkBox = (CheckBox) getInflater().inflate(a.g.f105h, (ViewGroup) this, false);
        this.f563f = checkBox;
        a(checkBox);
    }

    private void f() {
        ImageView imageView = (ImageView) getInflater().inflate(a.g.f106i, (ViewGroup) this, false);
        this.f560c = imageView;
        b(imageView, 0);
    }

    private void g() {
        RadioButton radioButton = (RadioButton) getInflater().inflate(a.g.f108k, (ViewGroup) this, false);
        this.f561d = radioButton;
        a(radioButton);
    }

    private LayoutInflater getInflater() {
        if (this.f575r == null) {
            this.f575r = LayoutInflater.from(getContext());
        }
        return this.f575r;
    }

    private void setSubMenuArrowVisible(boolean z4) {
        ImageView imageView = this.f565h;
        if (imageView != null) {
            imageView.setVisibility(z4 ? 0 : 8);
        }
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f566i;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f566i.getLayoutParams();
        rect.top += this.f566i.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public boolean d() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public void e(g gVar, int i4) {
        this.f559b = gVar;
        this.f574q = i4;
        setVisibility(gVar.isVisible() ? 0 : 8);
        setTitle(gVar.i(this));
        setCheckable(gVar.isCheckable());
        h(gVar.A(), gVar.g());
        setIcon(gVar.getIcon());
        setEnabled(gVar.isEnabled());
        setSubMenuArrowVisible(gVar.hasSubMenu());
        setContentDescription(gVar.getContentDescription());
    }

    @Override // androidx.appcompat.view.menu.k.a
    public g getItemData() {
        return this.f559b;
    }

    public void h(boolean z4, char c5) {
        int i4 = (z4 && this.f559b.A()) ? 0 : 8;
        if (i4 == 0) {
            this.f564g.setText(this.f559b.h());
        }
        if (this.f564g.getVisibility() != i4) {
            this.f564g.setVisibility(i4);
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        p.d0(this, this.f568k);
        TextView textView = (TextView) findViewById(a.f.M);
        this.f562e = textView;
        int i4 = this.f569l;
        if (i4 != -1) {
            textView.setTextAppearance(this.f570m, i4);
        }
        this.f564g = (TextView) findViewById(a.f.F);
        ImageView imageView = (ImageView) findViewById(a.f.I);
        this.f565h = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.f572o);
        }
        this.f566i = (ImageView) findViewById(a.f.f89r);
        this.f567j = (LinearLayout) findViewById(a.f.f83l);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i4, int i5) {
        if (this.f560c != null && this.f571n) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f560c.getLayoutParams();
            int i6 = layoutParams.height;
            if (i6 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i6;
            }
        }
        super.onMeasure(i4, i5);
    }

    public void setCheckable(boolean z4) {
        CompoundButton compoundButton;
        CompoundButton compoundButton2;
        if (!z4 && this.f561d == null && this.f563f == null) {
            return;
        }
        if (this.f559b.m()) {
            if (this.f561d == null) {
                g();
            }
            compoundButton = this.f561d;
            compoundButton2 = this.f563f;
        } else {
            if (this.f563f == null) {
                c();
            }
            compoundButton = this.f563f;
            compoundButton2 = this.f561d;
        }
        if (z4) {
            compoundButton.setChecked(this.f559b.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (compoundButton2 == null || compoundButton2.getVisibility() == 8) {
                return;
            }
            compoundButton2.setVisibility(8);
            return;
        }
        CheckBox checkBox = this.f563f;
        if (checkBox != null) {
            checkBox.setVisibility(8);
        }
        RadioButton radioButton = this.f561d;
        if (radioButton != null) {
            radioButton.setVisibility(8);
        }
    }

    public void setChecked(boolean z4) {
        CompoundButton compoundButton;
        if (this.f559b.m()) {
            if (this.f561d == null) {
                g();
            }
            compoundButton = this.f561d;
        } else {
            if (this.f563f == null) {
                c();
            }
            compoundButton = this.f563f;
        }
        compoundButton.setChecked(z4);
    }

    public void setForceShowIcon(boolean z4) {
        this.f576s = z4;
        this.f571n = z4;
    }

    public void setGroupDividerEnabled(boolean z4) {
        ImageView imageView = this.f566i;
        if (imageView != null) {
            imageView.setVisibility((this.f573p || !z4) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z4 = this.f559b.z() || this.f576s;
        if (z4 || this.f571n) {
            ImageView imageView = this.f560c;
            if (imageView == null && drawable == null && !this.f571n) {
                return;
            }
            if (imageView == null) {
                f();
            }
            if (drawable == null && !this.f571n) {
                this.f560c.setVisibility(8);
                return;
            }
            ImageView imageView2 = this.f560c;
            if (!z4) {
                drawable = null;
            }
            imageView2.setImageDrawable(drawable);
            if (this.f560c.getVisibility() != 0) {
                this.f560c.setVisibility(0);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        int i4;
        TextView textView;
        if (charSequence != null) {
            this.f562e.setText(charSequence);
            if (this.f562e.getVisibility() == 0) {
                return;
            }
            textView = this.f562e;
            i4 = 0;
        } else {
            i4 = 8;
            if (this.f562e.getVisibility() == 8) {
                return;
            } else {
                textView = this.f562e;
            }
        }
        textView.setVisibility(i4);
    }
}
