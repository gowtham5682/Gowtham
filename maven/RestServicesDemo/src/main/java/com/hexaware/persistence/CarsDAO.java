package com.hexaware.persistence;

import java.util.List;

import com.hexaware.model.*;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

public interface CarsDAO {

    @SqlUpdate("Insert into Cars (name,price) values(:name, :price")
    public int insertCar(@Bind("name") String carName, @Bind("price") double price);

    @SqlQuery("Select * from Cars")
    @Mapper(CarsMapper.class)
    public List<Cars> listAll();

    @SqlQuery("Select * from Cars where name = :name")
    @Mapper(CarsMapper.class)
    Cars find(@Bind("name") int id);

	public int updateCar(double price, int id);

}