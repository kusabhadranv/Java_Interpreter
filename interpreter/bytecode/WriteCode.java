package bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class WriteCode extends ByteCode {
    public void init(ArrayList<String> args){
    }
    public void execute(VirtualMachine vm){
        System.out.println(vm.peek());
    }
    public String toString(){
        String out_string;
        out_string = "WRITE";
        return out_string;
    }
}
