/*
The Swag Trio - Max Schneider, Jason Yang, Michael Kamela
APCS pd07
CW20 -- Breaking the Bank
2021-10-19
DISCO:
The withdraw method doesn't work if you withdraw the account's exact balance
QCC:
*/
public class Teller {
	public static void main(String[] args) {
		System.out.println("Broken Code - Should Allow us to withdraw this amount");
		BankAccount Hackerman = new BankAccount();
		Hackerman.setBalance(100);
		Hackerman.withdraw(100);
		System.out.println("General Tests:");
		BankAccount ba = new BankAccount(); ba.setName("Test Account");
		ba.setPasswd("StrongPassword"); ba.setPin((short)9998); ba.setAcctNum(123456789);
		ba.setBalance(1000); ba.withdraw(100); ba.deposit(200);

		System.out.println("Functional Responses: "); System.out.println(ba.toString());
		System.out.println("Should say: 'Account Name: Test Account, Password: StrongPassword, Pin: 9999, Account Number: 123456789, Balance: 1100.0'");

		System.out.println("Error Messages:");

		ba.setAcctNum(4); ba.setPin((short)4); ba.withdraw(1000000);
		System.out.println(ba.authenticate(123456789, "WeakPassword"));
		System.out.println(ba.authenticate(4, "StrongPassword"));
		System.out.println("Should give 3 unique error messages and then two false values");
	}
}
