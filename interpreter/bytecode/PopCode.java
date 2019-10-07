package bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class PopCode extends ByteCode {
    int pop_count;
    public void init(ArrayList<String> args){
        pop_count = Integer.parseInt(args.get(0));
    }
    public void execute(VirtualMachine vm){
        for(int i=0;i<pop_count;i++){
            vm.pop();
        }
    }
    public String toString(){
        String out_string;
        out_string = "POP " + pop_count;
        return out_string;
    }
}
