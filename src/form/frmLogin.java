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
        lblEmptyLeft = new javax.swing.JLabel();
        lblHello = new javax.swing.JLabel();
        lblEmptyRight = new javax.swing.JLabel();
        MenuBar = new javax.swing.JMenuBar();
        mnuFile = new javax.swing.JMenu();
        mnuFileLogout = new javax.swing.JMenuItem();
        mnuFileExit = new javax.swing.JMenuItem();
        mnuCreateNewEvents = new javax.swing.JMenu();
        mnuCreateNewEventsFromExcel = new javax.swing.JMenuItem();
        mnuMakeNewCard = new javax.swing.JMenu();
        mnuMakeNewCardFromExcel = new javax.swing.JMenuItem();

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

        lblEmptyLeft.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N

        lblHello.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        lblHello.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/admin.png"))); // NOI18N

        lblEmptyRight.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N

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
                                .addComponent(lblEmptyLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblHello)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblEmptyRight, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(8, 8, 8))))
        );
        pnlLoginLayout.setVerticalGroup(
            pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEmptyLeft)
                    .addComponent(lblEmptyRight)
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

        mnuFile.setText("Tùy chọn");
        mnuFile.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        mnuFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuFileMouseClicked(evt);
            }
        });

        mnuFileLogout.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        mnuFileLogout.setText("Đăng xuất");
        mnuFile.add(mnuFileLogout);

        mnuFileExit.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        mnuFileExit.setText("Thoát");
        mnuFile.add(mnuFileExit);

        MenuBar.add(mnuFile);

        mnuCreateNewEvents.setText("Sự kiện");
        mnuCreateNewEvents.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        mnuCreateNewEvents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuCreateNewEventsMouseClicked(evt);
            }
        });

        mnuCreateNewEventsFromExcel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        mnuCreateNewEventsFromExcel.setText("Thêm danh sách tham gia sự kiện từ file Excel");
        mnuCreateNewEvents.add(mnuCreateNewEventsFromExcel);

        MenuBar.add(mnuCreateNewEvents);

        mnuMakeNewCard.setText("Đăng ký thẻ mới");
        mnuMakeNewCard.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        mnuMakeNewCard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuMakeNewCardMouseClicked(evt);
            }
        });

        mnuMakeNewCardFromExcel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        mnuMakeNewCardFromExcel.setText("Thêm danh sách đăng ký thẻ từ file Excel");
        mnuMakeNewCard.add(mnuMakeNewCardFromExcel);

        MenuBar.add(mnuMakeNewCard);

        setJMenuBar(MenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void onRun() {
        this.setEnabled(true);
        this.setVisible(true);
        this.mnuFileExit.setEnabled(false);
        this.mnuFileLogout.setEnabled(false);
        this.mnuCreateNewEventsFromExcel.setEnabled(false);
        this.mnuMakeNewCardFromExcel.setEnabled(false);
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

    public void notice() {
        new JOptionPane().showMessageDialog(null, "Bạn chưa đăng nhập!");
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

    private void mnuFileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuFileMouseClicked
        notice();
    }//GEN-LAST:event_mnuFileMouseClicked

    private void mnuCreateNewEventsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuCreateNewEventsMouseClicked
        notice();
    }//GEN-LAST:event_mnuCreateNewEventsMouseClicked

    private void mnuMakeNewCardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuMakeNewCardMouseClicked
        notice();
    }//GEN-LAST:event_mnuMakeNewCardMouseClicked

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
    private javax.swing.JLabel lblEmptyLeft;
    private javax.swing.JLabel lblEmptyRight;
    private javax.swing.JLabel lblHello;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUser;
    private javax.swing.JMenu mnuCreateNewEvents;
    private javax.swing.JMenuItem mnuCreateNewEventsFromExcel;
    private javax.swing.JMenu mnuFile;
    private javax.swing.JMenuItem mnuFileExit;
    private javax.swing.JMenuItem mnuFileLogout;
    private javax.swing.JMenu mnuMakeNewCard;
    private javax.swing.JMenuItem mnuMakeNewCardFromExcel;
    private javax.swing.JPanel pnlLogin;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
