
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Aymen
 */
public class AdminPage extends javax.swing.JFrame {

    /**
     * Creates new form AdminPage
     * 
     */
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection connection = null;
    boolean editable =false;
    
    DefaultTableModel pdefaultTableModel = new DefaultTableModel();
    Object columns[] = {"Id", "First Name", "Last Name", "Phone", "Gender", "Age", "Blood Group", "Date", "Address"};
    
    DefaultTableModel DdefaultTableModel = new DefaultTableModel();
    Object dcolumns[] = {"Id", "First Name", "Last Name", "Phone", "Gender", "Age", "Department", "Email", "Address"};
   
    DefaultTableModel RdefaultTableModel = new DefaultTableModel();
    Object rcolumns[] = {"Id", "First Name", "Last Name", "Phone", "Gender", "Age", "Email", "Address"};
   
    DefaultTableModel NdefaultTableModel = new DefaultTableModel();
    Object ncolumns[] = {"Id", "First Name", "Last Name", "Phone", "Gender", "Age", "Email", "Address"};
    
    public AdminPage() {
        initComponents();
        
        pdefaultTableModel.setColumnIdentifiers(columns);
        PatientTable.setModel(pdefaultTableModel);
        
        DdefaultTableModel.setColumnIdentifiers(dcolumns);
        DoctorTable.setModel(pdefaultTableModel);
        
        RdefaultTableModel.setColumnIdentifiers(rcolumns);
        ReceptionistTable.setModel(pdefaultTableModel);
        
        NdefaultTableModel.setColumnIdentifiers(ncolumns);
        NurseTable.setModel(pdefaultTableModel);
    
    }
    
    public void loadPatientData() {
       pdefaultTableModel.setRowCount(0);
        pdefaultTableModel.setColumnIdentifiers(columns);
        PatientTable.setModel(pdefaultTableModel);
        connection = Connector.ConnectDb();
        String sql = "select patientid,firstName,lastName,mobileno,gender,age,bloodgroup,dateAdded,address from Patient";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            Object columnData[] = new Object[9];
            while (rs.next()) {
                columnData[0] = rs.getInt("patientid");
                columnData[1] = rs.getString("firstName");
                columnData[2] = rs.getString("lastName");
                columnData[3] = rs.getString("mobileno");
                columnData[4] = rs.getString("gender");
                columnData[5] = rs.getInt("age");
                columnData[6] = rs.getString("bloodgroup");
                columnData[7] = rs.getString("dateAdded");
                columnData[8] = rs.getString("address");
                
                pdefaultTableModel.addRow(columnData);
    
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void loadDoctorData() {
        DdefaultTableModel.setRowCount(0);
        DdefaultTableModel.setColumnIdentifiers(dcolumns);
        DoctorTable.setModel(DdefaultTableModel);
        connection = Connector.ConnectDb();
        String sql = "SELECT doctorId,firstName,lastName,mobileNo,gender,age,Name,email,homeAddress FROM Doctor,Staff,Department WHERE StaffType='Doctor' AND stId =staffId";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            Object columnData[] = new Object[9];
            while (rs.next()) {
                columnData[0] = rs.getInt("doctorid");
                columnData[1] = rs.getString("firstName");
                columnData[2] = rs.getString("lastName");
                columnData[3] = rs.getString("mobileno");
                columnData[4] = rs.getString("gender");
                columnData[5] = rs.getInt("age");
                columnData[6] = rs.getString("Name");
                columnData[7] = rs.getString("email");
                columnData[8] = rs.getString("homeAddress");
                
                
                DdefaultTableModel.addRow(columnData);
                
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void loadReceptionistData() {
        RdefaultTableModel.setRowCount(0);
        RdefaultTableModel.setColumnIdentifiers(rcolumns);
        ReceptionistTable.setModel(RdefaultTableModel);
        connection = Connector.ConnectDb();
        String sql = "SELECT rId,firstName,lastName,mobileNo,gender,age,email,homeAddress FROM Receptionist,Staff WHERE StaffType='Receptionist' AND stId=staffId";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            Object columnData[] = new Object[8];
            while (rs.next()) {
                columnData[0] = rs.getInt("rId");
                columnData[1] = rs.getString("firstName");
                columnData[2] = rs.getString("lastName");
                columnData[3] = rs.getString("mobileno");
                columnData[4] = rs.getString("gender");
                columnData[5] = rs.getInt("age");
                columnData[6] = rs.getString("email");
                columnData[7] = rs.getString("homeAddress");
                
                
                RdefaultTableModel.addRow(columnData);
    
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void loadNurseData() {
        NdefaultTableModel.setRowCount(0);
        NdefaultTableModel.setColumnIdentifiers(ncolumns);
        NurseTable.setModel(NdefaultTableModel);
        connection = Connector.ConnectDb();
        String sql = "SELECT nurseId,firstName,lastName,mobileNo,gender,age,email,homeAddress FROM NURSE,Staff WHERE StaffType='Nurse' AND stId=staffId";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            Object columnData[] = new Object[8];
            while (rs.next()) {
                columnData[0] = rs.getInt("nurseid");
                columnData[1] = rs.getString("firstName");
                columnData[2] = rs.getString("lastName");
                columnData[3] = rs.getString("mobileno");
                columnData[4] = rs.getString("gender");
                columnData[5] = rs.getInt("age");
                columnData[6] = rs.getString("email");
                columnData[7] = rs.getString("homeAddress");
                
                
                NdefaultTableModel.addRow(columnData);
    
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField15 = new javax.swing.JTextField();
        SidePanel = new javax.swing.JPanel();
        Receptionistbtn = new javax.swing.JLabel();
        Patientsbtn = new javax.swing.JLabel();
        Doctorsbtn = new javax.swing.JLabel();
        Nursebtn = new javax.swing.JLabel();
        CenterPanel = new javax.swing.JPanel();
        Receptionist = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ReceptionistTable = new javax.swing.JTable();
        AddReceptionistbtn = new javax.swing.JButton();
        EditReceptionistbtn = new javax.swing.JButton();
        DeleteReceptionistbtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        SearchPhone = new javax.swing.JTextField();
        SearchId = new javax.swing.JTextField();
        SearchLastName = new javax.swing.JTextField();
        SearchEmail = new javax.swing.JTextField();
        SearchFirstName = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        Patient = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        PatientTable = new javax.swing.JTable();
        AddPatientbtn = new javax.swing.JButton();
        EditPatientbtn = new javax.swing.JButton();
        DeletePatientbtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        SearchPhone1 = new javax.swing.JTextField();
        SearchId1 = new javax.swing.JTextField();
        SearchLastName1 = new javax.swing.JTextField();
        SearchBlood1 = new javax.swing.JTextField();
        SearchFirstName1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        Doctor = new javax.swing.JPanel();
        SearchId2 = new javax.swing.JTextField();
        SearchLastName2 = new javax.swing.JTextField();
        SearchFirstName2 = new javax.swing.JTextField();
        SearchPhone2 = new javax.swing.JTextField();
        SearchEmail2 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        DoctorTable = new javax.swing.JTable();
        AddDoctorbtn = new javax.swing.JButton();
        EditDoctorbtn = new javax.swing.JButton();
        DeleteDoctorbtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Nurse = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        NurseTable = new javax.swing.JTable();
        AddNursebtn = new javax.swing.JButton();
        EditNursebtn = new javax.swing.JButton();
        DeleteNursebtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        SearchId3 = new javax.swing.JTextField();
        SearchLastName3 = new javax.swing.JTextField();
        SearchFirstName3 = new javax.swing.JTextField();
        SearchPhone3 = new javax.swing.JTextField();
        SearchEmail3 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        jTextField15.setText("Id"); // NOI18N
        jTextField15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField15ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(getMaximumSize());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SidePanel.setBackground(new java.awt.Color(0, 102, 102));
        SidePanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SidePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Receptionistbtn.setBackground(new java.awt.Color(0, 153, 153));
        Receptionistbtn.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        Receptionistbtn.setForeground(new java.awt.Color(255, 255, 255));
        Receptionistbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_businesswoman_40px_1.png"))); // NOI18N
        Receptionistbtn.setText("Receptionist");
        Receptionistbtn.setOpaque(true);
        Receptionistbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ReceptionistbtnMouseClicked(evt);
            }
        });
        SidePanel.add(Receptionistbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 190, 40));

        Patientsbtn.setBackground(new java.awt.Color(0, 153, 153));
        Patientsbtn.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        Patientsbtn.setForeground(new java.awt.Color(255, 255, 255));
        Patientsbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_fever_40px.png"))); // NOI18N
        Patientsbtn.setText("Patients");
        Patientsbtn.setOpaque(true);
        Patientsbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PatientsbtnMouseClicked(evt);
            }
        });
        SidePanel.add(Patientsbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 190, 40));

