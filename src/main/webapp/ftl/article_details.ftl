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
<a href="/article/rich_text">写文章</a>
<table class="layui-table">
    <tr>
        <td>编号</td>
        <td>标题</td>
        <td>摘要</td>
        <td>发表时间</td>
        <td>所属分类</td>
        <td colspan ="2">操作</td>
    </tr>
    <#list articles as article>
          <tr>
              <td>${article.id!}</td>
              <td>${article.title!}</td>
              <td>${article.summary!}</td>
              <td>${article.publishDate!}</td>
              <td>${article.cate.cateName!}</td>
              <td><a href="javascript:void(0)" onclick="updata1(${article.id!})">修改</a></td>
              <td><a href="javascript:void(0)" onclick="delete1(${article.id!})">删除</a></td>
          </tr>
    </#list>
</table>
</body>
<script>

    function updata1(id) {
        alert("-----")
        layer.open({
            type: 2,
            title: '信息',
            shadeClose: true,
            shade: false,
            maxmin: true, //开启最大化最小化按钮
            area: ['100%', '100%'],
            content: '/article/queryById?id='+1
        })
    }
</script>
</html>