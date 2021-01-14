<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
    $(function(){
    	var time = new Date().getTime()/1000;
		//time = time - 86400;
	    $("#beginDate").val(timeStrmpFoarmat(new Date(time*1000)).replace(/-/g, ""));
	    $("#endDate").val(timeStrmpFoarmat(new Date(time*1000)).replace(/-/g, ""));
	    $("#begin").val(timeStrmpFoarmat(new Date(time*1000)));
	    $("#end").val(timeStrmpFoarmat(new Date(time*1000)));
	    $("#selectDate").change(function(){
	    	var val=$("#selectDate").val();
	    	selectDate(val);
	    });
	    $('#selectDate').multiselect();
    });
</script>
<!-- 时间 -->
<input type="hidden" id="beginDate"/>
<input type="hidden" id="endDate"/>
<div class="toolBar-left">
	<span class="detail_text">选择时间</span>
</div>
<div class="toolBar-left">
	<input type="text" class="form-control bt_date" value="" id="begin"  readonly>
</div>
<div class="toolBar-left" style="height:30px;line-height: 30px;font-size: 16px;margin: 0">
	-
</div>
<div class="toolBar-left">
	<input type="text" class="form-control bt_date" value="" id="end"  readonly>
</div>
  	<script type="text/javascript">
	$('#begin').datetimepicker({
	    format: 'yyyy-mm-dd',
	    minView: 'month',
	    language:'zh-CN',
	    todayBtn:  1,
    	autoclose: 1,
    	weekStart:1,
    	endDate : new Date()
	});
	$('#end').datetimepicker({
	    format: 'yyyy-mm-dd',
	    minView: 'month',
	    language:'zh-CN',
	    maxView:0,
	    todayBtn:  1,
    	autoclose: 1,
    	weekStart:1,
    	endDate : new Date()
	});
	
	$('#begin').on('changeDate', function(ev){
		$("#beginDate").val(timeStrmpFoarmat(ev.date.valueOf()).replace(/-/g, ""));
		
	});
	$('#end').on('changeDate', function(ev){
		$("#endDate").val(timeStrmpFoarmat(ev.date.valueOf()).replace(/-/g, ""));
		if($("#endDate").val()<$("#beginDate").val()){
			swal("警告","结束时间不能小于开始时间!","error");
		}
	});
</script>