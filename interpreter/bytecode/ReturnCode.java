package bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class ReturnCode extends ByteCode {
    String function_id;
    int arg_count = 0;
    public void init(ArrayList<String> args){
        arg_count = args.size();
        if(arg_count>0){
            function_id = args.get(0);
        }
    }
    public void execute(VirtualMachine vm){
        vm.popFrame();
        int return_addr = vm.popReturnAddr();
        vm.setPc(return_addr);
    }
    public String toString(){
        String out_string;
        if (arg_count>0){
            String[] tokens = function_id.split("<<");
            String base_id = tokens[0];
            out_string = "RETURN " + function_id + "   " + "EXIT " + base_id + " : ";
        }
        else{
            out_string = "RETURN ";
        }
        return out_string;
    }
}
