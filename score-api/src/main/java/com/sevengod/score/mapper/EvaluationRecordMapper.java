/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2022 z.capping@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.sevengod.score.mapper;

import com.sevengod.score.domain.vo.EvaluationRecordVo;
import com.sevengod.score.model.EvaluationRecord;
import com.sevengod.score.util.MyMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Seven God
 * @since 2022-09-11 22:33
 */
public interface EvaluationRecordMapper extends MyMapper<EvaluationRecord> {
    @Select("<script>"
            + "SELECT * "
            + "FROM evaluation_record t1 "
            + "LEFT JOIN user t2 ON t1.user_id = t2.id "
            + "WHERE t1.status = 0 "
            +"<if test='realName != null and realName != &quot;&quot;'>"
            + "AND real_name LIKE CONCAT(#{realName},'%') "
            +"</if>"
            +"<if test='tel != null and tel != &quot;&quot;'>"
            + "AND tel LIKE CONCAT(#{tel},'%') "
            +"</if>"
            +"<if test='startTime != null and startTime != &quot;&quot;'>"
            + "AND t1.created_at >= #{startTime} "
            +"</if>"
            +"<if test='endTime != null and endTime != &quot;&quot;'>"
            + "AND t1.created_at &lt;= #{endTime} "
            +"</if>"
            + "ORDER BY t1.id DESC "
            +"<bind name='key_offset' value='(page - 1) * pageSize'>"
            + "LIMIT #{key_offset}, #{pageSize}"
            +"</bind>"
            + "</script>")
    List<EvaluationRecordVo> search(String realName, String tel, String startTime, String endTime, Integer page, Integer pageSize);

    @Select("<script>"
            + "SELECT * "
            + "FROM evaluation_record t1 "
            + "LEFT JOIN user t2 ON t1.user_id = t2.id "
            + "WHERE t1.status = 0 "
            +"<if test='realName != null and realName != &quot;&quot;'>"
            + "AND real_name LIKE CONCAT(#{realName},'%') "
            +"</if>"
            +"<if test='tel != null and tel != &quot;&quot;'>"
            + "AND tel LIKE CONCAT(#{tel},'%') "
            +"</if>"
            +"<if test='startTime != null and startTime != &quot;&quot;'>"
            + "AND t1.created_at >= #{startTime} "
            +"</if>"
            +"<if test='endTime != null and endTime != &quot;&quot;'>"
            + "AND t1.created_at &lt;= #{endTime} "
            +"</if>"
            + "ORDER BY t1.id DESC "
            + "</script>")
    List<EvaluationRecordVo> export(String realName, String tel, String startTime, String endTime);
}