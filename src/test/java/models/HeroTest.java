package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeroTest {
    @Test
    void newObjectGetsCreatedCorretly_true() {
        Hero hero = setUpNewHero();
        assertEquals(true, hero instanceof Hero);
    }

    @Test
    public void getName_objectReturnsNameCorrectly_Thor() {
        Hero hero = setUpNewHero();
        assertEquals("Thor", hero.getName());
    }

    @Test
   public void update_objectCorrectlyUpdatesDetail() {
        Hero hero = setUpNewHero();
//        hero.update();

        assertEquals("Batman", hero.getName());
    }

    //Helper method
    public Hero setUpNewHero(){
        return  new Hero("Thor",40,"DC","Super","Hammer","Thunder");
    }
}
