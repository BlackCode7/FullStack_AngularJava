package commissionEmployee_execusao;

import commissionEmployee.CommissionEmployee;

public class CommissionEmployee_Execusao {

	public static void main(String[] args) throws IllegalAccessException {

		CommissionEmployee employee = new CommissionEmployee("Anderson",
											"Jones", "55-55-5555", 10000, 0.08);
		
		System.out.println("Employee information obtained by get methods:");
		System.out.printf( "%n%s %s%n", "First name is", employee.getFirstName());
		System.out.printf("%s %s%n", "Last name is", employee.getLastName());
		
		System.out.printf("%s %s%n", "Social security number is", employee.getSocialSecurityNumber());
		System.out.printf("%s %.2f%n", "Gross sales is", employee.getGrossSales());
		System.out.printf("%s %.2f%n", "Commission rate is", employee.getCommissionRate());

	}

}
