package example.encapsulation.com;

public class Student {

	private String stdname;
	private int stdrollno;
	private int stdid;

	public int getStdid() {
		return stdid;
	}

	public int getStdrollno() {
		return stdrollno;
	}

	public String getStdname() {
		return stdname;
	}

	public void setStdname(String stdname) {
		this.stdname = stdname;
	}

	public void setStdid(int stdid) {
		this.stdid = stdid;
	}

	public void setStdrollno(int stdrollno) {
		this.stdrollno = stdrollno;
	}

}
