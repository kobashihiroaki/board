package board_create;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BoardController {
	private static BoardController controller = new BoardController();

	public static BoardController getInstance() {
		return controller;
	}

	private BoardController() {
	}

	public void postTopic(Topic topic) {
		String sql = "INSERT INTO board(detail)"
				+ " VALUES(" + "'" + topic.getDetail() + "'" + ")";

		Connection con = null;
		Statement smt = null;
		try {
			con = ConnectionManager.getConnection();
			smt = con.createStatement();
			smt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (Exception ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception ignore) {
				}
			}
		}
	}



	public List<Topic> getTopics() {
		String sql = "SELECT * FROM board";
		List<Topic> topics = new ArrayList<Topic>();

		Connection con = null;
		Statement smt = null;
		ResultSet rs = null;
		try {
			con = ConnectionManager.getConnection();
			smt = con.createStatement();
			rs = smt.executeQuery(sql);
			while (rs.next()) {
				Topic topic = new Topic();
				topic.setId(rs.getInt("id"));
				topic.setStart_at(rs
						.getTimestamp("start_at"));
				topic.setDetail(rs.getString("detail"));
				topics.add(topic);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception ignore) {
				}
			}
			if (smt != null) {
				try {
					smt.close();
				} catch (Exception ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception ignore) {
				}
			}
		}
		return topics;
	}

	public void deleteTopic(Topic topic) {
		String sql = "DELETE  FROM board WHERE id = " + topic.getId() ;
		List<Topic> topics = new ArrayList<Topic>();

		Connection con = null;
		Statement smt = null;
		try {
			con = ConnectionManager.getConnection();
			smt = con.createStatement();
			smt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (Exception ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception ignore) {
				}
			}
		}
	}

	public static void main(String[] args) {
		BoardController ctrl = BoardController.getInstance();
		List <Topic> topics = ctrl.getTopics();
		for (int i = 0; i < topics.size(); i++) {
			System.out.println(topics.get(i));
		}

		System.out.println("END");
	}
}
