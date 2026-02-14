package e3;

/* loaded from: classes.dex */
public class m {
    public String a(e eVar) {
        String obj = eVar.getClass().getGenericInterfaces()[0].toString();
        return obj.startsWith("kotlin.jvm.functions.") ? obj.substring(21) : obj;
    }

    public String b(g gVar) {
        return a(gVar);
    }
}
