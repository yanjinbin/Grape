package com.yanjinbin.dao;

import com.yanjinbin.model.ArchiveStatEntity;
import com.yanjinbin.model.ArchiveStatEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArchiveStatEntityMapper {
    /**
     *  根据指定的条件获取数据库记录数,archive_stat
     *
     * @param example
     */
    long countByExample(ArchiveStatEntityExample example);

    /**
     *  新写入数据库记录,archive_stat
     *
     * @param record
     */
    int insert(ArchiveStatEntity record);

    /**
     *  动态字段,写入数据库记录,archive_stat
     *
     * @param record
     */
    int insertSelective(ArchiveStatEntity record);

    /**
     *  根据指定的条件查询符合条件的数据库记录,archive_stat
     *
     * @param example
     */
    List<ArchiveStatEntity> selectByExample(ArchiveStatEntityExample example);

    /**
     *  根据指定主键获取一条数据库记录,archive_stat
     *
     * @param ArchiveStatId
     */
    ArchiveStatEntity selectByPrimaryKey(Long ArchiveStatId);

    /**
     *  动态根据指定的条件来更新符合条件的数据库记录,archive_stat
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") ArchiveStatEntity record, @Param("example") ArchiveStatEntityExample example);

    /**
     *  根据指定的条件来更新符合条件的数据库记录,archive_stat
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") ArchiveStatEntity record, @Param("example") ArchiveStatEntityExample example);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,archive_stat
     *
     * @param record
     */
    int updateByPrimaryKeySelective(ArchiveStatEntity record);

    /**
     *  根据主键来更新符合条件的数据库记录,archive_stat
     *
     * @param record
     */
    int updateByPrimaryKey(ArchiveStatEntity record);
}