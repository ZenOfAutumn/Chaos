package com.zen.autumn.learn.base.annotation;


@DBTable(name = "Member")
public class Member {
	
	@SQLString(30)
	private String firstName;
	

	@SQLString(50)
	private String lastName;
	
	@SQLInteger
	private Integer age;

	@SQLString(value = 30,constraints = @Constraints(primaryKey = true))
	private String handle;
	
	static int memberCount;

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Integer getAge() {
		return age;
	}

	public String getHandle() {
		return handle;
	}

	public static int getMemberCount() {
		return memberCount;
	}
	
	
}
