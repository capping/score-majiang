// pages/index.js
const app = getApp()

Page({
    data: {
        avatar: app.globalData.avatar, //用户头像
        theme: wx.getSystemInfoSync().theme,
        nick_name:  app.globalData.nick_name //用户昵称
    },

    //onLoad方法
    onLoad(options) {

    },

    //用户选择头像
    onChooseAvatar(e) {
        const {
            avatarUrl
        } = e.detail

        //对临时图片链接进行base64编码
        var avatarUrl_base64 = 'data:image/jpeg;base64,' + wx.getFileSystemManager().readFileSync(avatarUrl, 'base64')

        console.log(avatarUrl_base64)
        //将编码后的图片发送到服务器进行存储
        wx.request({
            url: 'http://localhost:8080/api/upload_avatar',
            method: 'POST',
            header: {
                'content-type': 'application/json',
                'token': app.globalData.token
            },
            data: {
                avatar: avatarUrl_base64, //请求体中封装编码后的图片
            },
            success(res) {
                console.log(res),
                app.globalData.avatar = avatarUrl_base64
            }
        })
    },

    //获取用户昵称
    getNickName(e) {
        var nick_name = e.detail.value
        wx.request({
            url: 'http://localhost:8080/api/users/update',
            method: 'PATCH',
            header: {
                'content-type': 'application/json',
                'token': app.globalData.token
            },
            data: {
                nick_name: nick_name, //请求体中封装编码后的图片
            },
            success(res) {
                console.log(res)
                app.globalData.nick_name = nick_name
            }
        })
    },

    register() {
        wx.request({
            url: 'http://localhost:8080/api/user_info',
            method: 'GET',
            header: {
                'content-type': 'application/json',
                'token': app.globalData.token
            },
            success(res) {
                if (res.data.data.avatar.length > 0 && res.data.data.nick_name.length > 0) {
                    console.log("准备跳转")
                    wx.redirectTo({
                      url: '../index/index',
                    })
                }
            }
        })
    }
})
