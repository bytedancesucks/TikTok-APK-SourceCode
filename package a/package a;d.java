package a;

import com.a;
import java.util.Locale;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final f f363a;

    public final boolean a() {
        return this.f363a.a();
    }

    public final String toString() {
        return a.a(Locale.US, "%s@%s[cancellationRequested=%s]", new Object[]{getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(this.f363a.a())});
    }

    d(f fVar) {
        this.f363a = fVar;
    }
}