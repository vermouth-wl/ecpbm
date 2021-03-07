<%--
  Created by IntelliJ IDEA.
  User: kagura
  Date: 2020/12/20
  Time: 5:32 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>电子商务平台-后台登录页</title>
    <!-- 引入EasyUI的相关js和css文件 -->
    <link href="EasyUI/themes/default/easyui.css" rel="stylesheet" type="text/css">
    <link href="EasyUI/themes/icon.css" rel="stylesheet" type="text/css">
    <link href="EasyUI/demo/demo.css" rel="stylesheet" type="text/css">
    <script src="EasyUI/jquery.min.js" type="text/javascript"></script>
    <script src="EasyUI/jquery.easyui.min.js" type="text/javascript"></script>
    <script src="EasyUI/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
</head>
<body>
    <script type="text/javascript">
        function clearForm() {
            $('#adminLoginForm').form('clear')
        }
        function checkAdminLogin() {
            $('adminLoginForm').form("submit", {
                // 向控制器类AdminInfoController中的login方法发送请求
                uri: 'admininfo/login',
                success: function (result) {
                    var result = eval('(' + result + ')');
                    if (result.seccess == 'true') {
                        window.location.href = 'admin.jsp';
                        $('adminLoginDlg').dialog("close");
                    } else {
                        $.messager.show({
                            title: "提示信息",
                            msg: result.message
                        });
                    }
                }
            });
        }
    </script>
    <div id="adminLoginDlg" class="easyui-dialog"
         style="left: 550px; top: 200px; width: 300; height: 200"
         data-options="titleS: '后台登录', buttons: '#bb',modal:true">
        <form id="adminLoginForm" method="post">
            <table style="margin: 20px;font-size: 13;">
                <tr>
                    <th>用户名</th>
                    <td>
                        <input class="easyui-textbox" type="text" id="name" name="name" data-options="required:true" value="admin"/>
                    </td>
                </tr>
                <tr>
                    <th>密码</th>
                    <td>
                        <input class="easyui-textbox" type="text" id="pwd" name="pwd" data-options="required:true" value="123456"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div id="bb">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="checkAdminLogin()">登录</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
    </div>
</body>
</html>
