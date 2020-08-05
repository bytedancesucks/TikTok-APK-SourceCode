package a;

import com.ss.android.ugc.aweme.bx.i;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

final class c {

    /* renamed from: a  reason: collision with root package name */
    static final c f358a = new c();

    /* renamed from: b  reason: collision with root package name */
    final Executor f359b;

    /* renamed from: c  reason: collision with root package name */
    private final ExecutorService f360c;

    /* renamed from: d  reason: collision with root package name */
    private final ScheduledExecutorService f361d;

    public static ExecutorService a() {
        return i.d();
    }

    static ScheduledExecutorService b() {
        return i.f();
    }

    static class a implements Executor {

        /* renamed from: a  reason: collision with root package name */
        private ThreadLocal<Integer> f362a;

        private a() {
            this.f362a = new ThreadLocal<>();
        }

        private int a() {
            Integer num = this.f362a.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.f362a.remove();
            } else {
                this.f362a.set(Integer.valueOf(intValue));
            }
            return intValue;
        }

        public final void execute(Runnable runnable) {
            Integer num = this.f362a.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() + 1;
            this.f362a.set(Integer.valueOf(intValue));
            if (intValue <= 15) {
                try {
                    runnable.run();
                } catch (Throwable th) {
                    a();
                    throw th;
                }
            } else {
                c.a().execute(runnable);
            }
            a();
        }
    }

    /* JADX WARNING: type inference failed for: r0v12, types: [java.util.concurrent.ExecutorService] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private c() {
        /*
            r9 = this;
            r9.<init>()
            java.lang.String r0 = "java.runtime.name"
            java.lang.String r0 = java.lang.System.getProperty(r0)
            if (r0 != 0) goto L_0x000d
            r0 = 0
            goto L_0x0019
        L_0x000d:
            java.util.Locale r1 = java.util.Locale.US
            java.lang.String r0 = r0.toLowerCase(r1)
            java.lang.String r1 = "android"
            boolean r0 = r0.contains(r1)
        L_0x0019:
            r1 = 1
            if (r0 != 0) goto L_0x0021
            java.util.concurrent.ExecutorService r0 = java.util.concurrent.Executors.newCachedThreadPool()
            goto L_0x003d
        L_0x0021:
            java.util.concurrent.ThreadPoolExecutor r0 = new java.util.concurrent.ThreadPoolExecutor
            int r3 = a.b.f354c
            int r4 = a.b.f355d
            r5 = 1
            java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.SECONDS
            java.util.concurrent.LinkedBlockingQueue r8 = new java.util.concurrent.LinkedBlockingQueue
            r8.<init>()
            r2 = r0
            r2.<init>(r3, r4, r5, r7, r8)
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 9
            if (r2 < r3) goto L_0x003d
            r0.allowCoreThreadTimeOut(r1)
        L_0x003d:
            r9.f360c = r0
            com.ss.android.ugc.aweme.bx.q r0 = com.ss.android.ugc.aweme.bx.q.SCHEDULED
            com.ss.android.ugc.aweme.bx.n$a r0 = com.ss.android.ugc.aweme.bx.n.a(r0)
            com.ss.android.ugc.aweme.bx.n$a r0 = r0.a((int) r1)
            com.ss.android.ugc.aweme.bx.n r0 = r0.a()
            java.util.concurrent.ExecutorService r0 = com.ss.android.ugc.aweme.bx.i.a((com.ss.android.ugc.aweme.bx.n) r0)
            java.util.concurrent.ScheduledExecutorService r0 = (java.util.concurrent.ScheduledExecutorService) r0
            r9.f361d = r0
            a.c$a r0 = new a.c$a
            r1 = 0
            r0.<init>()
            r9.f359b = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.c.<init>():void");
    }
}