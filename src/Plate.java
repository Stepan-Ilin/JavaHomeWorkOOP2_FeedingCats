public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void info() {
        System.out.println("plate: " + food);
    }

    //region Метод добавления еды в тарелку
    public void addFood(int food) {
        if (food > 0)
            this.food += food;
    }

    /**
     * Убавление еды из тарелки
     * @param howMuch кол-во еды, на которое должно быть насыщение (в условных единицах)
     * @return кол-во еды в тарелке, после насыщении. В отрицательном значении - кол-во
     * еды, которое не хватило для насыщения, при этом кол-во еды в тарелке НЕ МЕНЯЕТСЯ
     */
    public int reductionFood(int howMuch) {
        return this.food < howMuch ? this.food - howMuch : (this.food -= howMuch);
    }
}
