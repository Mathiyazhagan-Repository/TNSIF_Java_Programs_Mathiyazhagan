//Program to define AdminService class 
package services.pgm;

import java.util.ArrayList;
import java.util.List;

import entities.pgm.Admin;

public class AdminService {

	
	    private List<Admin> adminList = new ArrayList<>();

	    public void addAdmin(Admin admin) {
	        adminList.add(admin);
	    }

	    public List<Admin> getAdmins() {
	        return adminList;
	    }
	}
