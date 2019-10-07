package interpreter;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import bytecode.*;
import interpreter.RunTimeStack;
import interpreter.Program;

public class VirtualMachine {

    private RunTimeStack   runStack;
    private Stack<Integer> returnAddrs;
    private Program        program;
    private int            pc;
    private boolean        isRunning;
    private boolean        dump = false;

    protected VirtualMachine(Program program) {
        this.program = program;
    }

    public void executeProgram(){
        runStack    = new RunTimeStack();
        returnAddrs = new Stack<Integer>();
        pc          = 0;
        isRunning   = true;

        while (isRunning) {
            ByteCode code = program.getCode(pc);
            code.execute(this);
            if (dump) {
                String out_string = code.toString();
                if (((code instanceof StoreCode) && ((StoreCode) code).get_arg_count()==2) || (code instanceof ReturnCode)){
                    out_string += runStack.peek();
                }
                else if(code instanceof CallCode){
                    out_string += "(";
                    List<Integer> top_frame = new ArrayList();
                    top_frame = runStack.get_top_frame();
                    for(int index=0;index < top_frame.size();index++){
                        if((index+1) == top_frame.size()){
                            out_string += top_frame.get(index);
                        }
                        else{
                            out_string += top_frame.get(index) + ",";
                        }
                    }
                    out_string += ")";
                }
                if(!(code instanceof DumpCode)){
                    System.out.print(out_string);
                    runStack.dump();
                }
            }
            pc++;
        }
    }

    public void newFrameAt(int offset){
        runStack.newFrameAt(offset);
    }

    public void push(int value){
        runStack.push(value);
    }

    public int pop(){
        return runStack.pop();
    }

    public void setPc(int destination){
        pc=destination;
    }

    public int getPc(){
        return pc;
    }

    public void setDumpState(String state){
        if(state.equals("ON")){
            dump=true;
        }
        else{
            dump=false;
        }
    }

    public void halt(){
        isRunning=false;
    }

    public void load(int offset){
        runStack.load(offset);
    }

    public void popFrame(){
        runStack.popFrame();
    }

    public void pushReturnAddr(int return_addr){
        returnAddrs.push(return_addr);
    }

    public int popReturnAddr(){
        return returnAddrs.pop();
    }

    public void store(int offset){
        runStack.store(offset);
    }

    public int peek(){
        return runStack.peek();
    }
}


