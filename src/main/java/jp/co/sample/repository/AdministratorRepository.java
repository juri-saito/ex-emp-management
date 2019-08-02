package jp.co.sample.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.sample.domain.Administrator;

/**
 * administratorsテーブルを操作するリポジトリ
 * 
 * @author JURI
 *
 */
@Repository
public class AdministratorRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;

	/**
	 * Administratorオブジェクトを生成するローマッパー
	 */
	private static final RowMapper<Administrator> ADMINISTRATOR_ROW_MAPPER = (rs, i) ->{
		Administrator administrator = new Administrator();
		administrator.setId(rs.getInt("id"));
		administrator.setName(rs.getString("name"));
		administrator.setMailAddress(rs.getString("mailAddress"));
		administrator.setPassword(rs.getString("password"));
		return administrator;
	};
	
	
	/**
	 * 管理者情報を挿入する
	 * 
	 * @param administrator
	 * 
	 */
	public void insert(Administrator administrator) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(administrator);
		
		String sql = "INSERT INTO administrators (name,mail_address,password) + VALUES(:name,:mailAddress,:password)";
		template.update(sql, param);
	}
	
	/**
	 * メールアドレスとパスワードから管理者情報を取得する。
	 * 
	 * @param mailAddress
	 * @param password
	 * @return administrator　存在しない場合はnullを返す
	 * 
	 */
	public Administrator findByMailAddressAndPassword(String mailAddress, String password) {
		Administrator administrator = new Administrator();
		
		String sql = "SELECT id,name,mailAddress,password FROM administrators";
		List<Administrator> administratorList = template.query(sql, ADMINISTRATOR_ROW_MAPPER);
		
		if(administratorList.size() == 0) {
			return null;
		}else {
			administrator = administratorList.get(0);
			return administrator; 
		}
	}
}
