package ru.mirea.lab_16.Model.Interfaces;

import ru.mirea.lab_16.Model.Customer;
import ru.mirea.lab_16.Model.MenuItem;

// ОН ГОТОВ НЕ ТРОГАТЬ
public interface IOrder {

    boolean add(MenuItem item);

    String[] itemsNames();

    int itemsQuantity();

    int itemQuantity(String itemName);

    int itemQuantity(MenuItem item);

    MenuItem[] getItems();

    boolean remove(String itemName);

    boolean remove(MenuItem item);

    int removeAll(String itemName);

    int removeAll(MenuItem item);

    MenuItem[] sortedItemsByCostDescending();

    int costTotal();

    Customer getCustomer();

    void setCustomer(Customer customer);
}
