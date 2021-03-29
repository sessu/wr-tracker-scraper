package net.sessu.WRTracker;

public class Score {

	private int song_id, level, ddrcode, score;
	
	public int getSong_id() {
		return song_id;
	}

	public int getLevel() {
		return level;
	}

	public int getDdrcode() {
		return ddrcode;
	}

	public int getScore() {
		return score;
	}

	public Score(int sa4_id, int level, int ddrcode, int score) {
		super();
		this.song_id = sa4_id;
		this.level = level;
		this.ddrcode = ddrcode;
		this.score = score;
	}

	@Override
	public String toString() {
		return "Score [sa4_id=" + song_id + ", level=" + level + ", ddrcode=" + ddrcode + ", score=" + score + "]";
	}

}
