import models.Hero;
import models.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
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
            List<Hero> list = request.session().attribute("Heroes");
            boolean moreThanThree = false;
            if (list != null && list.size() > 3) {
                moreThanThree = true;
                list = list.subList(0, 2);
            }
            model.put("Heroes", list);
            model.put("moreThanThree", moreThanThree);
            request.session().attribute("Heroes", new ArrayList<>());
            return new ModelAndView(model, "hero-form.hbs");
        }, new HandlebarsTemplateEngine());

        //task: process new hero form
        post("/hero/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            int age = Integer.parseInt(request.queryParams("age"));
            String squad = request.queryParams("squad");
            String description = request.queryParams("description");
            String strength = request.queryParams("strength");
            String weakness = request.queryParams("weakness");
            List<Hero> list = request.session().attribute("Heroes");
            Hero hero = new Hero(name,age, squad, strength, weakness, description);
            HeroApp heroApp = new HeroApp();
            heroApp.addHero(list, hero);
            List<Hero> updatedHeroes = heroApp.getHeroList();
            request.session().attribute("Heroes", updatedHeroes);
            boolean moreThanThree = false;
            if (updatedHeroes.size() > 4) {
                moreThanThree = true;
                updatedHeroes = updatedHeroes.subList(0, 3);
            }
            model.put("Heroes", updatedHeroes);
            model.put("moreThanThree", moreThanThree);
            return new ModelAndView(model, "hero-form.hbs");
        }, new HandlebarsTemplateEngine());

        //READ
        //get: show all heroes
        get("/heroes", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Hero> list = request.session().attribute("Heroes");
            model.put("Heroes", list);
            return new ModelAndView(model, "hero.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show an individual hero
        get("/hero/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int id = Integer.parseInt(request.params("id"));
            List<Hero> list = request.session().attribute("Heroes");
            Hero hero = list.get(id);
            model.put("Heroes", hero);
            return new ModelAndView(model, "hero-detail.hbs");
        }, new HandlebarsTemplateEngine());


        //UPDATE
        //get: show a form to update a hero
        get("/hero/:id/update", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Hero> list = request.session().attribute("Heroes");
            int id = Integer.parseInt(request.params("id"));
            Hero editHero = list.get(id);
            model.put("editHero", editHero);
            return new ModelAndView(model, "edit-hero.hbs");
        }, new HandlebarsTemplateEngine());

        //task: process a form to update a hero
        post("/hero/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Hero> list = req.session().attribute("Heroes");
            String name = req.queryParams("name");
            int age = Integer.parseInt(req.queryParams("age"));
            String squad = req.queryParams("squad");
            String strength = req.queryParams("strength");
            String weakness = req.queryParams("weakness");
            String description = req.queryParams("description");
            int id = Integer.parseInt(req.params("id"));
            Hero editHero = list.get(id);
            editHero.update(name,age,squad,strength, weakness, description);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());


        //DESTROY
        //get: delete all heroes
        get("/hero/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Hero> list = req.session().attribute("Heroes");
            list.clear();
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());
        post("/hero/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Hero> list = req.session().attribute("Heroes");
            list.clear();
            model.put("removeHeroes",list);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());


        //get: delete an individual hero
        get("/hero/:id/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Hero> list = req.session().attribute("Heroes");
            int id = Integer.parseInt(req.params("id"));
            list.remove(id);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());


//SQUAD
        //CREATE
        //get: show new squad form
        get("/squad/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Squad> list = req.session().attribute("Squads");
            model.put("Squads", list);
            req.session().attribute("Squads", new ArrayList<>());
            return new ModelAndView(model, "squad-form.hbs");
        }, new HandlebarsTemplateEngine());

        //task: process new squad form
        post("/squad/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String squadName = req.queryParams("squadName");
            Integer squadSize = Integer.parseInt(req.queryParams("squadSize"));
            String fightingCause = req.queryParams("fightingCause");
            List<Squad> list = req.session().attribute("Squads");
            Squad newSquad = new Squad(squadName, squadSize, fightingCause);
            SquadApp squadApp = new SquadApp();
            squadApp.addSquad(list, newSquad);
            List<Squad> updatedSquads = squadApp.getSquadList();
            req.session().attribute("Squads", updatedSquads);
            model.put("Squads", updatedSquads);
            return new ModelAndView(model, "squad-form.hbs");
        }, new HandlebarsTemplateEngine());

        //READ
        //get: show all squads
        get("/squad", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Squad> list = req.session().attribute("Squads");
            model.put("Squads", list);
            return new ModelAndView(model, "squad.hbs");
        }, new HandlebarsTemplateEngine());


        //get: show an individual squad
        get("/squad/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int id = Integer.parseInt(req.params("id"));
            List<Squad> list = req.session().attribute("Squads");
            Squad squad = list.get(id);
            model.put("Squads", squad);
            return new ModelAndView(model, "squad-detail.hbs");
        }, new HandlebarsTemplateEngine());


        //UPDATE
        //get: show a form to update a squad
        get("/squad/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Squad> list = req.session().attribute("Squads");
            int squadId = Integer.parseInt(req.params("squadId"));
            Squad editSquad = list.get(squadId);
            model.put("editSquad", editSquad);
            return new ModelAndView(model, "edit-squad-form.hbs");
        }, new HandlebarsTemplateEngine());

        //task: process a form to update a squad
        post("/squad/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Squad> list = req.session().attribute("Heroes");
            String squadName = req.queryParams("squadName");
            int squadSize = Integer.parseInt(req.queryParams("squadSize"));
            String fightingCause = req.queryParams("fightingCause");
            int squadId = Integer.parseInt(req.params("squadId"));
            Squad editSquad = list.get(squadId);
            editSquad.update(squadName, squadSize, fightingCause);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());


        //DESTROY
        //get: delete all squads
        get("/squad/delete", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Squad> list = request.session().attribute("Squads");
            list.clear();
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        //get: delete an individual squad
        get("/squad/:id/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Squad> list = req.session().attribute("Squads");
            int squadId = Integer.parseInt(req.params("squadId"));
            list.remove(squadId);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());


        //SQUAD MEMBERS
        get("/squad/:id/hero/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "squad-hero-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/squad/:id/hero/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int id = Integer.parseInt(req.params("id"));
            List<Squad> list = req.session().attribute("Squads");
            Squad squadM = list.get(id);
            String name = req.queryParams("name");
            int age = Integer.parseInt(req.queryParams("age"));
            String squad = req.queryParams("squad");
            String strength = req.queryParams("strength");
            String weakness = req.queryParams("weakness");
            String description = req.queryParams("description");
            Hero hero = new Hero(name,age,squad,strength,weakness,description);
            squadM.addsquadHero(hero);
            model.put("SquadHeroes", squadM);
            return new ModelAndView(model, "squad-success.hbs");
        }, new HandlebarsTemplateEngine());

        //custom 404 error page
        get("/404-error",(req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return  new ModelAndView(model,"404-error.hbs");
        },new HandlebarsTemplateEngine());
    }
}
