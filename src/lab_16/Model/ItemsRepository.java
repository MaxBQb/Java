package lab_16.Model;

public final class ItemsRepository {
    private static Dish[] dishes = new Dish[] {
            new Dish(220, "Афганское печенье", "Воздушное печенье из безе. "),
            new Dish(110, "Баклажанная икра", "Овощная икра, приготавливаемая из баклажанов. Считается не только вкусной, но и полезной. "),
            new Dish(2800, "Банановый торт", "Шоколадный мусс с добавлением цедры лимона и тонким вкусом имбиря с начинкой из фламбированного банана. "),
            new Dish(294, "Баурсак", "Это национальное татарское блюдо. Едят его вместо хлеба или в качестве десерта. "),
            new Dish(181, "Блины с ветчиной и сыром", "Очень вкусные блины с отборной ветчиной и сыром пармезан. "),
            new Dish(29, "Бублик", "Булочка с дырочкой из пшеничной хлебопекарной муки высшего сорта. "),
            new Dish(390, "Буррито", "Тортилья, говядина, обжаренная с овощами и сальсой Пиканта, рис, лист салата, сыр, сметанная сальса. "),
            new Dish(129, "Бутерброд с грудкой", "Хлеб тостовый, салат айсберг, грудинка, сыр. "),
            new Dish(1500, "Зур бэлиш", "Это национальный татарский мясной пирог с бульоном. "),
            new Dish(450, "Пельмени", "Это русское блюдо с говяжьем мясом. 15 штук. "),
            new Dish(44.9, "Ватрушка", "После одного укуса ловишь флэшбеки. "),
            new Dish(349, "Голубцы", "Это старинное блюдо, которое представляет собой мясной фарш, сделанный из самых различных видов мяса и птицы, завернутый в листья капусты. "),
            new Dish(324, "Гренки", "Отличная закуска к пиву. Обжаренный хлеб с чесноком. "),
            new Dish(422, "Салат Цезарь", "Салат айсберг, филе куриное, томаты черри, сыр пармезан и всеми любимые сухарики. "),
            new Dish(250, "Борщ", "Густой овощной суп с говяжьем мясом, главный ингредиент которого – свекла. "),
            new Dish(210, "Щи", "Суп со свежей или квашеной капустой, а так же с говяжьем мясом. "),
            new Dish(540, "Плов", "Вкусное блюдо, состоящее из риса и говяжьего мяса. "),
            new Dish(825, "Лазанья", "Итальянское блюдо, представляющее собой пласты теста, переложенные различной мясной начинкой. "),
            new Dish(620, "Пицца пепперони", "Пышное тесто, с острыми колбасками - пепперони. "),
            new Dish(398, "Винегрет", "Популярная холодная закуска из овощей, приправленная по вкусу майонезом, подсолнечным маслом или соусом. "),
            new Dish(415, "Оливье", "Это блюдо знают все. Если вы его никогда не пробовали это большая ошибка."),
            new Dish(117, "Дынная булочка", "Один из видов сладких булочек в Японии")
    };

    private static Drink[] drinks = new Drink[] {
            new Drink(794, "Пиво - Белый тигр", "Алкогольный напиток на основе хмеля. ", 38.0, DrinkTypeEnum.Beer),
            new Drink(2791, "Вино - Terra Rossa ", "Алкогольный напиток получаемый полным или частичным спиртовым брожением виноградного сока. ", 135.0, DrinkTypeEnum.Wine),
            new Drink(999.99, "Водка - Медведь", "Алкогольный напиток который обладает уникальным, ровным мягким вкусом с очень легкой, почти не заметной сладостью. ", 430.0, DrinkTypeEnum.Vodka),
            new Drink(2044, "Бренди - Torres 10", "Алкогольный напиток. Выразительные ноты выдержанных ароматных мускатных вин с Эгейских островов создают уникальный, цветочный характер. ", 250.0, DrinkTypeEnum.Brandy),
            new Drink(1200, "Шампанское - Невская Жемчужина", "Алкогольный напиток. Изготовлен по традиционной технологии из специальных сортов винограда, выращенного на юге России. ", 105.0, DrinkTypeEnum.Champagne),
            new Drink(2500, "Виски - Бэллс Ориджинал", "Алкогольный напиток. Этот уникальный виски представляет собой смесь 35 сортов зерновых и солодовых спиртов. ", 460.0, DrinkTypeEnum.Whiskey),
            new Drink(4507, "Текила - Don Julio Blanco", "Алкогольный напиток. Премиальная молодая текила с освежающим ароматом цитрусовых и голубой агавы. ", 380.0, DrinkTypeEnum.Tequila),
            new Drink(3817, "Ром - Botucal", "Этот ром обладает богатым и насыщенным вкусом с тонами шоколадного соуса, карамели и спелых тропических фруктов. ", 430.0, DrinkTypeEnum.Rum),
            new Drink(940, "Вермут - Мартини Бьянко ", "Гармоничное сочетание между ванилью и ароматными травами приводит к изысканному переплетению горьких и сладких ноток. ", 180.0, DrinkTypeEnum.Vermuth),
            new Drink(4275, "Ликер - XUXU", "Обладает плотной кремовой текстурой, имеет сладковатый привкус клубники и нотки лайма. ", 400.0, DrinkTypeEnum.Liquor),
            new Drink(1000, "Ягермайстер - Ликер десертный", "В состав напитка входят 56 трав, корнеплодов, фруктов и специй со всех уголков света. ", 350.0, DrinkTypeEnum.Jagermeister),
            new Drink(140, "Сок - яблочный", "Свежевыжатый сок из яблок. ", 0.0, DrinkTypeEnum.Juice),
            new Drink(120, "Сок - апельсиновый", "Свежевыжатый сок из апельсинов. ", 0.0, DrinkTypeEnum.Juice),
            new Drink(100, "Сок - томатный Rich", "Томатный сок в коробке", 0.0, DrinkTypeEnum.Juice),
            new Drink(160, "Кофе - Латте", "Нежное кофе с пенкой в виде сердца! ", 0.0, DrinkTypeEnum.Coffee),
            new Drink(90, "Кофе - Экспрессо", "Крепкое кофе для крепких людей! ", 0.0, DrinkTypeEnum.Coffee),
            new Drink(800, "Чай - зеленый Richard", "Целый чайник отборного зеленого чая. ", 0.0, DrinkTypeEnum.Green_tea),
            new Drink(800, "Чай - черный Richard", "Целый чайник отборного черного чая. ", 0.0, DrinkTypeEnum.Black_tea),
            new Drink(120, "Молоко - Простоквашино", "Свежее горячее молоко", 0.0, DrinkTypeEnum.Milk),
            new Drink(40, "Вода - Bon Aqua", "Чистейшая вода ", 0.0, DrinkTypeEnum.Water),
            new Drink(110, "Газировка - Pepsi", "Газированный напиток. Безалкогольный. ", 0.0, DrinkTypeEnum.Soda),
            new Drink(110, "Газировка - Sprite", "Газированный напиток. Безалкогольный. ", 0.0, DrinkTypeEnum.Soda)
    };

    public static int dishesLength() {
        return dishes.length;
    }

    public static int drinksLength() {
        return drinks.length;
    }

    public static Dish getDish(int index) {
        return dishes[index];
    }

    public static Drink getDrink(int index) {
        return drinks[index];
    }
}