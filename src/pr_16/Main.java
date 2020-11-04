package pr_16;

import java.util.Random;

public class Main {
    private static String[] drinksDescriptions = new String[]{
            "Тонизирует",
            "Освежает",
            "Свежий",
            "В кружке 0.5 л",
            "Охлажденный",
            "Вкусный",
            "Классический",
            "С шоколадкой в придачу",
            "Очень вкусный"
    };

    private static String[] drinks = new String[]{
            "Beer",
            "Wine",
            "Vodka",
            "Brandy",
            "Champagne",
            "Whiskey",
            "Tequila",
            "Rum",
            "Vermuth",
            "Liquor",
            "Jagermeister",
            "Juice",
            "Coffee",
            "Green_tea",
            "Black_tea",
            "Milk",
            "Water",
            "Soda"
    };

    private static String[] dishes = new String[]{
            "Авголемоно",
            "Агуапанела",
            "Аджика",
            "Адобо",
            "Азу",
            "Айвар",
            "Айвовый мармелад",
            "Аль пастор",
            "Аманатто",
            "Аматричана",
            "Афганское печенье",
            "Баклажанная икра",
            "Банановый торт",
            "Баурсак",
            "Безе",
            "Бефстроганов",
            "Блины",
            "Брауни",
            "Бублик",
            "Буррито",
            "Бутерброд",
            "Бэлиш",
            "Вареники",
            "Ватрушка",
            "Гамбургский стейк",
            "Голубцы",
            "Гренки",
            "Греческий салат",
            "Гречневая каша",
            "Гречневый суп",
            "Гуляш",
            "Борщ",
            "Щи",
            "Плов",
            "Лазанья",
            "Пицца",
            "Винегрет",
            "Оливье",
            "Вареники",
            "Дынная булочка",
    };

    private static String[] dishesDescription = new String[]{
            "ароматный",
            "хрустящий",
            "приготовленный на гриле",
            "свежеиспечённый",
            "разрезанный",
            "тушёный",
            "воздушный",
            "тёплый",
            "тягучий",
            "согревающий",
            "рассыпчатый",
            "бархатный",
            "сладкий",
            "медиум-прожарка",
            "особенный",
            "пикантный",
            "рыхлый",
            "медленного приготовления",
            "слоенный",
            "приправленный",
            "подрумяненный",
            "копченый",
            "фламбированный",
            "сезонный",
            "на противне",
            "лимонный"
    };

    public static void main(String[] args) throws IllegalTableNumber, OrderAlreadyAddedException {
        OrderManager orderManager = new OrderManager();

        Random random = new Random();
        for (int i = 0; i < random.nextInt(50) + 10; i++) {
            IOrder order = new RestaurantOrder();
            for (int j = 0; j < random.nextInt(3) + 1; j++) {
                IItem item = random.nextBoolean() ?

                        new Dish(random.nextInt(1000), dishes[random.nextInt(dishes.length)],
                                dishesDescription[random.nextInt(dishesDescription.length)]) :

                        new Drink(random.nextInt(1000), drinks[random.nextInt(drinks.length)],
                                drinksDescriptions[random.nextInt(drinksDescriptions.length)]);
                order.add(item);
            }

            orderManager.add(i, order);
        }

        for (int i = 0; i < random.nextInt(50) + 10; i++) {
            IOrder order = new InternetOrder();
            for (int j = 0; j < random.nextInt(3) + 1; j++) {
                IItem item = random.nextBoolean() ?
                        new Dish(random.nextInt(1000), dishes[random.nextInt(dishes.length)],
                                dishesDescription[random.nextInt(dishesDescription.length)]) :
                        new Drink(random.nextInt(1000), drinks[random.nextInt(drinks.length)],
                                drinksDescriptions[random.nextInt(drinksDescriptions.length)]);
                order.add(item);
            }
            orderManager.add(Character.toString(65 + i), order);
        }

        //Integer.toString new String(new StringBuilder((char) (i + 66)))
        System.out.println(orderManager);

    }
}
