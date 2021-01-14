/**************日期戳格式化***************/
function timeStrmpFoarmat(timeStrmp){
	var timeStrmp=new Date(timeStrmp);  
	var year=timeStrmp.getFullYear();     
    var month=timeStrmp.getMonth()+1;     
    var date=timeStrmp.getDate();       
    return year+"-"+
    		(month<10 ? "0" + month : month)+"-"+
    		(date<10 ? "0" + date : date);  
}

/**************时间戳格式化***************/
function timeStrmp(timeStrmp){
	var timeStrmp=new Date(timeStrmp*1000);  
	var year=timeStrmp.getFullYear();     
    var month=timeStrmp.getMonth()+1;     
    var date=timeStrmp.getDate();     
    var hour=timeStrmp.getHours();     
    var minute=timeStrmp.getMinutes();     
    var second=timeStrmp.getSeconds();  
    var date= year+"-"+
    		(month<10 ? "0" + month : month)+"-"+
    		(date<10 ? "0" + date : date)+" "+
    		(hour<10 ? "0" + hour : hour)+":"+
    		(minute<10 ? "0" + minute : minute);
    return date;
}

function timeStrmdhm(timeStrmp){
	var timeStrmp=new Date(timeStrmp*1000);  
	var year=timeStrmp.getFullYear();     
    var month=timeStrmp.getMonth()+1;     
    var date=timeStrmp.getDate();     
    var hour=timeStrmp.getHours();     
    var minute=timeStrmp.getMinutes();     
    var second=timeStrmp.getSeconds();  
    var date=(month<10 ? "0" + month : month)+"-"+
    		(date<10 ? "0" + date : date)+" "+
    		(hour<10 ? "0" + hour : hour)+":"+
    		(minute<10 ? "0" + minute : minute);
    return date;
}

function timeStrmpms(timeStrmp){
	var timeStrmp=new Date(timeStrmp);  
	var year=timeStrmp.getFullYear();     
    var month=timeStrmp.getMonth()+1;     
    var date=timeStrmp.getDate();     
    var hour=timeStrmp.getHours();     
    var minute=timeStrmp.getMinutes();     
    var second=timeStrmp.getSeconds();  
    var date= year+"-"+
    		(month<10 ? "0" + month : month)+"-"+
    		(date<10 ? "0" + date : date)+" "+
    		(hour<10 ? "0" + hour : hour)+":"+
    		(minute<10 ? "0" + minute : minute);
    return date;
}

/**************当前时间***************/
function nowDate(){
	var nowDate=new Date();  
	var year=nowDate.getFullYear();     
    var month=nowDate.getMonth()+1;     
    var date=nowDate.getDate();      
    return year+"-"+
    		(month<10 ? "0" + month : month)+"-"+
    		(date<10 ? "0" + date : date);
}

/**************最近24小时***************/
function lately24hours(){
	var yesterdsay = new Date(new Date().getTime() - 86400000);
	return timeStrmpFoarmat(yesterdsay);
}

/**************今天***************/
function todayHours(){
	var nowDate=new Date();  
	var year=nowDate.getFullYear();     
    var month=nowDate.getMonth()+1;     
    var date=nowDate.getDate();     
    return year+"-"+
		(month<10 ? "0" + month : month)+"-"+
		(date<10 ? "0" + date : date);
}
	
/**************昨天***************/	
function yesterdayHours(){
	var yesterdsay = new Date(new Date().getTime() - 86400000);
	var timeStrmp=new Date(yesterdsay);  
	var year=timeStrmp.getFullYear();     
    var month=timeStrmp.getMonth()+1;     
    var date=timeStrmp.getDate();     
    return year+"-"+
    		(month<10 ? "0" + month : month)+"-"+
    		(date<10 ? "0" + date : date);
}	
	
/**************近七天***************/	
function lately7days(){
	var lately7days = new Date(new Date().getTime() - 604800000);
	return timeStrmpFoarmat(lately7days);
}
	
	
