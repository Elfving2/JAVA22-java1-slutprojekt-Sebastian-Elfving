import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class GUI extends JFrame {
  GUI() {
    this.setTitle("Calender");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setResizable(false);
    this.setSize(1300, 800);
    JPanel group = new JPanel();
    group.setLayout(new BorderLayout());
    addComponents(group);

    this.add(group);
    this.setVisible(true);
  }

  public void addComponents(JPanel container) {

    JLabel [] date;
    JLabel [] day;
    JList list;
    JTextField textField;
    JButton add;
    JButton remove;
    DefaultListModel dlm;


    JPanel dates = new JPanel();
    JPanel days = new JPanel();
    JPanel lists = new JPanel();
    JPanel textFields = new JPanel();
    JPanel adds = new JPanel();
    JPanel removes = new JPanel();


    JPanel containerNorth = new JPanel();
    JPanel containerCenter = new JPanel();
    JPanel containerSouth = new JPanel();

    date = new JLabel[7];
    day = new JLabel[7];
    for (int i = 0; i < 7; i++) {
      date[i] = new JLabel();
      day[i] = new JLabel();
      list = new JList();
      dlm = new DefaultListModel();
      textField = new JTextField("add item");
      add = new JButton("Add Item");
      remove = new JButton("Remove item");

      addButtonListener(textField,list,add,remove,dlm);


      dates.setLayout(new GridLayout(1, 7));
      dates.add(date[i]);
      containerNorth.setLayout(new BorderLayout());
      days.setLayout(new GridLayout(1, 7));
      days.add(day[i]);

      containerNorth.add(dates, BorderLayout.NORTH);
      containerNorth.add(days, BorderLayout.CENTER);
      container.add(containerNorth, BorderLayout.NORTH);

      lists.setLayout(new GridLayout(1, 7));
      lists.add(list);
      containerCenter.setLayout(new BorderLayout());
      containerCenter.add(lists, BorderLayout.CENTER);
      container.add(containerCenter);

      textFields.setLayout(new GridLayout(1, 7));
      textFields.add(textField);
      adds.setLayout(new GridLayout(1, 7));
      adds.add(add);
      removes.setLayout(new GridLayout(1, 7));
      removes.add(remove);

      containerSouth.setLayout(new BorderLayout());
      containerSouth.add(textFields, BorderLayout.NORTH);
      containerSouth.add(adds, BorderLayout.CENTER);
      containerSouth.add(removes, BorderLayout.SOUTH);

      container.add(containerSouth, BorderLayout.SOUTH);

    }
    date[0].setText(GetDate.getDate(1,"today"));
    date[1].setText(GetDate.getDate(2,"today"));
    date[2].setText(GetDate.getDate(3,"today"));
    date[3].setText(GetDate.getDate(4,"today"));
    date[4].setText(GetDate.getDate(5,"today"));
    date[5].setText(GetDate.getDate(6,"today"));
    date[6].setText(GetDate.getDate(7,"today"));

    day[0].setText("Monday");
    day[1].setText("Tuesday");
    day[2].setText("Wednesday");
    day[3].setText("Thursday");
    day[4].setText("Friday");
    day[5].setText("Saturday");
    day[6].setText("Sunday");

  }

  public void addButtonListener(JTextField tf, JList l,JButton b, JButton bRemove, DefaultListModel d) {
    ActionListener bListener = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b) {
          d.addElement(tf.getText());
          l.setModel(d);
        } else if(e.getSource() == bRemove) {
          int[] arr = l.getSelectedIndices();
          for (int j : arr) {
            d.remove(j);
          }
        }
      }
    };
    b.addActionListener(bListener);
    bRemove.addActionListener(bListener);
  }
}


