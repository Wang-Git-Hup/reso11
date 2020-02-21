<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>对标管理</title>
    <!--1.引入echarts.js -->
    <script type="text/javascript" src="static/js/echarts.js"></script>
    <script type="text/javascript" src="static/js/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        $(function () {

            var names=[];
            var scores=[];
            $.ajax({
                type:"GET",
                url:"compare/list",
                success:function (msg) {

                    $(msg).each(function (index,item) {
                        names.push(item.company);
                        scores.push(item.targetmoney);
                    });

                    <!-- 3.初始化图表  -->
                    var myChart= echarts.init(document.getElementById("main"));
                    // 5.指定图表的配置项和数据
                    var option = {
                        title: {
                            text: '各操作系统手机销量展示'
                        },
                        tooltip: {},
                        legend: {
                            data:['销量']
                        },
                        xAxis: {
                            data: names
                        },
                        yAxis: {
                            axisLabel:{
                                formatter:function (value, index) {
                                   return value+"万";
                                }
                            }
                        },
                        series: [{
                            name: '销量',
                            type: 'bar',
                            data: scores
                        }]
                    };
                    <!-- 4.往图表中设置数据 -->
                    myChart.setOption(option);
                }
            });







        });
    </script>
</head>
<body>
<!-- 2.为 ECharts 准备一个具备大小（宽高）的 DOM -->
<div id="main" style="width: 600px;height:400px;"></div>
</body>
</html>