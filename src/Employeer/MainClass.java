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
		System.out.println(sap.PrintSkill());
		
		//LSP example
		Geekseat gs = new MainClass(). new Geekseat(); 
		gs.printMember();
		
		//ISP Example
		Senior senior = new MainClass(). new Senior();
		System.out.println("As a senior someone in geekseat should be able to " + senior.Code() + " and " + senior.Lead());
		
		//Dependency Inversion
		
		EmployeeAction ea = new MainClass(). new EmployeeAction();
		ea.doAction(new MainClass(). new Promotion());
		
		//Singleton pattern
		DBConnection.Connect();
		
		//Builder Pattern
		BuilderDirector builder = new MainClass(). new BuilderDirector();
		builder.createEmployee(new MainClass(). new RegularEmployee());
		builder.createEmployee(new MainClass(). new ExperienceEmployee());
		
	}
	
	//SRP
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
	
	
	//OO
	public interface IRole{
		String PrintSkill();
	}
	public class AnalystProgrammer implements IRole{

		public String PrintSkill() {
			return "Java, C#";
		}
		
	}
	public class SpecialAnalystProgrammer implements IRole {
		public String PrintSkill() {
			return "Java, C#, DevOps";
		}
	}
	//if there is a new role, it can add class to extend IRole implementation but IRole close to modification due to only have method PrintSkill()
	
	
	
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
	
	
	//singleton
	public static class DBConnection {

		   private static DBConnection dbConnect = null;
		   private DBConnection() {
		      // Exists only to defeat instantiation.
		   }

		   public static DBConnection getInstance() {
		      if(dbConnect == null) {
		    	  dbConnect = new DBConnection();
		      }
		      return dbConnect;
		   }
		   public static void Connect() {
			   System.out.println("You have been connected");
		   }
		}
	
	//builder pattern
	
	List<String> skills = new ArrayList<String>();

	public interface EmployeeBuilder{
		void SkillBuilder();
		void LeaderBuilder();
		void GetSkill();
	}
	public class RegularEmployee implements EmployeeBuilder {
		
		public void SkillBuilder(){
			skills.add("Skillfull");
		}
		public void LeaderBuilder() {
			skills.add("can't lead");
		}
		public void GetSkill(){
			for (String skill : skills){
				System.out.println(skill);
			}
		}
	}
	public class ExperienceEmployee implements EmployeeBuilder {
		
		public void SkillBuilder(){
			skills.add("Skillfull");
		}
		public void LeaderBuilder() {
			skills.add("natural leader");
		}
		public void GetSkill(){
			for (String skill : skills){
				System.out.println(skill);
			}
		}
	}
	public class BuilderDirector {
		  public void createEmployee(EmployeeBuilder builder) {
		    builder.SkillBuilder();
		    builder.LeaderBuilder();
		    builder.GetSkill();
		  }
	}
}

