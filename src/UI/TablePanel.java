package UI;

import javax.swing.*;
import java.awt.*;

public class TablePanel extends JPanel {

    private JTable table;
    private TableModel tableModel;

    public TablePanel(String[] columnNames) {
        setLayout(new BorderLayout());

        tableModel = new TableModel(columnNames);
        table = new JTable(tableModel);
        table.setRowHeight(25);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void addRow(String[] rowData) {
        tableModel.addRow(rowData);
    }

    public void removeRow(int rowIndex) {
        tableModel.removeRow(rowIndex);
    }
}