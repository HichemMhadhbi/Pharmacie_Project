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
	import dao.IMedicamentDao;
import dao.IUserDao;
import dao.IUserImpl;
import dao.MedicamentDaoImpl;
	import metier.entities.Category;
	import metier.entities.Medicament;
	import web.MedicamentModel;

	@WebServlet(name = "cs", urlPatterns = { "/controleur", "*.do" })
	public class ControleurServlet extends HttpServlet {
	    private static final long serialVersionUID = 1L;
	    private IMedicamentDao medicamentDao;
	    private ICategoryDao categoryDao;
	    private IUserDao userDao;

	    @Override
	    public void init() throws ServletException {
	        medicamentDao = new MedicamentDaoImpl();
	        categoryDao = new CategoryDaoImpl();
	        userDao = new IUserImpl();
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        String path = request.getServletPath();
	        if (path.equals("/index.do")) {
	            List<Medicament> medicaments = medicamentDao.getAllMedicaments();
	            request.setAttribute("medicaments", medicaments);
	            request.getRequestDispatcher("medicaments.jsp").forward(request, response);
	        } else if (path.equals("/chercher.do")) {
	            String keyword = request.getParameter("keyword");
	            List<Medicament> medicaments = medicamentDao.searchMedicaments(keyword);
	            MedicamentModel model = new MedicamentModel();
	            model.setKeyword(keyword);
	            model.setMedicaments(medicaments);
	            request.setAttribute("medicamentModel", model);
	            request.getRequestDispatcher("medicaments.jsp").forward(request, response);
	        } else if (path.equals("/saisie.do")) {
	        	List<Category> categories = categoryDao.getAllCategories();
	        	CategoryModel categoryModel = new CategoryModel();
	        	categoryModel.setCategories(categories);
	        	request.setAttribute("categoryModel", categoryModel);
	            request.getRequestDispatcher("saisieMedicament.jsp").forward(request, response);
	        } else if (path.equals("/save.do") && request.getMethod().equals("POST")) {
	            String name = request.getParameter("name");
	            int categoryId = Integer.parseInt(request.getParameter("category"));
	            Category category = categoryDao.getCategoryById(categoryId);
	            int quantity = Integer.parseInt(request.getParameter("quantity"));
	            double prix = Double.parseDouble(request.getParameter("prix"));

	            Medicament medicament = new Medicament(name, category, quantity, prix);
	            medicamentDao.save(medicament);
	            response.sendRedirect("index.do");
	        } else if (path.equals("/supprimer.do")) {
	            int medicamentId = Integer.parseInt(request.getParameter("id"));
	            medicamentDao.delete(medicamentId);
	            response.sendRedirect("index.do");
	        } else if (path.equals("/editer.do")) {
	            int medicamentId = Integer.parseInt(request.getParameter("id"));
	            Medicament medicament = medicamentDao.getMedicamentById(medicamentId);
	            List<Category> categories = categoryDao.getAllCategories();
	        	CategoryModel categoryModel = new CategoryModel();
	        	categoryModel.setCategories(categories);
	        	request.setAttribute("categoryModel", categoryModel);

	            request.setAttribute("medicament", medicament);
	            request.getRequestDispatcher("editerMedicament.jsp").forward(request, response);
	        } else if (path.equals("/update.do")) {
	            int medicamentId = Integer.parseInt(request.getParameter("id"));
	            String name = request.getParameter("name");
	            int categoryId = Integer.parseInt(request.getParameter("category"));
	            Category category = categoryDao.getCategoryById(categoryId);
	            int quantity = Integer.parseInt(request.getParameter("quantity"));
	            double prix = Double.parseDouble(request.getParameter("prix"));

	            Medicament medicament = new Medicament();
	            medicament.setMedicamentId(medicamentId);
	            medicament.setName(name);
	            medicament.setCategory(category);
	            medicament.setQuantity(quantity);
	            medicament.setPrix(prix);

	            medicamentDao.update(medicament);
	            response.sendRedirect("index.do");
	        }else if (path.equals("/login.do")) {
	            String username = request.getParameter("username");
	            String password = request.getParameter("password");
	            // Validate user credentials
	            boolean isValidCredentials = userDao.checkCredentials(username, password);
	            if (isValidCredentials) {
	                // Redirect to a success page or perform any desired action
	                response.sendRedirect("medicaments.jsp");
	            } else {
	                // Redirect back to the login page with an error message
	                request.setAttribute("errorMessage", "Invalid credentials. Please try again.");
	                request.getRequestDispatcher("login.jsp").forward(request, response);
	            }
	        } 
	        else if (path.equals("/register.do")) {
	            String username = request.getParameter("username");
	            String password = request.getParameter("password");
	            // Insert new user into the database
	            userDao.insertUser(username, password);
	            // Redirect to a success page or perform any desired action
	            response.sendRedirect("login.jsp");
	        }
	        else if (path.equals("/logout.do")) {
	            // Invalidate the session and redirect to the login page
	            request.getSession().invalidate();
	            response.sendRedirect("login.jsp");
	        }    else {
	            response.sendError(HttpServletResponse.SC_NOT_FOUND);
	        }
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        doGet(request, response);
	    }
	}

