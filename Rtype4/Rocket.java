
import javax.swing.ImageIcon;
/**
 * Write a description of class Rocket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rocket extends Ufo
{
    /**
     * Constructor for objects of class Rocket
     * @param int x, int y se le pasan los parametros x e y 
     * de las coordenadas donde se creará.
     */
    public Rocket(int x, int y)
    {
        super();
        ufo = "rocket";
        imageResource(ufo);
        this.x = x;
        this.y = y;
    }

    @Override
    public void move()
    {
        if(this.x>Rtype.WIDTH_SCREEN){
            this.activo=false;
        } else {
        x+=Rtype.ROCKETSPEED;
        }
    }
}
