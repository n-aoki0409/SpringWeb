package dao;

import javax.sql.DataSource;

import logic.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

	private static final String SELECT_BY_USERID_PASSWORD = "SELECT user_id, password, user_name, postcode,"
			+ " address, email, job, birthday FROM user_account WHERE user_id = :userId AND password = :password";

	private static final String INSERT = "INSERT INTO user_account (user_id, user_name, password, postcode, address, email, job, birthday)"
			+ " VALUES(:userId, :userName, :password, :postCode, :address, :email, :job, :birthDay)";

	private NamedParameterJdbcTemplate template;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.template = new NamedParameterJdbcTemplate(dataSource);
	}

	public User findByUserIdAndPassword(String userId, String password) {
		User user = new User();
		user.setUserId(userId);
		user.setPassword(password);

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(user);
		RowMapper<User> mapper = new BeanPropertyRowMapper<User>(User.class);
		return this.template.queryForObject(SELECT_BY_USERID_PASSWORD, parameterSource, mapper);
	}

	public void create(User user) {
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(user);
		this.template.update(UserDaoImpl.INSERT, parameterSource);
	}
}
