package forestfires;


public class FFCustomSimulator extends FFSimulator{
  
  // The fields are up to you. They must be left private.

  // Constructor. It does the same as FFSimulator(x,y).
  public FFCustomSimulator(int x, int y)

  // Constructor. It works the same as FFSimulator(500,2).
  public FFCustomSimulator()

  // Constructor. Uses the provided array instead of its own.
  public FFCustomSimulator(FFTree[] aforest)

  // Sets the animation speed. The parameter states how many
  // seconds uses a day in the simulation. The original speed
  // is 0.1 seconds per day.
  // Hint: there is a field in FFSimulator that you can use here.
  public void setFrameSpeed(double seconds)

  // Sets the distance for the spread of fire. Initially, the
  // distance is set to 20 pixels (method spreadFire).
  public void setSpreadDistance(int pixels)
  
  // You make need to override methods from FFCustomSimulator
  
}
