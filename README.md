#Express Deployment Manage
#启动流程
#com.mquick.server.guice.GuiceServletConfig 对服务端的依赖进行注入
#com.mquick.client.gin.ClientModule 对服务端代码做编译时依赖注入。

#WebSocket
#com.mquick.server.websocket.DashboardSocket 用于对本服务进行协调，对本服务的管理界面推送消息。
#com.mquick.server.websocket.PingPongSocket 用于与设备端的服务驻留程序间进行消息推送。