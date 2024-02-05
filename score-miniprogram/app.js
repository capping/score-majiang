//app.js
App({
    globalData: {
        token: null,
        is_login: false,
        avatar: null,
        nick_name: null
    },
    onLaunch: function() {
        this.checkLogin(res => {
            console.log('is_login: ', res.is_login)
            if (!res.is_login) {
                this.login()
            }
        })
    },
    login:function() {
        wx.login({
            success: (res) => {
                var code = res.code //获取code
                wx.request({ //调用后端接口
                    url: 'http://localhost:8080/api/wx_login?code=' + code,
                    method: 'GET',
                    success: (res) => {
                        wx.setStorage({
                            key: 'token',
                            data: res.data.token
                        })
                        this.globalData.token = res.data.token
                    }
                })
            },
        })
    },
    checkLogin:function(callback) {
        var token = this.globalData.token
        if (!token) {
            if (wx.getStorageSync('token')) {
                token = wx.getStorageSync('token')
                this.globalData.token = token
                wx.request({
                    url: 'http://localhost:8080/api/check_login',
                    data: {
                        token: token
                    },
                    success:(res) => {
                        callback({
                            is_login: res.data.data.is_login
                        })
                    }
                })
            } else {
                callback({is_login : false})
            }
        }
    }
})