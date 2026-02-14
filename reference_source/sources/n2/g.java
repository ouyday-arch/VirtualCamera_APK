package n2;

import android.view.View;
import n2.e;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g implements View.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    private final e<?> f5342b;

    /* renamed from: c, reason: collision with root package name */
    private final e.a f5343c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e<?> eVar, e.a aVar) {
        this.f5342b = eVar;
        this.f5343c = aVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        e.a aVar = this.f5343c;
        if (aVar == null) {
            return;
        }
        aVar.a(this.f5342b, view);
    }
}
