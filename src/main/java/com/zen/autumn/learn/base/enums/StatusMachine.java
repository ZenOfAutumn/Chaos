package com.zen.autumn.learn.base.enums;

public enum StatusMachine {
	
	A{
		@Override
		void status(String condition) {
			if(condition.length()>1){
				status = B;
			}else{
				status = C;
			}
		}

		@Override
		void init() {
			status =A;
		}
	},B{
		@Override
		void status(String condition) {
			status = A;
		}

		@Override
		void init() {
			status = B;
			
		}
	},C{
		@Override
		void status(String condition) {
			status = B;
		}

		@Override
		void init() {
			status = C;
		}
	};
	
	private static StatusMachine status;
	
	public StatusMachine getStatus(){
		return status;
	}
	
	StatusMachine(){
		init();
	}
	
	abstract void status(String condition);
	
	abstract void init();
	
	public static void main(String[] args) {
		StatusMachine start = StatusMachine.A;
		
		System.out.println(start.getStatus());
		
		
		String condition = "xx";
		start.status(condition);
		
		
		
	}
		

}
