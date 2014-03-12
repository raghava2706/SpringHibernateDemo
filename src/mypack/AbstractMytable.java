package mypack;

import java.math.BigDecimal;

/**
 * AbstractMytable entity provides the base persistence definition of the
 * Mytable entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractMytable implements java.io.Serializable {

	// Fields

	private int sno;
	private String name;
	private String location;
	private String email;

	// Constructors

	/** default constructor */
	public AbstractMytable() {
	}

	/** full constructor */
	public AbstractMytable(String name, String location, String email) {
		this.name = name;
		this.location = location;
		this.email = email;
	}

	// Property accessors

	public int getSno() {
		return this.sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}