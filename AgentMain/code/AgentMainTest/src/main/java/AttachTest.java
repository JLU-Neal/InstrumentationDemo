import com.sun.tools.attach.VirtualMachine;

public class AttachTest {

    public static void main(String[] args) throws Exception {
        VirtualMachine attach = VirtualMachine.attach(args[0]);
        attach.loadAgent(args[1]);
    }
}
