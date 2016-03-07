import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
//import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
//import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * COEN 280 - Winter 2016 Submission March4 2016 
 * Yelp application to query the data on basis of users and business 
 * @author Shilpita Roy
 */


public class hw03 extends javax.swing.JFrame {
//    private ArrayList<JCheckBox> checksCat = new ArrayList<JCheckBox>();
//    private ArrayList<JCheckBox> checksSubCat = new ArrayList<JCheckBox>();
      private ArrayList<String> listCategories = new ArrayList<String>();
//    private ArrayList<String> listSelectCategories = new ArrayList<String>();
      private String listSelectedCategories = "" ;
      private ArrayList<String> listSubCategories = new ArrayList<String>();
//    private ArrayList<String> listSelectSubCategories = new ArrayList<String>();
      private String listSelectedSubCategories = "" ;
//    private String listSelectedSubcategories = "" ;
      private static InsertToDB insertDB;
      private static Connection con;
      private String selectedCategory ="";
      private String selectedSubcategory ="";
      private String unselectedCategory ="";
      private String unselectedSubcategory ="";
//    private String selectFrom ="";
      private String a="";
      private String b="";
    /**
     * Creates new form TesterDemo
     */
    public hw03() throws SQLException, ClassNotFoundException {
      
        initComponents(); 
        insertDB     = new InsertToDB();
//      con          = insertDB.openConnection();
        createCategoryCheckboxes();
    }
 
