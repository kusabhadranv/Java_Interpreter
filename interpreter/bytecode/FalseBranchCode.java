package bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;


public class FalseBranchCode extends JumpCode {
    String label;
    int destination;
    public void init(ArrayList<String> args){
        label = args.get(0);
    }
    public void execute(VirtualMachine vm){
        int top_of_stack=vm.pop();
        boolean isfalse = (top_of_stack==0);
        if(isfalse){
            vm.setPc(destination-1); // pc gets ++ed after this
        }
    }
    public String getlabel(){
        return label;
    }
    public void setdestination(int dest){
        destination = dest;
    }
    public String toString(){
        String out_string;
        out_string = "FALSEBRANCH " + label;
        return out_string;
    }
}
