package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

class MyFrame extends JFrame {
    private static JLabel picture;

    public MyFrame(String title) throws HeadlessException {
        super(title);

        JPanel myPanel = new JPanel(new GridLayout(2, 2));
        JButton myButton1 = new JButton("Раз");
        JButton myButton2 = new JButton("Два");
        JButton myButton3 = new JButton("Три");

        String catString = "cat";
        JRadioButton catButton = new JRadioButton(catString);
        catButton.setText(catString);
        catButton.setMnemonic(KeyEvent.VK_C);
        catButton.setActionCommand(catString);

        String dogString = "dog";
        JRadioButton dogButton = new JRadioButton(dogString);
        dogButton.setMnemonic(KeyEvent.VK_D);
        dogButton.setActionCommand(dogString);

        ButtonGroup group = new ButtonGroup();
        group.add(catButton);
        group.add(dogButton);

        ActionListener CheckListener = e -> picture.setIcon(createImageIcon("images/" + e.getActionCommand() + ".jpg"));

        catButton.addActionListener(CheckListener);
        dogButton.addActionListener(CheckListener);

        picture = new JLabel(createImageIcon("images/" + catString + ".jpg"));
        picture.setPreferredSize(new Dimension(177, 122));

        JPanel CheckPanel = new JPanel();
        JPanel SmallPanel = new JPanel();
        SmallPanel.setLayout(new BoxLayout(SmallPanel, BoxLayout.Y_AXIS));
        SmallPanel.add(catButton);
        SmallPanel.add(dogButton);
        CheckPanel.setLayout(new BorderLayout());
        JLabel text = new JLabel("Кого вы больше любите?");
        CheckPanel.add(text, BorderLayout.PAGE_START);
        CheckPanel.add(picture, BorderLayout.LINE_START);
        CheckPanel.add(SmallPanel, BorderLayout.CENTER);
        myPanel.add(CheckPanel);

        myPanel.add(myButton1);
        myPanel.add(myButton2);
        myPanel.add(myButton3);

        Font font = new Font("Verdana", Font.PLAIN, 11);
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("Файл");
        fileMenu.setFont(font);

        JMenu newSubMenu = new JMenu("Подменю");
        newSubMenu.setFont(font);
        fileMenu.add(newSubMenu);

        JMenuItem txtFileItem = new JMenuItem("Пункт 1");
        txtFileItem.setFont(font);
        newSubMenu.add(txtFileItem);

        JMenuItem imgFileItem = new JMenuItem("Пунет 2");
        imgFileItem.setFont(font);
        newSubMenu.add(imgFileItem);

        JMenuItem openItem = new JMenuItem("Открыть");
        openItem.setFont(font);
        fileMenu.add(openItem);

        fileMenu.addSeparator();

        JMenuItem exitItem = new JMenuItem("Выход");
        exitItem.setFont(font);
        fileMenu.add(exitItem);
        exitItem.addActionListener(e -> System.exit(0));

        JMenu AboutMenu = new JMenu("О программе");
        AboutMenu.addActionListener(e -> {
            JDialog dialog = new JDialog();
            JLabel aboutLabel = new JLabel("Артур Николаенко");
            dialog.add(aboutLabel);
            dialog.setVisible(true);
        });
        menuBar.add(fileMenu);
        menuBar.add(AboutMenu);

        this.setLocationRelativeTo(null);
        this.setJMenuBar(menuBar);
        this.add(myPanel);
        this.setSize(500, 300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    private Icon createImageIcon(String path) {
        java.net.URL imgURL = Main.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}