    @SuppressWarnings("unchecked")
// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtRevCntInput = new javax.swing.JTextField();
        cmbRevInput = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtFrndCntInput = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cmbNFreindInput = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        txtAvgStarInput = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cmbAvgStarInput = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cmbSelectInput = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        Date date = new Date();
        jDateChooserMemberSince = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel7 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        cnbFrmDay = new javax.swing.JComboBox<>();
        txtFrmHr = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cnbToDay = new javax.swing.JComboBox<>();
        txtToHr = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        txtCknInput = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbStr = new javax.swing.JComboBox<>();
        txtStrInput = new javax.swing.JTextField();
        txtVotes = new javax.swing.JLabel();
        cmbVotes = new javax.swing.JComboBox<>();
        txtVotesInput = new javax.swing.JTextField();
        //Date date = new Date();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        btnQuery = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ResultTable = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        jQueryTextArea = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel6 = new javax.swing.JPanel();
        jQueryUserRadioButton = new javax.swing.JRadioButton();
        jQueryBusinessRadioButton = new javax.swing.JRadioButton();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Yelp"));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Business")));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Users"));

        jLabel7.setText("Member Since:");

        cmbRevInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "=, <, >", "=", "<", ">", "<=", ">=", "<>" }));

        jLabel9.setText("Review Count :");

        jLabel10.setText("value:");

        cmbNFreindInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "=, <, >", "=", "<", ">", "<=", ">=", "<>" }));

        jLabel11.setText("Number of Friends:");

        jLabel12.setText("value:");

        cmbAvgStarInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "=, <, >", "=", "<", ">", "<=", ">=", "<>" }));

        jLabel13.setText("Average Stars :");

        jLabel14.setText("Select :");

        cmbSelectInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AND, OR between attributes", "AND", "OR", " " }));

        jLabel15.setText("value:");

        jDateChooserMemberSince.setDate(date);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(cmbAvgStarInput, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAvgStarInput, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cmbSelectInput, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cmbNFreindInput, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbRevInput, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtRevCntInput, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtFrndCntInput))))
                            .addComponent(jDateChooserMemberSince, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooserMemberSince, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbRevInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRevCntInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbNFreindInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFrndCntInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbAvgStarInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAvgStarInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbSelectInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Sub-Category"));
        jPanel7.setLayout(new java.awt.GridLayout(0, 1));
        jScrollPane2.setViewportView(jPanel7);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Checkin"));

        cnbFrmDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" }));
        cnbFrmDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cnbFrmDayActionPerformed(evt);
            }
        });

        txtFrmHr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFrmHrActionPerformed(evt);
            }
        });

        jLabel1.setText("From:");

        jLabel2.setText("To:");

        cnbToDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" }));
        cnbToDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cnbToDayActionPerformed(evt);
            }
        });

        txtToHr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtToHrActionPerformed(evt);
            }
        });

        jLabel3.setText("Number of Checkins:");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "=, <, >", "=", "<", ">", "<=", ">=", "<>" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        txtCknInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCknInputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(txtCknInput, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cnbFrmDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cnbToDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFrmHr, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtToHr, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cnbFrmDay, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFrmHr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cnbToDay, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtToHr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3)
                    .addComponent(txtCknInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Review"));

        jLabel4.setText("From:");

        jLabel5.setText("To:");

        jLabel6.setText("Stars:");

        cmbStr.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "=, <, >", "=", "<", ">", "<=", ">=", "<>" }));

        txtVotes.setText("Votes:");

        cmbVotes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "=, <, >", "=", "<", ">", "<=", ">=", "<>" }));

        jDateChooser1.setDate(date);

        jDateChooser2.setDate(date);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(35, 35, 35)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtVotes)
                        .addGap(18, 18, 18)
                        .addComponent(cmbVotes, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtVotesInput, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(cmbStr, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtStrInput, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel4))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel5))
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtStrInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbStr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtVotes, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbVotes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtVotesInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnQuery.setText("ExecuteQuery");
        btnQuery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQueryActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Results"));

        ResultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        ResultTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        ResultTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ResultTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(ResultTable);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jQueryTextArea.setColumns(20);
        jQueryTextArea.setRows(5);
        jScrollPane6.setViewportView(jQueryTextArea);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Category"));
        jPanel6.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jPanel6ComponentAdded(evt);
            }
        });
        jPanel6.setLayout(new java.awt.GridLayout(0, 1));
        jScrollPane1.setViewportView(jPanel6);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(btnQuery)
                        .addGap(109, 109, 109))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQuery, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        jScrollPane4.setViewportView(jPanel1);

        buttonGroup1.add(jQueryUserRadioButton);
        jQueryUserRadioButton.setText("Query Yelp User");
        jQueryUserRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jQueryUserRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(jQueryBusinessRadioButton);
        jQueryBusinessRadioButton.setText("Query Yelp Business");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(499, 499, 499)
                        .addComponent(jQueryUserRadioButton)
                        .addGap(18, 18, 18)
                        .addComponent(jQueryBusinessRadioButton))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(461, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jQueryUserRadioButton)
                    .addComponent(jQueryBusinessRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4))
        );

        jScrollPane5.setViewportView(jPanel8);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1316, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5)
        );

        pack();
    }// </editor-fold>                        


    public void  createCategoryCheckboxes() throws SQLException, ClassNotFoundException { 
             con          = insertDB.openConnection();
             Statement stmt = con.createStatement(); 
             System.out.println("\n Selecting data");
             ResultSet result = stmt.executeQuery("Select distinct CATEGORIES from SUB_CATEGORY order by CATEGORIES"); 
             ResultSetMetaData meta = result.getMetaData(); 
           
             ItemListener itemListener = new ItemListener() {
                 public void itemStateChanged(ItemEvent itemEvent) {
                       AbstractButton abstractButton = (AbstractButton)itemEvent.getSource();
                       int state = itemEvent.getStateChange();
                       if (state == ItemEvent.SELECTED) {
                           try {
                                         selectedCategory = abstractButton.getText();
                                         createSubCategoryCheckboxes(selectedCategory);

                               } catch (SQLException ex) {
                                    Logger.getLogger(hw03.class.getName()).log(Level.SEVERE, null, ex);
                               } catch (ClassNotFoundException ex) {
                                  Logger.getLogger(hw03.class.getName()).log(Level.SEVERE, null, ex);
                               }
                       }else if (state == ItemEvent.DESELECTED){
                             try {
                                        unselectedCategory = abstractButton.getText();
                                        removeSubCategoryCheckboxes(unselectedCategory);
                                        
                                 } catch (SQLException ex) {
                                      Logger.getLogger(hw03.class.getName()).log(Level.SEVERE, null, ex);
                                 } catch (ClassNotFoundException ex) {
                               Logger.getLogger(hw03.class.getName()).log(Level.SEVERE, null, ex);
                              }
                       }
                }
            };
                  
             while (result.next()) { 
                 for (int col = 1 ; col <= meta.getColumnCount(); col++) { 
                        javax.swing.JCheckBox box = new javax.swing.JCheckBox(result.getString(col));
                        box.addItemListener(itemListener);
                        listCategories.add(result.getString(col));
                        add(box);
                 //     checksCat.add(box);
                        jPanel6.add(box);
                    } 
            }
            pack();                  
            System.out.println("\n the size list of all categories " +listCategories.size());
            stmt.close(); 
            insertDB.closeConnection(con);
    } 
    
  

    private void createSubCategoryCheckboxes(String selectedCategory ) throws SQLException, ClassNotFoundException { 
             con          = insertDB.openConnection();
             Statement stmt = con.createStatement(); 
  
             System.out.println("\n Selecting data");
             if(selectedCategory!= null){
                    if (a.length() == 0)
                        a = "'" + selectedCategory +"'";
                        //selectFrom.concat("'"+ selectedSubCategory.get(i) +"'");
                    else
                          a =",'" + selectedCategory +"'";
                    listSelectedCategories+= a;
        
                    System.out.println(listSelectedCategories);
                  
                    String query = "Select distinct SUBCATEGORIES from SUB_CATEGORY WHERE CATEGORIES = '"+selectedCategory +"' order by SUBCATEGORIES";
                    System.out.println("\n" + query);
                    ResultSet result = stmt.executeQuery(query); 
                    ResultSetMetaData meta = result.getMetaData();   
                        
            ItemListener itemListener = new ItemListener() {
                    public void itemStateChanged(ItemEvent itemEvent) {
                           AbstractButton abstractButton = (AbstractButton)itemEvent.getSource();
                           int state = itemEvent.getStateChange();
                           if (state == ItemEvent.SELECTED) {
                                   selectedSubcategory = abstractButton.getText();
                                   if (b.length() == 0)
                                             b = "'" + selectedSubcategory +"'";
                                             //selectFrom.concat("'"+ selectedSubCategory.get(i) +"'");
                                   else
                                             b =",'" + selectedSubcategory +"'";
                                 listSelectedSubCategories+= b;
                               
                            //   buildSelectedSubCategoryList(selectedSubCategory,null);
                                
                            }else if (state == ItemEvent.DESELECTED){
                                   unselectedSubcategory = abstractButton.getText();
                                   removeSelectSubCategory(unselectedSubcategory);
                              /*   if(listSelectedSubCategories.contains(unselectedSubcategory)){
                                  //  System.out.println("\n need to remove the category "+ unselectedSubcategory);
                                    listSelectedSubCategories = listSelectedSubCategories.replaceAll(unselectedSubcategory, "");
                              }*/
                           }
                    }
            };
             
            while (result.next()) { 
                   for (int col = 1 ; col <= meta.getColumnCount(); col++) { 
                          javax.swing.JCheckBox box = new javax.swing.JCheckBox(result.getString(col));
                          box.addItemListener(itemListener);
                          listSubCategories.add(result.getString(col));
                          add(box);
     //                   checksSubCat.add(box);
                          jPanel7.add(box); 
                    } 
            }
            pack(); 
           }
    //      System.out.println("checksSubCat after adding" +checksSubCat.size());
            System.out.println("list total SubCategory after adding "+listSubCategories.size());
    //      System.out.println("listSelectSubCat after adding"+listSelectSubCat.size());
            stmt.close(); 
            insertDB.closeConnection(con);     
    }
    
    
    private void removeSubCategoryCheckboxes(String unselectedCategory) throws SQLException, ClassNotFoundException { 
              con            = insertDB.openConnection();
          //  System.out.println("checksSubCat before removing " +checksSubCat.size());
              Statement stmt = con.createStatement(); 
              System.out.println("\n unselecting data");
              if(unselectedCategory!= null ){
                    if(listSelectedCategories.contains(",'"+unselectedCategory+"',")
                                                       || listSelectedCategories.contains("'"+unselectedCategory+"',") 
                                                       || listSelectedCategories.contains(",'"+unselectedCategory+"'")){
                       
            	   // if(listSelectedCategories.contains(unselectedCategory)){      
                        System.out.println("\n need to remove the category "+unselectedCategory);
                        listSelectedCategories = listSelectedCategories.replaceAll(unselectedCategory, "");
                    }
            	    
                 b="";
                 
                 listSelectedSubCategories="";
                 
                 jPanel7.removeAll();
                 jPanel7.revalidate();
                 jPanel7.repaint();
                 
     //      System.out.println("\n list of Selected SubCategories after Category unselected "+listSelectSubCategories.size());
             String query = "Select distinct SUBCATEGORIES from SUB_CATEGORY WHERE CATEGORIES = '"+ unselectedCategory +"' order by SUBCATEGORIES";
             System.out.println(query);
             ResultSet result = stmt.executeQuery(query); 
             ResultSetMetaData meta = result.getMetaData();   
             while (result.next()) { 
                 for (int col = 1 ; col <= meta.getColumnCount(); col++) { 
                          if(listSubCategories.contains(result.getString(col))){
                                   listSubCategories.remove(result.getString(col));  
                           } 
                 }     
             }   
           }
             
            ItemListener itemListener = new ItemListener() {
                    public void itemStateChanged(ItemEvent itemEvent) {
                        AbstractButton abstractButton = (AbstractButton)itemEvent.getSource();
                        int state = itemEvent.getStateChange();
                        if (state == ItemEvent.SELECTED) {
                                selectedSubcategory = abstractButton.getText();
                                if (b.length() == 0)
                                             b = "'" + selectedSubcategory +"'";
                                             //selectFrom.concat("'"+ selectedSubCategory.get(i) +"'");
                                else
                                             b =",'" + selectedSubcategory +"'";
                                              
                                listSelectedSubCategories+= b;
                               
                           //   buildSelectedSubCategoryList(selectedSubCategory,null);
                                
                        } else if (state == ItemEvent.DESELECTED){
                                unselectedSubcategory = abstractButton.getText();
                                removeSelectSubCategory(unselectedSubcategory);
                       }
                   }
            };
             
            for (int i = 0 ; i < listSubCategories.size(); i++) {
                 // System.out.println("listSubCat making checkbox"+listSubCat.get(i));
                    javax.swing.JCheckBox box = new javax.swing.JCheckBox(listSubCategories.get(i));
                    box.addItemListener(itemListener);
           
                    add(box);
                //  checksSubCat.add(box);
                   jPanel7.add(box); 
           }
               
           pack();
           System.out.println("\n list of total SubCategories after Category unselected "+listSubCategories.size());
           stmt.close();   
           insertDB.closeConnection(con);    
  }   
   
   private void removeSelectSubCategory(String unselectedSubcategory){
              if(listSelectedSubCategories.contains(",'"+unselectedSubcategory+"',") 
                                           || listSelectedSubCategories.contains("'"+unselectedSubcategory+"',") 
                                           || listSelectedSubCategories.contains(",'"+unselectedSubcategory+"'")){
                                    System.out.println("\n need to remove the category "+ unselectedSubcategory);
             //if(listSelectedCategories.contains(unselectedSubcategory)){ 	  
                       listSelectedSubCategories = listSelectedSubCategories.replaceAll(unselectedSubcategory, "");
             }
   } 
   
   private String createBusinessQuery(){
       
       String createBusiness = null;
       
       System.out.println("\n selected categories from query builder "+listSelectedCategories);
       
       System.out.println("\n selected subcategories from query builder "+listSelectedSubCategories);
       
       //create set of selected categories and subcategories filters
     /*  if (listSelectedCategories  == null)  
            listSelectedCategories = "''";
         if (listSelectedSubCategories == null)
            listSelectedSubCategories = "''"; 
     */
     
       if(listSelectedCategories == null || listSelectedSubCategories == null || listSelectedCategories == "" || listSelectedSubCategories == "")
                JOptionPane.showMessageDialog(new JFrame(),"Please select category and subcategories for business");
      //create set of checkin filters
        
       int fromday = 0;
       if(cnbFrmDay.getSelectedIndex() >= 0){
           fromday = cnbFrmDay.getSelectedIndex();
          // fromday = fromday;
       }
        
       int fromhour = 0 ;
       if (txtFrmHr.getText()== null || txtFrmHr.getText()=="" )
            JOptionPane.showMessageDialog(new JFrame(),"Enter Valid hours between 0 to 23");
       if (Integer.parseInt(txtFrmHr.getText()) >= 0 && Integer.parseInt(txtFrmHr.getText()) < 24)
           fromhour = Integer.parseInt(txtFrmHr.getText());
       else
           JOptionPane.showMessageDialog(new JFrame(),"Enter Valid hours between 0 to 23");
        
        int today = 6;
        if (cnbToDay.getSelectedIndex() >= 0){
                today = cnbToDay.getSelectedIndex();
              //  today = today;
        }
        
        int tohour = 23;
        if (txtToHr.getText()== null || txtToHr.getText()== "")
            JOptionPane.showMessageDialog(new JFrame(),"Enter Valid hours between 0 to 23");
        if (Integer.parseInt(txtToHr.getText()) >= 0 && Integer.parseInt(txtToHr.getText()) < 24)
             tohour =   Integer.parseInt(txtToHr.getText());
        else 
            JOptionPane.showMessageDialog(new JFrame(),"Enter Valid hours between 0 to 23");
        
        String checkin = ">";
        if(jComboBox3.getSelectedIndex() >= 0)
              checkin = jComboBox3.getSelectedItem().toString();
        
        int checkin_value = 0 ;
        if(txtCknInput.getText() == null || txtCknInput.getText()=="")
        	JOptionPane.showMessageDialog(new JFrame(),"Enter Valid Values in Numericals");
        else if (Integer.parseInt(txtCknInput.getText()) >= 0)
             checkin_value = Integer.parseInt(txtCknInput.getText());
       
       
       //create set of reviews filters   
        String from_date = (new SimpleDateFormat("YYYY-MM-dd")).format(jDateChooser1.getDate());
        String to_date = (new SimpleDateFormat("YYYY-MM-dd")).format(jDateChooser2.getDate());
        
        String stars_value=">" ;
        if(cmbStr.getSelectedIndex() >= 0)
                stars_value = cmbStr.getSelectedItem().toString();
        
        int star= 0 ;
        if (Integer.parseInt(txtStrInput.getText()) >= 0)
               star = Integer.parseInt(txtStrInput.getText());
        
        String votes_value = ">";
        if(cmbVotes.getSelectedIndex() >= 0)
               votes_value = cmbVotes.getSelectedItem().toString();
        int votes = 0 ;
        if (Integer.parseInt(txtVotesInput.getText()) >= 0)
               votes = Integer.parseInt(txtVotesInput.getText());
       /*
       String ReviewAndCategory = "SELECT B.BUSINESS_ID FROM BUSINESS B, REVIEWS R, SUB_CATEGORY S \n"
                                  + " WHERE B.BUSINESS_ID = R.BUSINESS_ID AND B.BUSINESS_ID = S.BUSINESS_ID \n"
                                  + " AND (S.CATEGORIES = ANY(" + listSelectedCategories + ") OR S.CATEGORIES IS NOT NULL) AND (S.SUBCATEGORIES=ANY(" + listSelectedSubCategories + ") OR S.SUBCATEGORIES IS NOT NULL) \n"
                                  + " AND R.STARS" + stars_value + star + " AND R.TOTAL_VOTES" + votes_value + votes  
                                  + " AND TO_DATE(R.PUBLISH_DATE,'yyyy-mm-dd')>=TO_DATE('"+ from_date + "','yyyy-mm-dd')\n" 
                                  + " AND TO_DATE(R.PUBLISH_DATE,'yyyy-mm-dd')<=TO_DATE('"+ to_date +"','yyyy-mm-dd')";
       */
        
        String ReviewAndCategory = "SELECT B.BUSINESS_ID FROM BUSINESS B, REVIEWS R, SUB_CATEGORY S \n"
                + " WHERE B.BUSINESS_ID = R.BUSINESS_ID AND B.BUSINESS_ID = S.BUSINESS_ID \n"
                + " AND S.CATEGORIES = ANY(" + listSelectedCategories + ")  AND S.SUBCATEGORIES=ANY(" + listSelectedSubCategories + ")  \n"
                + " AND R.STARS" + stars_value + star + " AND R.TOTAL_VOTES" + votes_value + votes  
                + " AND TO_DATE(R.PUBLISH_DATE,'yyyy-mm-dd')>=TO_DATE('"+ from_date + "','yyyy-mm-dd')\n" 
                + " AND TO_DATE(R.PUBLISH_DATE,'yyyy-mm-dd')<=TO_DATE('"+ to_date +"','yyyy-mm-dd')";
        
       createBusiness = "SELECT B.BUSINESS_NAME ,B.FULL_ADDRESS AS LOCATION ,B.CITY , B.STATE , B.STARS ,B.REVIEW_COUNT ,B.IS_OPEN ,BUSINESS_ID,B.ATTRIBUTES  FROM BUSINESS B WHERE B.BUSINESS_ID IN ((SELECT BUSINESS_ID FROM \n" 
                        + "((SELECT * FROM CHECKINS WHERE DAY_INDEX > " + fromday + " AND DAY_INDEX <" + today + ") \n" 
                        + "UNION (SELECT * FROM CHECKINS WHERE DAY_INDEX = " + fromday + " AND FROM_HOUR >= " + fromhour + ") \n"
                        + "UNION (SELECT * FROM CHECKINS WHERE DAY_INDEX =" + today + " AND FROM_HOUR <= " + tohour + ")) \n" 
                        + "GROUP BY BUSINESS_ID HAVING SUM(CHECKIN_COUNT)" + checkin + checkin_value + ") INTERSECT (" + ReviewAndCategory + "))";
      
       
       
      /* if (listSelectedCategories != null && listSelectedSubCategories != null)
        createBusiness = "SELECT B.BUSINESS_NAME, B.full_address , B.CITY ,B.State, B.review_count , B.IS_OPEN , B.Business_id FROM BUSINESS B, REVIEWS R ,CHECKINS C , SUB_CATEGORY S\n" 
                          +"WHERE B.BUSINESS_ID = R.BUSINESS_ID AND B.BUSINESS_ID = C.BUSINESS_ID AND S.BUSINESS_ID = B.BUSINESS_ID\n"
                          +"AND (S.CATEGORIES =ANY ("+ listSelectedCategories + ") OR S.CATEGORIES IS NOT NULL) AND (S.SUBCATEGORIES =ANY("+ listSelectedSubCategories +")OR S.SUBCATEGORIES IS NOT NULL)\n" 
                          + "GROUP BY B.BUSINESS_NAME, B.full_address , B.CITY ,B.State, B.review_count , B.IS_OPEN , B.Business_id";
       
       */
       
       return createBusiness;
   }
   
   
    private void displayBusinessResult(String selectBusiness) throws SQLException, ClassNotFoundException{
        con          = insertDB.openConnection();
       // Connecting_DB dbConnect = new Connecting_DB();
        try {
               Statement stmt = con.createStatement(); 
          // PreparedStatement pst = con.prepareStatement(selectBusiness);
             System.out.println(selectBusiness);
             ResultSet rs = stmt.executeQuery(selectBusiness); 
          //  ResultSet rs =  pst.executeQuery();
            DefaultTableModel displayDataTable = new DefaultTableModel();
            ResultSetMetaData metaData = rs.getMetaData();
               int columns = metaData.getColumnCount();
                String[]columnNames = new String[columns];
                for(int i=1;i<=columns;i++){
                    columnNames[i-1]= metaData.getColumnName(i);
                         
                }
                displayDataTable.setColumnIdentifiers(columnNames);
                
                //now populate the data
                while(rs.next()){
                    String[] rowData = new String[columns];
                    for(int i=1;i<=columns;i++){
                        rowData[i-1] = rs.getString(i);
                    }
                   displayDataTable.addRow(rowData);
                }
            ResultTable.setModel(displayDataTable);
            ResultTable.setVisible(true);
            ResultTable.setFillsViewportHeight(true);
             rs.close();
            stmt.close();
          //  dbConnect.closeConnection(con);
          //  jLabelQueryBuilder.setText("DbConnection Closed");
          jQueryTextArea.setText(selectBusiness);
          jQueryTextArea.setLineWrap(true);
        } catch (SQLException ex) {
            Logger.getLogger(hw03.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            insertDB.closeConnection(con);
        }
    }
    
    
    private void txtFrmHrActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void cnbToDayActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void txtToHrActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void txtCknInputActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void btnQueryActionPerformed(java.awt.event.ActionEvent evt) {                                         
         if(jQueryUserRadioButton.isSelected()){
             try {
                 //JOptionPane.showMessageDialog(new JFrame(),"USER");
                 String createUser = createUserQuery();
                 displayUserResult(createUser);
                 jQueryUserRadioButton.setSelected(false);
                 // displayUserResult();
             } catch (SQLException ex) {
                 Logger.getLogger(hw03.class.getName()).log(Level.SEVERE, null, ex);
             } catch (ClassNotFoundException ex) {
                 Logger.getLogger(hw03.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        else if(jQueryBusinessRadioButton.isSelected()){
             try {
                 // JOptionPane.showMessageDialog(new JFrame(),"BUSINESS ");
                 String createBusiness = createBusinessQuery();
                 displayBusinessResult(createBusiness);
                 //  jQueryBusinessRadioButton.setSelected(false);
                 //displayBusinessResult();
             } catch (SQLException ex) {
                 Logger.getLogger(hw03.class.getName()).log(Level.SEVERE, null, ex);
             } catch (ClassNotFoundException ex) {
                 Logger.getLogger(hw03.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        else
            JOptionPane.showMessageDialog(new JFrame(),"SELECT BUSINESS OR USER."); 
    }                                        
    
       private String createUserQuery(){
        String createUser = null;
        int revCountValue = 0;
        String revCountCondition = ">";
        int noOfFriendsValue = 0;
        String friendsCondition = ">";
        int avgStarsValue = 0;
        String avgStarsCondition = ">";
        String selectCondition = "OR";
   
        if((txtRevCntInput.getText()!=null)&&(cmbRevInput.getSelectedIndex() != 0)){
         revCountValue = Integer.parseInt(txtRevCntInput.getText());
         revCountCondition=cmbRevInput.getSelectedItem().toString();
        }
  
        if((txtFrndCntInput.getText()!=null)&&(cmbNFreindInput.getSelectedIndex() != 0)){
         noOfFriendsValue = Integer.parseInt(txtFrndCntInput.getText());
         friendsCondition=cmbNFreindInput.getSelectedItem().toString();
        }
 
         if((txtAvgStarInput.getText()!=null)&&(cmbAvgStarInput.getSelectedIndex() != 0)){
         avgStarsValue=Integer.parseInt(txtAvgStarInput.getText());
         avgStarsCondition=cmbAvgStarInput.getSelectedItem().toString();
        }
        
        if(!("AND, OR between attributes".equals(cmbSelectInput.getSelectedItem().toString())))
      
            selectCondition = cmbSelectInput.getSelectedItem().toString();
        
        String memSince = (new SimpleDateFormat("YYYY-MM")).format(jDateChooserMemberSince.getDate());
        
        createUser = "SELECT Y.NAME AS USER_NAME , Y.YELPING_SINCE ,Y.REVIEW_COUNT ,Y.TOTAL_FRIENDS ,Y.AVERAGE_STARS,Y.TOTAL_VOTES,Y.FANS,USER_ID  FROM YELP_USER Y WHERE Y.REVIEW_COUNT" 
                + revCountCondition + revCountValue + selectCondition+" Y.TOTAL_FRIENDS" 
                + friendsCondition +noOfFriendsValue + selectCondition+" Y.AVERAGE_STARS" 
                + avgStarsCondition + avgStarsValue+ selectCondition+" TO_DATE(Y.YELPING_SINCE, 'yyyy-mm') > TO_DATE('" 
                + memSince+ "', 'yyyy-mm')";
        
        return createUser;
    }
       
    private void displayUserResult(String selectUser) throws SQLException, ClassNotFoundException{
        con          = insertDB.openConnection();
       // Connecting_DB dbConnect = new Connecting_DB();
        try {
                System.out.println(selectUser);
           PreparedStatement pst = con.prepareStatement(selectUser);
            ResultSet rs =  pst.executeQuery();
            DefaultTableModel displayDataTable = new DefaultTableModel();
            ResultSetMetaData metaData = rs.getMetaData();
               int columns = metaData.getColumnCount();
                String[]columnNames = new String[columns];
                for(int i=1;i<=columns;i++){
                    columnNames[i-1]= metaData.getColumnName(i);
                         
                }
                displayDataTable.setColumnIdentifiers(columnNames);
                
                //now populate the data
                while(rs.next()){
                    String[] rowData = new String[columns];
                    for(int i=1;i<=columns;i++){
                        rowData[i-1] = rs.getString(i);
                    }
                   displayDataTable.addRow(rowData);
                }
            ResultTable.setModel(displayDataTable);
            ResultTable.setVisible(true);
            ResultTable.setFillsViewportHeight(true);
             rs.close();
            pst.close();
          //  dbConnect.closeConnection(con);
          //  jLabelQueryBuilder.setText("DbConnection Closed");
          jQueryTextArea.setText(selectUser);
          jQueryTextArea.setLineWrap(true);
             } catch (SQLException ex) {
            Logger.getLogger(hw03.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            insertDB.closeConnection(con);
        }
    }
    
    private void cnbFrmDayActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void jPanel6ComponentAdded(java.awt.event.ContainerEvent evt) {                                       
         // TODO add your handling code here:
    }                                      

    private void ResultTableMouseClicked(java.awt.event.MouseEvent evt) {                                         
          try {
                con          = insertDB.openConnection();
              // TODO add your handling code here:
              int row = ResultTable.getSelectedRow();
              int column = ResultTable.getColumnCount();
              JFrame reviewFrame = new JFrame("Reviews");
              JPanel reviewPanel = new JPanel();
              JScrollPane reviewPcrollPane ;
              JTable reviewTable= new JTable();
              String match_id = null;
              String user_id = null;
              String business_id =null;
              String query = null ;
              String match_col = null ;
              
              if(jQueryBusinessRadioButton.isSelected()){
                  match_col  = "BUSINESS_ID";
                  query = "SELECT B.business_name AS BUSINESS_NAME, R.publish_date AS REVIEWED_ON, R.TEXT AS REVIEW_TEXT from BUSINESS B, REVIEWS R \n" +
                      "WHERE B.business_id=R.business_id AND R.business_id =?" ;
              }else if (jQueryUserRadioButton.isSelected()){
                  match_col  = "USER_ID";
                  query = "SELECT B.business_name AS BUSINESS_NAME, R.publish_date AS REVIEWED_ON, R.TEXT AS REVIEW_TEXT from BUSINESS B, REVIEWS R \n" +
                      "WHERE B.business_id=R.business_id AND R.user_id =?" ;
                 // PreparedStatement pst = con.prepareStatement(query);
                 // pst.setString(1, match_id);
              }
              
              for(int i=0;i<column;i++){
                  String temp = ResultTable.getColumnName(i);
                  if(ResultTable.getColumnName(i).equalsIgnoreCase(match_col))
                      match_id = (String) ResultTable.getValueAt(row,i);
                  continue;
              }
              
             // con = insertDB.openConnection();
              PreparedStatement pst = con.prepareStatement(query);
              if(jQueryBusinessRadioButton.isSelected()){
                   business_id = match_id ;
                  pst.setString(1, business_id);
              }else if (jQueryUserRadioButton.isSelected()){
                   user_id= match_id  ;
                  pst.setString(1, user_id);
              }
              ResultSet rs = pst.executeQuery();
              ResultSetMetaData metaData = rs.getMetaData();
              //int review_column = metaData.getColumnCount();
              DefaultTableModel displayDataTable = new DefaultTableModel();
              
              int columns = metaData.getColumnCount();
              String[]columnNames = new String[columns];
              for(int i=1;i<=columns;i++){
                  columnNames[i-1]= metaData.getColumnName(i);     
              }
                 displayDataTable.setColumnIdentifiers(columnNames);
                
                //now populate the data
                while(rs.next()){
                    String[] rowData = new String[columns];
                    for(int i=1;i<=columns;i++){
                        rowData[i-1] = rs.getString(i);
                    }
                   displayDataTable.addRow(rowData);
                }
            
             rs.close();
            pst.close();
           // insertDB.closeConnection(con);
             if(column==0)
                  JOptionPane.showMessageDialog(reviewFrame, "No Reviews ");    
                 else{
                     reviewFrame.setSize(1300, 200);
                     reviewFrame.setLocationRelativeTo(null);
                     reviewPanel.setLayout(new BorderLayout());
                     reviewFrame.getContentPane().add(reviewPanel);
                     
                     reviewTable.setModel(displayDataTable);
                     reviewTable.getColumnModel().getColumn(0).setPreferredWidth(100);
                     reviewTable.getColumnModel().getColumn(1).setPreferredWidth(3);
                     reviewTable.getColumnModel().getColumn(2).setPreferredWidth(1000);
                     reviewPcrollPane = new JScrollPane(reviewTable);
                     reviewPcrollPane.setVisible(true);
                     reviewPanel.add(reviewPcrollPane,BorderLayout.CENTER);
                     reviewFrame.setVisible(true);
                     
                     reviewTable.setVisible(true);
                     reviewTable.setFillsViewportHeight(true);
                 }
                   //JOptionPane.showMessageDialog(frame, display); 
                 // pst.close();
                rs.close();
               // insertDB.closeConnection(con);
          } catch (SQLException ex) {
              Logger.getLogger(hw03.class.getName()).log(Level.SEVERE, null, ex);
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(hw03.class.getName()).log(Level.SEVERE, null, ex);
          }finally{
              insertDB.closeConnection(con);
          }
    }                                        

    private void jQueryUserRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                      
        // TODO add your handling code here:
    }                                                     

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])  {

        //try {
            /* Set the Nimbus look and feel */
            //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
            /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
            * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
            */
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(hw03.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(hw03.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(hw03.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(hw03.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>
            //</editor-fold>
         //   insertDB     = new InsertToDB();
         //   con          = insertDB.openConnection();
            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        new hw03().setVisible(true);
                    } catch (SQLException ex) {
                        Logger.getLogger(hw03.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(hw03.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
    
      /*  } catch (ClassNotFoundException ex) {
              Logger.getLogger(hw03.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
              Logger.getLogger(hw03.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
        //     insertDB.closeConnection(con);
        } */
    }

    // Variables declaration - do not modify                     
    private javax.swing.JTable ResultTable;
    private javax.swing.JButton btnQuery;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmbAvgStarInput;
    private javax.swing.JComboBox<String> cmbNFreindInput;
    private javax.swing.JComboBox<String> cmbRevInput;
    private javax.swing.JComboBox<String> cmbSelectInput;
    private javax.swing.JComboBox<String> cmbStr;
    private javax.swing.JComboBox<String> cmbVotes;
    private javax.swing.JComboBox<String> cnbFrmDay;
    private javax.swing.JComboBox<String> cnbToDay;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JComboBox<String> jComboBox3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooserMemberSince;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JRadioButton jQueryBusinessRadioButton;
    private javax.swing.JTextArea jQueryTextArea;
    private javax.swing.JRadioButton jQueryUserRadioButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextField txtAvgStarInput;
    private javax.swing.JTextField txtCknInput;
    private javax.swing.JTextField txtFrmHr;
    private javax.swing.JTextField txtFrndCntInput;
    private javax.swing.JTextField txtRevCntInput;
    private javax.swing.JTextField txtStrInput;
    private javax.swing.JTextField txtToHr;
    private javax.swing.JLabel txtVotes;
    private javax.swing.JTextField txtVotesInput;
    // End of variables declaration                   
}
