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

package com.sevengod.score.service;

import com.github.pagehelper.PageHelper;
import com.sevengod.score.domain.vo.SportsRecordVo;
import com.sevengod.score.mapper.SportsRecordMapper;
import com.sevengod.score.model.SportsRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author Seven God
 * @since 2022-01-31 21:42
 */
@Service
public class SportsRecordService {

    @Autowired
    private SportsRecordMapper sportsRecordMapper;

    public void save(SportsRecord sportsRecord) {
        if (sportsRecord.getId() != null) {
            sportsRecordMapper.updateByPrimaryKeySelective(sportsRecord);
        } else {
            sportsRecordMapper.insert(sportsRecord);
        }
    }

    public List<SportsRecordVo> getAll(String realName, String tel, String startTime, String endTime, Integer page, Integer pageSize) {
        if (page != null && pageSize != null) {
            PageHelper.startPage(page, pageSize);
        }
        return sportsRecordMapper.search(realName, tel, startTime, endTime, page, pageSize);
    }

    public List<SportsRecordVo> export(String realName, String tel, String startTime, String endTime) {
        return sportsRecordMapper.export(realName, tel, startTime, endTime);
    }
}
