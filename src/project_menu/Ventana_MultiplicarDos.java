
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

public class Ventana_MultiplicarDos {
    JFrame ventana;
    JPanel panel;
    JTextField Txt_num1, Txt_num2, Txt_total;
    
    //Constructor de la ventana
     public Ventana_MultiplicarDos(){
      crearVentana();
     }
     public void crearVentana(){
       ventana = new JFrame("Calcular Multiplicación");
  
       ventana.setSize(310,300); //Este será el tamaño de la ventana
       //Posición iniciar de la ventana
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
        panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED),"// Multiplicación de Dos Números //",
         TitledBorder.LEFT,TitledBorder.DEFAULT_POSITION));
        ventana.getContentPane().add(panel); //Agregacion del panel a la ventana  
    }
      public void Etiquetas(){
  
        //Etiqueta del primer numero
        JLabel Etq_num1 = new JLabel("Número 1: ");
        Etq_num1.setBounds(50,40,160,40);
        Etq_num1.setForeground(Color.red);//Color de las letras
        Etq_num1.setFont(new Font("calibri light",Font.BOLD,14));//Tipo de letra
        panel.add(Etq_num1);
        //Caja de texto del primer numero
        Txt_num1 = new JTextField();//obejto inicializado 
        Txt_num1.setBounds(150,50,100,20);//Posición
        Txt_num1.setEditable(true);//No editable 
        panel.add(Txt_num1);//Agregamos al panel
        
        //Etiqueta del segundo numero
        JLabel Etq_num2 = new JLabel("Número 2: ");
        Etq_num2.setBounds(50,90,160,40);
        Etq_num2.setForeground(Color.blue);//Color de las letras
        Etq_num2.setFont(new Font("calibri light",Font.BOLD,14));//Tipo de letra
        panel.add(Etq_num2);
        //Caja de texto para el numero dos
        Txt_num2 = new JTextField();//obejto inicializado 
        Txt_num2.setBounds(150,100,100,20);//Posición
        Txt_num2.setEditable(true);//No editable 
        panel.add(Txt_num2);//Agregamos al panel
        
        //Etiqueta del segundo numero
        JLabel Etq_total = new JLabel("Total: ");
        Etq_total.setBounds(50,150,160,40);
        Etq_total.setForeground(Color.blue);//Color de las letras
        Etq_total.setFont(new Font("calibri light",Font.BOLD,14));//Tipo de letra
        panel.add(Etq_total);
        //Caja de texto para el numero dos
        Txt_total = new JTextField();//obejto inicializado 
        Txt_total.setBounds(150,160,100,20);//Posición
        Txt_total.setEditable(false);//No editable 
        panel.add(Txt_total);//Agregamos al panel
    }
    public void botones(){
      JButton BT_Multiplicar = new JButton("Multiplicar");
      BT_Multiplicar.setBounds(140,200,120,30);//Posición
      BT_Multiplicar.setFont(new Font("calibri light",Font.BOLD,14));//Tipo de letra
      panel.add(BT_Multiplicar);
      //Boton para regresar a la ventana principal
      JButton BT_Atras = new JButton("Atrás");
      BT_Atras.setBounds(10,225,100,25);//Posición
      BT_Atras.setBackground(Color.CYAN);//Color del boton
      BT_Atras.setFont(new Font("calibri light",Font.BOLD,14));//Tipo de letra
      //Insertar imagen al botón "Atrás"
     ImageIcon Img = new ImageIcon(getClass().getResource("/Imagenes/IconVolver.png")); 
     BT_Atras.setIcon(new ImageIcon(Img.getImage().getScaledInstance(25, 20, Image.SCALE_SMOOTH)));
      panel.add(BT_Atras);//Agregar al panel
      //-----Acción o Evento del botón sumar
       ActionListener oyente = new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e) {
            int num1 = Integer.parseInt(Txt_num1.getText());
            int num2 = Integer.parseInt(Txt_num2.getText());
         
            int n_resultado = Funciones.MultiplicarDos(num1, num2);
            Txt_total.setText(n_resultado+"");//Aqui se guarda el resultado
        }
        
      };
      BT_Multiplicar.addActionListener(oyente);//Boton que multiplica
      
      //----Acción o evento del boton Atrás
      ActionListener oyente2 = new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e) {
             VentanaMenu volver = new VentanaMenu();//Objeto de la ventana principal
        }  
      };
      BT_Atras.addActionListener(oyente2);//Boton que volverá a la ventana principal
   
    }
       
}
