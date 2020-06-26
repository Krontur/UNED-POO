import javax.swing.*;
import java.awt.event.*;
import javax.swing.Timer;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
/**
 * La clase Vista es un JPanel que estará contenido en el JFrame principal de la clase Rtype.
 * 
 * 
 * @author Oscar González Tur
 * @version 1.0
 */
public class Vista extends JPanel implements ActionListener
{
    public Timer timer;
    private Controller controller;

    /**
     * Constructor de la clase Vista. 
     * Añade un keylistener.
     * Ajusta las preferencias del JPanel
     * Crea una nave(craft)
     * Crea un timer y lo inicia con un delay de 5ms.
     */
    public Vista()
    {
        //ajustamos las preferencias del JPanel
        setFocusable(true);
        setBackground(Color.black);
        setDoubleBuffered(true);
        setVisible(true);
        
        addKeyListener (new TAdapter());
        controller = new Controller();
        controller.aliensAdd = 0;
        timer = new Timer(5, this);
        timer.start();
     }      
    
    /**
     * El metodo paint pinta todos los objetos activos que hay en pantalla.
     * 
     * @param  Graphics g
     */
    public void paint(Graphics g)
    {
        super.paint(g);        
        Graphics2D g2d = (Graphics2D)g;
        drawUfo(g2d,controller.craft);        
               
        ArrayList<Ufo> ro = controller.craft.getRockets(); //toma los misiles actuales de la nave
        //Este "for" recorre un array y dibuja en el JPanel todos los objetos contenidos en el.
        for(Ufo rocket: ro){
            drawUfo(g2d,rocket);
        }               
        //Este for recorre un array y dibuja en el JPanel todos los objetos contenidos en el.
        for (Ufo alien: controller.getAliens()){
            drawUfo(g2d, alien);
        }        
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }    
    
    /**
     * metodo actionPerformed ejecutará los metodos necesarios cada vez que el timer avanza.
     */
    public void actionPerformed(ActionEvent e)
    {
        ArrayList<Ufo> ro = controller.craft.getRockets();
        
        //Este "for" comprueba la colision entre el array de misiles y el array de aliens
        for(Ufo rocket: ro){
            controller.checkColision(rocket,controller.getAliens());
        }
        
        controller.checkColision(controller.craft, controller.getAliens()); // este metodo comprueba la colision entre la nave 
                                      //y el array  de aliens.
                
        if(controller.aliensAdd < Rtype.numAliens){ //añade aliens mientras no se hayan añadido todos.
            controller.addAlien();            
        }
        
        controller.action(ro); //actualiza el estado de los misiles del arraylist.
        controller.action(controller.getAliens()); // actualiza el estado de los aliens del arraylist.
        controller.craft.move(); // actualiza el estado de la nave en la pantalla.
        if(controller.finDelJuego()) // comprueba si el estado actual del juego es el final del mismo.
        {
            timer.stop();  
            finalWindow(Rtype.mensajeFinal);
        }
        repaint(); 
    }
            
    /**
     * Metodo drawUfo: Este metodo dibuja en el JPanel la imagen del objeto ufo 
     * que le pasemos como segundo parametro.
     * @param Graphics2D g2, Ufo ufo
     */
    private void drawUfo(Graphics2D g2,Ufo ufo){        
        g2.drawImage(ufo.getImage(),ufo.getX(), ufo.getY(),this);
    }
    
    private void finalWindow(String msg)
    {
        int victory= JOptionPane.showConfirmDialog(this, msg + "¿Quieres volver a jugar?","Fin del Juego", JOptionPane.YES_NO_OPTION);
        switch(victory){
            case 0:
            Menu.rtype.setVisible(false);
            Menu.rtype.dispose();
            Menu menu = new Menu();
            break;
            case 1:
            System.exit(0);
            break;
        }
    }
    
    /**
     * La clase TAdapter es una clase privada de soporte que hereda de KeyAdapter.
     * Su función es recibir las pulsaciones de teclas y según si la tecla es pulsada o soltada
     * ejecuta el metodo pertinente.
     */
    private class TAdapter extends KeyAdapter
    {
        public void keyPressed(KeyEvent e){ //Llama al metodo publico keyPressed de la clase craft.
            controller.craft.keyPressed(e);
        }
        
        public void keyReleased(KeyEvent e){ //Lama al metodo publico keyReleased de la clase craft.
            controller.craft.keyReleased(e);
        }
    }
    
    /**
     * Metodo Sobreescrito getPreferredSize: Se sobreescribe este metodo para
     * que el tamaño del JPanel sea el especificado en las constantes WIDTH_SCREEN
     * y HEIGHT_SCREEN.
     */
    @Override
    public Dimension getPreferredSize(){
        Dimension dimension = new Dimension(Rtype.WIDTH_SCREEN,Rtype.HEIGHT_SCREEN);
        return dimension;
    }    
}
