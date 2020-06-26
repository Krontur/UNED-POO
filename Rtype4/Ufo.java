import java.awt.Image;
import javax.swing.ImageIcon;
import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * La clase Ufo es abstracta y en ella guardaremos los atributos y metodos
 * comunes a todos sus hijos.
 * 
 * @author Oscar González Tur
 * @version 1.0
 */
public abstract class Ufo
{    
    protected int x;  //coordenada x del objeto
    protected int y;  // coordenada y del objeto
    protected int dx; // desplazamiento del objeto en eje x(velocidad: número de pixeles que avanza por golpe de timer)
    protected int dy; // desplazamiento del objeto en eje y(velocidad: número de pixeles que avanza por golpe de timer)
    protected int width; //ancho del objeto
    protected int height; //alto del objeto
    protected int rnd;//variable random usada en algunos metodos.
    protected Image image;//imagen del objeto
    protected ImageIcon im;
    protected String ufo;//string del nombre del archivo que contiene la imagen.
    
    protected boolean activo;  //estado del objeto en el jego.
    
    protected HashMap<String,String> pictures;//lista clave , valor con los nombres de los archivos 
                                              // de las imagenes de cada objeto.

    /**
     * Constructor de la clase Ufo, inicia el objeto como activo y carga la lista 
     * de las imagenes disponibles para sus hijos.
     */
    public Ufo()
    {      
        activo=true;
        
        pictures = new HashMap<String,String>();
        pictures.put("craft", "nave.png");
        pictures.put("alien1", "alien1p.png");
        pictures.put("alien2", "alien2p.png");
        pictures.put("rocket", "misil.png");
                                
    }

    /**
     *Metodo abstracto move: este metodo modifica la posición en x e y del objeto. 
     */
    protected abstract void move();
    
    /**
     * Metodo imageResource: este metodo carga la imagen del objeto de la lista
     * de imagenes disponibles.
     * @param String ufo cada hijo le pasará un string con la clave para el hashmap.
     */
    protected void imageResource(String ufo)
    {        
        im = new ImageIcon(getClass().getResource(pictures.get(ufo)));
        image = im.getImage();
    }
    
    /**
     * getx nos devuelve la coordenada x del objeto
     * @return int x
     */
    protected int getX(){
        return x;
    }
    
    /**
     * getY nos devuelve la coordenada y del objeto
     * @return int y
     */
    protected int getY(){
        return y;
    }
    
    /**
     * getActivo nos devuelve un valor booleano según sea el estado del objeto.
     * @return boolean activo.
     */
    protected boolean getActivo(){
        return activo;
    }
     
    /**
     * setActivo nos deja asignar un estado true o false sobre la variable
     * activo de cada objeto ufo.
     * @param boolean z. Les pasamos true o false, según queramos marcar como activo 
     * o no activo.
     */
    protected void setActivo(boolean z){
        activo=z;
    }
    
    /**
     * getImage nos devuelve la imagen del objeto ufo.
     * @return Image image.
     */
    protected Image getImage(){
        return image;
    }      
    
}
