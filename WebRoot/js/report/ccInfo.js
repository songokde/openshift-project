/*$(function () {
	$("#yesAttacks").html("");
	$("#yesResAttacks").html("");
	
	$("#todAttacks").html("");
	$("#todResAttacks").html("");
	
	$("#7Attacks").html("");
	$("#7ResAttacks").html("");
	
	$("#pastAttacks").html("");
	$("#pastResAttacks").html("");
	
	$.post("", function(data) {
		$("#yesAttacks").html("");
		$("#yesResAttacks").html("");
		$("#todAttacks").html("");
		$("#todResAttacks").html("");
		$("#7Attacks").html("");
		$("#7ResAttacks").html("");
		$("#pastAttacks").html("");
		$("#pastResAttacks").html("");
	});
});

function searchDetail(factor){
	var queryData = { 
			time:factor,
			infoDomain:$("#infoDomain").val(),
		};
	$.post("",queryData,function(data) {
		
		
		showChart();
		searchPieTab();
	});
}*/

function showChart(){
	var myChart1 = echarts.init(document.getElementById('safePieChart'));	
	option = {
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
				data: ['48.225.18.170', '48.225.18.171', '48.225.18.172', '48.225.18.173', '48.225.18.16'],
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
					data: [320, 302, 301, 299, 200]
				}
			]
	};
	myChart1.setOption(option);
}

function showUrlChart(){
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
		            data:[
		                {name: '北京',value: Math.round(Math.random()*10000)},
		                {name: '天津',value: Math.round(Math.random()*10000)},
		                {name: '上海',value: Math.round(Math.random()*10000)},
		                {name: '重庆',value: Math.round(Math.random()*10000)},
		                {name: '河北',value: Math.round(Math.random()*10000)},
		                {name: '河南',value: Math.round(Math.random()*10000)},
		                {name: '云南',value: Math.round(Math.random()*10000)},
		                {name: '辽宁',value: Math.round(Math.random()*10000)},
		                {name: '黑龙江',value: Math.round(Math.random()*10000)},
		                {name: '湖南',value: Math.round(Math.random()*10000)},
		                {name: '安徽',value: Math.round(Math.random()*10000)},
		                {name: '山东',value: Math.round(Math.random()*10000)},
		                {name: '新疆',value: Math.round(Math.random()*10000)},
		                {name: '江苏',value: Math.round(Math.random()*10000)},
		                {name: '浙江',value: Math.round(Math.random()*10000)},
		                {name: '江西',value: 0},
		                {name: '湖北',value: 0},
		                {name: '广西',value: 0},
		                {name: '甘肃',value: 0},
		                {name: '山西',value: 0},
		                {name: '内蒙古',value: 0},
		                {name: '陕西',value: 0},
		                {name: '吉林',value: 0},
		                {name: '福建',value: 0},
		                {name: '贵州',value: 0},
		                {name: '广东',value: 0},
		                {name: '青海',value: 0},
		                {name: '西藏',value: 0},
		                {name: '四川',value: 0},
		                {name: '宁夏',value: 0},
		                {name: '海南',value: 0},
		                {name: '台湾',value: Math.round(Math.random()*10000)},
		                {name: '香港',value: Math.round(Math.random()*1000)},
		                {name: '澳门',value: Math.round(Math.random()*1000)}
		            ]
		        }
		    ]
		};
	    myChart2.setOption(option);
	},500);
	
}

function showCodeChart(){
	setTimeout(function(){
		var myChart3 = echarts.init(document.getElementById('safeCodeChart'));	
		option = {
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
					data: ['200', '404', '504', '502', '503'],
					show:false,
				},
				series: [
					{
						name: '状态码',
						type: 'bar',
						stack: '总量',
						color:'green',
						barWidth :'40%',
						label: {
							show: true,
							position: 'right',
							color:'black'
						},
						data: [320, 302, 301, 200, 100]
					}
				]
		};
		myChart3.setOption(option);
	},500);
}

function showChartBandWidth(){
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
/*				formatter: function (params) {
					return '时间：带宽';
				}*/
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
		        data: ['12-5', '12-6', '12-7', '12-8', '12-9']
		    },
		    yAxis: {
		        type: 'value'
		    },
		    series: [{
		        data: [820, 932, 901, 934, 1290],
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
	            data:[82, 93, 91, 93, 120],
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
}

function searchPieTab(data){
	$("#attackIpTab").bootstrapTable('destroy').bootstrapTable({
	  	contentType: "application/x-www-form-urlencoded", 
	  	data:data.data,
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
            field: "ip",
            title: "攻击IP",
            width : $(this).width() * 0.15
        },  {
            field: "area",
            title: "所属地区",
            width : $(this).width() * 0.15
        },  {
        	field: "time",
        	title: "最后一次攻击时间",
        	width : $(this).width() * 0.20
        },  {
        	field: "times",
        	title: "攻击次数",
        	width : $(this).width() * 0.15
        },  {
            field: "ratio",
            title: "操作",
            formatter : function() {
            	return 	" <button type='button' class='btn' onclick ='showDetail()'\">查看攻击详情</button>";
			}
        }]
    });
}

