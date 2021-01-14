$(function(){
	searchCcTable();
	
	$("#ccRuleForm").validate({
		submitHandler:function(form){
			saveCcConfigInfo();
		}
	});
});

function search(){
	searchCcTable();
}

function tableParams(params) {
	return {
		offset: params.offset,  
	    limit: params.limit,
	    name: $("#domain").val()
	};
}


function searchCcTable() {
	$("#ccConfigTab").bootstrapTable('destroy').bootstrapTable({
	  	contentType: "application/x-www-form-urlencoded", 
	  	method: 'post', 
	  	dataType: "json",  
		url: "cc/list",
		striped: true,                      //是否显示行间隔色
	    pagination: true,                   //是否显示分页（*）
	    sortable: false,                    //是否启用排序
	    sortOrder: "asc",                   //排序方式
	    sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
	    pageNumber: 1,                      //初始化加载第一页，默认第一页
	    pageSize: 5,                        //每页的记录行数（*）
	    pageList: [5, 10, 20, 100],      	//可供选择的每页的行数（*）
	    minimumCountColumns: 10,            //最少允许的列数
	    queryParams: tableParams, 
	    columns: [{
	        field: "wciRuleName",
	        title: "规则名称",
	        width : $(this).width() * 0.15
	    },  {
	        field: "wciUrl",
	        title: "URL",
	        width : $(this).width() * 0.20
	    },  {
	    	field: "wciDuration",
	    	title: "检测时长/秒",
	    	width : $(this).width() * 0.08
	    },  {
	    	field: "wciIpCount",
	    	title: "单一IP访问次数",
	    	width : $(this).width() * 0.08
	    },  {
	    	field: "wciRuleInfo",
	    	title: "匹配规则",
	    	width : $(this).width() * 0.15,
	    	formatter : function(value) {
	    		if(value==0){
		    		  return "<font color='#00a3b2'>完全匹配</font>";
		    	  }else if(value==1){
		    		  return "<font color='#00a3b2'>前缀匹配</font>";
		    	  }
	    	}
	    },  {
	    	field: "wciMovement",
	    	title: "阻断类型",
	    	width : $(this).width() * 0.08,
	    	formatter : function(value) {
	    		if(value==0){
		    		  return "<font color='#00a3b2'>封禁</font>";
		    	  }else if(value==1){
		    		  return "<font color='#00a3b2'>人机识别</font>";
		    	  }
	    	}
	    },  {
	    	field: "wciTime",
	    	title: "封禁时长",
	    	width : $(this).width() * 0.08
	    },  {
	        field: "action",
	        title: "操作",
	        formatter : function(value,row,index) {
            	return 	" <button type='button'  onclick='updateCcConfigInfo("+JSON.stringify(row)+")' class='btn yellow-bg btn-xs'\">编辑</button>"+
            	        " <button type='button' onclick='deleteCcConfigInfo("+row.wciId+")' class='btn btn-danger btn-xs'\">删除</button>";
			}
	    }]
	});
}

function addRule(){
	$('#id').val(""),
	$("#ccRuleForm")[0].reset();
	$("#ccRuleModal").modal("show");
}

function updateCcConfigInfo(obj){

	$("#ccRuleForm")[0].reset();
	$(".wciRuleInfo").attr("checked", false);
	$(".wciMovement").attr("checked", false);
	
    if(obj.wciRuleInfo==0){
    	$(".wciRuleInfo").eq(0).prop("checked",true);
	}else {
		$(".wciRuleInfo").eq(1).prop("checked",true);
	}
    if(obj.wciMovement==0){
    	$(".wciMovement").eq(0).prop("checked",true);
    }else {
    	$(".wciMovement").eq(1).prop("checked",true);
    }
    
	$('#id').val(obj.wciId),
	$('#wciRuleName').val(obj.wciRuleName),
	$('#wciUrl').val(obj.wciUrl),
	$('#wciDuration').val(obj.wciDuration),
	$('#wciIpCount').val(obj.wciIpCount),
	$('#wciTime').val(obj.wciTime),
	
	$("#ccRuleModal").modal("show");
}

//保存
function saveCcConfigInfo(){
	$(".save").attr("disabled",true);
	var wciRuleInfo,wciMovement;
	var type = $('input[name="wciRuleInfo"]:checked').val();
	if(type == "0" ){
		wciRuleInfo ="0";
	}else{
		wciRuleInfo ="1";
	}
	var type = $('input[name="wciMovement"]:checked').val();
	if(type == "0" ){
		wciMovement ="0";
	}else{
		wciMovement ="1";
	}
	var postdata = {
		wciId : $('#id').val(),
		wciRuleName : $('#wciRuleName').val(),
		wciUrl : $('#wciUrl').val(),	
		wciRuleInfo : wciRuleInfo,	
		wciDuration : $('#wciDuration').val(),	
		wciIpCount : $('#wciIpCount').val(),	
		wciMovement : wciMovement,	
		wciTime : $('#wciTime').val(),	
	};
	$.post("cc/up", postdata, function(data) {
		$(".save").attr("disabled",false);
		if (data == "OK") {
			$("#ccRuleModal").modal("hide");
			swal("提示信息","保存成功","success");
			$("#ccConfigTab").bootstrapTable("refresh");
		} else{
			swal("提示信息",data.toString(),"error");
		}
	});
}

//删除
function deleteCcConfigInfo(wciId){
	swal({   
		title: "确定删除吗？",
		text: "你将无法恢复！",
		type: "warning",
		showCancelButton: true,
		confirmButtonColor: "#DD6B55",
		confirmButtonText: "确定删除！",
		closeOnConfirm: false 
	},function(){
		$.post("cc/del", {wciId:wciId}, function(data) {
			if (data == "OK") {
				swal("提示信息","删除成功","success");
				$("#ccConfigTab").bootstrapTable("refresh");
			}else if(data == "NO"){
				swal("提示信息","删除失败,已有域名绑定该规则","warning");
			}else{
				swal("提示信息",data.toString(),"error");
			}
		});
	});
}