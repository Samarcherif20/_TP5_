package web;

import java.util.ArrayList;
import java.util.List;
import metier.entities.MakeUp;

public class MakeupModele {
    private String motCle;
    private List<MakeUp> makeUpList = new ArrayList<>();

    public String getMotCle() {
        return motCle;
    }

    public void setMotCle(String motCle) {
        this.motCle = motCle;
    }

    public List<MakeUp> getMakeUpList() {
        return makeUpList;
    }

    public void setMakeUpList(List<MakeUp> makeUpList) {
        this.makeUpList = makeUpList;
    }
}
