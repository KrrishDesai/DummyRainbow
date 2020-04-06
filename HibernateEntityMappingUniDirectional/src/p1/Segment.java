
package p1;

public class Segment 
{
    private int sid;
    private int x1;
    private int y1;
    private Point e2;

    public Segment() 
    {
        
    }

    public Segment(int sid, int x1, int y1, Point e2) 
    {
        this.sid = sid;
        this.x1 = x1;
        this.y1 = y1;
        this.e2 = e2;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public Point getE2() {
        return e2;
    }

    public void setE2(Point e2) {
        this.e2 = e2;
    }

    @Override
    public String toString()
    {
        return "Segment{" + "sid=" + sid + ", x1=" + x1 + ", y1=" + y1 + ", e2=" + e2 + '}';
    }
    
    
}
