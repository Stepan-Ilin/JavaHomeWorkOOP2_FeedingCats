//region Задание
//Объектно-ориентированное программирование (семинары)
//Урок 2. Принципы ООП Абстракция и интерфейсы. Пример проектирования
//
//Допустим, в программе есть класс Кот. У кота есть кличка и аппетит (сколько единиц еды он потребляет за приём
//        пищи). Эти поля мы заполняем с помощью конструктора. Также есть метод eat(), который заставляет
//        кота покушать, но пока что он пустой, так как неизвестно, откуда кот должен брать еду:
//
//public class Cat {
//    private String name;
//    private int appetite;
//    public Cat(String name, int appetite) {
//        this.name = name;
//        this.appetite = appetite;
//    }
//    public void eat() { }
//}
//
//Чтобы можно было хранить еду, создадим класс Тарелка с полем food (еда измеряется в целых
//        числах и не важно, что это за единицы измерения). При создании тарелки мы можем указать
//начальное значение food. В процессе работы с помощью метода info() можно вывести в консоль
//информацию о тарелке.
//
//public class Plate {
//    private int food;
//    public Plate(int food) {
//        this.food = food;
//    }
//    public void info() {
//        System.out.println("plate: " + food);
//    }
//}
//
//Если в методе main() создать объекты этих классов, то можно узнать информацию о тарелке и
//вызвать пустой метод eat() у кота. Эти объекты пока никак не могут взаимодействовать между собой.
//Можно добавить в классы геттеры и сеттеры и получить код вроде.
//
//public class MainClass {
//    public static void main(String[] args) {
//        Cat cat = new Cat("Barsik", 5);
//        Plate plate = new Plate(100);
//        plate.info();
//        cat.eat();
//        plate.setFood(plate.getFood() - cat.getAppetite());
//    }
//}
//
//ЗАДАНИЕ
//
//      Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, а кот пытается покушать 15-20).
//      Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать (хватило еды), сытость = true. Считаем,
// что если коту мало еды в тарелке, то он её просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы).
//      Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль.
//      Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.
//
//Достаточно выполнить первые 2 подпункта задачи.
//Формат сдачи: ссылка на гитхаб проект
//endregion


import java.util.Random;

public class MainClass {
    public static void main(String[] args) {
        int maxAppetite=30;
        int numberCats = 10;

        Cat[] cats = new Cat[numberCats];
        Random rnd = new Random();
        for (int i = 0; i < numberCats ; i++) {
            cats[i] = new Cat("Котик_" + i, rnd.nextInt(1,maxAppetite) ); // тут появились котики
        }
        System.out.println("----- До кормёшки -----");
        Cat cat = new Cat("Barsik", 5); // родился Барсик
        System.out.println(cat);
        for (Cat elem : cats)
            System.out.println(elem);   // голодная свора

        Plate plate = new Plate(100); // ...и тут тарека нашлась, да еще и с едой...
        plate.info();
        System.out.println("\n------ Добавка еды -----");
        plate.addFood(20); // добавка еды в тарелку
        plate.info();
        cat.eat(plate); // Барсик кушает

        //region Массовая кормёшка котиков
        System.out.println("\n----- Вовремя еды -----");
        for (Cat item : cats){
           item.eat(plate); // все кушают
        }
        //endregion

        System.out.println("\n---- После кормёшки -----");
        System.out.println(cat); // вывод Барсика
        for (Cat elem : cats)
            System.out.println(elem); // вывод остальных
        plate.info();
    }
}