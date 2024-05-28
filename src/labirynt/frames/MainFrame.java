/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package labirynt.frames;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import labirynt.MazeData;
import labirynt.printers.MazePrint;
import labirynt.readers.MazeReader;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import labirynt.Cell;
import Console.Console;
import Observers.ConsoleObserver;
import labirynt.MazeSolver;
import Observers.Observer;

/**
 *
 * @author Anton
 */
public class MainFrame extends javax.swing.JFrame {

    private final MazeData mazeData;
    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private final int screenWidth = (int) screenSize.width;
    private final int screenHeight = (int) screenSize.height;
    private MazePrint mazePrint;
    private MazeSolver mazeSolver;

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        mazeData = new MazeData();
        messageLabel.setText("<html>");
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
        jScrollPane = new javax.swing.JScrollPane();
        messagePanel = new javax.swing.JPanel();
        messageLabel = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        fileLoadButton = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(screenWidth , screenHeight - 50));

        ToolBar.setBackground(new java.awt.Color(255, 255, 255));
        ToolBar.setBorder(null);
        ToolBar.setOrientation(javax.swing.SwingConstants.VERTICAL);
        ToolBar.setRollover(true);
        ToolBar.setMargin(new java.awt.Insets(4, 4, 4, 4));
        ToolBar.setPreferredSize(new java.awt.Dimension(screenWidth * 18 / 100, screenHeight * 8 / 10));

        chooseStartButton.setBackground(new java.awt.Color(205, 242, 254));
        chooseStartButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        chooseStartButton.setText("Wybierz punkt początkowy");
        chooseStartButton.setFocusable(false);
        chooseStartButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        chooseStartButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        chooseStartButton.setMaximumSize(new java.awt.Dimension(252, 35));
        chooseStartButton.setMinimumSize(new java.awt.Dimension(252, 35));
        chooseStartButton.setPreferredSize(new java.awt.Dimension(252, 35));
        chooseStartButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        chooseStartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseStartButtonActionPerformed(evt);
            }
        });
        ToolBar.add(chooseStartButton);

        chooseEndButton.setBackground(new java.awt.Color(205, 242, 254));
        chooseEndButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        chooseEndButton.setText("Wybierz punkt końcowy");
        chooseEndButton.setFocusable(false);
        chooseEndButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        chooseEndButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        chooseEndButton.setMaximumSize(new java.awt.Dimension(252, 35));
        chooseEndButton.setMinimumSize(new java.awt.Dimension(252, 35));
        chooseEndButton.setPreferredSize(new java.awt.Dimension(252, 35));
        chooseEndButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        chooseEndButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseEndButtonActionPerformed(evt);
            }
        });
        ToolBar.add(chooseEndButton);
        ToolBar.add(jSeparator);

        findPathButton.setBackground(new java.awt.Color(102, 204, 255));
        findPathButton.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        findPathButton.setText("Znajdź ścieżkę");
        findPathButton.setFocusable(false);
        findPathButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        findPathButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        findPathButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findPathButtonActionPerformed(evt);
            }
        });
        ToolBar.add(findPathButton);
        ToolBar.add(jSeparator1);

        rowsLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rowsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rowsLabel.setText("Wiersze: 0");
        ToolBar.add(rowsLabel);

        columnsLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        columnsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        columnsLabel.setText("Kolumny: 0");
        ToolBar.add(columnsLabel);

        startLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        startLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        startLabel.setText("Start: 0");
        ToolBar.add(startLabel);

        endLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        endLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        endLabel.setText("Koniec: 0");
        ToolBar.add(endLabel);

        mazePanel.setBackground(new java.awt.Color(255, 255, 255));
        Dimension mazePanelSize = new java.awt.Dimension(screenWidth * 6 / 10 ,screenHeight * 8 / 10);
        mazePanel.setPreferredSize(mazePanelSize);

        javax.swing.GroupLayout mazePanelLayout = new javax.swing.GroupLayout(mazePanel);
        mazePanel.setLayout(mazePanelLayout);
        mazePanelLayout.setHorizontalGroup(
            mazePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        mazePanelLayout.setVerticalGroup(
            mazePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setPreferredSize(new java.awt.Dimension(screenWidth * 18 / 100, screenHeight * 8 / 10));

        messagePanel.setPreferredSize(new java.awt.Dimension(screenWidth * 18 / 100 , 32767));

        messageLabel.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        messageLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout messagePanelLayout = new javax.swing.GroupLayout(messagePanel);
        messagePanel.setLayout(messagePanelLayout);
        messagePanelLayout.setHorizontalGroup(
            messagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(messagePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(messageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        messagePanelLayout.setVerticalGroup(
            messagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(messagePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(messageLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane.setViewportView(messagePanel);

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
                .addComponent(ToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mazePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(5763, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mazePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1073, 1073, 1073))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fileLoadButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fileLoadButtonMouseClicked
        fileLoadBtnClicked();
    }//GEN-LAST:event_fileLoadButtonMouseClicked

    private void chooseStartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseStartButtonActionPerformed
        if (mazePrint == null) {
            showMessage("Nie wczytano jeszcze labiryntu<br>");
        } else {
            mazePrint.removeMouseListener(endPointMouseListener);
            mazePrint.removeMouseListener(startPointMouseListener);
            mazePrint.addMouseListener(startPointMouseListener);
        }
    }//GEN-LAST:event_chooseStartButtonActionPerformed

    private void chooseEndButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseEndButtonActionPerformed
        if (mazePrint == null) {
            showMessage("Nie wczytano jeszcze labiryntu<br>");
        } else {
            mazePrint.removeMouseListener(endPointMouseListener);
            mazePrint.removeMouseListener(startPointMouseListener);
            mazePrint.addMouseListener(endPointMouseListener);
        }
    }//GEN-LAST:event_chooseEndButtonActionPerformed

    private void findPathButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findPathButtonActionPerformed
        if (mazeSolver == null || !mazeSolver.isPath) {
            mazeSolver = new MazeSolver(mazeData);
            mazeSolver.getPath();
            findPathButton.setText("Schowaj ścieżkę");
            mazePanel.repaint();
        } else {
            mazeSolver.isPath = false;
            mazeSolver.cellsResetPath();
            findPathButton.setText("Znajdź ścieżkę");
            mazePanel.repaint();
        }
    }//GEN-LAST:event_findPathButtonActionPerformed

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
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JToolBar.Separator jSeparator;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JPanel mazePanel;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JPanel messagePanel;
    private javax.swing.JLabel rowsLabel;
    private javax.swing.JLabel startLabel;
    // End of variables declaration//GEN-END:variables

    private void fileLoadBtnClicked() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(MainFrame.this);
        File file = fileChooser.getSelectedFile();
        if (file != null) {
            showMessage("Wybrano plik: <br>" + file.getName() + "<br>");
            readFile(file);
        }
    }

    public void readFile(File file) {
        MazeReader reader = new MazeReader(file, mazeData, this);
        reader.readFile();
        showMessage("Wczytano labirynt: " + mazeData.getColumns() + "x" + mazeData.getRows() + "<br>");
        printMaze();
        setMazeLabels();
    }

    private void printMaze() {
        mazePrint = new MazePrint(mazeData);
        int margin = 20;
        int maxMazeSize = (1024 * 2 + 1) * mazePrint.getSquareSize();
        mazePanel.removeAll();
        mazePanel.setLayout(new FlowLayout(FlowLayout.LEFT, margin, margin));
        mazePrint.setPreferredSize(new Dimension(maxMazeSize, maxMazeSize));
        JScrollPane scrollPane = new JScrollPane(mazePrint);
        scrollPane.setPreferredSize(new Dimension(screenWidth * 6 / 10 - 2 * margin, screenHeight * 8 / 10 - 2 * margin));
        mazePanel.add(scrollPane);
        mazePanel.revalidate();
        mazePanel.repaint();

    }

    private void setMazeLabels() {
        columnsLabel.setText("Kolumny: " + mazeData.getColumns());
        rowsLabel.setText("Wiersze: " + mazeData.getRows());
        startLabel.setText("Start: " + mazeData.getStart());
        endLabel.setText("End: " + mazeData.getEnd());
    }

    public void showMessage(String text) {
        String oldText = messageLabel.getText();
        messageLabel.setText(oldText + text);
    }

    private final MouseListener startPointMouseListener = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            setPoint(e, true);
        }
    };

    private final MouseListener endPointMouseListener = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            setPoint(e, false);
        }
    };

    private void setPoint(MouseEvent e, Boolean ifStart) {
        int x = e.getX() / mazePrint.getSquareSize();
        int y = e.getY() / mazePrint.getSquareSize();
        if (x % 2 == 0 || y % 2 == 0) {
            showMessage("Nie możesz wybrać punktu w tym miejscu <br>");
            mazePrint.removeMouseListener(startPointMouseListener);
            mazePrint.removeMouseListener(endPointMouseListener);
        } else {
            x /= 2;
            y /= 2;
            int node = mazeData.getColumns() * y + x;
            if (node == mazeData.getStart() || node == mazeData.getEnd()) {
                showMessage("Nie możesz wybrać punktu w tym miejscu <br>");
            } else {
                if (ifStart == true) {
                    updateStartCell(y, x);
                    showMessage("Wybrano punkt początkowy: " + node + "<br>");
                    mazePrint.removeMouseListener(startPointMouseListener);
                    mazeData.setStart(node);
                } else {
                    updateEndCell(y, x);
                    showMessage("Wybrano punkt końcowy: " + node + "<br>");
                    mazePrint.removeMouseListener(endPointMouseListener);
                    mazeData.setEnd(node);
                }
                setMazeLabels();

            }

        }
    }

    private void updateStartCell(int y, int x) {
        int oldX, oldY;
        int oldStart = mazeData.getStart();
        oldY = oldStart / mazeData.getColumns();
        oldX = oldStart - oldY * mazeData.getColumns();
        List<List<Cell>> cells = mazeData.getMazeCells();
        cells.get(oldY * 2 + 1).set(oldX * 2 + 1, Cell.PATH);
        cells.get(y * 2 + 1).set(x * 2 + 1, Cell.START);
        mazeData.setMazeCells(cells);
        printMaze();
    }

    private void updateEndCell(int y, int x) {
        int oldX, oldY;
        int oldEnd = mazeData.getEnd();
        oldY = oldEnd / mazeData.getColumns();
        oldX = oldEnd - oldY * mazeData.getColumns();
        List<List<Cell>> cells = mazeData.getMazeCells();
        cells.get(oldY * 2 + 1).set(oldX * 2 + 1, Cell.PATH);
        cells.get(y * 2 + 1).set(x * 2 + 1, Cell.END);
        mazeData.setMazeCells(cells);
        printMaze();
    }
    
    @Override
     public void setVisible(boolean b) {
        super.setVisible(b);
        Console console = new Console();
        Observer consoleObserver = new ConsoleObserver(this);
        console.addObserver(consoleObserver);
        console.setConsoleListener();
    }
}
