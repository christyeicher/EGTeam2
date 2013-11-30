package cafitnessclub.view.com;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import cafitnessclub.model.POJO.com.ClassObject;
import cafitnessclub.model.POJO.com.Member;
import cafitnessclub.model.com.Classes;
import cafitnessclub.model.com.Members;

class RosterTableModel extends AbstractTableModel {
	ArrayList<Member> members = null;
	
	public RosterTableModel(int classID){
		try {
			members = Members.getClassRoster(classID);
			System.out.println(members.toString());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}		
	}
	
	
	
	@Override
	public String getColumnName(int index)	{
		switch (index) {
        case 0:  return "ID";              
        case 1:  return "Name";                 
        case 2:  return "Email";                                
        default: return "null Value";                 
		}
	}
	
	@Override
	public int getRowCount() {
		return this.members.size();
	}
	
	@Override
	public int getColumnCount() {
		return 3;
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Member row = this.members.get(rowIndex);
		switch (columnIndex) {
        case 0:  return row.getMemberID();              
        case 1:  return row.getName();                 
        case 2:  return row.getEmail();                 
                    
        default: return "null Value";
                 
		}
	}	
	
 }
