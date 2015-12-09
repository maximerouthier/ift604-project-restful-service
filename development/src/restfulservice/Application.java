package restfulservice;

import java.util.*;

public class Application extends javax.ws.rs.core.Application {
  public static final Database DATABASE = new Database();
  
  @Override
  public Set<Class<?>> getClasses() {
    return new HashSet<Class<?>>(Arrays.asList(ActionResourceService.class));
  }
}
