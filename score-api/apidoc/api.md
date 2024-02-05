# API 文档
## 1.登录接口
`GET /api/wx_login?code=${code}`

Request Body
```
params code 临时登录凭证
```
Response
```
情况1：授权失败
{
    "code": 1,
    "msg", "授权失败, 请重新登录"
}

情况2：授权成功(无手机号和真实姓名)
{
    "code":0,
    "msg":"授权成功",
    "user":{
        "id":1,
        "status":0,
        "page":1,
        "tel":"",
        "openid":"odCD70IcaGH0gyA6ufcz6qhJD5V4",
        "unionid":"",
        "created_at":"2022-09-10 22:30:31",
        "updated_at":"2022-09-10 22:30:31",
        "page_size":10,
        "real_name":"",
        "user_type":0
    }
}

情况3：授权成功(带手机号和真实姓名)
{
    "code":0,
    "msg":"授权成功",
    "user":{
        "id":1,
        "status":0,
        "page":1,
        "tel":"12345678901",
        "openid":"odCD70IcaGH0gyA6ufcz6qhJD5V4",
        "unionid":"",
        "created_at":"2022-09-10 22:30:31",
        "updated_at":"2022-09-10 22:30:31",
        "page_size":10,
        "real_name":"张三",
        "user_type":0
    }
}
```

## 2.添加手机号和真实姓名
`POST /api/users/save`

Request Body
```
{
    params id 用户ID,
    params real_name 真实姓名,
    params tel 手机号
}
```
Response
```
成功
{
    "msg": "更新成功!",
    "code": 0
}
```

## 3.添加运动记录
`POST /api/sports_record/save`

Request Body
```
{
    params user_id 用户ID,
    params type 运动类型: 1-走路, 2-慢跑,
    params data 运动详细信息
}
```
Response
```
成功
{
    "msg": "新增成功!",
    "code": 0
}
```

## 4.获取测评表
`GET /api/evaluation_form?id=${id}`

