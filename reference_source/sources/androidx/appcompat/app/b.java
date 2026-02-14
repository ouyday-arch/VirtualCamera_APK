package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AlertController;

/* loaded from: classes.dex */
public class b extends b.b {

    /* renamed from: d, reason: collision with root package name */
    final AlertController f414d;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final AlertController.b f415a;

        /* renamed from: b, reason: collision with root package name */
        private final int f416b;

        public a(Context context) {
            this(context, b.h(context, 0));
        }

        public a(Context context, int i4) {
            this.f415a = new AlertController.b(new ContextThemeWrapper(context, b.h(context, i4)));
            this.f416b = i4;
        }

        public b a() {
            b bVar = new b(this.f415a.f365a, this.f416b);
            this.f415a.a(bVar.f414d);
            bVar.setCancelable(this.f415a.f382r);
            if (this.f415a.f382r) {
                bVar.setCanceledOnTouchOutside(true);
            }
            bVar.setOnCancelListener(this.f415a.f383s);
            bVar.setOnDismissListener(this.f415a.f384t);
            DialogInterface.OnKeyListener onKeyListener = this.f415a.f385u;
            if (onKeyListener != null) {
                bVar.setOnKeyListener(onKeyListener);
            }
            return bVar;
        }

        public Context b() {
            return this.f415a.f365a;
        }

        public a c(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f415a;
            bVar.f387w = listAdapter;
            bVar.f388x = onClickListener;
            return this;
        }

        public a d(boolean z4) {
            this.f415a.f382r = z4;
            return this;
        }

        public a e(View view) {
            this.f415a.f371g = view;
            return this;
        }

        public a f(int i4) {
            this.f415a.f367c = i4;
            return this;
        }

        public a g(Drawable drawable) {
            this.f415a.f368d = drawable;
            return this;
        }

        public a h(int i4) {
            AlertController.b bVar = this.f415a;
            bVar.f372h = bVar.f365a.getText(i4);
            return this;
        }

        public a i(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f415a;
            bVar.f376l = charSequence;
            bVar.f378n = onClickListener;
            return this;
        }

        public a j(DialogInterface.OnKeyListener onKeyListener) {
            this.f415a.f385u = onKeyListener;
            return this;
        }

        public a k(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f415a;
            bVar.f373i = charSequence;
            bVar.f375k = onClickListener;
            return this;
        }

        public a l(ListAdapter listAdapter, int i4, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f415a;
            bVar.f387w = listAdapter;
            bVar.f388x = onClickListener;
            bVar.I = i4;
            bVar.H = true;
            return this;
        }

        public a m(int i4) {
            AlertController.b bVar = this.f415a;
            bVar.f370f = bVar.f365a.getText(i4);
            return this;
        }

        public a n(CharSequence charSequence) {
            this.f415a.f370f = charSequence;
            return this;
        }

        public a o(View view) {
            AlertController.b bVar = this.f415a;
            bVar.f390z = view;
            bVar.f389y = 0;
            bVar.E = false;
            return this;
        }
    }

    protected b(Context context, int i4) {
        super(context, h(context, i4));
        this.f414d = new AlertController(getContext(), this, getWindow());
    }

    static int h(Context context, int i4) {
        if (((i4 >>> 24) & 255) >= 1) {
            return i4;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(a.a.f14o, typedValue, true);
        return typedValue.resourceId;
    }

    public Button f(int i4) {
        return this.f414d.c(i4);
    }

    public ListView g() {
        return this.f414d.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // b.b, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f414d.f();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i4, KeyEvent keyEvent) {
        if (this.f414d.g(i4, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i4, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i4, KeyEvent keyEvent) {
        if (this.f414d.h(i4, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i4, keyEvent);
    }

    @Override // b.b, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f414d.q(charSequence);
    }
}
