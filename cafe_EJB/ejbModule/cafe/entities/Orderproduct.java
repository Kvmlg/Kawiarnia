package cafe.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the orderproducts database table.
 * 
 */
@Entity
@Table(name="orderproducts")
@NamedQuery(name="Orderproduct.findAll", query="SELECT o FROM Orderproduct o")
public class Orderproduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrderproductPK id;

	private String quantity;

	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="orders_id", insertable=false, updatable=false)
	private Order order;

	//bi-directional many-to-one association to Product
	@ManyToOne
	
	@JoinColumn(name="products_id", insertable=false, updatable=false)
	private Product product;
	

	public Orderproduct() {
	}

	public OrderproductPK getId() {
		return this.id;
	}

	public void setId(OrderproductPK id) {
		this.id = id;
	}

	public String getQuantity() {
		return this.quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}