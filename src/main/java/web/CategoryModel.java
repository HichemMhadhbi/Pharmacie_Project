package web;

import java.util.ArrayList;
import java.util.List;
import metier.entities.Category;

public class CategoryModel {
    private String keyword;
    private List<Category> categories = new ArrayList<>();

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
