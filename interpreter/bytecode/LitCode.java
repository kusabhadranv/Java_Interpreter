package bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LitCode extends ByteCode {
    int literal;
    String id = " ";
    int arg_count=0;
    public void init(ArrayList<String> args){
        literal = Integer.parseInt(args.get(0));
        arg_count = args.size();
        if (args.size()>1) {
            id = args.get(1);
        }
    }
    public void execute(VirtualMachine vm){
        vm.push(literal);
    }
    public String toString(){
        String out_string = " ";
        if(arg_count>1){
            out_string = "LIT " + literal + " " + id + "    " + "int " + id ;
        }
        else{
            out_string = "LIT " + literal;
        }
        return out_string;
    }
}
