package com.journeyapps.barcodescanner;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import g1.s;
import java.util.HashMap;
import java.util.List;
import l1.k;
import p2.g;
import p2.h;
import p2.i;
import p2.j;

/* loaded from: classes.dex */
public class BarcodeView extends com.journeyapps.barcodescanner.a {
    private b C;
    private p2.a D;
    private j E;
    private h F;
    private Handler G;
    private final Handler.Callback H;

    /* loaded from: classes.dex */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i4 = message.what;
            if (i4 == k.f4526g) {
                p2.c cVar = (p2.c) message.obj;
                if (cVar != null && BarcodeView.this.D != null && BarcodeView.this.C != b.NONE) {
                    BarcodeView.this.D.b(cVar);
                    if (BarcodeView.this.C == b.SINGLE) {
                        BarcodeView.this.M();
                    }
                }
                return true;
            }
            if (i4 == k.f4525f) {
                return true;
            }
            if (i4 != k.f4527h) {
                return false;
            }
            List<s> list = (List) message.obj;
            if (BarcodeView.this.D != null && BarcodeView.this.C != b.NONE) {
                BarcodeView.this.D.a(list);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum b {
        NONE,
        SINGLE,
        CONTINUOUS
    }

    public BarcodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.C = b.NONE;
        this.D = null;
        this.H = new a();
        J();
    }

    private g G() {
        if (this.F == null) {
            this.F = H();
        }
        i iVar = new i();
        HashMap hashMap = new HashMap();
        hashMap.put(g1.e.NEED_RESULT_POINT_CALLBACK, iVar);
        g a5 = this.F.a(hashMap);
        iVar.b(a5);
        return a5;
    }

    private void J() {
        this.F = new p2.k();
        this.G = new Handler(this.H);
    }

    private void K() {
        L();
        if (this.C == b.NONE || !t()) {
            return;
        }
        j jVar = new j(getCameraInstance(), G(), this.G);
        this.E = jVar;
        jVar.i(getPreviewFramingRect());
        this.E.k();
    }

    private void L() {
        j jVar = this.E;
        if (jVar != null) {
            jVar.l();
            this.E = null;
        }
    }

    protected h H() {
        return new p2.k();
    }

    public void I(p2.a aVar) {
        this.C = b.SINGLE;
        this.D = aVar;
        K();
    }

    public void M() {
        this.C = b.NONE;
        this.D = null;
        L();
    }

    public h getDecoderFactory() {
        return this.F;
    }

    public void setDecoderFactory(h hVar) {
        p2.s.a();
        this.F = hVar;
        j jVar = this.E;
        if (jVar != null) {
            jVar.j(G());
        }
    }

    @Override // com.journeyapps.barcodescanner.a
    public void u() {
        L();
        super.u();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.journeyapps.barcodescanner.a
    public void x() {
        super.x();
        K();
    }
}
