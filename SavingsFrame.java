package P20_3;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SavingsFrame extends JFrame
{
    // Declarations
    private JTextField savingsField;
    private JTextField interestField;
    private JTextField yearsField;
    private JButton button;
    private JLabel resultLabel;
    private JLabel savingsLabel;
    private JLabel interestLabel;
    private JLabel yearsLabel;
    private double balance;

    // Constructor
    public SavingsFrame()
    {
        resultLabel = new JLabel("Balance: " + balance);

        createSavingsField();
        createInterestField();
        createYearsField();
        createButton();
        createPanel();

        setSize(720,150);
    }

    // Creates savings text field
    private void createSavingsField()
    {
        savingsLabel = new JLabel("Initial Savings: ");

        savingsField = new JTextField(10);
        savingsField.setText(""+ 0);
    }

    // Creates interest text field
    private void createInterestField()
    {
        interestLabel = new JLabel("Interest Rate: ");

        interestField = new JTextField(10);
        interestField.setText(""+0);
    }

    // Creates years text field
    private void createYearsField()
    {
        yearsLabel = new JLabel("Number of Years: ");

        yearsField = new JTextField(10);
        yearsField.setText(""+0);
    }

    // Listener for when calculate button is clicked
    class AddInterestListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            double savings = Double.parseDouble(savingsField.getText());
            double interestRate = Double.parseDouble(interestField.getText())/100;
            double years = Double.parseDouble(yearsField.getText());

            for(int i=0; i<years; i++)
            {
                savings += (interestRate*savings);
            }

            resultLabel.setText("Savings Balance: " + savings);
        }
    }

    // Creates and adds listener to button
    private void createButton()
    {
        button = new JButton("Calculate");

        ActionListener listener = new AddInterestListener();
        button.addActionListener(listener);
    }

    // Creates panel and adds it to the frame
    private void createPanel()
    {
        JPanel panel = new JPanel();
        panel.add(savingsLabel);
        panel.add(savingsField);
        panel.add(interestLabel);
        panel.add(interestField);
        panel.add(yearsLabel);
        panel.add(yearsField);
        panel.add(button);
        panel.add(resultLabel);
        add(panel);
    }

}
