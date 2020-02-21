<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>创建任务</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>
	<script>
		$(function(){
		    $.ajax({
                url:"${pageContext.request.contextPath}/emp/getEmps",
                type:"get",
                success:function(obj){
                    $(obj).each(function(index,item){
                        var opt ="<option value='"+item.eid+"'>"+item.ename+"</option>";
                        //添加到指定行后面
                        $("#emp").append(opt);
                    });
                }
			})
			$.ajax({
				url:"${pageContext.request.contextPath}/pro/showProAndOtherInfo",
				type:"get",
				data:{"mark":"3"},
				success:function(obj){
                    $(obj).each(function(index,item){
                        var opt ="<option value='"+item.pid+"'>"+item.pname+"</option>";
                        //添加到指定行后面
                        $("#pro").append(opt);
                    });
				}
			})
		})
		//项目下拉框改变事件
        function  Alays(obj) {
            $.ajax({
                url:"${pageContext.request.contextPath}/analys/showAnalys",
                type:"get",
                data:{"id":obj},
                success:function(msg){
                    $("#Analys").val(msg.title)
                }
            })
            $.ajax({
                url:"${pageContext.request.contextPath}/mou/findByanalFk",
                type:"get",
                data:{"id":obj},
                success:function(msg){
                    $(".b").remove();
                    $(msg).each(function(index,item){
                        var opt ="<option class='b' value='"+item.id+"'>"+item.modname+"</option>";
                        //添加到指定行后面
                        $("#mod").append(opt);
                    });
                }
            })


        }
        //模块下拉框改变展示功能信息
        function  funoo(obj) {
            $.ajax({
                url:"${pageContext.request.contextPath}/fun/findmouFk",
                type:"get",
                data:{"id":obj},
                success:function(msg){
                    $(".a").remove();
                    $(msg).each(function(index,item){
                        var opt ="<option  class='a' value='"+item.id+"'>"+item.functionname+"</option>";
                        //添加到指定行后面
                        $("#fun").append(opt);
                    });
                }
            })
        }
        function cobmit() {
		$("#form2").submit();

        }

	</script>
</head>
<body leftmargin="8" topmargin="8" background='skin/images/allbg.gif'>

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
<tr>
 <td height="26" background="skin/images/newlinebg3.gif">
  <table width="58%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td >
    当前位置:任务管理>>创建任务
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<form name="form2" id="form2" action="${pageContext.request.contextPath}/task/saveTask" method="post">

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="2" background="skin/images/tbg.gif">&nbsp;创建任务&nbsp;</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">参考位置：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<%--项目--%>
		<select id="pro" onchange="Alays(this.value)" >
			<option value=0>请选择</option>
			</select>-
			<input id="Analys" type="text" >-
			<select id="mod" onchange="funoo(this.value)">
				<option value=0>请选择</option>
		</select>-
		<select id="fun" name="funFk"><option value=0>请选择</option>
			</select>
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">任务标题：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input name="tasktitle"/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">开始时间：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input name="starttime"/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">结束时间：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input name="endtime"/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">执行者：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<select id="emp" name="empFk">
			<option value=0>请选择</option>
		</select></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">优先级：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><select name="level"><option>高</option><option>中</option><option>低</option><option>暂缓</option></select></td>
</tr>

<tr >
	<td align="right" bgcolor="#FAFAF1" >详细说明：</td>
	<td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
		<textarea rows=10 cols=130  name="remark"></textarea>
	</td>
</tr>


<tr bgcolor="#FAFAF1">
<td height="28" colspan=4 align=center>
	&nbsp;
	<a href="javascript:cobmit()" class="coolbg">保存</a>
</td>
</tr>
</table>

</form>
  

</body>
</html>