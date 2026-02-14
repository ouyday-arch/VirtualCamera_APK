package androidx.fragment.app;

import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.n;
import java.io.PrintWriter;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a extends n implements j.k {

    /* renamed from: s, reason: collision with root package name */
    final j f1455s;

    /* renamed from: t, reason: collision with root package name */
    boolean f1456t;

    /* renamed from: u, reason: collision with root package name */
    int f1457u = -1;

    public a(j jVar) {
        this.f1455s = jVar;
    }

    private static boolean s(n.a aVar) {
        Fragment fragment = aVar.f1603b;
        return (fragment == null || !fragment.f1419l || fragment.H == null || fragment.A || fragment.f1433z || !fragment.Q()) ? false : true;
    }

    @Override // androidx.fragment.app.j.k
    public boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        if (j.I) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.f1591h) {
            return true;
        }
        this.f1455s.i(this);
        return true;
    }

    @Override // androidx.fragment.app.n
    public int d() {
        return j(false);
    }

    @Override // androidx.fragment.app.n
    public int e() {
        return j(true);
    }

    @Override // androidx.fragment.app.n
    void f(int i4, Fragment fragment, String str, int i5) {
        super.f(i4, fragment, str, i5);
        fragment.f1426s = this.f1455s;
    }

    @Override // androidx.fragment.app.n
    public n g(Fragment fragment) {
        j jVar = fragment.f1426s;
        if (jVar == null || jVar == this.f1455s) {
            return super.g(fragment);
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(int i4) {
        if (this.f1591h) {
            if (j.I) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i4);
            }
            int size = this.f1584a.size();
            for (int i5 = 0; i5 < size; i5++) {
                n.a aVar = this.f1584a.get(i5);
                Fragment fragment = aVar.f1603b;
                if (fragment != null) {
                    fragment.f1425r += i4;
                    if (j.I) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.f1603b + " to " + aVar.f1603b.f1425r);
                    }
                }
            }
        }
    }

    int j(boolean z4) {
        if (this.f1456t) {
            throw new IllegalStateException("commit already called");
        }
        if (j.I) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new x.b("FragmentManager"));
            k("  ", printWriter);
            printWriter.close();
        }
        this.f1456t = true;
        this.f1457u = this.f1591h ? this.f1455s.l(this) : -1;
        this.f1455s.g0(this, z4);
        return this.f1457u;
    }

    public void k(String str, PrintWriter printWriter) {
        l(str, printWriter, true);
    }

    public void l(String str, PrintWriter printWriter, boolean z4) {
        String str2;
        if (z4) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f1593j);
            printWriter.print(" mIndex=");
            printWriter.print(this.f1457u);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f1456t);
            if (this.f1589f != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f1589f));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.f1590g));
            }
            if (this.f1585b != 0 || this.f1586c != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f1585b));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f1586c));
            }
            if (this.f1587d != 0 || this.f1588e != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f1587d));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f1588e));
            }
            if (this.f1594k != 0 || this.f1595l != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f1594k));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f1595l);
            }
            if (this.f1596m != 0 || this.f1597n != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f1596m));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f1597n);
            }
        }
        if (this.f1584a.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = this.f1584a.size();
        for (int i4 = 0; i4 < size; i4++) {
            n.a aVar = this.f1584a.get(i4);
            switch (aVar.f1602a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + aVar.f1602a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i4);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(aVar.f1603b);
            if (z4) {
                if (aVar.f1604c != 0 || aVar.f1605d != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f1604c));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f1605d));
                }
                if (aVar.f1606e != 0 || aVar.f1607f != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f1606e));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f1607f));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m() {
        int size = this.f1584a.size();
        for (int i4 = 0; i4 < size; i4++) {
            n.a aVar = this.f1584a.get(i4);
            Fragment fragment = aVar.f1603b;
            if (fragment != null) {
                fragment.j1(this.f1589f, this.f1590g);
            }
            switch (aVar.f1602a) {
                case 1:
                    fragment.i1(aVar.f1604c);
                    this.f1455s.j(fragment, false);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f1602a);
                case 3:
                    fragment.i1(aVar.f1605d);
                    this.f1455s.X0(fragment);
                    break;
                case 4:
                    fragment.i1(aVar.f1605d);
                    this.f1455s.B0(fragment);
                    break;
                case 5:
                    fragment.i1(aVar.f1604c);
                    this.f1455s.k1(fragment);
                    break;
                case 6:
                    fragment.i1(aVar.f1605d);
                    this.f1455s.v(fragment);
                    break;
                case 7:
                    fragment.i1(aVar.f1604c);
                    this.f1455s.o(fragment);
                    break;
                case 8:
                    this.f1455s.j1(fragment);
                    break;
                case 9:
                    this.f1455s.j1(null);
                    break;
                case 10:
                    this.f1455s.i1(fragment, aVar.f1609h);
                    break;
            }
            if (!this.f1600q && aVar.f1602a != 1 && fragment != null) {
                this.f1455s.N0(fragment);
            }
        }
        if (this.f1600q) {
            return;
        }
        j jVar = this.f1455s;
        jVar.O0(jVar.f1517q, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(boolean z4) {
        for (int size = this.f1584a.size() - 1; size >= 0; size--) {
            n.a aVar = this.f1584a.get(size);
            Fragment fragment = aVar.f1603b;
            if (fragment != null) {
                fragment.j1(j.c1(this.f1589f), this.f1590g);
            }
            switch (aVar.f1602a) {
                case 1:
                    fragment.i1(aVar.f1607f);
                    this.f1455s.X0(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f1602a);
                case 3:
                    fragment.i1(aVar.f1606e);
                    this.f1455s.j(fragment, false);
                    break;
                case 4:
                    fragment.i1(aVar.f1606e);
                    this.f1455s.k1(fragment);
                    break;
                case 5:
                    fragment.i1(aVar.f1607f);
                    this.f1455s.B0(fragment);
                    break;
                case 6:
                    fragment.i1(aVar.f1606e);
                    this.f1455s.o(fragment);
                    break;
                case 7:
                    fragment.i1(aVar.f1607f);
                    this.f1455s.v(fragment);
                    break;
                case 8:
                    this.f1455s.j1(null);
                    break;
                case 9:
                    this.f1455s.j1(fragment);
                    break;
                case 10:
                    this.f1455s.i1(fragment, aVar.f1608g);
                    break;
            }
            if (!this.f1600q && aVar.f1602a != 3 && fragment != null) {
                this.f1455s.N0(fragment);
            }
        }
        if (this.f1600q || !z4) {
            return;
        }
        j jVar = this.f1455s;
        jVar.O0(jVar.f1517q, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment o(ArrayList<Fragment> arrayList, Fragment fragment) {
        Fragment fragment2 = fragment;
        int i4 = 0;
        while (i4 < this.f1584a.size()) {
            n.a aVar = this.f1584a.get(i4);
            int i5 = aVar.f1602a;
            if (i5 != 1) {
                if (i5 == 2) {
                    Fragment fragment3 = aVar.f1603b;
                    int i6 = fragment3.f1431x;
                    boolean z4 = false;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        Fragment fragment4 = arrayList.get(size);
                        if (fragment4.f1431x == i6) {
                            if (fragment4 == fragment3) {
                                z4 = true;
                            } else {
                                if (fragment4 == fragment2) {
                                    this.f1584a.add(i4, new n.a(9, fragment4));
                                    i4++;
                                    fragment2 = null;
                                }
                                n.a aVar2 = new n.a(3, fragment4);
                                aVar2.f1604c = aVar.f1604c;
                                aVar2.f1606e = aVar.f1606e;
                                aVar2.f1605d = aVar.f1605d;
                                aVar2.f1607f = aVar.f1607f;
                                this.f1584a.add(i4, aVar2);
                                arrayList.remove(fragment4);
                                i4++;
                            }
                        }
                    }
                    if (z4) {
                        this.f1584a.remove(i4);
                        i4--;
                    } else {
                        aVar.f1602a = 1;
                        arrayList.add(fragment3);
                    }
                } else if (i5 == 3 || i5 == 6) {
                    arrayList.remove(aVar.f1603b);
                    Fragment fragment5 = aVar.f1603b;
                    if (fragment5 == fragment2) {
                        this.f1584a.add(i4, new n.a(9, fragment5));
                        i4++;
                        fragment2 = null;
                    }
                } else if (i5 != 7) {
                    if (i5 == 8) {
                        this.f1584a.add(i4, new n.a(9, fragment2));
                        i4++;
                        fragment2 = aVar.f1603b;
                    }
                }
                i4++;
            }
            arrayList.add(aVar.f1603b);
            i4++;
        }
        return fragment2;
    }

    public String p() {
        return this.f1593j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean q(int i4) {
        int size = this.f1584a.size();
        for (int i5 = 0; i5 < size; i5++) {
            Fragment fragment = this.f1584a.get(i5).f1603b;
            int i6 = fragment != null ? fragment.f1431x : 0;
            if (i6 != 0 && i6 == i4) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean r(ArrayList<a> arrayList, int i4, int i5) {
        if (i5 == i4) {
            return false;
        }
        int size = this.f1584a.size();
        int i6 = -1;
        for (int i7 = 0; i7 < size; i7++) {
            Fragment fragment = this.f1584a.get(i7).f1603b;
            int i8 = fragment != null ? fragment.f1431x : 0;
            if (i8 != 0 && i8 != i6) {
                for (int i9 = i4; i9 < i5; i9++) {
                    a aVar = arrayList.get(i9);
                    int size2 = aVar.f1584a.size();
                    for (int i10 = 0; i10 < size2; i10++) {
                        Fragment fragment2 = aVar.f1584a.get(i10).f1603b;
                        if ((fragment2 != null ? fragment2.f1431x : 0) == i8) {
                            return true;
                        }
                    }
                }
                i6 = i8;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean t() {
        for (int i4 = 0; i4 < this.f1584a.size(); i4++) {
            if (s(this.f1584a.get(i4))) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f1457u >= 0) {
            sb.append(" #");
            sb.append(this.f1457u);
        }
        if (this.f1593j != null) {
            sb.append(" ");
            sb.append(this.f1593j);
        }
        sb.append("}");
        return sb.toString();
    }

    public void u() {
        if (this.f1601r != null) {
            for (int i4 = 0; i4 < this.f1601r.size(); i4++) {
                this.f1601r.get(i4).run();
            }
            this.f1601r = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(Fragment.f fVar) {
        for (int i4 = 0; i4 < this.f1584a.size(); i4++) {
            n.a aVar = this.f1584a.get(i4);
            if (s(aVar)) {
                aVar.f1603b.k1(fVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment w(ArrayList<Fragment> arrayList, Fragment fragment) {
        for (int size = this.f1584a.size() - 1; size >= 0; size--) {
            n.a aVar = this.f1584a.get(size);
            int i4 = aVar.f1602a;
            if (i4 != 1) {
                if (i4 != 3) {
                    switch (i4) {
                        case 8:
                            fragment = null;
                            break;
                        case 9:
                            fragment = aVar.f1603b;
                            break;
                        case 10:
                            aVar.f1609h = aVar.f1608g;
                            break;
                    }
                }
                arrayList.add(aVar.f1603b);
            }
            arrayList.remove(aVar.f1603b);
        }
        return fragment;
    }
}
