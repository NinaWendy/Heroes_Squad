import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.staticFileLocation;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        //Home page
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            request.session().attribute("Heroes", new ArrayList<>());
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());
//HERO
        //CREATE
        //get: show new hero form

        //task: process new hero form

        //READ
        //get: show all heroes

        //get: show an individual task


        //UPDATE
        //get: show a form to update a hero

        //task: process a form to update a hero


        //DESTROY
        //get: delete all heroes

        //get: delete an individual hero


//SQUAD
        //CREATE
        //get: show new squad form

        //task: process new squad form

        //READ
        //get: show all squads

        //get: show an individual squad


        //UPDATE
        //get: show a form to update a squad

        //task: process a form to update a squad


        //DESTROY
        //get: delete all squads

        //get: delete an individual squad


        //SQUAD MEMBERS
    }
}
