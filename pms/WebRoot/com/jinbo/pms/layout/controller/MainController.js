Ext.define("core.layout.controller.MainController", {
	extend : "Ext.app.Controller",
			init : function() {
				var self = this;
				/**
				 * 动态加载controller并渲染它的主窗体
				 */
				this.addFunItem=function(funInfo){
					if(funInfo){
						var mainView=funInfo.mainView;
						var funPanel=mainView.down(funInfo.funViewXtype);
						if(!funPanel){
							self.application.getController(funInfo.funController).init();
							funPanel=Ext.create(funInfo.funViewName);
							mainView.add(funPanel);
							mainView.setActiveTab(funPanel);
						}else{									
							mainView.setActiveTab(funPanel);
						}
					}
				},
			//	Ext.create("core.layout.view.LoginWindow").show();
				this.control({
					"westview treepanel":{
						itemclick:function(tree,record,item,index,e,eOpts){
							var mainView=tree.up("mainview").down("centerview");
							/**部门人员管理*/
							if(record.data["id"]=="dept-user"){
								self.addFunItem({
									mainView:mainView,
									funViewXtype:"userlayout",
									funController:"core.user.controller.UserController",
									funViewName:"core.user.view.UserLayout"
								});
							/**角色人员管理*/
							}else if(record.data["id"]=="role-user"){
								self.addFunItem({
									mainView:mainView,
									funViewXtype:"rolelayout",
									funController:"core.user.controller.RoleController",
									funViewName:"core.user.view.RoleLayout"
								});
							}else if(record.data["id"]=="deployment"){
								self.addFunItem({
									mainView:mainView,
									funViewXtype:"deploylayout",
									funController:"core.jbpm.controller.WfDeployController",
									funViewName:"core.jbpm.view.DeployLayout"
								});
							}else if(record.data["id"]=="process"){
								self.addFunItem({
									mainView:mainView,
									funViewXtype:"processlayout",
									funController:"core.jbpm.controller.WfProcessController",
									funViewName:"core.jbpm.view.ProcessLayout"
								});
							}else if(record.data["id"]=="borrowMoney"){
								self.addFunItem({
									mainView:mainView,
									funViewXtype:"borrowlayout",
									funController:"core.oa.controller.BorrowMoneyController",
									funViewName:"core.oa.view.BorrowLayout"
								});
							}
						}
					},
					"topview button[ref=login]":{
							click:function(btn){
								var window=Ext.getCmp("loginwindow");
								if(window){
									window.show();
								}else{
									Ext.create("core.app.view.LoginWindow").show();
								}
							}
						},
					"topview button[ref=exit]":{
							click:function(btn){
								var form=Ext.getCmp("loginwindow").down("form[ref=loginform]").getForm();
					 			var userName=form.findField("userName").getValue();
					 			var passWord=form.findField("password").getValue();
								Ext.Ajax.request({
								url:"/jbpmItem/pc/userAction!exit.action",
								params:{userCode:userName,passWord:passWord},
								method:"POST",
								timeout:4000,
								success:function(response,opts){
									var resObj=Ext.decode(response.responseText);
									if(resObj.success){
										var dis=Ext.getCmp("displaylogin");
										dis.setValue("<font color=white><b>未登录</b></font>");
										dis.up("mainview").down("taskjobgrid").getStore().load();
										Ext.Msg.alert("提示",resObj.obj);
									}else{
										Ext.Msg.alert("提示",resObj.obj);
									}
								
								}
								});
							}
						},
					 "loginwindow button[ref=login]":{
					 	click:function(btn){
					 		var form=btn.up("form[ref=loginform]").getForm();
					 		var userName=form.findField("userName").getValue();
					 		var passWord=form.findField("password").getValue();
					 		Ext.Ajax.request({
								url:"/jbpmItem/pc/userAction!login.action",
								params:{userCode:userName,passWord:passWord},
								method:"POST",
								timeout:4000,
								success:function(response,opts){
									var resObj=Ext.decode(response.responseText);
									if(resObj.success){
										var userObj=resObj.obj;
										var dis=Ext.getCmp("displaylogin");
										dis.up("mainview").down("taskjobgrid").getStore().load();
										dis.setValue("<font color=white><b>"+userObj.userName+"->"+userObj.deptName+"</b></font>");
										btn.up("loginwindow").close();
									}else{
										Ext.Msg.alert("提示",resObj.obj);
									}
								}
					 		});
					 	}
					 }
				});
			},
			views : ["core.layout.view.CenterView", "core.layout.view.WestView","core.layout.view.ButtomPanel","core.layout.view.TopView", "core.layout.view.MainView","core.layout.view.LoginWindow","core.layout.view.TaskJobGrid"],
			stores : ["core.layout.store.TaskJobStore"],
			models : ["core.layout.model.TaskJobModel"]
});

						