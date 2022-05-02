import java.util.ArrayList;
import java.util.List;

public class SquadApp {
    private List<Squad> squadList = new ArrayList<>();

    public List<Squad> getSquadList() {
        return squadList;
    }
    public void addSquad( List<Squad> list, Squad squad){
        if(list != null){
            squadList = list;
        }
        assert list != null;
        squad.setSquadId(list.size());
        squadList.add(squad);
    }

    public  Squad findById(int squadId) {
        return  squadList.get(squadId);
    }

    public void clearAllSquads(){
        squadList.clear();
    }

    public void deleteSquad(int squadId) {
        squadList.remove(squadId);
    }
}
