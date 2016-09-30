public class Animal extends Zoological {
	public static final boolean DATABASE_TYPE = false;

	public Animal (String name) {
		this.name = name;
		this.type = DATABASE_TYPE;
	}
}