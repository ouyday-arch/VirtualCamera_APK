package androidx.appcompat.widget;

import android.R;
import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

@SuppressLint({"RestrictedAPI"})
/* loaded from: classes.dex */
class q0 extends a0.c implements View.OnClickListener {
    private int A;

    /* renamed from: m, reason: collision with root package name */
    private final SearchManager f1137m;

    /* renamed from: n, reason: collision with root package name */
    private final SearchView f1138n;

    /* renamed from: o, reason: collision with root package name */
    private final SearchableInfo f1139o;

    /* renamed from: p, reason: collision with root package name */
    private final Context f1140p;

    /* renamed from: q, reason: collision with root package name */
    private final WeakHashMap<String, Drawable.ConstantState> f1141q;

    /* renamed from: r, reason: collision with root package name */
    private final int f1142r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f1143s;

    /* renamed from: t, reason: collision with root package name */
    private int f1144t;

    /* renamed from: u, reason: collision with root package name */
    private ColorStateList f1145u;

    /* renamed from: v, reason: collision with root package name */
    private int f1146v;

    /* renamed from: w, reason: collision with root package name */
    private int f1147w;

    /* renamed from: x, reason: collision with root package name */
    private int f1148x;

    /* renamed from: y, reason: collision with root package name */
    private int f1149y;

    /* renamed from: z, reason: collision with root package name */
    private int f1150z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final TextView f1151a;

        /* renamed from: b, reason: collision with root package name */
        public final TextView f1152b;

        /* renamed from: c, reason: collision with root package name */
        public final ImageView f1153c;

        /* renamed from: d, reason: collision with root package name */
        public final ImageView f1154d;

        /* renamed from: e, reason: collision with root package name */
        public final ImageView f1155e;

