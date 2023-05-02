import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//triangulos de pascal
//gmd
//mcd
//fractales
//



public final class Fractal extends JFrame{
    private final int MIN_LEVEL = 0;
    private Color color = Color.BLUE;
    private JButton changeColorJButton;
    private JButton botonIncrementar; 
    private JButton botonDecrementar;
    private JLabel levelJLabel;
    private FractalJPanel drawSpace;
    private JPanel mainJPanel;
    private JPanel controlJPanel;
    
    public Fractal(){
        super("Fractal");
        initComponents();
        setBounds(250, 100, 400, 450);
        setVisible(true);
    }
    
    public void initComponents(){
        controlJPanel = new JPanel();
        controlJPanel.setLayout(new FlowLayout());
        controlJPanel.setBackground(Color.BLACK);
        cambiarColor();
        funcionDecrementar();
        funcionIncrementar();
        levelJLabel = new JLabel("Level: 0");
        levelJLabel.setForeground(Color.RED);
        levelJLabel.setFont(new Font("chiller", 1, 20));
        controlJPanel.add(levelJLabel);
        drawSpace = new FractalJPanel(0);
        mainJPanel =  new JPanel();
        mainJPanel.add(controlJPanel);
        mainJPanel.add(drawSpace);
        mainJPanel.setBackground(Color.BLACK);
        add(mainJPanel);
    }
    public void cambiarColor(){
        changeColorJButton =  new JButton("Color");
        controlJPanel.add(changeColorJButton);
        changeColorJButton.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    color = JColorChooser.showDialog(
                            Fractal.this, "Chose a color", color);
                    if(color == null)
                        color = Color.BLUE;
                    drawSpace.setColor(color);
                } 
            }
        );
    }
    public void funcionIncrementar(){
        botonIncrementar = new JButton("Incrementar nivel");
        controlJPanel.add(botonIncrementar);
        botonIncrementar.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int level = drawSpace.getLevel();
                    level++;
                    if(level >= MIN_LEVEL){
                        levelJLabel.setText("Level: " + level);
                        drawSpace.setLevel(level);
                        repaint();
                    }
                }
            }
        );
    }
    public void funcionDecrementar(){
        botonDecrementar = new JButton("decrementar nivel");
        controlJPanel.add(botonDecrementar);
        botonDecrementar.addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    int level = drawSpace.getLevel();
                    level--;
                    if(level >= MIN_LEVEL){
                        levelJLabel.setText("Level: " + level);
                        drawSpace.setLevel(level);
                        repaint();
                    }
                }   
            }  
        );
    }
    class FractalJPanel extends JPanel{
        private Color color;
        private int level;
        public FractalJPanel(int currentLevel){
            color = Color.BLUE;
            level = currentLevel;
            setBackground(Color.WHITE);
            setPreferredSize(new Dimension(400,400));
        }
        public void drawFractal(int level, int xA, int yA, int xB, int yB, Graphics g){
            if(level == 0)
                g.drawLine(xA, yA, xB, yB);
            else{
                int xC = (xA + xB)/ 2;
                int yC = (yA + yB)/ 2;
                int xD = xA + (xC - xA)/ 2 -(yC - yA)/ 2;
                int yD = yA + (yC - yA)/ 2 +(xC - xA)/ 2;
                drawFractal(level - 1, xD, yD, xA, yA, g);
                drawFractal(level - 1, xD, yD, xC, yC, g);
                drawFractal(level - 1, xD, yD, xB, yB, g);
            }
        }
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(color);
            drawFractal(level,100,90,290,200,g);
        }
        public void setColor(Color c){
            color = c;
        }
        public void setLevel(int currentLevel){
            level = currentLevel;
        }
        public int getLevel(){
            return level;
        }
    }
}