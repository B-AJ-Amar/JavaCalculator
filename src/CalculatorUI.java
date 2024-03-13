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
                CalcButton button = (CalcButton) e.getSource();
                if (button.value.equals("=")){
                    String resault = calc.calculate(textArea.getText());
                    textArea.setText(resault);
                }
                else if (button.value.equals("C")){
                    textArea.setText("");
                }
                else if (button.value.equals("Del")){
                    textArea.setText(textArea.getText().substring(0, textArea.getText().length()-1));
                }
                else{
                    textArea.setText(textArea.getText()+button.value);
                }
            }

        }

        public String value; // can be not the same as text like 'pi' and π

        private void initStyle() {
            setFont(new Font("Arial", Font.PLAIN, 20));
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

    private JPanel panel1 = new JPanel(new BorderLayout());
    private JTextArea textArea = new JTextArea();


    private JPanel panel2 = new JPanel(new GridLayout(7,7));
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
    private CalcButton b_multiply = new CalcButton("*");
    private CalcButton b_divide = new CalcButton("/");
    private CalcButton b_power = new CalcButton("^");
    private CalcButton b_equals = new CalcButton("=");
    private CalcButton b_clear = new CalcButton("C");
    private CalcButton b_ans = new CalcButton("Ans");
    private CalcButton b_lb = new CalcButton("(");
    private CalcButton b_rb = new CalcButton(")");
    private CalcButton b_pi = new CalcButton("π");
    private CalcButton b_e = new CalcButton("e");
    private CalcButton b_del = new CalcButton("Del");



    private Calculator calc = new Calculator() ;
    public CalculatorUI() {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                 | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,300);
        setLocationRelativeTo(null);
        setVisible(true);


        setLayout(new BorderLayout());
        add(panel1, BorderLayout.NORTH);

        panel1.add(textArea);

        panel2.add(b_1);
        panel2.add(b_2);
        panel2.add(b_3);
        panel2.add(b_plus);
        panel2.add(b_4);
        panel2.add(b_5);
        panel2.add(b_6);
        panel2.add(b_minus);
        panel2.add(b_7);
        panel2.add(b_8);
        panel2.add(b_9);
        panel2.add(b_multiply);
        panel2.add(b_0);
        panel2.add(b_dot);
        panel2.add(b_equals);
        panel2.add(b_divide);
//       base
        panel2.add(b_ans);
        panel2.add(b_lb);
        panel2.add(b_rb);
        panel2.add(b_power);
//
        panel2.add(b_pi);
        panel2.add(b_e);
        panel2.add(b_clear);
        panel2.add(b_del);








        add(panel2, BorderLayout.CENTER);


    }



    public static void main(String[] args) throws IOException {
        CalculatorUI app = new CalculatorUI();

    }

}
