
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SupermarketBillingSystem extends JFrame {

    JTextField txtBillNo, txtDate, txtProductId, txtTotal;

    JCheckBox chkMilk, chkBread, chkRice, chkOil;

    JButton btnGenerate, btnReset, btnExit;

    public SupermarketBillingSystem() {

        setTitle("Supermarket Billing System");
        setSize(650, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(245, 245, 245));

        // Heading
        JLabel heading = new JLabel("Supermarket Billing System");
        heading.setFont(new Font("Serif", Font.BOLD, 28));
        heading.setBounds(130, 25, 430, 40);
        panel.add(heading);

        // Bill Number
        JLabel lblBillNo = new JLabel("Bill No. :");
        lblBillNo.setBounds(70, 100, 120, 30);
        panel.add(lblBillNo);

        txtBillNo = new JTextField();
        txtBillNo.setBounds(200, 100, 150, 30);
        panel.add(txtBillNo);

        // Date
        JLabel lblDate = new JLabel("Date :");
        lblDate.setBounds(380, 100, 80, 30);
        panel.add(lblDate);

        txtDate = new JTextField(
            LocalDate.now().format(
                DateTimeFormatter.ofPattern("dd-MM-yyyy")
            )
        );
        txtDate.setEditable(false);
        txtDate.setBounds(450, 100, 150, 30);
        panel.add(txtDate);

        // Product ID
        JLabel lblProductId = new JLabel("Product ID :");
        lblProductId.setBounds(70, 155, 120, 30);
        panel.add(lblProductId);

        txtProductId = new JTextField();
        txtProductId.setBounds(200, 155, 150, 30);
        panel.add(txtProductId);

        // Select Item
        JLabel lblSelect = new JLabel("Select Item :");
        lblSelect.setBounds(70, 220, 130, 30);
        panel.add(lblSelect);

        // Checkboxes
        chkMilk = new JCheckBox("Milk (Rs. 30)");
        chkMilk.setBounds(200, 220, 200, 30);
        panel.add(chkMilk);

        chkBread = new JCheckBox("Bread (Rs. 40)");
        chkBread.setBounds(200, 260, 200, 30);
        panel.add(chkBread);

        chkRice = new JCheckBox("Rice (Rs. 60)");
        chkRice.setBounds(200, 300, 200, 30);
        panel.add(chkRice);

        chkOil = new JCheckBox("Oil (Rs. 150)");
        chkOil.setBounds(200, 340, 200, 30);
        panel.add(chkOil);

        // Total Amount
        JLabel lblTotal = new JLabel("Total Amount :");
        lblTotal.setBounds(70, 390, 130, 30);
        panel.add(lblTotal);

        txtTotal = new JTextField();
        txtTotal.setBounds(200, 390, 150, 30);
        txtTotal.setEditable(false);
        panel.add(txtTotal);

        // Generate Bill Button
        btnGenerate = new JButton("Generate Bill");
        btnGenerate.setBounds(50, 455, 160, 35);
        panel.add(btnGenerate);

        // Reset Button
        btnReset = new JButton("Reset");
        btnReset.setBounds(250, 455, 120, 35);
        panel.add(btnReset);

        // Exit Button
        btnExit = new JButton("Exit");
        btnExit.setBounds(430, 455, 120, 35);
        panel.add(btnExit);

        // Generate Bill Action
        btnGenerate.addActionListener(e -> generateBill());

        // Reset Action
        btnReset.addActionListener(e -> resetForm());

        // Exit Action
        btnExit.addActionListener(e -> {
            System.exit(0);
        });

        add(panel);
        setVisible(true);
    }

    // Generate Bill Method
    private void generateBill() {

        double total = 0;
        String result = "";

        if (chkMilk.isSelected()) {
            total = total + 30;
            result = result + "Milk ";
        }

        if (chkBread.isSelected()) {
            total = total + 40;
            result = result + "Bread ";
        }

        if (chkRice.isSelected()) {
            total = total + 60;
            result = result + "Rice ";
        }

        if (chkOil.isSelected()) {
            total = total + 150;
            result = result + "Oil ";
        }

        if (result.equals("")) {
            JOptionPane.showMessageDialog(
                this, "Please select an item"
            );
            return;
        }

        if (txtBillNo.getText().trim().isEmpty()
                || txtProductId.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(
                this, "Please enter Bill No. and Product ID"
            );
            return;
        }

        txtTotal.setText(String.valueOf(total));

        JOptionPane.showMessageDialog(
            this,
            "SUPERMARKET BILL\n\n"
            + "Bill No: " + txtBillNo.getText()
            + "\nDate: " + txtDate.getText()
            + "\nProduct ID: " + txtProductId.getText()
            + "\nSelected Items: " + result
            + "\nTotal Amount: Rs. " + total
        );
    }

    // Reset Method
    private void resetForm() {

        chkMilk.setSelected(false);
        chkBread.setSelected(false);
        chkRice.setSelected(false);
        chkOil.setSelected(false);

        txtBillNo.setText("");
        txtProductId.setText("");
        txtTotal.setText("");

        txtDate.setText(
            LocalDate.now().format(
                DateTimeFormatter.ofPattern("dd-MM-yyyy")
            )
        );
    }

    // Main Method
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new SupermarketBillingSystem();
        });
    }
}
