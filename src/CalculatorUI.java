import com.formdev.flatlaf.FlatIntelliJLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CalculatorUI extends JFrame {

    class CalcButton extends JButton {
        class ButtonEventListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean cleared = false;
                if (toBeCleared){
                    textArea.setText("");
                    toBeCleared = false;
                }

                CalcButton button = (CalcButton) e.getSource();
                if (button.value.equals("=") ){
                    String resault = calc.calculate(textArea.getText());
                    textArea.setText(resault);
                    toBeCleared = true;

                }
                else if (button.value.equals("C")){
                    textArea.setText("");
                }
                else if (button.value.equals("Del")){
                    if (!textArea.getText().isEmpty())
                    textArea.setText(textArea.getText().substring(0, textArea.getText().length()-1));
                }
                else if (button.value.equals("←")){
                   
                }
                else{
                    textArea.setText(textArea.getText()+button.value);

                }
            }

        }

        public String value; // can be not the same as text like 'pi' and π

        private void initStyle() {
            setFont(new Font("Arial", Font.PLAIN, 15));
            setSize(50,50);
        }
        public CalcButton(String text) {
            super(text);
            initStyle();
            value = text;
            addActionListener(new ButtonEventListener());
        }
        public CalcButton(String text, String value) {
            super(text);
            initStyle();
            this.value = value;
            addActionListener(new ButtonEventListener());
        }
    }
//    TODO: add theme button
    class ThemeButton extends JButton {
        private int currentTheme = 0;
        class ButtonEventListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {


                ThemeButton button = (ThemeButton) e.getSource();

            }

        }

        public String value; // can be not the same as text like 'pi' and π

        private void initStyle() {
            setFont(new Font("Arial", Font.PLAIN, 15));
            setSize(50,50);
        }
        public ThemeButton(String text) {
            super(text);
            initStyle();
            value = text;
            addActionListener(new ButtonEventListener());
        }
        public ThemeButton(String text, String value) {
            super(text);
            initStyle();
            this.value = value;
            addActionListener(new ButtonEventListener());
        }
    }

    private  JPanel panel0 = new JPanel(new BorderLayout());
    private JButton button = new JButton();
    ImageIcon sunIcon = new ImageIcon("../img/sun.png");
    ImageIcon moonIcon = new ImageIcon("../img/moon.png");
    private  JPanel panel1 = new JPanel(new BorderLayout());
    private JTextArea textArea = new JTextArea();
    public boolean toBeCleared = false; // for textArea


    private JPanel panel2 = new JPanel(new GridLayout(8,5));
//

    private JLabel spacer1 = new JLabel("");
    private JLabel spacer2 = new JLabel("");
    private CalcButton b_alt = new CalcButton("Alt");
    private CalcButton b_left = new CalcButton("←");
    private CalcButton b_right = new CalcButton("→");
//
    private CalcButton b_1 = new CalcButton("1");
    private CalcButton b_2 = new CalcButton("2");
    private CalcButton b_3 = new CalcButton("3");
    private CalcButton b_4 = new CalcButton("4");
    private CalcButton b_5 = new CalcButton("5");
    private CalcButton b_6 = new CalcButton("6");
    private CalcButton b_7 = new CalcButton("7");
    private CalcButton b_8 = new CalcButton("8");
    private CalcButton b_9 = new CalcButton("9");
    private CalcButton b_0 = new CalcButton("0");
    private CalcButton b_dot = new CalcButton(".");
    private CalcButton b_plus = new CalcButton("+");
    private CalcButton b_minus = new CalcButton("-");
    private CalcButton b_multiply = new CalcButton("×","*");
    private CalcButton b_divide = new CalcButton("/");
    private CalcButton b_power = new CalcButton("^");
    private CalcButton b_equals = new CalcButton("=");
    private CalcButton b_clear = new CalcButton("C");
    private CalcButton b_ans = new CalcButton("Ans");
    private CalcButton b_lb = new CalcButton("(");
    private CalcButton b_rb = new CalcButton(")");
    private CalcButton b_pi = new CalcButton("π");
    private CalcButton b_e = new CalcButton("e");
    private CalcButton b_exp = new CalcButton("e^x");
    private CalcButton b_del = new CalcButton("Del");

    private CalcButton b_mod = new CalcButton("mod", "%");
    private CalcButton b_log = new CalcButton("log", "log(");
    private CalcButton b_ln = new CalcButton("ln", "ln(");
    private CalcButton b_cos = new CalcButton("cos", "cos(");
    private CalcButton b_sin = new CalcButton("sin", "sin(");
    private CalcButton b_tan = new CalcButton("tan", "tan(");

    private CalcButton b_cosh = new CalcButton("cosh", "cosh(");
    private CalcButton b_sinh = new CalcButton("sinh", "sinh(");
    private CalcButton b_tanh = new CalcButton("tanh", "tanh(");
    private CalcButton b_sqrt = new CalcButton("√", "√(");




    private Calculator calc = new Calculator() ;
    public CalculatorUI() {


        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350,500);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

        textArea.setFont(new Font("Arial", Font.PLAIN, 36));
        setLayout(new BorderLayout());
        add(panel1, BorderLayout.CENTER);
        panel1.add(textArea, BorderLayout.NORTH);
        panel1.add(panel2, BorderLayout.CENTER);

//        ===============================

        panel2.add(b_alt);
        panel2.add(spacer1);
        panel2.add(b_left);
        panel2.add(b_right);
        panel2.add(spacer2);

        panel2.add(b_cosh);
        panel2.add(b_sinh);
        panel2.add(b_tanh);
        panel2.add(b_clear);
        panel2.add(b_del);

        panel2.add(b_cos);
        panel2.add(b_sin);
        panel2.add(b_tan);
        panel2.add(b_pi);
        panel2.add(b_e);

        panel2.add(b_power);
        panel2.add(b_lb);
        panel2.add(b_rb);
        panel2.add(b_mod);
        panel2.add(b_divide);

        panel2.add(b_exp);
        panel2.add(b_7);
        panel2.add(b_8);
        panel2.add(b_9);
        panel2.add(b_multiply);

        panel2.add(b_sqrt);
        panel2.add(b_6);
        panel2.add(b_5);
        panel2.add(b_4);
        panel2.add(b_minus);

        panel2.add(b_log);
        panel2.add(b_1);
        panel2.add(b_2);
        panel2.add(b_3);
        panel2.add(b_plus);

        panel2.add(b_ln);
        panel2.add(b_dot);
        panel2.add(b_0);
        panel2.add(b_ans);
        panel2.add(b_equals);

    }



    public static void main(String[] args) throws IOException {

        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }
        CalculatorUI app = new CalculatorUI();

    }

}
