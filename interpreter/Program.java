package interpreter;

import java.util.ArrayList;
import java.util.HashMap;

import bytecode.*;

public class Program {

    private ArrayList<ByteCode> program;
    private HashMap<String,Integer> labelMap= new HashMap<String,Integer>();

    public Program() {
        program = new ArrayList<>();
    }

    protected ByteCode getCode(int pc) {
        return this.program.get(pc);
    }

    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter(PC)
     * HINT: make note what type of data-stucture bytecodes are stored in.
     */
    public void resolveAddrs() {
        for(int x=0;x<program.size();x++){
            if(program.get(x) instanceof JumpCode){
                String label = ((JumpCode)program.get(x)).getlabel();
                int dest = labelMap.get(label);
                ((JumpCode)program.get(x)).setdestination(dest);
            }
        }
    }

    public void addByteCode(ByteCode bc){
        if(bc instanceof LabelCode){
            String label = ((LabelCode)bc).getlabel();
            labelMap.put(label,program.size());
        }
        program.add(bc);
    }
}
