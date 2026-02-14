package androidx.fragment.app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;

/* loaded from: classes.dex */
public class c extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    private Handler Z;

    /* renamed from: a0, reason: collision with root package name */
    private Runnable f1473a0 = new a();

    /* renamed from: b0, reason: collision with root package name */
    int f1474b0 = 0;

    /* renamed from: c0, reason: collision with root package name */
    int f1475c0 = 0;

    /* renamed from: d0, reason: collision with root package name */
    boolean f1476d0 = true;

    /* renamed from: e0, reason: collision with root package name */
    boolean f1477e0 = true;

    /* renamed from: f0, reason: collision with root package name */
    int f1478f0 = -1;

    /* renamed from: g0, reason: collision with root package name */
    Dialog f1479g0;

    /* renamed from: h0, reason: collision with root package name */
    boolean f1480h0;

    /* renamed from: i0, reason: collision with root package name */
    boolean f1481i0;

    /* renamed from: j0, reason: collision with root package name */
    boolean f1482j0;

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar = c.this;
            Dialog dialog = cVar.f1479g0;
            if (dialog != null) {
                cVar.onDismiss(dialog);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void T(Bundle bundle) {
        Bundle bundle2;
        super.T(bundle);
        if (this.f1477e0) {
            View K = K();
            if (K != null) {
                if (K.getParent() != null) {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
                this.f1479g0.setContentView(K);
            }
            d i4 = i();
            if (i4 != null) {
                this.f1479g0.setOwnerActivity(i4);
            }
            this.f1479g0.setCancelable(this.f1476d0);
            this.f1479g0.setOnCancelListener(this);
            this.f1479g0.setOnDismissListener(this);
            if (bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
                return;
            }
            this.f1479g0.onRestoreInstanceState(bundle2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void W(Context context) {
        super.W(context);
        if (this.f1482j0) {
            return;
        }
        this.f1481i0 = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void Z(Bundle bundle) {
        super.Z(bundle);
        this.Z = new Handler();
        this.f1477e0 = this.f1431x == 0;
        if (bundle != null) {
            this.f1474b0 = bundle.getInt("android:style", 0);
            this.f1475c0 = bundle.getInt("android:theme", 0);
            this.f1476d0 = bundle.getBoolean("android:cancelable", true);
            this.f1477e0 = bundle.getBoolean("android:showsDialog", this.f1477e0);
            this.f1478f0 = bundle.getInt("android:backStackId", -1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void g0() {
        super.g0();
        Dialog dialog = this.f1479g0;
        if (dialog != null) {
            this.f1480h0 = true;
            dialog.setOnDismissListener(null);
            this.f1479g0.dismiss();
            if (!this.f1481i0) {
                onDismiss(this.f1479g0);
            }
            this.f1479g0 = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void h0() {
        super.h0();
        if (this.f1482j0 || this.f1481i0) {
            return;
        }
        this.f1481i0 = true;
    }

    @Override // androidx.fragment.app.Fragment
    public LayoutInflater i0(Bundle bundle) {
        Context i4;
        if (!this.f1477e0) {
            return super.i0(bundle);
        }
        Dialog p12 = p1(bundle);
        this.f1479g0 = p12;
        if (p12 != null) {
            q1(p12, this.f1474b0);
            i4 = this.f1479g0.getContext();
        } else {
            i4 = this.f1427t.i();
        }
        return (LayoutInflater) i4.getSystemService("layout_inflater");
    }

    void o1(boolean z4, boolean z5) {
        if (this.f1481i0) {
            return;
        }
        this.f1481i0 = true;
        this.f1482j0 = false;
        Dialog dialog = this.f1479g0;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.f1479g0.dismiss();
            if (!z5) {
                if (Looper.myLooper() == this.Z.getLooper()) {
                    onDismiss(this.f1479g0);
                } else {
                    this.Z.post(this.f1473a0);
                }
            }
        }
        this.f1480h0 = true;
        if (this.f1478f0 >= 0) {
            a1().e(this.f1478f0, 1);
            this.f1478f0 = -1;
            return;
        }
        n a5 = a1().a();
        a5.g(this);
        if (z4) {
            a5.e();
        } else {
            a5.d();
        }
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.f1480h0) {
            return;
        }
        o1(true, true);
    }

    public Dialog p1(Bundle bundle) {
        throw null;
    }

    public void q1(Dialog dialog, int i4) {
        if (i4 != 1 && i4 != 2) {
            if (i4 != 3) {
                return;
            } else {
                dialog.getWindow().addFlags(24);
            }
        }
        dialog.requestWindowFeature(1);
    }

    public void r1(i iVar, String str) {
        this.f1481i0 = false;
        this.f1482j0 = true;
        n a5 = iVar.a();
        a5.b(this, str);
        a5.d();
    }

    @Override // androidx.fragment.app.Fragment
    public void v0(Bundle bundle) {
        Bundle onSaveInstanceState;
        super.v0(bundle);
        Dialog dialog = this.f1479g0;
        if (dialog != null && (onSaveInstanceState = dialog.onSaveInstanceState()) != null) {
            bundle.putBundle("android:savedDialogState", onSaveInstanceState);
        }
        int i4 = this.f1474b0;
        if (i4 != 0) {
            bundle.putInt("android:style", i4);
        }
        int i5 = this.f1475c0;
        if (i5 != 0) {
            bundle.putInt("android:theme", i5);
        }
        boolean z4 = this.f1476d0;
        if (!z4) {
            bundle.putBoolean("android:cancelable", z4);
        }
        boolean z5 = this.f1477e0;
        if (!z5) {
            bundle.putBoolean("android:showsDialog", z5);
        }
        int i6 = this.f1478f0;
        if (i6 != -1) {
            bundle.putInt("android:backStackId", i6);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void w0() {
        super.w0();
        Dialog dialog = this.f1479g0;
        if (dialog != null) {
            this.f1480h0 = false;
            dialog.show();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void x0() {
        super.x0();
        Dialog dialog = this.f1479g0;
        if (dialog != null) {
            dialog.hide();
        }
    }
}
