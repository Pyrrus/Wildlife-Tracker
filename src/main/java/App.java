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
      model.put("animals", Animal.all());
      model.put("title", "Animal list");
      model.put("header", header);
      model.put("css", "");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/animal/new", (request, response) -> {
      Map <String, Object> model = new HashMap <String, Object>();
      model.put("template", "templates/animal-new.vtl");
      model.put("title", "Add new Animal");
      model.put("header", header);
      model.put("css", "");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/animal/new", (request, response) -> {
      Map <String, Object> model = new HashMap <String, Object>();
      String name = request.queryParams("name");
      Animal newAnimal = new Animal(name);
      newAnimal.save();
      response.redirect("/animal");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/endangeredanimal", (request, response) -> {
      Map <String, Object> model = new HashMap <String, Object>();
      model.put("template", "templates/list-enanimal.vtl");
      model.put("title", "Endangered Animal List");
      model.put("animals", EndangeredAnimal.all());
      model.put("header", header);
      model.put("css", "");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/endangeredanimal/new", (request, response) -> {
      Map <String, Object> model = new HashMap <String, Object>();
      model.put("template", "templates/endangered-new.vtl");
      model.put("title", "Add new Endangered Animal");
      model.put("header", header);
      model.put("css", "");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/endangeredanimal/new", (request, response) -> {
      Map <String, Object> model = new HashMap <String, Object>();
      String name = request.queryParams("name");
      String age = request.queryParams("age");
      String heathly = request.queryParams("healthy");
      EndangeredAnimal newEndangeredAnimal = new EndangeredAnimal(name);
      newEndangeredAnimal.save();
      EndaneredInfo newEndaneredInfo = new EndaneredInfo(newEndangeredAnimal.getId());
      newEndaneredInfo.setAge(request.queryParams("age"));
      newEndaneredInfo.setHealth(request.queryParams("healthy"));
      newEndaneredInfo.save();
      response.redirect("/endangeredanimal");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
