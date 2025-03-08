package dao;
import java.util.List;
import metier.entities.MakeUp;

public interface IMakeUpDao {
    public MakeUp save(MakeUp m);
    public List<MakeUp> makeUpParMC(String mc);
    public MakeUp getMakeUp(Long id);
    public MakeUp updateMakeUp(MakeUp m);
    public void deleteMakeUp(Long id);
}
