/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.50
 * Generated at: 2023-06-05 01:25:21 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.main;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class upload_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("jar:file:/C:/eGovFrame-4.0.0/workspace.edu/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/ShimBeeSeo/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1612850415545L));
    _jspx_dependants.put("jar:file:/C:/eGovFrame-4.0.0/workspace.edu/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/ShimBeeSeo/WEB-INF/lib/jstl-1.2.jar!/META-INF/fn.tld", Long.valueOf(1153352682000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("<title>Bootstrap Example</title>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<meta content=\"\" name=\"keywords\">\r\n");
      out.write("<meta content=\"\" name=\"description\">\r\n");
      out.write("\r\n");
      out.write("<!-- Favicon -->\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/img/favicon.ico\" rel=\"icon\">\r\n");
      out.write("\r\n");
      out.write("<!-- Google Web Fonts -->\r\n");
      out.write("<link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\r\n");
      out.write("<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\r\n");
      out.write("<link\r\n");
      out.write("\thref=\"https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600&family=Inter:wght@600&family=Lobster+Two:wght@700&display=swap\"\r\n");
      out.write("\trel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<!-- Icon Font Stylesheet -->\r\n");
      out.write("<link\r\n");
      out.write("\thref=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css\"\r\n");
      out.write("\trel=\"stylesheet\">\r\n");
      out.write("<link\r\n");
      out.write("\thref=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css\"\r\n");
      out.write("\trel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<!-- Libraries Stylesheet -->\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/lib/animate/animate.min.css\"\r\n");
      out.write("\trel=\"stylesheet\">\r\n");
      out.write("<link\r\n");
      out.write("\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/lib/owlcarousel/assets/owl.carousel.min.css\"\r\n");
      out.write("\trel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<!-- Customized Bootstrap Stylesheet -->\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/css/bootstrap.min.css\"\r\n");
      out.write("\trel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<!-- Template Stylesheet -->\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/css/style.css\" rel=\"stylesheet\">\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write(".flex-container {\r\n");
      out.write("\tdisplay: flex;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".wrapper {\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\tflex-grow: 1;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".wrapper .image-box {\r\n");
      out.write("\twidth: 200px;\r\n");
      out.write("\theight: 200px;\r\n");
      out.write("\tobject-fit: cover;\r\n");
      out.write("\tdisplay: block;\r\n");
      out.write("\tmargin: 20px auto;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".wrapper .upload-btn {\r\n");
      out.write("\tborder: 1px solid #ddd;\r\n");
      out.write("\tpadding: 6px 12px;\r\n");
      out.write("\tdisplay: inline-block;\r\n");
      out.write("\tcursor: pointer;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".wrapper .upload-btn input[type=file] {\r\n");
      out.write("\tdisplay: none;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"container-xxl bg-white p-0\">\r\n");
      out.write("\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../common/header.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- 상자생성하고 사진넣어보기 -->\r\n");
      out.write("\t\t<section style=\"font-family: 'MaplestoryOTFBold';\" id=\"projects\"\r\n");
      out.write("\t\t\tclass=\"about-section text-center\">\r\n");
      out.write("\t\t\t<div style=\"margin-top: 0;\" class=\"testView\">\r\n");
      out.write("\t\t\t\t<h1>\r\n");
      out.write("\t\t\t\t\t<strong style=\"font-family: 'MaplestoryOTFBold';\">그림 업로드</strong>\r\n");
      out.write("\t\t\t\t</h1>\r\n");
      out.write("\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t<div style=\"display: block;\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"uploadPhoto\">\r\n");
      out.write("\t\t\t\t\t\t\t<h3>\r\n");
      out.write("\t\t\t\t\t\t\t\t<strong style=\"font-family: 'NEXON Lv1 Gothic OTF'\">사람</strong>\r\n");
      out.write("\t\t\t\t\t\t\t</h3>\r\n");
      out.write("\t\t\t\t\t\t\t");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<!--미리보기 테스트 -->\r\n");
      out.write("\t\t\t\t\t\t\t<form method=\"POST\" enctype=\"multipart/form-data\" id=\"form_img\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"flex-container\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"wrapper\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<h2>FileReader</h2>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<img src=\"https://i0.wp.com/adventure.co.kr/wp-content/uploads/2020/09/no-image.jpg\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tclass=\"image-box\" /> <label for=\"file\" class=\"upload-btn\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<input id=\"file\" multiple name=\"file\" type=\"file\" accept=\"image/*\" /> <span>Upload\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tImage</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- \t============================= 이미지 하나만 사용\t======================================\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"wrapper\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<h2>URL API</h2>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<img\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tsrc=\"https://i0.wp.com/adventure.co.kr/wp-content/uploads/2020/09/no-image.jpg\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tclass=\"image-box\" /> <label for=\"file2\" class=\"upload-btn\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<input id=\"file2\" type=\"file\" accept=\"image/*\" /> <span>Upload\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tImage</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div> -->\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<!-- 미리보기 이후 파일 업로드하기 -->\r\n");
      out.write("\t\t\t\t\t\t\t\t<button type=\"button\" onclick=\"uploadFunction();\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tclass=\"form-control btn btn-primary\" style=\"width: 150px\">파일업로드</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t<!--미리보기 테스트 끝 -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t\t<div style=\"margin: 0 !important;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<form name=\"inputImg\" method=\"POST\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div style=\"display: flex;\" class=\"container\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div style=\"display: block; margin: 0 auto\" class=\"col-md-4\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"width: 30rem; height: 30rem; background-image:url('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/img/sk(1).png'); background-repeat : no-repeat; background-size : 100% 100%; padding: 2rem 1.5rem;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"width: 26rem; height: 25rem;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<img style=\"width: 100%; height: 100%;\" id=\"foo2\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<br> <input class=\"btn btn-info\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tstyle=\"background-color: #FE5D37; border-color: #FE5D37; color: white\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tid=\"beforeSend\" type=\"submit\" value=\"이전페이지로\"> <input\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tclass=\"btn btn-info\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tstyle=\"background-color: #FE5D37; border-color: #FE5D37; color: white\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tid=\"nextSend\" type=\"button\" value=\"다음단계로\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tonclick=\"location.href='test2.do'\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div id=\"resultView\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<h3 id=\"resultTxt\"></h3>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../common/footer.jsp", out, false);
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<!-- JavaScript Libraries -->\r\n");
      out.write("\t<script src=\"https://code.jquery.com/jquery-3.4.1.min.js\"></script>\r\n");
      out.write("\t<script\r\n");
      out.write("\t\tsrc=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/lib/wow/wow.min.js\"></script>\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/lib/easing/easing.min.js\"></script>\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/lib/waypoints/waypoints.min.js\"></script>\r\n");
      out.write("\t<script\r\n");
      out.write("\t\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/lib/owlcarousel/owl.carousel.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\t<!-- Template Javascript -->\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/js/main.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t/* event.preventDefault(); */\r\n");
      out.write("\r\n");
      out.write("\t\tlet url = 'http://192.168.56.1:9000/photo';\r\n");
      out.write("\r\n");
      out.write("\t\t/*  \t\tconst response = fetch('http://192.168.56.1:9000/photo', {\r\n");
      out.write("\t\t method: 'POST',\r\n");
      out.write("\t\t body: formData\r\n");
      out.write("\t\t }); */\r\n");
      out.write("\r\n");
      out.write("\t\tconst formData = new FormData();\r\n");
      out.write("\r\n");
      out.write("/* =========================이미지 모델에게 확인 요청 ================================= */\r\n");
      out.write("\t\tfunction uploadFunction() {\r\n");
      out.write("\t\t\t// 임의 test, id값 쿼리스트링으로 보내기\r\n");
      out.write("\t\t\tvar id = 'samsam'\r\n");
      out.write("\t\t\tvar data = new FormData(form_img);\r\n");
      out.write("\t\t\tconsole.log(\"파일 업로드 요청\");\r\n");
      out.write("\r\n");
      out.write("\t\t\t/* async : false -> 비동기 동기로 변경, 다만 값 받아오기 전에 페이지 이동해 버리면 값 못받고 넘어감!!\r\n");
      out.write("\t\t\t\t\t\t\t\t주의하자! */\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\ttype : \"POST\",\r\n");
      out.write("\t\t\t\tenctype : 'multipart/form-data',\r\n");
      out.write("\t\t\t\turl : \"http://192.168.56.1:9000/photo/\" + id,\r\n");
      out.write("\t\t\t\tdata : data,\r\n");
      out.write("\t\t\t\tprocessData : false,\r\n");
      out.write("\t\t\t\tcontentType : false,\r\n");
      out.write("\t\t\t\tcache : false,\r\n");
      out.write("\t\t\t\ttimeout : 600000,\r\n");
      out.write("\t\t\t\tsuccess : function(items) {\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\tif (res = !null) {\r\n");
      out.write("\t\t\t\t\t\tconsole.log(\"파일 업로드 성공\");\r\n");
      out.write("\t\t\t\t\t\t// res 출력은 true만 나옴.. 어케 받아오지..?\r\n");
      out.write("\t\t\t\t\t\tconsole.log(items);\r\n");
      out.write("\t\t\t\t\t\t// 값 받아와서 히든태그에 집어 넣기!!\r\n");
      out.write("\t\t\t\t\t\t// null값 체크해서 페이지 이동 막아줘야 함\r\n");
      out.write("\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\tconsole.log(\"파일 업로드 실패\");\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\terror : function(e) {\r\n");
      out.write("\t\t\t\t\tconsole.log(\"파일 업로드 에러\");\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("\t<!-- 이미지 미리보기 처리 -->\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\tconst fileDOM = document.querySelector('#file');\r\n");
      out.write("\tconst previews = document.querySelectorAll('.image-box');\r\n");
      out.write("\r\n");
      out.write("\tfileDOM.addEventListener('change', () => {\r\n");
      out.write("\t  const reader = new FileReader();\r\n");
      out.write("\t  reader.onload = ({ target }) => {\r\n");
      out.write("\t    previews[0].src = target.result;\r\n");
      out.write("\t  };\r\n");
      out.write("\t  reader.readAsDataURL(fileDOM.files[0]);\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("\t/* 만약 이미지 두개 처리 할 거라면 */\r\n");
      out.write("\tconst fileDOM2 = document.querySelector('#file2');\r\n");
      out.write("\r\n");
      out.write("\tfileDOM2.addEventListener('change', () => {\r\n");
      out.write("\t  const imageSrc = URL.createObjectURL(fileDOM2.files[0]);\r\n");
      out.write("\t  previews[1].src = imageSrc;\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fset_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    boolean _jspx_th_c_005fset_005f0_reused = false;
    try {
      _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fset_005f0.setParent(null);
      // /WEB-INF/views/main/upload.jsp(6,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f0.setVar("contextPath");
      // /WEB-INF/views/main/upload.jsp(6,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f0.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/main/upload.jsp(6,0) '${pageContext.request.contextPath}'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${pageContext.request.contextPath}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
      if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      _jspx_th_c_005fset_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fset_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fset_005f0_reused);
    }
    return false;
  }
}