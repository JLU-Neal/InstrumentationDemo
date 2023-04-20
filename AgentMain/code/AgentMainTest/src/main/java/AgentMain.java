import java.lang.instrument.ClassDefinition;
import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;
import java.net.URL;
import java.security.CodeSource;
import java.security.ProtectionDomain;

public class AgentMain {
    public static void agentmain(String agentArgs, Instrumentation inst)  throws ClassNotFoundException, UnmodifiableClassException, InterruptedException {
        Class[] loadedClass = inst.getAllLoadedClasses();
        for (Class clazz : loadedClass){
            ProtectionDomain protectionDomain = clazz.getProtectionDomain();
            if (protectionDomain != null) {
                CodeSource codeSource = protectionDomain.getCodeSource();
                if (codeSource != null) {
                    URL location = codeSource.getLocation();
                    if (location != null) {
                        String path = location.getPath();
                        if (path.contains("engine-core") || path.contains("engine-extends") || path.contains("engine-api") || path.contains("engine-module")) {
                            System.out.println("changleTest111|" + clazz.getPackage().getName());
                        }else {
                            System.out.println("Path does not exist!");
                        }
                    }
                }
            }
        }
    }
}