package com.yanjinbin.dao;

import com.yanjinbin.model.ArchiveStageConfEntity;
import com.yanjinbin.model.ArchiveStageConfEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArchiveStageConfEntityMapper {
    /**
     *  根据指定的条件获取数据库记录数,archive_stage_conf
     *
     * @param example
     */
    long countByExample(ArchiveStageConfEntityExample example);

    /**
     *  新写入数据库记录,archive_stage_conf
     *
     * @param record
     */
    int insert(ArchiveStageConfEntity record);

    /**
     *  动态字段,写入数据库记录,archive_stage_conf
     *
     * @param record
     */
    int insertSelective(ArchiveStageConfEntity record);

    /**
     *  根据指定的条件查询符合条件的数据库记录,archive_stage_conf
     *
     * @param example
     */
    List<ArchiveStageConfEntity> selectByExample(ArchiveStageConfEntityExample example);

    /**
     *  根据指定主键获取一条数据库记录,archive_stage_conf
     *
     * @param ArchiveStageConfId
     */
    ArchiveStageConfEntity selectByPrimaryKey(Long ArchiveStageConfId);

    /**
     *  动态根据指定的条件来更新符合条件的数据库记录,archive_stage_conf
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") ArchiveStageConfEntity record, @Param("example") ArchiveStageConfEntityExample example);

    /**
     *  根据指定的条件来更新符合条件的数据库记录,archive_stage_conf
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") ArchiveStageConfEntity record, @Param("example") ArchiveStageConfEntityExample example);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,archive_stage_conf
     *
     * @param record
     */
    int updateByPrimaryKeySelective(ArchiveStageConfEntity record);

    /**
     *  根据主键来更新符合条件的数据库记录,archive_stage_conf
     *
     * @param record
     */
    int updateByPrimaryKey(ArchiveStageConfEntity record);
}