package bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class ArgsCode extends ByteCode {
    int argument;
    public void init(ArrayList<String> arg){
        argument=Integer.parseInt(arg.get(0));
    }
    public void execute(VirtualMachine vm){
        vm.newFrameAt(argument);
    }
    public String toString(){
        String out_string;
        out_string = "ARGS " + argument;
        return out_string;
    }
}
