package cafitnessclub.view.com;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import cafitnessclub.model.POJO.com.ClassObject;
import cafitnessclub.model.com.Classes;

class MyTableModel extends AbstractTableModel {
	ArrayList<ClassObject> classes = null;
	
	public MyTableModel(){
		try {
			classes = Classes.getClasses();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}		
	}
	
	public void resetClasses(int value){
		if (value == 1)
			try {
				classes = Classes.getClassesByInstructor();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		else if (value == 2)
			try {
				classes = Classes.getClassesByRoom();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	@Override
	public String getColumnName(int index)	{
		switch (index) {
        case 0:  return "ID";              
        case 1:  return "Name";                 
        case 2:  return "Start Time";                 
        case 3:  return "End Time";                 
        case 4:  return "Room";                 
        case 5:  return "Instructor";                 
        default: return "null Value";                 
		}
	}
	
	@Override
	public int getRowCount() {
		return this.classes.size();
	}
	
	@Override
	public int getColumnCount() {
		return 6;
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		ClassObject row = this.classes.get(rowIndex);
		switch (columnIndex) {
        case 0:  return row.getClassID();              
        case 1:  return row.getName();                 
        case 2:  return row.getStartTime().toString();                 
        case 3:  return row.getEndTime().toString();                 
        case 4:  return row.getRoom().getRoomName();                 
        case 5:  return row.getInstructor().getName();                 
        default: return "null Value";
                 
		}
	}	
	
 }
