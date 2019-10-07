package bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class HaltCode extends ByteCode {
    public void init(ArrayList<String> args){
    }
    public void execute(VirtualMachine vm){
        vm.halt();
    }
    public String toString(){
        String out_string;
        out_string = "HALT";
        return out_string;
    }
}
