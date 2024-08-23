package org.eelcorp.garage.DBAPI;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Fahrzeug {
    public enum FahrzeugTyp {
        AUTO,
        MOTORRAD
    }

    @Id
    private String nummernschild;
    private FahrzeugTyp fahrzeugTyp;
    private String model;
    private String kunde;

    @JsonIgnore
    @OneToOne(mappedBy = "nummernschild")
    private Parkplatz parkplatz;

    public Fahrzeug() { }

    public Fahrzeug(String nummernschild, FahrzeugTyp fahrzeugTyp, String model, String kunde) {
        this.nummernschild = nummernschild;
        this.fahrzeugTyp = fahrzeugTyp;
        this.model = model;
        this.kunde = kunde;
    }

    public String getNummernschild() {
        return nummernschild;
    }

    public void setNummernschild(String nummernschild) {
        this.nummernschild = nummernschild;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public FahrzeugTyp getFahrzeugTyp() {
        return fahrzeugTyp;
    }

    public void setFahrzeugTyp(FahrzeugTyp fahrzeugTyp) {
        this.fahrzeugTyp = fahrzeugTyp;
    }

    public String getKunde() {
        return kunde;
    }

    public void setKunde(String kunde) {
        this.kunde = kunde;
    }

    public Parkplatz getParkplatz() {
        return parkplatz;
    }

    public void setParkplatz(Parkplatz parkplatz) {
        this.parkplatz = parkplatz;
    }

    @Override
    public String toString() {
        return "Fahrzeug{" +
                "nummernschild='" + nummernschild + '\'' +
                ", fahrzeugTyp=" + fahrzeugTyp +
                ", model='" + model + '\'' +
                ", kunde='" + kunde + '\'' +
                ", parkplatz=" + parkplatz +
                '}';
    }
}
