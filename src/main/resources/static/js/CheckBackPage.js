function submint() {
    $("#su").ajaxSubmit({
        type: "post",  //提交方式
        dataType: "json", //数据类型
        async:false,
        url: "getchecktaskListNot.html", //请求url
        success: function (data) {//提交成功的回调函数
            $("#pageCount").val(data.pageCount);
            var options=""
            $.each(data.dataList, function (i, obj) {
                var statusStr="";
                var jobId = obj.jobId == null ? "" : obj.jobId;
                var jobName = obj.jobName == null ? "" : obj.jobName;
                var circuitName = obj.circuitName == null ? "" : obj.circuitName;
                var createByName = obj.createByName == null ? "" : obj.createByName;
                var startNo = obj.startNo == null ? "" : obj.startNo;
                var stopNo = obj.stopNo == null ? "" : obj.stopNo;
                var abolish = obj.abolish == null ? "" : obj.abolish;
                switch (obj.status) {
                    case "待分配":
                        statusStr= "<td  style='color:orange'>" + obj.status + "</td>";
                        break;
                    case "已分配":
                        statusStr= "<td  style='color:blue'>" + obj.status + "</td>";
                        break;
                    case "执行中":
                        statusStr= "<td  style='color:purple'>" + obj.status + "</td>";
                        break;
                    case "已完成":
                        statusStr= "<td  style='color:green'>" + obj.status + "</td>";
                        break;
                    default:
                        statusStr="<td >" +obj.status + "</td>";
                        break;
                }
                var createDate;
                if (obj.createDate == null) {
                    createDate = " ";
                } else {
                    var date = new Date(obj.createDate == null ? "" : obj.createDate);
                    createDate = date.getFullYear() + "/" + eval(date.getMonth() + "+1") + "/" + date.getDate()
                }
                var fDate;
                if (obj.finishDate == null) {
                    fDate = " ";
                } else {
                    var date2 = new Date(obj.finishDate == null ? "" : obj.finishDate);
                    fDate = date2.getFullYear() + "/" + eval(date2.getMonth() + "+1") + "/" + date2.getDate()
                }
                var trsTR = "<a href=\"showChecktask.html?jobId="+jobId+"\">查看</a>" +
                    "                    <span>|</span>" +
                    "                    <a href=\"backFlaw.html?jobId="+jobId+"\">回执录入</a>" +
                    "                    <span>|</span>" +
                    "<a href=\"updateChecktask.html?jobId="+jobId+"\">执行</a>" +
                    "                    <span>|</span>" ;
                options+=
                    "<tr style='vertical-align: middle'><td>"+jobId+"</td>"+
                    "<td>"+jobName+"</td>"+
                    "<td>"+circuitName+"</td>"+
                    "<td>"+startNo+"</td>"+
                    "<td>"+stopNo+"</td>"+
                    "<td>"+createByName+"</td>"+
                    "<td>"+createDate+"</td>"+statusStr+
                    "<td>"+fDate+"</td>"+
                    "<td>"+abolish+"</td>"+
                    "<td>"+trsTR+"</td></tr>";
            });
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
