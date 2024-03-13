import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {
    private String Ans;
    private String Mem;
    public Calculator(){
        this.Ans = "0";
        this.Mem = "0";
    }

    public String getMem() {
        return Mem;
    }

    public void setMem(String mem) {
        Mem = mem;
    }

    public String getAns() {
        return Ans;
    }

    public String calculate(String exp) {
        String line = null;
        String expression = exp.replace("^", "**");
        expression = expression.replace("÷", "/");
        expression = expression.replace("×", "*");
        expression = expression.replace("π", "pi");
        try{
            Runtime rt = Runtime.getRuntime();
            String pythonCode =
                    "from math import *;"
                            + "math_functions = " +
                            "{'sqrt': sqrt, 'acos': acos, 'asin': asin, 'atan': atan, " +
                            "'atan2': atan2, 'ceil': ceil, 'cos': cos, 'cosh': cosh, " +
                            "'degrees': degrees, 'exp': exp, 'fabs': fabs, 'floor': floor, " +
                            "'fmod': fmod, 'frexp': frexp, 'hypot': hypot, 'ldexp': ldexp, " +
                            "'log': log, 'log10': log10, 'modf': modf, 'pow': pow, " +
                            "'radians': radians, 'sin': sin, 'sinh': sinh, 'tan': tan, " +
                            "'tanh': tanh, 'pi': pi, 'e': e};"

                            + "result = eval('"+expression+"', math_functions);"
                            + "print(result)";
            System.out.println(pythonCode);
            // Construct the Python command
            String pythonCommand = "python -c \"" + pythonCode + "\"";

            // Execute the Python command
            Process pr= Runtime.getRuntime().exec(pythonCommand);

            BufferedReader inputReader = new BufferedReader(new InputStreamReader(pr.getInputStream()));
            line = inputReader.readLine();
            System.out.println("Output: " + line);

            inputReader.close();
        }
        catch (IOException e) {
            return "ERROR";
        }
        if (line != null) {
            this.Ans = line;
            return line;
        }
        return "ERROR";
    }
}
