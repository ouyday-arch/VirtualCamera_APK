package g0;

import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.Property;

/* loaded from: classes.dex */
class f {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> ObjectAnimator a(T t4, Property<T, PointF> property, Path path) {
        return ObjectAnimator.ofObject(t4, property, (TypeConverter) null, path);
    }
}
