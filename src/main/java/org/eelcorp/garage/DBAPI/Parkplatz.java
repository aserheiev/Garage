package org.eelcorp.garage.DBAPI;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

@Entity
public class Parkplatz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int etage;
    private boolean istBesetzt;

    @OneToOne
    @JoinColumn(name = "nummernschild", referencedColumnName = "nummernschild")
    @Nullable
    private Fahrzeug nummernschild;

    public Parkplatz() {}

    public Parkplatz(int etage, boolean istBesetzt, @Nullable Fahrzeug nummernschild) {
        this.etage = etage;
        this.istBesetzt = istBesetzt;
        this.nummernschild = nummernschild;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEtage() {
        return etage;
    }

    public void setEtage(int etage) {
        this.etage = etage;
    }

    public boolean isIstBesetzt() {
        return istBesetzt;
    }

    public void setIstBesetzt(boolean istBesetzt) {
        this.istBesetzt = istBesetzt;
    }

    @Nullable
    public Fahrzeug getNummernschild() {
        return nummernschild;
    }

    public void setNummernschild(@Nullable Fahrzeug nummernschild) {
        this.nummernschild = nummernschild;
    }

    @Override
    public String toString() {
        return "Parkplatz{" +
                "id=" + id +
                ", etage=" + etage +
                ", istBesetzt=" + istBesetzt +
                ", nummernschild=" + nummernschild +
                '}';
    }
}
