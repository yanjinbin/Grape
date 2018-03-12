package com.yanjinbin.dao;

import com.yanjinbin.model.ArchiveVideoEntity;
import com.yanjinbin.model.ArchiveVideoEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArchiveVideoEntityMapper {
    /**
     *  根据指定的条件获取数据库记录数,archive_video
     *
     * @param example
     */
    long countByExample(ArchiveVideoEntityExample example);

    /**
     *  新写入数据库记录,archive_video
     *
     * @param record
     */
    int insert(ArchiveVideoEntity record);

    /**
     *  动态字段,写入数据库记录,archive_video
     *
     * @param record
     */
    int insertSelective(ArchiveVideoEntity record);

    /**
     *  根据指定的条件查询符合条件的数据库记录,archive_video
     *
     * @param example
     */
    List<ArchiveVideoEntity> selectByExample(ArchiveVideoEntityExample example);

    /**
     *  根据指定主键获取一条数据库记录,archive_video
     *
     * @param ArchiveVideoId
     */
    ArchiveVideoEntity selectByPrimaryKey(Integer ArchiveVideoId);

    /**
     *  动态根据指定的条件来更新符合条件的数据库记录,archive_video
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") ArchiveVideoEntity record, @Param("example") ArchiveVideoEntityExample example);

    /**
     *  根据指定的条件来更新符合条件的数据库记录,archive_video
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") ArchiveVideoEntity record, @Param("example") ArchiveVideoEntityExample example);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,archive_video
     *
     * @param record
     */
    int updateByPrimaryKeySelective(ArchiveVideoEntity record);

    /**
     *  根据主键来更新符合条件的数据库记录,archive_video
     *
     * @param record
     */
    int updateByPrimaryKey(ArchiveVideoEntity record);
}