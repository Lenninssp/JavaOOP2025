package MyEngine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    static double[] cameraPosition = {0, 0, -500};
    static int[] rotation = {0, 0};
    static double zoom = 1.0;

    public static void main(String[] args) {
        JFrame frame = new JFrame("3D Renderer");
        Container pane = frame.getContentPane();
        pane.setLayout(new BorderLayout());

        JPanel renderPanel = new JPanel() {
            public void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

                g2.setColor(Color.BLACK);
                g2.fillRect(0, 0, getWidth(), getHeight());

                g2.translate(getWidth() / 2, getHeight() / 2);
                g2.scale(zoom, zoom);

                ArrayList<Triangle> tris = createTetrahedron();

                Matrix3 transform = getTransformationMatrix();

                ArrayList<Triangle> transformedTris = new ArrayList<>();
                for (Triangle t : tris) {
                    Vertex v1 = transform.transform(t.v1);
                    Vertex v2 = transform.transform(t.v2);
                    Vertex v3 = transform.transform(t.v3);

                    double centerZ = (v1.z + v2.z + v3.z) / 3.0;
                    transformedTris.add(new Triangle(v1, v2, v3, t.color, centerZ));
                }

                Collections.sort(transformedTris, Comparator.comparingDouble(t -> -t.centerZ));

                for (Triangle t : transformedTris) {
                    drawTriangleWithLighting(g2, t);
                }
            }
        };


        MouseAdapter mouseAdapter = new MouseAdapter() {
            private Point lastPoint;

            @Override
            public void mousePressed(MouseEvent e) {
                lastPoint = e.getPoint();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                if (lastPoint != null) {
                    int dx = e.getX() - lastPoint.x;
                    int dy = e.getY() - lastPoint.y;

                    rotation[0] = (rotation[0] + dx) % 360;
                    rotation[1] = Math.min(89, Math.max(-89, rotation[1] + dy));

                    lastPoint = e.getPoint();
                    renderPanel.repaint();
                }
            }

            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                zoom = Math.max(0.1, zoom - e.getWheelRotation() * 0.1);
                renderPanel.repaint();
            }
        };

        renderPanel.addMouseListener(mouseAdapter);
        renderPanel.addMouseMotionListener(mouseAdapter);
        renderPanel.addMouseWheelListener(mouseAdapter);

        pane.add(renderPanel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setVisible(true);
    }

    private static ArrayList<Triangle> createTetrahedron() {
        ArrayList<Triangle> tris = new ArrayList<>();
        double size = 150;


        Vertex v1 = new Vertex(size, size, size);
        Vertex v2 = new Vertex(-size, -size, size);
        Vertex v3 = new Vertex(-size, size, -size);
        Vertex v4 = new Vertex(size, -size, -size);


        tris.add(new Triangle(v1, v2, v3, new Color(255, 100, 100)));
        tris.add(new Triangle(v1, v2, v4, new Color(100, 255, 100)));
        tris.add(new Triangle(v1, v3, v4, new Color(100, 100, 255)));
        tris.add(new Triangle(v2, v3, v4, new Color(255, 255, 100)));

        return tris;
    }

    private static Matrix3 getTransformationMatrix() {
        double heading = Math.toRadians(rotation[0]);
        double pitch = Math.toRadians(rotation[1]);

        Matrix3 headingTransform = new Matrix3(new double[]{
                Math.cos(heading), 0, -Math.sin(heading),
                0, 1, 0,
                Math.sin(heading), 0, Math.cos(heading)
        });

        Matrix3 pitchTransform = new Matrix3(new double[]{
                1, 0, 0,
                0, Math.cos(pitch), Math.sin(pitch),
                0, -Math.sin(pitch), Math.cos(pitch)
        });

        return headingTransform.multiply(pitchTransform);
    }

    private static void drawTriangleWithLighting(Graphics2D g2, Triangle t) {

        Vertex v1 = t.v1;
        Vertex v2 = t.v2;
        Vertex v3 = t.v3;

        Vertex normal = calculateNormal(v1, v2, v3);


        double lightIntensity = Math.max(0.2, calculateLightIntensity(normal));


        Color baseColor = t.color;
        Color shadedColor = new Color(
                (int)(baseColor.getRed() * lightIntensity),
                (int)(baseColor.getGreen() * lightIntensity),
                (int)(baseColor.getBlue() * lightIntensity)
        );


        Path2D path = new Path2D.Double();
        path.moveTo(v1.x, v1.y);
        path.lineTo(v2.x, v2.y);
        path.lineTo(v3.x, v3.y);
        path.closePath();

        g2.setColor(shadedColor);
        g2.fill(path);


        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(1.0f));
        g2.draw(path);
    }

    private static Vertex calculateNormal(Vertex v1, Vertex v2, Vertex v3) {
        double ax = v2.x - v1.x;
        double ay = v2.y - v1.y;
        double az = v2.z - v1.z;
        double bx = v3.x - v1.x;
        double by = v3.y - v1.y;
        double bz = v3.z - v1.z;


        double nx = ay * bz - az * by;
        double ny = az * bx - ax * bz;
        double nz = ax * by - ay * bx;


        double length = Math.sqrt(nx * nx + ny * ny + nz * nz);
        return new Vertex(nx/length, ny/length, nz/length);
    }

    private static double calculateLightIntensity(Vertex normal) {

        Vertex lightDir = new Vertex(0.5, -1, 0.5);
        double length = Math.sqrt(lightDir.x * lightDir.x + lightDir.y * lightDir.y + lightDir.z * lightDir.z);
        lightDir.x /= length;
        lightDir.y /= length;
        lightDir.z /= length;


        return -(normal.x * lightDir.x + normal.y * lightDir.y + normal.z * lightDir.z);
    }
}

class Vertex {
    double x, y, z;

    Vertex(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

class Triangle {
    Vertex v1, v2, v3;
    Color color;
    double centerZ;

    Triangle(Vertex v1, Vertex v2, Vertex v3, Color color) {
        this(v1, v2, v3, color, 0);
    }

    Triangle(Vertex v1, Vertex v2, Vertex v3, Color color, double centerZ) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
        this.color = color;
        this.centerZ = centerZ;
    }
}

class Matrix3 {
    double[] values;

    Matrix3(double[] values) {
        this.values = values;
    }

    Matrix3 multiply(Matrix3 other) {
        double[] result = new double[9];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                for (int i = 0; i < 3; i++) {
                    result[row * 3 + col] += this.values[row * 3 + i] * other.values[i * 3 + col];
                }
            }
        }
        return new Matrix3(result);
    }

    Vertex transform(Vertex in) {
        return new Vertex(
                in.x * values[0] + in.y * values[1] + in.z * values[2],
                in.x * values[3] + in.y * values[4] + in.z * values[5],
                in.x * values[6] + in.y * values[7] + in.z * values[8]
        );
    }
}