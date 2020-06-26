import java.util.Random;
import javax.swing.ImageIcon;
/**
 * Clase abstracta que hereda de la clase abstracta Ufo.
 * 
 * @author Oscar González Tur 
 * @version 1.0
 */
public class Alien extends Ufo
{
    private boolean typeAlien;
    /**
     * Constructor de la clase Alien
     * Invoca el constructor de su clase padre Ufo 
     * e inicia las variables x y dx.
     */
    public Alien(boolean type)
    {
        super();
        typeAlien = type;
        x = Rtype.WIDTH_SCREEN;
        this.dx=Rtype.alienSpeed;
        if(type==true)
        {
            ufo = "alien1";
        } else {
            ufo = "alien2";
            dy = Rtype.alienSpeed;
        }
        imageResource(ufo);
        rnd = new Random().nextInt(Rtype.HEIGHT_SCREEN-(im.getIconHeight()+50));
        y = rnd;
        width = im.getIconWidth();
        height = im.getIconHeight();
    }

    /**
     * Metodo move sobreescrito: este metodo modifica la coordenada x del 
     * objeto alien según su posición y su valor de desplazamiento.
     */
    @Override
    public void move()
    {
      if(typeAlien==true)
      {
        if(x<-width){
            x=Rtype.WIDTH_SCREEN;
        }else {
        x-=dx;
        }
      } else {
        if((this.y<=0) || (this.y>Rtype.HEIGHT_SCREEN-height)){
            this.dy=-dy;
        } else {
          int rd = new Random().nextInt(100);
          if(rd<2){
            dy = -dy;
          }
       }
       if(this.x<-width){
         this.x=Rtype.WIDTH_SCREEN;
         }else {
         this.x-=dx;
         this.y+=dy;
         }
        
      }
    }
}
