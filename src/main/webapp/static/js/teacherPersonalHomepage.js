$(function () {

    layui.use(['element','layer','form'], function() {
        var element = layui.element;
        var layer = layui.layer;
        var form = layui.form;
        var $ = layui.jquery;
        //页面首次出现默认选中个人信息面板
        $(".firstshow").css("backgroundColor", "rgb(219,239,252)");
        $("#left_nav_personal").siblings().hide();
        AJAX.post1("/teacherPersonalHomepage/showInfo",{},function (data) {
            console.log(data);
            if(data.flag){
                data=data.map.reswait;
                console.log(data);
                $("#username").text(data[0].username),
                $("#useremail").text(data[0].useremail),
                $("#title").text(data[0].jobtitle)
            }else {
                layer.msg(data.msg);
            }
        })
        //重置密码
        //重置密码
        $("#modifyPassWord").on("click",function () {
            console.log("重置密码")
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
    })
})