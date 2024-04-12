import java.util.ArrayList;

abstract class Employee{
    private String name;
    private int id;

    public Employee(String name, int id){
        this.name = name;
        this.id = id;

    }

    //code's security is enhancing here as we are not getting direct access to user for seeing name and id of employee but user can call the getter and setter methods to see it
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }

    public abstract double calculateSalary();

    //overriding java's toString method for our requirement
    @Override
    public String toString(){
        return "Employee [name="+name+", id="+id+", salary="+calculateSalary()+"]";
    }

}

//Full-time employee class
class FullTimeEmployee extends Employee{
    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary){
        super(name, id);
        this.monthlySalary = monthlySalary;
    }


    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}


//PartTime Employee class

class partTimeEmployee extends Employee{
    private double hourlyRate;
    private int hoursWorked;

    public partTimeEmployee(String name, int id, double hourlyRate, int hoursWorked){
        super(name, id);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }


    @Override
    public double calculateSalary() {

        return hoursWorked * hourlyRate;
    }
}

//Payroll system
class PayRollSystem{
    private ArrayList<Employee> emplyeeList;


    public PayRollSystem() {
        emplyeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        emplyeeList.add(employee);
    }

    public void removeEmployee(int id){
        Employee employeeToRemove = null;
        for(Employee employee: emplyeeList){
            if(employee.getId() == id) {
                employeeToRemove = employee;
                break;
            }
        }
        if(employeeToRemove != null){
            emplyeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployee(){
        for(Employee employee: emplyeeList){
            System.out.println(employee);
        }
    }
}


public class Main {
    public static void main(String[] args) {
        PayRollSystem payrollSystem = new PayRollSystem();
        FullTimeEmployee emp1 = new FullTimeEmployee("Vikas", 01, 70000.0);
        partTimeEmployee emp2 = new partTimeEmployee("Trump", 02, 400, 4);

        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);
        System.out.println("-----INITIAL EMPLOYEE DETAILS-----");
        payrollSystem.displayEmployee();
        System.out.println("-----REMOVE EMPLOYEE");
        payrollSystem.removeEmployee(02);
        System.out.println("-----REMAINING EMPLOYEE DETAILS-----");
        payrollSystem.displayEmployee();

        }
    }

