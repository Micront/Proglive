package arhangel.dim.lesson6;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

// Панель на которой можно рисовать
public class PaintPanel extends JPanel {

    private int width, height;
    private int gridStep;
    // Список фигур, которые нужно отрисовать
    private List<Rectangle2D> rectangles = new ArrayList<>();

    public PaintPanel(int width, int height, int gridStep) {
        setPreferredSize(new Dimension(width, height));
        this.width = width;
        this.height = height;
        this.gridStep = gridStep;
        // панель умеет реагировать на нажатие мыши
        // SampleMouseAdapter - самодельный класс, который описывает, что нужно делать при
        // нажатии кнопок мыши, в его конструктор я передаю ссылку на текущую панель,
        // чтобы обработчик мог взаимодействовать с панелью
        addMouseListener(new SampleMouseAdapter(this));
    }


    // метод, который рисует графические элементы на окне
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Сейчас везде используем Graphics2D (Graphics - оставлен для обратной совместимости)
        Graphics2D g2d = (Graphics2D) g;

        // рисуем все фигуры из списка
        g2d.setColor(Color.RED);
        for (Rectangle2D r : rectangles) {
            g2d.fill(r);
        }

        // рисуем сетку
        g2d.setColor(Color.GRAY);

        for (int i = 0; i < width; i += gridStep) {
            g2d.drawLine(i, 0, i, height - 1);
        }
        for (int i = 0; i < height; i += gridStep) {
            g2d.drawLine(0, i, width - 1, i);
        }

    }

    // по координатам мыши определяем в какой клетке находится указатель мыши
    // и добавляем фигуру квадрат соответствующего размера в список
    //
    public void markCell(int x, int y, Color color) {
        System.out.println("Mark cell: " + x + "," + y);
        if (x >= 0 && x < width && y >=0 && y < height) {
            // в каую клетку ткнули (нам известны только координаты)
            int cellX = (x / gridStep) * gridStep;
            int cellY = (y / gridStep) * gridStep;
            rectangles.add(new Rectangle2D.Double(cellX, cellY, gridStep, gridStep));
            // этот метод автоматически вызовет перерисовку панели
            repaint();
        }
    }


}
