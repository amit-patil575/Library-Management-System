package com.dollop.lms.bean;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

	Scanner sc=new Scanner(System.in);
        public Validation() {
		super();
	    }

		public String capToSmall(String name) {
        	name=name.toLowerCase();
        	return name;
        }
		
		int c=0;
		int a=0;
		public String confirmPassword() {
			System.out.println("Enter Strong Password");
			String pass = sc.nextLine();
			Boolean stp=strongPassword(pass);
			if(stp==true) {
				System.out.println("Confirm your Password");
				String ConPass = sc.nextLine();
	
				if (pass.equals(ConPass)) {
					return pass;
				} 
				else {
					System.out.println("-- Wrong Confirm Password --");
					  if(c==3) {
						  c=0;
						  return "";
					  }
					  c++;
					return confirmPassword();
					  
				}
			}
			else {
				System.out.println("--Please Enter Strong Password--");
				  if(a==3) {
					  a=0;
					  return "";
				  }
				a++;
			   return confirmPassword();
			}

		}
		
		public Boolean strongPassword(String pass) {
			/*
			 * // Pattern pattern=Pattern.compile(
			 * "(?=.*?[A-Z])(?=.*?[a-z])(?!.*\s)(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{6,20}$");
			 * Matcher macher=pattern.matcher(pass); if(macher.matches()) { return true; }
			 */
			return false;	
		}
		
		int f=1;
		public String empty(String value) {
			value=value.trim();
			    if(value.isBlank()){
				    System.out.println("--Field should not be blank--");
				    if(f<=3) {
				    	f++;
				    	System.out.println("--Please ReEnter above Information");
				    	return empty(sc.nextLine());
				    }
				    else {
				    	f=0;
				    	return "false";
				    }
				}
			    else {
			    	return value;
			    }
	    }
		
		public boolean checkSpace(String s)
		{
			char ch[]=s.toCharArray();
			for(int i=0;i<ch.length;i++) {
				if(ch[i]==' ') {
					return false;
				}
			}
			
			if(s.equals("")) {
				return false;
			}
			return true;
		}
		
		int c1=1;
		public String phoneNumber(String num) {
			Pattern pattern=Pattern.compile("[0-9]{10}");
			Matcher macher=pattern.matcher(num);
			if(macher.matches()) {
				return num;
			} 
			else {
				System.out.println("--Invalid Phone number Please try again--");
				if (c1 <= 3) {
					c1++;
					System.out.println("Please ReEnter your phone Number-->");
					return phoneNumber(sc.nextLine());
				} 
				else {
					c1=0;
					return "false";
				}
			}	
		}
		
		int c3=1;
		public String emailId(String Id) {
			Pattern pattern=Pattern.compile("[a-z0-9]+@[a-z]+[.com]+$");
			Matcher macher=pattern.matcher(Id);
			if(macher.matches()) {
				return Id;
			}
			else {
				System.out.println("--Invalid Email Id Please try again--");
				if (c3 <= 3) {
					c3++;
					System.out.println("Please ReEnter your Email ID-->");
					return emailId(sc.nextLine());
				} 
				else {
					c3=0;
					return "false";
				}
			}	
		}
      
		public Integer onlyNum(int i) {
			int val = 0;
			try {
				if(i!=0)
			     sc.nextLine();
				 val=sc.nextInt();
				System.out.println("this try block");
			}
			catch(Exception e) {
				f=1;
				System.out.println("Please enter only Number ");
			    return onlyNum(1);
			}
			return val;
		}
		
		public Boolean space(String value) {
			/*
			 * Pattern pattern=Pattern.compile(
			 * "(?=.*?[A-Z])(?=.*?[a-z])(?!.*\s)(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,20}$");
			 * Matcher macher=pattern.matcher(value); if(macher.matches()) { return true; }
			 */
			return false;	
		}

		public static String EncryptPass(String str) {
			String hashText = null;
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				md.reset();
				md.update(str.getBytes());
				byte[] digest = md.digest();
				BigInteger bigInt = new BigInteger(1, digest);
				hashText = bigInt.toString(16);
				while (hashText.length() > 32) {
					hashText = "0" + hashText;
				}
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			return hashText;
		}
}
