package com.yanjinbin.dao;

import com.yanjinbin.model.AvDailyChargeEntity;
import com.yanjinbin.model.AvDailyChargeEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AvDailyChargeEntityMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table av_daily_charge
     *
     * @mbg.generated
     */
    long countByExample(AvDailyChargeEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table av_daily_charge
     *
     * @mbg.generated
     */
    int insert(AvDailyChargeEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table av_daily_charge
     *
     * @mbg.generated
     */
    int insertSelective(AvDailyChargeEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table av_daily_charge
     *
     * @mbg.generated
     */
    List<AvDailyChargeEntity> selectByExample(AvDailyChargeEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table av_daily_charge
     *
     * @mbg.generated
     */
    AvDailyChargeEntity selectByPrimaryKey(Integer avDailyChargeId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table av_daily_charge
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") AvDailyChargeEntity record, @Param("example") AvDailyChargeEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table av_daily_charge
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") AvDailyChargeEntity record, @Param("example") AvDailyChargeEntityExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table av_daily_charge
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(AvDailyChargeEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table av_daily_charge
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(AvDailyChargeEntity record);
}