        Doctorsbtn.setBackground(new java.awt.Color(0, 153, 153));
        Doctorsbtn.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        Doctorsbtn.setForeground(new java.awt.Color(255, 255, 255));
        Doctorsbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_doctor_male_40px.png"))); // NOI18N
        Doctorsbtn.setText("Doctors");
        Doctorsbtn.setOpaque(true);
        Doctorsbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DoctorsbtnMouseClicked(evt);
            }
        });
        SidePanel.add(Doctorsbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 190, -1));

        Nursebtn.setBackground(new java.awt.Color(0, 153, 153));
        Nursebtn.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        Nursebtn.setForeground(new java.awt.Color(255, 255, 255));
        Nursebtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_businesswoman_40px_1.png"))); // NOI18N
        Nursebtn.setText("Nurse");
        Nursebtn.setOpaque(true);
        Nursebtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NursebtnMouseClicked(evt);
            }
        });
        SidePanel.add(Nursebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 190, 40));

        getContentPane().add(SidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 550));
        SidePanel.getAccessibleContext().setAccessibleName("");

        CenterPanel.setLayout(new java.awt.CardLayout());

        Receptionist.setBackground(new java.awt.Color(204, 204, 255));

        ReceptionistTable.setAutoCreateRowSorter(true);
        ReceptionistTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Name", "Phone", "Gender", "Age", "Blood Type", "Email", "Address"
            }
        ));
        ReceptionistTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(ReceptionistTable);

        AddReceptionistbtn.setBackground(new java.awt.Color(51, 255, 51));
        AddReceptionistbtn.setForeground(new java.awt.Color(255, 255, 255));
        AddReceptionistbtn.setText("Add");
        AddReceptionistbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddReceptionistbtnActionPerformed(evt);
            }
        });

        EditReceptionistbtn.setBackground(new java.awt.Color(51, 51, 255));
        EditReceptionistbtn.setForeground(new java.awt.Color(255, 255, 255));
        EditReceptionistbtn.setText("Edit");
        EditReceptionistbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditReceptionistbtnActionPerformed(evt);
            }
        });

        DeleteReceptionistbtn.setBackground(new java.awt.Color(255, 51, 51));
        DeleteReceptionistbtn.setForeground(new java.awt.Color(255, 255, 255));
        DeleteReceptionistbtn.setText("Delete");
        DeleteReceptionistbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteReceptionistbtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Receptionist");

        SearchPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchPhoneActionPerformed(evt);
            }
        });
        SearchPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchPhoneKeyReleased(evt);
            }
        });

        SearchId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchIdKeyReleased(evt);
            }
        });

        SearchLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchLastNameActionPerformed(evt);
            }
        });
        SearchLastName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchLastNameKeyReleased(evt);
            }
        });

        SearchEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchEmailActionPerformed(evt);
            }
        });
        SearchEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchEmailKeyReleased(evt);
            }
        });

        SearchFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchFirstNameActionPerformed(evt);
            }
        });
        SearchFirstName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchFirstNameKeyReleased(evt);
            }
        });

        jLabel21.setText("ID");

        jLabel22.setText("Phone");

        jLabel23.setText("Last Name");

        jLabel24.setText("Email");

        jLabel25.setText("First Name");

        javax.swing.GroupLayout ReceptionistLayout = new javax.swing.GroupLayout(Receptionist);
        Receptionist.setLayout(ReceptionistLayout);
        ReceptionistLayout.setHorizontalGroup(
            ReceptionistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReceptionistLayout.createSequentialGroup()
                .addGroup(ReceptionistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ReceptionistLayout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(AddReceptionistbtn)
                        .addGap(141, 141, 141)
                        .addComponent(EditReceptionistbtn)
                        .addGap(133, 133, 133)
                        .addComponent(DeleteReceptionistbtn)
                        .addGap(0, 203, Short.MAX_VALUE))
                    .addGroup(ReceptionistLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(ReceptionistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(ReceptionistLayout.createSequentialGroup()
                                .addGroup(ReceptionistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addGroup(ReceptionistLayout.createSequentialGroup()
                                        .addGroup(ReceptionistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(SearchId, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(ReceptionistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel25)
                                            .addComponent(SearchFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(43, 43, 43)
                                        .addGroup(ReceptionistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel23)
                                            .addComponent(SearchLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(61, 61, 61)
                                .addGroup(ReceptionistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22)
                                    .addComponent(SearchPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(ReceptionistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ReceptionistLayout.createSequentialGroup()
                                        .addComponent(jLabel24)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(SearchEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)))))
                .addContainerGap())
        );
        ReceptionistLayout.setVerticalGroup(
            ReceptionistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ReceptionistLayout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addGroup(ReceptionistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jLabel23)
                    .addComponent(jLabel22)
                    .addComponent(jLabel24)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ReceptionistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchId, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ReceptionistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddReceptionistbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EditReceptionistbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteReceptionistbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        CenterPanel.add(Receptionist, "card2");

        Patient.setBackground(new java.awt.Color(204, 204, 255));

        PatientTable.setAutoCreateRowSorter(true);
        PatientTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Name", "Phone", "Gender", "Age", "Blood Type", "Email", "Address"
            }
        ));
        PatientTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(PatientTable);

        AddPatientbtn.setBackground(new java.awt.Color(51, 255, 51));
        AddPatientbtn.setForeground(new java.awt.Color(255, 255, 255));
        AddPatientbtn.setText("Add");
        AddPatientbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddPatientbtnActionPerformed(evt);
            }
        });

        EditPatientbtn.setBackground(new java.awt.Color(51, 51, 255));
        EditPatientbtn.setForeground(new java.awt.Color(255, 255, 255));
        EditPatientbtn.setText("Edit");
        EditPatientbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditPatientbtnActionPerformed(evt);
            }
        });

        DeletePatientbtn.setBackground(new java.awt.Color(255, 51, 51));
        DeletePatientbtn.setForeground(new java.awt.Color(255, 255, 255));
        DeletePatientbtn.setText("Delete");
        DeletePatientbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletePatientbtnActionPerformed(evt);
            }
        });

        jLabel2.setText("Patient");

        SearchPhone1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchPhone1ActionPerformed(evt);
            }
        });
        SearchPhone1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchPhone1KeyReleased(evt);
            }
        });

        SearchId1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchId1KeyReleased(evt);
            }
        });

        SearchLastName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchLastName1ActionPerformed(evt);
            }
        });
        SearchLastName1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchLastName1KeyReleased(evt);
            }
        });

        SearchBlood1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBlood1ActionPerformed(evt);
            }
        });
        SearchBlood1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchBlood1KeyReleased(evt);
            }
        });

        SearchFirstName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchFirstName1ActionPerformed(evt);
            }
        });
        SearchFirstName1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchFirstName1KeyReleased(evt);
            }
        });

        jLabel16.setText("Blood Group");

        jLabel17.setText("First Name");

        jLabel18.setText("ID");

        jLabel19.setText("Last Name");

        jLabel20.setText("Phone");

        javax.swing.GroupLayout PatientLayout = new javax.swing.GroupLayout(Patient);
        Patient.setLayout(PatientLayout);
        PatientLayout.setHorizontalGroup(
            PatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatientLayout.createSequentialGroup()
                .addGap(191, 191, 191)
                .addComponent(AddPatientbtn)
                .addGap(141, 141, 141)
                .addComponent(EditPatientbtn)
                .addGap(133, 133, 133)
                .addComponent(DeletePatientbtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PatientLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PatientLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PatientLayout.createSequentialGroup()
                        .addGroup(PatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SearchId1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addGap(18, 18, 18)
                        .addGroup(PatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(SearchFirstName1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(PatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SearchLastName1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addGap(61, 61, 61)
                        .addGroup(PatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(SearchPhone1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(PatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SearchBlood1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addGap(40, 40, 40)))
                .addContainerGap())
        );
        PatientLayout.setVerticalGroup(
            PatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PatientLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(PatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel16)
                    .addComponent(jLabel18))
                .addGap(10, 10, 10)
                .addGroup(PatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchFirstName1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchPhone1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchId1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchLastName1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchBlood1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddPatientbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EditPatientbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeletePatientbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        CenterPanel.add(Patient, "card2");

        Doctor.setBackground(new java.awt.Color(204, 204, 255));

        SearchId2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchId2KeyReleased(evt);
            }
        });

        SearchLastName2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchLastName2ActionPerformed(evt);
            }
        });
        SearchLastName2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchLastName2KeyReleased(evt);
            }
        });

        SearchFirstName2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchFirstName2ActionPerformed(evt);
            }
        });
        SearchFirstName2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchFirstName2KeyReleased(evt);
            }
        });

        SearchPhone2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchPhone2ActionPerformed(evt);
            }
        });
        SearchPhone2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchPhone2KeyReleased(evt);
            }
        });

        SearchEmail2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchEmail2ActionPerformed(evt);
            }
        });
        SearchEmail2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchEmail2KeyReleased(evt);
            }
        });

        DoctorTable.setAutoCreateRowSorter(true);
        DoctorTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Name", "Phone", "Gender", "Age", "Blood Type", "Email", "Address"
            }
        ));
        DoctorTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(DoctorTable);

        AddDoctorbtn.setBackground(new java.awt.Color(51, 255, 51));
        AddDoctorbtn.setForeground(new java.awt.Color(255, 255, 255));
        AddDoctorbtn.setText("Add");
        AddDoctorbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddDoctorbtnActionPerformed(evt);
            }
        });

        EditDoctorbtn.setBackground(new java.awt.Color(51, 51, 255));
        EditDoctorbtn.setForeground(new java.awt.Color(255, 255, 255));
        EditDoctorbtn.setText("Edit");
        EditDoctorbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditDoctorbtnActionPerformed(evt);
            }
        });

        DeleteDoctorbtn.setBackground(new java.awt.Color(255, 51, 51));
        DeleteDoctorbtn.setForeground(new java.awt.Color(255, 255, 255));
        DeleteDoctorbtn.setText("Delete");
        DeleteDoctorbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteDoctorbtnActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Doctors");

        jLabel6.setText("ID");

        jLabel7.setText("First Name");

        jLabel8.setText("Last Name");

        jLabel9.setText("Phone");

        jLabel10.setText("Department");

        javax.swing.GroupLayout DoctorLayout = new javax.swing.GroupLayout(Doctor);
        Doctor.setLayout(DoctorLayout);
        DoctorLayout.setHorizontalGroup(
            DoctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DoctorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
            .addGroup(DoctorLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(DoctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DoctorLayout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(AddDoctorbtn)
                        .addGap(141, 141, 141)
                        .addComponent(EditDoctorbtn)
                        .addGap(133, 133, 133)
                        .addComponent(DeleteDoctorbtn)
                        .addContainerGap(209, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DoctorLayout.createSequentialGroup()
                        .addGroup(DoctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SearchId2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(DoctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(SearchFirstName2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(DoctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SearchLastName2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(32, 32, 32)
                        .addGroup(DoctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SearchPhone2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(DoctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(SearchEmail2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(89, 89, 89))))
            .addGroup(DoctorLayout.createSequentialGroup()
                .addGap(394, 394, 394)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DoctorLayout.setVerticalGroup(
            DoctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DoctorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DoctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DoctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchFirstName2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchPhone2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchEmail2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchId2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchLastName2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(DoctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddDoctorbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EditDoctorbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteDoctorbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        CenterPanel.add(Doctor, "card2");

        Nurse.setBackground(new java.awt.Color(204, 204, 255));

        NurseTable.setAutoCreateRowSorter(true);
        NurseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Name", "Phone", "Gender", "Age", "Blood Type", "Email", "Address"
            }
        ));
        NurseTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(NurseTable);

        AddNursebtn.setBackground(new java.awt.Color(51, 255, 51));
        AddNursebtn.setForeground(new java.awt.Color(255, 255, 255));
        AddNursebtn.setText("Add");
        AddNursebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddNursebtnActionPerformed(evt);
            }
        });

        EditNursebtn.setBackground(new java.awt.Color(51, 51, 255));
        EditNursebtn.setForeground(new java.awt.Color(255, 255, 255));
        EditNursebtn.setText("Edit");
        EditNursebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditNursebtnActionPerformed(evt);
            }
        });

        DeleteNursebtn.setBackground(new java.awt.Color(255, 51, 51));
        DeleteNursebtn.setForeground(new java.awt.Color(255, 255, 255));
        DeleteNursebtn.setText("Delete");
        DeleteNursebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteNursebtnActionPerformed(evt);
            }
        });

        jLabel4.setText("Nurse");

        SearchId3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchId3KeyReleased(evt);
            }
        });

        SearchLastName3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchLastName3ActionPerformed(evt);
            }
        });
        SearchLastName3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchLastName3KeyReleased(evt);
            }
        });

        SearchFirstName3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchFirstName3ActionPerformed(evt);
            }
        });
        SearchFirstName3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchFirstName3KeyReleased(evt);
            }
        });

        SearchPhone3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchPhone3ActionPerformed(evt);
            }
        });
        SearchPhone3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchPhone3KeyReleased(evt);
            }
        });

        SearchEmail3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchEmail3ActionPerformed(evt);
            }
        });
        SearchEmail3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchEmail3KeyReleased(evt);
            }
        });

        jLabel11.setText("Email");

        jLabel12.setText("First Name");

        jLabel13.setText("ID");

        jLabel14.setText("Last Name");

        jLabel15.setText("Phone");

        javax.swing.GroupLayout NurseLayout = new javax.swing.GroupLayout(Nurse);
        Nurse.setLayout(NurseLayout);
        NurseLayout.setHorizontalGroup(
            NurseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NurseLayout.createSequentialGroup()
                .addGap(191, 191, 191)
                .addComponent(AddNursebtn)
                .addGap(141, 141, 141)
                .addComponent(EditNursebtn)
                .addGap(133, 133, 133)
                .addComponent(DeleteNursebtn)
                .addContainerGap(209, Short.MAX_VALUE))
            .addGroup(NurseLayout.createSequentialGroup()
                .addGroup(NurseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NurseLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4))
                    .addGroup(NurseLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(NurseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SearchId3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(NurseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(NurseLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(127, 127, 127)
                                .addComponent(jLabel14))
                            .addGroup(NurseLayout.createSequentialGroup()
                                .addComponent(SearchFirstName3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(NurseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(NurseLayout.createSequentialGroup()
                                        .addGap(86, 86, 86)
                                        .addComponent(jLabel4))
                                    .addGroup(NurseLayout.createSequentialGroup()
                                        .addGap(55, 55, 55)
                                        .addComponent(SearchLastName3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addGroup(NurseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(SearchPhone3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel15))
                                        .addGap(18, 18, 18)
                                        .addGroup(NurseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addComponent(SearchEmail3, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        NurseLayout.setVerticalGroup(
            NurseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NurseLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(NurseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(NurseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchFirstName3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchPhone3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchEmail3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchId3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchLastName3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(NurseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddNursebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EditNursebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteNursebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        CenterPanel.add(Nurse, "card2");

        getContentPane().add(CenterPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 890, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DoctorsbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DoctorsbtnMouseClicked
        // TODO add your handling code here:
      
        loadDoctorData();
        Doctor.setVisible(true);
        Patient.setVisible(false);
        Receptionist.setVisible(false);
        Nurse.setVisible(false);
    }//GEN-LAST:event_DoctorsbtnMouseClicked

    private void PatientsbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PatientsbtnMouseClicked
        // TODO add your handling code here:
        
        
        loadPatientData();
        Doctor.setVisible(false);
        Patient.setVisible(true);
        Receptionist.setVisible(false);
        Nurse.setVisible(false);
    }//GEN-LAST:event_PatientsbtnMouseClicked

    private void ReceptionistbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReceptionistbtnMouseClicked
        // TODO add your handling code here:
        
        loadReceptionistData();
        Doctor.setVisible(false);
        Patient.setVisible(false);
        Receptionist.setVisible(true);
        Nurse.setVisible(false);
        
    }//GEN-LAST:event_ReceptionistbtnMouseClicked

    
    private void jTextField15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField15ActionPerformed

    private void NursebtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NursebtnMouseClicked
        // TODO add your handling code here:
        loadNurseData();
        Doctor.setVisible(false);
        Patient.setVisible(false);
        Receptionist.setVisible(false);
        Nurse.setVisible(true);
    }//GEN-LAST:event_NursebtnMouseClicked

    private void AddReceptionistbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddReceptionistbtnActionPerformed
        // TODO add your handling code here:
        new AddReceptionist().setVisible(true);
    }//GEN-LAST:event_AddReceptionistbtnActionPerformed

    private void AddPatientbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddPatientbtnActionPerformed
        // TODO add your handling code here:
        new addPatient().setVisible(true);
    }//GEN-LAST:event_AddPatientbtnActionPerformed

    private void SearchFirstName2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchFirstName2ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_SearchFirstName2ActionPerformed

    private void SearchPhone2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchPhone2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchPhone2ActionPerformed

    private void SearchEmail2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchEmail2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchEmail2ActionPerformed

    private void AddDoctorbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddDoctorbtnActionPerformed
        // TODO add your handling code here:
        new AddDoctor().setVisible(true);
    }//GEN-LAST:event_AddDoctorbtnActionPerformed

    private void AddNursebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddNursebtnActionPerformed
        // TODO add your handling code here:
        new AddNurse().setVisible(true);
    }//GEN-LAST:event_AddNursebtnActionPerformed

    private void EditNursebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditNursebtnActionPerformed
        // TODO add your handling code here:
           int row,column,id;
         row = NurseTable.getSelectedRow();
         column = NurseTable.getSelectedColumn(); 
         if(NdefaultTableModel.getColumnName(column).equalsIgnoreCase("ID")){
        try{
         id = Integer.parseInt((NdefaultTableModel.getValueAt( row, column)).toString());
         EditNurse e =new EditNurse(id);
         e.setVisible(true);
         
        }
        
        catch( NumberFormatException e){
           JOptionPane.showMessageDialog(null,e);
        }
        }
        else{
             JOptionPane.showMessageDialog(null,"Please select ID!!");
        }
        
    }//GEN-LAST:event_EditNursebtnActionPerformed

    private void EditPatientbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditPatientbtnActionPerformed
        // TODO add your handling code here:
        int row,column,id;
         row = PatientTable.getSelectedRow();
         column = PatientTable.getSelectedColumn(); 
         if(pdefaultTableModel.getColumnName(column).equalsIgnoreCase("ID")){
        try{
         id = Integer.parseInt((pdefaultTableModel.getValueAt( row, column)).toString());
         EditPatient e =new EditPatient(id);
         e.setVisible(true);
         
        }
        
        catch( NumberFormatException e){
           JOptionPane.showMessageDialog(null,e);
        }
        }
        else{
             JOptionPane.showMessageDialog(null,"Please select ID!!");
        }
        
    }//GEN-LAST:event_EditPatientbtnActionPerformed

    private void DeletePatientbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletePatientbtnActionPerformed
        // TODO add your handling code here:
          int row,column,id;
         row = PatientTable.getSelectedRow();
         column = PatientTable.getSelectedColumn(); 
         if(pdefaultTableModel.getColumnName(column).equalsIgnoreCase("ID")){
        
         id = Integer.parseInt((pdefaultTableModel.getValueAt( row, column)).toString());
        
        
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to Delete the Patient?","Warning",dialogButton);
        if(dialogResult == JOptionPane.YES_OPTION){
            // Saving code here
        String id1=Integer.toString(id);
         try{
         connection = Connector.ConnectDb();
         String sql ="Delete Patient where patientid=?";
         ps = connection.prepareStatement(sql);
         ps.setString(1,id1);
         ps.execute();
         }
         catch(SQLException E){
             JOptionPane.showMessageDialog(null,E);
         } 
        }
         }
        else{
             JOptionPane.showMessageDialog(null,"Please select ID!!");
        }
    }//GEN-LAST:event_DeletePatientbtnActionPerformed

    private void EditDoctorbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditDoctorbtnActionPerformed
        // TODO add your handling code here:
          int row,column,id;
         row = DoctorTable.getSelectedRow();
         column = DoctorTable.getSelectedColumn(); 
         if(DdefaultTableModel.getColumnName(column).equalsIgnoreCase("ID")){
        try{
         id = Integer.parseInt((DdefaultTableModel.getValueAt( row, column)).toString());
         EditDoctor e =new EditDoctor(id);
         e.setVisible(true);
         
        }
        
        catch( NumberFormatException e){
           JOptionPane.showMessageDialog(null,e);
        }
        }
        else{
             JOptionPane.showMessageDialog(null,"Please select ID!!");
        }
        
    }//GEN-LAST:event_EditDoctorbtnActionPerformed

    private void DeleteDoctorbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteDoctorbtnActionPerformed
        // TODO add your handling code here:
        int row,column,id;
         row = DoctorTable.getSelectedRow();
         column = DoctorTable.getSelectedColumn(); 
         if(DdefaultTableModel.getColumnName(column).equalsIgnoreCase("ID")){
        
         id = Integer.parseInt((DdefaultTableModel.getValueAt( row, column)).toString());
        
        
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to Delete the Doctor?","Warning",dialogButton);
        if(dialogResult == JOptionPane.YES_OPTION){
            // Saving code here
        String id1=Integer.toString(id);
         try{
          connection = Connector.ConnectDb();
         String sql ="Select Staffid from doctor where doctorid=?";
         ps = connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
         ps.setString(1,id1);
         rs = ps.executeQuery(); 
         rs.first();
         int staffid = rs.getInt("staffId");
         connection = Connector.ConnectDb();
         String sql1 ="Delete Staff where stid=?";
         ps = connection.prepareStatement(sql1);
         ps.setString(1,Integer.toString(staffid));
         ps.execute();
         JOptionPane.showMessageDialog(null,"Doctor Deleted");
         }
         catch(SQLException E){
             JOptionPane.showMessageDialog(null,E);
         } 
        }
         }
        else{
             JOptionPane.showMessageDialog(null,"Please select ID!!");
        }
    }//GEN-LAST:event_DeleteDoctorbtnActionPerformed

    private void SearchFirstName2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchFirstName2KeyReleased
        // TODO add your handling code here:
  
        String search = SearchFirstName2.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter(DdefaultTableModel);
        DoctorTable.setRowSorter(tr);
        
        
        tr.setRowFilter(RowFilter.regexFilter(search,1));
    }//GEN-LAST:event_SearchFirstName2KeyReleased

    private void SearchId2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchId2KeyReleased
        // TODO add your handling code here:
        String search = SearchId2.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter(DdefaultTableModel);
        DoctorTable.setRowSorter(tr);
        
        
        tr.setRowFilter(RowFilter.regexFilter(search,0));
    }//GEN-LAST:event_SearchId2KeyReleased

    private void SearchPhone2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchPhone2KeyReleased
        // TODO add your handling code here:
        String search = SearchPhone2.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter(DdefaultTableModel);
        DoctorTable.setRowSorter(tr);
        
        
        tr.setRowFilter(RowFilter.regexFilter(search,3));
    }//GEN-LAST:event_SearchPhone2KeyReleased

    private void SearchEmail2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchEmail2KeyReleased
        // TODO add your handling code here:
        String search = SearchEmail2.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter(DdefaultTableModel);
        DoctorTable.setRowSorter(tr);
        
        
        tr.setRowFilter(RowFilter.regexFilter(search,6));
    }//GEN-LAST:event_SearchEmail2KeyReleased

    private void SearchLastName2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchLastName2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchLastName2ActionPerformed

    private void SearchLastName2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchLastName2KeyReleased
        // TODO add your handling code here:
        String search = SearchLastName2.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter(DdefaultTableModel);
        DoctorTable.setRowSorter(tr);
        
        
        tr.setRowFilter(RowFilter.regexFilter(search,2));
    }//GEN-LAST:event_SearchLastName2KeyReleased

    private void EditReceptionistbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditReceptionistbtnActionPerformed
        // TODO add your handling code here:
           int row,column,id;
         row = ReceptionistTable.getSelectedRow();
         column = ReceptionistTable.getSelectedColumn(); 
         if(RdefaultTableModel.getColumnName(column).equalsIgnoreCase("ID")){
        try{
         id = Integer.parseInt((RdefaultTableModel.getValueAt( row, column)).toString());
         EditReceptionist e =new EditReceptionist(id);
         e.setVisible(true);
         
        }
        
        catch( NumberFormatException e){
           JOptionPane.showMessageDialog(null,e);
        }
        }
        else{
             JOptionPane.showMessageDialog(null,"Please select ID!!");
        }
        
    }//GEN-LAST:event_EditReceptionistbtnActionPerformed

    private void DeleteReceptionistbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteReceptionistbtnActionPerformed
        // TODO add your handling code here:
          int row,column,id;
         row = ReceptionistTable.getSelectedRow();
         column = ReceptionistTable.getSelectedColumn(); 
         if(RdefaultTableModel.getColumnName(column).equalsIgnoreCase("ID")){
        
         id = Integer.parseInt((RdefaultTableModel.getValueAt( row, column)).toString());
        
        
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to Delete the Doctor?","Warning",dialogButton);
        if(dialogResult == JOptionPane.YES_OPTION){
            // Saving code here
        String id1=Integer.toString(id);
         try{
             
         connection = Connector.ConnectDb();
         String sql ="Select Staffid from Receptionist where rId=?";
         ps = connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
         ps.setString(1,id1);
         rs = ps.executeQuery(); 
         rs.first();
         int staffid = rs.getInt("staffId");
         
         
         connection = Connector.ConnectDb();
         String sql1 ="Delete Staff where stid=?";
         ps = connection.prepareStatement(sql1);
         ps.setString(1,Integer.toString(staffid));
         ps.execute();
         JOptionPane.showMessageDialog(null,"Receptionist Deleted");
         }
         catch(SQLException E){
             JOptionPane.showMessageDialog(null,E);
         } 
        }
         }
        else{
             JOptionPane.showMessageDialog(null,"Please select ID!!");
        }
    }//GEN-LAST:event_DeleteReceptionistbtnActionPerformed

    private void DeleteNursebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteNursebtnActionPerformed
        // TODO add your handling code here:
         int row,column,id;
         row = NurseTable.getSelectedRow();
         column = NurseTable.getSelectedColumn(); 
         if(NdefaultTableModel.getColumnName(column).equalsIgnoreCase("ID")){
        
         id = Integer.parseInt((NdefaultTableModel.getValueAt( row, column)).toString());
        
        
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to Delete the Doctor?","Warning",dialogButton);
        if(dialogResult == JOptionPane.YES_OPTION){
            // Saving code here
        String id1=Integer.toString(id);
         try{
             
         connection = Connector.ConnectDb();
         String sql ="Select Staffid from Nurse where nurseId=?";
         ps = connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
         ps.setString(1,id1);
         rs = ps.executeQuery(); 
         rs.first();
         int staffid = rs.getInt("staffId");
         
         
         connection = Connector.ConnectDb();
         String sql1 ="Delete Staff where stid=?";
         ps = connection.prepareStatement(sql1);
         ps.setString(1,Integer.toString(staffid));
         ps.execute();
         JOptionPane.showMessageDialog(null,"Nurse Deleted");
         }
         catch(SQLException E){
             JOptionPane.showMessageDialog(null,E);
         } 
        }
         }
        else{
             JOptionPane.showMessageDialog(null,"Please select ID!!");
        }
    }//GEN-LAST:event_DeleteNursebtnActionPerformed

    private void SearchPhone3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchPhone3KeyReleased
        // TODO add your handling code here:
        String search = SearchPhone3.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter(NdefaultTableModel);
        NurseTable.setRowSorter(tr);
        
        
        tr.setRowFilter(RowFilter.regexFilter(search,3));
    }//GEN-LAST:event_SearchPhone3KeyReleased

    private void SearchPhone3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchPhone3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchPhone3ActionPerformed

    private void SearchFirstName3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchFirstName3KeyReleased
        // TODO add your handling code here:
        String search = SearchFirstName3.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter(NdefaultTableModel);
        NurseTable.setRowSorter(tr);
        
        
        tr.setRowFilter(RowFilter.regexFilter(search,1));
    }//GEN-LAST:event_SearchFirstName3KeyReleased

    private void SearchFirstName3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchFirstName3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchFirstName3ActionPerformed

    private void SearchLastName3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchLastName3KeyReleased
        // TODO add your handling code here:
        String search = SearchLastName3.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter(NdefaultTableModel);
        NurseTable.setRowSorter(tr);
        
        
        tr.setRowFilter(RowFilter.regexFilter(search,2));
    }//GEN-LAST:event_SearchLastName3KeyReleased

    private void SearchLastName3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchLastName3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchLastName3ActionPerformed

    private void SearchId3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchId3KeyReleased
        // TODO add your handling code here:
        String search = SearchId3.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter(NdefaultTableModel);
        NurseTable.setRowSorter(tr);
        
        
        tr.setRowFilter(RowFilter.regexFilter(search,0));
    }//GEN-LAST:event_SearchId3KeyReleased

    private void SearchEmail3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchEmail3KeyReleased
        // TODO add your handling code here:
        String search = SearchEmail3.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter(NdefaultTableModel);
        NurseTable.setRowSorter(tr);
        
        
        tr.setRowFilter(RowFilter.regexFilter(search,6));
    }//GEN-LAST:event_SearchEmail3KeyReleased

    private void SearchEmail3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchEmail3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchEmail3ActionPerformed

    private void SearchPhone1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchPhone1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchPhone1ActionPerformed

    private void SearchPhone1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchPhone1KeyReleased
        // TODO add your handling code here:
        String search = SearchPhone1.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter(pdefaultTableModel);
        PatientTable.setRowSorter(tr);
        
        
        tr.setRowFilter(RowFilter.regexFilter(search,3));
    }//GEN-LAST:event_SearchPhone1KeyReleased

    private void SearchId1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchId1KeyReleased
        // TODO add your handling code here:
        String search = SearchId1.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter(pdefaultTableModel);
        PatientTable.setRowSorter(tr);
        
        
        tr.setRowFilter(RowFilter.regexFilter(search,0));
    }//GEN-LAST:event_SearchId1KeyReleased

    private void SearchLastName1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchLastName1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchLastName1ActionPerformed

    private void SearchLastName1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchLastName1KeyReleased
        // TODO add your handling code here:
        String search = SearchLastName1.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter(pdefaultTableModel);
        PatientTable.setRowSorter(tr);
        
        
        tr.setRowFilter(RowFilter.regexFilter(search,2));
    }//GEN-LAST:event_SearchLastName1KeyReleased

    private void SearchBlood1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBlood1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchBlood1ActionPerformed

    private void SearchBlood1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchBlood1KeyReleased
        // TODO add your handling code here:
        String search = SearchBlood1.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter(pdefaultTableModel);
        PatientTable.setRowSorter(tr);
        
        
        tr.setRowFilter(RowFilter.regexFilter(search,6));
        
    }//GEN-LAST:event_SearchBlood1KeyReleased

    private void SearchFirstName1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchFirstName1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchFirstName1ActionPerformed

    private void SearchFirstName1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchFirstName1KeyReleased
        // TODO add your handling code here:
        String search = SearchFirstName1.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter(pdefaultTableModel);
        PatientTable.setRowSorter(tr);
        
        
        tr.setRowFilter(RowFilter.regexFilter(search,1));
    }//GEN-LAST:event_SearchFirstName1KeyReleased

    private void SearchPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchPhoneActionPerformed

    private void SearchPhoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchPhoneKeyReleased
        // TODO add your handling code here:
        String search = SearchPhone.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter(RdefaultTableModel);
        ReceptionistTable.setRowSorter(tr);
        
        
        tr.setRowFilter(RowFilter.regexFilter(search,3));
    }//GEN-LAST:event_SearchPhoneKeyReleased

    private void SearchIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchIdKeyReleased
        // TODO add your handling code here:
        String search = SearchId.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter(RdefaultTableModel);
        ReceptionistTable.setRowSorter(tr);
        
        
        tr.setRowFilter(RowFilter.regexFilter(search,0));
    }//GEN-LAST:event_SearchIdKeyReleased

    private void SearchLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchLastNameActionPerformed

    private void SearchLastNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchLastNameKeyReleased
        // TODO add your handling code here:
        String search = SearchLastName.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter(RdefaultTableModel);
        ReceptionistTable.setRowSorter(tr);
        
        
        tr.setRowFilter(RowFilter.regexFilter(search,2));
    }//GEN-LAST:event_SearchLastNameKeyReleased

    private void SearchEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchEmailActionPerformed

    private void SearchEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchEmailKeyReleased
        // TODO add your handling code here:
        String search = SearchEmail.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter(RdefaultTableModel);
        ReceptionistTable.setRowSorter(tr);
        
        
        tr.setRowFilter(RowFilter.regexFilter(search,6));
    }//GEN-LAST:event_SearchEmailKeyReleased

    private void SearchFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchFirstNameActionPerformed

    private void SearchFirstNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchFirstNameKeyReleased
        // TODO add your handling code here:
        String search = SearchFirstName.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter(RdefaultTableModel);
        ReceptionistTable.setRowSorter(tr);
        
        
        tr.setRowFilter(RowFilter.regexFilter(search,1));
    }//GEN-LAST:event_SearchFirstNameKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddDoctorbtn;
    private javax.swing.JButton AddNursebtn;
    private javax.swing.JButton AddPatientbtn;
    private javax.swing.JButton AddReceptionistbtn;
    private javax.swing.JPanel CenterPanel;
    private javax.swing.JButton DeleteDoctorbtn;
    private javax.swing.JButton DeleteNursebtn;
    private javax.swing.JButton DeletePatientbtn;
    private javax.swing.JButton DeleteReceptionistbtn;
    private javax.swing.JPanel Doctor;
    private javax.swing.JTable DoctorTable;
    private javax.swing.JLabel Doctorsbtn;
    private javax.swing.JButton EditDoctorbtn;
    private javax.swing.JButton EditNursebtn;
    private javax.swing.JButton EditPatientbtn;
    private javax.swing.JButton EditReceptionistbtn;
    private javax.swing.JPanel Nurse;
    private javax.swing.JTable NurseTable;
    private javax.swing.JLabel Nursebtn;
    private javax.swing.JPanel Patient;
    private javax.swing.JTable PatientTable;
    private javax.swing.JLabel Patientsbtn;
    private javax.swing.JPanel Receptionist;
    private javax.swing.JTable ReceptionistTable;
    private javax.swing.JLabel Receptionistbtn;
    private javax.swing.JTextField SearchBlood1;
    private javax.swing.JTextField SearchEmail;
    private javax.swing.JTextField SearchEmail2;
    private javax.swing.JTextField SearchEmail3;
    private javax.swing.JTextField SearchFirstName;
    private javax.swing.JTextField SearchFirstName1;
    private javax.swing.JTextField SearchFirstName2;
    private javax.swing.JTextField SearchFirstName3;
    private javax.swing.JTextField SearchId;
    private javax.swing.JTextField SearchId1;
    private javax.swing.JTextField SearchId2;
    private javax.swing.JTextField SearchId3;
    private javax.swing.JTextField SearchLastName;
    private javax.swing.JTextField SearchLastName1;
    private javax.swing.JTextField SearchLastName2;
    private javax.swing.JTextField SearchLastName3;
    private javax.swing.JTextField SearchPhone;
    private javax.swing.JTextField SearchPhone1;
    private javax.swing.JTextField SearchPhone2;
    private javax.swing.JTextField SearchPhone3;
    private javax.swing.JPanel SidePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextField15;
    // End of variables declaration//GEN-END:variables
}
