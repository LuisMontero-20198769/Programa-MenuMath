
package project_menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class Vent_RestarDos {
    //Atributos de la clase
    JFrame ventana;
    JPanel panel;
    JTextField Txt_num1, Txt_num2, Txt_total;
    JButton BT_Restar, BT_Atras;
    
    //Constructor de la ventana
     public Vent_RestarDos(){
      crearVentana();
     }
     public void crearVentana(){
       ventana = new JFrame("Calcular Resta");
  
       ventana.setSize(300,300); //Este será el tamaño de la ventana
       //Imagen de icono de la ventana
       ventana.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/calcularIcon.jpg")).getImage());
       ventana.setLocationRelativeTo(null);//Centralización de ventana en la pantalla
       ventana.setVisible(true);
      
       Componentes();//Aqui se llama al metodo de los componentes de la ventana
       ventana.setLayout(new BoxLayout(ventana.getContentPane(), BoxLayout.Y_AXIS));
       ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);//Aquí cumple la función de cerrar mi ventana
       //crearMenu();//agragmos el metodo a la ventana
    }
    void Componentes(){
       Panel();//Agregamos el panel 
       Etiquetas(); 
       botones();
    }
    public void Panel(){
        panel = new JPanel();//instanciamiento del panel
        panel.setLayout(null);//Posicion por defecto de la etiqueta desactivada
        //Agregamos un borde interno a nuestro panelA
        panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED),"// Resta de Dos Números Positivos//",
         TitledBorder.LEFT,TitledBorder.DEFAULT_POSITION));
        ventana.getContentPane().add(panel); //Agregacion del panel a la ventana  
    }
    //Metodo que crea las etiquetas y las cajas de textos
      public void Etiquetas(){
  
        //Etiqueta del primer numero
        JLabel Etq_num1 = new JLabel("Número 1: ");
        Etq_num1.setBounds(50,40,160,40);
        Etq_num1.setForeground(Color.orange);//Color de las letras
        Etq_num1.setFont(new Font("calibri light",Font.BOLD,14));//Tipo de letra
        panel.add(Etq_num1);
        //Caja de texto del primer numero
        Txt_num1 = new JTextField();//obejto inicializado 
        Txt_num1.setBounds(150,50,80,20);//Posición
        Txt_num1.setEditable(true);//No editable 
        panel.add(Txt_num1);//Agregamos al panel
        
        //Etiqueta del segundo numero
        JLabel Etq_num2 = new JLabel("Número 2: ");
        Etq_num2.setBounds(50,90,160,40);
        Etq_num2.setForeground(Color.orange);//Color de las letras
        Etq_num2.setFont(new Font("calibri light",Font.BOLD,14));//Tipo de letra
        panel.add(Etq_num2);
        //Caja de texto para el numero dos
        Txt_num2 = new JTextField();//obejto inicializado 
        Txt_num2.setBounds(150,100,80,20);//Posición
        Txt_num2.setEditable(true);//No editable 
        panel.add(Txt_num2);//Agregamos al panel
        
        //Etiqueta del segundo numero
        JLabel Etq_total = new JLabel("Total: ");
        Etq_total.setBounds(50,150,160,40);
        Etq_total.setForeground(Color.black);//Color de las letras
        Etq_total.setFont(new Font("calibri light",Font.BOLD,14));//Tipo de letra
        panel.add(Etq_total);
        //Caja de texto para el numero dos
        Txt_total = new JTextField();//obejto inicializado 
        Txt_total.setBounds(150,160,80,20);//Posición
        Txt_total.setEditable(false);//No editable 
        panel.add(Txt_total);//Agregamos al panel
    }
    public void botones(){
        //Boton que efectua la resta
      BT_Restar = new JButton("Restar");
      BT_Restar.setBounds(150,200,85,25);//Posición
      BT_Restar.setFont(new Font("calibri light",Font.BOLD,14));//Tipo de letra
      panel.add(BT_Restar);
      //Boton para regresar a la ventana principal
      BT_Atras = new JButton("Atrás");
      BT_Atras.setBounds(10,225,100,25);//Posición
      BT_Atras.setBackground(Color.CYAN);//Color del boton
      BT_Atras.setFont(new Font("calibri light",Font.BOLD,14));//Tipo de letra
     //Insertar imagen al boton
     ImageIcon Img = new ImageIcon(getClass().getResource("/Imagenes/IconVolver.png")); 
      
     BT_Atras.setIcon(new ImageIcon(Img.getImage().getScaledInstance(25, 20, Image.SCALE_SMOOTH)));
      panel.add(BT_Atras);
      
      //-----Acción o Evento del botón sumar
       ActionListener oyente = new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e) {
            int num1 = Integer.parseInt(Txt_num1.getText());
            int num2 = Integer.parseInt(Txt_num2.getText());
         
            int n_resultado = Funciones.RestarDos(num1, num2);
            Txt_total.setText(n_resultado+"");//Aqui se guarda el resultado
            
        }
        
      };
      BT_Restar.addActionListener(oyente);//Boton que restará
      //----Acción o evento del boton Atrás
      ActionListener oyente2 = (ActionEvent e) -> {
          VentanaMenu volver = new VentanaMenu();//Objeto de la ventana principal
        
      };
      BT_Atras.addActionListener(oyente2);//Boton que volverá a la ventana principal
   
    }   
    
}
