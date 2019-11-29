
function togo(obj){
    $(".icon5").hide();
    $('.coin11').hide();
    $('.coin22').show();
    $(obj).find('.coin11').show();
    $(obj).find('.coin22').hide();
    $(".leftsidebar_box .cks").removeClass('menu_chioce2');
    if ($(obj).find('.icon5').is(":hidden")) {
        $(obj).addClass('menu_chioce2');
        $(obj).find('.icon5').show();
    } else {
        $(obj).removeClass('menu_chioce2');
        $(obj).find('.icon5').hide();
    }
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