package com.zen.autumn.learn.base.enums;


import static com.zen.autumn.learn.base.enums.Outcomee.DRAW;
import static com.zen.autumn.learn.base.enums.Outcomee.LOSE;
import static com.zen.autumn.learn.base.enums.Outcomee.WIN;

interface Competitor<T extends Competitor<T>> {
	Outcomee compete(T competitor);
}

public enum EnumRoShamBo implements Competitor<EnumRoShamBo> {

	PAPER(DRAW, LOSE, WIN), SCISSORS(WIN, DRAW, LOSE), ROCK(LOSE, WIN, DRAW);
	private Outcomee vPAPER, vSCISSORS, vROCK;

	EnumRoShamBo(Outcomee paper, Outcomee scissors, Outcomee rock) {
		this.vPAPER = paper;
		this.vSCISSORS = scissors;
		this.vROCK = rock;
	}

	@Override

	public Outcomee compete(EnumRoShamBo it) {
		switch (it) {
		default:
		case PAPER:
			return vPAPER;
		case SCISSORS:
			return vSCISSORS;
		case ROCK:
			return vROCK;
		}
	}

}
