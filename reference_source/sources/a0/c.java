package a0;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public abstract class c extends a {

    /* renamed from: j, reason: collision with root package name */
    private int f274j;

    /* renamed from: k, reason: collision with root package name */
    private int f275k;

    /* renamed from: l, reason: collision with root package name */
    private LayoutInflater f276l;

    @Deprecated
    public c(Context context, int i4, Cursor cursor, boolean z4) {
        super(context, cursor, z4);
        this.f275k = i4;
        this.f274j = i4;
        this.f276l = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // a0.a
    public View g(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f276l.inflate(this.f275k, viewGroup, false);
    }

    @Override // a0.a
    public View h(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f276l.inflate(this.f274j, viewGroup, false);
    }
}
