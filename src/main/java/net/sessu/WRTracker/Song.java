package net.sessu.WRTracker;

public class Song {
	private int sa4_id;
	private String konami_id;
	
	private int beg,bsp,dsp,esp,csp;
	private int     bdp,ddp,edp,cdp;
	
	private int beg_s,bsp_s,dsp_s,esp_s,csp_s;
	private int       bdp_s,ddp_s,edp_s,cdp_s;
	
	private int beg_c,bsp_c,dsp_c,esp_c,csp_c,bdp_c,ddp_c,edp_c,cdp_c;
	
	private String title;
	private String artist;
	
	public Song(int sa4_id) {
		super();
		this.sa4_id = sa4_id;
		beg_c=bsp_c=dsp_c=esp_c=csp_c=bdp_c=ddp_c=edp_c=cdp_c=0;
	}
	
	public int getBeg_c() {
		return beg_c;
	}

	public int getBsp_c() {
		return bsp_c;
	}

	public int getDsp_c() {
		return dsp_c;
	}

	public int getEsp_c() {
		return esp_c;
	}

	public int getCsp_c() {
		return csp_c;
	}

	public int getBdp_c() {
		return bdp_c;
	}

	public int getDdp_c() {
		return ddp_c;
	}

	public int getEdp_c() {
		return edp_c;
	}

	public int getCdp_c() {
		return cdp_c;
	}

	@Override
	public String toString() {
		return "Song [sa4_id=" + sa4_id + ", " + (konami_id != null ? "konami_id=" + konami_id + ", " : "") + "beg="
				+ beg + ", bsp=" + bsp + ", dsp=" + dsp + ", esp=" + esp + ", csp=" + csp + ", bdp=" + bdp + ", ddp="
				+ ddp + ", edp=" + edp + ", cdp=" + cdp + ", beg_s=" + beg_s + ", bsp_s=" + bsp_s + ", dsp_s=" + dsp_s
				+ ", esp_s=" + esp_s + ", csp_s=" + csp_s + ", bdp_s=" + bdp_s + ", ddp_s=" + ddp_s + ", edp_s=" + edp_s
				+ ", cdp_s=" + cdp_s + ", beg_c=" + beg_c + ", bsp_c=" + bsp_c + ", dsp_c=" + dsp_c + ", esp_c=" + esp_c
				+ ", csp_c=" + csp_c + ", bdp_c=" + bdp_c + ", ddp_c=" + ddp_c + ", edp_c=" + edp_c + ", cdp_c=" + cdp_c
				+ ", " + (title != null ? "title=" + title + ", " : "") + (artist != null ? "artist=" + artist : "")
				+ "]";
	}

	public String toJsString() {
		return "{index=" + sa4_id + ", " + (konami_id != null ? "id=" + konami_id + ", " : "") + "beg="
				+ beg + ", bsp=" + bsp + ", dsp=" + dsp + ", esp=" + esp + ", csp=" + csp + ", bdp=" + bdp + ", ddp="
				+ ddp + ", edp=" + edp + ", cdp=" + cdp + ", beg_s=" + beg_s + ", bsp_s=" + bsp_s + ", dsp_s=" + dsp_s
				+ ", esp_s=" + esp_s + ", csp_s=" + csp_s + ", bdp_s=" + bdp_s + ", ddp_s=" + ddp_s + ", edp_s=" + edp_s
				+ ", cdp_s=" + cdp_s + ", " + (title != null ? "title=\"" + title + ", " : "")
				+ (artist != null ? "artist=\"" + artist : "\"") + "}";
	}
	
	public void setSa4_id(int sa4_id) {
		this.sa4_id = sa4_id;
	}

	public void setKonami_id(String konami_id) {
		this.konami_id = konami_id;
	}

	public void setBeg(int beg) {
		this.beg = beg;
	}

	public void setBsp(int bsp) {
		this.bsp = bsp;
	}

	public void setDsp(int dsp) {
		this.dsp = dsp;
	}

	public void setEsp(int esp) {
		this.esp = esp;
	}

	public void setCsp(int csp) {
		this.csp = csp;
	}

	public void setBdp(int bdp) {
		this.bdp = bdp;
	}

	public void setDdp(int ddp) {
		this.ddp = ddp;
	}

	public void setEdp(int edp) {
		this.edp = edp;
	}

	public void setCdp(int cdp) {
		this.cdp = cdp;
	}

	public void setBeg_s(int beg_s) {
		this.beg_s = beg_s;
	}

	public void setBsp_s(int bsp_s) {
		this.bsp_s = bsp_s;
	}

	public void setDsp_s(int dsp_s) {
		this.dsp_s = dsp_s;
	}

	public void setEsp_s(int esp_s) {
		this.esp_s = esp_s;
	}

	public void setCsp_s(int csp_s) {
		this.csp_s = csp_s;
	}

	public void setBdp_s(int bdp_s) {
		this.bdp_s = bdp_s;
	}

	public void setDdp_s(int ddp_s) {
		this.ddp_s = ddp_s;
	}

	public void setEdp_s(int edp_s) {
		this.edp_s = edp_s;
	}

	public void setCdp_s(int cdp_s) {
		this.cdp_s = cdp_s;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public int getSa4_id() {
		return sa4_id;
	}

	public String getKonami_id() {
		return konami_id;
	}

	public int getBeg() {
		return beg;
	}

	public int getBsp() {
		return bsp;
	}

	public int getDsp() {
		return dsp;
	}

	public int getEsp() {
		return esp;
	}

	public int getCsp() {
		return csp;
	}

	public int getBdp() {
		return bdp;
	}

	public int getDdp() {
		return ddp;
	}

	public int getEdp() {
		return edp;
	}

	public int getCdp() {
		return cdp;
	}

	public int getBeg_s() {
		return beg_s;
	}

	public int getBsp_s() {
		return bsp_s;
	}

	public int getDsp_s() {
		return dsp_s;
	}

	public int getEsp_s() {
		return esp_s;
	}

	public int getCsp_s() {
		return csp_s;
	}

	public int getBdp_s() {
		return bdp_s;
	}

	public int getDdp_s() {
		return ddp_s;
	}

	public int getEdp_s() {
		return edp_s;
	}

	public int getCdp_s() {
		return cdp_s;
	}

	public String getTitle() {
		return title;
	}

	public String getArtist() {
		return artist;
	}

	public void setBeg_c(int beg_c) {
		this.beg_c = beg_c;
	}

	public void setBsp_c(int bsp_c) {
		this.bsp_c = bsp_c;
	}

	public void setDsp_c(int dsp_c) {
		this.dsp_c = dsp_c;
	}

	public void setEsp_c(int esp_c) {
		this.esp_c = esp_c;
	}

	public void setCsp_c(int csp_c) {
		this.csp_c = csp_c;
	}

	public void setBdp_c(int bdp_c) {
		this.bdp_c = bdp_c;
	}

	public void setDdp_c(int ddp_c) {
		this.ddp_c = ddp_c;
	}

	public void setEdp_c(int edp_c) {
		this.edp_c = edp_c;
	}

	public void setCdp_c(int cdp_c) {
		this.cdp_c = cdp_c;
	}

	
	

}
