package at.htl.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CLASS_ROOM")
public class ClassRoom extends PanacheEntityBase {

    @Column(name = "CLASS_NUMBER")
    private String classNumber;

    @Id
    @Column(name = "CLASS_NAME")
    private String className;

    public ClassRoom() {
    }

    public ClassRoom(String classNumber, String className) {
        this.classNumber = classNumber;
        this.className = className;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "ClassRoom{" +
                "classNumber=" + classNumber +
                ", className='" + className + '\'' +
                '}';
    }
}
