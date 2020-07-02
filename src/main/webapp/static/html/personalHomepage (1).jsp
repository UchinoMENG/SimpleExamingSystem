<%--
  Created by IntelliJ IDEA.
  User: 33279
  Date: 2020/5/23
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人主页</title>
    <script src="../jq/jquery-3.4.1.min (1).js"></script>
    <link href="../layui/css/layui.css" rel="stylesheet">
    <script src="../jq/jquery.cookie.js"></script>
    <link href="../css/personalHomepage_css.css" rel="stylesheet">
</head>
<%--rgb(219,239,252)--%>
<body style="background-color: rgb(245, 247, 249); ">
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
<div class="layui-row">
    <%--侧边导航--%>
    <div class="layui-col-md2" style="width: 18%;">
        <ul class="layui-nav layui-nav-tree left_nav" lay-filter="left_nav" style="height:100%">
            <!-- 侧边导航: <ul class="layui-nav layui-nav-tree layui-nav-side"> -->
            <li class="layui-nav-item left_nav_goback" id="returnHome">
                <a href="javascript:;" ><i class="layui-icon layui-icon-return" style="font-size: 14px;"></i>返回首页</a>
            </li>
            <li class="layui-nav-item firstshow">
                <a href="javascript:;"><i class="layui-icon layui-icon-username" style="font-size: 14px;"></i>个人信息</a>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;"><i class="layui-icon layui-icon-key" style="font-size: 14px;"></i>账号资料</a>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;"><i class="layui-icon layui-icon-template-1" style="font-size: 14px;"></i>课程信息</a>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;"><i class="layui-icon layui-icon-senior" style="font-size: 14px;"></i>绑定信息</a>
            </li>
        </ul>
    </div>
    <%--主图面板--%>
    <div class="layui-col-md8" style="width: 82%;">
        <%--            个人信息界面--%>
        <div class="layui-card main_panel" id="left_nav_personal">
            <div class="layui-card-header">个人信息</div>
            <%--                个人信息表单内容--%>
            <div class="layui-card-body">
                <form class="layui-form" action="">
                    <div class="layui-form-item">
                        <label class="layui-form-label">姓名</label>
                        <div id="username" class="layui-form-mid layui-input-inline"></div>
                        <button class="layui-btn layui-btn-normal layui-btn-sm" type="button" id="editName">编辑</button>
                        <%--                            点击编辑出现--%>
                        <div class="layui-input-inline modify">
                            <input type="text" name="username" required  lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input">
                            <div class="buttonGroup">
                                <button class="layui-btn layui-btn-primary layui-btn-sm" type="button" id="cancleName">取消</button>
                                <button class="layui-btn layui-btn-normal layui-btn-sm" type="button" id="saveName">保存</button>
                            </div>
                        </div>
                    </div>
                    <%--                        性别--%>
                    <div class="layui-form-item">
                        <label class="layui-form-label">性别</label>
                        <div id="sex" class="layui-form-mid layui-input-inline"></div>
                        <button class="layui-btn layui-btn-normal layui-btn-sm" type="button" id="editSex">编辑</button>
                        <div class="layui-input-block modify">
                            <input type="radio" name="sex" value="男" title="男" lay-filter="boy">
                            <input type="radio" name="sex" value="女" title="女" lay-filter="girl">
                            <div class="buttonGroup">
                                <button class="layui-btn layui-btn-primary layui-btn-sm" type="button" id="cancleSex">取消</button>
                                <button class="layui-btn layui-btn-normal layui-btn-sm" type="button" id="saveSex">保存</button>
                            </div>
                        </div>
                    </div>
                    <%--                        居住地址--%>
                    <div class="layui-form-item">
                        <label class="layui-form-label">现居住地址</label>
                        <div id="address" class="layui-form-mid layui-input-inline"></div>
                        <button class="layui-btn layui-btn-normal layui-btn-sm" type="button" id="editAddress">编辑</button>
                        <div class="layui-input-inline modify">
                            <select name="city"  lay-filter="city1" id="city">
                                <option value=""></option>
                                <option value="北京">北京</option>
                                <option value="上海">上海</option>
                                <option value="广州">广州</option>
                                <option value="深圳">深圳</option>
                                <option value="杭州">杭州</option>
                                <option value="重庆">重庆</option>
                                <option value="6">河北</option>
                                <option value="7">山西</option>
                                <option value="8">辽宁</option>
                                <option value="9">吉林</option>
                                <option value="10">黑龙江</option>
                                <option value="11">浙江</option>
                                <option value="12">安徽</option>
                                <option value="13">福建</option>
                                <option value="14">江西</option>
                                <option value="15">河南</option>
                                <option value="16">湖北</option>
                                <option value="17">湖南</option>
                                <option value="18">广东</option>
                                <option value="19">海南</option>
                                <option value="20">贵州</option>
                                <option value="21">云南</option>
                                <option value="22">陕西</option>
                                <option value="23">甘肃</option>
                                <option value="24">青海</option>
                                <option value="25">台湾</option>
                                <option value="26">内蒙古自治区</option>
                                <option value="27">广西壮族自治区</option>
                                <option value="28">西藏自治区</option>
                                <option value="29">宁夏回族自治区</option>
                                <option value="30">新疆维吾尔自治区</option>
                                <option value="31">香港特别行政区</option>
                                <option value="32">澳门特别行政区</option>
                            </select>
                            <div class="buttonGroup">
                                <button class="layui-btn layui-btn-primary layui-btn-sm" type="button" id="cancleAddress">取消</button>
                                <button class="layui-btn layui-btn-normal layui-btn-sm" type="button" id="saveAddress">保存</button>
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item layui-form-text">
                        <label class="layui-form-label">兴趣爱好</label>
                        <div class="layui-input-block">
                            <div class="layui-input-inline" style="width:80%">
                                <textarea id="hobby" name="desc" class="layui-textarea" id="hobby" disabled></textarea>
                                <%--                                <textarea name="desc" placeholder="请输入内容" class="layui-textarea"></textarea>--%>
                            </div>
                            <button class="layui-btn layui-btn-normal layui-btn-sm" type="button" id="editHobby">编辑</button>
                        </div>
                        <%--                            点击编辑出现--%>
                        <div class="layui-input-block modify">
                            <div class="buttonGroup">
                                <button class="layui-btn layui-btn-primary layui-btn-sm" type="button" id="cancleHobby">取消</button>
                                <button class="layui-btn layui-btn-normal layui-btn-sm" type="button" id="saveHobby">保存</button>
                            </div>
                        </div>
                    </div>
                    <button type="button" class="layui-btn layui-btn-primary" style="margin: auto;display: block;" type="submit" lay-filter="submitPersonalInformation" lay-submit="">提交修改</button>
                </form>
            </div>
        </div>
        <div class="layui-card main_panel" id="left_nav_accountNumber">
            <div class="layui-card-header">账号资料</div>
            <div class="layui-card-body">
                <form class="layui-form" action="">
                    <div class="layui-form-item">
                        <label class="layui-form-label">昵称</label>
                        <div id="asname" name="asname"class="layui-form-mid layui-input-inline"></div>
                        <button class="layui-btn layui-btn-normal layui-btn-sm" type="button" id="editMyName">编辑</button>
                        <%--                            点击编辑出现--%>
                        <div class="layui-input-inline modify">
                            <input type="text" name="username" required  lay-verify="required" placeholder="请输入昵称" autocomplete="off" class="layui-input">
                            <div class="buttonGroup">
                                <button class="layui-btn layui-btn-primary layui-btn-sm" type="button" id="cancleMyName">取消</button>
                                <button class="layui-btn layui-btn-normal layui-btn-sm" type="button" id="saveMyName">保存</button>
                            </div>
                        </div>
                    </div>
                    <%--                        身份--%>
                    <div class="layui-form-item">
                        <label class="layui-form-label">身份</label>
                        <div id="identity" class="layui-form-mid layui-input-inline showSex">学生</div>
                    </div>
                    <%--                        密码管理--%>
                    <div class="layui-form-item">
                        <label class="layui-form-label">密码管理</label>
                        <button class="layui-btn layui-btn-normal layui-btn-sm" type="button" id="modifyPassWord">重置密码</button>
                    </div>
                    <button class="layui-btn layui-btn-normal" lay-submit lay-filter="studentInfo123"id="studentInfo123">修改昵称</button>
                </form>
            </div>
        </div>
        <div class="layui-card main_panel" id="left_nav_course">
            <div class="layui-card-header">课程信息</div>
            <div class="layui-card-body couser_panel">
                <ul id="course">

                </ul>
            </div>
        </div>
        <div class="layui-card main_panel" id="left_nav_binding">
            <div class="layui-card-header">绑定信息</div>
            <div class="layui-card-body">
                <div class="layui-form-item">
                    <label class="layui-form-label">我的学校</label>
                    <div id="userschool" class="layui-form-mid layui-input-inline"></div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">我的邮箱</label>
                    <div id="userid" class="layui-form-mid layui-input-inline"></div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">我的专业</label>
                    <div id="margin" class="layui-form-mid layui-input-inline"></div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">我的班级</label>
                    <div id="userclass" class="layui-form-mid layui-input-inline">计科1班</div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="../layui/layui.js"></script>
