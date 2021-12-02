package at.htl.boundary;

import at.htl.control.ClassRoomRepository;
import at.htl.control.TeacherRepository;
import at.htl.entity.ClassRoom;
import at.htl.entity.Teacher;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("api/teacher")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TeacherEndpoint {

    @Inject
    TeacherRepository teacherRepository;

    @GET
    public Response getAllTeachers(){
        return Response.ok(this.teacherRepository.findTeacher()).build();
    }

    @POST
    public Response createTeacher(Teacher teacher){
        this.teacherRepository.addOrUpdateTeacher(teacher);

        return Response.status(201).build();
    }
}
