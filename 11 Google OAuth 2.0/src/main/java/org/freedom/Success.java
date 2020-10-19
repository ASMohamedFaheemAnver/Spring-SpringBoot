package org.freedom;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.freedom.model.GoogleToken;
import org.freedom.model.RequestTokenParams;
import org.freedom.model.User;

/**
 * Servlet implementation class Success
 */
public class Success extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Client client = ClientBuilder.newClient();
	WebTarget googleTokenServer = client.target("https://www.googleapis.com/oauth2/v4/token");
	WebTarget googleTokenAPI = client.target("https://www.googleapis.com/auth/userinfo");

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Success() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String code = request.getParameter("code");
		String client_id = "158385337925-ept9u494fub019t9beutqhmdianq64la.apps.googleusercontent.com";
		String client_secret = "";
		String redirect_uri = "http://localhost:8080/google-oauth/success";
		String grant_type = "authorization_code";

		RequestTokenParams requestTokenParams = new RequestTokenParams(code, client_id, client_secret, redirect_uri,
				grant_type);
		Response token = googleTokenServer.request().post(Entity.json(requestTokenParams));
		GoogleToken googleToken = token.readEntity(GoogleToken.class);
		System.out.println(googleToken.toString());

		WebTarget googleUserInfoAPI = client.target(
				"https://www.googleapis.com/oauth2/v1/userinfo?alt=json&access_token=" + googleToken.getAccess_token());
		Response userInfo = googleUserInfoAPI.request().get();
		User user = userInfo.readEntity(User.class);
		System.out.println(user.toString());
//		request.setAttribute("user", user);
		request.setAttribute("image", user.getPicture());
		request.setAttribute("email", user.getEmail());
		request.getRequestDispatcher("display-user.jsp").forward(request, response);
	}

}
