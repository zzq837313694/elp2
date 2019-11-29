/*分页*/

$(".zxf_pagediv").createPage({
    pageNum: $("#pageCount").val(),
    current: $("#returnpageIndex").val(),
    backfun: function (e) {
    }
});

function updataTask(obj) {
    alert("修改" + $(obj).parents("tr").find('td').eq(0).text());
}

/*审查任务*/
function review(obj) {
    alert("审查" + $(obj).parents("tr").find('td').eq(0).text());
}

/*删除任务*/
function deleteTask(obj) {
    alert("删除" + $(obj).parents("tr").find('td').eq(0).text());
}


/*修改消缺任务*/
function assigningTask(obj) {
    var worker = "";
    $('#modelRight li').each(function (index, item) {
        worker = worker + "," + $(item).text().split("--")[0];
    });
    if (worker != "") {
        $.post({
            url: "updateSovleTaskfinishWorker",
            data: "TaskNo=" + $(obj).attr('name') + "&finishWorker=" + worker,
            success: function (data) {
                if (data == 1) {
                    popup({
                        type: 'success', msg: "添加成功", delay: 1000, callBack: function () {
                            window.location.href = "/AdminSolveTask.html";
                        }
                    });

                }
            }

        })
    }

}