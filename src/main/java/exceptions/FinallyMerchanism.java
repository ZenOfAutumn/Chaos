package exceptions;

public class FinallyMerchanism {

	public int inc(){
		int x;
		try{
			x = 1;
			return x;
		}catch(Exception e){
			x = 2;
			return x;
		}finally {
			x=3;
		}
	}
	
	
	

}
