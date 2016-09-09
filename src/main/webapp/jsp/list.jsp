<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--引入jstl-->
<%@include file="common/tag.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>秒杀列表页</title>
    <%@include file="common/head.jsp" %>
</head>
<body>
<!--页面显示部分-->
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h2>秒杀列表</h2>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>房源编号</th>
                    <th>房源名称</th>
                    <th>秒杀倒计时</th>
                    <th>房源类型</th>
                    <th>房源面积</th>
                    <th>几室</th>
                    <th>几厅</th>
                    <th>几卫</th>
                    <th>秒杀开启时间</th>
                    <th>秒杀结束时间</th>
                </tr>
                </thead>
                <tbody id = "dataList">

                </tbody>
            </table>
        </div>
    </div>
</div>
<div id="killPhoneModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h3 class="modal-title text-center">
                    <span class="glyphicon glyphicon-phone"></span>
                </h3>
            </div>

            <div class="modal-body">
                <div class="row">
                    <div class="col-xs-8 col-xs-offset-2">
                        <input type="text" name="killPhone" id="killPhoneKey" placeholder="填写用户编号" class="form-control"/>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <span id="killPhoneMessage" class="glyphicon"></span>
                <button type="button" id="killPhoneBtn" class="btn btn-success">
                    <span class="glyphicon glyphicon-phone">
                        Submit
                    </span>
                </button>
            </div>
        </div>
    </div>
</div>

</body>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script
        src="http://cdnjs.cloudflare.com/ajax/libs/jquery.countdown/2.1.0/jquery.countdown.min.js"></script>
