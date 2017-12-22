package Employeer;

import java.util.*;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//SRP example
		IPosition pos = new Position();
		System.out.println("The salary of position " + pos.GetPosition() + " in Geekseat is " + pos.GetSalary());
		
		//LSP example
		SpecialAnalystProgrammer sap = new MainClass(). new SpecialAnalystProgrammer();
		System.out.println(sap.MobileDevOps());
		
		//LSP example
		Geekseat gs = new MainClass(). new Geekseat(); 
		gs.printMember();
		
		//ISP Example
		Senior senior = new MainClass(). new Senior();
		System.out.println("As a senior someone in geekseat should be able to " + senior.Code() + " and " + senior.Lead());
		
		//Dependency Inversion
		
		EmployeeAction ea = new MainClass(). new EmployeeAction();
		ea.doAction(new MainClass(). new Promotion());
	}
	
	
	public interface IPosition{
		String GetPosition();
		int GetSalary();
	}
	public static class Position implements IPosition{
		public String GetPosition() {
			return "Analyst Programmer";
		}
		public int GetSalary() {
			return 10000000;
		}
	}
	
	public interface IEmployee{
		String GetName();
		String Id();
	}
	public interface ISkill{
		boolean Java();
		boolean CSharp();
		boolean MobileDevOps();
	}
	public class AnalystProgrammer implements IEmployee,ISkill{

		public boolean Java() {
			return true;
		}

		public boolean CSharp() {
			return true;
		}

		public boolean MobileDevOps() {
			return false;
		}

		public String GetName() {
			return "Bagas";
		}

		public String Id() {
			return "QWEASD1";
		}
		
	}
	public class SpecialAnalystProgrammer extends AnalystProgrammer {
		@Override
		public boolean MobileDevOps() {
			return true;
		}
	}
	
	
	//LSP
	public interface IMember {
		int Salary();
	}
	public class Programmer implements IMember{
		public int Salary(){
			return 5000000;
		}
	}
	public class AP implements IMember{
		public int Salary(){
			return 10000000;
		}
	}

	public class Geekseat{
		private List<IMember> member = new ArrayList<IMember>();
		public Geekseat(){
			addMember(new Programmer());
			addMember(new AP());
		}
		
		public void addMember(IMember newMember) {
			member.add(newMember);
		}
		public void printMember() {
			for(IMember imember: member){
				System.out.println("Salary is " + imember.Salary());
			}
		}
	}
	
	
	//ISP
	public interface IWorker{
		public String Code();
	}
	public interface ILeader{
		public String Lead();
	}

	public class Regular implements IWorker{
		public String Code(){
			return "Code";
		}
	}
	public class Senior implements IWorker,ILeader{
		public String Code() {
			return "Code";
		}
		public String Lead() {
			return "Lead";
		}
	}
	
	public interface IAction{
		String Result();
	}
	public class Promotion implements IAction{
		public String Result() {
			return "Yeay I Got Promotion";
		}
	
	}
	public class EmployeeAction{
		public void doAction(IAction action) {
			System.out.println(action.Result());
		}
	}
}

