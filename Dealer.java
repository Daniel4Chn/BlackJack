public class Dealer extends Player{
    private String gender = "";

    public Dealer(String name, int age, double money, String gender){
        super(name, age, money);
        this.gender = gender;
    }
    public String getGender(){
        return gender;
    }
    public String toString(){
        return "Hi, I am your dealer. My name is " + getName() + " and I am " + getAge() + " years old";
    }


}
