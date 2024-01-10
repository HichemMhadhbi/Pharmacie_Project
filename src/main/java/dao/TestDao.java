package dao;

import java.util.List;
import metier.entities.Category;
import metier.entities.Medicament;
import web.MedicamentModel;

public class TestDao {
    public static void main(String[] args) {
        // Create instances of DAO implementations
        CategoryDaoImpl categoryDao = new CategoryDaoImpl();
        MedicamentDaoImpl medicamentDao = new MedicamentDaoImpl();

      
        List<Medicament> medicaments1 = medicamentDao.getAllMedicaments();
    	MedicamentModel medicamentModel = new MedicamentModel();
    	medicamentModel.setMedicaments(medicaments1);
    	for (Medicament m : medicaments1) {
            System.out.println(m);
        }
      
    }
   
}
