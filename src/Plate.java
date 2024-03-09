public class Plate {
    private int food;
    public Plate(int food) {
        this.food = food;
    }
    public void info() {
        System.out.println("plate: " + food);
    }

    //region Метод добавления еды в тарелку
    public void addFood(int food){
        this.food += food;
    }
    //endregion

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }
}
