    <link rel="stylesheet" href="/static/layui/css/layui.css">
    <script src="/static/jquery3.3.1.js"></script>
    <script src="/static/layui/layui.all.js"></script>

<table border="1" class="layui-table" >
    <tr>
        <td>编号</td><td style="width: 60%">分类名称</td><td colspan="2" style="width: 332px">操作</td>
    </tr>
    <#list cates as cate >
    <tr>
        <td>${cate.id}</td><td>${cate.cateName}</td><td><spa class="layui-btn-group"><button class="layui-btn" onclick="updateTabs(${cate.id})">编辑</button></spa></td><td><span class="layui-btn-group"><button class="layui-btn" onclick="deleteById(${cate.id})">删除</button></span></td>
    </tr>
    </#list>
<script>
    function updateTabs(id) {
        layer.open({
                type: 2,
                title: '信息',
                shadeClose: true,
                shade: false,
                maxmin: true, //开启最大化最小化按钮
                area: ['500px', '300px'],
                content: '/queryById?id='+id
            })
    }  function deleteById(id) {
        $.ajax({
            type: "POST",
            url: "/deleteById",
            data: {id:id},
            success: function(msg){
                if(msg.status=="success"){
                    layer.alert(msg.msg,function () {
                        window.location.reload()//刷新父窗口
                    })

                }else{
                    alert(msg.msg)
                }
            }
        });
    }
</script>