package p1;

import java.util.Iterator;

public class Point 
{
    private int pid;
    private int x;
    private int y;

    public Point() 
    {
      
    }

    public Point(int pid, int x, int y) {
        this.pid = pid;
        this.x = x;
        this.y = y;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" + "pid=" + pid + ", x=" + x + ", y=" + y + '}';
    }
    
    
}
