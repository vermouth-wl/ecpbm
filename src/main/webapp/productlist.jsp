<%--
  Created by IntelliJ IDEA.
  User: kagura
  Date: 2020/12/20
  Time: 5:33 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品列表</title>
    <!-- 引入EasyUI的相关js和css文件 -->
    <link href="EasyUI/themes/default/easyui.css" rel="stylesheet" type="text/css">
    <link href="EasyUI/themes/icon.css" rel="stylesheet" type="text/css">
    <link href="EasyUI/demo/demo.css" rel="stylesheet" type="text/css">
    <script src="EasyUI/jquery.min.js" type="text/javascript"></script>
    <script src="EasyUI/jquery.easyui.min.js" type="text/javascript"></script>
    <script src="EasyUI/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
</head>
<body>
    <table id="dg_productinfo" class="easyui-datagrid"></table>
    <!-- 创建Datagrid控件的工具栏，添加、修改、删除商品 -->
    <div id="tb_productinfo" style="padding: 2px 5px;">
        <a href="javascript:void(0)" class="easyui-linkbutton"
           iconCls="icon-add" plain="true" onclick="addProduct();">添加</a>
        <a href="javascript:void(0)" class="easyui-linkbutton"
           iconCls="icon-edit" plain="true" onclick="editProduct();">修改</a>
        <a href="javascript:void(0)" class="easyui-linkbutton"
           iconCls="icon-remove" plain="true" onclick="removeProduct();">删除</a>
    </div>
</body>
</html>
