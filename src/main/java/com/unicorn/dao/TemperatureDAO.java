package com.unicorn.dao;

import com.unicorn.model.Temperature;
import org.apache.ibatis.annotations.*;

@Mapper
public interface TemperatureDAO {
    String TABLE_NAME = "tem";
    String INSERT_FIELDS = "from, val, date";
//    String SELECT_FIELDS = ""

    @Insert({"insert into ", TABLE_NAME, "values (#{from},#{val},#{date})"})
    int addTemperature(Temperature temperature);

}
