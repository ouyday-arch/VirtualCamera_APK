package j;

import android.content.res.ColorStateList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements d {
    private e n(c cVar) {
        return (e) cVar.d();
    }

    @Override // j.d
    public float a(c cVar) {
        return cVar.b().getElevation();
    }

    @Override // j.d
    public void b(c cVar, float f4) {
        cVar.b().setElevation(f4);
    }

    @Override // j.d
    public void c(c cVar) {
        k(cVar, i(cVar));
    }

    @Override // j.d
    public float d(c cVar) {
        return h(cVar) * 2.0f;
    }

    @Override // j.d
    public void e(c cVar) {
        k(cVar, i(cVar));
    }

    @Override // j.d
    public ColorStateList f(c cVar) {
        return n(cVar).b();
    }

    @Override // j.d
    public void g(c cVar, float f4) {
        n(cVar).h(f4);
    }

    @Override // j.d
    public float h(c cVar) {
        return n(cVar).d();
    }

    @Override // j.d
    public float i(c cVar) {
        return n(cVar).c();
    }

    @Override // j.d
    public float j(c cVar) {
        return h(cVar) * 2.0f;
    }

    @Override // j.d
    public void k(c cVar, float f4) {
        n(cVar).g(f4, cVar.c(), cVar.e());
        o(cVar);
    }

    @Override // j.d
    public void l(c cVar, ColorStateList colorStateList) {
        n(cVar).f(colorStateList);
    }

    @Override // j.d
    public void m() {
    }

    public void o(c cVar) {
        if (!cVar.c()) {
            cVar.a(0, 0, 0, 0);
            return;
        }
        float i4 = i(cVar);
        float h4 = h(cVar);
        int ceil = (int) Math.ceil(f.a(i4, h4, cVar.e()));
        int ceil2 = (int) Math.ceil(f.b(i4, h4, cVar.e()));
        cVar.a(ceil, ceil2, ceil, ceil2);
    }
}
