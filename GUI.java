import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI extends JFrame {
  private JPanel panelNorth = new JPanel();
  private JPanel containerNorth = new JPanel();

  private JPanel panelCenter = new JPanel();
  private JPanel containerCenter = new JPanel();

  private JPanel panelSouth = new JPanel();
  private JPanel containerSouth = new JPanel();
  private JLabel[] label;
  private JList[] list;
  private JTextField[] textField;

  DefaultListModel dlmMonday;
  DefaultListModel dlmTuesday;
  DefaultListModel dlmWednesday;
  DefaultListModel dlmThursday;
  DefaultListModel dlmFriday;
  DefaultListModel dlmSaturday;
  DefaultListModel dlmSunday;


  GUI() {
    this.setTitle("Calender");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setResizable(false);
    this.setSize(1300, 800);

    panelNorth.setLayout(new BorderLayout());
    containerNorth.setLayout(new GridLayout(2, 7));
    panelNorth.add(containerNorth);

    panelCenter.setLayout(new BorderLayout());
    containerCenter.setLayout(new GridLayout(0, 7));
    panelCenter.add(containerCenter);

    panelSouth.setLayout(new BorderLayout());
    containerSouth.setLayout(new GridLayout(3, 7));
    panelSouth.add(containerSouth);

    //Creating 14 labels
    label = new JLabel[14];
    for (int i = 0; i < 14; i++) {
      label[i] = new JLabel("hello " + i);
      containerNorth.add(label[i]);
      System.out.println(label[i]);
    }

    //creating 7 lists
    list = new JList[7];
    for (int i = 0; i < list.length; i++) {
      list[i] = new JList();
      containerCenter.add(list[i]);
      System.out.println(list[i]);
    }
    //create a dlm for every list we create.
    dlmMonday = new DefaultListModel();
    dlmTuesday = new DefaultListModel();
    dlmWednesday = new DefaultListModel();
    dlmThursday = new DefaultListModel();
    dlmFriday = new DefaultListModel();
    dlmSaturday = new DefaultListModel();
    dlmSunday = new DefaultListModel();

    //creating 7 textFields
    textField = new JTextField[7];
    for (int i = 0; i < 7; i++) {
      textField[i] = new JTextField();
      //textField[i].setText("hello");
      containerSouth.add(textField[i]);
      System.out.println(textField[i]);
    }

    //creating 7 buttons
    JButton[] button = new JButton[14];
    for (int i = 0; i < button.length; i++) {
      button[i] = new JButton("add");
      containerSouth.add(button[i]);
      System.out.println(button[i]);
    }

    //calling static method from getDate
    label[0].setText(GetDate.getDate(1, "today: "));
    label[1].setText(GetDate.getDate(2, "today: "));
    label[2].setText(GetDate.getDate(3, "today: "));
    label[3].setText(GetDate.getDate(4, "today: "));
    label[4].setText(GetDate.getDate(5, "today: "));
    label[5].setText(GetDate.getDate(6, "today: "));
    label[6].setText(GetDate.getDate(7, "today: "));

    //adding calendar days
    label[7].setText("Monday");
    label[8].setText("Tuesday");
    label[9].setText("Wednesday");
    label[10].setText("Thursday");
    label[11].setText("Friday");
    label[12].setText("Saturday");
    label[13].setText("Sunday");

    ActionListener btnAddText = new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button[0]) {
          dlmMonday.addElement(textField[0].getText());
          list[0].setModel(dlmMonday);
        } else if (e.getSource() == button[1]) {
          dlmTuesday.addElement(textField[1].getText());
          list[1].setModel(dlmTuesday);
        } else if (e.getSource() == button[2]) {
          dlmWednesday.addElement(textField[2].getText());
          list[2].setModel(dlmWednesday);
        } else if (e.getSource() == button[3]) {
          dlmThursday.addElement(textField[3].getText());
          list[3].setModel(dlmThursday);
        } else if (e.getSource() == button[4]) {
          dlmFriday.addElement(textField[4].getText());
          list[4].setModel(dlmFriday);
        } else if (e.getSource() == button[5]) {
          dlmSaturday.addElement(textField[5].getText());
          list[5].setModel(dlmSaturday);
        } else if (e.getSource() == button[6]) {
          dlmSunday.addElement(textField[6].getText());
          list[6].setModel(dlmSunday);
        }
      }
    };

    ActionListener btnDeleteText = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button[7]) {
          int[] arr = list[0].getSelectedIndices();
          for (int i = 0; i < arr.length; i++) {
            dlmMonday.remove(arr[i]);
          }
        } else if (e.getSource() == button[8]) {
          int[] arr = list[1].getSelectedIndices();
          for (int i = 0; i < arr.length; i++) {
            dlmTuesday.remove(arr[i]);
          }
        } else if (e.getSource() == button[9]) {
          int[] arr = list[2].getSelectedIndices();
          for (int i = 0; i < arr.length; i++) {
            dlmWednesday.remove(arr[i]);
          }
        } else if (e.getSource() == button[10]) {
          int[] arr = list[3].getSelectedIndices();
          for (int i = 0; i < arr.length; i++) {
            dlmThursday.remove(arr[i]);
          }
        } else if (e.getSource() == button[11]) {
          int[] arr = list[4].getSelectedIndices();
          for (int i = 0; i < arr.length; i++) {
            dlmFriday.remove(arr[i]);
          }
        } else if (e.getSource() == button[12]) {
          int[] arr = list[5].getSelectedIndices();
          for (int i = 0; i < arr.length; i++) {
            dlmSaturday.remove(arr[i]);
          }
        } else if (e.getSource() == button[13]) {
          int[] arr = list[6].getSelectedIndices();
          for (int i = 0; i < arr.length; i++) {
            dlmSunday.remove(arr[i]);
          }
        }
      }
    };

    //add text to list
    button[0].addActionListener(btnAddText);
    button[1].addActionListener(btnAddText);
    button[2].addActionListener(btnAddText);
    button[3].addActionListener(btnAddText);
    button[4].addActionListener(btnAddText);
    button[5].addActionListener(btnAddText);
    button[6].addActionListener(btnAddText);

    //remove text from list by index
    button[7].addActionListener(btnDeleteText);
    button[8].addActionListener(btnDeleteText);
    button[9].addActionListener(btnDeleteText);
    button[10].addActionListener(btnDeleteText);
    button[11].addActionListener(btnDeleteText);
    button[12].addActionListener(btnDeleteText);
    button[13].addActionListener(btnDeleteText);




    //add to GUI and set GUI visible
    this.add(panelNorth, BorderLayout.NORTH);
    this.add(panelCenter, BorderLayout.CENTER);
    this.add(panelSouth, BorderLayout.SOUTH);
    this.setVisible(true);
  }
}

