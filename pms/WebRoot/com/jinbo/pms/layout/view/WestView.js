/**
 * 宸﹁竟閮ㄥ垎
 */
Ext.define("core.layout.view.WestView",{
	extend: 'Ext.panel.Panel',
	alias: 'widget.westview',
	collapsible: true,
	split: true,
	defaults: {
		bodyStyle: 'padding:2px'
	}, 	
	border:1,
	margins: '2 2 0 0',
	width: 180,
	minSize: 100,
	maxSize: 250,
	title:"功能菜单",
	iconCls:"menucls",
	layout : 'accordion',
	layoutConfig :{
				titleCollapse: false,
				animate: true,
				activeOnTop: true
			},
	items:[{
		title:"组织角色管理",
		
		items:[{
			xtype:"treepanel",
			rootVisible : false,// 不展示根节点
			displayField : "text",			
			border:0,
			root: {
	       	 	expanded: true,
	        	children: [{ 
	            		text: "用户管理",
	            		iconCls:"usernamemanager",
	            		//icon:"/gbwm/plug-in/mycs/images/j_username.gif",
	            		id:"dept-user",
	            	 	leaf: true 
	            	},{
	            		text: "角色管理",
	            		iconCls:"rolecls",
	            		id:"role-user1",
	            	 	leaf: true             		
	            	},{
	            		text: "部门管理",
	            		iconCls:"departcls",
	            		id:"role-user",
	            	 	leaf: true             		
	            	}
	        	]
    		}
		}]
	},{
		title:"系统管理",
		items:[{
			xtype:"treepanel",
			rootVisible : false,// 不展示根节点
			displayField : "text",
			border:0,
			root: {
	       	 	expanded: true,
	        	children: [
	            	{ 
	            		id:"deploymen2t",
	            		text: "异常监控", 
	            	 	leaf: true 
	            	},
	            	{ 
	            		id:"deploymen2t3",
	            		text: "服务器管理", 
	            	 	leaf: true 
	            	},{ 
	            		id:"deploymen25t",
	            		text: "内存使用", 
	            	 	leaf: true 
	            	},{ 
	            		id:"process3",
	            		text: "操作日志", 
	            	 	leaf: true 
	            	},{ 
	            		id:"process5",
	            		text: "数据库管理", 
	            	 	leaf: true 
	            	},{ 
	            		id:"process6",
	            		text: "字典维护", 
	            	 	leaf: true 
	            	},{ 
	            		id:"process7",
	            		text: "菜单维护", 
	            	 	leaf: true 
	            	}
	        	]
    		}
		}]
	},{
		title:"在线开发",
		items:[{
			xtype:"treepanel",
			rootVisible : false,// 不展示根节点
			displayField : "text",
			border:0,
			root: {
	       	 	expanded: true,
	        	children: [
	            	{ 
	            		id:"borrowMoney1",
	            		text: "模型开发", 
	            	 	leaf: true 
	            	},{ 
	            		id:"borrowMoney2",
	            		text: "UI设计", 
	            	 	leaf: true 
	            	},{ 
	            		id:"borrowMoney3",
	            		text: "控制器生成", 
	            	 	leaf: true 
	            	},{
	            	   	id:"borrowMoney4",
	            		text: "运行配置", 
	            	 	leaf: true 
	            	}
	        	]
    		}
		}]
	}],
    initComponent: function(){
        this.callParent(arguments);
    }
});



