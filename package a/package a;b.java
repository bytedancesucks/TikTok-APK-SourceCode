package a;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

final class b {

    /* renamed from: a  reason: collision with root package name */
    static final b f353a = new b();

    /* renamed from: c  reason: collision with root package name */
    static final int f354c;

    /* renamed from: d  reason: collision with root package name */
    static final int f355d = ((f356e * 2) + 1);

    /* renamed from: e  reason: collision with root package name */
    private static final int f356e;

    /* renamed from: b  reason: collision with root package name */
    final Executor f357b = new a();

    static class a implements Executor {
        private a() {
        }

        public final void execute(Runnable runnable) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    private b() {
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f356e = availableProcessors;
        f354c = availableProcessors + 1;
    }
}