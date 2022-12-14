package commissionEmployee;

public class CommissionEmployee  extends Object{

	private String firstName = "";
	private String lastName = "";
	private String socialSecurityNumber = ""; 
	private double grossSales; // vendas brutas semanais
	private double commissionRate; // percentagem da comiss?o
	
	public CommissionEmployee(String socialSecurityNumber, String lastName, String firstName, 
							  double grossSales, double commissionRate) throws IllegalAccessException {
		
		if( grossSales < 0.0 )throw new IllegalAccessException("Gross sales must be >= 0.0");
		if( commissionRate <= 0.0 || commissionRate >= 1.0)throw new IllegalAccessException("Commission rate must be > 0.0 and < 1.0");
				
		this.firstName = firstName;
		this.lastName = lastName;
		this.grossSales = grossSales;
		this.commissionRate = commissionRate;
		this.socialSecurityNumber = socialSecurityNumber;		
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	
	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}

	public double getGrossSales() {
		return grossSales;
	}

	public void setGrossSales(double grossSales) throws IllegalAccessException {
		if( grossSales < 0.0 ) throw new IllegalAccessException("Gross sales must be >= 0.0");
		this.grossSales = grossSales;
	}

	public double getCommissionRate() {
		return commissionRate;
	}

	public void setCommissionRate(double commissionRate) {		
		if (commissionRate <= 0.0 || commissionRate >= 1.0)
			throw new IllegalArgumentException(	"Commission rate must be > 0.0 and < 1.0");		
		this.commissionRate = commissionRate;
	}
	
	
	@Override
	public String toString() {
		return "CommissionEmployee [firstName=" + firstName + ", lastName=" + lastName + ", socialSecurityNumber="
				+ socialSecurityNumber + ", grossSales=" + grossSales + ", commissionRate=" + commissionRate + "]";
	}

	// Calculo dos lucros
	public double earnings() {
		return commissionRate * grossSales;
	}
	
	

	
	
}
