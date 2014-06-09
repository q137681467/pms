Ext.define("core.layout.view.ButtomPanel",{
extend:"Ext.panel.Panel",
	height : 30,
	alias : 'widget.buttomview',
	border:false,
	 bbar:[{
            text:"退出系统",
            iconCls:"logout",
            handler:function(){    
                    }
            },"-",{
                    text:"在线用户",
                    iconCls:"onlineUser",
                    handler:function(){
                        //new OnlineChatWindow().show();
                    }
                   },"-",{
                    text:"修改密码",
                    iconCls:"updatePart",
                    handler:function(){
    
                    }
                },"-",{
                    pressed:false,
                    iconCls:"contact",
                    text:"与我联系",
                    handler:function(){
                  
                    }
                }
			
                    
                    
           ]
	
});	