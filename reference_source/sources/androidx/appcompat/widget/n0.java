package androidx.appcompat.widget;

import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import java.io.InputStream;

/* loaded from: classes.dex */
class n0 extends Resources {

    /* renamed from: a, reason: collision with root package name */
    private final Resources f1101a;

    public n0(Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f1101a = resources;
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getAnimation(int i4) {
        return this.f1101a.getAnimation(i4);
    }

    @Override // android.content.res.Resources
    public boolean getBoolean(int i4) {
        return this.f1101a.getBoolean(i4);
    }

    @Override // android.content.res.Resources
    public int getColor(int i4) {
        return this.f1101a.getColor(i4);
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int i4) {
        return this.f1101a.getColorStateList(i4);
    }

    @Override // android.content.res.Resources
    public Configuration getConfiguration() {
        return this.f1101a.getConfiguration();
    }

    @Override // android.content.res.Resources
    public float getDimension(int i4) {
        return this.f1101a.getDimension(i4);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelOffset(int i4) {
        return this.f1101a.getDimensionPixelOffset(i4);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelSize(int i4) {
        return this.f1101a.getDimensionPixelSize(i4);
    }

    @Override // android.content.res.Resources
    public DisplayMetrics getDisplayMetrics() {
        return this.f1101a.getDisplayMetrics();
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i4) {
        return this.f1101a.getDrawable(i4);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i4, Resources.Theme theme) {
        return this.f1101a.getDrawable(i4, theme);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawableForDensity(int i4, int i5) {
        return this.f1101a.getDrawableForDensity(i4, i5);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawableForDensity(int i4, int i5, Resources.Theme theme) {
        return this.f1101a.getDrawableForDensity(i4, i5, theme);
    }

    @Override // android.content.res.Resources
    public float getFraction(int i4, int i5, int i6) {
        return this.f1101a.getFraction(i4, i5, i6);
    }

    @Override // android.content.res.Resources
    public int getIdentifier(String str, String str2, String str3) {
        return this.f1101a.getIdentifier(str, str2, str3);
    }

    @Override // android.content.res.Resources
    public int[] getIntArray(int i4) {
        return this.f1101a.getIntArray(i4);
    }

    @Override // android.content.res.Resources
    public int getInteger(int i4) {
        return this.f1101a.getInteger(i4);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getLayout(int i4) {
        return this.f1101a.getLayout(i4);
    }

    @Override // android.content.res.Resources
    public Movie getMovie(int i4) {
        return this.f1101a.getMovie(i4);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i4, int i5) {
        return this.f1101a.getQuantityString(i4, i5);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i4, int i5, Object... objArr) {
        return this.f1101a.getQuantityString(i4, i5, objArr);
    }

    @Override // android.content.res.Resources
    public CharSequence getQuantityText(int i4, int i5) {
        return this.f1101a.getQuantityText(i4, i5);
    }

    @Override // android.content.res.Resources
    public String getResourceEntryName(int i4) {
        return this.f1101a.getResourceEntryName(i4);
    }

    @Override // android.content.res.Resources
    public String getResourceName(int i4) {
        return this.f1101a.getResourceName(i4);
    }

    @Override // android.content.res.Resources
    public String getResourcePackageName(int i4) {
        return this.f1101a.getResourcePackageName(i4);
    }

    @Override // android.content.res.Resources
    public String getResourceTypeName(int i4) {
        return this.f1101a.getResourceTypeName(i4);
    }

    @Override // android.content.res.Resources
    public String getString(int i4) {
        return this.f1101a.getString(i4);
    }

    @Override // android.content.res.Resources
    public String getString(int i4, Object... objArr) {
        return this.f1101a.getString(i4, objArr);
    }

    @Override // android.content.res.Resources
    public String[] getStringArray(int i4) {
        return this.f1101a.getStringArray(i4);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i4) {
        return this.f1101a.getText(i4);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i4, CharSequence charSequence) {
        return this.f1101a.getText(i4, charSequence);
    }

    @Override // android.content.res.Resources
    public CharSequence[] getTextArray(int i4) {
        return this.f1101a.getTextArray(i4);
    }

    @Override // android.content.res.Resources
    public void getValue(int i4, TypedValue typedValue, boolean z4) {
        this.f1101a.getValue(i4, typedValue, z4);
    }

    @Override // android.content.res.Resources
    public void getValue(String str, TypedValue typedValue, boolean z4) {
        this.f1101a.getValue(str, typedValue, z4);
    }

    @Override // android.content.res.Resources
    public void getValueForDensity(int i4, int i5, TypedValue typedValue, boolean z4) {
        this.f1101a.getValueForDensity(i4, i5, typedValue, z4);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getXml(int i4) {
        return this.f1101a.getXml(i4);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return this.f1101a.obtainAttributes(attributeSet, iArr);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainTypedArray(int i4) {
        return this.f1101a.obtainTypedArray(i4);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i4) {
        return this.f1101a.openRawResource(i4);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i4, TypedValue typedValue) {
        return this.f1101a.openRawResource(i4, typedValue);
    }

    @Override // android.content.res.Resources
    public AssetFileDescriptor openRawResourceFd(int i4) {
        return this.f1101a.openRawResourceFd(i4);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) {
        this.f1101a.parseBundleExtra(str, attributeSet, bundle);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) {
        this.f1101a.parseBundleExtras(xmlResourceParser, bundle);
    }

    @Override // android.content.res.Resources
    public void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
        Resources resources = this.f1101a;
        if (resources != null) {
            resources.updateConfiguration(configuration, displayMetrics);
        }
    }
}
