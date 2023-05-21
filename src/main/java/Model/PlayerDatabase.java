package Model;


public class PlayerDatabase {

    public String created;
    public String name;
    public Integer playerSteps;


    public PlayerDatabase() {
    }

    public PlayerDatabase(String name, Integer playerSteps, String created) {
        this.name = name;
        this.playerSteps = playerSteps;
        this.created = created;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPlayerSteps() {
        return playerSteps;
    }

    public void setPlayerSteps(Integer playerSteps) {
        this.playerSteps = playerSteps;
    }

    public String getCreated() {
        return created;
    }

}

