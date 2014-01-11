<h3>Express Deployment Manage</h3>
<h4>概述</h4>
本项目是基于GWTP，意图构造一个通过websocket接收终端发起的websocket链接。并展现这些终端的基本信息。
<h4>启动流程</h4>
<ul>
<li>com.mquick.server.guice.GuiceServletConfig 对服务端的依赖进行注入</li>
<li>com.mquick.client.gin.ClientModule 对服务端代码做编译时依赖注入。</li>
</ul>
<h4>WebSocket</h4>
<ul>
<li>com.mquick.server.websocket.DashboardSocket 用于对本服务进行协调，对本服务的管理界面推送消息。</li>
<li>com.mquick.server.websocket.PingPongSocket 用于与设备端的服务驻留程序间进行消息推送。</li>
</ul>
