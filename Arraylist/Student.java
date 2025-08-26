public class Student {
    

    private String name;
    private char grade;

    public Student(String name, char grade){

        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public char getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student name is : " + name + "and grade =  " + grade;
    }

    


}
