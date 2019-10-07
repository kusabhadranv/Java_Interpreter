package bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class GotoCode extends JumpCode {
    String label;
    int destination;
    public void init(ArrayList<String> args){
        label = args.get(0);
    }
    public void execute(VirtualMachine vm){
        vm.setPc(destination-1); // pc gets added after this line
    }
    public String getlabel(){
        return label;
    }
    public void setdestination(int dest){
        destination = dest;
    }
    public String toString(){
        String out_string;
        out_string = "GOTO " + label;
        return out_string;
    }
}
