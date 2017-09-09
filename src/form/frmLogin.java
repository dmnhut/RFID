package form;

import com.alee.laf.WebLookAndFeel;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 *
 * @author Dev
 */
public class frmLogin extends javax.swing.JFrame {

    /**
     * Creates new form frmLogin
     */
    public frmLogin() {
        initComponents();
        onRun();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnlLogin = new javax.swing.JPanel();
        lblUser = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        lblHello1 = new javax.swing.JLabel();
        lblHello = new javax.swing.JLabel();
        lblHello2 = new javax.swing.JLabel();
        MenuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        lblUser.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblUser.setText("Tài Khoản");

        lblPassword.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblPassword.setText("Mật Khẩu");

        txtUsername.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        txtPassword.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        btnLogin.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnLogin.setText("Đăng Nhập");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnExit.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnExit.setText("Hủy");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        lblHello1.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N

        lblHello.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        lblHello.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/admin.png"))); // NOI18N

        lblHello2.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N

        javax.swing.GroupLayout pnlLoginLayout = new javax.swing.GroupLayout(pnlLogin);
        pnlLogin.setLayout(pnlLoginLayout);
        pnlLoginLayout.setHorizontalGroup(
            pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLoginLayout.createSequentialGroup()
                        .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(pnlLoginLayout.createSequentialGroup()
                        .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(pnlLoginLayout.createSequentialGroup()
                        .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlLoginLayout.createSequentialGroup()
                                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblUser, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                    .addComponent(lblPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPassword)
                                    .addComponent(txtUsername)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlLoginLayout.createSequentialGroup()
                                .addComponent(lblHello1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblHello)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblHello2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(8, 8, 8))))
        );
        pnlLoginLayout.setVerticalGroup(
            pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblHello1)
                    .addComponent(lblHello2)
                    .addComponent(lblHello))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUser))
                .addGap(18, 18, 18)
                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(txtPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExit))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(7, 6, 6, 6);
        getContentPane().add(pnlLogin, gridBagConstraints);

        jMenu1.setText("Tùy chọn");
        jMenu1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jMenuItem1.setText("Đăng xuất");
        jMenu1.add(jMenuItem1);

        jMenuItem3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jMenuItem3.setText("Thoát");
        jMenu1.add(jMenuItem3);

        MenuBar.add(jMenu1);

        jMenu2.setText("Tạo mới sự kiện");
        jMenu2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jMenuItem2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jMenuItem2.setText("Thêm sự kiện từ danh sách Excel");
        jMenu2.add(jMenuItem2);

        MenuBar.add(jMenu2);

        jMenu3.setText("Đăng ký thẻ");
        jMenu3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jMenuItem5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jMenuItem5.setText("Đăng ký thẻ từ danh sách Excel");
        jMenu3.add(jMenuItem5);

        MenuBar.add(jMenu3);

        setJMenuBar(MenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void onRun() {
        this.setEnabled(true);
        this.setVisible(true);
        setTitle("ĐỒ ÁN ĐIỂM DANH");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("checked.png")));
    }

    public void onPause() {
        this.setEnabled(false);
        this.setVisible(false);
    }

    public void onStop() {
        this.dispose();
    }

    public void onGoto() {
        frmMain main = new frmMain();
    }

    public void setupUser(model.Login log) {
        model.User.username = txtUsername.getText();
        model.User.password = txtPassword.getText();
        model.User.fullname = log.getFullname();
        model.User.codeID = log.getCodeID();
    }

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        model.Login log = new model.Login(txtUsername.getText(), txtPassword.getText());
        if (log.checkLogin()) {
            setupUser(log);
            log.logFile(true);
            onPause();
            onGoto();
            onStop();
        } else {
            new JOptionPane().showMessageDialog(null, "Tài khoản hoặc mật khẩu không đúng");
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Web look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        WebLookAndFeel.install();
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLogin;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JLabel lblHello;
    private javax.swing.JLabel lblHello1;
    private javax.swing.JLabel lblHello2;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPanel pnlLogin;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
