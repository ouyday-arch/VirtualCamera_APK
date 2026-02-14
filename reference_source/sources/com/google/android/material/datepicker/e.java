package com.google.android.material.datepicker;

import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
class e {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(long j4) {
        return b(j4, Locale.getDefault());
    }

    static String b(long j4, Locale locale) {
        return o.b(locale).format(new Date(j4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c(long j4) {
        return d(j4, Locale.getDefault());
    }

    static String d(long j4, Locale locale) {
        return o.k(locale).format(new Date(j4));
    }
}
