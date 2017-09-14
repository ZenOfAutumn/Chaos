package com.zen.autumn.learn.base.innerclass.AnonymousInnerClass;

public class AnonymousInner {

	interface Content{ void foo();}
	
	public Content getContent(){
		return new Content(){
			@Override
			public void foo() {				
				//some thing
			}
		};
	}	
	
	
	
	abstract class Base{		
		protected int i;					
		abstract void foo();
	}
	
	public Base getBase(final int j) {
		return new Base() {
			{
			
				this.i = j + 10;
			}

			void foo() {
				
				System.out.println(i);
				System.out.println(j);
			}
		};
	}
	
	
	
	
	static class Param{
		
		private String s;
		
		private int j;

		public String getS() {
			return s;
		}

		public void setS(String s) {
			this.s = s;
		}

		public int getJ() {
			return j;
		}

		public void setJ(int j) {
			this.j = j;
		}
		
		
	}
	
	
	interface ParamProcess{
		
		void foo();
		
		default void bar(){
			System.out.println("");
		}
	}
	
	
	public ParamProcess getPramProcess(Param p){		
		
			return new ParamProcess() {	
				{
					
				}
				@Override
				public void foo() {
					p.setJ(20);				
				}
			};
	}
	
	interface Destination{}
		
	public Destination
	  destination(String dest, float price) {
	    return new Destination() {
	      private int cost;
	      // Instance initialization for each object:
	      {
	        cost = Math.round(price);
	        if(cost > 100)
	          System.out.println("Over budget!");
	      }
	      private String label = dest;
	      public String readLabel() { return label; }
	    };
	  }	
	  public static void main(String[] args) {
	  
	    Destination d = new AnonymousInner().destination("Tasmania", 101.395F);
	  }
	
	
	
	
	
	
}
