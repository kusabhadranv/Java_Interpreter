package bytecode;

import java.util.ArrayList;
import interpreter.VirtualMachine;

public abstract class JumpCode extends ByteCode {
    public abstract void init(ArrayList<String> args);

    public abstract void execute(VirtualMachine vm);

    public abstract void setdestination(int dest);

    public abstract String getlabel();
}