import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// Extend HttpServlet class to create Http Servlet
public class MyServletDemo extends HttpServlet {

   private int f;
   private String msg;

   public void init() throws ServletException {
      
      
   }

   public void doGet(HttpServletRequest request, 
      HttpServletResponse response)
      throws ServletException, IOException 
   {

      // Setting up the content type of webpage
      response.setContentType("text/html");
      
      int d,m,y;
      f=0;
      msg="valid";
      d=Integer.parseInt(request.getParameter("dd"));
      m=Integer.parseInt(request.getParameter("mm"));
      y=Integer.parseInt(request.getParameter("yy"));
      if(m>12 || m<1) {
    	  f=1;
      }
      if(y<0) {
    	  f=1;
      }
      if(m==1 || m==3 || m==5 || m==7 || m==8 || m==10 || m==12) {
    	  if(d>31 || d<1) {
    		  f=1;
    	  }
      }
      if(m==4 || m==6 || m==9 || m==11) {
    	  if(d>30 || d<1) {
    		  f=1;
    	  }
      }
      if(m==2) {
    	  if(y%4==0 && (d>29 || d<1)) {
    		  f=1;
    	  }
    	  else if(y%4!=0 &&(d>28 || d<1)) {
    		  f=1;
    	  }
      }
      if(f==1) {
    	  msg="invalid";
      }
      
      // Writing message to the web page
      PrintWriter out = response.getWriter();
      out.println("<html>\r\n" + 
      		"   <body>\r\n" + 
      		"      <form action = \"HelloForm\" method = \"GET\">\r\n" + 
      		"         DD: <input type = \"number\" name = \"dd\">\r\n" + 
      		"         <br />\r\n" + 
      		"         MM: <input type = \"number\" name = \"mm\">\r\n" + 
      		"         <br />\r\n" + 
      		"         YYYY: <input type = \"number\" name = \"yy\" />\r\n" + 
      		"         <input type = \"submit\" value = \"Submit\" />\r\n" + 
      		"      </form>\r\n" +
      		"      <p>"+msg+"</p>\r\n" +
      		"   </body>\r\n" + 
      		"</html>");
   }

   public void destroy() {
      /* leaving empty for now this can be
       * used when we want to do something at the end
       * of Servlet life cycle
       */
   }
}