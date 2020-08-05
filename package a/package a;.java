package a;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class a extends Exception {
    private static final long serialVersionUID = 1;

    /* renamed from: a  reason: collision with root package name */
    private List<Throwable> f352a;

    public final List<Throwable> getInnerThrowables() {
        return this.f352a;
    }

    public final Throwable[] getCauses() {
        List<Throwable> list = this.f352a;
        return (Throwable[]) list.toArray(new Throwable[list.size()]);
    }

    public final List<Exception> getErrors() {
        ArrayList arrayList = new ArrayList();
        List<Throwable> list = this.f352a;
        if (list == null) {
            return arrayList;
        }
        for (Throwable next : list) {
            if (next instanceof Exception) {
                arrayList.add((Exception) next);
            } else {
                arrayList.add(new Exception(next));
            }
        }
        return arrayList;
    }

    public a(List<? extends Throwable> list) {
        this("There were multiple errors.", list);
    }

    public final void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        int i2 = -1;
        for (Throwable a2 : this.f352a) {
            printStream.append("\n");
            printStream.append("  Inner throwable #");
            i2++;
            printStream.append(Integer.toString(i2));
            printStream.append(": ");
            com.google.c.a.a.a.a.a.a(a2, printStream);
            printStream.append("\n");
        }
    }

    public final void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        int i2 = -1;
        for (Throwable a2 : this.f352a) {
            printWriter.append("\n");
            printWriter.append("  Inner throwable #");
            i2++;
            printWriter.append(Integer.toString(i2));
            printWriter.append(": ");
            com.google.c.a.a.a.a.a.a(a2, printWriter);
            printWriter.append("\n");
        }
    }

    public a(String str, Throwable[] thArr) {
        this(str, (List<? extends Throwable>) Arrays.asList(thArr));
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a(java.lang.String r2, java.util.List<? extends java.lang.Throwable> r3) {
        /*
            r1 = this;
            if (r3 == 0) goto L_0x0010
            int r0 = r3.size()
            if (r0 <= 0) goto L_0x0010
            r0 = 0
            java.lang.Object r0 = r3.get(r0)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            r1.<init>(r2, r0)
            java.util.List r2 = java.util.Collections.unmodifiableList(r3)
            r1.f352a = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.<init>(java.lang.String, java.util.List):void");
    }
}