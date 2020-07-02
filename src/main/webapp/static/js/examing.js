
function addtihao(dan,danti,id1,idname) {
    for (var i = 0;i<danti.length;i++){
        dan.append("<span id=\""+idname+"\" class=\"do\">"+(i+1)+"</span>");
    }
}
    layui.use('element', function(){
        var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
        //监听导航点击
        element.on('nav(demo)', function(elem){

        });
    });
    layui.use(['form','layer'], function(){
        var form = layui.form;
        var layer=layui.layer;
        //监听提交
        form.on('submit(formDemo)', function(data){
            console.log(data);
            data.field.examname = $.cookie("examName");
            data.field.useremail = $.cookie("userEmail");
            AJAX.post("/submitexam",data.field,function (res) {
                console.log(res);
              if (res.flag){
                  var sres = {};
                  sres.useremail =$.cookie("userEmail");
                  sres.examName = $.cookie("examName");
                  AJAX.post("/autoJudeg",sres,function (res2) {
                      if (res2.flag){
                          layer.msg("自动判分已完成");
                          window.location.href="学生端主页.html";
                      }
                      else{
                          layer.msg("自动判分内部出现错误");
                      }
                  })
              }
              else{
                  layer.alert(res.msg);
              }
            })
            return false;
        });
    });
    //当前题型
    var questionType="dan";
    //  题目按钮改变
    layui.use(['element','layer'], function() {
        element=layui.element;
        layer=layui.layer;
        //监听选项卡切换
        element.on('tab(makeQuestions)', function(data){
            // console.log(data.index); //得到当前的下标
            switch (data.index) {
                case 0:questionType="dan";
                    break;
                case 1:questionType="duo";
                    break;
                case 2:questionType="tian";
                    break;
                case 3:questionType="zhu";
                    break;
                default:layer.msg("切换读取错误");
            }
            // console.log(questionType);
        });

    })
console.log(questionType);

function chageinfo(data){
    var qno=$(data).parent().find(".no").text()-1;
    console.log("单选题"+qno);
    console.log(questionType);
    var chage=$("#"+questionType).children().eq(qno);
    chage.html('<i class="layui-icon layui-icon-ok" style="font-size: 15px; color: green;">');
}
function chageinfoTian(data){
    if($(data).val()!=""){
        var qno=$(data).parent().parent().find(".no").text()-1;
        console.log("填空题中的qno为"+qno);
        // console.log(qno);
        // console.log(questionType);
        var chage=$("#"+questionType).children().eq(qno);
        chage.html('<i class="layui-icon layui-icon-ok" style="font-size: 15px; color: green;">');
    }
}

function chageinfoZhu(data){
    if($(data).val()!=""){
        var qno=$(data).parent().find(".no").text()-1;
        console.log("主观题中的qno为"+qno);
        console.log(questionType);
        var chage=$("#"+questionType).children().eq(qno);
        chage.html('<i class="layui-icon layui-icon-ok" style="font-size: 15px; color: green;">');
    }
}

