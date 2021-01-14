
$(function(){
	view();
	 $.getJSON("config/sessionCom", function(data) {
		$("#domainSelect").empty();
		var option = "";
		var i = 0;
		for (i in data) {
			option = option + "<option value="+data[i].id+">" + data[i].text + "</option>";
		}
		$("#domainSelect").append(option);
	});
});

//查看赋值
function view(){
	if(pageId != -1){
		pageType="update";
		$.getJSON("config/info",{id:pageId}, function(data) {
			$("#domainSelect").empty();
			var option = "<option value="+data.domainId+">" + data.domainName + "</option>";
			$("#domainSelect").append(option);
			$("#domainSelect").attr("disabled","disabled");
			if(data.webStatus=='Y'){
				$("#webCheck").attr("checked",true)
			}
			if(data.ccStatus=='Y'){
				$("#ccCheck").attr("checked",true)
				$("#ccRuleIds").val(data.ccRuleIds)
				$("#ccRuleNames").text(data.ccRuleNames)
			}
			if(data.exactStatus=='Y'){
				$("#exactCheck").attr("checked",true)
				$("#exactRuleIds").val(data.exactRuleIds)
				$("#exactRuleNames").text(data.exactRuleNames)
			}
			if(data.ipStatus=='Y'){
				$("#ipCheck").attr("checked",true)
				$("#ipSegment").val(data.ipSegment)
				$("#ipInput").css("display","block");
			}else{
				$("#ipInput").css("display","none");
			}
		});
	}else{
		pageType="add";
	}
}


//保存or更新
function saveDomainConfig() {
	var web;
	var cc;
	var exact;
	var ip;
	if ($("#webCheck").is(":checked")) {
		web ="Y";
	} else {
		web ="N";
	}
	if ($("#ccCheck").is(":checked")) {
		cc ="Y";
		if($("#ccRuleIds").val()==''){
			swal({
				title:"cc规则为空",
				text:"",
				type:"warning",
			});
			return;
		}
	} else {
		cc ="N";
	} 
	if ($("#exactCheck").is(":checked")) {
		exact ="Y";
		if($("#exactRuleIds").val()==''){
			swal({
				title:"精准打击规则为空",
				text:"",
				type:"warning",
			});
			return;
		}
	} else {
		exact ="N";
	} 
	if ($("#ipCheck").is(":checked")== true) {
		ip ="Y";
		if($("#ipSegment").val()==''){
			swal({
				title:"ip为空",
				text:"",
				type:"warning",
			});
			return;
		}
	} else {
		ip ="N";
	} 
	var postData ={
		domainId: $("#domainSelect").val(),             
		domainName: $("#domainSelect").find("option:selected").text(),  
		webStatus : web,          
		ccStatus : cc,              
		ccRuleIds :  $("#ccRuleIds").val(),     
		exactStatus : exact,           
		exactRuleIds :$("#exactRuleIds").val(),              
		ipStatus : ip,              
		ipSegment : $("#ipSegment").val(),  
		type : pageType
	};
	$.post("config/up",postData, function(data) {
		if(data=="OK"){
			swal({
				title:"保存成功",
				text:"",
				type:"success",
			});
			window.location.href="javascript:history.go(-1)";
		}else{
			swal({
				title:"保存失败",
				text:"",
				type:"error",
			});
		}
	});
}

//左右选择框
function refreshRule(type) {
	$("#selrule").empty();
	$("#unrule").empty();
	$.getJSON("config/ruleList",{domainId:$("#domainSelect").val(),type:type},function(data) {
		var array = eval(data);
		$.each(array, function(index, obj) {
			if(obj.flag) {
				$("#selrule").append(
						"<option value='" + obj.ruleId + "'>" + obj.ruleName + "</option>");
			} else {
				$("#unrule").append(
						"<option value='" + obj.ruleId + "'>" + obj.ruleName + "</option>");
			}
		});
	});
	$("#ruleType").val(type);
	$("#ccRuleModal").modal("show");
	
}


//保存左右选择框
function saveRule(){
	var array = new Array();
	var arrayName = new Array();
	$('#selrule option').each(function() {
		if($(this).css('display')!='none'){//判断是否有隐藏列
			array.push($(this).val());
			arrayName.push($(this).text());
	    }
	});
	if($("#ruleType").val()=='cc'){
		$("#ccRuleIds").val(array.toString())
		$("#ccRuleNames").text(arrayName.toString())
	}else{
		$("#exactRuleIds").val(array.toString())
		$("#exactRuleNames").text(arrayName.toString())
	}
	swal({
		title:"保存成功",
		text:"",
		type:"success",
	});
	$("#ccRuleModal").modal("hide");
}
