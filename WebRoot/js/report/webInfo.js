$(function () {
	$.getJSON("config/combox", function(data) {
		$("#domain_select").empty();
		var option = "";
		var i = 0;
		for (i in data) {
			option = option + "<option value="+data[i].id+">" + data[i].text + "</option>";
		}
		$("#domain_select").append(option);
		$("#type_select").val(pageType);
		searchTab();
		showChart();
		findCount();
	});
});


function search(){
	findCount();
	searchTab();
	showChart();
	showAreaChart();
	showCodeChart();
	showChartBandWidth();
	
}

function findCount(){
	$("#allCount").html(0);
	$("#ipCount").html(0);
	$("#urlCount").html(0);
	$.post("over/reportMap",{domainId: $('#domain_select').val(),type:$("#type_select").val(),beginTime :$('#begin').val(),endTime :$('#end').val()}, function(data) {
		$("#allCount").html(data.count);
		$("#ipCount").html(data.ipCount);
		$("#urlCount").html(data.urlCount);
	});
}

//表格查询条件  
function gravidaTableParams(params) {
	return {  
		domainId: $('#domain_select').val(),
		type:$('#type_select').val(),
		beginTime :$('#begin').val(),
		endTime :$('#end').val()
     };  
}

function searchTab(){
	$("#attackIpTab").bootstrapTable('destroy').bootstrapTable({
	  	contentType: "application/x-www-form-urlencoded", 
	  	url: "over/ipList",
	    striped: true,  
	    pagination: false,  
	    singleSelect: false,  
	    clickToSelect:true,  
	    showColumns: false,  
	    search: false,   
	    silent: true,  
	    pageSize: 5,  
	    pageNumber:1, 
	    sidePagination: "client",  
	    pageList:[10, 25, 50, 100],  
	    queryParams: gravidaTableParams,
        columns: [{
            field: "waiAttackIp",
            title: "攻击IP",
            width : $(this).width() * 0.15
        },  {
            field: "waiNodeIp",
            title: "被攻击IP",
            width : $(this).width() * 0.15
        },  {
        	field: "waiTimeStamp",
        	title: "最后一次攻击时间",
        	width : $(this).width() * 0.20,
        	formatter : function(value) {
        		 var date = new Date(value);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
    		     var Y = date.getFullYear() + '-';
    		     var M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
    		     var D = date.getDate() + ' ';
    		     var h = date.getHours() + ':';
    		     var m = date.getMinutes() + ':';
    		     var s = date.getSeconds();
    		     return Y + M + D + h + m + s;
			}
        	
        },  {
        	field: "waiCount",
        	title: "攻击次数",
        	width : $(this).width() * 0.15
        },  {
            field: "ratio",
            title: "操作",
            formatter : function() {
            	return 	" <button type='button' class='btn' onclick ='showDetail("+JSON.stringify(row)+")'\">查看攻击详情</button>";
			}
        }]
    });
}

function showDetail(data){
	$("#attackDetailModal").modal("show");
	$("#webDetailTab").bootstrapTable('destroy').bootstrapTable({
		data: data,
	    striped: true,  
	    pagination: false,  
	    singleSelect: false,  
	    clickToSelect:true,  
	    showColumns: false,  
	    search: false,   
	    silent: true,  
	    pageSize: 5,  
	    pageNumber:1, 
	    sidePagination: "client",  
	    pageList:[10, 25, 50, 100],  
       columns: [{
           field: "waiTimeStamp",
           title: "攻击时间",
           width : $(this).width() * 0.15,
           formatter : function(value) {
      		 var date = new Date(value);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
  		     var Y = date.getFullYear() + '-';
  		     var M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
  		     var D = date.getDate() + ' ';
  		     var h = date.getHours() + ':';
  		     var m = date.getMinutes() + ':';
  		     var s = date.getSeconds();
  		     return Y + M + D + h + m + s;
			}
       },  {
           field: "waiAttackIp",
           title: "攻击IP",
           width : $(this).width() * 0.15
       },  {
	   	   field: "waiType",
	       title: "类型",
	       width : $(this).width() * 0.20,
	       formatter : function(value) {
	    	   if(value ==0){
	    		   return "WEB攻击";
	    	   }else if(value ==1){
	    		   return "CC攻击";
	    	   }else{
	    		   return "精准防护";
	    	   }
		   }
       },  {
       	   field: "waiMethod",
       	   title: "攻击方式",
           width : $(this).width() * 0.15,
           formatter : function(value) {
	    	   return "sql注入"
		   }
       },  {
       	   field: "waiArea",
           title: "攻击区域",
       	   width : $(this).width() * 0.15
       },  {
       	   field: "waiUrl",
           title: "攻击url",
       	   width : $(this).width() * 0.15
       },  {
       	   field: "waiCode",
           title: "状态码",
       	   width : $(this).width() * 0.15
       },  {
       	   field: "waiCount",
       	   title: "攻击数",
       	   width : $(this).width() * 0.15
       }]
   });
}

