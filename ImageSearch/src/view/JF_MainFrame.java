/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import controller.Controller;

/**
 *
 * @author inftel12
 */
public class JF_MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form JF_MainFrame
     */
    public JF_MainFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMain = new javax.swing.JPanel();
        jLabelIcono = new javax.swing.JLabel();
        jLabelTitle = new javax.swing.JLabel();
        jPanelSearch = new javax.swing.JPanel();
        jPanelSearchLeft = new javax.swing.JPanel();
        jLabelSubTitle = new javax.swing.JLabel();
        jTextFieldSearch = new javax.swing.JTextField();
        jComboBoxKindSearch = new javax.swing.JComboBox();
        jButtonSearch = new javax.swing.JButton();
        jPanelSearchRight = new javax.swing.JPanel();
        jScrollPaneShowSearch = new javax.swing.JScrollPane();
        jTableImages = new javax.swing.JTable();
        jPanelShowResult = new javax.swing.JPanel();
        jPanelShowImage = new javax.swing.JPanel();
        jLabelImage = new javax.swing.JLabel();
        jScrollPaneData = new javax.swing.JScrollPane();
        jTableImagesData = new javax.swing.JTable();
        jButtonBeack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(800, 560));
        setMinimumSize(new java.awt.Dimension(800, 560));
        setName("mainFrame"); // NOI18N
        setResizable(false);

        jPanelMain.setBackground(new java.awt.Color(255, 255, 255));
        jPanelMain.setMaximumSize(new java.awt.Dimension(790, 550));

        jLabelIcono.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/properties/master_inftel_opt.png"))); // NOI18N

        jLabelTitle.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitle.setText("Buscador de imágenes");

        jPanelSearch.setBackground(new java.awt.Color(255, 255, 255));

        jPanelSearchLeft.setBackground(new java.awt.Color(255, 255, 255));

        jLabelSubTitle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelSubTitle.setText("Buscar por:");

        jTextFieldSearch.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jComboBoxKindSearch.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jComboBoxKindSearch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nombre", "Extensión", "Nombre y extensión", "Directorio", "Etiqueta Marca", "Etiqueta Modelo", "Etiqueta Fecha" }));

        jButtonSearch.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButtonSearch.setText("Buscar");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelSearchLeftLayout = new javax.swing.GroupLayout(jPanelSearchLeft);
        jPanelSearchLeft.setLayout(jPanelSearchLeftLayout);
        jPanelSearchLeftLayout.setHorizontalGroup(
            jPanelSearchLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSearchLeftLayout.createSequentialGroup()
                .addGroup(jPanelSearchLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelSearchLeftLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanelSearchLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldSearch)
                            .addComponent(jComboBoxKindSearch, 0, 350, Short.MAX_VALUE)
                            .addComponent(jLabelSubTitle)))
                    .addGroup(jPanelSearchLeftLayout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(jButtonSearch)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanelSearchLeftLayout.setVerticalGroup(
            jPanelSearchLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSearchLeftLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelSubTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jComboBoxKindSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        jPanelSearchRight.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPaneShowSearch.setBorder(null);

        jTableImages.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "id_Imagen", "Ruta", "Imagen"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableImages.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTableImagesMousePressed(evt);
            }
        });
        jScrollPaneShowSearch.setViewportView(jTableImages);
        if (jTableImages.getColumnModel().getColumnCount() > 0) {
            jTableImages.getColumnModel().getColumn(0).setResizable(false);
            jTableImages.getColumnModel().getColumn(1).setResizable(false);
            jTableImages.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout jPanelSearchRightLayout = new javax.swing.GroupLayout(jPanelSearchRight);
        jPanelSearchRight.setLayout(jPanelSearchRightLayout);
        jPanelSearchRightLayout.setHorizontalGroup(
            jPanelSearchRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSearchRightLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneShowSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelSearchRightLayout.setVerticalGroup(
            jPanelSearchRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPaneShowSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jPanelSearchLayout = new javax.swing.GroupLayout(jPanelSearch);
        jPanelSearch.setLayout(jPanelSearchLayout);
        jPanelSearchLayout.setHorizontalGroup(
            jPanelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelSearchLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelSearchRight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(296, 296, 296))
        );
        jPanelSearchLayout.setVerticalGroup(
            jPanelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelSearchLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanelSearchRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelShowResult.setBackground(new java.awt.Color(255, 255, 255));

        jPanelShowImage.setBackground(new java.awt.Color(255, 255, 255));
        jPanelShowImage.setMaximumSize(new java.awt.Dimension(400, 201));
        jPanelShowImage.setPreferredSize(new java.awt.Dimension(400, 201));

        jLabelImage.setBackground(new java.awt.Color(255, 255, 255));
        jLabelImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/properties/no_image_available.png"))); // NOI18N
        jLabelImage.setMaximumSize(new java.awt.Dimension(400, 201));
        jLabelImage.setMinimumSize(new java.awt.Dimension(400, 201));
        jLabelImage.setPreferredSize(new java.awt.Dimension(400, 201));

        javax.swing.GroupLayout jPanelShowImageLayout = new javax.swing.GroupLayout(jPanelShowImage);
        jPanelShowImage.setLayout(jPanelShowImageLayout);
        jPanelShowImageLayout.setHorizontalGroup(
            jPanelShowImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanelShowImageLayout.setVerticalGroup(
            jPanelShowImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelImage, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
        );

        jTableImagesData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Directorio", "Etiqueta", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableImagesData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTableImagesDataMousePressed(evt);
            }
        });
        jScrollPaneData.setViewportView(jTableImagesData);
        if (jTableImagesData.getColumnModel().getColumnCount() > 0) {
            jTableImagesData.getColumnModel().getColumn(0).setResizable(false);
            jTableImagesData.getColumnModel().getColumn(1).setResizable(false);
            jTableImagesData.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout jPanelShowResultLayout = new javax.swing.GroupLayout(jPanelShowResult);
        jPanelShowResult.setLayout(jPanelShowResultLayout);
        jPanelShowResultLayout.setHorizontalGroup(
            jPanelShowResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelShowResultLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelShowImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneData, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelShowResultLayout.setVerticalGroup(
            jPanelShowResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelShowResultLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelShowResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelShowImage, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                    .addComponent(jScrollPaneData, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jButtonBeack.setText("Volver");
        jButtonBeack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBeackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonBeack)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMainLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelShowResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButtonBeack, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jPanelSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelShowResult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(689, 689, 689))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMain, javax.swing.GroupLayout.PREFERRED_SIZE, 560, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        Controller controller = new Controller();
        String kindSearch = (String) jComboBoxKindSearch.getSelectedItem();
        
        switch(kindSearch){
            case "Nombre":{
                controller.printImagesByName(jTableImages, jTextFieldSearch.getText());
            }break;
                
            case "Extensión":{
                controller.printImagesByExtension(jTableImages, jTextFieldSearch.getText());
            }break;
                
            case "Nombre y extensión":{
                controller.printImagesByNameAndExtension(jTableImages, jTextFieldSearch.getText());
            }break;
                
            case "Etiqueta Marca":{
                controller.printImagesByBrandLabel(jTableImages, jTextFieldSearch.getText());
            }break;
                
            case "Etiqueta Modelo":{
                controller.printImagesByModelLabel(jTableImages, jTextFieldSearch.getText());
            }break;
                
            case "Etiqueta Fecha":{
                controller.printImagesByDateLabel(jTableImages, jTextFieldSearch.getText());
            }break;
                
            case "Directorio":{
                controller.printImagesByDirectoryLabel(jTableImages, jTextFieldSearch.getText());
            }break;
        }
    }//GEN-LAST:event_jButtonSearchActionPerformed

    private void jTableImagesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableImagesMousePressed
        try {
            Controller controller = new Controller();
            
            int row = jTableImages.getSelectedRow();
            String idString = jTableImages.getValueAt(row, 0).toString();
            int imageId = Integer.parseInt(idString);
            controller.printSelectedImage(jLabelImage, jTableImagesData, imageId);
        } catch (IOException ex) {
            Logger.getLogger(JF_MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTableImagesMousePressed

    private void jTableImagesDataMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableImagesDataMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableImagesDataMousePressed

    private void jButtonBeackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBeackActionPerformed
        JF_Principal mainApi = new JF_Principal();
        
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run() {
                mainApi.setVisible(true);
            }
        });
        setVisible(false);
    }//GEN-LAST:event_jButtonBeackActionPerformed

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
            java.util.logging.Logger.getLogger(JF_MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF_MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF_MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JF_MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBeack;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JComboBox jComboBoxKindSearch;
    private javax.swing.JLabel jLabelIcono;
    private javax.swing.JLabel jLabelImage;
    private javax.swing.JLabel jLabelSubTitle;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JPanel jPanelSearch;
    private javax.swing.JPanel jPanelSearchLeft;
    private javax.swing.JPanel jPanelSearchRight;
    private javax.swing.JPanel jPanelShowImage;
    private javax.swing.JPanel jPanelShowResult;
    private javax.swing.JScrollPane jScrollPaneData;
    private javax.swing.JScrollPane jScrollPaneShowSearch;
    private javax.swing.JTable jTableImages;
    private javax.swing.JTable jTableImagesData;
    private javax.swing.JTextField jTextFieldSearch;
    // End of variables declaration//GEN-END:variables
}
