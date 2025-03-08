package metier.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "make_up")  
public class MakeUp implements Serializable {

    @Id
    @Column(name = "ID_MAQUILLAGE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMaquillage;

    @Column(name = "NOM")
    private String nom;

    @Column(name = "MARQUE")
    private String marque;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "PRIX")
    private double prix;

    public MakeUp() {
        super();
    }

    public MakeUp(String nom, String marque, String type, double prix) {
        this.nom = nom;
        this.marque = marque;
        this.type = type;
        this.prix = prix;
    }

    public Long getIdMaquillage() {
        return idMaquillage;
    }

    public void setIdMaquillage(Long idMaquillage) {
        this.idMaquillage = idMaquillage;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

   
    @Override
    public String toString() {
        return "MakeUp [idMaquillage=" + idMaquillage + ", nom=" + nom + ", marque=" + marque + ", type=" + type
                + ", prix=" + prix + "]";
    }
}
