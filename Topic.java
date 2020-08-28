package board_create;

import java.util.Date;

public class Topic {
	private int id;
	private String detail;
	private Date start_at;

	public String toString() {
		return super.toString()
				+ ",id=" + id
				+ ",detail=" + detail
				+ "start_at" + start_at
				;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Date getStart_at() {
		return start_at;
	}
	public void setStart_at(Date start_at) {
		this.start_at = start_at;
	}

}
