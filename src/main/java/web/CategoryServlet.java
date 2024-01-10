package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDaoImpl;
import dao.ICategoryDao;
import metier.entities.Category;
import web.CategoryModel;

@WebServlet(name = "categoryServlet", urlPatterns = { "/categories" })
public class CategoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ICategoryDao categoryDao;

    @Override
    public void init() throws ServletException {
        categoryDao = new CategoryDaoImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	List<Category> categories = categoryDao.getAllCategories();
    	request.setAttribute("categories", categories);
        request.getRequestDispatcher("categories.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        Category category = new Category(name);
        categoryDao.save(category);
        response.sendRedirect("categories.jsp");
    }
}
