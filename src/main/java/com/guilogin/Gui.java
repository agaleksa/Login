package com.guilogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame implements ActionListener {

    private JPanel p;
    private JButton b;
    private JLabel l,l2,l3,l4;
    private JTextArea t;
    private JPasswordField pf;

    public Gui() {
        super("LoginPanel");
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(2,2,200,400);
        setSize(800,800);
        setResizable(true);
        getContentPane().setBackground(Color.ORANGE);
        setLocation(0,0);

        p = new JPanel();
        add(p);
        p.setLayout(null);

        l = new JLabel("e-mail: ");
        l.setVisible(true);
        l.setFont(new Font("Georgia", Font.ITALIC, 20));
        l.setBounds(100,60,200,25);
        p.add(l);

        t = new JTextArea();
        t.setVisible(true);
        t.setFont(new Font("Georgia", Font.ITALIC, 20));
        t.setBounds(250,60,300,25);
        p.add(t);

        l2 = new JLabel("password: ");
        l2.setVisible(true);
        l2.setFont(new Font("Georgia", Font.ITALIC, 20));
        l2.setBounds(100,90,200,25);
        p.add(l2);

        pf = new JPasswordField();
        pf.setVisible(true);
        pf.setFont(new Font("Georgia", Font.ITALIC, 20));
        pf.setBounds(250,90,300,25);
        p.add(pf);

        l3 = new JLabel("result: ");
        l3.setVisible(true);
        l3.setFont(new Font("Georgia", Font.ITALIC, 20));
        l3.setBounds(100,250,200,25);
        p.add(l3);

        l4 = new JLabel("");
        l4.setVisible(true);
        l4.setFont(new Font("Georgia", Font.ITALIC, 20));
        l4.setBounds(250,250,300,25);
        p.add(l4);

        b = new JButton("login");
        b.setBounds(250,170,300,25);
        b.setVisible(true);
        b.setFont(new Font("Georgia", Font.BOLD,20));
        p.add(b);
        b.addActionListener(this);

    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Gui();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        SQL sql = new SQL();
        String result = sql.connect(t.getText().toString(),String.valueOf(pf.getPassword()));
        l4.setText(result);

        }
    }


