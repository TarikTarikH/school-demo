package at.htl.boundary;

import at.htl.control.ClassRoomRepository;
import at.htl.entity.ClassRoom;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("api/class-room")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClassRoomEndpoint {

    @Inject
    ClassRoomRepository classRoomRepository;

    @GET
    public Response getAllClassRooms(){
        return Response.ok(this.classRoomRepository.findClassRooms()).build();
    }

    @POST
    public Response createClassRoom(ClassRoom classRoom){
        this.classRoomRepository.addOrUpdateClassroom(classRoom);

        return Response.status(201).build();
    }
}
