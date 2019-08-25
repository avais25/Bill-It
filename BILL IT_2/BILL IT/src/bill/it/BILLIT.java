/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bill.it;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.text.*;
import java.awt.*;
import java.awt.print.*;
import java.awt.print.Book.*;
import javax.swing.JTable;

/**
 *
 * @author emran
 */
public class BILLIT extends javax.swing.JFrame{

    /**
     * @param args the command line arguments
     */
    public static float t_vat=0, t_amt=0;    // to calculate total vat and amount
    private javax.swing.JButton jButton1;       //print button
    private javax.swing.JButton jButton2;       //exit button
    private javax.swing.JButton jButton3;       //add record button
    private javax.swing.JButton jButton4;       //about button
    private static javax.swing.JLabel jLabel1;         // invoice label
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;             //table
    private static javax.swing.JTextArea jTextArea1;           //address
    private javax.swing.JTextField jTextField1;
    private static javax.swing.JTextField jTextField2;     //custumer name
    private static javax.swing.JTextField jTextField3;  //amount text feild
    private static javax.swing.JTextField jTextField4; //vat text feild
    private static org.jdesktop.swingx.JXDatePicker jXDatePicker1;     //date picker to select date
    private javax.swing.JButton invoice;           //invoice button generate invoice no
    private Vector data,head;
    private JTableHeader h;
    private void initComponents() throws Exception{
        data=new Vector();
        head=new Vector();
        h=new JTableHeader();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();         //jLabel for invoice
        //jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jScrollPane2 = new javax.swing.JScrollPane();
       jTable1 = new javax.swing.JTable();
        
      
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
         jButton4 = new javax.swing.JButton(); 
        invoice = new javax.swing.JButton("Invoice");           //the invoice button
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bill IT");

        //jLabel1.setText("Invoice No. : ");
        
       // jTextField1.setText("Enter no.");
       // jTextField1.setName(""); // NOI18N

        jLabel2.setText("Customer Name : ");

        jTextField2.setText("Enter Name");

        jLabel3.setText("Customer Address : ");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel4.setText("Date : ");

        jXDatePicker1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXDatePicker1ActionPerformed(evt);
            }
        });

        jLabel5.setText(" Amount : ");

        jLabel6.setText("VAT (5%) : ");

        
        jTable1.setModel(new javax.swing.table.DefaultTableModel(             //Setting initial model for JTable 1
                        ob=new Object [][] 
                        {
                            //{"a", "b", "c", "d", "e"}
                        },
                        new String [] 
                        {
                            "Product Id", "Product Name", "Quantity", "Discount", "Total Cost"
                        })                          //Setting applications table
                        {
                        Class[] types = new Class [] 
                        {
                            java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Integer.class
                        };
                        

                        @Override
                        public Class getColumnClass(int columnIndex) 
                        {
                            return types [columnIndex];
                        }
                    }); 
        
        
        
        jButton1.setText("PRIINT");
        jButton1.addActionListener(new java.awt.event.ActionListener()      // prinnt button  action listener
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                jButton1ActionPerformed(evt);
            }
        });
        
        jButton2.setText("EXIT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {            // exit button action listener
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
     
            
        });
        jButton3.setText("ADD RECORD");
        jButton3.addActionListener(new java.awt.event.ActionListener()      //add record action listener
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                jButton3ActionPerformed(evt);
            }
        });
        
        jButton4.setText("About");
        jButton4.addActionListener(new java.awt.event.ActionListener()      //about button action listener
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                jButton4ActionPerformed(evt);
            }
        });
        
        
        invoice.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)         //invoice button action listener
            {
                invoiceActionPerformed(evt);
            }
        });
        
        
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                            .addComponent(jTextField4)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(invoice)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(2, 2, 2)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(invoice)
                        .addComponent(jLabel2)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField3)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)
                    .addComponent(jButton4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        
        
        
        pack();
    }// </editor-fold>                        

    private void jXDatePicker1ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    } 
    private void jButton2ActionPerformed(ActionEvent evt) {                 // exit button
              
                dispose();
//To change body of generated methods, choose Tools | Templates.
            }
    Object [][] ob;
    javax.swing.JTextField jtextfield1;
    javax.swing.JTextField jtextfield2;
    private void jButton3ActionPerformed(ActionEvent evt) {
              
            javax.swing.JFrame jframe1 = new javax.swing.JFrame();
            javax.swing.JPanel jpanel = new javax.swing.JPanel();
            javax.swing.JButton jbutton1 = new javax.swing.JButton("ADD");
            javax.swing.JLabel jlabel1 = new javax.swing.JLabel("PRODUCT_ID : ");
            javax.swing.JLabel jlabel2 =new javax.swing.JLabel("QUANTITY : ");
            jtextfield1 = new javax.swing.JTextField(10);
            jtextfield2 = new javax.swing.JTextField(10);
            jframe1.setTitle("ADD RECORD");
            jframe1.setSize(250,150);
            jframe1.add(jpanel);
            jpanel.add(jlabel1);
            jpanel.add(jtextfield1);
            jpanel.add(jlabel2);
            jpanel.add(jtextfield2);
            jpanel.add(jbutton1);
            jbutton1.addActionListener(new java.awt.event.ActionListener() {
            
            int i=0,j=0;
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                try
                {
                        ResultSet s=connect();
                        String b;
                        int a,c=0,d,e,f,amt=0;                    //setting c as quantity
                        float  vat=0;
                        s.next();
                        a=s.getInt(1);                      //Extracting items from database 1=prod id  //2==product name //3== price  //4==discount //5==quantity
                        b=s.getString(2);                  
                        f=s.getInt(5); 
                        
                        if(f>=Integer.parseInt(jtextfield2.getText()))
                        c=Integer.parseInt(jtextfield2.getText());              //converting text into integer
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Insufficient Quantity, Quantity Available="+f, "InfoBox: " + "Error", JOptionPane.INFORMATION_MESSAGE);
                            return;                                                                     // Show error if quantity is insufficient
                        }
                        d=s.getInt(4);                     
                        e=(s.getInt(3)*c);                  //cost for quantity
                        e=e-((d*e)/100);                    //cost after discount
                        vat=(float) (0.05*e);                             //calculating vat
                        t_vat=t_vat+vat;
                        t_amt=t_amt+e;
                        jTextField4.setText(""+t_vat);                    //to show vat , t_vat is a static variable 
                        jTextField3.setText(""+t_amt);                     // to show total amount , t_amt  is a static vaiable
                        updateDatabase(f-c,a);                       //to reduce the quantity  //f=c is the new quantity
                        
                        
                        DefaultTableModel model =(DefaultTableModel)  jTable1.getModel();   //these two lines add a row in jtable
                        model.addRow(new Object[]{a,b,c,d,e});
                        jframe1.dispose();                                              // kill add record window
                }
                catch(Exception e){
                    
                }
            jScrollPane2.setViewportView(jTable1);
            

            }  
        });
            jframe1.setVisible(true);
            
           
    }
    
    
    private void jButton1ActionPerformed(ActionEvent evt)       // Print button to print final bill
    { 
        
        MessageFormat header=new MessageFormat("Bill");             //header of jTable page
        MessageFormat footer=new MessageFormat("");                 //footer of jTable page
        if("".equals(jLabel1.getText()))                               //to make sure that invoice no is generated, comment whole if to test print working without databasa
        {
        JOptionPane.showMessageDialog(null, "Please Generate Invoice Number First", "InfoBox: " + "Error", JOptionPane.INFORMATION_MESSAGE);
        return;                         //if invoice no is not generated we cannot print
        } 
       // MessageFormat footer=new MessageFormat("page{0,number,integer}");

        try{
            PrinterJob pj = PrinterJob.getPrinterJob();
            Book book = new Book();                         //creating a book to print
            Printable a=jTable1.getPrintable(JTable.PrintMode.FIT_WIDTH, header,footer);        //getting printable object of jTable
            book.append(a, pj.defaultPage());                               //appending jTabel to the book
            book.append(new Title(), pj.defaultPage());                     //apppending the printable title class as a page of book 
                            //Title is a class which is created at end of program inside BILLIT class
            book.append(new EndPage(), pj.defaultPage());                   // appening EndPage class as a page of book
                            //EndPage is a class crated at the end of program inside BILLIT calss
            pj.setPageable(book);       
            pj.print();         // printing the output by default printer
            
            
            
            
            //jTextArea1.print(header1, footer1);
            //jTable1.print(JTable.PrintMode.FIT_WIDTH, header, footer);  // to print only the jTable without any book 
    
    
    }
 
    catch(java.awt.print.PrinterException e)// catching error
    {
        System.err.format("Cannot print %s%n" , e.getMessage());
    }// end of catch
    } //end of action performed function
    
    
    
    
    private void jButton4ActionPerformed(ActionEvent evt) {     //jbutton 4 is about button
              
             javax.swing.JFrame jframe1 = new javax.swing.JFrame();
            javax.swing.JPanel jpanel = new javax.swing.JPanel();
            javax.swing.JButton exitb = new javax.swing.JButton("Exit");        //making exit button
            javax.swing.JLabel jlabel1 = new javax.swing.JLabel("Made By :- Avais Ahmad , Emran Husain");
            ImageIcon image = new ImageIcon("image/icon.jpg");              //adding image
            
            jframe1.setTitle("About");
            jframe1.setSize(700,700);
            jframe1.add(jpanel);
            
            JLabel label = new JLabel("", image, JLabel.CENTER);            //adding image as label
            

          jpanel.add(label);
            jpanel.add(jlabel1);
           
            jpanel.add(exitb);
             jframe1.setVisible(true);
             exitb.addActionListener(new java.awt.event.ActionListener() {      //coading for exit button
                  @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jframe1.dispose();
            }     
             });  //end of exit button action listener
             }          //end of button 4
    
    private void invoiceActionPerformed(ActionEvent evt) {     //it is invoice button
              
           if (nonEmptyFields()==1){     //checking if there aren no empty feilds
               try {
                   updateInvoiceDatabase();     //updating database and generate unique invoice number
           } catch (ClassNotFoundException | SQLException ex) {
               Logger.getLogger(BILLIT.class.getName()).log(Level.SEVERE, null, ex);
           }
           }  
            }

    ResultSet rs;       
    public ResultSet connect() throws ClassNotFoundException, SQLException
    {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","BILLIT","BILLIT");   //Connection to Database
        Statement st=cn.createStatement();  
        rs=st.executeQuery("select * from prod_id_table where prod_id="+jtextfield1.getText());         //Contains query 
        return rs;
    } 
    
    public void updateDatabase(int x,int y) throws ClassNotFoundException, SQLException           //x is the new quantity
    {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","BILLIT","BILLIT");   //Connection to Database
        Statement st1=cn.createStatement();  
        st1.executeQuery("UPDATE prod_id_table SET quantity='"+x+"'WHERE prod_id='"+y+"'");
        
    }

    
    public int nonEmptyFields()         //checks if all feilds are filled
    {
       if("Enter Name".equals(jTextField2.getText()) || "".equals(jTextField2.getText()))
       {
           JOptionPane.showMessageDialog(null, "Please Enter a custumers name", "InfoBox: " + "Error", JOptionPane.INFORMATION_MESSAGE);
           return 0;        //returns 0 for error
       }
       
       else if("".equals(jTextArea1.getText()))
       {
           JOptionPane.showMessageDialog(null, "Please Enter a custumers address", "InfoBox: " + "Error", JOptionPane.INFORMATION_MESSAGE);
         return 0;
       }
       else if(jXDatePicker1.getDate()==null)
       {
           JOptionPane.showMessageDialog(null, "Please Enter a date", "InfoBox: " + "Error", JOptionPane.INFORMATION_MESSAGE);
            return 0;
       }
       
       else if("".equals(jTextField3.getText()))
       {
           JOptionPane.showMessageDialog(null, "Please Buy Something", "InfoBox: " + "Error", JOptionPane.INFORMATION_MESSAGE);
         return 0;
       }
       
      else 
          return 1;         //returns 1 for success
    }
    
        
      public void  updateInvoiceDatabase()   throws ClassNotFoundException, SQLException  
      {
           Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","BILLIT","BILLIT");   //Connection to Database
        Statement st=cn.createStatement();
        SimpleDateFormat formater = new SimpleDateFormat("dd-MMM-yy");      //contert date format
        // Date date = format1.parse("05/01/1999");
        String date=formater.format(jXDatePicker1.getDate());       //converts date to specific format which is accepted by sql
        
        int a =generateInvoiceNo();
        
        st.executeQuery("insert into invoice_table values ('"+a+"','"+date+"','"+jTextField2.getText()+"','"+jTextField3.getText()+"','"+jTextArea1.getText()+"')");
      //sql command to inser values into invoice table
        
        jLabel1.setText(""+a); // generates invoice number to lable
        JOptionPane.showMessageDialog(null, "Custumer Entery successful, invoice no generation Successful", "InfoBox: " + "Success", JOptionPane.INFORMATION_MESSAGE);
      }
      
        
      public int generateInvoiceNo() throws ClassNotFoundException, SQLException   //generate unique invoice numer
      {
          Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","BILLIT","BILLIT");   //Connection to Database
        Statement st=cn.createStatement();
        ResultSet a=st.executeQuery("SELECT MAX(invoice_no) FROM invoice_table ");
      //  String str = a.getString("invoice_no");
        a.next();
        int id = a.getInt(1);       //convert result set to integer
     return(id+1);                  // increment invoice numer and return
      }

    public BILLIT() throws Exception{
        initComponents();
        ImageIcon icon = new ImageIcon("image\\icon1.jpg");             //icon connect
        setIconImage(icon.getImage());
        //connect();
    }
    public static void main(String[] args) {
        // TODO code application logic here
                try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try
                {
                  new BILLIT().setVisible(true);  
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
        });
    }

    private static class Title implements Printable  {          // Title class used for printing

          Font font = new Font("SansSerif", Font.PLAIN, 48);        // creating fonts
          Font font1 = new Font("SansSerif", Font.PLAIN, 18);
          

    @Override
    public int print(Graphics g, PageFormat pf, int pageIndex)      // the print function which is overrided
        throws PrinterException {
        Graphics2D g2d = (Graphics2D) g;                // graphics object
        g2d.translate(pf.getImageableX(), pf.getImageableY());
        g2d.setFont(font);
        g2d.setColor(Color.black);
        g2d.drawString("Bill It", 50, 200);         // printig Title
        g2d.setFont(font1);
        g2d.drawString("Invoice No="+jLabel1.getText(), 10, 270); // printing invoice no
        g2d.drawString("Date="+jXDatePicker1.getDate(), 10, 300);       // printin date
        g2d.drawString("Custumer Name="+jTextField2.getText(), 10, 330);// printing date
        g2d.drawString("Custumer Address="+jTextArea1.getText(), 10, 360);// printing address
        
        return Printable.PAGE_EXISTS;
    }       //end of print function
    }       //end of title class
    
    
    
    
     private static class EndPage implements Printable  {       ////EndPage class to append page to print

         // Font font = new Font("SansSerif", Font.PLAIN, 48);
          Font font1 = new Font("SansSerif", Font.PLAIN, 18);
          

    @Override
    public int print(Graphics g, PageFormat pf, int pageIndex)      //the print function
        throws PrinterException {
        Graphics2D g2d = (Graphics2D) g;                        //object for graphics
        
        g2d.translate(pf.getImageableX(), pf.getImageableY());
        //g2d.setFont(font);
        g2d.setColor(Color.black);
       // g2d.drawString("Bill It", 50, 200);
        //g2d.translate(pf.getImageableX(), pf.getImageableY());
        g2d.setFont(font1);
        g2d.setColor(Color.black);
        g2d.drawString("Amount="+jTextField3.getText(), 10, 270);           //printing amount
        g2d.drawString("VAT="+jTextField4.getText(), 10, 300);                  //printing amount
        return Printable.PAGE_EXISTS;
    }
            }   //end of EndPage Class
     
}           //end of class BILLIT