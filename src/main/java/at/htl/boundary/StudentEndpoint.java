package at.htl.boundary;

import at.htl.control.StudentRepository;
import at.htl.control.TeacherRepository;
import at.htl.entity.Student;
import at.htl.entity.Teacher;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("api/student")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StudentEndpoint {

    @Inject
    StudentRepository studentRepository;

    @GET
    public Response getAllStudents(){
        return Response.ok(this.studentRepository.findStudent()).build();
    }

    @POST
    public Response createTeacher(Student student){
        this.studentRepository.addOrUpdateStudent(student);

        return Response.status(201).build();
    }
}
