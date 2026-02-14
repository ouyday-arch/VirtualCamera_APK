package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import java.util.Calendar;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class MaterialCalendarGridView extends GridView {

    /* renamed from: b, reason: collision with root package name */
    private final Calendar f2934b;

    /* loaded from: classes.dex */
    class a extends y.a {
        a() {
        }

        @Override // y.a
        public void g(View view, z.c cVar) {
            super.g(view, cVar);
            cVar.Y(null);
        }
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f2934b = o.i();
        if (h.s1(getContext())) {
            setNextFocusLeftId(m0.f.f4988a);
            setNextFocusRightId(m0.f.f4989b);
        }
        y.p.a0(this, new a());
    }

    private void a(int i4, Rect rect) {
        int b5;
        if (i4 == 33) {
            b5 = getAdapter().h();
        } else {
            if (i4 != 130) {
                super.onFocusChanged(true, i4, rect);
                return;
            }
            b5 = getAdapter().b();
        }
        setSelection(b5);
    }

    private static int c(View view) {
        return view.getLeft() + (view.getWidth() / 2);
    }

    private static boolean d(Long l4, Long l5, Long l6, Long l7) {
        return l4 == null || l5 == null || l6 == null || l7 == null || l6.longValue() > l5.longValue() || l7.longValue() < l4.longValue();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    /* renamed from: b, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public j getAdapter2() {
        return (j) super.getAdapter();
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter().notifyDataSetChanged();
    }

    @Override // android.view.View
    protected final void onDraw(Canvas canvas) {
        int a5;
        int c5;
        int a6;
        int c6;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        j adapter = getAdapter();
        d<?> dVar = adapter.f3005c;
        c cVar = adapter.f3006d;
        Long item = adapter.getItem(adapter.b());
        Long item2 = adapter.getItem(adapter.h());
        for (x.d<Long, Long> dVar2 : dVar.b()) {
            Long l4 = dVar2.f6461a;
            if (l4 != null) {
                if (dVar2.f6462b == null) {
                    continue;
                } else {
                    long longValue = l4.longValue();
                    long longValue2 = dVar2.f6462b.longValue();
                    if (d(item, item2, Long.valueOf(longValue), Long.valueOf(longValue2))) {
                        return;
                    }
                    if (longValue < item.longValue()) {
                        a5 = adapter.b();
                        c5 = adapter.f(a5) ? 0 : materialCalendarGridView.getChildAt(a5 - 1).getRight();
                    } else {
                        materialCalendarGridView.f2934b.setTimeInMillis(longValue);
                        a5 = adapter.a(materialCalendarGridView.f2934b.get(5));
                        c5 = c(materialCalendarGridView.getChildAt(a5));
                    }
                    if (longValue2 > item2.longValue()) {
                        a6 = adapter.h();
                        c6 = adapter.g(a6) ? getWidth() : materialCalendarGridView.getChildAt(a6).getRight();
                    } else {
                        materialCalendarGridView.f2934b.setTimeInMillis(longValue2);
                        a6 = adapter.a(materialCalendarGridView.f2934b.get(5));
                        c6 = c(materialCalendarGridView.getChildAt(a6));
                    }
                    int itemId = (int) adapter.getItemId(a5);
                    int itemId2 = (int) adapter.getItemId(a6);
                    while (itemId <= itemId2) {
                        int numColumns = getNumColumns() * itemId;
                        int numColumns2 = (getNumColumns() + numColumns) - 1;
                        View childAt = materialCalendarGridView.getChildAt(numColumns);
                        canvas.drawRect(numColumns > a5 ? 0 : c5, childAt.getTop() + cVar.f2948a.c(), a6 > numColumns2 ? getWidth() : c6, childAt.getBottom() - cVar.f2948a.b(), cVar.f2955h);
                        itemId++;
                        materialCalendarGridView = this;
                    }
                }
            }
            materialCalendarGridView = this;
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    protected void onFocusChanged(boolean z4, int i4, Rect rect) {
        if (z4) {
            a(i4, rect);
        } else {
            super.onFocusChanged(false, i4, rect);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i4, KeyEvent keyEvent) {
        if (!super.onKeyDown(i4, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= getAdapter().b()) {
            return true;
        }
        if (19 != i4) {
            return false;
        }
        setSelection(getAdapter().b());
        return true;
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(ListAdapter listAdapter) {
        if (!(listAdapter instanceof j)) {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), j.class.getCanonicalName()));
        }
        super.setAdapter(listAdapter);
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public void setSelection(int i4) {
        if (i4 < getAdapter().b()) {
            i4 = getAdapter().b();
        }
        super.setSelection(i4);
    }
}
