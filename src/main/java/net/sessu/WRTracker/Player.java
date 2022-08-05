package net.sessu.WRTracker;

public class Player {
	private int ddrcode;
	private String name;
	private double weighted_score;
	private int total_u, total_t;
	
	private int beg_u, beg_t;
	private int bsp_u, bsp_t;
	private int dsp_u, dsp_t;
	private int esp_u, esp_t;
	private int csp_u, csp_t;
	
	private int bdp_u, bdp_t;
	private int ddp_u, ddp_t;
	private int edp_u, edp_t;
	private int cdp_u, cdp_t;

	private double beg_s;
	private double bsp_s;
	private double dsp_s;
	private double esp_s;
	private double csp_s;
	private double bdp_s;
	private double ddp_s;
	private double edp_s;
	private double cdp_s;
	
	public Player(int ddrcode, String name) {
		super();
		this.ddrcode = ddrcode;
		this.name = name;
	}

	public int getDdrcode() {
		return ddrcode;
	}

	public void setDdrcode(int ddrcode) {
		this.ddrcode = ddrcode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// ROUND TO 4 DECIMALS
	public double getWeighted_score() {
		return weighted_score;
	}

	public int getTotal_u() {
		return total_u;
	}

	public int getTotal_t() {
		return total_t;
	}

	public int getBeg_u() {
		return beg_u;
	}

	public int getBeg_t() {
		return beg_t;
	}

	public int getBsp_u() {
		return bsp_u;
	}

	public int getBsp_t() {
		return bsp_t;
	}

	public int getDsp_u() {
		return dsp_u;
	}

	public int getDsp_t() {
		return dsp_t;
	}

	public int getEsp_u() {
		return esp_u;
	}

	public int getEsp_t() {
		return esp_t;
	}

	public int getCsp_u() {
		return csp_u;
	}

	public int getCsp_t() {
		return csp_t;
	}

	public int getBdp_u() {
		return bdp_u;
	}

	public int getBdp_t() {
		return bdp_t;
	}

	public int getDdp_u() {
		return ddp_u;
	}

	public int getDdp_t() {
		return ddp_t;
	}

	public int getEdp_u() {
		return edp_u;
	}

	public int getEdp_t() {
		return edp_t;
	}

	public int getCdp_u() {
		return cdp_u;
	}

	public int getCdp_t() {
		return cdp_t;
	}

	public void setWeighted_score(double weighted_score) {
		this.weighted_score = weighted_score;
	}

	public void setTotal_u(int total_u) {
		this.total_u = total_u;
	}

	public void setTotal_t(int total_t) {
		this.total_t = total_t;
	}

	public void setBeg_u(int beg_u) {
		this.beg_u = beg_u;
	}

	public void setBeg_t(int beg_t) {
		this.beg_t = beg_t;
	}

	public void setBsp_u(int bsp_u) {
		this.bsp_u = bsp_u;
	}

	public void setBsp_t(int bsp_t) {
		this.bsp_t = bsp_t;
	}

	public void setDsp_u(int dsp_u) {
		this.dsp_u = dsp_u;
	}

	public void setDsp_t(int dsp_t) {
		this.dsp_t = dsp_t;
	}

	public void setEsp_u(int esp_u) {
		this.esp_u = esp_u;
	}

	public void setEsp_t(int esp_t) {
		this.esp_t = esp_t;
	}

	public void setCsp_u(int csp_u) {
		this.csp_u = csp_u;
	}

	public void setCsp_t(int csp_t) {
		this.csp_t = csp_t;
	}

	public void setBdp_u(int bdp_u) {
		this.bdp_u = bdp_u;
	}

	public void setBdp_t(int bdp_t) {
		this.bdp_t = bdp_t;
	}

	public void setDdp_u(int ddp_u) {
		this.ddp_u = ddp_u;
	}

	public void setDdp_t(int ddp_t) {
		this.ddp_t = ddp_t;
	}

	public void setEdp_u(int edp_u) {
		this.edp_u = edp_u;
	}

	public void setEdp_t(int edp_t) {
		this.edp_t = edp_t;
	}

	@Override
	public String toString() {
		return "Player [ddrcode=" + ddrcode + ", " + (name != null ? "name=" + name + ", " : "") + "weighted_score="
				+ weighted_score + ", total_u=" + total_u + ", total_t=" + total_t + ", beg_u=" + beg_u + ", beg_t="
				+ beg_t + ", bsp_u=" + bsp_u + ", bsp_t=" + bsp_t + ", dsp_u=" + dsp_u + ", dsp_t=" + dsp_t + ", esp_u="
				+ esp_u + ", esp_t=" + esp_t + ", csp_u=" + csp_u + ", csp_t=" + csp_t + ", bdp_u=" + bdp_u + ", bdp_t="
				+ bdp_t + ", ddp_u=" + ddp_u + ", ddp_t=" + ddp_t + ", edp_u=" + edp_u + ", edp_t=" + edp_t + ", cdp_u="
				+ cdp_u + ", cdp_t=" + cdp_t + ", beg_s=" + beg_s + ", bsp_s=" + bsp_s + ", dsp_s=" + dsp_s + ", esp_s="
				+ esp_s + ", csp_s=" + csp_s + ", bdp_s=" + bdp_s + ", ddp_s=" + ddp_s + ", edp_s=" + edp_s + ", cdp_s="
				+ cdp_s + "]";
	}

	public void setCdp_u(int cdp_u) {
		this.cdp_u = cdp_u;
	}

	public void setCdp_t(int cdp_t) {
		this.cdp_t = cdp_t;
	}

	public double getBeg_s() {
		return beg_s;
	}

	public double getBsp_s() {
		return bsp_s;
	}

	public double getDsp_s() {
		return dsp_s;
	}

	public double getEsp_s() {
		return esp_s;
	}

	public double getCsp_s() {
		return csp_s;
	}

	public double getBdp_s() {
		return bdp_s;
	}

	public double getDdp_s() {
		return ddp_s;
	}

	public double getEdp_s() {
		return edp_s;
	}

	public double getCdp_s() {
		return cdp_s;
	}

	public void setBeg_s(double beg_s) {
		this.beg_s = beg_s;
	}

	public void setBsp_s(double bsp_s) {
		this.bsp_s = bsp_s;
	}

	public void setDsp_s(double dsp_s) {
		this.dsp_s = dsp_s;
	}

	public void setEsp_s(double esp_s) {
		this.esp_s = esp_s;
	}

	public void setCsp_s(double csp_s) {
		this.csp_s = csp_s;
	}

	public void setBdp_s(double bdp_s) {
		this.bdp_s = bdp_s;
	}

	public void setDdp_s(double ddp_s) {
		this.ddp_s = ddp_s;
	}

	public void setEdp_s(double edp_s) {
		this.edp_s = edp_s;
	}

	public void setCdp_s(double cdp_s) {
		this.cdp_s = cdp_s;
	}
	
	
	
	

}