function searchUrlTab(data){
	$("#attackUrlTab").bootstrapTable('destroy').bootstrapTable({
	  	contentType: "application/x-www-form-urlencoded", 
	  	data:data.data,
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
            field: "ip",
            title: "攻击IP",
            width : $(this).width() * 0.15
        },  {
            field: "area",
            title: "所属地区",
            width : $(this).width() * 0.15
        },  {
        	field: "time",
        	title: "最后一次攻击时间",
        	width : $(this).width() * 0.20
        },  {
        	field: "times",
        	title: "攻击次数",
        	width : $(this).width() * 0.15
        },  {
            field: "ratio",
            title: "操作",
            formatter : function() {
            	return 	" <button type='button' class='btn' onclick ='showDetail()'\">查看攻击详情</button>";
			}
        }]
    });
}

function searchCodeTab(data){
	$("#attackCodeTab").bootstrapTable('destroy').bootstrapTable({
	  	contentType: "application/x-www-form-urlencoded", 
	  	data:data.data,
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
            field: "ip",
            title: "攻击IP",
            width : $(this).width() * 0.15
        },  {
            field: "area",
            title: "所属地区",
            width : $(this).width() * 0.15
        },  {
        	field: "time",
        	title: "最后一次攻击时间",
        	width : $(this).width() * 0.20
        },  {
        	field: "times",
        	title: "攻击次数",
        	width : $(this).width() * 0.15
        },  {
            field: "ratio",
            title: "操作",
            formatter : function() {
            	return 	" <button type='button' class='btn' onclick ='showDetail()'\">查看攻击详情</button>";
			}
        }]
    });
}

function showDetail(){
	 var data ={
			 "count": 10,
			 "data":[
			 	{
			 		"attackTime":"2020-09-11 21:10:45",
					"attackURL":"www.yimeiyu.com/yp/index.jsp",
					"attackType":"SQL注入",
					"attackRule":"sql代码执行插入",
					"requestMethod": "POST",
					"requestParam": "UESR=12333",
					"action": "阻断"
			 	},
			 	{
			 		"attackTime":"2020-11-11 12:45:43",
					"attackURL":"www.yimeiyu.com/yp/index.jsp",
					"attackType":"webshell",
					"attackRule":"webshell行为",
					"requestMethod": "POST",
					"requestParam": "UESR=12333",
					"action": "放行"
			 	},
			 	{
			 		"attackTime":"2020-11-11 12:45:43",
					"attackURL":"www.yimeiyu.com/yp/index.jsp",
					"attackType":"webshell",
					"attackRule":"webshell行为",
					"requestMethod": "POST",
					"requestParam": "UESR=12333",
					"action": "放行"
			 	},
			 	{
			 		"attackTime":"2020-11-11 12:45:43",
					"attackURL":"www.yimeiyu.com/yp/index.jsp",
					"attackType":"webshell",
					"attackRule":"webshell行为",
					"requestMethod": "POST",
					"requestParam": "UESR=12333",
					"action": "放行"
			 	},
			 	{
			 		"attackTime":"2020-11-11 12:45:43",
					"attackURL":"www.yimeiyu.com/yp/index.jsp",
					"attackType":"webshell",
					"attackRule":"webshell行为",
					"requestMethod": "POST",
					"requestParam": "UESR=12333",
					"action": "放行"
			 	},
			 	{
			 		"attackTime":"2020-11-11 12:45:43",
					"attackURL":"www.yimeiyu.com/yp/index.jsp",
					"attackType":"webshell",
					"attackRule":"webshell行为",
					"requestMethod": "POST",
					"requestParam": "UESR=12333",
					"action": "放行"
			 	},
			 	{
			 		"attackTime":"2020-11-11 12:45:43",
					"attackURL":"www.yimeiyu.com/yp/index.jsp",
					"attackType":"webshell",
					"attackRule":"webshell行为",
					"requestMethod": "POST",
					"requestParam": "UESR=12333",
					"action": "放行"
			 	}
			 ]
	 };
	$("#attackDetailModal").modal("show");
	$("#webDetailTab").bootstrapTable('destroy').bootstrapTable({
	  	contentType: "application/x-www-form-urlencoded", 
	  	data:data.data,
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
            field: "attackTime",
            title: "攻击时间",
            width : $(this).width() * 0.15
        },  {
            field: "attackURL",
            title: "攻击URL",
            width : $(this).width() * 0.15
        },  {
        	field: "attackType",
        	title: "攻击类型（全部）",
        	width : $(this).width() * 0.20
        },  {
        	field: "attackRule",
        	title: "规则描述",
        	width : $(this).width() * 0.15
        },  {
        	field: "requestMethod",
        	title: "请求方式",
        	width : $(this).width() * 0.15
        },  {
        	field: "requestParam",
        	title: "请求参数",
        	width : $(this).width() * 0.15
        },  {
            field: "action",
            title: "规则动作",
        }]
    });
}