package metier.entities;

import java.io.Serializable;

public class Medicament implements Serializable {
	 	private int medicamentId;
	    private String name;
	    private Category category;
	    private int quantity;
	    private double prix;
		public int getMedicamentId() {
			return medicamentId;
		}
		public void setMedicamentId(int medicamentId) {
			this.medicamentId = medicamentId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Category getCategory() {
			return category;
		}
		public void setCategory(Category category) {
			this.category = category;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public double getPrix() {
			return prix;
		}
		public void setPrix(double prix) {
			this.prix = prix;
		}
		@Override
		public String toString() {
			return "Medicament [medicamentId=" + medicamentId + ", name=" + name + ", quantity=" + quantity + ", prix="
					+ prix + "]";
		}
		public Medicament() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Medicament(String name, Category category, int quantity, double prix) {
			super();
			this.name = name;
			this.category = category;
			this.quantity = quantity;
			this.prix = prix;
		}
	    
}
