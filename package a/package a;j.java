package a;

public final class j<TResult> {

    /* renamed from: a  reason: collision with root package name */
    public final i<TResult> f419a = new i<>();

    public final boolean a() {
        return this.f419a.i();
    }

    public final void b() {
        if (!a()) {
            throw new IllegalStateException("Cannot cancel a completed task.");
        }
    }

    public final boolean a(Exception exc) {
        return this.f419a.b(exc);
    }

    public final boolean a(TResult tresult) {
        return this.f419a.b(tresult);
    }

    public final void b(Exception exc) {
        if (!a(exc)) {
            throw new IllegalStateException("Cannot set the error on a completed task.");
        }
    }

    public final void b(TResult tresult) {
        if (!a(tresult)) {
            throw new IllegalStateException("Cannot set the result of a completed task.");
        }
    }
}