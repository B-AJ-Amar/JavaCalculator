import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class Calculator {

//    private final String logsFile = "src/logs.csv";
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

    private String validate(String exp){
        String expression = exp.replace("^", "**");
        expression = expression.replace("÷", "/");
        expression = expression.replace("×", "*");
        expression = expression.replace("π", "pi");
        expression = expression.replace("√(", "√");
        expression = expression.replace("√", "sqrt(");
        expression = expression.replace("log(", "log10(");
        expression = expression.replace("Ans", this.Ans);
        expression = expression.replace("M", this.Mem);
        return expression;
    }

    public String calculate(String exp) {
        String line = null;
        if (exp.isEmpty()) return "0";
        String expression = validate(exp);

        try{
            Runtime rt = Runtime.getRuntime();
            String pythonCode =
                    "from math import *;"
                            + "math_functions = " +
                            "{'sqrt': sqrt, 'acos': acos, 'asin': asin, 'atan': atan, " +
                            "'atan2': atan2, 'ceil': ceil, 'cos': cos, 'cosh': cosh, " +
                            "'degrees': degrees, 'exp': exp, 'fabs': fabs, 'floor': floor, " +
                            "'fmod': fmod, 'frexp': frexp, 'hypot': hypot, 'ldexp': ldexp, " +
                            "'ln': log, 'log10': log10, 'modf': modf, 'pow': pow, " +
                            "'radians': radians, 'sin': sin, 'sinh': sinh, 'tan': tan, " +
                            "'tanh': tanh, 'pi': pi, 'e': e};"

                            + "result = eval('"+expression+"', math_functions);"
                            + "print(result)";
            // Construct the Python command
            String pythonCommand = "python -c \"" + pythonCode + "\"";

            // Execute the Python command
            Process pr= Runtime.getRuntime().exec(pythonCommand);

            BufferedReader inputReader = new BufferedReader(new InputStreamReader(pr.getInputStream()));
            line = inputReader.readLine();
            saveLog(exp, line);
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

    private void saveLog(String exp, String result) {
        try {
            FileWriter fileWriter = new FileWriter("src/logs.csv", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(exp + ";" + result+";" + new Date().toString());
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Logs> getLogs (){
        ArrayList<Logs> logs = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("src/logs.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(";");
                logs.add(new Logs(data[0], data[1], data[2]));
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return logs;

    }



}

class Logs{
    public String expression;
    public String result;
    public String date;
    public Logs(String expression, String result, String date){
        this.expression = expression;
        this.result = result;
        this.date = date;
    }
}