Request Body
```
{
    params id 测评表ID
}
```
Response
```
成功
{
    "code":0,
    "evaluation":{
        "id":1,
        "status":0,
        "page":1,
        "name":"焦虑自评量表(SAS)",
        "question":"{\"desc\": \"答案：A 没有或很少时间;B小部分时间：C相当多时间;D绝大部分或全部时间。\", \"standard\": \"评分标淮：正向计分题A、B、C、D按1、2、3、4分计：反向计分题（标注*的题目题号：5、9、13、17、19)按4.3.2.1 计分。总分乘以 1.25 取整数，即得标准分。低于50分者为正常：50-60分者为轻度焦虑：61-70 分者为中度焦虑，70 分以上者为重度焦虑。\", \"questions\": [{\"title\": \"1. 我觉得比平时容易紧张或着急\", \"options\": [{\"score\": 1, \"option\": \"A\"}, {\"score\": 2, \"option\": \"B\"}, {\"score\": 3, \"option\": \"C\"}, {\"score\": 4, \"option\": \"D\"}]}, {\"title\": \"2. 我无缘无故在感到害怕\", \"options\": [{\"score\": 1, \"option\": \"A\"}, {\"score\": 2, \"option\": \"B\"}, {\"score\": 3, \"option\": \"C\"}, {\"score\": 4, \"option\": \"D\"}]}, {\"title\": \"3. 我容易心里烦乱或感到惊恐\", \"options\": [{\"score\": 1, \"option\": \"A\"}, {\"score\": 2, \"option\": \"B\"}, {\"score\": 3, \"option\": \"C\"}, {\"score\": 4, \"option\": \"D\"}]}, {\"title\": \"4. 我觉得我可能将要发疯\", \"options\": [{\"score\": 1, \"option\": \"A\"}, {\"score\": 2, \"option\": \"B\"}, {\"score\": 3, \"option\": \"C\"}, {\"score\": 4, \"option\": \"D\"}]}, {\"title\": \"*5. 我觉得一切都很好\", \"options\": [{\"score\": 4, \"option\": \"A\"}, {\"score\": 3, \"option\": \"B\"}, {\"score\": 2, \"option\": \"C\"}, {\"score\": 1, \"option\": \"D\"}]}, {\"title\": \"6. 我手脚发抖打颤\", \"options\": [{\"score\": 1, \"option\": \"A\"}, {\"score\": 2, \"option\": \"B\"}, {\"score\": 3, \"option\": \"C\"}, {\"score\": 4, \"option\": \"D\"}]}, {\"title\": \"7. 我因为头疼、颈痛和背痛而苦恼\", \"options\": [{\"score\": 1, \"option\": \"A\"}, {\"score\": 2, \"option\": \"B\"}, {\"score\": 3, \"option\": \"C\"}, {\"score\": 4, \"option\": \"D\"}]}, {\"title\": \"8. 我觉得容易衰弱和疲乏\", \"options\": [{\"score\": 1, \"option\": \"A\"}, {\"score\": 2, \"option\": \"B\"}, {\"score\": 3, \"option\": \"C\"}, {\"score\": 4, \"option\": \"D\"}]}, {\"title\": \"*9. 我觉得心平气和，并且容易安静坐着\", \"options\": [{\"score\": 4, \"option\": \"A\"}, {\"score\": 3, \"option\": \"B\"}, {\"score\": 2, \"option\": \"C\"}, {\"score\": 1, \"option\": \"D\"}]}, {\"title\": \"10. 我觉得心跳得很快\", \"options\": [{\"score\": 1, \"option\": \"A\"}, {\"score\": 2, \"option\": \"B\"}, {\"score\": 3, \"option\": \"C\"}, {\"score\": 4, \"option\": \"D\"}]}, {\"title\": \"11. 我因为一阵阵头晕市苦恼\", \"options\": [{\"score\": 1, \"option\": \"A\"}, {\"score\": 2, \"option\": \"B\"}, {\"score\": 3, \"option\": \"C\"}, {\"score\": 4, \"option\": \"D\"}]}, {\"title\": \"12. 我有晕倒发作，或觉得要晕倒似的\", \"options\": [{\"score\": 1, \"option\": \"A\"}, {\"score\": 2, \"option\": \"B\"}, {\"score\": 3, \"option\": \"C\"}, {\"score\": 4, \"option\": \"D\"}]}, {\"title\": \"*13. 我吸气呼气都感到很容易\", \"options\": [{\"score\": 4, \"option\": \"A\"}, {\"score\": 3, \"option\": \"B\"}, {\"score\": 2, \"option\": \"C\"}, {\"score\": 1, \"option\": \"D\"}]}, {\"title\": \"14. 我的手脚麻木和刺痛\", \"options\": [{\"score\": 1, \"option\": \"A\"}, {\"score\": 2, \"option\": \"B\"}, {\"score\": 3, \"option\": \"C\"}, {\"score\": 4, \"option\": \"D\"}]}, {\"title\": \"15. 我因为胃痛和消化不良而苦恼\", \"options\": [{\"score\": 1, \"option\": \"A\"}, {\"score\": 2, \"option\": \"B\"}, {\"score\": 3, \"option\": \"C\"}, {\"score\": 4, \"option\": \"D\"}]}, {\"title\": \"16. 我常常要小便\", \"options\": [{\"score\": 1, \"option\": \"A\"}, {\"score\": 2, \"option\": \"B\"}, {\"score\": 3, \"option\": \"C\"}, {\"score\": 4, \"option\": \"D\"}]}, {\"title\": \"*17. 我的手脚常常是干燥温暖的\", \"options\": [{\"score\": 4, \"option\": \"A\"}, {\"score\": 3, \"option\": \"B\"}, {\"score\": 2, \"option\": \"C\"}, {\"score\": 1, \"option\": \"D\"}]}, {\"title\": \"18. 我脸红发热\", \"options\": [{\"score\": 1, \"option\": \"A\"}, {\"score\": 2, \"option\": \"B\"}, {\"score\": 3, \"option\": \"C\"}, {\"score\": 4, \"option\": \"D\"}]}, {\"title\": \"*19. 我容易入睡并且一夜睡得很好\", \"options\": [{\"score\": 4, \"option\": \"A\"}, {\"score\": 3, \"option\": \"B\"}, {\"score\": 2, \"option\": \"C\"}, {\"score\": 1, \"option\": \"D\"}]}, {\"title\": \"20. 我作恶梦\", \"options\": [{\"score\": 1, \"option\": \"A\"}, {\"score\": 2, \"option\": \"B\"}, {\"score\": 3, \"option\": \"C\"}, {\"score\": 4, \"option\": \"D\"}]}]}",
        "desc":"焦虑是一种比较普遍的精神体验，长期存在焦虑反应的人易发展为焦虑症。本量表包含20个项目，分为4级评分，请您仔细阅读以下内容，根据最近一星期的情况如实回答",
        "created_at":"2022-09-11 16:12:35.0",
        "updated_at":"2022-09-11 16:12:35.0",
        "page_size":10
    }
}
```

## 5.添加测评记录
`POST /api/evaluation_record/save`

