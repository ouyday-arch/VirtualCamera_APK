package k2;

import android.app.Application;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/* loaded from: classes.dex */
public class i extends Toast implements l2.a {

    /* renamed from: a, reason: collision with root package name */
    private TextView f4413a;

    public i(Application application) {
        super(application);
    }

    @Override // android.widget.Toast, l2.a
    public void setText(CharSequence charSequence) {
        super.setText(charSequence);
        TextView textView = this.f4413a;
        if (textView == null) {
            return;
        }
        textView.setText(charSequence);
    }

    @Override // android.widget.Toast, l2.a
    public void setView(View view) {
        super.setView(view);
        this.f4413a = view == null ? null : a(view);
    }
}
