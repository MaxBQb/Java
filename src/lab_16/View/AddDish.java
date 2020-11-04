package lab_16.View;

import lab_16.Model.Customer;
import lab_16.Model.InternetOrder;
import lab_16.Controller.cAddDish;
import lab_16.Controller.cOrderPanel;
import lab_16.Model.Interfaces.IOrder;

import javax.swing.*;
import java.awt.*;

public class AddDish extends JFrame {
    public JComboBox chbx_dishes = new JComboBox();
    public JButton btn_submit = new JButton("Ок");
    JPanel pnl_subgrid = new JPanel(new GridLayout(1,2));
    public cAddDish controller;

    public AddDish(IOrder order, cOrderPanel order_panel) {
        super("Выбор блюда");
        setLayout(new GridLayout(2, 1));
        setSize(1400,200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        add(chbx_dishes);
        pnl_subgrid.add(new JLabel()); // Skip cell
        pnl_subgrid.add(btn_submit);
        add(pnl_subgrid);

        setLocationRelativeTo(null); // отцентрировать окно
        controller = new cAddDish(this, order, order_panel); // Связь View-Controller
        setVisible(true);
    }

    public AddDish() {
        this(new InternetOrder(Customer.MATURE_UNKNOWN_CUSTOMER), null);
    }
}
