package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.SingletonConnection;
import metier.entities.Category;
import metier.entities.Medicament;

public class MedicamentDaoImpl implements IMedicamentDao {

    @Override
    public Medicament save(Medicament medicament) {
        Connection conn = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO Medicaments(name, category_id, quantity, prix) VALUES (?, ?, ?, ?)");
            ps.setString(1, medicament.getName());
            ps.setInt(2, medicament.getCategory().getCategoryId());
            ps.setInt(3, medicament.getQuantity());
            ps.setDouble(4, medicament.getPrix());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicament;
    }

    @Override
    public Medicament update(Medicament medicament) {
        Connection conn = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE Medicaments SET name=?, category_id=?, quantity=?, prix=? WHERE medicament_id=?");
            ps.setString(1, medicament.getName());
            ps.setInt(2, medicament.getCategory().getCategoryId());
            ps.setInt(3, medicament.getQuantity());
            ps.setDouble(4, medicament.getPrix());
            ps.setInt(5, medicament.getMedicamentId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicament;
    }

    @Override
    public void delete(int medicamentId) {
        Connection conn = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM Medicaments WHERE medicament_id = ?");
            ps.setInt(1, medicamentId);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Medicament> getAllMedicaments() {
        List<Medicament> medicaments = new ArrayList<>();
        Connection conn = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Medicaments");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Medicament medicament = new Medicament();
                medicament.setMedicamentId(rs.getInt("medicament_id"));
                medicament.setName(rs.getString("name"));
                medicament.setCategory(getCategoryById(rs.getInt("category_id")));
                medicament.setQuantity(rs.getInt("quantity"));
                medicament.setPrix(rs.getFloat("prix"));
                medicaments.add(medicament);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicaments;
    }

    @Override
    public Medicament getMedicamentById(int medicamentId) {
        Connection conn = SingletonConnection.getConnection();
        Medicament medicament = null;
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Medicaments WHERE medicament_id = ?");
            ps.setInt(1, medicamentId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                medicament = new Medicament();
                medicament.setMedicamentId(rs.getInt("medicament_id"));
                medicament.setName(rs.getString("name"));
                medicament.setCategory(getCategoryById(rs.getInt("category_id")));
                medicament.setQuantity(rs.getInt("quantity"));
                medicament.setPrix(rs.getFloat("prix"));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicament;
   }

    @Override
    public List<Medicament> searchMedicaments(String keyword) {
        List<Medicament> medicaments = new ArrayList<>();
        Connection conn = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Medicaments WHERE name LIKE ?");
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Medicament medicament = new Medicament();
                medicament.setMedicamentId(rs.getInt("medicament_id"));
                medicament.setName(rs.getString("name"));
                medicament.setCategory(getCategoryById(rs.getInt("category_id")));
                medicament.setQuantity(rs.getInt("quantity"));
                medicament.setPrix(rs.getFloat("prix"));
                medicaments.add(medicament);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicaments;
    }

    @Override
    public List<Medicament> searchMedicamentsByCategory(String category) {
        List<Medicament> medicaments = new ArrayList<>();
        Connection conn = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Medicaments WHERE category_id = ?");
            ps.setInt(1, getCategoryByName(category).getCategoryId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Medicament medicament = new Medicament();
                medicament.setMedicamentId(rs.getInt("medicament_id"));
                medicament.setName(rs.getString("name"));
                medicament.setCategory(getCategoryById(rs.getInt("category_id")));
                medicament.setQuantity(rs.getInt("quantity"));
                medicament.setPrix(rs.getFloat("prix"));
                medicaments.add(medicament);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicaments;
    }

    private Category getCategoryById(int categoryId) {
        Connection conn = SingletonConnection.getConnection();
        Category category = null;
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Categories WHERE category_id = ?");
            ps.setInt(1, categoryId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                category = new Category();
                category.setCategoryId(rs.getInt("category_id"));
                category.setName(rs.getString("name"));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    private Category getCategoryByName(String categoryName) {
        Connection conn = SingletonConnection.getConnection();
        Category category = null;
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Categories WHERE name = ?");
            ps.setString(1, categoryName);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                category = new Category();
                category.setCategoryId(rs.getInt("category_id"));
                category.setName(rs.getString("name"));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }
}
