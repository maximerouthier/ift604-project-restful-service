package restfulservice;

import java.io.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/actions")
public interface ActionResource {
  
  @GET
  @Produces("application/json")
  public StreamingOutput getActionList();
  
  @GET
  @Path("{id}")
  @Produces("application/json")
  public StreamingOutput getAction(@PathParam("id") String id);
  
  @POST
  @Consumes("application/json")
  public Response createAction(InputStream in);
  
  @PUT
  @Consumes("application/json")
  public void updateAction(InputStream in);
}
