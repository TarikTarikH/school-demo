package at.htl.control;

import at.htl.entity.ClassRoom;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ClassRoomRepository implements PanacheRepositoryBase<ClassRoom, String> {

    @Transactional
    public void addOrUpdateClassroom(ClassRoom classRoom){
        this.getEntityManager().merge(classRoom);
    }

    public List<ClassRoom> findClassRooms(){
        return this.listAll();
    }

    public ClassRoom findClassRoom(String className){
        return this.findById(className);
    }

    @Transactional
    public void deleteClassRoom(String className){
        this.deleteById(className);
    }
}
