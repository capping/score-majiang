// pages/index.js
const app = getApp()

Page({

  /**
   * 页面的初始数据
   */
    data: {
        avatar: app.globalData.avatar, //用户头像
        theme: wx.getSystemInfoSync().theme,
        nick_name:  app.globalData.nick_name //用户昵称
    },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {
    this.getUserInfo()
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow() {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage() {

  },
  getUserInfo:function() {
    // 获取登录用户的信息
    wx.request({
        url: 'http://localhost:8080/api/user_info',
        method: 'GET',
        header: {
            'content-type': 'application/json',
            'token': app.globalData.token
        },
        success(res) {
            if (res.data.data.avatar.length > 0 && res.data.data.nick_name.length > 0) {
                app.globalData.avatar = res.data.data.avatar
                app.globalData.nick_name = res.data.data.nick_name
            }
        }
    })
}
})