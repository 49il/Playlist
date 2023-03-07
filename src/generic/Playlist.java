/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package generic;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.text.DecimalFormat;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author agils
 */
public class Playlist extends javax.swing.JFrame {

   KoleksiMusik koleksi=new KoleksiMusik();
    public Playlist() {
        initComponents();
        tblPlaylist.setModel(koleksi);
        resizeColumns();
        resizeListener();
       
    }
    //method untuk pengaturan lebar dan tinggi kolom pada tabel
    private void resizeListener(){
        addComponentListener(new ComponentAdapter(){
            
            public void componentReisized(ComponentEvent e){
                
            }
        });
    }
    
    private void resizeColumns(){
        float[] columnWidthPercentage={90.0f,10.0f};
        int tW =tblPlaylist.getWidth();
        TableColumn column;
        TableColumnModel jTableColumnModel=tblPlaylist.getColumnModel();
        int cantCols=jTableColumnModel.getColumnCount();
        for(int i=0;i<cantCols;i++){
            column=jTableColumnModel.getColumn(i);
            int pWidth=Math.round(columnWidthPercentage[i] * tW);
            column.setPreferredWidth(pWidth);
            tblPlaylist.setRowHeight(27);
        }
        
    }
    //method untuk membaca ukuran file
    private String fileSizeOf(File file){
        DecimalFormat format=new DecimalFormat("#.##");
        long MB =1024 *1024;
        long KB=1024;
        final double length=file.length();
        if(length>MB){
            return format.format(length/MB)+" MB";
            
        }if(length>KB){
            return format.format(length/KB)+"KB";
        }
        return format.format(length)+ "B";
    }
    
