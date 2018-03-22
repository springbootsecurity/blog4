<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <link rel="stylesheet" href="/static/layui/css/layui.css">
    <link href="/static/kindeditor/themes/default/default.css">
    <script src="/static/jquery3.3.1.js"></script>
    <script src="/static/layui/layui.all.js"></script>
    <script src="/static/kindeditor/kindeditor-all-min.js"></script>
    <script src="/static/kindeditor/lang/zh-CN.js"></script>

    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->

    <style type="text/css">
        div{
            width:100%;
        }
    </style>
</head>
<body>
  <form>
      <table class="layui-table">
          <tr  hidden="hidden">
              <td>编号</td>
              <td><input value="${article.id!}"  id="id"></td>
          </tr>
          <tr>
              <td>标题</td>
              <td><input value="${article.title!}" id="title"></td>
          </tr>
          <tr>
              <td>摘要</td>
              <td>< <textarea id="editor_id" name="content" style="width:700px;height:300px;">
              ${article.summary}
              </textarea></td>
          </tr>
          <tr hidden="hidden">
              <td>发表时间</td>
              <td><input value="${article.publishDate!}"   id="publishDate"></td>
          </tr>
          <tr>
              <td>所属分类</td>
              <td><select id="cateid1"><option value="${article.cateid!}">${article.cate.cateName!}</option>
                          <#list allCate as cate>
                              <option value="${cate.id}">${cate.cateName}</option>
                          </#list>
              </select></td>
          </tr>
          <tr>
              <td></td>
              <td><button onclick="update()"  class="layui-btn layui-btn-normal">提交</button></td>
          </tr>
          <tr>
      </table>
  </form>
</body>
<script type="text/javascript">
    KindEditor.ready(function(K) {
        window.editor = K.create('#editor_id');
    });
    function update() {
         getContent();
        var id = $("#id").val();
        var summary = editor.html();
        var title = $("#title").val();
        var publishDate = $("#publishDate").val();
        var  myselect=document.getElementById("cateid1");
        var index=myselect.selectedIndex ;
        var cateid = myselect.options[index].value;
        $.ajax({
            type: "POST",
            url: "/article/update",
            data: {
                id:id,
                title:title,
                summary:summary,
                publishDate:publishDate,
                cateid:cateid
            },
            success: function(msg){
               layer.alert(msg.msg,function () {
                    window.parent.location.reload()
                })
            }
        });
    }
</script>
</html>