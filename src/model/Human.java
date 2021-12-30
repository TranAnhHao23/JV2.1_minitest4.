package model;

public class Human {
    private static int ID = 0;
    private int id;
    private String name;
    private int age;

    public Human() {
    }

    public Human(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public static int getID() {
        return ID;
    }

    public static void setID(int ID) {
        Human.ID = ID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Human{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
