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

function showModal(obj) {
    /*模态框显示*/
    $.post({
        url: "/chooseCheckWorker",
        data: "taskNo=" + $(obj).attr("id"),
        dataType: "json",
        success: function (workMap) {
            $('#modelLeft li,#modelRight li').remove();
            $.each(workMap.leftWorker, function (index, worker) {
                var workerLi = "<li onclick=\"isCheack(this)\">"+worker.userNo+"--"+worker.userName+"</li>"
                $('#modelLeft').append(workerLi)
            })
            $.each(workMap.rightWorker, function (index, worker) {
                var workerLi = "<li onclick=\"isCheack(this)\">"+worker.userNo+"--"+worker.userName+"</li>"
                $('#modelRight').append(workerLi)
            })
        }
    });
}