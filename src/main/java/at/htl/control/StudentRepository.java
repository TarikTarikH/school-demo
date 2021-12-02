package at.htl.control;

import at.htl.entity.ClassRoom;
import at.htl.entity.Student;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class StudentRepository implements PanacheRepository<Student> {
    @Transactional
    public Student addOrUpdateStudent(Student student){
        return this.getEntityManager().merge(student);
    }

    public List<Student> findStudent(){
        return this.listAll();
    }

    public Student findStudent(long studentId){
        return this.findById(studentId);
    }

    @Transactional
    public void deleteStudent(long studentId){
        this.deleteById(studentId);
    }
}
