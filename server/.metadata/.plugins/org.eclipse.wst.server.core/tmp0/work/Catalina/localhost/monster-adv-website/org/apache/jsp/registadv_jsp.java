/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.40
 * Generated at: 2014-08-12 08:59:12 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class registadv_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/css/map.css\" />\r\n");
      out.write("\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    <script src=\"http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\t\r\n");
      out.write("<script type=\"text/javascript\" src=\"http://openapi.map.naver.com/openapi/naverMap.naver?ver=2.0&key=806edb60b7778c1e58ea03b83f3bba5a\"></script>\r\n");
      out.write("<div id=\"map\" style=\"border:1px solid #000;\"></div>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("\t\tvar oSeoulCityPoint = new nhn.api.map.LatLng(37.5675451, 126.9773356);\r\n");
      out.write("\t\tvar defaultLevel = 11;\r\n");
      out.write("\t\tvar equipmentArray = new Array();\t/*장비 배열*/\r\n");
      out.write("\t\tvar oMap = new nhn.api.map.Map(document.getElementById('map'), { \r\n");
      out.write("\t\t\t\t\t\tpoint : oSeoulCityPoint,\r\n");
      out.write("\t\t\t\t\t\tzoom : defaultLevel,\r\n");
      out.write("\t\t\t\t\t\tenableWheelZoom : true,\r\n");
      out.write("\t\t\t\t\t\tenableDragPan : true,\r\n");
      out.write("\t\t\t\t\t\tenableDblClickZoom : false,\r\n");
      out.write("\t\t\t\t\t\tmapMode : 0,\r\n");
      out.write("\t\t\t\t\t\tactivateTrafficMap : false,\r\n");
      out.write("\t\t\t\t\t\tactivateBicycleMap : false,\r\n");
      out.write("\t\t\t\t\t\tminMaxLevel : [ 3, 14 ],\r\n");
      out.write("\t\t\t\t\t\tsize : new nhn.api.map.Size(800, 480)\t\t});\r\n");
      out.write("\t\tvar oSlider = new nhn.api.map.ZoomControl();\r\n");
      out.write("\t\toMap.addControl(oSlider);\r\n");
      out.write("\t\toSlider.setPosition({\r\n");
      out.write("\t\t\ttop : 10,\r\n");
      out.write("\t\t\tleft : 10\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar oSize = new nhn.api.map.Size(28, 37);\r\n");
      out.write("\t\tvar oOffset = new nhn.api.map.Size(14, 37);\r\n");
      out.write("\t\tvar oIcon = new nhn.api.map.Icon('/images/map/green_point.png', oSize, oOffset);\r\n");
      out.write("\t\t/*유동인구의 조건에 따라 이미지를 다르게 표시해 주기 위한 3색의 이미지*/\r\n");
      out.write("\t\tvar redIcon = new nhn.api.map.Icon('/images/map/red_point.png', oSize, oOffset);\r\n");
      out.write("\t\tvar greenIcon = new nhn.api.map.Icon('/images/map/green_point.png', oSize, oOffset);\r\n");
      out.write("\t\tvar yellooIcon = new nhn.api.map.Icon('/images/map/yello_point.png', oSize, oOffset);\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t/*정보 와드를 보여주기 위함*/\r\n");
      out.write("\t\tvar oInfoWnd = new nhn.api.map.InfoWindow();\r\n");
      out.write("\t\toInfoWnd.setVisible(false);\r\n");
      out.write("\t\toMap.addOverlay(oInfoWnd);\r\n");
      out.write("\r\n");
      out.write("\t\toInfoWnd.setPosition({\r\n");
      out.write("\t\t\ttop : 20,\r\n");
      out.write("\t\t\tleft :20\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\r\n");
      out.write("\t\tvar oLabel = new nhn.api.map.MarkerLabel(); // - 마커 라벨 선언.\r\n");
      out.write("\t\toMap.addOverlay(oLabel); // - 마커 라벨 지도에 추가. 기본은 라벨이 보이지 않는 상태로 추가됨.\r\n");
      out.write("\r\n");
      out.write("\t\toInfoWnd.attach('changeVisible', function(oCustomEvent) {\r\n");
      out.write("\t\t\tif (oCustomEvent.visible) {\r\n");
      out.write("\t\t\t\toLabel.setVisible(false);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\r\n");
      out.write("\t\toMap.attach('mouseenter', function(oCustomEvent) {\r\n");
      out.write("\r\n");
      out.write("\t\t\tvar oTarget = oCustomEvent.target;\r\n");
      out.write("\t\t\t// 마커위에 마우스 올라간거면\r\n");
      out.write("\t\t\tif (oTarget instanceof nhn.api.map.Marker) {\r\n");
      out.write("\t\t\t\tvar oMarker = oTarget;\r\n");
      out.write("\t\t\t\toLabel.setVisible(true, oMarker); // - 특정 마커를 지정하여 해당 마커의 title을 보여준다.\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\toMap.attach('mouseleave', function(oCustomEvent) {\r\n");
      out.write("\r\n");
      out.write("\t\t\tvar oTarget = oCustomEvent.target;\r\n");
      out.write("\t\t\t// 마커위에서 마우스 나간거면\r\n");
      out.write("\t\t\tif (oTarget instanceof nhn.api.map.Marker) {\r\n");
      out.write("\t\t\t\toLabel.setVisible(false);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\toMap.attach('click', function(oCustomEvent) {\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t/*맵이 나타내고 있는 좌표를 가져 오는 부분*/\r\n");
      out.write("\t\t\t/*데이터를 가져와 점을 찍어야 함*/\r\n");
      out.write("\r\n");
      out.write("\t\t\tvar oTarget = oCustomEvent.target;\r\n");
      out.write("\t\t\toInfoWnd.setVisible(false);\r\n");
      out.write("\t\t\t// 마커 클릭하면\r\n");
      out.write("\t\t\tif (oTarget instanceof nhn.api.map.Marker) {\r\n");
      out.write("\t\t\t\taddList(oTarget);\r\n");
      out.write("\t\t\t\t// 겹침 마커 클릭한거면\r\n");
      out.write("\t\t\t\talert(oTarget.identifier);\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tif (oCustomEvent.clickCoveredMarker){\r\n");
      out.write("\t\t\t\t\treturn;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t/*맵과 저장할 ary*/\r\n");
      out.write("\t\tvar equipmentAddfunc = function(map,ary){\r\n");
      out.write("\t\t\tvar bound = map.getBound();\r\n");
      out.write("\t\t\tvar x1 = bound[0].x;\r\n");
      out.write("\t\t\tvar y1 = bound[0].y;\r\n");
      out.write("\t\t\tvar x2 = bound[1].x;\r\n");
      out.write("\t\t\tvar y2 = bound[1].y;\r\n");
      out.write("\t\t\tvar year = document.getElementById(\"year\").value;\r\n");
      out.write("\t\t\tvar month = document.getElementById(\"month\").value;\r\n");
      out.write("\t\t\tvar day = document.getElementById(\"day\").value;\r\n");
      out.write("\t\t\tvar hour = document.getElementById(\"hour\").value;\r\n");
      out.write("\t\t\tjQuery.ajax({\r\n");
      out.write("\t\t\ttype:\"POST\",\r\n");
      out.write("\t\t\t/*사이트가 바뀜에 따라 주소를 변경해야 됨*/\r\n");
      out.write("\t\t\turl:\"http://localhost:8081/FinalWebProject/Mapping\",\r\n");
      out.write("\t\t\t/*좌표에 해당하는 값을 전달함 이름 : value */\r\n");
      out.write("\t\t\tdata:{x1:x1,y1:y1,x2:x2,y2:y2,year:year,month:month,day:day,hour:hour},\r\n");
      out.write("\t\t\t/*json 타입으로 리턴 받음*/\r\n");
      out.write("\t\t\tdataType:\"json\",\r\n");
      out.write("\t\t\tsuccess:function(data,testStatus,jqXHR){\r\n");
      out.write("\t\t\t\tvar result = data.mapResult;\r\n");
      out.write("\t\t\t\tvar flag=0;\r\n");
      out.write("\t\t\t\tfor(var i=0;i<data.mapResult.length;i++){\r\n");
      out.write("\t\t\t\t\tflag=0;\r\n");
      out.write("\t\t\t\t\tfor(var j=0;j<ary.length;j++){\r\n");
      out.write("\t\t\t\t\t\tif(ary[j].coordinate.coordinateX==result[i].coordinate.coordinateX&&ary[j].coordinate.coordinateY==result[i].coordinate.coordinateY)\r\n");
      out.write("\t\t\t\t\t\t{\t\r\n");
      out.write("\t\t\t\t\t\t\tflag=1;\r\n");
      out.write("\t\t\t\t\t\t\tbreak;\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t}/*j loop end*/\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t/*flag가 1이면 지금 지도안에 기기를 저장하는 목록에 중복된 좌표가 존재한다는 것이므로 추가하지 아니한다.*/\r\n");
      out.write("\t\t\t\t\tif(flag==1){\r\n");
      out.write("\t\t\t\t\t\tflag=0;\t/*그러면 flag만 0으로 바꾼다.*/\r\n");
      out.write("\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\tary.push(result[i]);/*이전에 없는 것인 경우 push한다.*/\r\n");
      out.write("\t\t\t\t\t\tvar oMarker;\r\n");
      out.write("\t\t\t\t\t\t/*0~5명 한가한 경우*/\r\n");
      out.write("\t\t\t\t\t\tif(0<=result[i].population&&result[i].population<=5){\r\n");
      out.write("\t\t\t\t\t\t\toMarker = new nhn.api.map.Marker(greenIcon, { title :result[i].address.si+' '+result[i].address.gu+' '+result[i].address.dong+' '+result[i].address.other});\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t/*6~10명 조금 바쁜 경우*/\r\n");
      out.write("\t\t\t\t\t\t}else if(6<=result[i].population&&result[i].population<=10){\r\n");
      out.write("\t\t\t\t\t\t\toMarker = new nhn.api.map.Marker(yelloIcon, { title :result[i].address.si+' '+result[i].address.gu+' '+result[i].address.dong+' '+result[i].address.other});\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t/*10명 초과인 경우*/\r\n");
      out.write("\t\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\t\toMarker = new nhn.api.map.Marker(redIcon, { title :result[i].address.si+' '+result[i].address.gu+' '+result[i].address.dong+' '+result[i].address.other});\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\toMarker.identifier = result[i].identifier;//identifier 추가\r\n");
      out.write("\t\t\t\t\t\toMarker.setPoint(new nhn.api.map.LatLng(result[i].coordinate.coordinateY,result[i].coordinate.coordinateX));\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\toMap.addOverlay(oMarker);\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t}/*else end*/\r\n");
      out.write("\t\t\t\t}/*i for문 end*/\r\n");
      out.write("\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t \terror: function(xhr,status,error){\r\n");
      out.write("\t\t\t\talert(xhr);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t};\r\n");
      out.write("\t\tvar addList = function(marker){\r\n");
      out.write("\t\t\tvar list=document.getElementById(\"graph_list\");\r\n");
      out.write("\t\t\tif(list.options.length==5){\r\n");
      out.write("\t\t\t\talert(\"다섯개 이상 등록할 수 없습니다.\");\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t//이미 존재하는 값이면\r\n");
      out.write("\t\t\tif(checkOption(list,marker.identifier)){\r\n");
      out.write("\t\t\t\talert(\"이미 추가되어 있습니다.\");\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tvar equipOption =document.createElement(\"option\");\r\n");
      out.write("\r\n");
      out.write("\t\t\tequipOption.value=marker.identifier;\r\n");
      out.write("\r\n");
      out.write("\t\t\tequipOption.text=marker.getTitle();\r\n");
      out.write("\r\n");
      out.write("\t\t\tlist.add(equipOption,null);\r\n");
      out.write("\t\t};\r\n");
      out.write("\t\tvar checkOption = function(listBox,value){\r\n");
      out.write("\t\t\tvar exists=false;\r\n");
      out.write("\r\n");
      out.write("\t\t\tfor(var i=0;i<listBox.options.length;i++){\r\n");
      out.write("\t\t\tif(listBox.options[i].value==value){ \r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\treturn exists;\r\n");
      out.write("\t\t\t};\r\n");
      out.write("\t\t\r\n");
      out.write("\t\toMap.attach('dragend', function(oCustomEvent) {\r\n");
      out.write("\t\t\tequipmentAddfunc(oMap,equipmentArray);\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\r\n");
      out.write("\t\twindow.onload=function(){\r\n");
      out.write("\t\t\tvar selectedRemove=document.getElementById(\"selectedRemove\");\r\n");
      out.write("\t\t\tselectedRemove.addEventListener(\"click\",\r\n");
      out.write("\t\t\t\tfunction(){\r\n");
      out.write("\t\t\t\tvar list=document.getElementById(\"graph_list\");\r\n");
      out.write("\t\t\t\tif(list.options.length==0){\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tvar optionToRemove=list.options.selectedIndex;\r\n");
      out.write("\t\t\t\tlist.remove(optionToRemove);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\t\t,false);\t\r\n");
      out.write("\t\t};\r\n");
      out.write("\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
