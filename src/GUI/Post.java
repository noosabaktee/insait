/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Classes.Comments;
import static Classes.LoginPreferences.loadId;
import Classes.Posts;
import Classes.Sharing;
import Classes.Users;
import Config.Connect;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author acer
 */
public class Post extends javax.swing.JFrame {

    /**
     * Creates new form Post
     */
    int id;
    int user_id = loadId();
    int post_user_id;
//  for comment
    int offset = 0;
    int limit = 1;
    int newOffset = 0;
    int commentAdd = 0;
    public Post(int id) {

        
        this.id = id;
        
        initComponents();
        panelComment.setLayout(new BoxLayout(panelComment, BoxLayout.Y_AXIS));
        updateComment(offset, limit);
        pack();
        
        Posts post = new Posts(id);
        if(post.getType() == 'S'){
            post = new Sharing(id);
            if(post.getComment() == 0){
                formComment.setVisible(false);
            }
        }
        
        title.setText(post.getTitle());
        Users userPost = new Users(post.getUserId());
        postedBy.setText("Diposting oleh " + userPost.getName());
        post_user_id = userPost.getId();
        content.setText("<html>" + post.getContent().replace("\n", "<br>")+ "</html>");
            
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    private void updateComment(int offset, int limit){
         try (Connection conn = Connect.getConnection(); Statement stmt = conn.createStatement()) {
            String query = "SELECT * FROM comments WHERE post_id = " + id + " ORDER BY id DESC LIMIT " + offset + "," + limit;
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Comments comment = new Comments(rs.getInt("id")); 
                CardComment cm = new CardComment(comment);
                panelComment.add(cm);
            }
            buttonMore();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
         
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        scrollPane1 = new java.awt.ScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        panelPost = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        content = new javax.swing.JLabel();
        formComment = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtComment = new javax.swing.JTextArea();
        btnSend = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        postedBy = new javax.swing.JLabel();
        panelComment = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        title.setText("Judul Disini Lurr");

        content.setText("disini");
        content.setPreferredSize(new java.awt.Dimension(200, 16));

        txtComment.setColumns(20);
        txtComment.setRows(5);
        jScrollPane1.setViewportView(txtComment);

        btnSend.setText("send");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        jLabel1.setText("Comment:");

        javax.swing.GroupLayout formCommentLayout = new javax.swing.GroupLayout(formComment);
        formComment.setLayout(formCommentLayout);
        formCommentLayout.setHorizontalGroup(
            formCommentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formCommentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(formCommentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSend)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        formCommentLayout.setVerticalGroup(
            formCommentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formCommentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSend)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        postedBy.setText("disini");
        postedBy.setPreferredSize(new java.awt.Dimension(200, 16));
        postedBy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                postedByMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(formComment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(title)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(postedBy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(206, 206, 206))
                            .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(postedBy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(formComment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        content.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout panelCommentLayout = new javax.swing.GroupLayout(panelComment);
        panelComment.setLayout(panelCommentLayout);
        panelCommentLayout.setHorizontalGroup(
            panelCommentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 359, Short.MAX_VALUE)
        );
        panelCommentLayout.setVerticalGroup(
            panelCommentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 152, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelPostLayout = new javax.swing.GroupLayout(panelPost);
        panelPost.setLayout(panelPostLayout);
        panelPostLayout.setHorizontalGroup(
            panelPostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPostLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelPostLayout.createSequentialGroup()
                        .addComponent(panelComment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelPostLayout.setVerticalGroup(
            panelPostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPostLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelComment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        jScrollPane4.setViewportView(panelPost);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void buttonMore(){
        JButton buttonMore = new JButton();
        buttonMore.setSize(400,400);
        buttonMore.setVisible(true);
        buttonMore.setText("See More");
        buttonMore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelComment.remove(buttonMore);
                panelComment.revalidate();
                panelComment.repaint();
                offset++;
                updateComment(offset,limit);
            }
        });
        panelComment.add(buttonMore);
    }
    
    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        // TODO add your handling code here:
        if("".equals(txtComment.getText())){
            JOptionPane.showMessageDialog(null,
            "Form harus terisi!",
            "Warning",
            JOptionPane.WARNING_MESSAGE);
            return;
        }
        try (Connection conn = Connect.getConnection(); Statement stmt = conn.createStatement()) {
            String insertUser = "INSERT INTO comments (user_id, post_id, content, date) VALUES(" +
                  user_id  + "," + id + ",'" + txtComment.getText() + "','" + System.currentTimeMillis() + "')";
            int i = stmt.executeUpdate(insertUser);
            if (i > 0) {
//                JOptionPane.showMessageDialog(null,
//                "Komentar berhasil ditambahkan!");
                txtComment.setText("");
                panelComment.removeAll();
                panelComment.revalidate();
                panelComment.repaint();
                updateComment(0,offset+2);
                offset++;
            } else {
                JOptionPane.showMessageDialog(null,
                "Komentar gagal ditambahkan!!");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnSendActionPerformed

    private void postedByMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_postedByMouseClicked
        // TODO add your handling code here:
        Profile profile = new Profile(post_user_id);
        profile.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        profile.setVisible(true);
    }//GEN-LAST:event_postedByMouseClicked

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
            java.util.logging.Logger.getLogger(Post.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Post.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Post.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Post.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new Post(3).setVisible(true);
            }
        });
//        SwingUtilities.invokeLater(() -> new Post(2));

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSend;
    private javax.swing.JLabel content;
    private javax.swing.JPanel formComment;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel panelComment;
    private javax.swing.JPanel panelPost;
    private javax.swing.JLabel postedBy;
    private java.awt.ScrollPane scrollPane1;
    private javax.swing.JLabel title;
    private javax.swing.JTextArea txtComment;
    // End of variables declaration//GEN-END:variables
}
