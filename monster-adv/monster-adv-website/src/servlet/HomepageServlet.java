package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import signage.*;
import signage.action.*;
import user.*;
import user.action.*;
import advResult.AdvResult;
import advResult.AdvResulttDependencyInjector;
import advResult.action.AdvResultSearchAction;
import advertisement.Advertisement;
import advertisement.AdvertisementDependencyInjector;
import advertisement.action.AdvertisementAddAction;
import advertisement.action.AdvertisementSearchAction;

import com.google.gson.*;

/**
 * Servlet implementation class HomepageServlet
 */
@WebServlet({ "/", "/main" })
public class HomepageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserDependencyInjector userDependencyInjector;
	private DigitalSignageDependencyInjector digitalSignageDependencyInjector;
	private AdvertisementDependencyInjector advertisementDependencyInjector;
	private AdvResulttDependencyInjector advResulttDependencyInjector;
	public HomepageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	public void init(ServletConfig config) throws ServletException {
		userDependencyInjector = new UserDependencyInjector();
		userDependencyInjector.start();
		digitalSignageDependencyInjector = new DigitalSignageDependencyInjector();
		digitalSignageDependencyInjector.start();
		advertisementDependencyInjector = new AdvertisementDependencyInjector();
		advertisementDependencyInjector.start();
		advResulttDependencyInjector = new AdvResulttDependencyInjector();
		advResulttDependencyInjector.start();
		
	}

	/**
	 * @see servlet#destroy()
	 */
	public void destroy() {
		userDependencyInjector.shutDown();
		digitalSignageDependencyInjector.shutDown();
		advertisementDependencyInjector.shutDown();
		advResulttDependencyInjector.shutDown();
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request,response);
	}
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex + 1);
		String dispatchUrl = "main.jsp";
		/*�� ���� �� Ȯ���ؼ� �ϳ� ���� ��, Ȩ������ ���� ��*/
		if(action==null||action.equals("")){
			dispatchUrl="main.jsp";
		}
		else if(action.equals("main")){
			dispatchUrl="main.jsp";
		}
		else if(action.equals("login")){
			dispatchUrl="login.jsp";
		}		
		/*����Ʈ ������ �������� ��*/
		else if(action.equals("weare")){
			dispatchUrl="weAre.jsp";
		}
		else if(action.equals("weare")){
			dispatchUrl="weAre.jsp";
		}
		else if(action.equals("regist")){
			dispatchUrl="registadv.jsp";
		}		
		else if(action.equals("registAccount")){
			dispatchUrl="newAccount.jsp";
		}				

		else if(action.equals("registAccount")){
			dispatchUrl="newAccount.jsp";
		}
		else if(action.equals("logout")){
			dispatchUrl="main.jsp";
			HttpSession session = request.getSession();
			session.setAttribute("logininfo",null);
		}
		
		else if(action.equals("loginResult")){
			dispatchUrl="result.jsp";
			
			String id = request.getParameter("input_id");
			String password = request.getParameter("input_pass");
			UserLoginAction loginAction = (UserLoginAction)userDependencyInjector.getObject(UserLoginAction.class);
			
			
			LoginInfo result = loginAction.login(id, password);
			if(result==null)
			{
			request.setAttribute("message","infoincorrect");
			}
			else
			{
			HttpSession session = request.getSession();
			session.setAttribute("logininfo",result);
			request.setAttribute("message","infocorrect");
			}
		}		
		else if(action.equals("infoSubmit")){
			dispatchUrl="result.jsp";			
			request.getParameterNames();
			String id = request.getParameter("userId");
			String upassword = request.getParameter("uPassword");
			String rpassword = request.getParameter("rPassword");	
			String name = request.getParameter("uName");
			String email = request.getParameter("email");	
			User user = new User(id,rpassword,name,email);
			request.setAttribute("userinfo",user);

			UserValidIdAction validIdAction = (UserValidIdAction)userDependencyInjector.getObject(UserValidIdAction.class);
			UserValidEmailAction validEmailAction = (UserValidEmailAction)userDependencyInjector.getObject(UserValidEmailAction.class);
			
			if(!upassword.equals(rpassword))
			{
				request.setAttribute("message","passwordincorrect");
			}
			else if(validIdAction.isValidId(id)==false)
			{
				request.setAttribute("message","idexist");
			}
			else if(validEmailAction.isValidEmail(email)==false)
			{
				request.setAttribute("message","emailexist");
			};
			
			if(request.getAttribute("message") == null)
			{
				UserRegistAction registAction=(UserRegistAction)userDependencyInjector.getObject(UserRegistAction.class);
				registAction.regist(user);
				request.setAttribute("message","regist");
			}
		}
		/**/
		else if(action.equals("newADV"))
		{
			dispatchUrl = "newADV.jsp";
			String signageID=request.getParameter("signageid");
			String signageName = request.getParameter("signageName");
			request.setAttribute("signageID",signageID);
			request.setAttribute("signageName",signageName);
		}
		else if(action.equals("newADVResult"))
		{
			AdvertisementAddAction addAction = (AdvertisementAddAction) advertisementDependencyInjector.getObject(AdvertisementAddAction.class);
			
			request.setCharacterEncoding("UTF-8");
			dispatchUrl = "result.jsp";
			
			String name = request.getParameter("advName");
			String userId = request.getParameter("requestID");
			String signageId = request.getParameter("signageID");
			String advKind = request.getParameter("advKind");
			String peopleKind = request.getParameter("peopleKind");
			int num = Integer.parseInt(request.getParameter("peopleNum"));
			/*���ε带 ����ġ�� ��� ��� ���� ����*/
			String locate = request.getParameter("filelocate");
			int time=10;	//�ӽ�
			
			Advertisement adv = new Advertisement(name,null,userId,signageId,peopleKind,advKind,time,num,locate);
			boolean result = addAction.insert(adv);
			
			if(result==true)
			{
				request.setAttribute("message","advRegistSucess");				
			}
			else
			{
				request.setAttribute("message","advRegistFail");								
			}
		}
		else if(action.equals("status")||action.equals("report"))
		{
			
			LoginInfo info = (LoginInfo) request.getSession().getAttribute("logininfo");
			if(info==null)
			{
				request.setAttribute("message","needlogin");
				dispatchUrl="result.jsp";
			}
			else
			{
				if(action.equals("status"))
				dispatchUrl = "status.jsp";
				else
				dispatchUrl = "report.jsp";					

				AdvertisementSearchAction searchAction = (AdvertisementSearchAction)advertisementDependencyInjector.getObject(AdvertisementSearchAction.class);
				Collection<Advertisement> result =searchAction.search(info.getUserId());
				response.setContentType("text/html; charset=utf-8");
				request.setAttribute("list",result);
			}
		}		
		else if(action.equals("mapping"))
		{
			request.setCharacterEncoding("UTF-8");
			DigitalSignageSearchAction searchAction = (DigitalSignageSearchAction) digitalSignageDependencyInjector.getObject(DigitalSignageSearchAction.class);			
			String stringX1 = request.getParameter("x1");
			String stringY1 = request.getParameter("y1");
			String stringX2 = request.getParameter("x2");
			String stringY2 = request.getParameter("y2");
			
			Collection<DigitalSignage> results = searchAction.search(Double.parseDouble(stringX1),Double.parseDouble(stringY1), Double.parseDouble(stringX2), Double.parseDouble(stringY2));
			

			 response.setContentType("text/html; charset=utf-8");
			
			 PrintWriter out = response.getWriter();
			 Gson gson = new Gson();
			 JsonObject myObj= new JsonObject();
			 JsonElement signageObj = gson.toJsonTree(results);	 
			 myObj.add("signageList", signageObj);
			 out.println(myObj.toString());
			return;		
		}
		else if(action.equals("mappingreport"))
		{
			dispatchUrl = "reportChart.jsp";

			request.setCharacterEncoding("UTF-8");		
						
			String adv = request.getParameter("adv");
			
			int temp = adv.indexOf("!")+1;
			
			String advName = adv.substring(temp);
			adv = adv.substring(0,temp-1);
			

			String year =request.getParameter("year");
			String month = request.getParameter("month");
			String day = request.getParameter("day");
			String kind = request.getParameter("selectKind");
			
			StringBuilder builder = new StringBuilder();
			builder.append(year);
			builder.append("-");
			
			
			if(month.length()==1)
				builder.append("0");
			builder.append(month);

			String dateString = year+","+month+",";
			
			if(kind.equals("month"))
			{
				dateString +="1";
			}
			else if(kind.equals("day"))
			{
				builder.append("-");			
				if(month.length()==1)
					builder.append("0");
				builder.append(day);
				dateString+=day;
			}

			AdvResultSearchAction searchAction = (AdvResultSearchAction) advResulttDependencyInjector.getObject(AdvResultSearchAction.class);
			Collection<AdvResult> results = searchAction.search(adv, builder.toString());

			String menString = "",womenString = "";
			
			Iterator<AdvResult> iterator = results.iterator();

			AdvResult tResult = iterator.next();
			menString+= String.valueOf(tResult.getMenNum());
			womenString+= String.valueOf(tResult.getWomenNum());
			
			while(iterator.hasNext())
			{
				tResult = iterator.next();
				menString+= ","+String.valueOf(tResult.getMenNum());
				womenString+= ","+String.valueOf(tResult.getWomenNum());
			}

			
			request.getSession().setAttribute("result",results);
			request.getSession().setAttribute("name", advName);
			request.getSession().setAttribute("date",dateString);
			request.getSession().setAttribute("menString",menString);
			request.getSession().setAttribute("womenString",womenString);
		}
				
		
		
		RequestDispatcher view = request.getRequestDispatcher(dispatchUrl);
		view.forward(request, response);

		
	}
}
