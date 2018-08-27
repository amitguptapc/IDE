package layout;

import backend.APICall;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIDesign implements ActionListener {
    public static JFrame frame;
    public static JComboBox<String> langSelector;
    public static JTextArea scriptPane;
    public static JEditorPane testCasePane;
    public static JEditorPane outputPane;
    public static JLabel ideLabel;
    public static JLabel selectLabel;
    public static JLabel scriptLabel;
    public static JLabel testCaseLabel;
    public static JLabel OutputLabel;
    public static JButton executeButton;
    public static JButton clearButton;
    public static JPanel panel;

    public static void main(String[] args) {
        try {
            frame = new JFrame();
            panel = new JPanel();
            scriptPane = new JTextArea();
            scriptPane.setRows(50);
            scriptPane.setColumns(40);
            scriptPane.setFont(new Font("Times New Roman", Font.PLAIN, 14));
            JScrollPane scroll = new JScrollPane(scriptPane, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            panel.add(scroll);
            frame.add(panel);
            scriptPane.setBounds(30, 30, 600, 600);
            executeButton = new JButton("Execute");
            frame.setSize(800, 1000);
            panel.add(executeButton);
            executeButton.addActionListener(new UIDesign());
            frame.setResizable(false);
            frame.setVisible(true);
        }catch (Exception ignored){
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == executeButton) {
            try {
                String s = scriptPane.getText();
                s = s.replace("\n", "\\n");
                APICall ob = new APICall();
                ob.script = s;
                ob.caller();
            }catch (Exception ignored){
            }
        }
    }
}