package web;

import java.util.ArrayList;
import java.util.List;
import metier.entities.Medicament;

public class MedicamentModel {
    private String keyword;
    private List<Medicament> medicaments = new ArrayList<>();

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public List<Medicament> getMedicaments() {
        return medicaments;
    }

    public void setMedicaments(List<Medicament> medicaments) {
        this.medicaments = medicaments;
    }
}
