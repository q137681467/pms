Ext.define("core.layout.view.TopView", {
	extend:"Ext.panel.Panel",
	alias : 'widget.topview',
	id:"topview",
	height : 50,
	id:"app-header",
	bodyStyle : {
			background:"url('../images/bg.gif') repeat-x",
		height:60,
		width:100
	},
	//html : "<h1>  <font color=bule size=5>&nbsp;&nbsp;&nbsp;&nbsp;GBWM平台</font></h1><p >欢迎[ admin | 组织架构 ]登录系统</p>",
	html:"<div style='height:100%'>" +
			"<div style='width:500px;height:100%;float:left'>GBWM平台</div>" +
			"<div style='height:100%;text-align:right'>欢迎[ admin | 组织架构 ]登录系统</div>"+
			"</div>",
	iconCls:"app-header2"

})
