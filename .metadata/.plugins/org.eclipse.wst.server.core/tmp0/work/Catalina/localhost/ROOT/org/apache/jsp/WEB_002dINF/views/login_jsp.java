/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.19
 * Generated at: 2020-03-30 07:34:43 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
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
      out.write("<meta name=\"google-signin-client_id\"\n");
      out.write("\tcontent=\"383758306779-1jiumsras5rv9m91p26mbp1vc9lt2cpb.apps.googleusercontent.com\">\n");
      out.write("\n");
      out.write("<title>login</title>\n");
      out.write("<script src=\"//developers.kakao.com/sdk/js/kakao.min.js\"></script>\n");
      out.write("<script type=\"text/javascript\"\n");
      out.write("\tsrc=\"https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js\"\n");
      out.write("\tcharset=\"utf-8\"></script>\n");
      out.write("<script type=\"text/javascript\"\n");
      out.write("\tsrc=\"http://code.jquery.com/jquery-1.11.3.min.js\"></script>\n");
      out.write("<script src=\"https://apis.google.com/js/platform.js\" async defer></script>\n");
      out.write("<script type=\"text/javascript\" src=\"../resources/js/jquery-3.4.1.min.js\"></script>\n");
      out.write("<style type=\"text/css\">\n");
      out.write(".top {\n");
      out.write("\tbackground-color: #fa8;\n");
      out.write("\twidth: 100vw;\n");
      out.write("\theight: 100px;\n");
      out.write("\tcolor: white;\n");
      out.write("\tcursor: pointer;\n");
      out.write("\tborder: solid;\n");
      out.write("\tmargin-top: -12px;\n");
      out.write("\tmargin-left: -12px;\n");
      out.write("}\n");
      out.write("#top_title{\n");
      out.write("\twidth: 100%;\n");
      out.write("\tmargin: 10px auto;\n");
      out.write("\ttext-align: center;\n");
      out.write("}\n");
      out.write(".body {\n");
      out.write("\ttext-align: center;\n");
      out.write("}\n");
      out.write("#bar {\n");
      out.write("\tmargin-bottom: 10pt;\n");
      out.write("\twidth: 350pt;\n");
      out.write("\theight: 30pt;\n");
      out.write("}\n");
      out.write("#my-signin2 {\n");
      out.write("\tdisplay: inline-block;\n");
      out.write("}\n");
      out.write("/* footer */\n");
      out.write("#footer {\n");
      out.write("\twidth: 101%;\n");
      out.write("\tmargin: 100px auto 0px;\n");
      out.write("}\n");
      out.write("#first-footer {\n");
      out.write("\twidth: 1300px;\n");
      out.write("\tmargin: auto;\n");
      out.write("\tdisplay: grid;\n");
      out.write("\tgrid-template-columns: 400px 550px 350px;\n");
      out.write("}\n");
      out.write("#footer-company {\n");
      out.write("\tfont-size: 9pt;\n");
      out.write("\tcolor: #888;\n");
      out.write("\tline-height: 5pt;\n");
      out.write("}\n");
      out.write("#footer-link a:link, #footer-link a:visited {\n");
      out.write("\tcolor: #888;\n");
      out.write("}\n");
      out.write("#footer-sns img {\n");
      out.write("\tmargin-top: 50px;\n");
      out.write("\twidth: 70px;\n");
      out.write("\theight: 70px;\n");
      out.write("}\n");
      out.write("#report-content {\n");
      out.write("\tmargin-left: 50px;\n");
      out.write("}\n");
      out.write("#send-report {\n");
      out.write("\tdisplay: block;\n");
      out.write("\ttext-decoration: none;\n");
      out.write("\tfont-size: 9pt;\n");
      out.write("\tcolor: black;\n");
      out.write("\tmargin: auto;\n");
      out.write("\ttext-align: center;\n");
      out.write("}\n");
      out.write("#second-footer {\n");
      out.write("\tbackground: #fa8;\n");
      out.write("\twidth: 100vw;\n");
      out.write("\tmin-width: 1320px;\n");
      out.write("\tmargin: -8px;\n");
      out.write("\tmargin-top: 20px;\n");
      out.write("}\n");
      out.write("#second-footer-content {\n");
      out.write("\twidth: 1300px;\n");
      out.write("\tdisplay: grid;\n");
      out.write("\tgrid-template-columns: 250px 800px 250px;\n");
      out.write("\theight: 170px;\n");
      out.write("\tmargin: auto;\n");
      out.write("}\n");
      out.write("#footer-logo {\n");
      out.write("\tpadding: 40px;\n");
      out.write("}\n");
      out.write("#footer-counting {\n");
      out.write("\tdisplay: grid;\n");
      out.write("\tgrid-template-columns: auto auto auto;\n");
      out.write("\tgrid-template-rows: 100px 70px;\n");
      out.write("\ttext-align: center;\n");
      out.write("\tcolor: #e86;\n");
      out.write("\tfont-size: 35pt;\n");
      out.write("}\n");
      out.write("#footer-counting i {\n");
      out.write("\tmargin-top: 25px;\n");
      out.write("}\n");
      out.write("#footer-counting a:link, #footer-counting a:visited {\n");
      out.write("\tcolor: #e86;\n");
      out.write("}\n");
      out.write("#footer-mailto-round {\n");
      out.write("\tpadding: 40px;\n");
      out.write("}\n");
      out.write("#footer-mailto {\n");
      out.write("\tmargin: auto;\n");
      out.write("\theight: 80px;\n");
      out.write("\twidth: 80px;\n");
      out.write("\tborder-radius: 80px;\n");
      out.write("\tbackground: #fff;\n");
      out.write("\tcolor: #d75;\n");
      out.write("\tfont-size: 30pt;\n");
      out.write("\ttext-align: center;\n");
      out.write("}\n");
      out.write("#footer-mailto i {\n");
      out.write("\tmargin-top: 20px;\n");
      out.write("}\n");
      out.write(".footer-counting-label {\n");
      out.write("\tmargin-top: -10px;\n");
      out.write("\tfont-size: 9pt;\n");
      out.write("\tcolor: #eee;\n");
      out.write("}\n");
      out.write(".footer-counting-number {\n");
      out.write("\tmargin-top: -10px;\n");
      out.write("\tfont-size: 16pt;\n");
      out.write("\tcolor: #dd3;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body onload=\"renderButton()\">\n");
      out.write("\t<div class=\"top\">\n");
      out.write("\t\t<h1 id=\"top_title\">ICT 레시피</h1>\n");
      out.write("\t\t<h2 id=\"top_title\">ICT RECIPE</h2>\n");
      out.write("\t</div>\n");
      out.write("\t<script type=\"text/javascript\">\n");
      out.write("\t$(function(){\n");
      out.write("\t\t$(\".top\").on(\"click\", function(){\n");
      out.write("\t\t\tlocation.href=\"/\";\n");
      out.write("\t\t});\n");
      out.write("\t});\n");
      out.write("\tfunction goLogin(f){\n");
      out.write("\t\tf.action = \"goLogin\";\n");
      out.write("\t\tf.submit();\n");
      out.write("\t}\n");
      out.write("\tfunction onSuccess(googleUser) {\n");
      out.write("\tconsole.log('Logged in as: ' + googleUser.getBasicProfile().getName());\n");
      out.write("\t}\n");
      out.write("\tfunction onFailure(error) {\n");
      out.write("\t\tconsole.log(error);\n");
      out.write("\t}\n");
      out.write("\tfunction renderButton() {\n");
      out.write("\t\tgapi.signin2.render('my-signin2', {\n");
      out.write("\t\t\t'scope': 'profile email',\n");
      out.write("\t\t\t'width': 240,\n");
      out.write("\t\t\t'height': 50,\n");
      out.write("\t\t\t'longtitle': true,\n");
      out.write("\t\t\t'theme': 'light',\n");
      out.write("\t\t\t'onsuccess': onSuccess,\n");
      out.write("\t\t\t'onfailure': onFailure\n");
      out.write("\t\t});\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("</script>\n");
      out.write("\t<div class=\"body\">\n");
      out.write("\t\t<form method=\"post\">\n");
      out.write("\t\t\t<h2>로그인</h2>\n");
      out.write("\t\t\t<p id=\"inpo\">\n");
      out.write("\t\t\t\t<input type=\"text\" placeholder=\"아이디\" name=\"id\"\n");
      out.write("\t\t\t\t\tstyle=\"width: 460px; height: 30px;\">\n");
      out.write("\t\t\t</p>\n");
      out.write("\t\t\t<p id=\"inpo\">\n");
      out.write("\t\t\t\t<input type=\"password\" placeholder=\"패스워드\" name=\"pw\"\n");
      out.write("\t\t\t\t\tstyle=\"width: 460px; height: 30px;\">\n");
      out.write("\t\t\t</p>\n");
      out.write("\t\t\t<button id=bar\n");
      out.write("\t\t\t\tstyle=\"background-color: #997000; color: white; font-size: 15pt;\"\n");
      out.write("\t\t\t\tonclick=\"goLogin(this.form)\">로그인</button>\n");
      out.write("\t\t</form>\n");
      out.write("\t\t<br>\n");
      out.write("\t\t<p style=\"font-size: 10pt;\">\n");
      out.write("\t\t\t<a href=\"find\">비밀번호 찾기</a> | <a href=\"join\">회원가입</a>\n");
      out.write("\t\t</p>\n");
      out.write("\t\t<br>\n");
      out.write("\t\t<!-- Facebook -->\n");
      out.write("\t\t<!-- <button id=bar style=\"background-color: blue; color: white; font-size: 15pt;\"> Facebook 간편로그인 </button><br> -->\n");
      out.write("\t\t<div id=\"fb-root\"></div>\n");
      out.write("\t\t<script async defer crossorigin=\"anonymous\"\n");
      out.write("\t\t\tsrc=\"https://connect.facebook.net/ko_KR/sdk.js#xfbml=1&version=v3.3&appId=343449269655895&autoLogAppEvents=1\"></script>\n");
      out.write("\t\t<div class=\"fb-login-button\" data-width=\"\" data-size=\"large\"\n");
      out.write("\t\t\tdata-button-type=\"login_with\" data-auto-logout-link=\"false\"\n");
      out.write("\t\t\tdata-use-continue-as=\"false\"></div>\n");
      out.write("\t\t<script>\n");
      out.write("\t\t  window.fbAsyncInit = function() {\n");
      out.write("\t\t    FB.init({\n");
      out.write("\t\t      appId      : '343449269655895',\n");
      out.write("\t\t      cookie     : true,\n");
      out.write("\t\t      xfbml      : true,\n");
      out.write("\t\t      version    : 'v3.3'\n");
      out.write("\t\t    });\n");
      out.write("\t\t    FB.AppEvents.logPageView();   \n");
      out.write("\t\t  };\n");
      out.write("\t\t  (function(d, s, id){\n");
      out.write("\t\t     var js, fjs = d.getElementsByTagName(s)[0];\n");
      out.write("\t\t     if (d.getElementById(id)) {return;}\n");
      out.write("\t\t     js = d.createElement(s); js.id = id;\n");
      out.write("\t\t     js.src = \"https://connect.facebook.net/en_US/sdk.js\";\n");
      out.write("\t\t     fjs.parentNode.insertBefore(js, fjs);\n");
      out.write("\t\t   }(document, 'script', 'facebook-jssdk'));\n");
      out.write("\t\t</script>\n");
      out.write("\t\t<br>\n");
      out.write("\t\t<br>\n");
      out.write("\n");
      out.write("\t\t<!-- Kakao -->\n");
      out.write("\t\t<!-- <button id=bar style=\"background-color: yellow; color: black; font-size: 15pt;\"> 카카오 간편로그인 </button><br> -->\n");
      out.write("\t\t<a id=\"kakao-login-btn\"></a> <a\n");
      out.write("\t\t\thref=\"http://developers.kakao.com/logout\"></a>\n");
      out.write("\t\t<script type='text/javascript'>\n");
      out.write("      \t//<![CDATA[\n");
      out.write("        // 사용할 앱의 JavaScript 키를 설정해 주세요.\n");
      out.write("        Kakao.init('5e564d89ee303d1a1c3ae2451b04cd4e');\n");
      out.write("        // 카카오 로그인 버튼을 생성합니다.\n");
      out.write("        Kakao.Auth.createLoginButton({\n");
      out.write("        \tcontainer: '#kakao-login-btn',\n");
      out.write("        \tsuccess: function(authObj) {\n");
      out.write("            alert(Kakao.Auth.getAccessToken());\n");
      out.write("        \t},\n");
      out.write("          \tfail: function(err) {\n");
      out.write("          \t\talert(JSON.stringify(err));\n");
      out.write("          \t}\n");
      out.write("       \t});\n");
      out.write("      \t//]]>\n");
      out.write("    \t</script>\n");
      out.write("\t\t<br>\n");
      out.write("\t\t<br>\n");
      out.write("\n");
      out.write("\t\t<!-- naver -->\n");
      out.write("\t\t<!-- <button id=bar style=\"background-color: #1DDB16; color: white; font-size: 15pt;\"> 네이버 간편로그인 </button><br> -->\n");
      out.write("\t\t<!-- 네이버아이디로로그인 버튼 노출 영역 -->\n");
      out.write("\t\t<div id=\"naver_id_login\"></div>\n");
      out.write("\t\t<!-- //네이버아이디로로그인 버튼 노출 영역 -->\n");
      out.write("\t\t<script type=\"text/javascript\">\n");
      out.write("\t\t  \tvar naver_id_login = new naver_id_login(\"JKVUnk675bZWjaeT7mei\", \"4oNoukX_cr\");\n");
      out.write("\t\t  \tvar state = naver_id_login.getUniqState();\n");
      out.write("\t\t  \tnaver_id_login.setButton(\"green\", 8,48);\n");
      out.write("\t\t  \tnaver_id_login.setDomain(\"http://localhost/login\");\n");
      out.write("\t\t  \tnaver_id_login.setState(state);\n");
      out.write("\t\t  \tnaver_id_login.setPopup();\n");
      out.write("\t\t  \tnaver_id_login.init_naver_id_login();\n");
      out.write("\t\t  </script>\n");
      out.write("\t\t<br>\n");
      out.write("\n");
      out.write("\t\t<!-- google -->\n");
      out.write("\t\t<!-- <button id=bar style=\"background-color: red; color: white; font-size: 15pt;\"> 구글 간편로그인 </button> -->\n");
      out.write("\t\t<!-- <div class=\"g-signin2\" data-onsuccess=\"onSignIn\"></div> -->\n");
      out.write("\t\t<div id=\"my-signin2\"></div>\n");
      out.write("\t\t<script type=\"text/javascript\">\n");
      out.write("\t\tfunction onSignIn(googleUser) {\n");
      out.write("\t\t  var profile = googleUser.getBasicProfile();\n");
      out.write("\t\t  console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.\n");
      out.write("\t\t  console.log('Name: ' + profile.getName());\n");
      out.write("\t\t  console.log('Image URL: ' + profile.getImageUrl());\n");
      out.write("\t\t  console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.\n");
      out.write("\t\t}\n");
      out.write("\t\t</script>\n");
      out.write("\t</div>\n");
      out.write("\t\n");
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