Request Body
```
{
    params user_id 用户ID,
    params evaluation_id 测评表ID,
    params data 测评表详细信息
}
```
Response
```
成功
{
    "msg": "新增成功!",
    "code": 0
}
```

# Web端接口
## 1.登录
`POST /admin/users/login`

Request Body
```
{
    params tel 手机号,
    params password 密码
}
```
Response
```
情况一: 成功
{
    "msg": "登录成功",
    "code": 0
}
情况二: 失败
{
    "msg": "手机号或密码错误",
    "code": 1
}
```
## 2.退出登录
`POST /admin/users/logout`

## 3.患者信息列表
`GET /admin/users`

Request Body
```
{
    params real_name 用户真实姓名(非必填, 模糊匹配),
    params tel 手机号(非必填, 模糊匹配),
    params start_time 开始时间(非必填),
    params end_time 结束时间(非必填),
    params page 页码(非必填, 默认:1),
    params page_size 每页大小(非必填, 默认:20)
}
```
Response
```
成功
{
    "total":1,
    "list":[
        {
            "id":1,
            "status":0,
            "page":1,
            "tel":"12345678901",
            "openid":"odCD70IcaGH0gyA6ufcz6qhJD5V4",
            "unionid":"",
            "created_at":"2022-09-10 22:30:31.0",
            "updated_at":"2022-09-11 12:13:37.0",
            "page_size":10,
            "real_name":"张si",
            "user_type":0
        }
    ],
    "pageNum":1,
    "pageSize":20,
    "size":1,
    "startRow":1,
    "endRow":1,
    "pages":1,
    "prePage":0,
    "nextPage":0,
    "isFirstPage":true,
    "isLastPage":true,
    "hasPreviousPage":false,
    "hasNextPage":false,
    "navigatePages":8,
    "navigatepageNums":[
        1
    ],
    "navigateFirstPage":1,
    "navigateLastPage":1,
    "firstPage":1,
    "lastPage":1
}
```

## 4.导出患者信息
`GET /admin/users/export`

Request Body
```
{
    params real_name 用户真实姓名(非必填, 模糊匹配),
    params tel 手机号(非必填, 模糊匹配),
    params start_time 开始时间(非必填),
    params end_time 结束时间(非必填)
}
```
Response
```
二进制流
```

## 5.测评表列表
`GET /admin/evaluation_records`

