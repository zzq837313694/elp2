function submint() {
    $("#su").ajaxSubmit({
        type: "post",  //提交方式
        dataType: "json", //数据类型
        async:false,
        url: "getflawinfoCheckList.html", //请求url
        success: function (data) {//提交成功的回调函数
            $("#pageCount").val(data.pageCount);
            var options=""
            $.each(data.dataList, function (i, obj) {
                var statusStr="";
                var checkJobNo = obj.checkJobNo == null ? "" : obj.checkJobNo;
                var circuitNo = obj.circuitNo == null ? "" : obj.circuitNo;
                var towerNo = obj.towerNo == null ? "" : obj.towerNo;
                var createByName = obj.createByName == null ? "" : obj.createByName;
                var flawLv = obj.flawLv == null ? "" : obj.flawLv;
                var flawName = obj.flawName == null ? "" : obj.flawName;
                var checkByName = obj.checkByName == null ? "" : obj.checkByName;
                var intcatRate = obj.intcatRate == null ? "" : obj.intcatRate;
                var comment = obj.comment == null ? "" : obj.comment;
                var createDate;
                if (obj.createDate == null) {
                    createDate = " ";
                } else {
                    var date = new Date(obj.createDate == null ? "" : obj.createDate);
                    createDate = date.getFullYear() + "/" + eval(date.getMonth() + "+1") + "/" + date.getDate()
                }
                var checkDate;
                if (obj.finishDate == null) {
                    checkDate = " ";
                } else {
                    var date2 = new Date(obj.checkDate == null ? "" : obj.checkDate);
                    checkDate = date2.getFullYear() + "/" + eval(date2.getMonth() + "+1") + "/" + date2.getDate()
                }
                options+=
                    "<tr style='vertical-align: middle'>" +
                    "<td>"+checkJobNo+"</td>"+
                    "<td>"+circuitNo+"</td>"+
                    "<td>"+towerNo+"</td>"+
                    "<td>"+flawLv+"</td>"+
                    "<td>"+flawName+"</td>"+
                    "<td>"+checkByName+"</td>"+
                    "<td>"+checkDate+"</td>"+
                    "<td>"+createByName+"</td>"+
                    "<td>"+createDate+"</td>"+
                    "<td>"+intcatRate*100+"%"+"</td>" +
                    "<td>"+comment+"</td>" +
                    "</tr>";
            });
            alert(options)
            $("#app").html(options);
        }
    });
    return false; //不刷新页面
}


$(function () {
    submint();
    $("#su").submit(function () {
        submint();
        return false;
    });
    $(document).on("click", "a.zxfPagenum", function () {
        var cur = parseInt($(this).text());
        $("#pageIndex").val(cur);
        submint();
    });
    $(document).on("click", "a.prebtn", function () {
        var cur = parseInt($("span.current").text());
        $("#pageIndex").val(cur);
        submint();
    });
    $(document).on("click", "a.nextbtn", function () {
        var cur = parseInt($("span.current").text());
        $("#pageIndex").val(cur);
        submint();
    });

    /* $(document).on("click","span.zxfokbtn",function(){
         var cur = $("input.zxfinput").val();
         alert(cur)
         var  a=$("#pageIndex").val();
         if(cur>$("#pageCount").val()){}else{
             submint();
         }

     });*/
    $(document).on("click","span.zxfokbtn",function(){
        var cur = parseInt($("input.zxfinput").val());
        if(cur>$("#pageCount").val()){return;}
        submint();
    });
    $(".zxf_pagediv").createPage({
        pageNum:$("#pageCount").val(),
        current:1,
        backfun: function(e) {
        }
    });
})
(function($){
    var zp = {
        init:function(obj,pageinit){
            return (function(){
                zp.addhtml(obj,pageinit);
                zp.bindEvent(obj,pageinit);
            }());
        },
        addhtml:function(obj,pageinit){
            return (function(){
                obj.empty();
                if (pageinit.current > 1) {
                    obj.append('<a href="javascript:;" class="prebtn">上一页</a>');
                } else{
                    obj.remove('.prevPage');
                    obj.append('<span class="disabled">上一页</span>');
                }
                if (pageinit.current >4 && pageinit.pageNum > 4) {
                    obj.append('<a href="javascript:;" class="zxfPagenum">'+1+'</a>');
                    /* obj.append('<a href="javascript:;" class="zxfPagenum">'+2+'</a>');*/
                    obj.append('<span>...</span>');
                }
                if (pageinit.current >4 && pageinit.current <= pageinit.pageNum-5) {
                    var start  = pageinit.current - 2,end = pageinit.current + 2;
                }else if(pageinit.current >4 && pageinit.current > pageinit.pageNum-5){
                    var start  = pageinit.pageNum - 4,end = pageinit.pageNum;
                }else{
                    var start = 1,end = 6;
                }

                for (;start <= end;start++) {
                    if (start <= pageinit.pageNum && start >=1) {
                        if (start == pageinit.current) {
                            obj.append('<span id="nowPage" class="current" onclick="getData(this)">'+ start +'</span>');
                        }else if(start == pageinit.current+1){
                            obj.append('<a href="javascript:;" class="zxfPagenum ">'+ start +'</a>');
                        }else{
                            obj.append('<a href="javascript:;" class="zxfPagenum">'+ start +'</a>');
                        }
                    }
                }
                if (end < pageinit.pageNum) {
                    obj.append('<span>...</span>');
                }
                if (pageinit.current >= pageinit.pageNum) {
                    obj.remove('.nextbtn');
                    obj.append('<span class="disabled">下一页</span>');
                } else{
                    obj.append('<a href="javascript:;" class="nextbtn">下一页</a>');
                }
                obj.append('<span>'+'共'+'<b>'+pageinit.pageNum+'</b>'+'页,'+'</span>');
                obj.append('<span>'+'到第'+'<input type="text" class="zxfinput" />'+'页'+'</span>');
                obj.append('<span class="zxfokbtn">'+'确定'+'</span>');
            }());
        },
        bindEvent:function(obj,pageinit){
            return (function(){
                obj.on("click","a.prebtn",function(){
                    var cur = parseInt(obj.children("span.current").text());
                    var current = $.extend(pageinit, {"current":cur-1});
                    zp.addhtml(obj,current);
                    if (typeof(pageinit.backfun)=="function") {
                        pageinit.backfun(current);
                    }
                });
                obj.on("click","a.zxfPagenum",function(){
                    var cur = parseInt($(this).text());
                    var current = $.extend(pageinit, {"current":cur});
                    zp.addhtml(obj,current);
                    if (typeof(pageinit.backfun)=="function") {
                        pageinit.backfun(current);
                    }
                });
                obj.on("click","a.nextbtn",function(){
                    var cur = parseInt(obj.children("span.current").text());
                    var current = $.extend(pageinit, {"current":cur+1});
                    zp.addhtml(obj,current);
                    if (typeof(pageinit.backfun)=="function") {
                        pageinit.backfun(current);
                    }
                });
                obj.on("click","span.zxfokbtn",function(){
                    var cur = parseInt($("input.zxfinput").val());

                    if(cur>pageinit.pageNum){return;}
                    $("#pageIndex").val(cur);
                    var current = $.extend(pageinit, {"current":cur});
                    zp.addhtml(obj,{"current":cur,"pageNum":pageinit.pageNum});
                    if (typeof(pageinit.backfun)=="function") {
                        pageinit.backfun(current);
                    }
                });
            }());
        }
    }
    $.fn.createPage = function(options){
        var pageinit = $.extend({
            backfun : function(){}
        },options);
        zp.init(this,pageinit);
    }
}(jQuery));
