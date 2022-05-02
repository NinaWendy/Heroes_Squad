import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.Map;

import static spark.Spark.*;

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
        get("/hero/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();

            return new ModelAndView(model, "hero-form.hbs");
        }, new HandlebarsTemplateEngine());

        //task: process new hero form
        post("/hero/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();

            return new ModelAndView(model, "hero-form.hbs");
        }, new HandlebarsTemplateEngine());

        //READ
        //get: show all heroes
        get("/heroes", (request, response) -> {
            Map<String, Object> model = new HashMap<>();

            return new ModelAndView(model, "hero.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show an individual task
        get("/hero/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<>();

            return new ModelAndView(model, "hero-detail.hbs");
        }, new HandlebarsTemplateEngine());


        //UPDATE
        //get: show a form to update a hero
        get("/hero/:id/update", (request, response) -> {
            Map<String, Object> model = new HashMap<>();

            return new ModelAndView(model, "edit-hero-form.hbs");
        }, new HandlebarsTemplateEngine());

        //task: process a form to update a hero
        post("/hero/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());


        //DESTROY
        //get: delete all heroes
        get("/hero/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());


        //get: delete an individual hero
        get("/hero/:id/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());


//SQUAD
        //CREATE
        //get: show new squad form
        get("/squad/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            return new ModelAndView(model, "squad-form.hbs");
        }, new HandlebarsTemplateEngine());

        //task: process new squad form
        post("/squad/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            return new ModelAndView(model, "squad-form.hbs");
        }, new HandlebarsTemplateEngine());

        //READ
        //get: show all squads
        get("/squad", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            return new ModelAndView(model, "squad.hbs");
        }, new HandlebarsTemplateEngine());


        //get: show an individual squad
        get("/squad/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            return new ModelAndView(model, "squad-detail.hbs");
        }, new HandlebarsTemplateEngine());


        //UPDATE
        //get: show a form to update a squad
        get("/squad/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            return new ModelAndView(model, "edit-squad-form.hbs");
        }, new HandlebarsTemplateEngine());

        //task: process a form to update a squad
        post("/squad/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());


        //DESTROY
        //get: delete all squads
        get("/squad/delete", (request, response) -> {
            Map<String, Object> model = new HashMap<>();

            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        //get: delete an individual squad
        get("/squad/:id/delete", (req, res) -> {

            return null;
        }, new HandlebarsTemplateEngine());


        //SQUAD MEMBERS
    }
}