Request Body
```
{
    params real_name 用户名(非必填, 模糊查询),
    params tel 手机号(非必填, 模糊查询),
    params start_time 开始时间(非必填),
    params end_time 结束时间(非必填),
    params page 页码(非必填, 默认:1),
    params page_size 每页大小(非必填, 默认:20)
}
```
Response
```
成功
{
    "total":1,
    "list":[
        {
            "id":1,
            "status":0,
            "page":1,
            "user_id":null,
            "evaluation_id":null,
            "score":50,
            "data":"{\"standard\": \"评分标淮：正向计分题A、B、C、D按1、2、3、4分计：反向计分题（标注*的题目题号：5、9、13、17、19)按4.3.2.1 计分。总分乘以 1.25 取整数，即得标准分。低于50分者为正常：50-60分者为轻度焦虑：61-70 分者为中度焦虑，70 分以上者为重度焦虑。\", \"questions\": [{\"title\": \"1. 我觉得比平时容易紧张或着急\", \"options\": [{\"check\": 1, \"score\": 1, \"option\": \"A:没有或很少时间\"}, {\"score\": 2, \"option\": \"B:小部分时间\"}, {\"score\": 3, \"option\": \"C:相当多时间\"}, {\"score\": 4, \"option\": \"D:绝大部分或全部时间\"}]}, {\"title\": \"2. 我无缘无故在感到害怕\", \"options\": [{\"check\": 1, \"score\": 1, \"option\": \"A:没有或很少时间\"}, {\"score\": 2, \"option\": \"B:小部分时间\"}, {\"score\": 3, \"option\": \"C:相当多时间\"}, {\"score\": 4, \"option\": \"D:绝大部分或全部时间\"}]}, {\"title\": \"3. 我容易心里烦乱或感到惊恐\", \"options\": [{\"check\": 1, \"score\": 1, \"option\": \"A:没有或很少时间\"}, {\"score\": 2, \"option\": \"B:小部分时间\"}, {\"score\": 3, \"option\": \"C:相当多时间\"}, {\"score\": 4, \"option\": \"D:绝大部分或全部时间\"}]}, {\"title\": \"4. 我觉得我可能将要发疯\", \"options\": [{\"check\": 1, \"score\": 1, \"option\": \"A:没有或很少时间\"}, {\"score\": 2, \"option\": \"B:小部分时间\"}, {\"score\": 3, \"option\": \"C:相当多时间\"}, {\"score\": 4, \"option\": \"D:绝大部分或全部时间\"}]}, {\"title\": \"*5. 我觉得一切都很好\", \"options\": [{\"score\": 4, \"option\": \"A:没有或很少时间\"}, {\"score\": 3, \"option\": \"B:小部分时间\"}, {\"check\": 1, \"score\": 2, \"option\": \"C:相当多时间\"}, {\"score\": 1, \"option\": \"D:绝大部分或全部时间\"}]}, {\"title\": \"6. 我手脚发抖打颤\", \"options\": [{\"score\": 1, \"option\": \"A:没有或很少时间\"}, {\"check\": 1, \"score\": 2, \"option\": \"B:小部分时间\"}, {\"score\": 3, \"option\": \"C:相当多时间\"}, {\"score\": 4, \"option\": \"D:绝大部分或全部时间\"}]}, {\"title\": \"7. 我因为头疼、颈痛和背痛而苦恼\", \"options\": [{\"score\": 1, \"option\": \"A:没有或很少时间\"}, {\"check\": 1, \"score\": 2, \"option\": \"B:小部分时间\"}, {\"score\": 3, \"option\": \"C:相当多时间\"}, {\"score\": 4, \"option\": \"D:绝大部分或全部时间\"}]}, {\"title\": \"8. 我觉得容易衰弱和疲乏\", \"options\": [{\"score\": 1, \"option\": \"A:没有或很少时间\"}, {\"check\": 1, \"score\": 2, \"option\": \"B:小部分时间\"}, {\"score\": 3, \"option\": \"C:相当多时间\"}, {\"score\": 4, \"option\": \"D:绝大部分或全部时间\"}]}, {\"title\": \"*9. 我觉得心平气和，并且容易安静坐着\", \"options\": [{\"score\": 4, \"option\": \"A:没有或很少时间\"}, {\"check\": 1, \"score\": 3, \"option\": \"B:小部分时间\"}, {\"score\": 2, \"option\": \"C:相当多时间\"}, {\"score\": 1, \"option\": \"D:绝大部分或全部时间\"}]}, {\"title\": \"10. 我觉得心跳得很快\", \"options\": [{\"score\": 1, \"option\": \"A:没有或很少时间\"}, {\"score\": 2, \"option\": \"B:小部分时间\"}, {\"check\": 1, \"score\": 3, \"option\": \"C:相当多时间\"}, {\"score\": 4, \"option\": \"D:绝大部分或全部时间\"}]}, {\"title\": \"11. 我因为一阵阵头晕市苦恼\", \"options\": [{\"score\": 1, \"option\": \"A:没有或很少时间\"}, {\"score\": 2, \"option\": \"B:小部分时间\"}, {\"check\": 1, \"score\": 3, \"option\": \"C:相当多时间\"}, {\"score\": 4, \"option\": \"D:绝大部分或全部时间\"}]}, {\"title\": \"12. 我有晕倒发作，或觉得要晕倒似的\", \"options\": [{\"score\": 1, \"option\": \"A:没有或很少时间\"}, {\"score\": 2, \"option\": \"B:小部分时间\"}, {\"check\": 1, \"score\": 3, \"option\": \"C:相当多时间\"}, {\"score\": 4, \"option\": \"D:绝大部分或全部时间\"}]}, {\"title\": \"*13. 我吸气呼气都感到很容易\", \"options\": [{\"check\": 1, \"score\": 4, \"option\": \"A:没有或很少时间\"}, {\"score\": 3, \"option\": \"B:小部分时间\"}, {\"score\": 2, \"option\": \"C:相当多时间\"}, {\"score\": 1, \"option\": \"D:绝大部分或全部时间\"}]}, {\"title\": \"14. 我的手脚麻木和刺痛\", \"options\": [{\"score\": 1, \"option\": \"A:没有或很少时间\"}, {\"score\": 2, \"option\": \"B:小部分时间\"}, {\"score\": 3, \"option\": \"C:相当多时间\"}, {\"check\": 1, \"score\": 4, \"option\": \"D:绝大部分或全部时间\"}]}, {\"title\": \"15. 我因为胃痛和消化不良而苦恼\", \"options\": [{\"score\": 1, \"option\": \"A:没有或很少时间\"}, {\"score\": 2, \"option\": \"B:小部分时间\"}, {\"score\": 3, \"option\": \"C:相当多时间\"}, {\"check\": 1, \"score\": 4, \"option\": \"D:绝大部分或全部时间\"}]}, {\"title\": \"16. 我常常要小便\", \"options\": [{\"score\": 1, \"option\": \"A:没有或很少时间\"}, {\"score\": 2, \"option\": \"B:小部分时间\"}, {\"score\": 3, \"option\": \"C:相当多时间\"}, {\"check\": 1, \"score\": 4, \"option\": \"D:绝大部分或全部时间\"}]}, {\"title\": \"*17. 我的手脚常常是干燥温暖的\", \"options\": [{\"score\": 4, \"option\": \"A:没有或很少时间\"}, {\"score\": 3, \"option\": \"B:小部分时间\"}, {\"score\": 2, \"option\": \"C:相当多时间\"}, {\"check\": 1, \"score\": 1, \"option\": \"D:绝大部分或全部时间\"}]}, {\"title\": \"18. 我脸红发热\", \"options\": [{\"score\": 1, \"option\": \"A:没有或很少时间\"}, {\"check\": 1, \"score\": 2, \"option\": \"B:小部分时间\"}, {\"score\": 3, \"option\": \"C:相当多时间\"}, {\"score\": 4, \"option\": \"D:绝大部分或全部时间\"}]}, {\"title\": \"*19. 我容易入睡并且一夜睡得很好\", \"options\": [{\"score\": 4, \"option\": \"A:没有或很少时间\"}, {\"check\": 1, \"score\": 3, \"option\": \"B:小部分时间\"}, {\"score\": 2, \"option\": \"C:相当多时间\"}, {\"score\": 1, \"option\": \"D:绝大部分或全部时间\"}]}, {\"title\": \"20. 我作恶梦\", \"options\": [{\"score\": 1, \"option\": \"A:没有或很少时间\"}, {\"score\": 2, \"option\": \"B:小部分时间\"}, {\"score\": 3, \"option\": \"C:相当多时间\"}, {\"check\": 1, \"score\": 4, \"option\": \"D:绝大部分或全部时间\"}]}]}",
            "created_at":"2022-09-12 00:23:21.0",
            "updated_at":"2022-09-12 00:23:21.0",
            "page_size":10
        }
    ],
    "pageNum":1,
    "pageSize":20,
    "size":1,
    "startRow":1,
    "endRow":1,
    "pages":1,
    "prePage":0,
    "nextPage":0,
    "isFirstPage":true,
    "isLastPage":true,
    "hasPreviousPage":false,
    "hasNextPage":false,
    "navigatePages":8,
    "navigatepageNums":[
        1
    ],
    "navigateFirstPage":1,
    "navigateLastPage":1,
    "firstPage":1,
    "lastPage":1
}
```
## 6.导出测评表列表
`GET /admin/evaluation_records/export`

