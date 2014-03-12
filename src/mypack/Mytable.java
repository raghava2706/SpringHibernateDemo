package mypack;

/**
 * Mytable entity. @author MyEclipse Persistence Tools
 */
public class Mytable extends AbstractMytable implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Mytable() {
	}

	/** full constructor */
	public Mytable(String name, String location, String email) {
		super(name, location, email);
	}

}
