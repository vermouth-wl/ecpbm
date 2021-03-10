<%--
  Created by IntelliJ IDEA.
  User: kagura
  Date: 2020/12/20
  Time: 5:33 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if (session.getAttribute("admin") == null) {
        response.sendRedirect("/ecpbm/admin_login.jsp");
    }
%>
<html>
<head>
    <title>后台管理首页</title>
    <!-- 引入EasyUI的相关js和css文件 -->
    <link href="EasyUI/themes/default/easyui.css" rel="stylesheet" type="text/css">
    <link href="EasyUI/themes/icon.css" rel="stylesheet" type="text/css">
    <link href="EasyUI/demo/demo.css" rel="stylesheet" type="text/css">
    <script src="EasyUI/jquery.min.js" type="text/javascript"></script>
    <script src="EasyUI/jquery.easyui.min.js" type="text/javascript"></script>
    <script src="EasyUI/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
</head>
<body class="easyui-layout">
    <div data-options="region:'north', border:false" style="height: 60px; background: #B3DFDA; padding: 10px">
        <div align="left">
            <div style="font-family: 'Microsoft YaHei; font-size: 16px;">电商平台后台管理系统</div>
        </div>
        <div align="right">
            欢迎您，<font color="red">${sessionScope.admin.name}</font>
        </div>
    </div>
    <div data-options="region:'west', split:true, title:'功能菜单'" style="width: 180px">
        <ul id="tt"></ul>
    </div>
    <div data-options="region:'south', border:false" style="height: 50px; background: #A9FACD; padding: 10px; text-align: center">
        powered by kagura
    </div>
    <div data-options="region:'center'">
        <div id="tabs" data-options="fit:true" class="easyui-tabs" style="width: 500px;height: 250px;"></div>
    </div>
    <script type="text/javascript">
        // 为tree指定数据
        $('#tt').tree({
            url: 'admininfo/getTree?adminid=${sessionScope.admin.id}'
        });
        $('#tt').tree({
            onClick: function(node) {
                if ("商品列表" == node.text) {
                    if ($('#tabs').tabs('exists', '商品列表')) {
                        $('#tabs').tabs('select', '商品列表');
                    } else {
                        $('#tabs').tabs('add', {
                            title: node.text,
                            href: 'productlist.jsp',
                            closable: true
                        });
                    }
                } else if ("商品类型列表" == node.text) {
                    if ($('#tabs').tabs('exists', '商品类型列表')) {
                        $('#tabs').tabs('select', '商品类型列表');
                    } else {
                        $('#tabs').tabs('add', {
                            title: node.text,
                            href: 'typelist.jsp',
                            closable: true
                        });
                    }
                } else if ("查询订单" == node.text) {
                    if ($('#tabs').tabs('exists', '查询订单')) {
                        $('#tabs').tabs('select', '查询订单');
                    } else {
                        $('#tabs').tabs('add', {
                            title: node.text,
                            href: 'searchorder.jsp',
                            closable: true
                        });
                    }
                } else if ("创建订单" == node.text) {
                    if ($('#tabs').tabs('exists', '创建订单')) {
                        $('#tabs').tabs('select', '创建订单');
                    } else {
                        $('#tabs').tabs('add', {
                            title: node.text,
                            href: 'createorder.jsp',
                            closable: true
                        });
                    }
                } else if ("客户列表" == node.text) {
                    if ($('#tabs').tabs('exists', '客户列表')) {
                        $('#tabs').tabs('select', '客户列表');
                    } else {
                        $('#tabs').tabs('add', {
                            title: node.text,
                            href: 'userlist.jsp',
                            closable: true
                        });
                    }
                } else if ("管理员列表" == node.text) {
                    if ($('#tabs').tabs('exists', '管理员列表')) {
                        $('#tabs').tabs('select', '管理员列表');
                    } else {
                        $('#tabs').tabs('add', {
                            title: node.text,
                            href: 'adminlist.jsp',
                            closable: true
                        });
                    }
                } else if ("退出系统" == node.text) {
                    $.ajax({
                        url: 'admininfo/logout',
                        success: function(data) {
                            window.location.href = "admin_login.jsp";
                        }
                    })
                }
            }
        });
    </script>
</body>
</html>
