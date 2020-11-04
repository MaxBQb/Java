package pr_16;

//интерфейс Order – позиции заказа

public interface IOrder {
    boolean add(IItem item);

    boolean remove(String itemName);

    int itemQuantityDelete(String itemName);

    int itemQuantity(); //возвращает общее число позиций заказа

    double costTotal(); //−возвращает общую стоимость заказа.

    IItem[] getItems();//−возвращает массив названий заказанных блюд и напитков.

    IItem[] sortedItemsByCostDescending(); //−возвращает массив позиций заказа, отсортированный по убыванию цены.
}
