/**
 * 后台交互操作
 */
$(function(){
    //获取邮箱
    // $(document).ready(function () {
    var str=decodeURI(location.href);
    // var useremail=str.split("?")[1].split("=")[1];

    //页面操作
    layui.use(['element','layer','form'], function(){
        var element = layui.element;
        var layer = layui.layer;
        var form = layui.form;
        var $ = layui.jquery;
        //页面首次出现默认选中个人信息面板
        $(".firstshow").css("backgroundColor","rgb(219,239,252)");
        $("#left_nav_personal").siblings().hide();
        //顶部导航栏操作
        element.on('nav(top_nav)', function(elem){
            layer.msg(elem.text());
            console.log("s"+elem.text);
        });
        //测试用设置token
        console.log($.cookie("userEmail"));
        AJAX.post1("/personalHomepage/showPersonalInformation",{},function (data) {
            data=JSON.parse(data);
            console.log(data);
            if(data.code=="200"){
                data=data.data;
                $("#username").text(data[0].username),
                    $("#sex").text(data[0].sex),
                    $("#address").text(data[0].address),
                    $("#hobby").val(data[0].hobby)
            }else {
                layer.msg(data.massage);
            }
        })
        //左侧导航栏操作
        element.on('nav(left_nav)', function(elem){
            elem.parent().siblings(":not(:first)").children().css("backgroundColor","white");
            elem.css("backgroundColor","rgb(219,239,252)");
            if(elem.text()=="个人信息"){
                $("#left_nav_personal").siblings().hide();
                $("#left_nav_personal").show();
                AJAX.post1("/personalHomepage/showPersonalInformation",{},function (data) {
                    data=JSON.parse(data);
                    console.log(data);
                    if(data.code=="200"){
                        data=data.data;
                        $("#username").text(data[0].username),
                            $("#sex").text(data[0].sex),
                            $("#address").text(data[0].address),
                            $("#hobby").val(data[0].hobby)
                    }else {
                        layer.msg(data.massage);
                    }
                })
            }
            else if(elem.text()=="账号资料"){
                $("#left_nav_accountNumber").siblings().hide();
                $("#left_nav_accountNumber").show();
            }
            else if(elem.text()=="课程信息"){
                $("#left_nav_course").siblings().hide();
                $("#left_nav_course").show();
            }
            else if(elem.text()=="绑定信息"){
                $("#left_nav_binding").siblings().hide();
                $("#left_nav_binding").show();
            }
        });
        //个人信息
        //将所有修改隐藏
        $(".modify").hide();
        //点击编辑后出现
        $("#editName").on("click",function () {
            $("#editName").hide();
            $("#editName").prev().hide();
            $("#editName").next().show();
        })
        $("#cancleName").on("click",function () {
            $("#cancleName").parent().parent().hide();
            $("#cancleName").parent().parent().prevUntil("label").show();
        });
        $("#saveName").on("click",function () {
            $("#username").text($("#saveName").parent().prev().val());
            $("#cancleName").trigger("click");
        });
        //编辑性别
        $("#editSex").on("click",function () {
            $("#editSex").hide();
            $("#editSex").prev().hide();
            $("#editSex").next().show();
        })
        $("#cancleSex").on("click",function () {
            $("#cancleSex").parent().parent().hide();
            $("#cancleSex").parent().parent().prevUntil("label").show();
        });
        $("#saveSex").on("click",function () {
            var val=$('input:radio[name="sex"]:checked').val();
            // console.log("sex："+val);
            $("#sex").text(val);
            // form.on('radio(boy)', function(data){
            //     console.log(data.value);
            //     $("#sex").text(data.value);
            // });
            // form.on('radio(girl)', function(data){
            //     console.log(data.value);
            //     $("#sex").text(data.value);
            // });
            $("#cancleSex").trigger("click");
        });
        //居住地
        $("#editAddress").on("click",function () {
            $("#editAddress").hide();
            $("#editAddress").prev().hide();
            $("#editAddress").next().show();
        })
        $("#cancleAddress").on("click",function () {
            $("#cancleAddress").parent().parent().hide();
            $("#cancleAddress").parent().parent().prevUntil("label").show();
        });
        $("#saveAddress").on("click",function () {
            val=$('#city option:selected').text();
            // console.log("city："+val);
            $("#address").text(val);
            $("#cancleAddress").trigger("click");
        });
        //兴趣爱好
        $("#editHobby").on("click",function () {
            $("#hobby").removeAttr("disabled");
            $("#hobby").attr("placeholder","请输入内容");
            $("#editHobby").hide();
            $("#editHobby").parent().next().show();
        })
        $("#cancleHobby").on("click",function () {
            $("#cancleHobby").parent().parent().hide();
            $("#editHobby").show();
            $("#hobby").attr("disabled","disabled");
            $("#hobby").removeAttr("placeholder");
        });
        $("#saveHobby").on("click",function () {
            $("#cancleHobby").trigger("click");
        });
        //提交按钮
        form.on('submit(submitPersonalInformation)', function(data){
            // console.log("data.field:"+JSON.stringify(data.field));
            console.log("email:"+$.cookie("userEmail"));
            AJAX.post1("/personalHomepage/personalInformation",{
                    "username":$("#username").text(),
                    "sex":$("#sex").text(),
                    "address":$("#address").text(),
                    "hobby":$("#hobby").val()
                },
                function (data) {
                    data=JSON.parse(data);
                    console.log(data);
                    if(data.code=="200"){
                        if(data.data[0]==1){
                            layer.msg("更新成功");
                        }
                        else{
                            console.log("更新失败");
                        }
                    }else {
                        layer.msg("else"+data.massage);
                    }
                })
            return false;
        });

//账号资料
        //昵称
        $("#editMyName").on("click",function () {
            $("#editMyName").hide();
            $("#editMyName").prev().hide();
            $("#editMyName").next().show();
        })
        $("#cancleMyName").on("click",function () {
            $("#cancleMyName").parent().parent().hide();
            $("#cancleMyName").parent().parent().prevUntil("label").show();
        });
        $("#saveMyName").on("click",function () {
            $("#asname").text($("#saveMyName").parent().prev().val());
            $("#cancleMyName").trigger("click");
        });
        // //邮箱
        // $("#editMailBox").on("click",function () {
        //     $("#editMailBox").hide();
        //     $("#editMailBox").prev().hide();
        //     $("#editMailBox").next().show();
        // })
        // $("#cancleMailBox").on("click",function () {
        //     $("#cancleMailBox").parent().parent().hide();
        //     $("#cancleMailBox").parent().parent().prevUntil("label").show();
        // });
        // $("#saveMailBox").on("click",function () {
        //     $("#cancleMailBox").trigger("click");
        // });

        //重置密码
        //重置密码
        $("#modifyPassWord").on("click",function () {
            var changePassword=layer.open({
                type: 1,
                skin: 'layui-layer-rim', //加上边框
                area: ['40%', '80%'], //宽高
                content: '<form class="layui-form" action="" style="width: 90%;margin:11px auto">\n' +
                    '        <div class="layui-form-item">\n' +
                    '            <div class="layui-form-item changePasswordTitle" >原密码</div>\n' +
                    '            <input type="password" name="pwdOld" id="pwdOld"required  lay-verify="required" placeholder="请输入原密码" autocomplete="off" class="layui-input">\n' +
                    '        </div>\n' +
                    '        <div class="layui-form-item">\n' +
                    '            <div class="layui-form-item changePasswordTitle">新密码</div>\n' +
                    '            <input type="password" name="pwdNew" id="pwdNew" required  lay-verify="required" placeholder="请输入新密码" autocomplete="off" class="layui-input">\n' +
                    '        </div>\n' +
                    '        <div class="layui-form-item">\n' +
                    '            <div class="layui-form-item changePasswordTitle">确认新密码</div>\n' +
                    '            <input type="password" name="pwdNew1" id="pwdNew1"required  lay-verify="required" placeholder="请输入确认新密码" autocomplete="off" class="layui-input">\n' +
                    '        </div>\n' +
                    '        <div class="layui-form-item" style="text-align: center;">\n' +
                    '            <button class="layui-btn layui-btn-normal" lay-submit lay-filter="formDemoPwd"id="formDemoPwd">立即提交</button>\n' +
                    '        </div>\n' +
                    '    </form>'
            });
        })
        //编辑
        // layui.use('form', function(){
        var form = layui.form;
        //监听提交
        form.on('submit(formDemoPwd)',function (data) {
            var data=data.field;
            console.log(data);
            console.log(data['pwdOld']);
            console.log(data['pwdNew']);
            console.log(data['pwdNew1']);
            if(data['pwdNew']!=data['pwdNew1']){
                alert("两次密码不一致");
            }else{
                $.ajax({
                    url:"/passwordChange",
                    data:{
                        "userEmail":$.cookie("userEmail"),
                        "pwdOld":data['pwdOld'],
                        "pwdNew":data['pwdNew']
                    },
                    type:"GET",
                    success:function (data) {
                        console.log(data);
                        var data_temp = data['map'];
                        if (data.flag){
                            alert("修改成功")

                        } else{
                            alert("原密码错误")
                        }
                    },error:function (data) {
                        alert("请求失败");
                    }
                })
            }
            return false;
        })
        $(document).on('click','#returnHome',function () {
            layer.confirm('确定返回主页？', {
                btn: ['确定','留下'] //按钮
            }, function(){
                window.location.href="学生端主页.html";
                layer.msg('欢迎回来', {icon: 1});
            }, function(){

            });

        })
        });
    });




    // $.ajax({
    //     url:"/accinfo",
    //     data:{
    //         "useremail":useremail
    //     },
    //     type:"GET",
    //     success:function (data) {
    //         console.log(data);
    //         var data_temp = data['map']["obj"];
    //         $("#asname").html(data_temp['asname']);
    //         $("#useremail").html(data_temp['useremail']);
    //         if (data_temp['identity']==1){
    //             $("#identity").html('学生');
    //         }
    //         else if (data_temp['identity']==2){
    //             $("#identity").html('老师');
    //         }
    //         else{
    //             $("#identity").html('超级管理员');
    //         }
    //     }
    // })
    // $.ajax({
    //     url:"/courseinfo",
    //     data:{
    //         "useremail":useremail
    //     },
    //     type:"GET",
    //     success:function (data) {
    //         console.log(data);
    //         var data_temp = data['map']["obj"];
    //         var course = $("#course");
    //         for (var i = 0;i<data_temp.length;i++){
    //             course.append("<li><div><span>课程：</span><span>"+data_temp[i]['coursename']+"</span></div><div><span>教师：</span><span>"+data_temp[i]['teachername']+"</span></div><div><span>考试时间：</span><span>"+data_temp[i]['testtime']+"</span></div></li>")
    //         }
    //     }
    // })
    // $.ajax({
    //     url:"/bindinfo",
    //     data:{
    //         "useremail":useremail
    //     },
    //     type:"GET",
    //     success:function (data) {
    //         console.log(data);
    //         var data_temp = data['map']["obj"];
    //         $("#userschool").html(data_temp['userschool']);
    //         $("#userid").html(data_temp['userid']);
    //         $("#margin").html(data_temp['margin']);
    //         $("#userclass").html(data_temp['userclass']);
    //     }
    // })





