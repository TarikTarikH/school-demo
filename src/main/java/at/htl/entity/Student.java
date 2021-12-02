package at.htl.entity;

import javax.persistence.*;

@Entity
@Table(name = "STUDENT")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "AGE")
    private int age;

    @ManyToOne
    @JoinColumn(name = "TEACHER_ID")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "CLASS_ROOM_ID")
    private ClassRoom classRoom;

    public Student() {
    }

    public Student(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Student(String firstName, String lastName, int age, Teacher teacher, ClassRoom classRoom) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.teacher = teacher;
        this.classRoom = classRoom;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", teacher=" + teacher +
                ", classRoom=" + classRoom +
                '}';
    }
}
