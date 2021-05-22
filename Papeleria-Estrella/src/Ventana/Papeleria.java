package Ventana;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/*
 * @author Gijon Vazquez Elias Dominick
 */
public class Papeleria extends JApplet implements ActionListener{
    DecimalFormat df;
    JFrame JF_Estadisticas;
	
    JPanel JP_Central;
    JPanel JP_DatosGen;
    JPanel JP_Datos;
    JPanel JP_Tablas;
    JPanel JP_Reporte; 
    JPanel JP_Botones;
 /*   
    JPanel JP_Titular;
    JPanel JP_Contenido;
    JPanel JP_Empleado;
    JPanel JP_Cargo;
    JPanel JP_Horas;
    JPanel JP_Modalidad;
    
    JPanel JP_Empleado2;
    JPanel JP_PH;
    JPanel JP_Bonificacion;
    JPanel JP_SueldoNeto;
 */   
    JLabel lbl_Titulo;
    JLabel lbl_Empleados;
    
    JTextField txt_Empleados;
    
    DefaultListModel mo_Nomina;
    
    JList lst_Nomina;
    
    DefaultTableModel mo_Informacion;
    DefaultTableModel mo_Calculos;
    
    JTable tb_Informacion;
    JTable tb_Calculos;
    
    JScrollPane scrtb_Informacion;
    JScrollPane scrtb_Calculos;
    
    //JScrollPane1.setViewportView(lstEstadistica);
    
    JButton btn_CalcularSueldo;
    JButton btn_CalcularNomina;
    JButton btn_Limpiar; 
    JButton btn_Salir;

    JMenuBar mb;
    JMenu m_Principal;
    JMenu m_Nuevo;
    JMenu m_Consultar;
    JMenu m_Actualizar;
    JMenu m_Sesion;
    
    JMenu m_n_Dato;
    JMenuItem m_n_Venta;
    JMenuItem m_n_Compra;
    
    JMenu m_c_Datos;
    JMenuItem m_c_Ventas;
    JMenuItem m_c_Compras;
    JMenuItem m_c_Inventario;
    
    JMenuItem m_a_Productos;
    JMenuItem m_a_Servicios;
    JMenu m_a_Proveedor;
    JMenuItem m_a_Cliente;
    
    JMenuItem m_s_Iniciar;
    JMenuItem m_s_Cerrar;
    
    JMenuItem m_nD_Productos;
    JMenuItem m_nD_Servicios;
    JMenuItem m_nD_Clientes;
    JMenuItem m_nD_Proveedores;
    
    JMenuItem m_aP_Telefono;
    JMenuItem m_aP_Direccion;
    
    int Filas, Columnas, ciclo=1;;
    
