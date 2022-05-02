import models.Hero;

import java.util.ArrayList;
import java.util.List;

public class HeroApp {
    private List<Hero> heroList = new ArrayList<>();

    public List<Hero> getHeroList() {
        return heroList;
    }
    public void addHero( List<Hero> list, Hero hero){
        if(list != null){
            heroList= list;
        }
        assert list != null;
        hero.setId(list.size());
        heroList.add(hero);
    }

    public  Hero findById(int id) {
        return  heroList.get(id);
    }

    public void clearAllHeroes(){
        heroList.clear();
    }

    public void deleteHero(int id) {
        heroList.remove(id);
    }
}
