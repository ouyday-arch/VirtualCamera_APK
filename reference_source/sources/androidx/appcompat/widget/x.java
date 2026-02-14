package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;

/* loaded from: classes.dex */
final class x {

    /* renamed from: a, reason: collision with root package name */
    private TextView f1216a;

    /* renamed from: b, reason: collision with root package name */
    private TextClassifier f1217b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(TextView textView) {
        this.f1216a = (TextView) x.h.c(textView);
    }

    public TextClassifier a() {
        TextClassifier textClassifier = this.f1217b;
        if (textClassifier != null) {
            return textClassifier;
        }
        TextClassificationManager textClassificationManager = (TextClassificationManager) this.f1216a.getContext().getSystemService(TextClassificationManager.class);
        return textClassificationManager != null ? textClassificationManager.getTextClassifier() : TextClassifier.NO_OP;
    }

    public void b(TextClassifier textClassifier) {
        this.f1217b = textClassifier;
    }
}
