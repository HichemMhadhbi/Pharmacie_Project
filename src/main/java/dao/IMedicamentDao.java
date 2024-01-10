package dao;

import java.util.List;
import metier.entities.Medicament;

public interface IMedicamentDao {
    public Medicament save(Medicament medicament);
    public Medicament update(Medicament medicament);
    public void delete(int medicamentId);
    public List<Medicament> getAllMedicaments();
    public Medicament getMedicamentById(int medicamentId);
    public List<Medicament> searchMedicaments(String keyword);
    public List<Medicament> searchMedicamentsByCategory(String category);
}
