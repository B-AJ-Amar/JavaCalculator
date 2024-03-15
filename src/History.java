import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
public class History {
    public static void showHistory(JFrame parent) {
        JDialog dialog = new JDialog(parent, "History", true);
        dialog.setSize(400, 300);
        dialog.setLayout(new BorderLayout());

        JTable table = createTable(Calculator.getLogs());

        JScrollPane scrollPane = new JScrollPane(table);

        dialog.add(scrollPane, BorderLayout.CENTER);

        dialog.setLocationRelativeTo(parent);

        dialog.setVisible(true);
    }

    private static Object[][] logsToMatrix(ArrayList<Logs> logs){
        Object[][] data = new Object[logs.size()][3];
        for (int i = 0; i < logs.size(); i++) {
            data[i][0] = logs.get(i).expression;
            data[i][1] = logs.get(i).result;
            data[i][2] = logs.get(i).date;
        }
        return data;
    }
    private static JTable createTable(ArrayList<Logs> logs) {
        Object[][] data = logsToMatrix(logs);

        String[] columns = {"Equation", "Resault", "Created_at"};

        DefaultTableModel model = new DefaultTableModel(data, columns);

        JTable table = new JTable(model);

        return table;
    }



}
