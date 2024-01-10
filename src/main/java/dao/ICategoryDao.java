package dao;

import java.util.List;
import metier.entities.Category;

public interface ICategoryDao {
    public Category save(Category category);
    public Category update(Category category);
    public void delete(int categoryId);
    public List<Category> getAllCategories();
    public Category getCategoryById(int categoryId);
}
