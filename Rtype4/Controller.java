import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
/**
 * Write a description of class Controlador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Controller
{
    public Craft craft;   // variable del objeto nave.
    public int aliensAdd; //variable de cantidad de aliens añadidos.
    private ArrayList<Ufo> aliens; //ArrayList donde se guardan los aliens añadidos.
    
    /**
     * Constructor de la clase Controlador: crea el array de aliens y una nave e inicializa la variable aliensAdd a 0.
     */
    public Controller()
    {
        aliens = new ArrayList<Ufo>();        
        aliensAdd = 0;
        craft = new Craft();        
    }

    /**
     * Metodo addAlien: Este metodo es el encargado de ir creando naves alienigenas de 
     * forma aleatoria.
     */
    public void addAlien(){
      int rd;
      rd = new Random().nextInt(1000); // creamos de forma aleatoria un numero entero. 
       if(rd<3){                       // según el número que salga se creará una nave A, nave B o ninguna.
         aliens.add(new Alien(false));
         aliensAdd++;
         } else if(rd>985) {
           aliens.add(new Alien(true));
           aliensAdd++;
        } 
    }
    
    /**
     * Metodo colision: Este metodo comprueba que dos objetos de la superclase Ufo no han colisionado.
     *      Lo que hace el metodo es crear un rectangulo a partir de la imagen de los objetos y comprobar
     *      si interesectan alguno de sus lados.
     * @param Ufo al1, Ufo al2
     */
    public void colision(Ufo al1, Ufo al2){
        Rectangle r1 = new Rectangle( al1.getX(), al1.getY(), al1.getImage().getWidth(null), al1.getImage().getHeight(null));
        Rectangle r2 = new Rectangle( al2.getX(), al2.getY(), al2.getImage().getWidth(null), al2.getImage().getHeight(null));
        if(r1.intersects(r2)){
            al1.setActivo(false); // si se interesectan los marcamos como no activos a los dos.
            al2.setActivo(false);
        }
    }
    
    /**
     * Metodo checkColision: Este metodo utiliza el metodo colision para comprobar si hay
     * hay una colisión entre un objeto ufo y una arraylist de objetos ufo.
     * 
     * @param Ufo ufo, ArrayList<Ufo> ufo2
     */
    public void checkColision(Ufo ufo1, ArrayList<Ufo> ufo2){        
        for(Ufo ufo:ufo2){
            colision(ufo1,ufo);
        }
    }  
    
    /**
     * Metodo action: este metodo comprueba todos los objetos de un arraylist y según
     * su estado o los elimina del array o hace que se muevan.
     * @param ArrayList<Ufo> ufos
     */    
    public void action(ArrayList<Ufo> ufos){
        for(int i=0; i<ufos.size(); i++){
            Ufo ufo = (Ufo) ufos.get(i);
            if(ufo.getActivo()){
                ufo.move(); //cambia la posición del objeto ufo.
            }else {
                ufos.remove(i); // si el estado es no activo elimina el objeto del array.
            }
        }
    } 
        
    /**
     * Metodo finDelJuego: Este metodo evalua si el juego a terminado, y según el final del juego
     * ( si han perdido o ganado ) guarda el mensaje que se mostrará en la ventana final a elegir 
     * y devuelve
     * 
     * @return boolean
     */    
    public boolean finDelJuego(){
            if(craft.activo==true && aliens.size()==0 && aliensAdd== Rtype.numAliens)
            {
                Rtype.mensajeFinal= " ¡¡ENHORABUENA, HAS GANADO!! ";
                return true;
            } else if(craft.activo==false){
                Rtype.mensajeFinal= " HAS PERDIDO ";
                return true;
            }else {
                return false;
            }
    }   
        
    public ArrayList<Ufo> getAliens()
    {
        return aliens;
    }
}