Request Body
```
{
    params real_name 用户真实姓名(非必填, 模糊匹配),
    params tel 手机号(非必填, 模糊匹配),
    params start_time 开始时间(非必填),
    params end_time 结束时间(非必填)
}
```
Response
```
二进制流
```

## 7.运动打卡列表
`GET /admin/sports_records`

Request Body
```
{
    params user_id 用户id(非必填),
    params tel 手机号(非必填),
    params start_time 开始时间(非必填),
    params end_time 结束时间(非必填),
    params page 页码(非必填, 默认:1),
    params page_size 每页大小(非必填, 默认:20)
}
```
Response
```
成功
{
    "total":1,
    "list":[
        {
            "id":1,
            "status":0,
            "page":1,
            "type":1,
            "data":"{\"run\": \"\", \"time\": \"\", \"points\": [{\"latitude\": \"\", \"longitude\": \"\"}], \"second\": \"\"}",
            "created_at":"2022-09-11 12:15:19.0",
            "updated_at":"2022-09-11 12:15:19.0",
            "page_size":10
        }
    ],
    "pageNum":1,
    "pageSize":20,
    "size":1,
    "startRow":1,
    "endRow":1,
    "pages":1,
    "prePage":0,
    "nextPage":0,
    "isFirstPage":true,
    "isLastPage":true,
    "hasPreviousPage":false,
    "hasNextPage":false,
    "navigatePages":8,
    "navigatepageNums":[
        1
    ],
    "navigateFirstPage":1,
    "navigateLastPage":1,
    "firstPage":1,
    "lastPage":1
}
```
## 8.导出运动打卡列表
`GET /admin/sports_records/export`

Request Body
```
{
    params real_name 用户真实姓名(非必填, 模糊匹配),
    params tel 手机号(非必填, 模糊匹配),
    params start_time 开始时间(非必填),
    params end_time 结束时间(非必填)
}
```
Response
```
二进制流
```