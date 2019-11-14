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