package Bean;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import Entity.CustomerAccount;
import Service.CustomerAccountService;

@ManagedBean
@SessionScoped
public class RegisterBean {

    private String username;
    private String password;
    private String fullName;
    private String dateOfBirth;
    private String gender;
    private String email;

    
    private CustomerAccountService customerAccountService = new CustomerAccountService();
    

    public String register() {
        // Check if the username
        CustomerAccount existingCustomerAccount = customerAccountService.getCustomerAccountByUsername(username);
        if (existingCustomerAccount != null) {
            // Display an error message
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Username already taken"));
            return null;
        } else {
        	Date date = new Date();
            // Create a new customer account with the provided information
            CustomerAccount newCustomerAccount = new CustomerAccount(username, password, fullName, date, gender, email);
            // Call the service method to save the new customer account
            customerAccountService.saveCustomerAccount(newCustomerAccount);
            // Store the customer account in the session
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("customerAccount", newCustomerAccount);
            return "home";
        }
    }
    // Getters and setters...


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


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
}