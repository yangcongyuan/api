<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <script src="jquery-2.2.4.min.js" type="text/javascript"></script>
</head>
<script>
    function showList() {
        $.ajax({
            url: "http://localhost:8080/qzw/rest/apartment/list",
            contentType: "application/json; charset=utf-8",
            dataType: "json", //返回的数据类型,text 或者 json数据，建议为json
            type: "post", //传参方式，get 或post
            data: JSON.stringify({
                "currentPage":"0",
                "pageSize":"10",
                "type":"3",
                "searchText":"一",
                "houseType":"4"
            }),
            //传过去的参数，格式为 变量名：变量值
            success: function(data,status) { //若Ajax处理成功后的回调函数，text是返回的页面信息
                console.log(data);
//                console.log("this is success! data:"+data,",status="+status);
//                var jsonText = JSON.stringify(data);
//                console.log(jsonText);
            },
            error: function(request,status,message){  //若Ajax处理失败后回调函数，msg是返回的错误信息
            }
        });
    }

    function newsList() {
        $.ajax({
            url: "http://localhost:8080/qzw/rest/news/newsList",
            contentType: "application/json; charset=utf-8",
            dataType: "json", //返回的数据类型,text 或者 json数据，建议为json
            type: "post", //传参方式，get 或post
            data: JSON.stringify({
                "currentPage":"0",
                "pageSize":"10",
                "publish":"1",

            }),
            //传过去的参数，格式为 变量名：变量值
            success: function(data,status) { //若Ajax处理成功后的回调函数，text是返回的页面信息
                console.log(data);

            },
            error: function(request,status,message){  //若Ajax处理失败后回调函数，msg是返回的错误信息
            }
        });
    }

    function selectId() {
        $.ajax({
            url: "http://localhost:8080/qzw/rest/news/selectId",
            contentType: "application/json; charset=utf-8",
            dataType: "json", //返回的数据类型,text 或者 json数据，建议为json
            type: "post", //传参方式，get 或post
            data: JSON.stringify({
                "id":"5",

            }),
            //传过去的参数，格式为 变量名：变量值
            success: function(data,status) { //若Ajax处理成功后的回调函数，text是返回的页面信息
                console.log(data);
                console.log("this is success! data:" + data, ",status=" + status);
                var jsonText = JSON.stringify(data)
                document.write(jsonText);
            },
            error: function(request,status,message){  //若Ajax处理失败后回调函数，msg是返回的错误信息
                console.log(request);
                console.log("this is error! request:" + request + ",status:" + status + ",message:" + message);
                var errrorText = request.responseText;
                var errrorText = eval('(' + errrorText + ')');
                console.log(errrorText[0]["message"]);
            }
        });
    }

    function insert() {
        $.ajax({
            url: "http://localhost:8080/qzw/rest/message/insert",
            contentType: "application/json; charset=utf-8",
            dataType: "json", //返回的数据类型,text 或者 json数据，建议为json
            type: "post", //传参方式，get 或post
            data: JSON.stringify({
                "sendId":"1",
                "message":"雀氏纸尿裤",
                "title":"棋子湾",
                "recId":"2",
            }),
            //传过去的参数，格式为 变量名：变量值
            success: function(data,status) { //若Ajax处理成功后的回调函数，text是返回的页面信息
                console.log(data);
                console.log("this is success! data:" + data, ",status=" + status);
                var jsonText = JSON.stringify(data)
                document.write(jsonText);
            },
            error: function(request,status,message){  //若Ajax处理失败后回调函数，msg是返回的错误信息
                console.log(request);
                console.log("this is error! request:" + request + ",status:" + status + ",message:" + message);
                var errrorText = request.responseText;
                var errrorText = eval('(' + errrorText + ')');
                console.log(errrorText[0]["message"]);
            }
        });
    }

    function updateById() {
        $.ajax({
            url: "http://localhost:8080/qzw/rest/message/updateById",
            contentType: "application/json; charset=utf-8",
            dataType: "json", //返回的数据类型,text 或者 json数据，建议为json
            type: "post", //传参方式，get 或post
            data: JSON.stringify({
                "id":"30",

            }),
            //传过去的参数，格式为 变量名：变量值
            success: function(data,status) { //若Ajax处理成功后的回调函数，text是返回的页面信息
                console.log(data);
                console.log("this is success! data:" + data, ",status=" + status);
                var jsonText = JSON.stringify(data)
                document.write(jsonText);
            },
            error: function(request,status,message){  //若Ajax处理失败后回调函数，msg是返回的错误信息
                console.log(request);
                console.log("this is error! request:" + request + ",status:" + status + ",message:" + message);
                var errrorText = request.responseText;
                var errrorText = eval('(' + errrorText + ')');
                console.log(errrorText[0]["message"]);
            }
        });
    }

    function statueList() {
        $.ajax({
            url: "http://localhost:8080/qzw/rest/message/statueList",
            contentType: "application/json; charset=utf-8",
            dataType: "json", //返回的数据类型,text 或者 json数据，建议为json
            type: "post", //传参方式，get 或post
            data: JSON.stringify({
                "statue":"2",
                "currentPage":"0",
                "pageSize":"10"

            }),
            //传过去的参数，格式为 变量名：变量值
            success: function(data,status) { //若Ajax处理成功后的回调函数，text是返回的页面信息
                console.log(data);
                console.log("this is success! data:" + data, ",status=" + status);
                var jsonText = JSON.stringify(data)
                document.write(jsonText);
            },
            error: function(request,status,message){  //若Ajax处理失败后回调函数，msg是返回的错误信息
                console.log(request);
                console.log("this is error! request:" + request + ",status:" + status + ",message:" + message);
                var errrorText = request.responseText;
                var errrorText = eval('(' + errrorText + ')');
                console.log(errrorText[0]["message"]);
            }
        });
    }

    function insertAttention() {
        $.ajax({
            url: "http://localhost:8080/qzw/rest/attention/insertAttention",
            contentType: "application/json; charset=utf-8",
            dataType: "json", //返回的数据类型,text 或者 json数据，建议为json
            type: "post", //传参方式，get 或post
            data: JSON.stringify({
                "userId":"5",
                "attentionNo":"5",


            }),
            //传过去的参数，格式为 变量名：变量值
            success: function(data,status) { //若Ajax处理成功后的回调函数，text是返回的页面信息
                console.log(data);
                console.log("this is success! data:" + data, ",status=" + status);
                var jsonText = JSON.stringify(data)
                document.write(jsonText);
            },
            error: function(request,status,message){  //若Ajax处理失败后回调函数，msg是返回的错误信息
                console.log(request);
                console.log("this is error! request:" + request + ",status:" + status + ",message:" + message);
                var errrorText = request.responseText;
                var errrorText = eval('(' + errrorText + ')');
                console.log(errrorText[0]["message"]);
            }
        });
    }

    function getList() {
        $.ajax({
            url: "http://localhost:8080/qzw/rest/attention/getList",
            contentType: "application/json; charset=utf-8",
            dataType: "json", //返回的数据类型,text 或者 json数据，建议为json
            type: "post", //传参方式，get 或post
            data: JSON.stringify({
                "userId":"1",
                "currentPage":"0",
                "pageSize":"10",


            }),
            //传过去的参数，格式为 变量名：变量值
            success: function(data,status) { //若Ajax处理成功后的回调函数，text是返回的页面信息
                console.log(data);
                console.log("this is success! data:" + data, ",status=" + status);
                var jsonText = JSON.stringify(data)
                document.write(jsonText);
            },
            error: function(request,status,message){  //若Ajax处理失败后回调函数，msg是返回的错误信息
                console.log(request);
                console.log("this is error! request:" + request + ",status:" + status + ",message:" + message);
                var errrorText = request.responseText;
                var errrorText = eval('(' + errrorText + ')');
                console.log(errrorText[0]["message"]);
            }
        });
    }

    function deleteById() {
        $.ajax({
            url: "http://localhost:8080/qzw/rest/attention/deleteById",
            contentType: "application/json; charset=utf-8",
            dataType: "json", //返回的数据类型,text 或者 json数据，建议为json
            type: "post", //传参方式，get 或post
            data: JSON.stringify({
                "id":"30",

            }),
            //传过去的参数，格式为 变量名：变量值
            success: function(data,status) { //若Ajax处理成功后的回调函数，text是返回的页面信息
                console.log(data);
                console.log("this is success! data:" + data, ",status=" + status);
                var jsonText = JSON.stringify(data)
                document.write(jsonText);
            },
            error: function(request,status,message){  //若Ajax处理失败后回调函数，msg是返回的错误信息
                console.log(request);
                console.log("this is error! request:" + request + ",status:" + status + ",message:" + message);
                var errrorText = request.responseText;
                var errrorText = eval('(' + errrorText + ')');
                console.log(errrorText[0]["message"]);
            }
        });
    }
</script>
<body>
<div id="error"></div>
    <input type="button" value="获取房源列表" onclick="showList()">
    <input type="button" value="获取新闻列表" onclick="newsList()">
    <input type="button" value="获取新闻详细信息" onclick="selectId()">
    <input type="button" value="添加站内信" onclick="insert()">
    <input type="button" value="删除站内信" onclick="updateById()">
    <input type="button" value="站内信列表" onclick="statueList()">
    <input type="button" value="添加关注" onclick="insertAttention()">
    <input type="button" value="我关注的列表" onclick="getList()">
    <input type="button" value="取消关注" onclick="deleteById()">

</body>
</html>
