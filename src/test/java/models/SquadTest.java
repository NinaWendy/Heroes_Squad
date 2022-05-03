package models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class SquadTest {
    @Test
    void newSquad_instantiatesCorrectly() {
        Squad squad= setUpNewSquad();
        assertNotNull(squad);
    }
    @Test
    public void getName_objectReturnsNameCorrectly_Thor() {
        Squad squad = setUpNewSquad();
        Assertions.assertEquals("Avengers", squad.getSquadName());
    }

    @Test
    public void update_objectCorrectlyUpdatesDetail() {
        Squad squad = setUpNewSquad();
        squad.update("X-men",4,"Corruption");
        Assertions.assertEquals("X-men", squad.getSquadName());
    }

    @Test
    void delete_objectIsCorrectlyRemoved() {
        ArrayList<Squad> instances = new ArrayList<>();
        Squad squad = setUpNewSquad();
        instances.add(squad);
        Squad squad1 = setUpNewSquad();
        instances.add(squad1);
        instances.remove(1);
        assertEquals(1,instances.size());
    }
    @Test
    public void getAllTasksByCategoryReturnsTasksCorrectly(){
        Squad squad = setUpNewSquad();
        Hero hero = setUpNewHero();
        Hero hero2 = new Hero("Batman",30,"Marvel","Bat","Suit","Badass");
        squad.addsquadHero(hero);
        squad.addsquadHero(hero2);
        assertEquals(2, squad.getSquadHeroes().size());
        assertEquals("Thor", hero.getName());
        assertEquals("Batman", hero2.getName());
    }

    //Helper Method
    public Squad setUpNewSquad(){
        return new Squad("Avengers",5,"sexism");
    }
    public Hero setUpNewHero(){
        return  new Hero("Thor",40,"DC","Super","Hammer","Thunder");
    }

}
