package bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class BopCode extends ByteCode {
    String operator;
    public void init(ArrayList<String> args){
        operator=args.get(0);
    }
    public void execute(VirtualMachine vm){
        int second_operand = vm.pop();
        int first_operand=vm.pop();

        switch(operator){
            case "+":
                vm.push(first_operand + second_operand);
                break;
            case "-":
                vm.push(first_operand - second_operand);
                break;
            case "*":
                vm.push(first_operand * second_operand);
                break;
            case "/":
                vm.push(first_operand / second_operand);
                break;
            case "==":
                if(first_operand==second_operand){
                    vm.push(1);
                }
                else{
                    vm.push(0);
                }
                break;
            case "!=":
                if(first_operand!=second_operand){
                    vm.push(1);
                }
                else{
                    vm.push(0);
                }
                break;
            case "<=":
                if(first_operand<=second_operand){
                    vm.push(1);
                }
                else{
                    vm.push(0);
                }
                break;
            case ">=":
                if(first_operand>=second_operand){
                    vm.push(1);
                }
                else{
                    vm.push(0);
                }
                break;
            case "<":
                if(first_operand<second_operand){
                    vm.push(1);
                }
                else{
                    vm.push(0);
                }
                break;
            case ">":
                if(first_operand>second_operand){
                    vm.push(1);
                }
                else{
                    vm.push(0);
                }
                break;
            case "&":
                if(first_operand==1 && second_operand==1){
                    vm.push(1);
                }
                else{
                    vm.push(0);
                }
                break;
            case "|":
                if(first_operand==1 || second_operand==1){
                    vm.push(1);
                }
                else{
                    vm.push(0);
                }
                break;
        }
    }
    public String toString(){
        String out_string;
        out_string = "BOP " + operator;
        return out_string;
    }
}


