package com.tiy.practice;


import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Day7Runner {
	File bankFile;
	static Bank bank;
	LocalDateTime localDateTime = LocalDateTime.now();
	Day7Runner runner;


	HashMap<String,ArrayList<BankAccount>> hashAccount= new HashMap<>();
	public static void main(String[] args) {

		int myIndex = 0;








		LocalDateTime localDateTime = LocalDateTime.now();
		DateTimeFormatter localFormat = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
		Day7Runner day = new Day7Runner();

		 bank = new Bank();


//		bank.addBankAccount("Thomas","Savings",100.00,localDateTime);

//    	bank.printInfo();
		String custName;


		System.out.println("Whats your name");
		Scanner scanner = new Scanner(System.in);
		custName = scanner.nextLine();
		boolean counter = true;
		int accountIndex = 0;



		File bankfile = new File("bank.txt");
		if (bankfile.exists()){

			readBank();
		}


		while (counter) {

			System.out.println("C = Checking");
			System.out.println("S = Saving");
			String type = scanner.nextLine();

			System.out.println("How much money you want to add");
			String money = scanner.nextLine();
			double myMoney = Double.parseDouble(money);


			if (type.equalsIgnoreCase("C")) {
				type = "Checking";
				bank.addBankAccount(custName, type, myMoney, localDateTime);
			} else if (type.equalsIgnoreCase("S")) {
				type = "Savings";
				bank.addBankAccount(custName, type, myMoney, localDateTime);

			}


			day.hashAccount.put(custName, bank.getListAccounts());

			saveName(bank);


			transActionWithAccount();
			bank.printInfo();
			for (BankAccount b : bank.getListAccounts()
					) {
				b.printInfo();
				System.out.println();

			}
			System.out.println("Do you want to create another account?");
			System.out.println("Enter Y/N");
			String loopQuestion = scanner.nextLine();
			if (loopQuestion.equalsIgnoreCase("Y")){
					counter = true;
			}else {
				counter = false;
			}
		}



	}

	private static void transActionWithAccount() {
		boolean stayHere = true;
		while (stayHere) {
			System.out.println();
			System.out.println();


			System.out.println("What would you like to do");
			System.out.println("d = Deposit");
			System.out.println("w = Withdraw");
			System.out.println("p = Print account info");
			System.out.println("b = Print bank info");
			System.out.println("e = Exit");

			int numThreadsStarted =0;

			while (true) {
				System.out.println("Number of threads started = " + numThreadsStarted);
				SampleThread localThread = new SampleThread();
				Thread newThread = new Thread(localThread);
				newThread.start();
//            localThread.run();
				numThreadsStarted++;
				if (numThreadsStarted > 3) {
					break;
				}
			}

			Scanner scanner = new Scanner(System.in);
			String transaction = scanner.nextLine();

			System.out.println("");


			switch (transaction) {
				case "d":

					System.out.println("How much do you want to deposit");
					String depositString = scanner.nextLine();
					double depositMoney = Double.parseDouble(depositString);


					bank.getListAccounts().get(0).deposit(depositMoney);

					break;
				case "w":
					System.out.println("How much do you want to withdraw");
					String dollars = scanner.nextLine();
					double withDrawMoney = Double.parseDouble(dollars);
					bank.getListAccounts().get(0).withdraw(withDrawMoney);
					break;

				case "p":
					bank.getListAccounts().get(0).printInfo();
					break;

				case "b":
					bank.printInfo();
					break;
				case "e":
					stayHere = false;
					break;
				default:
					System.out.println("You enter in the wrong value");
			}
		}
	}

	public static void saveName(Bank bank) {
		try {
			int myIndex = 0;
			File bankFile = new File("bank.txt");
			FileWriter bankWriter = new FileWriter(bankFile);
			bankWriter.write("Customer Name= "  +bank.listAccounts.get(myIndex).getName()+ "\n");
			bankWriter.write("Current Amount= " + bank.listAccounts.get(myIndex).getCurrentAmount() + "\n");
			bankWriter.write("Bank Type= " + bank.listAccounts.get(myIndex).getBankType() + "\n");
			bankWriter.close();
		} catch (Exception exception) {
			System.out.println("Exception while writing to file ...");
		}
	}

	public static Bank readBank() {
		try {
			File bankfile = new File("bank.txt");
			Scanner fileScanner = new Scanner(bankfile);
			String custName = null;
			String bankBalanceStr = null;
			String bankType = null;
			while (fileScanner.hasNext()) {
				String currentLine = fileScanner.nextLine();
				if (currentLine.startsWith("Customer Name")) {
					custName = currentLine.split("=")[1];
				}
				if (currentLine.startsWith("Current Amount")) {
					bankBalanceStr = currentLine.split("=")[1];
				}
				if (currentLine.startsWith("Bank Type")){
					bankType = currentLine.split("=")[1];
				}
			}
			System.out.println("Customer Name is " + custName);
			System.out.println("Balance is " + bankBalanceStr);
			System.out.println("Bank Type is " + bankType);
			double changeToMoney = Double.parseDouble(bankBalanceStr);
			bank.addBankAccount(custName, bankType, changeToMoney, new Day7Runner().localDateTime);


			System.out.println("Do you want to make changes to this account? Y/N");
			Scanner scanner = new Scanner(System.in);
			String yesOrNo = scanner.nextLine();
			if (yesOrNo.equalsIgnoreCase("Y")) {
				transActionWithAccount();
			}


			System.out.println();
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return null;
	}





}