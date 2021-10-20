/*
The Swag Trio - Max Schneider, Jason Yang, Michael Kamela
APCS pd07
HW20 -- External Audit
2021-10-19
DISCO:
The withdraw method doesn't work if you withdraw the account's exact balance because the targeted trio used "if (withdrawAmount >= balance)" rather than "if (withdrawAmount > balance)"
Other than that, their code seems to work fine. Their account number and pin are restricted to their respective ranges as defined by the assignment
HOWEVER trying to use decimal values (cents) when withdrawing and/or depositing leads to wacky long decimals, in this case withdrawing 100.05 from 1000.10 and then depositing 200 yields 1100.0500000000002 when it should result in a balance of 1100.05. I remember from the summer hw that this has something to do with the way that Java does math, so it might not actually be the fault of the trio being audited.
QCC:
How would one make the password functional? In other words, how could we make BankAccount.java ask for the user's password and account number everytime they try to deposit or withdraw from "their" account?
Is it within our current abilities to add this functionality to BankAccount.java?
A good Q: What operations are possible from BankAccount’s main() method but not Teller’s?
A (hopefully) good A: BankAccount's main() method has the ability to change attributes for BankAccount cats, wheras Teller cannot because BankAccount cats is only defined within the main() method.
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
		Hackerman2.setBalance(1000.10);
    Hackerman2.withdraw(100.05);
    Hackerman2.deposit(200);

		System.out.println("Functional Responses: "); System.out.println(Hackerman2.toString());
		System.out.println("Should say:" + "\n" + "Account Name: Test Account" + "\n" + "Password: StrongPassword" + "\n" + "Pin: 9998" + "\n" + "Account Number: 123456789" + "\n" + "Balance: 1100.05" + "\n");

		System.out.println("Error Messages:");

		Hackerman2.setAcctNum(4);
    Hackerman2.setPin((short)4);
    Hackerman2.withdraw(1000000);
		System.out.println(Hackerman2.authenticate(123456789, "WeakPassword"));
		System.out.println(Hackerman2.authenticate(4, "StrongPassword"));
		System.out.println("Should give 3 unique error messages and then two false values");
	}
}
