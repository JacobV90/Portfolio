package forestfires;


public class FFTree {

  // You choose which fields to use. They must be private.

  // Constructor. It takes in coordinates x and y.
  public FFTree(int x, int y)

  // Returns the x-coordinate of the tree.
  public int getX()

  // Returns the y-coordinate of the tree.
  public int getY()

  // Computes the Euclidean distance (norm 2) between this
  // tree and the other tree
  public double distanceTo(FFTree other)

  // Sets the tree on fire. Has an effect only if the tree is
  // healthy.
  public void setFire()

  // True if and only if the tree is currently on fire.
  public boolean isBurning()

  // True if and only if the fire consumed the tree.
  public boolean isBurnt()

  // Advances one day for the tree.
  public void newDay()

  // Additional methods (if you happen to need them) are to be
  // left private.

}
