package forestfires;

import java.awt.Color;

// DO NOT MODIFY THIS CLASS
// DO NOT SUBMIT THIS FILE

/**
 * A class that provides a graphical interface
 *
 * @author mmonsalv, lselavo
 */
public class FFViewer extends javax.swing.JFrame {

    private java.awt.Image _bg = null;

    /**
     * Creates new form FFViewer
     */
    public FFViewer() {
        initComponents();
        this.setSize(600, 600);
        _bg = new java.awt.image.BufferedImage(600, 600, java.awt.image.BufferedImage.TYPE_INT_RGB);
        this.setVisible(true);
        this.repaint();
    }

    /**
     * Terminates both the viewer and the application!
     *
     * @param terminate If true, ends the execution of the application
     */
    public void kill(boolean terminate) {
        this.dispose();
        if (terminate) {
            System.exit(0);
        }
    }

    /**
     * Puts the viewer and the controlling Thread on pause.
     *
     * @param seconds The number of seconds to pause. Can be a decimal.
     */
    public void pause(double seconds) {
        this.repaint();
        try {
            Thread.sleep((int) (seconds * 1000));
        } catch (Exception e) {
        }
    }

    private int neg = -5;

    /**
     * Draws an array of FFTrees in the display window.
     *
     * @param T The array of FFTrees to be drawn.
     */
    public void drawTrees(FFTree[] T) {
        java.awt.Graphics gfx = _bg.getGraphics();
        gfx.setColor(Color.WHITE);
        gfx.fillRect(0, 0, 600, 600);
        if (T == null) {
            return;
        }
        for (FFTree t : T) {
            int x = t.getX(), y = t.getY();
            if (t.isBurnt()) {
                gfx.setColor(new java.awt.Color(0, 0, 0));
            } else {
                gfx.setColor(new java.awt.Color(125, 100, 60));
            }
            gfx.fillRect(x - 1, y, 3, 15);
            if (t.isBurning()) {
                gfx.setColor(new java.awt.Color(200, 50, 0));
            } else if (t.isBurnt()) {
                gfx.setColor(new java.awt.Color(0, 0, 0));
            } else {
                gfx.setColor(new java.awt.Color(30, 200, 60));
            }
            gfx.fillOval(x - 11, y - 14, 23, 16);
            if (t.isBurning()) {
                gfx.setColor(new java.awt.Color(250, 150, 100));
                gfx.fillArc(x, y - 20 - neg, 10, 20 + 2*neg, 110, 300);
            }
        }
        neg *= -1;
        repaint();
    }

    /**
     * Useless from the main thread. This is called from the window system.
     *
     * @param g The handle for drawing onto.
     */
    @Override
    public void paint(java.awt.Graphics gfx) {
        gfx.drawImage(_bg, 0, 0, null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 528, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 397, Short.MAX_VALUE)
        );

        pack();
    }
}
