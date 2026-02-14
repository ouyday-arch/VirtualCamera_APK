package g1;

import java.util.Map;
import w1.b0;

/* loaded from: classes.dex */
public final class l implements u {

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3952a;

        static {
            int[] iArr = new int[g1.a.values().length];
            f3952a = iArr;
            try {
                iArr[g1.a.EAN_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3952a[g1.a.UPC_E.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3952a[g1.a.EAN_13.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3952a[g1.a.UPC_A.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3952a[g1.a.QR_CODE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3952a[g1.a.CODE_39.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3952a[g1.a.CODE_93.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f3952a[g1.a.CODE_128.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f3952a[g1.a.ITF.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f3952a[g1.a.PDF_417.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f3952a[g1.a.CODABAR.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f3952a[g1.a.DATA_MATRIX.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f3952a[g1.a.AZTEC.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    @Override // g1.u
    public n1.b a(String str, g1.a aVar, int i4, int i5, Map<g, ?> map) {
        u lVar;
        switch (a.f3952a[aVar.ordinal()]) {
            case 1:
                lVar = new w1.l();
                break;
            case 2:
                lVar = new b0();
                break;
            case 3:
                lVar = new w1.j();
                break;
            case 4:
                lVar = new w1.u();
                break;
            case 5:
                lVar = new f2.b();
                break;
            case 6:
                lVar = new w1.f();
                break;
            case 7:
                lVar = new w1.h();
                break;
            case 8:
                lVar = new w1.d();
                break;
            case 9:
                lVar = new w1.o();
                break;
            case 10:
                lVar = new a2.d();
                break;
            case 11:
                lVar = new w1.b();
                break;
            case 12:
                lVar = new q1.b();
                break;
            case 13:
                lVar = new h1.c();
                break;
            default:
                throw new IllegalArgumentException("No encoder available for format ".concat(String.valueOf(aVar)));
        }
        return lVar.a(str, aVar, i4, i5, map);
    }
}
