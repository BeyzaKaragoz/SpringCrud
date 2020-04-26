package com.crud.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.crud.dto.Animal;

@Repository

public class AnimalDaoImpl implements AnimalDao{
	NamedParameterJdbcTemplate template;

	@Autowired
	public void setTemplate(NamedParameterJdbcTemplate template) throws DataAccessException {
		this.template = template;
	}

	private SqlParameterSource getSqlParamsByModel(Animal a) {
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		if (a != null) {
			parameterSource.addValue("id", a.getAnimalid());
			parameterSource.addValue("color", a.getColor());
			parameterSource.addValue("type", a.getType());
			parameterSource.addValue("name", a.getName());
			
			}
			return parameterSource;
	}

	private static final class UserMapper implements RowMapper {

		public Animal mapRow(ResultSet rs, int rowNum) throws SQLException {
			Animal a = new Animal();
			a.setAnimalid(rs.getInt("animalid"));
			a.setColor(rs.getString("color"));
			a.setType(rs.getString("type"));
			a.setName(rs.getString("name"));
			
			return a;
		}

	}

	public List<Animal> getlistOfAnimals() {
		System.out.println("Animal List");
		String query = "SELECT animalid, type, name, color FROM animal";
		List<Animal> list = template.query(query, getSqlParamsByModel(null), new UserMapper());
		return list;
	}

	public void addAnimal(Animal a) {
		String query = "INSERT INTO animal(type, name, color) VALUES (:type, :name, :color)";
		template.update(query, getSqlParamsByModel(a));
	}
	public void deleteAnimal(String type) {
		String query = "DELETE FROM animal WHERE type = :type";
		template.update(query, getSqlParamsByModel(new Animal(type)));
	}
	public Animal findAnimal(String type) {
		String query = "SELECT * FROM animal WHERE type = :type";
		return (Animal)template.queryForObject(query, getSqlParamsByModel(new Animal(type)), new UserMapper());
	}

	public void updateAnimal(Animal a) {
		String query = "UPDATE animal SET type = :type, name = :name , color = :color WHERE type = :type";
		template.update(query, getSqlParamsByModel(a));
	}

	
	

	
}
