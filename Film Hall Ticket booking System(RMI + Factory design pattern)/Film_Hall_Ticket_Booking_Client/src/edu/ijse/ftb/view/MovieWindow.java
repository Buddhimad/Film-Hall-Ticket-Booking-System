package edu.ijse.ftb.view;

import edu.ijse.ftb.connector.ServerConnector;
import edu.ijse.ftb.controller.MovieController;
import edu.ijse.ftb.dto.MovieDTO;
import edu.ijse.ftb.observer.Observer;
import edu.ijse.ftb.observer.Subject;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MovieWindow extends javax.swing.JInternalFrame implements Observer {

    public MovieWindow() {
        initComponents();
        LoadMovieTable();
        lblMID.setText(getKeyID());
        try {
            UnicastRemoteObject.exportObject(this, 0);
            MovieController mct = ServerConnector.getServerConnector().getMovieController();
            Subject s = (Subject) mct;
            s.registerObserver(this);
        } catch (RemoteException ex) {
            Logger.getLogger(TestingWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(TestingWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(TestingWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnlbtn = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        pnlReg = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMoviename = new javax.swing.JTextField();
        txtAT = new javax.swing.JTextField();
        txtDu = new javax.swing.JTextField();
        txtSD = new javax.swing.JTextField();
        txtED = new javax.swing.JTextField();
        txtVQ = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        btnFind = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtMoID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtLan = new javax.swing.JTextField();
        lblMID = new javax.swing.JLabel();
        pnltbl = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMovie = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 1, true));
        setClosable(true);
        setIconifiable(true);
        setTitle("Movie Controller");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 255), 1, true));

        pnlbtn.setBackground(new java.awt.Color(255, 255, 255));
        pnlbtn.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(102, 153, 255)));

        btnAdd.setBackground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnView.setBackground(new java.awt.Color(255, 255, 255));
        btnView.setText("View");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnClose.setBackground(new java.awt.Color(255, 255, 255));
        btnClose.setText("Close");

        javax.swing.GroupLayout pnlbtnLayout = new javax.swing.GroupLayout(pnlbtn);
        pnlbtn.setLayout(pnlbtnLayout);
        pnlbtnLayout.setHorizontalGroup(
            pnlbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlbtnLayout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 43, Short.MAX_VALUE)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 43, Short.MAX_VALUE)
                .addComponent(btnView, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 43, Short.MAX_VALUE)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 43, Short.MAX_VALUE)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        pnlbtnLayout.setVerticalGroup(
            pnlbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlbtnLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(pnlbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnView, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pnlReg.setBackground(new java.awt.Color(255, 255, 255));
        pnlReg.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(51, 153, 255), new java.awt.Color(102, 153, 255)));

        jLabel1.setText("Movie Name");

        jLabel3.setText("Available Time");

        jLabel4.setText("Duration");

        jLabel5.setText("Start Date");

        jLabel6.setText("End Date");

        jLabel7.setText("Video Quality");

        jSeparator1.setForeground(new java.awt.Color(51, 153, 255));

        btnFind.setBackground(new java.awt.Color(255, 255, 255));
        btnFind.setText("Find");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        jLabel8.setText("Movie ID");

        jLabel2.setText("Language");

        lblMID.setText("MovieID");

        javax.swing.GroupLayout pnlRegLayout = new javax.swing.GroupLayout(pnlReg);
        pnlReg.setLayout(pnlRegLayout);
        pnlRegLayout.setHorizontalGroup(
            pnlRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jSeparator1)
                        .addGroup(pnlRegLayout.createSequentialGroup()
                            .addGroup(pnlRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7)
                                .addComponent(jLabel8)
                                .addComponent(jLabel2))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(pnlRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtED)
                                .addComponent(txtSD)
                                .addComponent(txtDu)
                                .addComponent(txtAT)
                                .addComponent(txtMoviename)
                                .addComponent(txtVQ, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtLan, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(pnlRegLayout.createSequentialGroup()
                                    .addComponent(txtMoID, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnFind, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)))
                            .addGap(5, 5, 5)))
                    .addComponent(lblMID))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlRegLayout.setVerticalGroup(
            pnlRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMoviename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(pnlRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtMoID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(pnlRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtAT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(pnlRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(pnlRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtSD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(pnlRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtED, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(pnlRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtVQ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(pnlRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtLan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMID))
        );

        pnltbl.setBackground(new java.awt.Color(255, 255, 255));
        pnltbl.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(102, 153, 255)));

        tblMovie.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MovieID", "Name", "Language", "Available Time", "Start Date", "End Date", "Video Quality", "Duration"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblMovie.setGridColor(new java.awt.Color(102, 102, 102));
        jScrollPane1.setViewportView(tblMovie);

        javax.swing.GroupLayout pnltblLayout = new javax.swing.GroupLayout(pnltbl);
        pnltbl.setLayout(pnltblLayout);
        pnltblLayout.setHorizontalGroup(
            pnltblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnltblLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        pnltblLayout.setVerticalGroup(
            pnltblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnltblLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pnlReg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnltbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(pnlbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(pnlbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlReg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnltbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        addMovies();
        LoadMovieTable();
        // lblMID.setText(getKeyID());
        adjustMovieIdAllFrames();
        // lblMID.setText(checkID(cid));
        //txtCID.setText(getKeyID());

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        updateMovies();
        LoadMovieTable();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        searchMovies();

    }//GEN-LAST:event_btnFindActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        deleteMovie();
        //getKeyID();
        LoadMovieTable();

        adjustMovieIdAllFrames();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        LoadMovieTable();
    }//GEN-LAST:event_btnViewActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnView;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblMID;
    private javax.swing.JPanel pnlReg;
    private javax.swing.JPanel pnlbtn;
    private javax.swing.JPanel pnltbl;
    private javax.swing.JTable tblMovie;
    private javax.swing.JTextField txtAT;
    private javax.swing.JTextField txtDu;
    private javax.swing.JTextField txtED;
    private javax.swing.JTextField txtLan;
    private javax.swing.JTextField txtMoID;
    private javax.swing.JTextField txtMoviename;
    private javax.swing.JTextField txtSD;
    private javax.swing.JTextField txtVQ;
    // End of variables declaration//GEN-END:variables

    public void LoadMovieTable() {
        try {
            MovieController mc = ServerConnector.getServerConnector().getMovieController();
            ArrayList<MovieDTO> lists = mc.getAllMovies();
            DefaultTableModel dtm = (DefaultTableModel) tblMovie.getModel();
            dtm.setRowCount(0);

            for (MovieDTO m : lists) {
                Object[] rows = {m.getMoid(), m.getName(), m.getLanguage(), m.getAvailableTime(), m.getStartDate(), m.getEndDate(), m.getVideoQuality(), m.getDuration()};
                dtm.addRow(rows);
            }

        } catch (NotBoundException ex) {
            Logger.getLogger(MovieWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(MovieWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(MovieWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(MovieWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MovieWindow.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void addMovies() {
        try {
            String name = txtMoviename.getText();
            String moid = lblMID.getText();
            String at = txtAT.getText();
            String du = txtDu.getText();
            String sd = txtSD.getText();
            String ed = txtED.getText();
            String vq = txtVQ.getText();
            String lan = txtLan.getText();
            MovieDTO movie = new MovieDTO(moid, name, lan, at, sd, ed, vq, du);

            MovieController mc = ServerConnector.getServerConnector().getMovieController();
            boolean isAdded = mc.add(movie);
            if (isAdded) {
                JOptionPane.showMessageDialog(this, "Movie details saved..");
            } else {
                JOptionPane.showMessageDialog(this, "Can't Save...");
            }
        } catch (ParseException ex) {
            Logger.getLogger(MovieWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MovieWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(MovieWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateMovies() {
        try {
            String name = txtMoviename.getText();
            String moid = lblMID.getText();
            String at = txtAT.getText();
            String du = txtDu.getText();
            String sd = txtSD.getText();
            String ed = txtED.getText();
            String vq = txtVQ.getText();
            String lan = txtLan.getText();
            MovieDTO movie = new MovieDTO(moid, name, lan, at, sd, ed, vq, du);

            MovieController mc = ServerConnector.getServerConnector().getMovieController();
            boolean isUpdated = mc.update(movie);
            if (isUpdated) {
                JOptionPane.showMessageDialog(this, "Movie details Updated..");
            } else {
                JOptionPane.showMessageDialog(this, "Update Failed...");
            }
        } catch (NotBoundException ex) {
            Logger.getLogger(MovieWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(MovieWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(MovieWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(MovieWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MovieWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void searchMovies() {
        try {
            String moid = txtMoID.getText();

            MovieController mc = ServerConnector.getServerConnector().getMovieController();
            MovieDTO mdto = mc.search(moid);
            if (mdto != null) {
                txtMoviename.setText(mdto.getName());
                //txtMoID.setText(mdto.getMoid());
                txtAT.setText(mdto.getAvailableTime());
                txtDu.setText(mdto.getDuration());
                txtSD.setText(mdto.getStartDate());
                txtED.setText(mdto.getEndDate());
                txtVQ.setText(mdto.getVideoQuality());
                txtLan.setText(mdto.getLanguage());

            } else {
                JOptionPane.showMessageDialog(this, "Not found...");
            }
        } catch (NotBoundException ex) {
            Logger.getLogger(MovieWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(MovieWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(MovieWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(MovieWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MovieWindow.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deleteMovie() {
        try {
            String moid = txtMoID.getText();

            MovieController mc = ServerConnector.getServerConnector().getMovieController();
            boolean isdeleted = mc.delete(moid);
            if (isdeleted) {
                JOptionPane.showMessageDialog(this, "Deleted...");
            } else {
                JOptionPane.showMessageDialog(this, "Cannot delete...");
            }
        } catch (NotBoundException ex) {
            Logger.getLogger(MovieWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(MovieWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(MovieWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(MovieWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MovieWindow.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void clearFields() {

    }

    //////////////////////////////////////////////////////////////////////////////////////////
    /*Movie ID generate */
    private static int i = 0;

    public static String getKeyID() {

        try {
            File file = new File("D:\\IJSE\\Project 2\\Film_Hall_Ticket_Booking_Server\\src\\edu\\ijse\\ftb\\file\\Movie.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String sCurrentLine;
            String lastLine = "";

            while ((sCurrentLine = br.readLine()) != null) {
                lastLine = sCurrentLine;

            }
            String[] store = lastLine.split("#");
            String t = store[0];
            String temp = t.replaceAll("M", "");
            i = Integer.parseInt(temp);
            i++;

        } catch (IOException | NumberFormatException e) {
            System.out.println(e);
        }
        return "M" + i;
    }

    /*checking movie id if its exists in file*/

    public String checkID(String id) {
        FileReader fw = null;
        String current;
        String lstline = "";
        String newid;
        try {
            File file = new File("D:\\IJSE\\Project 2\\Film_Hall_Ticket_Booking_Server\\src\\edu\\ijse\\ftb\\file\\Movie.txt");
            fw = new FileReader(file);
            BufferedReader br = new BufferedReader(fw);

            if ((current = br.readLine()) != null) {
                lstline = current;
            }
            String[] ca = lstline.split("#");
            if (id.equals(ca[0])) {
                String temp = id.replace("M", "");
                int tmp = Integer.parseInt(temp);
                tmp++;
                return "M" + tmp;
            }

        } catch (IOException ex) {
            Logger.getLogger(TestingWindow.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(TestingWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return id;
    }

    @Override
    public void update(String message) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateLabel(String messege) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateButton(JButton btn, String text) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateLbl(JLabel lbl, String text) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void incCID(String cid) throws RemoteException {

    }

    public void adjustMovieIdAllFrames() {

        try {
            MovieController mc = ServerConnector.getServerConnector().getMovieController();

            mc.checkMovieId(lblMID.getText());
            lblMID.setText(checkID(getKeyID()));

        } catch (NotBoundException ex) {
            Logger.getLogger(MovieWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(MovieWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(MovieWindow.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void AdjustMID(String mid) throws RemoteException {
        System.out.println("window AdjustMID method" + mid);
        String temp = mid.replace("M", "");
        int a = Integer.parseInt(temp);
        a++;
        String newid = "M" + a;
        System.out.println(newid);
        lblMID.setText(newid);
    }
}
