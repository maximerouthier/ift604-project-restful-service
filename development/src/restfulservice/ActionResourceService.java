package restfulservice;

import java.io.*;
import java.net.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import org.json.*;

import common.*;

public class ActionResourceService implements ActionResource {
  
  public StreamingOutput getActionList() {
    JSONArray jsonArray = new JSONArray();
    
    for (Action action : Application.DATABASE.getActionList()) {
      jsonArray.put(new JSONObject(action));
    }
    
    return new StreamingOutput() {
      @Override
      public void write(OutputStream out) throws IOException, WebApplicationException {
        new PrintStream(out).println(jsonArray);
      }
    };
  }
  
  public StreamingOutput getAction(String id) {
    Action action = Application.DATABASE.getAction(id);
    
    if (action == null) {
      throw new WebApplicationException(Response.Status.NOT_FOUND);
    }
    
    return new StreamingOutput() {
      @Override
      public void write(OutputStream out) throws IOException, WebApplicationException {
        new PrintStream(out).println(new JSONObject(action));
      }
    };
  }
  
  public Response createAction(InputStream in) {
    Action action = readAction(in);
    
    if (!Application.DATABASE.addAction(action)) {
      throw new WebApplicationException(Response.Status.PRECONDITION_FAILED);
    }
      
    return Response.created(URI.create("/actions/" + action.getId())).build();
  }
  
  public void updateAction(InputStream in) {
    Action update = readAction(in);
    
    if (!Application.DATABASE.updateAction(update)) {
      throw new WebApplicationException(Response.Status.NOT_FOUND);
    }
  }
  
  private Action readAction(InputStream in) {
    try {
      return new Action(new JSONObject(new JSONTokener(in)));
    }
    catch (Exception e) {
      throw new WebApplicationException(Response.Status.BAD_REQUEST);
    }
  }
}
