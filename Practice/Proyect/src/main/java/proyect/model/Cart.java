package proyect.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {

	@Id
	@GeneratedValue
	private long id;
	private Timestamp creation_date;
	private BigDecimal total;
	@ManyToOne
	@JoinColumn(name = "fk_user")
	private User user;

	@OneToMany(mappedBy = "cart")
	private List<LineItem> lines;

	private boolean closed;

	public Cart() {
		super();
	}

	public Cart(User user) {
		super();
		this.creation_date = Timestamp.from(Instant.now());
		this.total = BigDecimal.valueOf(0);
		this.user = user;
		this.closed = false;
	}

	public Timestamp getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Timestamp creation_date) {
		this.creation_date = creation_date;
	}

	public BigDecimal getTotal() {
		for (LineItem line : lines) {
			BigDecimal price = line.getItem().getPrice();
			BigDecimal qty = new BigDecimal(line.getQuantity());
			total = total.add(price.multiply(qty));
		}
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public boolean isClosed() {
		return closed;
	}

	public void setClosed(boolean closed) {
		this.closed = closed;
	}

	public List<LineItem> getLines() {
		return lines;
	}

	public void addAllLines(List<LineItem> lines) {
		this.lines = lines;
	}

	public void addLine(LineItem line) {
		this.lines.add(line);
	}

	public LineItem getLineByItemId(long itemId) {
		for (LineItem line : lines) {
			if (line.getItem().getId() == itemId) {
				return line;
			}
		}
		return null;
	}

}
