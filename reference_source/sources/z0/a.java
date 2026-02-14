package z0;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import b1.g;
import b1.k;
import b1.n;

/* loaded from: classes.dex */
public class a extends Drawable implements n {

    /* renamed from: b, reason: collision with root package name */
    private b f6647b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        g f6648a;

        /* renamed from: b, reason: collision with root package name */
        boolean f6649b;

        public b(g gVar) {
            this.f6648a = gVar;
            this.f6649b = false;
        }

        public b(b bVar) {
            this.f6648a = (g) bVar.f6648a.getConstantState().newDrawable();
            this.f6649b = bVar.f6649b;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a newDrawable() {
            return new a(new b(this));
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }
    }

    public a(k kVar) {
        this(new b(new g(kVar)));
    }

    private a(b bVar) {
        this.f6647b = bVar;
    }

    @Override // android.graphics.drawable.Drawable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a mutate() {
        this.f6647b = new b(this.f6647b);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        b bVar = this.f6647b;
        if (bVar.f6649b) {
            bVar.f6648a.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f6647b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f6647b.f6648a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f6647b.f6648a.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        if (this.f6647b.f6648a.setState(iArr)) {
            onStateChange = true;
        }
        boolean b5 = z0.b.b(iArr);
        b bVar = this.f6647b;
        if (bVar.f6649b == b5) {
            return onStateChange;
        }
        bVar.f6649b = b5;
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i4) {
        this.f6647b.f6648a.setAlpha(i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f6647b.f6648a.setColorFilter(colorFilter);
    }

    @Override // b1.n
    public void setShapeAppearanceModel(k kVar) {
        this.f6647b.f6648a.setShapeAppearanceModel(kVar);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i4) {
        this.f6647b.f6648a.setTint(i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f6647b.f6648a.setTintList(colorStateList);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f6647b.f6648a.setTintMode(mode);
    }
}
