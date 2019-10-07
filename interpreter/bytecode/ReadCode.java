package bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;
import java.util.Scanner;

public class ReadCode extends ByteCode {
    public void init(ArrayList<String> args){
    }
    public void execute(VirtualMachine vm) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter an integer : ");
        while(!scanner.hasNextInt()){
            System.out.print(scanner.next() + " is not an integer. Please enter an integer : ");
        }
        vm.push(scanner.nextInt());
    }
    public String toString(){
        String out_string;
        out_string = "READ";
        return out_string;
    }
}
