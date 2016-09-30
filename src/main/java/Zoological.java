public abstract class Zoological {
  protected int id;
  protected String name;
  protected boolean type;

  public String getName() {
    return name;
  }

  public int getId() {
	return id;
  }

  public boolean getType() {
    return type;
  }

  @Override
  public boolean equals(Object otherZoological) {
    if (!(otherZoological instanceof Zoological)) {
      return false;
    } else {
      Zoological newZoological = (Zoological) otherZoological;
      return this.getName().equals(newZoological.getName()) &&
             this.getType() == newZoological.getType();
    }
  }
}