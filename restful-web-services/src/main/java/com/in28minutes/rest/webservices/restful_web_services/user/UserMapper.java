package com.in28minutes.rest.webservices.restful_web_services.user;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface UserMapper {

	@Select("SELECT * FROM user")
	List<User> findAll();

	@Select("SELECT * FROM user WHERE id = #{id}")
	User findById(Long id);

	@Insert("INSERT INTO user(name ,birthday) VALUES(#{name},#{birthday})")
	@Options(useGeneratedKeys = true,keyProperty = "id")
	void insert(User user);

	@Delete("DELETE FROM user WHERE id = #{id}")
	void delete(Long id);


}
