import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
public class GUI extends JFrame {
    private JPanel dates;
    private JPanel days;
    private JPanel lists;
    private JPanel textFields;
    private JPanel adds;
    private JPanel removes;
    GUI() {
      super.setTitle("Calender");
      super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      super.setResizable(false);
      super.setSize(1300, 800);

      JPanel group = new JPanel();
      group.setLayout(new BorderLayout());
      addComponents(group);

      super.add(group);
      super.setVisible(true);
  }

  //creating components and looping through them 7 times, also adding them into different JPanels
  public void addComponents(JPanel container) {
        dates = new JPanel();
        days = new JPanel();
        lists = new JPanel();
        textFields = new JPanel();
        adds = new JPanel();
        removes = new JPanel();

        JLabel[] date = new JLabel[7];
        JLabel[] day = new JLabel[7];

        for (int i = 0; i < 7; i++) {
            date[i] = new JLabel();
            day[i] = new JLabel();
            JButton add = new JButton("Add Item");
            JButton remove = new JButton("Remove item");
            JList<String> list = new JList<>();
            DefaultListModel<String> dlm = new DefaultListModel<>();
            JTextField textField = new JTextField();

            dates.add(date[i]);
            days.add(day[i]);
            lists.add(list);
            textFields.add(textField);
            adds.add(add);
            removes.add(remove);

          styleComponents(container);
          addButtonListener(textField, list, add, remove,dlm);
      }
        getDate(date);
        dayOfWeek(day);
    }
  //styleComponents is used for styling and creating layouts to get the "calendar" look, with BorderLayout and GridLayout
  public void styleComponents (JPanel container) {
        //container North
        JPanel containerNorth = new JPanel();
        dates.setLayout(new GridLayout(1, 7));
        containerNorth.setLayout(new BorderLayout());
        days.setLayout(new GridLayout(1, 7));
        containerNorth.add(dates, BorderLayout.NORTH);
        containerNorth.add(days, BorderLayout.CENTER);

        //container Center
        JPanel containerCenter = new JPanel();
        lists.setLayout(new GridLayout(1, 7));
        containerCenter.setLayout(new BorderLayout());
        containerCenter.add(lists, BorderLayout.CENTER);

        //container South
        textFields.setLayout(new GridLayout(1, 7));
        adds.setLayout(new GridLayout(1, 7));
        removes.setLayout(new GridLayout(1, 7));
        JPanel containerSouth = new JPanel();
        containerSouth.setLayout(new BorderLayout());
        containerSouth.add(textFields, BorderLayout.NORTH);
        containerSouth.add(adds, BorderLayout.CENTER);
        containerSouth.add(removes, BorderLayout.SOUTH);

        //add containers to the main displayed container
        container.add(containerNorth, BorderLayout.NORTH);
        container.add(containerCenter, BorderLayout.CENTER);
        container.add(containerSouth, BorderLayout.SOUTH);
    }

    //Get the date week wise for 7 different labels. Also printing out "today" together with the current date.
    public void getDate(JLabel [] date) {
        date[0].setText(GetDate.getDate(1));
        date[1].setText(GetDate.getDate(2));
        date[2].setText(GetDate.getDate(3));
        date[3].setText(GetDate.getDate(4));
        date[4].setText(GetDate.getDate(5));
        date[5].setText(GetDate.getDate(6));
        date[6].setText(GetDate.getDate(7));
    }

  //looping through every day in a week.
  public void dayOfWeek (JLabel [] day) {
        String [] dayOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        for (int i = 0; i < dayOfWeek.length; i++) {
            day[i].setText(dayOfWeek[i]);
        }
    }

  //connects add button and remove button to list. Makes it possible to add text to the list, also to remove by id in list.
  public void addButtonListener(JTextField textField, JList<String> list, JButton buttonAdd, JButton buttonRemove, DefaultListModel<String> dlm) {
        ActionListener bListener = e -> {
            if (e.getSource() == buttonAdd) {
                dlm.addElement(textField.getText());
                list.setModel(dlm);
            }else if(e.getSource() == buttonRemove) {
                int[] arr = list.getSelectedIndices();
                for (int j : arr) {
                dlm.remove(j);
                }
            }
        };
        buttonAdd.addActionListener(bListener);
        buttonRemove.addActionListener(bListener);
    }
}


