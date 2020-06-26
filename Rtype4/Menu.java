import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;
/**
 * Clase Menu: esta clase es la encargada de representar en pantalla un menu
 * de elección de nivel del juego.Consiste en un JFrame que contiene un JPanel 
 * con 3 botones en su interior y cada botón tiene un listener que llama al 
 * constructor de la clase Rtype con los parametros correspondientes según el 
 * nivel seleccionado.
 * 
 * @author Oscar González Tur 
 * @version 1.0
 */
public class Menu extends JFrame 
{
    private JPanel menuNiveles;
    private JButton nivel1, nivel2, nivel3, nivel4;
    public static Rtype rtype;

    /**
     * Constructor de la clase Menu: se crea el JPanel y se le añaden los botones.
     * ajustamos los paremetros del JPanel y del JFrame. Añade el JPanel al JFrame y 
     * vuelve la ventana visible.
     * 
     */
    public Menu()
    {
        menuNiveles = new JPanel();             // creamos un JPanel.
        nivel1=new JButton();  // creamos el boton nivel1 al JPanel.
        nivel2=new JButton();  // creamos el boton nivel2 al JPanel.  
        nivel3=new JButton();  // creamos el boton nivel3 al JPanel.
        nivel4=new JButton();  // creamos el boton nivel4 al JPanel.
        setButtons();           //llamamos al metodo setButtons() que ajusta los textos y listener de los botones y los añade al JPanel.
        menuNiveles.setLayout(new GridLayout(4,1)); //ajustamos el layout del JPanel.
        setResizable(false);                    // ponemos en false el resizable del JFrame.
        setTitle("Rtype Nivel");
        setSize(new Dimension(200, 400));       // le damos la dimensión al JFrame.
        setDefaultCloseOperation(EXIT_ON_CLOSE);// ponemos por defecto que al cerrar la ventana se cierre la apliación.
        setLocationRelativeTo(null);            // ponemos la ubicación relativa del JFrame en null para que se centre en la pantalla.
        add(menuNiveles);                       // añadimos al JFrame el JPanel.
        setVisible(true);                       // hacemos el JFrame visible
    }

    /**
     * Metodo lanzarGUI ajusta el texto de los botones, añade los listeners y añade
     * los botones al menu de selección de dificultad.
     * 
     */
    private void setButtons()
    {
        nivel1.setText("FACIL");    // ajustamo el texto de los cuatro botones.
        nivel2.setText("NORMAL");
        nivel3.setText("COMPLICADO");
        nivel4.setText("IMPOSIBLE");
        // añadimos los listeners a los distintos botones y la llamada al constructor de rtype
        // con los parametros necesarios según la dificultad. Después ocultamos la ventana y eliminamos
        // el objeto menu mediante el metodo dispose().
        nivel1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                rtype = new Rtype(2,10); 
                setVisible(false); // se vuelve a la ventana del menu invisible.
                dispose();         // se elimina el objeto para que el garbage collector lo elimine.
            }
        });
        nivel2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                rtype = new Rtype(4,15);
                setVisible(false);
                dispose();
            }
        });
        nivel3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                rtype = new Rtype(6,20);
                setVisible(false);
                dispose();
            }
        });
        nivel4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                rtype = new Rtype(12,30);
                setVisible(false);
                dispose();
            }
        });
        menuNiveles.add(nivel1); // añadimos los botones al JPanel.
        menuNiveles.add(nivel2);
        menuNiveles.add(nivel3);
        menuNiveles.add(nivel4);
        
    }
    
    /*
     * Metodo main que inicia la aplicación creando el menu inicial.
     */
    public static void main(String [] args){
        Menu menu = new Menu();
    }
    
}