    public Papeleria() {
        df=new DecimalFormat("###0.00");
        //1.Creamos el Formulario
        JF_Estadisticas = new JFrame();
        JF_Estadisticas.setTitle("Programa 5");
        JF_Estadisticas.setSize(515, 450);
        JF_Estadisticas.setLayout(new BorderLayout());
        
        //2.Agregar los paneles para distribucion
        JP_Central = new JPanel();
        JP_Reporte = new JPanel();
        JP_DatosGen = new JPanel();
        JP_Datos = new JPanel();
        JP_Tablas = new JPanel();
        JP_Botones = new JPanel();
      /*  JP_Titular = new JPanel();
        JP_Contenido = new JPanel();
        JP_Empleado = new JPanel();
        JP_Cargo = new JPanel();
        JP_Horas = new JPanel();
        JP_Modalidad = new JPanel();
        
        JP_Empleado2 = new JPanel();
        JP_PH = new JPanel();
        JP_Bonificacion = new JPanel();
        JP_SueldoNeto = new JPanel();
      */      
        //3. Hacemos las Instrucciones
        Font font = new Font("Agency FB", Font.BOLD, 36);
        lbl_Titulo = new JLabel("EMPRESA LA BONITA",JLabel.CENTER);
        lbl_Titulo.setFont(font);
        lbl_Empleados = new JLabel("NUMERO DE EMPLEADOS");
        
        //4.Recoleccion de Datos
        txt_Empleados = new JTextField();
        
        mo_Calculos = new DefaultTableModel();
        mo_Informacion = new DefaultTableModel();
        
        tb_Calculos = new JTable();
        tb_Informacion = new JTable();
        
        scrtb_Informacion = new JScrollPane();
        scrtb_Calculos = new JScrollPane();
        
        mo_Nomina = new DefaultListModel();
        
        lst_Nomina = new JList();
 
        //5.Botones de Accion y Muestra
        mo_Informacion.setColumnCount(0);
        mo_Informacion.addColumn("NOMBRE");
        mo_Informacion.addColumn("HORAS TRABAJADAS");
        mo_Informacion.addColumn("PAGO POR HORA");
        mo_Calculos.setColumnCount(0);
        mo_Calculos.addColumn("SUBTOTAL");
        mo_Calculos.addColumn("BONO");
        mo_Calculos.addColumn("TOTAL");
               
        //Menu de Opciones
        mb=new JMenuBar();
        
        m_Principal = new JMenu("Inicio");
        m_Nuevo = new JMenu("Nuevo");
        m_Consultar = new JMenu("Consultar");
        m_Actualizar = new JMenu("Actualizar");
        m_Sesion = new JMenu("Sesion");

        m_n_Dato = new JMenu("Datos");
        m_n_Venta = new JMenuItem("Venta");
        m_n_Compra = new JMenuItem("Compra");

        //m_c_Datos = new JMenuItem("Datos"); //Creo que este es otro menu
        m_c_Datos = new JMenu("Datos");
        m_c_Ventas = new JMenuItem("Productos y Servicios Vendidos");
        m_c_Compras = new JMenuItem("Productos Comprados");
        m_c_Inventario = new JMenuItem("Inventario");

        m_a_Productos = new JMenuItem("Precio de Producto");
        m_a_Servicios = new JMenuItem("Precio de Servicios");
        m_a_Proveedor = new JMenu("Proveedor");
        m_a_Cliente = new JMenuItem("Numero de telefono del Cliente");

        m_s_Iniciar = new JMenuItem("Iniciar Sesion");
        m_s_Cerrar = new JMenuItem("Cerrar Sesion");
        
        m_nD_Productos = new JMenuItem("Productos");
        m_nD_Servicios = new JMenuItem("Servicios");
        m_nD_Clientes = new JMenuItem("Clientes");
        m_nD_Proveedores = new JMenuItem("Proveedores");
        
        m_aP_Telefono = new JMenuItem("Numero de Telefono");
        m_aP_Direccion = new JMenuItem("Direccion");
        
        
        //Invocadores
        m_n_Venta.addActionListener(this);
        m_n_Compra.addActionListener(this);
    
//        m_c_Datos.addActionListener(this);
        m_c_Ventas.addActionListener(this);
        m_c_Compras.addActionListener(this);
        m_c_Inventario.addActionListener(this);

        m_a_Productos.addActionListener(this);
        m_a_Servicios.addActionListener(this);
        m_a_Proveedor.addActionListener(this);
        m_a_Cliente.addActionListener(this);

        m_s_Iniciar.addActionListener(this);
        m_s_Cerrar.addActionListener(this);
        
        m_nD_Productos.addActionListener(this);
        m_nD_Servicios.addActionListener(this);
        m_nD_Clientes.addActionListener(this);
        m_nD_Proveedores.addActionListener(this);
        
        m_aP_Telefono.addActionListener(this);
        m_aP_Direccion.addActionListener(this);
        
        //Listas de Acciones
        m_Nuevo.add(m_n_Dato);
        m_Nuevo.add(m_n_Venta);
        m_Nuevo.add(m_n_Compra);
        
        m_Consultar.add(m_c_Datos);
        m_Consultar.add(m_c_Ventas);
        m_Consultar.add(m_c_Compras);
        m_Consultar.add(m_c_Inventario);
        
        m_Actualizar.add(m_a_Productos);
        m_Actualizar.add(m_a_Servicios);
        m_Actualizar.add(m_a_Proveedor);
        m_Actualizar.add(m_a_Cliente);
        
        m_Sesion.add(m_s_Iniciar);
        m_Sesion.add(m_s_Cerrar);
        
        //SubListas
        //Nuevo - Datos
        m_n_Dato.add(m_nD_Productos);
        m_n_Dato.add(m_nD_Servicios);
        m_n_Dato.add(m_nD_Clientes);
        m_n_Dato.add(m_nD_Proveedores);
        
        //Actualizar - Proveedor
        m_a_Proveedor.add(m_aP_Telefono);
        m_a_Proveedor.add(m_aP_Direccion);
        
        mb.add(m_Principal);
        mb.add(m_Nuevo);
        mb.add(m_Consultar);
        mb.add(m_Actualizar);
        mb.add(m_Sesion);
        /*
        menu1=new JMenu("Calcular");
        mb.add(menu1);
            mi1=new JMenuItem("Sueldos");
            mi1.addActionListener(this);
         menu1.add(mi1);
            mi2=new JMenuItem("Nomina");
            mi2.addActionListener(this);
        menu1.add(mi2); 
            menu2=new JMenuItem("Limpiar");
            menu2.addActionListener(this);
        mb.add(menu2);
            menu3=new JMenuItem("Salir");
            menu3.addActionListener(this);
        mb.add(menu3);  
        */
        
        btn_CalcularSueldo = new JButton("Calcular Sueldos");
        btn_CalcularNomina = new JButton("Calcular Nomina");
        btn_Limpiar = new JButton("Limpiar");
        btn_Salir = new JButton("Salir");
        
        tb_Calculos.setModel(mo_Calculos);
        tb_Informacion.setModel(mo_Informacion);
        
        tb_Calculos.setEnabled(false);
        
        lst_Nomina.setModel(mo_Nomina);
        
        scrtb_Calculos.setVerticalScrollBar(scrtb_Informacion.getVerticalScrollBar());
        
     /* scrlst_Empleado.setViewportView(lst_Empleado);
        scrlst_PagoXHora.setViewportView(lst_PagoXHora);
        scrlst_Bono.setViewportView(lst_Bono);
        scrlst_Sueldo.setViewportView(lst_Sueldo);
     */
        //6.Agregamos Acciones a los botones.
        btn_CalcularSueldo.addActionListener(this);
        btn_CalcularNomina.addActionListener(this);
        btn_Limpiar.addActionListener(this);
        btn_Salir.addActionListener(this);
        
         //7. Distribuimos
        JF_Estadisticas.add(JP_Central,BorderLayout.CENTER);

        JP_Central.setLayout(new GridLayout(3,0,0,0));
       // JP_Central.add(JP_DatosGen);
        JP_Central.add(JP_Tablas);
        //JP_Central.add(scrtb_Nomina);
        JP_Central.add(JP_Reporte);
        
        JP_DatosGen.setLayout(new BorderLayout());
        JP_DatosGen.add(lbl_Titulo,BorderLayout.NORTH);
        JP_DatosGen.add(JP_Datos,BorderLayout.CENTER);
        
        JP_Datos.setLayout(new BorderLayout());
        JP_Datos.add(lbl_Empleados,BorderLayout.WEST);
        JP_Datos.add(txt_Empleados,BorderLayout.CENTER);
        
        JP_Tablas.setLayout(new GridLayout(0,2,0,0));
        JP_Tablas.add(scrtb_Informacion);
        JP_Tablas.add(scrtb_Calculos);
        
        scrtb_Informacion.setViewportView(tb_Informacion);
        scrtb_Calculos.setViewportView(tb_Calculos);
        
        JP_Reporte.setLayout(new GridLayout(0,1,0,0));
        //JP_Reporte.add(mb);
        JP_Reporte.add(lst_Nomina);
        
        JP_Botones.setLayout(new GridLayout(4,0,0,0));
        JP_Botones.add(btn_CalcularSueldo);
        JP_Botones.add(btn_CalcularNomina);
        JP_Botones.add(btn_Limpiar);
        JP_Botones.add(btn_Salir);
/*        
        JP_Listas.setLayout(new GridLayout(0,4,0,0));
        JP_Listas.add(JP_Empleado2);
        JP_Listas.add(JP_PH);
        JP_Listas.add(JP_Bonificacion);
        JP_Listas.add(JP_SueldoNeto);
        
        JP_Empleado2.setLayout(new BorderLayout());
        JP_Empleado2.add(lbl_Empleado2,BorderLayout.NORTH);
        JP_Empleado2.add(scrlst_Empleado,BorderLayout.CENTER);
        
        JP_PH.setLayout(new BorderLayout());
        JP_PH.add(lbl_PH,BorderLayout.NORTH);
        JP_PH.add(scrlst_PagoXHora,BorderLayout.CENTER);
        
        JP_Bonificacion.setLayout(new BorderLayout());
        JP_Bonificacion.add(lbl_Bonificacion,BorderLayout.NORTH);
        JP_Bonificacion.add(scrlst_Bono,BorderLayout.CENTER);
        
        JP_SueldoNeto.setLayout(new BorderLayout());
        JP_SueldoNeto.add(lbl_SueldoNeto,BorderLayout.NORTH);
        JP_SueldoNeto.add(scrlst_Sueldo,BorderLayout.CENTER);
        
        
        JP_Reporte.setLayout(new BorderLayout());
        //JP_Reporte.add(JP_Botones,BorderLayout.NORTH);
        JP_Reporte.add(lbl_Estadisticas,BorderLayout.NORTH);
        JP_Reporte.add(scrlst_Estadisticas,BorderLayout.CENTER);
        
        
        
        
        JP_Datos.setLayout(new BorderLayout());
        JP_Datos.add(JP_Titular,BorderLayout.NORTH);
        JP_Datos.add(JP_Contenido,BorderLayout.CENTER);
        JP_Datos.add(JP_Botones,BorderLayout.SOUTH);
        
        JP_Titular.setLayout(new GridLayout(0,1,0,0));
        JP_Titular.add(lbl_Titulo);
        
        JP_Contenido.setLayout(new GridLayout(0,2,0,0));
        JP_Contenido.add(JP_Empleado);
        JP_Contenido.add(JP_Horas);
        JP_Contenido.add(JP_Cargo);
        JP_Contenido.add(JP_Modalidad);
        
        JP_Empleado.setLayout(new BorderLayout());
        JP_Empleado.add(lbl_Empleado,BorderLayout.NORTH);
        JP_Empleado.add(txt_Empleado,BorderLayout.CENTER);
        
        JP_Horas.setLayout(new BorderLayout());
        JP_Horas.add(lbl_Horas,BorderLayout.NORTH);
        JP_Horas.add(txt_Horas,BorderLayout.CENTER);
        
        JP_Cargo.setLayout(new BorderLayout());
        JP_Cargo.add(lbl_Cargo,BorderLayout.NORTH);
        JP_Cargo.add(cbo_Cargo,BorderLayout.CENTER);
    
        JP_Modalidad.setLayout(new BorderLayout());
        JP_Modalidad.add(lbl_Modalidad,BorderLayout.NORTH);
        JP_Modalidad.add(cbo_Modalidad,BorderLayout.CENTER);
  */      
        //8. Mostramos interfaz
        JF_Estadisticas.setJMenuBar(mb);
        JF_Estadisticas.setLocationRelativeTo(null);
        JF_Estadisticas.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==m_nD_Servicios){
            JF_Estadisticas.remove(JP_Central);
            //JP_Central.removeAll();
            JF_Estadisticas.add(JP_DatosGen,BorderLayout.CENTER);
            JF_Estadisticas.repaint();
            JF_Estadisticas.validate();
            //JOptionPane.showMessageDialog(null,"xd","",JOptionPane.PLAIN_MESSAGE);
        }
/*        if(e.getSource()==mi1){
            double Total=0,Bonificacion=0,Bono=0;
            boolean Iniciar;
            Iniciar=ValidacionEmpleados();
            if(Iniciar==true){  
                int Empleados=Empleados();
                Filas = Filas();
                Columnas = Columnas();
                mo_Informacion.setRowCount(Empleados);
                mo_Calculos.setRowCount(Empleados);
                
                if(ciclo==1){
                    ciclo++;
                }
                else{
                    if(ciclo>1){
                        boolean Proceso = ValidacionTabla();
                        if(Proceso==true){
                            for(int x=0;x<Filas;x++){
                                int Horas;
                                double PagoPorHora, Subtotal;
                                Horas= Integer.parseInt(mo_Informacion.getValueAt(x,1).toString());
                                PagoPorHora = Double.parseDouble(mo_Informacion.getValueAt(x,2).toString());
                                Subtotal = Horas*PagoPorHora;
                                Bonificacion = Bonificacion(Subtotal);
                                Bono=Subtotal*Bonificacion;
                                Total=Subtotal+Bono;
                                
                                mo_Calculos.setValueAt(df.format(Subtotal),x,0);
                                mo_Calculos.setValueAt(df.format(Bono),x,1);
                                mo_Calculos.setValueAt(df.format(Total),x,2);
                                ciclo++;
                            }
                        }
                    }
                }
            }
           // else{btn_Limpiar.doClick();}
           
            /*    Monto=PagoPorHora();
                Horas=HorasTrabajadas();
                Bonificacion=IdentificarBonificacion();
                
                MontoNeto=TotalPagar(Monto,Horas,Bonificacion);
                
                ContadorCargos();
                ContadorSueldo(MontoNeto);
                
                mo_Empleado.addElement(txt_Empleado.getText());
                mo_pagoXhora.addElement(Monto);
                mo_Bono.addElement((Horas*Monto)*Bonificacion);
                mo_Sueldo.addElement(MontoNeto);
                
                Total++;
            /*  txt_Reporte.append("Medios de Publicidad: "+(String)cbo_Medios.getSelectedItem());
                txt_Reporte.append("\nPrecio: $"+df.format(Costo));
                txt_Reporte.append("\n---------------------------------------");
                txt_Reporte.append("\nMonto Bruto: $"+df.format(MontoBruto));
                txt_Reporte.append("\nMonto de Descuento: $"+df.format(Descuento));
                txt_Reporte.append("\nMonto Neto: $"+df.format(MontoNeto));
                txt_Reporte.append("\n\nPrograma realizado por Elias Gijon");
                */
            
        }
