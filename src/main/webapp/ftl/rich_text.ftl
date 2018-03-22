<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>完整demo</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <link rel="stylesheet" href="/static/layui/css/layui.css">
    <link href="/static/kindeditor/themes/default/default.css">
    <script src="/static/jquery3.3.1.js"></script>
    <script src="/static/layui/layui.all.js"></script>
    <script src="/static/kindeditor/kindeditor-all-min.js"></script>
    <script src="/static/kindeditor/lang/zh-CN.js"></script>


    <style type="text/css">
        div {
            width: 100%;
        }
    </style>
</head>
<body>
<div>
    <h1>写文章</h1>
    标题:<input type="text" id="title"><br>
    分类:<select id="fl">
    <option value="请选择">--请选择--</option>
            <#list allCate as cate>
                <option value="${cate.id}">${cate.cateName}</option>
            </#list>
</select>
    <textarea id="editor_id" name="content" style="width:700px;height:300px;">

    </textarea><br>
</div>
<button onclick="inset()">提交</button>
</div>
<script type="text/javascript">
    KindEditor.ready(function (K) {
        window.editor = K.create('#editor_id');
    });

    function inset() {
        var title = $("#title").val();
        var myselect = document.getElementById("fl");
        var index = myselect.selectedIndex;
        var cateid = myselect.options[index].value;
        var text1 = editor.html();

        if (cateid != "请选择") {
            $.ajax({
                type: "POST",
                url: "/article/addArticle",
                data: {
                    cateid: cateid,
                    title: title,
                    summary: text1
                },
                success: function (msg) {
                    if (msg.status == "success") {
                        layer.alert(msg.msg, function () {
                            window.location.reload();
                        })

                    }

                }
            });
        } else {
            layer.alert("请输入分类")
        }


    }
</script>
</body>
</html>