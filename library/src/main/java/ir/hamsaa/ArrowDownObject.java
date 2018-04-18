package ir.hamsaa;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;

public class ArrowDownObject {

    private final Paint p = new Paint();
    private final Paint ps = new Paint();
    private final Path t = new Path();
    private final Matrix m = new Matrix();
    protected ColorFilter cf = null;
    private float od;

    /**
     * IMPORTANT: Due to the static usage of this class this
     * method sets the tint color statically. So it is highly
     * recommended to call the clearColorTint method when you
     * have finished drawing.
     * <p>
     * Sets the color to use when drawing the SVG. This replaces
     * all parts of the drawable which are not completely
     * transparent with this color.
     */
    public void setColorTint(int color) {
        cf = new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_IN);
    }

    public void clearColorTint(int color) {
        cf = null;
    }

    public void draw(Canvas c, int w, int h) {
        draw(c, w, h, 0, 0);
    }

    public void draw(Canvas c, int w, int h, int dx, int dy) {
        float ow = 260f;
        float oh = 260f;

        od = (w / ow < h / oh) ? w / ow : h / oh;

        r();
        c.save();
        c.translate((w - od * ow)  + dx, (h - od * oh)  + dy);

        m.reset();
        m.setScale(od, od);

        c.save();
        ps.setColor(Color.argb(0, 0, 0, 0));
        ps.setStrokeCap(Paint.Cap.BUTT);
        ps.setStrokeJoin(Paint.Join.MITER);
        ps.setStrokeMiter(4.0f * od);
        c.scale(1.0f, 1.0f);
        c.save();
        p.setColor(Color.parseColor("#FFFFFF"));
        c.scale(1.0f, -1.0f);
        c.translate(0.0f, -448.0f * od);
        t.reset();
        t.moveTo(158.08f, 264.96f);
        t.lineTo(256.0f, 167.04f);
        t.lineTo(353.92f, 264.96f);
        t.lineTo(384.0f, 234.67f);
        t.lineTo(256.0f, 106.67f);
        t.lineTo(128.0f, 234.67f);
        t.lineTo(158.08f, 264.96f);

        t.transform(m);
        c.drawPath(t, p);
        c.drawPath(t, ps);
        c.restore();
        r(0, 1, 3, 2);
        p.setColor(Color.parseColor("#FFFFFF"));
        c.restore();
        r();

        c.restore();
    }

    private void r(Integer... o) {
        p.reset();
        ps.reset();
        if (cf != null) {
            p.setColorFilter(cf);
            ps.setColorFilter(cf);
        }
        p.setAntiAlias(true);
        ps.setAntiAlias(true);
        p.setStyle(Paint.Style.FILL);
        ps.setStyle(Paint.Style.STROKE);
        for (Integer i : o) {
            switch (i) {
                case 0:
                    ps.setColor(Color.argb(0, 0, 0, 0));
                    break;
                case 1:
                    ps.setStrokeCap(Paint.Cap.BUTT);
                    break;
                case 2:
                    ps.setStrokeMiter(4.0f * od);
                    break;
                case 3:
                    ps.setStrokeJoin(Paint.Join.MITER);
                    break;
            }
        }
    }
}
