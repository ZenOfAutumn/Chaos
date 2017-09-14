package com.zen.autumn.learn.base.enums;

import static com.zen.autumn.learn.base.enums.Outcomee.DRAW;
import static com.zen.autumn.learn.base.enums.Outcomee.LOSE;
import static com.zen.autumn.learn.base.enums.Outcomee.WIN;


public enum RoShamBoArray {
	
	PAPER((byte)0), SCISSORS((byte)1), ROCK((byte)2);
	
	private byte id;
	
	private RoShamBoArray(final byte id) {
		this.id = id;
	}
	
	public byte getId(){
		return id;
	}
	  private static Outcomee[][] table = {
	    { DRAW, LOSE, WIN }, // PAPER
	    { WIN, DRAW, LOSE }, // SCISSORS
	    { LOSE, WIN, DRAW }, // ROCK
	  };
	  public Outcomee compete(RoShamBoArray other) {
	    return table[this.getId()][other.getId()];
	  }
	  public static void main(String[] args) {
		  for(RoShamBoArray A:values()){
			  for(RoShamBoArray B:values()){
				  System.out.println(A+"vs"+B+":"+A.compete(B));
			  }
		}
	  }
	

}
