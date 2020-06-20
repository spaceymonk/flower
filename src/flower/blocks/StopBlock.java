package flower.blocks;

import java.awt.*;

import static flower.DrawPanel.PADDING;
import static flower.DrawPanel.TILESIZE;

public class StopBlock extends AbstractBlock {

    private Rectangle area;
    private final String code = "STOP";

    public StopBlock(Point offset) {
        area = new Rectangle(offset, new Dimension(5, 2));
    }

    public StopBlock(int x, int y) {
        area = new Rectangle(x, y, 5, 2);
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        FontMetrics fm = graphics2D.getFontMetrics();
        graphics2D.setColor(Color.CYAN);
        graphics2D.fillRoundRect(area.x * TILESIZE, area.y * TILESIZE, area.width * TILESIZE, area.height * TILESIZE, TILESIZE * 2, TILESIZE * 2);
        if (isSelected()) graphics2D.setColor(Color.BLUE);
        else if (isHovered()) graphics2D.setColor(Color.YELLOW);
        else if (isBreakpoint()) graphics2D.setColor(Color.RED);
        else graphics2D.setColor(Color.BLACK);
        graphics2D.drawRoundRect(area.x * TILESIZE, area.y * TILESIZE, area.width * TILESIZE, area.height * TILESIZE, TILESIZE * 2, TILESIZE * 2);
        graphics2D.drawString(code, (area.x * TILESIZE) + (area.width * TILESIZE - fm.stringWidth(code)) / 2, (area.y * TILESIZE) + (area.height * TILESIZE + fm.getAscent()) / 2);
        graphics2D.setColor(Color.ORANGE);
        graphics2D.fillOval((area.x + 2) * TILESIZE + PADDING / 2, (area.y - 1) * TILESIZE + PADDING / 2, PADDING, PADDING);
    }

    @Override
    public void showDialog() {
        System.out.println("HEYY");
    }

    @Override
    public void moveTo(Point delta) {
        area.x += delta.x;
        area.y += delta.y;
    }

    @Override
    public Rectangle getInnerBounds() {
        return area;
    }

    @Override
    public Rectangle getOuterBounds() {
        return area;
    }

    @Override
    public Point[] getInputPins() {
        Point[] ret = new Point[1];
        ret[0] = new Point(area.x + 2, area.y - 1);
        return ret;
    }

    @Override
    public Point[] getOutputPins() {
        return null;
    }

    @Override
    public String getCode() {
        return code;
    }
}