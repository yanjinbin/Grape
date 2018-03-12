package com.yanjinbin.dao;

import com.yanjinbin.model.ArchiveEntity;
import com.yanjinbin.model.ArchiveEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArchiveEntityMapper {
    /**
     *  根据指定的条件获取数据库记录数,archive
     *
     * @param example
     */
    long countByExample(ArchiveEntityExample example);

    /**
     *  新写入数据库记录,archive
     *
     * @param record
     */
    int insert(ArchiveEntity record);

    /**
     *  动态字段,写入数据库记录,archive
     *
     * @param record
     */
    int insertSelective(ArchiveEntity record);

    /**
     *  根据指定的条件查询符合条件的数据库记录,archive
     *
     * @param example
     */
    List<ArchiveEntity> selectByExample(ArchiveEntityExample example);

    /**
     *  根据指定主键获取一条数据库记录,archive
     *
     * @param ArchiveId
     */
    ArchiveEntity selectByPrimaryKey(Integer ArchiveId);

    /**
     *  动态根据指定的条件来更新符合条件的数据库记录,archive
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") ArchiveEntity record, @Param("example") ArchiveEntityExample example);

    /**
     *  根据指定的条件来更新符合条件的数据库记录,archive
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") ArchiveEntity record, @Param("example") ArchiveEntityExample example);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,archive
     *
     * @param record
     */
    int updateByPrimaryKeySelective(ArchiveEntity record);

    /**
     *  根据主键来更新符合条件的数据库记录,archive
     *
     * @param record
     */
    int updateByPrimaryKey(ArchiveEntity record);
}