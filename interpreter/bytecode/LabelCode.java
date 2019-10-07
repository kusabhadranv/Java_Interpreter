package bytecode;

import java.util.ArrayList;
import interpreter.VirtualMachine;

public class LabelCode extends ByteCode {
    String label;
    public void init(ArrayList<String> args){
        label = args.get(0);
    }

    public void execute(VirtualMachine vm){
    }

    public String getlabel(){
        return label;
    }
    public String toString(){
        String out_string;
        out_string = "LABEL " + label;
        return out_string;
    }
}
