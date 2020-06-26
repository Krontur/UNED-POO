import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
/**
 * La clase Craft hereda de la clase abstracta Ufo.
 * 
 * @author Oscar González Tur
 * @version 1.0
 */
public class Craft extends Ufo
{
    private ArrayList<Ufo> rockets;   //ArrayList que contiene los misiles disparados por la nave.

    /**
     * Constructor de los objetos de la clase Craft.
     * Llama al constructor de la clase padre Ufo e inicializa las variables
     * del objeto craft.
     */
    public Craft()
    {
        super();
        ufo = "craft"; // se inicializa la variable ufo con el nombre de la clase del objeto.
        imageResource(ufo); // se carga la imagen que dibujará el metodo paint para este objeto.
        this.x=20; // se inicializa la coordenada x de la nave en el centro de la pantalla.
        this.y = Rtype.HEIGHT_SCREEN / 2; //se inicializa la coordenada y de la nave en el centro de la pantalla.
        rockets = new ArrayList<Ufo>(); // se crea el arraylist que contiene los misiles disparados.
        width=im.getIconWidth(); //se inicializa el ancho de la nave tomando el ancho de la imagen del objeto.
        height=im.getIconHeight(); // se inicializa el alto de la nave tomando el  alto de la imagen del objeto.
    }

    /**
     * Metodo move: este metodo varia la posición en x e y  del objeto craft
     * según las pulsaciones del teclado y dentro de los rangos permitidos por 
     * el tamaño de la pantalla. Esto ultimo se consigue gracias al metodo clamp.
     */
    @Override
    public void move()
    {
        x = clamp(x+dx, 0, Rtype.WIDTH_SCREEN - width);
        y = clamp(y+dy, 0, Rtype.HEIGHT_SCREEN - height);        
    }
    
    /**
     * Metodo shoot: este metodo crea un nuevo objeto rocket y lo añade al arraylist
     * rockets del objeto craft.
     */
    public void shoot()
    {
        Ufo rocket = new Rocket(getX()+width,getY()+height/2);
        rockets.add(rocket);
    }
    
    /**
     * Metodo keyPressed: este metodo modifica las variables del objeto craft
     * según las teclas pulsadas de teclado que recibe del TAdapter de la clase Vista.
     * @param KeyEvent e
     */
    public void keyPressed ( KeyEvent e)
    {
        int key = e.getKeyCode();
        
        if(key==KeyEvent.VK_Q){
            this.dy = -Rtype.CRAFTSPEED;
        }else 
        if(key==KeyEvent.VK_A){
                this.dy = Rtype.CRAFTSPEED;
        }else
        if(key==KeyEvent.VK_O){
                this.dx=-Rtype.CRAFTSPEED;
        }else
        if(key==KeyEvent.VK_P){
                this.dx=Rtype.CRAFTSPEED;
        }else
        if(key==KeyEvent.VK_SPACE){
            shoot();
        }
    }
    
    /**
     * Metodo keyReleased: este metodo modifica las variables del objeto craft
     * según las teclas soltadas de teclado que recibe del TAdapter de la clase Vista.
     * @param KeyEvent e
     */
    public void keyReleased (KeyEvent e)
    {
        int key = e.getKeyCode();
        
        if(key==KeyEvent.VK_Q){
            dy = 0;
        }else 
        if(key==KeyEvent.VK_A){
            dy =0;
        }else
        if(key==KeyEvent.VK_O){
            dx=0;
        }else
        if(key==KeyEvent.VK_P){
            dx=0;
        }
    }
    
    /**
     * Metodo getRockets: metodo que nos devuelve el arraylist de los
     * misiles que ha disparado el objeto craft.
     * @return ArrayList<Ufo> rockets.
     */
    public ArrayList<Ufo> getRockets(){
        return rockets;
    }
    
    /**
     * Metodo privado clamp: este metodo de soporte de la clase craft se utiliza como limite
     * para el desplazamiento del objeto craft dentro del JPanel y evitar así que se salga
     * de la pantalla
     * @param int valor, int min, int max valor: valor que queremos introducir, max: valor máximo 
     * posible, min: valor mínimo posible
     * @return int valor devuelve el valor dentro del rango permitido.
     */
    private int clamp(int valor, int min, int max) {
    if (valor > max)
        return max;
    if (valor < min)
        return min;
    return valor;
    }
}
