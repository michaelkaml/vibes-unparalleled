/*
The Swag Trio - Max Schneider, Jason Yang, Michael Kamela
APCS pd07
HW20 -- External Audit
2021-10-19
DISCO:
The withdraw method doesn't work if you withdraw the account's exact balance
QCC:
*/
public class Teller {
	public static void main(String[] args) {
		BankAccount Hackerman = new BankAccount();
		Hackerman.setBalance(100);
		Hackerman.withdraw(100);
    System.out.println("Mistake in Code - user should be able to withdraw entire balance \n");
		System.out.println("General Tests:");
    
		BankAccount Hackerman2 = new BankAccount();
    Hackerman2.setName("Test Account");
		Hackerman2.setPasswd("StrongPassword");
    Hackerman2.setPin((short)9998);
    Hackerman2.setAcctNum(123456789);
		Hackerman2.setBalance(1000);
    Hackerman2.withdraw(100);
    Hackerman2.deposit(200);

		System.out.println("Functional Responses: "); System.out.println(Hackerman2.toString());
		System.out.println("Should say:" + "\n" + "Account Name: Test Account" + "\n" + "Password: StrongPassword" + "\n" + "Pin: 9999" + "\n" + "Account Number: 123456789" + "\n" + "Balance: 1100.0" + "\n");

		System.out.println("Error Messages:");

		Hackerman2.setAcctNum(4);
    Hackerman2.setPin((short)4);
    Hackerman2.withdraw(1000000);
		System.out.println(Hackerman2.authenticate(123456789, "WeakPassword"));
		System.out.println(Hackerman2.authenticate(4, "StrongPassword"));
		System.out.println("Should give 3 unique error messages and then two false values");
	}
}
