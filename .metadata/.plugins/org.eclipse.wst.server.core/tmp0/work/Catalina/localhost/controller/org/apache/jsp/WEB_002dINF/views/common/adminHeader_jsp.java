/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.50
 * Generated at: 2023-06-20 11:14:29 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.common;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class adminHeader_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

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
  }

  public void _jspDestroy() {
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

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("\t\t<title>Template</title>\n");
      out.write("\t  \t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("\t  \t<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js\"></script>\n");
      out.write("\t  \t<meta content=\"\" name=\"keywords\">\n");
      out.write("\t    <meta content=\"\" name=\"description\">\n");
      out.write("\t    <link href=\"https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css\" rel=\"stylesheet\" />\n");
      out.write("\t    <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/css/admin.css\" rel=\"stylesheet\" />\n");
      out.write("\t    <script data-search-pseudo-elements defer src=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/js/all.min.js\" crossorigin=\"anonymous\"></script>\n");
      out.write("\t    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/feather-icons/4.28.0/feather.min.js\" crossorigin=\"anonymous\"></script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<nav class=\"topnav navbar navbar-expand shadow justify-content-between justify-content-sm-start navbar-light bg-white\" id=\"sidenavAccordion\">\n");
      out.write("            <!-- Sidenav Toggle Button-->\n");
      out.write("            <button class=\"btn btn-icon btn-transparent-dark order-1 order-lg-0 me-2 ms-lg-2 me-lg-0\" id=\"sidebarToggle\"><i data-feather=\"menu\"></i></button>\n");
      out.write("            <!-- Navbar Brand-->\n");
      out.write("            <!-- * * Tip * * You can use text or an image for your navbar brand.-->\n");
      out.write("            <!-- * * * * * * When using an image, we recommend the SVG format.-->\n");
      out.write("            <!-- * * * * * * Dimensions: Maximum height: 32px, maximum width: 240px-->\n");
      out.write("            <a class=\"navbar-brand pe-3 ps-4 ps-lg-2\" href=\"/controller/\">심비서</a>\n");
      out.write("            <!-- Navbar Search Input-->\n");
      out.write("            <!-- * * Note: * * Visible only on and above the lg breakpoint-->\n");
      out.write("            <form class=\"form-inline me-auto d-none d-lg-block me-3\">\n");
      out.write("                <div class=\"input-group input-group-joined input-group-solid\">\n");
      out.write("                    <input class=\"form-control pe-0\" type=\"search\" placeholder=\"Search\" aria-label=\"Search\" />\n");
      out.write("                    <div class=\"input-group-text\"><i data-feather=\"search\"></i></div>\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("        </nav>\n");
      out.write("        <div id=\"layoutSidenav\">\n");
      out.write("            <div id=\"layoutSidenav_nav\">\n");
      out.write("                <nav class=\"sidenav shadow-right sidenav-light\">\n");
      out.write("                    <div class=\"sidenav-menu\">\n");
      out.write("                        <div class=\"nav accordion\" id=\"accordionSidenav\">\n");
      out.write("                            <!-- Sidenav Accordion (Dashboard)-->\n");
      out.write("                           <a class=\"nav-link\" href=\"#\"> Dashboards</a>\n");
      out.write("                           <a class=\"nav-link\" href=\"adminMember.do\">Users List</a>\n");
      out.write("                           <a class=\"nav-link\" href=\"adminMemberData.do\">Users Data</a>\n");
      out.write("                            <!-- Sidenav Accordion (Applications)-->\n");
      out.write("                                \n");
      out.write("                            <div class=\"collapse\" id=\"collapseApps\" data-bs-parent=\"#accordionSidenav\">\n");
      out.write("                                <nav class=\"sidenav-menu-nested nav accordion\" id=\"accordionSidenavAppsMenu\">\n");
      out.write("                                    <!-- Nested Sidenav Accordion (Apps -> Knowledge Base)-->\n");
      out.write("                                    <a class=\"nav-link collapsed\" href=\"javascript:void(0);\" data-bs-toggle=\"collapse\" data-bs-target=\"#appsCollapseKnowledgeBase\" aria-expanded=\"false\" aria-controls=\"appsCollapseKnowledgeBase\">\n");
      out.write("                                        Knowledge Base\n");
      out.write("                                        <div class=\"sidenav-collapse-arrow\"><i class=\"fas fa-angle-down\"></i></div>\n");
      out.write("                                    </a>\n");
      out.write("                                    <div class=\"collapse\" id=\"appsCollapseKnowledgeBase\" data-bs-parent=\"#accordionSidenavAppsMenu\">\n");
      out.write("                                        <nav class=\"sidenav-menu-nested nav\">\n");
      out.write("                                            <a class=\"nav-link\" href=\"knowledge-base-home-1.html\">Home 1</a>\n");
      out.write("                                            <a class=\"nav-link\" href=\"knowledge-base-home-2.html\">Home 2</a>\n");
      out.write("                                            <a class=\"nav-link\" href=\"knowledge-base-category.html\">Category</a>\n");
      out.write("                                            <a class=\"nav-link\" href=\"knowledge-base-article.html\">Article</a>\n");
      out.write("                                        </nav>\n");
      out.write("                                    </div>\n");
      out.write("                                    <!-- Nested Sidenav Accordion (Apps -> User Management)-->\n");
      out.write("                                    <a class=\"nav-link collapsed\" href=\"javascript:void(0);\" data-bs-toggle=\"collapse\" data-bs-target=\"#appsCollapseUserManagement\" aria-expanded=\"false\" aria-controls=\"appsCollapseUserManagement\">\n");
      out.write("                                        User Management\n");
      out.write("                                        <div class=\"sidenav-collapse-arrow\"><i class=\"fas fa-angle-down\"></i></div>\n");
      out.write("                                    </a>\n");
      out.write("                                    <div class=\"collapse\" id=\"appsCollapseUserManagement\" data-bs-parent=\"#accordionSidenavAppsMenu\">\n");
      out.write("                                        <nav class=\"sidenav-menu-nested nav\">\n");
      out.write("                                            \n");
      out.write("                                            <a class=\"nav-link\" href=\"user-management-edit-user.html\">Edit User</a>\n");
      out.write("                                            <a class=\"nav-link\" href=\"user-management-add-user.html\">Add User</a>\n");
      out.write("                                            <a class=\"nav-link\" href=\"user-management-groups-list.html\">Groups List</a>\n");
      out.write("                                            <a class=\"nav-link\" href=\"user-management-org-details.html\">Organization Details</a>\n");
      out.write("                                        </nav>\n");
      out.write("                                    </div>\n");
      out.write("                                    <!-- Nested Sidenav Accordion (Apps -> Posts Management)-->\n");
      out.write("                                    <a class=\"nav-link collapsed\" href=\"javascript:void(0);\" data-bs-toggle=\"collapse\" data-bs-target=\"#appsCollapsePostsManagement\" aria-expanded=\"false\" aria-controls=\"appsCollapsePostsManagement\">\n");
      out.write("                                        Posts Management\n");
      out.write("                                        <div class=\"sidenav-collapse-arrow\"><i class=\"fas fa-angle-down\"></i></div>\n");
      out.write("                                    </a>\n");
      out.write("                                    <div class=\"collapse\" id=\"appsCollapsePostsManagement\" data-bs-parent=\"#accordionSidenavAppsMenu\">\n");
      out.write("                                        <nav class=\"sidenav-menu-nested nav\">\n");
      out.write("                                            <a class=\"nav-link\" href=\"blog-management-posts-list.html\">Posts List</a>\n");
      out.write("                                            <a class=\"nav-link\" href=\"blog-management-create-post.html\">Create Post</a>\n");
      out.write("                                            <a class=\"nav-link\" href=\"blog-management-edit-post.html\">Edit Post</a>\n");
      out.write("                                            <a class=\"nav-link\" href=\"blog-management-posts-admin.html\">Posts Admin</a>\n");
      out.write("                                        </nav>\n");
      out.write("                                    </div>\n");
      out.write("                                </nav>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("            </div>\n");
      out.write("</body>\n");
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
}
