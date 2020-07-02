layui.use('table', function(){
    var table = layui.table;

    //温馨提示：默认由前端自动合计当前行数据。从 layui 2.5.6 开始： 若接口直接返回了合计行数据，则优先读取接口合计行数据。
    //详见：https://www.layui.com/doc/modules/table.html#totalRow
    table.render({
        elem: '#histoyTestShow_table'
        ,url:'/test/table/demo1.json'
        ,toolbar: '#toolbarDemo'
        ,title: '历史考试'
        ,totalRow: true
        ,cols: [[
            {field:'time', title:'时间', fixed: 'left', unresize: true, sort: true}
            ,{field:'subject', title:'科目', minWidth:100, edit: 'text',style:'background-color: #eee;'}
            ,{field:'experience', title:'参与人数',  sort: true}
            ,{field:'sex', title:'成绩', edit: 'text', sort: true}
            ,{fixed: 'right', title:'操作', toolbar: '#see'}
        ]]
        ,initSort: {
            field: 'time' //排序字段，对应 cols 设定的各字段名
            ,type: 'desc' //排序方式  asc: 升序、desc: 降序、null: 默认排序
        }
        ,page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
            layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'] //自定义分页布局
            //,curr: 5 //设定初始在第 5 页
            ,groups: 1 //只显示 1 个连续页码
            ,first: false //不显示首页
            ,last: false //不显示尾页
        }
    });

    //工具栏事件
    table.on('toolbar(test)', function(obj){
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
});