package model;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        double averagePointO1 = (o1.getMathPoint() + o1.getPhysicsPoint() + o1.getChemisPoint())/3;
        double averagePointO2 = (o2.getMathPoint() + o2.getPhysicsPoint() + o2.getChemisPoint())/3;
        if (averagePointO1 > averagePointO2){
            return 1;
        } else if (averagePointO1 < averagePointO2){
            return -1;
        } else {
            return 0;
        }
    }
}
