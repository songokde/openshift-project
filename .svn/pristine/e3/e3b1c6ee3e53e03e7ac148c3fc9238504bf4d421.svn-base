$(function(){
	table();
});

function searchDomain(){
	table();
}

//表格查询条件  
function gravidaTableParams(params) {
     return {  
        offset: params.offset,  
        limit: params.limit,
        domain: $('#search').val()
     };  
}

function table() {
	$("#domainProtectionTab").bootstrapTable('destroy').bootstrapTable({
	  	contentType: "application/x-www-form-urlencoded", 
	  	url: "config/list",
	    striped: true,  
	    pagination: false,  
	    singleSelect: false,  
	    clickToSelect:true,  
	    showColumns: false,  
	    search: false,   
	    silent: true,  
	    pageSize: 5,  
	    pageNumber:1, 
	    sidePagination: "server",  
	    pageList:[10, 25, 50, 100],  
	    queryParams: gravidaTableParams,       
	    columns: [{
	        field: "wdiDname",
	        title: "域名名称",
	        width : $(this).width() * 0.15
	    },  {
	        field: "wdiWebShield",
	        title: "WEB攻击防护",
	        width : $(this).width() * 0.15,
	        formatter : function(value) {
	        	if(value=="N"){
	        		return "<a class='btn btn-xs btn-danger' >关闭</a>";
	        	}else{
	        		return "<a class='btn btn-xs btn-success' >开启</a>";
	        	}
			}
	    },  {
	    	field: "wdiCcIds",
	    	title: "cc防护状态",
	    	width : $(this).width() * 0.15,
	    	formatter : function(value) {
	    		if(value==null || value==""){
	        		return "<a class='btn btn-xs btn-danger' >关闭</a>";
	        	}else{
	        		return "<a class='btn btn-xs btn-success' >开启</a>";
	        	}
			}
	    },  {
	    	field: "wdiExactIds",
	    	title: "精准打击状态",
	    	width : $(this).width() * 0.15,
	    	formatter : function(value) {
	    		if(value==null || value==""){
	        		return "<a class='btn btn-xs btn-danger' >关闭</a>";
	        	}else{
	        		return "<a class='btn btn-xs btn-success' >开启</a>";
	        	}
			}
	    },  {
	    	field: "wdiIpSegment",
	    	title: "ip禁用状态",
	    	width : $(this).width() * 0.15,
	    	formatter : function(value) {
	        	if(value==null || value==""){
	        		return "<a class='btn btn-xs btn-danger' >关闭</a>";
	        	}else{
	        		return "<a class='btn btn-xs btn-success' >开启</a>";
	        	}
			}
	    },  {
	        field: "opt",
	        title: "操作",
	        formatter : function(value,row,index) {
            	return 	" <button type='button' class='btn btn-info btn-xs'  onclick='protectionConfig("+row.wdiDniId+")'\">防护配置</button>";
			}
	    }]
	});
}

//跳转
function protectionConfig(id){
	location.href="config/webProtection?param1="+id;
}
