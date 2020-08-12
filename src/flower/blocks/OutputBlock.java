package flower.blocks;

import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.GeneralPath;

import static flower.DrawPanel.TILESIZE;

public class OutputBlock extends AbstractBlock {

    public OutputBlock(Point offset) {
        super();
        type = OUTPUT_BLOCK;
        area = new Rectangle(offset.x, offset.y, 9, 5);
        code = "";
    }

    public OutputBlock() {
        super();
        type = OUTPUT_BLOCK;
        area = new Rectangle();
        code = "";
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        super.draw(graphics2D);
        FontMetrics fm = graphics2D.getFontMetrics();
        graphics2D.drawString(code, (area.x * TILESIZE) + (area.width * TILESIZE - fm.stringWidth(code)) / 2, ((area.y-1) * TILESIZE) + (area.height * TILESIZE + fm.getAscent()) / 2);
    }

    @Override
    public Shape getShape() {
        GeneralPath shape = new GeneralPath(GeneralPath.WIND_EVEN_ODD);
        shape.moveTo(area.x * TILESIZE, area.y * TILESIZE);
        shape.lineTo(area.x * TILESIZE, (area.y + area.height) * TILESIZE);
        shape.curveTo((area.x + area.width * 0.6f) * TILESIZE, (area.y + area.height*1.2f) * TILESIZE, (area.x + area.width * 0.3f) * TILESIZE, (area.y + area.height * 0.5f) * TILESIZE, (area.x + area.width) * TILESIZE, (area.y + area.height * 0.7f) * TILESIZE);
        shape.lineTo((area.x + area.width) * TILESIZE, area.y * TILESIZE);
        shape.closePath();
        return shape;
    }

    @Override
    public Point[] getInputPins() {
        Point[] ret = new Point[1];
        ret[0] = new Point(area.x + area.width / 2, area.y - 1);
        return ret;
    }

    @Override
    public Point[] getOutputPins() {
        Point[] ret = new Point[1];
        ret[0] = new Point(area.x + area.width / 2, area.y + area.height);
        return ret;
    }

}
