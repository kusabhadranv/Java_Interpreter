package bytecode;
import interpreter.VirtualMachine;

import java.util.ArrayList;

public class CallCode extends JumpCode {
    String function_id;
    int destination;
    public void init(ArrayList<String> args){
        function_id=args.get(0);
    }
    public void execute(VirtualMachine vm){
        int return_addr = vm.getPc();
        vm.pushReturnAddr(return_addr);
        vm.setPc(destination-1); //pc gets ++sed after this
    }
    public void setdestination(int dest){
        destination = dest;
    }
    public String getlabel(){
        return function_id;
    }
    public String toString (){
        String out_string;
        String[] tokens = function_id.split("<<");
        String base_id = tokens[0];
        out_string = "CALL " + function_id + "    " + base_id;
        return  out_string;
    }

}
