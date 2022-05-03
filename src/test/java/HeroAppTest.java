import models.Hero;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HeroAppTest {
    @Test
    void addHero_addsANewHero_returnsTrue() {
        Hero hero= setUpNewHero();
        HeroApp heroApp = new HeroApp();
        heroApp.addHero(new ArrayList<>(),hero);
        assertTrue(heroApp.getHeroList().contains(hero));
    }

    @Test
    public void getHeroList_returnsAllHeroes() {
        Hero hero = setUpNewHero();
        Hero hero1 = setUpNewHero();
        Hero hero2 = setUpNewHero();
        HeroApp heroApp =new HeroApp();
        heroApp.addHero(heroApp.getHeroList(),hero);
        heroApp.addHero(heroApp.getHeroList(),hero1);
        heroApp.addHero(heroApp.getHeroList(),hero2);
        Integer expected =3;
        assertEquals(expected, heroApp.getHeroList().size());
    }

    @Test
    void findById_returnsHeroCorrectly() {
        Hero hero= setUpNewHero();
        Hero hero1= setUpNewHero();
        HeroApp heroApp = new HeroApp();
        heroApp.addHero(heroApp.getHeroList(),hero);
        heroApp.addHero(heroApp.getHeroList(),hero1);
        assertEquals(hero1, heroApp.findById(1));
    }

    @Test
    public void clearAllHeroes() {
        List<Hero> heroList= new ArrayList<>();
        Hero hero = setUpNewHero();
        Hero hero1 = setUpNewHero();
        HeroApp heroApp= new HeroApp();
        heroApp.addHero(heroList,hero);
        heroApp.addHero(heroList,hero1);
        heroApp.clearAllHeroes();
        assertEquals(0,heroApp.getHeroList().size());

    }

    @Test
    public void deleteHeroById_removesHeroCorrectly() {
        Hero hero = setUpNewHero();
        Hero hero1 = setUpNewHero();
        HeroApp heroApp= new HeroApp();
        heroApp.addHero(heroApp.getHeroList(),hero);
        heroApp.addHero(heroApp.getHeroList(),hero1);
        heroApp.deleteHero(1);
        assertEquals(1, heroApp.getHeroList().size());
    }

    //Helper method
    public Hero setUpNewHero(){
        return  new Hero("Thor",40,"DC","Super","Hammer","Thunder");
    }

}
