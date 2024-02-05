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

package com.sevengod.score.controller;

import com.sevengod.score.model.SportsRecord;
import com.sevengod.score.service.SportsRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Seven God
 * @since 2022-09-11 11:47
 */
@RestController
@RequestMapping("/api")
public class SportsRecordController {

    @Autowired
    private SportsRecordService sportsRecordService;

    @RequestMapping(value = "/sports_record/save", method = RequestMethod.POST)
    public ModelMap save(@RequestBody SportsRecord sportsRecord) {
        ModelMap result = new ModelMap();
        if (sportsRecord.getType() == null) {
            result.put("msg", "请选择走路还是慢跑");
            result.put("code", 1);
            return  result;
        }
        if (sportsRecord.getData() == null) {
            result.put("msg", "请运动");
            result.put("code", 1);
            return  result;
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sportsRecord.setCreatedAt(df.format(new Date()));
        String msg = sportsRecord.getId() == null ? "新增成功!" : "更新成功!";
        sportsRecordService.save(sportsRecord);
        result.put("msg", msg);
        result.put("code", 0);
        return result;
    }
}
