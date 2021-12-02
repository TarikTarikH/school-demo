package at.htl.control;

import at.htl.entity.ClassRoom;
import at.htl.entity.Teacher;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class TeacherRepository implements PanacheRepository<Teacher> {

    @Transactional
    public void addOrUpdateTeacher(Teacher teacher){
        this.getEntityManager().merge(teacher);
    }

    public List<Teacher> findTeacher(){
        return this.listAll();
    }

    public Teacher findTeacher(long teacherId){
        return this.findById(teacherId);
    }

    @Transactional
    public void deleteTeacher(long teacherId){
        this.deleteById(teacherId);
    }
}
