package interpreter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import bytecode.HaltCode;
import interpreter.Program;
import interpreter.CodeTable;
import bytecode.ByteCode;
import bytecode.DumpCode;


public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;
    
    /**
     * Constructor Simply creates a buffered reader.
     * YOU ARE NOT ALLOWED TO READ FILE CONTENTS HERE
     * THIS NEEDS TO HAPPEN IN LOADCODES.
     */
    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
    }
    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     *      Tokenize string to break it into parts.
     *      Grab THE correct class name for the given ByteCode from CodeTable
     *      Create an instance of the ByteCode class name returned from code table.
     *      Parse any additional arguments for the given ByteCode and send them to
     *      the newly created ByteCode instance via the init function.
     */
    public Program loadCodes() {
        String   code,bytecode;
        String[] tokens;
        Program program =  new Program();
        try {
            while ((code=byteSource.readLine()) != null) {
                tokens = code.split("\\s+");
                bytecode = tokens[0];
                String bytecodeClass = CodeTable.getClassName(bytecode);
                Class c = Class.forName("bytecode." + bytecodeClass);
                ByteCode bc = (ByteCode)c.getDeclaredConstructor().newInstance();

                ArrayList<String> args =  new ArrayList<String>();
                for(int x=1;x<tokens.length;x++){
                    args.add(tokens[x]);
                }
                bc.init(args);
                program.addByteCode(bc);
            }
        } catch(Exception e){
            System.out.println("File IO exception : " + e);
        }
        program.resolveAddrs();
        return program;
    }
}
