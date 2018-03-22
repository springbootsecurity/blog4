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
<input type="text"  id="iid" name="title" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input" style="width: 200px;display:inline">
<input class="layui-btn layui-btn-normal" type="button" value="添加" onclick="add()">
<div id="tableDiv">
    <#include "table.ftl">
</div>

</body>
<script>
    function add() {
      var cateName = $("#iid").val();
      console.log(cateName)
      $.post("/addCate",{cateName:cateName},function (msg) {
          layer.alert(msg.msg,{title:'提示'}, function (index) {
              if(msg.status=='success'){
                  //刷新页面
                  $.get("/refresh",function (msg) {
                      $("#tableDiv").html(msg);
                  });
              }
              layer.close(index);
          });


      })
    }
</script>
</html>