function checkuserNo() {
    var userNo=$("#userNo").val();
    if (userNo==null ||userNo==""){
        $("#UpdateuserNo").text("不能为空");
        return false;
    } else {
        $("#UpdateuserNo").text("*");
        return true;
    }
}

function checkOldpassword() {
    var Oldpassword=$("#Oldpassword").val();
    var Oldpassword1=$("#Oldpassword1").val();
    if (Oldpassword==null||Oldpassword==""){
        $("#UpdateOldpassword").text("不能为空");
        return  false;
    }else if (Oldpassword==Oldpassword1){
            $("#UpdateOldpassword").text("*");
            return true;
    }else {
        $("#UpdateOldpassword").text("输入密码与旧密码不符");
        return false;
    }

}

function checkpassword() {
    var password=$("#password").val();
    if (password==null || password==""){
        $("#Updatepassword").text("不能为空");
        return false
    }else {
        $("#Updatepassword").text("*");
        return true;
    }
}
function checkNewpassword() {
    var Newpassword=$("#Newpassword").val();
    var password=$("#password").val();
    if (Newpassword==""|| Newpassword==null){
        $("#UpdateNewpassword").text("不能为空");
        return false
    }else if (Newpassword!=password){
            $("#UpdateNewpassword").text("两次密码不一致");
            return  false;
    } else {
        $("#UpdateNewpassword").text("*");
        return true;
    }
}

function checktel() {
    var tel=$("#tel").val();
    if (tel==null||tel==""){
        $("#UpdateTEL").text("不能为空");
        return false;
    } else {
        var  re = /^1\d{10}$/;
        if (!re.test(tel)){
            $("#UpdateTEL").text("请输入正确的11位数");
            return false;
        }else {
            $("#UpdateTEL").text("*");
            return true;
        }
    }
}

function checkemail() {
    var email=$("#email").val();
    if (email==null||email==""){
        $("#Updateemail").text("不能为空");
        return false;
    } else {
        var  re = /^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*\.[a-zA-Z0-9]{2,6}$/;
        if (!re.test(email)){
            $("#Updateemail").text("请输入正确格式");
            return false;
        }else {
            $("#Updateemail").text("*");
            return true;
        }
    }
}


$(function () {
    $("#userNo").blur(checkuserNo);
    $("#Oldpassword").blur(checkOldpassword);
    $("#password").blur(checkpassword);
    $("#tel").blur(checktel);
    $("#email").blur(checkemail);
    $("#Newpassword").blur(checkNewpassword);
});


$("#myUpdateWorker").submit(function () {
    var flag=true;
    if(!checkuserNo())flag=false;
    if (!checkOldpassword())flag=false;
    if (!checkNewpassword())flag=false;
    if (!checkpassword())flag=false;
    if (!checktel())flag=false;
    if (!checkemail())flag=false;
    return flag;
});