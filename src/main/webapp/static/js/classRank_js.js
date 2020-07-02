$(function () {
    //测试用设置token
    // $.cookie("token","123456");
    // $.cookie("userEmail","147852369@145.com");
    //在网址栏切割试卷id
    var str=decodeURI(location.href);
    var history_exam=str.split("?")[1].split("=")[1];
    $("#mySubject").text(history_exam);
    // var history_exam=$.cookie("examName");
    console.log($("#serach").val());

    layui.use(['table','element','layer'], function(){
        var table = layui.table;
        var element=layui.element;
        var layer=layui.layer;

        //界面首页显示
        var rank=table.render({
            elem: '#classRankShow'
            ,url:'/rank/showGrade'
            ,headers:{userEmail: $.cookie("userEmail")}
            ,where: {
                history_exam: history_exam
                ,keyword:$("#serach").val()
            }
            ,method: 'post' //如果无需自定义HTTP类型，可不加该参数
            ,page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
                layout: ['limit', 'prev', 'page', 'next', 'skip'] //自定义分页布局
                //,curr: 5 //设定初始在第 5 页
                ,groups: 1 //只显示 1 个连续页码
                ,first: false //不显示首页
                ,last: false //不显示尾页
            }
            ,cols: [[
                {field:'student_email',  title: '邮箱', sort: true}
                // ,{field:'username', width:100, title: '姓名'}
                ,{field:'historyExam', title: '考试'}
                ,{field:'class1', title: '班级'}
                ,{field:'score',  title: '成绩',sort: true}
                ,{field:'rank', title: '排名',sort: true}
            ]]
            ,initSort: {
                field: 'score' //排序字段，对应 cols 设定的各字段名
                ,type: 'desc' //排序方式  asc: 升序、desc: 降序、null: 默认排序
            }
        });
        //班级处搜索
        $("#serachbut").on("click",function () {
            console.log("点击1后："+$("#serach").val())
            rank.reload({
                where: {
                    keyword:$("#serach").val()
                }
                ,page: {
                    curr: 1 //重新从第 1 页开始
                }
            });
        })
        //切换显示
        element.on('tab(score)', function(data){
            console.log(data.index); //得到当前Tab的所在下标
            if(data.index==0){
                var rank=table.render({
                    elem: '#classRankShow'
                    ,url:'/rank/showGrade'
                    ,headers:{userEmail: $.cookie("userEmail")}
                    ,where: {
                        history_exam: history_exam
                        ,keyword:$("#serach").val()
                    }
                    ,method: 'post' //如果无需自定义HTTP类型，可不加该参数
                    ,page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
                        layout: ['limit', 'prev', 'page', 'next', 'skip'] //自定义分页布局
                        //,curr: 5 //设定初始在第 5 页
                        ,groups: 1 //只显示 1 个连续页码
                        ,first: false //不显示首页
                        ,last: false //不显示尾页
                    }
                    ,cols: [[
                        {field:'student_email',  title: '邮箱', sort: true}
                        // ,{field:'username', width:100, title: '姓名'}
                        ,{field:'historyExam', title: '考试'}
                        ,{field:'class1', title: '班级'}
                        ,{field:'score',  title: '成绩',sort: true}
                        ,{field:'rank', title: '排名',sort: true}
                    ]]
                    ,initSort: {
                        field: 'score' //排序字段，对应 cols 设定的各字段名
                        ,type: 'desc' //排序方式  asc: 升序、desc: 降序、null: 默认排序
                    }
                });
                //班级处搜索
                $("#serachbut").on("click",function () {
                    console.log("点击1后："+$("#serach").val())
                    rank.reload({
                        where: {
                            keyword:$("#serach").val()
                        }
                        ,page: {
                            curr: 1 //重新从第 1 页开始
                        }
                    });
                })
            }

            else if(data.index==1){
                //年级排名
                layui.use('table', function(){
                    var table = layui.table;
                    var rankyear=table.render({
                        elem: '#classRankShow2'
                        ,url:'/rank/showGradeYear'
                        ,headers:{userEmail: $.cookie("userEmail")}
                        ,where: {
                            history_exam: history_exam
                            ,keyword:$("#serach2").val()
                        }
                        ,method: 'post' //如果无需自定义HTTP类型，可不加该参数
                        ,page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
                            layout: ['limit', 'prev', 'page', 'next', 'skip'] //自定义分页布局
                            //,curr: 5 //设定初始在第 5 页
                            ,groups: 1 //只显示 1 个连续页码
                            ,first: false //不显示首页
                            ,last: false //不显示尾页
                        }
                        ,cols: [[
                            {field:'student_email',  title: '邮箱', sort: true}
                            // ,{field:'username', width:100, title: '姓名'}
                            ,{field:'historyExam', title: '考试'}
                            ,{field:'gradeName', title: '年级'}
                            ,{field:'class1', title: '班级'}
                            ,{field:'score',  title: '成绩',sort: true}
                            ,{field:'rank', title: '排名',sort: true}
                        ]]
                        ,initSort: {
                            field: 'score' //排序字段，对应 cols 设定的各字段名
                            ,type: 'desc' //排序方式  asc: 升序、desc: 降序、null: 默认排序
                        }
                    });
                    //年级处搜素
                    $("#serachbut2").on("click",function () {
                        console.log("点击2后："+$("#serach2").val())
                        rankyear.reload({
                            where: {
                                keyword:$("#serach2").val()
                            }
                            ,page: {
                                curr: 1 //重新从第 1 页开始
                            }
                        });
                    })
                });

            }

        });

    $("#mySubject").val(history_exam);
    // 显示学生身份信息
    AJAX.post1("/rank/personalIdentity",{
        "history_exam":history_exam
    },
        function (data) {
        console.log(data);
        if(data.code=="200"){
            data=data.data;
            $("#myName").text(data[0].studentEmail);
            $("#myGrade").text(data[0].score);
        }else{
            layer.msg(data.message);
        }
    })

    $("#myRank").val("");
    console.log($.cookie("token"));
    });

})
