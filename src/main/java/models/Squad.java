package models;

import java.util.List;

public class Squad {
    private String squadName;
    private int squadSize;
    private String fightingCause;
    private int squadId;


    public Squad(String squadName, int squadSize, String fightingCause) {
        this.squadName = squadName;
        this.squadSize = squadSize;
        this.fightingCause = fightingCause;
    }

    public String getSquadName() {
        return squadName;
    }

    public void setSquadName(String squadName) {
        this.squadName = squadName;
    }

    public int getSquadSize() {
        return squadSize;
    }

    public void setSquadSize(int squadSize) {
        this.squadSize = squadSize;
    }

    public String getFightingCause() {
        return fightingCause;
    }

    public void setFightingCause(String fightingCause) {
        this.fightingCause = fightingCause;
    }

    public int getSquadId() {
        return squadId;
    }

    public void setSquadId(int squadId) {
        this.squadId = squadId;
    }

    public void update(String squadName, int squadSize, String fightingCause) {
        this.squadName = squadName;
        this.squadSize = squadSize;
        this.fightingCause = fightingCause;
    }
}
