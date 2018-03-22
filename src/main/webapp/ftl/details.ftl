<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="/static/layui/css/layui.css">
    <script src="/static/jquery3.3.1.js"></script>
    <script src="/static/layui/layui.all.js"></script>

</head>
<body>
<form action="" method="post" id="dform">
    <table class="layui-table">
        <tr style="display: none">
            <td><input id="id" value="${cate.id}"></td>
        </tr>
        <tr >
            <td>分类名称<input type="text" id="cateName" name="cateName" class="layui-input" value="${cate.cateName}"></td>
        </tr>
        <tr >
            <td><input type="button" value="提交" onclick="qudata()" class="layui-btn layui-btn-normal"></td>
        </tr>
    </table>
</form>
</body>
<script>
    function qudata() {
        var id = $("#id").val();
        var cateName = $("#cateName").val();

        $.ajax({
            type: "POST",
            url: "/update",
            data: {
                id:id,
                cateName:cateName
            },
            success: function(msg){
                if(msg.status=="success"){
                    layer.alert(msg.msg,function () {
                        window.parent.location.reload()
                    })
                }else{
                    layer.alert(msg.msg)
                }
            }
        });
    }
</script>
</html>