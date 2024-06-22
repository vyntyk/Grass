import java.awt.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

class Grass {
    public static void main(String[] args) throws Exception {
        JFrame jFrame = getFrame();
        MyComponent component = new MyComponent();
        JButton jButton = new JButton("Button");
        jFrame.add(jButton);
        jFrame.add(component);
        jButton.setVisible(false);
    }

    static JFrame getFrame() {
        JFrame jFrame = new JFrame() {
        };
        jFrame.setVisible(true);
        jFrame.setTitle("Grass");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(dimension.width / 2 - 400, dimension.height / 2 - 400, 800, 800);
        return jFrame;
    }
}
class MyComponent extends JComponent {
    Image frame;

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                try {
                    frame = ImageIO.read(new File("src\\grass.png"));
                    frame = frame.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
                    g2.drawImage(frame, j * 50, i * 50, getFocusCycleRootAncestor());
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}