package Bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import Entity.CustomerAccount;


@ManagedBean
@ViewScoped
public class ReserveBean {
	
	
	
	
	public String reserveSeats() {
		String view = "";
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		HttpSession session = request.getSession();
		CustomerAccount customerAccount = null;
		if(session.getAttribute("customerAccount") != null) {
			view = "welcome";
				
		}else {
			view = "login";
		}
		
		return view;
	}

}
