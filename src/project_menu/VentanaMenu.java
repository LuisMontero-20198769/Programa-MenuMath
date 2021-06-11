
package project_menu;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class VentanaMenu implements ActionListener{
    //Atibutos de la clase
    JFrame ventana;
    JPanel jpanel;
    JLabel fondo;
    JMenu sumar, restar, multip,Ssumar,Srestar,Smultip;
    JMenuItem sub1,sub2,sub3,sub4,sub5,sub6;
    JMenuBar menubar; 
    
    //Metodo creador del menu
    public void crearMenu(){
       menubar = new JMenuBar();
       //MENUS
       sumar = new JMenu("Calcular 1");
       multip = new JMenu("Calcular 2");
       restar = new JMenu("Calcular 3");
       //SUB-MENUS
       Ssumar = new JMenu("Sumar");
       Smultip = new JMenu("Multiplicar");
       Srestar = new JMenu("Restar");
       //SUMAS, OPERACIONES
       sub1 = new JMenuItem("DOS NUMEROS");
       sub2 = new JMenuItem("TRES NUMEROS");
       //MULTIPLICACION, OPERACIONES.
       sub3 = new JMenuItem("DOS NUMERO");
       sub4 = new JMenuItem("TRES NUMEROS");
       //RESTAR, OPERACIONES
       sub5 = new JMenuItem("DOS NUMEROS POSITIVOS(+)");
       sub6 = new JMenuItem("DOS NUMEROS NEGATIVOS(-)");
       //AGREGAMOS LAS OPERACIONES AL SUB-MENU
       sumar.add(Ssumar);
       restar.add(Srestar);
       multip.add(Smultip);
        //SUMAS
        Ssumar.add(sub1);
        Ssumar.add(sub2);
        //MULTIPLICACION
        Smultip.add(sub3);
        Smultip.add(sub4);
        //RESTA
        Srestar.add(sub5); 
        Srestar.add(sub6);
       
       Ssumar.addActionListener(this);
       Smultip.addActionListener(this);
       Srestar.addActionListener(this);
       
       sub1.addActionListener(this);
       sub2.addActionListener(this);
       sub3.addActionListener(this);
       sub4.addActionListener(this);
       sub5.addActionListener(this);
       sub6.addActionListener(this);
       
       
       menubar.add(sumar);
       menubar.add(multip);
       menubar.add(restar);
       
    }
    public void crearVentana(){
       ventana = new JFrame("Menú Calculadora");
  
       ventana.setSize(400,400); //Este será el tamaño de la ventana
       //Posición iniciar de la ventana
       ventana.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/calcularIcon.jpg")).getImage());
       ventana.setLocationRelativeTo(null);//Centralización de ventana en la pantalla
       ventana.setVisible(true);
       //Componentes();//Aqui se llama al metodo de los componentes de la ventana
       ventana.setLayout(new BoxLayout(ventana.getContentPane(), BoxLayout.Y_AXIS));
       ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);//Aquí cumple la función de cerrar mi ventana
       ventana.setJMenuBar(menubar);
        ventana.getContentPane().add(jpanel); //Agregacion del jpanel a la ventana  
       //crearMenu();//agragmos el metodo a la ventana
    }
    //Metodo Principal
    public void Componentes(){
       crearPanel();//Agregamos al constructor de componentes; el constructor del panelA
     
    }
    public void crearPanel(){
        jpanel = new JPanel();//instanciamiento del jpanel
        jpanel.setLayout(null);//Posicion por defecto de la etiqueta desactivada
        //Agregamos un borde interno a nuestro panelA
        
        jpanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED),"",
         TitledBorder.RIGHT,TitledBorder.DEFAULT_POSITION));
         //fila 1
       Vector <String> fila1 = new Vector <String>();
        fila1.addElement("Sumar dos números");
        fila1.addElement(Funciones.Total+"");
        //fila 2
        Vector <String> fila2 = new Vector <String>();
        fila2.addElement("Sumar tres números");
        fila2.addElement(Funciones.total2+"");
        //fila 3
        Vector <String> fila3 = new Vector <String>();
        fila3.addElement("Multiplicar dos números");
        fila3.addElement(Funciones.total3+"");
        //fila 4
        Vector <String> fila4 = new Vector <String>();
        fila4.addElement("Multiplicar tres números");
        fila4.addElement(Funciones.total4+"");
        //fila 5
        Vector <String> fila5 = new Vector <String>();
        fila5.addElement("Restar dos números positivos");
        fila5.addElement(Funciones.total5+"");
        //fila 6
        Vector <String> fila6 = new Vector <String>();
        fila6.addElement("Restar dos números negativos");
        fila6.addElement(Funciones.total6+"");
        //total de las filas
         Vector <Vector> TotalFil = new Vector <Vector>();
        TotalFil.addElement(fila1);
        TotalFil.addElement(fila2);
        TotalFil.addElement(fila3);
        TotalFil.addElement(fila4);
        TotalFil.addElement(fila5);
        TotalFil.addElement(fila6);
        //--Columnas 
         Vector <String> colm = new Vector <String>();
        colm.addElement("Referencia");
        colm.addElement("Resultado");
       
       
        //----
        JTable tabla = new JTable(TotalFil,colm);//objeto 
        tabla.setForeground(Color.BLUE);//Color de las letras
        JScrollPane JS_sp = new JScrollPane(tabla);
        JS_sp.setBounds(20, 80, 350, 120);//Posición de la tabla
         
        jpanel.add(JS_sp);
         
    }
   
    //Constructor de la clase
    public VentanaMenu(){
       crearMenu();
       crearPanel();
       crearVentana();
    }
    
    @Override
       public void actionPerformed(ActionEvent a){
          if(a.getSource()==sub1){
               //Llamamos a la venatan sumar dos numeros
               Ventana_SumaDos obj = new Ventana_SumaDos();
              
               
          }
          if(a.getSource()==sub2){
              Ventana_SumarTres obj = new Ventana_SumarTres();//objeto
          }
          if(a.getSource()==sub3){
              Ventana_MultiplicarDos obj = new Ventana_MultiplicarDos();//objeto
          }
          if(a.getSource()==sub4){
              Ventana_MultiplicarTres obj = new Ventana_MultiplicarTres();//objeto
          }
          if(a.getSource()==sub5){
              Vent_RestarDos obj = new Vent_RestarDos();//objeto
          }
          if(a.getSource()==sub6){
              Vent_RestarNegativos obj = new Vent_RestarNegativos();//objeto
              
          }
         
       }
      
}
//Imagen de fondo
class panelImage extends JPanel{

    @Override
    public void paint(Graphics g){
        Dimension dimension = this.getSize();
        ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/Fondo.jpg"));
        g.drawImage(icon.getImage(), 0, 0, dimension.width, dimension.height, null);
        setOpaque(false);
        super.paintChildren(g);
    }
 
    
}
