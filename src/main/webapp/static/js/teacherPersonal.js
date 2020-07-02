function mark(data){
    var ex_name=$(data).parent().parent().find(".ex_name").text();
    console.log("进入"+ex_name);
    $.cookie("examName",ex_name);
    window.open("teacher_judge.html?ex_name="+ex_name);
}
function analysis(data){
    var ex_name=$(data).parent().parent().find(".ex_name").text();
    console.log("进入"+ex_name);
    $.cookie("examName",ex_name);
    window.open("teacher_analysis.html?ex_name="+ex_name);
}
$(function () {
    //注意：导航 依赖 element 模块，否则无法进行功能性操作
    layui.use(['element','layer'], function(){
        var element = layui.element;
        var layer=layui.layer;

    //测试用设置userEmail
    //首页面显示未判完的卷
    AJAX.post1("/teacherPersonal/showWait",{},function (data) {
        console.log(data)
        if(data.flag){
            var reswait=data.map.reswait;
            for(var i=0;i<reswait.length;i++){
                $("#wait").append('<li>\n' +
                    '                        <div>\n' +
                    '                            <span>试卷：</span>\n' +
                    '                            <span class="ex_name">'+reswait[i].examination_name +'</span>\n' +
                    '                        </div>\n' +
                    '                        <div>\n' +
                    '                            <span>已阅：</span>\n' +
                    '                            <span>'+reswait[i].count+"/"+reswait[i].countWait+'</span>\n' +
                    '                        </div>\n' +
                    '                        <div>\n' +
                    '                            <span>发布班级：</span>\n' +
                    '                            <span>'+reswait[i].grade_name+"级"+reswait[i].class_name+'</span>\n' +
                    '                        </div>\n' +
                    '                        <div>\n' +
                    '                            <span>发布时间：</span>\n' +
                    '                            <span>'+reswait[i].start_time+'</span>\n' +
                    '                        </div>\n' +
                    '                        <div>\n' +
                    '                            <span>阅卷：</span>\n' +
                    '                            <button type="button" class="layui-btn layui-btn-normal" onclick="mark(this)">判卷</button>\n' +
                    '                        </div>\n' +
                    '                    </li>');
            }
        }else {
            layer.msg(data.msg);
        }

    })

    //首页面显示发布的卷
    AJAX.post1("/teacherPersonal/published",{},function (data) {
        console.log(data)
        if(data.flag){
            var reswait=data.map.reswait;
            for(var i=0;i<reswait.length;i++){
                $("#published").append('<li>\n' +
                    '                        <div>\n' +
                    '                            <span>试卷：</span>\n' +
                    '                            <span class="ex_name">'+reswait[i].examination_name +'</span>\n' +
                    '                        </div>\n' +
                    '                        <div>\n' +
                    '                            <span>发布班级：</span>\n' +
                    '                            <span>'+reswait[i].grade_name+"级"+reswait[i].class_name+'</span>\n' +
                    '                        </div>\n' +
                    '                        <div>\n' +
                    '                            <span>发布时间：</span>\n' +
                    '                            <span>'+reswait[i].start_time+'</span>\n' +
                    '                        </div>\n' +
                    '                        <div>\n' +
                    '                            <span>查看试卷分析：</span>\n' +
                    '                            <button type="button" class="layui-btn layui-btn-normal" onclick="analysis(this)">查看</button>\n' +
                    '                        </div>\n' +
                    '                    </li>');
            }
        }else {
            layer.msg(data.msg);
        }
    })
    });
})