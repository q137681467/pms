/*
 * ClassName 用户数据集
 */
 Ext.define("core.layout.store.TaskJobStore",{
 	extend:'Ext.data.Store',
	model:'core.layout.model.TaskJobModel',
	pageSize:10,
	proxy:{
		type:"ajax",
		url:"/jbpmItem/pc/wfTaskAction!getCurrentUserTasks.action",
		reader:{
			type:"json",
			root:"rows",
			totalProperty :'totalCount'		
		},
		writer:{
			type:"json"
		}
	},
	autoLoad:true	
 });