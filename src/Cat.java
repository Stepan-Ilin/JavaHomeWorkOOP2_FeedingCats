public class Cat {
    private final String name;
    private final int appetite;
    private boolean satiety = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;

    }

    public void eat(Plate plate) {
        int result = plate.reductionFood(appetite);
        if (result >= 0) {
            setSatiety(true);
        }else {
            System.out.println("Не хватило " + (-1 * result) + " еды котику " + name + " с аппетитом " + appetite + "." );
            plate.info();
        }
    }

    public void setSatiety(boolean satiety) {
        this.satiety = satiety;
    }

    @Override
    public String toString() {
        return "Котик " + "'" + name + "'" +
                " имеет аппетит " + appetite +
                ", сейчас - " + (satiety ? "сыт" : "голоден") + ".";
    }
}
