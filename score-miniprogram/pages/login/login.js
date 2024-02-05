Page({

    data: {

    },

    login() {
        wx.login({
            success: (res) => {
                console.log(res)
                var code = res.code //获取code
                wx.request({ //调用后端接口
                    url: 'http://localhost:8080/api/wx_login?code=' + code,
                    method: 'GET',
                    success(res) {
                        console.log(res)
                        //页面跳转
                        wx.navigateTo({
                            //携带用户头像信息和用户昵称信息
                            url: '/index/index?userAvatarUrl=' + res.data.data.userAvatarUrl + '&userName=' + res.data.data.userName,
                        })
                    }
                })
            },
        })
    }
})