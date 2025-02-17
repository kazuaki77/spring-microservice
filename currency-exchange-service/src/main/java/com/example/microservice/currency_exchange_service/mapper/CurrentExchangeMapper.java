package com.example.microservice.currency_exchange_service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.example.microservice.currency_exchange_service.bean.CurrentExchange;

@Mapper
public interface CurrentExchangeMapper {

	@Select("select * from currency_exchange;")
	public List<CurrentExchange> findAll();

	@Select("select * from currency_exchange where id =#{id}")
	public CurrentExchange findById(Long id);

	@Select("select * from currency_exchange where currency_from =#{currency_from} and currency_to = #{currency_to}")
	public CurrentExchange findByFromAndTo(String currency_from, String currency_to);

	@Insert("insert into currency_exchange (currency_from,currency_to,conversion_multiple,environment) values(#{currency_from},#{currency_to},#{conversion_multiple},#{environment});")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void save(CurrentExchange currentExchange);
}
