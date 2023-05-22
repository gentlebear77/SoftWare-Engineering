package UI;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class PortfolioPanel extends JPanel{

    private JButton backButton;
	private JButton exitButton;
	private JButton importButton1;

    public PortfolioPanel() {
        setLayout(null);
        //setLayout(new BorderLayout());
        
        backButton = new JButton("Back");//a back-arrow picture
        backButton.setBounds(0,0,70,30);
        backButton.setContentAreaFilled(false);
        
        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.BOLD, 13));
        exitButton.setBounds(891,0,70,30);
        exitButton.setContentAreaFilled(false);
        exitButton.setBorderPainted(false);

        JLabel titleLabel = new JLabel("Portfolio");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setBounds(180,90,250,40); 

        
        importButton1 = new JButton("Import");
        importButton1.setBounds(340,100,80,25);

        JPanel portfolio = new JPanel();
        portfolio.setLayout(new FlowLayout());
        JScrollPane scrollPane = new JScrollPane(portfolio);
        scrollPane.setBounds(100, 150, 750, 400);
        add(scrollPane);

        importButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    String filePath = selectedFile.getAbsolutePath();
                    String fileType = filePath.substring(filePath.lastIndexOf('.')).toLowerCase();

                    ImageIcon icon = null;

                    if (fileType.equals(".jpg") || fileType.equals(".jpeg") || fileType.equals(".png") || fileType.equals(".gif")) {
                        icon = new ImageIcon(filePath);
                    } else {
                        //Set ICONS or covers for other file types
                        icon = new ImageIcon("path/to/your/default/icon.png");
                    }

                    Image image = icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
                    icon = new ImageIcon(image);
                    JLabel fileLabel = new JLabel(icon);
                    fileLabel.setToolTipText(selectedFile.getName());
                    portfolio.add(fileLabel);
                    portfolio.revalidate();
                    portfolio.repaint();
                }
            }
        });

        add(backButton);
        add(exitButton);
        add(titleLabel);
        add(importButton1);
    }

    public JButton getBackButton() {
        return backButton;
    }
    public JButton getExitButton() {
        return exitButton;
    }

    
}