<script src="../js/common.js"></script>
<script src="../js/personalHomepage_js (1).js"></script>
<script>
    function exit() {
        $.cookie('userEmail', '', { expires: -1 }); // 删除 cookie
        $.cookie('token', '', { expires: -1 }); // 删除 cookie
        $.cookie('examname', '', { expires: -1 }); // 删除 cookie
    }
</script>
</body>
<script>
    $(document).ready(function () {
        $.ajax({
            url:"/perinfo",
            data:{
                "useremail":$.cookie("userEmail"),//$.cookie("useremail")
            },
            type:"GET",
            success:function (data) {
                console.log(data);
                var data_temp = data['map']["obj"];
                alert(data_temp['username']);
                $("#username").html(data_temp['username']);
                $("#sex").html(data_temp['sex']);
                $("#address").html(data_temp['address']);
                $("#hobby").html(data_temp['hobby']);
            }
        })
        $.ajax({
            url:"/accinfo",
            data:{
                "useremail":$.cookie("userEmail"),
            },
            type:"GET",
            success:function (data) {
                console.log(data);
                var data_temp = data['map']["obj"];
                $("#asname").html(data_temp['asname']);
                $("#useremail").html(data_temp['useremail']);
                if (data_temp['identity']==1){
                    $("#identity").html('学生');
                }
                else if (data_temp['identity']==2){
                    $("#identity").html('老师');
                }
                else{
                    $("#identity").html('超级管理员');
                }
            }
        })
        $.ajax({
            url:"/courseinfo",
            data:{
                "useremail":$.cookie("userEmail"),
            },
            type:"GET",
            success:function (data) {
                console.log(data);
                var data_temp = data['map']["obj"];
                var course = $("#course");
                for (var i = 0;i<data_temp.length;i++){
                    course.append("<li><div><span>课程：</span><span>"+data_temp[i]['coursename']+"</span></div><div><span>教师：</span><span>"+data_temp[i]['teachername']+"</span></div><div><span>考试时间：</span><span>"+data_temp[i]['testtime']+"</span></div></li>")
                }
            }
        })
        $.ajax({
            url:"/bindinfo",
            data:{
                "useremail":$.cookie("userEmail"),
            },
            type:"GET",
            success:function (data) {
                console.log(data);
                var data_temp = data['map']["obj"];
                $("#userschool").html(data_temp['userschool']);
                $("#userid").html(data_temp['userid']);
                $("#margin").html(data_temp['margin']);
                $("#userclass").html(data_temp['userclass']);
            }
        })
    })

    layui.use('form', function() {
        var form = layui.form;
        form.on('submit(studentInfo123)', function (data) {
            var data = data.field;
            console.log($("#asname").html());
            $.ajax({
                url: "/asNameUpdate",
                data: {
                    "userEmail": $.cookie("userEmail"),
                    "asname": $("#asname").html()
                },
                type: "GET",
                success: function (data) {
                    console.log(data);
                    if (data.flag) {
                        alert("修改成功")
                    } else {
                        alert("修改失败")
                    }
                }, error: function (data) {
                    alert("请求失败");
                }
            })
            return false;
        })

    })
</script>
</html>
