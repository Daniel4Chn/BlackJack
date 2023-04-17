public class Player {
    private String name;
    private int age;
    public double money;

    public Player(String name, int age, double money){
        this.name = name;
        this.age = age;
        this.money = money;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public double money(){
        return money;
    }
}
