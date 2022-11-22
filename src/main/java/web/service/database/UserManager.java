package web.service.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import web.encoding.Encoding;
import web.model.User;

public class UserManager {
	private static final String GET_USER = "SELECT id, email, password, name, region, gender, comment, agreement  FROM account WHERE email = ? AND password = ?";
	private static final String ADD_USER = "INSERT INTO account (email, password, name, region, gender, comment, agreement) VALUES(?,?,?,?,?,?,?)";

	private Logger logger = Logger.getLogger(DBWorker.class.getName());
	private DBWorker worker;

	public UserManager(DBWorker worker) {
		this.worker = worker;
	}

	public User getUser(String login, String password) {
		User user = null;
		Connection con = worker.getConnection();
		if (Objects.nonNull(login) && Objects.nonNull(password) && Objects.nonNull(con)) {
			PreparedStatement ps = null;
			ResultSet rs = null;

			try {
				ps = con.prepareStatement(GET_USER);
				ps.setString(1, login);
				ps.setString(2, Encoding.md5EncryptionWithSalt(password));
				rs = ps.executeQuery();
				if (rs.next()) {
					user = new User(rs.getInt("id"), rs.getString("email"), rs.getString("password"),
							rs.getString("name"), rs.getString("region"), rs.getString("gender"),
							rs.getString("comment"), rs.getBoolean("agreement"));
				}
			} catch (SQLException e) {
				logger.log(Level.INFO, e.getMessage());
			} finally {
				try {
					if (Objects.nonNull(rs)) {
						rs.close();
					}
				} catch (SQLException e2) {
					logger.log(Level.INFO, e2.getMessage());
				}
				try {
					if (Objects.nonNull(ps)) {
						ps.close();
					}
				} catch (SQLException e1) {
					logger.log(Level.INFO, e1.getMessage());
				}
				try {
					if (Objects.nonNull(con)) {
						con.close();
					}
				} catch (SQLException e) {
					logger.log(Level.INFO, e.getMessage());
				}
			}
		}
		return user;
	}

	public void addUser(User user) {
		Connection con = worker.getConnection();

		if (Objects.nonNull(user)) {
			PreparedStatement ps = null;
			try {
				ps = con.prepareStatement(ADD_USER);
				ps.setString(1, user.getEmail());
				ps.setString(2, Encoding.md5EncryptionWithSalt(user.getPassword()));
				ps.setString(3, user.getName());
				ps.setString(4, user.getRegion());
				ps.setString(5, user.getGender());
				ps.setString(6, user.getComment());
				ps.setBoolean(7, user.isAgreement());
				ps.execute();
			} catch (SQLException e) {
				logger.log(Level.INFO, e.getMessage());
			} finally {
				try {
					if (Objects.nonNull(ps)) {
						ps.close();
					}
				} catch (SQLException e1) {
					logger.log(Level.INFO, e1.getMessage());
				}
				try {
					if (Objects.nonNull(con)) {
						con.close();
					}
				} catch (SQLException e) {
					logger.log(Level.INFO, e.getMessage());
				}
			}
		}
	}
}
