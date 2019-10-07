package bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;


public class LoadCode extends ByteCode {
    int offset;
    String id;
    int arg_size=0;
    public void init(ArrayList<String> args){
        offset = Integer.parseInt(args.get(0));
        arg_size = args.size();
        if(arg_size>1){
            id = args.get(1);
        }
    }
    public void execute(VirtualMachine vm){
        vm.load(offset) ;
    }
    public String toString(){
        String out_string;
        if(arg_size>1){
            out_string = "LOAD " + offset + " " + id + "    <load " + id + ">";
        }
        else{
            out_string = "LOAD " + offset;
        }
        return out_string;
    }
}
