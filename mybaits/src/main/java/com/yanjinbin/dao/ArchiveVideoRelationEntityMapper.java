package com.yanjinbin.dao;

import com.yanjinbin.model.ArchiveVideoRelationEntity;
import com.yanjinbin.model.ArchiveVideoRelationEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArchiveVideoRelationEntityMapper {
    /**
     *  根据指定的条件获取数据库记录数,archive_video_relation
     *
     * @param example
     */
    long countByExample(ArchiveVideoRelationEntityExample example);

    /**
     *  新写入数据库记录,archive_video_relation
     *
     * @param record
     */
    int insert(ArchiveVideoRelationEntity record);

    /**
     *  动态字段,写入数据库记录,archive_video_relation
     *
     * @param record
     */
    int insertSelective(ArchiveVideoRelationEntity record);

    /**
     *  根据指定的条件查询符合条件的数据库记录,archive_video_relation
     *
     * @param example
     */
    List<ArchiveVideoRelationEntity> selectByExample(ArchiveVideoRelationEntityExample example);

    /**
     *  根据指定主键获取一条数据库记录,archive_video_relation
     *
     * @param ArchiveVideoRelationId
     */
    ArchiveVideoRelationEntity selectByPrimaryKey(Long ArchiveVideoRelationId);

    /**
     *  动态根据指定的条件来更新符合条件的数据库记录,archive_video_relation
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") ArchiveVideoRelationEntity record, @Param("example") ArchiveVideoRelationEntityExample example);

    /**
     *  根据指定的条件来更新符合条件的数据库记录,archive_video_relation
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") ArchiveVideoRelationEntity record, @Param("example") ArchiveVideoRelationEntityExample example);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,archive_video_relation
     *
     * @param record
     */
    int updateByPrimaryKeySelective(ArchiveVideoRelationEntity record);

    /**
     *  根据主键来更新符合条件的数据库记录,archive_video_relation
     *
     * @param record
     */
    int updateByPrimaryKey(ArchiveVideoRelationEntity record);
}