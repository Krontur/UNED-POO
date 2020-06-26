import javax.swing.JFrame; 
import java.awt.Color;
import java.awt.*;
import java.awt.Toolkit;
/**
 * La clase Rtype es el JFrame principal del juego.
 * Contiene las variables generales del juego.
 * En el se muestra la pantalla del juego.
 * 
 * @author (Oscar González Tur) 
 */
public class Rtype extends JFrame 
{
    public static final int HEIGHT_SCREEN= 600;  // constante de la altura de la ventana
    public static final int WIDTH_SCREEN = 800;  // constante del ancho de la ventana
    public static final int ROCKETSPEED=6;       //constante de la velocidad de desplazamiento de la nave(craft)
    public static final int CRAFTSPEED=5;        // constante de la velocidad de desplazmiento del misisl (rocket)
    public static int alienSpeed;                //variable de la velocidad de desplazamiento del alien,varía según la dificulad
    public static int numAliens;                 //variable del número de aliens, varía según la dificultad
    public static String mensajeFinal;
    public static Vista vista;
    private Dimension pantalla;                  //variable de tipo Dimension con el tamaño de la pantalla principal del juego.
        
    /**
     * Constructor de la clase Rtype
     * centra la ventana en la pantalla, crea la ventana e inicializa
     * las variables alienSpeed y numAliens según los parametros introducidos.
     * 
     * @param introducimos como parametros la velocidad de la nave alien 
     *  y el número de aliens que aparecerán según la dificultad seleccionada.
     */
    public Rtype(int alienSpeed,int  numAliens)
    {
       vista = new Vista();
       makeFrame();  
       centerScreen();
       this.alienSpeed=alienSpeed;
       this.numAliens=numAliens;       
    }   
    
    /**
     * Metodo centerScreen() calcula el centro de la pantalla  y centra el JFrame.
     */
    private void centerScreen(){
        pantalla = Toolkit.getDefaultToolkit().getScreenSize();
       int height = (int) pantalla.getHeight()-HEIGHT_SCREEN;
       int width = (int) pantalla.getWidth()-WIDTH_SCREEN;
       this.setLocation(width/2,height/2);
    }
    
    /**
     * Metodo makeFrame() crea el frame de la pantalla principal del juego
     * y añade el JPanel.
     */    
    private void makeFrame(){
       this.setLayout(new BorderLayout());
       this.getContentPane().add(vista, BorderLayout.CENTER);
       this.setTitle("R-Type");
       this.setResizable(false);
       this.setDefaultCloseOperation(EXIT_ON_CLOSE);
       this.pack();
       this.setVisible(true);
    }
    
     
}
