<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>AJAX根据省份ID获取名称</title>
  <script type="text/javascript">
    function search() {
      var xmlHTTP =new XMLHttpRequest();
      xmlHTTP.onreadystatechange=function(){
        if(xmlHTTP.readyState==4&&xmlHTTP.status==200){
          //alert(xmlHTTP.responseText)
          document.getElementById("proname").value=xmlHTTP.responseText;
        }
      }
      var proid=document.getElementById("proid").value;
      xmlHTTP.open("get","queryProvince?proid="+proid,true);
      xmlHTTP.send();
    }
  </script>
</head>
<body>
<table>
  <tr>
    <td>省份编号：</td>
    <td>
      <input type="text" id="proid">
      <input type="button" value="搜索" onclick="search()">
    </td>
  </tr>
  <tr>
    <td>省份名称：</td>
    <td><input type="text" id="proname"></td>
  </tr>
</table>
</body>
</html>
