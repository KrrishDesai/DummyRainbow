
package hibernateentitymappingunidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import p1.*;

public class HibernateEntityMappingUniDirectional 
{
    public static void main(String[] args)
    {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        System.out.println("Session Factory Created");
        
        Session ses = sf.openSession();
        System.out.println("Session Created");
        
        Transaction t = ses.beginTransaction();
        System.out.println("Transaction Completed");
        
        Point p1 = new Point(10, 20, 30);
        
        Segment s1 = new Segment(1, 2, 3, p1);
        
        ses.save(s1);  
        System.out.println("Object Saved");
        t.commit();
        Segment s = (Segment) ses.get(Segment.class, 1);
        
        System.out.println("S : " + s);
    }
    
}
