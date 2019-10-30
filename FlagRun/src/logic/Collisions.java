package logic;
package math;
public class Collisions {

  public integer X_1,Y_1; // colision
  public const Thresold;
    
   public Collision(x1,y1)
  {
     
     this.X_1 =x1;
     this.Y_1 =y1;
    
  }
    
  //1 means there is collision with a predefined object
  public bool detect_collision( int x, int y)
  {
    if (sqrt(abs(x-x1)+abs(y-y1))<Thresold)
    {
      return 1;
    }
    return 0;
    
  }
  
}
