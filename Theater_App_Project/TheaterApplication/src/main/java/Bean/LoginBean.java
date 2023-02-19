package Bean;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import Entity.CustomerAccount;
import Service.CustomerAccountService;


@ManagedBean
@SessionScoped
public class LoginBean {

    private String username;
    private String password;

    
    private CustomerAccountService customerAccountService = new CustomerAccountService();

    public String login() {
    	
        CustomerAccount customerAccount = customerAccountService.getCustomerAccountByUsername(username);
        if (customerAccount != null && customerAccount.getPassword() != null && customerAccount.getPassword().equals(password)) {
            // Store the customer account in the session
        	setPassword(customerAccount.getUsername());
        	setUsername(customerAccount.getPassword());
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("customerAccount", customerAccount);
            return "welcome";
        } else {
            // Display an error message
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Invalid username or password"));
            return null;
        }
    }

    
    
    
    public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String logout() throws IOException {
        // Remove the customer account from the session and redirect to the home page
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext.getCurrentInstance().getExternalContext().redirect("home.xhtml");
        return null;
    }

}
