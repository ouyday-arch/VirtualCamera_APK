package n0;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

/* loaded from: classes.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private long f5253a;

    /* renamed from: b, reason: collision with root package name */
    private long f5254b;

    /* renamed from: c, reason: collision with root package name */
    private TimeInterpolator f5255c;

    /* renamed from: d, reason: collision with root package name */
    private int f5256d;

    /* renamed from: e, reason: collision with root package name */
    private int f5257e;

    public i(long j4, long j5) {
        this.f5255c = null;
        this.f5256d = 0;
        this.f5257e = 1;
        this.f5253a = j4;
        this.f5254b = j5;
    }

    public i(long j4, long j5, TimeInterpolator timeInterpolator) {
        this.f5256d = 0;
        this.f5257e = 1;
        this.f5253a = j4;
        this.f5254b = j5;
        this.f5255c = timeInterpolator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i b(ValueAnimator valueAnimator) {
        i iVar = new i(valueAnimator.getStartDelay(), valueAnimator.getDuration(), f(valueAnimator));
        iVar.f5256d = valueAnimator.getRepeatCount();
        iVar.f5257e = valueAnimator.getRepeatMode();
        return iVar;
    }

    private static TimeInterpolator f(ValueAnimator valueAnimator) {
        TimeInterpolator interpolator = valueAnimator.getInterpolator();
        return ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) ? a.f5239b : interpolator instanceof AccelerateInterpolator ? a.f5240c : interpolator instanceof DecelerateInterpolator ? a.f5241d : interpolator;
    }

    public void a(Animator animator) {
        animator.setStartDelay(c());
        animator.setDuration(d());
        animator.setInterpolator(e());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(g());
            valueAnimator.setRepeatMode(h());
        }
    }

    public long c() {
        return this.f5253a;
    }

    public long d() {
        return this.f5254b;
    }

    public TimeInterpolator e() {
        TimeInterpolator timeInterpolator = this.f5255c;
        return timeInterpolator != null ? timeInterpolator : a.f5239b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (c() == iVar.c() && d() == iVar.d() && g() == iVar.g() && h() == iVar.h()) {
            return e().getClass().equals(iVar.e().getClass());
        }
        return false;
    }

    public int g() {
        return this.f5256d;
    }

    public int h() {
        return this.f5257e;
    }

    public int hashCode() {
        return (((((((((int) (c() ^ (c() >>> 32))) * 31) + ((int) (d() ^ (d() >>> 32)))) * 31) + e().getClass().hashCode()) * 31) + g()) * 31) + h();
    }

    public String toString() {
        return '\n' + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + c() + " duration: " + d() + " interpolator: " + e().getClass() + " repeatCount: " + g() + " repeatMode: " + h() + "}\n";
    }
}
