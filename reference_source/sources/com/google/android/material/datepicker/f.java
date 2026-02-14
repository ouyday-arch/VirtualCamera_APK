package com.google.android.material.datepicker;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: classes.dex */
class f extends BaseAdapter {

    /* renamed from: e, reason: collision with root package name */
    private static final int f2956e;

    /* renamed from: b, reason: collision with root package name */
    private final Calendar f2957b;

    /* renamed from: c, reason: collision with root package name */
    private final int f2958c;

    /* renamed from: d, reason: collision with root package name */
    private final int f2959d;

    static {
        f2956e = Build.VERSION.SDK_INT >= 26 ? 4 : 1;
    }

    public f() {
        Calendar i4 = o.i();
        this.f2957b = i4;
        this.f2958c = i4.getMaximum(7);
        this.f2959d = i4.getFirstDayOfWeek();
    }

    private int b(int i4) {
        int i5 = i4 + this.f2959d;
        int i6 = this.f2958c;
        return i5 > i6 ? i5 - i6 : i5;
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer getItem(int i4) {
        if (i4 >= this.f2958c) {
            return null;
        }
        return Integer.valueOf(b(i4));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f2958c;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i4) {
        return 0L;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"WrongConstant"})
    public View getView(int i4, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(m0.h.f5018e, viewGroup, false);
        }
        this.f2957b.set(7, b(i4));
        textView.setText(this.f2957b.getDisplayName(7, f2956e, Locale.getDefault()));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(m0.i.f5030h), this.f2957b.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }
}
