import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.Arrays;
import java.util.*;

public class App {
  public static void main(String[] args) {

  	staticFileLocation("/public");
    String layout = "templates/layout.vtl";
    String header = "templates/header.vtl";

    get("/", (request, response) -> {
      Map <String, Object> model = new HashMap <String, Object>();
      model.put("template", "templates/index.vtl");
      model.put("title", "Portland Wildlife Tracker");
      model.put("header", header);
      model.put("css", "");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/animal", (request, response) -> {
      Map <String, Object> model = new HashMap <String, Object>();
      model.put("template", "templates/list-animal.vtl");
      model.put("animal", Animal.all());
      model.put("title", "Animal list");
      model.put("header", header);
      model.put("css", "");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/endangeredanimal", (request, response) -> {
      Map <String, Object> model = new HashMap <String, Object>();
      model.put("template", "templates/list-enanimal.vtl");
      model.put("title", "Endangered Animal List");
      model.put("animal", EndangeredAnimal.all());
      model.put("header", header);
      model.put("css", "");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
