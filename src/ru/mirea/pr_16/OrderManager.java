package ru.mirea.pr_16;

import java.util.HashMap;

public class OrderManager {


    private java.util.HashMap<Integer, IOrder> tablesOrders = new HashMap<>();

    private java.util.HashMap<String, IOrder> addressesOrders = new HashMap<>();

    OrderManager() {

    }

    public void add(int tableNumber, IOrder order) throws OrderAlreadyAddedException {
        if (tablesOrders.containsKey(tableNumber))
            throw new OrderAlreadyAddedException("Для этого столика уже есть заказ!");
        tablesOrders.put(tableNumber, order);
    }

    public void add(String address, IOrder order) throws OrderAlreadyAddedException {
        if (addressesOrders.containsKey(address))
            throw new OrderAlreadyAddedException("Для этого адреса уже есть заказ!");
        addressesOrders.put(address, order);
    }

    public IOrder getOrder(int tableNumber) throws IllegalTableNumber {
        if (tablesOrders.containsKey(tableNumber) == false)
            throw new IllegalTableNumber("Столика с таким номером нет!");
        return tablesOrders.get(tableNumber);
    }

    public IOrder getOrder(String address) throws IllegalTableNumber {
        if (addressesOrders.containsKey(address) == false)
            throw new IllegalTableNumber("Такого адреса нет!");
        return addressesOrders.get(address);
    }

    public void addItem(int tableNumber, IItem item) throws IllegalTableNumber {
        if (tablesOrders.containsKey(tableNumber) == false)
            throw new IllegalTableNumber("Столика с таким номером нет!");
        tablesOrders.get(tableNumber).add(item);
    }

    public void addItem(String address, IItem item) throws IllegalTableNumber {
        if (addressesOrders.containsKey(address) == false)
            throw new IllegalTableNumber("Такого адреса нет!");
        addressesOrders.get(address).add(item);
    }

    public void removeOrder(int tableNumber) throws IllegalTableNumber{
        if (tablesOrders.containsKey(tableNumber) == false)
            throw new IllegalTableNumber("Столика с таким номером нет!");
        tablesOrders.remove(tableNumber);
    }

    public void removeOrder(String address) throws IllegalTableNumber {
        if (addressesOrders.containsKey(address) == false)
            throw new IllegalTableNumber("Такого адреса нет!");
        addressesOrders.remove(address);
    }

    public int freeTableNumber() {
        int number = tablesOrders.keySet().toArray().length - 1;
        IOrder a = tablesOrders.get(number);
        if (number > 0){
            tablesOrders.remove(number);
            return number;
        }
        return -1;
    }

    public int[] freeTableNumbers() {
        if (tablesOrders.size() == 0)
            return null;
        int[] numbers = new int[tablesOrders.size()];
        for (int i = 0; i < tablesOrders.size(); i++) {
            numbers[i] = (int) (tablesOrders.keySet().toArray()[i]);
        }
        tablesOrders.clear();
        return numbers;
    }

    public IOrder[] getOrders() { //возвращающий массив имеющихся на данный момент интернет-заказов.
        int size = tablesOrders.size() + addressesOrders.size();
        IOrder[] array = new IOrder[size];
        int count = 0;

        for (String i : (String[])addressesOrders.keySet().toArray()) {
            array[count] = addressesOrders.get(i);
            count++;
        }

        for (Integer i : (Integer[])tablesOrders.keySet().toArray()) {
            array[count] = tablesOrders.get(i);
            count++;
        }

        return array;
    }

    public double tablesOrdersCostSummary() {
        double cost = 0;
        for (Integer i : tablesOrders.keySet()) {
            cost += tablesOrders.get(i).costTotal();
        }
        return cost;
    }

    public double internetOrdersCostSummary() {
        double cost = 0;
        for (String i : addressesOrders.keySet()) {
            cost += addressesOrders.get(i).costTotal();
        }
        return cost;
    }

    public int getItemsQuantity(String name) {
        int count = 0;
        for (String i : (String[])addressesOrders.keySet().toArray()) {
           for (IItem j : addressesOrders.get(i).getItems()){
               if (j.getName().equals(name))
                   count++;
           }
        }

        for (Integer i : (Integer[])tablesOrders.keySet().toArray()) {
            for (IItem j : tablesOrders.get(i).getItems()){
                if (j.getName().equals(name))
                    count++;
            }
        }

        return count;
    }

    @Override
    public String toString() {
        StringBuilder tablesOrdersList = new StringBuilder();
        StringBuilder addressesOrdersList = new StringBuilder();
        for (var key : tablesOrders.keySet()) {
            tablesOrdersList.append("[" + key + "]  \t");
            tablesOrdersList.append(tablesOrders.get(key) + "\n");
        }
        for (var key : addressesOrders.keySet()) {
            addressesOrdersList.append("[" + key + "]  \t");
            addressesOrdersList.append(addressesOrders.get(key) + "\n");
        }
        return "Менеджер заказов\n{\n" +
                "Заказы со столиков:\n" + tablesOrdersList +
                "\nИнтернет-заказы: \n" + addressesOrdersList +
                "\n}\n";
    }
}
/*
Переименуйте класс TablesOrderManager в OrderManager.
Добавьте ему еще одно поле типа java.util.HasMap<String, Order>, которое содержит пары адрес-заказ, и методы (работающие с этим полем):
Методы класса:
//   −перегрузка метода добавления заказа. В качестве параметров принимает строку – адрес и ссылку на заказ.
//   −перегрузка метода получения заказа. В качестве параметра принимает строку – адрес.
//   −перегрузка метода удаления заказа. В качестве параметра принимает строку – адрес заказа.
//   −перегрузка метода добавления позиции к заказу. В качестве параметра принимает адрес и Item.
// возвращающий массив имеющихся на данный момент интернет-заказов.
// возвращающий суммарную сумму имеющихся на данный момент интернет-заказов.
//   возвращающий общее среди всех интернет-заказов количество заказанных порций заданного блюда по его имени. Принимает имя блюда в качестве параметра.
Методы должны работать с интерфейсными ссылками Order и Item.
*/