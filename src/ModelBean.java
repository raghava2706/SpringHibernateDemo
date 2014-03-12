import mypack.Mytable;
import mypack.MytableDAO;


public class ModelBean implements ModelInterface
{
	MytableDAO dao;

	public ModelBean(MytableDAO dao) 
	{		
		this.dao = dao;
	}

	@Override
	public void display(int sno, String name, String location, String email) 
	{
		Mytable m = new Mytable();
		m.setSno(sno);
		m.setName(name);
		m.setLocation(location);
		m.setEmail(email);
		
		dao.save(m);
		
		System.out.printf("Serial Number = %d\nName = %s\nLocation = %s\nEmail = %s", sno, name, location, email);		
	}
	
	
	

}
