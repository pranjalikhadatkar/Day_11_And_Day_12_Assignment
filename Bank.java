package Com.Deckofcards;
import java.util.Scanner;

public class Bank {
	   private String accno;
	    private String name;
	    private long balance;
  Scanner sc = new Scanner(System.in);
  
	   public void openAccount() {
	        System.out.print("Enter Account No: ");
	        accno = sc.next();
	        System.out.print("Enter Name: ");
	        name = sc.next();
	        System.out.print("Enter Balance: ");
	        balance = sc.nextLong();
	    }

	   public void showAccount() {
	        System.out.println(accno + "," + name + ","+ balance);
	    }

	   public void deposit() {
	        long amt;
	        System.out.println("Enter Amount You Want to Deposit : ");
	        amt = sc.nextLong();
	        balance = balance + amt;
	    }


	   public void withdrawal() {
	        long amt;
	        System.out.println("Enter Amount You Want to withdraw : ");
	        amt = sc.nextLong();
	        if (balance >= amt) {
	            balance = balance - amt;
	        } else {
	            System.out.println("Less Balance..Transaction Failed..");
	        }
	    }

	    boolean search(String acn) {
	        if (accno.equals(acn)) {
	            showAccount();
	            return (true);
	        }else {
	        return (false);
	    }
	}

	public class BankAmountWithdraw {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        System.out.print("How Many Customer You Want to Input : ");
	        int n = sc.nextInt();
	        Bank[] C = new Bank[n];
	        for (int i = 0; i < C.length; i++) {
	            C[i] = new Bank();
	            C[i].openAccount();
	        }


	        int ch;
	        do {
	            System.out.println("Main Menu\n1. Display Info\n 2. Search By Account\n 3. Deposit\n 4. Withdrawal\n 5.E xit ");
	            System.out.println("Enter Choice :");
	            ch = sc.nextInt();
	            switch (ch) {
	                case 1:
	                    for (Bank bank : C) {
	                        bank.showAccount();
	                    }
	                    break;

	                case 2:
	                    System.out.print("Enter Account No. You Want to Search...: ");
	                    String acn = sc.next();
	                    boolean found = false;
	                    for (Bank bank : C) {
	                        found = bank.search(acn);
	                        if (found) {
	                            break;
	                        }
	                    }
	                    if (!found) {
	                        System.out.println("Search Failed..Account Not Exist..");
	                    }
	                    break;

	                case 3:
	                    System.out.print("Enter Account No : ");
	                    acn = sc.next();
	                    found = false;
	                    for (Bank bank : C) {
	                        found = bank.search(acn);
	                        if (found) {
	                            bank.deposit();
	                            break;
	                        }
	                    }
	                    if (!found) {
	                        System.out.println("Search Failed..Account Not Exist..");
	                    }
	                    break;

	                case 4:
	                    System.out.print("Enter Account No : ");
	                    acn = sc.next();
	                    found = false;
	                    for (Bank bank : C) {
	                        found = bank.search(acn);
	                        if (found) {
	                            bank.withdrawal();
	                            break;
	                        }
	                    }
	                    if (!found) {
	                        System.out.println("Search Failed..Account Not Exist..");
	                    }
	                    break;

	                default:
	                    System.out.println("Thank you..");
	                    break;
	            }
	        }
	        while (ch != 5);
	    }
	}		
	}



