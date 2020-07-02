<%--
  Created by IntelliJ IDEA.
  User: 33279
  Date: 2020/5/24
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成绩排名</title>
    <link href="../layui/css/layui.css" rel="stylesheet">
    <link href="../css/classRank_css.css" rel="stylesheet">
    <script src="../jq/jquery-3.4.1.min (1).js"></script>
    <script src="/static/jq/jquery.cookie.js"></script>
</head>
<body>
<%--        头部导航栏--%>
<div  style="width: 100%;height: 62px;background-color: #363c40;">
    <div class="layui-col-md10 layui-col-md-offset1">
        <ul class="layui-nav" lay-filter="" style="background-color: #363c40;">
            <li  class="layui-nav-item"><a href="" style="font-size:20px">在线考试系统</a></li>
            <li class="layui-nav-item" style="float:right">
                <a href="">我</a>
                <dl class="layui-nav-child">
                    <dd><a href="personalHomepage (1).jsp">个人界面</a></dd>
                    <dd><a href="login.html" onclick="exit()">退出</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item" style="float:right">
                <a href="学生端主页.html">个人主页 |<span class="layui-badge-dot"></span></a>
            </li>
            <li class="layui-nav-item" style="float:right">
                <a href="message.html"><i class="layui-icon layui-icon-email" style="font-size: 16px; color: #47a7ef;">消息 </i> <span class="layui-badge">1</span> |</a>
            </li>
        </ul>
    </div>
</div>
<%--侧面个人成绩分析--%>
    <div class="main">
        <div class="main_left">
            <img src="../images/haimianbaobao1.jpg">
            <div>
                <label class="layui-form-label">姓名:</label>
                <div id="myName">张三</div>
            </div>
            <div>
                <label class="layui-form-label">考试科目:</label>
                <div id="mySubject">软件工程</div>
            </div>
            <div>
                <label class="layui-form-label">此次考试成绩:</label>
                <div id="myGrade">99</div>
            </div>
        </div>
        <div class="layui-tab" style=" width: 78%;margin-top: 30px;" lay-filter="score">
            <ul class="layui-tab-title">
                <li class="layui-this">班级排名</li>
                <li>年级排名</li>
            </ul>
            <div class="layui-tab-content">
                <div class="layui-tab-item layui-show">
                    <div class="layui-form-item">
                        <button type="button" class="layui-btn layui-btn-normal" style="float: right" id="serachbut"><i class="layui-icon layui-icon-search" style="font-size: 14px;"></i>查找</button>
                        <div class="layui-input-inline" style="float: right">
                            <input type="text" name="search" placeholder="请输入关键字" class="layui-input" id="serach">
                        </div>
                    </div>
                    <table class="layui-hide" id="classRankShow"></table>
                </div>
                <div class="layui-tab-item">
                    <div class="layui-form-item">
                        <button type="button" class="layui-btn layui-btn-normal" style="float: right" id="serachbut2"><i class="layui-icon layui-icon-search" style="font-size: 14px;"></i>查找</button>
                        <div class="layui-input-inline" style="float: right">
                            <input type="text" name="search" placeholder="请输入关键字" class="layui-input" id="serach2">
                        </div>
                    </div>
                    <table class="layui-hide" id="classRankShow2"></table>
                </div>
            </div>
        </div>
    </div>

    <script src="/static/js/common.js"></script>
    <script src="../layui/layui.js"></script>
    <script src="../js/classRank_js.js"></script>
</body>
<script>
    function exit() {
        $.cookie('userEmail', '', { expires: -1 }); // 删除 cookie
        $.cookie('token', '', { expires: -1 }); // 删除 cookie
        $.cookie('examname', '', { expires: -1 }); // 删除 cookie
    }
</script>
</html>