<script>



    $(function () {
        apartment.initData();
    });


    var apartment;
    apartment = {
        //封装秒杀相关的URL
        URL: {
            data: function () {
                return '/qzw/rest/apartment/list';
            },
            exposer: function (aparId) {
                return '/qzw/rest/apartment/seckill/' + aparId + '/exposer';
            },
            new: function () {
                return '/qzw/rest/apartment/seckill/time/now';
            },
            execution: function (aparId, md5) {
                return '/qzw/rest/apartment/seckill/' + aparId + '/' + md5 + '/execution';
            }
        },
        initData: function () {

           $.ajax({
               url: apartment.URL.data(),
               contentType: "application/json; charset=utf-8",
               dataType: "json", //返回的数据类型,text 或者 json数据，建议为json
               type: "post", //传参方式，get 或post
               data: JSON.stringify({
                   "currentPage":"0",
                   "pageSize":"10"
               }),
               //传过去的参数，格式为 变量名：变量值
               success: function(data,status) { //若Ajax处理成功后的回调函数，text是返回的页面信息
                   console.log(data);
                   var dataList = $("#dataList");
                   var dataListHTML = "";
                   for (var i in data["list"]){
                       dataListHTML += '<tr id = '+data["list"][i]["aparId"]+'>';
                       dataListHTML += '<td>'+data["list"][i]["aparId"]+'</td>';
                       dataListHTML += '<td>'+data["list"][i]["aparName"]+'</td>';
                       dataListHTML += '<td class="runTime">加载中。。</td>';
                       dataListHTML += '<td>'+data["list"][i]["aparType"]+'</td>';
                       dataListHTML += '<td>'+data["list"][i]["area"]+'</td>';
                       dataListHTML += '<td>'+data["list"][i]["room"]+'</td>';
                       dataListHTML += '<td>'+data["list"][i]["hall"]+'</td>';
                       dataListHTML += '<td>'+data["list"][i]["toilet"]+'</td>';
                       dataListHTML += '<td>'+apartment.formatdate(data["list"][i]["startTime"],"yyyy-MM-dd HH:mm:ss")+'</td>';
                       dataListHTML += '<td>'+apartment.formatdate(data["list"][i]["endTime"],"yyyy-MM-dd HH:mm:ss")+'</td>';
                       dataListHTML += '</tr>';
                   }
                   dataList.html(dataListHTML);

                    //计时交互
                    for (var i in data["list"]) {
                        apartment.initTime({
                            starTime: data["list"][i]["startTime"],
                            endTime: data["list"][i]["endTime"],
                            aparId: data["list"][i]["aparId"]
                        });
                    }

//                   $("#dataList tr").click(function(){
//                       var aparId = $(this).attr("id");
//                       window.location.href = "http://localhost:8080/qzw/rest/apartment/"+aparId+"/detail";
//                   });

                },
                error: function (request, status, message) {  //若Ajax处理失败后回调函数，msg是返回的错误信息

                }
            });
        },
        handleSeckillkill: function (aparId, node) {
            //处理秒杀逻辑
            node.hide().html('<button id="' + aparId + '_killbtn">开始秒杀</button>');
            $.post(apartment.URL.exposer(aparId), {}, function (result) {
                //回调函数中，执行交互流程
                if (result && result['success']) {
                    var exposer = result['date'];
                    if (exposer['exposed']) {
                        //开启秒杀
                        //获取秒杀的地址
                        var md5 = exposer['md5']
                        var killUrl = apartment.URL.execution(aparId, md5);
                        console.log("killUrl:" + killUrl);
                        //绑定一次点击事件
                        $("#" + aparId + "_killbtn").one('click', function () {
                            //执行秒杀请求
                            //1.禁用按钮
                            $(this).addClass('disabled');
                            //2.发送秒杀请求
                            $.post(killUrl + "?userId=" + sessionStorage.userId, {}, function (result) {
                                console.log(result);
                                if (result && result['success']) {
                                    var killResult = result['date'];
                                    var state = killResult['state'];
                                    var stateInfo = killResult['stateInfo'];
                                    //3.显示秒杀结构
                                    node.html('<span>' + stateInfo + '</span>');
                                }
                            });
                        });
                        node.show();
                    } else {
                        //未开启秒杀
                        var now = exposer['now'];
                        var start = exposer['start'];
                        var end = exposer['end']
                        //重新计算计时逻辑
                        apartment.countdown(aparId, now, start, end);
                    }
                } else {
                    console.log("result:" + result);
                }
            });
        },
        countdown: function (aparId, nowTime, starTime, endTime) {
            var aparObj = $("#" + aparId).children(".runTime");
            if (nowTime > endTime) {
                //秒杀结束
                aparObj.html("秒杀结束!");
            } else if (nowTime < starTime) {
                //秒杀未开始，计时时间绑定
                var killTime = new Date(starTime + 1000);
                aparObj.countdown(killTime, function (event) {
                    //时间格式
                    //var format = event.strftime('秒杀倒计时： %D天 %H时 %M分 %S秒');
                    var format = event.strftime(' %D天 %H时 %M分 %S秒');
                    aparObj.html(format);
                    /**
                     * 时间完成后回调事件
                     */
                }).on('finish.countdown', function () {
                    //获取秒杀地址，控制实现逻辑，执行秒杀
                    apartment.handleSeckillkill(aparId, aparObj);
                });
                aparObj.html("秒杀未开始!");
            } else {
                //秒杀开始
                apartment.handleSeckillkill(aparId, aparObj);
            }
        },
        //验证用户编号
        validateUserId: function (userId) {
            if (userId && userId.length == 6 && !isNaN(userId)) {
                return true;
            } else {
                return false;
            }
        },
        //计时
        initTime: function (params) {

            //用户手机验证和登录，计时交互
            //规划我们的交互流程
            //没有登录后端，在sessionStorage查找用户编号
            var userId = sessionStorage.userId;
            //验证用户编号
            if (!apartment.validateUserId(userId)) {
                //如果没登录就是FALSE,绑定用户编号
                //控制输出

                var killPhoneModal = $('#killPhoneModal');
                killPhoneModal.modal({
                    show: true,//显示弹出层
                    backdrop: 'static',//禁止位置关闭
                    keyboard: false//关闭键盘事件
                });
                $('#killPhoneBtn').click(function () {
                    var userId = $('#killPhoneKey').val();
                    if (apartment.validateUserId(userId)) {
                        //用户编号写入COOKIE
                        sessionStorage["userId"] = userId;
                        //刷新页面
                        window.location.reload();
                    } else {
                        $('#killPhoneMessage').hide().html('<label class="label label-danger">用户编号错误！长度为6</label>').show(300);
                    }
                });

            }


            //计时交互
            var starTime = params['starTime'];
            var endTime = params['endTime'];
            var aparId = params['aparId'];

            $.get(apartment.URL.new(), {}, function (result) {
                //
                if (result && result['success']) {
                    var nowTime = result['date'];
                    //时间判断,计时交互
                    apartment.countdown(aparId, nowTime, starTime, endTime)
                } else {
                    console.log('result:' + result);
                }
            })
        },
        //格式化时间
        formatdate: function (date, format) {
            if (!date) return;
            if (!format) format = "yyyy-MM-dd";
            switch (typeof date) {
                case "string":
                    date = new Date(date.replace(/-/, "/"));
                    break;
                case "number":
                    date = new Date(date);
                    break;
            }
            if (!date instanceof Date) return;
            var dict = {
                "yyyy": date.getFullYear(),
                "M": date.getMonth() + 1,
                "d": date.getDate(),
                "H": date.getHours(),
                "m": date.getMinutes(),
                "s": date.getSeconds(),
                "MM": ("" + (date.getMonth() + 101)).substr(1),
                "dd": ("" + (date.getDate() + 100)).substr(1),
                "HH": ("" + (date.getHours() + 100)).substr(1),
                "mm": ("" + (date.getMinutes() + 100)).substr(1),
                "ss": ("" + (date.getSeconds() + 100)).substr(1)
            };
            return format.replace(/(yyyy|MM?|dd?|HH?|ss?|mm?)/g, function () {
                return dict[arguments[0]];
            });
        }
    };

</script>
</html>
