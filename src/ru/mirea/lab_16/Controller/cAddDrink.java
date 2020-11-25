package ru.mirea.lab_16.Controller;
import ru.mirea.lab_16.Model.Drink;
import ru.mirea.lab_16.Model.ItemsRepository;
import ru.mirea.lab_16.View.AddDrink;
import ru.mirea.lab_16.Model.Interfaces.IOrder;

import javax.swing.*;

public class cAddDrink {
    public cAddDrink(AddDrink view, IOrder order, cOrderPanel order_panel) {
        for (int i = 0; i < ItemsRepository.drinksLength(); i++)
            view.chbx_drinks.addItem((ItemsRepository.getDrink(i)).toString());

        view.lbl_age_restriction.setVisible(false);

        view.btn_submit.addActionListener(e -> {
            if (order_panel.isClosed()) {
                JOptionPane.showMessageDialog(view,
                        "Заказ уже закрыт!",
                        "Ошибка!",
                        JOptionPane.WARNING_MESSAGE
                );
                view.dispose();
                return;
            }

            view.lbl_age_restriction.setVisible(false);
            Drink new_drink = ItemsRepository.getDrink(view.chbx_drinks.getSelectedIndex());
            if (new_drink.isAlcoholicDrink() && order.getCustomer().getAge() < 18) {
                view.lbl_age_restriction.setVisible(true);
                return;
            }

            order.add(new_drink);
            if (order_panel != null)
                order_panel.updateOrderList();
            view.dispose();
        });
    }
}
