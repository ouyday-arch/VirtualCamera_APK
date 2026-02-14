package n;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class g implements Iterable<Intent> {

    /* renamed from: b, reason: collision with root package name */
    private final ArrayList<Intent> f5236b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private final Context f5237c;

    /* loaded from: classes.dex */
    public interface a {
        Intent g();
    }

    private g(Context context) {
        this.f5237c = context;
    }

    public static g d(Context context) {
        return new g(context);
    }

    public g a(Intent intent) {
        this.f5236b.add(intent);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g b(Activity activity) {
        Intent g4 = activity instanceof a ? ((a) activity).g() : null;
        if (g4 == null) {
            g4 = e.a(activity);
        }
        if (g4 != null) {
            ComponentName component = g4.getComponent();
            if (component == null) {
                component = g4.resolveActivity(this.f5237c.getPackageManager());
            }
            c(component);
            a(g4);
        }
        return this;
    }

    public g c(ComponentName componentName) {
        int size = this.f5236b.size();
        try {
            Context context = this.f5237c;
            while (true) {
                Intent b5 = e.b(context, componentName);
                if (b5 == null) {
                    return this;
                }
                this.f5236b.add(size, b5);
                context = this.f5237c;
                componentName = b5.getComponent();
            }
        } catch (PackageManager.NameNotFoundException e4) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e4);
        }
    }

    public void e() {
        f(null);
    }

    public void f(Bundle bundle) {
        if (this.f5236b.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        ArrayList<Intent> arrayList = this.f5236b;
        Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        if (o.a.d(this.f5237c, intentArr, bundle)) {
            return;
        }
        Intent intent = new Intent(intentArr[intentArr.length - 1]);
        intent.addFlags(268435456);
        this.f5237c.startActivity(intent);
    }

    @Override // java.lang.Iterable
    @Deprecated
    public Iterator<Intent> iterator() {
        return this.f5236b.iterator();
    }
}
