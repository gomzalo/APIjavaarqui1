package api;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;


//ApplicationClass ap = new ApplicationClass();

@ApplicationPath("")
public class ApiApplication extends Application {
 @Override
 public Set<Class<?>> getClasses() {
  Set<Class<?>> classes = new HashSet<Class<?>>();
  classes.add(api.ApiService.class);
  return classes;
 }
}