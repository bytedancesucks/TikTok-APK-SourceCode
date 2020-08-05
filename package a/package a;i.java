package a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class i<TResult> {

    /* renamed from: a  reason: collision with root package name */
    public static final ExecutorService f374a = c.a();

    /* renamed from: b  reason: collision with root package name */
    public static final Executor f375b = b.f353a.f357b;

    /* renamed from: c  reason: collision with root package name */
    private static final Executor f376c = c.f358a.f359b;

    /* renamed from: d  reason: collision with root package name */
    private static volatile a f377d;
    private static i<?> m = new i<>((Object) null);
    private static i<Boolean> n = new i<>(true);
    private static i<Boolean> o = new i<>(false);
    private static i<?> p = new i<>(true);

    /* renamed from: e  reason: collision with root package name */
    private final Object f378e = new Object();

    /* renamed from: f  reason: collision with root package name */
    private boolean f379f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f380g;

    /* renamed from: h  reason: collision with root package name */
    private TResult f381h;

    /* renamed from: i  reason: collision with root package name */
    private Exception f382i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f383j;
    private k k;
    private List<g<TResult, Void>> l = new ArrayList();

    public interface a {
    }

    public static a a() {
        return f377d;
    }

    public static <TResult> i<TResult> h() {
        return p;
    }

    public final boolean a(long j2, TimeUnit timeUnit) throws InterruptedException {
        boolean b2;
        synchronized (this.f378e) {
            if (!b()) {
                this.f378e.wait(timeUnit.toMillis(j2));
            }
            b2 = b();
        }
        return b2;
    }

    public final <TContinuationResult> i<TContinuationResult> a(g<TResult, TContinuationResult> gVar, Executor executor) {
        return a(gVar, executor, (d) null);
    }

    public final <TContinuationResult> i<TContinuationResult> a(g<TResult, TContinuationResult> gVar, Executor executor, d dVar) {
        boolean b2;
        j jVar = new j();
        synchronized (this.f378e) {
            b2 = b();
            if (!b2) {
                final j jVar2 = jVar;
                final g<TResult, TContinuationResult> gVar2 = gVar;
                final Executor executor2 = executor;
                final d dVar2 = dVar;
                this.l.add(new g<TResult, Void>() {
                    /* access modifiers changed from: private */
                    /* renamed from: a */
                    public Void then(i<TResult> iVar) {
                        i.a(jVar2, gVar2, iVar, executor2, dVar2);
                        return null;
                    }
                });
            }
        }
        if (b2) {
            a(jVar, gVar, this, executor, dVar);
        }
        return jVar.f419a;
    }

    public final <TContinuationResult> i<TContinuationResult> a(g<TResult, TContinuationResult> gVar) {
        return a(gVar, f376c, (d) null);
    }

    public final TResult e() {
        TResult tresult;
        synchronized (this.f378e) {
            tresult = this.f381h;
        }
        return tresult;
    }

    i() {
    }

    public final boolean d() {
        boolean z;
        synchronized (this.f378e) {
            if (f() != null) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public final Exception f() {
        Exception exc;
        synchronized (this.f378e) {
            if (this.f382i != null) {
                this.f383j = true;
                if (this.k != null) {
                    this.k.f420a = null;
                    this.k = null;
                }
            }
            exc = this.f382i;
        }
        return exc;
    }

    public final void g() throws InterruptedException {
        synchronized (this.f378e) {
            if (!b()) {
                this.f378e.wait();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean i() {
        synchronized (this.f378e) {
            if (this.f379f) {
                return false;
            }
            this.f379f = true;
            this.f380g = true;
            this.f378e.notifyAll();
            j();
            return true;
        }
    }

    private void j() {
        synchronized (this.f378e) {
            for (g then : this.l) {
                try {
                    then.then(this);
                } catch (RuntimeException e2) {
                    throw e2;
                } catch (Exception e3) {
                    throw new RuntimeException(e3);
                }
            }
            this.l = null;
        }
    }

    public final boolean c() {
        boolean z;
        synchronized (this.f378e) {
            z = this.f380g;
        }
        return z;
    }

    public final boolean b() {
        boolean z;
        synchronized (this.f378e) {
            z = this.f379f;
        }
        return z;
    }

    public static <TResult> i<TResult> a(Callable<TResult> callable) {
        return a(callable, (Executor) f374a, (d) null);
    }

    public static <TResult> i<TResult> b(Callable<TResult> callable) {
        return a(callable, f376c, (d) null);
    }

    public final <TContinuationResult> i<TContinuationResult> c(g<TResult, TContinuationResult> gVar) {
        return c(gVar, f376c, (d) null);
    }

    public static <TResult> i<TResult> a(Exception exc) {
        j jVar = new j();
        jVar.b(exc);
        return jVar.f419a;
    }

    public final <TContinuationResult> i<TContinuationResult> b(g<TResult, i<TContinuationResult>> gVar) {
        return b(gVar, f376c, (d) null);
    }

    public final <TContinuationResult> i<TContinuationResult> d(final g<TResult, i<TContinuationResult>> gVar) {
        return b(new g<TResult, i<TContinuationResult>>((d) null) {
            public final /* synthetic */ Object then(i iVar) throws Exception {
                d dVar = null;
                if (dVar != null && dVar.a()) {
                    return i.h();
                }
                if (iVar.d()) {
                    return i.a(iVar.f());
                }
                if (iVar.c()) {
                    return i.h();
                }
                return iVar.b(gVar);
            }
        }, f376c);
    }

    public static <TResult> i<List<TResult>> a(final Collection<? extends i<TResult>> collection) {
        return b((Collection<? extends i<?>>) collection).c(new g<Void, List<TResult>>() {
            public final /* synthetic */ Object then(i iVar) throws Exception {
                if (collection.size() == 0) {
                    return Collections.emptyList();
                }
                ArrayList arrayList = new ArrayList();
                for (i e2 : collection) {
                    arrayList.add(e2.e());
                }
                return arrayList;
            }
        });
    }

    private i(TResult tresult) {
        b(tresult);
    }

    public static i<Void> a(long j2) {
        ScheduledExecutorService b2 = c.b();
        if (j2 <= 0) {
            return a((Object) null);
        }
        final j jVar = new j();
        b2.schedule(new Runnable() {
            public final void run() {
                jVar.a(null);
            }
        }, j2, TimeUnit.MILLISECONDS);
        return jVar.f419a;
    }

    private i(boolean z) {
        i();
    }

    public static <TResult> i<TResult> a(TResult tresult) {
        if (tresult == null) {
            return m;
        }
        if (!(tresult instanceof Boolean)) {
            j jVar = new j();
            jVar.b(tresult);
            return jVar.f419a;
        } else if (((Boolean) tresult).booleanValue()) {
            return n;
        } else {
            return o;
        }
    }

    public static i<Void> b(Collection<? extends i<?>> collection) {
        if (collection.size() == 0) {
            return a((Object) null);
        }
        j jVar = new j();
        ArrayList arrayList = new ArrayList();
        Object obj = new Object();
        AtomicInteger atomicInteger = new AtomicInteger(collection.size());
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        for (i a2 : collection) {
            final Object obj2 = obj;
            final ArrayList arrayList2 = arrayList;
            final AtomicBoolean atomicBoolean2 = atomicBoolean;
            final AtomicInteger atomicInteger2 = atomicInteger;
            final j jVar2 = jVar;
            a2.a(new g<Object, Void>() {
                /* access modifiers changed from: private */
                /* renamed from: a */
                public Void then(i<Object> iVar) {
                    if (iVar.d()) {
                        synchronized (obj2) {
                            arrayList2.add(iVar.f());
                        }
                    }
                    if (iVar.c()) {
                        atomicBoolean2.set(true);
                    }
                    if (atomicInteger2.decrementAndGet() == 0) {
                        if (arrayList2.size() != 0) {
                            if (arrayList2.size() == 1) {
                                jVar2.b((Exception) arrayList2.get(0));
                            } else {
                                jVar2.b((Exception) new a(com.a.a("There were %d exceptions.", new Object[]{Integer.valueOf(arrayList2.size())}), (List<? extends Throwable>) arrayList2));
                            }
                        } else if (atomicBoolean2.get()) {
                            jVar2.b();
                        } else {
                            jVar2.b(null);
                        }
                    }
                    return null;
                }
            });
        }
        return jVar.f419a;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002b, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(java.lang.Exception r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f378e
            monitor-enter(r0)
            boolean r1 = r3.f379f     // Catch:{ all -> 0x002c }
            r2 = 0
            if (r1 == 0) goto L_0x000a
            monitor-exit(r0)     // Catch:{ all -> 0x002c }
            return r2
        L_0x000a:
            r1 = 1
            r3.f379f = r1     // Catch:{ all -> 0x002c }
            r3.f382i = r4     // Catch:{ all -> 0x002c }
            r3.f383j = r2     // Catch:{ all -> 0x002c }
            java.lang.Object r4 = r3.f378e     // Catch:{ all -> 0x002c }
            r4.notifyAll()     // Catch:{ all -> 0x002c }
            r3.j()     // Catch:{ all -> 0x002c }
            boolean r4 = r3.f383j     // Catch:{ all -> 0x002c }
            if (r4 != 0) goto L_0x002a
            a.i$a r4 = a()     // Catch:{ all -> 0x002c }
            if (r4 == 0) goto L_0x002a
            a.k r4 = new a.k     // Catch:{ all -> 0x002c }
            r4.<init>(r3)     // Catch:{ all -> 0x002c }
            r3.k = r4     // Catch:{ all -> 0x002c }
        L_0x002a:
            monitor-exit(r0)     // Catch:{ all -> 0x002c }
            return r1
        L_0x002c:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002c }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: a.i.b(java.lang.Exception):boolean");
    }

    /* access modifiers changed from: package-private */
    public final boolean b(TResult tresult) {
        synchronized (this.f378e) {
            if (this.f379f) {
                return false;
            }
            this.f379f = true;
            this.f381h = tresult;
            this.f378e.notifyAll();
            j();
            return true;
        }
    }

    public final <TContinuationResult> i<TContinuationResult> c(g<TResult, TContinuationResult> gVar, Executor executor) {
        return c(gVar, executor, (d) null);
    }

    public final <TContinuationResult> i<TContinuationResult> b(g<TResult, i<TContinuationResult>> gVar, Executor executor) {
        return b(gVar, executor, (d) null);
    }

    public static <TResult> i<TResult> a(Callable<TResult> callable, d dVar) {
        return a(callable, (Executor) f374a, dVar);
    }

    public static <TResult> i<TResult> a(Callable<TResult> callable, Executor executor) {
        return a(callable, executor, (d) null);
    }

    private <TContinuationResult> i<TContinuationResult> c(final g<TResult, TContinuationResult> gVar, Executor executor, d dVar) {
        return b(new g<TResult, i<TContinuationResult>>((d) null) {
            public final /* synthetic */ Object then(i iVar) throws Exception {
                d dVar = null;
                if (dVar != null && dVar.a()) {
                    return i.h();
                }
                if (iVar.d()) {
                    return i.a(iVar.f());
                }
                if (iVar.c()) {
                    return i.h();
                }
                return iVar.a(gVar);
            }
        }, executor);
    }

    public final <TContinuationResult> i<TContinuationResult> b(g<TResult, i<TContinuationResult>> gVar, Executor executor, d dVar) {
        boolean b2;
        j jVar = new j();
        synchronized (this.f378e) {
            b2 = b();
            if (!b2) {
                final j jVar2 = jVar;
                final g<TResult, i<TContinuationResult>> gVar2 = gVar;
                final Executor executor2 = executor;
                final d dVar2 = dVar;
                this.l.add(new g<TResult, Void>() {
                    /* access modifiers changed from: private */
                    /* renamed from: a */
                    public Void then(i<TResult> iVar) {
                        i.b(jVar2, gVar2, iVar, executor2, dVar2);
                        return null;
                    }
                });
            }
        }
        if (b2) {
            b(jVar, gVar, this, executor, dVar);
        }
        return jVar.f419a;
    }

    private static <TResult> i<TResult> a(final Callable<TResult> callable, Executor executor, final d dVar) {
        final j jVar = new j();
        try {
            executor.execute(new Runnable() {
                public final void run() {
                    d dVar = dVar;
                    if (dVar == null || !dVar.a()) {
                        try {
                            jVar.b(callable.call());
                        } catch (CancellationException unused) {
                            jVar.b();
                        } catch (Exception e2) {
                            jVar.b(e2);
                        }
                    } else {
                        jVar.b();
                    }
                }
            });
        } catch (Exception e2) {
            jVar.b((Exception) new h(e2));
        }
        return jVar.f419a;
    }

    public static <TContinuationResult, TResult> void b(final j<TContinuationResult> jVar, final g<TResult, i<TContinuationResult>> gVar, final i<TResult> iVar, Executor executor, final d dVar) {
        try {
            executor.execute(new Runnable() {
                public final void run() {
                    d dVar = dVar;
                    if (dVar == null || !dVar.a()) {
                        try {
                            i iVar = (i) gVar.then(iVar);
                            if (iVar == null) {
                                jVar.b(null);
                            } else {
                                iVar.a(new g<TContinuationResult, Void>() {
                                    public final /* synthetic */ Object then(i iVar) throws Exception {
                                        if (dVar != null && dVar.a()) {
                                            jVar.b();
                                            return null;
                                        } else if (iVar.c()) {
                                            jVar.b();
                                            return null;
                                        } else if (iVar.d()) {
                                            jVar.b(iVar.f());
                                            return null;
                                        } else {
                                            jVar.b(iVar.e());
                                            return null;
                                        }
                                    }
                                });
                            }
                        } catch (CancellationException unused) {
                            jVar.b();
                        } catch (Exception e2) {
                            jVar.b(e2);
                        }
                    } else {
                        jVar.b();
                    }
                }
            });
        } catch (Exception e2) {
            jVar.b((Exception) new h(e2));
        }
    }

    public static <TContinuationResult, TResult> void a(final j<TContinuationResult> jVar, final g<TResult, TContinuationResult> gVar, final i<TResult> iVar, Executor executor, final d dVar) {
        try {
            executor.execute(new Runnable() {
                public final void run() {
                    d dVar = dVar;
                    if (dVar == null || !dVar.a()) {
                        try {
                            jVar.b(gVar.then(iVar));
                        } catch (CancellationException unused) {
                            jVar.b();
                        } catch (Exception e2) {
                            jVar.b(e2);
                        }
                    } else {
                        jVar.b();
                    }
                }
            });
        } catch (Exception e2) {
            jVar.b((Exception) new h(e2));
        }
    }
}