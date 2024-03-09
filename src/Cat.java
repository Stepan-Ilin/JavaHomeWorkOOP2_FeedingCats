public class Cat {
    private final String name;
    private final int appetite;
    private boolean satiety = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;

    }

    public void eat(Plate plate) {
        int deltaFood = plate.getFood() - getAppetite();
        if (deltaFood >= 0) {
            setSatiety(true);
            plate.setFood(deltaFood);
        }else {
            System.out.println("Не хватило " + (-1 * deltaFood) + " еды котику " + name + " с аппетитом " + appetite + "." );
            plate.info();
        }
    }

    public void setSatiety(boolean satiety) {
        this.satiety = satiety;
    }

    public int getAppetite() {
        return appetite;
    }

    @Override
    public String toString() {
        return "Котик " + "'" + name + "'" +
                " имеет аппетит " + appetite +
                ", сейчас - " + (satiety ? "сыт" : "голоден") + ".";
    }
}
