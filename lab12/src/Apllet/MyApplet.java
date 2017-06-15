package Apllet;

import javax.swing.*;

public class MyApplet extends JApplet{
    private javax.swing.JButton jButton1; // кнопка расчета
    private javax.swing.JComboBox jComboBox1; // исходная шкала температур
    private javax.swing.JComboBox jComboBox2; // результирующая шкала температур
    private javax.swing.JTextField jTextField1; // исходное значение температуры
    private javax.swing.JTextField jTextField2; // результирующее значение температуры
    private javax.swing.JLabel jLabel1; // поясняющие надписи
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1; //панели для размещения компонентов
    private javax.swing.JPanel jPanel4;


    private double FromValue;
    private String FromValueStr;
    private double ToValue;
    private String ToValueStr;


    public void init() {
        try {
            java.awt.EventQueue.invokeAndWait(new Runnable() {
                public void run() {
                    initComponents();
                    jPanel1.setBounds(10, 10, 400, 70);
                    jComboBox1.addItem("Цельсий");
                    jComboBox1.addItem("Кельвин");
                    jComboBox1.addItem("Фаренгейт");

                    jComboBox2.addItem("Цельсий");
                    jComboBox2.addItem("Кельвин");
                    jComboBox2.addItem("Фаренгейт");
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        setName("MainApplet");
        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(501, 75));
        jPanel1.setLayout(new java.awt.BorderLayout());
        jPanel4.setLayout(new java.awt.GridLayout(2, 4, 5, 5));
        jLabel1.setText("Исходная шкала:");
        jPanel4.add(jLabel1);
        jComboBox1.setMaximumSize(new java.awt.Dimension(100, 20));
        jComboBox1.setMinimumSize(new java.awt.Dimension(100, 20));
        jComboBox1.setName("Kelvin");
        jComboBox1.setPreferredSize(new java.awt.Dimension(100, 20));
        jPanel4.add(jComboBox1);
        jLabel2.setText("Значение : ");
        jLabel2.setMaximumSize(new java.awt.Dimension(100, 20));
        jLabel2.setMinimumSize(new java.awt.Dimension(100, 20));
        jLabel2.setPreferredSize(new java.awt.Dimension(100, 20));
        jPanel4.add(jLabel2);
        jTextField1.setText("0");
        jTextField1.setMaximumSize(new java.awt.Dimension(100, 20));
        jTextField1.setMinimumSize(new java.awt.Dimension(100, 20));
        jTextField1.setPreferredSize(new java.awt.Dimension(100, 20));
        jPanel4.add(jTextField1);
        jLabel3.setText("Результат:");
        jPanel4.add(jLabel3);
        jComboBox2.setMaximumSize(new java.awt.Dimension(100, 20));
        jComboBox2.setMinimumSize(new java.awt.Dimension(100, 20));
        jComboBox2.setPreferredSize(new java.awt.Dimension(100, 20));
        jPanel4.add(jComboBox2);
        jLabel4.setText("Значение :");
        jLabel4.setMaximumSize(new java.awt.Dimension(100, 20));
        jLabel4.setMinimumSize(new java.awt.Dimension(100, 20));
        jLabel4.setPreferredSize(new java.awt.Dimension(100, 20));
        jPanel4.add(jLabel4);
        jTextField2.setText("0");
        jTextField2.setMaximumSize(new java.awt.Dimension(100, 20));
        jTextField2.setMinimumSize(new java.awt.Dimension(100, 20));
        jTextField2.setPreferredSize(new java.awt.Dimension(100, 20));
        jPanel4.add(jTextField2);
        jPanel1.add(jPanel4, java.awt.BorderLayout.CENTER);
        jButton1.setText("Перевод");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, java.awt.BorderLayout.SOUTH);
        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
        getAccessibleContext().setAccessibleName("MainApplet");
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        FromValueStr = jTextField1.getText();
        try {
            FromValue = Double.parseDouble(FromValueStr);
        } catch (Exception e) {
            System.out.println("BALBES");
        }
        if (!jComboBox1.getSelectedItem().toString().equalsIgnoreCase("Цельсий")) {
        } else {
            if (jComboBox2.getSelectedItem().toString() == "Кельвин") {
                ToValue = FromValue + 273.15;
            }
            if (jComboBox2.getSelectedItem().toString() == "Фаренгейт") {
                ToValue = (1.8 * FromValue) + 32;
            }
        }
        if (jComboBox1.getSelectedItem().toString() == "Кельвин") {
            if (jComboBox2.getSelectedItem().toString() == "Цельсий") {
                ToValue = FromValue - 273.15;
            }
            if (jComboBox2.getSelectedItem().toString() == "Фаренгейт") {
                ToValue = (1.8 * (FromValue - 275.15)) + 32;
            }
        }
        if (jComboBox1.getSelectedItem().toString() == "Фаренгейт") {
            if (jComboBox2.getSelectedItem().toString() == "Цельсий") {
                ToValue = (FromValue - 32) / 1.8;
            }
            if (jComboBox2.getSelectedItem().toString() == "Кельвин") {
                ToValue = (FromValue - 32) / 1.8 + 273.15;
            }
        }
        String ToValueStr = String.format("%10.2f", ToValue);
        jTextField2.setText(ToValueStr.trim());
    }

}
