<%--
  Created by IntelliJ IDEA.
  User: 33279
  Date: 2020/5/24
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>历史考试</title>
    <script src="../jq/jquery-3.4.1.min (1).js"></script>
    <script src="../jq/jquery.cookie.js"></script>
    <script src="../js/common.js"></script>
    <link href="../layui/css/layui.css" rel="stylesheet">
    <link href="../css/historyTest_css.css" rel="stylesheet">
</head>
<body>
    <%--        头部导航栏--%>
    <div  style="width: 100%;height: 62px;background-color: #363c40;">
        <div class="layui-col-md10 layui-col-md-offset1">
            <ul class="layui-nav" lay-filter="" style="background-color: #363c40;">
                <li  class="layui-nav-item"><a href="" style="font-size:20px">在线考试系统</a></li>
                <li class="layui-nav-item"><a href="历史成绩查询.html">历史成绩查询</a></li>
                <li class="layui-nav-item "><a href="classRank.jsp">成绩排名</a></li>
                <!--            <li class="layui-nav-item"><a id="studentWrongNav">错题分析</a></li>-->
                <!--            <li class="layui-nav-item">-->
                <!--                <a >年级排名</a>-->
                <!--            </li>-->
                <li class="layui-nav-item layui-this"><a href="historyTest.jsp">历史试卷查询</a></li>
                <li class="layui-nav-item" style="float:right">
                    <a>我</a>
                    <dl class="layui-nav-child">
                        <!--                    <dd><a id="modifyNav">修改信息</a></dd>-->
                        <dd><a class="personalHomepageNav ">个人中心</a></dd>
                        <dd><a id="loginNav">退出</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item" style="float:right">
                    <a href="学生端主页.html">学生首页 |<span class="layui-badge-dot"></span></a>
                </li>
                <li class="layui-nav-item" style="float:right">
                    <a href="message.html"><i class="layui-icon layui-icon-email" style="font-size: 16px; color: #47a7ef;">消息 </i> <span class="layui-badge">1</span> |</a>
                </li>
            </ul>
        </div>

    <div id="histoyTestShow">
        <div class="layui-form-item">
            <button type="button" class="layui-btn layui-btn-normal" style="float: right"><i class="layui-icon layui-icon-search" style="font-size: 14px;"></i>查找</button>
            <div class="layui-input-inline" style="float: right">
                <input type="text" name="search" placeholder="请输入关键字" class="layui-input">
            </div>
        </div>
        <table class="layui-hide" id="histoyTestShow_table" lay-filter="test"></table>
    </div>

<%--    历史考试回看--%>
    <script id="see" type="text/html">
        <a class="layui-btn layui-btn-radius layui-btn-normal" lay-event="edit">
            <i class="layui-icon layui-icon-read" style="font-size: 14px;"></i> 查看
        </a>
    </script>
    <script src="../layui/layui.js"></script>
    <script src="../js/historyTest_js.js"></script>
</body>
<script>
    $(document).ready(function () {
            var data = {
                useremail:$.cookie("userEmail")
            }
            alert($.cookie("userEmail"));
            AJAX.get1("/checkUser",data,function (res) {
                if (res.flag){
                    var obj = res['map']['obj'];
                    if (obj['userType']!=1){
                        alert("权限不足");
                        location.href = "login.html";
                    }
                }
                else {
                    alert(res.msg);
                    location.href = "login.html";
                }

            })
        }
    )
    layui.use('form', function(){
        var form = layui.form;
        form.on('submit(formDemo)', function(data){
            layer.msg(JSON.stringify(data.field));
            return false;
        });

        //nav导航栏
        //修改信息
        $(document).on('click','#modifyNav',function () {
            alert($.cookie("userEmail"));
            window.location.href="modify.html";
        })
        //个人中心
        $(document).on('click','.personalHomepageNav',function () {
            alert($.cookie("userEmail"));
            window.location.href="personalHomepage (1).jsp";
        })
        //退出
        $(document).on('click','#modifyNav',function () {
            alert($.cookie("userEmail"));
            $.cookie("userEmail", "",'/');
            alert($.cookie("userEmail"));
            window.location.href="login.html";
        })
        //错题分析
        //上面已经存好了最近考试名
        $(document).on('click','#studentWrongNav',function () {
            alert($.cookie("examName"));
            window.location.href="student_wrong_questions.html";
        })
    });
</script>
</html>
