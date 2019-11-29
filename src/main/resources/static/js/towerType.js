function update(obj) {
    var towerNo=$(obj).attr("towerNo");
    var circuitname=$(obj).attr("circuitName");
    var status=$(obj).attr("status");
    var circuitNo=$(obj).attr("circuitNo");
    $("#mycircuitNo>option[value="+circuitNo+"]").attr("selected",true);
    $("#towerNo1").val(towerNo);
    if($("#statusON").val()==status){
        $("#statusOFF").removeAttr("checked");
        $("#statusON").attr("checked",true);
    }
    if($("#statusOFF").val()==status){
        $("#statusON").removeAttr("checked");
        $("#statusOFF").attr("checked",true);
    }
}
//实现异步删除

function del(obj) {
    var no=$(obj).attr("no");
    var data="towerNo="+no;
    $.get("delOneTower.html",data,function(relData){
        if(relData>"0"){
            popup({
                type: 'success', msg: "刪除成功", delay: 1000, callBack: function () {
                    window.location.reload();
                }
            });
        }else{
            alert("删除失败!");
        }
    });
}
//线路停无法修改
function stop(){
    confirm("所属线路已停用,无法修改请先启用线路后在修改！")
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

//验证不为空
function checkNo(){
    var addtowerNo= $("#addtowerNo").val();
    if (addtowerNo==null || addtowerNo==""){
        $("#addtowerNo1").text("*不能为空");
        return false;
    }else {
        $("#addtowerNo1").text("*");
        return true;
    }
}

function checkaddcircuitNo(){
    var  addcircuitNo=$("#addcircuitNo").val();
    if (addcircuitNo==null || addcircuitNo==""){
        $("#addcircuitNo1").text("*请选择线路");
        return false;
    } else {
        $("#addcircuitNo1").text("*");
        return true;
    }
}

function checkUpdateTower(){
    var towerNo1= $("#towerNo1").val();
    if (towerNo1==null || towerNo1==""){
        $("#updateTowerSpan").text("*不能为空");
        return false;
    }else {
        $("#updateTowerSpan").text("*");
        return true;
    }
}

function checkUpdateCircuit(){
    var  mycircuitNo=$("#mycircuitNo").val();
    if (mycircuitNo==null || mycircuitNo==""){
        $("#updateCircuitSpan").text("*请选择线路");
        return false;
    } else {
        $("#updateCircuitSpan").text("*");
        return true;
    }
}

$(function () {
    $("#addtowerNo").blur(checkNo);
    $("#addcircuitNo").blur(checkaddcircuitNo);
    $("#towerNo1").blur(checkUpdateTower);
    $("#mycircuitNo").blur(checkUpdateCircuit);
});


$("#myaddfrom").submit(function () {
    var flag=true;
    if(!checkNo())flag=false;
    if (!checkaddcircuitNo())flag=false;
    return flag;
});
$("#updateTowerForm").submit(function () {
    var flag=true;
    if(!checkUpdateTower())flag=false;
    if (!checkUpdateCircuit())flag=false;
    return flag;
});
$('#myModal2').on('hidden.bs.modal', function () {
    document.getElementById("updateTowerForm").reset();
});
$('#myModal').on('hidden.bs.modal', function () {
    document.getElementById("myaddfrom").reset();
});

