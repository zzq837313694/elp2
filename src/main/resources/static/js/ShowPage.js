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
                    obj.append('<a href="javascript:;" class="zxfPagenum">'+2+'</a>');
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

                        }else  if (start == pageinit.current-1) {
                            obj.append('<span class="zxfPagenum previouspage ">' + start + '</span>');
                        }else if(start == pageinit.current+1){
                            obj.append('<a href="javascript:;" class="zxfPagenum nextpage">'+ start +'</a>');
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
                obj.append('<span>'+'到第'+'<input type="text" class="zxfinput" value="5"/>'+'页'+'</span>');
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

    $('#submit_btn').click(function() {
        alert(123)
        var myDate = new Date();
        var obj={};
        obj.jobId=$("#jobId").val();
        obj.circuitNo=$("#circuitNo").val();
        obj.status=$("#status").val();
        obj.checkBy=$("#checkBy").val();
        var description = "";
        for(var i in obj){
            var property=obj[i];
            description+=i+" = "+property+"\n";
        }
        $.ajax({
            type: "POST",
            url: "checktaskController/getchecktaskList",
            dataType: "json",
            data:JSON.stringify(obj),
            contentType : "application/json",
            success: function (data) {
                console.log(data)
            },
            error: function (e) {
                console.log(e)
            }
        })
    })
}(jQuery));
