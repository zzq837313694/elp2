
//消缺员回传
function sovleWorkerBackData(){
    $('textarea[id="solveWorker"]').val("");
    $('#modelRight li').each(function (index, item) {
        $('textarea[id="solveWorker"]').val($('textarea[id="solveWorker"]').val()+"  >"+item.innerText);
    });
}


//消缺列表回传显示
function flawInfoBackData() {
    $("#sovleFlawTable tbody *").remove();
    $('.flaw:checkbox:checked').each(function (index, item) {
        var tr = $("<tr></tr>");
        var tds = $(item).parents("tr").html();
        tr.append(tds);
        tr.find(".flaw").parent().remove();
        $("#sovleFlawTable tbody").append(tr);
        tr = $("<tr></tr>");
    });
}


//保存提交制定任务
function saveSovleTask() {
    var sovleTaskNo=$('input[name="sovleTaskNo"]').val();
    var sovleTaskName=$('input[name="sovleTaskName"]').val();
    var documents=$('select[name="documents"]').val();
    var manager=$('select[name="manager"]').val();
    var creatBy=$('input[name="creatBy"]').val();
    var creatDate=$('input[name="creatDate"]').val();
    var describe=$('textarea[name="describe"]').val();
    var comment=$('textarea[name="comment"]').val();
    var solveWorker=$('textarea[name="solveWorker"]').val();
    var floawList="";
    $("#sovleFlawTable tbody tr").each(function (index, item) {
        floawList=floawList+$(item).children()[0].innerText+",";
    });
    var requestData="solveTaskNo="+sovleTaskNo+"&solveTaskName="+sovleTaskName+"&documents="+documents
        +"&manager="+manager+"&creatBy="+creatBy+"&createDate="+creatDate+"&describe="+describe+"&comment="+comment
        +"&solveWorker="+solveWorker+"&floawList="+floawList;
    $.post({
        url:"/saveSovleTask",
        data:requestData,
        dataType: 'text',
        success:function (data) {

            document.url="/AdminSolveTask.html";
        },
        error:function (erroMsg) {
            alert(erroMsg);
        }
    });
}


function checkAllFlaw(obj) {
    $("input[class='flaw']").attr("checked", obj.checked);
}

function findFlaws(i) {
    var requestdata;
    if (i == 1) {
        requestdata = "checkJobNo=" + $('input[name="checkJobNo"]').val()
            + "&circuitNo=" + $('input[name="circuitNo"]').val()
            + "&flawTypeId=" + $('select[name="flawTypeId"]').val()
            + "&flawLv=" + $('select[name="flawLv"]').val()
            + "&startTime=" + $('input[name="startTime"]').val()
            + "&endTime=" + $('input[name="endTime"]').val();
    }
    $.post({
        url: "findFlaws",
        data: requestdata,
        dataType: "",
        success: function (flaws) {
            $("#flawTable tbody").text("");
            $.each(flaws, function (index, flaw) {
                var flawTr = " <tr><td><input type=\"checkbox\" id=\'" + flaw.flawNo + "\' name=\'" + flaw.flawNo + "\' class=\'flaw\'>" +
                    "                        </td>\n<td>" + flaw.flawNo + "</td>\n" +
                    "                        <td>" + flaw.towerNo + "</td>\n" +
                    "                        <td>" + flaw.flawLv + "</td>\n" +
                    "                        <td>" + flaw.flawTypeId + "</td>\n" +
                    "                        <td>" + flaw.comment + "</td>\n" +
                    "                        <td>" + flaw.checkBy + "</td>\n" +
                    "                        <td>" + flaw.checkDate + "</td></tr>";
                $("#flawTable tbody").append(flawTr);
            });
        }
    })
}
