import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MainForm {
    private JPanel mainPanel;
    private JTextField srcDateField;
    private JSpinner dateShift;
    private JButton shiftButton;
    private JLabel resultDateField;

    public MainForm() {
        shiftButton.addActionListener(
                // Обработчик событий в Java8
                actionEvent -> {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                    LocalDate srcDate = LocalDate.parse(srcDateField.getText(), formatter);

                    Integer shift = (Integer) dateShift.getValue();

                    LocalDate dstDate = srcDate.plusDays(shift);

                    String dstDateStr = formatter.format(dstDate);

                    resultDateField.setText(dstDateStr);
                }
        );
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Сдвиг даты");
        MainForm form = new MainForm();
        frame.setContentPane(form.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
