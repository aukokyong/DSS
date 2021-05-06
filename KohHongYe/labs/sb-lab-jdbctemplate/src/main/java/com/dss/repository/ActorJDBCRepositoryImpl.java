package com.dss.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.dss.model.Actor;

@Repository
public class ActorJDBCRepositoryImpl implements ActorJDBCRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;

	class ActorRowMapper implements RowMapper<Actor> {

		@Override
		public Actor mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Actor actor = new Actor();
			actor.setActorId(resultSet.getLong(1));
			actor.setFirstName(resultSet.getString(2));
			actor.setLastName(resultSet.getString(3));
			actor.setGender(resultSet.getString(4).charAt(0));
			actor.setAge(resultSet.getInt(5));
			return actor;
		}

	}

	@Override
	public List<Actor> findAll() {
		ActorRowMapper actorRowMapper = new ActorRowMapper();
		List<Actor> actorsList = jdbcTemplate.query("SELECT * FROM ACTORS", actorRowMapper);
		return actorsList;
	}

	@Override
	public Optional<Actor> findById(long actorId) {
		BeanPropertyRowMapper<Actor> beanPropertyRowMapper = new BeanPropertyRowMapper<Actor>(Actor.class);
		Actor actor = jdbcTemplate.queryForObject("SELECT * FROM ACTORS where actor_id = ?",
				new Object[]{actorId},
				beanPropertyRowMapper);
		return Optional.of(actor);
	}

	@Override
	public int insert(Actor actor) {
		return jdbcTemplate.update(
				"insert into ACTORS values(?, ?, ?, ?, ?)",
				new Object[] { actor.getActorId(), actor.getFirstName(), actor.getLastName(), ""+actor.getGender(),actor.getAge() });
	}

	@Override
	public int update(Actor actor) {
		return jdbcTemplate.update(
				"update ACTORS " + " set first_name = ?, last_name = ?, gender = ? , age = ?" + " where actor_id = ?",
				new Object[] { actor.getFirstName(), actor.getLastName(),
						""+actor.getGender(),actor.getAge() ,actor.getActorId()});
	}

	@Override
	public int deleteById(long actorId) {
		return jdbcTemplate.update("delete from ACTORS where actor_id=?", new Object[] { actorId });
	}

	@Override
	public int deleteAll() {
		return jdbcTemplate.update("delete from ACTORS");
	}

}
