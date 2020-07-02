$(function () {
    layui.use(['table','layer','form'], function(){
        var table = layui.table;
        var layer=layui.layer;
        var form = layui.form;
        //单选显示
        table.render({
            elem: '#dan'
            ,url:'/IndependentTopicSelection/showDan'
            ,method: 'post'
            ,toolbar: '#toolbarDemo'
            ,title: '单选题库'
            ,totalRow: true
            ,cols: [[
                {type: 'checkbox', fixed: 'left'}
                ,{field:'subjectCentent', title:'选择题目' }
                ,{field:'subjectOptions', title:'选项',  templet: function(res){
                        // console.log(res.subjectOptions);
                       if(res.subjectOptions!=null){
                           var op=res.subjectOptions.split("@");
                           var x;
                           var show='<div class="layui-form-item">';
                           for(var i=0;i<op.length;i++){
                               var abc;
                               switch (i) {
                                   case 0:abc="A";break;
                                   case 1:abc="B";break;
                                   case 2:abc="C";break;
                                   case 3:abc="D";break;
                                   case 4:abc="E";break;
                                   case 5:abc='F';break;
                                   case 6:abc='G';break;
                                   default:abc='';
                               }
                               show+='<div class="layui-input-block" style=" margin-left: auto;">'+abc+'、<span>'+op[i]+'</span></div>';
                           }
                           show+='</div>';
                           return show;
                       }
                       return null;
                    }
                }
                ,{field:'subjectAnswer', title:'正确答案'}
                ,{field:'subjectValue', title:'分值',  sort: true, totalRow: true}
                ,{field:'answerAnalysis', title:'答案分析'}
                ,{field:'subjectTypeCode', title:'科目',  sort: true}
                ,{field:'knowledgeCode', title:'知识点'}
                ,{field:'subjectDifficultly', title:'难度',sort: true,}
            ]]
            ,page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
                layout: ['limit', 'prev', 'page', 'next', 'skip'] //自定义分页布局
                //,curr: 5 //设定初始在第 5 页
                ,groups: 1 //只显示 1 个连续页码
                ,first: false //不显示首页
                ,last: false //不显示尾页
            }
            // ,done: function(res, curr, count){
            //     //如果是异步请求数据方式，res即为你接口返回的信息。
            //     //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
            //     console.log(res);
            //     //得到当前页码
            //     console.log(curr);
            //     //得到数据总量
            //     console.log(count);
            // }
        });
        //多选显示
        table.render({
            elem: '#duo'
            ,url:'/IndependentTopicSelection/showDuo'
            ,method: 'post'
            ,toolbar: '#toolbarDemo'
            ,title: '多选题库'
            ,totalRow: true
            ,cols: [[
                {type: 'checkbox', fixed: 'left'}
                ,{field:'subjectCentent', title:'多选题目' }
                ,{field:'subjectOptions', title:'选项',  templet: function(res){
                        if(res.subjectOptions!=null){
                            var op=res.subjectOptions.split("@");
                            var x;
                            var show='<div class="layui-form-item">';
                            for(var i=0;i<op.length;i++){
                                var abc;
                                switch (i) {
                                    case 0:abc="A";break;
                                    case 1:abc="B";break;
                                    case 2:abc="C";break;
                                    case 3:abc="D";break;
                                    case 4:abc="E";break;
                                    case 5:abc='F';break;
                                    case 6:abc='G';break;
                                    default:abc='';
                                }
                                show+='<div class="layui-input-block" style=" margin-left: auto;">'+abc+'、<span>'+op[i]+'</span></div>';
                            }
                            show+='</div>';
                            return show;
                        }
                        return null;
                    }
                }
                ,{field:'subjectAnswer', title:'正确答案', templet: function(res){
                        if(res.subjectAnswer!=null){
                            var op=res.subjectAnswer.split("@");
                            var x;
                            var show='<div class="layui-form-item">';
                            for(var i=0;i<op.length;i++){
                                if(op[i]!=null){
                                    show+='<span style="margin-right: 5px;">'+op[i]+'</span>';
                                }
                            }
                            show+='</div>';
                            return show;
                        }
                        return null;
                    }}
                ,{field:'subjectValue', title:'分值',  sort: true, totalRow: true}
                ,{field:'answerAnalysis', title:'答案分析'}
                ,{field:'subjectTypeCode', title:'科目',  sort: true}
                ,{field:'knowledgeCode', title:'知识点'}
                ,{field:'subjectDifficultly', title:'难度',sort: true,}
            ]]
            ,page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
                layout: ['limit', 'prev', 'page', 'next', 'skip'] //自定义分页布局
                //,curr: 5 //设定初始在第 5 页
                ,groups: 1 //只显示 1 个连续页码
                ,first: false //不显示首页
                ,last: false //不显示尾页
            }
        });
        //填空显示
        table.render({
            elem: '#tian'
            ,url:'/IndependentTopicSelection/showTian'
            ,method: 'post'
            ,toolbar: '#toolbarDemo'
            ,title: '填空题库'
            ,totalRow: true
            ,cols: [[
                {type: 'checkbox', fixed: 'left'}
                ,{field:'pinName', title:'填空题目' }
                ,{field:'pinAnswer', title:'填空答案' }
                ,{field:'pinScore', title:'分值',  sort: true, totalRow: true}
                ,{field:'pinAnly', title:'答案分析'}
                ,{field:'pinType', title:'科目',  sort: true}
                ,{field:'pinKnowledge', title:'知识点'}
                ,{field:'pinDifficult', title:'难度',sort: true,}
            ]]
            ,page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
                layout: ['limit', 'prev', 'page', 'next', 'skip'] //自定义分页布局
                //,curr: 5 //设定初始在第 5 页
                ,groups: 1 //只显示 1 个连续页码
                ,first: false //不显示首页
                ,last: false //不显示尾页
            }
        });

        //主观题显示
        table.render({
            elem: '#zhu'
            ,url:'/IndependentTopicSelection/showZhu'
            ,method: 'post'
            ,toolbar: '#toolbarDemo'
            ,title: '填空题库'
            ,totalRow: true
            ,cols: [[
                {type: 'checkbox', fixed: 'left'}
                ,{field:'pinName', title:'主观题目' }
                ,{field:'pinAnswer', title:'主观答案' }
                ,{field:'pinScore', title:'分值',  sort: true, totalRow: true}
                ,{field:'pinAnly', title:'答案分析'}
                ,{field:'pinType', title:'科目',  sort: true}
                ,{field:'pinKnowledge', title:'知识点'}
                ,{field:'pinDifficult', title:'难度',sort: true,}
            ]]
            ,page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
                layout: ['limit', 'prev', 'page', 'next', 'skip'] //自定义分页布局
                //,curr: 5 //设定初始在第 5 页
                ,groups: 1 //只显示 1 个连续页码
                ,first: false //不显示首页
                ,last: false //不显示尾页
            }
        });
        //工具栏事件
        table.on('toolbar(dan)', function(obj){
            console.log(obj);
            console.log(obj.config);
            console.log(obj.config.id)
            var checkStatus = table.checkStatus(obj.config.id);
            switch(obj.event){
                case 'getCheckData':
                    var data = checkStatus.data;
                    layer.alert(JSON.stringify(data));
                    break;
                case 'getCheckLength':
                    var data = checkStatus.data;
                    layer.msg('选中了：'+ data.length + ' 个');
                    break;
                case 'isAll':
                    layer.msg(checkStatus.isAll ? '全选': '未全选')
                    break;
            };
        });
        table.on('toolbar(duo)', function(obj){
            var checkStatus = table.checkStatus(obj.config.id);
            switch(obj.event){
                case 'getCheckData':
                    var data = checkStatus.data;
                    layer.alert(JSON.stringify(data));
                    break;
                case 'getCheckLength':
                    var data = checkStatus.data;
                    layer.msg('选中了：'+ data.length + ' 个');
                    break;
                case 'isAll':
                    layer.msg(checkStatus.isAll ? '全选': '未全选')
                    break;
            };
        });
        table.on('toolbar(tian)', function(obj){
            var checkStatus = table.checkStatus(obj.config.id);
            switch(obj.event){
                case 'getCheckData':
                    var data = checkStatus.data;
                    layer.alert(JSON.stringify(data));
                    break;
                case 'getCheckLength':
                    var data = checkStatus.data;
                    layer.msg('选中了：'+ data.length + ' 个');
                    break;
                case 'isAll':
                    layer.msg(checkStatus.isAll ? '全选': '未全选')
                    break;
            };
        });
        table.on('toolbar(zhu)', function(obj){
            var checkStatus = table.checkStatus(obj.config.id);
            switch(obj.event){
                case 'getCheckData':
                    var data = checkStatus.data;
                    layer.alert(JSON.stringify(data));
                    break;
                case 'getCheckLength':
                    var data = checkStatus.data;
                    layer.msg('选中了：'+ data.length + ' 个');
                    break;
                case 'isAll':
                    layer.msg(checkStatus.isAll ? '全选': '未全选')
                    break;
            };
        });

//提交按钮
        form.on('submit(inChoice_exam)', function(data){
            console.log(data.elem) //被执行事件的元素DOM对象，一般为button对象
            console.log(data.form) //被执行提交的form对象，一般在存在form标签时才会返回
            console.log(data.field) //当前容器的全部表单字段，名值对形式：{name: value}
            var dan=table.checkStatus("dan");
            var duo=table.checkStatus("duo");
            var tian=table.checkStatus("tian");
            var zhu=table.checkStatus("zhu");
            var datadan=dan.data;
            var dataduo=duo.data;
            var datatian=tian.data;
            var datazhu=zhu.data;
            console.log(datadan);
            console.log(dataduo);
            console.log(datatian);
            console.log(datazhu);
            return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
        });


        function text () {
            var dan="dan";
            var datadan=dan.data;

        }

    });


})
