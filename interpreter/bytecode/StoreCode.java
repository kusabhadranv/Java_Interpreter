package bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class StoreCode extends ByteCode{
    int offset;
    String id;
    int arg_count=0;
    public void init(ArrayList<String> args){
        arg_count = args.size();
        offset = Integer.parseInt(args.get(0));
        if(arg_count>1){
            id = args.get(1);
        }
    }
    public void execute(VirtualMachine vm){
        vm.store(offset);
    }
    public String toString(){
        String out_string;
        if (arg_count>1){
            out_string = "STORE " + offset + " " + id + "   " + id + "=";
        }
        else{
            out_string = "STORE" + offset;
        }
        return out_string;
    }
    public int get_arg_count(){
        return arg_count;
    }
}
