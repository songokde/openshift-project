
//自定义js

//公共配置


$(document).ready(function () {

    // MetsiMenu
    $('#side-menu').metisMenu();

    // 打开右侧边栏
    $('.right-sidebar-toggle').click(function () {
        $('#right-sidebar').toggleClass('sidebar-open');
    });

    //固定菜单栏
    $(function () {
        $('.sidebar-collapse').slimScroll({
            height: '100%',
            railOpacity: 0.9,
            alwaysVisible: false
        });
    });


    // 菜单切换
    $('.navbar-minimalize').click(function () {
        $("body").toggleClass("mini-navbar");
        SmoothlyMenu();
        return false;//解决栈溢出问题
    });


    // 侧边栏高度
    function fix_height() {
        var heightWithoutNavbar = $("body > #wrapper").height() - 61;
        $(".sidebard-panel").css("min-height", heightWithoutNavbar + "px");
    }
    fix_height();

    $(window).bind("load resize click scroll", function () {
        if (!$("body").hasClass('body-small')) {
            fix_height();
        }
    });

    //侧边栏滚动
    $(window).scroll(function () {
        if ($(window).scrollTop() > 0 && !$('body').hasClass('fixed-nav')) {
            $('#right-sidebar').addClass('sidebar-top');
        } else {
            $('#right-sidebar').removeClass('sidebar-top');
        }
    });

    $('.full-height-scroll').slimScroll({
        height: '100%'
    });

    $('#side-menu>li').click(function () {
        if ($('body').hasClass('mini-navbar')) {
            NavToggle();
        }
    });
    $('#side-menu>li li a').click(function () {
        if ($(window).width() < 769) {
            NavToggle();
        }
    });

    $('.nav-close').click(NavToggle);

    //ios浏览器兼容性处理
    if (/(iPhone|iPad|iPod|iOS)/i.test(navigator.userAgent)) {
        $('#content-main').css('overflow', 'auto');
    }else{
    	$('#content-main').css('overflow', 'auto');
    }

});

$(window).bind("load resize", function () {
    if ($(this).width() < 769) {
        $('body').addClass('mini-navbar');
        $('.navbar-static-side').fadeIn();
    }
});

function NavToggle() {
    $('.navbar-minimalize').trigger('click');
}

function SmoothlyMenu() {
    if (!$('body').hasClass('mini-navbar')) {
        $('#side-menu').hide();
        setTimeout(function () {
            $('#side-menu').fadeIn(500);
        }, 100);
    } else if ($('body').hasClass('fixed-sidebar')) {
        $('#side-menu').hide();
        setTimeout(function () {
            $('#side-menu').fadeIn(500);
        }, 300);
    } else {
        $('#side-menu').removeAttr('style');
    }
}

function getTopWinow(){  
    var p = window;  
    while(p != p.parent){  
        p = p.parent;  
    }  
    return p;  
} 

$.ajaxSetup({
	contentType : "application/x-www-form-urlencoded;charset=utf-8", 
	complete : function(xhr, textStatus) {  
		if (xhr.status == 999) {
			swal({
				title: "超时提醒",  //弹出框的title
				text: "您长时间未操作访问已超时,请重新登录!", //弹出框里面的提示文本
				type: "info",  //弹出框类型
				showCancelButton: true, //是否显示取消按钮
				confirmButtonColor: "#DD6B55",//确定按钮颜色
				cancelButtonText: "停留本页",//取消按钮文本
				confirmButtonText: "返回主页",//确定按钮上面的文档
				closeOnConfirm: true
			},function(){
				setTimeout(function(){
					var top = getTopWinow(); 
					top.location.href="/index.jsp";
					return; 
				}, 200);
			});
		} 
	} 
});