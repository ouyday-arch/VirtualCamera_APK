package j2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import j2.x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/* loaded from: classes.dex */
public final class x extends Fragment implements Runnable {

    /* renamed from: h, reason: collision with root package name */
    private static final List<Integer> f4225h = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private boolean f4226b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f4227c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f4228d;

    /* renamed from: e, reason: collision with root package name */
    private h f4229e;

    /* renamed from: f, reason: collision with root package name */
    private e f4230f;

    /* renamed from: g, reason: collision with root package name */
    private int f4231g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements e {
        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f4233a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f4234b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ArrayList f4235c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f4236d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a implements e {
            a() {
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: j2.x$b$b, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0052b implements h {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ ArrayList f4239a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f4240b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ ArrayList f4241c;

            C0052b(ArrayList arrayList, int i4, ArrayList arrayList2) {
                this.f4239a = arrayList;
                this.f4240b = i4;
                this.f4241c = arrayList2;
            }

            @Override // j2.h
            public void a(List<String> list, boolean z4) {
                if (z4 && x.this.isAdded()) {
                    int[] iArr = new int[this.f4239a.size()];
                    Arrays.fill(iArr, 0);
                    x.this.onRequestPermissionsResult(this.f4240b, (String[]) this.f4239a.toArray(new String[0]), iArr);
                }
            }

            @Override // j2.h
            public void b(List<String> list, boolean z4) {
                if (x.this.isAdded()) {
                    int[] iArr = new int[this.f4239a.size()];
                    for (int i4 = 0; i4 < this.f4239a.size(); i4++) {
                        iArr[i4] = a0.f(this.f4241c, (String) this.f4239a.get(i4)) ? -1 : 0;
                    }
                    x.this.onRequestPermissionsResult(this.f4240b, (String[]) this.f4239a.toArray(new String[0]), iArr);
                }
            }
        }

        b(Activity activity, ArrayList arrayList, ArrayList arrayList2, int i4) {
            this.f4233a = activity;
            this.f4234b = arrayList;
            this.f4235c = arrayList2;
            this.f4236d = i4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(Activity activity, ArrayList arrayList, ArrayList arrayList2, int i4) {
            x.c(activity, arrayList, new a(), new C0052b(arrayList2, i4, arrayList));
        }

        @Override // j2.h
        public void a(List<String> list, boolean z4) {
            if (z4 && x.this.isAdded()) {
                long j4 = c.f() ? 150L : 0L;
                final Activity activity = this.f4233a;
                final ArrayList arrayList = this.f4234b;
                final ArrayList arrayList2 = this.f4235c;
                final int i4 = this.f4236d;
                a0.u(new Runnable() { // from class: j2.y
                    @Override // java.lang.Runnable
                    public final void run() {
                        x.b.this.d(activity, arrayList, arrayList2, i4);
                    }
                }, j4);
            }
        }

        @Override // j2.h
        public void b(List<String> list, boolean z4) {
            if (x.this.isAdded()) {
                int[] iArr = new int[this.f4235c.size()];
                Arrays.fill(iArr, -1);
                x.this.onRequestPermissionsResult(this.f4236d, (String[]) this.f4235c.toArray(new String[0]), iArr);
            }
        }
    }

    public static void c(Activity activity, ArrayList<String> arrayList, e eVar, h hVar) {
        int nextInt;
        List<Integer> list;
        x xVar = new x();
        Bundle bundle = new Bundle();
        do {
            nextInt = new Random().nextInt((int) Math.pow(2.0d, 8.0d));
            list = f4225h;
        } while (list.contains(Integer.valueOf(nextInt)));
        list.add(Integer.valueOf(nextInt));
        bundle.putInt("request_code", nextInt);
        bundle.putStringArrayList("request_permissions", arrayList);
        xVar.setArguments(bundle);
        xVar.setRetainInstance(true);
        xVar.h(true);
        xVar.f(hVar);
        xVar.g(eVar);
        xVar.a(activity);
    }

    public void a(Activity activity) {
        activity.getFragmentManager().beginTransaction().add(this, toString()).commitAllowingStateLoss();
    }

    public void b(Activity activity) {
        activity.getFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();
    }

    public void d() {
        Activity activity = getActivity();
        Bundle arguments = getArguments();
        if (activity == null || arguments == null) {
            return;
        }
        int i4 = arguments.getInt("request_code");
        ArrayList<String> stringArrayList = arguments.getStringArrayList("request_permissions");
        if (stringArrayList == null || stringArrayList.isEmpty()) {
            return;
        }
        if (!c.l()) {
            int size = stringArrayList.size();
            int[] iArr = new int[size];
            for (int i5 = 0; i5 < size; i5++) {
                iArr[i5] = j.e(activity, stringArrayList.get(i5)) ? 0 : -1;
            }
            onRequestPermissionsResult(i4, (String[]) stringArrayList.toArray(new String[0]), iArr);
            return;
        }
        if (c.f() && stringArrayList.size() >= 2 && a0.f(stringArrayList, "android.permission.BODY_SENSORS_BACKGROUND")) {
            ArrayList<String> arrayList = new ArrayList<>(stringArrayList);
            arrayList.remove("android.permission.BODY_SENSORS_BACKGROUND");
            i(activity, stringArrayList, arrayList, i4);
            return;
        }
        if (c.c() && stringArrayList.size() >= 2 && a0.f(stringArrayList, "android.permission.ACCESS_BACKGROUND_LOCATION")) {
            ArrayList<String> arrayList2 = new ArrayList<>(stringArrayList);
            arrayList2.remove("android.permission.ACCESS_BACKGROUND_LOCATION");
            i(activity, stringArrayList, arrayList2, i4);
        } else {
            if (!c.c() || !a0.f(stringArrayList, "android.permission.ACCESS_MEDIA_LOCATION") || !a0.f(stringArrayList, "android.permission.READ_EXTERNAL_STORAGE")) {
                requestPermissions((String[]) stringArrayList.toArray(new String[stringArrayList.size() - 1]), i4);
                return;
            }
            ArrayList<String> arrayList3 = new ArrayList<>(stringArrayList);
            arrayList3.remove("android.permission.ACCESS_MEDIA_LOCATION");
            i(activity, stringArrayList, arrayList3, i4);
        }
    }

    public void e() {
        Bundle arguments = getArguments();
        Activity activity = getActivity();
        if (arguments == null || activity == null) {
            return;
        }
        boolean z4 = false;
        for (String str : arguments.getStringArrayList("request_permissions")) {
            if (j.i(str) && !j.e(activity, str) && (c.d() || !a0.g(str, "android.permission.MANAGE_EXTERNAL_STORAGE"))) {
                c0.d(this, a0.m(activity, a0.b(str)), getArguments().getInt("request_code"));
                z4 = true;
            }
        }
        if (z4) {
            return;
        }
        d();
    }

    public void f(h hVar) {
        this.f4229e = hVar;
    }

    public void g(e eVar) {
        this.f4230f = eVar;
    }

    public void h(boolean z4) {
        this.f4228d = z4;
    }

    public void i(Activity activity, ArrayList<String> arrayList, ArrayList<String> arrayList2, int i4) {
        ArrayList arrayList3 = new ArrayList(arrayList);
        Iterator<String> it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.remove(it.next());
        }
        c(activity, arrayList2, new a(), new b(activity, arrayList3, arrayList, i4));
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i4, int i5, Intent intent) {
        ArrayList<String> stringArrayList;
        Activity activity = getActivity();
        Bundle arguments = getArguments();
        if (activity == null || arguments == null || this.f4227c || i4 != arguments.getInt("request_code") || (stringArrayList = arguments.getStringArrayList("request_permissions")) == null || stringArrayList.isEmpty()) {
            return;
        }
        this.f4227c = true;
        a0.t(stringArrayList, this);
    }

    @Override // android.app.Fragment
    @SuppressLint({"SourceLockedOrientationActivity"})
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        int requestedOrientation = activity.getRequestedOrientation();
        this.f4231g = requestedOrientation;
        if (requestedOrientation != -1) {
            return;
        }
        a0.r(activity);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f4229e = null;
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        Activity activity = getActivity();
        if (activity == null || this.f4231g != -1 || activity.getRequestedOrientation() == -1) {
            return;
        }
        activity.setRequestedOrientation(-1);
    }

    @Override // android.app.Fragment
    public void onRequestPermissionsResult(int i4, String[] strArr, int[] iArr) {
        if (strArr.length == 0 || iArr.length == 0) {
            return;
        }
        Bundle arguments = getArguments();
        Activity activity = getActivity();
        if (activity == null || arguments == null || this.f4230f == null || i4 != arguments.getInt("request_code")) {
            return;
        }
        h hVar = this.f4229e;
        this.f4229e = null;
        e eVar = this.f4230f;
        this.f4230f = null;
        a0.s(activity, strArr, iArr);
        ArrayList b5 = a0.b(strArr);
        f4225h.remove(Integer.valueOf(i4));
        b(activity);
        List<String> c5 = j.c(b5, iArr);
        if (c5.size() == b5.size()) {
            eVar.c(activity, b5, c5, true, hVar);
            eVar.a(activity, b5, false, hVar);
            return;
        }
        List<String> b6 = j.b(b5, iArr);
        eVar.b(activity, b5, b6, j.h(activity, b6), hVar);
        if (!c5.isEmpty()) {
            eVar.c(activity, b5, c5, false, hVar);
        }
        eVar.a(activity, b5, false, hVar);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        if (!this.f4228d) {
            b(getActivity());
        } else {
            if (this.f4226b) {
                return;
            }
            this.f4226b = true;
            e();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (isAdded()) {
            d();
        }
    }
}
