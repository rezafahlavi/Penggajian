package tampilan;

import java.io.File;
import java.sql.*;
import javax.swing.*;
import javax.swing.JOptionPane;
import koneksi.koneksi;
import java.text.*;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class bayargaji extends javax.swing.JFrame {
    private Connection conn=new koneksi().GetConnection();
    private DefaultTableModel tableModel;
    
    public bayargaji() {
        initComponents();
        datatable();
        tid.setEnabled(false);
        kode();
        tampilpilih();
        tampilpilih2();
    }
protected void aktif(){
        bsimpan.setEnabled(true);
        cidkar.setEnabled(true);
    }

    protected void kosong(){
         tid.setText("");
         cidkar.setSelectedIndex(0);
         cnama.setSelectedIndex(0);
         //tgl
         tjabatan.setText("");
         cdepartement.setSelectedIndex(0);
         tnorek.setText("");
         tnamarek.setText("");
         thadir.setText("");
         ttotal.setText("");
         tgaji.setText("");
         tbpjstk.setText("");
         tbpjskes.setText("");
         thadir.setText("");
         tpph.setText("");
    }
    
    private void kode() {
        try {
            Connection c = koneksi.GetConnection();
            Statement s = c.createStatement();

            String sql = "SELECT * FROM gaji ORDER by id desc";
            ResultSet r = s.executeQuery(sql);

            if (r.next()) {
                String nofak = r.getString("id").substring(1);
                String AN = "" + (Integer.parseInt(nofak) + 1);
                String Nol = "";

                if (AN.length() == 1) {
                    Nol = "000";
                } else if (AN.length() == 2) {
                    Nol = "00";
                } else if (AN.length() == 3) {
                    Nol = "0";
                } else if (AN.length() == 4) {
                    Nol = "";
                }

                tid.setText("G" + Nol + AN);
            } else {
                tid.setText("G0001");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
     
    }
    
    protected void datatable(){
         Object[] Baris ={"ID","ID Karyawan","Nama","Jabatan","Departement","No Rek","Nama Rek","Hadir","Gaji Pokok","Tanggal","BPJS TK"
                            ,"BPJS Kes","Tunjangan","PPH 21","Total"};
         tableModel = new DefaultTableModel (null, Baris);
         tbldata.setModel(tableModel);
         String sql = "select * from gaji";
         try{
            java.sql.Statement stat=conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
             String a = hasil.getString("id");
             String b = hasil.getString("id_kar");
             String c = hasil.getString("nama");
             String d = hasil.getString("jabatan");
             String e = hasil.getString("departement");
             String f = hasil.getString("norek");
             String g = hasil.getString("namarek");
             String h = hasil.getString("hadir");
             String i = hasil.getString("gaji");
             String j = hasil.getString("periode");
             String k = hasil.getString("bpjstk");
             String l = hasil.getString("bpjskes");
             String m = hasil.getString("tunjangan");
             String n = hasil.getString("pph21");
             String o = hasil.getString("total");
             
             String[] data={a,b,c,d,e,f,g,h,i,j,k,l,m,n,o};
             tableModel.addRow(data);
            }   
         }catch(Exception e){
         
         }
     }
    
    private void tampilpilih() {
        try {
            Connection c = koneksi.GetConnection();
            Statement s = c.createStatement();

            String sql = "SELECT id FROM karyawan";
            ResultSet r = s.executeQuery(sql);

            while (r.next()) {
                cidkar.addItem(r.getString("id"));
            }

            r.last();
            int jumlahdata = r.getRow();
            r.first();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
    
    private void tampilpilih2() {
        try {
            Connection c = koneksi.GetConnection();
            Statement s = c.createStatement();

            String sql = "SELECT nama FROM karyawan";
            ResultSet r = s.executeQuery(sql);

            while (r.next()) {
                cnama.addItem(r.getString("nama"));
            }

            r.last();
            int jumlahdata = r.getRow();
            r.first();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel9 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbldata = new javax.swing.JTable();
        bedit = new javax.swing.JButton();
        bhapus = new javax.swing.JButton();
        bmenu = new javax.swing.JButton();
        bkeluar = new javax.swing.JButton();
        bsimpan = new javax.swing.JButton();
        bbersihkan = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        tid = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        cidkar = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        cnama = new javax.swing.JComboBox<>();
        jLabel32 = new javax.swing.JLabel();
        tjabatan = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        cdepartement = new javax.swing.JComboBox<>();
        tnorek = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tnamarek = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        thadir = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tgaji = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tbpjstk = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tbpjskes = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        ttunjangan = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tpph = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        ttgl = new com.toedter.calendar.JDateChooser();
        jLabel27 = new javax.swing.JLabel();
        ttotal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jLabel34.setIcon(new javax.swing.ImageIcon("C:\\Users\\unix\\Documents\\NetBeansProjects\\penggajian\\gambar\\pz cussons 100p.jpg")); // NOI18N

        jLabel35.setIcon(new javax.swing.ImageIcon("C:\\Users\\unix\\Documents\\NetBeansProjects\\penggajian\\gambar\\pz cussons 100p.jpg")); // NOI18N

        jLabel36.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(204, 0, 51));
        jLabel36.setText("Data Penggajian PT PZ Cussos");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel36)
                .addGap(170, 170, 170)
                .addComponent(jLabel35))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34)
                    .addComponent(jLabel35)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel36)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel22.setText("Masukan Data Penggajian");

        tbldata.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11", "Title 12", "Title 13", "Title 14", "Title 15"
            }
        ));
        tbldata.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbldataMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbldata);

        bedit.setText("Ubah");
        bedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beditActionPerformed(evt);
            }
        });

        bhapus.setText("Hapus");
        bhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhapusActionPerformed(evt);
            }
        });

        bmenu.setText("Menu Utama");
        bmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bmenuActionPerformed(evt);
            }
        });

        bkeluar.setText("Keluar");
        bkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bkeluarActionPerformed(evt);
            }
        });

        bsimpan.setText("Simpan dan Cetak Slip Gaji");
        bsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpanActionPerformed(evt);
            }
        });

        bbersihkan.setText("Bersihkan");
        bbersihkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbersihkanActionPerformed(evt);
            }
        });

        jLabel37.setText("ID");

        jLabel30.setText("ID Karyawan");

        cidkar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih" }));
        cidkar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cidkarActionPerformed(evt);
            }
        });

        jLabel23.setText("Nama");

        cnama.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih" }));
        cnama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cnamaActionPerformed(evt);
            }
        });

        jLabel32.setText("Jabatan");

        jLabel33.setText("Departement");

        cdepartement.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih", "HRD & GA", "Finance", "Marketing & CS", "IT", "Production", "Logistic" }));

        jLabel1.setText("No Rek");

        jLabel2.setText("Nama Rek");

        jLabel3.setText("Jumlah Hadir");

        jLabel6.setText("Gaji Pokok");

        jLabel7.setText("BPJS TK");

        jLabel8.setText("BPJS Kes");

        jLabel9.setText("Tunj Hadir");

        jLabel10.setText("PPH 21");

        jButton1.setText("Cek");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel11.setText("Hari");

        jButton2.setText("Hitung");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel14.setText("Periode");

        ttgl.setDateFormatString("yyyy-MM-dd");

        jLabel27.setText("Total Gaji");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(350, 350, 350)
                .addComponent(jLabel22)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37)
                    .addComponent(jLabel30)
                    .addComponent(jLabel23)
                    .addComponent(jLabel32)
                    .addComponent(jLabel33))
                .addGap(36, 36, 36)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cidkar, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tid, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cnama, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tjabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cdepartement, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(jLabel1))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(bedit, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bmenu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bkeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(116, 116, 116))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(thadir, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1))
                            .addComponent(tnamarek, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tnorek, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(ttgl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                                .addComponent(tgaji, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel27))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tpph, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ttunjangan, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tbpjskes, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tbpjstk, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                            .addComponent(ttotal))
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(30, 30, 30))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bbersihkan, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addGap(12, 12, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37)
                            .addComponent(jLabel1)
                            .addComponent(tnorek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cidkar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30)
                            .addComponent(jLabel2)
                            .addComponent(tnamarek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23)
                            .addComponent(jLabel3)
                            .addComponent(thadir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(jButton1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tjabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32)
                            .addComponent(jLabel6)
                            .addComponent(tgaji, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ttgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel33)
                                .addComponent(cdepartement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel14))))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tbpjstk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tbpjskes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ttunjangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tpph, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(ttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bsimpan)
                    .addComponent(bbersihkan))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bhapus)
                    .addComponent(bedit)
                    .addComponent(bmenu)
                    .addComponent(bkeluar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbldataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbldataMouseClicked
        bsimpan.setEnabled(false);
        bedit.setEnabled(true);
        bhapus.setEnabled(true);
        int i = tbldata.getSelectedRow();
        if (i == -1) {
            return;
        }
        String id = (String) tableModel.getValueAt(i, 0);
        tid.setText(id);

        String idkar = (String) tableModel.getValueAt(i, 1);
        cidkar.setSelectedItem(idkar);

        String nama = (String) tableModel.getValueAt(i, 2);
        cnama.setSelectedItem(nama);

        String jabatan = (String) tableModel.getValueAt(i, 3);
        tjabatan.setText(jabatan);

        String departement = (String) tableModel.getValueAt(i, 4);
        cdepartement.setSelectedItem(departement);
        
        String norek = (String) tableModel.getValueAt(i, 5);
        tnorek.setText(norek);

        String namarek = (String) tableModel.getValueAt(i, 6);
        tnamarek.setText(namarek);
        
        String hadir = (String) tableModel.getValueAt(i, 7);
        thadir.setText(hadir);
        
        String gaji = (String) tableModel.getValueAt(i, 8);
        tgaji.setText(gaji);

        //String tgl = (String) tableModel.getValueAt(i, 6);
        //tgl.setText(tgl);

        String bpjstk = (String) tableModel.getValueAt(i, 10);
        tbpjstk.setText(bpjstk);
        
        String bpjskes = (String) tableModel.getValueAt(i, 11);
        tbpjskes.setText(bpjskes);
        
        String tunjangan = (String) tableModel.getValueAt(i, 12);
        ttunjangan.setText(tunjangan);
        
        String pph = (String) tableModel.getValueAt(i, 13);
        tpph.setText(pph);
        
        String total = (String) tableModel.getValueAt(i, 14);
        ttotal.setText(total);
    }//GEN-LAST:event_tbldataMouseClicked

    private void beditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beditActionPerformed
        String tgl = "yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tgl);
        String tanggal = String.valueOf(fm.format(ttgl.getDate()));
        try{
            String sql="UPDATE gaji set id_kar='"+cidkar.getSelectedItem().toString()+"',nama='"+cnama.getSelectedItem().toString()+"',jabatan='"+tjabatan.getText()+"',"
            + "departement='"+cdepartement.getSelectedItem().toString()+"',norek='"+tnorek.getText()+"',namarek='"+tnamarek.getText()+"',hadir='"+thadir.getText()+"',"
            + "gaji='"+tgaji.getText()+"',periode='"+tanggal+"',bpjstk='"+tbpjstk.getText()+"',bpjskes='"+tbpjskes.getText()+"',tunjangan='"+ttunjangan.getText()+"',"
            + "pph21='"+tpph.getText()+"',total='"+ttotal.getText()+"'"
            + "where id='"+tid.getText()+"'";
            PreparedStatement stat=conn.prepareStatement(sql);
            stat.executeUpdate();

            JOptionPane.showMessageDialog(null, "Data BERHASIL diubah");

            kosong();
            datatable();
            aktif();
            kode();

        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Data GAGAL diubah"+e);
        }
    }//GEN-LAST:event_beditActionPerformed

    private void bhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhapusActionPerformed

        try{
            String sql="delete from gaji where id ='"+tid.getText()+"' ";

            PreparedStatement stat=conn.prepareStatement(sql);
            stat.executeUpdate();

            JOptionPane.showMessageDialog(null, "Data BERHASIL dihapus");

            kosong();
            datatable();
            aktif();
            kode();

        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Data GAGAL dihapus");
        }
    }//GEN-LAST:event_bhapusActionPerformed

    private void bmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bmenuActionPerformed
        this.dispose();
        new menu().setVisible(true);
    }//GEN-LAST:event_bmenuActionPerformed

    private void bkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkeluarActionPerformed
        this.dispose();
    }//GEN-LAST:event_bkeluarActionPerformed

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
        String tgl = "yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tgl);
        String tanggal = String.valueOf(fm.format(ttgl.getDate()));
        try{
            String sql="insert into gaji (id,id_kar,nama,jabatan,departement,norek,namarek,hadir,gaji,periode,bpjstk,bpjskes,tunjangan,pph21,total)"
            +"values"+"('"+tid.getText()+"','"+cidkar.getSelectedItem().toString()+"','"+cnama.getSelectedItem().toString()+"',"
            + "'"+tjabatan.getText()+"','"+cdepartement.getSelectedItem().toString()+"','"+tnorek.getText()+"','"+tnamarek.getText()+"','"+thadir.getText()+"',"
            + "'"+tgaji.getText()+"','"+tanggal+"','"+tbpjstk.getText()+"','"+tbpjskes.getText()+"','"+ttunjangan.getText()+"',"
            + "'"+tpph.getText()+"','"+ttotal.getText()+"' )";

            PreparedStatement stat=conn.prepareStatement(sql);
            stat.executeUpdate();

            JOptionPane.showMessageDialog(null, "Data BERHASIL disimpan");

            kosong();
            datatable();
            aktif();
            kode();

        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Data GAGAL disimpan"+e);
        }
        
        try{
            //coding  cetak surat jalan
            String namaFile = "src/laporan/surat_jalan.jasper";
            Connection conn = new koneksi().GetConnection();
            HashMap parameter = new HashMap();
            
            
            String tgllap = String.valueOf(fm.format(ctglkeluar.getDate()));
            String pemesan = tpemesan.getText();
            String alamat = talamat.getText();
            
            //parameter
            parameter.put("tanggal",tgllap);
            parameter.put("pemesan",pemesan);
            parameter.put("alamat",alamat);
            
            File report_file = new File(namaFile);
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(report_file.getPath());
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameter, conn);
            JasperViewer.viewReport(jasperPrint, false);
            JasperViewer.setDefaultLookAndFeelDecorated(true);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Maaf Terjadi Kesalahan Dalam Mencetak"+e);
        }
    }//GEN-LAST:event_bsimpanActionPerformed

    private void bbersihkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbersihkanActionPerformed
        kosong();
        aktif();
        kode();
    }//GEN-LAST:event_bbersihkanActionPerformed

    private void cidkarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cidkarActionPerformed
        if (cidkar.getSelectedItem().equals("Pilih")){
            tjabatan.setText("");
        }else{
            try {
                Connection c = koneksi.GetConnection();
                Statement s = c.createStatement();

                String sql = "SELECT nama,jabatan,departement FROM karyawan WHERE id ='" + cidkar.getSelectedItem() + "'";
                ResultSet r = s.executeQuery(sql);

                while (r.next()) {
                    cnama.setSelectedItem(r.getString("nama"));
                    tjabatan.setText(r.getString("jabatan"));
                    cdepartement.setSelectedItem(r.getString("departement"));
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_cidkarActionPerformed

    private void cnamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cnamaActionPerformed
        if (cnama.getSelectedItem().equals("Pilih")){
            tjabatan.setText("");
        }else{
            try {
                Connection c = koneksi.GetConnection();
                Statement s = c.createStatement();

                String sql = "SELECT id,jabatan,departement FROM karyawan WHERE nama ='" + cnama.getSelectedItem() + "'";
                ResultSet r = s.executeQuery(sql);

                while (r.next()) {
                    cidkar.setSelectedItem(r.getString("id"));
                    tjabatan.setText(r.getString("jabatan"));
                    cdepartement.setSelectedItem(r.getString("departement"));
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_cnamaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String id = cidkar.getSelectedItem().toString();
        String sql = "select hadir from absen where id_kar='"+id+"'";
        try{
            java.sql.Statement stat=conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                thadir.setText(hasil.getString("hadir"));
            }
        }catch(Exception e){

        }            
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int hadir,gaji,totgaji,tottk,totkes,totpph;
        hadir = Integer.parseInt(thadir.getText().toString());
        gaji = Integer.parseInt(tgaji.getText().toString());
        
        tottk = gaji*8/100;
        totkes = gaji*1/100;
        totpph = gaji*5/100;
        
         if(hadir == 30){
            ttunjangan.setText("100000");
        }else{       
            ttunjangan.setText("0");
         }
        tbpjstk.setText(Integer.toString(tottk));
        tbpjskes.setText(Integer.toString(totkes));
        tpph.setText(Integer.toString(totpph));       
        totgaji = gaji-tottk-totkes-totpph;
        ttotal.setText(Integer.toString(totgaji));
        
    }//GEN-LAST:event_jButton2ActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(bayargaji.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bayargaji.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bayargaji.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bayargaji.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bayargaji().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bbersihkan;
    private javax.swing.JButton bedit;
    private javax.swing.JButton bhapus;
    private javax.swing.JButton bkeluar;
    private javax.swing.JButton bmenu;
    private javax.swing.JButton bsimpan;
    private javax.swing.JComboBox<String> cdepartement;
    private javax.swing.JComboBox<String> cidkar;
    private javax.swing.JComboBox<String> cnama;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbldata;
    private javax.swing.JTextField tbpjskes;
    private javax.swing.JTextField tbpjstk;
    private javax.swing.JTextField tgaji;
    private javax.swing.JTextField thadir;
    private javax.swing.JTextField tid;
    private javax.swing.JTextField tjabatan;
    private javax.swing.JTextField tnamarek;
    private javax.swing.JTextField tnorek;
    private javax.swing.JTextField tpph;
    private com.toedter.calendar.JDateChooser ttgl;
    private javax.swing.JTextField ttotal;
    private javax.swing.JTextField ttunjangan;
    // End of variables declaration//GEN-END:variables
}
