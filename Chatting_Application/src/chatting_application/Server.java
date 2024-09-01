package chatting_application;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.net.*;

public class Server implements ActionListener {

    JTextField text;
    JPanel a1;
    static Box vertical = Box.createVerticalBox();
    static JFrame f = new JFrame();
    static DataOutputStream dout;
    Server() {

        f.setLayout(null);

//        JPanel backgroundPanel = new JPanel() {
//            @Override
//            protected void paintComponent(Graphics g) {
//                super.paintComponent(g);
//                ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/back.webp"));
//                Image image = icon.getImage();
//                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
//            }
//        };
//        backgroundPanel.setBounds(0, 0, 450, 700);
//        backgroundPanel.setLayout(null);
//        add(backgroundPanel);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(7,94,84));
        p1.setBounds(0,0,450,70);
        p1.setLayout(null);
        f.add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/3.png"));
        Image i2 = i1.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel back =new JLabel(i3);
        back.setBounds(5,20,25,25);
        p1.add(back);

        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent ae) {
                System.exit(0);
            }
        });

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/1.png"));
        Image i5= i4.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel profile =new JLabel(i6);
        profile.setBounds(40,10,50,50);
        p1.add(profile);

        ImageIcon i7= new ImageIcon(ClassLoader.getSystemResource("icons/video.png"));
        Image i8 = i7.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        ImageIcon i9= new ImageIcon(i8);
        JLabel video =new JLabel(i9);
        video.setBounds(300,20,30,30);
        p1.add(video);


        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("icons/phone.png"));
        Image i11 = i10.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);
        JLabel phone =new JLabel(i12);
        phone.setBounds(360,15,35,38);
        p1.add(phone);

        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("icons/3icon.png"));
        Image i14 = i13.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        ImageIcon i15 = new ImageIcon(i14);
        JLabel morevert = new JLabel(i15);
        morevert.setBounds(420,20,5,27);
        p1.add(morevert);

        JLabel name = new JLabel("Debmalya");
        name.setBounds(95,15,100,16);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("SAN SERIF", Font.BOLD, 18));
        p1.add(name);

        JLabel status = new JLabel("Active now");
        status.setBounds(95,35,100,18);
        status.setForeground(Color.WHITE);
        status.setFont(new Font("SAN SERIF", Font.BOLD, 14));
        p1.add(status);


        a1 = new JPanel();
        a1.setBounds(5,75,440,570);
        f.add(a1);


        text = new JTextField();
        text.setBounds(5,655,310,40);
        text.setFont(new Font("SAN SERIF", Font.PLAIN,16));
        f.add(text);


        JButton send = new JButton("Send");
        send.setBounds(320,655,123,40);
        send. setBackground(new Color(7,94,84));
        send.setForeground(Color.WHITE);
        send.addActionListener(this);
        send.setFont(new Font("SAN SERIF", Font.PLAIN, 16));
        f.add(send);

        f.setSize(450, 700);
        f.setLocation(200,50);
        f. setUndecorated(true);
        f.getContentPane().setBackground(Color.WHITE);

        f.setVisible(true);

    }

//    public  void  actionPerformed(ActionEvent ae) {
//        String out = text.getText();
//
//        JLabel output = new JLabel();
//
//        JPanel p2 = new JPanel();
//        p2.add(output);
//
//        a1.setLayout(new BorderLayout());
//
//        JPanel right= new JPanel(new BorderLayout());
//        right.add(p2, BorderLayout.LINE_END);
//        vertical.add(right);
//        vertical.add(Box.createVerticalStrut(15));
//
//        a1.add(vertical, BorderLayout.PAGE_START);
//
//        repaint();
//        invalidate();
//        validate();
//
//    }

//    public void actionPerformed(ActionEvent ae) {
//        try {
//            String out = text.getText();
//
//            // Set the text of the JLabel
//            JLabel output = new JLabel(out);
//
//            // Create a panel and add the JLabel to it
//            JPanel p2 = formatLabel(out);
////        p2.add(output);
//
//            // Set the layout of 'a1' panel to BorderLayout
//            a1.setLayout(new BorderLayout());
//
//            // Create a new panel 'right' with BorderLayout and add 'p2' to it
//            JPanel right = new JPanel(new BorderLayout());
//            right.add(p2, BorderLayout.LINE_END);
//
//            // Add 'right' panel to the vertical box and add a vertical space of 15 pixels
//            vertical.add(right);
//            vertical.add(Box.createVerticalStrut(15));
//
//            // Add the vertical box to the top of 'a1' panel
//            a1.add(vertical, BorderLayout.PAGE_START);
//            dout.writeUTF(out);
//
//            text.setText("");
//
//            // Update the GUI to reflect changes
//            a1.revalidate(); // Revalidate to recalculate the layout
//            a1.repaint(); // Repaint the panel to display the new components
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        // Clear the text field after sending the message
//        text.setText("");
//    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String out = text.getText();

            // Set the text of the JLabel
            JLabel output = new JLabel(out);

            // Create a panel and add the JLabel to it
            JPanel p2 = formatLabel(out);
//        p2.add(output);

            // Set the layout of 'a1' panel to BorderLayout
            a1.setLayout(new BorderLayout());

            // Create a new panel 'right' with BorderLayout and add 'p2' to it
            JPanel right = new JPanel(new BorderLayout());
            right.add(p2, BorderLayout.LINE_END);

            // Add 'right' panel to the vertical box and add a vertical space of 15 pixels
            vertical.add(right);
            vertical.add(Box.createVerticalStrut(15));

            // Add the vertical box to the top of 'a1' panel
            a1.add(vertical, BorderLayout.PAGE_START);

            dout.writeUTF(out);

            text.setText("");

            // Update the GUI to reflect changes
            a1.revalidate(); // Revalidate to recalculate the layout
            a1.repaint(); // Repaint the panel to display the new components

        }catch (Exception e) {
            e.printStackTrace();
        }
        // Clear the text field after sending the message
        text.setText("");
    }
    public static JPanel formatLabel(String out) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        JLabel output = new JLabel("<html><p style=\"width: 150px\">" + out + "</p></html>");
        output.setFont(new Font("Tahoma", Font.PLAIN, 16));
        output.setBackground(new Color(37,211,102));
        output.setOpaque(true);
        output.setBorder(new EmptyBorder(15,15,15,50));

        panel.add(output);

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

        JLabel time = new JLabel();
        time.setText(sdf.format(cal.getTime()));


        panel.add(time);

        return panel;
    }


    public static void main(String[] args) {
        new Server();

        try {
            ServerSocket skt = new ServerSocket(6001);
            while (true) {
                Socket s = skt.accept();
                DataInputStream dis = new DataInputStream(s.getInputStream());
                dout = new DataOutputStream(s.getOutputStream());

                while(true) {
                    String moh = dis.readUTF();
                    JPanel panel = formatLabel(moh);

                    JPanel left = new JPanel(new BorderLayout());
                    left.add(panel, BorderLayout.LINE_START);
                    vertical.add(left);
                    f.validate();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}