function isCheack(obj) {
    $(obj).toggleClass("active")
}

/*添加消缺员*/
function addpeople(){
    var  leftLi=$('#modelLeft li[class="active"]');
    leftLi.removeClass("active");
    $('#modelRight').append(leftLi)

}
/*移除消缺员*/
function removepeople(){
    var  leftLi=$('#modelRight li[class="active"]');
    leftLi.removeClass("active");
    $('#modelLeft').append(leftLi)
}

