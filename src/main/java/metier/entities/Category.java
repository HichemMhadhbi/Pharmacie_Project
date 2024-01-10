package metier.entities;

import java.io.Serializable;

public class Category implements Serializable {
	 	private int categoryId;
	    private String name;
		public int getCategoryId() {
			return categoryId;
		}
		public void setCategoryId(int categoryId) {
			this.categoryId = categoryId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		@Override
		public String toString() {
			return "Category [categoryId=" + categoryId + ", name=" + name + "]";
		}
		public Category() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Category(String name) {
			super();
			this.name = name;
		}
	    
	    
}