    //method untuk mendapatkan ekstensi file
    private String extensionOf(File file){
        String fileExtension="";
        String fileName=file.getName();
        if(fileName.contains(".")&& fileName.lastIndexOf(".")!=0){
            fileExtension=
                    fileName.substring(fileName.lastIndexOf(".")+1);
        }
        return fileExtension;
    }
    //method untuk mengkoleksi semua file mp3 yang dipilih
    private void addFiles(File[]files){
        for(File file: files){
            String path=file.getAbsolutePath();
            String fn=file.getName();
            String fileName=fn.substring(0,fn.length()-4);
            String fileSize =fileSizeOf(file);
            String extension="";
            int i=path.lastIndexOf('.');
            if(i>0){
                extension=extensionOf(file);
            }
            Musik m=new Musik(path,fileName,fileSize,extension);
            koleksi.add(m);
        }
    }
    //method untuk mebaca semua file mp3 di dalam folder dan sub folder
    private void addFolder (File dir){
        File[] listOfFiles=dir.listFiles();
        for(File  listOfFile: listOfFiles){
            String path=listOfFile.getAbsolutePath();
            String fn=listOfFile.getName();
            String fileName=fn.substring(0,fn.length()-4);
            String fileSize=fileSizeOf(listOfFile);
            String extension;
            int i=path.lastIndexOf('.');
            if(i>0 ){
                extension=extensionOf(listOfFile);
                if("mp3".equalsIgnoreCase(extension)){
                    Musik m =new
                        Musik(path,fileName,fileSize,extension);
                    koleksi.add(m);
                }
            }
        
            else if(listOfFile.isDirectory()){
                addFolder(listOfFile);
            }
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

        jPanel1 = new javax.swing.JPanel();
        popupTombol = new javax.swing.JPopupMenu();
        addFiles = new javax.swing.JMenuItem();
        addFolder = new javax.swing.JMenuItem();
        clearPlaylist = new javax.swing.JMenuItem();
        pnFooter = new javax.swing.JPanel();
        btnPlaylist = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPlaylist = new javax.swing.JTable();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        addFiles.setText("addFiles");
        addFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFilesActionPerformed(evt);
            }
        });
        popupTombol.add(addFiles);

        addFolder.setText("addFolder");
        addFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFolderActionPerformed(evt);
            }
        });
        popupTombol.add(addFolder);

        clearPlaylist.setText("ClearPlaylist");
        clearPlaylist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearPlaylistActionPerformed(evt);
            }
        });
        popupTombol.add(clearPlaylist);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnFooter.setPreferredSize(new java.awt.Dimension(785, 50));

        btnPlaylist.setText("Playlist");
        btnPlaylist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlaylistActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnFooterLayout = new javax.swing.GroupLayout(pnFooter);
        pnFooter.setLayout(pnFooterLayout);
        pnFooterLayout.setHorizontalGroup(
            pnFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnFooterLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btnPlaylist)
                .addContainerGap(655, Short.MAX_VALUE))
        );
        pnFooterLayout.setVerticalGroup(
            pnFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnFooterLayout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(btnPlaylist)
                .addContainerGap())
        );

        getContentPane().add(pnFooter, java.awt.BorderLayout.PAGE_END);

        tblPlaylist.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPlaylist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPlaylistMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPlaylist);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 785, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addFilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFilesActionPerformed
        JFileChooser fc=new JFileChooser();
        fc.setDialogType(JFileChooser.FILES_ONLY);
        fc.setMultiSelectionEnabled(true);
        fc.setDialogTitle("add Files");
        fc.setAcceptAllFileFilterUsed(false);
        fc.setFileFilter(new FileNameExtensionFilter("MP3 File(*.mp3)","mp3"));
        fc.setApproveButtonText("Add Files");
        int show =fc.showOpenDialog(this);
        if(show ==JFileChooser.APPROVE_OPTION){
            File[]files=fc.getSelectedFiles();
            addFiles(files);
        }
        
    }//GEN-LAST:event_addFilesActionPerformed

    private void tblPlaylistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPlaylistMouseClicked
       int i =tblPlaylist.getSelectedRow();
       if(evt.getClickCount()==2 && i !=-1){
           Musik m=koleksi.get(i);
           JOptionPane.showMessageDialog(this,
                   "<html>"
                   +"<head>"
                   +"<style>"
                   +"table{border-collapse: collapse; border: 1px solid blue;}"
                   +"tr{ border-bottom:1pt solid black;}"
                   +"</style>"
                   +"</head>"
                   +"<body>"
                   +"<h3>Detail Musik:</h3>"
                   +"<table>"
                   +"<tr><td>Lokasi</td><td>:</td><td>"+m.getPath()+ "</td></tr>"
                   +"<tr><td>Nama file</td><td>:</td><td>"+m.getFileName()+ "</td></tr>"
                   +"<tr><td>Ukuran</td><td>:</td><td>"+m.getFileSize()+ "</td></tr>"
                   +"<tr><td>Lokasi</td><td>:</td><td>"+m.getExtention()+"</td></tr>"
                   +"</table>"
                   +"</body>"
                   +"</html>"
                   
           
           );
       }
    }//GEN-LAST:event_tblPlaylistMouseClicked

    private void btnPlaylistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlaylistActionPerformed
        popupTombol.show(btnPlaylist,
                btnPlaylist.getWidth(),
                btnPlaylist.getHeight()/2);
    }//GEN-LAST:event_btnPlaylistActionPerformed

    private void addFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFolderActionPerformed
       JFileChooser fc=new JFileChooser();
       fc.setDialogType(JFileChooser.DIRECTORIES_ONLY);
       fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
       fc.setDialogTitle("Add Folder");
       fc.setApproveButtonText("Add Folder");
       int show =fc.showOpenDialog(this);
       if(show== JFileChooser.APPROVE_OPTION){
           File file=fc.getSelectedFile();
           addFolder(file);
       }
       
    }//GEN-LAST:event_addFolderActionPerformed

    private void clearPlaylistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearPlaylistActionPerformed
       koleksi.clear();
    }//GEN-LAST:event_clearPlaylistActionPerformed

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
            java.util.logging.Logger.getLogger(Playlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Playlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Playlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Playlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Playlist().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem addFiles;
    private javax.swing.JMenuItem addFolder;
    private javax.swing.JButton btnPlaylist;
    private javax.swing.JMenuItem clearPlaylist;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnFooter;
    private javax.swing.JPopupMenu popupTombol;
    private javax.swing.JTable tblPlaylist;
    // End of variables declaration//GEN-END:variables
}
