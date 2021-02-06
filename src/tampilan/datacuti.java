package tampilan;

import java.sql.*;
import javax.swing.*;
import javax.swing.JOptionPane;
import koneksi.koneksi;
import java.text.*;
import javax.swing.table.DefaultTableModel;

public class datacuti extends javax.swing.JFrame {
    private Connection conn=new koneksi().GetConnection();
    private DefaultTableModel tableModel;
    
    public datacuti() {
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
         tsisacuti.setText("");
         tcuti.setText("");
         tjabatan.setText("");
         cdepartement.setSelectedIndex(0);
    }
    
    private void kode() {
        try {
            Connection c = koneksi.GetConnection();
            Statement s = c.createStatement();

            String sql = "SELECT * FROM cuti ORDER by id desc";
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

                tid.setText("C" + Nol + AN);
            } else {
                tid.setText("C0001");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
     
    }
    
    protected void datatable(){
         Object[] Baris ={"ID","ID Karyawan","Nama","Jabatan","Departement","Sisa Cuti","Tanggal Cuti","Total Cuti"};
         tableModel = new DefaultTableModel (null, Baris);
         tbldata.setModel(tableModel);
         String sql = "select * from cuti";
         try{
            java.sql.Statement stat=conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
             String a = hasil.getString("id");
             String b = hasil.getString("id_kar");
             String c = hasil.getString("nama");
             String d = hasil.getString("jabatan");
             String e = hasil.getString("departement");
             String f = hasil.getString("sisa_cuti");
             String g = hasil.getString("tanggal");
             String h = hasil.getString("cuti");
             
             String[] data={a,b,c,d,e,f,g,h};
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
        jLabel27 = new javax.swing.JLabel();
        tcuti = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbldata = new javax.swing.JTable();
        bedit = new javax.swing.JButton();
        bhapus = new javax.swing.JButton();
        bmenu = new javax.swing.JButton();
        bkeluar = new javax.swing.JButton();
        bsimpan = new javax.swing.JButton();
        bbersihkan = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        ttgl = new com.toedter.calendar.JDateChooser();
        jLabel31 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        tsisacuti = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        bcek = new javax.swing.JButton();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jLabel34.setIcon(new javax.swing.ImageIcon("C:\\Users\\unix\\Documents\\NetBeansProjects\\penggajian\\gambar\\pz cussons 100p.jpg")); // NOI18N

        jLabel35.setIcon(new javax.swing.ImageIcon("C:\\Users\\unix\\Documents\\NetBeansProjects\\penggajian\\gambar\\pz cussons 100p.jpg")); // NOI18N

        jLabel36.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(204, 0, 51));
        jLabel36.setText("Pengajuan Cuti PZ Cussos");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel34)
                .addGap(189, 189, 189)
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        jLabel22.setText("Masukan Data Karyawan Cuti");

        jLabel27.setText("Total Cuti");

        tbldata.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
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

        bsimpan.setText("Simpan");
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

        jLabel10.setText("Tanggal Cuti");

        ttgl.setDateFormatString("yyyy-MM-dd");

        jLabel31.setText("Hari");

        jLabel38.setText("Sisa Cuti");

        jLabel39.setText("Hari");

        bcek.setText("Cek");
        bcek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcekActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bedit, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bmenu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bkeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(239, 239, 239))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel37)
                                    .addComponent(jLabel30)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel32))
                                .addGap(64, 64, 64)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tid, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cidkar, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cnama, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tjabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cdepartement, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel33))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel38))
                                .addGap(52, 52, 52)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(ttgl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel8Layout.createSequentialGroup()
                                            .addComponent(tcuti, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabel31)
                                            .addGap(17, 17, 17)))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(tsisacuti, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel39)
                                        .addGap(18, 18, 18)
                                        .addComponent(bcek, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(bsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(bbersihkan, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(301, 301, 301)
                        .addComponent(jLabel22)))
                .addContainerGap(178, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38)
                            .addComponent(tsisacuti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel39)
                            .addComponent(bcek))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(ttgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(tcuti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31))
                        .addGap(112, 112, 112)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bsimpan)
                            .addComponent(bbersihkan)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cidkar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tjabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(cdepartement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bhapus)
                    .addComponent(bedit)
                    .addComponent(bmenu)
                    .addComponent(bkeluar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
       
        String sisa = (String) tableModel.getValueAt(i, 5);
        tsisacuti.setText(sisa);
        
        //String tgl = (String) tableModel.getValueAt(i, 6);
        //tgl.setText(tgl);
        
        String cuti = (String) tableModel.getValueAt(i, 7);
        tcuti.setText(cuti);
    }//GEN-LAST:event_tbldataMouseClicked

    private void beditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beditActionPerformed
         String tgl = "yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tgl);
        String tanggal = String.valueOf(fm.format(ttgl.getDate()));
        try{
            String sql="UPDATE cuti set id_kar='"+cidkar.getSelectedItem().toString()+"',nama='"+cnama.getSelectedItem().toString()+"',jabatan='"+tjabatan.getText()+"',"
            + "departement='"+cdepartement.getSelectedItem().toString()+"',sisa_cuti='"+tsisacuti.getText()+"',"
            + "tanggal='"+tanggal+"',cuti='"+tcuti.getText()+"'"
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
            String sql="delete from cuti where id ='"+tid.getText()+"' ";

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
            String sql="insert into cuti (id,id_kar,nama,jabatan,departement,sisa_cuti,tanggal,cuti)"
            +"values"+"('"+tid.getText()+"','"+cidkar.getSelectedItem().toString()+"','"+cnama.getSelectedItem().toString()+"',"
            + "'"+tjabatan.getText()+"','"+cdepartement.getSelectedItem().toString()+"','"+tsisacuti.getText()+"','"+tanggal+"',"
            + "'"+tcuti.getText()+"' )";

            PreparedStatement stat=conn.prepareStatement(sql);
            stat.executeUpdate();            
            
            int sisa,ambil,tot;
            sisa=Integer.parseInt(tsisacuti.getText().toString());
            ambil=Integer.parseInt(tcuti.getText().toString());
            tot=sisa-ambil;
            
            String sql2="UPDATE karyawan set cuti='"+tot+"' "
            + "where id='"+cidkar.getSelectedItem().toString()+"'";
            PreparedStatement stat2=conn.prepareStatement(sql2);
            stat2.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data BERHASIL disimpan");

            kosong();
            datatable();
            aktif();
            kode();

        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Data GAGAL disimpan"+e);
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

    private void bcekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcekActionPerformed
        String id = cidkar.getSelectedItem().toString();
        String sql = "select cuti from karyawan where id='"+id+"'";
        try{
            java.sql.Statement stat=conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                tsisacuti.setText(hasil.getString("cuti"));
            }
        }catch(Exception e){

        }
    }//GEN-LAST:event_bcekActionPerformed

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
            java.util.logging.Logger.getLogger(datacuti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(datacuti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(datacuti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(datacuti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new datacuti().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bbersihkan;
    private javax.swing.JButton bcek;
    private javax.swing.JButton bedit;
    private javax.swing.JButton bhapus;
    private javax.swing.JButton bkeluar;
    private javax.swing.JButton bmenu;
    private javax.swing.JButton bsimpan;
    private javax.swing.JComboBox<String> cdepartement;
    private javax.swing.JComboBox<String> cidkar;
    private javax.swing.JComboBox<String> cnama;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbldata;
    private javax.swing.JTextField tcuti;
    private javax.swing.JTextField tid;
    private javax.swing.JTextField tjabatan;
    private javax.swing.JTextField tsisacuti;
    private com.toedter.calendar.JDateChooser ttgl;
    // End of variables declaration//GEN-END:variables
}
