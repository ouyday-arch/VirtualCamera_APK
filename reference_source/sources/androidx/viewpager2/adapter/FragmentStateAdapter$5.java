package androidx.viewpager2.adapter;

import android.os.Handler;
import androidx.lifecycle.d;
import androidx.lifecycle.e;
import androidx.lifecycle.g;

/* loaded from: classes.dex */
class FragmentStateAdapter$5 implements e {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Handler f2122a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Runnable f2123b;

    @Override // androidx.lifecycle.e
    public void d(g gVar, d.a aVar) {
        if (aVar == d.a.ON_DESTROY) {
            this.f2122a.removeCallbacks(this.f2123b);
            gVar.a().c(this);
        }
    }
}
