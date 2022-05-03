import models.Hero;
import models.Squad;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SquadAppTest {
    @Test
    void addSquad_addsANewSquad_returnsTrue() {
        Squad squad = setUpNewSquad();
        SquadApp squadApp = new SquadApp();
        squadApp.addSquad(new ArrayList<>(),squad);
        assertTrue(squadApp.getSquadList().contains(squad));
    }

    @Test
    public void getSquadList_returnsAllSquads() {
        Squad squad = setUpNewSquad();
        Squad squad1 = setUpNewSquad();
        Squad squad2 = setUpNewSquad();
        SquadApp squadApp = new SquadApp();
        squadApp.addSquad(squadApp.getSquadList(),squad);
        squadApp.addSquad(squadApp.getSquadList(), squad1);
        squadApp.addSquad(squadApp.getSquadList(), squad2);
        Integer expected =3;
        assertEquals(expected, squadApp.getSquadList().size());
    }

    @Test
    void findById_returnsSquadCorrectly() {
        Squad squad = setUpNewSquad();
        Squad squad1 = setUpNewSquad();
        SquadApp squadApp = new SquadApp();
        squadApp.addSquad(squadApp.getSquadList(),squad);
        squadApp.addSquad(squadApp.getSquadList(), squad1);
        assertEquals(squad1, squadApp.findById(1));
    }

    @Test
    public void clearAllSquads() {
        List<Squad> squadList = new ArrayList<>();
        Squad squad = setUpNewSquad();
        Squad squad1 = setUpNewSquad();
        SquadApp squadApp = new SquadApp();
        squadApp.addSquad(squadList,squad);
        squadApp.addSquad(squadList, squad1);
        squadApp.clearAllSquads();
        assertEquals(0, squadApp.getSquadList().size());

    }

    @Test
    public void deleteSquadById_removesSquadCorrectly() {
        Squad squad = setUpNewSquad();
        Squad squad1 = setUpNewSquad();
        SquadApp squadApp = new SquadApp();
        squadApp.addSquad(squadApp.getSquadList(),squad);
        squadApp.addSquad(squadApp.getSquadList(), squad1);
        squadApp.deleteSquad(1);
        assertEquals(1, squadApp.getSquadList().size());
    }
    @Test
    public void addedSquadsAreReturnedFromGetAll(){
        SquadApp squadApp= new SquadApp();
        squadApp.clearAllSquads();
        Squad squad = setUpNewSquad();
        squadApp.addSquad(squadApp.getSquadList(),squad);
        assertEquals(1, squadApp.getSquadList().size());
    }
    @Test
    public void noSquadReturnsEmptyList(){
        SquadApp squadApp= new SquadApp();
        squadApp.clearAllSquads();
        assertEquals(0, squadApp.getSquadList().size());
    }



    //Helper methods
    public Squad setUpNewSquad(){
        return new Squad("Avengers",5,"sexism");
    }
    public Hero setUpNewHero(){
        return  new Hero("Thor",40,"DC","Super","Hammer","Thunder");
    }

}
