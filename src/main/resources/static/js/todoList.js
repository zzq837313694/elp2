
function togo(obj){
    // 先处理掉所有存在的节点,再判断是否存在
    $('.icon3').hide();
    $('.icon4').show();
    $(".icon5").hide();
    $('.coin11').hide();
    $('.coin22').show();
    $(obj).find('.coin11').show();
    $(obj).find('.coin22').hide();
    $(obj).children('.icon5').show();
    $(obj).siblings('dt').find('.icon3');
}

function gotoPage(url) {
    var lifeBody = window.parent.frames[1].document.getElementById('bg').getElementsByClassName('container');
    $(lifeBody).find('dd').each(function (index, item) {
        if ($(item).find('a').attr('href') == url) {
            $(item).siblings('dt').click();
            togo(item);
            window.parent.frames[2].location.href = "/" + url;

        }

    });
}