package interpreter;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RunTimeStack {

    private ArrayList<Integer> runTimeStack;
    private Stack<Integer>     framePointer;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }


    public void dump(){
        System.out.print("\n");
        int runTimeStack_ptr = 0;
        for(int frame_index = 0;frame_index < (framePointer.size()-1);frame_index++){
            int frame_size = framePointer.get(frame_index + 1) - framePointer.get(frame_index);
            int frame_end = frame_size + runTimeStack_ptr;
            System.out.print("[");
            for(int runtimestack_index = runTimeStack_ptr; runtimestack_index < frame_end;runtimestack_index++){
                if((runtimestack_index+1) == frame_end){
                    System.out.print(runTimeStack.get(runtimestack_index));
                }
                else{
                    System.out.print(runTimeStack.get(runtimestack_index) + ",");
                }
                runTimeStack_ptr++;
            }
            System.out.print("]");
        }
        System.out.print("[");
        for(int index = runTimeStack_ptr;index < runTimeStack.size();index++){
            if((index+1) == runTimeStack.size()){
                System.out.print(runTimeStack.get(index));
            }
            else{
                System.out.print(runTimeStack.get(index) + ",");
            }
        }
        System.out.print("]\n");
    }

    public int peek(){
        return runTimeStack.get(runTimeStack.size()-1);
    }

    public int push(int value){
        runTimeStack.add(value);
        return value;
    }

    public int pop(){
        int top_of_stack=0;
        int frame_size = runTimeStack.size() - framePointer.peek();
        if (frame_size>0){
            top_of_stack = runTimeStack.get(runTimeStack.size()-1);
            runTimeStack.remove(runTimeStack.size()-1);
        }
        return top_of_stack;
    }

    public int store(int offset){
        int top_of_stack = runTimeStack.get(runTimeStack.size()-1);
        int stack_pos = framePointer.peek()+offset;
        runTimeStack.remove(runTimeStack.size()-1);
        runTimeStack.set(stack_pos,top_of_stack);
        return top_of_stack;
    }

    public int load(int offset){
        int value_index = framePointer.peek() + offset;
        int value = runTimeStack.get(value_index);
        runTimeStack.add(value);
        return value;
    }

    public void newFrameAt(int offset){
        int frame_pointer = runTimeStack.size() - offset;
        framePointer.add(frame_pointer);
    }

    public void popFrame(){
        int pop_nos =runTimeStack.size() - framePointer.peek();
        int top_of_stack = runTimeStack.get(runTimeStack.size()-1);
        for(int i=0;i<pop_nos;i++){
            this.pop();
        }
        runTimeStack.add(top_of_stack);
        framePointer.pop();
    }
    public List<Integer> get_top_frame(){
        List<Integer> top_frame = new ArrayList();
        for(int stack_pos = framePointer.peek(); stack_pos < runTimeStack.size();stack_pos++){
            top_frame.add(runTimeStack.get(stack_pos));
        }
        return top_frame;
    }
}
