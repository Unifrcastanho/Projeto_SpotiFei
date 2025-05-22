/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;


import controller.ControllerHistorico;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
/**
 *
 * @author rodri
 */
public class HistoricoFrame extends javax.swing.JFrame {

    private ControllerHistorico c; 

    public HistoricoFrame() {
        initComponents();
        c = new ControllerHistorico(this);
    }

    public JScrollPane getjScrollPane4() {
        return jScrollPane4;
    }

    public void setjScrollPane4(JScrollPane jScrollPane4) {
        this.jScrollPane4 = jScrollPane4;
    }

    public JScrollPane getjScrollPane5() {
        return jScrollPane5;
    }

    public void setjScrollPane5(JScrollPane jScrollPane5) {
        this.jScrollPane5 = jScrollPane5;
    }

    public JScrollPane getjScrollPane6() {
        return jScrollPane6;
    }

    public void setjScrollPane6(JScrollPane jScrollPane6) {
        this.jScrollPane6 = jScrollPane6;
    }

    public JLabel getLbl_curtidas() {
        return lbl_curtidas;
    }

    public void setLbl_curtidas(JLabel lbl_curtidas) {
        this.lbl_curtidas = lbl_curtidas;
    }

    public JLabel getLbl_historico() {
        return lbl_historico;
    }

    public void setLbl_historico(JLabel lbl_historico) {
        this.lbl_historico = lbl_historico;
    }

    public JLabel getLbl_descurtidas() {
        return lbl_descurtidas;
    }

    public void setLbl_descurtidas(JLabel lbl_descurtidas) {
        this.lbl_descurtidas = lbl_descurtidas;
    }

    public JList<String> getList_curtidas() {
        return list_curtidas;
    }

    public void setList_descurtidas(JList<String> list_descurtidas) {
        this.list_descurtidas = list_descurtidas;
    }

    public JList<String> getList_historico() {
        return list_historico;
    }

    public void setList_historico(JList<String> list_historico) {
        this.list_historico = list_historico;
    }

    public JList<String> getList_descurtidas() {
        return list_descurtidas;
    }

    public void setList_curtidas(JList<String> list_curtidas) {
        this.list_curtidas = list_curtidas;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        list_historico = new javax.swing.JList<>();
        lbl_historico = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        list_curtidas = new javax.swing.JList<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        list_descurtidas = new javax.swing.JList<>();
        lbl_descurtidas = new javax.swing.JLabel();
        lbl_curtidas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        list_historico.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(list_historico);

        lbl_historico.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_historico.setText("Historico");

        list_curtidas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane5.setViewportView(list_curtidas);

        list_descurtidas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane6.setViewportView(list_descurtidas);

        lbl_descurtidas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_descurtidas.setText("Descurtidas");

        lbl_curtidas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_curtidas.setText("Curtidas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(9, 9, 9)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_historico))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_curtidas))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbl_descurtidas)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(10, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_historico)
                            .addComponent(lbl_descurtidas))
                        .addComponent(lbl_curtidas))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(51, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lbl_curtidas;
    private javax.swing.JLabel lbl_descurtidas;
    private javax.swing.JLabel lbl_historico;
    private javax.swing.JList<String> list_curtidas;
    private javax.swing.JList<String> list_descurtidas;
    private javax.swing.JList<String> list_historico;
    // End of variables declaration//GEN-END:variables
}


