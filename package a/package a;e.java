package a;

import java.io.Closeable;

public final class e implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private final Object f364a;

    /* renamed from: b  reason: collision with root package name */
    private f f365b;

    /* renamed from: c  reason: collision with root package name */
    private Runnable f366c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f367d;

    /* access modifiers changed from: package-private */
    public final void a() {
        synchronized (this.f364a) {
            if (!this.f367d) {
                this.f366c.run();
                close();
            } else {
                throw new IllegalStateException("Object already closed");
            }
        }
    }

    public final void close() {
        synchronized (this.f364a) {
            if (!this.f367d) {
                this.f367d = true;
                f fVar = this.f365b;
                synchronized (fVar.f368a) {
                    fVar.d();
                    fVar.f369b.remove(this);
                }
                this.f365b = null;
                this.f366c = null;
            }
        }
    }
}