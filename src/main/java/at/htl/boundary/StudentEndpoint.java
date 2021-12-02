package at.htl.boundary;

import at.htl.control.StudentRepository;
import at.htl.control.TeacherRepository;
import at.htl.entity.Student;
import at.htl.entity.Teacher;
import io.quarkus.security.identity.SecurityIdentity;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("api/student")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StudentEndpoint {

    @Inject
    StudentRepository studentRepository;

    @Inject
    SecurityIdentity securityIdentity;

    @GET
    public Response getAllStudents(){
        return Response.ok(this.studentRepository.findStudent()).build();
    }

    @POST
    public Response createTeacher(Student student){
        this.studentRepository.addOrUpdateStudent(student);

        return Response.status(201).build();
    }

    @POST
    @RolesAllowed({"admin"})
    @Path("clear")
    @Transactional
    public Response clearTable(){
        this.studentRepository.deleteAll();

        return Response.ok().build();
    }

    @GET
    @Path("info")
    public SecurityIdentity getInfo(){
        return securityIdentity;
    }

    @GET
    @RolesAllowed({"admin", "simp"})
    @Path("basket")
    public String getBasket(){
        return "\uD83D\uDC94 L \uD83D\uDC94";
    }
}
