package com.yanjinbin.dao;

import com.yanjinbin.model.ArchiveVideoTrackEntity;
import com.yanjinbin.model.ArchiveVideoTrackEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArchiveVideoTrackEntityMapper {
    /**
     *  根据指定的条件获取数据库记录数,archive_video_track
     *
     * @param example
     */
    long countByExample(ArchiveVideoTrackEntityExample example);

    /**
     *  新写入数据库记录,archive_video_track
     *
     * @param record
     */
    int insert(ArchiveVideoTrackEntity record);

    /**
     *  动态字段,写入数据库记录,archive_video_track
     *
     * @param record
     */
    int insertSelective(ArchiveVideoTrackEntity record);

    /**
     * ,archive_video_track
     *
     * @param example
     */
    List<ArchiveVideoTrackEntity> selectByExampleWithBLOBs(ArchiveVideoTrackEntityExample example);

    /**
     *  根据指定的条件查询符合条件的数据库记录,archive_video_track
     *
     * @param example
     */
    List<ArchiveVideoTrackEntity> selectByExample(ArchiveVideoTrackEntityExample example);

    /**
     *  根据指定主键获取一条数据库记录,archive_video_track
     *
     * @param ArchiveVideoTrackId
     */
    ArchiveVideoTrackEntity selectByPrimaryKey(Integer ArchiveVideoTrackId);

    /**
     *  动态根据指定的条件来更新符合条件的数据库记录,archive_video_track
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") ArchiveVideoTrackEntity record, @Param("example") ArchiveVideoTrackEntityExample example);

    /**
     * ,archive_video_track
     *
     * @param record
     * @param example
     */
    int updateByExampleWithBLOBs(@Param("record") ArchiveVideoTrackEntity record, @Param("example") ArchiveVideoTrackEntityExample example);

    /**
     *  根据指定的条件来更新符合条件的数据库记录,archive_video_track
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") ArchiveVideoTrackEntity record, @Param("example") ArchiveVideoTrackEntityExample example);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,archive_video_track
     *
     * @param record
     */
    int updateByPrimaryKeySelective(ArchiveVideoTrackEntity record);

    /**
     * ,archive_video_track
     *
     * @param record
     */
    int updateByPrimaryKeyWithBLOBs(ArchiveVideoTrackEntity record);

    /**
     *  根据主键来更新符合条件的数据库记录,archive_video_track
     *
     * @param record
     */
    int updateByPrimaryKey(ArchiveVideoTrackEntity record);
}