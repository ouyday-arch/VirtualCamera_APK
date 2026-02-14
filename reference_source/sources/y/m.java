package y;

import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private int f6535a;

    /* renamed from: b, reason: collision with root package name */
    private int f6536b;

    public m(ViewGroup viewGroup) {
    }

    public int a() {
        return this.f6535a | this.f6536b;
    }

    public void b(View view, View view2, int i4) {
        c(view, view2, i4, 0);
    }

    public void c(View view, View view2, int i4, int i5) {
        if (i5 == 1) {
            this.f6536b = i4;
        } else {
            this.f6535a = i4;
        }
    }

    public void d(View view, int i4) {
        if (i4 == 1) {
            this.f6536b = 0;
        } else {
            this.f6535a = 0;
        }
    }
}
