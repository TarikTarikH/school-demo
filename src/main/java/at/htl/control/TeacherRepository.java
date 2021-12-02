package at.htl.control;

import at.htl.entity.ClassRoom;
import at.htl.entity.Teacher;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.transaction.Transactional;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@ApplicationScoped
public class TeacherRepository implements PanacheRepository<Teacher> {

    @Transactional
    public void addOrUpdateTeacher(Teacher teacher) {
        this.getEntityManager().merge(teacher);
    }

    public List<Teacher> findTeacher() {
        return this.listAll();
    }

    public Teacher findTeacher(long teacherId) {
        return this.findById(teacherId);
    }

    @Transactional
    public void deleteTeacher(long teacherId) {
        this.deleteById(teacherId);
    }

    //https://www.javaguides.net/2019/07/java-json-processing-tutorial.html
    public void readTeachersFromFile() {
        try {
            var path = Thread.currentThread().getContextClassLoader().getResource("teacher-data.json");
            
            //Get file
            var inputStream = new FileInputStream(Paths.get(path.toURI()).toFile());

            //Read values from file to JsonArray
            var jsonReader = Json.createReader(inputStream);
            var jsonArray = jsonReader.readArray();

            jsonReader.close();
            inputStream.close();

            for (var jsonObject : jsonArray) {
                //Save values from array to POJOs
                var teacher = new Teacher(jsonObject.asJsonObject().getString("firstName"), jsonObject.asJsonObject().getString("lastName"));

                //Save to db
                this.addOrUpdateTeacher(teacher);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }
}