        public a(View view) {
            this.f1151a = (TextView) view.findViewById(R.id.text1);
            this.f1152b = (TextView) view.findViewById(R.id.text2);
            this.f1153c = (ImageView) view.findViewById(R.id.icon1);
            this.f1154d = (ImageView) view.findViewById(R.id.icon2);
            this.f1155e = (ImageView) view.findViewById(a.f.f88q);
        }
    }

    public q0(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.f1143s = false;
        this.f1144t = 1;
        this.f1146v = -1;
        this.f1147w = -1;
        this.f1148x = -1;
        this.f1149y = -1;
        this.f1150z = -1;
        this.A = -1;
        this.f1137m = (SearchManager) this.f266e.getSystemService("search");
        this.f1138n = searchView;
        this.f1139o = searchableInfo;
        this.f1142r = searchView.getSuggestionCommitIconResId();
        this.f1140p = context;
        this.f1141q = weakHashMap;
    }

    private void A(String str, Drawable drawable) {
        if (drawable != null) {
            this.f1141q.put(str, drawable.getConstantState());
        }
    }

    private void B(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null) {
            extras.getBoolean("in_progress");
        }
    }

    private Drawable k(String str) {
        Drawable.ConstantState constantState = this.f1141q.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    private CharSequence l(CharSequence charSequence) {
        if (this.f1145u == null) {
            TypedValue typedValue = new TypedValue();
            this.f266e.getTheme().resolveAttribute(a.a.K, typedValue, true);
            this.f1145u = this.f266e.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.f1145u, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    private Drawable m(ComponentName componentName) {
        String nameNotFoundException;
        ActivityInfo activityInfo;
        int iconResource;
        PackageManager packageManager = this.f266e.getPackageManager();
        try {
            activityInfo = packageManager.getActivityInfo(componentName, 128);
            iconResource = activityInfo.getIconResource();
        } catch (PackageManager.NameNotFoundException e4) {
            nameNotFoundException = e4.toString();
        }
        if (iconResource == 0) {
            return null;
        }
        Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
        if (drawable != null) {
            return drawable;
        }
        nameNotFoundException = "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString();
        Log.w("SuggestionsAdapter", nameNotFoundException);
        return null;
    }

    private Drawable n(ComponentName componentName) {
        String flattenToShortString = componentName.flattenToShortString();
        if (!this.f1141q.containsKey(flattenToShortString)) {
            Drawable m4 = m(componentName);
            this.f1141q.put(flattenToShortString, m4 != null ? m4.getConstantState() : null);
            return m4;
        }
        Drawable.ConstantState constantState = this.f1141q.get(flattenToShortString);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable(this.f1140p.getResources());
    }

    public static String o(Cursor cursor, String str) {
        return w(cursor, cursor.getColumnIndex(str));
    }

    private Drawable p(Cursor cursor) {
        Drawable n4 = n(this.f1139o.getSearchActivity());
        return n4 != null ? n4 : this.f266e.getPackageManager().getDefaultActivityIcon();
    }

    private Drawable q(Uri uri) {
        try {
            if ("android.resource".equals(uri.getScheme())) {
                try {
                    return r(uri);
                } catch (Resources.NotFoundException unused) {
                    throw new FileNotFoundException("Resource does not exist: " + uri);
                }
            }
            InputStream openInputStream = this.f1140p.getContentResolver().openInputStream(uri);
            if (openInputStream == null) {
                throw new FileNotFoundException("Failed to open " + uri);
            }
            try {
                return Drawable.createFromStream(openInputStream, null);
            } finally {
                try {
                    openInputStream.close();
                } catch (IOException e4) {
                    Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e4);
                }
            }
        } catch (FileNotFoundException e5) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e5.getMessage());
            return null;
        }
        Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e5.getMessage());
        return null;
    }

    private Drawable s(String str) {
        if (str == null || str.isEmpty() || "0".equals(str)) {
            return null;
        }
        try {
            int parseInt = Integer.parseInt(str);
            String str2 = "android.resource://" + this.f1140p.getPackageName() + "/" + parseInt;
            Drawable k4 = k(str2);
            if (k4 != null) {
                return k4;
            }
            Drawable c5 = o.a.c(this.f1140p, parseInt);
            A(str2, c5);
            return c5;
        } catch (Resources.NotFoundException unused) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        } catch (NumberFormatException unused2) {
            Drawable k5 = k(str);
            if (k5 != null) {
                return k5;
            }
            Drawable q4 = q(Uri.parse(str));
            A(str, q4);
            return q4;
        }
    }

    private Drawable t(Cursor cursor) {
        int i4 = this.f1149y;
        if (i4 == -1) {
            return null;
        }
        Drawable s4 = s(cursor.getString(i4));
        return s4 != null ? s4 : p(cursor);
    }

    private Drawable u(Cursor cursor) {
        int i4 = this.f1150z;
        if (i4 == -1) {
            return null;
        }
        return s(cursor.getString(i4));
    }

    private static String w(Cursor cursor, int i4) {
        if (i4 == -1) {
            return null;
        }
        try {
            return cursor.getString(i4);
        } catch (Exception e4) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e4);
            return null;
        }
    }

    private void y(ImageView imageView, Drawable drawable, int i4) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i4);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    private void z(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        textView.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
    }

    @Override // a0.a, a0.b.a
    public CharSequence a(Cursor cursor) {
        String o4;
        String o5;
        if (cursor == null) {
            return null;
        }
        String o6 = o(cursor, "suggest_intent_query");
        if (o6 != null) {
            return o6;
        }
        if (this.f1139o.shouldRewriteQueryFromData() && (o5 = o(cursor, "suggest_intent_data")) != null) {
            return o5;
        }
        if (!this.f1139o.shouldRewriteQueryFromText() || (o4 = o(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return o4;
    }

    @Override // a0.a, a0.b.a
    public void b(Cursor cursor) {
        if (this.f1143s) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.b(cursor);
            if (cursor != null) {
                this.f1146v = cursor.getColumnIndex("suggest_text_1");
                this.f1147w = cursor.getColumnIndex("suggest_text_2");
                this.f1148x = cursor.getColumnIndex("suggest_text_2_url");
                this.f1149y = cursor.getColumnIndex("suggest_icon_1");
                this.f1150z = cursor.getColumnIndex("suggest_icon_2");
                this.A = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e4) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e4);
        }
    }

    @Override // a0.b.a
    public Cursor d(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "" : charSequence.toString();
        if (this.f1138n.getVisibility() == 0 && this.f1138n.getWindowVisibility() == 0) {
            try {
                Cursor v4 = v(this.f1139o, charSequence2, 50);
                if (v4 != null) {
                    v4.getCount();
                    return v4;
                }
            } catch (RuntimeException e4) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e4);
            }
        }
        return null;
    }

    @Override // a0.a
    public void e(View view, Context context, Cursor cursor) {
        a aVar = (a) view.getTag();
        int i4 = this.A;
        int i5 = i4 != -1 ? cursor.getInt(i4) : 0;
        if (aVar.f1151a != null) {
            z(aVar.f1151a, w(cursor, this.f1146v));
        }
        if (aVar.f1152b != null) {
            String w4 = w(cursor, this.f1148x);
            CharSequence l4 = w4 != null ? l(w4) : w(cursor, this.f1147w);
            if (TextUtils.isEmpty(l4)) {
                TextView textView = aVar.f1151a;
                if (textView != null) {
                    textView.setSingleLine(false);
                    aVar.f1151a.setMaxLines(2);
                }
            } else {
                TextView textView2 = aVar.f1151a;
                if (textView2 != null) {
                    textView2.setSingleLine(true);
                    aVar.f1151a.setMaxLines(1);
                }
            }
            z(aVar.f1152b, l4);
        }
        ImageView imageView = aVar.f1153c;
        if (imageView != null) {
            y(imageView, t(cursor), 4);
        }
        ImageView imageView2 = aVar.f1154d;
        if (imageView2 != null) {
            y(imageView2, u(cursor), 8);
        }
        int i6 = this.f1144t;
        if (i6 != 2 && (i6 != 1 || (i5 & 1) == 0)) {
            aVar.f1155e.setVisibility(8);
            return;
        }
        aVar.f1155e.setVisibility(0);
        aVar.f1155e.setTag(aVar.f1151a.getText());
        aVar.f1155e.setOnClickListener(this);
    }

    @Override // a0.a, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i4, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i4, view, viewGroup);
        } catch (RuntimeException e4) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e4);
            View g4 = g(this.f266e, this.f265d, viewGroup);
            if (g4 != null) {
                ((a) g4.getTag()).f1151a.setText(e4.toString());
            }
            return g4;
        }
    }

    @Override // a0.a, android.widget.Adapter
    public View getView(int i4, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i4, view, viewGroup);
        } catch (RuntimeException e4) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e4);
            View h4 = h(this.f266e, this.f265d, viewGroup);
            if (h4 != null) {
                ((a) h4.getTag()).f1151a.setText(e4.toString());
            }
            return h4;
        }
    }

    @Override // a0.c, a0.a
    public View h(Context context, Cursor cursor, ViewGroup viewGroup) {
        View h4 = super.h(context, cursor, viewGroup);
        h4.setTag(new a(h4));
        ((ImageView) h4.findViewById(a.f.f88q)).setImageResource(this.f1142r);
        return h4;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        B(c());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        B(c());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f1138n.U((CharSequence) tag);
        }
    }

    Drawable r(Uri uri) {
        int parseInt;
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.f266e.getPackageManager().getResourcesForApplication(authority);
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new FileNotFoundException("No path: " + uri);
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    parseInt = Integer.parseInt(pathSegments.get(0));
                } catch (NumberFormatException unused) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                }
            } else {
                if (size != 2) {
                    throw new FileNotFoundException("More than two path segments: " + uri);
                }
                parseInt = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
            }
            if (parseInt != 0) {
                return resourcesForApplication.getDrawable(parseInt);
            }
            throw new FileNotFoundException("No resource found for: " + uri);
        } catch (PackageManager.NameNotFoundException unused2) {
            throw new FileNotFoundException("No package found for authority: " + uri);
        }
    }

    Cursor v(SearchableInfo searchableInfo, String str, int i4) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder fragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        if (i4 > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i4));
        }
        return this.f266e.getContentResolver().query(fragment.build(), null, suggestSelection, strArr2, null);
    }

    public void x(int i4) {
        this.f1144t = i4;
    }
}
