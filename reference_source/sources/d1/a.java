package d1;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.Filterable;
import android.widget.ListAdapter;
import androidx.appcompat.widget.d;
import androidx.appcompat.widget.j0;
import com.google.android.material.textfield.TextInputLayout;
import m0.b;

/* loaded from: classes.dex */
public class a extends d {

    /* renamed from: e, reason: collision with root package name */
    private final j0 f3580e;

    /* renamed from: f, reason: collision with root package name */
    private final AccessibilityManager f3581f;

    /* renamed from: d1.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0039a implements AdapterView.OnItemClickListener {
        C0039a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i4, long j4) {
            a aVar = a.this;
            a.this.d(i4 < 0 ? aVar.f3580e.u() : aVar.getAdapter().getItem(i4));
            AdapterView.OnItemClickListener onItemClickListener = a.this.getOnItemClickListener();
            if (onItemClickListener != null) {
                if (view == null || i4 < 0) {
                    view = a.this.f3580e.x();
                    i4 = a.this.f3580e.w();
                    j4 = a.this.f3580e.v();
                }
                onItemClickListener.onItemClick(a.this.f3580e.k(), view, i4, j4);
            }
            a.this.f3580e.dismiss();
        }
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.f4933a);
    }

    public a(Context context, AttributeSet attributeSet, int i4) {
        super(e1.a.c(context, attributeSet, i4, 0), attributeSet, i4);
        Context context2 = getContext();
        this.f3581f = (AccessibilityManager) context2.getSystemService("accessibility");
        j0 j0Var = new j0(context2);
        this.f3580e = j0Var;
        j0Var.I(true);
        j0Var.C(this);
        j0Var.H(2);
        j0Var.n(getAdapter());
        j0Var.K(new C0039a());
    }

    private TextInputLayout c() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T extends ListAdapter & Filterable> void d(Object obj) {
        setText(convertSelectionToString(obj), false);
    }

    @Override // android.widget.TextView
    public CharSequence getHint() {
        TextInputLayout c5 = c();
        return (c5 == null || !c5.N()) ? super.getHint() : c5.getHint();
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(T t4) {
        super.setAdapter(t4);
        this.f3580e.n(getAdapter());
    }

    @Override // android.widget.AutoCompleteTextView
    public void showDropDown() {
        AccessibilityManager accessibilityManager;
        if (getInputType() == 0 && (accessibilityManager = this.f3581f) != null && accessibilityManager.isTouchExplorationEnabled()) {
            this.f3580e.show();
        } else {
            super.showDropDown();
        }
    }
}
