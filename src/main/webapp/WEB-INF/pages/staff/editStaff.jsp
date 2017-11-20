<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>
    <link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/Calendar.js"></script>
    <script>
        function createXMLHttpRequest() {
            try {
                return new XMLHttpRequest();
            } catch (e) {
                try {
                    return new ActiveXObject("Msxml2.HTTP");
                } catch (e) {
                    try {
                        return new ActiveXObject("Microsoft.HTTP");
                    } catch (e) {
                        throw e;
                    }
                }
            }
        }

        function changePost(obj) {
            //选中部门
            var depId = obj.value;
            //获取XMLHttpRequest对象
            var xmlHttp = createXMLHttpRequest();
            //打开连接
            var url = "${pageContext.request.contextPath}/showPost.action";
            xmlHttp.open("POST", url, true);
            //设置请求头
            xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            //发出请求时,给出请求体
            xmlHttp.send("depId=" + depId);
            //给xmlHttp对象的onreadystatechange事件注册监听
            xmlHttp.onreadystatechange = function () {
                if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
                    //获取返回的json数据
                    var jsonData = eval("(" + xmlHttp.responseText + ")");
                    //显示到select的option中
                    var selectE = document.getElementById("postSelectId");
                    selectE.innerHTML = "<option value='-1'>----请--选--择----</option>";
                    for (var i = 0; i < jsonData.length; i++) {
                        var postObj = jsonData[i];
                        selectE.innerHTML += "<option name='post.postId' value='" + postObj.postId + "'>" + postObj.postName + "</option>";
                    }
                }
            }
        }
    </script>
</head>

<body class="emp_body">
<table border="0" cellspacing="0" cellpadding="0" width="100%">
    <tr>
        <td class="topg"></td>
    </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0" class="wukuang" width="100%">
    <tr>
        <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
        <td width="44%" align="left">[员工管理]</td>

        <td width="52%" align="right">
            <!-- 提交表单 -->
            <a href="javascript:void(0)" onclick="document.forms[0].submit()">
                <img src="${pageContext.request.contextPath}/images/button/save.gif"/>
            </a>
            <!-- 执行js，进行返回 -->
            <a href="javascript:void(0)" onclick="window.history.go(-1)"><img
                    src="${pageContext.request.contextPath}/images/button/tuihui.gif"/></a>

        </td>
        <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
    </tr>
</table>

<form action="saveStaff.action" method="post">
    <input type="hidden" name="staffId" value="${staffId}"/>
    <table width="88%" border="0" class="emp_table" style="width:80%;">
        <s:iterator var="staff" value="staffs">
            <tr>
                <td>登录名：</td>
                <td><input type="text" name="loginName" value="${staff.loginName}"/></td>
                <td>密码：</td>
                <td><input type="password" name="loginPwd" value="${staff.loginPwd}" readonly="readonly"/></td>
            </tr>

        <tr>
            <td>姓名：</td>
            <td><input type="text" name="staffName" value="${staff.staffName}"/></td>
            <td>性别：</td>
            <td>
                <input type="radio" name="gender" checked="checked" value="男"/>男
                <input type="radio" name="gender" value="女"/>女
            </td>
        </tr>
        <tr>
            <td width="10%">所属部门：</td>
            <td width="20%">
                <select name="post.dept.deptId" onchange="changePost(this)">
                    <option value="">----请--选--择----</option>
                    <s:iterator var="department" value="departments">
                        <s:if test="#department.depId==model.post.dept.depId">
                            <option value="${department.depId}" selected="selected">${department.depName}</option>
                        </s:if>
                        <s:else>
                            <option value="${department.depId}">${department.depName}</option>
                        </s:else>
                    </s:iterator>
                </select>
            </td>
            <td width="8%">职务：</td>
            <td width="62%">
                <select name="post.postId" id="postSelectId">
                    <option value="${staff.post.postId}">${staff.post.postName}</option>
                </select>
            </td>
        </tr>
        <tr>
            <td width="10%">入职时间：</td>
            <td width="20%">
                <input type="text" name="onDutyDate" value="${staff.onDutyDate}" readonly="readonly"
                       onfocus="c.showMoreDay=true; c.show(this);"/>
            </td>
            <td width="8%"></td>
            <td width="62%"></td>
        </tr>
        </s:iterator>
    </table>
</form>

</body>
</html>
