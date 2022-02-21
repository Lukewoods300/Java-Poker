package poker.controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lobby extends JFrame{
	JLabel name;
    JButton     sendMessage;
    JTextField  messageBox;
    JTextArea   chatBox;
    public Lobby() {
    	setLayout(new BorderLayout());
    	JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel southPanel = new JPanel();
        southPanel.setBackground(Color.BLUE);
        southPanel.setLayout(new GridBagLayout());

        messageBox = new JTextField(30);
        messageBox.requestFocusInWindow();

        sendMessage = new JButton("Send Message");
        sendMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{//add username
				 chatBox.append("<" + ">:  " + messageBox.getText()
                 + "\n");
         messageBox.setText("");
         messageBox.requestFocusInWindow();
			}
        });

        chatBox = new JTextArea();
        chatBox.setEditable(false);
        chatBox.setFont(new Font("Serif", Font.PLAIN, 15));
        chatBox.setLineWrap(true);

        GridBagConstraints left = new GridBagConstraints();
        left.anchor = GridBagConstraints.LINE_START;
        left.fill = GridBagConstraints.HORIZONTAL;
        left.weightx = 512.0D;
        left.weighty = 1.0D;

        GridBagConstraints right = new GridBagConstraints();
        right.insets = new Insets(0, 10, 0, 0);
        right.anchor = GridBagConstraints.LINE_END;
        right.fill = GridBagConstraints.NONE;
        right.weightx = 1.0D;
        right.weighty = 1.0D;
        
        mainPanel.add(new JScrollPane(chatBox), BorderLayout.CENTER);
        southPanel.add(messageBox, left);
        southPanel.add(sendMessage, right);

        mainPanel.add(BorderLayout.SOUTH, southPanel);

        add(mainPanel, BorderLayout.CENTER);

	    setSize(1000,680);
	    setVisible(true);
    }
    
    public static void main(String[] args) {
    	Lobby a = new Lobby();
    }
}
