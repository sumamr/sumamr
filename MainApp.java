package suma1.com;




import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;




public class MainApp {

	public static void main(String[] args) {
		Configuration conn=new Configuration().configure().addAnnotatedClass(EmployeeHql.class);		        
		 ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(conn.getProperties()).buildServiceRegistry();
		 SessionFactory sf=conn.buildSessionFactory(reg);
		 Session sess=sf.openSession();
		 Transaction tx=sess.beginTransaction();
		 
		 
		 /*EmployeeHql e1=new EmployeeHql(1,"suma",123.00f,"Bangalore",100);
		 sess.save(e1);
		 EmployeeHql e2=new EmployeeHql(2,"Ram",1500.05f,"MPT",101);
		 sess.save(e2);
		 EmployeeHql e3=new EmployeeHql(3,"Rama",20500.04f,"Maddur",102);
		 sess.save(e3);*/
		 
		 
		 //to get the single record based on ID
	/*	EmployeeHql r=(EmployeeHql) sess.get(EmployeeHql.class, 1);
		System.out.println(r);*/
		 
		 
		 // to get the records manually
		/* EmployeeHql r=(EmployeeHql)sess.get(EmployeeHql.class, 1);
		 System.out.println("empid="+r.getEid()+" name="+r.getName()+" salary="+r.getSalary()+" address="+r.getAddress()+" deptno="+r.getDeptno());
		 */
		 
		 //Retrieve all the records and getting the record in table format instead in a single line
		Query q=sess.createQuery("from EmployeeHql");
		 //retrieve records based on name of the class
		 List l= q.list();
		 System.out.println(l);
		 
		 Iterator<EmployeeHql> it=l.iterator();
		 while(it.hasNext())
		 {
			 EmployeeHql r=it.next();
			 System.out.println("empid="+r.getEid()+" name="+r.getName()+" salary="+r.getSalary()+" address="+r.getAddress()+" deptno="+r.getDeptno());
			 
		 }
		   
		 
		 //to update the record 
		 
		 Query q1= sess.createQuery("update EmployeeHql set name=:n where eid=:i");
		 q1.setParameter("n","Zayba");
		 q1.setParameter("i", 1);
		 int i=q1.executeUpdate();
		 if(i>0)
		 {
			 System.out.println("Record is updated successfully");
		 }
		 else
		 {
			 System.out.println("Not updated");
		 }
		 
		 //to delete the record using HQL based on id
		 Query s=sess.createQuery("Delete from EmployeeHql where eid=:i");
		 s.setParameter("i", 2);
		 int z=s.executeUpdate();
		 if(z>0)
		 {
			 System.out.println("Record is deleted");
		 }
		 else
		 {
			 System.out.println("Not deleted");
		 }
		 
		 //using Aggreate functions in HQL
		 
		 Query z1=sess.createQuery("select sum(salary) from EmployeeHql");
		 List sl=z1.list();
		 System.out.println("Total Salary = "+sl.get(0));
		 tx.commit();
		 sess.close();
		 

	}

}
