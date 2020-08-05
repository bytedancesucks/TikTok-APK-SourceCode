package a;

import com.a;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

public final class f implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    public final Object f368a = new Object();

    /* renamed from: b  reason: collision with root package name */
    final List<e> f369b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public ScheduledFuture<?> f370c;

    /* renamed from: d  reason: collision with root package name */
    private final ScheduledExecutorService f371d = c.b();

    /* renamed from: e  reason: collision with root package name */
    private boolean f372e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f373f;

    private void e() {
        ScheduledFuture<?> scheduledFuture = this.f370c;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.f370c = null;
        }
    }

    public final boolean a() {
        boolean z;
        synchronized (this.f368a) {
            d();
            z = this.f372e;
        }
        return z;
    }

    public final d b() {
        d dVar;
        synchronized (this.f368a) {
            d();
            dVar = new d(this);
        }
        return dVar;
    }

    /* access modifiers changed from: package-private */
    public void d() {
        if (this.f373f) {
            throw new IllegalStateException("Object already closed");
        }
    }

    public final void c() {
        synchronized (this.f368a) {
            d();
            if (!this.f372e) {
                e();
                this.f372e = true;
                ArrayList arrayList = new ArrayList(this.f369b);
                a(arrayList);
            }
        }
    }

    public final void close() {
        synchronized (this.f368a) {
            if (!this.f373f) {
                e();
                for (e close : this.f369b) {
                    close.close();
                }
                this.f369b.clear();
                this.f373f = true;
            }
        }
    }

    public final String toString() {
        return a.a(Locale.US, "%s@%s[cancellationRequested=%s]", new Object[]{getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(a())});
    }

    private static void a(List<e> list) {
        for (e a2 : list) {
            a2.a();
        }
    }
}