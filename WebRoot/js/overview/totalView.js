
$(function () {
	$.post("over/allMap", function(data) {
		$("#webYesterday").html(data["web"]["yesterday"]);
		$("#webToday").html(data["web"]["today"]);
		$("#webFuture").html(data["web"]["future"]);
		$("#ccYesterday").html(data["cc"]["yesterday"]);
		$("#ccToday").html(data["cc"]["today"]);
		$("#ccFuture").html(data["cc"]["future"]);
		$("#visitYesterday").html(data["visit"]["yesterday"]);
		$("#visitToday").html(data["visit"]["today"]);
		$("#visitFuture").html(data["visit"]["future"]);
		showChartWeb(data["webChar"]);
		showChartCc(data["ccChar"]);
		showChartVisit(data["visitChar"]);
		showChartBandWidth(data["bandwidth"]);
	}); 
});


function showChartWeb(data){
	var myChart = echarts.init(document.getElementById('webLineChart'));
	option = {
		tooltip: {
	        trigger: 'axis',
	    },
		xAxis: {
			show : false,
	        type: 'category',
	        data: data["time"]
	    },
	    yAxis: {
	    	show : false,
	        type: 'value'
	    },
	    series: [{
	    	name:'web攻击',
            type:'line',
	        data: data["value"],
	        type: 'line'
	    }]
			   
	};
    myChart.setOption(option);
   
}

function showChartCc(data){
	var myChart2 = echarts.init(document.getElementById('ccLineChart'));
    option = {
		 tooltip: {
	         trigger: 'axis',
	     },
		 xAxis: {
			show : false,
	        type: 'category',
	        data:  data["time"]
	    },
	    yAxis: {
	    	show : false,
	        type: 'value'
	    },
	    series: [{
	    	name:'cc攻击',
            type:'line',
	        data:  data["value"],
	        lineStyle: {
			 color: 'origin'
	        }
	    }]
    };
    myChart2.setOption(option);
}


function showChartVisit(data){
	var myChart3 = echarts.init(document.getElementById('controlLineChart'));
    option = {
		tooltip: {
	        trigger: 'axis',
	    },
		xAxis: {
			show : false,
	        type: 'category',
	        data: data["time"]
	    },
	    yAxis: {
	    	show : false,
	        type: 'value'
	    },
	    series: [{
	    	name:'访问攻击',
	        data: data["value"],
	        type: 'line',
	        lineStyle: {
				 color: 'blue'
	        }
	    }]
    };
    myChart3.setOption(option);
}

function showChartBandWidth(data){
	console.info(data)
	var myChart4 = echarts.init(document.getElementById('bandWidthChart'));
	option = {
	    title: {
	        text: '近7天带宽/Mbps',
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
	        data: data["time"]
	    },
	    yAxis: {
	        type: 'value'
	    },
	    series: [{
	        data: data["value"],
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
	    }]
	};
    myChart4.setOption(option);
}

function view(type){
	location.href="report/webInfo?param1="+type;
}