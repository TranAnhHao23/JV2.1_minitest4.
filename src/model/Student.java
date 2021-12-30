package model;

public class Student extends Human{
    private double mathPoint;
    private double physicsPoint;
    private double chemisPoint;

    public Student() {
    }

    public Student(int id, String name, int age, double mathPoint, double physicsPoint, double chemisPoint) {
        super(id, name, age);
        this.mathPoint = mathPoint;
        this.physicsPoint = physicsPoint;
        this.chemisPoint = chemisPoint;
    }

    public double getMathPoint() {
        return mathPoint;
    }

    public void setMathPoint(double mathPoint) {
        this.mathPoint = mathPoint;
    }

    public double getPhysicsPoint() {
        return physicsPoint;
    }

    public void setPhysicsPoint(double physicsPoint) {
        this.physicsPoint = physicsPoint;
    }

    public double getChemisPoint() {
        return chemisPoint;
    }

    public void setChemisPoint(double chemisPoint) {
        this.chemisPoint = chemisPoint;
    }

    public double getAveragePoint(){
        return (mathPoint+physicsPoint+chemisPoint)/3;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + super.getId() +
                ", name='" + super.getName() + '\'' +
                ", age=" + super.getAge() +
                ", mathPoint=" + mathPoint +
                ", physicsPoint=" + physicsPoint +
                ", chemisPoint=" + chemisPoint +
                ", averagePoint=" + getAveragePoint() +
                '}';
    }
}