function addContentDan(dan,danti,id1,allid){
    for (var i = 0;i<danti.length;i++){
        var strt = "<div class=\"layui-form-item\"><div class=\"con\" ><div>  <span class=\"no\">"+(i+1)+"</span><span>. "+danti[i].title+"" +
            "</span></div>";
        var tt = danti[i].choice.split("@");
        var lnum = 10;
        var ahp = "A";
        for (var j = 0;j<tt.length;j++){
            if (j ==1){
                ahp="B";
            }
            else if (j ==2){
                ahp = "C";
            }
            else if (j ==3){
                ahp = "D";
            }
            var tp = "<div class=\"choice\" onclick=\"chageinfo(this)\"><input type=\"radio\" name=\"dan"+allid+"\" value=\""+ahp+"\" >"+ahp+"  "
                +"<span>"+tt[j]+"</span></div>";
            strt = strt+tp;
        }
        allid ++;
        strt = strt+" </div>\n" +
            "</div>";
        dan.append(strt);
    }
}
function addContentDuo(dan,danti,id1,allid){
    for (var i = 0;i<danti.length;i++){
        var strt = "<div class=\"judge layui-form-item\"><div><div>  <span class=\"no\">"+(i+1)+"</span><span>. "+danti[i].title+"" +
            "</span></div>";
        var tt = danti[i].choice.split("@");
        var ahp = "A";
        for (var j = 0;j<tt.length;j++) {
            if (j == 1) {
                ahp = "B";
            }
            else if (j == 2) {
                ahp = "C";
            }
            else if (j == 3) {
                ahp = "D";
            }
            var tp = "<p class=\"choice\" onclick=\"chageinfo(this)\"><input type=\"checkbox\" name=\"duo"+(allid+ahp)+"\" value=\"" + ahp + "\" >" + " <span>" + ahp+"  " + "</span>"
                + "<span>" + tt[j] + "</span></p>";
            strt = strt + tp;
        }
        allid ++;
        strt = strt+" </div>\n";
        dan.append(strt);
    }
}
function addContentTian(dan,danti,id1,allid) {
    for (var i = 0;i<danti.length;i++){
        var sttr = "<div class=\"layui-form-item\">\n" +
            "    <span class=\"no tianno\">"+(i+1)+"</span><label class=\"layui-form-label fill\">. "+" "+danti[i].title+"</label>"
        +"<div class=\"layui-input-inline\">\n" +
            "    <input type=\"text\" name=\"tian"+allid+"\" required  lay-verify=\"required\" placeholder=\"请输入答案\" autocomplete=\"off\" class=\"layui-input\" onblur=\"chageinfoTian(this)\">\n" +
            "    </div>\n" +
            "    </div>";
        allid ++;
        dan.append(sttr);
    }
}
function addContentZhu(dan,danti,id1,allid) {
    for (var i = 0;i<danti.length;i++){
        var sttr ="<div class=\"jianda layui-form-item\">\n" +
            "    <div class=\"zhumo\">\n" +
            "    <span class=\"no\">"+(i+1)+"</span><span>. "+danti[i].title+"</span>"
            +"</div>\n" +
            "    <textarea name=\"zhu"+allid+"\" required lay-verify=\"required\" placeholder=\"请输入你的答案\" class=\"layui-textarea\" onblur=\"chageinfoZhu(this)\"></textarea>\n" +
            "    </div>";
        allid ++;
        dan.append(sttr);
    }
}
function  DateDifference(faultDate,completeTime){
    var stime =new Date(faultDate).getTime();
    console.log("时间为"+stime);
    var etime = new Date(completeTime).getTime();
    console.log("时间为2 "+etime);
    var usedTime = etime - stime;  //两个时间戳相差的毫秒数
    var time = usedTime/1000/60;
    return time;
}
$(document).ready(function () {
    var dataa = {
        "examname": $.cookie("examName")
    }
    AJAX.get("/examing",dataa,function (data) {
        console.log(data);
        if (data.flag){
            //根据个数生成响应的题号检查数
            alert("成功了");
            var dan = data.map.dan;
            var duo = data.map.duo;
            var tian = data.map.tian;
            var zhu = data.map.zhu;
            var danti = $("#dan");
            var duoti = $("#duo");
            var tianti = $("#tian");
            var zhuti = $("#zhu");
            var hao = 1;
            addtihao(danti, dan, hao);
            addtihao(duoti, duo, hao);
            addtihao(tianti, tian, hao);
            addtihao(zhuti, zhu, hao);
            var danxuanti = $("#danxuanti");
            var duoxuanti = $("#duoxuanti");
            var tiankongti = $("#tiankongti");
            var zhuguanti = $("#zhuguanti");
            var allid = 1;
            addContentDan(danxuanti, dan, 1,allid);
            allid = allid+dan.length;
            addContentDuo(duoxuanti, duo, 1,allid);
            allid = allid+duo.length;
            addContentTian(tiankongti, tian, 1,allid);
            allid = allid+tian.length;
            addContentZhu(zhuguanti,zhu, 1,allid);
            AJAX.get("/examtime",dataa,function (res) {
                console.log(res);
                if (res.flag){
                    var testname = $("#testName");
                    var starttime = $("#starttime");
                    var endtime = $("#endtime");
                    var timesum = $("#timesum");
                    var obj = res.map.obj;
                    testname.text((obj.examName));
                    starttime.text(obj.startTime);
                    endtime.text (obj.examTime);
                    timesum.html(DateDifference(obj.startTime,obj.examTime)+"分钟");
                }
            })
        }
        else{
            alert("加载页面失败，内部服务器失败");
        }
    })

})