/*        if(e.getSource()==mi2){
            if(ciclo>2){
                mo_Nomina.clear();
                mo_Nomina.addElement("-----------------------------------");
                mo_Nomina.addElement("NOMINA");
                mo_Nomina.addElement("-----------------------------------");
                mo_Nomina.addElement("El Total de Pago Basico: "+df.format(TotalSueldoBasico()));
                mo_Nomina.addElement("El Total de Bonificacion: "+df.format(TotalBonos()));
                mo_Nomina.addElement("El Total: "+df.format(Total()));
                mo_Nomina.addElement("-----------------------------------");
            }
            else{
                JOptionPane.showMessageDialog(null,"Se debe de iniciar la informacion primero","Ejecucion sin datos",JOptionPane.WARNING_MESSAGE);
            }
        }
        if(e.getSource()==menu2){
            if((txt_Empleados.getText()).equals("")){
                JOptionPane.showMessageDialog(null,"Los Campos estan limpios","Error en Ejecucion",JOptionPane.WARNING_MESSAGE);
            }
            else{
                for(int x=(Filas-1);x>=0;x--){
                    mo_Informacion.removeRow(x);
                    mo_Calculos.removeRow(x);
                }
            }
            Filas=0;
            txt_Empleados.setText("");
            mo_Nomina.removeAllElements();
            ciclo=1;
            txt_Empleados.requestFocus();
        }
        if(e.getSource()==menu3){
            System.exit(0);
        }
    }
*/    
    public boolean ValidacionEmpleados(){
        boolean TB=true;
        try{
            Empleados();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Se debe Ingresar un valor numerico en Empleados","Error en Empleados",JOptionPane.WARNING_MESSAGE);  
            TB=false;
        }
        
        return TB;
    }
    
     public boolean ValidacionTabla(){
        boolean TB=true;
        for(int x=0;x<Filas;x++){
            try{
                (mo_Informacion.getValueAt(x,0)).toString();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"Se debe Ingresar un Nombre de Empleado","Error al llenar la Tabla",JOptionPane.WARNING_MESSAGE);
                TB=false;
            }    
            
            try{
                Integer.parseInt(mo_Informacion.getValueAt(x,1).toString());
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"Se debe Ingresar un valor numerico en Horas","Error al llenar la Tabla",JOptionPane.WARNING_MESSAGE);
                TB=false;
            }
            
            try{
                Double.parseDouble(mo_Informacion.getValueAt(x,2).toString());
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"Se debe Ingresar un valor numerico en Pago por Horas","Error al llenar la Tabla",JOptionPane.WARNING_MESSAGE);
                TB=false;
            }
        }
        return TB;
    }
 
    public int Empleados(){
        int Empleados;
        Empleados=Integer.parseInt(String.valueOf(txt_Empleados.getText()));
        return Empleados;
    }
    
    public int Columnas(){
        return Integer.parseInt(String.valueOf(mo_Informacion.getColumnCount()));
    }
    
    public int Filas(){
        return Empleados();
    }
        
    public double Bonificacion(double Sueldo){
        double Bonificacion=0;
        if (Sueldo<5000){
            Bonificacion=0.2;
        }
        else {
            if((Sueldo>=5001)&&(Sueldo<7000)){
                Bonificacion=0.1;
            }
            else{
                if(Sueldo>7000){
                    Bonificacion=0.05;
                }
            }
        }
        return Bonificacion;
    }
    
    public double TotalSueldoBasico(){
        double TotalSueldoBasico=0;
        for(int x=0;x<Filas;x++){
            double Subtotal = Double.parseDouble(mo_Calculos.getValueAt(x,0).toString());
            TotalSueldoBasico+=Subtotal;
        }
        return TotalSueldoBasico;
    }
    
    public double TotalBonos(){
        double TotalBonos=0;
        for(int x=0;x<Filas;x++){
            double Bono = Double.parseDouble(mo_Calculos.getValueAt(x,1).toString());
            TotalBonos += Bono;
        }
        return TotalBonos;
    }
    public double Total(){
        double Total=0;
        for(int x=0;x<Filas;x++){
            double total = Double.parseDouble(mo_Calculos.getValueAt(x,2).toString());
            Total+=total;
        }
        return Total;
    }
    
    public static void main(String[]args){
        Papeleria AS=new Papeleria();
    }
}