function showChart(){
	$.getJSON("over/ipTop", {domainId: $('#domain_select').val(),type:$('#type_select').val(),beginTime :$('#begin').val(),endTime :$('#end').val()},function(data) {
		if(data==null){
    		$("#safePieChart").html("<p class='data-null'>暂无数据</p>");
    	}else{
    		var myChart1 = echarts.init(document.getElementById('safePieChart'));	
    		option = {
    				title : {
    			        text: '被攻击IP TOP5',
    			        left: 'left'
    			    },
    				tooltip: {
    					trigger: 'axis',
    					axisPointer: {            // 坐标轴指示器，坐标轴触发有效
    						type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
    					}
    				},
    				xAxis: {
    					type: 'value',
    					show:false,
    				},
    				yAxis: {
    					type: 'category',
    					data: data["ip"],
    					show:false,
    				},
    				series: [
    					{
    						name: '访问次数',
    						type: 'bar',
    						stack: '总量',
    						color:'green',
    						barWidth :'40%',
    						label: {
    							show: true,
    							position: 'right',
    							color:'black'
    						},
    						data: data["value"]
    					}
    				]
    		};
    		myChart1.setOption(option);
    	}
	});
}

function showAreaChart(){
	$.getJSON("over/areaMap", {domainId: $('#domain_select').val(),type:$('#type_select').val(),beginTime :$('#begin').val(),endTime :$('#end').val()},function(data) {
		if(data==null){
			$("#container").html("<p class='data-null'>暂无数据</p>");
		}else{
			setTimeout(function(){
				var myChart2 = echarts.init(document.getElementById('container'));	
				option = {
				    title : {
				        text: '区域攻击概览',
				        left: 'center'
				    },
				    tooltip : {
				        trigger: 'item'
				    },
				    visualMap: {
				        min: 0,
				        max: 2500,
				        left: 'left',
				        top: 'bottom',
				        text:['高','低'],           // 文本，默认为数值文本
				        calculable : true
				    },
				    toolbox: {
				        show: true,
				        orient : 'vertical',
				        left: 'right',
				        top: 'center',
				        feature : {
				            mark : {show: true},
				            dataView : {show: true, readOnly: false},
				            restore : {show: true},
				            saveAsImage : {show: true}
				        }
				    },
				    series : [
				        {
				            name: '攻击次数',
				            type: 'map',
				            mapType: 'china',
				            roam: false,
				            label: {
				                normal: {
				                    show: false
				                },
				                emphasis: {
				                    show: true
				                }
				            },
				            data:data
				        }
				    ]
				};
			    myChart2.setOption(option);
			},500);
		}
	});
}

function showCodeChart(){
	$.getJSON("over/codeMap", {domainId: $('#domain_select').val(),type:$('#type_select').val(),beginTime :$('#begin').val(),endTime :$('#end').val()},function(data) {
		var addContent='';
		for (var key in data) { 
			addContent+='<div class="col-lg-6 col-md-6 col-sm-12 code_body">\
				 	<div class="code_left">\
						<span class="code_num ft_20">'+key+'</span>\
						<span class="code_num ft_14">'+data[key]+'次</span>\
					</div>\
					<div class="code_right">\
						<span class="code_text ft_14">bad gateway（网关故障）</span>\
						<span class="code_text ft_14">状态码描述：代理或网关服务器遇到问题</span>\
					</div>\
				</div>'  
        }
		$("#codeDIV").append(addContent);
	});
}

function showChartBandWidth(){
	$.getJSON("over/bandwidthMap", {domainId: $('#domain_select').val(),type:$('#type_select').val(),beginTime :$('#begin').val(),endTime :$('#end').val()},function(data) {
		setTimeout(function(){
			var myChart4 = echarts.init(document.getElementById('bandWidthChart'));
			option = {
			    title: {
			        text: '总带宽-攻击带宽/Mbps',
			        left: 'center',
			        align: 'right',
			    	textStyle:{
				       color:'#666',
				       fontSize:12,
				       fontWeight:400,
				    }		
			    },
			    tooltip : {
					trigger: 'axis',
				},
				grid:{
					 x:50,
				     y:45,
				     x2:5,
				     y2:55
			    },
			    xAxis: {
			        boundaryGap : false,
			    	splitLine:{show:true},
			        type: 'category',
			        data: data["time"]
			    },
			    yAxis: {
			        type: 'value'
			    },
			    series: [{
			        data: data["bandWidth"],
			        type: 'line',
			        smooth: true,
			        symbol:'none',
			        itemStyle: {
			    	normal: {
			    		color:"#188df0",
			   			areaStyle: {color:"#7abbf5"},
			    		lineStyle: {
			    			width:2
			    		}
			    	}
			    },
			    },{
		            name:'对比',
		            type:'line',
		            symbol:'none',
		            smooth:true,
		            data:data["attackBandWidth"],
		            itemStyle: {
				    	normal: {
				    		color:"#e4393c",
				    		lineStyle: {
				    			width:2
				    		}
				    	}
				    },
		        }]
			};
		    myChart4.setOption(option);
		},500);  
	});
}
