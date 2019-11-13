//验证表单
$(function () {
    $("#circuitNo").blur(checkaddCircuitNoSpan);
    $("#circuitName").blur(checkaddCircuitNameSpan);
    $("#lineLength").blur(checkaddLineLengthSpan);
    $("#circuitLength").blur(checkaddCircuitLengthSpan);
    $("#onlineDate").blur(checkaddOnlineDateSpan);
    $("#voltLv").blur(checkaddVoltLvSpan);
    $("#startNo").blur(checkaddStartNoSpan);
    $("#stopNo").blur(checkaddStopNoSpan);
    $("#towerCount").blur(checkaddTowerCountSpan);
});

$("#mycircuitAdd").submit(function () {
    var  flag=true;
    if (!checkaddCircuitNoSpan()){flag=false};
    if (!checkaddCircuitNameSpan())flag=false;
    if (!checkaddLineLengthSpan())flag=false;
    if (!checkaddCircuitLengthSpan())flag=false;
    if (!checkaddOnlineDateSpan())flag=false;
    if (!checkaddVoltLvSpan())flag=false;
    if (!checkaddStartNoSpan())flag=false;
    if (!checkaddStopNoSpan())flag=false;
    if (!checkaddTowerCountSpan())flag=false;
    return flag;
});
function checkaddCircuitNoSpan() {
    if($("#circuitNo").val()==null ||$("#circuitNo").val()==""){
        $("#addCircuitNoSpan").text("不能为空");
        return false;
    }else{
        $("#addCircuitNoSpan").text("");
        return true;
    }
}
function checkaddCircuitNameSpan() {
    if($("#circuitName").val()==null ||$("#circuitName").val()==""){
        $("#addCircuitNameSpan").text("不能为空");
        return false;
    }else{
        $("#addCircuitNameSpan").text("");
        return true;
    }
}
function checkaddLineLengthSpan() {
    if($("#lineLength").val()==null ||$("#lineLength").val()=="") {
        $("#addLineLengthSpan").text("不能为空");
        return  false;
    }else{
        var reg = /^[0-9]*$/;
        if (reg.test($("#lineLength").val()) == false) {
            $("#addLineLengthSpan").text("输入有误，请输入数字");
            return false;
        }else {
            $("#addLineLengthSpan").text("");
            return true;
        }
    }
}
function checkaddCircuitLengthSpan() {
    if($("#circuitLength").val()==null ||$("#circuitLength").val()=="") {
    $("#addCircuitLengthSpan").text("不能为空");
    return false;
    }else{
        var reg=/^[0-9]*$/;
        if (reg.test($("#circuitLength").val())==false) {
            $("#addCircuitLengthSpan").text("输入有误，请输入数字");
            return false;}
        else {$("#addCircuitLengthSpan").text("");
            return true;}
    }
}
function checkaddOnlineDateSpan() {
    if($("#onlineDate").val()==null ||$("#onlineDate").val()==""){
        $("#addOnlineDateSpan").text("不能为空");
        return false;
    }else{
        $("#addOnlineDateSpan").text("");
        return true;
    }
}
function checkaddVoltLvSpan() {
    if($("#voltLv").val()==null ||$("#voltLv").val()=="") {
    $("#addVoltLvSpan").text("不能为空");
    return false;
    }else{
        var reg=/^[0-9]*$/;
        if (reg.test($("#voltLv").val())==false) {
            $("#addVoltLvSpan").text("输入有误，请输入数字");
            return false;}
        else {
        $("#addVoltLvSpan").text("");
        return true;}
    }
}
function checkaddStartNoSpan() {
    if($("#startNo").val()==null ||$("#startNo").val()==""){
        $("#addStartNoSpan").text("不能为空");
        return false;
    }else{
        $("#addStartNoSpan").text("");
        return true;
    }
}
function checkaddStopNoSpan() {
    if($("#stopNo").val()==null ||$("#stopNo").val()==""){
        $("#addStopNoSpan").text("不能为空");
        return false;
    }else{
        $("#addStopNoSpan").text("");
        return true;
    }
}
function checkaddTowerCountSpan() {
    if($("#towerCount").val()==null ||$("#towerCount").val()=="") {

    $("#addTowerCountSpan").text("不能为空");
    return  false;
    }else{
        var reg=/^[0-9]*$/;
        if (reg.test($("#towerCount").val())==false) {
            $("#addTowerCountSpan").text("输入有误，请输入数字");
            return false;}
        else {
        $("#addTowerCountSpan").text("");
        return true;
        }
    }
}