package models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class HeroTest {
    @Test
    void newObjectGetsCreatedCorretly_true() {
        Hero hero = setUpNewHero();
        assertNotNull(hero);
    }

    @Test
    public void getName_objectReturnsNameCorrectly_Thor() {
        Hero hero = setUpNewHero();
        assertEquals("Thor", hero.getName());
    }

    @Test
   public void update_objectCorrectlyUpdatesDetail() {
        Hero hero = setUpNewHero();
        hero.update("Batman",34,"Marvel","Bat","Suit","Most badass");
        assertEquals("Batman", hero.getName());
    }

    @Test
    void delete_objectIsCorrectlyRemoved() {
       ArrayList<Hero> instances = new ArrayList<>();
        Hero hero = setUpNewHero();
        instances.add(hero);
        Hero hero1 = setUpNewHero();
        instances.add(hero1);
        instances.remove(1);
        assertEquals(1,instances.size());
    }

    //Helper method
    public Hero setUpNewHero(){
        return  new Hero("Thor",40,"DC","Super","Hammer","Thunder");
    }
}
