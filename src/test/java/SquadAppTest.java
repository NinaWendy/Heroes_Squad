import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SquadAppTest {
    @Test
    void addHero_addsANewHero_returnsTrue() {
        Squad squad = setUpNewSquad();
        SquadApp squadApp = new SquadApp();
        squadApp.addSquad(new ArrayList<>(),squad);
        assertTrue(squadApp.getSquadList().contains(squad));
    }

    @Test
    public void getHeroList_returnsAllHeroes() {
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
    void findById_returnsHeroCorrectly() {
        Squad squad = setUpNewSquad();
        Squad squad1 = setUpNewSquad();
        SquadApp squadApp = new SquadApp();
        squadApp.addSquad(squadApp.getSquadList(),squad);
        squadApp.addSquad(squadApp.getSquadList(), squad1);
        assertEquals(squad1, squadApp.findById(1));
    }

    @Test
    public void clearAllHeroes() {
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
    public void deleteHeroById_removesHeroCorrectly() {
        Squad squad = setUpNewSquad();
        Squad squad1 = setUpNewSquad();
        SquadApp squadApp = new SquadApp();
        squadApp.addSquad(squadApp.getSquadList(),squad);
        squadApp.addSquad(squadApp.getSquadList(), squad1);
        squadApp.deleteSquad(1);
        assertEquals(1, squadApp.getSquadList().size());
    }

    //Helper method
    public Squad setUpNewSquad(){
        return new Squad("Avengers",5,"sexism");
    }

}
