package bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class DumpCode extends ByteCode {
    String state;
    public void init(ArrayList<String> args){
        state = args.get(0);
    }
    public void execute(VirtualMachine vm){
        vm.setDumpState(state);
    }
}
