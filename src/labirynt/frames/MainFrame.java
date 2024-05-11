/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package labirynt.frames;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import labirynt.MazeData;
import labirynt.printers.MazePrint;
import labirynt.printers.MazePrinter;
import labirynt.readers.MazeReader;
import labirynt.readers.TxtReader;

/**
 *
 * @author Anton
 */
public class MainFrame extends javax.swing.JFrame {
    
    private MazeReader reader;
    private final MazeData mazeData;

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        mazeData = new MazeData(); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ToolBar = new javax.swing.JToolBar();
        chooseStartButton = new javax.swing.JButton();
        chooseEndButton = new javax.swing.JButton();
        jSeparator = new javax.swing.JToolBar.Separator();
        findPathButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        rowsLabel = new javax.swing.JLabel();
        columnsLabel = new javax.swing.JLabel();
        startLabel = new javax.swing.JLabel();
        endLabel = new javax.swing.JLabel();
        mazePanel = new javax.swing.JPanel();
        jMenuBar = new javax.swing.JMenuBar();
        fileLoadButton = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ToolBar.setBackground(new java.awt.Color(255, 255, 255));
        ToolBar.setBorder(null);
        ToolBar.setOrientation(javax.swing.SwingConstants.VERTICAL);
        ToolBar.setRollover(true);
        ToolBar.setMargin(new java.awt.Insets(4, 4, 4, 4));

        chooseStartButton.setBackground(new java.awt.Color(205, 242, 254));
        chooseStartButton.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        chooseStartButton.setText("Wybierz punkt początkowy");
        chooseStartButton.setFocusable(false);
        chooseStartButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        chooseStartButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        chooseStartButton.setMaximumSize(new java.awt.Dimension(252, 35));
        chooseStartButton.setMinimumSize(new java.awt.Dimension(252, 35));
        chooseStartButton.setPreferredSize(new java.awt.Dimension(252, 35));
        chooseStartButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ToolBar.add(chooseStartButton);

        chooseEndButton.setBackground(new java.awt.Color(205, 242, 254));
        chooseEndButton.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        chooseEndButton.setText("Wybierz punkt końcowy");
        chooseEndButton.setFocusable(false);
        chooseEndButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        chooseEndButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        chooseEndButton.setMaximumSize(new java.awt.Dimension(252, 35));
        chooseEndButton.setMinimumSize(new java.awt.Dimension(252, 35));
        chooseEndButton.setPreferredSize(new java.awt.Dimension(252, 35));
        chooseEndButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ToolBar.add(chooseEndButton);
        ToolBar.add(jSeparator);

        findPathButton.setBackground(new java.awt.Color(102, 204, 255));
        findPathButton.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        findPathButton.setText("Znajdź ścieżkę");
        findPathButton.setFocusable(false);
        findPathButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        findPathButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ToolBar.add(findPathButton);
        ToolBar.add(jSeparator1);

        rowsLabel.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        rowsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rowsLabel.setText("Wiersze: 0");
        ToolBar.add(rowsLabel);

        columnsLabel.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        columnsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        columnsLabel.setText("Kolumny: 0");
        ToolBar.add(columnsLabel);

        startLabel.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        startLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        startLabel.setText("Start: 0");
        ToolBar.add(startLabel);

        endLabel.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        endLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        endLabel.setText("Koniec: 0");
        ToolBar.add(endLabel);

        mazePanel.setBackground(new java.awt.Color(255, 255, 255));
        mazePanel.setPreferredSize(new java.awt.Dimension(1200, 1080));

        javax.swing.GroupLayout mazePanelLayout = new javax.swing.GroupLayout(mazePanel);
        mazePanel.setLayout(mazePanelLayout);
        mazePanelLayout.setHorizontalGroup(
            mazePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5120, Short.MAX_VALUE)
        );
        mazePanelLayout.setVerticalGroup(
            mazePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jMenuBar.setBackground(new java.awt.Color(102, 204, 255));

        fileLoadButton.setText("Wczytaj z pliku");
        fileLoadButton.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        fileLoadButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fileLoadButtonMouseClicked(evt);
            }
        });
        jMenuBar.add(fileLoadButton);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(mazePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 5120, Short.MAX_VALUE)
                .addContainerGap(897, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, 5120, Short.MAX_VALUE)
                    .addComponent(mazePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 5120, Short.MAX_VALUE))
                .addContainerGap(1073, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fileLoadButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fileLoadButtonMouseClicked
        fileLoadBtnClicked();
    }//GEN-LAST:event_fileLoadButtonMouseClicked

   
    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToolBar ToolBar;
    private javax.swing.JButton chooseEndButton;
    private javax.swing.JButton chooseStartButton;
    private javax.swing.JLabel columnsLabel;
    private javax.swing.JLabel endLabel;
    private javax.swing.JMenu fileLoadButton;
    private javax.swing.JButton findPathButton;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JToolBar.Separator jSeparator;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JPanel mazePanel;
    private javax.swing.JLabel rowsLabel;
    private javax.swing.JLabel startLabel;
    // End of variables declaration//GEN-END:variables

    private void fileLoadBtnClicked() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(MainFrame.this);
        File file = fileChooser.getSelectedFile();
        if (file != null){
            parseFile(file);
            reader.readFromFile(mazeData);
            //printmaze(file.getAbsolutePath());
            printmaze();
        }
    }
    
    private void parseFile(File file) {
        String fileName = file.getName();
        switch (getFileExtension(fileName)){
        
            case "txt" -> reader = new TxtReader(file.getAbsolutePath());
            
            case "bin" -> {
            }
        
        }
    }
    
    private static String getFileExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
    }
    
    /*private void print(){
        MazePrinter printer = new MazePrinter(mazeData.mazeCells);
        mazePanel.removeAll();
        printer.print(mazePanel);
    
    }*/
    
    private void printmaze(){
       MazePrint mazePrint = new MazePrint(mazeData.mazeCells);
       mazePanel.removeAll();
       mazePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
       mazePrint.setPreferredSize(new Dimension(50000,50000));
       JScrollPane scrollPane = new JScrollPane(mazePrint);
       scrollPane.setPreferredSize(new Dimension(1000,700));
       mazePanel.add(scrollPane);
       mazePanel.revalidate();
       mazePanel.repaint();
    }
    /*
    private void printsquare(Color c){
       JPanel squarePanel = new JPanel();
       squarePanel.setPreferredSize( new Dimension(5,5));
       squarePanel.setBackground(c);
       mazePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
       mazePanel.add(squarePanel);
       mazePanel.revalidate();
       mazePanel.repaint();
    }
    */

    
}
