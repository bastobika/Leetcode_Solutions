package Easy;

import java.util.List;

/* You have a data structure of employee information, which includes the employee's unique id, their importance value, and their direct subordinates' id.
 * You are given an array of employees employees where:
 * 		1. employees[i].id is the ID of the ith employee.
 * 		2. employees[i].importance is the importance value of the ith employee.
 * 		3. employees[i].subordinates is a list of the IDs of the subordinates of the ith employee.
 * Given an integer id that represents the ID of an employee, return the total importance value of this employee and all their subordinates.
*/


public class LC690_EmployeeImportance {

	class Employee {
	    public int id;
	    public int importance;
	    public List<Integer> subordinates;
	};
	
	public int getImportance(List<Employee> employees, int id) {
        Employee emp = null;
        for(int i=0;i<employees.size();i++)
            if(employees.get(i).id == id){
                emp = employees.get(i);
                break;
            }
        int imp = emp.importance;
        for(int i=0;i<emp.subordinates.size();i++)
            imp += getImportance(employees,emp.subordinates.get(i));
        return imp;
    }
	
	public static void main(String[] args) {
		System.out.println("Employee importance");
	}

}
