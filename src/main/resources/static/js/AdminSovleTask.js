
/*分页*/

$(".zxf_pagediv").createPage({
    pageNum: $("#pageCount").val(),
    current: $("#returnpageIndex").val(),
    backfun: function(e) {
    }
});


/*修改消缺任务*/
function updateTask(obj) {
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

function updataTask(obj) {


}