package com.yanjinbin.dao;

import com.yanjinbin.model.ArchiveAdditEntity;
import com.yanjinbin.model.ArchiveAdditEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArchiveAdditEntityMapper {
    /**
     *  根据指定的条件获取数据库记录数,archive_addit
     *
     * @param example
     */
    long countByExample(ArchiveAdditEntityExample example);

    /**
     *  新写入数据库记录,archive_addit
     *
     * @param record
     */
    int insert(ArchiveAdditEntity record);

    /**
     *  动态字段,写入数据库记录,archive_addit
     *
     * @param record
     */
    int insertSelective(ArchiveAdditEntity record);

    /**
     * ,archive_addit
     *
     * @param example
     */
    List<ArchiveAdditEntity> selectByExampleWithBLOBs(ArchiveAdditEntityExample example);

    /**
     *  根据指定的条件查询符合条件的数据库记录,archive_addit
     *
     * @param example
     */
    List<ArchiveAdditEntity> selectByExample(ArchiveAdditEntityExample example);

    /**
     *  根据指定主键获取一条数据库记录,archive_addit
     *
     * @param ArchiveAdditId
     */
    ArchiveAdditEntity selectByPrimaryKey(Long ArchiveAdditId);

    /**
     *  动态根据指定的条件来更新符合条件的数据库记录,archive_addit
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") ArchiveAdditEntity record, @Param("example") ArchiveAdditEntityExample example);

    /**
     * ,archive_addit
     *
     * @param record
     * @param example
     */
    int updateByExampleWithBLOBs(@Param("record") ArchiveAdditEntity record, @Param("example") ArchiveAdditEntityExample example);

    /**
     *  根据指定的条件来更新符合条件的数据库记录,archive_addit
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") ArchiveAdditEntity record, @Param("example") ArchiveAdditEntityExample example);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,archive_addit
     *
     * @param record
     */
    int updateByPrimaryKeySelective(ArchiveAdditEntity record);

    /**
     * ,archive_addit
     *
     * @param record
     */
    int updateByPrimaryKeyWithBLOBs(ArchiveAdditEntity record);

    /**
     *  根据主键来更新符合条件的数据库记录,archive_addit
     *
     * @param record
     */
    int updateByPrimaryKey(ArchiveAdditEntity record);
}