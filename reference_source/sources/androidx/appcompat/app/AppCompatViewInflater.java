package androidx.appcompat.app;

import a.j;
import android.R;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.appcompat.widget.b0;
import androidx.appcompat.widget.k;
import androidx.appcompat.widget.m;
import androidx.appcompat.widget.o;
import androidx.appcompat.widget.s;
import androidx.appcompat.widget.t;
import androidx.appcompat.widget.t0;
import androidx.appcompat.widget.u;
import androidx.appcompat.widget.w;
import androidx.appcompat.widget.z;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import y.p;

/* loaded from: classes.dex */
public class AppCompatViewInflater {

    /* renamed from: b, reason: collision with root package name */
    private static final Class<?>[] f404b = {Context.class, AttributeSet.class};

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f405c = {R.attr.onClick};

    /* renamed from: d, reason: collision with root package name */
    private static final String[] f406d = {"android.widget.", "android.view.", "android.webkit."};

    /* renamed from: e, reason: collision with root package name */
    private static final Map<String, Constructor<? extends View>> f407e = new k.a();

    /* renamed from: a, reason: collision with root package name */
    private final Object[] f408a = new Object[2];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements View.OnClickListener {

        /* renamed from: b, reason: collision with root package name */
        private final View f409b;

        /* renamed from: c, reason: collision with root package name */
        private final String f410c;

        /* renamed from: d, reason: collision with root package name */
        private Method f411d;

        /* renamed from: e, reason: collision with root package name */
        private Context f412e;

        public a(View view, String str) {
            this.f409b = view;
            this.f410c = str;
        }

        private void a(Context context, String str) {
            String str2;
            Method method;
            while (context != null) {
                try {
                    if (!context.isRestricted() && (method = context.getClass().getMethod(this.f410c, View.class)) != null) {
                        this.f411d = method;
                        this.f412e = context;
                        return;
                    }
                } catch (NoSuchMethodException unused) {
                }
                context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
            }
            int id = this.f409b.getId();
            if (id == -1) {
                str2 = "";
            } else {
                str2 = " with id '" + this.f409b.getContext().getResources().getResourceEntryName(id) + "'";
            }
            throw new IllegalStateException("Could not find method " + this.f410c + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.f409b.getClass() + str2);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f411d == null) {
                a(this.f409b.getContext(), this.f410c);
            }
            try {
                this.f411d.invoke(this.f412e, view);
            } catch (IllegalAccessException e4) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e4);
            } catch (InvocationTargetException e5) {
                throw new IllegalStateException("Could not execute method for android:onClick", e5);
            }
        }
    }

    private void a(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if ((context instanceof ContextWrapper) && p.C(view)) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f405c);
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                view.setOnClickListener(new a(view, string));
            }
            obtainStyledAttributes.recycle();
        }
    }

    private View r(Context context, String str, String str2) {
        String str3;
        Map<String, Constructor<? extends View>> map = f407e;
        Constructor<? extends View> constructor = map.get(str);
        if (constructor == null) {
            if (str2 != null) {
                try {
                    str3 = str2 + str;
                } catch (Exception unused) {
                    return null;
                }
            } else {
                str3 = str;
            }
            constructor = Class.forName(str3, false, context.getClassLoader()).asSubclass(View.class).getConstructor(f404b);
            map.put(str, constructor);
        }
        constructor.setAccessible(true);
        return constructor.newInstance(this.f408a);
    }

    private View s(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            Object[] objArr = this.f408a;
            objArr[0] = context;
            objArr[1] = attributeSet;
            if (-1 != str.indexOf(46)) {
                return r(context, str, null);
            }
            int i4 = 0;
            while (true) {
                String[] strArr = f406d;
                if (i4 >= strArr.length) {
                    return null;
                }
                View r4 = r(context, str, strArr[i4]);
                if (r4 != null) {
                    return r4;
                }
                i4++;
            }
        } catch (Exception unused) {
            return null;
        } finally {
            Object[] objArr2 = this.f408a;
            objArr2[0] = null;
            objArr2[1] = null;
        }
    }

    private static Context t(Context context, AttributeSet attributeSet, boolean z4, boolean z5) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.f252x3, 0, 0);
        int resourceId = z4 ? obtainStyledAttributes.getResourceId(j.f257y3, 0) : 0;
        if (z5 && resourceId == 0 && (resourceId = obtainStyledAttributes.getResourceId(j.f262z3, 0)) != 0) {
            Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
        }
        obtainStyledAttributes.recycle();
        return resourceId != 0 ? ((context instanceof f.d) && ((f.d) context).b() == resourceId) ? context : new f.d(context, resourceId) : context;
    }

    private void u(View view, String str) {
        if (view != null) {
            return;
        }
        throw new IllegalStateException(getClass().getName() + " asked to inflate view for <" + str + ">, but returned null");
    }

    protected androidx.appcompat.widget.d b(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.d(context, attributeSet);
    }

    protected androidx.appcompat.widget.f c(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.f(context, attributeSet);
    }

    protected androidx.appcompat.widget.g d(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.g(context, attributeSet);
    }

    protected androidx.appcompat.widget.h e(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.h(context, attributeSet);
    }

    protected k f(Context context, AttributeSet attributeSet) {
        return new k(context, attributeSet);
    }

    protected m g(Context context, AttributeSet attributeSet) {
        return new m(context, attributeSet);
    }

    protected o h(Context context, AttributeSet attributeSet) {
        return new o(context, attributeSet);
    }

    protected androidx.appcompat.widget.p i(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.p(context, attributeSet);
    }

    protected s j(Context context, AttributeSet attributeSet) {
        return new s(context, attributeSet);
    }

    protected t k(Context context, AttributeSet attributeSet) {
        return new t(context, attributeSet);
    }

    protected u l(Context context, AttributeSet attributeSet) {
        return new u(context, attributeSet);
    }

    protected w m(Context context, AttributeSet attributeSet) {
        return new w(context, attributeSet);
    }

    protected z n(Context context, AttributeSet attributeSet) {
        return new z(context, attributeSet);
    }

    protected b0 o(Context context, AttributeSet attributeSet) {
        return new b0(context, attributeSet);
    }

    protected View p(Context context, String str, AttributeSet attributeSet) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final View q(View view, String str, Context context, AttributeSet attributeSet, boolean z4, boolean z5, boolean z6, boolean z7) {
        View k4;
        Context context2 = (!z4 || view == null) ? context : view.getContext();
        if (z5 || z6) {
            context2 = t(context2, attributeSet, z5, z6);
        }
        if (z7) {
            context2 = t0.b(context2);
        }
        str.hashCode();
        char c5 = 65535;
        switch (str.hashCode()) {
            case -1946472170:
                if (str.equals("RatingBar")) {
                    c5 = 0;
                    break;
                }
                break;
            case -1455429095:
                if (str.equals("CheckedTextView")) {
                    c5 = 1;
                    break;
                }
                break;
            case -1346021293:
                if (str.equals("MultiAutoCompleteTextView")) {
                    c5 = 2;
                    break;
                }
                break;
            case -938935918:
                if (str.equals("TextView")) {
                    c5 = 3;
                    break;
                }
                break;
            case -937446323:
                if (str.equals("ImageButton")) {
                    c5 = 4;
                    break;
                }
                break;
            case -658531749:
                if (str.equals("SeekBar")) {
                    c5 = 5;
                    break;
                }
                break;
            case -339785223:
                if (str.equals("Spinner")) {
                    c5 = 6;
                    break;
                }
                break;
            case 776382189:
                if (str.equals("RadioButton")) {
                    c5 = 7;
                    break;
                }
                break;
            case 799298502:
                if (str.equals("ToggleButton")) {
                    c5 = '\b';
                    break;
                }
                break;
            case 1125864064:
                if (str.equals("ImageView")) {
                    c5 = '\t';
                    break;
                }
                break;
            case 1413872058:
                if (str.equals("AutoCompleteTextView")) {
                    c5 = '\n';
                    break;
                }
                break;
            case 1601505219:
                if (str.equals("CheckBox")) {
                    c5 = 11;
                    break;
                }
                break;
            case 1666676343:
                if (str.equals("EditText")) {
                    c5 = '\f';
                    break;
                }
                break;
            case 2001146706:
                if (str.equals("Button")) {
                    c5 = '\r';
                    break;
                }
                break;
        }
        switch (c5) {
            case 0:
                k4 = k(context2, attributeSet);
                u(k4, str);
                break;
            case 1:
                k4 = e(context2, attributeSet);
                u(k4, str);
                break;
            case 2:
                k4 = i(context2, attributeSet);
                u(k4, str);
                break;
            case 3:
                k4 = n(context2, attributeSet);
                u(k4, str);
                break;
            case 4:
                k4 = g(context2, attributeSet);
                u(k4, str);
                break;
            case 5:
                k4 = l(context2, attributeSet);
                u(k4, str);
                break;
            case 6:
                k4 = m(context2, attributeSet);
                u(k4, str);
                break;
            case 7:
                k4 = j(context2, attributeSet);
                u(k4, str);
                break;
            case '\b':
                k4 = o(context2, attributeSet);
                u(k4, str);
                break;
            case '\t':
                k4 = h(context2, attributeSet);
                u(k4, str);
                break;
            case '\n':
                k4 = b(context2, attributeSet);
                u(k4, str);
                break;
            case 11:
                k4 = d(context2, attributeSet);
                u(k4, str);
                break;
            case '\f':
                k4 = f(context2, attributeSet);
                u(k4, str);
                break;
            case '\r':
                k4 = c(context2, attributeSet);
                u(k4, str);
                break;
            default:
                k4 = p(context2, str, attributeSet);
                break;
        }
        if (k4 == null && context != context2) {
            k4 = s(context2, str, attributeSet);
        }
        if (k4 != null) {
            a(k4, attributeSet);
        }
        return k4;
    }
}
