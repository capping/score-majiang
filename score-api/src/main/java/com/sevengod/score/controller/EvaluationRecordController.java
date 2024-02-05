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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevengod.score.model.EvaluationRecord;
import com.sevengod.score.pojo.Evaluation;
import com.sevengod.score.pojo.Options;
import com.sevengod.score.pojo.Questions;
import com.sevengod.score.service.EvaluationRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Seven God
 * @since 2022-09-11 11:47
 */
@RestController
@RequestMapping("/api")
public class EvaluationRecordController {

    @Autowired
    private EvaluationRecordService evaluationRecordService;

    @RequestMapping(value = "/evaluation_record/save", method = RequestMethod.POST)
    public ModelMap save(@RequestBody @Validated EvaluationRecord evaluationRecord) throws IOException {
        ModelMap result = new ModelMap();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        evaluationRecord.setCreatedAt(df.format(new Date()));
        String msg = evaluationRecord.getId() == null ? "新增成功!" : "更新成功!";
        String data = evaluationRecord.getData();

        ObjectMapper objectMapper = new ObjectMapper();
        Evaluation evaluation = objectMapper.readValue(data, Evaluation.class);
        Questions[] questions = evaluation.getQuestions();
        int score = 0;
        for (Questions question : questions) {
            Options[] options = question.getOptions();
            for (Options option : options) {
                if (option.getCheck() == null) {
                    continue;
                } else if (option.getCheck() == 1) {
                    score += option.getScore();
                }
            }
        }

        evaluationRecord.setScore(score);
        evaluationRecordService.save(evaluationRecord);
        result.put("msg", msg);
        result.put("code", 0);
        return result;
    }
}
