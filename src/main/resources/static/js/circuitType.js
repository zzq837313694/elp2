//修改 线路状态和线路下的塔杆状态
function update(obj) {
    var No=$(obj).attr("No");
    var text=$(obj).text();
    data="circuitNo="+No+"&useStatus="+text;
    $.get("updateStatusTwo.html",data,function (relData) {
        if (relData>0){
           /* alert(No+"路线及其以下的杆塔已全部"+text);
            window.location.reload();*/
            popup({
                type: 'success', msg: No+"路线及其以下的杆塔已全部"+text, delay: 2000, callBack: function () {
                    window.location.reload();
                }
            });
        } else{
            alert("失败")
        }
    });
}

//异步删除 线路 以及线路下的塔杆
function del(obj) {
    var no=$(obj).attr("no");

    if(confirm("确定删除该路线及其以下的杆塔吗？")){
        var data="circuitNo="+no;
        //发送异步请求
        $.get("delOneTwo.html",data,function(relData){
            if(relData>"0"){
                /*alert("该路线及其以下的杆塔删除成功!");
                $(obj).parent().parent().remove();
                window.location.reload();*/
                popup({
                    type: 'success', msg: "该路线及其以下的杆塔删除成功", delay: 2000, callBack: function () {
                        window.location.reload();
                    }
                });
            }else{
                alert("删除失败!");
            }
        });
        return true;
    }else{
        return false;
    }
}
$(".zxf_pagediv").createPage({
    pageNum: $("#pageCount").val(),
    current: $("#returnpageIndex").val(),
    backfun: function(e) {
    }
});
$(document).on("click", "a.zxfPagenum", function () {
    var cur = parseInt($(this).text());
    $("#pageIndex").val(cur);
    $("#test").submit();
});
$(document).on("click", "a.prebtn", function () {
    var cur = parseInt($("span.current").text());
    $("#pageIndex").val(cur);
    $("#test").submit();
});
$(document).on("click", "a.nextbtn", function () {
    var cur = parseInt($("span.current").text());
    $("#pageIndex").val(cur);
    $("#test").submit();
});

$(document).on("click","span.zxfokbtn",function(){
    var cur = parseInt($("input.zxfinput").val());
    $("#pageIndex").val(cur);
    $("#test").submit();
});

